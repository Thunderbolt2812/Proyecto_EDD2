package proyectoedd2;

public class NodoIndice {

    private Node nodo;
    private int indice;

    public NodoIndice(Node nodo, int indice) {
        this.nodo = nodo;
        this.indice = indice;
    } // Fin Nodo Indice

    public Node getNodo() {
        return nodo;
    } // Fin Get Nodo

    public void setNodo(Node nodo) {
        this.nodo = nodo;
    } // Fin Set Nodo

    public int getIndice() {
        return indice;
    } // Fin Get Indice

    public void setIndice(int indice) {
        this.indice = indice;
    } // Fin Set Indice

}
