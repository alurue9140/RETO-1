/**
 * @author Jorge Pitarch
 * colaborador George Popa
 */

public class Empleado {

    private int ID;
    private String NIF;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String cuenta;
    private String numSS;
    private String email;
    private int departamento;

    public Empleado(int ID, String NIF, String nombre, String apellido1, String apellido2,
                    String cuenta, String numSS, String email, int departamento) {

        this.ID = ID;                 this.NIF = NIF;                 this.nombre = nombre;
        this.apellido1 = apellido1;   this.apellido2 = apellido2;     this.cuenta = cuenta;
        this.numSS = numSS;           this.email = email;             this.departamento = departamento;
    }

    public int getDepartamento() { return departamento; }

    public void setDepartamento(int departamento) { this.departamento = departamento; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    @Override
    public String toString() {
        /**
         * autor Jorge Pitarch
         */
        return "{ID: " + ID + ", NIF: " + NIF + ", Nombre: " + nombre + ", Primer apellido: " + apellido1 + ", Segundo apellido: " + apellido2 + ", Cuenta: " + cuenta +
                ", Nº Seguridad Social: " + numSS + ", Correo: " + email + ", Departamento: " + departamento + "}";
    }

    public String toStringCSV() {
        /**
         * autor Jorge Pitarch
         */
        return Integer.toString(ID) + ";" + NIF + ";" + nombre + ";" + apellido1 + ";" +
                apellido2 + ";" + cuenta + ";" + numSS + ";" + email + ";" + Integer.toString(departamento);
    }
}