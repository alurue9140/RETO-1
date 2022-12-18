import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * @author Jorge Pitarch
 */

public class Modificaciones {

    public static LectorCSV lector;
    public static Scanner input = new Scanner(System.in);

    public Modificaciones (LectorCSV lector){
        Modificaciones.lector = lector;
    }

    public void datosPersonales (int ID) throws IOException {

        /**
         *     Autor: Isaac Rueda
         *     Colaboradores: George Popa, Jorge Pitarch
         */

        for (int i = 0; i < lector.empleado.size(); i++) {

            if (ID == lector.empleado.get(i).getID()) {

                int opcion = MenuTerminal.leerEntero("\n------------------------------------------------------- \n" +
                                                             "DATOS MODIFICABLES \n" +
                                                             "1.- Modificar NIF \n" +
                                                             "2.- Modificar Nombre \n" +
                                                             "3.- Modificar Primer Apellido \n" +
                                                             "4.- Modificar Segundo Apellido \n" +
                                                             "5.- Modificar Cuenta \n" +
                                                             "6.- Modificar Email \n" +
                                                             "7.- Modificar Departamento \n" +
                                                             "Volver atrás (0) \n" +
                                                             "Salir (-1) \n" +
                                                             "Introduce una opción: ");
  
                switch (opcion) {

                    case 0: MenuTerminal.modificarDatos(); break;

                    case -1: System.out.println("Apagando..."); break;

                    case 1:
                        String NIF = MenuTerminal.leerCadena("Introduce el nuevo NIF con el siguiente formato '12345678-A' ");
                        lector.empleado.get(i).setNIF(NIF);
                        System.out.println("------------------------------------------------------- \n" +
                                           "Los datos han sido modificados correctamente.");
                        System.out.print("Este es el nuevo NIF " + lector.empleado.get(i).getNIF());
                        lector.guardarCSV(lector);
                        datosPersonales(ID);
                        break;
  
                    case 2:
                        String nombre = MenuTerminal.leerCadena("Introduce el nuevo nombre: ");
                        lector.empleado.get(i).setNombre(nombre);
                        System.out.println("------------------------------------------------------- \n" +
                                           "Los datos han sido modificados correctamente.");
                        System.out.print("Este es el nuevo nombre: " + lector.empleado.get(i).getNombre());
                        lector.guardarCSV(lector);
                        datosPersonales(ID);
                        break;
  
                    case 3:
                        String apellido1 = MenuTerminal.leerCadena("Introduce el nuevo primer apellido: ");
                        lector.empleado.get(i).setApellido1(apellido1);
                        System.out.println("------------------------------------------------------- \n" +
                                           "Los datos han sido modificados correctamente.");
                        System.out.print("Este es el nuevo primer apellido: " + lector.empleado.get(i).getApellido1());
                        lector.guardarCSV(lector);
                        datosPersonales(ID);
                        break;
  
                    case 4:
                        String apellido2 = MenuTerminal.leerCadena("Introduce el nuevo segundo apellido: ");
                        lector.empleado.get(i).setApellido2(apellido2);
                        System.out.println("------------------------------------------------------- \n" +
                                         "Los datos han sido modificados correctamente.");
                        System.out.print("Este es el nuevo segundo apellido: " + lector.empleado.get(i).getApellido2());
                        lector.guardarCSV(lector);
                        datosPersonales(ID);
                        break;
  
                    case 5:
                        String cuenta = MenuTerminal.leerCadena("Introduce el nuevo nombre de cuenta: ");
                        lector.empleado.get(i).setCuenta(cuenta);
                        System.out.println("------------------------------------------------------- \n" +
                                           "Los datos han sido modificados correctamente.");
                        System.out.print("Este es el nuevo nombre de cuenta para el empleado con ID " + ID + ": " + lector.empleado.get(i).getCuenta() );
                        lector.guardarCSV(lector);
                        datosPersonales(ID);
                        break;
  
                    case 6:
                        String email = MenuTerminal.leerCadena("Introduce el nuevo email: ");
                        lector.empleado.get(i).setEmail(email);
                        System.out.println("------------------------------------------------------- \n" +
                                           "Los datos han sido modificados correctamente.");
                        System.out.print("Este es el nuevo email del empleado con ID  " + ID + ": " + lector.empleado.get(i).getEmail());
                        lector.guardarCSV(lector);
                        datosPersonales(ID);
                        break;
  
                    case 7:
                        int departamento = MenuTerminal.leerEntero("Introduce el nuevo número de Departamento del empleado con ID " + ID + ": ");
                        input.nextLine();
                        lector.empleado.get(i).setDepartamento(departamento);
                        System.out.println("------------------------------------------------------- \n" +
                                           "Los datos han sido modificados correctamente.");
                        System.out.print("Este es el nuevo número de departamento para el empleado con ID " + ID + ": " + lector.empleado.get(i).getDepartamento() );
                        lector.guardarCSV(lector);
                        datosPersonales(ID);
                        break;

                    default: System.out.println("¡Valor introducido incorrecto! Porfavor, elige una de las opciones del menú.");
                             System.out.println("-------------------------------------------------------");
                             datosPersonales(ID);
                             break;
                }
            }
        }
    }

