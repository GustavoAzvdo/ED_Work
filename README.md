# 🔢 Trabalho de Estrutura de Dados – Comparação de Algoritmos de Ordenação

Este projeto tem como objetivo comparar o desempenho de diferentes algoritmos de ordenação, analisando tempo de execução, número de comparações e número de trocas sob diferentes cenários de entrada.

## 📚 Algoritmos implementados

### Complexidade O(n²)
- Bubble Sort
- Insertion Sort
- Selection Sort

### Complexidade O(n log n)
- Merge Sort
- Quick Sort
- Arrays.sort() (Java nativo)

---

## 🧪 Cenários testados

- Vetor com dados **crescentes**
- Vetor com dados **decrescentes**
- Vetor com dados **aleatórios**

Para cada cenário, foram realizados testes com os seguintes tamanhos:

- 1.000 elementos
- 10.000 elementos
- 100.000 elementos

---

## 🧾 Coleta de dados

Para cada execução, são coletados os seguintes dados:

- Tempo de execução (em milissegundos)
- Número de comparações
- Número de trocas

Os resultados são salvos em arquivos CSV dentro da pasta `resultados/` 
---

## 📈 Gráficos

Alternativamente, os arquivos `.csv` podem ser importados para Excel ou Google Sheets para análise visual.

---

## 📦 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/GustavoAzvdo/ED_Work.git
