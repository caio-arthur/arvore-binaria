package main;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        
        // Loop principal do menu
        while (true) {
            String menu = "===== MENU ÁRVORE BINÁRIA =====\n\n"
                        + "1. Inserir um número\n"
                        + "2. Remover um número\n"
                        + "3. Pesquisar um número\n"
                        + "4. Imprimir em Pré-ordem\n"
                        + "5. Imprimir em Em-ordem\n"
                        + "6. Imprimir em Pós-ordem\n"
                        + "7. Verificar se é Estritamente Binária\n"
                        + "8. Verificar se é Completa\n"
                        + "9. Verificar se é Cheia\n"
                        + "10. Obter altura da árvore\n"
                        + "11. Obter grau de um nó\n"
                        + "0. Sair\n\n"
                        + "Escolha uma opção:";

            String escolhaStr = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.PLAIN_MESSAGE);

            // Se o usuário cancelar ou fechar a janela
            if (escolhaStr == null) {
                break;
            }

            try {
                int escolha = Integer.parseInt(escolhaStr);

                if (escolha == 0) {
                    break; // Sai do loop
                }

                switch (escolha) {
                    case 1:
                        String valorInserirStr = JOptionPane.showInputDialog("Digite o valor para inserir:");
                        if (valorInserirStr != null) {
                            arvore.inserir(Integer.parseInt(valorInserirStr));
                            JOptionPane.showMessageDialog(null, "Valor inserido com sucesso!");
                        }
                        break;
                    case 2:
                        String valorRemoverStr = JOptionPane.showInputDialog("Digite o valor para remover:");
                         if (valorRemoverStr != null) {
                            arvore.remover(Integer.parseInt(valorRemoverStr));
                            JOptionPane.showMessageDialog(null, "Tentativa de remoção concluída.");
                        }
                        break;
                    case 3:
                        String valorPesquisarStr = JOptionPane.showInputDialog("Digite o valor para pesquisar:");
                         if (valorPesquisarStr != null) {
                            boolean encontrado = arvore.pesquisar(Integer.parseInt(valorPesquisarStr));
                            JOptionPane.showMessageDialog(null, "O valor " + (encontrado ? "foi encontrado." : "não foi encontrado."));
                        }
                        break;
                    case 4:
                        exibirMensagemFormatada("Percurso Pré-ordem", arvore.getPreOrdem());
                        break;
                    case 5:
                        exibirMensagemFormatada("Percurso Em-ordem", arvore.getEmOrdem());
                        break;
                    case 6:
                        exibirMensagemFormatada("Percurso Pós-ordem", arvore.getPosOrdem());
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "A árvore é estritamente binária? " + arvore.isEstritamenteBinaria());
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "A árvore é completa? " + arvore.isCompleta());
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "A árvore é cheia? " + arvore.isCheia());
                        break;
                    case 10:
                        JOptionPane.showMessageDialog(null, "Altura da árvore: " + arvore.getAltura());
                        break;
                    case 11:
                        String valorGrauStr = JOptionPane.showInputDialog("Digite o valor do nó para saber o grau:");
                        if (valorGrauStr != null) {
                            int grau = arvore.getGrauDoNo(Integer.parseInt(valorGrauStr));
                             if (grau == -1) {
                                JOptionPane.showMessageDialog(null, "Nó não encontrado.");
                            } else {
                                JOptionPane.showMessageDialog(null, "O grau do nó é: " + grau);
                            }
                        }
                        break;
                    case 12:
                        exibirMensagemFormatada("Visualização da Árvore", arvore.gerarVisualizacao());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Exibe uma mensagem em um JTextArea com fonte monoespaçada e dentro de um JScrollPane.
     * Ideal para exibir a árvore textual ou listas.
     * @param titulo O título da janela.
     * @param mensagem A mensagem a ser exibida.
     */
    private static void exibirMensagemFormatada(String titulo, String mensagem) {
        JTextArea textArea = new JTextArea(mensagem);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Fonte monoespaçada para alinhamento
        textArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Tamanho preferencial da caixa de diálogo
        
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}