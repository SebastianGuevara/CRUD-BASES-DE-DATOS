import java.sql.*;
import java.util.ArrayList;

public class Create
{
    //private Connection con;
    public int newCityPopulation;
    public String newCityName,newCityCode,newCityDistrict;
    public String newCountryLCode,newCountryLLanguage,newCountryLIsOfficial;
    public float newCountryLPercentage;
    public String newCountryCode,newCountryName,newCountryContinent,newCountryRegion,newCountryLocalName,newCountryGovernmentForm,newCountryHeadOfState,newCountryCode2;
    public float newCountrySurface,newCountryLifeExpectancy,newCountryGNP,newCountryGNPOld;
    public int newCountryYear,newCountryPopulation,newCountryCapital;
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
    public void addToCountry()
    {

        String addCountry = "INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(addCountry);
            statement.setString(1, newCountryCode);
            statement.setString(2, newCountryName);
            statement.setString(3, newCountryContinent);
            statement.setString(4, newCountryRegion);
            statement.setFloat(5, newCountrySurface);
            statement.setInt(6, newCountryYear);
            statement.setInt(7, newCountryPopulation);
            statement.setFloat(8, newCountryLifeExpectancy);
            statement.setFloat(9, newCountryGNP);
            statement.setFloat(10, newCountryGNPOld);
            statement.setString(11, newCountryLocalName);
            statement.setString(12, newCountryGovernmentForm);
            statement.setString(13, newCountryHeadOfState);
            statement.setInt(14, newCountryCapital);
            statement.setString(15, newCountryCode2);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
    public ArrayList fillCreateCombo()
    {
        String fill = "select code from country";
        String arrayCount = "select count(code) from country";
        ArrayList data = new ArrayList();
        data.add("");
        try
        {
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(fill);
            while(result.next())
            {
                data.add(result.getString("code"));
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }


}

