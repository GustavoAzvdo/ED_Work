package util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private final FileWriter writer;

    public CSVWriter(String filename) throws IOException {
        writer = new FileWriter(filename);
        writer.append("Algoritmo,Tamanho,Cenario,Tempo (ms),Comparacoes,Trocas\n");
    }

    public void escreverLinha(String algoritmo, int tamanho, String cenario, long tempo, long comparacoes, long trocas) throws IOException {
        writer.append(algoritmo).append(",")
                .append(String.valueOf(tamanho)).append(",")
                .append(cenario).append(",")
                .append(String.valueOf(tempo)).append(",")
                .append(String.valueOf(comparacoes)).append(",")
                .append(String.valueOf(trocas)).append("\n");
    }

    public void escreverLinhaEmBranco() throws IOException {
        writer.append("\n");
    }

    public void fechar() throws IOException {
        writer.flush();
        writer.close();
    }
}
