public class BinaryTree {
    Node raiz;

    //MUDEI UM POUCO SEUS METODOS! So simplifiquei na vdd.
    /// Aqui, ele recebe dois parametros, a posição (A posicao é sempre a raiz) e o valor inserido
    // ele checa se a posição é = a null, se for retorna o valor naquela posição
    // checa se o valor inserido é menor que o valor da posição atual, se for, vai pra esquerda
    // checa se o valor inserido é maior que o valor da posição atual, se for, vai pra direita
    private Node inserirValor(Node posicao, int valor) {
        if(posicao == null){
            return new Node(valor);
        }
        if(valor  < posicao.valor){
            posicao.esquerda = inserirValor(posicao.esquerda, valor);
        }else if(valor > posicao.valor){
            posicao.direita = inserirValor(posicao.direita, valor);
        }else{
            return posicao;
        }
        return posicao;
    }
    // Esse aqui é so pra chamar o metodo na main
    public void inserir(int valor){
        raiz = inserirValor(raiz, valor);
    }

    // MUDEI UM POUCO SEUS METODOS! So simplifiquei na vdd.
    // Aqui ele recebe a posição e o valor a ser procurado (A posicao é sempre a raiz);
    // Checa se a posição é null, se for retorna false.
    // se a posição foi igual ao valor, retorna true
    // se o valor for menor que a posição atual, ele vai pra esquerda
    // se o valor for maior que a posição atual, ele vai pra direita (ta no else)
    private boolean buscarValor(Node posicao, int valor){
        if(posicao == null){
            return false;
        }
        if(valor == posicao.valor){
            return true;
        }
        if(valor < posicao.valor){
            return buscarValor(posicao.esquerda, valor);
        }
        else {
            return buscarValor(posicao.direita, valor);
        }
    }
    // so pra chamar na main
    public boolean buscar(int valor){
        return buscarValor(raiz, valor);
    }

    private Node deletarValor(Node posicao, int valor) {
        if (posicao == null) {
            return null; // encontrou nda
        }
        if (valor == posicao.valor) {
            // Node não tem filhos
            if (posicao.esquerda == null && posicao.direita == null) {
                return null;
            }
            if (posicao.direita == null) {
                return posicao.esquerda;
            }
            if (posicao.esquerda == null) {
                return posicao.direita;
            }

            Node maiorNo = posicao.esquerda;
            while (maiorNo.direita != null) {
                maiorNo = maiorNo.direita;
            }

            posicao.valor = maiorNo.valor;
            posicao.esquerda = deletarValor(posicao.esquerda, maiorNo.valor);
            return posicao;
        }
        if (valor < posicao.valor) {
            posicao.esquerda = deletarValor(posicao.esquerda, valor);
            return posicao;
        }
        posicao.direita = deletarValor(posicao.direita, valor);
        return posicao;
    }
    public void deletar(int valor) {
        raiz = deletarValor(raiz, valor);
    }

    public void print() {
        printRecursivo(raiz, 0);
    }
    private void printRecursivo(Node posicao, int nivel) {
        if (posicao == null) {
            return;
        }

        // Imprime a subárvore direita primeiro (inorder)
        printRecursivo(posicao.direita, nivel + 1);

        // Imprime o valor do nó atual com base no nível (formato horizontal)
        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); // Espaço para indentação
        }
        System.out.println(posicao.valor);

        // Imprime a subárvore esquerda depois (inorder)
        printRecursivo(posicao.esquerda, nivel + 1);
    }


}
