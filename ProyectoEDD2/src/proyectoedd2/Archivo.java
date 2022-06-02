package proyectoedd2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Archivo {

    protected int primaryKey;
    protected ArrayList<Integer> secundaryKey;
    protected int registros;
    protected int headAvail;
    protected ArrayList<Campo> campos;
    protected LinkedList<Integer> AvailList;
    protected File baseFile;

    public Archivo() {
    }

    public Archivo(File archivo, File archivoArbol) {
        try (RandomAccessFile random = new RandomAccessFile(archivo, "r")) {

            baseFile = archivo;

            this.headAvail = random.readInt();
            this.registros = random.readInt();
            try {
                this.primaryKey = random.readInt();
            } catch (Exception e) {
                this.primaryKey = -1;
            }
            try {
                this.secundaryKey = new ArrayList<>();
                int auxSecundarias = random.readInt();
                for (int i = 0; i < auxSecundarias; i++) {
                    try {
                        this.secundaryKey.add(random.readInt());
                    } catch (NumberFormatException e) {
                    }
                }
            } catch (Exception e) {
            }
            try {
                this.campos = new ArrayList<>();
                int cantidadCampos = random.readInt();//4
                for (int i = 0; i < cantidadCampos; i++) {
                    String aux = random.readUTF();
                    if (aux.endsWith("_int")) {
                        this.campos.add(new CampoEntero(aux));
                    } else if (aux.endsWith("_dec")) {
                        this.campos.add(new CampoDecimal(aux));
                    } else if (aux.endsWith("_str")) {
                        CampoTexto campoNuevo = new CampoTexto(aux);
                        campoNuevo.setLongitud(random.readInt());
                        this.campos.add(campoNuevo);
                    } else if (aux.endsWith("_car")) {
                        this.campos.add(new CampoCaracter(aux));
                    }
                }
            } catch (Exception e) {
            }
            FileInputStream indices = new FileInputStream(archivoArbol);
            ObjectInputStream os = new ObjectInputStream(indices);

            reconstruirAvailList(archivo);

        } catch (IOException e) {
        }

    }

    public Archivo(int primaryKey, int registros, int headAvail, ArrayList<Campo> campos) {
        this.primaryKey = -1;
        this.registros = registros;
        this.headAvail = headAvail;
        this.campos = campos;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int llavePrincipal) {
        this.primaryKey = llavePrincipal;
    }

    public int getRegistros() {
        return registros;
    }

    public void setRegistros(int noRegistros) {
        this.registros = noRegistros;
    }

    private int getCabezaAvail() {
        return headAvail;
    }

    public void setCabezaAvail(int cabezaAvail) {
        this.headAvail = cabezaAvail;
    }

    public LinkedList<Integer> getAvailList() {
        return AvailList;
    }

    public void setAvailList(LinkedList<Integer> AvailList) {
        this.AvailList = AvailList;
    }

    public ArrayList<Campo> getCamposDelArchivo() {
        return campos;
    }

    public void setCamposDelArchivo(ArrayList<Campo> camposDelArchivo) {
        this.campos = camposDelArchivo;
    }

    public ArrayList<Integer> getSecundarias() {
        return secundaryKey;
    }

    public void setSecundarias(ArrayList<Integer> secundarias) {
        this.secundaryKey = secundarias;
    }

    public File getBaseFile() {
        return baseFile;
    }

    public int tamanioMetadata() {
        int total = 43 + (4 * secundaryKey.size()) + (31 * campos.size());

        for (int i = 0; i < campos.size(); i++) {
            if (campos.get(i) instanceof CampoTexto) {
                total += 4;
            }
        }

        return total;
    }

    public int longitudRegistro() {
        int ret = 0;

        for (int i = 0; i < this.campos.size(); i++) {
            Campo c = campos.get(i);
            if (c instanceof CampoEntero) {
                ret += 4;
            } else if (c instanceof CampoDecimal) {
                ret += 8;
            } else if (c instanceof CampoCaracter) {
                ret += 2;
            } else {
                ret += 2 + ((CampoTexto) c).getLongitud();
            }
        }

        return ret + 4; //Sumamos 2 por la escritura del newline con el writeChars() method
    }

    public File updateTree(File fileIndices) {

        try (FileOutputStream fs = new FileOutputStream(fileIndices, false); ObjectOutputStream os = new ObjectOutputStream(fs)) {

            os.flush();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return fileIndices;
    }

    private void reconstruirAvailList(File file) {

        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            int pos = this.headAvail;
            this.AvailList = new LinkedList<>();

            while (pos != -1) {

                raf.seek(pos);

                raf.readChar();
                pos = raf.readInt();
            }

        } catch (Exception e) {
        }

    }

    public void updateSecondaryKeys(int removed) {
        for (int i = 0; i < secundaryKey.size(); i++) {
            int val = secundaryKey.get(i);

            if (val > removed) {
                secundaryKey.set(i, val - 1);
            } else if (val == removed) {
                Integer old = secundaryKey.remove(i--);
            }
        }
    }

    public int offsetToKey(int key) {
        if (key < 0 || key >= campos.size()) {
            return -1;
        }

        int ret = 2;

        for (int i = 0; i < key; i++) {
            Campo c = campos.get(i);

            if (c instanceof CampoEntero) {
                ret += 4;
            } else if (c instanceof CampoDecimal) {
                ret += 8;
            } else if (c instanceof CampoCaracter) {
                ret += 2;
            } else {
                ret += ((CampoTexto) c).getLongitud() + 2;
            }
        }

        return ret;
    }
}
