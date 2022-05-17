import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Delete
{
    private final DataBase db=new DataBase();
    private Main main = new Main();


    //deleteGUI deleteGUI = new deleteGUI();
    public int cityCount;
    public String oldCountryCode,oldCountryLLanguage,oldCountryLCode;
    public int oldCityID;
    private final Connection con = db.getConnection();
    public Delete() throws SQLException, ClassNotFoundException {
        Statement idStatement = con.createStatement();
        ResultSet rs = idStatement.executeQuery("select id from city order by id desc limit 1;");
        rs.next();
        int count = rs.getInt(1);
        this.cityCount = count +1;
    }

    public void deleteFromCountry()
    {
        String deleteCountry = "delete FROM country WHERE Code=?";
        String countryCheck = String.format("select count(code) from country where code = '%s'",oldCountryCode);
        try
        {
            PreparedStatement statement = con.prepareStatement(deleteCountry);
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(countryCheck);
            while(result.next())
            {
                if(result.getInt("count(code)")==1)
                {
                    statement.setString(1, oldCountryCode);
                    statement.execute();
                    JOptionPane.showMessageDialog(null,"COUNTRY REMOVED SUCCESSFULLY");
                    main.getGUI().getTables().getCountryModel().setRowCount(0);
                    main.getGUI().getTables().getCountryModel().setColumnCount(0);
                    main.getGUI().getTables().countryTableConfig();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"THAT COUNTRY DOESN'T EXISTS");
                }
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void deleteFromCity()
    {
        String deleteCity = "delete FROM city where ID=?";
        try
        {
            PreparedStatement statement = con.prepareStatement(deleteCity);
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery("select count(id) from city where id ="+oldCityID+";");
            while(result.next())
            {
                if(result.getInt("count(id)")==1)
                {
                    statement.setInt(1, oldCityID);
                    statement.execute();
                    JOptionPane.showMessageDialog(null,"CITY REMOVED SUCCESSFULLY");
                    main.getGUI().getTables().cityModel.setRowCount(0);
                    main.getGUI().getTables().cityModel.setColumnCount(0);
                    main.getGUI().getTables().cityTableConfig();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"THAT CITY DOESN'T EXISTS");
                }
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void deleteFromCountryLanguage()
    {

        String deleteCountryLanguage = "delete from countryLanguage where Language=?";
        String countryLCheck = String.format("select count(language) from countryLanguage where language = '%s' and countryCode = '%s'",oldCountryLLanguage,oldCountryLCode);
        try
        {
            PreparedStatement statement = con.prepareStatement(deleteCountryLanguage);
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(countryLCheck);
            while(result.next())
            {
                if(result.getInt("count(language)")==1)
                {
                    statement.setString(1, oldCountryLLanguage);
                    statement.execute();
                    JOptionPane.showMessageDialog(null,"COUNTRY LANGUAGE REMOVED SUCCESSFULLY");
                    main.getGUI().getTables().getCountryLananguageModel().setRowCount(0);
                    main.getGUI().getTables().getCountryLananguageModel().setColumnCount(0);
                    main.getGUI().getTables().countryLanguagesTableConfig();
                }
                else
                {
                    System.out.println(oldCountryLLanguage);
                    System.out.println(oldCountryLCode);
                    JOptionPane.showMessageDialog(null,"THAT COUNTRY LANGUAGE DOESN'T EXISTS");
                }
            }


        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setOldCityID(int oldCityID) {
        this.oldCityID = oldCityID;
    }

    public void setOldCountryCode(String oldCountryCode) {
        this.oldCountryCode = oldCountryCode;
    }

    public void setOldCountryLLanguage(String oldCountryLLanguage) {
        this.oldCountryLLanguage = oldCountryLLanguage;
    }

    public void setOldCountryLCode(String oldCountryLCode) {
        this.oldCountryLCode = oldCountryLCode;
    }
}
