import java.io.IOException;

/**
 * @author Jorge Pitarch
 */

public class Eliminaciones {

    /**
     * autor Isaac Rueda
     */

    public static LectorCSV lector;

    public Eliminaciones(LectorCSV lector) {
        Eliminaciones.lector = lector;
    }

    public void eliminarCascada(int dept) throws IOException {

        /**
         * autor Isaac Rueda
         */

        for (int i = 0; i < lector.departamento.size(); i++) {

            if (dept == lector.departamento.get(i).getNumero()) {
                lector.departamento.remove(i);
                break;
            }
        }

        for (int j = 0; j < lector.empleado.size(); j++) {

            if (dept == lector.empleado.get(j).getDepartamento()) {
                lector.empleado.remove(j);
                lector.empresa.remove(j);
                lector.horasExtra.remove(j);
                j--;
            }
        }

        System.out.println("\n------------------------------------------------------- \n" +
                           "El departamento seleccionado y todas sus dependencias han sido eliminadas con éxito. \n" +
                           "Volviendo al menú de eliminaciones... \n" +
                           "-------------------------------------------------------");
        lector.guardarCSV(lector);
        MenuTerminal.eliminarDatos();
    }

    public void eliminarConIntegridadReferencial(int dept) throws IOException {

        /**
         * autor Isaac Rueda
         */

        int empleadosDependientes = 0;
        boolean siDepende = false;

        for (int i = 0; i < lector.departamento.size(); i++) {

            if (dept == lector.departamento.get(i).getNumero()) {

                for (int j = 0; j < lector.empleado.size(); j++) {

                    if (dept == lector.empleado.get(j).getDepartamento()) {
                        empleadosDependientes++;
                        siDepende = true;
                    }
                }
            }
        }

        if (siDepende){
            System.out.println("\nHay " + empleadosDependientes + " empleados dependiendo de este departamento. Primero elimínalos o utiliza la opción de eliminar un departamento junto a sus dependencias (modo no seguro)");
        } else {
            System.out.println("\nNo hay usuarios dependientes, puedes eliminar el departamento con la opción de eliminar el departamento junto a sus dependencias (modo no seguro)");
        }

        System.out.println("\nVolviendo al menú de eliminaciones... \n" +
                           "-------------------------------------------------------");
        lector.guardarCSV(lector);
        MenuTerminal.eliminarDatos();
    }
}