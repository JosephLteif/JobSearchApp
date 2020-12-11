/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DTO.PasswordReset;
import DTO.User;
import Repositories.RepoPasswordReset;
import Repositories.RepoUser;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import utilities.Regex;
import utilities.EmailClass;
import utilities.TokenGenerator;

/**
 *
 * @author Lama
 */
public class SignUpForm extends javax.swing.JFrame {

    int gender = 1;
    EmailClass sendmail = new EmailClass();

    public String confmail;
    public String token;
    RepoUser repoU = new RepoUser();
    RepoPasswordReset repoP = new RepoPasswordReset();

    public SignUpForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        X = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ComboGender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign Up");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        X.setBackground(new java.awt.Color(51, 102, 255));
        X.setForeground(new java.awt.Color(255, 255, 255));
        X.setText("X");
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        jPanel2.add(X, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 70));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel3.setText("First name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 30));

        jLabel4.setText("Last name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 30));

        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 40, 30));
        jPanel1.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 210, -1));
        jPanel1.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 210, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 210, -1));

        jLabel7.setText("Gender");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 30));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        ComboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        jPanel1.add(ComboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        this.dispose();
    }//GEN-LAST:event_XActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String fn = this.txtFname.getText();
        String ln = this.txtLname.getText();
        String email = this.txtEmail.getText();
        confmail = this.txtEmail.getText();
         
     

        if (ComboGender.getSelectedItem().equals("Male")) {
            gender = 2;
        }

        String ems = "";

        Component frame = null;

        if (!Regex.isValidName(fn) || !Regex.isValidName(ln) || !Regex.isValidEmail(email)) {
            if (!Regex.isValidName(fn)) {
                ems = ems + "Invalid first name.\n";
            } else if (!Regex.isValidName(ln)) {
                ems = ems + "Invalid last name";
            } else if (!Regex.isValidEmail(email)) {
                ems = ems + "Invalid email address";
            }



            JOptionPane.showMessageDialog(frame, ems,
                    "Sign up failed", JOptionPane.ERROR_MESSAGE);
        } else {

            token = TokenGenerator.generatetxt();
            PasswordReset pr = new PasswordReset(confmail, token);

            User newUser = new User(fn, ln, email, gender);
            if (new RepoUser().create(newUser)) {

                try {
                    if (repoP.insert(pr)) {

                        Thread T1 = new Thread(() -> {
                            try {
                                String sub = "Sign up verfication!";
                                String body = "Dear " + newUser.getFname() + " " + newUser.getLname() + ",<br> We'd like to welcome you in our app!Hoping that you'll find your dream job through our app!<br> "
                                        + "But first we need to verify your email. So kindly enter this code: <br>" + pr.getTok() + "<br>"
                                        + "For any complaints, you can reach us on this email.";
                                String[] mails = new String[1];
                                mails[0] = newUser.getEmail();
                                sendmail.sendFromGmail(mails, sub, body, null, null, null);

                            } catch (MessagingException ex) {
                                System.out.println(ex.getMessage());
                            }
                        });
                        T1.start();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                new SignupConfirmMailForm(pr.getEmail()).setVisible(true);

                this.dispose();

                repoU.Destroy();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    
    /**
     */
    public static void signUp() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SignUpForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboGender;
    private javax.swing.JButton X;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    // End of variables declaration//GEN-END:variables
}
