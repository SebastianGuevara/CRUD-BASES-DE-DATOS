import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase
{
    private final Connection con;
    private String username;
    private String password;


    public DataBase() throws SQLException {

        JTextField xField = new JTextField(10);
        JPasswordField yField = new JPasswordField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
        myPanel.add(new JLabel("Username:"));
        myPanel.add(xField);
        myPanel.add(Box.createVerticalBox()); // a spacer
        myPanel.add(new JLabel("Password:"));
        myPanel.add(yField);
        /*
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Login",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,new ImageIcon());
        if (result == JOptionPane.OK_OPTION)
        {
            username = xField.getText();
            password = yField.getText();
        }
         */

        String url = "jdbc:mysql://localhost:3306/world";
        con= DriverManager.getConnection(url,"root","12345");
        System.out.println("Conectado correctamente");
        PreparedStatement st1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        PreparedStatement st2 = con.prepareStatement("SET GLOBAL FOREIGN_KEY_CHECKS=0");
        st1.execute();
        st2.execute();

    }

    public Connection getConnection()
    {
        return this.con;
    }
}
