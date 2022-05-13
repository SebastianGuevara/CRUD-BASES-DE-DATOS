import java.sql.*;

public class Delete
{
    private final DataBase db=new DataBase();
    public int cityCount;
    public String oldCountryCode;
    public int oldCityID;
    private final Connection con = db.getConnection();
    public Delete() throws SQLException {
        Statement idStatement = con.createStatement();
        ResultSet rs = idStatement.executeQuery("select id from city order by id desc limit 1;");
        rs.next();
        int count = rs.getInt(1);
        this.cityCount = count +1;
    }
    public void deleteFromCountry()
    {
        String deleteCountry = "delete FROM country WHERE Code=?";
        try
        {
            PreparedStatement statement = con.prepareStatement(deleteCountry);
            statement.setString(1, oldCountryCode);
            statement.execute();
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
            statement.setInt(1, 4080);
            statement.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void deleteFromCountryLanguage()
    {
        String deleteCountryLanguage = "delete from countryLanguage where Language=?";
        try
        {
            PreparedStatement statement = con.prepareStatement(deleteCountryLanguage);
            statement.setString(1, oldCountryCode);
            statement.execute();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
