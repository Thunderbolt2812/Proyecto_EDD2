package proyectoedd2;

public class Entero extends Campo{
    protected Integer valor;

    public Entero() {
    }

    public Entero(String nombreCampo) {
        super(nombreCampo);
        this.valor = 0;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

    @Override
    public int compareTo(Campo o) {
        Entero comparacion = (Entero) o;
        return this.valor.compareTo(comparacion.getValor());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Entero)) return false;
        
        Entero c = (Entero) obj;
        return this.valor.equals(c.valor);
    }
}
