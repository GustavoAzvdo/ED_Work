package util;

import java.util.Random;

public class DataGenerator {

    private static final Random random = new Random(42); // seed fixa para reprodutibilidade

    public static int[] gerarCrescente(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }
        return vetor;
    }

    public static int[] gerarDecrescente(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    public static int[] gerarAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho * 10); // valores aleatórios entre 0 e (tamanho*10)
        }
        return vetor;
    }
}