    public void datosEmpresariales(int ID) throws IOException {

        /**
         *     Autor: George Popa
         *     Colaboradores: Isaac Rueda, Jorge Pitarch
         */

            for (int i = 0; i < lector.empleado.size(); i++) {

                if (ID == lector.empresa.get(i).getID()) {

                    int opcion = MenuTerminal.leerEntero("\n------------------------------------------------------- \n" +
                                                                 "DATOS MODIFICABLES \n" +
                                                                 "1.- Modificar Cargo \n" +
                                                                 "2.- Modificar Antigüedad \n" +
                                                                 "3.- Modificar Departamento \n" +
                                                                 "4.- Modificar Grupo de Cotización \n" +
                                                                 "5.- Modificar Categoría \n" +
                                                                 "Volver atrás (0) \n" +
                                                                 "Salir (-1)\n" +
                                                                 "Introduce una opción: ");

                    switch (opcion) {

                        case 0: MenuTerminal.modificarDatos(); break;

                        case -1: System.out.println("Apagando..."); break;

                        case 1:
                            String nuevoCargo = MenuTerminal.leerCadena("Introduce el nuevo cargo: ");
                            lector.empresa.get(i).setCargo(nuevoCargo);
                            System.out.println("------------------------------------------------------- \n" +
                                               "Los datos han sido modificados correctamente.");
                            System.out.println("Este es el nuevo cargo: " + lector.empresa.get(i).getCargo());
                            lector.guardarCSV(lector);
                            datosEmpresariales(ID);
                            break;

                        case 2:
                            String nuevaAntiguedad = MenuTerminal.leerCadena("Introduce la nueva antigüedad: ");
                            lector.empresa.get(i).setAntiguedad(nuevaAntiguedad);
                            System.out.println("------------------------------------------------------- \n" +
                                               "Los datos han sido modificados correctamente.");
                            System.out.println("Esta es la nueva antigüedad: " + lector.empresa.get(i).getAntiguedad());
                            lector.guardarCSV(lector);
                            datosEmpresariales(ID);
                            break;

                        case 3:
                            int nuevoDep = MenuTerminal.leerEntero("Introduce el nuevo departamento: ");
                            lector.empresa.get(i).setCodDep(nuevoDep);
                            System.out.println("------------------------------------------------------- \n" +
                                               "Los datos han sido modificados correctamente.");
                            System.out.println("Este es el nuevo departamento: " + lector.empresa.get(i).getCodDep());
                            lector.guardarCSV(lector);
                            datosEmpresariales(ID);
                            break;

                        case 4:
                            int nuevoGrupo = MenuTerminal.leerEntero("Introduce el nuevo Grupo de cotización: ");
                            lector.empresa.get(i).setCodGrupo(nuevoGrupo);
                            System.out.println("------------------------------------------------------- \n" +
                                               "Los datos han sido modificados correctamente.");
                            System.out.println("Este es el nuevo Grupo de cotización: " + lector.empresa.get(i).getCodGrupo());
                            lector.guardarCSV(lector);
                            datosEmpresariales(ID);
                            break;

                        case 5:
                            String nuevoCodCat = MenuTerminal.leerCadena("Introduce la nueva categoría: ");
                            lector.empresa.get(i).setCodCat(nuevoCodCat);
                            System.out.println("------------------------------------------------------- \n" +
                                               "Los datos han sido modificados correctamente.");
                            System.out.println("Esta es la nueva categoría: " + lector.empresa.get(i).getCodCat());
                            lector.guardarCSV(lector);
                            datosEmpresariales(ID);
                            break;

                        default: System.out.println("¡Valor introducido incorrecto! Porfavor, elige una de las opciones del menú.");
                                 System.out.println("-------------------------------------------------------");
                                 datosEmpresariales(ID);
                                 break;
                    }
                }
            }
    }
}
