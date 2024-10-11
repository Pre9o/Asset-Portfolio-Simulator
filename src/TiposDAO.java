import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TiposDAO extends DAO<Tipos, Integer> {
    @Override
    protected String getDeleteSQL() {
        return "DELETE FROM tipos WHERE codigo = ?";
    }

    @Override
    protected String getUpdateSQL() {
        return "UPDATE tipos SET nome = ? WHERE codigo = ?";
    }

    @Override
    protected String getReadSQL() {
        return "SELECT * FROM tipos";
    }

    @Override
    protected String getCreateSQL() {
        return "INSERT INTO tipos (codigo, nome) VALUES (?, ?)";
    }

    @Override
    protected void setDeleteSQL(PreparedStatement stmt, Integer tipos) throws SQLException {
        stmt.setInt(1, tipos);
    }

    @Override
    protected void setUpdateSQL(PreparedStatement stmt, Tipos tipos) throws SQLException {
        stmt.setInt(1, tipos.codigo);
        stmt.setString(2, tipos.nome);
    }

    @Override
    protected void setCreateSQL(PreparedStatement stmt, Tipos tipos) throws SQLException {
        stmt.setInt(1, tipos.codigo);
        stmt.setString(2, tipos.nome);
    }

    @Override
    protected Tipos readObject(ResultSet rs) throws SQLException {
        return new Tipos(
                rs.getInt("codigo"),
                rs.getString("nome"));
    }
}

