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

public class Opportunities {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public int getMax() { // for max row
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(OpportunityID) from opportunities");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opportunities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }
    
    
    public boolean isOIDExist(int id) { // When same id exists
        try {
            ps = con.prepareStatement("select * from opportunities where OpportunityID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opportunities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void insert(int oid, String oname, String lid, String status, String pro, String amount) {

        String sql = "insert into opportunities values(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, oid);
            ps.setString(2, oname);
            ps.setString(3, lid);
            ps.setString(4, status);
            ps.setString(5, pro);
            ps.setString(6, amount);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showConfirmDialog(null, "Opportunity added successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Opportunities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void getOppValues(JTable table, String searchValues) { // To show student details on the table
        String sql = "select * from opportunities where concat (OpportunityID, Opportunity_Name, LeadID, Status, Probability, Amount) like ? order by OpportunityID desc";
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
                row[2] = rs.getInt(3);
                row[3] = rs.getString(4);
                row[4] = rs.getFloat(5);
                row[5] = rs.getInt(6);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opportunities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void updateOOp(int oid, String oname, String status, String Probability, String amount) {

        String sql = "update opportunities set Opportunity_Name = ?, Status = ?, Probability = ?, Amount = ? where OpportunityID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, oname);
            ps.setString(2, status);
            ps.setString(3,Probability);
            ps.setString(4, amount);
            ps.setInt(5, oid);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Opportunity data updated successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opportunities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOOP(int id) {
        int yesNo = JOptionPane.showConfirmDialog(null, "All the information of this Opportunity will also be deleted", "Opportunity delete", JOptionPane.OK_CANCEL_OPTION, 0);
        if (yesNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from opportunities where OpportunityID = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Opportunity data deleted successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Opportunities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
