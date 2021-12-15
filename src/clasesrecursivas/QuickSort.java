package clasesrecursivas;



import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class QuickSort {
    public static void main(String[] args) {
        int numeros[] = {1, 9, 23, 4, 55, 100, 1, 1, 23};
        System.out.println("Antes de QS: " + Arrays.toString(numeros));
        quicksort(numeros, 0, numeros.length - 1);
        System.out.println("Despu�s de QS: " + Arrays.toString(numeros));
        String[] nombres = {"Leon", "Chris", "Jill", "Wesker", "Ada"};
        System.out.println("Antes de QS: " + Arrays.toString(nombres));
        quicksort(nombres, 0, nombres.length - 1);
        System.out.println("Despu�s de QS: " + Arrays.toString(nombres));
    }

    private static int particion(int arreglo[], int izquierda, int derecha) {
        // Elegimos el pivote, es el primero
        int pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            // Mientras cada elemento desde la izquierda est� en orden (sea menor que el
            // pivote) contin�a avanzando el �ndice
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            // Mientras cada elemento desde la derecha est� en orden (sea mayor que el
            // pivote) contin�a disminuyendo el �ndice
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
    /*
    Si la izquierda es mayor o igual que la derecha significa que no
    necesitamos hacer ning�n intercambio
    de variables, pues los elementos ya est�n en orden (al menos en esta
    iteraci�n)
    */
            if (izquierda >= derecha) {
                // Indicar "en d�nde nos quedamos" para poder dividir el arreglo de nuevo
                // y ordenar los dem�s elementos
                return derecha;
            } else {//Nota: yo s� que el else no hace falta por el return de arriba, pero as� el algoritmo es m�s claro
      /*
      Si las variables quedaron "lejos" (es decir, la izquierda no super� ni
      alcanz� a la derecha)
      significa que se detuvieron porque encontraron un valor que no estaba
      en orden, as� que lo intercambiamos
      */
                int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
      /*
      Ya intercambiamos, pero seguimos avanzando los �ndices una vez m�s
      */
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }


    // Divide y vencer�s
    private static void quicksort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }


    private static int particion(String arreglo[], int izquierda, int derecha) {
        // Elegimos el pivote, es el primero
        String pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            // Mientras cada elemento desde la izquierda est� en orden (sea menor que el
            // pivote) contin�a avanzando el �ndice
            while (arreglo[izquierda].compareTo(pivote) < 0) {
                izquierda++;
            }
            // Mientras cada elemento desde la derecha est� en orden (sea mayor que el
            // pivote) contin�a disminuyendo el �ndice
            while (arreglo[derecha].compareTo(pivote) > 0) {
                derecha--;
            }
    /*
    Si la izquierda es mayor o igual que la derecha significa que no
    necesitamos hacer ning�n intercambio
    de variables, pues los elementos ya est�n en orden (al menos en esta
    iteraci�n)
    */
            if (izquierda >= derecha) {
                // Indicar "en d�nde nos quedamos" para poder dividir el arreglo de nuevo
                // y ordenar los dem�s elementos
                return derecha;
            } else {//Nota: yo s� que el else no hace falta por el return de arriba, pero as� el algoritmo es m�s claro
      /*
      Si las variables quedaron "lejos" (es decir, la izquierda no super� ni
      alcanz� a la derecha)
      significa que se detuvieron porque encontraron un valor que no estaba
      en orden, as� que lo intercambiamos
      */
                String temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
      /*
      Ya intercambiamos, pero seguimos avanzando los �ndices una vez m�s
      */
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }

    // Divide y vencer�s
    private static void quicksort(String arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }
}