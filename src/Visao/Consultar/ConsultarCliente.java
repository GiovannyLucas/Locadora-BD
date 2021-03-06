package Visao.Consultar;

import DAO.ClienteDAO;
import DAO.Conexao;
import Modelo.Cliente;
import Principal.Menu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanny Lucas
 */
public class ConsultarCliente extends javax.swing.JFrame {

    public ConsultarCliente() {
        initComponents();
        setLocationRelativeTo(this);
        AtualizaTable();
    }

    private void AtualizaTable() {
        Connection con = Conexao.AbrirConexao();
        ClienteDAO bd = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = bd.ListarCliente();
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (Cliente tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            jTable.setValueAt(tab.getRG(), i, 2);
            jTable.setValueAt(tab.getCPF(), i, 3);
            jTable.setValueAt(tab.getTelefone(), i, 4);
            jTable.setValueAt(tab.getEmail(), i, 5);
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
        pesqCod = new javax.swing.JTextField();
        bTN_PCod = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        pesqNome = new javax.swing.JTextField();
        bTN_PNome = new javax.swing.JButton();
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
        jLabel23.setText("Pesquisar por código:");

        pesqCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqCodActionPerformed(evt);
            }
        });

        bTN_PCod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        bTN_PCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTN_PCodActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "RG", "CPF", "Telefone", "E-mail"
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

        pesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqNomeActionPerformed(evt);
            }
        });

        bTN_PNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        bTN_PNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTN_PNomeActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Pesquisar por nome:");

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
                .addGap(31, 31, 31)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bTN_PNome)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bTN_PCod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bTN_PCod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bTN_PNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24))))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void pesqCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqCodActionPerformed

    private void pesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqNomeActionPerformed

    private void bTN_PNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTN_PNomeActionPerformed
        String nome = pesqNome.getText();
        
        Connection con = Conexao.AbrirConexao();
        ClienteDAO bd = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = bd.Pesquisar_Nome_Cliente(nome); 
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (Cliente tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            jTable.setValueAt(tab.getRG(), i, 2);
            jTable.setValueAt(tab.getCPF(), i, 3);
            jTable.setValueAt(tab.getTelefone(), i, 4);
            jTable.setValueAt(tab.getEmail(), i, 5);
            i++;
        }
        pesqNome.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_bTN_PNomeActionPerformed

    private void bTN_PCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTN_PCodActionPerformed
        String codigo = pesqCod.getText();
        int cod = Integer.parseInt(codigo);
        
        Connection con = Conexao.AbrirConexao();
        ClienteDAO bd = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = bd.Pesquisar_Cod_Cliente(cod); 
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (Cliente tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            jTable.setValueAt(tab.getRG(), i, 2);
            jTable.setValueAt(tab.getCPF(), i, 3);
            jTable.setValueAt(tab.getTelefone(), i, 4);
            jTable.setValueAt(tab.getEmail(), i, 5);
            i++;
        }
        pesqCod.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_bTN_PCodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AtualizaTable();
        pesqNome.setText("");
        pesqCod.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bTN_PCod;
    private javax.swing.JButton bTN_PNome;
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
    private javax.swing.JTextField pesqNome;
    // End of variables declaration//GEN-END:variables
}
