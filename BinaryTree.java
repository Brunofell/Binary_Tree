public class BinaryTree {
    Node raiz;
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
