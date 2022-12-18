import java.io.IOException;

/**
 * @author Jorge Pitarch
 */

public class Consultas {

    public static LectorCSV lector;

    public Consultas(LectorCSV lector){
        Consultas.lector = lector;
    }

    public void datosPersonales (String NIF) throws  IOException {

        /**
         * autor: George Popa
         * colaborador: Isaac Rueda
         */

        boolean ya = false;

        for(Empleado datosEmpleado : lector.empleado) {

            if (datosEmpleado.getNIF().equals(NIF)) {

                System.out.println("EL NIF introducido correponde al siguiente empleado: \n" + datosEmpleado);
                ya = true;
                break;
            }
        }

        if (!ya) {
            System.out.println("¡El NIF introducido no existe! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println("\nVolviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }

    public void datosEmpresariales (int id) throws  IOException{

        /**
         * autor: George Popa
         * colaborador: Isaac Rueda
         */

        boolean ya = false;

        for (Empresa datosEmpresa : lector.empresa) {

            if (datosEmpresa.getID() == id) {

                System.out.println("El ID introducido corresponde al siguiente empleado: \n" + datosEmpresa);
                ya = true;
                break;
            }
        }

        if (!ya) {
            System.out.println("¡El ID introducido no existe! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println("\nVolviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }


    public void trabajadoresPorDepartamento (String dept) throws IOException {

        /**
         * autor: Jorge Pitarch
         * colaborador: Isaac Rueda
         */

        boolean ya = false;

        for (Departamento datos : lector.departamento) {

            if (datos.getNombre().equals(dept)) {

                int ID = datos.getNumero();
                System.out.println("En el departamento " + dept + " se encuentran los siguientes empleados: \n");

                for (Empleado datosEmpleado : lector.empleado) {

                    if (datosEmpleado.getDepartamento() == ID) {

                        System.out.println(datosEmpleado);
                        ya = true;
                    }
                }
            }
        }

        if (!ya) {
            System.out.println("¡El departamento introducido no existe o no tiene empleados asociados! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println("\nVolviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }

    public void trabajadoresPorCategoria (String cat) throws IOException{

        /**
         * autor: David López y Jorge Pitarch
         * colaborador: Isaac Rueda
         */

        boolean ya = false;

        System.out.println("Los siguientes empleados pertenecen a la categoría " + cat + ": ");

        for (Empresa e : lector.empresa){

            if (e.getCodCat().equals(cat)){

                int ID = e.getID();

                for (Empleado actual : lector.empleado) {

                    if (actual.getID() == ID){

                        System.out.println(actual);
                        ya = true;
                    }
                }
            }
        }

        if (!ya) {
            System.out.println("¡La categoria no existe o no tiene empleados asociados! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println("\nVolviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }

    public void horasExtraCategoria (String cat) throws IOException{

        /**
         * autor: David López
         * colaborador: Isaac Rueda
         */

        boolean ya = false;

        int sumaTotal = 0;

        for (Empresa datos : lector.empresa) {

            if (cat.equals(datos.getCodCat())) {

                int id = datos.getID();

                for (HorasExtra datosHorasExtra : lector.horasExtra) {

                    if (id == datosHorasExtra.getID()) {

                        sumaTotal += datosHorasExtra.getHoras();
                        ya = true;
                    }
                }
            }
        }

        if (!ya) {
            System.out.println("¡La categoria no existe o no tiene empleados asociados! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println ("El total de horas extra de la categoría es: " + sumaTotal + "\n" +
                                "Volviendo al menú de Consultas... \n" +
                                "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }


    public void horasExtraID (int ID) throws IOException{

        /**
         * autor: Jorge Pitarch
         * colaborador: Isaac Rueda
         */

        boolean ya = false;

        for (HorasExtra horas : lector.horasExtra){

            if (horas.getID() == ID){

                System.out.println();
                System.out.println("El empleado con ID: " + horas.getID() + " ha realizado " + horas.getHoras() + " horas extra.");
                ya = true;

            }
        }

        if (!ya) {
            System.out.println("¡El empleado no existe o no tiene horas extras asociadas! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println("Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }

    public void horasExtraDni (String NIF) throws IOException  {

        /**
         * autor: Isaac Rueda
         */

        boolean ya = false;

        for (Empleado datos : lector.empleado) {

            if (datos.getNIF().equals(NIF)) {

                int id = datos.getID();

                for (HorasExtra datosHorasExtra : lector.horasExtra) {

                    if (datosHorasExtra.getID()==id) {

                        System.out.println("El total de horas extra del usuario " + datos.getNombre() + " con NIF " + datos.getNIF() + " es de " + datosHorasExtra.getHoras() + " horas.");
                        ya = true;

                    }
                }
            }
        }

        if (!ya) {
            System.out.println("El empleado no existe o no tiene horas extras asociadas! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println("Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }

    public void horasExtraDepartamento (String dept) throws IOException{

        /**
         * autor: Isaac Rueda
         */

        boolean ya = false;

        dept = dept.toLowerCase();

        int sumaTotal = 0;
        String nombreDept = "";

        for (Departamento datos : lector.departamento) {

            if (datos.getNombre().equals(dept) ) {

                int numeroDept = datos.getNumero();
                nombreDept = datos.getNombre();

                for (Empleado datosEmpleado : lector.empleado) {

                    if (datosEmpleado.getDepartamento() == numeroDept) {

                        int idActual = datosEmpleado.getID();

                        for (HorasExtra datosHorasExtra : lector.horasExtra) {

                            if (idActual == datosHorasExtra.getID()) {

                                sumaTotal += datosHorasExtra.getHoras();
                                ya = true;

                            }
                        }
                    }
                }
            }
        }

        if (!ya) {
            System.out.println("¡El departamento no existe o sus empleados no tienen horas extras asociadas! \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        } else {
            System.out.println("La cantidad total de horas extra del departamento " + nombreDept + " es: " + sumaTotal + " \n" +
                               "Volviendo al menú de Consultas... \n" +
                               "-------------------------------------------------------" );
            MenuTerminal.consultarDatos();
        }
    }
}