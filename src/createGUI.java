import javax.swing.*;
import java.awt.*;

public class createGUI
{
    final JFrame createFrame = new JFrame();
    final JPanel createCountryPanel = new JPanel();
    final JPanel createCityPanel = new JPanel();
    final JPanel createCountryLPanel = new JPanel();
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
    private String tableSelection = "";
    public String newCityID,newCityName,newCityCode,newCityDistrict,newCityPopulation;
    final JLayeredPane mainCreatePanel = new JLayeredPane();
    ImageIcon ico = new ImageIcon("src/log.png");
    public createGUI()
    {
        //Frame config
        createFrame.setResizable(true);
        createFrame.setSize(400,260);
        createFrame.setLayout(new BorderLayout());
        createFrame.setIconImage(ico.getImage());
        createFrame.setVisible(false);
        createFrame.setLocationRelativeTo(null);
        createFrame.add(mainCreatePanel,BorderLayout.CENTER);

        //Main panel config
        mainCreatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainCreatePanel.setLayout(new BorderLayout());
        mainCreatePanel.add(createCountryPanel);
        mainCreatePanel.add(createCityPanel,BorderLayout.CENTER);
        mainCreatePanel.add(createCountryLPanel);
        mainCreatePanel.setBounds(0,0,500,500);
        mainCreatePanel.setVisible(true);

        //Create Country Panel Configuration
        createCountryPanel.setBackground(Color.BLACK);
        createCountryPanel.setBounds(0,0,400,325);

        this.createCity();

        //Create Country Language Configuration
        createCountryLPanel.setBackground(Color.RED);
        createCountryLPanel.setBounds(0,0,400,325);
    }

    private void createCity()
    {
        String[] createCityLabels = {"ID: ","Name: ","Country Code: ","District: ","Population: "};
        GridBagLayout cityLayout = new GridBagLayout();
        GridBagConstraints cityConstraintsID = new GridBagConstraints();
        GridBagConstraints cityConstraintsName = new GridBagConstraints();
        GridBagConstraints cityConstraintsCode = new GridBagConstraints();
        GridBagConstraints cityConstraintsDistrict = new GridBagConstraints();
        GridBagConstraints cityConstraintsPopulation = new GridBagConstraints();
        createCityPanel.setLayout(cityLayout);
        createCityPanel.setBounds(0,0,400,225);

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
        GridBagConstraints createCityButtonConstraints = new GridBagConstraints();
        createCityButtonConstraints.gridx = -1;
        createCityButtonConstraints.gridy = 6;
        createCityButtonConstraints.insets = new Insets(10,125,0,0);
        createCityButtonConstraints.anchor = GridBagConstraints.PAGE_END;
        createCityPanel.add(createCityButton,createCityButtonConstraints);
        southCreateCityPanel.setPreferredSize(new Dimension(100,40));
        createCityButton.setFocusable(false);
        createCityButton.addActionListener(e->{
            this.newCityID = cityID.getText();
            this.newCityName = cityName.getText();
            this.newCityCode = cityCountryCode.getText();
            this.newCityDistrict = cityDistrict.getText();
            this.newCityPopulation = cityPopulation.getText();
        });
    }

    public String getTableSelection() {
        return tableSelection;
    }
    public void setTableSelection(String tableSelection) {
        this.tableSelection = tableSelection;
    }
    public void createSelector()
    {
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
    }
}
