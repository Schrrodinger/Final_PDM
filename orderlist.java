/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuyet Anh
 */
public class orderlist extends javax.swing.JFrame {
    Vector head = new Vector();
    Vector data = new Vector();
    Vector data2 = new Vector();
    Vector data3 = new Vector();
    private static String accountidd;
    public String getaccountid(){
        return accountidd;
    }
    public void setaccountid(String id){
        this.accountidd = id;
    }

    /**
     * Creates new form orderlist
     */
    public orderlist(String id) {
        this.accountidd = id;
        initComponents();
        setLocationRelativeTo(null);
        
        head.add("OrderID");
        head.add("Order_Date");
        String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
        try (Connection con = DriverManager.getConnection(connectionUr1);
            Statement stmt = (Statement) con.createStatement();){
            String SQL = "Select OrderID, Order_Date From Order_ Where Status = 'Waitting'";

            ResultSet rs = stmt.executeQuery(SQL);

            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            while (rs.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumns;i++){
                    v.add(rs.getObject(i));

                }
                data.add(v);
   
            }
            jTable1.setModel(new DefaultTableModel(data, head));
            Statement sta = (Statement) con.createStatement();
            String SQL2 = "Select OrderID, Order_Date From Order_ Where Status = 'Delivering'";

            ResultSet re = sta.executeQuery(SQL2);

            ResultSetMetaData metaDataa = re.getMetaData();
            int numberOfColumnss = metaDataa.getColumnCount();
            
            while (re.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumnss;i++){
                    v.add(re.getObject(i));

                }
                data2.add(v);
            }
            jTable2.setModel(new DefaultTableModel(data2, head));
            
            Statement stat = (Statement) con.createStatement();
            String SQL3 = "Select OrderID, Order_Date From Order_ Where Status = 'Done'";

            ResultSet res = stat.executeQuery(SQL3);

            ResultSetMetaData metaDataaa = res.getMetaData();
            int numberOfColumnsss = metaDataaa.getColumnCount();
            
            while (res.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumnsss;i++){
                    v.add(res.getObject(i));

                }
                data3.add(v);
            }
            jTable3.setModel(new DefaultTableModel(data3, head));
            
        }
        
        catch (SQLException e){
               JOptionPane.showConfirmDialog(this, "Failed connect");
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

        jLabel1 = new javax.swing.JLabel();
        process = new javax.swing.JTabbedPane();
        waitting = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        accept = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        process2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("YOUR ORDER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "OrderID", "Order_Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        accept.setText("Accept");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout waittingLayout = new javax.swing.GroupLayout(waitting);
        waitting.setLayout(waittingLayout);
        waittingLayout.setHorizontalGroup(
            waittingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waittingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
            .addGroup(waittingLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(123, 123, 123)
                .addComponent(accept)
                .addGap(65, 65, 65))
        );
        waittingLayout.setVerticalGroup(
            waittingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waittingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(waittingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(waittingLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4)
                        .addGap(138, 138, 138)
                        .addComponent(accept))
                    .addGroup(waittingLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        process.addTab("Waitting", waitting);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "OrderID", "Order Date"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout process2Layout = new javax.swing.GroupLayout(process2);
        process2.setLayout(process2Layout);
        process2Layout.setHorizontalGroup(
            process2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(process2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        process2Layout.setVerticalGroup(
            process2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, process2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        process.addTab("Delivering", process2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "OrderID", "Order Date"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        process.addTab("Done", jPanel3);

        getContentPane().add(process, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 660, 262));

        jLabel5.setText("Back to dashboard");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
//        // TODO add your handling code here:
//        int n = jTable1.getSelectedRow();
//        String a = data.get(n).toString();
//        data.remove(n);
//        a= a.replace("[", "");
//        a= a.replace("]", "");
//        String [] group = a.split(",");
//        String orderid = group[0];
//        
//        String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
//        try {
//            Connection con = DriverManager.getConnection(connectionUr1);
//            if (txttime.getText().length() == 0 ){
//                JOptionPane.showMessageDialog(null,"Please fill expected time for order","Message", JOptionPane.WARNING_MESSAGE);
//                
//            }
//            else {                
//                String sql = "UPDATE Order_ SET Status = 'Delivering' WHERE OrderID = ? ";
//                PreparedStatement ps = con.prepareStatement(sql);
//                ps.setString(1,orderid );
//                ps.execute();
//                 
//                String sql2 = "UPDATE Order_ SET Status = ? WHERE OrderID = ? ";
//                PreparedStatement ps2 = con.prepareStatement(sql);
//                ps2.setString(1,txttime.getText());
//                ps2.setString(2,orderid );
//                ps2.execute();
//                
//                JOptionPane.showMessageDialog(null," This order is already acceptted");
//            
//           
//                jTable1.setModel(new DefaultTableModel(data, head));
//           
//                
//            }
//            
//            
//           
//            
//        
//            
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        
//        
    }//GEN-LAST:event_acceptActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
                    System.out.println( "truoc n");
        int n = jTable1.getSelectedRow();
        System.out.println(n);
        String a = data.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String or = group[0];
        System.out.println( "sau n");
        System.out.println( or);
        orderinformation o = new orderinformation(accountidd,or);
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Employeesinterface e = new Employeesinterface(accountidd);
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        //AAAAAAAAAAAAAAA
        int n = jTable2.getSelectedRow();
        System.out.println(n);
        String a = data2.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String or = group[0];
        orderconfirm o = new orderconfirm(accountidd,or, "Emp");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int n = jTable3.getSelectedRow();
        String a = data3.get(n).toString();
        System.out.println(n);
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String or = group[0];
        orderdetails o = new orderdetails(accountidd, or);
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable3MouseClicked

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
            java.util.logging.Logger.getLogger(orderlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderlist(accountidd).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTabbedPane process;
    private javax.swing.JPanel process2;
    private javax.swing.JPanel waitting;
    // End of variables declaration//GEN-END:variables
}