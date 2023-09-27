import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BinaryTree arvore = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("••••••••ÁRVORE BINÁRIA DE BUSCA••••••••");
        System.out.println("• INSERIR    [1]                      •");
        System.out.println("• BUSCAR     [2]                      •");
        System.out.println("• DELETAR    [3]                      •");
        System.out.println("• VISUALIZAR [4]                      •");
        System.out.println("• SAIR       [0]                      •");
        System.out.println("•••••••••••••••••••••••••••••••••••••••");

        while (true){
            System.out.print("• Digite uma opção: ");
            int opcao = sc.nextInt();
            if(opcao == 0){
                System.out.println("tchau (ง •̀_•́)ง");
                break;
            }if(opcao == 1){
                System.out.print("• insira um elemento na Árvore: ");
                int elemento = sc.nextInt();
                arvore.inserir(elemento);
                System.out.println("• Elemento inserido!");
                System.out.println(" ");

            }if(opcao == 2){
                System.out.print("• Insira um elemento para busca-lo na Árvore: ");
                int busca = sc.nextInt();
                System.out.println(arvore.buscar(busca));
                System.out.println(" ");

            }if(opcao == 3){
                System.out.print("• Insira um elemento para ser deletado da Árvore: ");
                int deletar = sc.nextInt();
                arvore.deletar(deletar);
                System.out.println(" ");

            }if(opcao == 4){
                System.out.println(" ");
                System.out.println("• Vizualização da Árvore: ");
                arvore.print();
                System.out.println(" ");
            }
        }
    }
}