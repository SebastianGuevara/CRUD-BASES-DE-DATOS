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
    public char[] columnsChar = new char[1];
    private String searchColumns = "";
    private String searchCountry = "";
    private final Main main = new Main();


    public Report() throws SQLException, ClassNotFoundException {
        Statement idStatement = con.createStatement();
        ResultSet rs = idStatement.executeQuery("select id from city order by id desc limit 1;");
        rs.next();
        int count = rs.getInt(1);
        this.cityCount = count +1;
    }

    public String reportCountry(Object code, Object name, Object continent, Object region, Object surfaceArea, Object indepYear, Object population, Object lifeExpectancy,
    Object GNP, Object GNPOld, Object localName, Object governmentForm, Object headOfState, Object capital, Object code2) {
        selectColumns();
        if(code != null){
            searchCountry += (" c.code = '"+ code + "' ");
        }
        if (name != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.name = '"+ name + "' ");
            }
            else {
                searchCountry += (" AND c.name = '"+ name + "' ");
            }
        }
        if (continent != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e')
            {
                searchCountry += (" c.continent = '"+ continent + "' ");
            }
            else {
                searchCountry += (" AND c.continent = '"+ continent + "' ");
            }
        }
        if (region != null) {
            if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                searchCountry += (" c.region = '" + region + "' ");
            } else {
                searchCountry += (" AND c.region = '" + region + "' ");
            }
        }
        if (surfaceArea != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.surfaceArea = '"+ surfaceArea + "' ");
            }
            else {
                searchCountry += (" AND c.surfaceArea = '"+ surfaceArea + "' ");
            }
        }
        if (indepYear != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.indepYear = '"+ indepYear + "' ");
            }
            else {
                searchCountry += (" AND c.indepYear = '"+ indepYear + "' ");
            }
        }
        if (population != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.population = '"+ population + "' ");
            }
            else {
                searchCountry += (" AND c.population = '"+ population + "' ");
            }
        }
        if (lifeExpectancy != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.lifeExpectancy = '"+ lifeExpectancy + "' ");
            }
            else {
                searchCountry += (" AND c.lifeExpectancy = '"+ lifeExpectancy + "' ");
            }
        }
        if (GNP != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.GNP = '"+ GNP + "' ");
            }
            else {
                searchCountry += (" AND c.GNP = '"+ GNP + "' ");
            }
        }
        if (GNPOld != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.GNPOld = '"+ GNPOld + "' ");
            }
            else {
                searchCountry += (" AND c.GNPOld = '"+ GNPOld + "' ");
            }
        }
        if (localName != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.localName = '"+ localName + "' ");
            }
            else {
                searchCountry += (" AND c.localName = '"+ localName + "' ");
            }
        }
        if (governmentForm != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.governmentForm = '"+ governmentForm + "' ");
            }
            else {
                searchCountry += (" AND c.governmentForm = '"+ governmentForm + "' ");
            }
        }
        if (headOfState != null) {
            if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                searchCountry += (" c.headOfState = '" + headOfState + "' ");
            } else {
                searchCountry += (" AND c.headOfState = '" + headOfState + "' ");
            }
        }
        if (capital != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.capital = '"+ capital + "' ");
            }
            else {
                searchCountry += (" AND c.capital = '"+ capital + "' ");
            }
        }
        if (code2 != null){
            if(searchCountry.charAt(searchCountry.length()-1) == 'e') {
                searchCountry += (" c.code2 = '"+ code2 + "' ");
            }
            else {
                searchCountry += (" AND c.code2 = '"+ code2 + "' ");
            }
        }

        return searchCountry;

    }
    public void selectColumns()
    {
        searchColumns = "select ";
        if(main.getGUI().getReportGUI().countryCodeCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.code ");
            }
            else
            {
                searchColumns += (",c.code ");
            }
        }
        if(main.getGUI().getReportGUI().countryNameCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.name ");
            }
            else
            {
                searchColumns += (",c.name ");
            }
        }
        if(main.getGUI().getReportGUI().countryContinentCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.continent ");
            }
            else
            {
                searchColumns += (",c.continent ");
            }
        }
        if(main.getGUI().getReportGUI().countryRegionCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-1)=='t')
            {
                searchColumns += ("c.region ");
            }
            else
            {
                searchColumns += (",c.region ");
            }
        }
        if(main.getGUI().getReportGUI().countrySurfaceCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.surfaceArea ");
            }
            else
            {
                searchColumns += (",c.surfaceArea ");
            }
        }
        if(main.getGUI().getReportGUI().countryYearCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.IndepYear ");
            }
            else
            {
                searchColumns += (",c.IndepYear ");
            }
        }
        if(main.getGUI().getReportGUI().countryPopulationCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.population ");
            }
            else
            {
                searchColumns += (",c.population ");
            }
        }
        if(main.getGUI().getReportGUI().countryLifeExpectancyCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.LifeExpectancy ");
            }
            else
            {
                searchColumns += (",c.LifeExpectancy ");
            }
        }
        if(main.getGUI().getReportGUI().countryGNPCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.GNP ");
            }
            else
            {
                searchColumns += (",c.GNP ");
            }
        }
        if(main.getGUI().getReportGUI().countryGNPOldCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.GNPOld ");
            }
            else
            {
                searchColumns += (",c.GNPOld ");
            }
        }
        if(main.getGUI().getReportGUI().countryLocalNameCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.LocalName ");
            }
            else
            {
                searchColumns += (",c.LocalName ");
            }
        }
        if(main.getGUI().getReportGUI().countryGovernmentFormCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.GovernmentForm ");
            }
            else
            {
                searchColumns += (",c.GovernmentForm ");
            }
        }
        if(main.getGUI().getReportGUI().countryHeadOfStateCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.HeadOfState ");
            }
            else
            {
                searchColumns += (",c.HeadOfState ");
            }
        }
        if(main.getGUI().getReportGUI().countryCapitalCheck.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.Capital ");
            }
            else
            {
                searchColumns += (",c.Capital ");
            }
        }
        if(main.getGUI().getReportGUI().countryCode2Check.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-2)=='t')
            {
                searchColumns += ("c.Code2 ");
            }
            else
            {
                searchColumns += (",c.Code2 ");
            }
        }

        searchColumns += ("from");
        if(main.getGUI().getReportGUI().countryCheckbox.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-1)=='m')
            {
                searchColumns += (" country as c");
            }
            else
            {
                searchColumns += (" ,country as c");
            }
        }
        if(main.getGUI().getReportGUI().cityCheckbox.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-1)=='m')
            {
                searchColumns += (" city as ci");
            }
            else
            {
                searchColumns += (" ,city as ci");
            }
        }
        if(main.getGUI().getReportGUI().countryLanguageCheckbox.isSelected())
        {
            if(searchColumns.charAt(searchColumns.length()-1)=='m')
            {
                searchColumns += (" countryLanguage as cl");
            }
            else
            {
                searchColumns += (" ,countryLanguage as cl");
            }
        }

        searchColumns += " where";
        searchCountry = searchColumns;

    }


    public ArrayList<String> fillComboBoxCountryCode() {
        String query = "select code from country order by code";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryName() {
        String query = "select name from country order by name";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryContinent() {
        String query = "select continent from country group by continent order by continent";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryRegion() {
        String query = "select region from country group by region order by region";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountrySurface() {
        String query = "select surfaceArea from country order by surfaceArea";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryYear() {
        String query = "select IndepYear from country group by IndepYear order by IndepYear";
        ArrayList<String> data = new ArrayList<>();
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
    public ArrayList<String> fillComboBoxCountryPopulation() {
        String query = "select population from country group by population order by population";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryLifeExpectancy() {
        String query = "select LifeExpectancy from country order by LifeExpectancy";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryGNP() {
        String query = "select GNP from country group by GNP order by GNP";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryGNPOld() {
        String query = "select GNPOld from country group by GNPOld order by GNPOld";
        ArrayList data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryLocalName() {
        String query = "select LocalName from country group by LocalName order by LocalName";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryGovernmentForm() {
        String query = "select GovernmentForm from country group by GovernmentForm order by GovernmentForm";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryHeadOfState() {
        String query = "select HeadOfState from country group by HeadOfState order by HeadOfState";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryCapital() {
        String query = "select capital from country group by capital order by capital";
        ArrayList<String> data = new ArrayList<>();

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
    public ArrayList<String> fillComboBoxCountryCode2() {
        String query = "select code2 from country order by code2";
        ArrayList<String> data = new ArrayList<>();

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
                searchCity += ("ID = '"+ ID + "' ");
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
        String searchCountryLanguage = "select * from countryLanguage where";
        try {
            PreparedStatement statement = con.prepareStatement(searchCountryLanguage);
            if(countryCode != null){
                searchCountryLanguage += (" countryCode = '"+ countryCode + "' ");
            }
            if (language != null){
                if(searchCountryLanguage.charAt(searchCountryLanguage.length()-1)=='e')
                {
                    searchCountryLanguage += (" language = '"+ language + "' ");
                }
                else
                {
                    searchCountryLanguage += ("AND language = '"+ language + "' ");
                }

            }
            if (isOfficial != null){
                if(searchCountryLanguage.charAt(searchCountryLanguage.length()-1)=='e')
                {
                    searchCountryLanguage += (" isOfficial = '"+ isOfficial + "' ");
                }
                else
                {
                    searchCountryLanguage += ("AND language = '"+ language + "' ");
                }

            }
            if (percentage != null){
                if(searchCountryLanguage.charAt(searchCountryLanguage.length()-1)=='e')
                {
                    searchCountryLanguage += (" percentage = '"+ percentage + "' ");
                }
                else
                {
                    searchCountryLanguage += ("AND percentage = '"+ percentage + "' ");
                }

            }
            System.out.println(searchCountryLanguage);

            //statement.setString(1,searchCountryLanguage);
            //statement.execute();
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
