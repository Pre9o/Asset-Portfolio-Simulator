public class Ativos {
    int codigo;
    int tipo_codigo;
    String nome;

    public Ativos(int codigo, int tipo_codigo, String nome) {
        this.codigo = codigo;
        this.tipo_codigo = tipo_codigo;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Ativos{" +
                "codigo='" + codigo + '\'' +
                ", tipo_codigo='" + tipo_codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
