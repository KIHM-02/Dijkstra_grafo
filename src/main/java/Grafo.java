import java.util.Scanner;

public class Grafo
{
    Scanner scan = new Scanner(System.in);
    private final int cantidad_Nodos;
    private Nodo[] vector_Nodos;
    public Matriz_adyacente[][] matriz_adyacente;

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

    public void dijkstra(String origen, String destino)
    {
        int[] array_visitados = new int[cantidad_Nodos];                                    //sirve para conocer las posiciones visitadas anteriormente
        String[] etiquetas_visitadas = new String[cantidad_Nodos];
        int fila, columna, posArray = 1, posVisitada = 0;                                   //Declaramos fuera para poder hacer modificaciones de sus valores
        int arranque = 0, aux = 999, suma = 0;                                              //El aux es para tener el valor mas alto, para ir encontrando el menor en la matriz adyacente
        String etiqueta = "";

        System.out.println("Entrando a Dijkstra (Kevijstra)");

        for(int i = 0; i<cantidad_Nodos; i++)
        {
            array_visitados[i] = 999;                                                           //Seteamos los valores al maximo para de ahi, cambiarlos a la posicion visitada
            if(vector_Nodos[i].getEtiqueta().equals(origen))
            {
                arranque = i;                                                                   //Encontramos la posicion de arranque segun el origen
            }
        }


        //Inicio de algoritmo de busqueda del elemento menor por fila
        array_visitados[0] = arranque;                                                          //la primera posicion de los visitados, sera el vector de arranque
        etiquetas_visitadas[0] = vector_Nodos[arranque].getEtiqueta();

        for (fila = arranque; fila<cantidad_Nodos; fila++)
        {
             for(columna = 0; columna<cantidad_Nodos; columna++)
            {
                if(!isVisited(array_visitados, columna))
                {
                    if(matriz_adyacente[fila][columna].isDato_establecido() &&                  //Verificamos si el nodo de la fila, esta conectado a los nodos de las columnas
                            aux>matriz_adyacente[fila][columna].getPeso_arista())               //Tambien, si el aux es menor a dicho valor, este ingresara y cambiara el valor
                    {
                        aux = matriz_adyacente[fila][columna].getPeso_arista();                 //Seteamos al auxiliar el valor
                        etiqueta = vector_Nodos[columna].getEtiqueta();                         //Seteamos la etiqueta visita, para despues agregarla al arrary_visitados
                        posVisitada = columna;
                        array_visitados[posArray] =posVisitada;
                        etiquetas_visitadas[posArray] = etiqueta;
                    }
                }
            }

             if(!etiqueta.equals(destino))
             {

                 fila = posVisitada-1;                                                               //Redireccionamos a la fila anterior, para empezar a verificar dichos elementos
                 suma+= aux;
                 posArray++;
                 aux = 999;
             }
             else
             {
                 fila = cantidad_Nodos;
                 suma+= aux;
             }
        }

        System.out.println("El peso del viaje es: "+suma);
        System.out.println("El camino es: ");

        for(int i =0; i<etiquetas_visitadas.length; i++)
        {
            System.out.print(" "+etiquetas_visitadas[i]);
        }

    }

    public boolean isVisited(int[] array, int columna)
    {
        for(int i = 0; i< array.length; i++)
        {
            if(array[i] == columna)
                return true;
        }

        return false;
    }

}
