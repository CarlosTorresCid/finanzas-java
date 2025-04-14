// logica/GestorFinanzas.java
package logica;

import datos.*;
import java.util.*;
import java.time.*;

public class GestorFinanzas {
    private double dineroSinClasificar;
    private List<Ingreso> ingresos;
    private List<GastoMensual> gastosMensuales;
    private List<GastoPuntual> gastosPuntuales;
    private List<ObjetivoAhorro> objetivos;
    private int contadorGastos;

    public GestorFinanzas() {
        ingresos = new ArrayList<>();
        gastosMensuales = new ArrayList<>();
        gastosPuntuales = new ArrayList<>();
        objetivos = new ArrayList<>();
        contadorGastos = 1;
    }

    public void ingresarDinero(double cantidad) {
        Ingreso ingreso = new Ingreso(cantidad, LocalDate.now());
        ingresos.add(ingreso);
        dineroSinClasificar += cantidad;
    }

    public void agregarGastoMensual(String concepto, double importe) {
        GastoMensual gasto = new GastoMensual(contadorGastos++, concepto, importe, LocalDate.now());
        gastosMensuales.add(gasto);
    }

    // logica/GestorFinanzas.java
    public void agregarGastoPuntual(String concepto, double importe, String etiqueta, double precioGasolina) {
        GastoPuntual gasto;
        if (etiqueta.equalsIgnoreCase("Gasolina")) {
            gasto = new GastoGasolina(contadorGastos++, concepto, importe, LocalDate.now(), precioGasolina);
        } else {
            gasto = new GastoPuntual(contadorGastos++, concepto, importe, LocalDate.now(), etiqueta);
        }
        gastosPuntuales.add(gasto);
        dineroSinClasificar -= importe; // Restar el importe del gasto puntual del dinero disponible
    }

    public void eliminarGastoMensualPorId(int id) {
        gastosMensuales.removeIf(g -> g.getId() == id);
    }

    public void pagarGastoPorId(List<? extends Gasto> lista, int id) {
        for (Gasto g : lista) {
            if (g.getId() == id && !g.estaPagado()) {
                g.pagar();
                dineroSinClasificar -= g.getImporte();
                break;
            }
        }
    }

    public List<GastoMensual> getGastosMensuales() {
        return gastosMensuales; }

    public List<GastoPuntual> getGastosPuntuales() {
        return gastosPuntuales; }

    public double getDineroSinClasificar() {
        return dineroSinClasificar; }

    public List<ObjetivoAhorro> getObjetivos() {
        return objetivos; }

    public void agregarObjetivo(String nombre, double cantidad) {
        objetivos.add(new ObjetivoAhorro(nombre, cantidad));
    }
    public void agregarDineroObjetivo(String nombre, double cantidad) {
        for (ObjetivoAhorro o : objetivos) {
            if (o.getNombre().equalsIgnoreCase(nombre)) {
                if (dineroSinClasificar >= cantidad) {
                    o.agregarDinero(cantidad);
                    dineroSinClasificar -= cantidad;
                }
                break;
            }
        }
    }
}
