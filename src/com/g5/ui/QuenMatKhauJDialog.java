/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.g5.ui;

import com.g5.DAO.NhanVienDAO;
import com.g5.entity.NhanVien;
import com.g5.entityDAO.NhanVienDAOImpl;
import com.g5.util.Auth;
import com.g5.util.JDBCHelper;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

/**
 *
 * @author KIM NGAN
 */
public class QuenMatKhauJDialog extends javax.swing.JDialog {

    private JFrame frame;
    XacNhanMatKhauJDiaLog doiMatKhauDialog = new XacNhanMatKhauJDiaLog(frame, true);

    /**
     * Creates new form QuenMatKhauJDialog
     */
    public QuenMatKhauJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.frame = (JFrame) parent;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quên mật khẩu");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        newJPanel1 = new com.g5.ui.NewJPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuiMaXN = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        btnTiepTuc = new javax.swing.JButton();
        txtMaXN = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTaiKhoan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
        jLabel2.setText("Quên mật khẩu");

        btnGuiMaXN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuiMaXN.setText("Gửi");
        btnGuiMaXN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMaXNActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã xác nhận");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên tài khoản");

        btnThoat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThoat.setText("Thoát");

        btnTiepTuc.setBackground(new java.awt.Color(51, 204, 255));
        btnTiepTuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTiepTuc.setForeground(new java.awt.Color(0, 0, 0));
        btnTiepTuc.setText("Tiếp Tục");
        btnTiepTuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiepTucActionPerformed(evt);
            }
        });

        txtEmail.setText("tvugiang@gmail.com");

        txtTaiKhoan.setText("NV1");

        javax.swing.GroupLayout newJPanel1Layout = new javax.swing.GroupLayout(newJPanel1);
        newJPanel1.setLayout(newJPanel1Layout);
        newJPanel1Layout.setHorizontalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(txtTaiKhoan)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaXN, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuiMaXN))
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addComponent(btnTiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat))
                    .addGroup(newJPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2))
                    .addComponent(txtEmail))
                .addGap(44, 44, 44))
        );
        newJPanel1Layout.setVerticalGroup(
            newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaXN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuiMaXN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTiepTucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiepTucActionPerformed
        Continue();
    }//GEN-LAST:event_btnTiepTucActionPerformed

    private void btnGuiMaXNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMaXNActionPerformed
        layLaiTK();
    }//GEN-LAST:event_btnGuiMaXNActionPerformed

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
            java.util.logging.Logger.getLogger(QuenMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuenMatKhauJDialog dialog = new QuenMatKhauJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiMaXN;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTiepTuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollBar jScrollBar1;
    private com.g5.ui.NewJPanel newJPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaXN;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables

    NhanVienDAO nvdao = new NhanVienDAOImpl();
    Random ranDom = new Random();

    void ketThuc() {
        this.dispose();
    }

    String gmail = "";
    String tk = "";

    void layLaiTK() {
        if (txtEmail.getText().trim().isEmpty() || txtTaiKhoan.getText().trim().isEmpty()) {
            System.out.println("Vui lòng nhập");
            return;
        }

        gmail = txtEmail.getText().trim();
        tk = txtTaiKhoan.getText().trim();
        List<NhanVien> nvList = nvdao.getAll();
        if (nvList.size() <= 0) {
            System.out.println("qq");
            return;
        }
        for (NhanVien nhanVien : nvList) {
            if (tk.equalsIgnoreCase(Auth.accountNV(String.valueOf(nhanVien.getMaNV())))) {
                String xnmk = Auth.accountXNNV(String.valueOf(nhanVien.getMaNV()));
                doiMatKhauDialog.setmaNV(xnmk);
                if (gmail.equalsIgnoreCase(nhanVien.getEmail())) {
                    System.out.println("qq");
                    send();

                }

            }

        }

        //   send();
    }
    int OTP;

    void send() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        String tk = "tvugiang@gmail.com";
        String mk = "vbcrhdgkparvwbyv";

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(tk, mk);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(tk));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(gmail)// Gmail nguời nhận
            );
            message.setSubject("Lấy lại tài khoản");// Tiêu đề tin nhắn
            OTP = ranDom.nextInt(9000) + 1000;
//            forgotpass(rdpass, mk);
            message.setText("Tài khoản và Mã OTP:\n Tài khoản: " + txtTaiKhoan.getText().trim() + "\n Mã OTP: " + OTP);// Nội dung tin nhắn

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void Continue() {
        String maXN = txtMaXN.getText().trim();
        if (maXN.equalsIgnoreCase(String.valueOf(OTP))) {

            doiMatKhauDialog.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Mã xác nhận không đúng");
            return;
        }
    }

}
