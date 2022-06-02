package proyectoedd2;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import java.io.*;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.io.RandomAccessFile;

public class Main extends javax.swing.JFrame {

    boolean validar = false;
    int contador = 0, cantidad = 0;
    boolean openfile = false;

    public void Salvar_Archivo() {

        JOptionPane.showMessageDialog(null, "Su archivo se ha guardado exitosamente");
    }

    public void Cargar_Archivo() {
        FileSuccess = 0;
        String direction;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./"));
        FileNameExtensionFilter data = new FileNameExtensionFilter("DAT FILE", "dat");
        fileChooser.setFileFilter(data);
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) { //Cuando le da guardar
            File Archivo;
            try {
                if (fileChooser.getFileFilter().getDescription().equals("DAT FILE")) { //Chequea si lo que quiere guardar es DAT FILE
                    direction = fileChooser.getSelectedFile().getPath() + ".dat";
                    Archivo = fileChooser.getSelectedFile();
                    this.file = Archivo;
                    JOptionPane.showMessageDialog(null, "El archivo se abrió con éxito");
                    FileSuccess = 1;
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo abrir, asegurese que su archivo sea un archivo DAT.");
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Hubo un problema.");
            }
            try {

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Hubo un error al cerrar el archivo.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Operacion cancelada.");
        }

    }

    private void Nuevo_Archivo() {

        Crear_Archivo();
        if (FileSuccess == 1) {
            openfile = true;
        }

    }

    private void Crear_Archivo() {

        FileSuccess = 0;
        String direction;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./"));
        FileNameExtensionFilter data = new FileNameExtensionFilter("DAT FILE", "dat");
        fileChooser.setFileFilter(data);
        int seleccion = fileChooser.showSaveDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File archivo = null;
            FileOutputStream fos = null;
            ObjectOutputStream ous = null;

            try {
                if (fileChooser.getFileFilter().getDescription().equals("DAT FILE")) {
                    direction = fileChooser.getSelectedFile().getPath() + ".dat";
                    direction = direction.replace(".dat", "");
                    direction += ".dat";

                    archivo = new File(direction);
                    if (archivo.length() == 0) {
                        this.file = new File(direction);
                        JOptionPane.showMessageDialog(this, "Enhorabuena!\n Cualquier cambio sin salvar no se puede recuperar");
                        jmi_Campos.setEnabled(true);
                        jm_Registros.setEnabled(true);
                        jm_indices.setEnabled(true);
                        jm_Estandarizacion.setEnabled(true);
                        jmi_Salvar_Archivo.setEnabled(true);
                        jmi_Cerrar_Archivo.setEnabled(true);
                    } else if (archivo.exists()) {
                        archivo.delete();
                        archivo.createNewFile();
                        this.file = new File(direction);
                        JOptionPane.showMessageDialog(this, "File OverWritten, New Length: " + archivo.length());
                    }
                    FileSuccess = 1;
                } else {
                    JOptionPane.showMessageDialog(this, "No se puede salvar. Use DAT FILE.");
                }
                fos = new FileOutputStream(archivo);
                ous = new ObjectOutputStream(fos);
                ous.flush();
            } catch (HeadlessException | IOException e) {
                JOptionPane.showMessageDialog(this, "Error desconocido");
            }
            try {
                ous.close();
                fos.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Cerrando Archivos.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Operacion cancelada!");
        }
    }

    public void Cargar_Archivo_2() {
        FileSuccess2 = 0;
        String direction;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./"));
        FileNameExtensionFilter data = new FileNameExtensionFilter("DAT FILE", "dat");
        fileChooser.setFileFilter(data);
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File Archivo;

            try {
                if (fileChooser.getFileFilter().getDescription().equals("DAT FILE")) {
                    direction = fileChooser.getSelectedFile().getPath() + ".dat";
                    Archivo = fileChooser.getSelectedFile();
                    this.file2 = Archivo;
                    JOptionPane.showMessageDialog(null, "Sucess!");
                    FileSuccess2 = 1;
                } else {
                    JOptionPane.showMessageDialog(this, "El archivo no se cargo, asegurese que su archivo es de tipo DAT.");
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Hubo un error!");
            }
            try {
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar archivo.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Operacion cancelada!");
        }

    }

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        Table.setForeground(Color.BLACK);
        Table.setBackground(Color.WHITE);
        Table.setFont(new Font("", 1, 22));
        Table.setRowHeight(30);
        Table.putClientProperty("terminateEditOnFocusLost", true);
        cleanTable = Table.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_Crearcampo = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tf_NombreCampo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        js_tamanioCadena = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        rb_LlaveSecundaria = new javax.swing.JRadioButton();
        rb_LlavePrincipal = new javax.swing.JRadioButton();
        rb_campoNormal = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        tipoEntero = new javax.swing.JRadioButton();
        tipoString = new javax.swing.JRadioButton();
        tipoChar = new javax.swing.JRadioButton();
        tipoDecimal = new javax.swing.JRadioButton();
        JD_ModificarCampos = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jtf_actualCampo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jtf_nuevoCampo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        JL_13 = new javax.swing.JLabel();
        JD_EliminarCampos = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_campos = new javax.swing.JList<>();
        TipoDato = new javax.swing.ButtonGroup();
        TipoLlave = new javax.swing.ButtonGroup();
        JD_Listar_Campos = new javax.swing.JDialog();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        Listar_Campos1 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jmb_Principal = new javax.swing.JMenuBar();
        jm_Archivo = new javax.swing.JMenu();
        jmi_Nuevo_Archivo = new javax.swing.JMenuItem();
        jmi_Cargar_Archivo = new javax.swing.JMenuItem();
        jmi_Salvar_Archivo = new javax.swing.JMenuItem();
        jmi_Cerrar_Archivo = new javax.swing.JMenuItem();
        jmi_Salir = new javax.swing.JMenuItem();
        jmi_Campos = new javax.swing.JMenu();
        jmi_Crear_Campo = new javax.swing.JMenuItem();
        jmi_Borrar_Campo = new javax.swing.JMenuItem();
        jmi_Listar_Campos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jm_Registros = new javax.swing.JMenu();
        jmi_Crear_Registro = new javax.swing.JMenuItem();
        jmi_Borrar_Registro = new javax.swing.JMenuItem();
        jmi_Buscar_Registro = new javax.swing.JMenuItem();
        jmi_modreg = new javax.swing.JMenuItem();
        jm_indices = new javax.swing.JMenu();
        jmi_crearindices = new javax.swing.JMenuItem();
        jmi_reindexar = new javax.swing.JMenuItem();
        jm_Estandarizacion = new javax.swing.JMenu();
        jmi_Exportar_Excel = new javax.swing.JMenuItem();
        jmi_Exportrar_XML = new javax.swing.JMenuItem();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel17.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nuevo Campo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Nombre del campo:");

        tf_NombreCampo.setBorder(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Longitud de cadena:");

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setForeground(new java.awt.Color(0, 153, 153));

        jButton7.setText("Regresar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Aceptar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de llave", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        rb_LlaveSecundaria.setBackground(new java.awt.Color(255, 255, 255));
        TipoLlave.add(rb_LlaveSecundaria);
        rb_LlaveSecundaria.setText("LLave secundaria");

        rb_LlavePrincipal.setBackground(new java.awt.Color(255, 255, 255));
        TipoLlave.add(rb_LlavePrincipal);
        rb_LlavePrincipal.setText("LLave primaria");

        rb_campoNormal.setBackground(new java.awt.Color(255, 255, 255));
        TipoLlave.add(rb_campoNormal);
        rb_campoNormal.setText("Campo normal");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(rb_LlavePrincipal)
                .addGap(26, 26, 26)
                .addComponent(rb_LlaveSecundaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(rb_campoNormal)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_LlavePrincipal)
                    .addComponent(rb_LlaveSecundaria)
                    .addComponent(rb_campoNormal))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de dato"));

        tipoEntero.setBackground(new java.awt.Color(255, 255, 255));
        TipoDato.add(tipoEntero);
        tipoEntero.setText("Entero");

        tipoString.setBackground(new java.awt.Color(255, 255, 255));
        TipoDato.add(tipoString);
        tipoString.setText("Texto");
        tipoString.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tipoStringStateChanged(evt);
            }
        });
        tipoString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoStringActionPerformed(evt);
            }
        });

        tipoChar.setBackground(new java.awt.Color(255, 255, 255));
        TipoDato.add(tipoChar);
        tipoChar.setText("Caracter");

        tipoDecimal.setBackground(new java.awt.Color(255, 255, 255));
        TipoDato.add(tipoDecimal);
        tipoDecimal.setText("Decimal");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tipoEntero)
                .addGap(18, 18, 18)
                .addComponent(tipoString)
                .addGap(18, 18, 18)
                .addComponent(tipoChar)
                .addGap(18, 18, 18)
                .addComponent(tipoDecimal)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoEntero)
                    .addComponent(tipoString)
                    .addComponent(tipoChar)
                    .addComponent(tipoDecimal))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(js_tamanioCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_NombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tf_NombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(js_tamanioCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout JD_CrearcampoLayout = new javax.swing.GroupLayout(JD_Crearcampo.getContentPane());
        JD_Crearcampo.getContentPane().setLayout(JD_CrearcampoLayout);
        JD_CrearcampoLayout.setHorizontalGroup(
            JD_CrearcampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_CrearcampoLayout.setVerticalGroup(
            JD_CrearcampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));

        jLabel22.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Modificar Campo");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel22)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Buscar campo:");

        jtf_actualCampo.setEditable(false);
        jtf_actualCampo.setBackground(new java.awt.Color(255, 255, 255));
        jtf_actualCampo.setBorder(null);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Nuevo nombre:");

        jtf_nuevoCampo.setBorder(null);

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));

        jButton9.setText("Regresar ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Aceptar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap())
        );

        JL_13.setForeground(new java.awt.Color(102, 102, 102));
        JL_13.setText("Seleccione el campo que le gustaría modificar:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_13, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(jtf_actualCampo)
                    .addComponent(jtf_nuevoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(JL_13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jtf_actualCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jtf_nuevoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_ModificarCamposLayout = new javax.swing.GroupLayout(JD_ModificarCampos.getContentPane());
        JD_ModificarCampos.getContentPane().setLayout(JD_ModificarCamposLayout);
        JD_ModificarCamposLayout.setHorizontalGroup(
            JD_ModificarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_ModificarCamposLayout.setVerticalGroup(
            JD_ModificarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));

        jLabel25.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Eliminar Campo");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel25)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));

        jButton11.setText("Regresar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Aceptar");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jList_campos);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout JD_EliminarCamposLayout = new javax.swing.GroupLayout(JD_EliminarCampos.getContentPane());
        JD_EliminarCampos.getContentPane().setLayout(JD_EliminarCamposLayout);
        JD_EliminarCamposLayout.setHorizontalGroup(
            JD_EliminarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_EliminarCamposLayout.setVerticalGroup(
            JD_EliminarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(0, 153, 153));

        jLabel26.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Listar Campos");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel26)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table2MouseClicked(evt);
            }
        });
        Table2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Table2PropertyChange(evt);
            }
        });
        Listar_Campos1.setViewportView(Table2);

        jPanel18.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Listar_Campos1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Listar_Campos1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout JD_Listar_CamposLayout = new javax.swing.GroupLayout(JD_Listar_Campos.getContentPane());
        JD_Listar_Campos.getContentPane().setLayout(JD_Listar_CamposLayout);
        JD_Listar_CamposLayout.setHorizontalGroup(
            JD_Listar_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_Listar_CamposLayout.setVerticalGroup(
            JD_Listar_CamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel16.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("FILE MANAGER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel16)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scroll.setViewportView(Table);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Salir");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Limpiar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jm_Archivo.setText("Archivo");

        jmi_Nuevo_Archivo.setText("Nuevo Archivo");
        jmi_Nuevo_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Nuevo_ArchivoActionPerformed(evt);
            }
        });
        jm_Archivo.add(jmi_Nuevo_Archivo);

        jmi_Cargar_Archivo.setText("Cargar Archivo");
        jmi_Cargar_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Cargar_ArchivoActionPerformed(evt);
            }
        });
        jm_Archivo.add(jmi_Cargar_Archivo);

        jmi_Salvar_Archivo.setText("Salvar Archivo");
        jmi_Salvar_Archivo.setEnabled(false);
        jmi_Salvar_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Salvar_ArchivoActionPerformed(evt);
            }
        });
        jm_Archivo.add(jmi_Salvar_Archivo);

        jmi_Cerrar_Archivo.setText("Cerrar Archivo");
        jmi_Cerrar_Archivo.setEnabled(false);
        jmi_Cerrar_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Cerrar_ArchivoActionPerformed(evt);
            }
        });
        jm_Archivo.add(jmi_Cerrar_Archivo);

        jmi_Salir.setText("Salir");
        jmi_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_SalirActionPerformed(evt);
            }
        });
        jm_Archivo.add(jmi_Salir);

        jmb_Principal.add(jm_Archivo);

        jmi_Campos.setText("Campos");
        jmi_Campos.setEnabled(false);

        jmi_Crear_Campo.setText("Crear Campos");
        jmi_Crear_Campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Crear_CampoActionPerformed(evt);
            }
        });
        jmi_Campos.add(jmi_Crear_Campo);

        jmi_Borrar_Campo.setText("Modificar Campos");
        jmi_Borrar_Campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Borrar_CampoActionPerformed(evt);
            }
        });
        jmi_Campos.add(jmi_Borrar_Campo);

        jmi_Listar_Campos.setText("Borrar Campos");
        jmi_Listar_Campos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Listar_CamposActionPerformed(evt);
            }
        });
        jmi_Campos.add(jmi_Listar_Campos);

        jMenuItem1.setText("Listar Campos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmi_Campos.add(jMenuItem1);

        jmb_Principal.add(jmi_Campos);

        jm_Registros.setText("Registros");
        jm_Registros.setEnabled(false);

        jmi_Crear_Registro.setText("Nuevo registro");
        jmi_Crear_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Crear_RegistroActionPerformed(evt);
            }
        });
        jm_Registros.add(jmi_Crear_Registro);

        jmi_Borrar_Registro.setText("Modificar Registro");
        jmi_Borrar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Borrar_RegistroActionPerformed(evt);
            }
        });
        jm_Registros.add(jmi_Borrar_Registro);

        jmi_Buscar_Registro.setText("Buscar Registro");
        jmi_Buscar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Buscar_RegistroActionPerformed(evt);
            }
        });
        jm_Registros.add(jmi_Buscar_Registro);

        jmi_modreg.setText("Borrar Registro");
        jmi_modreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_modregActionPerformed(evt);
            }
        });
        jm_Registros.add(jmi_modreg);

        jmb_Principal.add(jm_Registros);

        jm_indices.setText("Indice");
        jm_indices.setEnabled(false);

        jmi_crearindices.setText("Crear Indices");
        jmi_crearindices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_crearindicesActionPerformed(evt);
            }
        });
        jm_indices.add(jmi_crearindices);

        jmi_reindexar.setText("Re Indexar Archivos");
        jmi_reindexar.setEnabled(false);
        jmi_reindexar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_reindexarActionPerformed(evt);
            }
        });
        jm_indices.add(jmi_reindexar);

        jmb_Principal.add(jm_indices);

        jm_Estandarizacion.setText("Utilidades");
        jm_Estandarizacion.setEnabled(false);

        jmi_Exportar_Excel.setText("Exportar EXCEL");
        jmi_Exportar_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Exportar_ExcelActionPerformed(evt);
            }
        });
        jm_Estandarizacion.add(jmi_Exportar_Excel);

        jmi_Exportrar_XML.setText("Exportar XML con SCHEMA");
        jmi_Exportrar_XML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Exportrar_XMLActionPerformed(evt);
            }
        });
        jm_Estandarizacion.add(jmi_Exportrar_XML);

        jmb_Principal.add(jm_Estandarizacion);

        setJMenuBar(jmb_Principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_Nuevo_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Nuevo_ArchivoActionPerformed
        // TODO add your handling code here:
        Nuevo_Archivo();
        jmi_Campos.setEnabled(true);
//        jmi_Modificar_Campo.setEnabled(true);
        jmi_Crear_Campo.setEnabled(true);
        jmi_Borrar_Campo.setEnabled(true);
        jm_Registros.setEnabled(true);
        jm_indices.setEnabled(true);
        jm_Estandarizacion.setEnabled(true);
        jmi_Salvar_Archivo.setEnabled(true);
        jmi_Cerrar_Archivo.setEnabled(true);
    }//GEN-LAST:event_jmi_Nuevo_ArchivoActionPerformed

    private void jmi_Salvar_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Salvar_ArchivoActionPerformed
        // TODO add your handling code here:
        Salvar_Archivo();
    }//GEN-LAST:event_jmi_Salvar_ArchivoActionPerformed

    private void jmi_Cerrar_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Cerrar_ArchivoActionPerformed
        if (!salvado) {
            int save = JOptionPane.showConfirmDialog(this, "¿Desea guardar el "
                    + "archivo?", "Guardar y cerrar.",
                    JOptionPane.YES_NO_OPTION);
            if (save == JOptionPane.YES_OPTION) {
                jmi_Salvar_ArchivoActionPerformed(evt);
            }
            salvado = true;
        }//fin del if
        // try {
        //RAfile.close();
        Table.setModel(cleanTable);
        jmi_Campos.setEnabled(false);
        jm_Registros.setEnabled(false);
        jm_indices.setEnabled(false);
        jm_Estandarizacion.setEnabled(false);
        jmi_Salvar_Archivo.setEnabled(false);
        jmi_Cerrar_Archivo.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Cerrado Exitosamente", "Cerrado", JOptionPane.INFORMATION_MESSAGE);
        // } catch (HeadlessException | IOException e) {
        //  JOptionPane.showMessageDialog(null, "Error al cerrar", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        // }
    }//GEN-LAST:event_jmi_Cerrar_ArchivoActionPerformed

    private void jmi_Cargar_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Cargar_ArchivoActionPerformed
        // TODO add your handling code here:
        Cargar_Archivo();
        if (FileSuccess == 1) {
            jmi_Campos.setEnabled(true);
//            jmi_Modificar_Campo.setEnabled(true);
            jmi_Crear_Campo.setEnabled(true);
            jmi_Listar_Campos.setEnabled(true);
            jmi_Borrar_Campo.setEnabled(true);
            jm_Registros.setEnabled(true);
            jm_indices.setEnabled(true);
            jm_Estandarizacion.setEnabled(true);
            jmi_Salvar_Archivo.setEnabled(true);
            jmi_Cerrar_Archivo.setEnabled(true);
        }
    }//GEN-LAST:event_jmi_Cargar_ArchivoActionPerformed

    private void jmi_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jmi_SalirActionPerformed

    private void jmi_Crear_CampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Crear_CampoActionPerformed

        this.setVisible(false);
        JD_Crearcampo.setVisible(false);
        JD_Crearcampo.pack();
        JD_Crearcampo.setLocationRelativeTo(this);
        JD_Crearcampo.setVisible(true);
    }//GEN-LAST:event_jmi_Crear_CampoActionPerformed

    private void jmi_Borrar_CampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Borrar_CampoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JD_ModificarCampos.setVisible(false);
        JD_ModificarCampos.pack();
        JD_ModificarCampos.setLocationRelativeTo(this);
        JD_ModificarCampos.setVisible(true);
    }//GEN-LAST:event_jmi_Borrar_CampoActionPerformed

    private void jmi_Listar_CamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Listar_CamposActionPerformed

        this.setVisible(false);
        JD_EliminarCampos.setVisible(false);
        JD_EliminarCampos.pack();
        JD_EliminarCampos.setLocationRelativeTo(this);
        JD_EliminarCampos.setVisible(true);

    }//GEN-LAST:event_jmi_Listar_CamposActionPerformed

    private void jmi_Crear_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Crear_RegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_Crear_RegistroActionPerformed

    private void jmi_Borrar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Borrar_RegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_Borrar_RegistroActionPerformed

    private void jmi_Buscar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Buscar_RegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_Buscar_RegistroActionPerformed

    private void jmi_modregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_modregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_modregActionPerformed

    private void jmi_crearindicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_crearindicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_crearindicesActionPerformed

    private void jmi_Exportar_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Exportar_ExcelActionPerformed


    }//GEN-LAST:event_jmi_Exportar_ExcelActionPerformed

    private void jmi_Exportrar_XMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Exportrar_XMLActionPerformed

    }//GEN-LAST:event_jmi_Exportrar_XMLActionPerformed

    private void jmi_reindexarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_reindexarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_reindexarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JD_Crearcampo.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        JD_ModificarCampos.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        JD_EliminarCampos.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String nombreCampo = tf_NombreCampo.getText();
        nombreCampo = nombreCampo.toUpperCase();

        boolean repetido = false;
        if (nombreCampo == null || nombreCampo.equals("")) {
            return;
        }
        if (nombreCampo.length() > 25) {
            JOptionPane.showMessageDialog(JD_Crearcampo, "No debe de ser mayor a 25 el campo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreSinEspacios = nombreCampo;

        for (int i = nombreCampo.length(); i < 25; i++) {
            nombreCampo += " ";
        }
        String auxValidacion;
        for (int i = 0; i < archivoEnUso.getCamposDelArchivo().size(); i++) {
            auxValidacion = archivoEnUso.getCamposDelArchivo().get(i).getNombreCampo();
            if (auxValidacion.equalsIgnoreCase(nombreCampo)) { //Checks repetition
                repetido = true;
                break;
            }
        }
        if (repetido) {
            JOptionPane.showMessageDialog(JD_Crearcampo, "El campo ya existe, por favor intente de nuevo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel m = (DefaultTableModel) Table.getModel();
            m.addColumn(nombreSinEspacios);
            Table.setModel(m);

            if (tipoEntero.isSelected()) {
                CampoEntero campo = new CampoEntero(nombreCampo + "_int");
                archivoEnUso.getCamposDelArchivo().add(campo);
            } else if (tipoDecimal.isSelected()) {
                CampoDecimal campo = new CampoDecimal(nombreCampo + "_dec");
                archivoEnUso.getCamposDelArchivo().add(campo);
            } else if (tipoChar.isSelected()) {
                CampoCaracter campo = new CampoCaracter(nombreCampo + "_car");
                archivoEnUso.getCamposDelArchivo().add(campo);
            } else if (tipoString.isSelected()) {
                CampoTexto campo = new CampoTexto(nombreCampo + "_str");
                campo.setLongitud((Integer) js_tamanioCadena.getValue());
                js_tamanioCadena.setValue(15);
                archivoEnUso.getCamposDelArchivo().add(campo);
            }
            if (archivoEnUso.getPrimaryKey() != -1) {
                tieneLlavePrincipal = true;
            }
            if (rb_LlavePrincipal.isSelected()) {

                if (!tieneLlavePrincipal) {

                    archivoEnUso.setPrimaryKey(archivoEnUso.getCamposDelArchivo().size() - 1);
                    tieneLlavePrincipal = true;
                } else {
                    int seleccion = JOptionPane.showConfirmDialog(JD_Crearcampo, "¿Desea cambiar la llave principal a este campo?",
                            "Cambiar llave principal", JOptionPane.INFORMATION_MESSAGE);
                    if (seleccion == JOptionPane.YES_OPTION) {
                        archivoEnUso.setPrimaryKey(archivoEnUso.getCamposDelArchivo().size() - 1);
                    }
                }

            } else if (rb_LlaveSecundaria.isSelected()) {
                archivoEnUso.getSecundarias().add(archivoEnUso.getCamposDelArchivo().size() - 1);
            }
            JOptionPane.showMessageDialog(JD_Crearcampo, "Campo agregado exitosamente.");
            DefaultListModel mod = (DefaultListModel) jList_campos.getModel();
            mod.addElement(nombreSinEspacios);
            jList_campos.setModel(mod);

            saved = false;
            tf_NombreCampo.setText("");
            tipoString.setSelected(true);
            rb_campoNormal.setSelected(true);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3MouseClicked

    private void tipoStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoStringActionPerformed

    private void tipoStringStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tipoStringStateChanged
        if (tipoString.isSelected()) {
            js_tamanioCadena.setEnabled(true);
        } else {
            js_tamanioCadena.setEnabled(false);
        }
    }//GEN-LAST:event_tipoStringStateChanged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {

            int seleccion = jList_campos.getSelectedIndex();

            DefaultListModel mod = (DefaultListModel) jList_campos.getModel();

            String viejo = jtf_actualCampo.getText();
            String nuevoNombre = jtf_nuevoCampo.getText();

            if (nuevoNombre == null || nuevoNombre.equals(viejo)) {
                return;
            }

            nuevoNombre = nuevoNombre;

            if (nuevoNombre.equals("")) {
                return;
            } else if (nuevoNombre.length() > 25) {
                JOptionPane.showMessageDialog(JD_ModificarCampos, "El nuevo nombre del campo no debe "
                        + "sobrepasar los 25 caracteres.", "Nombre demasiado largo.", JOptionPane.ERROR_MESSAGE);
                return;
            }

            nuevoNombre = nuevoNombre.toUpperCase();

            int largo = nuevoNombre.length();
            while (nuevoNombre.length() < 25) {
                nuevoNombre += " ";
            }

            for (int i = 0; i < archivoEnUso.getCamposDelArchivo().size(); i++) {
                if (nuevoNombre.equalsIgnoreCase(archivoEnUso.getCamposDelArchivo().get(i).getNombreCampo().substring(0, 25))) {
                    JOptionPane.showMessageDialog(this, "El campo ingresado ya existe.", "No se"
                            + " puede modificar el campo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            //Cambiamos el campo en la JList
            mod.setElementAt(nuevoNombre, seleccion);
            jList_campos.setModel(mod);

            //Obtenemos el campo del ArchivoDeRegistro
            Campo campo = archivoEnUso.getCamposDelArchivo().get(seleccion);
            String nombreViejo = campo.getNombreCampo();

            if (nombreViejo.endsWith("int")) {
                nuevoNombre += "_int";
            } else if (nombreViejo.endsWith("dec")) {
                nuevoNombre += "_dec";
            } else if (nombreViejo.endsWith("car")) {
                nuevoNombre += "_car";
            } else {
                nuevoNombre += "_str";
            }

            //Cambiamos el campo en el ArchivoDeRegistro
            campo.setNombreCampo(nuevoNombre);

            JOptionPane.showMessageDialog(this, "Campo modificado con exito",
                    "REALIZADO", JOptionPane.INFORMATION_MESSAGE);

            // Modificamos el campo en la tabla.
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            String dataAux[] = new String[archivoEnUso.getCamposDelArchivo().size()];
            for (int i = 0; i < dataAux.length; i++) {
                if (i == seleccion) {
                    dataAux[i] = nuevoNombre.substring(0, largo);
                } else {
                    dataAux[i] = model.getColumnName(i);
                }
            }
            saved = false;

            JD_ModificarCampos.setVisible(false);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void Table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Table2MouseClicked

    private void Table2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Table2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_Table2PropertyChange

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        JD_Listar_Campos.setVisible(false);
        JD_Listar_Campos.pack();
        JD_Listar_Campos.setLocationRelativeTo(this);
        JD_Listar_Campos.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JD_Listar_Campos.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Crearcampo;
    private javax.swing.JDialog JD_EliminarCampos;
    private javax.swing.JDialog JD_Listar_Campos;
    private javax.swing.JDialog JD_ModificarCampos;
    private javax.swing.JLabel JL_13;
    private javax.swing.JScrollPane Listar_Campos1;
    private javax.swing.JTable Table;
    private javax.swing.JTable Table2;
    private javax.swing.ButtonGroup TipoDato;
    private javax.swing.ButtonGroup TipoLlave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JList<String> jList_campos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JMenu jm_Archivo;
    private javax.swing.JMenu jm_Estandarizacion;
    private javax.swing.JMenu jm_Registros;
    private javax.swing.JMenu jm_indices;
    private javax.swing.JMenuBar jmb_Principal;
    private javax.swing.JMenuItem jmi_Borrar_Campo;
    private javax.swing.JMenuItem jmi_Borrar_Registro;
    private javax.swing.JMenuItem jmi_Buscar_Registro;
    private javax.swing.JMenu jmi_Campos;
    private javax.swing.JMenuItem jmi_Cargar_Archivo;
    private javax.swing.JMenuItem jmi_Cerrar_Archivo;
    private javax.swing.JMenuItem jmi_Crear_Campo;
    private javax.swing.JMenuItem jmi_Crear_Registro;
    private javax.swing.JMenuItem jmi_Exportar_Excel;
    private javax.swing.JMenuItem jmi_Exportrar_XML;
    private javax.swing.JMenuItem jmi_Listar_Campos;
    private javax.swing.JMenuItem jmi_Nuevo_Archivo;
    private javax.swing.JMenuItem jmi_Salir;
    private javax.swing.JMenuItem jmi_Salvar_Archivo;
    private javax.swing.JMenuItem jmi_crearindices;
    private javax.swing.JMenuItem jmi_modreg;
    private javax.swing.JMenuItem jmi_reindexar;
    private javax.swing.JSpinner js_tamanioCadena;
    private javax.swing.JTextField jtf_actualCampo;
    private javax.swing.JTextField jtf_nuevoCampo;
    private javax.swing.JRadioButton rb_LlavePrincipal;
    private javax.swing.JRadioButton rb_LlaveSecundaria;
    private javax.swing.JRadioButton rb_campoNormal;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField tf_NombreCampo;
    private javax.swing.JRadioButton tipoChar;
    private javax.swing.JRadioButton tipoDecimal;
    private javax.swing.JRadioButton tipoEntero;
    private javax.swing.JRadioButton tipoString;
    // End of variables declaration//GEN-END:variables
    int FileSuccess;
    File file;
    File file2;
    int FileSuccess2;
    RandomAccessFile RAfile;
    RandomAccessFile RAfile2;
    TableModel cleanTable;
    private boolean salvado = true;
    private boolean saved = true;
    private boolean tieneLlavePrincipal = false;
    private Archivo archivoEnUso;
}
