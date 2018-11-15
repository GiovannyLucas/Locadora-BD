/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locacao;

import DAO.AluguelDAO;
import DAO.ClassificacaoDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.DVDDAO;
import DAO.FilmeDAO;
import Modelo.Aluguel;
import Modelo.Classificacao;
import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanny Lucas
 */
public class ControleLocacao extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaDevolucao1
     */
    public ControleLocacao() {
        initComponents();
        setLocationRelativeTo(this);
        AtualizaCombo();
        AtualizaTable();
    }
    
    private void AtualizaTable() {
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.ListarAluguel(); 
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
        pesqCod.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
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

    public void AtualizaDate(){
        Date date = new Date();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm");
        jTF_DataLocacao.setText(data.format(date));
        jTF_Horas.setText(hora.format(date));
    }
    
    public void InserirDados(int cod){
        Connection con = Conexao.AbrirConexao();
        DVDDAO dvd = new DVDDAO(con);
        FilmeDAO filme = new FilmeDAO(con);
        List<DVD> listaDVD = new ArrayList<>();
        List<Filme> listaFIL = new ArrayList<>();
        listaDVD = dvd.ListarCodFilme(cod);
        for (DVD a : listaDVD) {
            int codigo = a.getCod_filme();
            listaFIL = filme.Pesquisar_Cod_Filme(codigo);
        }
        for (Filme a : listaFIL) {
            jTF_Titulo.setText(a.getTitulo());
            jTF_Categoria.setText("" + a.getCod_categoria());
            jTF_Classificacao.setText("" + a.getCod_classificacao());
            jLbFoto.setIcon(new ImageIcon("C:/Locadora/" + a.getCapa()));
        }
        ClassificacaoDAO cla = new ClassificacaoDAO(con);
        List<Classificacao> listaCLA = new ArrayList<>();
        String b = jTF_Classificacao.getText();
        int codigo = Integer.parseInt(b);
        listaCLA = cla.ListarPrecoClassificacao(codigo);
        for (Classificacao a : listaCLA) {
            double preco = a.getPreco();
            jTF_Valor.setText("" + preco + "0");
        }
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTF_CodDVD = new javax.swing.JTextField();
        bTN_OK = new javax.swing.JButton();
        jTF_Titulo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTF_Categoria = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTF_Codigo = new javax.swing.JTextField();
        jTF_Valor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTF_CodCliente = new javax.swing.JTextField();
        jCB_Cliente = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jTF_Classificacao = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLbFoto = new javax.swing.JLabel();
        jTF_Horas = new javax.swing.JTextField();
        jTF_DataLocacao = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pesqCod = new javax.swing.JTextField();
        pesqDVD = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pesqCliente = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        btn_Cadastrar = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Código do DVD:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(30, 40, 99, 18);

        jTF_CodDVD.setBackground(new java.awt.Color(204, 255, 255));
        jTF_CodDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_CodDVDActionPerformed(evt);
            }
        });
        jPanel4.add(jTF_CodDVD);
        jTF_CodDVD.setBounds(140, 30, 70, 28);

        bTN_OK.setText("OK");
        bTN_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTN_OKActionPerformed(evt);
            }
        });
        jPanel4.add(bTN_OK);
        bTN_OK.setBounds(220, 30, 47, 32);

        jTF_Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_TituloActionPerformed(evt);
            }
        });
        jPanel4.add(jTF_Titulo);
        jTF_Titulo.setBounds(90, 70, 430, 28);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Título:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(20, 80, 48, 18);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Categoria:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(20, 120, 65, 18);

        jTF_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_CategoriaActionPerformed(evt);
            }
        });
        jPanel4.add(jTF_Categoria);
        jTF_Categoria.setBounds(90, 110, 47, 28);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Classificação:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(160, 120, 84, 18);

        jTF_Codigo.setEditable(false);
        jTF_Codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_Codigo.setToolTipText("");
        jTF_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_CodigoActionPerformed(evt);
            }
        });
        jPanel4.add(jTF_Codigo);
        jTF_Codigo.setBounds(310, 30, 50, 28);

        jTF_Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_ValorActionPerformed(evt);
            }
        });
        jPanel4.add(jTF_Valor);
        jTF_Valor.setBounds(430, 110, 90, 28);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Valor do aluguel:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(320, 120, 105, 18);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Cliente:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(20, 160, 50, 18);

        jTF_CodCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_CodClienteActionPerformed(evt);
            }
        });
        jPanel4.add(jTF_CodCliente);
        jTF_CodCliente.setBounds(90, 150, 47, 28);

        jCB_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_ClienteActionPerformed(evt);
            }
        });
        jPanel4.add(jCB_Cliente);
        jCB_Cliente.setBounds(150, 150, 370, 30);

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Data da locação:");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(20, 200, 104, 18);

        jTF_Classificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_ClassificacaoActionPerformed(evt);
            }
        });
        jPanel4.add(jTF_Classificacao);
        jTF_Classificacao.setBounds(250, 110, 47, 28);

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Data de devolução:");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(260, 200, 130, 18);
        jPanel4.add(jDateChooser1);
        jDateChooser1.setBounds(390, 190, 130, 30);

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Horas:");
        jPanel4.add(jLabel20);
        jLabel20.setBounds(390, 40, 40, 18);

        jLbFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DVD_VIDEO_logo.png"))); // NOI18N
        jPanel4.add(jLbFoto);
        jLbFoto.setBounds(560, 40, 270, 190);
        jPanel4.add(jTF_Horas);
        jTF_Horas.setBounds(440, 30, 80, 30);
        jPanel4.add(jTF_DataLocacao);
        jTF_DataLocacao.setBounds(130, 190, 100, 30);

        jTabbedPane1.addTab("CADASTRAR", jPanel4);

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Pesquisar por código:");

        pesqCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqCodActionPerformed(evt);
            }
        });

        pesqDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqDVDActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Pesquisar por DVD:");

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Pesquisar por cliente:");

        pesqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqClienteActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa1.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "DVD", "Cliente", "Horário", "Locação", "Devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jButton1.setText("TODOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(5, 5, 5)
                        .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesqDVD, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel24)
                                .addGap(5, 5, 5)
                                .addComponent(pesqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton16)))
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23))
                            .addComponent(pesqDVD)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel24))
                                .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(pesqCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22))
                            .addComponent(pesqCod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONSULTAR", jPanel8);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton11.setText("Limpar");

        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        jButton13.setText("Cancelar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(btn_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 297, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_CodDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_CodDVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_CodDVDActionPerformed

    private void bTN_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTN_OKActionPerformed
        AtualizaDate();
        String pesquisa = jTF_CodDVD.getText();
        Connection con = Conexao.AbrirConexao();

        if (pesquisa.equals("")) {
            JOptionPane.showMessageDialog(null, "Digie o código do DVD",
                "Video Locadora", JOptionPane.ERROR_MESSAGE);
        } else {
            DVDDAO sql = new DVDDAO(con);
            int cod = Integer.parseInt(pesquisa);
            if (sql.Testar_DVD(cod) == false) {
                JOptionPane.showMessageDialog(null, "Código do DVD não encontrado",
                    "Video Locadora", JOptionPane.ERROR_MESSAGE);
                jTF_CodDVD.setText("");
                jTF_Titulo.setText("");
                jTF_Valor.setText("");
                jTF_Categoria.setText("");
                jTF_Classificacao.setText("");
                jLbFoto.setIcon(new ImageIcon(""));
                jTF_Codigo.setText("");
            } else {
                if (sql.Testar_Situacao(cod) == false) {
                    JOptionPane.showMessageDialog(null, "O DVD de código ("+cod+") está emprestado",
                        "Video Locadora", JOptionPane.INFORMATION_MESSAGE);
                    jTF_CodDVD.setText("");
                    jTF_Titulo.setText("");
                    jTF_Valor.setText("");
                    jTF_Categoria.setText("");
                    jTF_Classificacao.setText("");
                    jLbFoto.setIcon(new ImageIcon(""));
                    jTF_Codigo.setText("");
                } else {
                    InserirDados(cod);
                    jTF_Codigo.setText(pesquisa);
                    jTF_CodDVD.setText("");

                }
            }
            Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
        }
    }//GEN-LAST:event_bTN_OKActionPerformed

    private void jTF_TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_TituloActionPerformed

    private void jTF_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_CategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_CategoriaActionPerformed

    private void jTF_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_CodigoActionPerformed

    private void jTF_ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_ValorActionPerformed

    private void jTF_CodClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_CodClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_CodClienteActionPerformed

    private void jCB_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_ClienteActionPerformed
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        String nome = jCB_Cliente.getSelectedItem().toString();
        
        lista = sql.ConsultaCodigoCliente(nome);
        
        for (Cliente b : lista) {
            int a = b.getCodigo();
            jTF_CodCliente.setText("" + a);
        }
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con); 
    }//GEN-LAST:event_jCB_ClienteActionPerformed

    private void jTF_ClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_ClassificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_ClassificacaoActionPerformed

    private void pesqCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqCodActionPerformed

    private void pesqDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqDVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqDVDActionPerformed

    private void pesqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqClienteActionPerformed

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        String dvd = jTF_Codigo.getText();
        String cliente = jTF_CodCliente.getText();
        String horario = jTF_Horas.getText();
        String aluguel = jTF_DataLocacao.getText();
        if (dvd.equals("") || cliente.equals("") || jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio",
                    "Video Locadora", JOptionPane.WARNING_MESSAGE);
        } else {
            String devolucao = new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser1.getDate());
            Connection con = Conexao.AbrirConexao();
            AluguelDAO sql = new AluguelDAO(con);
            int coddvd = Integer.parseInt(dvd);
            int codcli = Integer.parseInt(cliente);
            Aluguel a = new Aluguel();
            a.setCoddvd(coddvd);
            a.setCodcliente(codcli);
            a.setHorario(horario);
            a.setData_aluguel(aluguel);
            a.setData_devolucao(devolucao);
            sql.Inserir_Aluguel(a);
            String situacao = "Emprestado";
            sql.Atualizar_Situacao(situacao, coddvd);
            Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
            
            jTF_Codigo.setText("");
            jTF_CodCliente.setText("");
            jTF_Horas.setText("");
            jTF_DataLocacao.setText("");
            jTF_Titulo.setText("");
            jTF_Valor.setText("");
            jTF_Classificacao.setText("");
            jTF_Categoria.setText("");
            jTF_CodCliente.setText("");
            jCB_Cliente.setSelectedItem(0);
            jTF_DataLocacao.setText("");
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso",
                    "Video Locadora", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String codigo = pesqCod.getText();
        int id = Integer.parseInt(codigo);
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.Pesquisa_Cod_Aluguel(id); 
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
        pesqCod.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String codigoDVD = pesqDVD.getText();
        int iddvd = Integer.parseInt(codigoDVD);
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.Pesquisa_Coddvd_Aluguel(iddvd); 
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
        pesqDVD.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String codigoCli = pesqCliente.getText();
        int idCli = Integer.parseInt(codigoCli);
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO bd = new AluguelDAO(con);
        List<Aluguel> lista = new ArrayList<>();
        lista = bd.Pesquisa_Codcli_Aluguel(idCli); 
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
        pesqCliente.setText("");
        Conexao.FecharConexao((com.mysql.jdbc.Connection) con);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AtualizaTable();
        pesqCliente.setText("");
        pesqDVD.setText("");
        pesqCod.setText("");
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
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ControleLocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bTN_OK;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JComboBox<String> jCB_Cliente;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLbFoto;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_Categoria;
    private javax.swing.JTextField jTF_Classificacao;
    private javax.swing.JTextField jTF_CodCliente;
    private javax.swing.JTextField jTF_CodDVD;
    private javax.swing.JTextField jTF_Codigo;
    private javax.swing.JTextField jTF_DataLocacao;
    private javax.swing.JTextField jTF_Horas;
    private javax.swing.JTextField jTF_Titulo;
    private javax.swing.JTextField jTF_Valor;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField pesqCliente;
    private javax.swing.JTextField pesqCod;
    private javax.swing.JTextField pesqDVD;
    // End of variables declaration//GEN-END:variables
}
