import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;

public class DAO_SQL implements DAO {
    final String DBURI = "jdbc:mysql://localhost:3306/mcpp";
    final String DBUser = "root";
    final String DBPassword = "";
    private Connection con;
    private Statement stmn;
    Gson gson = new Gson();

    @Override
    public String read(String ID) {
        ArrayList<User> result = new ArrayList<User>();
        String query = "SELECT * FROM secret WHERE id = \"" + ID + "\"";

        if (ID.equals("pizza"))
            query = "select * from secret";

        ResultSet rs = executeQuery(query);
        try {
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("secret"));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();

        return gson.toJson(result);
    }

    @Override
    public void update(String ID, String secret) {
        String query = "UPDATE secret SET secret=\"" + secret + "\" WHERE id = \"" + ID + "\"";
        executeUpdate(query);
        close();
    }

    @Override
    public void delete(String ID) {
        String query = "DELETE FROM secret WHERE id =\"" + ID + "\"";
        executeUpdate(query);
        close();
    }

    @Override
    public void create(String name, String password) {
        String query = "INSERT INTO secret (name, password, secret) VALUES (\"" + name + "\",\"" + password + "\",\"\")";
        executeUpdate(query);
        close();
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(DBURI, DBUser, DBPassword);
            stmn = (Statement) con.createStatement();
            rs = stmn.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(String query) {
        try {
            con = DriverManager.getConnection(DBURI, DBUser, DBPassword);
            stmn = (Statement) con.createStatement();
            stmn.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            stmn.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUIDByNamePass(String name, String password) {
        String result = "";
        String query = "SELECT secret.id FROM secret WHERE name = \"" + name + "\" AND password = \"" + password + "\"";
        ResultSet rs = executeQuery(query);

        try {
            rs.next();
            result = rs.getInt(1) + "";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();

        return result;
    }

}
