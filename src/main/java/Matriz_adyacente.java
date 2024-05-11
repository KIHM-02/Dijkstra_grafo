public class Matriz_adyacente
{
    private boolean dato_establecido;
    private int peso_arista;

    public Matriz_adyacente(boolean dato_establecido)
    {
        this.dato_establecido = dato_establecido;
    }

    public Matriz_adyacente(boolean dato_establecido, int peso_arista)
    {
        this.dato_establecido = dato_establecido;
        this.peso_arista = peso_arista;
    }

    public boolean isDato_establecido() {
        return dato_establecido;
    }

    public void setDato_establecido(boolean dato_establecido) {
        this.dato_establecido = dato_establecido;
    }

    public int getPeso_arista() {
        return peso_arista;
    }

    public void setPeso_arista(int peso_arista) {
        this.peso_arista = peso_arista;
    }
}
