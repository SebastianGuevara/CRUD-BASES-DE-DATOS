import javax.swing.*;
import java.sql.*;

public class Update {

    Main main = new Main();
    private Connection con = main.db.getConnection();
    public String updatedCountryCode, updatedCountryName, updatedCountryContinent, updatedCountryRegion, updatedCountryLocalName, updatedCountryGovernmentForm, updatedCountryHeadOfState, updatedCountryCode2;
    public int updatedCountryYear, updatedCountryPopulation, updatedCountryCapital;
    public String updatedCityName, updatedCityCode, updatedCityDistrict,updatedCityID;
    public int updatedCityPopulation;
    public String updatedCountryLCode, updatedCountryLLanguage, updatedCountryLIsOfficial;
    public float updatedCountryLPercentage;
    public float updatedCountrySurface, updatedCountryLifeExpectancy, updatedCountryGNP, updatedCountryGNPOld;
    public Update() throws SQLException, ClassNotFoundException {

    }

    public void updateInCountry()
    {
        String updateCountry = "UPDATE country SET Code=?, Name=?, Continent=?, Region=?, SurfaceArea=?, IndepYear=?, Population=?, LifeExpectancy=?, GNP=?, GNPOld=?, LocalName=?, GovernmentForm=?, HeadOfState=?, Capital=?, Code2=? where code=?";

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
            statement.setString(16, updatedCountryCode);
            statement.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String[] updateCountryFill(String code)
    {
        String fill = String.format("select * from country where code ='%s'",code);
        String[] data = new String[15];
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
                data[5]=result.getString(6);
                data[6]=result.getString(7);
                data[7]=result.getString(8);
                data[8]=result.getString(9);
                data[9]=result.getString(10);
                data[10]=result.getString(11);
                data[11]=result.getString(12);
                data[12]=result.getString(13);
                data[13]=result.getString(14);
                data[14]=result.getString(15);
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
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
