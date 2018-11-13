package Visao.Consultar;

import DAO.CategoriaDAO;
import DAO.ClassificacaoDAO;
import DAO.Conexao;
import Modelo.Categoria;
import Modelo.Classificacao;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ConsultarClassificacao extends javax.swing.JFrame {

    public ConsultarClassificacao() {
        initComponents();
        setLocationRelativeTo(this);
        AtualizaTable();
    }

        private void AtualizaTable() {
        Connection con = Conexao.AbrirConexao();
        ClassificacaoDAO bd = new ClassificacaoDAO(con);
        List<Classificacao> lista = new ArrayList<>();
        lista = bd.ListarClassificacao();
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (Classificacao tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
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
        btnPesqCod = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        pesqNome = new javax.swing.JTextField();
        btnPesqNome = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

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

        btnPesqCod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        btnPesqCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqCodActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        btnPesqNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        btnPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqNomeActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Pesquisar por nome:");

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesqNome)
                .addGap(24, 24, 24)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesqCod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24))
                    .addComponent(btnPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqNomeActionPerformed
        String nome = pesqNome.getText();
        
        Connection con = Conexao.AbrirConexao();
        ClassificacaoDAO bd = new ClassificacaoDAO(con);
        List<Classificacao> lista = new ArrayList<>();
        lista = bd.Pesquisar_Nome_Classificacao(nome); 
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (Classificacao tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            i++;
        }
        pesqNome.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_btnPesqNomeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AtualizaTable();
        pesqNome.setText("");
        pesqCod.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPesqCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqCodActionPerformed
        String codigo = pesqCod.getText();
        int cod = Integer.parseInt(codigo);
        
        Connection con = Conexao.AbrirConexao();
        ClassificacaoDAO bd = new ClassificacaoDAO(con);
        List<Classificacao> lista = new ArrayList<>();
        lista = bd.Pesquisar_Cod_Classificacao(cod); 
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }
        
        int i = 0;
        for (Classificacao tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            i++;
        }
        pesqCod.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_btnPesqCodActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarClassificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarClassificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarClassificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarClassificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarClassificacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesqCod;
    private javax.swing.JButton btnPesqNome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
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
