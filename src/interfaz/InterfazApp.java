// interfaz/InterfazApp.java
package interfaz;

import datos.GastoMensual;
import datos.GastoPuntual;
import logica.GestorFinanzas;
import java.util.*;

public class InterfazApp {
    private GestorFinanzas gestor;
    private Scanner sc;

    public InterfazApp() {
        gestor = new GestorFinanzas();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Ingresar dinero\n2. Gastos\n3. Ahorros\n4. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> ingresarDinero();
                case 2 -> menuGastos();
                case 3 -> menuAhorros();
                case 4 -> salir = true;
            }
        }
    }

    private void ingresarDinero() {
        System.out.print("Cantidad a ingresar: ");
        double cantidad = sc.nextDouble();
        gestor.ingresarDinero(cantidad);
        System.out.println("Dinero ingresado correctamente.");
    }

    private void menuGastos() {
        System.out.println("1. Gastos mensuales\n2. Gastos puntuales");
        int op = sc.nextInt();
        if (op == 1) menuGastosMensuales();
        else menuGastosPuntuales();
    }

    private void menuGastosMensuales() {
        System.out.println("1. Ver gastos\n2. Pagar\n3. Añadir\n4. Eliminar");
        int op = sc.nextInt();
        sc.nextLine(); // limpiar salto de línea

        switch (op) {
            case 1 -> {
                List<GastoMensual> lista = gestor.getGastosMensuales();
                if (lista.isEmpty()) {
                    System.out.println("No hay gastos mensuales.");
                } else {
                    for (GastoMensual g : lista) {
                        System.out.printf("ID: %d | %s | %.2f€ | %s | Pagado: %s\n",
                                g.getId(), g.getConcepto(), g.getImporte(), g.getFecha(), g.estaPagado() ? "Sí" : "No");
                    }
                }
            }
            case 2 -> {
                System.out.print("ID del gasto a pagar: ");
                int id = sc.nextInt();
                gestor.pagarGastoPorId(gestor.getGastosMensuales(), id);
                System.out.println("Gasto pagado (si existía y estaba pendiente).");
            }
            case 3 -> {
                System.out.print("Concepto: ");
                String concepto = sc.nextLine();
                System.out.print("Importe: ");
                double importe = sc.nextDouble();
                gestor.agregarGastoMensual(concepto, importe);
                System.out.println("Gasto mensual añadido.");
            }
            case 4 -> {
                System.out.print("ID del gasto a eliminar: ");
                int id = sc.nextInt();
                gestor.eliminarGastoMensualPorId(id);
                System.out.println("Gasto eliminado (si existía).");
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    private void menuGastosPuntuales() {
        System.out.println("1. Ver gastos\n2. Pagar\n3. Añadir");
        int op = sc.nextInt();
        sc.nextLine(); // Limpiar salto de línea

        switch (op) {
            case 1 -> {
                List<GastoPuntual> lista = gestor.getGastosPuntuales();
                if (lista.isEmpty()) {
                    System.out.println("No hay gastos puntuales.");
                } else {
                    for (GastoPuntual g : lista) {
                        System.out.printf("ID: %d | %s | %.2f€ | %s | Etiqueta: %s | Pagado: %s\n",
                                g.getId(), g.getConcepto(), g.getImporte(), g.getFecha(), g.getEtiqueta(), g.estaPagado() ? "Sí" : "No");
                    }
                }
            }
            case 2 -> {
                System.out.print("ID del gasto puntual a pagar: ");
                int id = sc.nextInt();
                gestor.pagarGastoPorId(gestor.getGastosPuntuales(), id);
                System.out.println("Gasto puntual pagado (si existía y estaba pendiente).");
            }
            case 3 -> {
                System.out.print("Concepto: ");
                String concepto = sc.nextLine();
                System.out.print("Importe: ");
                double importe = sc.nextDouble();
                sc.nextLine(); // Limpiar salto de línea
                System.out.print("Etiqueta (por ejemplo, Gasolina): ");
                String etiqueta = sc.nextLine();

                if (etiqueta.equalsIgnoreCase("Gasolina")) {
                    System.out.print("Precio de la gasolina: ");
                    double precioGasolina = sc.nextDouble();
                    gestor.agregarGastoPuntual(concepto, importe, etiqueta, precioGasolina);
                    System.out.println("Gasto puntual de Gasolina añadido.");
                } else {
                    gestor.agregarGastoPuntual(concepto, importe, etiqueta, 0);
                    System.out.println("Gasto puntual añadido.");
                }
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    private void menuAhorros() {
        System.out.println("1. Ver dinero disponible\n2. Añadir objetivo\n3. Agregar dinero a objetivo");
        int op = sc.nextInt();
        sc.nextLine(); // Limpiar salto de línea

        switch (op) {
            case 1 -> {
                System.out.printf("Dinero sin clasificar: %.2f€\n", gestor.getDineroSinClasificar());
            }
            case 2 -> {
                System.out.print("Nombre del objetivo: ");
                String nombre = sc.nextLine();
                System.out.print("Cantidad a ahorrar: ");
                double cantidad = sc.nextDouble();
                gestor.agregarObjetivo(nombre, cantidad);
                System.out.println("Objetivo de ahorro añadido.");
            }
            case 3 -> {
                System.out.print("Nombre del objetivo: ");
                String nombre = sc.nextLine();
                System.out.print("Cantidad a añadir al objetivo: ");
                double cantidad = sc.nextDouble();
                gestor.agregarDineroObjetivo(nombre, cantidad);
                System.out.println("Dinero agregado al objetivo (si era válido y había suficiente dinero).");
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    public static void main(String[] args) {
        new InterfazApp().iniciar();
    }
}
