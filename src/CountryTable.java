import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryTable
{
    final JTable table = new JTable()
    {
        @Override
        public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
            if (convertColumnIndexToModel(columnIndex) != 0) {
                return;
            }
            super.changeSelection(rowIndex, columnIndex, toggle, extend);
        }
    };

    public CountryTable() throws ClassNotFoundException
    {
        DefaultTableModel model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("Code");
        model.addColumn("Name");
        model.addColumn("Continent");
        model.addColumn("Region");
        model.addColumn("SurfaceArea");
        model.addColumn("IndepYear");
        model.addColumn("Population");
        model.addColumn("LifeExpectancy");
        model.addColumn("GNP");
        model.addColumn("GNPOld");
        model.addColumn("LocalName");
        model.addColumn("GovernmentForm");
        model.addColumn("HeadOfState");
        model.addColumn("Capital");
        model.addColumn("Code2");

        table.setModel(model);
        String[] data = new String[15];


        try
        {
            DataBase db = new DataBase();
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

                model.addRow(data);
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setDragEnabled(false);
        table.setUpdateSelectionOnSort(false);
        table.getTableHeader().setReorderingAllowed(false);


        table.setVisible(true);
    }

    public JTable getTable() {
        return table;
    }

}
