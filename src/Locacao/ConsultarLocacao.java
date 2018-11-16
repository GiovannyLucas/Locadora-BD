package Locacao;

import DAO.AluguelDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.FilmeDAO;
import Modelo.Aluguel;
import Modelo.Cliente;
import Modelo.Filme;
import Modelo.Listar;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanny Lucas
 */
public class ConsultarLocacao extends javax.swing.JFrame {

    public ConsultarLocacao() {
        initComponents();
        setLocationRelativeTo(this);
        setSize(855, 380);
        AtualizaCombo();
    }

    private void AtualizaCombo(){
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = sql.ListarComboCliente();
        jCB_Cliente.addItem("");
        
        for (Cliente b : lista) {
            jCB_Cliente.addItem(b.getNome());
        }
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }
    
    public void MostrarCodigo() {
        String cliente = jTF_cod_Cliente.getText();
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.Pesquisa_Nome_Aluguel(cliente);
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();

        while (tbm.getRowCount() > 0) {
            tbm.removeRow(0);
        }

        int i = 0;
        for (Aluguel tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCod(), i, 0);
            jTable.setValueAt(tab.getCoddvd(), i, 1);
            jTable.setValueAt(tab.getCodcliente(), i, 2);
            jTable.setValueAt(tab.getHorario(), i, 3);
            jTable.setValueAt(tab.getData_aluguel(), i, 4);
            jTable.setValueAt(tab.getData_devolucao(), i, 5);
            i++;
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCB_Cliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jTF_cod_Cliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jCB_Cliente.setToolTipText("");
        jCB_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_ClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jCB_Cliente);
        jCB_Cliente.setBounds(290, 20, 314, 36);

        jLabel1.setText("Cliente:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 30, 42, 16);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "DVD", "Horário", "Locação", "Devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(28, 72, 785, 250);
        getContentPane().add(jTF_cod_Cliente);
        jTF_cod_Cliente.setBounds(280, 100, 38, 36);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_ClienteActionPerformed
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        String nome = jCB_Cliente.getSelectedItem().toString();
        
        lista = sql.ConsultaCodigoCliente(nome);
        
        for (Cliente b : lista) {
            int a = b.getCodigo();
            jTF_cod_Cliente.setText("" + a);
        }
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
        
        MostrarCodigo();
    }//GEN-LAST:event_jCB_ClienteActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        Integer linha = jTable.getSelectedRow();
        Integer idaluguel = (Integer) jTable.getValueAt(linha, 0);
        Integer idcliente = (Integer) jTable.getValueAt(linha, 1);
        Integer iddvd = (Integer) jTable.getValueAt(linha, 2);
        
        Listar a = new Listar();
        a.setCoddvd(iddvd);
        a.setCodaluguel(idaluguel);
        a.setCodcliente(idcliente);
        
        new EfetuarDevolucao().setVisible(true);
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCB_Cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_cod_Cliente;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
