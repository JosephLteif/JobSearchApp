/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author joelt
 */
public class AppHomeForm extends javax.swing.JFrame {

    int xx = 0;
    int yy = 0;

    /**
     * Creates new form appHomeFrm
     */
    public AppHomeForm() {
        this.oldColor = new Color(51, 102, 255);
        this.backColor = new Color(51, 153, 255);
        initComponents();
    }

    public AppHomeForm(String username) {
        this.oldColor = new Color(51, 102, 255);
        this.backColor = new Color(51, 153, 255);
        setUndecorated(true);
        initComponents();
        this.username = username;
        jLabel6.setText(jLabel6.getText() + " " + this.username);
        jLayeredPane1.moveToFront(HomePanel);
        Title.setText(this.username + "'s Page");
        EditButton.setVisible(false);
        SearchBar.setVisible(false);
        jLabel2.setVisible(false);
        
        jTextField1.setVisible(false);
        jTextField10.setVisible(false);
        jTextField11.setVisible(false);
        jTextField12.setVisible(false);
        jTextField13.setVisible(false);
        jTextField14.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField6.setVisible(false);
        jTextField7.setVisible(false);
        jTextField8.setVisible(false);
        jTextField9.setVisible(false);
    }

    public static void setProfilePanel(ImageIcon I) {
        profilePicture.setIcon(I);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        searchOption = new javax.swing.JPanel();
        Searchlogo = new javax.swing.JLabel();
        Search = new javax.swing.JLabel();
        homeOption = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        profileOption = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        X = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        HomePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        mainText = new javax.swing.JTextArea();
        ProfilePanel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        EditButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        Title = new javax.swing.JLabel();
        profilePicture = new javax.swing.JLabel();
        SearchPanel = new javax.swing.JTabbedPane();
        SearchUsers = new javax.swing.JPanel();
        SearchBar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        SearchCompanies = new javax.swing.JPanel();
        SearchBar2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        SearchJobs = new javax.swing.JPanel();
        SearchBar1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Page");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel.setBackground(new java.awt.Color(51, 102, 255));
        menuPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuPanelMouseDragged(evt);
            }
        });
        menuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanelMousePressed(evt);
            }
        });
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home");
        menuPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        menuPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 101, 10));

        searchOption.setBackground(new java.awt.Color(51, 102, 255));
        searchOption.setPreferredSize(new java.awt.Dimension(229, 96));
        searchOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchOptionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchOptionMouseReleased(evt);
            }
        });
        searchOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Searchlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/search-logo.png"))); // NOI18N
        searchOption.add(Searchlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        Search.setBackground(new java.awt.Color(102, 0, 102));
        Search.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");
        searchOption.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        menuPanel.add(searchOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 210, 41));

        homeOption.setBackground(new java.awt.Color(51, 102, 255));
        homeOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeOptionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeOptionMouseReleased(evt);
            }
        });
        homeOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/icons8-home-26.png"))); // NOI18N
        homeOption.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Home");
        homeOption.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        menuPanel.add(homeOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 181, 210, 40));

        profileOption.setBackground(new java.awt.Color(51, 102, 255));
        profileOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                profileOptionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                profileOptionMouseReleased(evt);
            }
        });
        profileOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/icons8-person-64.png"))); // NOI18N
        profileOption.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel7.setBackground(new java.awt.Color(102, 0, 102));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Profile");
        profileOption.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 60, -1));

        menuPanel.add(profileOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 228, 210, 40));

        jPanel1.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 204, 498));

        X.setBackground(new java.awt.Color(255, 255, 255));
        X.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        X.setText("X");
        X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                XMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                XMousePressed(evt);
            }
        });
        jPanel1.add(X, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, -1, -1));

        HomePanel.setBackground(new java.awt.Color(255, 255, 255));
        HomePanel.setPreferredSize(new java.awt.Dimension(578, 504));
        HomePanel.setVerifyInputWhenFocusTarget(false);
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel10.setText("Home Page");
        HomePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        HomePanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 198, 10));

        mainText.setEditable(false);
        mainText.setColumns(20);
        mainText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mainText.setRows(5);
        mainText.setText("\nThis application connects job seekers with \nemployers looking to hire. Companies can post job opportunities, \nand job seekers can apply to these jobs based on their preferences.\nThis platform helps business leaders to hire people based on their\nneeds, as it helps job seekers to catch their dream jobs.");
        mainText.setBorder(null);
        mainText.setFocusable(false);
        HomePanel.add(mainText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        ProfilePanel.setBackground(new java.awt.Color(255, 255, 255));
        ProfilePanel.setPreferredSize(new java.awt.Dimension(578, 504));
        ProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setEnabled(false);
        ProfilePanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 180, 233, -1));

        jTextField2.setEnabled(false);
        ProfilePanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 206, 233, -1));

        jTextField3.setEnabled(false);
        ProfilePanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 232, 233, -1));

        jTextField6.setEnabled(false);
        ProfilePanel.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 258, 233, -1));

        jTextField7.setEnabled(false);
        ProfilePanel.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 284, 233, -1));

        jTextField8.setEnabled(false);
        ProfilePanel.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 310, 233, -1));

        jTextField9.setEnabled(false);
        ProfilePanel.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 336, 233, -1));

        jTextField10.setEnabled(false);
        ProfilePanel.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 362, 233, -1));

        jTextField11.setEnabled(false);
        ProfilePanel.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 388, 233, -1));

        jTextField12.setEnabled(false);
        ProfilePanel.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 414, 233, -1));

        jTextField13.setEnabled(false);
        ProfilePanel.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 440, 233, -1));

        jTextField14.setEnabled(false);
        ProfilePanel.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 466, 233, -1));

        jLabel24.setText("Last Job");
        ProfilePanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 468, -1, -1));

        jLabel22.setText("Years of experience");
        ProfilePanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 442, -1, -1));

        jLabel23.setText("GPA");
        ProfilePanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 414, -1, -1));

        jLabel21.setText("Major");
        ProfilePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 388, -1, -1));

        jLabel20.setText("Degree");
        ProfilePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 362, -1, -1));

        jLabel19.setText("PhoneNumber");
        ProfilePanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 336, -1, -1));

        jLabel18.setText("Email");
        ProfilePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 310, -1, -1));

        jLabel17.setText("Country");
        ProfilePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 284, -1, -1));

        jLabel16.setText("Region");
        ProfilePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 260, -1, -1));

        jLabel15.setText("City");
        ProfilePanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 236, -1, -1));

        jLabel14.setText("LastName");
        ProfilePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 210, -1, -1));

        jLabel13.setText("FirstName");
        ProfilePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 182, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Upload image");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        ProfilePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Welcome");
        ProfilePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 35, -1, -1));
        ProfilePanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, 64, 10));

        EditButton.setBackground(new java.awt.Color(255, 255, 255));
        EditButton.setText("Edit Info");
        EditButton.setBorder(null);
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        ProfilePanel.add(EditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 158, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        ProfilePanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 88, -1, 398));

        Title.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Title.setText("Title");
        ProfilePanel.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 88, 350, 60));

        profilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/e01d8c8ac8d02856d9ca18a0_rw_1920_1.jpg"))); // NOI18N
        ProfilePanel.add(profilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        SearchPanel.setBackground(new java.awt.Color(255, 255, 255));

        SearchUsers.setBackground(new java.awt.Color(255, 255, 255));
        SearchUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchBarKeyPressed(evt);
            }
        });
        SearchUsers.add(SearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 29, 491, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        Table.setForeground(new java.awt.Color(255, 255, 255));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FirstName", "LastName", "Years of Experience", "Job Title", "Email", "Degree"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(Table);

        SearchUsers.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 540, 404));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Search");
        SearchUsers.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 25, -1, -1));

        SearchPanel.addTab("Search for Users", SearchUsers);

        SearchCompanies.setBackground(new java.awt.Color(255, 255, 255));
        SearchCompanies.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchBar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchBar2KeyPressed(evt);
            }
        });
        SearchCompanies.add(SearchBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 29, 491, -1));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Website", "PhoneNumber1", "PhoneNumber2", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table2.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(Table2);

        SearchCompanies.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 540, 404));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Search");
        SearchCompanies.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 25, -1, -1));

        SearchPanel.addTab("Search for companies", SearchCompanies);

        SearchJobs.setBackground(new java.awt.Color(255, 255, 255));
        SearchJobs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchBar1KeyPressed(evt);
            }
        });
        SearchJobs.add(SearchBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 29, 491, -1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployerName", "Job Description", "Type", "SkillName", "CompanyName", "SkillLevel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(Table1);

        SearchJobs.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 540, 400));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Search");
        SearchJobs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 25, -1, -1));

        SearchPanel.addTab("SearchJobs", SearchJobs);

        jLayeredPane1.setLayer(HomePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ProfilePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(SearchPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(ProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(HomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProfilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        SearchPanel.getAccessibleContext().setAccessibleName("Search for Users");
        SearchPanel.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 0, 574, 495));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // TODO add your handling code here:
        if (!jTextField1.isEnabled()) {
            jTextField1.setEnabled(true);
            jTextField10.setEnabled(true);
            jTextField11.setEnabled(true);
            jTextField12.setEnabled(true);
            jTextField13.setEnabled(true);
            jTextField14.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(true);
            jTextField6.setEnabled(true);
            jTextField7.setEnabled(true);
            jTextField8.setEnabled(true);
            jTextField9.setEnabled(true);
        } else {
            jTextField1.setEnabled(false);
            jTextField10.setEnabled(false);
            jTextField11.setEnabled(false);
            jTextField12.setEnabled(false);
            jTextField13.setEnabled(false);
            jTextField14.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
            jTextField6.setEnabled(false);
            jTextField7.setEnabled(false);
            jTextField8.setEnabled(false);
            jTextField9.setEnabled(false);
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void profileOptionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileOptionMouseReleased
        // TODO add your handling code here:
        profileOption.setBackground(oldColor);
    }//GEN-LAST:event_profileOptionMouseReleased

    private void profileOptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileOptionMousePressed
        // TODO add your handling code here:

        jTextField1.setVisible(true);
        jTextField10.setVisible(true);
        jTextField11.setVisible(true);
        jTextField12.setVisible(true);
        jTextField13.setVisible(true);
        jTextField14.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
        jTextField6.setVisible(true);
        jTextField7.setVisible(true);
        jTextField8.setVisible(true);
        jTextField9.setVisible(true);

        EditButton.setVisible(true);
        HomePanel.setVisible(false);
        SearchPanel.setVisible(false);
        jLayeredPane1.moveToFront(ProfilePanel);
        profileOption.setBackground(backColor);
    }//GEN-LAST:event_profileOptionMousePressed

    private void homeOptionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeOptionMouseReleased
        // TODO add your handling code here:
        homeOption.setBackground(oldColor);
    }//GEN-LAST:event_homeOptionMouseReleased

    private void homeOptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeOptionMousePressed
        // TODO add your handling code here:
        EditButton.setVisible(false);
        HomePanel.setVisible(true);
        SearchPanel.setVisible(false);
        jLayeredPane1.moveToFront(HomePanel);
        homeOption.setBackground(backColor);
        jLabel6.setText("");
        jLabel6.setText("Welcome " + this.username);
    }//GEN-LAST:event_homeOptionMousePressed

    private void searchOptionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchOptionMouseReleased
        // TODO add your handling code here:
        searchOption.setBackground(oldColor);
    }//GEN-LAST:event_searchOptionMouseReleased

    private void searchOptionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchOptionMousePressed
        // TODO add your handling code here:
        SearchBar.setVisible(true);
        jLabel2.setVisible(true);
        searchOption.setBackground(backColor);
        EditButton.setVisible(false);
        HomePanel.setVisible(false);
        SearchPanel.setVisible(true);
        jLayeredPane1.moveToFront(SearchPanel);
    }//GEN-LAST:event_searchOptionMousePressed

    private void XMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XMousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_XMousePressed

    private void SearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyPressed
        // TODO add your handling code here:
        if (!SearchBar.getText().equals("")) {
            /*MySQLConnectionManager.searchjobseeker(SearchBar.getText());*/
        }
    }//GEN-LAST:event_SearchBarKeyPressed

    private void SearchBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBar1KeyPressed
        // TODO add your handling code here:
        /* MySQLConnectionManager.SearchJobOffer(SearchBar1.getText());*/
    }//GEN-LAST:event_SearchBar1KeyPressed

    private void SearchBar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBar2KeyPressed
        // TODO add your handling code here:
        /* MySQLConnectionManager.searchCompany(SearchBar2.getText());*/
    }//GEN-LAST:event_SearchBar2KeyPressed

    private void menuPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanelMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_menuPanelMousePressed

    private void menuPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_menuPanelMouseDragged

    private void XMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_XMouseEntered

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        new FileChooserForm(this.username).setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AppHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppHomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AppHomeForm().setVisible(true);
        });
    }

    private Image I;
    static protected String username = new String();
    private final Color backColor;
    private final Color oldColor;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButton;
    private javax.swing.JPanel HomePanel;
    protected static javax.swing.JPanel ProfilePanel;
    private javax.swing.JLabel Search;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JTextField SearchBar1;
    private javax.swing.JTextField SearchBar2;
    private javax.swing.JPanel SearchCompanies;
    private javax.swing.JPanel SearchJobs;
    private javax.swing.JTabbedPane SearchPanel;
    private javax.swing.JPanel SearchUsers;
    private javax.swing.JLabel Searchlogo;
    public static javax.swing.JTable Table;
    public static javax.swing.JTable Table1;
    public static javax.swing.JTable Table2;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel X;
    private javax.swing.JPanel homeOption;
    private javax.swing.JDialog jDialog1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    protected static javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField10;
    public static javax.swing.JTextField jTextField11;
    public static javax.swing.JTextField jTextField12;
    public static javax.swing.JTextField jTextField13;
    public static javax.swing.JTextField jTextField14;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField jTextField9;
    private javax.swing.JTextArea mainText;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel profileOption;
    private static javax.swing.JLabel profilePicture;
    private javax.swing.JPanel searchOption;
    // End of variables declaration//GEN-END:variables
}
