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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Lama
 */
public class viewProfile extends javax.swing.JFrame {

    private int xx = 0;
    private int yy = 0;
    /**
     * Creates new form viewProfile
     */
    User u;
    User u1;

    public viewProfile(User u, User u1) {
        setUndecorated(true);
        initComponents();
        this.u = u;
        this.u1 = u1;
        this.lblfname.setText(u.getFname());
        this.lbllname.setText(u.getLname());
        this.lbldob.setText(u.getDob());
        this.lblemail.setText(u.getEmail());
        this.lbllocation.setText(u.getLocation());
        this.lblmajor.setText(u.getMajor());
        this.lblphonenumber.setText(u.getPhoneNumber());
        if (!(u.getPP() == null)) {
            Image Im = null;
            try {
                Im = ImageIO.read(new File(u.getPP()));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Im = FileChooserForm.resizeImage(Im, 100, 100);
            this.Image.setIcon(new ImageIcon(Im));
        }
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(457, 100));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        X1.setBackground(new java.awt.Color(51, 102, 255));
        X1.setForeground(new java.awt.Color(255, 255, 255));
        X1.setText("X");
        X1.setBorderPainted(false);
        X1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                X1ActionPerformed(evt);
            }
        });
        jPanel2.add(X1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 20));

        lblfname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblfname.setForeground(new java.awt.Color(255, 255, 255));
        lblfname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfname.setText("jLabel2");
        jPanel2.add(lblfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 70, 30));

        lbllname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbllname.setForeground(new java.awt.Color(255, 255, 255));
        lbllname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllname.setText("jLabel3");
        jPanel2.add(lbllname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 70, 30));

        Image.setBackground(new java.awt.Color(102, 255, 255));
        Image.setForeground(new java.awt.Color(51, 255, 255));
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/e01d8c8ac8d02856d9ca18a0_rw_1920_1.jpg"))); // NOI18N
        jPanel2.add(Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 120));
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

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Send Email");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new SendEmailToUser(u,u1).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
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
