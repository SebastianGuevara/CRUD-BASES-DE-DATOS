import documents.MyComboBoxRenderer;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;

public class ReportGUI
{
    private JFrame reportFrame = new JFrame();
    private JPanel mainReportPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel centralPanel = new JPanel();

    //CheckBoxes
    private JCheckBox countryCheckbox = new JCheckBox("Country");
    private JCheckBox cityCheckbox = new JCheckBox("City");
    private JCheckBox countryLanguageCheckbox = new JCheckBox("Country Language");

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
        JPanel cityPanel = new JPanel();
        JPanel countryLPanel = new JPanel();
        countryPanel.setBackground(Color.red);
        countryLPanel.setBackground(Color.black);
        centralPanel.add(countryPanel);
        centralPanel.add(cityPanel);
        centralPanel.add(countryLPanel);
        countryPanel.setLayout(new FlowLayout());
        cityPanel.setLayout(new FlowLayout());
        countryLPanel.setLayout(new FlowLayout());
        countryPanel.setVisible(false);
        cityPanel.setVisible(false);
        countryLPanel.setVisible(false);

        //CITY COMBO QUERY CONFIG
        JComboBox<String> cityID = new JComboBox<>();
        JComboBox<String> cityName = new JComboBox<>();
        JComboBox<String> cityCode = new JComboBox<>();
        JComboBox<String> cityDistrict = new JComboBox<>();
        JComboBox<Integer> cityPopulation = new JComboBox<>();

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
                countryPanel.setVisible(true);
            }
            else
            {
                countryPanel.setVisible(false);
            }
        });
        cityCheckbox.addActionListener(e->
        {
            if(cityCheckbox.isSelected())
            {
                cityPanel.setVisible(true);
                reportFrame.setSize(660,325);
            }
            else
            {
                cityPanel.setVisible(false);
            }
        });
        countryLanguageCheckbox.addActionListener(e->
        {
            if(countryLanguageCheckbox.isSelected())
            {
                countryLPanel.setVisible(true);
                reportFrame.setSize(550,325);
            }
            else
            {
                countryLPanel.setVisible(false);
            }
        });











        reportFrame.setVisible(true);
    }

}
