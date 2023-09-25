public class BinaryTree {
    Node raiz;

    public Node insert(int valor, Node posicao) {
        if (posicao == null) {
            raiz = new Node(valor);
        } else if (valor < posicao.valor) {
            if (posicao.esquerda == null) {
                posicao.esquerda = new Node(valor);
            } else {
                insert(valor, posicao.esquerda);
            }
        } else if (valor > posicao.valor) {
            if (posicao.direita == null) {
                posicao.direita = new Node(valor);
            } else {
                insert(valor, posicao.direita);
            }
        }
        return posicao;
    }

    public Node PrePesquisa(Node place) {
        System.out.print(" " + place.valor);
        if (place.esquerda != null) {
            PrePesquisa(place.esquerda);
        }
        if (place.direita != null) {
            PrePesquisa(place.direita);
        }
        return place;
    }

    public Node PesquisaEmOrdem(Node place) {
        if (place.esquerda != null) {
            PesquisaEmOrdem(place.esquerda);
        }
        System.out.print(" " + place.valor);
        if (place.direita != null) {
            PesquisaEmOrdem(place.direita);
        }
        return place;
    }

    public Node PesquisaAposOrdem(Node place) {
        if (place.esquerda != null) {
            PesquisaAposOrdem(place.esquerda);
        }
        System.out.print(" " + place.valor);
        if (place.direita != null) {
            PesquisaAposOrdem(place.direita);
        }
        return place;
    }

    public Node_posicao search(int valor, Node posicao, int altura, int profundidade) {
        if (posicao == null) {
            return new Node_posicao(null, -1, -1); // Nó não encontrado
        }

        if (posicao.valor == valor) {
            return new Node_posicao(posicao, altura, profundidade);
        }

        if (valor < posicao.valor) {
            return search(valor, posicao.esquerda, altura + 1, profundidade + 1);
        } else {
            return search(valor, posicao.direita, altura + 1, profundidade + 1);
        }
    }

    private Node deletaRecursivo(Node atual, int valor){
        if(atual == null){
            return null; // encontrou nda
        }
        if(valor == atual.valor){
            // Node não tem filhos
            if(atual.esquerda == null && atual.direita == null){
                return null;
            }
            if(atual.direita == null){
                return atual.esquerda;
            }
            if(atual.esquerda == null){
                return atual.direita;
            }
            int smallestValue = menorNo(atual.direita);
            atual.valor = smallestValue;
            atual.direita = deletaRecursivo(atual.direita, smallestValue);
            return atual;
        }
        if(valor < atual.valor){
            atual.esquerda = deletaRecursivo(atual.esquerda, valor);
            return atual;
        }
        atual.direita = deletaRecursivo(atual.direita, valor);
        return atual;
    }

    private int menorNo(Node raiz){
        if(raiz.esquerda == null){
            return raiz.valor;
        }else{
            return menorNo(raiz.esquerda);
        }
    }

    public void delete(int valor) {
        raiz = deletaRecursivo(raiz, valor);
    }

}
