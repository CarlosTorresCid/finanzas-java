// datos/GastoPuntual.java
package datos;

import java.time.LocalDate;

public class GastoPuntual extends Gasto {
    private String etiqueta;

    public GastoPuntual(int id, String concepto, double importe, LocalDate fecha, String etiqueta) {
        super(id, concepto, importe, fecha, "Puntual");
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}
