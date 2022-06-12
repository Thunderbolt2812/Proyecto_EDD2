package proyectoedd2;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import java.io.*;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import java.io.RandomAccessFile;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;

public class Main extends javax.swing.JFrame {

    boolean validar = false;
    int contador = 0, cantidad = 0;
    boolean openfile = false;

//    public void Salvar_Archivo() {
//
//        JOptionPane.showMessageDialog(null, "Su archivo se ha guardado exitosamente");
//    }
//
//    public void Cargar_Archivo() {
//        FileSuccess = 0;
//        String direction;
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File("./"));
//        FileNameExtensionFilter data = new FileNameExtensionFilter("DAT FILE", "dat");
//        fileChooser.setFileFilter(data);
//        int seleccion = fileChooser.showOpenDialog(this);
//        if (seleccion == JFileChooser.APPROVE_OPTION) { //Cuando le da guardar
//            File Archivo;
//            try {
//                if (fileChooser.getFileFilter().getDescription().equals("DAT FILE")) { //Chequea si lo que quiere guardar es DAT FILE
//                    direction = fileChooser.getSelectedFile().getPath() + ".dat";
//                    Archivo = fileChooser.getSelectedFile();
//                    this.file = Archivo;
//                    JOptionPane.showMessageDialog(null, "El archivo se abrió con éxito");
//                    FileSuccess = 1;
//                } else {
//                    JOptionPane.showMessageDialog(this, "No se pudo abrir, asegurese que su archivo sea un archivo DAT.");
//                }
//
//            } catch (HeadlessException e) {
//                JOptionPane.showMessageDialog(this, "Hubo un problema.");
//            }
//            try {
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Hubo un error al cerrar el archivo.");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Operacion cancelada.");
//        }
//
////    }
//
//    private void Nuevo_Archivo() {
//
//        Crear_Archivo();
//        if (FileSuccess == 1) {
//            openfile = true;
//        }
//
//    }
//
//    private void Crear_Archivo() {
//
//        FileSuccess = 0;
//        String direction;
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File("./"));
//        FileNameExtensionFilter data = new FileNameExtensionFilter("DAT FILE", "dat");
//        fileChooser.setFileFilter(data);
//        int seleccion = fileChooser.showSaveDialog(this);
//
//        if (seleccion == JFileChooser.APPROVE_OPTION) {
//
//            File archivo = null;
//            FileOutputStream fos = null;
//            ObjectOutputStream ous = null;
//
//            try {
//                if (fileChooser.getFileFilter().getDescription().equals("DAT FILE")) {
//                    direction = fileChooser.getSelectedFile().getPath() + ".dat";
//                    direction = direction.replace(".dat", "");
//                    direction += ".dat";
//
//                    archivo = new File(direction);
//                    if (archivo.length() == 0) {
//                        this.file = new File(direction);
//                        JOptionPane.showMessageDialog(this, "Enhorabuena!\n Cualquier cambio sin salvar no se puede recuperar");
//                        jmi_Campos.setEnabled(true);
//                        jm_Registros.setEnabled(true);
//                        jm_indices.setEnabled(true);
//                        jm_Estandarizacion.setEnabled(true);
//                        jmi_Salvar_Archivo.setEnabled(true);
//                        jmi_Cerrar_Archivo.setEnabled(true);
//                    } else if (archivo.exists()) {
//                        archivo.delete();
//                        archivo.createNewFile();
//                        this.file = new File(direction);
//                        JOptionPane.showMessageDialog(this, "File OverWritten, New Length: " + archivo.length());
//                    }
//                    FileSuccess = 1;
//                } else {
//                    JOptionPane.showMessageDialog(this, "No se puede salvar. Use DAT FILE.");
//                }
//                fos = new FileOutputStream(archivo);
//                ous = new ObjectOutputStream(fos);
//                ous.flush();
//            } catch (HeadlessException | IOException e) {
//                JOptionPane.showMessageDialog(this, "Error desconocido");
//            }
//            try {
//                ous.close();
//                fos.close();
//            } catch (IOException e) {
//                JOptionPane.showMessageDialog(this, "Cerrando Archivos.");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Operacion cancelada!");
//        }
//    }
//    public void Cargar_Archivo_2() {
//        FileSuccess2 = 0;
//        String direction;
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File("./"));
//        FileNameExtensionFilter data = new FileNameExtensionFilter("DAT FILE", "dat");
//        fileChooser.setFileFilter(data);
//        int seleccion = fileChooser.showOpenDialog(this);
//        if (seleccion == JFileChooser.APPROVE_OPTION) {
//            File Archivo;
//
//            try {
//                if (fileChooser.getFileFilter().getDescription().equals("DAT FILE")) {
//                    direction = fileChooser.getSelectedFile().getPath() + ".dat";
//                    Archivo = fileChooser.getSelectedFile();
//                    this.file2 = Archivo;
//                    JOptionPane.showMessageDialog(null, "Sucess!");
//                    FileSuccess2 = 1;
//                } else {
//                    JOptionPane.showMessageDialog(this, "El archivo no se cargo, asegurese que su archivo es de tipo DAT.");
//                }
//
//            } catch (HeadlessException e) {
//                JOptionPane.showMessageDialog(this, "Hubo un error!");
//            }
//            try {
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Error al cerrar archivo.");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Operacion cancelada!");
//        }
//
//    }
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
//        Table.setForeground(Color.BLACK);
//        Table.setBackground(Color.WHITE);
//        Table.setFont(new Font("", 1, 22));
//        Table.setRowHeight(30);
//        Table.putClientProperty("terminateEditOnFocusLost", true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_Crearcampo = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TF_NombreDelCampo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        SP_LongitudDelCampo = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        RB_LlaveSecundariaDelCampo = new javax.swing.JRadioButton();
        RB_LlavePrimariaDelCampo = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        CB_TipoDeDatoDelCampo = new javax.swing.JComboBox<>();
        JD_ModificarEliminarCampos = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        JL_13 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        CB_TipoDeDatoDelCampoModificado = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        SP_LongitudDelCampoModificado = new javax.swing.JSpinner();
        jPanel18 = new javax.swing.JPanel();
        RB_LlaveSecundariaDelCampoModificado = new javax.swing.JRadioButton();
        RB_LlavePrimariaDelCampoModificado = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TF_NombreDelCampoModificado = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        CB_CampoAModificar = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CB_CampoABorrar = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        TipoDato = new javax.swing.ButtonGroup();
        TipoLlave = new javax.swing.ButtonGroup();
        JD_RegistroNuevo = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        JL_14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jb_crearRegistro = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jt_campos = new javax.swing.JTable();
        JD_Listar = new javax.swing.JDialog();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_ListarCampos = new javax.swing.JTextArea();
        TipoDatoModificar = new javax.swing.ButtonGroup();
        TipoLLaveModificar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_ArchivoAbierto = new javax.swing.JTextArea();
        POS = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TA_ListarCampos1 = new javax.swing.JTextArea();
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jm_Registros = new javax.swing.JMenu();
        jmi_Crear_Registro = new javax.swing.JMenuItem();
        jmi_Borrar_Registro = new javax.swing.JMenuItem();
        jmi_Buscar_Registro = new javax.swing.JMenuItem();
        jmi_modreg = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
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

        TF_NombreDelCampo.setBorder(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Longitud de campo:");

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
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
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

        RB_LlaveSecundariaDelCampo.setBackground(new java.awt.Color(255, 255, 255));
        POS.add(RB_LlaveSecundariaDelCampo);
        RB_LlaveSecundariaDelCampo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlaveSecundariaDelCampo.setText("Llave Secundaria");

        RB_LlavePrimariaDelCampo.setBackground(new java.awt.Color(255, 255, 255));
        POS.add(RB_LlavePrimariaDelCampo);
        RB_LlavePrimariaDelCampo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlavePrimariaDelCampo.setText("Llave Primaria");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(RB_LlavePrimariaDelCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(RB_LlaveSecundariaDelCampo)
                    .addGap(53, 53, 53)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RB_LlavePrimariaDelCampo)
                        .addComponent(RB_LlaveSecundariaDelCampo))
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de dato"));

        CB_TipoDeDatoDelCampo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_TipoDeDatoDelCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "int", "double", "char", "string", " " }));
        CB_TipoDeDatoDelCampo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CB_TipoDeDatoDelCampo, 0, 377, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CB_TipoDeDatoDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(TF_NombreDelCampo))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(39, 39, 39)
                                .addComponent(SP_LongitudDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(TF_NombreDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(SP_LongitudDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout JD_CrearcampoLayout = new javax.swing.GroupLayout(JD_Crearcampo.getContentPane());
        JD_Crearcampo.getContentPane().setLayout(JD_CrearcampoLayout);
        JD_CrearcampoLayout.setHorizontalGroup(
            JD_CrearcampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(147, 147, 147)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel22)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        JL_13.setText("Seleccione el campo que le gustaría modificar:");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de dato"));

        CB_TipoDeDatoDelCampoModificado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_TipoDeDatoDelCampoModificado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "int", "double", "char", "string" }));
        CB_TipoDeDatoDelCampoModificado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CB_TipoDeDatoDelCampoModificado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(CB_TipoDeDatoDelCampoModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Longitud de Cadena"));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(SP_LongitudDelCampoModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SP_LongitudDelCampoModificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de llave"));

        RB_LlaveSecundariaDelCampoModificado.setBackground(new java.awt.Color(255, 255, 255));
        RB_LlaveSecundariaDelCampoModificado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlaveSecundariaDelCampoModificado.setText("Llave Secundaria");

        RB_LlavePrimariaDelCampoModificado.setBackground(new java.awt.Color(255, 255, 255));
        RB_LlavePrimariaDelCampoModificado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlavePrimariaDelCampoModificado.setText("Llave Primaria");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(RB_LlavePrimariaDelCampoModificado)
                    .addGap(18, 18, 18)
                    .addComponent(RB_LlaveSecundariaDelCampoModificado)
                    .addContainerGap(100, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RB_LlavePrimariaDelCampoModificado)
                        .addComponent(RB_LlaveSecundariaDelCampoModificado))
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        jPanel19.setBackground(new java.awt.Color(232, 231, 231));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Campo Actual: ");

        jLabel2.setText("Nuevo Campo:");

        TF_NombreDelCampoModificado.setBackground(new java.awt.Color(232, 231, 231));
        TF_NombreDelCampoModificado.setBorder(null);

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));

        CB_CampoAModificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_CampoAModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        CB_CampoAModificar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_CampoAModificarItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_CampoAModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
                        .addComponent(TF_NombreDelCampoModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CB_CampoAModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(TF_NombreDelCampoModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Campo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel4.setText("Campo:");

        CB_CampoABorrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_CampoABorrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        CB_CampoABorrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_CampoABorrarItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(CB_CampoABorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CB_CampoABorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(JL_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(309, 309, 309))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(JL_13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));

        jButton9.setText("Regresar ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("modificar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton6))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout JD_ModificarEliminarCamposLayout = new javax.swing.GroupLayout(JD_ModificarEliminarCampos.getContentPane());
        JD_ModificarEliminarCampos.getContentPane().setLayout(JD_ModificarEliminarCamposLayout);
        JD_ModificarEliminarCamposLayout.setHorizontalGroup(
            JD_ModificarEliminarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_ModificarEliminarCamposLayout.setVerticalGroup(
            JD_ModificarEliminarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_ModificarEliminarCamposLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));

        jLabel19.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Crear Registro");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel19)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        JL_14.setForeground(new java.awt.Color(102, 102, 102));
        JL_14.setText("Ingrese los datos, del nuevo registro:");

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jb_crearRegistro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jb_crearRegistro.setText("Aceptar");
        jb_crearRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_crearRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_crearRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jb_crearRegistro))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jt_campos.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jt_campos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jt_campos.setCellSelectionEnabled(true);
        jScrollPane4.setViewportView(jt_campos);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_14, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JL_14)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_RegistroNuevoLayout = new javax.swing.GroupLayout(JD_RegistroNuevo.getContentPane());
        JD_RegistroNuevo.getContentPane().setLayout(JD_RegistroNuevoLayout);
        JD_RegistroNuevoLayout.setHorizontalGroup(
            JD_RegistroNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_RegistroNuevoLayout.setVerticalGroup(
            JD_RegistroNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(0, 153, 153));

        jLabel21.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Listar Campos");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(25, 25, 25))
        );

        jPanel22.setBackground(new java.awt.Color(0, 153, 153));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TA_ListarCampos.setColumns(20);
        TA_ListarCampos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TA_ListarCampos.setRows(5);
        TA_ListarCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        TA_ListarCampos.setEnabled(false);
        jScrollPane2.setViewportView(TA_ListarCampos);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_ListarLayout = new javax.swing.GroupLayout(JD_Listar.getContentPane());
        JD_Listar.getContentPane().setLayout(JD_ListarLayout);
        JD_ListarLayout.setHorizontalGroup(
            JD_ListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_ListarLayout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        JD_ListarLayout.setVerticalGroup(
            JD_ListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TA_ArchivoAbierto.setColumns(20);
        TA_ArchivoAbierto.setRows(5);
        TA_ArchivoAbierto.setEnabled(false);
        jScrollPane1.setViewportView(TA_ArchivoAbierto);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel16.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("FILE MANAGER");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen proyecto.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(554, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(27, 27, 27))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
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
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        TA_ListarCampos1.setColumns(20);
        TA_ListarCampos1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TA_ListarCampos1.setRows(5);
        TA_ListarCampos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        TA_ListarCampos1.setEnabled(false);
        jScrollPane3.setViewportView(TA_ListarCampos1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
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

        jmi_Borrar_Campo.setText("Modificar y Eliminar Campos");
        jmi_Borrar_Campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Borrar_CampoActionPerformed(evt);
            }
        });
        jmi_Campos.add(jmi_Borrar_Campo);

        jMenuItem2.setText("Listar Campos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmi_Campos.add(jMenuItem2);

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

        jMenuItem1.setText("Listar registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jm_Registros.add(jMenuItem1);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_Nuevo_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Nuevo_ArchivoActionPerformed
        try {
            Boolean existe = false;
            JFileChooser directorio = new JFileChooser("./");
            directorio.setApproveButtonText("Guardar");
            int seleccion = directorio.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = new File(directorio.getSelectedFile() + ".txt");
                BufferedWriter salida = new BufferedWriter(new FileWriter(archivo));
                salida.close();
                // CARGADO DE ARCHIVOS A EL ARCHIVO BINARIO
                int ID;
                aa.cargarArchivo();
                for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                    if (aa.getLista_archivos().get(i).getArchivo().getName().equals(archivo.getName())) {
                        existe = true;
                    } // Fin If
                } // Fin For
                if (existe == false) {
                    ID = aa.GenerarId();
                    archivo_actual = new Archivo(archivo, ID);
                    GuardarArchivo = archivo.getName();
                    aa.AddArchivo(archivo_actual);
                    aa.escribirArchivo();
                    archivo_actual = null;
                    JOptionPane.showMessageDialog(null, "¡Se ha creado su archivo exitosamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede crear el archivo porque ya existe");
                } // Fin If
            } // Fin If
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch

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

    void EscribirCamposBinario() {
        try {
            archivo_actual.setCampos(campos_nuevos);
            FileWriter fw = null;
            BufferedWriter bw = null;
            fw = new FileWriter(archivo_actual.getArchivo());
            bw = new BufferedWriter(fw);
            bw.write(TA_ArchivoAbierto.getText());
            bw.flush();
            aa.cargarArchivo();
            for (Archivo archivo : aa.getLista_archivos()) {
                if (archivo.getID() == archivo_actual.getID()) {
                    archivo.setArchivo(archivo_actual.getArchivo());
                    archivo.setCampos(campos_nuevos);
                    break;
                } // Fin If
            } // Fin For
            aa.escribirArchivo();
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
    }
    private void jmi_Salvar_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Salvar_ArchivoActionPerformed
        try {
            // Actualiza el Text Area
            FileReader fr = null;
            BufferedReader br = null;
            fr = new FileReader(archivo_actual.getArchivo());
            br = new BufferedReader(fr);
            TA_ArchivoAbierto.setText("");
            String linea;
            while ((linea = br.readLine()) != null) {
                TA_ArchivoAbierto.append(linea);
            } // Fin While
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
            // Actualiza el file dentro del archivo binario
            EscribirCamposBinario();
            formatear_CBbox_Modificar();
            formatear_CBbox_borrar();

            if (secreo == true || semodifico == true || seborro == true) {
                JOptionPane.showMessageDialog(null, "Archivo Salvado Exitosamente");
            } // Fin If
            secreo = false;
            semodifico = false;
            seborro = false;
            salvado = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jmi_Salvar_ArchivoActionPerformed

//        //Reset navigation buttons
//        jb_siguiente.setEnabled(false);
//        jb_final.setEnabled(false);
//        jb_anterior.setEnabled(false);
//        jb_inicio.setEnabled(false);
//        //Reset helper variables
//        currentPosList = -1;
//        currentRegList = -1;

    private void jmi_Cerrar_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Cerrar_ArchivoActionPerformed
        try {
            // ME FALTA PROBAR SI FUNCIONA CON LOS CRUDS
            if (salvado == true) {
                if (JOptionPane.showConfirmDialog(null, "¿Desea salvar los cambios en el archivo?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    // Actualiza el text area
                    FileReader fr = null;
                    BufferedReader br = null;
                    fr = new FileReader(archivo_actual.getArchivo());
                    br = new BufferedReader(fr);
                    TA_ArchivoAbierto.setText("");
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        TA_ArchivoAbierto.append(linea);
                    } // Fin While
                    try {
                        br.close();
                        fr.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } // Fin Try Catch
                    // Actualiza el file dentro del archivo binario
                    EscribirCamposBinario();
                    JOptionPane.showMessageDialog(this, "¡Se ha guardado el archivo exitosamente!");
                } else {
                    FileWriter fw = null;
                    BufferedWriter bw = null;
                    fw = new FileWriter(archivo_actual.getArchivo());
                    bw = new BufferedWriter(fw);
                    bw.write(TA_ArchivoAbierto.getText());
                    TA_ArchivoAbierto.setText("");
                    bw.flush();
                    aa.cargarArchivo();
                    for (Archivo archivo : aa.getLista_archivos()) {
                        if (archivo.getID() == archivo_actual.getID()) {
                            archivo.setArchivo(archivo_actual.getArchivo());
                            break;
                        } // Fin If
                    } // Fin For
                    aa.escribirArchivo();
                    try {
                        bw.close();
                        fw.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } // Fin Try Catch
                } // Fin If
            } else {
                FileWriter fw = null;
                BufferedWriter bw = null;
                fw = new FileWriter(archivo_actual.getArchivo());
                bw = new BufferedWriter(fw);
                bw.write(TA_ArchivoAbierto.getText());
                TA_ArchivoAbierto.setText("");
                bw.flush();
                aa.cargarArchivo();
                for (Archivo archivo : aa.getLista_archivos()) {
                    if (archivo.getID() == archivo_actual.getID()) {
                        archivo.setArchivo(archivo_actual.getArchivo());
                        break;
                    } // Fin If
                } // Fin For
                aa.escribirArchivo();
                try {
                    bw.close();
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } // Fin Try Catch
            } // Fin If
            GuardarArchivo = null;
            archivo_actual = null;
            campos_nuevos.clear();
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jmi_Campos.setEnabled(false);
        jm_Registros.setEnabled(false);
        jm_indices.setEnabled(false);
        jm_Estandarizacion.setEnabled(false);
        jmi_Salvar_Archivo.setEnabled(false);
        jmi_Cerrar_Archivo.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Archivo cerrado exitosamente", "", JOptionPane.INFORMATION_MESSAGE);
        // } catch (HeadlessException | IOException e) {
        //  JOptionPane.showMessageDialog(null, "Error al cerrar", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        // }
    }//GEN-LAST:event_jmi_Cerrar_ArchivoActionPerformed
    void formatear_CBbox_Modificar() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        for (int i = 0; i < campos_nuevos.size(); i++) {
            Campo campo_temporal = campos_nuevos.get(i);
            modelo.addElement(campo_temporal.getNombre());
        }// Fin If
        CB_CampoAModificar.setModel(modelo);
    }

    void formatear_CBbox_borrar() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        for (int i = 0; i < campos_nuevos.size(); i++) {
            Campo campo_temporal = campos_nuevos.get(i);
            modelo.addElement(campo_temporal.getNombre());
        }// Fin If
        CB_CampoABorrar.setModel(modelo);
    }

    void listar_campos() {
        try {
            TA_ListarCampos1.setText("");
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                TA_ListarCampos1.append(archivo_actual.getCampos().get(i).toString());
            } // Fin For
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
    }
    private void jmi_Cargar_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Cargar_ArchivoActionPerformed
        try {
//            if (JOptionPane.showConfirmDialog(null, "¿Desea utilizar un archivo de prueba?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                boolean existePrueba = false;
//                aa.cargarArchivo();
//                for (Archivo archivo : aa.getLista_archivos()) {
//                    if (archivo.getArchivo().getName().equals("PersonFile.txt")) {
//                        existePrueba = true;
//                        break;
//                    } // Fin If
//                } // Fin For
//                aa.escribirArchivo();
//                arboles.cargarArchivo();
//                if (existePrueba) {
//                    aa.cargarArchivo();
//                    for (int i = 0; i < aa.getLista_archivos().size(); i++) {
//                        if (aa.getLista_archivos().get(i).getArchivo().getName().equals("PersonFile.txt")) {
//                            archivo_actual = aa.getLista_archivos().get(i);
//                            arbol_actual = arboles.getListaarboles().get(i).getArbol();
//                            arbol_secundarioactual = arbolessecundarios.getListaarboles().get(i).getArbolSecundario();
//                            GuardarArchivo = "PersonFile.txt";
//                            break;
//                        } // Fin If
//                    } // Fin For
//                    this.setVisible(false);
//                    VentanaMenuPrincipal.pack();
//                    VentanaMenuPrincipal.setLocationRelativeTo(null);
//                    VentanaMenuPrincipal.setVisible(true);
//                } else {
//                    GenerarPersonFile();
//                    this.setVisible(false);
//                    VentanaMenuPrincipal.pack();
//                    VentanaMenuPrincipal.setLocationRelativeTo(null);
//                    VentanaMenuPrincipal.setVisible(true);
//                } // Fin If
//            } else {
            File archivo_abrir = null;
            FileReader fr = null;
            BufferedReader br = null;

            JFileChooser filechooser = new JFileChooser("./");
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Texto", "txt");
            FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Imagenes", "jpg", "png", "bmp");
            filechooser.setFileFilter(filtro);
            filechooser.addChoosableFileFilter(filtro2);
            int seleccion = filechooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                archivo_abrir = filechooser.getSelectedFile();
                GuardarArchivo = archivo_abrir.getName();
                boolean valid = false;
                aa.cargarArchivo();
                for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                    if (aa.getLista_archivos().get(i).getArchivo().equals(archivo_abrir)) {
                        valid = true;
                        archivo_actual = aa.getLista_archivos().get(i);
                        formatear_CBbox_Modificar();
                        formatear_CBbox_borrar();
                        // listar_campos();
                        for (int j = 0; j < archivo_actual.getCampos().size(); j++) {
                            campos_nuevos.add(archivo_actual.getCampos().get(j));
                        } // Fin For
                        break;
                    } // Fin If
                } // Fin For
                if (!valid) {
                    // CARGADO DE ARCHIVOS A EL ARCHIVO BINARIO
                    int ID;
                    aa.cargarArchivo();
                    ID = aa.GenerarId();
                    archivo_actual = new Archivo(archivo_abrir, ID);
                    GuardarArchivo = null;
                    aa.AddArchivo(archivo_actual);
                    aa.escribirArchivo();
                    formatear_CBbox_Modificar();
                    formatear_CBbox_borrar();
                    listar_campos();
                    GuardarArchivo = archivo_actual.getArchivo().getName();
                } // Fin If
                fr = new FileReader(archivo_abrir);
                br = new BufferedReader(fr);
                String linea;
                TA_ArchivoAbierto.append("");
                while ((linea = br.readLine()) != null) {
                    TA_ArchivoAbierto.append(linea);
                    TA_ArchivoAbierto.append("\n");
                } // Fin While
                try {
                    br.close();
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } // Fin Try Catch
                arboles.cargarArchivo();
                // Esto verifica que el arbol no exista
                for (int i = 0; i < arboles.getListaarboles().size(); i++) {
                    if (arboles.getListaarboles().get(i).getArchivo().equals(archivo_actual.getArchivo())) {
                        arbol_actual = arboles.getListaarboles().get(i).getArbol();
                        break;
                    } // Fin If
                } // Fin For
                arbolessecundarios.cargarArchivo();
                for (int i = 0; i < arbolessecundarios.getListaarboles().size(); i++) {
                    if (arbolessecundarios.getListaarboles().get(i).getIDArchivoActual() == archivo_actual.getID()) {
                        arbol_secundarioactual = arbolessecundarios.getListaarboles().get(i).getArbolSecundario();
                        break;
                    } // Fin If
                } // Fin For
                salvado = false;
                JOptionPane.showMessageDialog(null, "Archivo cargado con exito");
            } // Fin If
