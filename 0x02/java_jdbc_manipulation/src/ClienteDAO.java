import java.sql.Connection;

public interface ClienteDAO {
    Connection connect(String urlConexao);
    void createTable(String urlConexao);

    void selectAll(String urlConexao);
    void delete(String urlConexao, int id);
    void insert(String urlConexao, Cliente cliente);
    void update(String urlConexao, int id, String name, Integer idade);
}
