import javax.swing.*;
import java.awt.*;

public class createGUI
{
    //Frame stuff
    final JFrame createFrame = new JFrame();
    final JPanel createCountryPanel = new JPanel();
    final JPanel createCityPanel = new JPanel();
    final JPanel createCountryLPanel = new JPanel();

    //Country Inputs and Labels
    final JTextField countryCode = new JTextField();
    final JTextField countryName = new JTextField();
    final JTextField countryContinent = new JTextField();
    final JTextField countryRegion = new JTextField();
    final JTextField countrySurface = new JTextField();
    final JTextField countryYear = new JTextField();
    final JTextField countryPopulation = new JTextField();
    final JTextField countryLifeExpectancy = new JTextField();
    final JTextField countryGNP = new JTextField();
    final JTextField countryGNPOld = new JTextField();
    final JTextField countryLocalName = new JTextField();
    final JTextField countryGovernmentForm = new JTextField();
    final JTextField countryHeadOfState = new JTextField();
    final JTextField countryCapital = new JTextField();
    final JTextField countryCode2 = new JTextField();
    final JLabel countryCodeLabel = new JLabel("Code:");
    final JLabel countryNameLabel = new JLabel("Name:");
    final JLabel countryContinentLabel = new JLabel("Continent:");
    final JLabel countryRegionLabel = new JLabel("Region:");
    final JLabel countrySurfaceLabel = new JLabel("Surface Area:");
    final JLabel countryYearLabel = new JLabel("Independence Year:");
    final JLabel countryPopulationLabel = new JLabel("Population:");
    final JLabel countryLifeExpectancyLabel = new JLabel("Life Expectancy:");
    final JLabel countryGNPLabel = new JLabel("GNP:");
    final JLabel countryGNPOldLabel = new JLabel("GNPOld");
    final JLabel countryLocalNameLabel = new JLabel("Local Name:");
    final JLabel countryGovernmentFormLabel = new JLabel("Government Form:");
    final JLabel countryHeadOfStateLabel = new JLabel("Head of State:");
    final JLabel countryCapitalLabel = new JLabel("Capital:");
    final JLabel countryCode2Label = new JLabel("Code 2:");
    public String newCountryCode,newCountryName,newCountryContinent,newCountryRegion,newCountrySurface,newCountryYear,newCountryPopulation,newCountryLifeExpectancy,newCountryGNP,newCountryGNPOld,newCountryLocalName,newCountryGovernmentForm,newCountryHeadOfState,newCountryCapital,newCountryCode2;

    //City Inputs and Labels
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
    public String newCityID,newCityName,newCityCode,newCityDistrict,newCityPopulation;

    //Country Language Inputs and Labels
    final JTextField countryLCode = new JTextField();
    final JTextField countryLLanguage = new JTextField();
    final JTextField countryLIsOfficial = new JTextField();
    final JTextField countryLPercentage = new JTextField();
    final JLabel countryLCodeLabel = new JLabel("Code:");
    final JLabel countryLLanguageLabel = new JLabel("Language:");
    final JLabel countryLIsOfficialLabel = new JLabel("Is official:");
    final JLabel countryLPercentageLabel = new JLabel("Percentage: ");
    public String newCountryLCode,newCountryLLanguage,newCountryLIsOfficial,newCountryLPercentage;

    //Other stuff
    final JLayeredPane mainCreatePanel = new JLayeredPane();
    private String tableSelection = "";
    ImageIcon ico = new ImageIcon("src/log.png");

