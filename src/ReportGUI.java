import documents.MyComboBoxRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;
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
    private final JCheckBox countryCheckbox = new JCheckBox("Country");
    private final JCheckBox cityCheckbox = new JCheckBox("City");
    private final JCheckBox countryLanguageCheckbox = new JCheckBox("Country Language");

    //COUNTRY COMBO QUERY CONFIG
    JComboBox<String> countryCode = new JComboBox<>();
    JComboBox<String> countryName = new JComboBox<>();
    JComboBox<String> countryContinent = new JComboBox<>();
    JComboBox<String> countryRegion = new JComboBox<>();
    JComboBox<String> countrySurface = new JComboBox<>();
    JComboBox<String> countryYear = new JComboBox<>();
    JComboBox<String> countryPopulation= new JComboBox<>();
    JComboBox<String> countryLifeExpectancy= new JComboBox<>();
    JComboBox<String> countryGNP = new JComboBox<>();
    JComboBox<String> countryGNPOld= new JComboBox<>();
    JComboBox<String> countryLocalName = new JComboBox<>();
    JComboBox<String> countryGovernmentForm = new JComboBox<>();
    JComboBox<String> countryHeadOfState = new JComboBox<>();
    JComboBox<String> countryCapital = new JComboBox<>();
    JComboBox<String> countryCode2= new JComboBox<>();
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
    JComboBox<String> cityPopulation = new JComboBox<>();
    DefaultComboBoxModel fillCityID = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityName = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityCode = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityDistrict = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCityPopulation= new DefaultComboBoxModel();

    //COUNTRY LANGUEGA QUERY MENU
    JComboBox<String> countryLCode = new JComboBox<>();
    JComboBox<String> countryLLanguage = new JComboBox<>();
    JComboBox<String> countryLIsOfficial = new JComboBox<>();
    JComboBox<String> countryLPercentage = new JComboBox<>();
    DefaultComboBoxModel fillCountryLCode= new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLLanguage = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLIsOfficial = new DefaultComboBoxModel();
    DefaultComboBoxModel fillCountryLPercentage= new DefaultComboBoxModel();

    JPanel northNorthPanel = new JPanel();
    JPanel northSouthPanel = new JPanel();
    JLabel selectCheckbox = new JLabel("Select tables you want to use");
    JButton enterButton = new JButton("Generate report");

    JFrame tableFrame = new JFrame();
    JPanel panelCenter = new JPanel();
    DefaultTableModel countryModel = new DefaultTableModel();
    JTable table = new JTable();
    JScrollPane scroll = new JScrollPane(table);
    String countryQuery = "sss";


    ImageIcon ico = new ImageIcon("src/log.png");
    
    public ReportGUI() throws SQLException {
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
            try
            {
                System.out.println(report.reportCountry(countryCode.getSelectedItem().toString(),countryName.getSelectedItem().toString(),countryContinent.getSelectedItem().toString(),countryRegion.getSelectedItem().toString(),countrySurface.getSelectedItem().toString(),countryName.getSelectedItem().toString(),countryYear.getSelectedItem().toString(),countryPopulation.getSelectedItem().toString(),countryLifeExpectancy.getSelectedItem().toString(),countryGNP.getSelectedItem().toString(),countryGNPOld.getSelectedItem().toString(),countryLocalName.getSelectedItem().toString(),countryGovernmentForm.getSelectedItem().toString(),countryHeadOfState.getSelectedItem().toString(),countryName.getSelectedItem().toString()));
                //countryQuery = report.reportCountry(countryCode.getSelectedItem().toString(),countryName.getSelectedItem().toString(),countryContinent.getSelectedItem().toString(),countryRegion.getSelectedItem().toString(),countrySurface.getSelectedItem().toString(),countryName.getSelectedItem().toString(),countryYear.getSelectedItem().toString(),countryPopulation.getSelectedItem().toString(),countryLifeExpectancy.getSelectedItem().toString(),countryGNP.getSelectedItem().toString(),countryGNPOld.getSelectedItem().toString(),countryLocalName.getSelectedItem().toString(),countryGovernmentForm.getSelectedItem().toString(),countryHeadOfState.getSelectedItem().toString(),countryName.getSelectedItem().toString());
            }
            catch (NullPointerException a)
            {
                a.printStackTrace();
            }

            tableView();
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
        centralPanel.setLayout(new BoxLayout(centralPanel,BoxLayout.Y_AXIS));

        centralPanel.add(countryCentralPanel);
        centralPanel.add(cityCentralPanel);
        centralPanel.add(countryLCentralPanel);

        countryCentralPanel.setLayout(new BorderLayout());
        cityCentralPanel.setLayout(new BorderLayout());
        countryLCentralPanel.setLayout(new BorderLayout());

        countryPanel.setLayout(new FlowLayout());
        cityPanel.setLayout(new FlowLayout());
        countryLPanel.setLayout(new FlowLayout());


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
        countrySurface.setPreferredSize(new Dimension(120,20));
        countrySurface.setRenderer(new MyComboBoxRenderer("Surface"));
        countrySurface.setModel(fillCountrySurface);
        fillCountrySurface.addAll(report.fillComboBoxCountrySurface());
        countryYear.setPreferredSize(new Dimension(120,20));
        countryYear.setRenderer(new MyComboBoxRenderer("Independation Year"));
        countryYear.setModel(fillCountryYear);
        fillCountryYear.addAll(report.fillComboBoxCountryYear());
        countryPopulation.setPreferredSize(new Dimension(120,20));
        countryPopulation.setRenderer(new MyComboBoxRenderer("Population"));
        countryPopulation.setModel(fillCountryPopulation);
        fillCountryPopulation.addAll(report.fillComboBoxCountryPopulation());
        countryLifeExpectancy.setPreferredSize(new Dimension(120,20));
        countryLifeExpectancy.setRenderer(new MyComboBoxRenderer("Life Expectancy"));
        countryLifeExpectancy.setModel(fillCountryLifeExpectancy);
        fillCountryLifeExpectancy.addAll(report.fillComboBoxCountryLifeExpectancy());
        countryGNP.setPreferredSize(new Dimension(120,20));
        countryGNP.setRenderer(new MyComboBoxRenderer("GNP"));
        countryGNP.setModel(fillCountryGNP);
        fillCountryGNP.addAll(report.fillComboBoxCountryGNP());
        countryGNPOld.setPreferredSize(new Dimension(120,20));
        countryGNPOld.setRenderer(new MyComboBoxRenderer("Old GNP"));
        countryGNPOld.setModel(fillCountryGNPOld);
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

        countryPanel.add(countryCode);
        countryPanel.add(countryName);
        countryPanel.add(countryContinent);
        countryPanel.add(countryRegion);
        countryPanel.add(countrySurface);
        countryPanel.add(countryYear);
        countryPanel.add(countryPopulation);
        countryPanel.add(countryLifeExpectancy);
        countryPanel.add(countryGNP);
        countryPanel.add(countryGNPOld);
        countryPanel.add(countryLocalName);
        countryPanel.add(countryGovernmentForm);
        countryPanel.add(countryHeadOfState);
        countryPanel.add(countryCapital);
        countryPanel.add(countryCode2);

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
        cityPopulation.setPreferredSize(new Dimension(120,20));
        cityPopulation.setRenderer(new MyComboBoxRenderer("Population"));
        cityPopulation.setModel(fillCityPopulation);
        fillCityPopulation.addAll(report.fillComboBoxCityPopulation());

        cityPanel.add(cityID);
        cityPanel.add(cityName);
        cityPanel.add(cityCode);
        cityPanel.add(cityDistrict);
        cityPanel.add(cityPopulation);

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
        countryLPercentage.setPreferredSize(new Dimension(120,20));
        countryLPercentage.setRenderer(new MyComboBoxRenderer("Percentage"));
        countryLPercentage.setModel(fillCountryLPercentage);
        fillCountryLPercentage.addAll(report.fillComboBoxCountryLPercentage());

        countryLPanel.add(countryLCode);
        countryLPanel.add(countryLLanguage);
        countryLPanel.add(countryLIsOfficial);
        countryLPanel.add(countryLPercentage);
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
        fillCountryName.addAll(report.fillComboBoxCountryCode());
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
        fillCountryGNPOld.addAll(report.fillComboBoxCountryGNP());
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
                reportFrame.setSize(660,325);
                if(countryCheckbox.isSelected()&&cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(658,355);
                }
                else if(countryCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(658,332);
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
                reportFrame.setSize(660,325);
                if(countryCheckbox.isSelected()&&cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(658,355);
                }
                else if(cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(658,325);
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
                reportFrame.setSize(550,325);
                if(countryCheckbox.isSelected()&&cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(658,355);
                }
                else if(countryCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(658,332);
                }
                else if(cityCheckbox.isSelected()&&countryLanguageCheckbox.isSelected())
                {
                    reportFrame.setSize(658,325);
                }
            }
            else
            {
                countryLCentralPanel.setVisible(false);
            }
        });

        reportFrame.setVisible(true);
    }
    public void tableView()
    {

        tableFrame.setResizable(false);
        tableFrame.setSize(1300,750);
        tableFrame.setTitle("REPORT");
        tableFrame.setLayout(new BorderLayout());
        tableFrame.setIconImage(ico.getImage());
        tableFrame.setLocationRelativeTo(null);
        panelCenter.add(scroll);

        panelCenter.setPreferredSize(new Dimension(100,100));
        panelCenter.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));

        tableFrame.add(panelCenter,BorderLayout.CENTER);
        //.add(panelNorth,BorderLayout.NORTH);
        //tableFrame.add(panelSouth,BorderLayout.SOUTH);
        //tableFrame.add(panelEast,BorderLayout.EAST);
        //tableFrame.add(panelWest,BorderLayout.WEST);

        scroll.setPreferredSize(new Dimension(1300,750));

        table.setModel(countryModel);
        for(int i = 0; i<fillCountryColumns().toArray().length;i++)
            countryModel.addColumn(fillCountryColumns().get(i));
        fillCountryData();

        tableFrame.setVisible(true);
    }
    public ArrayList<String> fillCountryColumns()
    {

        ArrayList<String> columns = new ArrayList<>();
        /*
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

         */

        return columns;
    }
    public String[] fillCountryData()
    {
        String[] data = new String[fillCountryColumns().toArray().length];
        /*
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

         */
        return data;
    }

}
