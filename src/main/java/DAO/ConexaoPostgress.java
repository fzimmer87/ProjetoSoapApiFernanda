package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgress {
    private static final String url = "jdbc:postgresql://lv-dev.betternow.com.br:8002/Treinamento";

    private static final String user ="postgres";
    private static final String password ="postgres";
    private static Connection conn;
    public static Connection getConexao(){
        try{
            Class.forName("org.postgresql.Driver");
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else {
                return conn;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
