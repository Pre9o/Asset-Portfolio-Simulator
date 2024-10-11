import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CotacoesDAO extends DAO<Cotacoes, Integer> {
    @Override
    protected String getDeleteSQL() {
        return "DELETE FROM cotacoes WHERE idcotacao = ?";
    }

    @Override
    protected String getUpdateSQL() {
        return "UPDATE cotacoes SET data = ?, ativo_codigo = ?, valor = ? WHERE idcotacao = ?";
    }

    @Override
    protected String getReadSQL() {
        return "SELECT * FROM cotacoes";
    }

    @Override
    protected String getCreateSQL() {
        return "INSERT INTO cotacoes (idcotacao, data, ativo_codigo, valor) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected void setDeleteSQL(PreparedStatement stmt, Integer cotacoes) throws SQLException {
        stmt.setInt(1, cotacoes);
    }

    @Override
    protected void setUpdateSQL(PreparedStatement stmt, Cotacoes cotacoes) throws SQLException {
        stmt.setInt(1, cotacoes.idcotacao);
        stmt.setTimestamp(2, java.sql.Timestamp.valueOf(cotacoes.data));
        stmt.setInt(3, cotacoes.ativo_codigo);
        stmt.setDouble(4, cotacoes.valor);
    }

    @Override
    protected void setCreateSQL(PreparedStatement stmt, Cotacoes cotacoes) throws SQLException {
        stmt.setInt(1, cotacoes.idcotacao);
        stmt.setTimestamp(2, java.sql.Timestamp.valueOf(cotacoes.data));
        stmt.setInt(3, cotacoes.ativo_codigo);
        stmt.setDouble(4, cotacoes.valor);
    }

    @Override
    protected Cotacoes readObject(ResultSet rs) throws SQLException {
        return new Cotacoes(
                rs.getInt("idcotacao"),
                rs.getTimestamp("data").toLocalDateTime(),
                rs.getInt("ativo_codigo"),
                rs.getDouble("valor"));
    }
}

