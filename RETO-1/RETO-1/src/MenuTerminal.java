import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @author Jorge Pitarch
 * colaborador Isaac Rueda
 */

public class MenuTerminal {

    public static final int CONSULTAR = 1;
    public static final int ANADIR = 2;
    public static final int MODIFICAR = 3;
    public static final int ELIMINAR = 4;
    public static final int SALIR = 5;
    public static Scanner input = new Scanner(System.in);
    public static LectorCSV lector = new LectorCSV();

    public static void main(String[] args) throws IOException {

        /**
         * colaborador Isaac Rueda
         */

        //Inicializamos las ArrayLists
        lector.leerCSV();

        //Mostramos al usuario las acciones que puede realizar
        menuPrincipal();

    }
    public static void menuPrincipal() throws IOException {

        /**
         * colaborador Isaac Rueda
         */

        int opcion = leerEntero("\nBienvenido al menú principal \n" +
                                        "------------------------------------------------------- \n" +
                                        "1.- CONSULTAR DATOS \n" +
                                        "2.- AÑADIR DATOS \n" +
                                        "3.- MODIFICAR DATOS \n" +
                                        "4.- ELIMINAR DATOS \n" +
                                        "5.- SALIR \n" +
                                        "¿Qué deseas hacer?: ");

        switch (opcion) {

            case CONSULTAR: consultarDatos(); break;

            case ANADIR: anyadirDatos(); break;

            case MODIFICAR: modificarDatos(); break;

            case ELIMINAR: eliminarDatos(); break;

            case SALIR: System.out.println("Apagando..."); break;

            default:
                System.out.println("¡Valor introducido incorrecto! Porfavor, elige una de las opciones del menú.");
                System.out.println("-------------------------------------------------------");
                menuPrincipal();
                break;
        }
    }

