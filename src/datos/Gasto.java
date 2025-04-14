package datos;

import java.time.LocalDate;

public class Gasto {
    protected int id;
    protected String concepto;
    protected double importe;
    protected LocalDate fecha;
    protected String tipo;
    protected boolean pagado; // Añadimos estado de pago

    public Gasto(int id, String concepto, double importe, LocalDate fecha, String tipo) {
        this.id = id;
        this.concepto = concepto;
        this.importe = importe;
        this.fecha = fecha;
        this.tipo = tipo;
        this.pagado = false; // Por defecto está sin pagar
    }

    // Getters
    public int getId() { return id; }
    public String getConcepto() { return concepto; }
    public double getImporte() { return importe; }
    public LocalDate getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    public boolean estaPagado() { return pagado; }

    // Método para pagar
    public void pagar() {
        this.pagado = true;
    }

    // Setters (si necesitas modificar luego)
    public void setImporte(double importe) { this.importe = importe; }
    public void setConcepto(String concepto) { this.concepto = concepto; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
