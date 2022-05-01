import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase
{
    private Connection con;

    public DataBase() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "12345";

        //Class.forName("jdbc:mysql://localhost:3306/world");
        con= DriverManager.getConnection(url,username,password);
        System.out.println("Conectado correctamente");

    }

    public Connection getConnection()
    {
        return this.con;
    }
}
