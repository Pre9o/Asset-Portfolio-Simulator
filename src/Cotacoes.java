import java.time.LocalDateTime;

public class Cotacoes {
    int idcotacao;
    LocalDateTime data;
    int ativo_codigo;
    double valor;

    public Cotacoes(int idcotacao, LocalDateTime data, int ativo_codigo, double valor) {
        this.idcotacao = idcotacao;
        this.data = data;
        this.ativo_codigo = ativo_codigo;
        this.valor = valor;
    }

    @Override
    public String toString(){
        return "Cotacoes{" +
                "idcotacao='" + idcotacao + '\'' +
                ", data='" + data + '\'' +
                ", ativo_codigo='" + ativo_codigo + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
