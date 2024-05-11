import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cantidad_Nodos;

        System.out.println("Cuantos Nodos tendra el grafo? (Recuerda que rellenas la matriz xd)");
            cantidad_Nodos = scan.nextInt();

        Grafo grafo = new Grafo(cantidad_Nodos);

        grafo.creacion_matriz_nodos();
        grafo.nodos_ligados();
        grafo.mostrarMatrizAdyacencia();

    }
}
