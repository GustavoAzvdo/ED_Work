package sort;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort {

    public static class Resultado {
        public long comparacoes = 0;
        public long trocas = 0;
        public long tempoMillis = 0;
    }

    public static Resultado ordenar(int[] array) {
        Resultado resultado = new Resultado();
        Instant inicio = Instant.now();

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                resultado.comparacoes++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                resultado.trocas++;
            }
        }

        Instant fim = Instant.now();
        resultado.tempoMillis = Duration.between(inicio, fim).toMillis();
        return resultado;
    }
}
