/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DTO.PasswordReset;
import Repositories.RepoPasswordReset;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import utilities.EmailClass;
import utilities.Regex;
import utilities.TokenGenerator;

/**
 *
 * @author joelt
 */
public class ForgotPasswordForm extends javax.swing.JFrame {

    RepoPasswordReset repoP=new RepoPasswordReset();
    EmailClass sendmail = new EmailClass();
    public  String confmail;
    public  String token;
    /**
     * Creates new form forgotPassword
     */
    public ForgotPasswordForm() {
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
        jLabel3 = new javax.swing.JLabel();
        txtmail = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Forgot your password");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Dear user, kindly confirm your email: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 310, 40));

        txtmail.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 220, 30));

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        confmail=this.txtmail.getText();
        confmail = confmail.toLowerCase();
        String ems = "";
        Component frame = null;
       if (!Regex.isValidEmail(confmail)){
           ems = ems + "Invalid email address";
           JOptionPane.showMessageDialog(frame, ems,
           "Email confirmation", JOptionPane.ERROR_MESSAGE);
           
       }
      else try {
          if (!repoP.foundmail(confmail)){
              ems = ems + "No accounts associated with this mail!";
              JOptionPane.showMessageDialog(frame, ems,
                      "Account not found", JOptionPane.ERROR_MESSAGE);
          }
          else{
              
              token=TokenGenerator.generatetxt();
              
              
              
              PasswordReset pr=new PasswordReset(confmail,token);
              
              
              try {
                  if (repoP.insert(pr)){
                      Thread T1 = new Thread(() -> {
                          try {
                              String sub = "Reset your Jobify Password!";
                              String body = "Dear user, kindly find your code below.<br><br> " + token+"<br><br>For any complaints, you can reach us on this email.";
                              String[] mails = new String[1];
                              mails[0] = confmail;
                              sendmail.sendFromGmail(mails, sub, body);
                          } catch (MessagingException ex) {
                              Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      });
                      T1.start();
                      
                      
                      
                      ForgotPass2Form frm2=new ForgotPass2Form(pr);
                      
                      frm2.addWindowListener(new java.awt.event.WindowAdapter(){
                          
                          @Override
                          public void windowClosed(java.awt.event.WindowEvent windowEvent){
                              
                          }
                      });
                      
                      frm2.setVisible(true);
                  }
              } catch (SQLException ex) {
                  Logger.getLogger(ForgotPasswordForm.class.getName()).log(Level.SEVERE, null, ex);
              }
              
              
              
          }} catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordForm.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         
           
       repoP.Destroy();
             
        this.dispose();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void forgotPassword() {
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
            java.util.logging.Logger.getLogger(ForgotPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPasswordForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.TextField txtmail;
    // End of variables declaration//GEN-END:variables
}
