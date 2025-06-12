package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementação de uma Árvore Binária de Pesquisa.
 * @param <T> O tipo de dado que a árvore armazena.
 */
public class ArvoreBinaria<T extends Comparable<T>> {

    private No<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    // ========== INSERÇÃO ==========
    public void inserir(T valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No<T> inserirRecursivo(No<T> atual, T valor) {
        if (atual == null) {
            return new No<>(valor);
        }

        if (valor.compareTo(atual.getValor()) < 0) {
            atual.setEsquerda(inserirRecursivo(atual.getEsquerda(), valor));
        } else if (valor.compareTo(atual.getValor()) > 0) {
            atual.setDireita(inserirRecursivo(atual.getDireita(), valor));
        }
        // Se o valor já existe, não faz nada e retorna o nó atual.
        return atual;
    }

    // ========== REMOÇÃO ==========
    public void remover(T valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No<T> removerRecursivo(No<T> atual, T valor) {
        if (atual == null) {
            return null; // Valor não encontrado
        }

        if (valor.compareTo(atual.getValor()) < 0) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), valor));
        } else if (valor.compareTo(atual.getValor()) > 0) {
            atual.setDireita(removerRecursivo(atual.getDireita(), valor));
        } else {
            // Nó a ser removido encontrado!

            // Caso 1: Nó sem filhos (folha)
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            // Caso 2: Nó com um filho
            if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            }

            // Caso 3: Nó com dois filhos
            // Encontrar o menor valor na subárvore direita (sucessor em ordem)
            T menorValor = encontrarMenorValor(atual.getDireita());
            atual.setValor(menorValor);
            atual.setDireita(removerRecursivo(atual.getDireita(), menorValor));
        }
        return atual;
    }

    private T encontrarMenorValor(No<T> no) {
        return no.getEsquerda() == null ? no.getValor() : encontrarMenorValor(no.getEsquerda());
    }

    // ========== PERCURSOS (TRAVERSALS) ==========
    public void imprimirPreOrdem() {
        System.out.print("Pré-ordem: ");
        percorrerPreOrdem(raiz);
        System.out.println();
    }

    private void percorrerPreOrdem(No<T> no) {
        if (no != null) {
            System.out.print(no.getValor() + " ");
            percorrerPreOrdem(no.getEsquerda());
            percorrerPreOrdem(no.getDireita());
        }
    }

    public void imprimirEmOrdem() {
        System.out.print("Em-ordem: ");
        percorrerEmOrdem(raiz);
        System.out.println();
    }

    private void percorrerEmOrdem(No<T> no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerda());
            System.out.print(no.getValor() + " ");
            percorrerEmOrdem(no.getDireita());
        }
    }
    
    public void imprimirPosOrdem() {
        System.out.print("Pós-ordem: ");
        percorrerPosOrdem(raiz);
        System.out.println();
    }

    private void percorrerPosOrdem(No<T> no) {
        if (no != null) {
            percorrerPosOrdem(no.getEsquerda());
            percorrerPosOrdem(no.getDireita());
            System.out.print(no.getValor() + " ");
        }
    }

    // ========== FUNCIONALIDADES ADICIONAIS ==========
    
    public String getPreOrdem() {
        StringBuilder sb = new StringBuilder("Pré-ordem: ");
        percorrerPreOrdem(raiz, sb);
        return sb.toString();
    }

    private void percorrerPreOrdem(No<T> no, StringBuilder sb) {
        if (no != null) {
            sb.append(no.getValor()).append(" ");
            percorrerPreOrdem(no.getEsquerda(), sb);
            percorrerPreOrdem(no.getDireita(), sb);
        }
    }

    public String getEmOrdem() {
        StringBuilder sb = new StringBuilder("Em-ordem: ");
        percorrerEmOrdem(raiz, sb);
        return sb.toString();
    }

    private void percorrerEmOrdem(No<T> no, StringBuilder sb) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerda(), sb);
            sb.append(no.getValor()).append(" ");
            percorrerEmOrdem(no.getDireita(), sb);
        }
    }

    public String getPosOrdem() {
        StringBuilder sb = new StringBuilder("Pós-ordem: ");
        percorrerPosOrdem(raiz, sb);
        return sb.toString();
    }

    private void percorrerPosOrdem(No<T> no, StringBuilder sb) {
        if (no != null) {
            percorrerPosOrdem(no.getEsquerda(), sb);
            percorrerPosOrdem(no.getDireita(), sb);
            sb.append(no.getValor()).append(" ");
        }
    }

    // ========== VISUALIZAÇÃO GRÁFICA EM TEXTO ==========

    public String gerarVisualizacao() {
        if (raiz == null) {
            return "Árvore vazia.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Visualização da Árvore:\n");
        gerarVisualizacaoRecursiva(sb, raiz, "", true);
        return sb.toString();
    }

    /**
     * Gera uma representação textual da árvore.
     * @param sb O StringBuilder para construir a string.
     * @param no O nó atual.
     * @param prefixo O prefixo de indentação para a linha atual.
     * @param isTail True se for o último filho do pai, para desenhar '└──', senão '├──'.
     */
    private void gerarVisualizacaoRecursiva(StringBuilder sb, No<T> no, String prefixo, boolean isTail) {
        if (no != null) {
            sb.append(prefixo).append(isTail ? "└── " : "├── ").append(no.getValor()).append("\n");
            // O filho da direita vem primeiro para que a árvore cresça "para cima" no texto
            if (no.getDireita() != null || no.getEsquerda() != null) {
                if (no.getDireita() != null) {
                    gerarVisualizacaoRecursiva(sb, no.getDireita(), prefixo + (isTail ? "    " : "│   "), no.getEsquerda() == null);
                }
                if (no.getEsquerda() != null) {
                    gerarVisualizacaoRecursiva(sb, no.getEsquerda(), prefixo + (isTail ? "    " : "│   "), true);
                }
            }
        }
    }

    public boolean pesquisar(T valor) {
        return pesquisarRecursivo(raiz, valor);
    }

    private boolean pesquisarRecursivo(No<T> atual, T valor) {
        if (atual == null) {
            return false;
        }
        if (valor.equals(atual.getValor())) {
            return true;
        }
        return valor.compareTo(atual.getValor()) < 0
            ? pesquisarRecursivo(atual.getEsquerda(), valor)
            : pesquisarRecursivo(atual.getDireita(), valor);
    }
    
    public int getAltura() {
        return calcularAltura(raiz);
    }
    
    private int calcularAltura(No<T> no) {
        if (no == null) {
            return -1; // Altura de árvore vazia ou nó nulo é -1
        }
        int alturaEsquerda = calcularAltura(no.getEsquerda());
        int alturaDireita = calcularAltura(no.getDireita());
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }
    
    public int getGrauDoNo(T valor) {
        No<T> no = encontrarNo(raiz, valor);
        if (no == null) {
            return -1; // Nó não encontrado
        }
        int grau = 0;
        if (no.getEsquerda() != null) grau++;
        if (no.getDireita() != null) grau++;
        return grau;
    }
    
    private No<T> encontrarNo(No<T> atual, T valor) {
        if (atual == null || valor.equals(atual.getValor())) {
            return atual;
        }
        return valor.compareTo(atual.getValor()) < 0
            ? encontrarNo(atual.getEsquerda(), valor)
            : encontrarNo(atual.getDireita(), valor);
    }

    // ========== PROPRIEDADES DA ÁRVORE ==========

    public boolean isEstritamenteBinaria() {
        return verificarEstritamenteBinaria(raiz);
    }

    private boolean verificarEstritamenteBinaria(No<T> no) {
        if (no == null) {
            return true; // Árvore vazia é estritamente binária
        }
        // Se for um nó folha
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return true;
        }
        // Se tiver ambos os filhos, checar as subárvores
        if (no.getEsquerda() != null && no.getDireita() != null) {
            return verificarEstritamenteBinaria(no.getEsquerda()) && verificarEstritamenteBinaria(no.getDireita());
        }
        // Se tiver apenas um filho, não é estritamente binária
        return false;
    }
    
    public boolean isCheia() {
        int h = getAltura();
        return verificarCheia(raiz, h, 0);
    }

    private boolean verificarCheia(No<T> no, int altura, int nivel) {
        if (no == null) {
            return true;
        }
        // Se é um nó folha, deve estar no último nível
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return (altura == nivel);
        }
        // Se não é folha e tem apenas um filho, não é cheia
        if (no.getEsquerda() == null || no.getDireita() == null) {
            return false;
        }
        // Checa recursivamente para as subárvores
        return verificarCheia(no.getEsquerda(), altura, nivel + 1) && verificarCheia(no.getDireita(), altura, nivel + 1);
    }
    
    public boolean isCompleta() {
        if (raiz == null) {
            return true;
        }
        Queue<No<T>> queue = new LinkedList<>();
        queue.add(raiz);
        boolean fimNivel = false;

        while (!queue.isEmpty()) {
            No<T> noAtual = queue.poll();

            if (noAtual.getEsquerda() != null) {
                if (fimNivel) return false; // Se já encontramos um buraco, não pode haver mais nós
                queue.add(noAtual.getEsquerda());
            } else {
                fimNivel = true; // Encontrou o primeiro "buraco"
            }

            if (noAtual.getDireita() != null) {
                if (fimNivel) return false;
                queue.add(noAtual.getDireita());
            } else {
                fimNivel = true;
            }
        }
        return true;
    }
}