    public createGUI()
    {
        //Frame config
        createFrame.setResizable(true);
        createFrame.setSize(400,325);
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

        this.createCity();
        this.createCountry();
        this.createCountryLanguage();

    }
    private void createCountry()
    {
        GridBagLayout countryLayout = new GridBagLayout();
        GridBagConstraints countryCodeConstraints = new GridBagConstraints();
        GridBagConstraints countryNameConstraints = new GridBagConstraints();
        GridBagConstraints countryContinentConstraints = new GridBagConstraints();
        GridBagConstraints countryRegionConstraints = new GridBagConstraints();
        GridBagConstraints countrySurfaceConstraints = new GridBagConstraints();
        GridBagConstraints countryYearConstraints = new GridBagConstraints();
        GridBagConstraints countryPopulationConstraints = new GridBagConstraints();
        GridBagConstraints countryLifeExpectancyConstraints = new GridBagConstraints();
        GridBagConstraints countryGNPConstraints = new GridBagConstraints();
        GridBagConstraints countryGNPOLdConstraints = new GridBagConstraints();
        GridBagConstraints countryLocalNameConstraints = new GridBagConstraints();
        GridBagConstraints countryGovernmentFormConstraints = new GridBagConstraints();
        GridBagConstraints countryHeadStateConstraints = new GridBagConstraints();
        GridBagConstraints countryCapitalConstraints = new GridBagConstraints();
        GridBagConstraints countryCode2Constraints = new GridBagConstraints();
        createCountryPanel.setLayout(countryLayout);
        createCountryPanel.setBounds(0,0,400,530);

        countryCodeConstraints.gridx = -1;
        countryCodeConstraints.gridy = 0;
        countryCodeConstraints.insets.bottom = 10;
        countryCodeConstraints.insets.right = 7;
        countryCodeConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryCodeConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryNameConstraints.gridx = -1;
        countryNameConstraints.gridy = 1;
        countryNameConstraints.insets.bottom = 10;
        countryNameConstraints.insets.right = 7;
        countryNameConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryNameConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryContinentConstraints.gridx = -1;
        countryContinentConstraints.gridy = 2;
        countryContinentConstraints.insets.bottom = 10;
        countryContinentConstraints.insets.right = 7;
        countryContinentConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryContinentConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryRegionConstraints.gridx = -1;
        countryRegionConstraints.gridy = 3;
        countryRegionConstraints.insets.bottom = 10;
        countryRegionConstraints.insets.right = 7;
        countryRegionConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryRegionConstraints.fill = GridBagConstraints.HORIZONTAL;
        countrySurfaceConstraints.gridx = -1;
        countrySurfaceConstraints.gridy = 4;
        countrySurfaceConstraints.insets.bottom = 10;
        countrySurfaceConstraints.insets.right = 7;
        countrySurfaceConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countrySurfaceConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryYearConstraints.gridx = -1;
        countryYearConstraints.gridy = 5;
        countryYearConstraints.insets.bottom = 10;
        countryYearConstraints.insets.right = 7;
        countryYearConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryYearConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryPopulationConstraints.gridx = -1;
        countryPopulationConstraints.gridy = 6;
        countryPopulationConstraints.insets.bottom = 10;
        countryPopulationConstraints.insets.right = 7;
        countryPopulationConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryPopulationConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryLifeExpectancyConstraints.gridx = -1;
        countryLifeExpectancyConstraints.gridy = 7;
        countryLifeExpectancyConstraints.insets.bottom = 10;
        countryLifeExpectancyConstraints.insets.right = 7;
        countryLifeExpectancyConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryLifeExpectancyConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryGNPConstraints.gridx = -1;
        countryGNPConstraints.gridy = 8;
        countryGNPConstraints.insets.bottom = 10;
        countryGNPConstraints.insets.right = 7;
        countryGNPConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryGNPConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryGNPOLdConstraints.gridx = -1;
        countryGNPOLdConstraints.gridy = 9;
        countryGNPOLdConstraints.insets.bottom = 10;
        countryGNPOLdConstraints.insets.right = 7;
        countryGNPOLdConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryGNPOLdConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryLocalNameConstraints.gridx = -1;
        countryLocalNameConstraints.gridy = 10;
        countryLocalNameConstraints.insets.bottom = 10;
        countryLocalNameConstraints.insets.right = 7;
        countryLocalNameConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryLocalNameConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryGovernmentFormConstraints.gridx = -1;
        countryGovernmentFormConstraints.gridy = 11;
        countryGovernmentFormConstraints.insets.bottom = 10;
        countryGovernmentFormConstraints.insets.right = 7;
        countryGovernmentFormConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryGovernmentFormConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryHeadStateConstraints.gridx = -1;
        countryHeadStateConstraints.gridy = 12;
        countryHeadStateConstraints.insets.bottom = 10;
        countryHeadStateConstraints.insets.right = 7;
        countryHeadStateConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryHeadStateConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryCapitalConstraints.gridx = -1;
        countryCapitalConstraints.gridy = 13;
        countryCapitalConstraints.insets.bottom = 10;
        countryCapitalConstraints.insets.right = 7;
        countryCapitalConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryCapitalConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryCode2Constraints.gridx = -1;
        countryCode2Constraints.gridy = 14;
        countryCode2Constraints.insets.bottom = 10;
        countryCode2Constraints.insets.right = 7;
        countryCode2Constraints.gridwidth = GridBagConstraints.RELATIVE;
        countryCode2Constraints.fill = GridBagConstraints.HORIZONTAL;

        createCountryPanel.add(countryCodeLabel,countryCodeConstraints);
        createCountryPanel.add(countryCode,countryCodeConstraints);
        createCountryPanel.add(countryNameLabel,countryNameConstraints);
        createCountryPanel.add(countryName,countryNameConstraints);
        createCountryPanel.add(countryContinentLabel,countryContinentConstraints);
        createCountryPanel.add(countryContinent,countryContinentConstraints);
        createCountryPanel.add(countryRegionLabel,countryRegionConstraints);
        createCountryPanel.add(countryRegion,countryRegionConstraints);
        createCountryPanel.add(countrySurfaceLabel,countrySurfaceConstraints);
        createCountryPanel.add(countrySurface,countrySurfaceConstraints);
        createCountryPanel.add(countryYearLabel,countryYearConstraints);
        createCountryPanel.add(countryYear,countryYearConstraints);
        createCountryPanel.add(countryPopulationLabel,countryPopulationConstraints);
        createCountryPanel.add(countryPopulation,countryPopulationConstraints);
        createCountryPanel.add(countryLifeExpectancyLabel,countryLifeExpectancyConstraints);
        createCountryPanel.add(countryLifeExpectancy,countryLifeExpectancyConstraints);
        createCountryPanel.add(countryGNPLabel,countryGNPConstraints);
        createCountryPanel.add(countryGNP,countryGNPConstraints);
        createCountryPanel.add(countryGNPOldLabel,countryGNPOLdConstraints);
        createCountryPanel.add(countryGNPOld,countryGNPOLdConstraints);
        createCountryPanel.add(countryLocalNameLabel,countryLocalNameConstraints);
        createCountryPanel.add(countryLocalName,countryLocalNameConstraints);
        createCountryPanel.add(countryGovernmentFormLabel,countryGovernmentFormConstraints);
        createCountryPanel.add(countryGovernmentForm,countryGovernmentFormConstraints);
        createCountryPanel.add(countryHeadOfStateLabel,countryHeadStateConstraints);
        createCountryPanel.add(countryHeadOfState,countryHeadStateConstraints);
        createCountryPanel.add(countryCapitalLabel,countryCapitalConstraints);
        createCountryPanel.add(countryCapital,countryCapitalConstraints);
        createCountryPanel.add(countryCode2Label,countryCode2Constraints);
        createCountryPanel.add(countryCode2,countryCode2Constraints);

        countryCode.setPreferredSize(new Dimension(150,20));
        countryName.setPreferredSize(new Dimension(150,20));
        countryGovernmentForm.setPreferredSize(new Dimension(150,20));

        JButton createCountryButton = new JButton("Enter");
        GridBagConstraints createCountryButtonConstraints = new GridBagConstraints();
        createCountryButtonConstraints.gridx = -1;
        createCountryButtonConstraints.gridy = 16;
        createCountryButtonConstraints.insets = new Insets(10,125,0,0);
        createCountryButtonConstraints.anchor = GridBagConstraints.PAGE_END;
        createCountryPanel.add(createCountryButton,createCountryButtonConstraints);
        createCountryButton.setFocusable(false);
        createCountryButton.addActionListener(e->{
            this.newCountryCode = countryCode.getText();
            this.newCountryName = countryName.getText();
            this.newCountryContinent = countryContinent.getText();
            this.newCountryRegion = countryRegion.getText();
            this.newCountrySurface = countrySurface.getText();
            this.newCountryYear = countryYear.getText();
            this.newCountryPopulation = countryPopulation.getText();
            this.newCountryLifeExpectancy = countryLifeExpectancy.getText();
            this.newCountryGNP = countryGNP.getText();
            this.newCountryGNPOld = countryGNPOld.getText();
            this.newCountryLocalName = countryLocalName.getName();
            this.newCountryGovernmentForm = countryGovernmentForm.getText();
            this.newCountryHeadOfState = countryHeadOfState.getText();
            this.newCountryCapital = countryCapital.getText();
            this.newCountryCode2 = countryCode2.getText();
        });


    }
    private void createCity()
    {
        //Create City Panel Configuration
        GridBagLayout cityLayout = new GridBagLayout();
        GridBagConstraints cityConstraintsID = new GridBagConstraints();
        GridBagConstraints cityConstraintsName = new GridBagConstraints();
        GridBagConstraints cityConstraintsCode = new GridBagConstraints();
        GridBagConstraints cityConstraintsDistrict = new GridBagConstraints();
        GridBagConstraints cityConstraintsPopulation = new GridBagConstraints();
        createCityPanel.setLayout(cityLayout);
        createCityPanel.setBounds(0,0,400,250);

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
    private  void  createCountryLanguage()
    {
        GridBagLayout countryLLayout = new GridBagLayout();
        GridBagConstraints countryLCodeConstraints = new GridBagConstraints();
        GridBagConstraints countryLLanguageConstraints = new GridBagConstraints();
        GridBagConstraints countryLIsOfficialConstraints = new GridBagConstraints();
        GridBagConstraints countryLPercentageConstraints = new GridBagConstraints();
        createCountryLPanel.setLayout(countryLLayout);
        createCountryLPanel.setBounds(0,0,400,325);

        countryLCodeConstraints.gridx = -1;
        countryLCodeConstraints.gridy = 0;
        countryLCodeConstraints.insets.bottom = 10;
        countryLCodeConstraints.insets.right = 7;
        countryLCodeConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryLCodeConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryLLanguageConstraints.gridx = -1;
        countryLLanguageConstraints.gridy = 1;
        countryLLanguageConstraints.insets.bottom = 10;
        countryLLanguageConstraints.insets.right = 7;
        countryLLanguageConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryLLanguageConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryLIsOfficialConstraints.gridx = -1;
        countryLIsOfficialConstraints.gridy = 2;
        countryLIsOfficialConstraints.insets.bottom = 10;
        countryLIsOfficialConstraints.insets.right = 7;
        countryLIsOfficialConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryLIsOfficialConstraints.fill = GridBagConstraints.HORIZONTAL;
        countryLPercentageConstraints.gridx = -1;
        countryLPercentageConstraints.gridy = 3;
        countryLPercentageConstraints.insets.bottom = 10;
        countryLPercentageConstraints.insets.right = 7;
        countryLPercentageConstraints.gridwidth = GridBagConstraints.RELATIVE;
        countryLPercentageConstraints.fill = GridBagConstraints.HORIZONTAL;

        createCountryLPanel.add(countryLCodeLabel,countryLCodeConstraints);
        createCountryLPanel.add(countryLCode,countryLCodeConstraints);
        createCountryLPanel.add(countryLLanguageLabel,countryLLanguageConstraints);
        createCountryLPanel.add(countryLLanguage,countryLLanguageConstraints);
        createCountryLPanel.add(countryLIsOfficialLabel,countryLIsOfficialConstraints);
        createCountryLPanel.add(countryLIsOfficial,countryLIsOfficialConstraints);
        createCountryLPanel.add(countryLPercentageLabel,countryLPercentageConstraints);
        createCountryLPanel.add(countryLPercentage,countryLPercentageConstraints);

        countryLCode.setPreferredSize(new Dimension(150,20));

        JButton createCountryLButton = new JButton("Enter");
        GridBagConstraints createCountryLButtonConstraints = new GridBagConstraints();
        createCountryLButtonConstraints.gridx = -1;
        createCountryLButtonConstraints.gridy = 4;
        createCountryLButtonConstraints.insets = new Insets(10,125,0,0);
        createCountryLButtonConstraints.anchor = GridBagConstraints.PAGE_END;
        createCountryLPanel.add(createCountryLButton,createCountryLButtonConstraints);
        createCountryLButton.addActionListener(e->{
            this.newCountryLCode = countryLCode.getText();
            this.newCountryLLanguage = countryLLanguage.getText();
            this.newCountryLIsOfficial = countryLIsOfficial.getText();
            this.newCountryLPercentage = countryLPercentage.getText();
        });
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
                createFrame.setSize(400,560);
                createFrame.setVisible(true);
            }
            case "city" -> {
                createFrame.setTitle("CREATE NEW CITY");
                createCityPanel.setVisible(true);
                createCountryPanel.setVisible(false);
                createCountryLPanel.setVisible(false);
                createFrame.setSize(400,280);
                createFrame.setVisible(true);
            }
            case "countryL" -> {
                createFrame.setTitle("CREATE NEW COUNTRY LANGUAGE");
                createCityPanel.setVisible(false);
                createCountryPanel.setVisible(false);
                createCountryLPanel.setVisible(true);
                createFrame.setSize(400,240);
                createFrame.setVisible(true);
            }
            default -> JOptionPane.showMessageDialog(null, "SELECT A TABLE");
        }
    }
}
