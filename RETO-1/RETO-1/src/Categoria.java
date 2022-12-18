/**
 * @author George Popa
 * colaborador Jorge Pitarch
 */

public class Categoria {
    private String numero;

    public Categoria(String numero) {

        this.numero = numero;
    }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    @Override
    public String toString() {
        return "{CodCat: " + numero + "}";
    } //autor Jorge Pitarch

    public String toStringCSV() {
        return numero;
    } //autor Jorge Pitarch
}
