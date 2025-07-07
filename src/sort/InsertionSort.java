package sort;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort {

    public static class Resultado {
        public long comparacoes = 0;
        public long trocas = 0;
        public long tempoMillis = 0;
    }

    public static Resultado ordenar(int[] array) {
        Resultado resultado = new Resultado();
        Instant inicio = Instant.now();

        int n = array.length;

        for (int i = 1; i < n; i++) {
            int chave = array[i];
            int j = i - 1;

            while (j >= 0) {
                resultado.comparacoes++;
                if (array[j] > chave) {
                    array[j + 1] = array[j];
                    resultado.trocas++;
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = chave;
        }

        Instant fim = Instant.now();
        resultado.tempoMillis = Duration.between(inicio, fim).toMillis();
        return resultado;
    }
}
