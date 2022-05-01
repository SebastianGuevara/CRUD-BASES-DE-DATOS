import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.SQLException;

public class GUI
{
    //Frames
    final JFrame mainFrame = new JFrame();
    //Panels
    final JPanel panelNorth = new JPanel();
    final JPanel panelSouth = new JPanel();
    final JPanel panelCenter = new JPanel();
    final JPanel panelEast = new JPanel();
    final JPanel panelWest = new JPanel();
    final JPanel buttonsPanel = new JPanel();
    final JPanel tablesTitlePanel = new JPanel();
    final JPanel tablesPanel = new JPanel();
    //Labels
    final JLabel tablesTitle = new JLabel("",JLabel.CENTER);
    final JLabel buttonTitle = new JLabel("Select your table",JLabel.CENTER);
    //Buttons
    final JButton cityButton = new JButton("Cities");
    final JButton countryButton = new JButton("Countries");
    final JButton countryLButton = new JButton("Country Languages");
    //Tables
    CountryTable countryTable = new CountryTable();
    CityTable cityTable = new CityTable();
    CountryLanguageTable countryLTable = new CountryLanguageTable();
    //Scrolls
    JScrollPane countryScroll = new JScrollPane(countryTable.getTable());
    JScrollPane cityScroll = new JScrollPane(cityTable.getTable());
    JScrollPane countryLScroll = new JScrollPane(countryLTable.getTable());


    //DefaultTableModel model = new DefaultTableModel();


    public GUI() throws SQLException, ClassNotFoundException {

        //mainFrame Config
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,750);
        mainFrame.setTitle("CRUD");
        mainFrame.setLayout(new BorderLayout());

        //Main panels configuration
        panelNorth.setPreferredSize(new Dimension(100,100));
        panelSouth.setPreferredSize(new Dimension(100,100));
        panelCenter.setPreferredSize(new Dimension(100,100));
        panelCenter.setBackground(Color.WHITE);
        panelCenter.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        panelEast.setPreferredSize(new Dimension(100,100));
        panelWest.setPreferredSize(new Dimension(100,100));

        //mainFrame layout configuration
        mainFrame.add(panelNorth,BorderLayout.NORTH);
        mainFrame.add(panelSouth,BorderLayout.SOUTH);
        mainFrame.add(panelCenter,BorderLayout.CENTER);
        mainFrame.add(panelEast,BorderLayout.EAST);
        mainFrame.add(panelWest,BorderLayout.WEST);

        //Central panel configuration
        panelCenter.setLayout(new BorderLayout(10,10));
        tablesTitle.setFont(new Font("Consolas",Font.BOLD,20));
        tablesTitle.setText("Select one table");
        panelCenter.add(tablesTitlePanel,BorderLayout.NORTH);
        tablesTitlePanel.setBackground(Color.WHITE);
        tablesTitlePanel.add(tablesTitle,BorderLayout.CENTER);




        //Upper panel configuration
        panelNorth.setLayout(new BorderLayout(10,10));
        buttonTitle.setFont(new Font("Consolas",Font.BOLD,15));
        panelNorth.add(buttonTitle,BorderLayout.NORTH);
        panelNorth.add(buttonsPanel,BorderLayout.CENTER);
        buttonsPanel.setLayout(new FlowLayout());
        countryButton.setPreferredSize(new Dimension(144,26));
        cityButton.setPreferredSize(new Dimension(144,26));
        countryLButton.setPreferredSize(new Dimension(144,26));
        buttonsPanel.add(countryButton,FlowLayout.LEFT);
        buttonsPanel.add(cityButton,FlowLayout.CENTER);
        buttonsPanel.add(countryLButton,FlowLayout.RIGHT);
        countryButton.setFocusable(false);
        cityButton.setFocusable(false);
        countryLButton.setFocusable(false);

        //Tables configuration
        tablesPanel.setBackground(Color.WHITE);
        panelCenter.add(tablesPanel,BorderLayout.CENTER);
        //Country Table
        countryTable.getTable().setVisible(false);
        countryScroll.setVisible(false);
        tablesPanel.add(countryScroll);
        countryScroll.setPreferredSize(new Dimension(1000,423));

        //City Table
        cityTable.getTable().setVisible(false);
        cityScroll.setVisible(false);
        tablesPanel.add(cityScroll);
        //Country Language Table
        //tablesPanel.add(countryLTable.getTable());
        countryLTable.getTable().setVisible(false);
        countryLScroll.setVisible(false);
        tablesPanel.add(countryLScroll);



        //Buttons Configuration
        countryButton.addActionListener(e -> tablesTitle.setText("Countries Table"));
        countryButton.addActionListener(e -> countryTable.getTable().setVisible(true));
        countryButton.addActionListener(e -> countryScroll.setVisible(true));
        countryButton.addActionListener(e -> cityTable.getTable().setVisible(false));
        countryButton.addActionListener(e -> cityScroll.setVisible(false));
        countryButton.addActionListener(e->countryLTable.getTable().setVisible(false));
        countryButton.addActionListener(e -> countryLScroll.setVisible(false));
        countryButton.addActionListener(e -> mainFrame.setSize(1300,750));

        cityButton.addActionListener(e -> tablesTitle.setText("Cities Table"));
        cityButton.addActionListener(e -> cityTable.getTable().setVisible(true));
        cityButton.addActionListener(e -> cityScroll.setVisible(true));
        cityButton.addActionListener(e->countryLTable.getTable().setVisible(false));
        cityButton.addActionListener(e -> countryLScroll.setVisible(false));
        cityButton.addActionListener(e -> countryTable.getTable().setVisible(false));
        cityButton.addActionListener(e -> countryScroll.setVisible(false));
        cityButton.addActionListener(e -> mainFrame.setSize(800,750));

        countryLButton.addActionListener(e -> tablesTitle.setText("Country Languages Table"));
        countryLButton.addActionListener(e->countryLTable.getTable().setVisible(true));
        countryLButton.addActionListener(e -> countryLScroll.setVisible(true));
        countryLButton.addActionListener(e -> cityTable.getTable().setVisible(false));
        countryLButton.addActionListener(e -> cityScroll.setVisible(false));
        countryLButton.addActionListener(e -> countryTable.getTable().setVisible(false));
        countryLButton.addActionListener(e -> countryScroll.setVisible(false));
        countryLButton.addActionListener(e -> mainFrame.setSize(800,750));

        System.out.println(cityScroll.getPreferredSize());





















        mainFrame.setVisible(true);











    }

}
