import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase
{
    private final Connection con;
    LoginGUI log = new LoginGUI();

    public DataBase() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        //String password = JOptionPane.showInputDialog(null,"Ingrese clave");

        //Class.forName("jdbc:mysql://localhost:3306/world");
        con= DriverManager.getConnection(url,log.getUs(),log.getPs());
        System.out.println("Conectado correctamente");

    }

    public Connection getConnection()
    {
        return this.con;
    }
}
