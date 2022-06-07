package proyectoedd2;

public class Decimal extends Campo{
    protected Double valor;

    public Decimal() {
    }

    public Decimal(String nombreCampo) {
        super(nombreCampo);
        this.valor = 0.0;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
@Override
    public int compareTo(Campo o) {
        Decimal comparacion = (Decimal) o;
        return this.valor.compareTo(comparacion.getValor());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Decimal)) return false;
        
        Decimal c = (Decimal) obj;
        return this.valor.equals(c.valor);
    }
}
