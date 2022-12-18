/**
 * @author Jorge Pitarch
 * colaborador George Popa
 */

public class Grupo {
    private String nombre;
    private String numero;
    private String formacion;
    private double salarioBase;

    public Grupo(String nombre, String numero, String formacion, double salarioBase){

        this.nombre = nombre;
        this.numero = numero;
        this.formacion = formacion;
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        /**
         * autor Jorge Pitarch
         */
        return "{Nombre: " + nombre + ", Número: " + numero + ", Formación: " + formacion + ", Salario Base: " + salarioBase + "}";
    }

    public String toStringCSV () {
        /**
         * autor Jorge Pitarch
         */
        return nombre  + ";" + numero + ";" + formacion + ";" + Double.toString(salarioBase);
    }
}