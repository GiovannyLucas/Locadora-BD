package Visao.Consultar;

import DAO.Conexao;
import DAO.DVDDAO;
import Modelo.DVD;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ConsultarDVD extends javax.swing.JFrame {

    public ConsultarDVD() {
        initComponents();
        setLocationRelativeTo(this);
        AtualizaTable();
    }

    private void AtualizaTable() {
        Connection con = Conexao.AbrirConexao();
        DVDDAO bd = new DVDDAO(con);
        List<DVD> lista = new ArrayList<>();
        lista = bd.ListarDVD();
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (DVD tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getCod_filme(), i, 1);
            jTable.setValueAt(tab.getNome_filme(), i, 2);
            jTable.setValueAt(tab.getPreco(), i, 3);
            jTable.setValueAt(tab.getData_compra(),  i, 4);
            jTable.setValueAt(tab.getSituacao(), i, 5);
            i++;
        }
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        pesqCodFilme = new javax.swing.JTextField();
        bTN_pesqCodFilme = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        pesqCod = new javax.swing.JTextField();
        bTN_pesqCod = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Pesquisar por código:");

        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "DVD", "Cliente", "Horário", "Locação", "Devolução"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("TODOS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Pesquisar por código do filme:");

        pesqCodFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqCodFilmeActionPerformed(evt);
            }
        });

        bTN_pesqCodFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        bTN_pesqCodFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTN_pesqCodFilmeActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código do filme", "Nome do filme", "Preço da compra", "Data da compra", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable);

        jButton2.setText("TODOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pesqCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqCodActionPerformed(evt);
            }
        });

        bTN_pesqCod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        bTN_pesqCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTN_pesqCodActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Pesquisar por código:");

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bTN_pesqCod)
                .addGap(42, 42, 42)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesqCodFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bTN_pesqCodFilme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bTN_pesqCodFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesqCodFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addComponent(bTN_pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void pesqCodFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqCodFilmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqCodFilmeActionPerformed

    private void pesqCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqCodActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bTN_pesqCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTN_pesqCodActionPerformed
        String codigo = pesqCod.getText();
        int id = Integer.parseInt(codigo);
        
        Connection con = Conexao.AbrirConexao();
        DVDDAO bd = new DVDDAO(con);
        List<DVD> lista = new ArrayList<>();
        lista = bd.Pesquisar_Cod_iddvd(id); 
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (DVD tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getCod_filme(), i, 1);
            jTable.setValueAt(tab.getNome_filme(), i, 2);
            jTable.setValueAt(tab.getPreco(), i, 3);
            jTable.setValueAt(tab.getData_compra(), i, 4);
            jTable.setValueAt(tab.getSituacao(), i, 5);
            i++;
        }
        pesqCod.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_bTN_pesqCodActionPerformed

    private void bTN_pesqCodFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTN_pesqCodFilmeActionPerformed
        String codigo = pesqCodFilme.getText();
        int cod = Integer.parseInt(codigo);
        
        Connection con = Conexao.AbrirConexao();
        DVDDAO bd = new DVDDAO(con);
        List<DVD> lista = new ArrayList<>();
        lista = bd.Pesquisar_Cod_idfilme(cod); 
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (DVD tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getCod_filme(), i, 1);
            jTable.setValueAt(tab.getNome_filme(), i, 2);
            jTable.setValueAt(tab.getPreco(), i, 3);
            jTable.setValueAt(tab.getData_compra(), i, 4);
            jTable.setValueAt(tab.getSituacao(), i, 5);
            i++;
        }
        pesqCodFilme.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_bTN_pesqCodFilmeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AtualizaTable();
        pesqCod.setText("");
        pesqCodFilme.setText("");
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
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarDVD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bTN_pesqCod;
    private javax.swing.JButton bTN_pesqCodFilme;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField pesqCod;
    private javax.swing.JTextField pesqCodFilme;
    // End of variables declaration//GEN-END:variables
}
