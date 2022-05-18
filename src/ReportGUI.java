import documents.MyComboBoxRenderer;
import javax.swing.*;
import java.awt.*;

public class ReportGUI
{
    private final JFrame reportFrame = new JFrame();
    private final JPanel mainReportPanel = new JPanel();
    private final JPanel northPanel = new JPanel();
    private final JPanel southPanel = new JPanel();
    private final JPanel centralPanel = new JPanel();

    //CheckBoxes
    private final JCheckBox countryCheckbox = new JCheckBox("Country");
    private final JCheckBox cityCheckbox = new JCheckBox("City");
    private final JCheckBox countryLanguageCheckbox = new JCheckBox("Country Language");

    ImageIcon ico = new ImageIcon("src/log.png");
    
    public ReportGUI()
    {
        reportFrame.setResizable(false);
        reportFrame.setSize(400,325);
        reportFrame.setTitle("REPORT");
        reportFrame.setLayout(new BorderLayout());
        reportFrame.setIconImage(ico.getImage());
        reportFrame.setVisible(false);
        reportFrame.setLocationRelativeTo(null);
        reportFrame.add(mainReportPanel,BorderLayout.CENTER);
    }
    public void mainSetup()
    {
        mainReportPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(100,60));


        mainReportPanel.add(northPanel,BorderLayout.NORTH);
        mainReportPanel.add(centralPanel,BorderLayout.CENTER);
        mainReportPanel.add(southPanel,BorderLayout.SOUTH);


        //NorthPanel config
        JPanel northNorthPanel = new JPanel();
        JPanel northSouthPanel = new JPanel();
        JLabel selectCheckbox = new JLabel("Select tables you want to use");
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

        //South panel config
        JButton enterButton = new JButton("Generate report");
        enterButton.setFocusable(false);
        southPanel.add(enterButton);
        enterButton.addActionListener(e->
        {

        });

        //Central panel config
        centralPanel.setLayout(new BoxLayout(centralPanel,BoxLayout.Y_AXIS));
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

        centralPanel.add(countryCentralPanel);
        centralPanel.add(cityCentralPanel);
        centralPanel.add(countryLCentralPanel);

        countryCentralPanel.setLayout(new BorderLayout());
        cityCentralPanel.setLayout(new BorderLayout());
        countryLCentralPanel.setLayout(new BorderLayout());


        countryPanel.setLayout(new FlowLayout());
        cityPanel.setLayout(new FlowLayout());
        countryLPanel.setLayout(new FlowLayout());
        countryCentralPanel.setVisible(false);
        cityCentralPanel.setVisible(false);
        countryLCentralPanel.setVisible(false);

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

        countryCode.setPreferredSize(new Dimension(120,20));
        countryCode.setRenderer(new MyComboBoxRenderer("Code"));
        countryName.setPreferredSize(new Dimension(120,20));
        countryName.setRenderer(new MyComboBoxRenderer("Name"));
        countryContinent.setPreferredSize(new Dimension(120,20));
        countryContinent.setRenderer(new MyComboBoxRenderer("Continent"));
        countryRegion.setPreferredSize(new Dimension(120,20));
        countryRegion.setRenderer(new MyComboBoxRenderer("Region"));
        countrySurface.setPreferredSize(new Dimension(120,20));
        countrySurface.setRenderer(new MyComboBoxRenderer("Surface"));
        countryYear.setPreferredSize(new Dimension(120,20));
        countryYear.setRenderer(new MyComboBoxRenderer("Independation Year"));
        countryPopulation.setPreferredSize(new Dimension(120,20));
        countryPopulation.setRenderer(new MyComboBoxRenderer("Population"));
        countryLifeExpectancy.setPreferredSize(new Dimension(120,20));
        countryLifeExpectancy.setRenderer(new MyComboBoxRenderer("Life Expectancy"));
        countryGNP.setPreferredSize(new Dimension(120,20));
        countryGNP.setRenderer(new MyComboBoxRenderer("GNP"));
        countryGNPOld.setPreferredSize(new Dimension(120,20));
        countryGNPOld.setRenderer(new MyComboBoxRenderer("Old GNP"));
        countryLocalName.setPreferredSize(new Dimension(120,20));
        countryLocalName.setRenderer(new MyComboBoxRenderer("Local Name"));
        countryGovernmentForm.setPreferredSize(new Dimension(120,20));
        countryGovernmentForm.setRenderer(new MyComboBoxRenderer("Government Form"));
        countryHeadOfState.setPreferredSize(new Dimension(120,20));
        countryHeadOfState.setRenderer(new MyComboBoxRenderer("Head of State"));
        countryCapital.setPreferredSize(new Dimension(120,20));
        countryCapital.setRenderer(new MyComboBoxRenderer("Capital"));
        countryCode2.setPreferredSize(new Dimension(120,20));
        countryCode2.setRenderer(new MyComboBoxRenderer("Code"));

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



        //CITY COMBO QUERY CONFIG
        JComboBox<String> cityID = new JComboBox<>();
        JComboBox<String> cityName = new JComboBox<>();
        JComboBox<String> cityCode = new JComboBox<>();
        JComboBox<String> cityDistrict = new JComboBox<>();
        JComboBox<String> cityPopulation = new JComboBox<>();

        cityID.setPreferredSize(new Dimension(120,20));
        cityID.setRenderer(new MyComboBoxRenderer("ID"));
        cityName.setPreferredSize(new Dimension(120,20));
        cityName.setRenderer(new MyComboBoxRenderer("Name"));
        cityCode.setPreferredSize(new Dimension(120,20));
        cityCode.setRenderer(new MyComboBoxRenderer("Country Code"));
        cityDistrict.setPreferredSize(new Dimension(120,20));
        cityDistrict.setRenderer(new MyComboBoxRenderer("District"));
        cityPopulation.setPreferredSize(new Dimension(120,20));
        cityPopulation.setRenderer(new MyComboBoxRenderer("Population"));


        cityPanel.add(cityID);
        cityPanel.add(cityName);
        cityPanel.add(cityCode);
        cityPanel.add(cityDistrict);
        cityPanel.add(cityPopulation);

        //COUNTRY LANGUEGA QUERY MENU
        JComboBox<String> countryLCode = new JComboBox<>();
        JComboBox<String> countryLLanguage = new JComboBox<>();
        JComboBox<String> countryLIsOfficial = new JComboBox<>();
        JComboBox<String> countryLPercentage = new JComboBox<>();

        countryLCode.setPreferredSize(new Dimension(120,20));
        countryLCode.setRenderer(new MyComboBoxRenderer("Country Code"));
        countryLLanguage.setPreferredSize(new Dimension(120,20));
        countryLLanguage.setRenderer(new MyComboBoxRenderer("Language"));
        countryLIsOfficial.setPreferredSize(new Dimension(120,20));
        countryLIsOfficial.setRenderer(new MyComboBoxRenderer("Is official?"));
        countryLPercentage.setPreferredSize(new Dimension(120,20));
        countryLPercentage.setRenderer(new MyComboBoxRenderer("Percentage"));

        countryLPanel.add(countryLCode);
        countryLPanel.add(countryLLanguage);
        countryLPanel.add(countryLIsOfficial);
        countryLPanel.add(countryLPercentage);

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
        enterButton.addActionListener(e->{
            System.out.println(reportFrame.getSize());
        });











        reportFrame.setVisible(true);
    }

}
