import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cantidad_Nodos;
        String origen, destino;

        System.out.println("Cuantos Nodos tendra el grafo? (Recuerda que rellenas la matriz xd)");
            cantidad_Nodos = scan.nextInt();

        Grafo grafo = new Grafo(cantidad_Nodos);

        scan.nextLine();                //Limpiamos buffer

        grafo.creacion_matriz_nodos();
        grafo.nodos_ligados();
        grafo.mostrarMatrizAdyacencia();

        System.out.println("Indique el origen del grafo: ");
            origen = scan.nextLine();

        System.out.println("Indique el destino del grafo: ");
            destino = scan.nextLine();

        grafo.dijkstra(origen, destino);

    }
}
