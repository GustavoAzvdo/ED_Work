import sort.*;
import util.CSVWriter;
import util.DataGenerator;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] tamanhos = {1000, 10000, 100000};

        // CSVs para O(n²)
        CSVWriter csvOn2Crescente = new CSVWriter("resultados/on2_crescente.csv");
        CSVWriter csvOn2Decrescente = new CSVWriter("resultados/on2_decrescente.csv");
        CSVWriter csvOn2Aleatorio = new CSVWriter("resultados/on2_aleatorio.csv");

        // CSVs para O(n log n)
        CSVWriter csvOnLognCrescente = new CSVWriter("resultados/onlogn_crescente.csv");
        CSVWriter csvOnLognDecrescente = new CSVWriter("resultados/onlogn_decrescente.csv");
        CSVWriter csvOnLognAleatorio = new CSVWriter("resultados/onlogn_aleatorio.csv");

        for (int tamanho : tamanhos) {
            int[] crescente = DataGenerator.gerarCrescente(tamanho);
            int[] decrescente = DataGenerator.gerarDecrescente(tamanho);
            int[] aleatorio = DataGenerator.gerarAleatorio(tamanho);

            // O(n²) - CRESCENTE
            testarESalvar("Bubble Sort", BubbleSort::ordenar, crescente, tamanho, "Crescente", csvOn2Crescente);
            testarESalvar("Insertion Sort", InsertionSort::ordenar, crescente, tamanho, "Crescente", csvOn2Crescente);
            testarESalvar("Selection Sort", SelectionSort::ordenar, crescente, tamanho, "Crescente", csvOn2Crescente);
            csvOn2Crescente.escreverLinhaEmBranco();

            // O(n²) - DECRESCENTE
            testarESalvar("Bubble Sort", BubbleSort::ordenar, decrescente, tamanho, "Decrescente", csvOn2Decrescente);
            testarESalvar("Insertion Sort", InsertionSort::ordenar, decrescente, tamanho, "Decrescente", csvOn2Decrescente);
            testarESalvar("Selection Sort", SelectionSort::ordenar, decrescente, tamanho, "Decrescente", csvOn2Decrescente);
            csvOn2Decrescente.escreverLinhaEmBranco();

            // O(n²) - ALEATÓRIO
            testarESalvar("Bubble Sort", BubbleSort::ordenar, aleatorio, tamanho, "Aleatório", csvOn2Aleatorio);
            testarESalvar("Insertion Sort", InsertionSort::ordenar, aleatorio, tamanho, "Aleatório", csvOn2Aleatorio);
            testarESalvar("Selection Sort", SelectionSort::ordenar, aleatorio, tamanho, "Aleatório", csvOn2Aleatorio);
            csvOn2Aleatorio.escreverLinhaEmBranco();

            // O(n log n) - CRESCENTE
            testarESalvar("Quick Sort", QuickSort::ordenar, crescente, tamanho, "Crescente", csvOnLognCrescente);
            testarESalvar("Merge Sort", MergeSort::ordenar, crescente, tamanho, "Crescente", csvOnLognCrescente);
            testarESalvar("Arrays.sort", ArraysSort::ordenar, crescente, tamanho, "Crescente", csvOnLognCrescente);
            csvOnLognCrescente.escreverLinhaEmBranco();

            // O(n log n) - DECRESCENTE
            testarESalvar("Quick Sort", QuickSort::ordenar, decrescente, tamanho, "Decrescente", csvOnLognDecrescente);
            testarESalvar("Merge Sort", MergeSort::ordenar, decrescente, tamanho, "Decrescente", csvOnLognDecrescente);
            testarESalvar("Arrays.sort", ArraysSort::ordenar, decrescente, tamanho, "Decrescente", csvOnLognDecrescente);
            csvOnLognDecrescente.escreverLinhaEmBranco();

            // O(n log n) - ALEATÓRIO
            testarESalvar("Quick Sort", QuickSort::ordenar, aleatorio, tamanho, "Aleatório", csvOnLognAleatorio);
            testarESalvar("Merge Sort", MergeSort::ordenar, aleatorio, tamanho, "Aleatório", csvOnLognAleatorio);
            testarESalvar("Arrays.sort", ArraysSort::ordenar, aleatorio, tamanho, "Aleatório", csvOnLognAleatorio);
            csvOnLognAleatorio.escreverLinhaEmBranco();
        }

        // Fechar arquivos
        csvOn2Crescente.fechar();
        csvOn2Decrescente.fechar();
        csvOn2Aleatorio.fechar();
        csvOnLognCrescente.fechar();
        csvOnLognDecrescente.fechar();
        csvOnLognAleatorio.fechar();

        System.out.println("✅ Resultados salvos na pasta 'resultados'");
    }

    interface AlgoritmoOrdenacao {
        Object ordenar(int[] vetor);
    }

    public static void testarESalvar(String nome, AlgoritmoOrdenacao algoritmo, int[] vetorOriginal, int tamanho, String cenario, CSVWriter csv) throws IOException {
        int[] vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
        Object resultadoObj = algoritmo.ordenar(vetor);

        long comparacoes = 0;
        long trocas = 0;
        long tempo = 0;

        if (resultadoObj instanceof BubbleSort.Resultado res) {
            comparacoes = res.comparacoes;
            trocas = res.trocas;
            tempo = res.tempoMillis;
        } else if (resultadoObj instanceof InsertionSort.Resultado res) {
            comparacoes = res.comparacoes;
            trocas = res.trocas;
            tempo = res.tempoMillis;
        } else if (resultadoObj instanceof SelectionSort.Resultado res) {
            comparacoes = res.comparacoes;
            trocas = res.trocas;
            tempo = res.tempoMillis;
        } else if (resultadoObj instanceof QuickSort.Resultado res) {
            comparacoes = res.comparacoes;
            trocas = res.trocas;
            tempo = res.tempoMillis;
        } else if (resultadoObj instanceof MergeSort.Resultado res) {
            comparacoes = res.comparacoes;
            trocas = res.trocas;
            tempo = res.tempoMillis;
        } else if (resultadoObj instanceof ArraysSort.Resultado res) {
            comparacoes = -1; // Não é possível medir
            trocas = -1;
            tempo = res.tempoMillis;
        }

        csv.escreverLinha(nome, tamanho, cenario, tempo, comparacoes, trocas);
    }
}
