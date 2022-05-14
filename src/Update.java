import javax.swing.*;
import java.sql.*;

public class Update {

    private DataBase db = new DataBase();
    private Connection con = db.getConnection();
    public String updatedCountryCode, updatedCountryName, updatedCountryContinent, updatedCountryRegion, updatedCountryLocalName, updatedCountryGovernmentForm, updatedCountryHeadOfState, updatedCountryCode2;
    public int updatedCountryYear, updatedCountryPopulation, updatedCountryCapital;
    public String updatedCityName, updatedCityCode, updatedCityDistrict,updatedCityID;
    public int updatedCityPopulation;
    public String updatedCountryLCode, updatedCountryLLanguage, updatedCountryLIsOfficial;
    public float updatedCountryLPercentage;
    public float updatedCountrySurface, updatedCountryLifeExpectancy, updatedCountryGNP, updatedCountryGNPOld;
    private Tables tables;

    {
        try {
            tables = new Tables();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Update() throws SQLException {

    }

    public void updateInCountry()
    {
        String updateCountry = "UPDATE country SET Code=?, Name=?, Continent=?, Region=?, SurfaceArea=?, IndepYear=?, Population=?, LifeExpectancy=?, GNP=?, GNPOld=?, LocalName=?, GovernmentForm=?, HeadOfState=?, Capital=?, Code2=?";

        try {
            PreparedStatement statement = con.prepareStatement(updateCountry);
            statement.setString(1, updatedCountryCode);
            statement.setString(2, updatedCountryName);
            statement.setString(3, updatedCountryContinent);
            statement.setString(4, updatedCountryRegion);
            statement.setFloat(5, updatedCountrySurface);
            statement.setInt(6, updatedCountryYear);
            statement.setInt(7, updatedCountryPopulation);
            statement.setFloat(8, updatedCountryLifeExpectancy);
            statement.setFloat(9, updatedCountryGNP);
            statement.setFloat(10, updatedCountryGNPOld);
            statement.setString(11, updatedCountryLocalName);
            statement.setString(12, updatedCountryGovernmentForm);
            statement.setString(13, updatedCountryHeadOfState);
            statement.setInt(14, updatedCountryCapital);
            statement.setString(15, updatedCountryCode2);
            statement.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateInCity()
    {
        String updateCity = "UPDATE city SET ID=?, Name=?, CountryCode=?, District=?, Population=? where id = ?";

        try {
            PreparedStatement statement = con.prepareStatement(updateCity);
            statement.setInt(1, Integer.parseInt(updatedCityID));
            statement.setString(2, updatedCityName);
            statement.setString(3, updatedCityCode);
            statement.setString(4, updatedCityDistrict);
            statement.setInt(5, updatedCityPopulation);
            statement.setInt(6, Integer.parseInt(updatedCityID));
            statement.execute();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String[] updateCityFill(int cityID)
    {
        String fill = String.format("select * from city where id = %s",cityID);
        String[] data = new String[5];
        try {
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(fill);
            while(result.next())
            {
                data[0]=result.getString(1);
                data[1]=result.getString(2);
                data[2]=result.getString(3);
                data[3]=result.getString(4);
                data[4]=result.getString(5);
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void updateInCountryLanguage()
    {
        String updateCountryLanguage = "UPDATE countrylanguage SET CountryCode=?, Language=?, IsOfficial=?, Percentage=? where countryCode = ? and language = ?";

        try {
            PreparedStatement statement = con.prepareStatement(updateCountryLanguage);
            statement.setString(1, updatedCountryLCode);
            statement.setString(2, updatedCountryLLanguage);
            statement.setString(3, updatedCountryLIsOfficial);
            statement.setFloat(4, updatedCountryLPercentage);
            statement.setString(5, updatedCountryLCode);
            statement.setString(6, updatedCountryLLanguage);
            statement.execute();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String[] updateCountryLFill(String language, String code)
    {
        String fill = String.format("select * from countryLanguage where language = '%s' and countryCode = '%s'",language,code);
        String[] data = new String[4];
        try {
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(fill);
            while(result.next())
            {
                data[0]=result.getString(1);
                data[1]=result.getString(2);
                data[2]=result.getString(3);
                data[3]=result.getString(4);
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
