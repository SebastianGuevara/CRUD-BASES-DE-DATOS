import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables
{
   // private final GUI gui = new GUI();
    public DataBase db;
    public DefaultTableModel cityModel = new DefaultTableModel()
    {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    {
        try {
            db = new DataBase();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos");
            //throwables.printStackTrace();
        }
    }

    final JTable cityTable = new JTable()
    {
        @Override
        public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
            if (convertColumnIndexToModel(columnIndex) != 0) {
                return;
            }
            super.changeSelection(rowIndex, columnIndex, toggle, extend);
        }
    };
    final JTable countryLTable = new JTable()
    {
        @Override
        public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
            if (convertColumnIndexToModel(columnIndex) != 0) {
                return;
            }
            super.changeSelection(rowIndex, columnIndex, toggle, extend);
        }
    };
    final JTable countryTable = new JTable()
    {
        @Override
        public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
            if (convertColumnIndexToModel(columnIndex) != 0) {
                return;
            }
            super.changeSelection(rowIndex, columnIndex, toggle, extend);
        }
    };

    public Tables() throws ClassNotFoundException {
        cityTableConfig();
        countryLanguagesTableConfig();
        countryTableConfig();
    }
    public void cityTableConfig()
    {

        cityModel.addColumn("ID");
        cityModel.addColumn("Name");
        cityModel.addColumn("CountryCode");
        cityModel.addColumn("District");
        cityModel.addColumn("Population");

        cityTable.setModel(cityModel);
        String[] data = new String[5];


        try
        {

            Connection con = db.getConnection();
            Statement st;
            st = con.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM city");

            while(result.next())
            {
                data[0]=result.getString(1);
                data[1]=result.getString(2);
                data[2]=result.getString(3);
                data[3]=result.getString(4);
                data[4]=result.getString(5);

                cityModel.addRow(data);
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        cityTable.setRowSelectionAllowed(false);
        cityTable.setCellSelectionEnabled(false);
        cityTable.setDragEnabled(false);
        cityTable.setUpdateSelectionOnSort(false);
        cityTable.getTableHeader().setReorderingAllowed(false);
        cityTable.getTableHeader().setResizingAllowed(false);

        cityTable.setVisible(true);
    }
    private final DefaultTableModel countryLananguageModel = new DefaultTableModel()
    {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public void countryLanguagesTableConfig()
    {
        countryLananguageModel.addColumn("CountryCode");
        countryLananguageModel.addColumn("Language");
        countryLananguageModel.addColumn("IsOfficial");
        countryLananguageModel.addColumn("Percentage");

        countryLTable.setModel(countryLananguageModel);
        String[] data = new String[4];
        try
        {
            Connection con = db.getConnection();
            Statement st;
            st = con.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM countryLanguage");

            while(result.next())
            {
                data[0]=result.getString(1);
                data[1]=result.getString(2);
                data[2]=result.getString(3);
                data[3]=result.getString(4);
                countryLananguageModel.addRow(data);
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        countryLTable.setRowSelectionAllowed(false);
        countryLTable.setCellSelectionEnabled(false);
        countryLTable.setDragEnabled(false);
        countryLTable.setUpdateSelectionOnSort(false);
        countryLTable.getTableHeader().setReorderingAllowed(false);
        countryLTable.getTableHeader().setResizingAllowed(false);
        countryLTable.setVisible(true);
    }
    DefaultTableModel countryModel = new DefaultTableModel()
    {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public void countryTableConfig()
    {
        countryModel.addColumn("Code");
        countryModel.addColumn("Name");
        countryModel.addColumn("Continent");
        countryModel.addColumn("Region");
        countryModel.addColumn("SurfaceArea");
        countryModel.addColumn("IndepYear");
        countryModel.addColumn("Population");
        countryModel.addColumn("LifeExpectancy");
        countryModel.addColumn("GNP");
        countryModel.addColumn("GNPOld");
        countryModel.addColumn("LocalName");
        countryModel.addColumn("GovernmentForm");
        countryModel.addColumn("HeadOfState");
        countryModel.addColumn("Capital");
        countryModel.addColumn("Code2");

        countryTable.setModel(countryModel);
        String[] data = new String[15];


        try
        {
            Connection con = db.getConnection();
            Statement st;
            st = con.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM country");

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

                countryModel.addRow(data);
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        countryTable.setRowSelectionAllowed(false);
        countryTable.setCellSelectionEnabled(false);
        countryTable.setDragEnabled(false);
        countryTable.setUpdateSelectionOnSort(false);
        countryTable.getTableHeader().setReorderingAllowed(false);
        getCountryTable().getTableHeader().setResizingAllowed(false);
        countryTable.getTableHeader().setResizingAllowed(false);


        countryTable.setVisible(true);
    }
    private void create()
    {
        //System.out.println(gui.newCityPopulation);
    }

    public JTable getCityTable() {
        return cityTable;
    }

    public JTable getCountryLTable() {
        return countryLTable;
    }

    public JTable getCountryTable() {
        return countryTable;
    }

    public DefaultTableModel getCityModel() {
        return cityModel;
    }

    public DefaultTableModel getCountryLananguageModel() {
        return countryLananguageModel;
    }
    public DefaultTableModel getCountryModel() {
        return countryModel;
    }
}
