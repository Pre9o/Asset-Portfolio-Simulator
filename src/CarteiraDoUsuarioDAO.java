import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CarteiraDoUsuarioDAO extends DAO<CarteiraDoUsuario, Integer> {
    @Override
    protected String getDeleteSQL() {
        return "DELETE FROM carteiradousuario WHERE id = ?";
    }

    @Override
    protected String getUpdateSQL() {
        return "UPDATE carteiradousuario SET operacao = ?, data = ?, ativo_codigo = ?, quantidade = ?, valor = ?, WHERE idcarteira = ?";
    }

    @Override
    protected String getReadSQL() {
        return "SELECT * FROM carteiradousuario";
    }

    @Override
    protected String getCreateSQL() {
        return "INSERT INTO carteiradousuario (id, operacao, data, ativo_codigo, quantidade, valor) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setDeleteSQL(PreparedStatement stmt, Integer carteiraDoUsuario) throws SQLException {
        stmt.setInt(1, carteiraDoUsuario);
    }

    @Override
    protected void setUpdateSQL(PreparedStatement stmt, CarteiraDoUsuario carteiraDoUsuario) throws SQLException {
        stmt.setInt(1, carteiraDoUsuario.idcarteira);
        stmt.setInt(2, carteiraDoUsuario.operacao);
        stmt.setTimestamp(3, java.sql.Timestamp.valueOf(carteiraDoUsuario.data));
        stmt.setInt(4, carteiraDoUsuario.ativo_codigo);
        stmt.setInt(5, carteiraDoUsuario.quantidade);
        stmt.setDouble(6, carteiraDoUsuario.valor);
    }

    @Override
    protected void setCreateSQL(PreparedStatement stmt, CarteiraDoUsuario carteiraDoUsuario) throws SQLException {
        stmt.setInt(1, carteiraDoUsuario.idcarteira);
        stmt.setInt(2, carteiraDoUsuario.operacao);
        stmt.setTimestamp(3, java.sql.Timestamp.valueOf(carteiraDoUsuario.data));
        stmt.setInt(4, carteiraDoUsuario.ativo_codigo);
        stmt.setInt(5, carteiraDoUsuario.quantidade);
        stmt.setDouble(6, carteiraDoUsuario.valor);
    }

    @Override
    protected CarteiraDoUsuario readObject(ResultSet rs) throws SQLException {
        return new CarteiraDoUsuario(
                rs.getInt("idcarteira"),
                (char) rs.getInt("operacao"),
                rs.getTimestamp("data").toLocalDateTime(),
                rs.getInt("ativo_codigo"),
                rs.getInt("quantidade"),
                rs.getDouble("valor"));
    }
}

