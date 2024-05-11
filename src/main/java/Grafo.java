import java.util.Scanner;

public class Grafo
{
    Scanner scan = new Scanner(System.in);
    private int cantidad_Nodos;
    private Nodo vector_Nodos[];
    public Matriz_adyacente matriz_adyacente[][];

    public Grafo(int cantidad)
    {
        this.cantidad_Nodos = cantidad;
    }

    public void creacion_matriz_nodos()
    {
        vector_Nodos = new Nodo[cantidad_Nodos];
        String etiqueta;

        for (int i = 0; i<cantidad_Nodos; i++)
        {
            System.out.println("Cual sera la etiqueta del Nodo?");
                etiqueta = scan.next();

             vector_Nodos[i] = new Nodo(etiqueta);
        }

        for(int i = 0; i<cantidad_Nodos; i++)
        {
            System.out.println("la etiqueta es: "+vector_Nodos[i].getEtiqueta());
        }
    }

    public void nodos_ligados()
    {
        matriz_adyacente = new Matriz_adyacente[cantidad_Nodos][cantidad_Nodos];
        int peso_arista;

        setFalseMadyacente();

        System.out.println("Seccion de ligar nodos entre si...\n" +
                "Si esta ligado el nodo al nodo siguiente, agregue el peso de la arista\n" +
                "Si NO esta ligado, coloque -1");


        for (int i = 0; i<cantidad_Nodos; i++)
        {
            for (int j = 0; j<cantidad_Nodos; j++)
            {
                if(!matriz_adyacente[i][j].isDato_establecido())
                {
                    System.out.println("Esta conectado el nodo "+
                            vector_Nodos[i].getEtiqueta() + " al nodo "+
                            vector_Nodos[j].getEtiqueta()+" ?\nRespuesta: ");

                    peso_arista = scan.nextInt();

                    if(peso_arista != -1)
                    {
                        matriz_adyacente[i][j].setPeso_arista(peso_arista);
                        matriz_adyacente[i][j].setDato_establecido(true);

                        matriz_adyacente[j][i].setPeso_arista(peso_arista);
                        matriz_adyacente[j][i].setDato_establecido(true);
                    }
                }
            }
        }
    }

    private void setFalseMadyacente()
    {
        for (int init_fila = 0; init_fila<cantidad_Nodos; init_fila++)
        {
            for(int init_colum = 0; init_colum<cantidad_Nodos; init_colum++)
            {
                matriz_adyacente[init_fila][init_colum] = new Matriz_adyacente(false);
            }
        }
    }

    public void mostrarMatrizAdyacencia()
    {
        for (int fila = 0; fila<cantidad_Nodos; fila++)
        {
            for(int columna = 0; columna<cantidad_Nodos; columna++)
            {
                if(!matriz_adyacente[fila][columna].isDato_establecido())
                {
                    System.out.print(matriz_adyacente[fila][columna].isDato_establecido() + " ");
                }
                else
                {
                    System.out.print(matriz_adyacente[fila][columna].getPeso_arista() + " ");
                }
            }
            System.out.println("\n");
        }
    }
}
