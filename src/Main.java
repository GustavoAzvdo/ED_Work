import sort.BubbleSort;
import sort.InsertionSort;
import sort.SelectionSort;
import util.CSVWriter;
import util.DataGenerator;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] tamanhos = {1000, 10000, 100000};

        CSVWriter csvCrescente = new CSVWriter("resultados/crescente.csv");
        CSVWriter csvDecrescente = new CSVWriter("resultados/decrescente.csv");
        CSVWriter csvAleatorio = new CSVWriter("resultados/aleatorio.csv");

        for (int tamanho : tamanhos) {
            // === Vetor Crescente ===
            int[] crescente = DataGenerator.gerarCrescente(tamanho);
            testarESalvar("Bubble Sort", BubbleSort::ordenar, crescente, tamanho, "Crescente", csvCrescente);
            testarESalvar("Insertion Sort", InsertionSort::ordenar, crescente, tamanho, "Crescente", csvCrescente);
            testarESalvar("Selection Sort", SelectionSort::ordenar, crescente, tamanho, "Crescente", csvCrescente);
            csvCrescente.escreverLinhaEmBranco();

            // === Vetor Decrescente ===
            int[] decrescente = DataGenerator.gerarDecrescente(tamanho);
            testarESalvar("Bubble Sort", BubbleSort::ordenar, decrescente, tamanho, "Decrescente", csvDecrescente);
            testarESalvar("Insertion Sort", InsertionSort::ordenar, decrescente, tamanho, "Decrescente", csvDecrescente);
            testarESalvar("Selection Sort", SelectionSort::ordenar, decrescente, tamanho, "Decrescente", csvDecrescente);
            csvDecrescente.escreverLinhaEmBranco();

            // === Vetor Aleatório ===
            int[] aleatorio = DataGenerator.gerarAleatorio(tamanho);
            testarESalvar("Bubble Sort", BubbleSort::ordenar, aleatorio, tamanho, "Aleatório", csvAleatorio);
            testarESalvar("Insertion Sort", InsertionSort::ordenar, aleatorio, tamanho, "Aleatório", csvAleatorio);
            testarESalvar("Selection Sort", SelectionSort::ordenar, aleatorio, tamanho, "Aleatório", csvAleatorio);
            csvAleatorio.escreverLinhaEmBranco();
        }

        csvCrescente.fechar();
        csvDecrescente.fechar();
        csvAleatorio.fechar();

        System.out.println("✅ Dados salvos em arquivos separados por cenário na pasta 'resultados'");
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
        }

        csv.escreverLinha(nome, tamanho, cenario, tempo, comparacoes, trocas);
    }
}
