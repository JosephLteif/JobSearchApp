/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DTO.User;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Lama
 */
public class viewProfile extends javax.swing.JFrame {

    /**
     * Creates new form viewProfile
     */
    User u;

    public viewProfile(User u) {
        initComponents();
        this.u = u;
        this.lblfname.setText(u.getFname());
        this.lbllname.setText(u.getLname());
        this.lbldob.setText(u.getDob());
        this.lblemail.setText(u.getEmail());
        this.lbllocation.setText(u.getLocation());
        this.lblmajor.setText(u.getMajor());
        this.lblphonenumber.setText(u.getPhoneNumber());
        System.out.println(u.getUid());
        Image Im = null;
        try {
            Im = ImageIO.read(new File(u.getPP()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Im = FileChooserForm.resizeImage(Im, 100, 100);
        this.Image.setIcon(new ImageIcon(Im));
    }

    private viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        X1 = new javax.swing.JButton();
        lblfname = new javax.swing.JLabel();
        lbllname = new javax.swing.JLabel();
        Image = new javax.swing.JLabel();
        lnamelbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbldob = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblphonenumber = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblmajor = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbllocation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(457, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        X1.setBackground(new java.awt.Color(51, 153, 255));
        X1.setForeground(new java.awt.Color(255, 255, 255));
        X1.setText("X");
        X1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                X1ActionPerformed(evt);
            }
        });
        jPanel2.add(X1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 20));

        lblfname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfname.setForeground(new java.awt.Color(255, 255, 255));
        lblfname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfname.setText("jLabel2");
        jPanel2.add(lblfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 70, 30));

        lbllname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbllname.setForeground(new java.awt.Color(255, 255, 255));
        lbllname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllname.setText("jLabel3");
        jPanel2.add(lbllname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 70, 30));
        jPanel2.add(Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 120));
        jPanel1.add(lnamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Date of birth");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lbldob.setText("jLabel6");
        jPanel1.add(lbldob, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lblemail.setText("jLabel7");
        jPanel1.add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        lblphonenumber.setText("jLabel8");
        jPanel1.add(lblphonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Major");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Phone Number");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        lblmajor.setText("jLabel11");
        jPanel1.add(lblmajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Location");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        lbllocation.setText("jLabel13");
        jPanel1.add(lbllocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void X1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_X1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_X1ActionPerformed

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
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new viewProfile().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image;
    private javax.swing.JButton X1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbldob;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lbllname;
    private javax.swing.JLabel lbllocation;
    private javax.swing.JLabel lblmajor;
    private javax.swing.JLabel lblphonenumber;
    private javax.swing.JLabel lnamelbl;
    // End of variables declaration//GEN-END:variables
}
