package mainPackage;

import DataBase.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Marketing {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public int getMax() { // for max row
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(CampaignID) from marketing");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marketing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }
    
        public void getMaValues(JTable table, String searchValues) { // To show student details on the table
        String sql = "select * from marketing where concat (CampaignID, LeadID, CampaignName, Channel, Cost) like ? order by CampaignID desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValues + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[10];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getFloat(5);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marketing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
