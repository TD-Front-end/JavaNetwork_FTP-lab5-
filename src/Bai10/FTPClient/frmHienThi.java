/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai10.FTPClient;

import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author TienDat
 */
public final class frmHienThi extends javax.swing.JFrame {
    private Socket socket = null;
    private PrintWriter out = null;
    private Scanner in = null;
    private String username="";
    private String password="";
    private String path="";
    /**
     * Creates new form frmHienThi
     */
    public frmHienThi() {
        initComponents();
    }

    frmHienThi(Socket socket, String username, String password) {
        initComponents();
        this.socket = socket;
        this.setTitle("Xin chào"+username);
        this.username = username;
        this.password = password;
        loadlist();
    }

    
    //load danh sách
    public void loadlist(){
        try {
            BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
            in = new Scanner(bi);
            DefaultListModel dm = new DefaultListModel();
            int n = in.nextInt();
            for(int i = 0 ; i < n; i++)
            {
                String filename = in.nextLine();
                dm.addElement(filename);
            }
            this.listUserFolder.setModel(dm);
            listUserFolder.setSelectedIndex(0);
            this.validate();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooserClient = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listClientFolder = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUserFolder = new javax.swing.JList<>();
        btnupload = new javax.swing.JButton();
        btndownload = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Current Folder at Client");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listClientFolder);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Your account's Folder on server");

        jScrollPane2.setViewportView(listUserFolder);

        btnupload.setBackground(new java.awt.Color(102, 102, 255));
        btnupload.setText("Upload");
        btnupload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadActionPerformed(evt);
            }
        });

        btndownload.setBackground(new java.awt.Color(102, 102, 255));
        btndownload.setText("Dowload");
        btndownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndownloadActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 153));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnupload)
                    .addComponent(btndownload)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnupload)
                                .addGap(29, 29, 29)
                                .addComponent(btndownload)
                                .addGap(32, 32, 32)
                                .addComponent(jButton2)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnuploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadActionPerformed
        // Upload
        String str = "upload@"+"select * from taikhoan where username='" +username+ "'@";
        String filename;
        
        if(!path.equals("")){
            try {
                filename = listClientFolder.getSelectedValue().toString();
                File f = new File(path+"\\"+filename);
                str=str+filename;
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(str+"@"+(int)f.length());
                
                byte[] mybytearray = new byte[(int) f.length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
                bis.read(mybytearray, 0 , mybytearray.length);
                OutputStream os = socket.getOutputStream();
                os.write(mybytearray, 0 , mybytearray.length);
                os.flush();
                bis.close();
                loadlist();
               // updateFolderServer();
                JOptionPane.showMessageDialog(null, "upload tệp tin lên thành công");
            } catch (Exception e) {
                try {
                    if(socket!=null)
                        socket.close();
                } catch (Exception ex) {
                    e.printStackTrace();
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "upload tệp tin thất bại");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn file","Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnuploadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // browse
        this.fileChooserClient.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(this.fileChooserClient.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try {
                path = this.fileChooserClient.getSelectedFile().getCanonicalPath();
                File dir = new File(path);
                File dsfile[] = dir.listFiles();
                if(dsfile==null){
                    JOptionPane.showMessageDialog(null, "Đường dẫn không đúng hay không phải thư mục!");
                }else{
                    DefaultListModel dm = new DefaultListModel();
                    for(int i = 0 ;i<dsfile.length; i++)
                    {
                        String filename = dsfile[i].getName();
                        dm.addElement(filename);
                    }
                    this.listClientFolder.setModel(dm);
                    listClientFolder.setSelectedIndex(0);
                }
            } catch (Exception e) {
            }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btndownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndownloadActionPerformed
        // dowload
        String str = "download@" + "select * from taikhoan where username='" + username + "'@";
        String filename;
        try {
            //Truyền lệnh lên server yêu cầu file
            filename = listUserFolder.getSelectedValue().toString();
            str = str + filename;
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(str);
            //Nhận file từ server về lưu trong path
            BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
            in = new Scanner(bi);
            int doDaiFile = in.nextInt();//lấy độ dài File

            if (path.equals("")) {
                this.fileChooserClient.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (this.fileChooserClient.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    path = this.fileChooserClient.getSelectedFile().getCanonicalPath();
                }
            }

            int bytesRead;
            int current = 0;
            File f = new File(path + "\\" + filename);
            byte[] mybytearray = new byte[doDaiFile];
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray, 0, mybytearray.length);
            current = bytesRead;
            while (current != doDaiFile) {
                bytesRead = is.read(mybytearray, current, mybytearray.length - current);
                if (bytesRead >= 0) {
                    current += bytesRead;
                }
            }
            bos.write(mybytearray, 0, current);
            bos.flush();
            bos.close();
            File dir = new File(path);
            File dsFile[] = dir.listFiles();

            DefaultListModel dm = new DefaultListModel();
            for (int i = 0; i < dsFile.length; i++) {
                String name = dsFile[i].getName();
                dm.addElement(name);
            }
            this.listClientFolder.setModel(dm);
            listClientFolder.setSelectedIndex(0);
//        try {
//            byte[] mybytearray = new byte[1024*32];
////            //Truyền lệnh lên server yêu cầu file
//            filename = listUserFolder.getSelectedValue().toString();
//            str = str + filename;
//            out = new PrintWriter(socket.getOutputStream(), true);
//            out.println(str);
//            //Nhận file từ server về lưu trong path
//            InputStream is = socket.getInputStream();
//            FileOutputStream fos = new FileOutputStream(path+"\\"+filename);
//            is.read(mybytearray, 0, mybytearray.length);
//            fos.write(mybytearray, 0, mybytearray.length);
            
            
            
                     
//            if (path.equals("")) {
//                this.fileChooserClient.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                if (this.fileChooserClient.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//                    path = this.fileChooserClient.getSelectedFile().getCanonicalPath();
//                }
//            }
//           
//            File dir = new File(path);
//            File dsFile[] = dir.listFiles();
//            DefaultListModel dm = new DefaultListModel();
//            for (int i = 0; i < dsFile.length; i++) {
//                String name = dsFile[i].getName();
//                dm.addElement(name);
//            }
//            this.listClientFolder.setModel(dm);
//            listClientFolder.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Tải file thành công");
        } catch (Exception e) {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception ex) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Tải file thất bại");
            }
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tải file thất bại");
        }     
    }//GEN-LAST:event_btndownloadActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHienThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHienThi().setVisible(true);
            }
        });
    }
    
    private void capNhatClientFolder(String cpath) {
        //mo thu muc voi duong dan path ra
        File dir = new File(path);
        File dsFile[] = dir.listFiles();
        if (dsFile == null) {
            JOptionPane.showMessageDialog(null, " Duong dan sai!");
        } else {
            try {
                //luu duong dan hien tai ma list hien thi danh tap tin trong folder do.               
                DefaultListModel dm = new DefaultListModel();
                for (int i = 0; i < dsFile.length; i++) {
                    String filename = dsFile[i].getName();
                    dm.addElement(filename);
                }
                this.listClientFolder.setModel(dm);
                this.validate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }

    }       
    //
    private void updateFolderServer() {
        try {
            BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
            Scanner sc = new Scanner(bi);
            DefaultListModel dm = new DefaultListModel();
            //server goi ve so luong tap tin thu muc sau khi upload
            int n = sc.nextInt();
            System.out.println("Da nhan duoc so luong tap tin goi tu server");
            //nhan ten tung tap tin thu muc
            for (int i = 0; i < n; i++) {
                String filename = sc.nextLine();
                dm.addElement(filename);
            }
            System.out.println("Da hien thi xong danh sach tap tin");
            //hien thi len form
            this.listUserFolder.setModel(dm);
            //ve lai giao dien
            this.validate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", e.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndownload;
    private javax.swing.JButton btnupload;
    private javax.swing.JFileChooser fileChooserClient;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listClientFolder;
    private javax.swing.JList<String> listUserFolder;
    // End of variables declaration//GEN-END:variables
}
