package sort;

import java.time.Duration;
import java.time.Instant;

public class QuickSort {

    public static class Resultado {
        public final long comparacoes;
        public final long trocas;
        public final long tempoMillis;

        public Resultado(long comparacoes, long trocas, long tempoMillis) {
            this.comparacoes = comparacoes;
            this.trocas = trocas;
            this.tempoMillis = tempoMillis;
        }
    }

    private static long comparacoes;
    private static long trocas;

    public static Resultado ordenar(int[] vetor) {
        comparacoes = 0;
        trocas = 0;

        Instant inicio = Instant.now();
        quickSort(vetor, 0, vetor.length - 1);
        Instant fim = Instant.now();

        long tempoMillis = Duration.between(inicio, fim).toMillis();
        return new Resultado(comparacoes, trocas, tempoMillis);
    }

    private static void quickSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(arr, inicio, fim);
            quickSort(arr, inicio, pivoIndex - 1);
            quickSort(arr, pivoIndex + 1, fim);
        }
    }

    private static int particionar(int[] arr, int inicio, int fim) {
        int meio = inicio + (fim - inicio) / 2;
        int pivo = arr[meio];
        trocar(arr, meio, fim); // move o pivô para o final

        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            comparacoes++;
            if (arr[j] <= pivo) {
                i++;
                trocar(arr, i, j);
            }
        }

        trocar(arr, i + 1, fim); // coloca o pivô na posição correta
        return i + 1;
    }

    private static void trocar(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            trocas++;
        }
    }
}
