package sort;

import java.time.Duration;
import java.time.Instant;

public class MergeSort {

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
        mergeSort(vetor, 0, vetor.length - 1);
        Instant fim = Instant.now();

        long tempoMillis = Duration.between(inicio, fim).toMillis();
        return new Resultado(comparacoes, trocas, tempoMillis);
    }

    private static void mergeSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);
            merge(vetor, esquerda, meio, direita);
        }
    }

    private static void merge(int[] vetor, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia dados para vetores temporários L[] e R[]
        for (int i = 0; i < n1; ++i) L[i] = vetor[esquerda + i];
        for (int j = 0; j < n2; ++j) R[j] = vetor[meio + 1 + j];

        int i = 0, j = 0;
        int k = esquerda;

        while (i < n1 && j < n2) {
            comparacoes++;
            if (L[i] <= R[j]) {
                vetor[k] = L[i];
                i++;
            } else {
                vetor[k] = R[j];
                j++;
            }
            trocas++; // consideramos como troca a escrita no vetor original
            k++;
        }

        // Copia os elementos restantes de L[], se houver
        while (i < n1) {
            vetor[k] = L[i];
            i++;
            k++;
            trocas++;
        }

        // Copia os elementos restantes de R[], se houver
        while (j < n2) {
            vetor[k] = R[j];
            j++;
            k++;
            trocas++;
        }
    }
}
