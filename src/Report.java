import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Report {

    private final Main main = new Main();
    private final Connection con = main.db.getConnection();
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



    public Report() throws SQLException, ClassNotFoundException {
        Statement idStatement = con.createStatement();
        ResultSet rs = idStatement.executeQuery("select id from city order by id desc limit 1;");
        rs.next();
        int count = rs.getInt(1);
        this.cityCount = count +1;
    }

    boolean test = false;


    public String reportCountry(Object code, Object name, Object continent, Object region,Object surfaceAreaLow,Object surfaceAreaHigh, Object indepYearLow, Object indepYearHigh, Object populationLow, Object populationHigh, Object lifeExpectancyLow, Object lifeExpectancyHigh,
                                Object GNPLow, Object GNPHigh, Object GNPOldLow, Object GNPOldHigh, Object localName, Object governmentForm, Object headOfState, Object capital, Object code2, Object cityID, Object cityName, Object cityCode, Object cityDistrict,
                                Object cityPopulationLow, Object cityPopulationHigh, Object clCode, Object clLanguage, Object clIsOfficial, Object clPercentageLow, Object clPercentageHigh) {
        if(capital=="CityID")
        {
            this.test=true;
        }
        selectColumns();
        if(!(code == null&&name==null&&continent==null&&region==null&&surfaceAreaLow==null&&surfaceAreaHigh==null&&indepYearLow==null&&indepYearHigh==null&&populationLow==null&&
                populationHigh==null&&lifeExpectancyLow==null&&lifeExpectancyHigh==null&&GNPLow==null&&GNPHigh==null&&GNPOldLow==null&&GNPOldHigh==null&&localName==null&&governmentForm==null&&headOfState==null&&capital==null&&code2==null&&
                cityCode==null&&cityID==null&&cityName==null&&cityDistrict==null&&cityPopulationLow==null&&cityPopulationHigh==null&&clCode==null&&clLanguage==null&&clIsOfficial==null&&clPercentageLow==null&&clPercentageHigh==null))
        {
            searchColumns += " where";
        }

        searchCountry = searchColumns;
        if(main.getGUI().getReportGUI().countryCheckbox.isSelected()) {

            if (code != null) {
                if (code == "City Country Code")
                {
                    searchCountry += " c.code = ci.countryCode";
                }
                else if (code == "Country Language Country Code")
                {
                    searchCountry += " c.code = cl.countryCode";
                }
                else
                {
                    searchCountry += (" c.code = '" + code + "' ");
                }
            }
            if (name != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.name = '" + name + "' ");
                } else {
                    searchCountry += (" AND c.name = '" + name + "' ");
                }
            }
            if (continent != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.continent = '" + continent + "' ");
                } else {
                    searchCountry += (" AND c.continent = '" + continent + "' ");
                }
            }
            if (region != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.region = '" + region + "' ");
                } else {
                    searchCountry += (" AND c.region = '" + region + "' ");
                }
            }
            if (!(Objects.equals(surfaceAreaLow,"") && Objects.equals(surfaceAreaHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.surfaceArea >=" + surfaceAreaLow +" AND c.surfaceArea <= " + surfaceAreaHigh + " ");
                } else {
                    searchCountry += (" AND c.surfaceArea >=" + surfaceAreaLow +" AND c.surfaceArea <= " + surfaceAreaHigh + " ");
                }
            }
            if (!(Objects.equals(indepYearLow,"") && Objects.equals(indepYearHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.indepYear >=" + indepYearLow +" AND c.indepYear <= " + indepYearHigh + " ");
                } else {
                    searchCountry += (" AND c.indepYear >=" + indepYearLow +" AND c.indepYear <= " + indepYearHigh + " ");
                }
            }
            if (!(Objects.equals(populationLow,"") && Objects.equals(populationHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.population >=" + populationLow +" AND c.population <= " + populationHigh + " ");
                } else {
                    searchCountry += (" AND c.population >=" + populationLow +" AND c.population <= " + populationHigh + " ");
                }
            }
            if (!(Objects.equals(lifeExpectancyLow,"") && Objects.equals(lifeExpectancyHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.lifeExpectancy >=" + lifeExpectancyLow +" AND c.lifeExpectancy <= " + lifeExpectancyHigh + " ");
                } else {
                    searchCountry += (" AND c.lifeExpectancy >=" + lifeExpectancyLow +" AND c.lifeExpectancy <= " + lifeExpectancyHigh + " ");
                }
            }
            if (!(Objects.equals(GNPLow,"") && Objects.equals(GNPHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.GNP >=" + GNPLow +" AND c.GNP <= " + GNPHigh + " ");
                } else {
                    searchCountry += (" AND c.GNP >=" + GNPLow +" AND c.GNP <= " + GNPHigh + " ");
                }
            }
            if (!(Objects.equals(GNPOldLow,"") && Objects.equals(GNPOldHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.GNPOld >=" + GNPOldLow +" AND c.GNPOld <= " + GNPOldHigh + " ");
                } else {
                    searchCountry += (" AND c.GNPOld >=" + GNPOldLow +" AND c.GNPOld <= " + GNPOldHigh + " ");
                }
            }
            if (localName != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.localName = '" + localName + "' ");
                } else {
                    searchCountry += (" AND c.localName = '" + localName + "' ");
                }
            }
            if (governmentForm != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.governmentForm = '" + governmentForm + "' ");
                } else {
                    searchCountry += (" AND c.governmentForm = '" + governmentForm + "' ");
                }
            }
            if (headOfState != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.headOfState = '" + headOfState + "' ");
                } else {
                    searchCountry += (" AND c.headOfState = '" + headOfState + "' ");
                }
            }
            if (capital != null) {
                if (capital == "City ID")
                {
                    if (searchCountry.charAt(searchCountry.length() - 2) == 'e') {
                        searchCountry += (" c.capital = ci.id");
                    } else {
                        searchCountry += (" AND c.capital = ci.id");
                    }
                }
                else
                {
                    if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                        searchCountry += (" c.capital = '" + capital + "' ");
                    } else {
                        searchCountry += (" AND c.capital = '" + capital + "' ");
                    }
                }

            }
            if (code2 != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" c.code2 = '" + code2 + "' ");
                } else {
                    searchCountry += (" AND c.code2 = '" + code2 + "' ");
                }
            }
        }

        if(main.getGUI().getReportGUI().cityCheckbox.isSelected()) {
            if (cityID != null) {

                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += ("ci.ID = '" + cityID + "' ");
                } else {
                    searchCountry += (" AND ci.ID = '" + cityID + "' ");
                }

            }
            if (cityName != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" ci.name = '" + cityName + "' ");
                } else {
                    searchCountry += ("AND ci.name = '" + cityName + "' ");
                }
            }
            if (cityCode != null) {
                if (cityCode == "Country Code")
                {
                    searchCountry += " c.code = ci.countryCode";
                }
                else if (cityCode == "Country Language Country Code")
                {
                    if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                        searchCountry += (" ci.countryCode = '" + cityCode + "' ");
                    } else {
                        searchCountry += ("AND ci.countryCode = '" + cityCode + "' ");
                    }
                }
                else
                {
                    if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                        searchCountry += (" ci.countryCode = '" + cityCode + "' ");
                    } else {
                        searchCountry += ("AND ci.countryCode = '" + cityCode + "' ");
                    }
                }
            }
            if (cityDistrict != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" ci.district = '" + cityDistrict + "' ");
                } else {
                    searchCountry += ("AND ci.district = '" + cityDistrict + "' ");
                }
            }
            if (!(Objects.equals(cityPopulationLow,"") && Objects.equals(cityPopulationHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" ci.population >=" + cityPopulationLow +" AND ci.population <= " + cityPopulationHigh + " ");
                } else {
                    searchCountry += ("AND ci.population >=" + cityPopulationLow +" AND ci.population <= " + cityPopulationHigh + " ");
                }
            }
        }
        if(main.getGUI().getReportGUI().countryLanguageCheckbox.isSelected()) {

            if (clCode != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" cl.countryCode = '" + clCode + "' ");
                } else {
                    searchCountry += ("AND cl.countryCode = '" + clCode + "' ");
                }
            }
            if (clLanguage != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" cl.language = '" + clLanguage + "' ");
                } else {
                    searchCountry += ("AND cl.language = '" + clLanguage + "' ");
                }
            }
            if (clIsOfficial != null) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" cl.isOfficial = '" + clIsOfficial + "' ");
                } else {
                    searchCountry += ("AND cl.isOfficial = '" + clIsOfficial + "' ");
                }
            }
            if (!(Objects.equals(clPercentageLow,"") && Objects.equals(clPercentageHigh,""))) {
                if (searchCountry.charAt(searchCountry.length() - 1) == 'e') {
                    searchCountry += (" cl.percentage >=" + clPercentageLow +" AND cl.percentage <= " + clPercentageHigh + " ");
                } else {
                    searchCountry += ("AND cl.percentage >=" + clPercentageLow +" AND cl.percentage <= " + clPercentageHigh + " ");
                }
            }
        }

        return searchCountry;
    }
    public void selectColumns()
    {
        searchColumns = "select ";
        if(main.getGUI().getReportGUI().countryCheckbox.isSelected()) {


            if (main.getGUI().getReportGUI().countryCodeCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.code ");
                } else {
                    searchColumns += (",c.code ");
                }
            }
            if (main.getGUI().getReportGUI().countryNameCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.name ");
                } else {
                    searchColumns += (",c.name ");
                }
            }
            if (main.getGUI().getReportGUI().countryContinentCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.continent ");
                } else {
                    searchColumns += (",c.continent ");
                }
            }
            if (main.getGUI().getReportGUI().countryRegionCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 1) == 't') {
                    searchColumns += ("c.region ");
                } else {
                    searchColumns += (",c.region ");
                }
            }
            if (main.getGUI().getReportGUI().countrySurfaceCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.surfaceArea ");
                } else {
                    searchColumns += (",c.surfaceArea ");
                }
            }
            if (main.getGUI().getReportGUI().countryYearCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.IndepYear ");
                } else {
                    searchColumns += (",c.IndepYear ");
                }
            }
            if (main.getGUI().getReportGUI().countryPopulationCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.population ");
                } else {
                    searchColumns += (",c.population ");
                }
            }
            if (main.getGUI().getReportGUI().countryLifeExpectancyCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.LifeExpectancy ");
                } else {
                    searchColumns += (",c.LifeExpectancy ");
                }
            }
            if (main.getGUI().getReportGUI().countryGNPCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.GNP ");
                } else {
                    searchColumns += (",c.GNP ");
                }
            }
            if (main.getGUI().getReportGUI().countryGNPOldCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.GNPOld ");
                } else {
                    searchColumns += (",c.GNPOld ");
                }
            }
            if (main.getGUI().getReportGUI().countryLocalNameCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.LocalName ");
                } else {
                    searchColumns += (",c.LocalName ");
                }
            }
            if (main.getGUI().getReportGUI().countryGovernmentFormCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.GovernmentForm ");
                } else {
                    searchColumns += (",c.GovernmentForm ");
                }
            }
            if (main.getGUI().getReportGUI().countryHeadOfStateCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.HeadOfState ");
                } else {
                    searchColumns += (",c.HeadOfState ");
                }
            }
            if (main.getGUI().getReportGUI().countryCapitalCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.Capital ");
                } else {
                    searchColumns += (",c.Capital ");
                }
            }
            if (main.getGUI().getReportGUI().countryCode2Check.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("c.Code2 ");
                } else {
                    searchColumns += (",c.Code2 ");
                }
            }
        }
        if(main.getGUI().getReportGUI().cityCheckbox.isSelected()) {


            if (main.getGUI().getReportGUI().cityIDCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("ci.id ");
                } else {
                    searchColumns += (",ci.id ");
                }
            }
            if (main.getGUI().getReportGUI().cityNameCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("ci.name ");
                } else {
                    searchColumns += (",ci.name ");
                }
            }
            if (main.getGUI().getReportGUI().cityCodeCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("ci.countryCode ");
                } else {
                    searchColumns += (",ci.countryCode ");
                }
            }
            if (main.getGUI().getReportGUI().cityDistrictCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("ci.district ");
                } else {
                    searchColumns += (",ci.district ");
                }
            }
            if (main.getGUI().getReportGUI().cityPopulationCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 1) == 't') {
                    searchColumns += ("ci.population ");
                } else {
                    searchColumns += (",ci.population ");
                }
            }
        }
        if(main.getGUI().getReportGUI().countryLanguageCheckbox.isSelected()) {
            if (main.getGUI().getReportGUI().countryLCodeCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("cl.countryCode ");
                } else {
                    searchColumns += (",cl.countryCode ");
                }
            }
            if (main.getGUI().getReportGUI().countryLLanguageCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("cl.language ");
                } else {
                    searchColumns += (",cl.language ");
                }
            }
            if (main.getGUI().getReportGUI().countryLIsCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("cl.isOfficial ");
                } else {
                    searchColumns += (",cl.isOfficial ");
                }
            }
            if (main.getGUI().getReportGUI().countryLPercentageCheck.isSelected()) {
                if (searchColumns.charAt(searchColumns.length() - 2) == 't') {
                    searchColumns += ("cl.percentage ");
                } else {
                    searchColumns += (",cl.percentage ");
                }
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

        if((main.getGUI().getReportGUI().cityCheckbox.isSelected())||test)
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

    }


    public ArrayList<String> fillComboBoxCountryCode() {
        String query = "select code from country group by code order by code";
        ArrayList<String> data = new ArrayList<>();
        data.add("City Country Code");
        data.add("Country Language Country Code");

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
        String query = "select name from country group by name order by name";
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
        String query = "select surfaceArea from country group by surfaceArea order by surfaceArea";
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
        String query = "select LifeExpectancy from country group by LifeExpectancy order by LifeExpectancy";
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

        data.add("City ID");

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
        String query = "select code2 from country group by code2 order by code2";
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

    public ArrayList fillComboBoxCityID() {
        String query = "select id from city group by id order by id";
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
        String query = "select name from city group by name order by name";
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
        String query = "select countryCode from city group by countryCode order by countryCode";
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
        String query = "select population from city group by population order by population";
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

    public ArrayList fillComboBoxCountryLCode() {
        String query = "select countryCode from countryLanguage group by countryCode order by countryCode";
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
        ArrayList data = new ArrayList();
        data.add("T");
        data.add("F");
        return data;
    }
    public ArrayList fillComboBoxCountryLLanguage() {
        String query = "select language from countryLanguage group by language order by language";
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
