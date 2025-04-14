// datos/GastoMensual.java
package datos;

import java.time.LocalDate;

public class GastoMensual extends Gasto {

    public GastoMensual(int id, String concepto, double importe, LocalDate fecha) {
        super(id, concepto, importe, fecha, "Mensual");
    }

    // Si en el futuro quieres agregar métodos específicos para gastos mensuales, puedes hacerlo aquí.
}
