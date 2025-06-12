package main;

/**
 * Representa um nó em uma Árvore Binária.
 * @param <T> O tipo de dado que o nó armazena, deve ser comparável.
 */
public class No<T extends Comparable<T>> {
    private T valor;
    private No<T> esquerda;
    private No<T> direita;

    public No(T valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    // Getters e Setters
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}