//            } // Fin If
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo porque no existe");
        }
        jmi_Campos.setEnabled(true);
//            jmi_Modificar_Campo.setEnabled(true);
        jmi_Crear_Campo.setEnabled(true);
        jmi_Borrar_Campo.setEnabled(true);
        jm_Registros.setEnabled(true);
        jm_indices.setEnabled(true);
        jm_Estandarizacion.setEnabled(true);
        jmi_Salvar_Archivo.setEnabled(true);
        jmi_Cerrar_Archivo.setEnabled(true);

    }//GEN-LAST:event_jmi_Cargar_ArchivoActionPerformed

    private void jmi_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jmi_SalirActionPerformed

    private void jmi_Crear_CampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Crear_CampoActionPerformed
        if (archivo_actual.getCant_Registros() >= 1) {
            JOptionPane.showMessageDialog(this, "No es posible modificar los campos de este archivo.");
        } else {
            this.setVisible(false);
            JD_Crearcampo.setVisible(false);
            JD_Crearcampo.pack();
            JD_Crearcampo.setLocationRelativeTo(this);
            JD_Crearcampo.setVisible(true);
        }
    }//GEN-LAST:event_jmi_Crear_CampoActionPerformed

    private void jmi_Borrar_CampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Borrar_CampoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JD_ModificarEliminarCampos.setVisible(false);
        JD_ModificarEliminarCampos.pack();
        JD_ModificarEliminarCampos.setLocationRelativeTo(this);
        JD_ModificarEliminarCampos.setVisible(true);
    }//GEN-LAST:event_jmi_Borrar_CampoActionPerformed

    private void jmi_Crear_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Crear_RegistroActionPerformed

        this.setVisible(false);
        JD_RegistroNuevo.setVisible(false);
        JD_RegistroNuevo.pack();
        JD_RegistroNuevo.setLocationRelativeTo(this);
        JD_RegistroNuevo.setVisible(true);
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
        JD_ModificarEliminarCampos.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed
    public int GenerarIDCampo() {
        // CAMBIAR
        boolean valid;
        while (true) {
            valid = true;
            int ran;
            ran = 1 + random.nextInt(1000);
            for (Campo campo : archivo_actual.getCampos()) {
                if (campo.getID() == ran) {
                    valid = false;
                    break;
                } // Fin If
            } // Fin For
            if (valid) {
                return ran;
            } // Fin If
        } // Fin While
    }

    void añadir_campo_txt(Campo campo) {
        String linea = campo.campo_para_archivo();
        escribir_archivo_txt(linea);
        JOptionPane.showMessageDialog(this, "¡Se ha creado el campo exitosamente!");
    }

    void escribir_archivo_txt(String linea) {
        // Forma de Escribir:
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo_actual.getArchivo(), true);
            bw = new BufferedWriter(fw);
            bw.write(linea);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } // Fin Try Catch
    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        try {
            salvado = true;
            boolean existe = false;
            String nombre = TF_NombreDelCampo.getText();
            // Validacion del campo para ver si el nombre ya existe
            for (int i = 0; i < campos_nuevos.size(); i++) {
                if (campos_nuevos.get(i).getNombre().equals(nombre)) {
                    existe = true;
                } // Fin If
            }// Fin For
            String tipo_de_dato;
            int longitud;
            tipo_de_dato = (String) CB_TipoDeDatoDelCampo.getSelectedItem();
            longitud = Integer.parseInt(SP_LongitudDelCampo.getValue().toString());
            boolean llave_primaria = false;
            boolean llave_secundaria = false;
            if (RB_LlavePrimariaDelCampo.isSelected() == true && RB_LlaveSecundariaDelCampo.isSelected() == true) {
                llave_primaria = true;
                llave_secundaria = true;
            } else if (RB_LlavePrimariaDelCampo.isSelected() == false && RB_LlaveSecundariaDelCampo.isSelected() == true) {
                llave_primaria = false;
                llave_secundaria = true;
            } else if (RB_LlavePrimariaDelCampo.isSelected() == true && RB_LlaveSecundariaDelCampo.isSelected() == false) {
                llave_primaria = true;
                llave_secundaria = false;
            } // Fin If
            int ID_campo, ID_archivo;
            ID_campo = GenerarIDCampo();
            ID_archivo = archivo_actual.getID();
            Campo campo_nuevo = new Campo(ID_campo, ID_archivo, nombre, tipo_de_dato, longitud, llave_primaria, llave_secundaria);
            if (campos_nuevos.isEmpty()) {
                if (nombre.equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para el campo");
                    TF_NombreDelCampo.setText("");
                    CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                    SP_LongitudDelCampo.setValue(1);
                    RB_LlavePrimariaDelCampo.setSelected(false);
                    RB_LlaveSecundariaDelCampo.setSelected(false);
                } else if (llave_primaria == false) {
                    JOptionPane.showMessageDialog(null, "El primer campo ingresado debe ser una llave primaria");
                    TF_NombreDelCampo.setText("");
                    CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                    SP_LongitudDelCampo.setValue(1);
                    RB_LlavePrimariaDelCampo.setSelected(false);
                    RB_LlaveSecundariaDelCampo.setSelected(false);
                } else if (llave_primaria == true && llave_secundaria == true) {
                    JOptionPane.showMessageDialog(null, "No se puede seleccionar que sea llave primaria y secundaria a la vez");
                    TF_NombreDelCampo.setText("");
                    CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                    SP_LongitudDelCampo.setValue(1);
                    RB_LlavePrimariaDelCampo.setSelected(false);
                    RB_LlaveSecundariaDelCampo.setSelected(false);
                } else if (longitud < 1) {
                    JOptionPane.showMessageDialog(null, "La longitud del campo no puede ser negativa");
                    TF_NombreDelCampo.setText("");
                    CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                    SP_LongitudDelCampo.setValue(1);
                    RB_LlavePrimariaDelCampo.setSelected(false);
                    RB_LlaveSecundariaDelCampo.setSelected(false);
                } else {
                    campo_actual = campo_nuevo;
                    campos_nuevos.add(campo_nuevo);
                    añadir_campo_txt(campo_nuevo);
                    TF_NombreDelCampo.setText("");
                    CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                    SP_LongitudDelCampo.setValue(1);
                    for (int i = 0; i < campos_nuevos.size(); i++) {
                        if (campos_nuevos.get(i).isLlavePrimaria()) {
                            RB_LlavePrimariaDelCampo.setEnabled(false);
                        } // Fin If
                    } // Fin For
                    for (int i = 0; i < campos_nuevos.size(); i++) {
                        if (campos_nuevos.get(i).isLlave_secundaria()) {
                            RB_LlaveSecundariaDelCampo.setEnabled(false);
                        } // Fin If
                    } // Fin For
                    RB_LlavePrimariaDelCampo.setSelected(false);
                    RB_LlaveSecundariaDelCampo.setSelected(false);
                    secreo = true;
                } // Fin If
            } else {
                if (existe == false) {
                    if (nombre.equals("")) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para el campo");
                        TF_NombreDelCampo.setText("");
                        CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                        SP_LongitudDelCampo.setValue(1);
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlavePrimaria()) {
                                RB_LlavePrimariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlave_secundaria()) {
                                RB_LlaveSecundariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        RB_LlavePrimariaDelCampo.setSelected(false);
                        RB_LlaveSecundariaDelCampo.setSelected(false);
                    } else if (llave_primaria == true && llave_secundaria == true) {
                        JOptionPane.showMessageDialog(null, "No se puede seleccionar que sea llave primaria y secundaria a la vez");
                        TF_NombreDelCampo.setText("");
                        CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                        SP_LongitudDelCampo.setValue(1);
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlavePrimaria()) {
                                RB_LlavePrimariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlave_secundaria()) {
                                RB_LlaveSecundariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        RB_LlavePrimariaDelCampo.setSelected(false);
                        RB_LlaveSecundariaDelCampo.setSelected(false);
                    } else if (longitud < 1) {
                        JOptionPane.showMessageDialog(null, "La longitud del campo no puede ser negativa");
                        TF_NombreDelCampo.setText("");
                        CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                        SP_LongitudDelCampo.setValue(1);
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlavePrimaria()) {
                                RB_LlavePrimariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlave_secundaria()) {
                                RB_LlaveSecundariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        RB_LlavePrimariaDelCampo.setSelected(false);
                        RB_LlaveSecundariaDelCampo.setSelected(false);
                    } else {
                        campo_actual = campo_nuevo;
                        campos_nuevos.add(campo_nuevo);
                        añadir_campo_txt(campo_nuevo);
                        TF_NombreDelCampo.setText("");
                        CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                        SP_LongitudDelCampo.setValue(1);
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlavePrimaria()) {
                                RB_LlavePrimariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        for (int i = 0; i < campos_nuevos.size(); i++) {
                            if (campos_nuevos.get(i).isLlave_secundaria()) {
                                RB_LlaveSecundariaDelCampo.setEnabled(false);
                            } // Fin If
                        } // Fin For
                        RB_LlavePrimariaDelCampo.setSelected(false);
                        RB_LlaveSecundariaDelCampo.setSelected(false);
                        secreo = true;
                    } // Fin If
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede crear el campo porque ya existe un campo con el mismo nombre");
                    TF_NombreDelCampo.setText("");
                    CB_TipoDeDatoDelCampo.setSelectedIndex(0);
                    SP_LongitudDelCampo.setValue(1);
                    for (int i = 0; i < campos_nuevos.size(); i++) {
                        if (campos_nuevos.get(i).isLlavePrimaria()) {
                            RB_LlavePrimariaDelCampo.setEnabled(false);
                        } // Fin If
                    } // Fin For
                    for (int i = 0; i < campos_nuevos.size(); i++) {
                        if (campos_nuevos.get(i).isLlave_secundaria()) {
                            RB_LlaveSecundariaDelCampo.setEnabled(false);
                        } // Fin If
                    } // Fin For
                    RB_LlavePrimariaDelCampo.setSelected(false);
                    RB_LlaveSecundariaDelCampo.setSelected(false);
                } // Fin If
            } // Fin If
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // Actualiza el Text Area
            FileReader fr = null;
            BufferedReader br = null;
            fr = new FileReader(archivo_actual.getArchivo());
            br = new BufferedReader(fr);
            TA_ArchivoAbierto.setText("");
            String linea;
            while ((linea = br.readLine()) != null) {
                TA_ArchivoAbierto.append(linea);
            } // Fin While
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
            // Actualiza el file dentro del archivo binario
            EscribirCamposBinario();
            formatear_CBbox_Modificar();
            formatear_CBbox_borrar();

            if (secreo == true || semodifico == true || seborro == true) {
                JOptionPane.showMessageDialog(null, "Archivo Salvado Exitosamente");
            } // Fin If
            secreo = false;
            semodifico = false;
            seborro = false;
            salvado = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (CB_CampoAModificar.getSelectedIndex() >= 1) {
            try {
                salvado = true;
                boolean existe = false;
                String nombre;
                int longitud;
                String tipo_de_dato;
                boolean llave_primaria = false;
                boolean llave_secundaria = false;
                nombre = TF_NombreDelCampoModificado.getText();
                // VALIDACION QUE SE PUEDE BORRAR O CAMBIAR
                for (int i = 0; i < campos_nuevos.size(); i++) {
                    if (i != CB_CampoAModificar.getSelectedIndex() - 1) {
                        if (campos_nuevos.get(i).getNombre().equals(nombre)) {
                            existe = true;
                        } // Fin If
                    } // Fin If
                } // Fin For
                tipo_de_dato = (String) CB_TipoDeDatoDelCampoModificado.getSelectedItem();
                longitud = Integer.parseInt(SP_LongitudDelCampoModificado.getValue().toString());
                if (RB_LlavePrimariaDelCampoModificado.isSelected()) {
                    llave_primaria = true;
                } // Fin If
                if (RB_LlaveSecundariaDelCampoModificado.isSelected()) {
                    llave_secundaria = true;
                } // Fin If
                if (existe == false) {
                    if (nombre.equals("")) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para el campo");
                        TF_NombreDelCampoModificado.setText("");
                        CB_TipoDeDatoDelCampoModificado.setSelectedIndex(0);
                        SP_LongitudDelCampoModificado.setValue(1);
                        RB_LlavePrimariaDelCampoModificado.setSelected(false);
                        RB_LlaveSecundariaDelCampoModificado.setSelected(false);
                        CB_CampoAModificar.setSelectedIndex(0);
                    } else if (longitud < 1) {
                        JOptionPane.showMessageDialog(null, "La longitud de un campo no puede ser negativa");
                        TF_NombreDelCampoModificado.setText("");
                        CB_TipoDeDatoDelCampoModificado.setSelectedIndex(0);
                        SP_LongitudDelCampoModificado.setValue(1);
                        RB_LlavePrimariaDelCampoModificado.setSelected(false);
                        RB_LlaveSecundariaDelCampoModificado.setSelected(false);
                        CB_CampoAModificar.setSelectedIndex(0);
                    } else {
                        for (Campo campo : campos_nuevos) {
                            if (campo.getID() == campo_actual.getID()) {
                                campo.setNombre(nombre);
                                campo.setTipo_de_dato(tipo_de_dato);
                                campo.setLongitud(longitud);
                                campo.setLlaveprimaria(llave_primaria);
                                campo.setLlave_secundaria(llave_secundaria);
                            } // Fin If
                        } // Fin For
                        formatear_CBbox_Modificar();
                        formatear_CBbox_borrar();
                        cambios_txt();
                        TF_NombreDelCampoModificado.setText("");
                        CB_TipoDeDatoDelCampoModificado.setSelectedIndex(0);
                        SP_LongitudDelCampoModificado.setValue(1);
                        RB_LlavePrimariaDelCampoModificado.setSelected(false);
                        RB_LlaveSecundariaDelCampoModificado.setSelected(false);
                        CB_CampoAModificar.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(this, "¡Se ha modificado el campo exitosamente!");
                        semodifico = true;
                    } // Fin If
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede modificar el campo porque ya existe un campo con el mismo nombre");
                    TF_NombreDelCampoModificado.setText("");
                    CB_TipoDeDatoDelCampoModificado.setSelectedIndex(0);
                    SP_LongitudDelCampoModificado.setValue(1);
                    RB_LlavePrimariaDelCampoModificado.setSelected(false);
                    RB_LlaveSecundariaDelCampoModificado.setSelected(false);
                    CB_CampoAModificar.setSelectedIndex(0);
                } // Fin If
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
        } else {
            JOptionPane.showMessageDialog(this, "Porfavor seleccione un campo para que sea modificado");
        }
    }//GEN-LAST:event_jButton10ActionPerformed
    public void cambios_txt() {
        // Forma de Escribir:
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            String linea = "";
            for (int i = 0; i < campos_nuevos.size(); i++) {
                linea += campos_nuevos.get(i).campo_para_archivo();
            } // Fin For
            fw = new FileWriter(archivo_actual.getArchivo());
            bw = new BufferedWriter(fw);
            bw.write(linea);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } // Fin Try Catch
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (CB_CampoABorrar.getSelectedIndex() > 0) {
            try {
                boolean llave_primaria = false;
                for (int i = 0; i < campos_nuevos.size(); i++) {
                    if (campos_nuevos.get(i).getID() == campo_actual.getID()) {
                        llave_primaria = campos_nuevos.get(i).isLlavePrimaria();
                    } // Fin If              
                } // Fin For
                if (llave_primaria) {
                    JOptionPane.showMessageDialog(this, "No se puede eliminar el campo debido a que es llave primaria");
                    CB_CampoABorrar.setSelectedIndex(0);
                } else {
                    salvado = true;
                    for (int i = 0; i < campos_nuevos.size(); i++) {
                        if (campos_nuevos.get(i).getID() == campo_actual.getID()) {
                            campos_nuevos.remove(i);
                        } // Fin If              
                    } // Fin For
                    cambios_txt();
                    seborro = true;
                    formatear_CBbox_Modificar();
                    formatear_CBbox_borrar();
                    JOptionPane.showMessageDialog(this, "¡Se ha eliminado el campo exitosamente!");
                } // Fin If
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
        } else {
            JOptionPane.showMessageDialog(this, "Porfavor seleccione un campo para que sea eliminado");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        TA_ListarCampos1.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JD_RegistroNuevo.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jb_crearRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_crearRegistroActionPerformed


    }//GEN-LAST:event_jb_crearRegistroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JD_Listar.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        listar_campos();
//        this.setVisible(false);
//        JD_Listar.setVisible(false);
//        JD_Listar.pack();
//        JD_Listar.setLocationRelativeTo(this);
//        JD_Listar.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void CB_CampoAModificarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_CampoAModificarItemStateChanged
        try {
            Campo campo_modificar;
            String nombre_campo_modificar;
            nombre_campo_modificar = (String) CB_CampoAModificar.getSelectedItem();
            campo_modificar = MatchNombreCampo(nombre_campo_modificar);
            if (campo_modificar != null) {
                TF_NombreDelCampoModificado.setText(campo_modificar.getNombre());
                CB_TipoDeDatoDelCampoModificado.setSelectedItem(campo_modificar.getTipo_de_dato());
                SP_LongitudDelCampoModificado.setValue(campo_modificar.getLongitud());
                RB_LlavePrimariaDelCampoModificado.setSelected(campo_modificar.isLlavePrimaria());
                RB_LlaveSecundariaDelCampoModificado.setSelected(campo_modificar.isLlave_secundaria());
                campo_actual = campo_modificar;
                boolean hayllaveSecundaria = false;
                for (int i = 0; i < campos_nuevos.size(); i++) {
                    if (campos_nuevos.get(i).isLlave_secundaria()) {
                        hayllaveSecundaria = true;
                    } // Fin If
                } // Fin For
                if (hayllaveSecundaria == true && campo_modificar.isLlave_secundaria() == true) {
                    RB_LlaveSecundariaDelCampoModificado.setEnabled(true);
                } else if (hayllaveSecundaria == true && campo_modificar.isLlave_secundaria() == false) {
                    RB_LlaveSecundariaDelCampoModificado.setEnabled(false);
                } else {
                    RB_LlaveSecundariaDelCampoModificado.setEnabled(true);
                } // Fin If
                if (campo_modificar.isLlavePrimaria()) {
                    RB_LlaveSecundariaDelCampoModificado.setEnabled(false);
                } // Fin If
            } // Fin If 
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
    }//GEN-LAST:event_CB_CampoAModificarItemStateChanged
    public Campo MatchNombreCampo(String name) {
        for (Campo campos : campos_nuevos) {
            if (campos.getNombre().equals(name)) {
                return campos;
            } // Fin If
        } // Fin For
        return null;
    } // Fin Match Nombre Campo
    private void CB_CampoABorrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_CampoABorrarItemStateChanged
        // ACTUALIZA LA INFORMACIÓN EN EL JDIALOG CON CADA SELECCION
        try {
            Campo campo_borrar;
            String nombre_campo_borrar;
            nombre_campo_borrar = (String) CB_CampoABorrar.getSelectedItem();
            campo_borrar = MatchNombreCampo(nombre_campo_borrar);
            if (campo_borrar != null) {
                campo_actual = campo_borrar;
            } // Fin If
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
    }//GEN-LAST:event_CB_CampoABorrarItemStateChanged

    private void btn_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseClicked
        // Hace todo lo que equivale a salvar archivo , pero es un acceso directo
          try {
            // Actualiza el Text Area
            FileReader fr = null;
            BufferedReader br = null;
            fr = new FileReader(archivo_actual.getArchivo());
            br = new BufferedReader(fr);
            TA_ArchivoAbierto.setText("");
            String linea;
            while ((linea = br.readLine()) != null) {
                TA_ArchivoAbierto.append(linea);
            } // Fin While
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
            // Actualiza el file dentro del archivo binario
            EscribirCamposBinario();
            formatear_CBbox_Modificar();
            formatear_CBbox_borrar();

            if (secreo == true || semodifico == true || seborro == true) {
                JOptionPane.showMessageDialog(null, "Archivo Actualizado");
            } // Fin If
            secreo = false;
            semodifico = false;
            seborro = false;
            salvado = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_btn_actualizarMouseClicked

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
    private javax.swing.JComboBox<String> CB_CampoABorrar;
    private javax.swing.JComboBox<String> CB_CampoAModificar;
    private javax.swing.JComboBox<String> CB_TipoDeDatoDelCampo;
    private javax.swing.JComboBox<String> CB_TipoDeDatoDelCampoModificado;
    private javax.swing.JDialog JD_Crearcampo;
    private javax.swing.JDialog JD_Listar;
    private javax.swing.JDialog JD_ModificarEliminarCampos;
    private javax.swing.JDialog JD_RegistroNuevo;
    private javax.swing.JLabel JL_13;
    private javax.swing.JLabel JL_14;
    private javax.swing.ButtonGroup POS;
    private javax.swing.JRadioButton RB_LlavePrimariaDelCampo;
    private javax.swing.JRadioButton RB_LlavePrimariaDelCampoModificado;
    private javax.swing.JRadioButton RB_LlaveSecundariaDelCampo;
    private javax.swing.JRadioButton RB_LlaveSecundariaDelCampoModificado;
    private javax.swing.JSpinner SP_LongitudDelCampo;
    private javax.swing.JSpinner SP_LongitudDelCampoModificado;
    private javax.swing.JTextArea TA_ArchivoAbierto;
    private javax.swing.JTextArea TA_ListarCampos;
    private javax.swing.JTextArea TA_ListarCampos1;
    private javax.swing.JTextField TF_NombreDelCampo;
    private javax.swing.JTextField TF_NombreDelCampoModificado;
    private javax.swing.ButtonGroup TipoDato;
    private javax.swing.ButtonGroup TipoDatoModificar;
    private javax.swing.ButtonGroup TipoLLaveModificar;
    private javax.swing.ButtonGroup TipoLlave;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
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
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jb_crearRegistro;
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
    private javax.swing.JMenuItem jmi_Nuevo_Archivo;
    private javax.swing.JMenuItem jmi_Salir;
    private javax.swing.JMenuItem jmi_Salvar_Archivo;
    private javax.swing.JMenuItem jmi_crearindices;
    private javax.swing.JMenuItem jmi_modreg;
    private javax.swing.JMenuItem jmi_reindexar;
    private javax.swing.JTable jt_campos;
    // End of variables declaration//GEN-END:variables
private Administrar_Archivos aa = new Administrar_Archivos("./Archivos.dmo");
    private Archivo archivo_actual;
    private String GuardarArchivo;
    private ArrayList<Campo> campos_nuevos = new ArrayList();
    private Adminarboles arboles = new Adminarboles("./Arboles.txt");
    private BTree arbol_actual = null;
    private Admin_arbolsecundario arbolessecundarios = new Admin_arbolsecundario("./Arboles_secundarios.txt");
    private BTree arbol_secundarioactual;
    private boolean salvado = false;
    private Campo campo_actual;
    private boolean semodifico = false;
    private boolean secreo = false;
    private boolean seborro = false;
    Random random = new Random();
}
