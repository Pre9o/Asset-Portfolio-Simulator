import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Scanner;

public class Carteira {
    private static Connection conn = null;

    public static Connection getConn() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    return conn;
                }
            } catch (SQLException e) {
                System.out.println("Erro ao conectar com o banco de dados");
            }
        }
        String host = "localhost:3306";
        String db = "bancodedados";
        String url = "jdbc:mysql://" + host + "/" + db;
        String user = "root";
        String pwd = "123456";
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados");
            conn = null;
        }
        return conn;
    }

    public static void incluirAtivo(){
        var scanner = new Scanner(System.in);
        System.out.println("Digite o codigo do ativo: ");
        var codigo = scanner.nextInt();
        System.out.println("Digite o tipo do codigo do ativo: ");
        var tipo = scanner.nextInt();
        System.out.println("Digite o nome do ativo: ");
        var nome = scanner.nextLine();
        var ativo = new Ativos(codigo, tipo, nome);
        var ativodao = new AtivosDAO();
        ativodao.create(ativo);
        System.out.println("Ativo criado com sucesso");
    }

    public static void verificarRentabilidade(){
        var scanner = new Scanner(System.in);
        System.out.println("Digite o codigo do ativo que voce quer verificar a rentabilidade: ");
        var codigo = scanner.nextInt();
        var ativodao = new AtivosDAO();
        var ativo = ativodao.read();
        var carteiradao = new CarteiraDoUsuarioDAO();
        var carteira = carteiradao.read();
        var data = LocalDate.now();
        //printar o valor do ativo na data de hoje
        System.out.println("O valor do ativo na data de hoje é: " + carteira);
    }

    public static void comprarAtivo(){
        var scanner = new Scanner(System.in);
        System.out.println("Digite o codigo do ativo que voce quer comprar: ");
        var codigo = scanner.nextInt();
        System.out.println("Digite a quantidade de ativos que voce quer comprar: ");
        var quantidade = scanner.nextInt();
        var ativodao = new AtivosDAO();
        var ativo = ativodao.read();
        var carteira = new CarteiraDoUsuarioDAO();
        var data = LocalDate.now();
        //printar o valor do ativo na data de hoje
        System.out.println("O valor do ativo na data de hoje é: " + ativo);
    }

    public static void venderAtivo(){
        var scanner = new Scanner(System.in);
        System.out.println("Digite o codigo do ativo que voce quer vender: ");
        var codigo = scanner.nextInt();
        System.out.println("Digite a quantidade de ativos que voce quer vender: ");
        var quantidade = scanner.nextInt();
        var ativodao = new AtivosDAO();
        var ativo = ativodao.read();
        var carteira = new CarteiraDoUsuarioDAO();
        var data = LocalDate.now();
        //printar o valor do ativo na data de hoje
        System.out.println("O valor do ativo na data de hoje é: " + ativo);
    }

    public static void mostrarCarteira(){
        var scanner = new Scanner(System.in);
        System.out.println("Digite o codigo do ativo que voce quer ver na carteira: ");
        var codigo = scanner.nextInt();
        var ativodao = new AtivosDAO();
        var ativo = ativodao.read();
        var carteira = new CarteiraDoUsuarioDAO();
        var data = LocalDate.now();
        //printar o valor do ativo na data de hoje
        System.out.println("O valor do ativo na data de hoje é: " + ativo);
    }
}
