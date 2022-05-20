import documents.JTextFieldCharLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class UpdateGUI
{
    //Frame stuff
    final JFrame updateFrame = new JFrame();
    final JPanel updateCountryPanel = new JPanel();
    final JPanel updateCityPanel = new JPanel();
    final JPanel updateCountryLPanel = new JPanel();

    //Country Inputs and Labels
    private final String[] continents = {"","Asia","Europe","North America","Africa","Oceania","Antarctica","South America"};
    final JLabel countryCode = new JLabel();
    final JTextField countryName = new JTextField();
    final JComboBox<String> countryContinent = new JComboBox<>(continents);
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

    //City Inputs and Labels
    final JTextField cityName = new JTextField();
    final JTextField cityCountryCode = new JTextField();
    final JTextField cityDistrict = new JTextField();
    final JTextField cityPopulation = new JTextField();
    final JLabel cityNameLabel = new JLabel("Name:");
    final JLabel cityCountryCodeLabel = new JLabel("Country Code:");
    final JLabel cityDistrictLabel = new JLabel("District:");
    final JLabel cityPopulationLabel = new JLabel("City Population:");
    final JLabel cityID = new JLabel();
    final JLabel cityIDLabel = new JLabel("City ID:");


    //Country Language Inputs and Labels
    final String[] isOfficialChoices = {"","T","F"};
    final JLabel countryLCode = new JLabel();
    final JLabel countryLLanguage = new JLabel();
    final JComboBox<String> countryLIsOfficial = new JComboBox<>(isOfficialChoices);
    final JTextField countryLPercentage = new JTextField();
    final JLabel countryLCodeLabel = new JLabel("Code:");
    final JLabel countryLLanguageLabel = new JLabel("Language:");
    final JLabel countryLIsOfficialLabel = new JLabel("Is official:");
    final JLabel countryLPercentageLabel = new JLabel("Percentage: ");

    //Other stuff
    final JLayeredPane mainupdatePanel = new JLayeredPane();
    private String tableSelection = "";
    ImageIcon ico = new ImageIcon("src/log.png");
    Update update = new Update();
    public String updateCountryCode,updateCityID,updateCountryLLanguage,updateCountryLCode;
    private boolean canUpdateCountry = false;
    private boolean canUpdateCity = false;
    private boolean canUpdateCountryL = false;
    private int countryCount = 0;
    private int cityCount = 0;
    private int countryLCount = 0;
    Main main = new Main();

    public UpdateGUI() throws SQLException, ClassNotFoundException {
        //Frame config
        updateFrame.setResizable(false);
        updateFrame.setSize(400,325);
        updateFrame.setLayout(new BorderLayout());
        updateFrame.setIconImage(ico.getImage());
        updateFrame.setVisible(false);
        updateFrame.setLocationRelativeTo(null);
        updateFrame.add(mainupdatePanel,BorderLayout.CENTER);

        //Main panel config
        mainupdatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainupdatePanel.setLayout(new BorderLayout());
        mainupdatePanel.add(updateCountryPanel);
        mainupdatePanel.add(updateCityPanel,BorderLayout.CENTER);
        mainupdatePanel.add(updateCountryLPanel);
        mainupdatePanel.setBounds(0,0,500,500);
        mainupdatePanel.setVisible(true);
    }
    private void updateCountry()
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
        updateCountryPanel.setLayout(countryLayout);
        updateCountryPanel.setBounds(0,0,400,530);

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

        updateCountryPanel.add(countryCodeLabel,countryCodeConstraints);
        updateCountryPanel.add(countryCode,countryCodeConstraints);
        updateCountryPanel.add(countryNameLabel,countryNameConstraints);
        updateCountryPanel.add(countryName,countryNameConstraints);
        updateCountryPanel.add(countryContinentLabel,countryContinentConstraints);
        updateCountryPanel.add(countryContinent,countryContinentConstraints);
        updateCountryPanel.add(countryRegionLabel,countryRegionConstraints);
        updateCountryPanel.add(countryRegion,countryRegionConstraints);
        updateCountryPanel.add(countrySurfaceLabel,countrySurfaceConstraints);
        updateCountryPanel.add(countrySurface,countrySurfaceConstraints);
        updateCountryPanel.add(countryYearLabel,countryYearConstraints);
        updateCountryPanel.add(countryYear,countryYearConstraints);
        updateCountryPanel.add(countryPopulationLabel,countryPopulationConstraints);
        updateCountryPanel.add(countryPopulation,countryPopulationConstraints);
        updateCountryPanel.add(countryLifeExpectancyLabel,countryLifeExpectancyConstraints);
        updateCountryPanel.add(countryLifeExpectancy,countryLifeExpectancyConstraints);
        updateCountryPanel.add(countryGNPLabel,countryGNPConstraints);
        updateCountryPanel.add(countryGNP,countryGNPConstraints);
        updateCountryPanel.add(countryGNPOldLabel,countryGNPOLdConstraints);
        updateCountryPanel.add(countryGNPOld,countryGNPOLdConstraints);
        updateCountryPanel.add(countryLocalNameLabel,countryLocalNameConstraints);
        updateCountryPanel.add(countryLocalName,countryLocalNameConstraints);
        updateCountryPanel.add(countryGovernmentFormLabel,countryGovernmentFormConstraints);
        updateCountryPanel.add(countryGovernmentForm,countryGovernmentFormConstraints);
        updateCountryPanel.add(countryHeadOfStateLabel,countryHeadStateConstraints);
        updateCountryPanel.add(countryHeadOfState,countryHeadStateConstraints);
        updateCountryPanel.add(countryCapitalLabel,countryCapitalConstraints);
        updateCountryPanel.add(countryCapital,countryCapitalConstraints);
        updateCountryPanel.add(countryCode2Label,countryCode2Constraints);
        updateCountryPanel.add(countryCode2,countryCode2Constraints);

        countryCode.setPreferredSize(new Dimension(150,20));
        countryName.setPreferredSize(new Dimension(150,20));
        countryContinent.setPreferredSize(new Dimension(150,20));
        countryGovernmentForm.setPreferredSize(new Dimension(150,20));

        JButton updateCountryButton = new JButton("Enter");
        GridBagConstraints updateCountryButtonConstraints = new GridBagConstraints();
        updateCountryButtonConstraints.gridx = -1;
        updateCountryButtonConstraints.gridy = 16;
        updateCountryButtonConstraints.insets = new Insets(10,125,0,0);
        updateCountryButtonConstraints.anchor = GridBagConstraints.PAGE_END;
        updateCountryPanel.add(updateCountryButton,updateCountryButtonConstraints);
        updateCountryButton.setFocusable(false);

        countryName.setDocument(new JTextFieldCharLimit(52));
        countryRegion.setDocument(new JTextFieldCharLimit(26));
        countrySurface.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE)&&!(input==KeyEvent.VK_PERIOD))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        countryYear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        countryPopulation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        countryLifeExpectancy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE)&&!(input==KeyEvent.VK_PERIOD))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        countryGNP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE)&&!(input==KeyEvent.VK_PERIOD))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        countryGNPOld.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE)&&!(input==KeyEvent.VK_PERIOD))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        countryLocalName.setDocument(new JTextFieldCharLimit(45));
        countryGovernmentForm.setDocument(new JTextFieldCharLimit(45));
        countryHeadOfState.setDocument(new JTextFieldCharLimit(60));
        countryCapital.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        countryCode2.setDocument(new JTextFieldCharLimit(2));

        String[] fill = update.updateCountryFill(updateCountryCode);
        if(fill[0]!=null)
        {
            update.updatedCountryCode = fill[0];
            countryCode.setText(fill[0]);
            countryName.setText(fill[1]);
            countryContinent.setSelectedItem(fill[2]);
            countryRegion.setText(fill[3]);
            countrySurface.setText(fill[4]);
            countryYear.setText(fill[5]);
            countryPopulation.setText(fill[6]);
            countryLifeExpectancy.setText(fill[7]);
            countryGNP.setText(fill[8]);
            countryGNPOld.setText(fill[9]);
            countryLocalName.setText(fill[10]);
            countryGovernmentForm.setText(fill[11]);
            countryHeadOfState.setText(fill[12]);
            countryCapital.setText(fill[13]);
            countryCode2.setText(fill[14]);
        }

        updateCountryButton.addActionListener(e->{

            update.updatedCountryName = countryName.getText();
            update.updatedCountryContinent = Objects.requireNonNull(countryContinent.getSelectedItem()).toString();
            update.updatedCountryRegion = countryRegion.getText();
            update.updatedCountrySurface = Float.parseFloat(countrySurface.getText());
            update.updatedCountryYear = Integer.parseInt(countryYear.getText());
            update.updatedCountryPopulation = Integer.parseInt(countryPopulation.getText());
            update.updatedCountryLifeExpectancy = Float.parseFloat(countryLifeExpectancy.getText());
            update.updatedCountryGNP = Float.parseFloat(countryGNP.getText());
            update.updatedCountryGNPOld = Float.parseFloat(countryGNPOld.getText());
            update.updatedCountryLocalName = countryLocalName.getText();
            update.updatedCountryGovernmentForm = countryGovernmentForm.getText();
            update.updatedCountryHeadOfState = countryHeadOfState.getText();
            update.updatedCountryCapital = Integer.parseInt(countryCapital.getText());
            update.updatedCountryCode2 = countryCode2.getText();
            update.updateInCountry();

            updateFrame.dispatchEvent(new WindowEvent(updateFrame,WindowEvent.WINDOW_CLOSING));
            JOptionPane.showMessageDialog(null,"COUNTRY UPDATED SUCCESSFULLY");
            countryCode.setText("");
            countryName.setText("");
            countryContinent.setSelectedItem("");
            countryRegion.setText("");
            countrySurface.setText("");
            countryYear.setText("");
            countryPopulation.setText("");
            countryLifeExpectancy.setText("");
            countryGNP.setText("");
            countryGNPOld.setText("");
            countryLocalName.setText("");
            countryGovernmentForm.setText("");
            countryHeadOfState.setText("");
            countryCapital.setText("");
            countryCode2.setText("");

            main.getGUI().getTables().getCountryModel().setRowCount(0);
            main.getGUI().getTables().getCountryModel().setColumnCount(0);
            main.getGUI().getTables().countryTableConfig();
        });


    }
    private void updateCity()
    {
        //update City Panel Configuration
        GridBagLayout cityLayout = new GridBagLayout();
        GridBagConstraints cityConstraintsID = new GridBagConstraints();
        GridBagConstraints cityConstraintsName = new GridBagConstraints();
        GridBagConstraints cityConstraintsCode = new GridBagConstraints();
        GridBagConstraints cityConstraintsDistrict = new GridBagConstraints();
        GridBagConstraints cityConstraintsPopulation = new GridBagConstraints();
        updateCityPanel.setLayout(cityLayout);
        updateCityPanel.setBounds(0,0,400,200);

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

        updateCityPanel.add(cityIDLabel,cityConstraintsID);
        updateCityPanel.add(cityID,cityConstraintsID);
        updateCityPanel.add(cityNameLabel,cityConstraintsName);
        updateCityPanel.add(cityName,cityConstraintsName);
        updateCityPanel.add(cityCountryCodeLabel,cityConstraintsCode);
        updateCityPanel.add(cityCountryCode,cityConstraintsCode);
        updateCityPanel.add(cityDistrictLabel,cityConstraintsDistrict);
        updateCityPanel.add(cityDistrict,cityConstraintsDistrict);
        updateCityPanel.add(cityPopulationLabel,cityConstraintsPopulation);
        updateCityPanel.add(cityPopulation,cityConstraintsPopulation);

        cityPopulation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });

        cityName.setPreferredSize(new Dimension(150,20));
        cityCountryCode.setPreferredSize(new Dimension(150,20));
        cityDistrict.setPreferredSize(new Dimension(150,20));
        cityPopulation.setPreferredSize(new Dimension(150,20));

        JPanel southupdateCityPanel = new JPanel();
        JButton updateCityButton = new JButton("Enter");
        GridBagConstraints updateCityButtonConstraints = new GridBagConstraints();
        updateCityButtonConstraints.gridx = -1;
        updateCityButtonConstraints.gridy = 6;
        updateCityButtonConstraints.insets = new Insets(10,125,0,0);
        updateCityButtonConstraints.anchor = GridBagConstraints.PAGE_END;
        updateCityPanel.add(updateCityButton,updateCityButtonConstraints);
        southupdateCityPanel.setPreferredSize(new Dimension(100,40));
        updateCityButton.setFocusable(false);
        cityCountryCode.setDocument(new JTextFieldCharLimit(3));

        String[] fill = update.updateCityFill(Integer.parseInt(updateCityID));
        if(fill[0]!=null)
        {
            update.updatedCityID = fill[0];
            cityID.setText(fill[0]);
            cityName.setText(fill[1]);
            cityCountryCode.setText(fill[2]);
            cityDistrict.setText(fill[3]);
            cityPopulation.setText(fill[4]);
        }

        updateCityButton.addActionListener(e->{

            update.updatedCityName = cityName.getText();
            update.updatedCityCode = cityCountryCode.getText().toUpperCase();
            update.updatedCityDistrict = cityDistrict.getText();
            update.updatedCityPopulation = Integer.parseInt(cityPopulation.getText());
            update.updateInCity();
             
            updateFrame.dispatchEvent(new WindowEvent(updateFrame,WindowEvent.WINDOW_CLOSING));
            JOptionPane.showMessageDialog(null,"CITY UPDATED SUCCESSFULLY");
            cityName.setText("");
            cityCountryCode.setText("");
            cityDistrict.setText("");
            cityPopulation.setText("");

            main.getGUI().getTables().getCityModel().setRowCount(0);
            main.getGUI().getTables().getCityModel().setColumnCount(0);
            main.getGUI().getTables().cityTableConfig();

        });

    }
    private  void  updateCountryLanguage()
    {
        GridBagLayout countryLLayout = new GridBagLayout();
        GridBagConstraints countryLCodeConstraints = new GridBagConstraints();
        GridBagConstraints countryLLanguageConstraints = new GridBagConstraints();
        GridBagConstraints countryLIsOfficialConstraints = new GridBagConstraints();
        GridBagConstraints countryLPercentageConstraints = new GridBagConstraints();
        updateCountryLPanel.setLayout(countryLLayout);
        updateCountryLPanel.setBounds(0,0,400,325);

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

        updateCountryLPanel.add(countryLCodeLabel,countryLCodeConstraints);
        updateCountryLPanel.add(countryLCode,countryLCodeConstraints);
        updateCountryLPanel.add(countryLLanguageLabel,countryLLanguageConstraints);
        updateCountryLPanel.add(countryLLanguage,countryLLanguageConstraints);
        updateCountryLPanel.add(countryLIsOfficialLabel,countryLIsOfficialConstraints);
        updateCountryLPanel.add(countryLIsOfficial,countryLIsOfficialConstraints);
        updateCountryLPanel.add(countryLPercentageLabel,countryLPercentageConstraints);
        updateCountryLPanel.add(countryLPercentage,countryLPercentageConstraints);

        countryLCode.setPreferredSize(new Dimension(150,20));
        countryLIsOfficial.setPreferredSize(new Dimension(150,20));

        countryLCode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isLetter(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS LETTERS");
                }
            }
        });
        countryLPercentage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if(!Character.isDigit(input)&&!(input==KeyEvent.VK_BACK_SPACE)&&!(input==KeyEvent.VK_DELETE)&&!(input==KeyEvent.VK_PERIOD))
                {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"THIS SPACE ONLY ACCEPTS NUMBERS");
                }
            }
        });
        JButton updateCountryLButton = new JButton("Enter");
        GridBagConstraints updateCountryLButtonConstraints = new GridBagConstraints();
        updateCountryLButtonConstraints.gridx = -1;
        updateCountryLButtonConstraints.gridy = 4;
        updateCountryLButtonConstraints.insets = new Insets(10,125,0,0);
        updateCountryLButtonConstraints.anchor = GridBagConstraints.PAGE_END;
        updateCountryLPanel.add(updateCountryLButton,updateCountryLButtonConstraints);

        String[] fill = update.updateCountryLFill(updateCountryLLanguage,updateCountryLCode);
        update.updatedCountryLCode= fill[0];
        countryLCode.setText(fill[0]);
        update.updatedCountryLLanguage = fill[1];
        countryLLanguage.setText(fill[1]);
        countryLIsOfficial.setSelectedItem(fill[2]);
        countryLPercentage.setText(fill[3]);

        updateCountryLButton.addActionListener(e->{
            if(Float.parseFloat(countryLPercentage.getText())>100)
            {
                JOptionPane.showMessageDialog(null,"THE PERCENTAGE THAT YOU ENTER IS NOT VALID");
            }
            else
            {
                update.updatedCountryLCode = countryLCode.getText().toUpperCase();
                update.updatedCountryLLanguage = countryLLanguage.getText();
                update.updatedCountryLIsOfficial = Objects.requireNonNull(countryLIsOfficial.getSelectedItem()).toString();
                update.updatedCountryLPercentage = Float.parseFloat(countryLPercentage.getText());
                update.updateInCountryLanguage();

                updateFrame.dispatchEvent(new WindowEvent(updateFrame,WindowEvent.WINDOW_CLOSING));
                JOptionPane.showMessageDialog(null,"COUNTRY LANGUAGE UPDATED SUCCESSFULLY");
                countryLCode.setText("");
                countryLLanguage.setText("");
                countryLIsOfficial.setSelectedItem("");
                countryLPercentage.setText("");
                main.getGUI().getTables().getCountryLananguageModel().setRowCount(0);
                main.getGUI().getTables().getCountryLananguageModel().setColumnCount(0);
                main.getGUI().getTables().countryLanguagesTableConfig();
            }

        });
    }
    public void setTableSelection(String tableSelection) {
        this.tableSelection = tableSelection;
    }
    public void updateSelector()
    {
        switch (tableSelection) {
            case "country" -> {
                do
                {
                    updateCountryCode = JOptionPane.showInputDialog("ENTER COUNTRY CODE TO UPDATE");
                    if (!updateCountryCode.matches("^[a-zA-z]*$"))
                    {
                        JOptionPane.showMessageDialog(null,"COUNTRY CODE ONLY CONTAINS LETTERS");
                    }
                    else if (updateCountryCode.length()>3)
                    {
                        JOptionPane.showMessageDialog(null,"COUNTRY CODE HAVE A MAXIMUM OF CHARACTERS OF 3");
                    }
                    else
                    {
                        canUpdateCountry = true;
                        countryCount++;
                    }
                }
                while (!updateCountryCode.matches("^[a-zA-z]*$")||updateCountryCode.length()>3);
                String[] fill = update.updateCountryFill(updateCountryCode);
                if(canUpdateCountry)
                {
                    if(countryCount==1)
                    {
                        this.updateCountry();
                    }
                    if(fill[0]!=null)
                    {
                        update.updatedCountryCode = fill[0];
                        countryCode.setText(fill[0]);
                        countryName.setText(fill[1]);
                        countryContinent.setSelectedItem(fill[2]);
                        countryRegion.setText(fill[3]);
                        countrySurface.setText(fill[4]);
                        countryYear.setText(fill[5]);
                        countryPopulation.setText(fill[6]);
                        countryLifeExpectancy.setText(fill[7]);
                        countryGNP.setText(fill[8]);
                        countryGNPOld.setText(fill[9]);
                        countryLocalName.setText(fill[10]);
                        countryGovernmentForm.setText(fill[11]);
                        countryHeadOfState.setText(fill[12]);
                        countryCapital.setText(fill[13]);
                        countryCode2.setText(fill[14]);

                        updateFrame.setTitle("UPDATE NEW COUNTRY");
                        updateCityPanel.setVisible(false);
                        updateCountryPanel.setVisible(true);
                        updateCountryLPanel.setVisible(false);
                        updateFrame.setSize(400,560);
                        updateFrame.setVisible(true);
                    }
                    else if(canUpdateCountry)
                    {
                        JOptionPane.showMessageDialog(null,"THAT COUNTRY DOESN'T EXISTS");
                    }
                }
            }
            case "city" -> {
                do {
                    updateCityID = JOptionPane.showInputDialog("ENTER CITY ID TO UPDATE");
                    if (!updateCityID.matches("^[0-9]*$"))
                    {
                        JOptionPane.showMessageDialog(null,"CITY ID ONLY CONTAINS NUMBERS");
                    }
                    else
                    {
                        canUpdateCity = true;
                        cityCount++;
                    }
                } while (!updateCityID.matches("^[0-9]*$"));
                String[] fill = update.updateCityFill(Integer.parseInt(updateCityID));
                if(canUpdateCity)
                {
                    if(cityCount==1)
                    {
                        this.updateCity();
                    }
                    if(fill[0]!=null)
                    {
                        update.updatedCityID = fill[0];
                        cityID.setText(fill[0]);
                        cityName.setText(fill[1]);
                        cityCountryCode.setText(fill[2]);
                        cityDistrict.setText(fill[3]);
                        cityPopulation.setText(fill[4]);

                        updateFrame.setTitle("UPDATE CITY");
                        updateCityPanel.setVisible(true);
                        updateCountryPanel.setVisible(false);
                        updateCountryLPanel.setVisible(false);
                        updateFrame.setSize(400,240);
                        updateFrame.setVisible(true);
                    }
                    else if(canUpdateCity)
                    {
                        JOptionPane.showMessageDialog(null,"THAT CITY DOESN'T EXISTS");
                    }
                }
            }
            case "countryL" -> {
                JTextField xField = new JTextField(10);
                JTextField yField = new JTextField(10);
                JPanel myPanel = new JPanel();
                myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
                myPanel.add(new JLabel("Country code:"));
                myPanel.add(xField);
                myPanel.add(Box.createVerticalBox()); // a spacer
                myPanel.add(new JLabel("Language:"));
                myPanel.add(yField);
                do {
                    int result = JOptionPane.showConfirmDialog(null, myPanel,
                            "SEARCH FOR COUNTRY LANGUAGE",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    if (result == JOptionPane.OK_OPTION)
                    {
                        updateCountryLCode = xField.getText();
                        updateCountryLLanguage = yField.getText();
                    }
                    if (updateCountryLLanguage.length()>30)
                    {
                        JOptionPane.showMessageDialog(null,"LANGUAGES HAVE A MAXIMUM OF CHARACTERS OF 30");
                    }
                    else if (updateCountryLCode.length()>3)
                    {
                        JOptionPane.showMessageDialog(null,"COUNTRY CODE HAVE A MAXIMUM OF CHARACTERS OF 3");
                    }
                    else if(!updateCountryLCode.matches("^[a-zA-z]*$"))
                    {
                        JOptionPane.showMessageDialog(null,"COUNTRY CODE ONLY CONTAINS LETTERS");
                    }
                    else
                    {
                        canUpdateCountryL = true;
                        countryLCount++;
                    }
                } while (updateCountryLLanguage.length()>30||updateCountryLCode.length()>3||!updateCountryLCode.matches("^[a-zA-z]*$"));
                String[] fill = update.updateCountryLFill(updateCountryLLanguage,updateCountryLCode);
                if(canUpdateCountryL)
                {
                    if(countryLCount==1)
                    {
                        this.updateCountryLanguage();
                    }
                    if(fill[0]!=null)
                    {
                        update.updatedCountryLCode= fill[0];
                        countryLCode.setText(fill[0]);
                        countryLLanguage.setText(fill[1]);
                        update.updatedCountryLLanguage = fill[1];
                        countryLIsOfficial.setSelectedItem(fill[2]);
                        countryLPercentage.setText(fill[3]);
                        updateFrame.setTitle("UPDATE COUNTRY LANGUAGE");
                        updateCityPanel.setVisible(false);
                        updateCountryPanel.setVisible(false);
                        updateCountryLPanel.setVisible(true);
                        updateFrame.setSize(400,240);
                        updateFrame.setVisible(true);
                    }
                    else if(canUpdateCountryL)
                    {
                        JOptionPane.showMessageDialog(null,"THAT COUNTRY LANGUAGE DOESN'T EXISTS");
                    }

                }
            }
            default -> JOptionPane.showMessageDialog(null, "SELECT A TABLE");
        }
    }
}
