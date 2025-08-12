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

public class Contacts {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public int getMax() { // for max row
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(ContactID) from contacts");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }
    
    public void insert(int cid, String csid, String email, String phone, String cra) {

        String sql = "insert into contacts values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setString(2, csid);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, cra);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showConfirmDialog(null, "Contact added successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isCnIDExist(int id) { // When same id exists
        try {
            ps = con.prepareStatement("select * from contacts where ContactID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void getContactsValues(JTable table, String searchValues) { // To show student details on the table
        String sql = "select * from contacts where concat (ContactID, CustomerID, Email, Phone, created_at) like ? order by ContactID desc";
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
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateContacts(int cnid, String csid, String email, String phone) {

        String sql = "update contacts set CustomerID = ?, Email = ?, Phone = ? where ContactID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, csid);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setInt(4, cnid);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Contact data updated successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteContacts(int id) {
        int yesNo = JOptionPane.showConfirmDialog(null, "All the information of this Contacts will also be deleted", "Contact delete", JOptionPane.OK_CANCEL_OPTION, 0);
        if (yesNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from contacts where ContactID = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Contact data deleted successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
