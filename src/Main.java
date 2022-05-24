import javax.swing.*;
import java.sql.SQLException;
public class Main {


    public static DataBase db;

    static {
        try {
            db = new DataBase();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null,"Incorrect username or password");
        }
    }

    private static final GUI GUI;

    static {
        try {
            GUI = new GUI();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        db.getConnection();
        GUI.GUISetup();
    }

    public static GUI getGUI() {
        return GUI;
    }
}
