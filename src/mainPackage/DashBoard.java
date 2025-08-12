package mainPackage;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DashBoard extends javax.swing.JFrame {

    customer cus = new customer();
    Contacts con = new Contacts();
    Leads lead = new Leads();
    Opportunities opp = new Opportunities();
    Sales sal = new Sales();
    Marketing mark = new Marketing();
    Support sup = new Support();
    Analytics anl = new Analytics();
    MainDashboard main = new MainDashboard();
    private DefaultTableModel model;
    private int rowIndex;

    public DashBoard() {
        initComponents();
        init();
    }

    public void init() {
        setTime();
        tableViewCustomer();
        tableViewContacts();
        tableViewLeads();
        tableViewOpportunities();
        tableViewSales();
        tableViewMarketing();
        tableViewSupport();
        tableViewAnalytics();
        Cus_ID.setText(String.valueOf(cus.getMax()));
        Con_cID.setText(String.valueOf(con.getMax()));
        L_ID.setText(String.valueOf(lead.getMax()));
        Opp_ID.setText(String.valueOf(opp.getMax()));
        sa_ID.setText(String.valueOf(sal.getMax()));
        m_ID.setText(String.valueOf(mark.getMax()));
        su_ID.setText(String.valueOf(sup.getMax()));
        anl_ID.setText(String.valueOf(anl.getMax()));
        /*===============================================*/
        tc.setText(String.valueOf(main.totalcus()));
        tcne.setText(String.valueOf(main.totalNewcus()));
        tcn.setText(String.valueOf(main.totalcn()));
        tcnne.setText(String.valueOf(main.totalNewcn()));
        tnl.setText(String.valueOf(main.totallead()));
        tnln.setText(String.valueOf(main.totalNLead()));
        stts.setText(String.valueOf(main.leadstatus()));
        oops.setText(String.valueOf(main.oops()));
        sttso.setText(String.valueOf(main.ostatus()));
        trs.setText(String.valueOf(main.totalrev()));
        trsn.setText(String.valueOf(main.newsale()));
        cam.setText(String.valueOf(main.totalcam()));
        cos.setText(String.valueOf(main.totalcost()));
        opt.setText(String.valueOf(main.nopt()));
        rpt.setText(String.valueOf(main.nrpt()));
        pri.setText(String.valueOf(main.priority()));
        rp.setText(String.valueOf(main.nrp()));
    }

    public void tableViewCustomer() {
        cus.getCustomerValues(Cus_table, "");
        model = (DefaultTableModel) Cus_table.getModel();
        Cus_table.setRowHeight(30);
        Cus_table.setShowGrid(true);
        Cus_table.setGridColor(Color.black);
        Cus_table.setBackground(Color.white);
    }

    public void tableViewContacts() {
        con.getContactsValues(Con_table, "");
        model = (DefaultTableModel) Con_table.getModel();
        Con_table.setRowHeight(30);
        Con_table.setShowGrid(true);
        Con_table.setGridColor(Color.black);
        Con_table.setBackground(Color.white);
    }

    public void tableViewLeads() {
        lead.getLeadsValues(Lead_table, "");
        model = (DefaultTableModel) Lead_table.getModel();
        Lead_table.setRowHeight(30);
        Lead_table.setShowGrid(true);
        Lead_table.setGridColor(Color.black);
        Lead_table.setBackground(Color.white);
    }

    public void tableViewOpportunities() {
        opp.getOppValues(Opp_table, "");
        model = (DefaultTableModel) Opp_table.getModel();
        Opp_table.setRowHeight(30);
        Opp_table.setShowGrid(true);
        Opp_table.setGridColor(Color.black);
        Opp_table.setBackground(Color.white);
    }

    public void tableViewSales() {
        sal.getSalValues(Sales_table, "");
        model = (DefaultTableModel) Sales_table.getModel();
        Sales_table.setRowHeight(30);
        Sales_table.setShowGrid(true);
        Sales_table.setGridColor(Color.black);
        Sales_table.setBackground(Color.white);
    }

    public void tableViewMarketing() {
        mark.getMaValues(Marketing_table, "");
        model = (DefaultTableModel) Marketing_table.getModel();
        Marketing_table.setRowHeight(30);
        Marketing_table.setShowGrid(true);
        Marketing_table.setGridColor(Color.black);
        Marketing_table.setBackground(Color.white);
    }

    public void tableViewSupport() {
        sup.getSupValues(Support_table, "");
        model = (DefaultTableModel) Support_table.getModel();
        Support_table.setRowHeight(30);
        Support_table.setShowGrid(true);
        Support_table.setGridColor(Color.black);
        Support_table.setBackground(Color.white);
    }

    public void tableViewAnalytics() {
        anl.getAnValues(Analytics_table, "");
        model = (DefaultTableModel) Analytics_table.getModel();
        Analytics_table.setRowHeight(30);
        Analytics_table.setShowGrid(true);
        Analytics_table.setGridColor(Color.black);
        Analytics_table.setBackground(Color.white);
    }

    public void clearc() {
        Cus_table.setModel(new DefaultTableModel(null, new Object[]{"CustomerID", "Name", "Address", "Phone", "created_at"}));
        cus.getCustomerValues(Cus_table, "");
        Cus_ID.setText(String.valueOf(cus.getMax()));
        Cus_Name.setText(null);
        Cus_address.setText(null);
        Cus_phone.setText(null);
        Cus_time.setText(null);
    }

    public void clearcon() {
        Con_table.setModel(new DefaultTableModel(null, new Object[]{"ContactID", "CustomerID", "Email", "Phone", "created_at"}));
        con.getContactsValues(Con_table, "");
        Con_cID.setText(String.valueOf(con.getMax()));
        Con_cusID.setText(null);
        Con_email.setText(null);
        Con_phone.setText(null);
        Con_time.setText(null);
    }

    public void clearl() {
        Lead_table.setModel(new DefaultTableModel(null, new Object[]{"LeadID", "Lead_name", "ContactID", "Status", "Source", "created_at"}));
        lead.getLeadsValues(Lead_table, "");
        L_ID.setText(String.valueOf(con.getMax()));
        L_name.setText(null);
        L_C_ID.setText(null);
        L_stat.setSelectedIndex(0);
        L_source.setSelectedIndex(0);
        L_C_time.setText(null);
    }

    public void clearo() {
        Opp_table.setModel(new DefaultTableModel(null, new Object[]{"OpportunityID", "Opportunity_Name", "LeadID", "Status", "Probability", "Amount"}));
        opp.getOppValues(Opp_table, "");
        Opp_ID.setText(String.valueOf(opp.getMax()));
        o_name.setText(null);
        o_l_ID.setText(null);
        ostat.setSelectedIndex(0);
        opro.setText(null);
        oam.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DashBoard = new javax.swing.JPanel();
        MainDashBoard = new javax.swing.JPanel();
        DashBoard_Heading = new javax.swing.JPanel();
        MainHeading = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        GroupPanel = new javax.swing.JPanel();
        GroupTab = new raven.tabbed.TabbedPaneCustom();
        Dashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        sttso = new javax.swing.JLabel();
        oops = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        totalCustomers = new javax.swing.JLabel();
        newCustomers = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        tc = new javax.swing.JLabel();
        tcne = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        tcn = new javax.swing.JLabel();
        tcnne = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        tnl = new javax.swing.JLabel();
        stts = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        tnln = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        rp = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        trs = new javax.swing.JLabel();
        trsn = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        cam = new javax.swing.JLabel();
        cos = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        opt = new javax.swing.JLabel();
        pri = new javax.swing.JLabel();
        rpt = new javax.swing.JLabel();
        Customer = new javax.swing.JPanel();
        Cus_D_P = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cus_Name = new javax.swing.JTextField();
        Cus_address = new javax.swing.JTextField();
        Cus_phone = new javax.swing.JTextField();
        cus_Add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Cus_ID = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Cus_refresh = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        Cus_time = new javax.swing.JTextField();
        Cus_D_T = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cus_table = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        Cus_update = new javax.swing.JButton();
        Cus_delete = new javax.swing.JButton();
        Cus_print = new javax.swing.JButton();
        Cus_logout = new javax.swing.JButton();
        Contacts = new javax.swing.JPanel();
        Con_D_P = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Con_cusID = new javax.swing.JTextField();
        Con_email = new javax.swing.JTextField();
        Con_phone = new javax.swing.JTextField();
        Con_add = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Con_cID = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Con_refresh = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        Con_time = new javax.swing.JTextField();
        Con_D_T = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Con_table = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        Con_update = new javax.swing.JButton();
        Con_delete = new javax.swing.JButton();
        Con_print = new javax.swing.JButton();
        Con_logout = new javax.swing.JButton();
        Leads = new javax.swing.JPanel();
        L_D_P = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        L_C_ID = new javax.swing.JTextField();
        L_Add = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        L_ID = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        L_refresh = new javax.swing.JButton();
        L_name = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        L_stat = new javax.swing.JComboBox<>();
        L_source = new javax.swing.JComboBox<>();
        L_C_time = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        L_D_T = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Lead_table = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        L_update = new javax.swing.JButton();
        L_delete = new javax.swing.JButton();
        L_print = new javax.swing.JButton();
        L_logout = new javax.swing.JButton();
        Opportunities = new javax.swing.JPanel();
        L_D_P1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        o_l_ID = new javax.swing.JTextField();
        opro = new javax.swing.JTextField();
        o_Add = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        Opp_ID = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        o_refresh = new javax.swing.JButton();
        o_name = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        oam = new javax.swing.JTextField();
        ostat = new javax.swing.JComboBox<>();
        L_D_T1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Opp_table = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        o_update = new javax.swing.JButton();
        o_delete = new javax.swing.JButton();
        o_print = new javax.swing.JButton();
        op_logout = new javax.swing.JButton();
        Sales = new javax.swing.JPanel();
        L_D_P2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        L_C_ID4 = new javax.swing.JTextField();
        L_source3 = new javax.swing.JTextField();
        L_Add2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        sa_ID = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        L_refresh2 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        L_source4 = new javax.swing.JTextField();
        L_C_ID12 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        lsd = new javax.swing.JTextField();
        L_D_T4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Sales_table = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        L_update4 = new javax.swing.JButton();
        L_delete4 = new javax.swing.JButton();
        s_print = new javax.swing.JButton();
        s_logout = new javax.swing.JButton();
        Marketing = new javax.swing.JPanel();
        L_D_P3 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        L_C_ID6 = new javax.swing.JTextField();
        L_source5 = new javax.swing.JTextField();
        L_Add3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        m_ID = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        L_refresh3 = new javax.swing.JButton();
        L_C_ID7 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        L_source6 = new javax.swing.JTextField();
        L_D_T5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Marketing_table = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        L_update5 = new javax.swing.JButton();
        L_delete5 = new javax.swing.JButton();
        m_print = new javax.swing.JButton();
        m_logout = new javax.swing.JButton();
        Support = new javax.swing.JPanel();
        L_D_P4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        L_C_ID8 = new javax.swing.JTextField();
        L_Add4 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        su_ID = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        L_refresh4 = new javax.swing.JButton();
        L_C_ID9 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        L_D_T6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Support_table = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        L_update6 = new javax.swing.JButton();
        L_delete6 = new javax.swing.JButton();
        su_print = new javax.swing.JButton();
        su_logout = new javax.swing.JButton();
        Analytics = new javax.swing.JPanel();
        L_D_P5 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        L_C_ID10 = new javax.swing.JTextField();
        L_source9 = new javax.swing.JTextField();
        L_Add5 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        anl_ID = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        L_refresh5 = new javax.swing.JButton();
        L_C_ID11 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        L_D_T7 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Analytics_table = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        L_update7 = new javax.swing.JButton();
        L_delete7 = new javax.swing.JButton();
        a_print = new javax.swing.JButton();
        an_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Relationship System Dashboard");
        setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        DashBoard.setBackground(new java.awt.Color(51, 255, 204));
        DashBoard.setPreferredSize(new java.awt.Dimension(950, 600));

        MainDashBoard.setBackground(new java.awt.Color(51, 255, 255));
        MainDashBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 204, 204), null, null));
        MainDashBoard.setPreferredSize(new java.awt.Dimension(980, 640));

        DashBoard_Heading.setBackground(new java.awt.Color(102, 255, 204));
        DashBoard_Heading.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 153), new java.awt.Color(0, 255, 204), null, null));

        MainHeading.setFont(new java.awt.Font("Swis721 BlkOul BT", 1, 40)); // NOI18N
        MainHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainHeading.setText("Customer Relationship System");

        txtTime.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTime.setPreferredSize(new java.awt.Dimension(90, 8));

        txtDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDate.setPreferredSize(new java.awt.Dimension(160, 8));

        javax.swing.GroupLayout DashBoard_HeadingLayout = new javax.swing.GroupLayout(DashBoard_Heading);
        DashBoard_Heading.setLayout(DashBoard_HeadingLayout);
        DashBoard_HeadingLayout.setHorizontalGroup(
            DashBoard_HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoard_HeadingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(DashBoard_HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        DashBoard_HeadingLayout.setVerticalGroup(
            DashBoard_HeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoard_HeadingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DashBoard_HeadingLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupPanel.setBackground(new java.awt.Color(255, 255, 255));

        GroupTab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        GroupTab.setSelectedColor(new java.awt.Color(0, 153, 51));
        GroupTab.setUnselectedColor(new java.awt.Color(204, 255, 255));

        Dashboard.setBackground(new java.awt.Color(0, 255, 204));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(204, 255, 255), null, null));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Opportunities");

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(153, 255, 255));
        jLabel66.setText("Open Opportunities:");

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(153, 255, 255));
        jLabel67.setText("Closed-Won:");

        sttso.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sttso.setForeground(new java.awt.Color(51, 255, 255));

        oops.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        oops.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel55))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sttso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oops, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(oops, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(sttso, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Customers");

        totalCustomers.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        totalCustomers.setForeground(new java.awt.Color(153, 255, 255));
        totalCustomers.setText("Total Customers:");

        newCustomers.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        newCustomers.setForeground(new java.awt.Color(153, 255, 255));
        newCustomers.setText("New Customers:");

        tc.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tc.setForeground(new java.awt.Color(51, 255, 255));

        tcne.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tcne.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel52))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(newCustomers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcne, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(totalCustomers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addGap(1, 1, 1)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tc, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalCustomers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newCustomers)
                    .addComponent(tcne, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Contacts");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(153, 255, 255));
        jLabel62.setText("Total Contacts:");

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(153, 255, 255));
        jLabel63.setText("New Contacts:");

        tcn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tcn.setForeground(new java.awt.Color(51, 255, 255));

        tcnne.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tcnne.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel53)
                .addGap(75, 75, 75))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcnne, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addGap(1, 1, 1)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(tcn, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel63)
                    .addComponent(tcnne, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(0, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Leads");

        jLabel64.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(153, 255, 255));
        jLabel64.setText("Total Leads:");

        jLabel65.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(153, 255, 255));
        jLabel65.setText("Status:");

        tnl.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tnl.setForeground(new java.awt.Color(51, 255, 255));

        stts.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        stts.setForeground(new java.awt.Color(51, 255, 255));

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(153, 255, 255));
        jLabel77.setText("New Leads:");

        tnln.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tnln.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel54))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stts, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel77))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tnln, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(tnl, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(tnln, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stts, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65))
                        .addGap(14, 14, 14))))
        );

        jPanel29.setBackground(new java.awt.Color(0, 51, 51));
        jPanel29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Analytics");

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 255, 255));
        jLabel74.setText("Reports Generated:");

        rp.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rp.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(74, 74, 74))
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addGap(2, 2, 2)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74)
                    .addComponent(rp, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(0, 51, 51));
        jPanel30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Sales");

        jLabel68.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(153, 255, 255));
        jLabel68.setText("Total Revenue ($):");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(153, 255, 255));
        jLabel69.setText("New Sales:");

        trs.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        trs.setForeground(new java.awt.Color(51, 255, 255));

        trsn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        trsn.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel56))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trsn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trs, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addGap(2, 2, 2)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(trs, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(trsn, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(0, 51, 51));
        jPanel31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Marketing");

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(153, 255, 255));
        jLabel70.setText("Campaigns:");

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(153, 255, 255));
        jLabel71.setText("Total Cost ($):");

        cam.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cam.setForeground(new java.awt.Color(51, 255, 255));

        cos.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cos.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addGap(68, 68, 68))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel70)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cam, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGap(1, 1, 1)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(cam, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71)
                    .addComponent(cos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(0, 51, 51));
        jPanel32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 204, 255), new java.awt.Color(51, 51, 51), new java.awt.Color(0, 204, 204)));

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Support");

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(153, 255, 255));
        jLabel72.setText("Open Tickets:");

        jLabel73.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 255, 255));
        jLabel73.setText("Resolved Tickets:");

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(153, 255, 255));
        jLabel76.setText("Priority:");

        opt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        opt.setForeground(new java.awt.Color(51, 255, 255));

        pri.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        pri.setForeground(new java.awt.Color(51, 255, 255));

        rpt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rpt.setForeground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rpt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pri, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addGap(1, 1, 1)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72))
                    .addComponent(opt, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(rpt, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel10, jPanel2, jPanel29, jPanel30, jPanel32, jPanel5, jPanel9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel2, jPanel29, jPanel30, jPanel32, jPanel5, jPanel9});

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupTab.addTab("Dashboard", Dashboard);

        Customer.setBackground(new java.awt.Color(0, 255, 204));

        Cus_D_P.setBackground(new java.awt.Color(102, 204, 255));
        Cus_D_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Customer Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Phone");

        Cus_Name.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        Cus_address.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        Cus_phone.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        cus_Add.setBackground(new java.awt.Color(204, 253, 246));
        cus_Add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cus_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        cus_Add.setText("Add");
        cus_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_AddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Customer ID");

        Cus_ID.setEditable(false);
        Cus_ID.setBackground(new java.awt.Color(204, 204, 204));
        Cus_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel12.setBackground(new java.awt.Color(0, 204, 204));
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Details");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Cus_refresh.setBackground(new java.awt.Color(204, 253, 246));
        Cus_refresh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Cus_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        Cus_refresh.setText("Refresh");
        Cus_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cus_refreshActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel60.setText("Adding Date");

        Cus_time.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        javax.swing.GroupLayout Cus_D_PLayout = new javax.swing.GroupLayout(Cus_D_P);
        Cus_D_P.setLayout(Cus_D_PLayout);
        Cus_D_PLayout.setHorizontalGroup(
            Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cus_D_PLayout.createSequentialGroup()
                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Cus_D_PLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Cus_D_PLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cus_address, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Cus_D_PLayout.createSequentialGroup()
                                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Cus_D_PLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Cus_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Cus_D_PLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Cus_time)
                                            .addComponent(Cus_phone, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))))
                            .addGroup(Cus_D_PLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cus_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(Cus_D_PLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(Cus_D_PLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(cus_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cus_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        Cus_D_PLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Cus_ID, Cus_Name, Cus_address, Cus_phone, Cus_time});

        Cus_D_PLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Cus_refresh, cus_Add});

        Cus_D_PLayout.setVerticalGroup(
            Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cus_D_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Cus_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cus_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Cus_address, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Cus_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(Cus_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(Cus_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cus_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cus_refresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Cus_D_PLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Cus_ID, Cus_Name, Cus_address, Cus_phone, Cus_time});

        Cus_D_PLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Cus_refresh, cus_Add});

        Cus_D_T.setBackground(new java.awt.Color(51, 204, 255));
        Cus_D_T.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Cus_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Cus_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Address", "Phone", "Adding Time"
            }
        ));
        Cus_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cus_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Cus_table);

        jPanel11.setBackground(new java.awt.Color(51, 255, 204));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        Cus_update.setBackground(new java.awt.Color(204, 253, 246));
        Cus_update.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Cus_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        Cus_update.setText("Update");
        Cus_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cus_updateActionPerformed(evt);
            }
        });

        Cus_delete.setBackground(new java.awt.Color(204, 253, 246));
        Cus_delete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Cus_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        Cus_delete.setText("Delete");
        Cus_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cus_deleteActionPerformed(evt);
            }
        });

        Cus_print.setBackground(new java.awt.Color(204, 253, 246));
        Cus_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Cus_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        Cus_print.setText("Print");
        Cus_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cus_printActionPerformed(evt);
            }
        });

        Cus_logout.setBackground(new java.awt.Color(204, 253, 246));
        Cus_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Cus_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        Cus_logout.setText("Logout");
        Cus_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cus_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(Cus_update)
                .addGap(27, 27, 27)
                .addComponent(Cus_delete)
                .addGap(27, 27, 27)
                .addComponent(Cus_print)
                .addGap(26, 26, 26)
                .addComponent(Cus_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Cus_delete, Cus_print, Cus_update});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cus_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cus_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cus_print)
                    .addComponent(Cus_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Cus_delete, Cus_print, Cus_update});

        javax.swing.GroupLayout Cus_D_TLayout = new javax.swing.GroupLayout(Cus_D_T);
        Cus_D_T.setLayout(Cus_D_TLayout);
        Cus_D_TLayout.setHorizontalGroup(
            Cus_D_TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
            .addGroup(Cus_D_TLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Cus_D_TLayout.setVerticalGroup(
            Cus_D_TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cus_D_TLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout CustomerLayout = new javax.swing.GroupLayout(Customer);
        Customer.setLayout(CustomerLayout);
        CustomerLayout.setHorizontalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cus_D_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cus_D_T, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CustomerLayout.setVerticalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerLayout.createSequentialGroup()
                        .addComponent(Cus_D_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Cus_D_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupTab.addTab("Customer", Customer);

        Contacts.setBackground(new java.awt.Color(0, 255, 204));

        Con_D_P.setBackground(new java.awt.Color(102, 204, 255));
        Con_D_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Customer ID");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Phone");

        Con_cusID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        Con_email.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        Con_phone.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        Con_add.setBackground(new java.awt.Color(204, 253, 246));
        Con_add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Con_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        Con_add.setText("Add");
        Con_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_addActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Contacts ID");

        Con_cID.setEditable(false);
        Con_cID.setBackground(new java.awt.Color(204, 204, 204));
        Con_cID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel13.setBackground(new java.awt.Color(0, 204, 204));
        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Contacts Details");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        Con_refresh.setBackground(new java.awt.Color(204, 253, 246));
        Con_refresh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Con_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        Con_refresh.setText("Refresh");
        Con_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_refreshActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel61.setText("Adding Date");

        Con_time.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        javax.swing.GroupLayout Con_D_PLayout = new javax.swing.GroupLayout(Con_D_P);
        Con_D_P.setLayout(Con_D_PLayout);
        Con_D_PLayout.setHorizontalGroup(
            Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Con_D_PLayout.createSequentialGroup()
                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Con_D_PLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Con_D_PLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Con_email, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Con_D_PLayout.createSequentialGroup()
                                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Con_D_PLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Con_cID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Con_D_PLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(Con_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(Con_D_PLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Con_cusID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(Con_D_PLayout.createSequentialGroup()
                                    .addGap(125, 125, 125)
                                    .addComponent(Con_time, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel61)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Con_D_PLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(Con_D_PLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(Con_add, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(Con_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        Con_D_PLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Con_cID, Con_cusID, Con_email, Con_phone, Con_time});

        Con_D_PLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Con_add, Con_refresh});

        Con_D_PLayout.setVerticalGroup(
            Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Con_D_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Con_cID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Con_cusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Con_email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Con_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(Con_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(Con_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Con_add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Con_refresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Con_D_PLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Con_cID, Con_cusID, Con_email, Con_phone, Con_time});

        Con_D_PLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Con_add, Con_refresh});

        Con_D_T.setBackground(new java.awt.Color(51, 204, 255));
        Con_D_T.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Con_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Con_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Contacts ID", "Customer ID", "Email", "Phone", "Adding Date"
            }
        ));
        Con_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Con_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Con_table);

        jPanel14.setBackground(new java.awt.Color(51, 255, 204));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        Con_update.setBackground(new java.awt.Color(204, 253, 246));
        Con_update.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Con_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        Con_update.setText("Update");
        Con_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_updateActionPerformed(evt);
            }
        });

        Con_delete.setBackground(new java.awt.Color(204, 253, 246));
        Con_delete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Con_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        Con_delete.setText("Delete");
        Con_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_deleteActionPerformed(evt);
            }
        });

        Con_print.setBackground(new java.awt.Color(204, 253, 246));
        Con_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Con_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        Con_print.setText("Print");
        Con_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_printActionPerformed(evt);
            }
        });

        Con_logout.setBackground(new java.awt.Color(204, 253, 246));
        Con_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Con_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        Con_logout.setText("Logout");
        Con_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Con_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(Con_update)
                .addGap(27, 27, 27)
                .addComponent(Con_delete)
                .addGap(27, 27, 27)
                .addComponent(Con_print)
                .addGap(26, 26, 26)
                .addComponent(Con_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Con_delete, Con_print});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Con_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Con_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Con_print)
                    .addComponent(Con_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Con_delete, Con_print});

        javax.swing.GroupLayout Con_D_TLayout = new javax.swing.GroupLayout(Con_D_T);
        Con_D_T.setLayout(Con_D_TLayout);
        Con_D_TLayout.setHorizontalGroup(
            Con_D_TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
            .addGroup(Con_D_TLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Con_D_TLayout.setVerticalGroup(
            Con_D_TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Con_D_TLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ContactsLayout = new javax.swing.GroupLayout(Contacts);
        Contacts.setLayout(ContactsLayout);
        ContactsLayout.setHorizontalGroup(
            ContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContactsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Con_D_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Con_D_T, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ContactsLayout.setVerticalGroup(
            ContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContactsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContactsLayout.createSequentialGroup()
                        .addComponent(Con_D_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Con_D_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupTab.addTab("Contacts", Contacts);

        Leads.setBackground(new java.awt.Color(0, 255, 204));

        L_D_P.setBackground(new java.awt.Color(102, 204, 255));
        L_D_P.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Contacts ID");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Status");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Source");

        L_C_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_Add.setBackground(new java.awt.Color(204, 253, 246));
        L_Add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        L_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        L_Add.setText("Add");
        L_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_AddActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Lead ID");

        L_ID.setEditable(false);
        L_ID.setBackground(new java.awt.Color(204, 204, 204));
        L_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel15.setBackground(new java.awt.Color(0, 204, 204));
        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Lead Details");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        L_refresh.setBackground(new java.awt.Color(204, 253, 246));
        L_refresh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        L_refresh.setText("Refresh");
        L_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_refreshActionPerformed(evt);
            }
        });

        L_name.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Lead Name");

        L_stat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        L_stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New", "Contacted", "Interested", "Qualified", "Closed" }));

        L_source.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        L_source.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Website", "Referral", "Social Media", "Trade Show", "Email Campaign" }));

        L_C_time.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("Adding Date");

        javax.swing.GroupLayout L_D_PLayout = new javax.swing.GroupLayout(L_D_P);
        L_D_P.setLayout(L_D_PLayout);
        L_D_PLayout.setHorizontalGroup(
            L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L_D_PLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(L_D_PLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(L_C_time, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, L_D_PLayout.createSequentialGroup()
                        .addComponent(L_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(L_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, L_D_PLayout.createSequentialGroup()
                        .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(L_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_C_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_name, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L_source, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65))
        );

        L_D_PLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {L_C_ID, L_ID, L_name, L_source, L_stat});

        L_D_PLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {L_Add, L_refresh});

        L_D_PLayout.setVerticalGroup(
            L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(L_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(L_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(L_C_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(L_stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(L_source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(L_C_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(L_D_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_refresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        L_D_PLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_C_ID, L_C_time, L_ID, L_name, L_source, L_stat});

        L_D_PLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_Add, L_refresh});

        L_D_T.setBackground(new java.awt.Color(51, 204, 255));
        L_D_T.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Lead_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Lead_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Lead ID", "Lead Name", "Contact ID", "Status", "Source", "Adding Date"
            }
        ));
        Lead_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lead_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Lead_table);

        jPanel16.setBackground(new java.awt.Color(51, 255, 204));
        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        L_update.setBackground(new java.awt.Color(204, 253, 246));
        L_update.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        L_update.setText("Update");
        L_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_updateActionPerformed(evt);
            }
        });

        L_delete.setBackground(new java.awt.Color(204, 253, 246));
        L_delete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        L_delete.setText("Delete");
        L_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_deleteActionPerformed(evt);
            }
        });

        L_print.setBackground(new java.awt.Color(204, 253, 246));
        L_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        L_print.setText("Print");
        L_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_printActionPerformed(evt);
            }
        });

        L_logout.setBackground(new java.awt.Color(204, 253, 246));
        L_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        L_logout.setText("Logout");
        L_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(L_update)
                .addGap(27, 27, 27)
                .addComponent(L_delete)
                .addGap(27, 27, 27)
                .addComponent(L_print)
                .addGap(26, 26, 26)
                .addComponent(L_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {L_delete, L_logout, L_print, L_update});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_print)
                    .addComponent(L_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_delete, L_logout, L_print, L_update});

        javax.swing.GroupLayout L_D_TLayout = new javax.swing.GroupLayout(L_D_T);
        L_D_T.setLayout(L_D_TLayout);
        L_D_TLayout.setHorizontalGroup(
            L_D_TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(L_D_TLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        L_D_TLayout.setVerticalGroup(
            L_D_TLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_TLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout LeadsLayout = new javax.swing.GroupLayout(Leads);
        Leads.setLayout(LeadsLayout);
        LeadsLayout.setHorizontalGroup(
            LeadsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeadsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_D_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_D_T, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        LeadsLayout.setVerticalGroup(
            LeadsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeadsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeadsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeadsLayout.createSequentialGroup()
                        .addComponent(L_D_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(L_D_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupTab.addTab("Leads", Leads);

        Opportunities.setBackground(new java.awt.Color(0, 255, 204));

        L_D_P1.setBackground(new java.awt.Color(102, 204, 255));
        L_D_P1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Lead ID");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Status");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Probability");

        o_l_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        opro.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        o_Add.setBackground(new java.awt.Color(204, 253, 246));
        o_Add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        o_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        o_Add.setText("Add");
        o_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_AddActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Opportunity ID");

        Opp_ID.setEditable(false);
        Opp_ID.setBackground(new java.awt.Color(204, 204, 204));
        Opp_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel17.setBackground(new java.awt.Color(0, 204, 204));
        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Opportunity Details");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        o_refresh.setBackground(new java.awt.Color(204, 253, 246));
        o_refresh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        o_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        o_refresh.setText("Refresh");
        o_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_refreshActionPerformed(evt);
            }
        });

        o_name.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Opportunity Name");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Amount");

        oam.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        ostat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ostat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prospecting", "Qualification", "Proposal Sent", "Negotiation", "Closed Won", "Closed Lost", " " }));

        javax.swing.GroupLayout L_D_P1Layout = new javax.swing.GroupLayout(L_D_P1);
        L_D_P1.setLayout(L_D_P1Layout);
        L_D_P1Layout.setHorizontalGroup(
            L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(L_D_P1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(o_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(o_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(L_D_P1Layout.createSequentialGroup()
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(L_D_P1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L_D_P1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(40, 40, 40)))
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opro, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Opp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o_l_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o_name, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oam, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ostat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        L_D_P1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Opp_ID, o_l_ID, o_name, oam, opro, ostat});

        L_D_P1Layout.setVerticalGroup(
            L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Opp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(10, 10, 10)
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(11, 11, 11)
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o_l_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(ostat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(11, 11, 11)
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(37, 37, 37)
                .addGroup(L_D_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o_refresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        L_D_P1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Opp_ID, o_l_ID, o_name, oam, opro, ostat});

        L_D_P1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {o_Add, o_refresh});

        L_D_T1.setBackground(new java.awt.Color(51, 204, 255));
        L_D_T1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Opp_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Opp_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Opportunity ID", "Opportunity Name", "Lead ID", "Status", "Probability", "Amount"
            }
        ));
        Opp_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opp_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Opp_table);

        jPanel18.setBackground(new java.awt.Color(51, 255, 204));
        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        o_update.setBackground(new java.awt.Color(204, 253, 246));
        o_update.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        o_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        o_update.setText("Update");
        o_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_updateActionPerformed(evt);
            }
        });

        o_delete.setBackground(new java.awt.Color(204, 253, 246));
        o_delete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        o_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        o_delete.setText("Delete");
        o_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_deleteActionPerformed(evt);
            }
        });

        o_print.setBackground(new java.awt.Color(204, 253, 246));
        o_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        o_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        o_print.setText("Print");
        o_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_printActionPerformed(evt);
            }
        });

        op_logout.setBackground(new java.awt.Color(204, 253, 246));
        op_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        op_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        op_logout.setText("Logout");
        op_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(o_update)
                .addGap(27, 27, 27)
                .addComponent(o_delete)
                .addGap(27, 27, 27)
                .addComponent(o_print)
                .addGap(26, 26, 26)
                .addComponent(op_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(o_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(o_print)
                    .addComponent(op_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {o_delete, o_print, o_update, op_logout});

        javax.swing.GroupLayout L_D_T1Layout = new javax.swing.GroupLayout(L_D_T1);
        L_D_T1.setLayout(L_D_T1Layout);
        L_D_T1Layout.setHorizontalGroup(
            L_D_T1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(L_D_T1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        L_D_T1Layout.setVerticalGroup(
            L_D_T1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_T1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout OpportunitiesLayout = new javax.swing.GroupLayout(Opportunities);
        Opportunities.setLayout(OpportunitiesLayout);
        OpportunitiesLayout.setHorizontalGroup(
            OpportunitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpportunitiesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_D_P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(L_D_T1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        OpportunitiesLayout.setVerticalGroup(
            OpportunitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpportunitiesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OpportunitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OpportunitiesLayout.createSequentialGroup()
                        .addComponent(L_D_T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(L_D_P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupTab.addTab("Opportunities", Opportunities);

        Sales.setBackground(new java.awt.Color(0, 255, 204));

        L_D_P2.setBackground(new java.awt.Color(102, 204, 255));
        L_D_P2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setText("Product ID");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("Price ($)");

        L_C_ID4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_C_ID4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_C_ID4ActionPerformed(evt);
            }
        });

        L_source3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_Add2.setBackground(new java.awt.Color(204, 253, 246));
        L_Add2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        L_Add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        L_Add2.setText("Add");
        L_Add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_Add2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setText("Sale ID");

        sa_ID.setEditable(false);
        sa_ID.setBackground(new java.awt.Color(204, 204, 204));
        sa_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel19.setBackground(new java.awt.Color(0, 204, 204));
        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Sales Details");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        L_refresh2.setBackground(new java.awt.Color(204, 253, 246));
        L_refresh2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_refresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        L_refresh2.setText("Refresh");
        L_refresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_refresh2ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("Customer ID");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("Quantity");

        L_source4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_C_ID12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setText("Sale Date");

        lsd.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lsd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lsdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout L_D_P2Layout = new javax.swing.GroupLayout(L_D_P2);
        L_D_P2.setLayout(L_D_P2Layout);
        L_D_P2Layout.setHorizontalGroup(
            L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(L_D_P2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(L_Add2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(L_refresh2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, L_D_P2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel24)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_source3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sa_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_source4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID12, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lsd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        L_D_P2Layout.setVerticalGroup(
            L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sa_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(L_C_ID4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(L_C_ID12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_source3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(11, 11, 11)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_source4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lsd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L_D_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Add2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_refresh2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        L_D_P2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_C_ID12, L_C_ID4, L_source3, L_source4, sa_ID});

        L_D_P2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_Add2, L_refresh2});

        L_D_T4.setBackground(new java.awt.Color(51, 204, 255));
        L_D_T4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Sales_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Sales_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sale ID", "Customer ID", "Product ID", "Price ($)", "Quantity", "Sale Date"
            }
        ));
        jScrollPane7.setViewportView(Sales_table);

        jPanel25.setBackground(new java.awt.Color(51, 255, 204));
        jPanel25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        L_update4.setBackground(new java.awt.Color(204, 253, 246));
        L_update4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_update4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        L_update4.setText("Update");
        L_update4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_update4ActionPerformed(evt);
            }
        });

        L_delete4.setBackground(new java.awt.Color(204, 253, 246));
        L_delete4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_delete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        L_delete4.setText("Delete");
        L_delete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_delete4ActionPerformed(evt);
            }
        });

        s_print.setBackground(new java.awt.Color(204, 253, 246));
        s_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        s_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        s_print.setText("Print");
        s_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_printActionPerformed(evt);
            }
        });

        s_logout.setBackground(new java.awt.Color(204, 253, 246));
        s_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        s_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        s_logout.setText("Logout");
        s_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(L_update4)
                .addGap(27, 27, 27)
                .addComponent(L_delete4)
                .addGap(27, 27, 27)
                .addComponent(s_print)
                .addGap(26, 26, 26)
                .addComponent(s_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_update4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_delete4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_print)
                    .addComponent(s_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_delete4, L_update4, s_logout, s_print});

        javax.swing.GroupLayout L_D_T4Layout = new javax.swing.GroupLayout(L_D_T4);
        L_D_T4.setLayout(L_D_T4Layout);
        L_D_T4Layout.setHorizontalGroup(
            L_D_T4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(L_D_T4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        L_D_T4Layout.setVerticalGroup(
            L_D_T4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_T4Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout SalesLayout = new javax.swing.GroupLayout(Sales);
        Sales.setLayout(SalesLayout);
        SalesLayout.setHorizontalGroup(
            SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_D_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_D_T4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SalesLayout.setVerticalGroup(
            SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalesLayout.createSequentialGroup()
                        .addComponent(L_D_T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(L_D_P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupTab.addTab("Sales", Sales);

        Marketing.setBackground(new java.awt.Color(0, 255, 204));

        L_D_P3.setBackground(new java.awt.Color(102, 204, 255));
        L_D_P3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setText("Campaign Name");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setText("Channel");

        L_C_ID6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_source5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_Add3.setBackground(new java.awt.Color(204, 253, 246));
        L_Add3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        L_Add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        L_Add3.setText("Add");
        L_Add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_Add3ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setText("Campaign ID");

        m_ID.setEditable(false);
        m_ID.setBackground(new java.awt.Color(204, 204, 204));
        m_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel20.setBackground(new java.awt.Color(0, 204, 204));
        jPanel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Marketing Details");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        L_refresh3.setBackground(new java.awt.Color(204, 253, 246));
        L_refresh3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_refresh3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        L_refresh3.setText("Refresh");
        L_refresh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_refresh3ActionPerformed(evt);
            }
        });

        L_C_ID7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setText("Lead ID");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel37.setText("Cost ($)");

        L_source6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        javax.swing.GroupLayout L_D_P3Layout = new javax.swing.GroupLayout(L_D_P3);
        L_D_P3.setLayout(L_D_P3Layout);
        L_D_P3Layout.setHorizontalGroup(
            L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(L_D_P3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(L_Add3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(L_refresh3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(L_D_P3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_source5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_source6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        L_D_P3Layout.setVerticalGroup(
            L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(10, 10, 10)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_C_ID7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(11, 11, 11)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_C_ID6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_source5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(11, 11, 11)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_source6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(71, 71, 71)
                .addGroup(L_D_P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Add3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_refresh3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        L_D_P3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_C_ID6, L_C_ID7, L_source5, L_source6, m_ID});

        L_D_P3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_Add3, L_refresh3});

        L_D_T5.setBackground(new java.awt.Color(51, 204, 255));
        L_D_T5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Marketing_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Marketing_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Campaign ID", "Lead ID", "Campaign Name", "Channel", "Cost ($)"
            }
        ));
        jScrollPane8.setViewportView(Marketing_table);

        jPanel26.setBackground(new java.awt.Color(51, 255, 204));
        jPanel26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        L_update5.setBackground(new java.awt.Color(204, 253, 246));
        L_update5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_update5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        L_update5.setText("Update");
        L_update5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_update5ActionPerformed(evt);
            }
        });

        L_delete5.setBackground(new java.awt.Color(204, 253, 246));
        L_delete5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_delete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        L_delete5.setText("Delete");
        L_delete5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_delete5ActionPerformed(evt);
            }
        });

        m_print.setBackground(new java.awt.Color(204, 253, 246));
        m_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        m_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        m_print.setText("Print");
        m_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_printActionPerformed(evt);
            }
        });

        m_logout.setBackground(new java.awt.Color(204, 253, 246));
        m_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        m_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        m_logout.setText("Logout");
        m_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(L_update5)
                .addGap(27, 27, 27)
                .addComponent(L_delete5)
                .addGap(27, 27, 27)
                .addComponent(m_print)
                .addGap(26, 26, 26)
                .addComponent(m_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_update5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_delete5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_print)
                    .addComponent(m_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel26Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_delete5, L_update5, m_logout, m_print});

        javax.swing.GroupLayout L_D_T5Layout = new javax.swing.GroupLayout(L_D_T5);
        L_D_T5.setLayout(L_D_T5Layout);
        L_D_T5Layout.setHorizontalGroup(
            L_D_T5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(L_D_T5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        L_D_T5Layout.setVerticalGroup(
            L_D_T5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_T5Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MarketingLayout = new javax.swing.GroupLayout(Marketing);
        Marketing.setLayout(MarketingLayout);
        MarketingLayout.setHorizontalGroup(
            MarketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MarketingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_D_P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_D_T5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MarketingLayout.setVerticalGroup(
            MarketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MarketingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MarketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MarketingLayout.createSequentialGroup()
                        .addComponent(L_D_T5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(L_D_P3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupTab.addTab("Marketing", Marketing);

        Support.setBackground(new java.awt.Color(0, 255, 204));

        L_D_P4.setBackground(new java.awt.Color(102, 204, 255));
        L_D_P4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setText("Issue");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setText("Status");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setText("Priority");

        L_C_ID8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_Add4.setBackground(new java.awt.Color(204, 253, 246));
        L_Add4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        L_Add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        L_Add4.setText("Add");
        L_Add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_Add4ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel41.setText("Ticket ID");

        su_ID.setEditable(false);
        su_ID.setBackground(new java.awt.Color(204, 204, 204));
        su_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel21.setBackground(new java.awt.Color(0, 204, 204));
        jPanel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Support Details");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        L_refresh4.setBackground(new java.awt.Color(204, 253, 246));
        L_refresh4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_refresh4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        L_refresh4.setText("Refresh");
        L_refresh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_refresh4ActionPerformed(evt);
            }
        });

        L_C_ID9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setText("Customer ID");

        jComboBox6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "In Progress", "On Hold", "Resolved", "Closed", "Escalated" }));

        jComboBox7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High", "Critical", "Urgent", "Normal" }));

        javax.swing.GroupLayout L_D_P4Layout = new javax.swing.GroupLayout(L_D_P4);
        L_D_P4.setLayout(L_D_P4Layout);
        L_D_P4Layout.setHorizontalGroup(
            L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(L_D_P4Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(L_Add4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(L_refresh4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(L_D_P4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(su_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        L_D_P4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {L_C_ID8, jComboBox6, jComboBox7});

        L_D_P4Layout.setVerticalGroup(
            L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(su_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(10, 10, 10)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_C_ID9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(11, 11, 11)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_C_ID8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(L_D_P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Add4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_refresh4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        L_D_P4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_C_ID8, L_C_ID9, jComboBox6, jComboBox7, su_ID});

        L_D_P4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_Add4, L_refresh4});

        L_D_T6.setBackground(new java.awt.Color(51, 204, 255));
        L_D_T6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Support_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Support_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ticket ID", "Customer ID", "Issue", "Status", "Priority"
            }
        ));
        jScrollPane9.setViewportView(Support_table);

        jPanel27.setBackground(new java.awt.Color(51, 255, 204));
        jPanel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        L_update6.setBackground(new java.awt.Color(204, 253, 246));
        L_update6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_update6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        L_update6.setText("Update");
        L_update6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_update6ActionPerformed(evt);
            }
        });

        L_delete6.setBackground(new java.awt.Color(204, 253, 246));
        L_delete6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_delete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        L_delete6.setText("Delete");
        L_delete6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_delete6ActionPerformed(evt);
            }
        });

        su_print.setBackground(new java.awt.Color(204, 253, 246));
        su_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        su_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        su_print.setText("Print");
        su_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                su_printActionPerformed(evt);
            }
        });

        su_logout.setBackground(new java.awt.Color(204, 253, 246));
        su_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        su_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        su_logout.setText("Logout");
        su_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                su_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(L_update6)
                .addGap(27, 27, 27)
                .addComponent(L_delete6)
                .addGap(27, 27, 27)
                .addComponent(su_print)
                .addGap(26, 26, 26)
                .addComponent(su_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_update6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_delete6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(su_print)
                    .addComponent(su_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel27Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_delete6, L_update6, su_logout, su_print});

        javax.swing.GroupLayout L_D_T6Layout = new javax.swing.GroupLayout(L_D_T6);
        L_D_T6.setLayout(L_D_T6Layout);
        L_D_T6Layout.setHorizontalGroup(
            L_D_T6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(L_D_T6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        L_D_T6Layout.setVerticalGroup(
            L_D_T6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_T6Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout SupportLayout = new javax.swing.GroupLayout(Support);
        Support.setLayout(SupportLayout);
        SupportLayout.setHorizontalGroup(
            SupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_D_P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_D_T6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SupportLayout.setVerticalGroup(
            SupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SupportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SupportLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(L_D_T6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(L_D_P4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GroupTab.addTab("Support ", Support);

        Analytics.setBackground(new java.awt.Color(0, 255, 204));

        L_D_P5.setBackground(new java.awt.Color(102, 204, 255));
        L_D_P5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(51, 255, 153), null, null));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel45.setText("Sales ID");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel47.setText("Marketing ID");

        L_C_ID10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_source9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        L_Add5.setBackground(new java.awt.Color(204, 253, 246));
        L_Add5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        L_Add5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add new.png"))); // NOI18N
        L_Add5.setText("Add");
        L_Add5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_Add5ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel48.setText("Report ID");

        anl_ID.setEditable(false);
        anl_ID.setBackground(new java.awt.Color(204, 204, 204));
        anl_ID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel22.setBackground(new java.awt.Color(0, 204, 204));
        jPanel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(153, 255, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 204, 255)));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Analytics Details");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        L_refresh5.setBackground(new java.awt.Color(204, 253, 246));
        L_refresh5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_refresh5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        L_refresh5.setText("Refresh");
        L_refresh5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_refresh5ActionPerformed(evt);
            }
        });

        L_C_ID11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel50.setText("Opportunity ID");

        javax.swing.GroupLayout L_D_P5Layout = new javax.swing.GroupLayout(L_D_P5);
        L_D_P5.setLayout(L_D_P5Layout);
        L_D_P5Layout.setHorizontalGroup(
            L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(L_D_P5Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(L_Add5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(L_refresh5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(L_D_P5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_source9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_C_ID11, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        L_D_P5Layout.setVerticalGroup(
            L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_P5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(10, 10, 10)
                .addGroup(L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_C_ID11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(11, 11, 11)
                .addGroup(L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_C_ID10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_source9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(114, 114, 114)
                .addGroup(L_D_P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_Add5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_refresh5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        L_D_P5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_C_ID10, L_C_ID11, L_source9, anl_ID});

        L_D_P5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_Add5, L_refresh5});

        L_D_T7.setBackground(new java.awt.Color(51, 204, 255));
        L_D_T7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(102, 255, 204), null, null));

        Analytics_table.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Analytics_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Report ID", "Opportunity ID", "Sales ID", "Marketing ID"
            }
        ));
        jScrollPane10.setViewportView(Analytics_table);

        jPanel28.setBackground(new java.awt.Color(51, 255, 204));
        jPanel28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), null, null));

        L_update7.setBackground(new java.awt.Color(204, 253, 246));
        L_update7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_update7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        L_update7.setText("Update");
        L_update7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_update7ActionPerformed(evt);
            }
        });

        L_delete7.setBackground(new java.awt.Color(204, 253, 246));
        L_delete7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        L_delete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        L_delete7.setText("Delete");
        L_delete7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_delete7ActionPerformed(evt);
            }
        });

        a_print.setBackground(new java.awt.Color(204, 253, 246));
        a_print.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        a_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        a_print.setText("Print");
        a_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_printActionPerformed(evt);
            }
        });

        an_logout.setBackground(new java.awt.Color(204, 253, 246));
        an_logout.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        an_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout.png"))); // NOI18N
        an_logout.setText("Logout");
        an_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(L_update7)
                .addGap(27, 27, 27)
                .addComponent(L_delete7)
                .addGap(27, 27, 27)
                .addComponent(a_print)
                .addGap(26, 26, 26)
                .addComponent(an_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_update7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_delete7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_print)
                    .addComponent(an_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_delete7, L_update7, a_print, an_logout});

        javax.swing.GroupLayout L_D_T7Layout = new javax.swing.GroupLayout(L_D_T7);
        L_D_T7.setLayout(L_D_T7Layout);
        L_D_T7Layout.setHorizontalGroup(
            L_D_T7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(L_D_T7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        L_D_T7Layout.setVerticalGroup(
            L_D_T7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(L_D_T7Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AnalyticsLayout = new javax.swing.GroupLayout(Analytics);
        Analytics.setLayout(AnalyticsLayout);
        AnalyticsLayout.setHorizontalGroup(
            AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnalyticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_D_P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L_D_T7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AnalyticsLayout.setVerticalGroup(
            AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnalyticsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(L_D_P5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(L_D_T7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupTab.addTab("Analytics ", Analytics);

        javax.swing.GroupLayout GroupPanelLayout = new javax.swing.GroupLayout(GroupPanel);
        GroupPanel.setLayout(GroupPanelLayout);
        GroupPanelLayout.setHorizontalGroup(
            GroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        GroupPanelLayout.setVerticalGroup(
            GroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MainDashBoardLayout = new javax.swing.GroupLayout(MainDashBoard);
        MainDashBoard.setLayout(MainDashBoardLayout);
        MainDashBoardLayout.setHorizontalGroup(
            MainDashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainDashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainDashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashBoard_Heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainDashBoardLayout.setVerticalGroup(
            MainDashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainDashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashBoard_Heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout DashBoardLayout = new javax.swing.GroupLayout(DashBoard);
        DashBoard.setLayout(DashBoardLayout);
        DashBoardLayout.setHorizontalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainDashBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
                .addContainerGap())
        );
        DashBoardLayout.setVerticalGroup(
            DashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainDashBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*========================= Customer Tab Button codes ========================================*/

    private void cus_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_AddActionPerformed

        int id = cus.getMax();
        String cname = Cus_Name.getText();
        String address = Cus_address.getText();
        String phone = Cus_phone.getText();
        String cra = Cus_time.getText();

        cus.insert(id, cname, address, phone, cra);
        Cus_table.setModel(new DefaultTableModel(null, new Object[]{"CustomerID", "Name", "Address", "Phone", "created_at"}));
        cus.getCustomerValues(Cus_table, "");
        clearc();
    }//GEN-LAST:event_cus_AddActionPerformed

    private void Cus_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cus_updateActionPerformed

        int id = Integer.parseInt(Cus_ID.getText());
        if (cus.isCIDExist(id)) {

            String cname = Cus_Name.getText();
            String address = Cus_address.getText();
            String phone = Cus_phone.getText();

            cus.updateCustomer(id, cname, address, phone);

        } else {
            JOptionPane.showMessageDialog(this, "Customer id dosen't exist");
        }
        clearc();
    }//GEN-LAST:event_Cus_updateActionPerformed

    private void Cus_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cus_deleteActionPerformed

        int id = Integer.parseInt(Cus_ID.getText());
        if (cus.isCIDExist(id)) {
            cus.deleteCustomer(id);
            Cus_table.setModel(new DefaultTableModel(null, new Object[]{"CustomerID", "Name", "Address", "Phone", "created_at"}));
            cus.getCustomerValues(Cus_table, "");
        } else {
            JOptionPane.showMessageDialog(this, "Customer id dosen't exist");
        }
        clearc();
    }//GEN-LAST:event_Cus_deleteActionPerformed

    private void Cus_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cus_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Cus_logoutActionPerformed

    private void Cus_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cus_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Customer's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Cus_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Cus_printActionPerformed

    private void Cus_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cus_refreshActionPerformed
        Cus_table.setModel(new DefaultTableModel(null, new Object[]{"CustomerID", "Name", "Address", "Phone", "created_at"}));
        cus.getCustomerValues(Cus_table, "");
        Cus_ID.setText(String.valueOf(cus.getMax()));
        Cus_Name.setText(null);
        Cus_address.setText(null);
        Cus_phone.setText(null);
        Cus_time.setText(null);
    }//GEN-LAST:event_Cus_refreshActionPerformed

    private void Con_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_addActionPerformed
        int cnid = con.getMax();
        String csid = Con_cusID.getText();
        String email = Con_email.getText();
        String phone = Con_phone.getText();
        String cra = Con_time.getText();

        con.insert(cnid, csid, email, phone, cra);
        Con_table.setModel(new DefaultTableModel(null, new Object[]{"ContactID", "CustomerID", "Email", "Phone"}));
        con.getContactsValues(Con_table, "");
        clearcon();
    }//GEN-LAST:event_Con_addActionPerformed

    private void Con_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_refreshActionPerformed
        Con_table.setModel(new DefaultTableModel(null, new Object[]{"ContactID", "CustomerID", "Email", "Phone"}));
        con.getContactsValues(Con_table, "");
        Con_cID.setText(String.valueOf(con.getMax()));
        Con_cusID.setText(null);
        Con_email.setText(null);
        Con_phone.setText(null);
        Con_time.setText(null);
    }//GEN-LAST:event_Con_refreshActionPerformed

    private void Con_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_updateActionPerformed
        int cid = Integer.parseInt(Con_cID.getText());
        if (con.isCnIDExist(cid)) {

            String csid = Con_cusID.getText();
            String email = Con_email.getText();
            String phone = Con_phone.getText();

            con.updateContacts(cid, csid, email, phone);

        } else {
            JOptionPane.showMessageDialog(this, "Contact id dosen't exist");
        }
        clearcon();
    }//GEN-LAST:event_Con_updateActionPerformed

    private void Con_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_deleteActionPerformed
        int cid = Integer.parseInt(Con_cID.getText());
        if (con.isCnIDExist(cid)) {
            con.deleteContacts(cid);
            Con_table.setModel(new DefaultTableModel(null, new Object[]{"ContactID", "CustomerID", "Email", "Phone", "created_at"}));
            con.getContactsValues(Con_table, "");
        } else {
            JOptionPane.showMessageDialog(this, "Contact id dosen't exist");
        }
        clearcon();
    }//GEN-LAST:event_Con_deleteActionPerformed

    private void Con_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Contact's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Con_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Con_printActionPerformed

    private void Con_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Con_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Con_logoutActionPerformed

    private void L_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_AddActionPerformed
        int lid = lead.getMax();
        String lname = L_name.getText();
        String cnid = L_C_ID.getText();
        String status = L_stat.getSelectedItem().toString();
        String source = L_source.getSelectedItem().toString();
        String cra = L_C_time.getText();

        lead.insert(lid, lname, cnid, status, source, cra);
        Lead_table.setModel(new DefaultTableModel(null, new Object[]{"LeadID", "Lead_name", "ContactID", "Status", "Source", "created_at"}));
        lead.getLeadsValues(Lead_table, "");
        clearl();
    }//GEN-LAST:event_L_AddActionPerformed

    private void L_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_refreshActionPerformed
        Lead_table.setModel(new DefaultTableModel(null, new Object[]{"LeadID", "Lead_name", "ContactID", "Status", "Source", "created_at"}));
        lead.getLeadsValues(Lead_table, "");
        L_ID.setText(String.valueOf(lead.getMax()));
        L_name.setText(null);
        L_C_ID.setText(null);
        L_stat.setSelectedIndex(0);
        L_source.setSelectedIndex(0);
        L_C_time.setText(null);
    }//GEN-LAST:event_L_refreshActionPerformed

    private void L_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_updateActionPerformed
        int lid = Integer.parseInt(L_ID.getText());
        if (lead.isLIDExist(lid)) {

            String lname = L_name.getText();
            String cnid = L_C_ID.getText();
            String status = L_stat.getSelectedItem().toString();
            String source = L_source.getSelectedItem().toString();

            lead.updateLeads(lid, lname, cnid, status, source);

        } else {
            JOptionPane.showMessageDialog(this, "Lead id dosen't exist");
        }
        clearl();
    }//GEN-LAST:event_L_updateActionPerformed

    private void L_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_deleteActionPerformed
        int lid = Integer.parseInt(L_ID.getText());
        if (lead.isLIDExist(lid)) {
            lead.deleteLeads(lid);
            Lead_table.setModel(new DefaultTableModel(null, new Object[]{"LeadID", "Lead_name", "ContactID", "Status", "Source"}));
            lead.getLeadsValues(Lead_table, "");
        } else {
            JOptionPane.showMessageDialog(this, "Lead id dosen't exist");
        }
        clearl();
    }//GEN-LAST:event_L_deleteActionPerformed

    private void L_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Lead's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Lead_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_L_printActionPerformed

    private void L_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_L_logoutActionPerformed

    private void o_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_AddActionPerformed
        int oid = opp.getMax();
        String oname = o_name.getText();
        String lid = o_l_ID.getText();
        String status = L_stat.getSelectedItem().toString();
        String pro = opro.getText();
        String amount = oam.getText();

        opp.insert(oid, oname, lid, status, pro, amount);
        Opp_table.setModel(new DefaultTableModel(null, new Object[]{"OpportunityID", "Opportunity_Name", "LeadID", "Status", "Probability", "Amount"}));
        opp.getOppValues(Opp_table, "");
        clearo();
    }//GEN-LAST:event_o_AddActionPerformed

    private void o_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_refreshActionPerformed
        Opp_table.setModel(new DefaultTableModel(null, new Object[]{"OpportunityID", "Opportunity_Name", "LeadID", "Status", "Probability", "Amount"}));
        opp.getOppValues(Opp_table, "");
        Opp_ID.setText(String.valueOf(opp.getMax()));
        o_name.setText(null);
        o_l_ID.setText(null);
        ostat.setSelectedIndex(0);
        opro.setText(null);
        oam.setText(null);
    }//GEN-LAST:event_o_refreshActionPerformed

    private void o_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_updateActionPerformed
        int oid = Integer.parseInt(Opp_ID.getText());
        if (opp.isOIDExist(oid)) {

            String oname = o_name.getText();
            String status = ostat.getSelectedItem().toString();
            String pro = opro.getText();
            String amount = oam.getText();

            opp.updateOOp(oid, oname, status, pro, amount);

        } else {
            JOptionPane.showMessageDialog(this, "Opportunity id dosen't exist");
        }
        clearo();
    }//GEN-LAST:event_o_updateActionPerformed

    private void o_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_deleteActionPerformed
        int oid = Integer.parseInt(Opp_ID.getText());
        if (opp.isOIDExist(oid)) {
            opp.deleteOOP(oid);
            Opp_table.setModel(new DefaultTableModel(null, new Object[]{"OpportunityID", "Opportunity_Name", "LeadID", "Status", "Probability", "Amount"}));
            opp.getOppValues(Opp_table, "");
        } else {
            JOptionPane.showMessageDialog(this, "Opportunity id dosen't exist");
        }
        clearo();
    }//GEN-LAST:event_o_deleteActionPerformed

    private void o_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Opportunity's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Opp_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_o_printActionPerformed

    private void op_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_op_logoutActionPerformed

    private void L_Add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_Add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_Add2ActionPerformed

    private void L_refresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_refresh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_refresh2ActionPerformed

    private void L_Add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_Add3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_Add3ActionPerformed

    private void L_refresh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_refresh3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_refresh3ActionPerformed

    private void L_Add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_Add4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_Add4ActionPerformed

    private void L_refresh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_refresh4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_refresh4ActionPerformed

    private void L_Add5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_Add5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_Add5ActionPerformed

    private void L_refresh5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_refresh5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_refresh5ActionPerformed

    private void L_update4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_update4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_update4ActionPerformed

    private void L_delete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_delete4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_delete4ActionPerformed

    private void s_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Sale's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Sales_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_s_printActionPerformed

    private void s_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_s_logoutActionPerformed

    private void L_update5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_update5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_update5ActionPerformed

    private void L_delete5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_delete5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_delete5ActionPerformed

    private void m_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Marketing's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Marketing_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_m_printActionPerformed

    private void m_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_m_logoutActionPerformed

    private void L_update6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_update6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_update6ActionPerformed

    private void L_delete6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_delete6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_delete6ActionPerformed

    private void su_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_su_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Support's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Support_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_su_printActionPerformed

    private void su_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_su_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_su_logoutActionPerformed

    private void L_update7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_update7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_update7ActionPerformed

    private void L_delete7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_delete7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_delete7ActionPerformed

    private void a_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_printActionPerformed
        try {
            MessageFormat header = new MessageFormat("Analytic's Information");
            MessageFormat footer = new MessageFormat("Page(0,number,integer");
            Analytics_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_a_printActionPerformed

    private void an_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an_logoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_an_logoutActionPerformed

    private void Cus_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cus_tableMouseClicked
        model = (DefaultTableModel) Cus_table.getModel();
        rowIndex = Cus_table.getSelectedRow();
        Cus_ID.setText(model.getValueAt(rowIndex, 0).toString());
        Cus_Name.setText(model.getValueAt(rowIndex, 1).toString());
        Cus_address.setText(model.getValueAt(rowIndex, 2).toString());
        Cus_phone.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_Cus_tableMouseClicked

    private void Con_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Con_tableMouseClicked
        model = (DefaultTableModel) Con_table.getModel();
        rowIndex = Con_table.getSelectedRow();
        Con_cID.setText(model.getValueAt(rowIndex, 0).toString());
        Con_cusID.setText(model.getValueAt(rowIndex, 1).toString());
        Con_email.setText(model.getValueAt(rowIndex, 2).toString());
        Con_phone.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_Con_tableMouseClicked

    private void Lead_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lead_tableMouseClicked
        model = (DefaultTableModel) Lead_table.getModel();
        rowIndex = Lead_table.getSelectedRow();
        L_ID.setText(model.getValueAt(rowIndex, 0).toString());
        L_name.setText(model.getValueAt(rowIndex, 1).toString());
        L_C_ID.setText(model.getValueAt(rowIndex, 2).toString());
        String stat = model.getValueAt(rowIndex, 3).toString();
        if (stat.equals(ABORT)) {
            L_stat.setSelectedIndex(1);
        }
        String source = model.getValueAt(rowIndex, 4).toString();
        if (source.equals(ABORT)) {
            L_source.setSelectedIndex(1);
        }
    }//GEN-LAST:event_Lead_tableMouseClicked

    private void L_C_ID4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_C_ID4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_L_C_ID4ActionPerformed

    private void lsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lsdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lsdActionPerformed

    private void Opp_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opp_tableMouseClicked
        model = (DefaultTableModel) Opp_table.getModel();
        rowIndex = Opp_table.getSelectedRow();
        Opp_ID.setText(model.getValueAt(rowIndex, 0).toString());
        o_name.setText(model.getValueAt(rowIndex, 1).toString());
        o_l_ID.setText(model.getValueAt(rowIndex, 2).toString());
        String stat = model.getValueAt(rowIndex, 3).toString();
        if (stat.equals(ABORT)) {
            ostat.setSelectedIndex(1);
        }
        opro.setText(model.getValueAt(rowIndex, 4).toString());
        oam.setText(model.getValueAt(rowIndex, 5).toString());
    }//GEN-LAST:event_Opp_tableMouseClicked

    /*============================================================================================*/
    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    txtTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    txtDate.setText(df.format(date));
                }
            }
        }).start();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Analytics;
    private javax.swing.JTable Analytics_table;
    private javax.swing.JPanel Con_D_P;
    private javax.swing.JPanel Con_D_T;
    private javax.swing.JButton Con_add;
    private javax.swing.JTextField Con_cID;
    private javax.swing.JTextField Con_cusID;
    private javax.swing.JButton Con_delete;
    private javax.swing.JTextField Con_email;
    private javax.swing.JButton Con_logout;
    private javax.swing.JTextField Con_phone;
    private javax.swing.JButton Con_print;
    private javax.swing.JButton Con_refresh;
    private javax.swing.JTable Con_table;
    private javax.swing.JTextField Con_time;
    private javax.swing.JButton Con_update;
    private javax.swing.JPanel Contacts;
    private javax.swing.JPanel Cus_D_P;
    private javax.swing.JPanel Cus_D_T;
    private javax.swing.JTextField Cus_ID;
    private javax.swing.JTextField Cus_Name;
    private javax.swing.JTextField Cus_address;
    private javax.swing.JButton Cus_delete;
    private javax.swing.JButton Cus_logout;
    private javax.swing.JTextField Cus_phone;
    private javax.swing.JButton Cus_print;
    private javax.swing.JButton Cus_refresh;
    private javax.swing.JTable Cus_table;
    private javax.swing.JTextField Cus_time;
    private javax.swing.JButton Cus_update;
    private javax.swing.JPanel Customer;
    private javax.swing.JPanel DashBoard;
    private javax.swing.JPanel DashBoard_Heading;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel GroupPanel;
    private raven.tabbed.TabbedPaneCustom GroupTab;
    private javax.swing.JButton L_Add;
    private javax.swing.JButton L_Add2;
    private javax.swing.JButton L_Add3;
    private javax.swing.JButton L_Add4;
    private javax.swing.JButton L_Add5;
    private javax.swing.JTextField L_C_ID;
    private javax.swing.JTextField L_C_ID10;
    private javax.swing.JTextField L_C_ID11;
    private javax.swing.JTextField L_C_ID12;
    private javax.swing.JTextField L_C_ID4;
    private javax.swing.JTextField L_C_ID6;
    private javax.swing.JTextField L_C_ID7;
    private javax.swing.JTextField L_C_ID8;
    private javax.swing.JTextField L_C_ID9;
    private javax.swing.JTextField L_C_time;
    private javax.swing.JPanel L_D_P;
    private javax.swing.JPanel L_D_P1;
    private javax.swing.JPanel L_D_P2;
    private javax.swing.JPanel L_D_P3;
    private javax.swing.JPanel L_D_P4;
    private javax.swing.JPanel L_D_P5;
    private javax.swing.JPanel L_D_T;
    private javax.swing.JPanel L_D_T1;
    private javax.swing.JPanel L_D_T4;
    private javax.swing.JPanel L_D_T5;
    private javax.swing.JPanel L_D_T6;
    private javax.swing.JPanel L_D_T7;
    private javax.swing.JTextField L_ID;
    private javax.swing.JButton L_delete;
    private javax.swing.JButton L_delete4;
    private javax.swing.JButton L_delete5;
    private javax.swing.JButton L_delete6;
    private javax.swing.JButton L_delete7;
    private javax.swing.JButton L_logout;
    private javax.swing.JTextField L_name;
    private javax.swing.JButton L_print;
    private javax.swing.JButton L_refresh;
    private javax.swing.JButton L_refresh2;
    private javax.swing.JButton L_refresh3;
    private javax.swing.JButton L_refresh4;
    private javax.swing.JButton L_refresh5;
    private javax.swing.JComboBox<String> L_source;
    private javax.swing.JTextField L_source3;
    private javax.swing.JTextField L_source4;
    private javax.swing.JTextField L_source5;
    private javax.swing.JTextField L_source6;
    private javax.swing.JTextField L_source9;
    private javax.swing.JComboBox<String> L_stat;
    private javax.swing.JButton L_update;
    private javax.swing.JButton L_update4;
    private javax.swing.JButton L_update5;
    private javax.swing.JButton L_update6;
    private javax.swing.JButton L_update7;
    private javax.swing.JTable Lead_table;
    private javax.swing.JPanel Leads;
    private javax.swing.JPanel MainDashBoard;
    private javax.swing.JLabel MainHeading;
    private javax.swing.JPanel Marketing;
    private javax.swing.JTable Marketing_table;
    private javax.swing.JTextField Opp_ID;
    private javax.swing.JTable Opp_table;
    private javax.swing.JPanel Opportunities;
    private javax.swing.JPanel Sales;
    private javax.swing.JTable Sales_table;
    private javax.swing.JPanel Support;
    private javax.swing.JTable Support_table;
    private javax.swing.JButton a_print;
    private javax.swing.JButton an_logout;
    private javax.swing.JTextField anl_ID;
    private javax.swing.JLabel cam;
    private javax.swing.JLabel cos;
    private javax.swing.JButton cus_Add;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField lsd;
    private javax.swing.JTextField m_ID;
    private javax.swing.JButton m_logout;
    private javax.swing.JButton m_print;
    private javax.swing.JLabel newCustomers;
    private javax.swing.JButton o_Add;
    private javax.swing.JButton o_delete;
    private javax.swing.JTextField o_l_ID;
    private javax.swing.JTextField o_name;
    private javax.swing.JButton o_print;
    private javax.swing.JButton o_refresh;
    private javax.swing.JButton o_update;
    private javax.swing.JTextField oam;
    private javax.swing.JLabel oops;
    private javax.swing.JButton op_logout;
    private javax.swing.JTextField opro;
    private javax.swing.JLabel opt;
    private javax.swing.JComboBox<String> ostat;
    private javax.swing.JLabel pri;
    private javax.swing.JLabel rp;
    private javax.swing.JLabel rpt;
    private javax.swing.JButton s_logout;
    private javax.swing.JButton s_print;
    private javax.swing.JTextField sa_ID;
    private javax.swing.JLabel stts;
    private javax.swing.JLabel sttso;
    private javax.swing.JTextField su_ID;
    private javax.swing.JButton su_logout;
    private javax.swing.JButton su_print;
    private javax.swing.JLabel tc;
    private javax.swing.JLabel tcn;
    private javax.swing.JLabel tcne;
    private javax.swing.JLabel tcnne;
    private javax.swing.JLabel tnl;
    private javax.swing.JLabel tnln;
    private javax.swing.JLabel totalCustomers;
    private javax.swing.JLabel trs;
    private javax.swing.JLabel trsn;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
}
