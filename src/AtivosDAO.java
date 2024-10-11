import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtivosDAO extends DAO<Ativos, Integer> {
    @Override
    protected String getDeleteSQL() {
        return "DELETE FROM ativos WHERE codigo = ?";
    }

    @Override
    protected String getUpdateSQL() {
        return "UPDATE ativos SET tipo_codigo = ?, nome = ? WHERE codigo = ?";
    }

    @Override
    protected String getReadSQL() {
        return "SELECT * FROM ativos";
    }

    @Override
    protected String getCreateSQL() {
        return "INSERT INTO ativos (codigo, tipo_codigo, nome) VALUES (?, ?, ?)";
    }

    @Override
    protected void setDeleteSQL(PreparedStatement stmt, Integer ativos) throws SQLException {
        stmt.setInt(1, ativos);
    }

    @Override
    protected void setUpdateSQL(PreparedStatement stmt, Ativos ativos) throws SQLException {
        stmt.setInt(1, ativos.codigo);
        stmt.setInt(2, ativos.tipo_codigo);
        stmt.setString(3, ativos.nome);
    }

    @Override
    protected void setCreateSQL(PreparedStatement stmt, Ativos ativos) throws SQLException {
        stmt.setInt(1, ativos.codigo);
        stmt.setInt(2, ativos.tipo_codigo);
        stmt.setString(3, ativos.nome);
    }

    @Override
    protected Ativos readObject(ResultSet rs) throws SQLException {
        return new Ativos(
                rs.getInt("codigo"),
                rs.getInt("tipo_codigo"),
                rs.getString("nome"));
    }
}