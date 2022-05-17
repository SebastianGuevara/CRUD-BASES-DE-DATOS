import javax.swing.*;
import java.sql.SQLException;

public class DeleteGUI
{
    private String tableSelection = "";
    private int countrySelector,citySelector,countryLSelector;
    private final Delete delete = new Delete();
    private Main main = new Main();
    public String oldCityID,oldCountryCode,oldCountryLLanguage,oldCountryLCode;
    public DeleteGUI() throws SQLException, ClassNotFoundException {

    }
    public void setTableSelection(String tableSelection) {
        this.tableSelection = tableSelection;
    }
    public void deleteSelector()
    {
        int deleteSelectorPane = JOptionPane.YES_NO_OPTION;
        switch (tableSelection) {
            case "country" -> {
                do {
                    oldCountryCode = JOptionPane.showInputDialog("ENTER COUNTRY CODE TO REMOVE");
                    if (oldCountryCode.matches("^[a-zA-Z]*$"))
                    {
                        if(oldCountryCode.length()!=3)
                        {
                            JOptionPane.showMessageDialog(null,"COUNTRY CODE ONLY CONTAINS 3 CHARACTERS");
                        }
                        else
                        {
                            delete.setOldCountryCode(oldCountryCode);
                            countrySelector = JOptionPane.showConfirmDialog(null,"ARE YOU SURE THAT YOU WANT TO DELETE THAT COUNTRY?","WARNING",deleteSelectorPane);
                        }
                    } else
                    {
                        JOptionPane.showMessageDialog(null,"COUNTRY CODE ONLY CONTAINS LETTERS");
                    }
                } while (!oldCountryCode.matches("^[a-zA-Z]*$")||oldCountryCode.length()!=3);
                if(countrySelector==0)
                {
                    delete.deleteFromCountry();
                }
            }
            case "city" -> {
                do {
                    oldCityID = JOptionPane.showInputDialog("ENTER CITY ID TO REMOVE");
                    if (oldCityID.matches("^[0-9]*$"))
                    {
                        delete.setOldCityID(Integer.parseInt(oldCityID));
                        citySelector = JOptionPane.showConfirmDialog(null,"ARE YOU SURE THAT YOU WANT TO DELETE THAT CITY?","WARNING",deleteSelectorPane);
                    } else
                    {
                        JOptionPane.showMessageDialog(null,"CITY ID ONLY CONTAINS NUMBERS");
                    }
                } while (!oldCityID.matches("^[0-9]*$"));
                if(citySelector==0)
                {
                    delete.deleteFromCity();
                    //main.getGUI().getTables().cityModel.removeRow();
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
                            "DELETE COUNTRY LANGUAGE",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    if (result == JOptionPane.OK_OPTION)
                    {
                        delete.setOldCountryLCode(xField.getText());
                        delete.setOldCountryLLanguage(yField.getText());
                        oldCountryLCode = xField.getText();
                        oldCountryLLanguage = yField.getText();
                    }
                    if (oldCountryLLanguage.length()>30)
                    {
                        JOptionPane.showMessageDialog(null,"LANGUAGES HAVE A MAXIMUM OF CHARACTERS OF 30");
                    }
                    else if (oldCountryLCode.length()>3)
                    {
                        JOptionPane.showMessageDialog(null,"COUNTRY CODE HAVE A MAXIMUM OF CHARACTERS OF 3");
                    }
                } while (oldCountryLLanguage.length()>30||oldCountryLCode.length()>3);
                countryLSelector = JOptionPane.showConfirmDialog(null,"ARE YOU SURE THAT YOU WANT TO DELETE THAT CITY?","WARNING",deleteSelectorPane);
                if(countryLSelector==0)
                {
                    delete.deleteFromCountryLanguage();
                }


            }
            default -> JOptionPane.showMessageDialog(null, "SELECT A TABLE");
        }
    }

    public String getOldCityID() {
        return oldCityID;
    }
}
