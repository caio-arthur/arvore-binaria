Este projeto consiste na implementação de uma **Árvore Binária de Pesquisa** utilizando a linguagem Java. O programa permite a manipulação completa da árvore e a análise de suas propriedades estruturais, com uma interface de usuário gráfica simples baseada em `JOptionPane`.

## 📜 Sumário

- [Funcionalidades](#-funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Como Executar o Projeto](#-como-executar-o-projeto)
- [Demonstração](#-demonstração)
- [Autor](#-autor)

## ✨ Funcionalidades

- **Inserção de Elementos**: Adiciona novos nós à árvore mantendo suas propriedades.
- **Remoção de Elementos**: Remove nós tratando os três casos possíveis (nó folha, nó com um filho, nó com dois filhos).
- **Busca**: Verifica se um elemento existe na árvore.
- **Percursos**:
  - Pré-ordem (`Root -> Left -> Right`)
  - Em-ordem (`Left -> Root -> Right`)
  - Pós-ordem (`Left -> Right -> Root`)
- **Análise da Estrutura**:
  - Calcular a **altura** da árvore.
  - Obter o **grau** de um nó específico.
  - Verificar se a árvore é **estritamente binária** (nós com 0 ou 2 filhos).
  - Verificar se a árvore é **cheia** (todos os nós internos com 2 filhos e folhas no mesmo nível).
  - Verificar se a árvore é **completa** (niveis preenchidos da esquerda para a direita).
- **Interface Gráfica**: Menu interativo construído com `javax.swing.JOptionPane`.

## 🛠️ Tecnologias Utilizadas

- **[Java](https://www.java.com/) (Versão 11 ou superior)**: Linguagem principal do projeto.
- **[Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/)**: Utilizado para a interface gráfica com o usuário (`JOptionPane`).

## 🚀 Como Executar o Projeto

Você precisará ter o **JDK (Java Development Kit)** instalado em sua máquina (versão 11 ou superior).

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/caio-arthur/arvore-binaria.git
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd seu-repositorio
    ```

3.  **Compile os arquivos `.java`:**
    (Assumindo que seus arquivos estão na estrutura de pacotes dentro de um diretório `src`)
    ```bash
    # No Windows (usando ;)
    javac -d bin src\com\meuprojeto\arvore\*.java src\com\meuprojeto\app\*.java

    # No Linux/macOS (usando :)
    javac -d bin src/com/meuprojeto/arvore/*.java src/com/meuprojeto/app/*.java
    ```

4.  **Execute a classe principal:**

Após a execução, o menu gráfico da aplicação será exibido.

## 👤 Autor

- **Seu Nome** - [LinkedIn]([https://www.linkedin.com/in/seu-usuario/](https://www.linkedin.com/in/carthur-backend-developer/))
