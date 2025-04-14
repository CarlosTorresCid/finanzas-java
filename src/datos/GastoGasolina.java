package datos;


import java.time.LocalDate;

public class GastoGasolina extends GastoPuntual {

    private double precioGasolina;

    public GastoGasolina(int id, String concepto, double importe, LocalDate fecha, double precioGasolina) {
        super(id, concepto, importe, fecha, "Gasolina");
        this.precioGasolina = precioGasolina;
    }

    public double getPrecioGasolina() {
        return precioGasolina;
    }

    public void setPrecioGasolina(double precioGasolina) {
        this.precioGasolina = precioGasolina;
    }

    public double calcularLitros() {
        return importe / precioGasolina;
    }
}
