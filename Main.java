import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho da árvore (entre 1 e 50): ");
        int tamanhoArvore = scanner.nextInt();

        if (tamanhoArvore < 1 || tamanhoArvore > 50) {
            System.out.println("Tamanho inválido. Utilizando o tamanho padrão de 10.");
            tamanhoArvore = 10;
        }
        //gera os nós de 0 até 100
        for (int i = 0; i < tamanhoArvore; i++) {
            binaryTree.insert(rand.nextInt(100), binaryTree.raiz);
        }

        //print GERAL das diferentes formas de busca (ta comentado la no BinaryTree como funcionam)
        System.out.println("\nPRE-ORDER");
        binaryTree.PrePesquisa(binaryTree.raiz);

        System.out.println("\nEM-ORDEM");
        binaryTree.PesquisaEmOrdem(binaryTree.raiz);

        System.out.println("\nApos-Ordem");
        binaryTree.PesquisaAposOrdem(binaryTree.raiz);

        //aqui esta dizendo se foi encontrado ou não o nó ESCOLHIDO na arvore e mostrando a altura e a profundidade
        System.out.print("\nDigite um valor para procurar na árvore: ");
        int valorProcurado = scanner.nextInt();

        Node_posicao resultado = binaryTree.search(valorProcurado, binaryTree.raiz, 0, 0);
        
        if (resultado.node != null) {
            System.out.println("\nValor " + valorProcurado + " encontrado na árvore.");
            System.out.println("Altura do nó: " + resultado.altura);
            System.out.println("Profundidade do nó: " + resultado.profundidade);
        } else {
            System.out.println("\nValor " + valorProcurado + " não encontrado na árvore.");
        }
    }
}
