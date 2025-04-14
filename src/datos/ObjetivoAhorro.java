// datos/ObjetivoAhorro.java
package datos;

public class ObjetivoAhorro {
    private String nombre;
    private double cantidad;

    public ObjetivoAhorro(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public double getCantidad() { return cantidad; }
    public void agregarDinero(double cantidad) {
        this.cantidad += cantidad;
    }
}
