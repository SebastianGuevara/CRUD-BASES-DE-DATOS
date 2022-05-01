import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CityTable
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

    public CityTable() throws ClassNotFoundException
    {
        DefaultTableModel model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("CountryCode");
        model.addColumn("District");
        model.addColumn("Population");

        table.setModel(model);
        String[] data = new String[5];


        try
        {
            DataBase db = new DataBase();
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
