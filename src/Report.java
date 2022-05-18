import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class Report {
    private final DataBase db= new DataBase();
    private final Connection con = db.getConnection();
    public int cityCount;
    public String  localName, governmentForm, headOfState, code2;
    public int indepYear, population, capital;
    public float surfaceArea, lifeExpectancy, GNP, GNPOld;
    public int ID, cityPopulation;
    public String cityName, cityCountryCode, district;
    public String countryCode, language, isOfficial;
    public float percentage;

    public Report() throws SQLException {
        Statement idStatement = con.createStatement();
        ResultSet rs = idStatement.executeQuery("select id from city order by id desc limit 1;");
        rs.next();
        int count = rs.getInt(1);
        this.cityCount = count +1;
    }

    public void reportCountry(String code, String name, String continent, String region) {
        String searchCountry = "select * from country where";
        char lastChar = searchCountry.charAt(searchCountry.length()-1);
        try {
            PreparedStatement statement = con.prepareStatement(searchCountry);
            if(code != null){
                searchCountry += (" code = '"+ code + "' ");
            }
            if (name != null){
                if(lastChar == 'e') {
                    searchCountry += (" name = '"+ name + "' ");
                }
                else {
                    searchCountry += ("AND name = '"+ name + "'");
                }
            }
            if (continent != null){
                if(lastChar == 'e') {
                    searchCountry += (" continent = '"+ continent + "' ");
                }
                else {
                    searchCountry += ("AND continent = '"+ continent + "' ");
                }
            }
            if (region != null){
                if(lastChar == 'e') {
                    searchCountry += (" region = '"+ region + "' ");
                }
                else {
                    searchCountry += ("AND region = '"+ region + "' ");
                }
            }
            System.out.println(searchCountry);

            if (surfaceArea != 0){
                searchCountry += ("surfaceArea = '"+ surfaceArea + "'");
            }
            if (indepYear != 0){
                searchCountry += ("indepYear = '"+ indepYear + "'");
            }
            if (population != 0){
                searchCountry += ("population = '"+ population + "'");
            }
            if (lifeExpectancy != 0){
                searchCountry += ("lifeExpectancy = '"+ lifeExpectancy + "'");
            }
            if (GNP != 0){
                searchCountry += ("GNP = '"+ GNP + "'");
            }
            if (GNPOld != 0){
                searchCountry += ("GNPOld = '"+ GNPOld + "'");
            }
            if (localName != null){
                searchCountry += ("localName = '"+ localName + "'");
            }
            if (governmentForm != null){
                searchCountry += ("governmentForm = '"+ governmentForm + "'");
            }
            if (headOfState != null){
                searchCountry += ("headOfState = '"+ headOfState + "'");
            }
            if (lifeExpectancy != 0){
                searchCountry += ("lifeExpectancy = '"+ lifeExpectancy + "'");
            }
            if (capital != 0){
                searchCountry += ("capital = '"+ capital + "'");
            }
            if (code2 != null){
                searchCountry += ("code2 = '"+ code2 + "'");
            }
            //statement.setString(1,searchCountry);
            //statement.execute();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList fillComboBoxCountryCode() {
        String query = "select code from country order by code";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryName() {
        String query = "select name from country order by name";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryContinent() {
        String query = "select continent from country group by continent order by continent";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryRegion() {
        String query = "select region from country group by region order by region";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountrySurface() {
        String query = "select surfaceArea from country order by surfaceArea";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryYear() {
        String query = "select IndepYear from country group by IndepYear order by IndepYear";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString(1)!=null)
                    data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryPopulation() {
        String query = "select population from country group by population order by population";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryLifeExpectancy() {
        String query = "select LifeExpectancy from country order by LifeExpectancy";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString(1)!=null)
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryGNP() {
        String query = "select GNP from country group by GNP order by GNP";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryGNPOld() {
        String query = "select GNPOld from country group by GNPOld order by GNPOld";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString(1)!=null)
                    data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryLocalName() {
        String query = "select LocalName from country group by LocalName order by LocalName";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryGovernmentForm() {
        String query = "select GovernmentForm from country group by GovernmentForm order by GovernmentForm";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryHeadOfState() {
        String query = "select HeadOfState from country group by HeadOfState order by HeadOfState";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString(1)!=null)
                    data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryCapital() {
        String query = "select capital from country group by capital order by capital";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString(1)!=null)
                    data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryCode2() {
        String query = "select code2 from country order by code2";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }

    public void reportCity() {
        String searchCity = "select * from city where ";
        try {
            PreparedStatement statement = con.prepareStatement(searchCity);
            if(ID != 0){
                searchCity += ("ID = '"+ ID + "'");
            }
            if (cityName != null){
                searchCity += ("cityName = '"+ cityName + "'");
            }
            if (cityCountryCode != null){
                searchCity += ("cityCountryCode = '"+ cityCountryCode + "'");
            }
            if (district != null){
                searchCity += ("district = '"+ district + "'");
            }
            if (cityPopulation != 0){
                searchCity += ("cityPopulation = '"+ cityPopulation + "'");
            }

            statement.setString(1,searchCity);
            statement.execute();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList fillComboBoxCityID() {
        String query = "select id from city order by id";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCityName() {
        String query = "select name from city order by name";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCityCode() {
        String query = "select countryCode from city order by countryCode";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCityDistrict() {
        String query = "select district from city group by district order by district";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCityPopulation() {
        String query = "select population from city order by population";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }

    public void reportCountryLanguage() {
        String searchCountryLanguage = "select * from countryLanguage where ";
        try {
            PreparedStatement statement = con.prepareStatement(searchCountryLanguage);
            if(countryCode != null){
                searchCountryLanguage += ("countryCode = '"+ countryCode + "'");
            }
            if (language != null){
                searchCountryLanguage += ("language = '"+ language + "'");
            }
            if (isOfficial != null){
                searchCountryLanguage += ("isOfficial = '"+ isOfficial + "'");
            }
            if (percentage != 0){
                searchCountryLanguage += ("percentage = '"+ percentage + "'");
            }

            statement.setString(1,searchCountryLanguage);
            statement.execute();
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList fillComboBoxCountryLCode() {
        String query = "select countryCode from countryLanguage order by countryCode";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryLOfficial() {
        String query = "select countryCode from countryLanguage order by countryCode";
        ArrayList data = new ArrayList();
        data.add("T");
        data.add("F");
        return data;
    }
    public ArrayList fillComboBoxCountryLLanguage() {
        String query = "select language from countryLanguage order by language";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
    public ArrayList fillComboBoxCountryLPercentage()
    {
        String query = "select percentage from countryLanguage group by percentage order by percentage";
        ArrayList data = new ArrayList();

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                data.add(rs.getString(1));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }

}
