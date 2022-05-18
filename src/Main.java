import java.sql.SQLException;
public class Main {


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
        GUI.GUISetup();
        new Report().reportCountry("COL", "Hola", "a", null);
    }

    public static GUI getGUI() {
        return GUI;
    }
}
