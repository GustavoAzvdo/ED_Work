package sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ArraysSort {

    public static class Resultado {
        public final long tempoMillis;

        public Resultado(long tempoMillis) {
            this.tempoMillis = tempoMillis;
        }
    }

    public static Resultado ordenar(int[] vetor) {
        Instant inicio = Instant.now();
        Arrays.sort(vetor);
        Instant fim = Instant.now();

        long tempo = Duration.between(inicio, fim).toMillis();
        return new Resultado(tempo);
    }
}
