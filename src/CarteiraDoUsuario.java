import java.time.LocalDateTime;

public class CarteiraDoUsuario {
    int idcarteira;
    char operacao;
    LocalDateTime data;
    int ativo_codigo;
    int quantidade;
    double valor;

    public CarteiraDoUsuario(int idcarteira, char operacao, LocalDateTime data, int ativo_codigo, int quantidade, double valor) {
        this.idcarteira = idcarteira;
        this.operacao = operacao;
        this.data = data;
        this.ativo_codigo = ativo_codigo;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    @Override
    public String toString(){
        return "CarteiraDoUsuario{" +
                "idcarteira='" + idcarteira + '\'' +
                ", operacao='" + operacao + '\'' +
                ", data='" + data + '\'' +
                ", ativo_codigo='" + ativo_codigo + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
