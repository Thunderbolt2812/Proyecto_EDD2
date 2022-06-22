package proyectoedd2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    private Workbook workbook;

    public void LlavesOrdenadas(int IndiceNodoActual, ArrayList<Long> lista, BTree arbol_actual) {
        if (IndiceNodoActual >= 0) {
            Node node = arbol_actual.getNodos().get(IndiceNodoActual);
            for (int i = 0; i < node.getN(); i++) {
                LlavesOrdenadas(node.getHijos().get(i), lista, arbol_actual);
                lista.add(node.getLlaves().get(i).getPos());
            }
            LlavesOrdenadas(node.getHijos().get(node.getN()), lista, arbol_actual);
        }
    }

    public String Llenar(Archivo archivo_actual, File archivo_excel, ArrayList<Long> lista) throws IOException {
        String respuesta = "El archivo no se exporto.";
        if (archivo_excel.getName().endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }
        String nombre = archivo_actual.getArchivo().getName();
        Sheet hoja = workbook.createSheet(nombre.substring(0, nombre.length() - 4));
        for (int i = -1; i < lista.size(); i++) {
            Row fila = hoja.createRow(i + 1);
            if (i == -1) {
                for (int j = 0; j < archivo_actual.getCampos().size(); j++) {
                    Cell celda = fila.createCell(j);
                    celda.setCellValue(archivo_actual.getCampos().get(j).getNombre());
                }
            } else {
                long RRN = lista.get(i);
                String line = leerRegistro(Math.toIntExact(RRN), archivo_actual);
                String arreglo[] = line.split("\\|");
                for (int j = 0; j < archivo_actual.getCampos().size(); j++) {
                    Cell celda = fila.createCell(j);
                    String insertar = arreglo[j];
                    celda.setCellValue(insertar);
                }
            }
            workbook.write(new FileOutputStream(archivo_excel));
            respuesta = "Archivo Exportado";
        }
        return respuesta;
    }

    private String leerRegistro(int RRN, Archivo archivo_actual) {
        String linea = "";
        File archivo = new File(archivo_actual.getArchivo().getAbsolutePath());
        try {
            RandomAccessFile af = new RandomAccessFile(archivo, "rw");
            af.seek(RRN);
            for (int i = 0; i < archivo_actual.LongitudFijaCampos(); i++) {
                linea += af.readChar();
            }
        } catch (IOException e) {
        }
        return linea;
    }
}
