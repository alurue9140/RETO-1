/**
 * @author George Popa
 *
 */
public class HorasExtra {
    private int ID;
    private String fecha;
    private int horas;

    public HorasExtra(int ID, String fecha, int horas) {

        this.ID = ID;
        this.fecha = fecha;
        this.horas = horas;
    }

    public void setHoras(int horas){
        this.horas = horas;
    }

    public int getHoras(){
        return horas;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getFecha(){
        return fecha;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    @Override
    public String toString() {
        return "{ID empleado: " + ID + ", Fecha: " + fecha + ", Horas extra: " + horas + "}"; } //autor Jorge Pitarch

    public String toStringCSV(){
        return Integer.toString(ID) + ";" + fecha + ";" + Integer.toString(horas); } //autor Jorge Pitarch
}