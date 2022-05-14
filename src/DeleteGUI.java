import javax.swing.*;
import java.sql.SQLException;

public class DeleteGUI
{
    private String tableSelection = "";
    private int countrySelector,citySelector,countryLSelector;
    private final Delete delete = new Delete();
    public String oldCityID,oldCountryCode,oldCountryLLanguage;
    public DeleteGUI() throws SQLException {

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
                }
            }
            case "countryL" -> {
                do {
                    oldCountryLLanguage = JOptionPane.showInputDialog("ENTER LANGUAGE TO REMOVE");
                    if(oldCountryLLanguage.length()<30)
                    {
                        delete.setOldCountryLLanguage(oldCountryLLanguage);
                        citySelector = JOptionPane.showConfirmDialog(null,"ARE YOU SURE THAT YOU WANT TO DELETE THAT COUNTRY LANGUAGE?","WARNING",deleteSelectorPane);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"LANGUAGES HAVE A MAXIMUM OF CHARACTERS OF 30");
                    }
                } while (oldCountryLLanguage.length()>30);
                if(citySelector==0)
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
