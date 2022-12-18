/**
 * @author George Popa
 * colaborador Jorge Pitarch
 */
public class Departamento {
    private int numero;
    private String nombre;

    public Departamento(int numero, String nombre){

        this.numero = numero;
        this.nombre = nombre;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "{Departamento nº: " + numero + ", nombre: " + nombre + "}"; } //autor Jorge Pitarch

    public String toStringCSV() {
        return Integer.toString(numero) + ";" + nombre;
    } //autor Jorge Pitarch
}