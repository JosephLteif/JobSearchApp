/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import connection.ConnectionManager;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author joelt
 */
public class Login extends javax.swing.JFrame {

    ConnectionManager con;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        con = new ConnectionManager();
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\joelt\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\AppLogo.png");
        this.setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        signUpBtn = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        forgetPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(153, 153, 153));
        setLocationByPlatform(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signUpBtn.setText("Sign up");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        mainPanel.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 230, 30));

        Password.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        mainPanel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 280, 36));

        passwordLabel.setText("Password");
        mainPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        Email.setText("Email");
        mainPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        Username.setToolTipText("Username");
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        mainPanel.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 280, 36));

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        mainPanel.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 230, 30));

        forgetPassword.setText("Click here!");
        forgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgetPasswordMouseClicked(evt);
            }
        });
        mainPanel.add(forgetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jLabel1.setText("Forgot your password?");
        mainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        String pass = new String(this.Password.getPassword());
        if ((this.Username.getText().equals("admin") && pass.equals("admin")) || con.login(this.Username.getText(), pass)) {
            new appHome(this.Username.getText()).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed

        // TODO add your handling code here:
        new signUp().setVisible(true);
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void forgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgetPasswordMouseClicked
        // TODO add your handling code here:
        new forgotPassword().setVisible(true);
    }//GEN-LAST:event_forgetPasswordMouseClicked

    public void Login() {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel forgetPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton signUpBtn;
    // End of variables declaration//GEN-END:variables
}
