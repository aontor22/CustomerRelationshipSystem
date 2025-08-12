package mainPackage;

import DataBase.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Leads {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public int getMax() { // for max row
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(LeadID) from leads");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Leads.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }
    
    
    public void insert(int lid, String lname, String cnid, String status, String source, String cra) {

        String sql = "insert into leads values(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, lid);
            ps.setString(2, lname);
            ps.setString(3, cnid);
            ps.setString(4, status);
            ps.setString(5, source);
            ps.setString(6, cra);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showConfirmDialog(null, "Lead added successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Leads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isLIDExist(int id) { // When same id exists
        try {
            ps = con.prepareStatement("select * from leads where LeadID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Leads.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void getLeadsValues(JTable table, String searchValues) { // To show student details on the table
        String sql = "select * from leads where concat (LeadID, Lead_name, ContactID, Status, Source, created_at) like ? order by LeadID desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValues + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[10];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Leads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateLeads(int lid, String lname, String cnid, String status, String source) {

        String sql = "update leads set Lead_name = ?, ContactID = ?, Status = ?, Source = ? where LeadID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, lname);
            ps.setString(2, cnid);
            ps.setString(3, status);
            ps.setString(4,source);
            ps.setInt(5, lid);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Lead data updated successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Leads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteLeads(int id) {
        int yesNo = JOptionPane.showConfirmDialog(null, "All the information of this Lead will also be deleted", "Lead delete", JOptionPane.OK_CANCEL_OPTION, 0);
        if (yesNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from leads where LeadID = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Lead data deleted successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Leads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
