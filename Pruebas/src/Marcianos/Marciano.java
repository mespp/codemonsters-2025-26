package Marcianos;

public class Marciano extends Object {
    public int x, y;
    public String tipo;

    public Marciano(String tipo) {
        this.tipo = tipo;
    }

    public Marciano(String tipo, int x, int y) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    /*
    public String comoTexto() {
        String resultado = tipo + " en (" + x + ", " + y + ")";
        return resultado;
    }
    */

    public String toString() {
        return tipo + " en (" + x + ", " + y + ")";
    }
}