import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class
GUI
{
    //Frames
    final JFrame mainFrame = new JFrame();
    final JFrame createFrame = new JFrame();
    //Panels
    final JPanel panelNorth = new JPanel();
    final JPanel panelSouth = new JPanel();
    final JPanel panelCenter = new JPanel();
    final JPanel panelEast = new JPanel();
    final JPanel panelWest = new JPanel();
    final JPanel buttonsPanel = new JPanel();
    final JPanel tablesTitlePanel = new JPanel();
    final JPanel tablesPanel = new JPanel();
    final JPanel createCountryPanel = new JPanel();
    final JPanel createCityPanel = new JPanel();
    final JPanel createCountryLPanel = new JPanel();
    //Labels
    final JLabel tablesTitle = new JLabel("",JLabel.CENTER);
    final JLabel buttonTitle = new JLabel("Select your table",JLabel.CENTER);
    //Buttons
    final JButton cityButton = new JButton("Cities");
    final JButton countryButton = new JButton("Countries");
    final JButton countryLButton = new JButton("Country Languages");
    final JButton createButton = new JButton("Create");
    final JButton deleteButton = new JButton("Delete");
    final JButton updateButton = new JButton("Update");
    //Tables
    Tables tables = new Tables();
    //Scrolls
    JScrollPane countryScroll = new JScrollPane(tables.getCountryTable());
    JScrollPane cityScroll = new JScrollPane(tables.getCityTable());
    JScrollPane countryLScroll = new JScrollPane(tables.getCountryLTable());
    ImageIcon ico = new ImageIcon("src/log.png");
    //Create inputs
    final JTextField cityID = new JTextField();
    final JTextField cityName = new JTextField();
    final JTextField cityCountryCode = new JTextField();
    final JTextField cityDistrict = new JTextField();
    final JTextField cityPopulation = new JTextField();
    final JLabel cityIDLabel = new JLabel("City ID:");
    final JLabel cityNameLabel = new JLabel("Name:");
    final JLabel cityCountryCodeLabel = new JLabel("Country Code:");
    final JLabel cityDistrictLabel = new JLabel("District:");
    final JLabel cityPopulationLabel = new JLabel("City Population:");

     //Other variables
    private String tableSelection = "";
    public String newCityID,newCityName,newCityCode,newCityDistrict,newCityPopulation;
    final JLayeredPane mainCreatePanel = new JLayeredPane();

    public GUI() throws ClassNotFoundException{

        //mainFrame Config
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,750);
        mainFrame.setTitle("CRUD");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setIconImage(ico.getImage());
        mainFrame.setLocationRelativeTo(null);

        //CreateFrame Config
        createFrame.setResizable(true);
        createFrame.setSize(400,255);
        createFrame.setLayout(new BorderLayout());
        createFrame.setIconImage(ico.getImage());
        createFrame.setVisible(false);
        createFrame.setLocationRelativeTo(null);

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
        mainCreatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        createFrame.add(mainCreatePanel,BorderLayout.CENTER);
        mainCreatePanel.setLayout(new BorderLayout());
        mainCreatePanel.add(createCountryPanel);
        mainCreatePanel.add(createCityPanel,BorderLayout.CENTER);
        mainCreatePanel.add(createCountryLPanel);
        mainCreatePanel.setBounds(0,0,500,500);
        mainCreatePanel.setVisible(true);




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

        //Lower panel configuration
        panelSouth.setLayout(new FlowLayout());
        panelSouth.add(createButton,FlowLayout.LEFT);
        panelSouth.add(deleteButton,FlowLayout.CENTER);
        panelSouth.add(updateButton,FlowLayout.RIGHT);
        createButton.setFocusable(false);
        deleteButton.setFocusable(false);
        updateButton.setFocusable(false);
        //Tables configuration
        tablesPanel.setBackground(Color.WHITE);
        panelCenter.add(tablesPanel,BorderLayout.CENTER);
        //Country Table
        tables.getCountryTable().setVisible(false);
        countryScroll.setVisible(false);
        tablesPanel.add(countryScroll);
        countryScroll.setPreferredSize(new Dimension(1000,423));
        //City Table
        tables.getCityTable().setVisible(false);
        cityScroll.setVisible(false);
        tablesPanel.add(cityScroll);
        //Country Language Table
        //tablesPanel.add(tables.getCountryLTable());
        tables.getCountryLTable().setVisible(false);
        countryLScroll.setVisible(false);
        tablesPanel.add(countryLScroll);



        //Table Buttons Configuration
        countryButton.addActionListener(e -> tablesTitle.setText("Countries Table"));
        countryButton.addActionListener(e -> tables.getCountryTable().setVisible(true));
        countryButton.addActionListener(e -> countryScroll.setVisible(true));
        countryButton.addActionListener(e -> tables.getCityTable().setVisible(false));
        countryButton.addActionListener(e -> cityScroll.setVisible(false));
        countryButton.addActionListener(e->tables.getCountryLTable().setVisible(false));
        countryButton.addActionListener(e -> countryLScroll.setVisible(false));
        countryButton.addActionListener(e -> mainFrame.setSize(1300,750));
        countryButton.addActionListener(e -> tableSelection = "country");

        cityButton.addActionListener(e -> tablesTitle.setText("Cities Table"));
        cityButton.addActionListener(e -> tables.getCityTable().setVisible(true));
        cityButton.addActionListener(e -> cityScroll.setVisible(true));
        cityButton.addActionListener(e->tables.getCountryLTable().setVisible(false));
        cityButton.addActionListener(e -> countryLScroll.setVisible(false));
        cityButton.addActionListener(e -> tables.getCountryTable().setVisible(false));
        cityButton.addActionListener(e -> countryScroll.setVisible(false));
        cityButton.addActionListener(e -> mainFrame.setSize(800,750));
        cityButton.addActionListener(e -> tableSelection = "city" );

        countryLButton.addActionListener(e -> tablesTitle.setText("Country Languages Table"));
        countryLButton.addActionListener(e->tables.getCountryLTable().setVisible(true));
        countryLButton.addActionListener(e -> countryLScroll.setVisible(true));
        countryLButton.addActionListener(e -> tables.getCityTable().setVisible(false));
        countryLButton.addActionListener(e -> cityScroll.setVisible(false));
        countryLButton.addActionListener(e -> tables.getCountryTable().setVisible(false));
        countryLButton.addActionListener(e -> countryScroll.setVisible(false));
        countryLButton.addActionListener(e -> mainFrame.setSize(800,750));
        countryLButton.addActionListener(e -> tableSelection = "countryL");

        //Create Country Panel Configuration
        createCountryPanel.setBackground(Color.BLACK);
        createCountryPanel.setBounds(0,0,400,325);


        //Create City Panel Configuration
        String[] createCityLabels = {"ID: ","Name: ","Country Code: ","District: ","Population: "};
        GridBagLayout cityLayout = new GridBagLayout();
        GridBagConstraints cityConstraintsID = new GridBagConstraints();
        GridBagConstraints cityConstraintsName = new GridBagConstraints();
        GridBagConstraints cityConstraintsCode = new GridBagConstraints();
        GridBagConstraints cityConstraintsDistrict = new GridBagConstraints();
        GridBagConstraints cityConstraintsPopulation = new GridBagConstraints();
        createCityPanel.setLayout(cityLayout);
        createCityPanel.setBounds(0,0,400,170);

        cityConstraintsID.gridx = -1;
        cityConstraintsID.gridy = 0;
        cityConstraintsID.insets.bottom = 10;
        cityConstraintsID.insets.right = 7;
        cityConstraintsID.gridwidth = GridBagConstraints.RELATIVE;
        cityConstraintsID.fill = GridBagConstraints.HORIZONTAL;
        cityConstraintsName.gridx = -1;
        cityConstraintsName.gridy = 1;
        cityConstraintsName.insets.bottom = 10;
        cityConstraintsName.insets.right = 7;
        cityConstraintsName.gridwidth = GridBagConstraints.RELATIVE;
        cityConstraintsName.fill = GridBagConstraints.HORIZONTAL;
        cityConstraintsCode.gridx = -1;
        cityConstraintsCode.gridy = 2;
        cityConstraintsCode.insets.bottom = 10;
        cityConstraintsCode.insets.right = 7;
        cityConstraintsCode.gridwidth = GridBagConstraints.RELATIVE;
        cityConstraintsCode.fill = GridBagConstraints.HORIZONTAL;
        cityConstraintsDistrict.gridx = -1;
        cityConstraintsDistrict.gridy = 3;
        cityConstraintsDistrict.insets.bottom = 10;
        cityConstraintsDistrict.insets.right = 7;
        cityConstraintsDistrict.gridwidth = GridBagConstraints.RELATIVE;
        cityConstraintsDistrict.fill = GridBagConstraints.HORIZONTAL;
        cityConstraintsPopulation.gridx = -1;
        cityConstraintsPopulation.gridy = 4;
        cityConstraintsPopulation.insets.bottom = 10;
        cityConstraintsPopulation.insets.right = 7;
        cityConstraintsPopulation.gridwidth = GridBagConstraints.RELATIVE;
        cityConstraintsPopulation.fill = GridBagConstraints.HORIZONTAL;

        createCityPanel.add(cityIDLabel,cityConstraintsID);
        createCityPanel.add(cityID,cityConstraintsID);
        createCityPanel.add(cityNameLabel,cityConstraintsName);
        createCityPanel.add(cityName,cityConstraintsName);
        createCityPanel.add(cityCountryCodeLabel,cityConstraintsCode);
        createCityPanel.add(cityCountryCode,cityConstraintsCode);
        createCityPanel.add(cityDistrictLabel,cityConstraintsDistrict);
        createCityPanel.add(cityDistrict,cityConstraintsDistrict);
        createCityPanel.add(cityPopulationLabel,cityConstraintsPopulation);
        createCityPanel.add(cityPopulation,cityConstraintsPopulation);

        cityID.setPreferredSize(new Dimension(150,20));
        cityName.setPreferredSize(new Dimension(150,20));
        cityCountryCode.setPreferredSize(new Dimension(150,20));
        cityDistrict.setPreferredSize(new Dimension(150,20));
        cityPopulation.setPreferredSize(new Dimension(150,20));

        JPanel southCreateCityPanel = new JPanel();
        JButton createCityButton = new JButton("Enter");
        southCreateCityPanel.setPreferredSize(new Dimension(100,40));
        mainCreatePanel.add(southCreateCityPanel,BorderLayout.SOUTH);
        southCreateCityPanel.add(createCityButton);
        createCityButton.setFocusable(false);
        createCityButton.addActionListener(e->{
            this.newCityID = cityID.getText();
            this.newCityName = cityName.getText();
            this.newCityCode = cityCountryCode.getText();
            this.newCityDistrict = cityDistrict.getText();
            this.newCityPopulation = cityPopulation.getText();
        });


        //Create Country Language Configuration
        createCountryLPanel.setBackground(Color.RED);
        createCountryLPanel.setBounds(0,0,400,325);

        //Create Button Configuration
        createButton.addActionListener(e ->{

            switch (tableSelection) {
                case "country" -> {
                    createFrame.setTitle("CREATE NEW COUNTRY");
                    createCityPanel.setVisible(false);
                    createCountryPanel.setVisible(true);
                    createCountryLPanel.setVisible(false);
                    createFrame.setVisible(true);
                }
                case "city" -> {
                    createFrame.setTitle("CREATE NEW CITY");
                    createCityPanel.setVisible(true);
                    createCountryPanel.setVisible(false);
                    createCountryLPanel.setVisible(false);
                    createFrame.setVisible(true);
                }
                case "countryL" -> {
                    createFrame.setTitle("CREATE NEW COUNTRY LANGUAGE");
                    createCityPanel.setVisible(false);
                    createCountryPanel.setVisible(false);
                    createCountryLPanel.setVisible(true);
                    createFrame.setVisible(true);
                }
                default -> JOptionPane.showMessageDialog(null, "SELECT A TABLE");
            }
        });

        System.out.println(cityScroll.getPreferredSize());





















        mainFrame.setVisible(true);
        newCityPopulation = "HOLA";










    }

}
