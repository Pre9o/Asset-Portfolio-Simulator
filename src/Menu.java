import java.util.Scanner;
import java.time.LocalDateTime;

public class Menu{
        public static void opcoesMenu(){
        System.out.println("1 - Incluir ativo");
        System.out.println("2 - Comprar ativo");
        System.out.println("3 - Vender ativo");
        System.out.println("4 - Verificar saldo");
        System.out.println("5 - Verificar carteira");
        System.out.println("6 - Sair");
    }

    public static void selecaoMenu(){
        var scanner = new Scanner(System.in);
        var opcao = 0;
        while (opcao != 6) {
            opcoesMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    Carteira.incluirAtivo();
                    break;
                case 2:
                    Carteira.comprarAtivo();
                    break;
                case 3:
                    Carteira.venderAtivo();
                    break;
                case 4:
                    Carteira.verificarRentabilidade();
                    break;
                case 5:
                    Carteira.mostrarCarteira();
                    break;
                case 6:
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public static void sair(){
        System.out.println("Saindo...");
    }
}
