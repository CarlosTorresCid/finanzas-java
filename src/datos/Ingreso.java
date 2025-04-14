// datos/Ingreso.java
package datos;

import java.time.LocalDate;

public class Ingreso {
    private double cantidad;
    private LocalDate fecha;

    public Ingreso(double cantidad, LocalDate fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public double getCantidad() { return cantidad; }
    public LocalDate getFecha() { return fecha; }
}
