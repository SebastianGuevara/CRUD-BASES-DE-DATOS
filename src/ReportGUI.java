import documents.MyComboBoxRenderer;
import documents.TextPrompt;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class ReportGUI
{
    private final DataBase db= new DataBase();
    private final Connection con = db.getConnection();

    JPanel countryPanel = new JPanel();
    JPanel countryNorthPanel = new JPanel();
    JPanel countryCentralPanel = new JPanel();
    JPanel cityPanel = new JPanel();
    JPanel cityNorthPanel = new JPanel();
    JPanel cityCentralPanel = new JPanel();
    JPanel countryLPanel = new JPanel();
    JPanel countryLNorthPanel = new JPanel();
    JPanel countryLCentralPanel = new JPanel();
    JLabel countryLabel = new JLabel("Country");
    JLabel cityLabel = new JLabel("City");
    JLabel countryLLabel = new JLabel("Country Language");
    private Report report = new Report();

    private final JFrame reportFrame = new JFrame();
    private final JPanel mainReportPanel = new JPanel();
    private final JPanel northPanel = new JPanel();
    private final JPanel southPanel = new JPanel();
    private final JPanel centralPanel = new JPanel();

    //CheckBoxes
    public final JCheckBox countryCheckbox = new JCheckBox("Country");
    public final JCheckBox cityCheckbox = new JCheckBox("City");
    public final JCheckBox countryLanguageCheckbox = new JCheckBox("Country Language");

    //COUNTRY COMBO QUERY CONFIG
    JComboBox<String> countryCode = new JComboBox<>();
    JComboBox<String> countryName = new JComboBox<>();
    JComboBox<String> countryContinent = new JComboBox<>();
    JComboBox<String> countryRegion = new JComboBox<>();
    JLabel countrySurfaceLabel = new JLabel("Surface Area:");
    JTextField countrySurface = new JTextField();
    JTextField countrySurfaceUp = new JTextField();
    JLabel countryYearLabel = new JLabel("Independence year:");
    JTextField countryYear = new JTextField();
    JTextField countryYearUp = new JTextField();
    JLabel countryPopulationLabel = new JLabel("Population");
    JTextField countryPopulation = new JTextField();
    JTextField countryPopulationUp = new JTextField();
    JLabel countryLifeExpectancyLabel = new JLabel("Life Expectancy");
    JTextField countryLifeExpectancy = new JTextField();
    JTextField countryLifeExpectancyUp = new JTextField();
    JLabel countryGNPLabel = new JLabel("GNP");
    JTextField countryGNP = new JTextField();
    JTextField countryGNPUp = new JTextField();
    JLabel countryGNPOldLabel = new JLabel("Old GNP");
    JTextField countryGNPOld = new JTextField();
    JTextField countryGNPOldUp = new JTextField();
    JComboBox<String> countryLocalName = new JComboBox<>();
    JComboBox<String> countryGovernmentForm = new JComboBox<>();
    JComboBox<String> countryHeadOfState = new JComboBox<>();
    JComboBox<String> countryCapital = new JComboBox<>();
    JComboBox<String> countryCode2 = new JComboBox<>();
    DefaultComboBoxModel fillCountryCode = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryName = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryContinent = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryRegion = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountrySurface = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryYear = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryPopulation = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLifeExpectancy = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryGNP= new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryGNPOld = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLocalName = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryGovernmentForm = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryHeadOfState = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryCapital = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryCode2= new DefaultComboBoxModel();

    //CITY COMBO QUERY CONFIG
    JComboBox<String> cityID = new JComboBox<>();
    JComboBox<String> cityName = new JComboBox<>();
    JComboBox<String> cityCode = new JComboBox<>();
    JComboBox<String> cityDistrict = new JComboBox<>();
    JLabel cityPopulationLabel = new JLabel("Population");
    JTextField cityPopulation = new JTextField();
    JTextField cityPopulationUp = new JTextField();
    DefaultComboBoxModel fillCityID = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityName = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityCode = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityDistrict = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityPopulation= new DefaultComboBoxModel();

    //COUNTRY LANGUEGA QUERY MENU
    JComboBox<String> countryLCode = new JComboBox<>();
    JComboBox<String> countryLLanguage = new JComboBox<>();
    JComboBox<String> countryLIsOfficial = new JComboBox<>();
    JLabel countryLPercentageLabel = new JLabel("Percentage");
    JTextField countryLPercentage = new JTextField();
    JTextField countryLPercentageUp = new JTextField();

    DefaultComboBoxModel fillCountryLCode= new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLLanguage = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLIsOfficial = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLPercentage= new DefaultComboBoxModel();

    JPanel northNorthPanel = new JPanel();
    JPanel northSouthPanel = new JPanel();
    JLabel selectCheckbox = new JLabel("Select tables you want to use");
    JButton enterButton = new JButton("Select Columns");

    JFrame tableFrame = new JFrame();
    JPanel panelCenter = new JPanel();
    DefaultTableModel countryModel = new DefaultTableModel();
    JTable table = new JTable()
    {
        @Override
        public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
            if (convertColumnIndexToModel(columnIndex) != 0) {
                return;
            }
            super.changeSelection(rowIndex, columnIndex, toggle, extend);
        }
    };

    JScrollPane scroll = new JScrollPane(table);
    String countryQuery = "select * from country";

    JFrame columnsFrame = new JFrame();
    public JCheckBox countryCodeCheck = new JCheckBox("Code",true);
    public JCheckBox countryNameCheck = new JCheckBox("Name",true);
    public JCheckBox countryContinentCheck = new JCheckBox("Continent",true);
    public JCheckBox countryRegionCheck = new JCheckBox("Region",true);
    public JCheckBox countrySurfaceCheck = new JCheckBox("Surface Area",true);
    public JCheckBox countryYearCheck = new JCheckBox("IndepYear",true);
    public JCheckBox countryPopulationCheck = new JCheckBox("Population",true);
    public JCheckBox countryLifeExpectancyCheck = new JCheckBox("Life Expectancy",true);
    public JCheckBox countryGNPCheck = new JCheckBox("GNP",true);
    public JCheckBox countryGNPOldCheck = new JCheckBox("GNPOld",true);
    public JCheckBox countryLocalNameCheck = new JCheckBox("LocalName",true);
    public JCheckBox countryGovernmentFormCheck = new JCheckBox("Government Form",true);
    public JCheckBox countryHeadOfStateCheck = new JCheckBox("Head Of State",true);
    public JCheckBox countryCapitalCheck = new JCheckBox("Capital",true);
    public JCheckBox countryCode2Check = new JCheckBox("Code2",true);

    public JCheckBox cityIDCheck = new JCheckBox("ID",true);
    public JCheckBox cityNameCheck = new JCheckBox("Name",true);
    public JCheckBox cityCodeCheck = new JCheckBox("Country Code",true);
    public JCheckBox cityDistrictCheck = new JCheckBox("District",true);
    public JCheckBox cityPopulationCheck = new JCheckBox("Population",true);

    public JCheckBox countryLCodeCheck = new JCheckBox("Country Code",true);
    public JCheckBox countryLLanguageCheck = new JCheckBox("Language",true);
    public JCheckBox countryLIsCheck = new JCheckBox("IsOfficial",true);
    public JCheckBox countryLPercentageCheck= new JCheckBox("Percentage",true);

    JButton columnSelectorButton = new JButton("Generate Report");

    JButton exportButton = new JButton("Export to excel");

    ImageIcon ico = new ImageIcon("src/log.png");
    
    public ReportGUI() throws SQLException, ClassNotFoundException {
        reportFrame.setResizable(false);
        reportFrame.setSize(400,325);
        reportFrame.setTitle("REPORT");
        reportFrame.setLayout(new BorderLayout());
        reportFrame.setIconImage(ico.getImage());
        reportFrame.setVisible(false);
        reportFrame.setLocationRelativeTo(null);
        reportFrame.add(mainReportPanel,BorderLayout.CENTER);

        enterButton.setFocusable(false);
        southPanel.add(enterButton);
        enterButton.addActionListener(e->{
            selectColumns();
            reportFrame.dispatchEvent(new WindowEvent(reportFrame,WindowEvent.WINDOW_CLOSING));
        });
        mainReportPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,60));

        mainReportPanel.add(northPanel,BorderLayout.NORTH);
        mainReportPanel.add(centralPanel,BorderLayout.CENTER);
        mainReportPanel.add(southPanel,BorderLayout.SOUTH);

        //NorthPanel config
        northPanel.setLayout(new BorderLayout());
        northPanel.add(northNorthPanel,BorderLayout.NORTH);
        northPanel.add(northSouthPanel,BorderLayout.CENTER);
        northNorthPanel.add(selectCheckbox);
        northSouthPanel.setLayout(new FlowLayout());
        northSouthPanel.add(countryCheckbox,FlowLayout.LEFT);
        northSouthPanel.add(cityCheckbox,FlowLayout.CENTER);
        northSouthPanel.add(countryLanguageCheckbox,FlowLayout.RIGHT);
        countryCheckbox.setFocusable(false);
        cityCheckbox.setFocusable(false);
        countryLanguageCheckbox.setFocusable(false);

        //Central panel config
        BoxLayout box = new BoxLayout(centralPanel,BoxLayout.X_AXIS);
        centralPanel.setLayout(box);

        centralPanel.add(countryCentralPanel);
        centralPanel.add(cityCentralPanel);
        centralPanel.add(countryLCentralPanel);

        countryCentralPanel.setBorder(BorderFactory.createBevelBorder(1));
        cityCentralPanel.setBorder(BorderFactory.createBevelBorder(1));
        countryLCentralPanel.setBorder(BorderFactory.createBevelBorder(1));

        countryCentralPanel.setPreferredSize(new Dimension(100,100));
        cityCentralPanel.setPreferredSize(new Dimension(100,100));
        countryLCentralPanel.setPreferredSize(new Dimension(100,100));

        countryCentralPanel.setLayout(new BorderLayout());
        cityCentralPanel.setLayout(new BorderLayout());
        countryLCentralPanel.setLayout(new BorderLayout());

        countryPanel.setLayout(new GridBagLayout());
        cityPanel.setLayout(new GridBagLayout());
        countryLPanel.setLayout(new GridBagLayout());

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

        GridBagConstraints cityConstraintsID = new GridBagConstraints();
        GridBagConstraints cityConstraintsName = new GridBagConstraints();
        GridBagConstraints cityConstraintsCode = new GridBagConstraints();
        GridBagConstraints cityConstraintsDistrict = new GridBagConstraints();
        GridBagConstraints cityConstraintsPopulation = new GridBagConstraints();

        GridBagLayout countryLLayout = new GridBagLayout();
        GridBagConstraints countryLCodeConstraints = new GridBagConstraints();
        GridBagConstraints countryLLanguageConstraints = new GridBagConstraints();
        GridBagConstraints countryLIsOfficialConstraints = new GridBagConstraints();
        GridBagConstraints countryLPercentageConstraints = new GridBagConstraints();

        new TextPrompt("From",countrySurface);
        new TextPrompt("To",countrySurfaceUp);
        new TextPrompt("From",countryYear);
        new TextPrompt("To",countryYearUp);
        new TextPrompt("From",countryPopulation);
        new TextPrompt("To",countryPopulationUp);
        new TextPrompt("From",countryLifeExpectancy);
        new TextPrompt("To",countryLifeExpectancyUp);
        new TextPrompt("From",countryGNP);
        new TextPrompt("To",countryGNPUp);
        new TextPrompt("From",countryGNPOld);
        new TextPrompt("To",countryGNPOldUp);
        new TextPrompt("From",cityPopulation);
        new TextPrompt("To",cityPopulationUp);
        new TextPrompt("From",countryLPercentage);
        new TextPrompt("To",countryLPercentageUp);

        countrySurface.addKeyListener(new KeyAdapter() {
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
        countrySurfaceUp.addKeyListener(new KeyAdapter() {
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
        });countryYearUp.addKeyListener(new KeyAdapter() {
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
        countryPopulationUp.addKeyListener(new KeyAdapter() {
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
        countryLifeExpectancyUp.addKeyListener(new KeyAdapter() {
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
        });countryGNPUp.addKeyListener(new KeyAdapter() {
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
        countryGNPOldUp.addKeyListener(new KeyAdapter() {
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
        cityPopulationUp.addKeyListener(new KeyAdapter() {
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
        countryLPercentageUp.addKeyListener(new KeyAdapter() {
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
        countryNorthPanel.setPreferredSize(new Dimension(20,20));
        cityNorthPanel.setPreferredSize(new Dimension(20,20));
        cityCentralPanel.setPreferredSize(new Dimension(20,10));
        countryLNorthPanel.setPreferredSize(new Dimension(20,20));
        countryLCentralPanel.setPreferredSize(new Dimension(20,10));

        countryNorthPanel.add(countryLabel);
        cityNorthPanel.add(cityLabel);
        countryLNorthPanel.add(countryLLabel);

        countryCentralPanel.add(countryPanel,BorderLayout.CENTER);
        countryCentralPanel.add(countryNorthPanel,BorderLayout.NORTH);
        cityCentralPanel.add(cityPanel,BorderLayout.CENTER);
        cityCentralPanel.add(cityNorthPanel,BorderLayout.NORTH);
        countryLCentralPanel.add(countryLPanel,BorderLayout.CENTER);
        countryLCentralPanel.add(countryLNorthPanel,BorderLayout.NORTH);

        countryCode.setPreferredSize(new Dimension(120,20));
        countryCode.setRenderer(new MyComboBoxRenderer("Code"));
        countryCode.setModel(fillCountryCode);
        fillCountryCode.addAll(report.fillComboBoxCountryCode());
        countryName.setPreferredSize(new Dimension(120,20));
        countryName.setRenderer(new MyComboBoxRenderer("Name"));
        countryName.setModel(fillCountryName);
        fillCountryName.addAll(report.fillComboBoxCountryName());
        countryContinent.setPreferredSize(new Dimension(120,20));
        countryContinent.setRenderer(new MyComboBoxRenderer("Continent"));
        countryContinent.setModel(fillCountryContinent);
        fillCountryContinent.addAll(report.fillComboBoxCountryContinent());
        countryRegion.setPreferredSize(new Dimension(120,20));
        countryRegion.setRenderer(new MyComboBoxRenderer("Region"));
        countryRegion.setModel(fillCountryRegion);
        fillCountryRegion.addAll(report.fillComboBoxCountryRegion());
        countrySurface.setPreferredSize(new Dimension(58,20));
        countrySurfaceUp.setPreferredSize(new Dimension(58,20));
        fillCountrySurface.addAll(report.fillComboBoxCountrySurface());
        countryYear.setPreferredSize(new Dimension(58,20));
        countryYearUp.setPreferredSize(new Dimension(58,20));
        fillCountryYear.addAll(report.fillComboBoxCountryYear());
        countryPopulation.setPreferredSize(new Dimension(58,20));
        countryPopulationUp.setPreferredSize(new Dimension(58,20));
        fillCountryPopulation.addAll(report.fillComboBoxCountryPopulation());
        countryLifeExpectancy.setPreferredSize(new Dimension(58,20));
        countryLifeExpectancyUp.setPreferredSize(new Dimension(58,20));
        fillCountryLifeExpectancy.addAll(report.fillComboBoxCountryLifeExpectancy());
        countryGNP.setPreferredSize(new Dimension(58,20));
        countryGNPUp.setPreferredSize(new Dimension(58,20));
        fillCountryGNP.addAll(report.fillComboBoxCountryGNP());
        countryGNPOld.setPreferredSize(new Dimension(58,20));
        countryGNPOldUp.setPreferredSize(new Dimension(58,20));
        fillCountryGNPOld.addAll(report.fillComboBoxCountryGNPOld());
        countryLocalName.setPreferredSize(new Dimension(120,20));
        countryLocalName.setRenderer(new MyComboBoxRenderer("Local Name"));
        countryLocalName.setModel(fillCountryLocalName);
        fillCountryLocalName.addAll(report.fillComboBoxCountryLocalName());
        countryGovernmentForm.setPreferredSize(new Dimension(120,20));
        countryGovernmentForm.setRenderer(new MyComboBoxRenderer("Government Form"));
        countryGovernmentForm.setModel(fillCountryGovernmentForm);
        fillCountryGovernmentForm.addAll(report.fillComboBoxCountryGovernmentForm());
        countryHeadOfState.setPreferredSize(new Dimension(120,20));
        countryHeadOfState.setRenderer(new MyComboBoxRenderer("Head of State"));
        countryHeadOfState.setModel(fillCountryHeadOfState);
        fillCountryHeadOfState.addAll(report.fillComboBoxCountryHeadOfState());
        countryCapital.setPreferredSize(new Dimension(120,20));
        countryCapital.setRenderer(new MyComboBoxRenderer("Capital"));
        countryCapital.setModel(fillCountryCapital);
        fillCountryCapital.addAll(report.fillComboBoxCountryCapital());
        countryCode2.setPreferredSize(new Dimension(120,20));
        countryCode2.setRenderer(new MyComboBoxRenderer("Code"));
        countryCode2.setModel(fillCountryCode2);
        fillCountryCode2.addAll(report.fillComboBoxCountryCode2());

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

        countryPanel.add(countryCode,countryCodeConstraints);
        countryPanel.add(countryName,countryNameConstraints);
        countryPanel.add(countryContinent,countryContinentConstraints);
        countryPanel.add(countryRegion,countryRegionConstraints);
        countryPanel.add(countrySurfaceLabel,countrySurfaceConstraints);
        countryPanel.add(countrySurface,countrySurfaceConstraints);
        countryPanel.add(countrySurfaceUp,countrySurfaceConstraints);
        countryPanel.add(countryYearLabel,countryYearConstraints);
        countryPanel.add(countryYear,countryYearConstraints);
        countryPanel.add(countryYearUp,countryYearConstraints);
        countryPanel.add(countryPopulationLabel,countryPopulationConstraints);
        countryPanel.add(countryPopulation,countryPopulationConstraints);
        countryPanel.add(countryPopulationUp,countryPopulationConstraints);
        countryPanel.add(countryLifeExpectancyLabel,countryLifeExpectancyConstraints);
        countryPanel.add(countryLifeExpectancy,countryLifeExpectancyConstraints);
        countryPanel.add(countryLifeExpectancyUp,countryLifeExpectancyConstraints);
        countryPanel.add(countryGNPLabel,countryGNPConstraints);
        countryPanel.add(countryGNP,countryGNPConstraints);
        countryPanel.add(countryGNPUp,countryGNPConstraints);
        countryPanel.add(countryGNPOldLabel,countryGNPOLdConstraints);
        countryPanel.add(countryGNPOld,countryGNPOLdConstraints);
        countryPanel.add(countryGNPOldUp,countryGNPOLdConstraints);
        countryPanel.add(countryLocalName,countryLocalNameConstraints);
        countryPanel.add(countryGovernmentForm,countryGovernmentFormConstraints);
        countryPanel.add(countryHeadOfState,countryHeadStateConstraints);
        countryPanel.add(countryCapital,countryCapitalConstraints);
        countryPanel.add(countryCode2,countryCode2Constraints);

        cityID.setPreferredSize(new Dimension(120,20));
        cityID.setRenderer(new MyComboBoxRenderer("ID"));
        cityID.setModel(fillCityID);
        fillCityID.addAll(report.fillComboBoxCityID());
        cityName.setPreferredSize(new Dimension(120,20));
        cityName.setRenderer(new MyComboBoxRenderer("Name"));
        cityName.setModel(fillCityName);
        fillCityName.addAll(report.fillComboBoxCityName());
        cityCode.setPreferredSize(new Dimension(120,20));
        cityCode.setRenderer(new MyComboBoxRenderer("Country Code"));
        cityCode.setModel(fillCityCode);
        fillCityCode.addAll(report.fillComboBoxCityCode());
        cityDistrict.setPreferredSize(new Dimension(120,20));
        cityDistrict.setRenderer(new MyComboBoxRenderer("District"));
        cityDistrict.setModel(fillCityDistrict);
        fillCityDistrict.addAll(report.fillComboBoxCityDistrict());
        cityPopulation.setPreferredSize(new Dimension(58,20));
        cityPopulationUp.setPreferredSize(new Dimension(58,20));
        fillCityPopulation.addAll(report.fillComboBoxCityPopulation());

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

        cityPanel.add(cityID,cityConstraintsID);
        cityPanel.add(cityName,cityConstraintsName);
        cityPanel.add(cityCode,cityConstraintsCode);
        cityPanel.add(cityDistrict,cityConstraintsDistrict);
        cityPanel.add(cityPopulationLabel,cityConstraintsPopulation);
        cityPanel.add(cityPopulation,cityConstraintsPopulation);
        cityPanel.add(cityPopulationUp,cityConstraintsPopulation);

        countryLCode.setPreferredSize(new Dimension(120,20));
        countryLCode.setRenderer(new MyComboBoxRenderer("Country Code"));
        countryLCode.setModel(fillCountryLCode);
        fillCountryLCode.addAll(report.fillComboBoxCountryLCode());
        countryLLanguage.setPreferredSize(new Dimension(120,20));
        countryLLanguage.setRenderer(new MyComboBoxRenderer("Language"));
        countryLLanguage.setModel(fillCountryLLanguage);
        fillCountryLLanguage.addAll(report.fillComboBoxCountryLLanguage());
        countryLIsOfficial.setPreferredSize(new Dimension(120,20));
        countryLIsOfficial.setRenderer(new MyComboBoxRenderer("Is official?"));
        countryLIsOfficial.setModel(fillCountryLIsOfficial);
        fillCountryLIsOfficial.addAll(report.fillComboBoxCountryLOfficial());
        countryLPercentage.setPreferredSize(new Dimension(58,20));
        countryLPercentageUp.setPreferredSize(new Dimension(58,20));
        fillCountryLPercentage.addAll(report.fillComboBoxCountryLPercentage());

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

        countryLPanel.add(countryLCode,countryLCodeConstraints);
        countryLPanel.add(countryLLanguage,countryLLanguageConstraints);
        countryLPanel.add(countryLIsOfficial,countryLIsOfficialConstraints);
        countryLPanel.add(countryLPercentageLabel,countryLPercentageConstraints);
        countryLPanel.add(countryLPercentage,countryLPercentageConstraints);
        countryLPanel.add(countryLPercentageUp,countryLPercentageConstraints);
    }
    public void mainSetup()
    {
        countryCheckbox.setSelected(false);
        cityCheckbox.setSelected(false);
        countryLanguageCheckbox.setSelected(false);

        countryCentralPanel.setVisible(false);
        cityCentralPanel.setVisible(false);
        countryLCentralPanel.setVisible(false);

        //COUNTRY
        fillCountryCode.removeAllElements();
        fillCountryCode.addAll(report.fillComboBoxCountryCode());
        fillCountryName.removeAllElements();
        fillCountryName.addAll(report.fillComboBoxCountryName());
        fillCountryContinent.removeAllElements();
        fillCountryContinent.addAll(report.fillComboBoxCountryContinent());
        fillCountryRegion.removeAllElements();
        fillCountryRegion.addAll(report.fillComboBoxCountryRegion());
        fillCountrySurface.removeAllElements();
        fillCountrySurface.addAll(report.fillComboBoxCountrySurface());
        fillCountryYear.removeAllElements();
        fillCountryYear.addAll(report.fillComboBoxCountryYear());
        fillCountryPopulation.removeAllElements();
        fillCountryPopulation.addAll(report.fillComboBoxCountryPopulation());
        fillCountryLifeExpectancy.removeAllElements();
        fillCountryLifeExpectancy.addAll(report.fillComboBoxCountryLifeExpectancy());
        fillCountryGNP.removeAllElements();
        fillCountryGNP.addAll(report.fillComboBoxCountryGNP());
        fillCountryGNPOld.removeAllElements();
        fillCountryGNPOld.addAll(report.fillComboBoxCountryGNPOld());
        fillCountryLocalName.removeAllElements();
        fillCountryLocalName.addAll(report.fillComboBoxCountryLocalName());
        fillCountryGovernmentForm.removeAllElements();
        fillCountryGovernmentForm.addAll(report.fillComboBoxCountryGovernmentForm());
        fillCountryHeadOfState.removeAllElements();
        fillCountryHeadOfState.addAll(report.fillComboBoxCountryHeadOfState());
        fillCountryCapital.removeAllElements();
        fillCountryCapital.addAll(report.fillComboBoxCountryCapital());
        fillCountryCode2.removeAllElements();
        fillCountryCode2.addAll(report.fillComboBoxCountryCode2());

        //CITY
        fillCityID.removeAllElements();
        fillCityID.addAll(report.fillComboBoxCityID());
        fillCityName.removeAllElements();
        fillCityName.addAll(report.fillComboBoxCityName());
        fillCityCode.removeAllElements();
        fillCityCode.addAll(report.fillComboBoxCityCode());
        fillCityDistrict.removeAllElements();
        fillCityDistrict.addAll(report.fillComboBoxCityDistrict());
        fillCityPopulation.removeAllElements();
        fillCityPopulation.addAll(report.fillComboBoxCityPopulation());

        //COUNTRY LANGUAGE
        fillCountryLCode.removeAllElements();
        fillCountryLCode.addAll(report.fillComboBoxCountryLCode());
        fillCountryLLanguage.removeAllElements();
        fillCountryLLanguage.addAll(report.fillComboBoxCountryLLanguage());
        fillCountryLIsOfficial.removeAllElements();
        fillCountryLIsOfficial.addAll(report.fillComboBoxCountryLOfficial());
        fillCountryLPercentage.removeAllElements();
        fillCountryLPercentage.addAll(report.fillComboBoxCountryLPercentage());

        countryCheckbox.addActionListener(e->
        {

            if(countryCheckbox.isSelected())
            {
                countryCentralPanel.setVisible(true);
                reportFrame.setSize(350,650);
                if(countryCheckbox.isSelected()&&cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(1200,650);
                }
                else if(countryCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(850,650);
                } else if (countryCheckbox.isSelected()&&cityCheckbox.isSelected())
                {
                    reportFrame.setSize(850,650);
                }

            }
            else
            {
                countryCentralPanel.setVisible(false);
            }
        });
        cityCheckbox.addActionListener(e->
        {
            if(cityCheckbox.isSelected())
            {
                cityCentralPanel.setVisible(true);
                reportFrame.setSize(350,350);
                if(countryCheckbox.isSelected()&&cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(1200,650);
                }
                else if(cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(850,350);
                }
                else if(cityCheckbox.isSelected()&&countryCheckbox.isSelected())
                {
                    reportFrame.setSize(850,650);
                }
            }
            else
            {
                cityCentralPanel.setVisible(false);
            }
        });
        countryLanguageCheckbox.addActionListener(e->
        {
            if(countryLanguageCheckbox.isSelected())
            {
                countryLCentralPanel.setVisible(true);
                reportFrame.setSize(350,300);
                if(countryCheckbox.isSelected()&&cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(1200,650);
                }
                else if(countryCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(850,650);
                }
                else if(cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(850,350);
                }
            }
            else
            {
                countryLCentralPanel.setVisible(false);
            }
        });

        countryCodeCheck.setFocusable(false);
        countryNameCheck.setFocusable(false);
        countryContinentCheck.setFocusable(false);
        countryRegionCheck.setFocusable(false);
        countrySurfaceCheck.setFocusable(false);
        countryYearCheck.setFocusable(false);
        countryPopulationCheck.setFocusable(false);
        countryLifeExpectancyCheck.setFocusable(false);
        countryGNPCheck.setFocusable(false);
        countryGNPOldCheck.setFocusable(false);
        countryLocalNameCheck.setFocusable(false);
        countryGovernmentFormCheck.setFocusable(false);
        countryHeadOfStateCheck.setFocusable(false);
        countryCapitalCheck.setFocusable(false);
        countryCode2Check.setFocusable(false);

        cityIDCheck.setFocusable(false);
        cityNameCheck.setFocusable(false);
        cityCodeCheck.setFocusable(false);
        cityDistrictCheck.setFocusable(false);
        cityPopulationCheck.setFocusable(false);

        countryLCodeCheck.setFocusable(false);
        countryLLanguageCheck.setFocusable(false);
        countryLIsCheck.setFocusable(false);
        countryLPercentageCheck.setFocusable(false);

        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setDragEnabled(false);
        table.setUpdateSelectionOnSort(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        reportFrame.setVisible(true);
    }
    public void selectColumns()
    {
        JPanel mainP = new JPanel();
        JPanel northP = new JPanel();
        JPanel southP = new JPanel();
        JPanel centralP = new JPanel();
        JPanel centralNorth = new JPanel();
        JPanel centralCentral = new JPanel();
        JPanel northNorth = new JPanel();
        JPanel northCentral = new JPanel();
        JPanel southNorth = new JPanel();
        JPanel southCentral = new JPanel();
        JLabel countryColumnsLabel = new JLabel("Country Columns");
        JLabel cityColumnsLabel = new JLabel("City Columns");
        JLabel countryLColumnsLabel = new JLabel("Country Language Columns");

        countryColumnsLabel.setFont(new Font("Arial",Font.BOLD,15));
        cityColumnsLabel.setFont(new Font("Arial",Font.BOLD,15));
        countryLColumnsLabel.setFont(new Font("Arial",Font.BOLD,15));

        columnsFrame.setResizable(false);
        columnsFrame.setSize(400,350);
        columnsFrame.setTitle("SELECT COLUMNS");
        columnsFrame.setLayout(new BorderLayout());
        columnsFrame.setIconImage(ico.getImage());
        columnsFrame.setVisible(false);
        columnsFrame.setLocationRelativeTo(null);
        columnsFrame.add(mainP,BorderLayout.CENTER);

        mainP.setLayout(new BorderLayout());

        northP.setLayout(new BorderLayout());
        northP.setPreferredSize(new Dimension(100,150));
        centralP.setLayout(new BorderLayout());
        centralP.setPreferredSize(new Dimension(10,10));
        southP.setLayout(new BorderLayout());
        southP.setPreferredSize(new Dimension(100,100));

        centralCentral.setPreferredSize(new Dimension(100,100));

        mainP.add(northP,BorderLayout.NORTH);
        mainP.add(centralP,BorderLayout.CENTER);
        mainP.add(southP,BorderLayout.SOUTH);

        northP.add(northNorth,BorderLayout.NORTH);
        northP.add(northCentral,BorderLayout.CENTER);
        centralP.add(centralNorth,BorderLayout.NORTH);
        centralP.add(centralCentral,BorderLayout.CENTER);
        southP.add(southNorth,BorderLayout.NORTH);
        southP.add(southCentral,BorderLayout.CENTER);

        northNorth.add(countryColumnsLabel);
        centralNorth.add(cityColumnsLabel);
        southNorth.add(countryLColumnsLabel);

        northCentral.setLayout(new FlowLayout());
        centralCentral.setLayout(new FlowLayout());
        southCentral.setLayout(new FlowLayout());

        countryCodeCheck.setSelected(true);
        countryNameCheck.setSelected(true);
        countryContinentCheck.setSelected(true);
        countryRegionCheck.setSelected(true);
        countrySurfaceCheck.setSelected(true);
        countryYearCheck.setSelected(true);
        countryPopulationCheck.setSelected(true);
        countryLifeExpectancyCheck.setSelected(true);
        countryGNPCheck.setSelected(true);
        countryGNPOldCheck.setSelected(true);
        countryLocalNameCheck.setSelected(true);
        countryLocalNameCheck.setSelected(true);
        countryGovernmentFormCheck.setSelected(true);
        countryHeadOfStateCheck.setSelected(true);
        countryCapitalCheck.setSelected(true);
        countryCode2Check.setSelected(true);

        cityIDCheck.setSelected(true);
        cityNameCheck.setSelected(true);
        cityCodeCheck.setSelected(true);
        cityDistrictCheck.setSelected(true);
        cityPopulationCheck.setSelected(true);


        countryLCodeCheck.setSelected(true);
        countryLLanguageCheck.setSelected(true);
        countryLIsCheck.setSelected(true);
        countryLPercentageCheck.setSelected(true);


        northCentral.add(countryCodeCheck);
        northCentral.add(countryNameCheck);
        northCentral.add(countryContinentCheck);
        northCentral.add(countryRegionCheck);
        northCentral.add(countrySurfaceCheck);
        northCentral.add(countryYearCheck);
        northCentral.add(countryPopulationCheck);
        northCentral.add(countryLifeExpectancyCheck);
        northCentral.add(countryGNPCheck);
        northCentral.add(countryGNPOldCheck);
        northCentral.add(countryLocalNameCheck);
        northCentral.add(countryGovernmentFormCheck);
        northCentral.add(countryHeadOfStateCheck);
        northCentral.add(countryCapitalCheck);
        northCentral.add(countryCode2Check);

        centralCentral.add(cityIDCheck);
        centralCentral.add(cityNameCheck);
        centralCentral.add(cityCodeCheck);
        centralCentral.add(cityDistrictCheck);
        centralCentral.add(cityPopulationCheck);

        southCentral.add(countryLCodeCheck);
        southCentral.add(countryLLanguageCheck);
        southCentral.add(countryLIsCheck);
        southCentral.add(countryLPercentageCheck);

        JPanel panel = new JPanel();
        southP.add(panel,BorderLayout.SOUTH);
        columnSelectorButton.setFocusable(false);
        panel.add(columnSelectorButton);

        columnSelectorButton.addActionListener(e->{
            countryModel.setColumnCount(0);
            countryModel.setRowCount(0);
            try
            {
                countryQuery = report.reportCountry(countryCode.getSelectedItem(),countryName.getSelectedItem(),countryContinent.getSelectedItem(),countryRegion.getSelectedItem(),countrySurface.getText(),countrySurfaceUp.getText(),countryYear.getText(),countryYearUp.getText(),countryPopulation.getText(),countryPopulationUp.getText(),countryLifeExpectancy.getText(),countryLifeExpectancyUp.getText(),countryGNP.getText(),countryGNPUp.getText(),countryGNPOld.getText(),countryGNPOldUp.getText(),countryLocalName.getSelectedItem(),countryGovernmentForm.getSelectedItem(),countryHeadOfState.getSelectedItem(),countryCapital.getSelectedItem(),countryCode2.getSelectedItem(), cityID.getSelectedItem(),cityName.getSelectedItem(),cityCode.getSelectedItem(),cityDistrict.getSelectedItem(),cityPopulation.getText(),cityPopulationUp.getText(), countryLCode.getSelectedItem(), countryLLanguage.getSelectedItem(), countryLIsOfficial.getSelectedItem(), countryLPercentage.getText(),countryLPercentage.getText());
                System.out.println(countryQuery);
            }
            catch (NullPointerException a)
            {
                a.printStackTrace();
            }
            tableView();
            columnsFrame.dispatchEvent(new WindowEvent(reportFrame,WindowEvent.WINDOW_CLOSING));
        });
        columnsFrame.setVisible(true);


    }
    public void tableView()
    {
        JPanel panelSouth = new JPanel();

        tableFrame.setResizable(false);
        tableFrame.setSize(1275,450);
        tableFrame.setTitle("REPORT");
        tableFrame.setLayout(new BorderLayout());
        tableFrame.setIconImage(ico.getImage());
        tableFrame.setLocationRelativeTo(null);
        tableFrame.add(panelSouth,BorderLayout.SOUTH);
        panelSouth.add(exportButton);
        panelCenter.add(scroll);
        exportButton.setFocusable(false);
        exportButton.addActionListener(e-> {
            try {
                writeToExcel();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        panelCenter.setPreferredSize(new Dimension(100,100));
        panelCenter.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));

        tableFrame.add(panelCenter,BorderLayout.CENTER);

        scroll.setPreferredSize(new Dimension(1250,400));

        if(!countryQuery.equals("select * from country where"))
        {
            table.setModel(countryModel);
            for(int i = 0; i<fillCountryColumns().toArray().length;i++)
                countryModel.addColumn(fillCountryColumns().get(i));
            fillCountryData();
            tableFrame.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"INSERT MINIMUM ONE VALUE");
        }
    }
    public ArrayList<String> fillCountryColumns()
    {

        ArrayList<String> columns = new ArrayList<>();
        try {
            Statement countryStatement = con.createStatement();
            ResultSet countryRS = countryStatement.executeQuery(countryQuery);
            ResultSetMetaData countryRSMD = countryRS.getMetaData();
            for(int i=1;i<=countryRSMD.getColumnCount();i++)
            {
                columns.add(countryRSMD.getColumnName(i));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return columns;
    }
    public String[] fillCountryData()
    {
        String[] data = new String[fillCountryColumns().toArray().length];
        try {
            Statement countryStatement = con.createStatement();
            ResultSet countryRS = countryStatement.executeQuery(countryQuery);
            while (countryRS.next())
            {
                for(int i = 0; i<fillCountryColumns().toArray().length;i++)
                    data[i] = countryRS.getString(i + 1);
                countryModel.addRow(data);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return data;
    }
    public void writeToExcel() throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xls");

        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Save file");
        chooser.setAcceptAllFileFilterUsed(false);

        if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            String fileR = chooser.getSelectedFile().toString().concat(".xls");
            File file = new File(fileR);
            FileWriter out = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(out);
            for(int i =0;i<countryModel.getColumnCount();i++)
            {
                bw.write(countryModel.getColumnName(i)+"\t");
            }


            bw.write("\n");

            for(int i =0;i<countryModel.getRowCount();i++)
            {
                for(int j =0;j<countryModel.getColumnCount();j++)
                {
                    if(countryModel.getValueAt(i,j)!=null)
                    {
                        bw.write(countryModel.getValueAt(i,j).toString()+"\t");
                    }
                }
                bw.write("\n");
            }
            bw.close();

        }
    }

}
