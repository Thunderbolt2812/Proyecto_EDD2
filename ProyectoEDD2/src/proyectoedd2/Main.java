package proyectoedd2;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.io.RandomAccessFile;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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
//                    JOptionPane.showMessageDialog(null, "El archivo se abri?? con ??xito");
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
        RB_LlavePrimariaDelCampo = new javax.swing.JRadioButton();
        RB_LlaveSecundariaDelCampo = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        CB_TipoDeDatoDelCampo = new javax.swing.JComboBox<>();
        JD_ModificarCampos = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        JL_13 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        CB_TipoDeDatoDelCampoModificado = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        SP_LongitudDelCampoModificado = new javax.swing.JSpinner();
        jPanel18 = new javax.swing.JPanel();
        RB_LlavePrimariaDelCampoModificado = new javax.swing.JRadioButton();
        RB_LlaveSecundariaDelCampoModificado = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        TF_NombreDelCampoModificado = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        CB_CampoAModificar = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        TipoDato = new javax.swing.ButtonGroup();
        TipoLlave = new javax.swing.ButtonGroup();
        TipoDatoModificar = new javax.swing.ButtonGroup();
        TipoLLaveModificar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_ArchivoAbierto = new javax.swing.JTextArea();
        POS = new javax.swing.ButtonGroup();
        JD_EliminarCampos = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        CB_CampoABorrar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        JD_Agregar_registro = new javax.swing.JDialog();
        jPanel23 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        JL_28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTbl_tablaRegistros = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        JD_Modificar_registro = new javax.swing.JDialog();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        CB_LlavesModificarRegistro = new javax.swing.JComboBox<>();
        TF_LlaveModificarRegistro = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaModificarRegistro = new javax.swing.JTable();
        JD_Eliminar_registro = new javax.swing.JDialog();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jCb_llavesEliminarRegistros = new javax.swing.JComboBox<>();
        jTf_LLaveEliminarRegistros = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TablaEliminarRegistro = new javax.swing.JTable();
        JD_Cruzar_Archivo = new javax.swing.JDialog();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        Btn_abrir_archivo = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTbl_CamposParaCruceSelecionar = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTbl_CamposCruzados = new javax.swing.JTable();
        JD_Buscar_registro = new javax.swing.JDialog();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        CB_LlavesBuscarRegistros = new javax.swing.JComboBox<>();
        jTf_buscarRegistros = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaBuscarRegistro = new javax.swing.JTable();
        JD_Listar_registros = new javax.swing.JDialog();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTbl_ListarRegistros1 = new javax.swing.JTable();
        jPanel50 = new javax.swing.JPanel();
        jButton23 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
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
        jmi_Mod_Campo = new javax.swing.JMenuItem();
        jmi_Borrar_Campo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jm_Registros = new javax.swing.JMenu();
        jmi_Crear_Registro = new javax.swing.JMenuItem();
        jmi_Borrar_Registro = new javax.swing.JMenuItem();
        jmi_Buscar_Registro = new javax.swing.JMenuItem();
        jmi_modreg = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
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

        SP_LongitudDelCampo.setEnabled(false);

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

        RB_LlavePrimariaDelCampo.setBackground(new java.awt.Color(255, 255, 255));
        RB_LlavePrimariaDelCampo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlavePrimariaDelCampo.setText("Llave Primaria");
        RB_LlavePrimariaDelCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_LlavePrimariaDelCampoActionPerformed(evt);
            }
        });

        RB_LlaveSecundariaDelCampo.setBackground(new java.awt.Color(255, 255, 255));
        RB_LlaveSecundariaDelCampo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlaveSecundariaDelCampo.setText("Llave Secundaria");
        RB_LlaveSecundariaDelCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_LlaveSecundariaDelCampoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(RB_LlavePrimariaDelCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(RB_LlaveSecundariaDelCampo)
                    .addGap(53, 53, 53)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
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
        CB_TipoDeDatoDelCampo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_TipoDeDatoDelCampoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CB_TipoDeDatoDelCampo, 0, 356, Short.MAX_VALUE)
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
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(SP_LongitudDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_NombreDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(TF_NombreDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(SP_LongitudDelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(147, 147, 147))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(24, 24, 24))
        );

        JL_13.setText("Seleccione el campo que le gustar??a modificar:");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de dato"));

        CB_TipoDeDatoDelCampoModificado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_TipoDeDatoDelCampoModificado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "int", "double", "char", "string" }));
        CB_TipoDeDatoDelCampoModificado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        CB_TipoDeDatoDelCampoModificado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_TipoDeDatoDelCampoModificadoItemStateChanged(evt);
            }
        });

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

        SP_LongitudDelCampoModificado.setEnabled(false);

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

        RB_LlavePrimariaDelCampoModificado.setBackground(new java.awt.Color(255, 255, 255));
        RB_LlavePrimariaDelCampoModificado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlavePrimariaDelCampoModificado.setText("Llave Primaria");

        RB_LlaveSecundariaDelCampoModificado.setBackground(new java.awt.Color(255, 255, 255));
        RB_LlaveSecundariaDelCampoModificado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RB_LlaveSecundariaDelCampoModificado.setText("Llave Secundaria");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
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
                    .addContainerGap(10, Short.MAX_VALUE)))
        );

        jPanel19.setBackground(new java.awt.Color(232, 231, 231));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Campo Actual: ");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));

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
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_CampoAModificar, 0, 349, Short.MAX_VALUE))
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
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(CB_CampoAModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(TF_NombreDelCampoModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addComponent(JL_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(309, 309, 309))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addContainerGap(132, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout JD_ModificarCamposLayout = new javax.swing.GroupLayout(JD_ModificarCampos.getContentPane());
        JD_ModificarCampos.getContentPane().setLayout(JD_ModificarCamposLayout);
        JD_ModificarCamposLayout.setHorizontalGroup(
            JD_ModificarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_ModificarCamposLayout.createSequentialGroup()
                .addGroup(JD_ModificarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JD_ModificarCamposLayout.setVerticalGroup(
            JD_ModificarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_ModificarCamposLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TA_ArchivoAbierto.setColumns(20);
        TA_ArchivoAbierto.setRows(5);
        TA_ArchivoAbierto.setEnabled(false);
        jScrollPane1.setViewportView(TA_ArchivoAbierto);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));

        jLabel23.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Eliminar Campo");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(24, 24, 24))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione el campo que le gustar??a borrar"));

        CB_CampoABorrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_CampoABorrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        CB_CampoABorrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_CampoABorrarItemStateChanged(evt);
            }
        });

        jLabel5.setText("Campo Eliminar:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CB_CampoABorrar, 0, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CB_CampoABorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton11.setText("Eliminar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton11))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jPanel28.setBackground(new java.awt.Color(0, 153, 153));

        jLabel24.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Agregar Nuevo Registro");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel24)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        JL_28.setText("Ingrese los datos dentro de la siguiente tabla: ");

        jTbl_tablaRegistros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTbl_tablaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTbl_tablaRegistros);

        jPanel29.setBackground(new java.awt.Color(0, 153, 153));

        jButton6.setText("Regresar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setText("Agregar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton12))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_28)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JL_28)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout JD_Agregar_registroLayout = new javax.swing.GroupLayout(JD_Agregar_registro.getContentPane());
        JD_Agregar_registro.getContentPane().setLayout(JD_Agregar_registroLayout);
        JD_Agregar_registroLayout.setHorizontalGroup(
            JD_Agregar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_Agregar_registroLayout.setVerticalGroup(
            JD_Agregar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jPanel31.setBackground(new java.awt.Color(0, 153, 153));

        jLabel25.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Modificar Registro");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel25)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese la llave del registro a modificar: "));

        CB_LlavesModificarRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_LlavesModificarRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        CB_LlavesModificarRegistro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_LlavesModificarRegistroItemStateChanged(evt);
            }
        });

        TF_LlaveModificarRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(CB_LlavesModificarRegistro, 0, 203, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(TF_LlaveModificarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_LlavesModificarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_LlaveModificarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel34.setBackground(new java.awt.Color(0, 153, 153));

        jButton13.setText("Buscar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Regresar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Aceptar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton13)
                .addGap(26, 26, 26)
                .addComponent(jButton15)
                .addGap(29, 29, 29)
                .addComponent(jButton14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique el registro en la tabla"));

        TablaModificarRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(TablaModificarRegistro);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JD_Modificar_registroLayout = new javax.swing.GroupLayout(JD_Modificar_registro.getContentPane());
        JD_Modificar_registro.getContentPane().setLayout(JD_Modificar_registroLayout);
        JD_Modificar_registroLayout.setHorizontalGroup(
            JD_Modificar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_Modificar_registroLayout.setVerticalGroup(
            JD_Modificar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jPanel36.setBackground(new java.awt.Color(0, 153, 153));

        jLabel26.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Eliminar Registro");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel26)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(0, 153, 153));

        jButton16.setText("Buscar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Regresar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Aceptar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton16)
                .addGap(26, 26, 26)
                .addComponent(jButton18)
                .addGap(29, 29, 29)
                .addComponent(jButton17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la llave del registro a eliminar"));

        jCb_llavesEliminarRegistros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCb_llavesEliminarRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jCb_llavesEliminarRegistros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCb_llavesEliminarRegistrosItemStateChanged(evt);
            }
        });

        jTf_LLaveEliminarRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jCb_llavesEliminarRegistros, 0, 253, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jTf_LLaveEliminarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTf_LLaveEliminarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCb_llavesEliminarRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addGap(39, 39, 39)))
        );

        TablaEliminarRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaEliminarRegistro.setEnabled(false);
        jScrollPane11.setViewportView(TablaEliminarRegistro);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Eliminar_registroLayout = new javax.swing.GroupLayout(JD_Eliminar_registro.getContentPane());
        JD_Eliminar_registro.getContentPane().setLayout(JD_Eliminar_registroLayout);
        JD_Eliminar_registroLayout.setHorizontalGroup(
            JD_Eliminar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_Eliminar_registroLayout.setVerticalGroup(
            JD_Eliminar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jPanel41.setBackground(new java.awt.Color(0, 153, 153));

        jLabel27.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Cruzar Archivos");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel27)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel42.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(0, 153, 153));

        Btn_abrir_archivo.setText("Abrir Archivo");
        Btn_abrir_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_abrir_archivoActionPerformed(evt);
            }
        });

        jButton24.setText("Mostrar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton19.setText("Regresar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton25.setText("A??adir");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("Cruzar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_abrir_archivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(Btn_abrir_archivo)
                .addGap(32, 32, 32)
                .addComponent(jButton24)
                .addGap(18, 18, 18)
                .addComponent(jButton25)
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addGap(18, 18, 18)
                .addComponent(jButton19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Elige el campo que deseas cruzar"));
        jPanel22.setForeground(new java.awt.Color(51, 51, 51));

        jTbl_CamposParaCruceSelecionar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane13.setViewportView(jTbl_CamposParaCruceSelecionar);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Campos Cruzados"));
        jPanel24.setForeground(new java.awt.Color(51, 51, 51));

        jTbl_CamposCruzados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane14.setViewportView(jTbl_CamposCruzados);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JD_Cruzar_ArchivoLayout = new javax.swing.GroupLayout(JD_Cruzar_Archivo.getContentPane());
        JD_Cruzar_Archivo.getContentPane().setLayout(JD_Cruzar_ArchivoLayout);
        JD_Cruzar_ArchivoLayout.setHorizontalGroup(
            JD_Cruzar_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_Cruzar_ArchivoLayout.setVerticalGroup(
            JD_Cruzar_ArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        jPanel44.setBackground(new java.awt.Color(0, 153, 153));

        jLabel28.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Buscar Registro ");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel28)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel45.setBackground(new java.awt.Color(0, 153, 153));

        jButton20.setText("Buscar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Regresar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton20)
                .addGap(87, 87, 87)
                .addComponent(jButton21)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la llave del registro a Modificar"));

        CB_LlavesBuscarRegistros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CB_LlavesBuscarRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        CB_LlavesBuscarRegistros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_LlavesBuscarRegistrosItemStateChanged(evt);
            }
        });

        jTf_buscarRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel46Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CB_LlavesBuscarRegistros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jTf_buscarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel46Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CB_LlavesBuscarRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(jTf_buscarRegistros, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        TablaBuscarRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaBuscarRegistro.setEnabled(false);
        jScrollPane7.setViewportView(TablaBuscarRegistro);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_Buscar_registroLayout = new javax.swing.GroupLayout(JD_Buscar_registro.getContentPane());
        JD_Buscar_registro.getContentPane().setLayout(JD_Buscar_registroLayout);
        JD_Buscar_registroLayout.setHorizontalGroup(
            JD_Buscar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_Buscar_registroLayout.setVerticalGroup(
            JD_Buscar_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));

        jPanel49.setBackground(new java.awt.Color(0, 153, 153));

        jLabel29.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Listar Registros");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel29)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTbl_ListarRegistros1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(jTbl_ListarRegistros1);

        jPanel50.setBackground(new java.awt.Color(0, 153, 153));

        jButton23.setText("Regresar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jButton23)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jPanel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout JD_Listar_registrosLayout = new javax.swing.GroupLayout(JD_Listar_registros.getContentPane());
        JD_Listar_registros.getContentPane().setLayout(JD_Listar_registrosLayout);
        JD_Listar_registrosLayout.setHorizontalGroup(
            JD_Listar_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_Listar_registrosLayout.setVerticalGroup(
            JD_Listar_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16))
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
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton22.setText("PersonFile");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
        });
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

        jmi_Mod_Campo.setText("Modificar Campos");
        jmi_Mod_Campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_Mod_CampoActionPerformed(evt);
            }
        });
        jmi_Campos.add(jmi_Mod_Campo);

        jmi_Borrar_Campo.setText("Eliminar Campos");
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

        jMenuItem3.setText("Cruzar archivos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jm_Registros.add(jMenuItem3);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                    JOptionPane.showMessageDialog(null, "??Se ha creado su archivo exitosamente!");
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
        jmi_Mod_Campo.setEnabled(true);
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
        // ACTUALIZA EL TEXT AREA QUE MUESTRA EL ARCHIVO
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
                if (JOptionPane.showConfirmDialog(null, "??Desea salvar los cambios en el archivo?", "Confirmaci??n", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
                    JOptionPane.showMessageDialog(this, "??Se ha guardado el archivo exitosamente!");
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
//            if (JOptionPane.showConfirmDialog(null, "??Desea utilizar un archivo de prueba?", "Confirmaci??n", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
        jmi_Mod_Campo.setEnabled(true);
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
        try {
            TF_NombreDelCampo.setText("");
            CB_TipoDeDatoDelCampo.setSelectedIndex(0);
            SP_LongitudDelCampo.setValue(1);
            RB_LlavePrimariaDelCampo.setSelected(false);
            RB_LlaveSecundariaDelCampo.setSelected(false);
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
            this.setVisible(false);
            JD_Crearcampo.setVisible(false);
            JD_Crearcampo.pack();
            JD_Crearcampo.setLocationRelativeTo(this);
            JD_Crearcampo.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jmi_Crear_CampoActionPerformed

    private void jmi_Mod_CampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Mod_CampoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JD_ModificarCampos.setVisible(false);
        JD_ModificarCampos.pack();
        JD_ModificarCampos.setLocationRelativeTo(this);
        JD_ModificarCampos.setVisible(true);
    }//GEN-LAST:event_jmi_Mod_CampoActionPerformed

    private void jmi_Crear_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Crear_RegistroActionPerformed
        jTbl_tablaRegistros.setModel(new DefaultTableModel());
        DefaultTableModel model = (DefaultTableModel) jTbl_tablaRegistros.getModel();
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            model.addColumn(archivo_actual.getCampos().get(i).getNombre());
        } // Fin For
        model.setNumRows(1);
        this.setVisible(false);
        JD_Agregar_registro.setVisible(false);
        JD_Agregar_registro.pack();
        JD_Agregar_registro.setLocationRelativeTo(this);
        JD_Agregar_registro.setVisible(true);

    }//GEN-LAST:event_jmi_Crear_RegistroActionPerformed

    private void jmi_Borrar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Borrar_RegistroActionPerformed
        if (!(arbol_actual == null)) {
            TablaModificarRegistro.setModel(new DefaultTableModel());
            DefaultTableModel model = (DefaultTableModel) TablaModificarRegistro.getModel();
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                model.addColumn(archivo_actual.getCampos().get(i).getNombre());
            } // Fin For
            CB_LlavesModificarRegistro.setModel(new DefaultComboBoxModel<>());
            CB_LlavesModificarRegistro.addItem(archivo_actual.getCampos().get(0).getNombre());
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                    CB_LlavesModificarRegistro.addItem(archivo_actual.getCampos().get(i).getNombre());
                    break;
                } // Fin If
            } // Fin For
            this.setVisible(false);
            JD_Modificar_registro.setVisible(false);
            JD_Modificar_registro.pack();
            JD_Modificar_registro.setLocationRelativeTo(this);
            JD_Modificar_registro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Aun no existen registros creados");
        }

    }//GEN-LAST:event_jmi_Borrar_RegistroActionPerformed

    private void jmi_Buscar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Buscar_RegistroActionPerformed
        if (!(arbol_actual == null)) {
            DefaultTableModel modelo = new DefaultTableModel();
            TablaBuscarRegistro.setModel(new DefaultTableModel());
            DefaultTableModel model = (DefaultTableModel) TablaBuscarRegistro.getModel();
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                model.addColumn(archivo_actual.getCampos().get(i).getNombre());
            } // Fin For
            jTbl_tablaRegistros.setModel(modelo);
            CB_LlavesBuscarRegistros.setModel(new DefaultComboBoxModel<>());
            CB_LlavesBuscarRegistros.addItem(archivo_actual.getCampos().get(0).getNombre());
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                    CB_LlavesBuscarRegistros.addItem(archivo_actual.getCampos().get(i).getNombre());
                    break;
                } // Fin If
            } // Fin For
            jTf_buscarRegistros.setText("");
            this.setVisible(false);
            JD_Buscar_registro.setVisible(false);
            JD_Buscar_registro.pack();
            JD_Buscar_registro.setLocationRelativeTo(this);
            JD_Buscar_registro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tienes registros guardados en estos momentos");
        }

    }//GEN-LAST:event_jmi_Buscar_RegistroActionPerformed

    private void jmi_modregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_modregActionPerformed
        if (!(arbol_actual == null)) {
            DefaultTableModel model = new DefaultTableModel();
            TablaEliminarRegistro.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{}));
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                model.addColumn(archivo_actual.getCampos().get(i).getNombre());
            } // Fin For
            jCb_llavesEliminarRegistros.setModel(new DefaultComboBoxModel<>());
            jCb_llavesEliminarRegistros.addItem(archivo_actual.getCampos().get(0).getNombre());
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                    jCb_llavesEliminarRegistros.addItem(archivo_actual.getCampos().get(i).getNombre());
                    break;
                } // Fin If
            } // Fin For
            jTf_LLaveEliminarRegistros.setText("");
            TablaEliminarRegistro.setModel(model);
            this.setVisible(false);
            JD_Eliminar_registro.setVisible(false);
            JD_Eliminar_registro.pack();
            JD_Eliminar_registro.setLocationRelativeTo(this);
            JD_Eliminar_registro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No tienes registros guardados en estos momentos.");
        }

    }//GEN-LAST:event_jmi_modregActionPerformed

    private void jmi_crearindicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_crearindicesActionPerformed
        arbolessecundarios.cargarArchivo();
        boolean arbolseccreado = false;
        int posllave_secundaria = 0;
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                posllave_secundaria = i;
            } // Fin If
        } // Fin For
        for (int i = 0; i < arbolessecundarios.getListaarboles().size(); i++) {
            if (arbolessecundarios.getListaarboles().get(i).getIDArchivoActual() == archivo_actual.getID()) {
                arbolseccreado = true;
                arbol_secundarioactual = arbolessecundarios.getListaarboles().get(i).getArbolSecundario();
                break;
            } // Fin If
        } // Fin For
        if (arbolseccreado == false) {
            arbolessecundarios.cargarArchivo();
            Archivoarbolsecundario archivosecundario = new Archivoarbolsecundario(archivo_actual.getArchivo(), archivo_actual.getID(), new BTree(6));
            for (int i = 0; i < archivo_actual.getCant_Registros(); i++) {
                if (i == 0) {
                    try {
                        int rrn = 500;
                        String data = leerregistro(rrn);
                        String arr[] = data.split("\\|");
                        String llave = arr[posllave_secundaria];
                        if (archivo_actual.getCampos().get(posllave_secundaria).getTipo_de_dato().equals("int")) {
                            int num = archivo_actual.getCampos().get(posllave_secundaria).getLongitud() - llave.length();
                            llave = espacios.substring(0, num) + llave;
                        } // Fin If
                        archivosecundario.getArbolSecundario().B_Tree_Insert(llave, rrn);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } // Fin Try Catch
                } else {
                    try {
                        int rrn2 = (250 + (tam_registro() * i)) * 2;
                        String data;
                        data = leerregistro(rrn2);
                        String arr[] = data.split("\\|");
                        String llave = arr[posllave_secundaria];
                        if (archivo_actual.getCampos().get(posllave_secundaria).getTipo_de_dato().equals("int")) {
                            int num = archivo_actual.getCampos().get(posllave_secundaria).getLongitud() - llave.length();
                            llave = espacios.substring(0, num) + llave;
                        } // Fin If
                        archivosecundario.getArbolSecundario().B_Tree_Insert(llave, rrn2);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } // Fin Try Catch
                } // Fin If
            } // Fin For
            arbolessecundarios.getListaarboles().add(archivosecundario);
            arbol_secundarioactual = archivosecundario.getArbolSecundario();
            arbolessecundarios.escribirArchivo();
            JOptionPane.showMessageDialog(this, "Se crearon los indices nuevos");
        } else {
            JOptionPane.showMessageDialog(null, "Presione el boton reindexar par actualizar sus indices");
        }
        jmi_reindexar.setEnabled(true);
    }//GEN-LAST:event_jmi_crearindicesActionPerformed

    private void jmi_Exportar_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Exportar_ExcelActionPerformed
        rrn_llaves_en_orden = new ArrayList();
        Excel excel = new Excel();
        JFileChooser directorio = new JFileChooser("./");
        directorio.setApproveButtonText("Exportar");
        int seleccion = directorio.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo_excel = new File(directorio.getSelectedFile() + ".xls");
                excel.LlavesOrdenadas(arbol_actual.getRaiz(), rrn_llaves_en_orden, arbol_actual);
                JOptionPane.showMessageDialog(null, excel.Llenar(archivo_actual, archivo_excel, rrn_llaves_en_orden));
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jmi_Exportar_ExcelActionPerformed

    private void jmi_Exportrar_XMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Exportrar_XMLActionPerformed
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();
            String Nombre;
            Nombre = GuardarArchivo.substring(0, GuardarArchivo.length() - 4);
            Nombre = Nombre.replace(" ", "_");
            Element root = documento.createElement(Nombre);
            documento.appendChild(root);
            rrn_llaves_en_orden = new ArrayList();
            LlavesOrdenadas(arbol_actual.getRaiz(), rrn_llaves_en_orden, arbol_actual);
            for (int i = 0; i < rrn_llaves_en_orden.size(); i++) {
                long RRN = rrn_llaves_en_orden.get(i);
                String data = leerregistro(Math.toIntExact(RRN));
                String arr[] = data.split("\\|");
                Element row = documento.createElement("Registro");
                for (int j = 0; j < archivo_actual.getCampos().size(); j++) {
                    Element campo = documento.createElement(archivo_actual.getCampos().get(j).getNombre());
                    String insertar = arr[j];
                    Text dato = documento.createTextNode(insertar);
                    campo.appendChild(dato);
                    row.appendChild(campo);
                } // Fin For
                root.appendChild(row);
            } // Fin For
            Source source = new DOMSource(documento);
            String nameArchivo;
            nameArchivo = Nombre + ".xml";
            Result result = new StreamResult(new File(nameArchivo));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            JOptionPane.showMessageDialog(this, "??Exportaci??n Exitosa!");
            rrn_llaves_en_orden = new ArrayList();
        } catch (Exception e) {
            e.printStackTrace();
        } // Fin Try Catch
    }//GEN-LAST:event_jmi_Exportrar_XMLActionPerformed
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
    private void jmi_reindexarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_reindexarActionPerformed
        if (arbol_secundarioactual == null) {
        } else {
            JOptionPane.showMessageDialog(null, "Sus indices han sido actualizados");
        }
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

    void a??adir_campo_txt(Campo campo) {
        String linea = campo.campo_para_archivo();
        escribir_archivo_txt(linea);
        JOptionPane.showMessageDialog(this, "??Se ha creado el campo exitosamente!");
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
            if (tipo_de_dato.equals("int")) {
                longitud = 100;
            } else if (tipo_de_dato.equals("double")) {
                longitud = 100;
            } else if (tipo_de_dato.equals("char")) {
                longitud = 5;
            } else {
                longitud = Integer.parseInt(SP_LongitudDelCampo.getValue().toString());
            }
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
                    a??adir_campo_txt(campo_nuevo);
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
                        a??adir_campo_txt(campo_nuevo);
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
                if (tipo_de_dato.equals("int")) {
                    longitud = 100;
                } else if (tipo_de_dato.equals("double")) {
                    longitud = 100;
                } else if (tipo_de_dato.equals("char")) {
                    longitud = 5;
                } else {
                    longitud = Integer.parseInt(SP_LongitudDelCampoModificado.getValue().toString());
                }

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
                        JOptionPane.showMessageDialog(this, "??Se ha modificado el campo exitosamente!");
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
        if (!(arbol_actual == null)) {
            avanzar = 50;
            retroceder = 0;
            rrn_llaves_en_orden = new ArrayList();
            arbol_actual.BTree_KeysInOrder(arbol_actual.getRaiz(), rrn_llaves_en_orden);
            listar_registros();
        } else {
            JOptionPane.showMessageDialog(this, "No tienes registros guardados en estos momentos.");
        }
        this.setVisible(false);
        JD_Listar_registros.setVisible(false);
        JD_Listar_registros.pack();
        JD_Listar_registros.setLocationRelativeTo(this);
        JD_Listar_registros.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        TA_ListarCampos1.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private void jmi_Borrar_CampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_Borrar_CampoActionPerformed
        this.setVisible(false);
        JD_EliminarCampos.setVisible(false);
        JD_EliminarCampos.pack();
        JD_EliminarCampos.setLocationRelativeTo(this);
        JD_EliminarCampos.setVisible(true);
    }//GEN-LAST:event_jmi_Borrar_CampoActionPerformed

    private void CB_CampoABorrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_CampoABorrarItemStateChanged
        // ACTUALIZA LA INFORMACI??N EN EL JDIALOG CON CADA SELECCION
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
        }
    }//GEN-LAST:event_CB_CampoABorrarItemStateChanged

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
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
                    JOptionPane.showMessageDialog(this, "??Se ha eliminado el campo exitosamente!");
                } // Fin If
            } catch (Exception e) {
                e.printStackTrace();
            } // Fin Try Catch
        } else {
            JOptionPane.showMessageDialog(this, "Porfavor seleccione un campo para que sea eliminado");
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JD_EliminarCampos.dispose();
        this.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
                JOptionPane.showMessageDialog(null, "Actualizado");
            } // Fin If
            secreo = false;
            semodifico = false;
            seborro = false;
            salvado = false;
            listar_campos();
        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTbl_tablaRegistros.getModel();
        if (!ValidaciondeingresoTabla(jTbl_tablaRegistros, true)) {
            return;
        } // Fin If
        if (archivo_actual.getCant_Registros() == 0) {
            RandomAccessFile flujo;
            try {
                File archivo = archivo_actual.getArchivo();
                flujo = new RandomAccessFile(new File(archivo_actual.getArchivo().getAbsolutePath()), "rw");
                String metadata2;
                metadata2 = TA_ArchivoAbierto.getText();
                metadata2 += LlenadoEspacios(metadata2.length(), 250);
                StringBuffer sbmetadata = new StringBuffer(metadata2);
                sbmetadata.setLength(250);
                flujo.writeChars(sbmetadata.toString());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } // Fin Try Catch
        } // Fin If
        //Aqui es donde se guarda el registro a ingresar
        String guardar = "";
        arboles.cargarArchivo();
        // Esto es para los que ya estan creados en el arbol
        boolean omitidos = false;
        // Verifica si el arbol esta creado
        boolean arbolcreado = false;
        int getposarbol = 0;//agarra la posicion del arbol
        // Esto verifica que el arbol no exista
        for (int i = 0; i < arboles.getListaarboles().size(); i++) {
            if (arboles.getListaarboles().get(i).getArchivo().equals(archivo_actual.getArchivo())) {
                arbolcreado = true;
                getposarbol = i;//se agarra la posicion del arbol creado
                arbol_actual = arboles.getListaarboles().get(i).getArbol();
                break;
            } // Fin If
        } // Fin For
        int llaveprimaria = 0;
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            if (archivo_actual.getCampos().get(i).isLlavePrimaria()) {
                llaveprimaria = i;
            } // Fin If
        } // Fin For
        // Aqui se empieza a trabajar en la creacion
        if (arbolcreado == false) {
            // Aqui es sie el arbol no esta creado pues se crea dentro de la lista de arboles y se hace el registro
            arboles.cargarArchivo();
            int id = arboles.GenerarId();
            Archivoconarbolb Archivodelarbol = new Archivoconarbolb(archivo_actual.getArchivo(), id);
            Archivodelarbol.setArbol(6);
            for (int i = 0; i < model.getRowCount(); i++) {
                guardar = "";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    guardar += model.getValueAt(i, j).toString() + "|";
                } // Fin For
                guardar += llenar(guardar.length()) + "\n";
                String llave = model.getValueAt(i, llaveprimaria).toString();
                if (archivo_actual.getCampos().get(llaveprimaria).getTipo_de_dato().equals("String")) {
                    int num = archivo_actual.getCampos().get(llaveprimaria).getLongitud() - llave.length();
                    llave = espacios.substring(0, num) + llave;
                } else if (archivo_actual.getCampos().get(llaveprimaria).getTipo_de_dato().equals("int")) {
                    int num = archivo_actual.getCampos().get(llaveprimaria).getLongitud() - llave.length();
                    llave = espacios.substring(0, num) + llave;
                } // Fin If
                arbolessecundarios.cargarArchivo();
                if (Archivodelarbol.getArbol().B_Tree_Search(Archivodelarbol.getArbol().getRaiz(), llave) != null) {
                    omitidos = true;
                } else {
                    int rrn = 0;
                    try {
                        // Aqui manda a llamar el RRN para designarlo al arbol
                        rrn = guardarRegistro(guardar);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } // Fin Try Catch
                    Archivodelarbol.getArbol().B_Tree_Insert(llave, rrn);
                    if (arbol_secundarioactual != null) {
                        int llavesecundaria = 0;
                        arbolessecundarios.cargarArchivo();
                        for (int r = 0; r < archivo_actual.getCampos().size(); r++) {
                            if (archivo_actual.getCampos().get(r).isLlave_secundaria()) {
                                llavesecundaria = r;
                            } // Fin If
                        } // Fin For
                        int archivodelarbol = 0;
                        for (int r = 0; r < arbolessecundarios.getListaarboles().size(); r++) {
                            if (arbolessecundarios.getListaarboles().get(r).getIDArchivoActual() == archivo_actual.getID()) {
                                archivodelarbol = r;
                            } // Fin If
                        } // Fin For
                        for (int r = 0; r < model.getRowCount(); r++) {
                            for (int s = 0; s < model.getColumnCount(); s++) {
                            }//fin segundo for
                            String llave_secundaria = model.getValueAt(r, llavesecundaria).toString();
                            if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("int")) {
                                int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave_secundaria.length();
                                llave_secundaria = espacios.substring(0, num) + llave_secundaria;
                            } // Fin If
                            if (arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario().B_Tree_Search(arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario().getRaiz(), llave_secundaria) != null) {
                                omitidos = true;
                            } else {
                                arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario().B_Tree_Insert(llave_secundaria, rrn);
                                arbol_secundarioactual = arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario();
                                arbolessecundarios.escribirArchivo();
                            } // Fin If
                        } // Fin For
                    } // Fin Ff 
                } // Fin If
            } // Fin For
            arbol_actual = Archivodelarbol.getArbol();
            arboles.getListaarboles().add(Archivodelarbol);
            arboles.escribirArchivo();
        } else {
            // Aqui se hace cuando el arbol ya esta creado
            arboles.cargarArchivo();
            for (int i = 0; i < model.getRowCount(); i++) {
                guardar = "";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    guardar += model.getValueAt(i, j).toString() + "|";
                } // Fin For
                guardar += llenar(guardar.length()) + "\n";
                int posicion_llave = getPosKey();
                String llave = model.getValueAt(i, posicion_llave).toString();
                if (archivo_actual.getCampos().get(llaveprimaria).getTipo_de_dato().equals("String")) {
                    int num = archivo_actual.getCampos().get(llaveprimaria).getLongitud() - llave.length();
                    llave = espacios.substring(0, num) + llave;
                } else if (archivo_actual.getCampos().get(llaveprimaria).getTipo_de_dato().equals("int")) {
                    int num = archivo_actual.getCampos().get(llaveprimaria).getLongitud() - llave.length();
                    llave = espacios.substring(0, num) + llave;
                } // Fin If
                int llavesecundaria = 0;
                for (int r = 0; r < archivo_actual.getCampos().size(); r++) {
                    if (archivo_actual.getCampos().get(r).isLlave_secundaria()) {
                        llavesecundaria = r;
                    } // Fin If
                } // Fin For
                String llave_secun = "";
                for (int r = 0; r < model.getRowCount(); r++) {
                    for (int s = 0; s < model.getColumnCount(); s++) {
                    } // Fin Segundo For
                    llave_secun = model.getValueAt(r, llavesecundaria).toString();
                    if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("int")) {
                        int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave_secun.length();
                        llave_secun = espacios.substring(0, num) + llave_secun;
                    } // Fin If
                } // Fin For
                int validacion = 0;
                for (int r = 0; r < arbolessecundarios.getListaarboles().size(); r++) {
                    if (arbolessecundarios.getListaarboles().get(r).getIDArchivoActual() == archivo_actual.getID()) {
                        validacion = r;
                    } // Fin If
                } // Fin For
                if (arbol_secundarioactual != null) {
                    if (!archivo_actual.getArchivo().getName().equals("PersonFile")) {
                        if (arboles.getListaarboles().get(getposarbol).getArbol().B_Tree_Search(arboles.getListaarboles().get(getposarbol).getArbol().getRaiz(), llave) != null || arbolessecundarios.getListaarboles().get(validacion).getArbolSecundario().B_Tree_Search(arbolessecundarios.getListaarboles().get(validacion).getArbolSecundario().getRaiz(), llave_secun) != null) {
                            omitidos = true;
                        } // Fin If
                    } // Fin If
                } // Fin If
                if (arboles.getListaarboles().get(getposarbol).getArbol().B_Tree_Search(arboles.getListaarboles().get(getposarbol).getArbol().getRaiz(), llave) != null) {
                    omitidos = true;
                } else {
                    int rrn = 0;
                    try {
                        rrn = guardarRegistro(guardar); //aqui manda a llamar al rrn para designarlo al arbol
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } // Fin Try Catch
                    arboles.getListaarboles().get(getposarbol).getArbol().B_Tree_Insert(llave, rrn);
                    if (arbol_secundarioactual != null) {
                        llavesecundaria = 0;
                        arbolessecundarios.cargarArchivo();
                        for (int r = 0; r < archivo_actual.getCampos().size(); r++) {
                            if (archivo_actual.getCampos().get(r).isLlave_secundaria()) {
                                llavesecundaria = r;
                            } // Fin Ff
                        } // Fin For
                        int archivodelarbol = 0;
                        for (int r = 0; r < arbolessecundarios.getListaarboles().size(); r++) {
                            if (arbolessecundarios.getListaarboles().get(r).getIDArchivoActual() == archivo_actual.getID()) {
                                archivodelarbol = r;
                            } // Fin If
                        } // Fin For
                        for (int r = 0; r < model.getRowCount(); r++) {
                            for (int s = 0; s < model.getColumnCount(); s++) {
                            } // Fin Segundo For
                            String llave_secundaria = model.getValueAt(r, llavesecundaria).toString();
                            if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("int")) {
                                int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave_secundaria.length();
                                llave_secundaria = espacios.substring(0, num) + llave_secundaria;
                            } // Fin If
                            if (arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario().B_Tree_Search(arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario().getRaiz(), llave_secundaria) != null) {
                                omitidos = true;
                            } else {
                                arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario().B_Tree_Insert(llave_secundaria, rrn);
                                arbol_secundarioactual = arbolessecundarios.getListaarboles().get(archivodelarbol).getArbolSecundario();
                                arbolessecundarios.escribirArchivo();
                            } // Fin If
                        } // Fin For
                    } // Fin If
                } // Fin If
            } // Fin for
            arbol_actual = arboles.getListaarboles().get(getposarbol).getArbol();
            arboles.escribirArchivo();
        } // Fin If
        String message;
        // Esto lo que hace es enviar un mensaje a ver si el registro ya existe en el arbol
        if (omitidos) {
            message = "Algunos registros no fueron guardados ya que habia un registro con la misma llave primaria o secundaria almacenado en el archivo";
        } else {
            message = "??Guardado Exitoso!";
        } // Fin If
        arboles.escribirArchivo();
        JOptionPane.showMessageDialog(null, message);
        jTbl_tablaRegistros.setModel(new DefaultTableModel());
        DefaultTableModel modelo = (DefaultTableModel) jTbl_tablaRegistros.getModel();
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            modelo.addColumn(archivo_actual.getCampos().get(i).getNombre());
        } // Fin For
        modelo.setNumRows(1);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void CB_LlavesModificarRegistroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_LlavesModificarRegistroItemStateChanged
        try {
            DefaultTableModel model = (DefaultTableModel) TablaModificarRegistro.getModel();
            if (model.getRowCount() != 0) {
                model.removeRow(0);
            } // Fin If
            TablaModificarRegistro.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CB_LlavesModificarRegistroItemStateChanged

    private void jCb_llavesEliminarRegistrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCb_llavesEliminarRegistrosItemStateChanged
        try {
            DefaultTableModel model = (DefaultTableModel) TablaEliminarRegistro.getModel();
            if (model.getRowCount() != 0) {
                model.removeRow(0);
            } // Fin If
            TablaEliminarRegistro.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jCb_llavesEliminarRegistrosItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JD_Agregar_registro.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        JD_Modificar_registro.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        JD_Eliminar_registro.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        JD_Cruzar_Archivo.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        JD_Buscar_registro.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void CB_LlavesBuscarRegistrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_LlavesBuscarRegistrosItemStateChanged
        try {
            DefaultTableModel model = (DefaultTableModel) TablaBuscarRegistro.getModel();
            if (model.getRowCount() != 0) {
                model.removeRow(0);
            } // Fin If
            TablaBuscarRegistro.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CB_LlavesBuscarRegistrosItemStateChanged

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if (archivo_actual.getLongitudLlavePrimaria() < jTf_buscarRegistros.getText().length()) {
            JOptionPane.showMessageDialog(this, "La llave ingresada excede la longitud permitida.");
            return;
        } // Fin If
        if (jTf_buscarRegistros.getText().equals("") || CB_LlavesBuscarRegistros.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el la llave del registro que desea buscar.");
            return;
        } // Fin If
        int llavesecundaria = 0;
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                llavesecundaria = i;
            } // Fin If
        } // Fin For
        for (int i = 0; i < arboles.getListaarboles().size(); i++) {
            if (arboles.getListaarboles().get(i).getArchivo().equals(archivo_actual.getArchivo())) {
                arbol_actual = arboles.getListaarboles().get(i).getArbol();
                break;
            } // Fin If
        } // Fin For
        int poscombobox = CB_LlavesBuscarRegistros.getSelectedIndex();
        if (poscombobox == 0) {
            if (arbol_actual != null) {
                DefaultTableModel model = (DefaultTableModel) TablaBuscarRegistro.getModel();
                model.getDataVector().removeAllElements();
                if (true || CB_LlavesBuscarRegistros.getSelectedIndex() == 0) {
                    int pk = 0;
                    String llave = jTf_buscarRegistros.getText();
                    if (archivo_actual.getCampos().get(pk).getTipo_de_dato().equals("int")) {
                        int num = archivo_actual.getCampos().get(pk).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } else if (archivo_actual.getCampos().get(pk).getTipo_de_dato().equals("String")) {
                        int num = archivo_actual.getCampos().get(pk).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } // Fin If
                    rrnsbuscar = new ArrayList<Long>();
                    arbol_actual.searchByAffinity(arbol_actual.getRaiz(), llave, rrnsbuscar);//searchbyaffinity lo que hace es devolver el rrn de la llave que buscamos
                    if (rrnsbuscar.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No se encontro ningun registro con ese valor");
                        jTf_buscarRegistros.setText("");
                        return;
                    } // Fin If
                    for (long l : rrnsbuscar) {
                        // Aal rrn se le asigan el valor que el rrn le ha enviado
                        rrnabuscar = Math.toIntExact(l);
                        try {
                            String data = leerregistro(Math.toIntExact(rrnabuscar));
                            String arr[] = data.split("\\|");
                            Object arr2[] = new Object[model.getColumnCount()];
                            for (int i = 0; i < model.getColumnCount(); i++) {
                                arr2[i] = arr[i];
                            } // Fin For
                            model.addRow(arr2);
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } // Fin Try Catch
                    } // Fin For
                } // Fin If
            } else {
                JOptionPane.showMessageDialog(null, "No se puede buscar porque no existen registros creados");
            } // Fin If
        } else if (poscombobox == 1) {
            if (arbol_secundarioactual != null) {
                DefaultTableModel model = (DefaultTableModel) TablaBuscarRegistro.getModel();
                model.getDataVector().removeAllElements();
                if (true || CB_LlavesBuscarRegistros.getSelectedIndex() == 0) {
                    String llave = jTf_buscarRegistros.getText();
                    if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("int")) {
                        int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } else if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("String")) {
                        int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } // Fin If
                    rrnsbuscar = new ArrayList<>();
                    // Searchbyaffinity lo que hace es devolver el rrn de la llave que buscamos
                    arbol_secundarioactual.searchByAffinity(arbol_secundarioactual.getRaiz(), llave, rrnsbuscar);
                    if (rrnsbuscar.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No se encontro ningun registro con ese valor");
                        jTf_buscarRegistros.setText("");
                        return;
                    } // Fin If
                    for (long l : rrnsbuscar) {
                        rrnabuscar = Math.toIntExact(l);//al rrn se le asigan el valor que el rrn le ha enviado
                        try {
                            String data = leerregistro(Math.toIntExact(rrnabuscar));
                            String arr[] = data.split("\\|");
                            Object arr2[] = new Object[model.getColumnCount()];
                            for (int i = 0; i < model.getColumnCount(); i++) {
                                arr2[i] = arr[i];
                            } // Fin For
                            model.addRow(arr2);
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } // Fin Try Catch
                    } // Fin For
                } // Fin If
            } else {
                JOptionPane.showMessageDialog(null, "No se puede buscar porque no existen indices nuevos creados");
            } // Fin If
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (TF_LlaveModificarRegistro.getText().equals("") || CB_LlavesModificarRegistro.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese la llave del registro que desea buscar");
            TF_LlaveModificarRegistro.setText("");
            return;
        } // Fin If
        int llaveSecundaria = 0;
        String Second = "";
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                llaveSecundaria = i;
                Second = archivo_actual.getCampos().get(i).getNombre();
            } // Fin If
        } // Fin For
        for (int i = 0; i < arboles.getListaarboles().size(); i++) {
            if (arboles.getListaarboles().get(i).getArchivo().equals(archivo_actual.getArchivo())) {
                arbol_actual = arboles.getListaarboles().get(i).getArbol();
                break;
            } // Fin If
        } // Fin For
        int posComboBox = CB_LlavesModificarRegistro.getSelectedIndex();
        if (posComboBox == 0) {
            if (archivo_actual.getLongitudLlavePrimaria() < TF_LlaveModificarRegistro.getText().length()) {
                JOptionPane.showMessageDialog(this, "La llave ingresada excede la longitud permitida");
                TF_LlaveModificarRegistro.setText("");
                return;
            } // Fin If
            if (arbol_actual != null) {
                DefaultTableModel model = (DefaultTableModel) TablaModificarRegistro.getModel();
                model.getDataVector().removeAllElements();
                if (true || CB_LlavesModificarRegistro.getSelectedIndex() == 0) {
                    int pk = 0;
                    String llave = TF_LlaveModificarRegistro.getText();
                    if (archivo_actual.getCampos().get(pk).getTipo_de_dato().equals("int")) {
                        int num = archivo_actual.getCampos().get(pk).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } else if (archivo_actual.getCampos().get(pk).getTipo_de_dato().equals("String")) {
                        int num = archivo_actual.getCampos().get(pk).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } // Fin If
                    rrnsbuscar = new ArrayList<>();
                    // Search By Affinity lo que hace es devolver el rrn de la llave que buscamos
                    arbol_actual.searchByAffinity(arbol_actual.getRaiz(), llave, rrnsbuscar);
                    if (rrnsbuscar.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El registro que busca no ha sido encontrado");
                        TF_LlaveModificarRegistro.setText("");
                        return;
                    } // Fin If
                    for (long rrn : rrnsbuscar) {
                        // Al RRN se le asigan el valor que el rrn le ha enviado
                        rrnModificar = Math.toIntExact(rrn);
                        try {
                            String linea = leerregistro(Math.toIntExact(rrnModificar));
                            String arreglo[] = linea.split("\\|");
                            Object arreglo2[] = new Object[model.getColumnCount()];
                            for (int i = 0; i < model.getColumnCount(); i++) {
                                llaveprimariaTemp = arreglo[0];
                                llavesecundariaTemp = arreglo[llaveSecundaria];
                                arreglo2[i] = arreglo[i];
                            } // Fin For
                            model.addRow(arreglo2);
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } // Fin Try
                    } // Fin For
                } // Fin If
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda debido a que aun no existen registros creados");
            } // Fin If
        } else if (posComboBox == 1) {
            if (archivo_actual.getLongitudLlaveSecundaria() < TF_LlaveModificarRegistro.getText().length()) {
                JOptionPane.showMessageDialog(this, "La llave ingresada excede la longitud permitida");
                TF_LlaveModificarRegistro.setText("");
                return;
            } // Fin If
            if (arbol_secundarioactual != null) {
                DefaultTableModel model = (DefaultTableModel) TablaModificarRegistro.getModel();
                model.getDataVector().removeAllElements();
                if (true || CB_LlavesModificarRegistro.getSelectedIndex() == 0) {
                    String llave = TF_LlaveModificarRegistro.getText();
                    if (archivo_actual.getCampos().get(llaveSecundaria).getTipo_de_dato().equals("int")) {
                        int num = archivo_actual.getCampos().get(llaveSecundaria).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } else if (archivo_actual.getCampos().get(llaveSecundaria).getTipo_de_dato().equals("String")) {
                        int num = archivo_actual.getCampos().get(llaveSecundaria).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } // Fin If
                    rrnsbuscar = new ArrayList<>();
                    // Search By Affinity lo que hace es devolver el rrn de la llave que buscamos
                    arbol_secundarioactual.searchByAffinity(arbol_secundarioactual.getRaiz(), llave, rrnsbuscar);
                    if (rrnsbuscar.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El registro que busca no ha sido encontrado");
                        TF_LlaveModificarRegistro.setText("");
                        return;
                    } // Fin If
                    for (long l : rrnsbuscar) {
                        // Al RRN se le asigan el valor que el rrn le ha enviado
                        rrnModificar = Math.toIntExact(l);
                        try {
                            String data = leerregistro(Math.toIntExact(rrnModificar));
                            String arreglo[] = data.split("\\|");
                            Object arreglo2[] = new Object[model.getColumnCount()];
                            for (int i = 0; i < model.getColumnCount(); i++) {
                                llaveprimariaTemp = arreglo[0];
                                if (arreglo[i].equals(Second)) {
                                    llavesecundariaTemp = arreglo[i];
                                } // Fin If
                                arreglo2[i] = arreglo[i];
                            } // Fin For
                            model.addRow(arreglo2);
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } // Fin Try Catch
                    } // Fin For
                } // Fin If
            } else {
                JOptionPane.showMessageDialog(null, "No existen nuevos indices creados, dirijase al Menu Indices");
            } // Fin If
        } // Fin If
        TF_LlaveModificarRegistro.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (TablaModificarRegistro.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Aun no ha buscado ningun registro");
            TF_LlaveModificarRegistro.setText("");
            return;
        } // Fin If
        if (ValidaciondeingresoTabla(TablaModificarRegistro, false)) {
            String columnaLlavePrimaria = "", columnaLlaveSecundaria = "";
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                if (archivo_actual.getCampos().get(i).isLlavePrimaria()) {
                    columnaLlavePrimaria = archivo_actual.getCampos().get(i).getNombre();
                } // Fin If
            } // Fin For
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                    columnaLlaveSecundaria = archivo_actual.getCampos().get(i).getNombre();
                } // Fin If
            } // Fin For
            DefaultTableModel model = (DefaultTableModel) TablaModificarRegistro.getModel();
            String guardar = "";
            String llavePrimaria = "", llaveSecundaria = "";
            for (int j = 0; j < model.getColumnCount(); j++) {
                guardar += model.getValueAt(0, j).toString() + "|";
                if (model.getColumnName(j).equals(columnaLlavePrimaria)) {
                    llavePrimaria = model.getValueAt(0, j).toString();
                } // Fin If
                if (model.getColumnName(j).equals(columnaLlaveSecundaria)) {
                    llaveSecundaria = model.getValueAt(0, j).toString();
                } // Fin If
            } // Fin For
            if (!llavePrimaria.equals(llaveprimariaTemp)) {
                JOptionPane.showMessageDialog(this, "La llave primaria no se debe modificar");
                DefaultTableModel modelo = (DefaultTableModel) TablaModificarRegistro.getModel();
                if (modelo.getRowCount() != 0) {
                    modelo.removeRow(0);
                } // Fin If
                TablaModificarRegistro.setModel(modelo);
                return;
            } // Fin If
            if (!llaveSecundaria.equals(llavesecundariaTemp)) {
                JOptionPane.showMessageDialog(this, "La llave secundaria no se debe modificar");
                DefaultTableModel modelo = (DefaultTableModel) TablaModificarRegistro.getModel();
                if (modelo.getRowCount() != 0) {
                    modelo.removeRow(0);
                } // Fin If
                TablaModificarRegistro.setModel(modelo);
                return;
            } // Fin If
            model.removeRow(0);
            try {
                Modificar(guardar, rrnModificar);
                JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");
                TF_LlaveModificarRegistro.setText("");
                CB_LlavesModificarRegistro.setSelectedIndex(0);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } // Fin Try Catch
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (archivo_actual.getLongitudLlavePrimaria() < jTf_LLaveEliminarRegistros.getText().length()) {
            JOptionPane.showMessageDialog(this, "La llave ingresada excede la longitud permitida.");
            return;
        } // Fin If
        if (jTf_LLaveEliminarRegistros.getText().equals("") || jCb_llavesEliminarRegistros.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el la llave del registro que desea buscar.");
            return;
        } // Fin If
        int llavesecundaria = 0;
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            if (archivo_actual.getCampos().get(i).isLlave_secundaria()) {
                llavesecundaria = i;
            } // Fin If
        } // Fin For
        for (int i = 0; i < arboles.getListaarboles().size(); i++) {
            if (arboles.getListaarboles().get(i).getArchivo().equals(archivo_actual.getArchivo())) {
                arbol_actual = arboles.getListaarboles().get(i).getArbol();
                break;
            } // Fin If
        } // Fin For
        int poscombobox = jCb_llavesEliminarRegistros.getSelectedIndex();
        if (poscombobox == 0) {
            if (arbol_actual != null) {
                DefaultTableModel model = (DefaultTableModel) TablaEliminarRegistro.getModel();
                model.getDataVector().removeAllElements();
                if (true || jCb_llavesEliminarRegistros.getSelectedIndex() == 0) {
                    int pk = 0;
                    String llave = jTf_LLaveEliminarRegistros.getText();
                    if (archivo_actual.getCampos().get(pk).getTipo_de_dato().equals("int")) {
                        int num = archivo_actual.getCampos().get(pk).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } else if (archivo_actual.getCampos().get(pk).getTipo_de_dato().equals("String")) {
                        int num = archivo_actual.getCampos().get(pk).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } // Fin If
                    rrnsbuscar = new ArrayList<Long>();
                    // Search By Affinity lo que hace es devolver el rrn de la llave que buscamos
                    arbol_actual.searchByAffinity(arbol_actual.getRaiz(), llave, rrnsbuscar);
                    if (rrnsbuscar.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No se encontro ningun registro con ese valor");
                        jTf_LLaveEliminarRegistros.setText("");
                        return;
                    } // Fin If
                    for (long l : rrnsbuscar) {
                        rrnabuscar = Math.toIntExact(l);//al rrn se le asigan el valor que el rrn le ha enviado
                        try {
                            String data = leerregistro(Math.toIntExact(rrnabuscar));
                            String arr[] = data.split("\\|");
                            Object arr2[] = new Object[model.getColumnCount()];
                            for (int i = 0; i < model.getColumnCount(); i++) {
                                arr2[i] = arr[i];
                            }
                            model.addRow(arr2);
                            //jTf_buscarRegistros.setEditable(false);
                            // jCb_llavesBuscarregistros.setEnabled(false);
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } // Fin Try Catch
                    } // Fin For
                } // Fin If
            } else {
                JOptionPane.showMessageDialog(null, "No se puede buscar porque no existen registros creados");
            } // Fin If
        } else if (poscombobox == 1) {
            if (arbol_secundarioactual != null) {
                DefaultTableModel model = (DefaultTableModel) TablaEliminarRegistro.getModel();
                model.getDataVector().removeAllElements();
                if (true || jCb_llavesEliminarRegistros.getSelectedIndex() == 0) {
                    String llave = jTf_LLaveEliminarRegistros.getText();
                    if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("int")) {
                        int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } else if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("String")) {
                        int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave.length();
                        llave = espacios.substring(0, num) + llave;
                    } // Fin If
                    rrnsbuscar = new ArrayList<Long>();
                    // Search By Affinity lo que hace es devolver el rrn de la llave que buscamos
                    arbol_secundarioactual.searchByAffinity(arbol_secundarioactual.getRaiz(), llave, rrnsbuscar);
                    if (rrnsbuscar.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No se encontro ningun registro con ese valor");
                        jTf_LLaveEliminarRegistros.setText("");
                        return;
                    } // Fin If
                    for (long l : rrnsbuscar) {
                        // Al RRN se le asigan el valor que el rrn le ha enviado
                        rrnabuscar = Math.toIntExact(l);
                        try {
                            String data = leerregistro(Math.toIntExact(rrnabuscar));
                            String arr[] = data.split("\\|");
                            Object arr2[] = new Object[model.getColumnCount()];
                            for (int i = 0; i < model.getColumnCount(); i++) {
                                arr2[i] = arr[i];
                            } // Fin For
                            model.addRow(arr2);
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } // Fin Try Catch
                    } // Fin For
                } // Fin If
            } else {
                JOptionPane.showMessageDialog(null, "No se puede buscar porque no existen indices nuevos creados");
            } // Fin If
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (TablaEliminarRegistro.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "No has buscado ning??n registro todav??a.");
            return;
        } // Fin If
        int getposarbol1 = 0;//esto es para agrrar la posicion dle arbolcreado
        for (int i = 0; i < arboles.getListaarboles().size(); i++) {
            if (arboles.getListaarboles().get(i).getArchivo().equals(archivo_actual.getArchivo())) {
                getposarbol1 = i;
                arbol_actual = arboles.getListaarboles().get(i).getArbol();
                break;
            } // Fin If
        } // Fin For
        rrn_llaves_en_orden = new ArrayList<Long>();
        arbol_actual.BTree_KeysInOrder(arbol_actual.getRaiz(), rrn_llaves_en_orden);
        if (!rrn_llaves_en_orden.isEmpty()) {
            int c = 0;
            for (long rrn : rrnsbuscar) {
                if (true || Campo.class.cast(jCb_llavesEliminarRegistros.getSelectedItem()).isLlavePrimaria()) {
                    String data = "";
                    try {
                        data = leerregistro(Math.toIntExact(rrn));
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } // Fin Try Catch
                    char[] data2 = data.toCharArray();
                    data2[0] = '*';
                    data2[1] = '|';
                    String rrnString = "";
                    boolean es_primer_registro_eliminado = true;
                    if (archivo_actual.getAvailList().isEmpty()) {
                        rrnString = rrnAsString(-1);
                    } else {
                        rrnString = rrnAsString((int) archivo_actual.getAvailList().peekFirst());
                        RandomAccessFile flujo;
                        try {
                            flujo = new RandomAccessFile(new File(archivo_actual.getArchivo().getAbsolutePath()), "rw");
                            StringBuffer sbregistro = new StringBuffer(rrnString);
                            sbregistro.setLength(10);
                            flujo.seek((archivo_actual.getSizeMetadata() + 1) * 2);
                            flujo.writeChars(sbregistro.toString());
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        } // Fin Try Catch
                        es_primer_registro_eliminado = false;
                    }
                    int aux_cont = 0;
                    for (int i = 2; i < rrnString.length(); i++) {
                        data2[i] = rrnString.charAt(aux_cont);
                        aux_cont++;
                    } // Fin For
                    try {
                        int posicion_llave = getPosKey();
                        String llave = TablaEliminarRegistro.getValueAt(c++, posicion_llave).toString();
                        if (archivo_actual.getCampos().get(posicion_llave).getTipo_de_dato().equals("int")) {
                            int num = archivo_actual.getCampos().get(posicion_llave).getLongitud() - llave.length();
                            llave = espacios.substring(0, num) + llave;
                        } // Fin If
                        int llavesecundaria = 0;
                        for (int r = 0; r < archivo_actual.getCampos().size(); r++) {
                            if (archivo_actual.getCampos().get(r).isLlave_secundaria()) {
                                llavesecundaria = r;
                            } // Fin If
                        } // Fin For
                        String llave_secun = "";
                        for (int r = 0; r < TablaEliminarRegistro.getRowCount(); r++) {
                            for (int s = 0; s < TablaEliminarRegistro.getColumnCount(); s++) {
                            } // Fin For
                            llave_secun = TablaEliminarRegistro.getValueAt(r, llavesecundaria).toString();
                            if (archivo_actual.getCampos().get(llavesecundaria).getTipo_de_dato().equals("int")) {
                                int num = archivo_actual.getCampos().get(llavesecundaria).getLongitud() - llave_secun.length();
                                llave_secun = espacios.substring(0, num) + llave_secun;
                            } // Fin If
                        } // Fin For
                        int validacion = 0;
                        for (int r = 0; r < arbolessecundarios.getListaarboles().size(); r++) {
                            if (arbolessecundarios.getListaarboles().get(r).getIDArchivoActual() == archivo_actual.getID()) {
                                validacion = r;
                            } // Fin If
                        } // Fin For
                        if (arbol_secundarioactual != null) {
                            arbolessecundarios.cargarArchivo();
                            arbolessecundarios.getListaarboles().get(validacion).getArbolSecundario().B_Tree_Delete_Key(arbol_secundarioactual.getRaiz(), llave_secun);
                            arbol_secundarioactual = arbolessecundarios.getListaarboles().get(validacion).getArbolSecundario();
                            arbolessecundarios.escribirArchivo();
                        } // Fin If
                        //ESTO ELIMINA EL REGISTRO DE LA LISTA DE REGISTROS
                        arboles.cargarArchivo();
                        arboles.getListaarboles().get(getposarbol1).getArbol().B_Tree_Delete_Key(arboles.getListaarboles().get(getposarbol1).getArbol().getRaiz(), llave);
                        arbol_actual = arboles.getListaarboles().get(getposarbol1).getArbol();
                        arboles.escribirArchivo();
                        Modificar(new String(data2), Math.toIntExact(rrn));
                        aa.cargarArchivo();
                        for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                            if (aa.getLista_archivos().get(i).getID() == archivo_actual.getID()) {
                                aa.getLista_archivos().get(i).getAvailList().add(Math.toIntExact(rrn));
                                archivo_actual = aa.getLista_archivos().get(i);
                                break;
                            } // Fin If
                        } // Fin For
                        aa.escribirArchivo();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } // Fin Try Catch
                } // Fin If
            } // Fin For 
            jTf_LLaveEliminarRegistros.setText("");
            DefaultTableModel model = new DefaultTableModel();
            TablaEliminarRegistro.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{}));
            for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
                model.addColumn(archivo_actual.getCampos().get(i).getNombre());
            } // Fin For
            TablaEliminarRegistro.setModel(model);
            JOptionPane.showMessageDialog(this, "El registro a sido eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "No existen registros guardados.");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void RB_LlavePrimariaDelCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_LlavePrimariaDelCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_LlavePrimariaDelCampoActionPerformed

    private void RB_LlaveSecundariaDelCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_LlaveSecundariaDelCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_LlaveSecundariaDelCampoActionPerformed

    private void CB_TipoDeDatoDelCampoModificadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_TipoDeDatoDelCampoModificadoItemStateChanged
        String tipo_de_dato = (String) CB_TipoDeDatoDelCampoModificado.getSelectedItem();
        if (tipo_de_dato.equals("int")) {
            SP_LongitudDelCampoModificado.setEnabled(false);
        } else if (tipo_de_dato.equals("double")) {
            SP_LongitudDelCampoModificado.setEnabled(false);
        } else if (tipo_de_dato.equals("char")) {
            SP_LongitudDelCampoModificado.setEnabled(false);
        } else {
            SP_LongitudDelCampoModificado.setEnabled(true);
        }
    }//GEN-LAST:event_CB_TipoDeDatoDelCampoModificadoItemStateChanged

    private void CB_TipoDeDatoDelCampoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_TipoDeDatoDelCampoItemStateChanged
        String tipo_de_dato = (String) CB_TipoDeDatoDelCampo.getSelectedItem();
        if (tipo_de_dato.equals("int")) {
            SP_LongitudDelCampo.setEnabled(false);
        } else if (tipo_de_dato.equals("double")) {
            SP_LongitudDelCampo.setEnabled(false);
        } else if (tipo_de_dato.equals("char")) {
            SP_LongitudDelCampo.setEnabled(false);
        } else {
            SP_LongitudDelCampo.setEnabled(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_CB_TipoDeDatoDelCampoItemStateChanged

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        boolean existePrueba = false;
        aa.cargarArchivo();
        for (Archivo archivo : aa.getLista_archivos()) {
            if (archivo.getArchivo().getName().equals("PersonFile.txt")) {
                existePrueba = true;
                break;
            } // Fin If
        } // Fin For
        aa.escribirArchivo();
        arboles.cargarArchivo();
        if (existePrueba) {
            aa.cargarArchivo();
            for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                if (aa.getLista_archivos().get(i).getArchivo().getName().equals("PersonFile.txt")) {
                    archivo_actual = aa.getLista_archivos().get(i);
                    arbol_actual = arboles.getListaarboles().get(i).getArbol();
                    arbol_secundarioactual = arbolessecundarios.getListaarboles().get(i).getArbolSecundario();
                    GuardarArchivo = "PersonFile.txt";
                    break;
                } // Fin If
            } // Fin For

        } else {
            GenerarPersonFile();

        }
        jmi_Campos.setEnabled(true);
//        jmi_Modificar_Campo.setEnabled(true);
        jmi_Crear_Campo.setEnabled(true);
        jmi_Mod_Campo.setEnabled(true);
        jm_Registros.setEnabled(true);
        jm_indices.setEnabled(true);
        jm_Estandarizacion.setEnabled(true);
        jmi_Salvar_Archivo.setEnabled(true);
        jmi_Cerrar_Archivo.setEnabled(true);
        jmi_reindexar.setEnabled(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.setVisible(false);
        JD_Cruzar_Archivo.setVisible(false);
        JD_Cruzar_Archivo.pack();
        JD_Cruzar_Archivo.setLocationRelativeTo(this);
        JD_Cruzar_Archivo.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        JD_Listar_registros.dispose();
        this.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Btn_abrir_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_abrir_archivoActionPerformed
        String save = "";
        try {
            // VALIDACI??N: SI INGRESO EL NOMBRE DE UN ARCHIVO QUE NO EXISTE TIRA ERROR
            if (JOptionPane.showConfirmDialog(null, "??Desea utilizar un archivo de prueba?", "Confirmaci??n", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                boolean existePrueba = false;
                aa.cargarArchivo();
                for (Archivo archivo : aa.getLista_archivos()) {
                    if (archivo.getArchivo().getName().equals("PersonFile.txt")) {
                        existePrueba = true;
                        break;
                    } // Fin If
                } // Fin For
                aa.escribirArchivo();
                if (existePrueba) {
                    aa.cargarArchivo();
                    for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                        if (aa.getLista_archivos().get(i).getArchivo().getName().equals("PersonFile.txt")) {
                            archivo_para_cruzar = aa.getLista_archivos().get(i);
                            save = "PersonFile.txt";
                            break;
                        } // Fin If
                    } // Fin For
                } else {
                    GenerarPersonFile();
                } // Fin If
                //termina abrir de prueba
            } else {
                File archivo_abrir = null;
                FileReader fr = null;
                BufferedReader br = null;
                TA_ArchivoAbierto.setText("");
                JFileChooser filechooser = new JFileChooser("./");
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Texto", "txt");
                //FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Imagenes", "jpg", "png", "bmp");
                filechooser.setFileFilter(filtro);
                //filechooser.addChoosableFileFilter(filtro2);
                int seleccion = filechooser.showOpenDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    archivo_abrir = filechooser.getSelectedFile();
                    save = archivo_abrir.getName();
                    boolean valid = false;
                    aa.cargarArchivo();
                    for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                        if (aa.getLista_archivos().get(i).getArchivo().equals(archivo_abrir)) {
                            valid = true;
                            archivo_para_cruzar = aa.getLista_archivos().get(i);
                            break;
                        } // Fin If
                    } // Fin For
                    if (!valid) {
                        int ID;
                        aa.cargarArchivo();
                        ID = aa.GenerarId();
                        archivo_para_cruzar = new Archivo(archivo_abrir, ID);
                        save = null;
                        // AQUI FALTA SETEARLE LOS CAMPOS
                        aa.AddArchivo(archivo_para_cruzar);
                        aa.escribirArchivo();
                        save = archivo_para_cruzar.getArchivo().getName();
                        //System.out.println(GuardarArchivo);
                    } // Fin If
                    fr = new FileReader(archivo_abrir);
                    br = new BufferedReader(fr);
                    try {
                        br.close();
                        fr.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } // Fin Try Catch
                    salvado = false;
                } // Fin If
                JOptionPane.showMessageDialog(this, "Archivo Cargado.");
            } // Fin If
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo porque no existe");
        } // Fin Try Catch


    }//GEN-LAST:event_Btn_abrir_archivoActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        if (!(archivo_para_cruzar == null)) {
            boolean puede_cruzarse = false;
            /*
            Reviso si el archivo tiene relaci??n de campos y tambi??n meto en un
            arraylist todos los campos de ambos archivos
             */
            campos_para_cruzar.clear();
            int ya = 0;
            for (int j = 0; j < archivo_actual.getCampos().size(); j++) {
                campos_para_cruzar.add(archivo_actual.getCampos().get(j));
                for (int k = 0; k < archivo_para_cruzar.getCampos().size(); k++) {
                    if (archivo_para_cruzar.getCampos().get(k).campos_para_cruce().
                            equals(archivo_actual.getCampos().get(j).campos_para_cruce())) {
                        puede_cruzarse = true;
                    } else {
                        if (ya == 0) {
                            campos_para_cruzar.add(archivo_para_cruzar.getCampos().get(k));
                        }
                    }
                }//fin for
                ya++;
            }//fin for
            //Procedo a la creaci??n del archivo cruzado
            if (puede_cruzarse) {
                //limpio la tabla
                jTbl_CamposParaCruceSelecionar.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{}
                ));
                jTbl_CamposCruzados.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{},
                        new String[]{}
                ));
                //agarro el modelo de la tabla y meto los campos a dicha tabla
                DefaultTableModel model = (DefaultTableModel) jTbl_CamposParaCruceSelecionar.getModel();
                model.addColumn("Nombre del Campo");
                model.addColumn("Tipo de Dato");
                model.addColumn("Longitud del Campo");
                String campos_en_string = "";//servir?? para hacer .split
                String[] split;
                for (int i = 0; i < campos_para_cruzar.size(); i++) {
                    Object[] new_row = new Object[model.getColumnCount()];
                    campos_en_string
                            += (campos_para_cruzar.get(i).getNombre() + "??"
                            + campos_para_cruzar.get(i).getTipo_de_dato() + "??"
                            + campos_para_cruzar.get(i).getLongitud());
                    System.out.println(campos_para_cruzar.get(i).getNombre() + "??");
                    System.out.println(campos_para_cruzar.get(i).getTipo_de_dato() + "??");
                    System.out.println(campos_para_cruzar.get(i).getLongitud() + "??");
                    split = campos_en_string.split("??");
                    campos_en_string = "";
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        new_row[j] = split[j];
                    }//fin for
                    model.addRow(new_row);
                }//fin for
                jTbl_CamposParaCruceSelecionar.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "No es posible cruzar los archivos prque no existe una relaci??n de campos entre ambos archivos");
            }//fin if interior
        } else {
            JOptionPane.showMessageDialog(this, "Todav??a no has seleccionado un archivo para cruzar.");
        }      // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        if (jTbl_CamposParaCruceSelecionar.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "No existen mas campos para cruzar.");
        } else if (jTbl_CamposParaCruceSelecionar.getSelectedRow() >= 0) {
            //campos_para_cruzar.remove(jTbl_CamposParaCruceSelecionar.getSelectedRow());
            String nombre_campo = jTbl_CamposParaCruceSelecionar.getValueAt(jTbl_CamposParaCruceSelecionar.getSelectedRow(), 0).toString();
            DefaultTableModel modelo = (DefaultTableModel) jTbl_CamposCruzados.getModel();
            modelo.addColumn(nombre_campo);
            jTbl_CamposCruzados.setModel(modelo);
            cont++;
        } else {
            JOptionPane.showMessageDialog(this, "No has seleccionado un campo de la tabla.");
        }        // TODO add your handling code here:

    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // CIERRA EL ARCHIVO Y PREGUNTA SI SE DESEA GUARDAR O NO
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
                    JOptionPane.showMessageDialog(null, "??Se ha creado su archivo exitosamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede crear el archivo porque ya existe");
                } // Fin If
            } // Fin If
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File archivo_abrir = null;
            FileReader fr = null;
            BufferedReader br = null;
            TA_ArchivoAbierto.setText("");
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
                        listar_campos();
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
                this.setVisible(false);
            }
        } catch (Exception e) {
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
            listar_campos();
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
        String nombre_campo = jTbl_CamposParaCruceSelecionar.getValueAt(jTbl_CamposParaCruceSelecionar.getSelectedRow(), 0).toString();
        for (int i = 0; i < cont; i++) {
            if (campos_para_cruzar.get(i).getNombre().equals(nombre_campo)) {
                try {
                    salvado = true;
                    boolean existe = false;
                    String nombre = campos_para_cruzar.get(i).getNombre();
                    // Validacion del campo para ver si el nombre ya existe
                    for (int j = 0; j < campos_nuevos.size(); j++) {
                        if (campos_nuevos.get(j).getNombre().equals(nombre)) {
                            existe = true;
                        } // Fin If
                    }// Fin For
                    String tipo_de_dato = campos_para_cruzar.get(i).getTipo_de_dato();
                    int longitud = campos_para_cruzar.get(i).getLongitud();
                    boolean llave_primaria = campos_para_cruzar.get(i).isLlavePrimaria();
                    boolean llave_secundaria = campos_para_cruzar.get(i).isLlave_secundaria();
                    int ID_campo, ID_archivo;
                    ID_campo = GenerarIDCampo();
                    ID_archivo = archivo_actual.getID();
                    Campo campo_nuevo = new Campo(ID_campo, ID_archivo, nombre, tipo_de_dato, longitud, llave_primaria, llave_secundaria);
                    JOptionPane.showMessageDialog(null, "Archivo cruzado exitosamente");
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
                        listar_campos();
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
                    // Fin If
                } catch (Exception e) {
                    e.printStackTrace();
                }
////                lineacampos = campos_para_cruzar.get(i).getNombre() + "??" + campos_para_cruzar.get(i).getTipo_de_dato() + "??" + campos_para_cruzar.get(i).getLongitud() + "??" + campos_para_cruzar.get(i).isLlavePrimaria() + "??" + campos_para_cruzar.get(i).isLlave_secundaria() + "??";
//                try {
//                    salvado = true;
//                    boolean existe = false;
//                    String nombre = campos_para_cruzar.get(i).getNombre();
//                    // Validacion del campo para ver si el nombre ya existe
//                    for (int j = 0; j < campos_nuevos.size(); j++) {
//                        if (campos_nuevos.get(j).getNombre().equals(nombre)) {
//                            existe = true;
//                        } // Fin If
//                    }// Fin For
//                    String tipo_de_dato;
//                    int longitud;
//                    tipo_de_dato = campos_para_cruzar.get(i).getTipo_de_dato();
//                    longitud = campos_para_cruzar.get(i).getLongitud();
//                    boolean llave_primaria = campos_para_cruzar.get(i).isLlavePrimaria();
//                    boolean llave_secundaria = campos_para_cruzar.get(i).isLlave_secundaria();
//                    int ID_campo, ID_archivo;
//                    ID_campo = GenerarIDCampo();
//                    ID_archivo = archivo_actual.getID();
//                    Campo campo_nuevo = new Campo(ID_campo, ID_archivo, nombre, tipo_de_dato, longitud, llave_primaria, llave_secundaria);
//                    try {
//                        // Actualiza el Text Area
//                        FileReader fr = null;
//                        BufferedReader br = null;
//                        fr = new FileReader(archivo_actual.getArchivo());
//                        br = new BufferedReader(fr);
//                        TA_ArchivoAbierto.setText("");
//                        String linea;
//                        while ((linea = br.readLine()) != null) {
//                            TA_ArchivoAbierto.append(linea);
//                        } // Fin While
//                        try {
//                            br.close();
//                            fr.close();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        } // Fin Try Catch
//                        // Actualiza el file dentro del archivo binario
//                        EscribirCamposBinario();
//                        formatear_CBbox_Modificar();
//                        formatear_CBbox_borrar();
//                        listar_campos();
//                        if (secreo == true || semodifico == true || seborro == true) {
//                            JOptionPane.showMessageDialog(null, "Archivo Salvado Exitosamente");
//                        } // Fin If
//                        secreo = false;
//                        semodifico = false;
//                        seborro = false;
//                        salvado = false;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        }

    }//GEN-LAST:event_jButton26ActionPerformed
    private void GenerarPersonFile() {

        try {
            String lineacampos;
            // Obtenemos los campos en "duro" y los guardamos en un arreglo
            lineacampos = "PersonId??int??6??Si??No&PersonName??String??20??No??No&PersonAge??int??3??No??No&CityId??int??2??No??Si??";
            String[] campos = lineacampos.split("\\&");
            // Guarda el archivo actual en el binario con los demas archivos
            aa.cargarArchivo();
            int ID;
            ID = aa.GenerarId();
            archivo_actual = new Archivo(new File("PersonFile.txt"), ID);
            GuardarArchivo = "PersonFile.txt";
            aa.AddArchivo(archivo_actual);
            aa.escribirArchivo();
            for (int i = 0; i < campos.length; i++) {
                // De la linea de un campo luego necesitamos darle split a los atributos del campo 
                String[] campos2 = campos[i].split("\\??");
                String nombreCampo = campos2[0];
                String tipoCampo = campos2[1];
                int longitudCampo = (Integer.parseInt(campos2[2]));
                boolean llavePrimaria, llaveSecundaria;
                llavePrimaria = false;
                llaveSecundaria = false;
                if (campos2[3].equals("Si")) {
                    llavePrimaria = true;
                }// Fin If
                if (campos2[4].equals("Si")) {
                    llaveSecundaria = true;
                }// Fin If                
                // Seteamos dichos campos en el archivo actual
                int IDCampo;
                IDCampo = GenerarIDCampo();
                Campo campo = new Campo(ID, IDCampo, nombreCampo, tipoCampo, longitudCampo, llavePrimaria, llaveSecundaria);
                archivo_actual.addCampo(campo);
                aa.cargarArchivo();
                for (Archivo archivo : aa.getLista_archivos()) {
                    if (archivo.getID() == archivo_actual.getID()) {
                        archivo.addCampo(campo);
                        break;
                    } // Fin If
                } // Fin For
                aa.escribirArchivo();
            } // Fin For
            ArrayList<String> PersonFirstName = new ArrayList();
            // Se generan 100 nombres aleatorios
            PersonFirstName.add("Sahory");
            PersonFirstName.add("Skarleth");
            PersonFirstName.add("Jesus");
            PersonFirstName.add("Ariel");
            PersonFirstName.add("Gustavo");
            PersonFirstName.add("Antonio");
            PersonFirstName.add("Daniela");
            PersonFirstName.add("Samantha");
            PersonFirstName.add("Hugo");
            PersonFirstName.add("Mateo");
            PersonFirstName.add("Estefania");
            PersonFirstName.add("Fanny");
            PersonFirstName.add("Santiago");
            PersonFirstName.add("Samir");
            PersonFirstName.add("Katherin");
            PersonFirstName.add("Kathia");
            PersonFirstName.add("Lionel");
            PersonFirstName.add("Andres");
            PersonFirstName.add("Daniela");
            PersonFirstName.add("Karla");
            PersonFirstName.add("Cristiano");
            PersonFirstName.add("Ronaldo");
            PersonFirstName.add("Sofia");
            PersonFirstName.add("Amanda");
            PersonFirstName.add("Juan");
            PersonFirstName.add("Roman");
            PersonFirstName.add("Ammy");
            PersonFirstName.add("Sara");
            PersonFirstName.add("Josue");
            PersonFirstName.add("Alberto");
            PersonFirstName.add("Michell");
            PersonFirstName.add("Cristina");
            PersonFirstName.add("Carlos");
            PersonFirstName.add("Omar");
            PersonFirstName.add("Jimena");
            PersonFirstName.add("Jireth");
            PersonFirstName.add("David");
            PersonFirstName.add("Jason");
            PersonFirstName.add("Karoline");
            PersonFirstName.add("Camila");
            PersonFirstName.add("Eduartdo");
            PersonFirstName.add("Ricardo");
            PersonFirstName.add("Vianka");
            PersonFirstName.add("Abigail");
            PersonFirstName.add("Aldair");
            PersonFirstName.add("Armando");
            PersonFirstName.add("Gloria");
            PersonFirstName.add("Doris");
            PersonFirstName.add("Jorge");
            PersonFirstName.add("Francisco");
            PersonFirstName.add("Nicolle");
            PersonFirstName.add("Issis");
            PersonFirstName.add("Manuel");
            PersonFirstName.add("Gerardo");
            PersonFirstName.add("Shadde");
            PersonFirstName.add("Aleeiya");
            PersonFirstName.add("Tomas");
            PersonFirstName.add("Luis");
            PersonFirstName.add("Fabian");
            PersonFirstName.add("Sandra");
            PersonFirstName.add("Mabel");
            PersonFirstName.add("Javier");
            PersonFirstName.add("Camilo");
            PersonFirstName.add("Valeria");
            PersonFirstName.add("Marina");
            PersonFirstName.add("Marcelo");
            PersonFirstName.add("Jonathan");
            PersonFirstName.add("Maribel");
            PersonFirstName.add("Nadir");
            PersonFirstName.add("Jose");
            PersonFirstName.add("Edgardo");
            PersonFirstName.add("Maria");
            PersonFirstName.add("Ester");
            PersonFirstName.add("Hector");
            PersonFirstName.add("Herson");
            PersonFirstName.add("Alondra");
            PersonFirstName.add("Bessy");
            PersonFirstName.add("Patricio");
            PersonFirstName.add("bob");
            PersonFirstName.add("Mario");
            PersonFirstName.add("Angelina");
            PersonFirstName.add("Angela");
            PersonFirstName.add("Lana");
            PersonFirstName.add("Paulo");
            PersonFirstName.add("Diego");
            PersonFirstName.add("Irene");
            PersonFirstName.add("Angelica");
            PersonFirstName.add("Edwin");
            PersonFirstName.add("Erick");
            PersonFirstName.add("Ericka");
            PersonFirstName.add("Marcela");
            PersonFirstName.add("Mauricio");
            PersonFirstName.add("Fabricio");
            PersonFirstName.add("Yadira");
            PersonFirstName.add("Yanira");
            PersonFirstName.add("Joaquin");
            PersonFirstName.add("Anthony");
            PersonFirstName.add("Ezequiel");
            PersonFirstName.add("Dua");
            PersonFirstName.add("Olivia");
            PersonFirstName.add("Alicia");
            ArrayList<String> PersonLastName = new ArrayList();
            // Se generan 100 apellidos aleatorios
            PersonLastName.add("Cano");
            PersonLastName.add("Herrera");
            PersonLastName.add("Meraz");
            PersonLastName.add("Duarte");
            PersonLastName.add("Pineda");
            PersonLastName.add("Orellana");
            PersonLastName.add("Martinez");
            PersonLastName.add("Perez");
            PersonLastName.add("Hernandez");
            PersonLastName.add("Rodriguez");
            PersonLastName.add("Figueroa");
            PersonLastName.add("Sorto");
            PersonLastName.add("Castillo");
            PersonLastName.add("Lopez");
            PersonLastName.add("Morales");
            PersonLastName.add("Ortiz");
            PersonLastName.add("Torres");
            PersonLastName.add("Espinal");
            PersonLastName.add("Flores");
            PersonLastName.add("Murillo");
            PersonLastName.add("Fuentes");
            PersonLastName.add("Espinoza");
            PersonLastName.add("Paz");
            PersonLastName.add("Messi");
            PersonLastName.add("Nu??ez");
            PersonLastName.add("Cuccitini");
            PersonLastName.add("Cortez");
            PersonLastName.add("Velasquez");
            PersonLastName.add("Mendoza");
            PersonLastName.add("Valle");
            PersonLastName.add("Vergara");
            PersonLastName.add("Navarro");
            PersonLastName.add("Gallardo");
            PersonLastName.add("Do Santos");
            PersonLastName.add("Orellana");
            PersonLastName.add("Oliva");
            PersonLastName.add("Salazar");
            PersonLastName.add("Aquilar");
            PersonLastName.add("Aguilera");
            PersonLastName.add("Caceres");
            PersonLastName.add("Godoy");
            PersonLastName.add("Romero");
            PersonLastName.add("Lagos");
            PersonLastName.add("Medina");
            PersonLastName.add("Fernandez");
            PersonLastName.add("Bustillo");
            PersonLastName.add("Moreno");
            PersonLastName.add("Carvajal");
            PersonLastName.add("Ponce");
            PersonLastName.add("Ochoa");
            PersonLastName.add("Leiva");
            PersonLastName.add("Ruiz");
            PersonLastName.add("Rivera");
            PersonLastName.add("Rivera");
            PersonLastName.add("Brito");
            PersonLastName.add("Estrada");
            PersonLastName.add("Rico");
            PersonLastName.add("Otero");
            PersonLastName.add("Castellano");
            PersonLastName.add("Sevilla");
            PersonLastName.add("Villalobos");
            PersonLastName.add("Lainez");
            PersonLastName.add("Zapata");
            PersonLastName.add("Bruschi");
            PersonLastName.add("Mejia");
            PersonLastName.add("Mondragon");
            PersonLastName.add("Melendez");
            PersonLastName.add("Fiallos");
            PersonLastName.add("Diaz");
            PersonLastName.add("Barrientos");
            PersonLastName.add("Guardado");
            PersonLastName.add("Rios");
            PersonLastName.add("Galvan");
            PersonLastName.add("Coleman");
            PersonLastName.add("Vargas");
            PersonLastName.add("Rosa");
            PersonLastName.add("Casta??eda");
            PersonLastName.add("Jimenez");
            PersonLastName.add("Juearez");
            PersonLastName.add("Avila");
            PersonLastName.add("Lozano");
            PersonLastName.add("Benitez");
            PersonLastName.add("Campos");
            PersonLastName.add("Sanchez");
            PersonLastName.add("Ramirez");
            PersonLastName.add("Castro");
            PersonLastName.add("Pecas");
            PersonLastName.add("Sousa");
            PersonLastName.add("Fonseca");
            PersonLastName.add("Rojas");
            PersonLastName.add("Rubio");
            PersonLastName.add("Bravo");
            PersonLastName.add("Grant");
            PersonLastName.add("Sifuentes");
            PersonLastName.add("Beltran");
            PersonLastName.add("Higuita");
            PersonLastName.add("Maradona");
            PersonLastName.add("Palommo");
            BTree Btreepersons_secundario = new BTree(6);
            Archivoconarbolb archivo_prueba = new Archivoconarbolb(archivo_actual.getArchivo(), archivo_actual.getID());
            Archivoarbolsecundario archivo_prueba_secundario = new Archivoarbolsecundario(archivo_actual.getArchivo(), archivo_actual.getID(), Btreepersons_secundario);
            RandomAccessFile flujo = new RandomAccessFile(new File("PersonFile.txt"), "rw");
            BTree BTreePersons = new BTree(6);
            String metadata2;
            metadata2 = "PersonId??int??6??Si??No&PersonName??String??20??No??No&PersonAge??int??3??No??No&CityId??int??2??No??Si??";
            metadata2 += LlenadoEspacios(metadata2.length(), 250);
            StringBuffer sbmetadata = new StringBuffer(metadata2);
            sbmetadata.setLength(250);
            flujo.writeChars(sbmetadata.toString());
            // Escribimos los campos en "duro" dentro del archivo
            random = new Random();
            int personID;
            personID = 1;
            long RRN;
            String nombre, apellido, registro, primaryKey, secondaryKey;
            int edad, cityID;
            for (int i = 1; i <= 10000; i++) {
                // Se iran escribiendo de forma aleatoria los registros dentro del archivo
                nombre = PersonFirstName.get((int) Math.floor(Math.random() * 90));
                apellido = PersonLastName.get((int) Math.floor(Math.random() * 90));
                edad = 1 + random.nextInt(99);
                cityID = 1 + random.nextInt(50);
                registro = personID + "|" + nombre + " " + apellido + "|" + edad + "|" + cityID + "|";
                // Llena de espacios si no se completaron los 35 caracteres
                registro += LlenadoEspacios(registro.length(), 35);
                StringBuffer sb = new StringBuffer(registro);
                sb.setLength(35);
                flujo.writeChars(sb.toString());
                RRN = setRrn();
                // Obtenemos la llave primaria para poder insertarla en el arbolB
                primaryKey = String.valueOf(personID);
                primaryKey = espacios.substring(0, 6 - primaryKey.length()) + primaryKey;
                BTreePersons.B_Tree_Insert(primaryKey, RRN);
                personID++;
//                 Obtenemos la llave secundaria para poder insertarla en el arbolB
                secondaryKey = String.valueOf(cityID);
                secondaryKey = espacios.substring(0, 2 - secondaryKey.length()) + secondaryKey;
                if (Btreepersons_secundario.B_Tree_Search(Btreepersons_secundario.getRaiz(), secondaryKey) == null) {
                    Btreepersons_secundario.B_Tree_Insert(secondaryKey, RRN);
                }
            } // Fin For
            // Escrbir en el archivoconArbolB
            archivo_prueba.setArbol(BTreePersons);
            // Escribir en el binario de arbol
            arboles.cargarArchivo();
            arboles.getListaarboles().add(archivo_prueba);
            arboles.escribirArchivo();
            arbol_actual = BTreePersons;
            //
            archivo_prueba_secundario.setArbolSecundario(Btreepersons_secundario);
            // Escribir en el binario de arbol
            arbolessecundarios.cargarArchivo();
            arbolessecundarios.getListaarboles().add(archivo_prueba_secundario);
            arbol_secundarioactual = Btreepersons_secundario;
            arbolessecundarios.escribirArchivo();
            GenerarCityFile();
            JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GenerarCityFile() {
        try {
            String lineacampos;
            // Obtenemos los campos en "duro"y los guardamos en un arreglo
            lineacampos = "CityId??int??2??Si??No&CityName??char??30??No??No??";
            String[] campos = lineacampos.split("\\&");
            // Guarda el archivo actual en el binario con los demas archivos
            aa.cargarArchivo();
            int ID;
            ID = aa.GenerarId();
            Archivo archivoC = new Archivo(new File("CityFile.txt"), ID);
            aa.AddArchivo(archivoC);
            aa.escribirArchivo();
            for (int i = 0; i < campos.length; i++) {
                // De la linea de un campo luego necesitamos darle split a los atributos del campo 
                String[] campos2 = campos[i].split("\\??");
                String nombreCampo = campos2[0];
                String tipoCampo = campos2[1];
                int longitudCampo = (Integer.parseInt(campos2[2]));
                boolean llavePrimaria, llaveSecundaria;
                llavePrimaria = false;
                llaveSecundaria = false;
                if (campos2[3].equals("Si")) {
                    llavePrimaria = true;
                }// Fin If
                if (campos2[4].equals("Si")) {
                    llaveSecundaria = true;
                }// Fin If                
                // Seteamos dichos campos en el archivo actual
                int IDCampo;
                IDCampo = GenerarIDCampo();
                Campo campo = new Campo(ID, IDCampo, nombreCampo, tipoCampo, longitudCampo, llavePrimaria, llaveSecundaria);
                aa.cargarArchivo();
                for (Archivo archivo : aa.getLista_archivos()) {
                    if (archivo.getID() == archivoC.getID()) {
                        archivo.addCampo(campo);
                        break;
                    } // Fin If
                } // Fin For
                aa.escribirArchivo();
            } // Fin For
            ArrayList<String> CityName = new ArrayList();
            // Se generan 100 ciudades aleatorias
            CityName.add("Tokio");
            CityName.add("Nueva York");
            CityName.add("Los Angeles");
            CityName.add("Paris");
            CityName.add("Seul");
            CityName.add("Londres");
            CityName.add("Osaka");
            CityName.add("Shanghai");
            CityName.add("Chicago");
            CityName.add("Moscu");
            CityName.add("Pekin");
            CityName.add("Colonia");
            CityName.add("Houston");
            CityName.add("Washington D.C.");
            CityName.add("Sao Paulo");
            CityName.add("Hong Kong");
            CityName.add("Dallas");
            CityName.add("Ciudad de Mexico");
            CityName.add("Canton");
            CityName.add("Singapur");
            CityName.add("Boston");
            CityName.add("Estambul");
            CityName.add("Filadelfia");
            CityName.add("San Francisco");
            CityName.add("Taipei");
            CityName.add("Amsterdam");
            CityName.add("Buenos Aires");
            CityName.add("Milan");
            CityName.add("Bangkok");
            CityName.add("Atalanta");
            CityName.add("Barcelona");
            CityName.add("Liverpool");
            CityName.add("Madrid");
            CityName.add("Delhi");
            CityName.add("Tegucigalpa");
            CityName.add("Lisboa");
            CityName.add("Las Vegas");
            CityName.add("Manchester");
            CityName.add("Lyon");
            CityName.add("Venecia");
            CityName.add("Praga");
            CityName.add("Dubai");
            CityName.add("Turin");
            CityName.add("Guadalajara");
            CityName.add("Oslo");
            CityName.add("Bucarest");
            CityName.add("Memphis");
            CityName.add("Ottawa");
            CityName.add("Valencia");
            CityName.add("Florencia");
            CityName.add("Alejandria");
            CityName.add("Bremen");
            CityName.add("Bristol");
            CityName.add("Niza");
            CityName.add("Ginebra");
            CityName.add("Sofia");
            CityName.add("Oporto");
            CityName.add("Leipzig");
            CityName.add("Sevilla");
            CityName.add("Quebec");
            CityName.add("Nantes");
            CityName.add("Zagreb");
            CityName.add("Kuala Lumpur");
            CityName.add("Zaragoza");
            CityName.add("Murcia");
            CityName.add("San Pedro Sula");
            CityName.add("La Esperanza");
            CityName.add("Bilbao");
            CityName.add("Kiev");
            CityName.add("San Petersburgo");
            CityName.add("Atenas");
            CityName.add("Francfort");
            CityName.add("Basilea");
            CityName.add("Gotemburgo");
            CityName.add("Auckland");
            CityName.add("Wellington");
            CityName.add("Stuttgart");
            CityName.add("La Ceiba");
            CityName.add("Comayagua");
            CityName.add("El Progreso");
            CityName.add("Choloma");
            CityName.add("Danli");
            CityName.add("La Lima");
            CityName.add("Juticalpa");
            CityName.add("Tela");
            CityName.add("Trujillo");
            CityName.add("Catacamas");
            CityName.add("Omoa");
            CityName.add("Tocoa");
            CityName.add("Talanga");
            CityName.add("Virginia");
            CityName.add("Marcala");
            CityName.add("Yuscaran");
            CityName.add("Puerto Lempira");
            CityName.add("Gracias");
            CityName.add("Amapala");
            CityName.add("San Diego");
            CityName.add("Montevideo");
            CityName.add("Marsella");
            CityName.add("Minsk");
            CityName.add("Riga");
            Collections.shuffle(CityName);
            aa.escribirArchivo();
            RandomAccessFile flujo = new RandomAccessFile(new File("CityFile.txt"), "rw");
            String metadata2;
            metadata2 = "CityId??int??2??Si??No&CityName??char??30??No??No??";
            metadata2 += LlenadoEspacios(metadata2.length(), 250);
            StringBuffer sbmetadata = new StringBuffer(metadata2);
            sbmetadata.setLength(250);
            flujo.writeChars(sbmetadata.toString());
            String registro, primaryKey;
            for (int i = 0; i <= 99; i++) {
                if (i <= 9) {
                    registro = "0" + i + "|" + CityName.get(i) + "|";
                    registro += LlenadoEspacios(registro.length(), 34);
                    primaryKey = "0" + i;
                } else {
                    registro = i + "|" + CityName.get(i) + "|";
                    registro += LlenadoEspacios(registro.length(), 34);
                    primaryKey = i + "";
                } // Fin If
                StringBuffer sb = new StringBuffer(registro);
                sb.setLength(34);
                flujo.writeChars(sb.toString());
                primaryKey = espacios.substring(0, 2 - primaryKey.length()) + primaryKey;
            } // Fin For            
            flujo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean ValidaciondeingresoTabla(JTable tabla, boolean guardar) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        if (tabla.isEditing()) {
            tabla.getCellEditor().stopCellEditing();
        } // Fin If
        if (model.getRowCount() != 0) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                if (model.getValueAt(model.getRowCount() - 1, i) == null) {
                    if (guardar) {
                        model.removeRow(model.getRowCount() - 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "No puede dejar ningun campo vacio!");
                        return false;
                    } // Fin If
                } // Fin If
                if (model.getValueAt(model.getRowCount() - 1, i).toString().length() > archivo_actual.getCampos().get(i).getLongitud()) {
                    JOptionPane.showMessageDialog(null, "En el campo \""
                            + archivo_actual.getCampos().get(i).getNombre() + "\" se esta pasando de la longitud maxima"
                            + " que es " + archivo_actual.getCampos().get(i).getLongitud());
                    model.setValueAt("", model.getRowCount() - 1, i);
                    return false;
                } // Fin If
                if ("int".equals(archivo_actual.getCampos().get(i).getTipo_de_dato())) {
                    try {
                        Integer.parseInt(model.getValueAt(model.getRowCount() - 1, i).toString());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "En el campo \""
                                + archivo_actual.getCampos().get(i).getNombre()
                                + "\" esta ingresando caracteres y solo se permiten enteros!");
                        return false;
                    } // Fin Try Catch
                } // Fin If
            } // Fin For
        } // Fin If
        return true;
    }

    public String LlenadoEspacios(int tamRegistro, int tamRegistroMaximo) {
        String acum = "";
        for (int i = tamRegistro; i < tamRegistroMaximo; i++) {
            acum += " ";
        } // Fin For
        return acum;
    }

    public String llenar(int n) {
        int lengthT = 0;
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            lengthT += archivo_actual.getCampos().get(i).getLongitud();
        } // Fin For
        String spaces = "";
        for (int i = n; i < lengthT + archivo_actual.getCampos().size(); i++) {
            spaces += " ";
        } // Fin For
        return spaces;
    }

    private int guardarRegistro(String registro) throws FileNotFoundException, IOException {
        int rrn = setRrn();
        if (archivo_actual.getAvailList().isEmpty()) {
            try {
                RandomAccessFile flujo = new RandomAccessFile(new File(archivo_actual.getArchivo().getAbsolutePath()), "rw");
                registro += LlenadoEspacios(registro.length(), tam_registro());
                StringBuffer sbregistro = new StringBuffer(registro);
                sbregistro.setLength(tam_registro());
                flujo.seek(rrn);
                flujo.writeChars(sbregistro.toString());
                return rrn;
            } catch (IOException ex) {
                ex.printStackTrace();
            } // Fin Try Catch
        } else {
            try {
                rrn = (int) archivo_actual.getAvailList().peekLast();
                aa.cargarArchivo();
                for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                    if (aa.getLista_archivos().get(i).getID() == archivo_actual.getID()) {
                        aa.getLista_archivos().get(i).getAvailList().removeLast();
                        archivo_actual = aa.getLista_archivos().get(i);
                        break;
                    } // Fin If
                } // Fin For
                aa.escribirArchivo();
                RandomAccessFile flujo = new RandomAccessFile(new File(archivo_actual.getArchivo().getAbsolutePath()), "rw");
                registro += LlenadoEspacios(registro.length(), tam_registro());
                StringBuffer sbregistro = new StringBuffer(registro);
                sbregistro.setLength(tam_registro());
                flujo.seek(rrn);
                flujo.writeChars(sbregistro.toString());
                if (!archivo_actual.getAvailList().isEmpty()) {
                    int rrn2 = (int) archivo_actual.getAvailList().peekLast();
                    RandomAccessFile raf = new RandomAccessFile(new File(archivo_actual.getArchivo().getAbsolutePath()), "rw");
                    String cabeza_availist = Integer.toString(rrn2);
                    StringBuffer sbcabeza = new StringBuffer(cabeza_availist);
                    sbcabeza.setLength(50);
                    raf.seek((archivo_actual.getSizeMetadata() + 1) * 2);
                    raf.writeChars(sbcabeza.toString());
                } else {
                    RandomAccessFile raf = new RandomAccessFile(new File(archivo_actual.getArchivo().getAbsolutePath()), "rw");
                    String cabeza_availist = "-1";
                    StringBuffer sbcabeza = new StringBuffer(cabeza_availist);
                    sbcabeza.setLength(50);
                    raf.seek((archivo_actual.getSizeMetadata() + 1) * 2);
                    raf.writeChars(sbcabeza.toString());
                } // Fin If
                return rrn;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } // Fin Try Catch
        } // Fin If
        return rrn;
    }

    private int getPosKey() {
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            if (archivo_actual.getCampos().get(i).isLlavePrimaria()) {
                return i;
            } // Fin If
        } // Fin For
        return -1;
    }

    private int setRrn() {
        aa.cargarArchivo();
        if (archivo_actual.getAvailList().isEmpty()) {
            int pos_archivo = 0;
            for (int i = 0; i < aa.getLista_archivos().size(); i++) {
                if (aa.getLista_archivos().get(i).getID() == archivo_actual.getID()) {
                    pos_archivo = i;
                    break;
                } // Fin If
            } // Fin For
            if (aa.getLista_archivos().get(pos_archivo).getCant_Registros() == 0) {
                aa.cargarArchivo();
                int rrn = 500;
                aa.getLista_archivos().get(pos_archivo).setCant_Registros(true);
                archivo_actual = aa.getLista_archivos().get(pos_archivo);
                aa.escribirArchivo();
                return rrn;
            } else {
                aa.cargarArchivo();
                int rrn = (250 + (tam_registro() * aa.getLista_archivos().get(pos_archivo).getCant_Registros())) * 2;
                aa.getLista_archivos().get(pos_archivo).setCant_Registros(true);
                archivo_actual = aa.getLista_archivos().get(pos_archivo);
                aa.escribirArchivo();
                return rrn;
            } // Fin If
        } // Fin If
        return (int) archivo_actual.getAvailList().peekFirst();
    }

    private int tam_registro() {
        int length = 0;
        for (Campo campo : archivo_actual.getCampos()) {
            length += campo.getLongitud();
        } // Fin For
        return length + archivo_actual.getCampos().size();
    }
    ArrayList<Long> rrn_llaves_en_orden = new ArrayList();

    public void listar_registros() {
        jTbl_ListarRegistros1.setModel(new DefaultTableModel());
        DefaultTableModel model = (DefaultTableModel) jTbl_ListarRegistros1.getModel();
        for (int i = 0; i < archivo_actual.getCampos().size(); i++) {
            model.addColumn(archivo_actual.getCampos().get(i).getNombre());
        } // Fin For

        jTbl_ListarRegistros1.setModel(model);
        for (int i = retroceder; i < avanzar && i < rrn_llaves_en_orden.size(); i++) {
            long RRN = rrn_llaves_en_orden.get(i);
            try {
                String data = leerregistro(Math.toIntExact(RRN));
                String arr[] = data.split("\\|");
                Object arr2[] = new Object[model.getColumnCount()];
                for (int j = 0; j < model.getColumnCount(); j++) {
                    arr2[j] = arr[j];
                } // Fin For
                model.addRow(arr2);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } // Fin Try Catchs
        } // Fin For
    }

    private String leerregistro(int RRN) throws FileNotFoundException, IOException {
        File archivo = new File(archivo_actual.getArchivo().getAbsolutePath());
        RandomAccessFile af = new RandomAccessFile(archivo, "rw");
        String linea = "";
        af.seek(RRN);//
        for (int i = 0; i < tam_registro(); i++) {
            linea += af.readChar();
        } // Fin For
        return linea;
    }

    private void Modificar(String data, int rrn) throws FileNotFoundException, IOException {
        RandomAccessFile flujo = new RandomAccessFile(new File(archivo_actual.getArchivo().getAbsolutePath()), "rw");
        data += LlenadoEspacios(data.length(), tam_registro());
        StringBuffer sbregistro = new StringBuffer(data);
        sbregistro.setLength(tam_registro());
        flujo.seek(rrn);
        flujo.writeChars(sbregistro.toString());
    }

    private String rrnAsString(int rrn) {
        String rrnString = "";
        rrnString += rrn;
        for (int i = rrnString.length(); i < 5; i++) {
            rrnString += '.';
        } // Fin For
        return rrnString;
    }

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
    private javax.swing.JButton Btn_abrir_archivo;
    private javax.swing.JComboBox<String> CB_CampoABorrar;
    private javax.swing.JComboBox<String> CB_CampoAModificar;
    private javax.swing.JComboBox<String> CB_LlavesBuscarRegistros;
    private javax.swing.JComboBox<String> CB_LlavesModificarRegistro;
    private javax.swing.JComboBox<String> CB_TipoDeDatoDelCampo;
    private javax.swing.JComboBox<String> CB_TipoDeDatoDelCampoModificado;
    private javax.swing.JDialog JD_Agregar_registro;
    private javax.swing.JDialog JD_Buscar_registro;
    private javax.swing.JDialog JD_Crearcampo;
    private javax.swing.JDialog JD_Cruzar_Archivo;
    private javax.swing.JDialog JD_EliminarCampos;
    private javax.swing.JDialog JD_Eliminar_registro;
    private javax.swing.JDialog JD_Listar_registros;
    private javax.swing.JDialog JD_ModificarCampos;
    private javax.swing.JDialog JD_Modificar_registro;
    private javax.swing.JLabel JL_13;
    private javax.swing.JLabel JL_28;
    private javax.swing.ButtonGroup POS;
    private javax.swing.JRadioButton RB_LlavePrimariaDelCampo;
    private javax.swing.JRadioButton RB_LlavePrimariaDelCampoModificado;
    private javax.swing.JRadioButton RB_LlaveSecundariaDelCampo;
    private javax.swing.JRadioButton RB_LlaveSecundariaDelCampoModificado;
    private javax.swing.JSpinner SP_LongitudDelCampo;
    private javax.swing.JSpinner SP_LongitudDelCampoModificado;
    private javax.swing.JTextArea TA_ArchivoAbierto;
    private javax.swing.JTextArea TA_ListarCampos1;
    private javax.swing.JTextField TF_LlaveModificarRegistro;
    private javax.swing.JTextField TF_NombreDelCampo;
    private javax.swing.JTextField TF_NombreDelCampoModificado;
    private javax.swing.JTable TablaBuscarRegistro;
    private javax.swing.JTable TablaEliminarRegistro;
    private javax.swing.JTable TablaModificarRegistro;
    private javax.swing.ButtonGroup TipoDato;
    private javax.swing.ButtonGroup TipoDatoModificar;
    private javax.swing.ButtonGroup TipoLLaveModificar;
    private javax.swing.ButtonGroup TipoLlave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jCb_llavesEliminarRegistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
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
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTbl_CamposCruzados;
    private javax.swing.JTable jTbl_CamposParaCruceSelecionar;
    private javax.swing.JTable jTbl_ListarRegistros1;
    private javax.swing.JTable jTbl_tablaRegistros;
    private javax.swing.JTextField jTf_LLaveEliminarRegistros;
    private javax.swing.JTextField jTf_buscarRegistros;
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
    private javax.swing.JMenuItem jmi_Mod_Campo;
    private javax.swing.JMenuItem jmi_Nuevo_Archivo;
    private javax.swing.JMenuItem jmi_Salir;
    private javax.swing.JMenuItem jmi_Salvar_Archivo;
    private javax.swing.JMenuItem jmi_crearindices;
    private javax.swing.JMenuItem jmi_modreg;
    private javax.swing.JMenuItem jmi_reindexar;
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
    private String espacios = new String(new char[1024]).replace('\0', ' ');
    private int avanzar = 0;
    private int retroceder = 0;
    private ArrayList<Long> rrnsbuscar;
    private int rrnModificar = 0;
    private String llaveprimariaTemp;
    private String llavesecundariaTemp;
    private int rrnabuscar = 0;
    Archivo archivo_para_cruzar = null;
    ArrayList<Campo> campos_para_cruzar = new ArrayList();
    ArrayList<Campo> campos_cruzados = new ArrayList();
    private int cont = 0;
}