    public static void consultarDatos() throws IOException {

        /**
         * colaborador Isaac Rueda
         */

        //Le pasamos a nuestra variable 'consulta' las arrayLists inicializadas en el método main (por medio de 'lector')
        Consultas consulta = new Consultas(lector);

        int opcion = leerEntero("\nBienvenido al menú de consultas \n" +
                                        "------------------------------------------------------- \n" +
                                        "1.- Consultar datos personales de un trabajador (DNI) \n" +
                                        "2.- Consultar datos empresariales de un trabajador (ID) \n" +
                                        "3.- Consultar trabajadores de un departamento \n" +
                                        "4.- Consultar trabajadores de una categoría \n" +
                                        "5.- Consultar horas extra de una categoría \n" +
                                        "6.- Consultar horas extra de un trabajador (ID) \n" +
                                        "7.- Consultar horas extra de un trabajador (DNI) \n" +
                                        "8.- Consultar horas extra de un departamento \n" +
                                        "Volver atrás (0) \n" +
                                        "Salir (-1) \n" +
                                        "Introduce una opción: ");

        switch (opcion) {

            case 1:
                String NIF = leerCadena("Introduce el NIF del empleado: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.datosPersonales(NIF);
                break;

            case 2:
                int ID = leerEntero("Introduce el ID del empleado: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.datosEmpresariales(ID);
                break;

            case 3:
                String nom = leerCadena("Introduce el nombre del departamento: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.trabajadoresPorDepartamento(nom);
                break;

            case 4:
                String cat = leerCadena("Introduce la categoría: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.trabajadoresPorCategoria(cat);
                break;

            case 5:
                cat = leerCadena("Introduce la categoría: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.horasExtraCategoria(cat);
                break;

            case 6:
                ID = leerEntero("Introduce el ID del empleado: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.horasExtraID(ID);
                break;

            case 7:
                NIF = leerCadena("Introduce el NIF del empleado: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.horasExtraDni(NIF);
                break;

            case 8:
                String dept = leerCadena("Introduce el nombre del departamento: ");
                System.out.println("\n-------------------------------------------------------");
                consulta.horasExtraDepartamento(dept);
                break;

            case 0: menuPrincipal(); break;

            case -1: System.out.println("Apagando..."); break;

            default:
                System.out.println("¡Valor introducido incorrecto! Porfavor, elige una de las opciones del menú.");
                System.out.println("-------------------------------------------------------");
                consultarDatos();
                break;
        }
    }

    public static void anyadirDatos() throws IOException {

        Adiciones adicion = new Adiciones(lector);;

        int opcion = leerEntero("\nBienvenido al menú de adiciones \n" +
                                        "------------------------------------------------------- \n" +
                                        "1.- Añadir un nuevo trabajador \n" +
                                        "2.- Añadir un nuevo departamento \n" +
                                        "Volver atrás (0) \n" +
                                        "Salir (-1) \n" +
                                        "Introduce una opción: ");

        switch (opcion) {

            case 1: adicion.anyadirEmpleado(); break;

            case 2: adicion.nuevoDepartamento(); break;

            case 0: menuPrincipal(); break;

            case -1: System.out.println("Apagando..."); break;

            default:
                System.out.println("¡Valor introducido incorrecto! Porfavor, elige una de las opciones del menú.");
                System.out.println("-------------------------------------------------------");
                anyadirDatos();
                break;
        }
    }

    public static void modificarDatos() throws IOException {

        /**
         * autor Isaac Rueda y George Popa
         */

        Modificaciones modificar = new Modificaciones(lector);

        int opcion = leerEntero("\nBienvenido al menú de modificaciones \n" +
                                        "------------------------------------------------------- \n" +
                                        "1.- Modificar datos personales de un trabajador \n" +
                                        "2.- Modificar datos empresariales de un trabajador \n" +
                                        "Volver atrás (0) \n" +
                                        "Salir (-1) \n" +
                                        "Introduce una opción: ");

        switch (opcion) {

            case 1:

                int ID = leerEntero("Introduce un ID para modificar sus datos personales: ");

                while (ID > lector.empleado.size()) {

                    ID = leerEntero("No existe ningún empleado con ese ID \nIntroduce un ID válido: ");

                }

                modificar.datosPersonales(ID);
                break;

            case 2:

                ID = leerEntero("Introduce un ID para modificar sus datos de empresa: ");

                while (ID > lector.empresa.size()) {

                    ID = leerEntero("No existe ningún empleado con ese ID \nIntroduce un ID válido: ");

                }

                modificar.datosEmpresariales(ID);
                break;

            case 0: menuPrincipal(); break;

            case -1: System.out.println("Apagando..."); break;

            default:
                System.out.println("¡Valor introducido incorrecto! Porfavor, elige una de las opciones del menú.");
                System.out.println("-------------------------------------------------------");
                modificarDatos();
                break;
        }
    }


    public static void eliminarDatos() throws IOException {

        /**
         * autor Isaac Rueda
         */

        Eliminaciones eliminacion = new Eliminaciones(lector);

        int opcion = leerEntero( "\nBienvenido al menú de eliminaciones \n" +
                                        "------------------------------------------------------- \n" +
                                        "1.- Eliminar un departamento junto a sus dependencias \n" +  //Eliminar en Cascada
                                        "2.- Eliminar un departamento (modo seguro) \n" +             //Eliminar si la Integridad Referencial lo permite
                                        "Volver atrás (0) \n" +
                                        "Salir (-1) \n" +
                                        "Introduce una opción: ");

        switch (opcion) {

            case 1:

                int num = leerEntero("Introduzca el número de departamento: ");

                while (num > lector.departamento.size()) {

                    num = leerEntero("No existe ningún departamento con dicho número.\nIntroduce número de departamento válido (0 para volver atrás): ");
                    if (num == 0){
                        eliminarDatos();
                    }
                }

                eliminacion.eliminarCascada(num);
                break;

            case 2:

                num = leerEntero("Introduzca el número de departamento: ");

                while (num > lector.departamento.size()) {

                    num = leerEntero("No existe ningún departamento con ese número.\nIntroduce un número de departamento válido (0 para volver atrás): ");
                    if (num == 0) {
                        eliminarDatos();
                    }
                }

                for (Departamento datos : lector.departamento) {

                    if (datos.getNumero() == num) {

                        eliminacion.eliminarConIntegridadReferencial(num);
                        break;
                    }
                }

                break;

            case 0: menuPrincipal(); break;

            case -1: System.out.println("Apagando..."); break;

            default:
                System.out.println("¡Valor introducido incorrecto! Porfavor, elige una de las opciones del menú.");
                System.out.println("-------------------------------------------------------");
                eliminarDatos();
                break;
        }
    }

    public static int leerEntero(String mensaje) {

        int opcion = 0;
        boolean continua;

        do {
            try {

                continua = false;
                System.out.print(mensaje);
                opcion = input.nextInt();
                input.nextLine();

                return opcion;

            } catch (InputMismatchException e) {
                System.out.println("¡Error! Introduce un nuevo valor (numérico) \n" +
                                   "-------------------------------------------------------");
                input.next();
                continua = true;
            }

        } while (continua);
        
        return opcion;
    }

    public static String leerCadena (String mensaje) {

        System.out.print(mensaje);
        String str = input.nextLine();

        return str;
    }
}
