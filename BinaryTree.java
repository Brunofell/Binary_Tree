public class BinaryTree {
    private Node raiz;

    //MUDEI UM POUCO SEUS METODOS! So simplifiquei na vdd.
    /// Aqui, ele recebe dois parametros, a posição (A posicao é sempre a raiz) e o valor inserido
    // ele checa se a posição é = a null, se for retorna o valor naquela posição
    // checa se o valor inserido é menor que o valor da posição atual, se for, vai pra esquerda
    // checa se o valor inserido é maior que o valor da posição atual, se for, vai pra direita
    private Node inserirValor(Node posicao, int valor) {
        if(posicao == null){
            return new Node(valor);
        }
        if(valor  < posicao.getValor()){
            posicao.setEsquerda(inserirValor(posicao.getEsquerda(), valor));
        }else if(valor > posicao.getValor()){
            posicao.setDireita(inserirValor(posicao.getDireita(), valor));
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
        if(valor == posicao.getValor()){
            return true;
        }
        if(valor < posicao.getValor()){
            return buscarValor(posicao.getEsquerda(), valor);
        }
        else {
            return buscarValor(posicao.getDireita(), valor);
        }
    }
    // so pra chamar na main
    public boolean buscar(int valor){
        return buscarValor(raiz, valor);
    }

    private Node deletarValor(Node posicao, int valor) {
        if (posicao == null) {
            System.out.println("Esse elemento não existe!");
            return null;
        }

        if (valor == posicao.getValor()) {
            if (posicao.getEsquerda() == null && posicao.getDireita() == null) { // no folha
                System.out.println(posicao.getValor() + " removido");
                return null;
            }

            if (posicao.getDireita() == null) { // nó com um filho
                System.out.println("• " + posicao.getValor() + " removido");
                return posicao.getEsquerda();
            }
            if (posicao.getEsquerda() == null) { // nó com um filho
                System.out.println("• " + posicao.getValor() + " removido");
                return posicao.getDireita();
            }

            Node maiorNo = posicao.getEsquerda(); // dois filhos
            while (maiorNo.getDireita() != null) { // maior valor na subárvore esquerda, vai pelos nos da direita
                maiorNo = maiorNo.getDireita(); // sempre a folha
            }

            posicao.setValor(maiorNo.getValor()); // mudando a raiz
            posicao.setEsquerda(deletarValor(posicao.getEsquerda(), maiorNo.getValor()));
            return posicao;
        }

        if (valor < posicao.getValor()) { //continua a busca
            posicao.setEsquerda(deletarValor(posicao.getEsquerda(), valor));
            return posicao;
        }
        posicao.setDireita(deletarValor(posicao.getDireita(), valor)); // subarvore da direita
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
        printRecursivo(posicao.getDireita(), nivel + 1);

        // Imprime o valor do nó atual com base no nível (formato horizontal)
        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); // Espaço para indentação
        }
        System.out.println(posicao.getValor());

        // Imprime a subárvore esquerda depois (inorder)
        printRecursivo(posicao.getEsquerda(), nivel + 1);
    }

}