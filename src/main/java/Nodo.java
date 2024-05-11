public class Nodo
{
    private String etiqueta, antecesor;
    private int peso;

    public Nodo(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public Nodo(String etiqueta, String antecesor, int peso)
    {
        this.etiqueta = etiqueta;
        this.antecesor = antecesor;
        this.peso = peso;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getAntecesor() {
        return antecesor;
    }

    public void setAntecesor(String antecesor) {
        this.antecesor = antecesor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
