import java.sql.*;

public class Create
{
    //private Connection con;
    public int newCityPopulation;
    public String newCityName,newCityCode,newCityDistrict;
    public String newCountryLCode,newCountryLLanguage,newCountryLIsOfficial;
    public float newCountryLPercentage;
    private Tables tables;
    public int cityCount;
    {
        try {
            tables = new Tables();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection con = tables.db.getConnection();

    public Create() throws SQLException {
        Statement idStatement = con.createStatement();
        ResultSet rs = idStatement.executeQuery("select id from city order by id desc limit 1;");
        rs.next();
        int count = rs.getInt(1);
        this.cityCount = count +1;
    }

    /*
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
*/
    public void addToCity()
    {
        String addCity = "INSERT INTO city (ID, Name, CountryCode, District, Population) VALUES (?,?,?,?,?)";
        try {

            PreparedStatement statement = con.prepareStatement(addCity);
            statement.setInt(1, this.cityCount);
            statement.setString(2, newCityName);
            statement.setString(3, newCityCode);
            statement.setString(4, newCityDistrict);
            statement.setInt(5, newCityPopulation);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addToCityLanguage()
    {
        String addCountryLanguage = "INSERT INTO countryLanguage (CountryCode, Language, IsOfficial, Percentage) VALUES (?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(addCountryLanguage);
            statement.setString(1, newCountryLCode);
            statement.setString(2, newCountryLLanguage);
            statement.setString(3, newCountryLIsOfficial);
            statement.setFloat(4, newCountryLPercentage);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

