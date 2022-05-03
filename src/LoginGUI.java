import javax.swing.*;
import java.awt.*;

public class LoginGUI
{
    private final JFrame mainFrame = new JFrame();
    private final JTextField username = new JTextField();
    private final JTextField password = new JPasswordField();
    private final JPanel panel = new JPanel();
    private final JPanel panelUser = new JPanel();
    private final JPanel panelPass = new JPanel();
    private final JPanel panelL = new JPanel();
    private final JPanel panelR = new JPanel();
    private final JPanel panelLT = new JPanel();
    private final JPanel panelLS = new JPanel();
    private final JLabel userLabel = new JLabel("Username:");
    private final JLabel passwordLabel = new JLabel("Password:");
    private final JButton loginButton = new JButton("Enter");

    private String us;
    private String ps;
    public LoginGUI()
    {
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(350,200);
        mainFrame.setTitle("CRUD");
        mainFrame.setLayout(new BorderLayout());

        mainFrame.add(panel,BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(panelUser);
        panel.add(panelPass);
        mainFrame.add(panelL,BorderLayout.WEST);
        mainFrame.add(panelR,BorderLayout.EAST);
        panelR.setLayout(new BorderLayout());
        panelR.add(loginButton,BorderLayout.CENTER);
        panelL.setPreferredSize(new Dimension(100,100));
        panelR.setPreferredSize(new Dimension(100,100));
        panelUser.setLayout(new BorderLayout());
        panelUser.add(username,BorderLayout.SOUTH);
        panelL.setLayout(new BoxLayout(panelL,BoxLayout.Y_AXIS));
        panelL.add(panelLT);
        panelLT.setPreferredSize(new Dimension(50,50));
        panelLS.setPreferredSize(new Dimension(50,82));
        panelL.add(panelLS);
        panelLT.setLayout(new BorderLayout());
        panelLT.add(userLabel,BorderLayout.SOUTH);
        panelPass.setLayout(new BorderLayout());
        panelLS.add(passwordLabel,BorderLayout.NORTH);
        panelPass.add(password,BorderLayout.NORTH);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        username.setText("fdasfdas");

        loginButton.addActionListener(e->this.us = username.getText());
        loginButton.addActionListener(e->this.ps = password.getText());

        mainFrame.setVisible(true);
    }

    public String getPs() {
        return ps;
    }

    public String getUs() {
        return us;
    }
}

