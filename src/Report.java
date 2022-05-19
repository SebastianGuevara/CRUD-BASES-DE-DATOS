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

    public void reportCountry(String code, String name, String continent, String region, String surfaceArea, String indepYear, String population, String lifeExpectancy,
    String GNP, String GNPOld, String localName, String governmentForm, String headOfState, String capital, String code2) {
        String searchCountry = "select * from country where";
        try {
            PreparedStatement statement = con.prepareStatement(searchCountry);
            if(code != null){
                searchCountry += (" code = '"+ code + "' ");
            }
            if (name != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" name = '"+ name + "' ");
                }
                else {
                    searchCountry += (" AND name = '"+ name + "' ");
                }
            }
            if (continent != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e')
                {
                    searchCountry += (" continent = '"+ continent + "' ");
                }
                else {
                    searchCountry += (" AND continent = '"+ continent + "' ");
                }
            }
            if (region != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" region = '" + region + "' ");
                } else {
                    searchCountry += (" AND region = '" + region + "' ");
                }
            }
            if (surfaceArea != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" surfaceArea = '"+ surfaceArea + "' ");
                }
                else {
                    searchCountry += (" AND surfaceArea = '"+ surfaceArea + "' ");
                }
            }
            if (indepYear != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" indepYear = '"+ indepYear + "' ");
                }
                else {
                    searchCountry += (" AND indepYear = '"+ indepYear + "' ");
                }
            }
            if (population != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" population = '"+ population + "' ");
                }
                else {
                    searchCountry += (" AND population = '"+ population + "' ");
                }
            }
            if (lifeExpectancy != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" lifeExpectancy = '"+ lifeExpectancy + "' ");
                }
                else {
                    searchCountry += (" AND lifeExpectancy = '"+ lifeExpectancy + "' ");
                }
            }
            if (GNP != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" GNP = '"+ GNP + "' ");
                }
                else {
                    searchCountry += (" AND GNP = '"+ GNP + "' ");
                }
            }
            if (GNPOld != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" GNPOld = '"+ GNPOld + "' ");
                }
                else {
                    searchCountry += (" AND GNPOld = '"+ GNPOld + "' ");
                }
            }
            if (localName != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" localName = '"+ localName + "' ");
                }
                else {
                    searchCountry += (" AND localName = '"+ localName + "' ");
                }
            }
            if (governmentForm != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" governmentForm = '"+ governmentForm + "' ");
                }
                else {
                    searchCountry += (" AND governmentForm = '"+ governmentForm + "' ");
                }
            }
            if (headOfState != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" headOfState = '" + headOfState + "' ");
                } else {
                    searchCountry += (" AND headOfState = '" + headOfState + "' ");
                }
            }
            if (capital != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" capital = '"+ capital + "' ");
                }
                else {
                    searchCountry += (" AND capital = '"+ capital + "' ");
                }
            }
            if (code2 != null){
                if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                    searchCountry += (" code2 = '"+ code2 + "' ");
                }
                else {
                    searchCountry += (" AND code2 = '"+ code2 + "' ");
                }
            }
            System.out.println(searchCountry);
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

    public void reportCity(String ID, String name, String code, String district, String population) {
        String searchCity = "select * from city where";
        try {
            PreparedStatement statement = con.prepareStatement(searchCity);
            if(ID != null){
                if(searchCity.charAt(searchCity.length()-1)=='e')
                {
                    searchCity += ("ID = '"+ ID + "' ");
                }
                else
                {
                    searchCity += (" ID = '"+ ID + "' ");
                }
            }
            if (name != null){
                if(searchCity.charAt(searchCity.length()-1)=='e')
                {
                    searchCity += (" cityName = '"+ name + "' ");
                }
                else
                {
                    searchCity += ("AND cityName = '"+ name + "' ");
                }
            }
            if (code != null){
                if(searchCity.charAt(searchCity.length()-1)=='e')
                {
                    searchCity += (" cityCountryCode = '"+ code + "' ");
                }
                else
                {
                    searchCity += ("AND cityCountryCode = '"+ code + "' ");
                }
            }
            if (district != null){
                if(searchCity.charAt(searchCity.length()-1)=='e')
                {
                    searchCity += (" district = '"+ district + "' ");
                }
                else
                {
                    searchCity += ("AND district = '"+ district + "' ");
                }
            }
            if (population !=  null){
                if(searchCity.charAt(searchCity.length()-1)=='e')
                {
                    searchCity += (" cityPopulation = '"+ population + "' ");
                }
                else
                {
                    searchCity += ("AND cityPopulation = '"+ population + "' ");
                }

            }
            System.out.println(searchCity);

            //statement.setString(1,searchCity);
            //statement.execute();
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

    public void reportCountryLanguage(String countryCode, String language, String isOfficial, String percentage) {
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
            if (percentage != null){
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
