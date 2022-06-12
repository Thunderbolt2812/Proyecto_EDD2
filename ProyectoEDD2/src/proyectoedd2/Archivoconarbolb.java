package proyectoedd2;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Archivoconarbolb implements Serializable {
//esta clase se hizo con el proposito de poder crear el archivo donde el arbolb se mantiene y no se elimina
//esta clase se basa en Archivo ya que tienen varios componentes similares    

    private File archivo;
    private int ID;
    private BTree arbol;

    public Archivoconarbolb() {
    } // Fin Constructor Archivo

    public Archivoconarbolb(File archivo, int ID) {
        this.archivo = archivo;
        this.ID = ID;
    } // Fin Constructor Archivo

    public BTree getArbol() {
        return arbol;
    }

    public void setArbol(int orden) {
        this.arbol = new BTree(orden);
    }

    public void setArbol(BTree arbol) {
        this.arbol = arbol;
    }

    public int getID() {
        return ID;
    } // Fin Get ID;

    public void setID(int ID) {
        this.ID = ID;
    } // Fin Set ID;

    public File getArchivo() {
        return archivo;
    } // Fin Get Archivo

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    } // Fin Set Archivo

} // Fin Clase Archivo
