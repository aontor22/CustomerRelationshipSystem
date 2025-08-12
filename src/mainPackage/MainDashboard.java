package mainPackage;

import DataBase.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDashboard {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public int totalcus() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM customers");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totalNewcus() {
        int ne = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM customers WHERE DATE(created_at) = CURDATE()");
            if (rs.next()) {
                ne = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ne;
    }

    public int totalcn() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM contacts");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totalNewcn() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM contacts WHERE DATE(created_at) = CURDATE()");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totallead() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM leads");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totalNLead() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM leads WHERE DATE(created_at) = CURDATE()");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public String leadstatus() {
        String status = null;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Status FROM leads ORDER BY LeadID DESC LIMIT 1;");
            if (rs.next()) {
                status = (rs.getString("Status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int oops() {
        int oop = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total_open_opportunities FROM opportunities WHERE Status IN ('Prospecting', 'Qualification', 'Proposal Sent', 'Negotiation')");
            if (rs.next()) {
                oop = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oop;
    }

    public int ostatus() {
        int stat = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total_closed_won FROM opportunities WHERE Status = 'Closed Won'");
            if (rs.next()) {
                stat = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stat;
    }

    public float totalrev() {
        float total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(Price * Quantity) AS total_revenue FROM sales;");
            if (rs.next()) {
                total = (rs.getFloat(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int newsale() {
        int ns = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS new_sales_count FROM sales WHERE SaleDate = CURDATE()");
            /*SELECT COUNT(*) AS new_sales_count
                FROM sales
                WHERE SaleDate BETWEEN '2024-01-01' AND '2024-06-01';
             */
            if (rs.next()) {
                ns = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ns;
    }

    public int totalcam() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM marketing");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public float totalcost() {
        float total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(Cost) AS total_cost FROM marketing;");
            if (rs.next()) {
                total = (rs.getFloat(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int nopt() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS open_tickets_count FROM support WHERE Status = 'Open'");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int nrpt() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS resolve_tickets_count FROM support WHERE Status = 'Resolved'");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public String priority() {
        String status = null;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Priority FROM support ORDER BY TicketID DESC LIMIT 1;");
            if (rs.next()) {
                status = (rs.getString("Priority"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int nrp() {
        int total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total_reports_generated FROM analytics");
            if (rs.next()) {
                total = (rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int getMax() { // for max row
        int id = 0, total = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(ContactID) from contacts");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }
}
