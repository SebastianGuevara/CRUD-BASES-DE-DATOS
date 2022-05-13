import javax.swing.*;
import java.sql.*;

public class Update {

    private DataBase db = new DataBase();
    private Connection con = db.getConnection();
    public String updatedCountryCode, updatedCountryName, updatedCountryContinent, updatedCountryRegion, updatedCountryLocalName, updatedCountryGovernmentForm, updatedCountryHeadOfState, updatedCountryCode2;
    public int updatedCountryYear, updatedCountryPopulation, updatedCountryCapital;
    public String updatedCityName, updatedCityCode, updatedCityDistrict;
    public int updatedCityPopulation;
    public String updatedCountryLCode, updatedCountryLLanguage, updatedCountryLIsOfficial;
    public int updatedCountryLPercentage;
    public float updatedCountrySurface, updatedCountryLifeExpectancy, updatedCountryGNP, updatedCountryGNPOld;
    private Tables tables;

    public int cityCount;
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

            int countryRowsUpdated = statement.executeUpdate();

            if(countryRowsUpdated > 0) {
                JOptionPane.showMessageDialog(null,"Country updated succesfully!");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateInCity()
    {
        String updateCity = "UPDATE city SET ID=?, Name=?, CountryCode=?, District=?, Population=?";

        try {
            PreparedStatement statement = con.prepareStatement(updateCity);
            statement.setInt(1, this.cityCount);
            statement.setString(2, updatedCityName);
            statement.setString(3, updatedCityCode);
            statement.setString(4, updatedCityDistrict);
            statement.setInt(5, updatedCityPopulation);

            int cityRowsUpdated = statement.executeUpdate();

            if(cityRowsUpdated > 0) {
                JOptionPane.showMessageDialog(null,"Country updated succesfully!");
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateInCountryLanguage()
    {
        String updateCountryLanguage = "UPDATE countrylanguage SET CountryCode=?, Language=?, IsOfficial=?, Percentage=?";

        try {
            PreparedStatement statement = con.prepareStatement(updateCountryLanguage);
            statement.setString(1, updatedCountryLCode);
            statement.setString(2, updatedCountryLLanguage);
            statement.setString(3, updatedCountryLIsOfficial);
            statement.setFloat(4, updatedCountryLPercentage);

            int countryLRowsUpdated = statement.executeUpdate();

            if(countryLRowsUpdated > 0) {
                JOptionPane.showMessageDialog(null,"Country updated succesfully!");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
