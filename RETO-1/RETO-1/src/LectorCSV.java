import java.io.*;
import java.util.ArrayList;

/**
 * @author Jorge Pitarch
 */

public class LectorCSV {

    /**
     * autor Isaac Rueda
     * colaborador George Popa
     */

    // Declaración de variables para utilizarlas en el método

    public  final String SEPARADOR = ";" ;
    public  final String RUTA = "./recursos/";

    // Declaración de ArrayList para utilizar en el programa

    public  ArrayList <Departamento> departamento = new ArrayList<>();
    public  ArrayList <Empleado> empleado = new ArrayList<>();
    public  ArrayList <Grupo> grupo = new ArrayList<>();
    public  ArrayList <Empresa> empresa = new ArrayList<>();
    public  ArrayList <Categoria> categoria = new ArrayList<>();
    public  ArrayList <HorasExtra> horasExtra = new ArrayList<>();

    // Método para leer CSV

    public void leerCSV () {

        /**
         * autor Isaac Rueda
         * colaborador George Popa
         */

        // Abrir todos los lectores de archivos

        BufferedReader bufferLecturaHorasExtra = null;
        BufferedReader bufferLecturaDepartamentos = null;
        BufferedReader bufferLecturaEmpleados = null;
        BufferedReader bufferLecturaEmpresa = null;
        BufferedReader bufferLecturaGrupos = null;
        BufferedReader bufferLecturaCategorias = null;

        try {

            // Abrir el .csv en buffer de lectura

            bufferLecturaCategorias = new BufferedReader(new FileReader(RUTA + "Categorias.csv"));
            bufferLecturaEmpresa = new BufferedReader(new FileReader(RUTA + "DatosEmpresa.csv"));
            bufferLecturaDepartamentos = new BufferedReader(new FileReader(RUTA + "Departamentos.csv"));
            bufferLecturaEmpleados = new BufferedReader(new FileReader(RUTA + "Empleados.csv"));
            bufferLecturaGrupos= new BufferedReader(new FileReader(RUTA + "Grupos.csv"));
            bufferLecturaHorasExtra = new BufferedReader(new FileReader(RUTA + "HorasExtra.csv"));

            // Leer una línea del archivo

            String lineaCategorias = bufferLecturaCategorias.readLine();
            String lineaEmpresa = bufferLecturaEmpresa.readLine();
            String lineaDepartamentos = bufferLecturaDepartamentos.readLine();
            String lineaEmpleados = bufferLecturaEmpleados.readLine();
            String lineaGrupos = bufferLecturaGrupos.readLine();
            String lineaHorasExtra = bufferLecturaHorasExtra.readLine();

            // Leer la segunda línea, para saltarnos la cabecera del .csv

            lineaDepartamentos = bufferLecturaDepartamentos.readLine();
            lineaEmpresa = bufferLecturaEmpresa.readLine();
            lineaEmpleados = bufferLecturaEmpleados.readLine();
            lineaCategorias = bufferLecturaCategorias.readLine();
            lineaGrupos = bufferLecturaGrupos.readLine();
            lineaHorasExtra = bufferLecturaHorasExtra.readLine();

            /**
             * Como sabemos la estructura de cada CSV, guardamos cada línea en un array de Strings y después
             * con el constructor de cada Clase, añadimos cada elemento del array a una nueva instancia/objeto de
             * dicha clase, pasándolo de String al valor que haga falta en cada momento. Por último se añade ese objeto
             * a su ArrayList correspondiente y se lee/carga la siguiente línea del fichero .csv
             */

            while (lineaDepartamentos != null) {

                String [] datosDepartamento = lineaDepartamentos.split(SEPARADOR);

                Departamento nuevo = new Departamento(Integer.parseInt(datosDepartamento[0]), datosDepartamento[1]);

                departamento.add(nuevo);

                lineaDepartamentos = bufferLecturaDepartamentos.readLine();

            }

            while (lineaEmpresa != null) {

                String [] datosEmpresa = lineaEmpresa.split(SEPARADOR);

                Empresa nuevo = new Empresa(Integer.parseInt(datosEmpresa[0]), datosEmpresa[1],datosEmpresa[2],Integer.parseInt(datosEmpresa[3]),Integer.parseInt(datosEmpresa[4]),datosEmpresa[5]);

                empresa.add(nuevo);

                lineaEmpresa = bufferLecturaEmpresa.readLine();

            }

            while (lineaEmpleados != null) {

                String [] datosEmpleados = lineaEmpleados.split(SEPARADOR);

                Empleado nuevo = new Empleado(Integer.parseInt(datosEmpleados[0]), datosEmpleados[1], datosEmpleados[2],datosEmpleados[3],datosEmpleados[4],datosEmpleados[5],datosEmpleados[6],datosEmpleados[7],Integer.parseInt(datosEmpleados[8]));

                empleado.add(nuevo);

                lineaEmpleados = bufferLecturaEmpleados.readLine();

            }

            while (lineaCategorias != null) {

                String [] datosCategorias = lineaCategorias.split(SEPARADOR);

                Categoria nuevo = new Categoria (datosCategorias[0]);

                categoria.add(nuevo);

                lineaCategorias = bufferLecturaCategorias.readLine();

            }

            while (lineaGrupos != null) {

                String [] datosGrupos = lineaGrupos.split(SEPARADOR);

                Grupo nuevo = new Grupo((datosGrupos[0]), datosGrupos[1], datosGrupos[2],Double.parseDouble(datosGrupos[3]));

                grupo.add(nuevo);

                lineaGrupos = bufferLecturaGrupos.readLine();

            }

            while (lineaHorasExtra != null) {

                String [] datosHorasExtra = lineaHorasExtra.split(SEPARADOR);

                HorasExtra nuevo = new HorasExtra (Integer.parseInt(datosHorasExtra[0]), datosHorasExtra[1], Integer.parseInt(datosHorasExtra[2]));

                horasExtra.add(nuevo);

                lineaHorasExtra = bufferLecturaHorasExtra.readLine();

            }

            bufferLecturaCategorias.close();
            bufferLecturaEmpresa.close();
            bufferLecturaDepartamentos.close();
            bufferLecturaEmpleados.close();
            bufferLecturaGrupos.close();
            bufferLecturaHorasExtra.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarCSV(LectorCSV l) throws IOException {

        /**
         * autor Jorge Pitarch
         */

        BufferedWriter escrituraCategorias = new BufferedWriter(new FileWriter(RUTA + "Categorias.csv"));
        BufferedWriter escrituraDatosEmpresa = new BufferedWriter(new FileWriter(RUTA + "DatosEmpresa.csv"));
        BufferedWriter escrituraDepartamentos = new BufferedWriter(new FileWriter(RUTA + "Departamentos.csv"));
        BufferedWriter escrituraEmpleados = new BufferedWriter(new FileWriter(RUTA + "Empleados.csv"));
        BufferedWriter escrituraGrupos = new BufferedWriter(new FileWriter(RUTA + "Grupos.csv"));
        BufferedWriter escrituraHorasExtra = new BufferedWriter(new FileWriter(RUTA + "HorasExtra.csv"));

        escrituraCategorias.write("Cod_cat");
        for (Categoria cat : l.categoria){
            escrituraCategorias.newLine();
            escrituraCategorias.write(cat.toStringCSV());
        }

        escrituraDatosEmpresa.write("ID;cargo;antiguedad;cod_d;cod_g;cod_c");
        for (Empresa e : l.empresa){
            escrituraDatosEmpresa.newLine();
            escrituraDatosEmpresa.write(e.toStringCSV());
        }

        escrituraDepartamentos.write("codi;nombre");
        for (Departamento dept : l.departamento){
            escrituraDepartamentos.newLine();
            escrituraDepartamentos.write(dept.toStringCSV());
        }

        escrituraEmpleados.write("ID;nif;Nombre;Apellido1;Apellido2;cuenta;N__de_afiliacion_a_la_Seguridad_Social;email;departamento");
        for (Empleado e : l.empleado){
            escrituraEmpleados.newLine();
            escrituraEmpleados.write(e.toStringCSV());
        }

        escrituraGrupos.write("cod_g;Nombre;Formacion;SalarioBase");
        for (Grupo grupo : l.grupo){
            escrituraGrupos.newLine();
            escrituraGrupos.write(grupo.toStringCSV());
        }

        escrituraHorasExtra.write("ID;fecha;horas");
        for (HorasExtra horas : l.horasExtra){
            escrituraHorasExtra.newLine();
            escrituraHorasExtra.write(horas.toStringCSV());
        }

        escrituraCategorias.close();
        escrituraDatosEmpresa.close();
        escrituraDepartamentos.close();
        escrituraEmpleados.close();
        escrituraGrupos.close();
        escrituraHorasExtra.close();
    }

}
