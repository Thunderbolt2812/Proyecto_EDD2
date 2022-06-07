package proyectoedd2;

public class Caracter extends Campo{
    protected Character valor;

    public Caracter(String nombreCampo) {
        super(nombreCampo);
        this.valor = ' ';
    }

    public Caracter(Character valor) {
        this.valor = valor;
    }

    public Character getValor() {
        return valor;
    }

    public void setValor(Character valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

    @Override
    public int compareTo(Campo o) {
        Caracter comparacion = (Caracter) o;
        return this.valor.compareTo(comparacion.getValor());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Caracter)) return false;
        
        Caracter c = (Caracter) obj;
        return this.valor.equals(c.valor);
    }
}
