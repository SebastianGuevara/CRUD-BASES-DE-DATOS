import java.sql.SQLException;
public class Main {
    private static GUI GUI;

    static {
        try {
            GUI = new GUI();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Main() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        GUI.GUISetup();
    }

    public static GUI getGUI() {
        return GUI;
    }
}
