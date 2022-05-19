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
        new Report().reportCountry(null, "Hola", "a", "a","a","a","a","a","a","a","d","d","e","r","t");
    }

    public static GUI getGUI() {
        return GUI;
    }
}
