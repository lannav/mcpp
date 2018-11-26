public interface DAO {
    void update(String ID, String secret);
    String read(String ID);
    void delete(String ID);
    void create(String name, String value);
}
