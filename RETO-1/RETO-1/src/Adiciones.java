import java.io.IOException;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * @author Jorge Pitarch
 */

public class Adiciones {

    private static Scanner input = new Scanner(System.in);
    private  static LectorCSV lector;

    public Adiciones(LectorCSV lector) {
        Adiciones.lector = lector;
    }

    public void anyadirEmpleado () throws IOException{

        /**
         * colaborador Isaac Rueda
         */

        String NIF, nombre, apellido1, apellido2, cuenta, numSS, email, cargo, antiguedad, codCat;
        int codGrupo, dept;
        int ID = lector.empleado.size() + 1;

        NIF = MenuTerminal.leerCadena("Introduce el NIF del nuevo empleado: ");

        nombre = MenuTerminal.leerCadena("Introduce el nombre del nuevo empleado: ");

        apellido1 = MenuTerminal.leerCadena("Introduce el primer apellido del nuevo empleado: ");

        apellido2 = MenuTerminal.leerCadena("Introduce el segundo apellido del nuevo empleado: ");

        email = MenuTerminal.leerCadena("Introduce el email del nuevo empleado: ");

        cuenta = MenuTerminal.leerCadena("Introduce la cuenta del nuevo empleado (la cuenta es el mail hasta el '@'): ");

        numSS = MenuTerminal.leerCadena("Introduce el número de la seguridad social del nuevo empleado: ");

        dept = MenuTerminal.leerEntero("Introduce el número del departamento al que irá este nuevo empleado: ");

        //Creamos el nuevo empleado con los datos introducidos
        Empleado nuevo = new Empleado(ID, NIF, nombre, apellido1, apellido2, cuenta, numSS, email, dept);

        //Lo añadimos a su ArrayList correspondiente
        lector.empleado.add(nuevo);

        cargo = MenuTerminal.leerCadena("Introduce el cargo del nuevo empleado: ");

        antiguedad = MenuTerminal.leerCadena("¿Qué día se incorporará?: ");

        codCat = MenuTerminal.leerCadena("Introduce la categoría de este nuevo empleado: ");

        codGrupo = MenuTerminal.leerEntero("Introduce el número del grupo al que pertenecerá el nuevo empleado: ");

        //Creamos los datos de empresa introducidos y unas horas extra
        Empresa nueva = new Empresa(ID, cargo, antiguedad, dept, codGrupo, codCat);
        HorasExtra horas = new HorasExtra(ID, antiguedad, 0);

        //Los añadimos a su ArrayList correspondiente
        lector.empresa.add(nueva);
        lector.horasExtra.add(horas);

        lector.guardarCSV(lector);
        System.out.println("\nGuardando... \nEl nuevo empleado ha sido añadido con éxito. \nVolviendo al menú de adiciones..." +
                           "\n-------------------------------------------------------");
        MenuTerminal.anyadirDatos();
    }

    public void nuevoDepartamento () throws IOException {

        /**
         * colaborador Isaac Rueda
         */

        int numero;
        String nombre;

        nombre = MenuTerminal.leerCadena("¿Cómo se llamará el nuevo departamento?: ");

        numero = MenuTerminal.leerEntero("¿Qué número tendrá?: ");

        Departamento nuevo = new Departamento(numero, nombre);

        lector.departamento.add(nuevo);

        lector.guardarCSV(lector);
        System.out.println("\nGuardando... \nEl nuevo departamento se ha añadido con éxito. \nVolviendo al menú de adiciones..." +
                           "\n-------------------------------------------------------");
        MenuTerminal.anyadirDatos();
    }
}
