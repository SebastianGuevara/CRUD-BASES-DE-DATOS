import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryLanguageTable
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

    public CountryLanguageTable() throws ClassNotFoundException
    {
        DefaultTableModel model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("CountryCode");
        model.addColumn("Language");
        model.addColumn("IsOfficial");
        model.addColumn("Percentage");

        table.setModel(model);
        String[] data = new String[4];


        try
        {
            DataBase db = new DataBase();
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
