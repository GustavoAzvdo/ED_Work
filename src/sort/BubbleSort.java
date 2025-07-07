package sort;

import java.time.Duration;
import java.time.Instant;

public class BubbleSort {

    public static class Resultado {
        public long comparacoes = 0;
        public long trocas = 0;
        public long tempoMillis = 0;
    }

    public static Resultado ordenar(int[] array) {
        Resultado resultado = new Resultado();
        Instant inicio = Instant.now();

        int n = array.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                resultado.comparacoes++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    resultado.trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }

        Instant fim = Instant.now();
        resultado.tempoMillis = Duration.between(inicio, fim).toMillis();
        return resultado;
    }
}
