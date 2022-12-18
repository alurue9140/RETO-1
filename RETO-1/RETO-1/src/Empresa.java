/**
 * @author George Popa
 * colaborador Jorge Pitarch
 */
public class Empresa {

    private int ID;
    private String cargo;
    private String antiguedad;
    private int codDep;
    private int codGrupo;
    private String codCat;

    public Empresa(int ID, String cargo, String antiguedad, int codDep, int codGrupo, String codCat) {

        this.ID = ID;                 this.cargo = cargo;             this.antiguedad = antiguedad;
        this.codDep = codDep;         this.codGrupo = codGrupo;       this.codCat = codCat;
    }


    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    public int getCodDep() {
        return codDep;
    }

    public void setCodDep(int codDep) {
        this.codDep = codDep;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        //Autor Jorge Pitarch

        return "{ID: " + ID + ", Cargo: " + cargo + ", Antigüedad: " + antiguedad + ", Departamento: " + codDep + ", Grupo: " + codGrupo + ", Categoría: " + codCat + "}";
    }

    public String toStringCSV(){
        //Autor Jorge Pitarch

        return Integer.toString(ID) + ";" + cargo + ";" + antiguedad + ";" +
                Integer.toString(codDep) + ";" + Integer.toString(codGrupo) + ";" + codCat;
    }
}
