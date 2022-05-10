import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Create
{
    private Connection con;

    public Create() {
        addToCountry();
    }

    public void addToCountry()
    {
        String addCountry = "INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2) VALUES ()";

        String countryData[];
        countryData = new String[15];

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(addCountry);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.setString(1, "hola");
            statement.setString(2, "hola");
            statement.setString(3, "hola");
            statement.setString(4, "hola");
            statement.setFloat(5, 12);
            statement.setInt(6, 21);
            statement.setInt(7, 124);
            statement.setFloat(8, 23);
            statement.setFloat(9, 234);
            statement.setFloat(10, 234);
            statement.setString(11, "hola");
            statement.setString(12, "hola");
            statement.setString(13, "hola");
            statement.setInt(14, 44);
            statement.setString(15, "hola");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addToCity()
    {
        String addCity = "INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES ()";

        String countryData[];
        countryData = new String[15];

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(addCity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.setString(1, "hola");
            statement.setString(2, "hola");
            statement.setString(3, "hola");
            statement.setString(4, "hola");
            statement.setString(5, "hola");
            statement.setString(6, "hola");
            statement.setString(7, "hola");
            statement.setString(8, "hola");
            statement.setString(9, "hola");
            statement.setString(10, "hola");
            statement.setString(11, "hola");
            statement.setString(12, "hola");
            statement.setString(13, "hola");
            statement.setString(14, "hola");
            statement.setString(15, "hola");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

