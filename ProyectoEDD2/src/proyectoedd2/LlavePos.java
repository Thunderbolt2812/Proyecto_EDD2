package proyectoedd2;

import java.io.Serializable;

public class LlavePos implements Serializable {

    private String llave;
    private long pos;

    public LlavePos(String llave, long pos) {
        this.llave = llave;
        this.pos = pos;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public long getPos() {
        return pos;
    }

    public void setPos(long pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "{" + "llave=" + llave + ", pos=" + pos + '}';
    }

}
