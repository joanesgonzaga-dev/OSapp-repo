/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Auxiliares.GerenciaJFrames;
import Auxiliares.ManipulaComponentes;
import Auxiliares.meuDefaultTableCellRenderer;
import Configuracoes.DAO;
import Entidades.Cliente;
import Models.meuAbstractTableModel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Joanes Gonzaga
 */
public class frmLocalizaPessoas extends javax.swing.JFrame {

    List clientes;
    meuAbstractTableModel model;

    /**
     * Creates new form frmLocalizaPessoas
     */
    public frmLocalizaPessoas() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GerenciaJFrames gerenciaFrame = new GerenciaJFrames();
        gerenciaFrame.posicionaFrame(this);

        clientes = new ArrayList();

        model = new meuAbstractTableModel(clientes);
        
        
        tableBuscaClientes.setModel(model);
        
        //tableBuscaClientes.setDefaultRenderer(String.class, new meuDefaultTableCellRenderer());
        
        
        
        tableBuscaClientes.getColumnModel().getColumn(0).setPreferredWidth(60);
        tableBuscaClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
        tableBuscaClientes.getColumnModel().getColumn(2).setPreferredWidth(250);
        tableBuscaClientes.getColumnModel().getColumn(3).setPreferredWidth(250);
        tableBuscaClientes.getColumnModel().getColumn(4).setPreferredWidth(250);
        tableBuscaClientes.getColumnModel().getColumn(5).setPreferredWidth(70);
         
       // tableBuscaClientes.getColumnModel().getColumn(3).
        carregaValoresPadrao();
        implementaListeners();
    }

    public void carregaValoresPadrao() {

        Connection con = DAO.getConexao();
        try {
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM lojas WHERE atual = 'S' ");
            while (rs.next()) {
                //Define ID Opção de Busca
                String idBuscaPadrao = rs.getString("idBuscaPadrao");
                if (idBuscaPadrao.equals("CD")) {
                    rbCodigo.setSelected(true);
                    txtTermoBusca.setFormatterFactory(null);
                    txtTermoBusca.setText("");
                    rbPF.setEnabled(true);
                    rbPJ.setEnabled(true);
                    
                } 
                else if(idBuscaPadrao.equals("RS")){
                    rbRSocial.setSelected(true);
                    rbPF.setEnabled(true);
                    rbPJ.setEnabled(true);
                    txtTermoBusca.setFormatterFactory(null);
                    txtTermoBusca.setText("");
                }
                else if (idBuscaPadrao.equals("NF")) {
                    rbNome.setSelected(true);
                    rbPF.setEnabled(true);
                    rbPJ.setEnabled(true);
                    txtTermoBusca.setFormatterFactory(null);
                    txtTermoBusca.setText("");
                }
                else if (idBuscaPadrao.equals("CPF")) {
                    rbCPF.setSelected(true);
                    rbPF.setEnabled(true);
                    rbPJ.setEnabled(false);
                    txtTermoBusca.setText("");
                    try {
                        MaskFormatter format = new MaskFormatter("###.###.###-##");
                        format.setPlaceholderCharacter('_');
                        txtTermoBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
                        txtTermoBusca.setValue(null);
                    } catch (ParseException ex) {

                    }
                } else if (idBuscaPadrao.equals("CNPJ")) {
                    rbCNPJ.setSelected(true);
                    rbPF.setEnabled(false);
                    rbPJ.setEnabled(true);

                    try {
                        MaskFormatter format = new MaskFormatter("##.###.###/####-##");
                        format.setPlaceholderCharacter('_');
                        txtTermoBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
                        txtTermoBusca.setValue(null);
                    } catch (ParseException ex) {

                    }

                } else if (idBuscaPadrao.equals("TF")) {
                    rbTelefone.setSelected(true);
                    rbPF.setEnabled(true);
                    rbPJ.setEnabled(true);
                }

                //Define Tipo Pessoa Busca
                String tipoPessoaBuscaPadrao = rs.getString("tipoPessoaPadraoCliente");
                if (tipoPessoaBuscaPadrao.equals("PF")) {
                    
                    rbPF.setSelected(true);
                    
                } else if (tipoPessoaBuscaPadrao.equals("PJ")) {
                    rbPJ.setSelected(true);
                }
                
                
            }

            txtTermoBusca.requestFocus();

        } catch (SQLException ex) {

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
        java.awt.GridBagConstraints gridBagConstraints;

        rbgroupOpcoesBusca = new javax.swing.ButtonGroup();
        rbgroupTipoPessoa = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rbCodigo = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        rbCNPJ = new javax.swing.JRadioButton();
        rbTelefone = new javax.swing.JRadioButton();
        rbRSocial = new javax.swing.JRadioButton();
        rbCPF = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        rbPF = new javax.swing.JRadioButton();
        rbPJ = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtTermoBusca = new javax.swing.JFormattedTextField();
        btnLimpar = new javax.swing.JButton();
        ckbAcumular = new javax.swing.JCheckBox();
        ckbTodos = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBuscaClientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesquisar Clientes - Softaway Sistemas");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Opções da Busca:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel4.setLayout(new java.awt.GridBagLayout());

        rbgroupOpcoesBusca.add(rbCodigo);
        rbCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbCodigo.setText("Código");
        rbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(rbCodigo, gridBagConstraints);

        rbgroupOpcoesBusca.add(rbNome);
        rbNome.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbNome.setText("Nome Fantasia");
        rbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(rbNome, gridBagConstraints);

        rbgroupOpcoesBusca.add(rbCNPJ);
        rbCNPJ.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbCNPJ.setText("CNPJ");
        rbCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCNPJActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(rbCNPJ, gridBagConstraints);

        rbgroupOpcoesBusca.add(rbTelefone);
        rbTelefone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbTelefone.setText("Telefone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(rbTelefone, gridBagConstraints);

        rbgroupOpcoesBusca.add(rbRSocial);
        rbRSocial.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbRSocial.setText("Nome/Razão Social");
        rbRSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRSocialActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(rbRSocial, gridBagConstraints);

        rbgroupOpcoesBusca.add(rbCPF);
        rbCPF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbCPF.setText("CPF");
        rbCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCPFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(rbCPF, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tipo Pessoa:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel5.setLayout(new java.awt.GridBagLayout());

        rbgroupTipoPessoa.add(rbPF);
        rbPF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbPF.setText("Pessoa Física");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(rbPF, gridBagConstraints);

        rbgroupTipoPessoa.add(rbPJ);
        rbPJ.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rbPJ.setText("Pessoa Jurídica");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(rbPJ, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jPanel5, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Parâmetro da Busca:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(btnBuscar, gridBagConstraints);

        txtTermoBusca.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(txtTermoBusca, gridBagConstraints);

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(btnLimpar, gridBagConstraints);

        ckbAcumular.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ckbAcumular.setText("Acumular Consultas");
        ckbAcumular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbAcumularActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(ckbAcumular, gridBagConstraints);

        ckbTodos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ckbTodos.setText("Todos");
        ckbTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbTodosItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(ckbTodos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        tableBuscaClientes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableBuscaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableBuscaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableBuscaClientes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Comandos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdicionar.setText("Adicionar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(btnAdicionar, gridBagConstraints);

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new java.awt.Dimension(89, 29));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(btnEditar, gridBagConstraints);

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(89, 29));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(btnExcluir, gridBagConstraints);

        btnSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSair.setText("Fechar");
        btnSair.setPreferredSize(new java.awt.Dimension(89, 29));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(btnSair, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String strBusca = null;
        String colunaBusca = null;
        String tipoPessoa = null;

        

            if (ckbTodos.isSelected()) {
                strBusca = "SELECT * FROM CLIENTES ORDER BY NOME";
            } else {
                
                if (txtTermoBusca.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Você Precisa Digitar um Parâmetro para a Consulta!");
            txtTermoBusca.requestFocus();
            return;
        } 
                
                
                if (rbPF.isSelected()) {
                    tipoPessoa = "PF";
                } else if (rbPJ.isSelected()) {
                    tipoPessoa = "PJ";
                }

                if (rbCodigo.isSelected()) {

                    strBusca = "SELECT * FROM clientes WHERE codigo =" + txtTermoBusca.getText() + " AND tipoCLI ='" + tipoPessoa + "'";
                } else if (rbNome.isSelected()) {

                    strBusca = "SELECT * FROM clientes WHERE apelido LIKE '%" + txtTermoBusca.getText() + "%'" + " AND tipoCLI ='" + tipoPessoa + "'";
                } else if (rbRSocial.isSelected()) {
                    strBusca = "SELECT * FROM clientes WHERE nome LIKE '%" + txtTermoBusca.getText() + "%'" + " AND tipoCLI ='" + tipoPessoa + "'";
                } else if (rbCNPJ.isSelected()) {

                    strBusca = "SELECT * FROM clientes WHERE cnpj = '" + txtTermoBusca.getText() + "'" + " AND tipoCLI ='" + tipoPessoa + "'";
                } 
                else if(rbCPF.isSelected()){
                    strBusca = "SELECT * FROM clientes WHERE cpf = '" + txtTermoBusca.getText() + "'" + " AND tipoCLI ='" + tipoPessoa + "'";
                }
                else if (rbTelefone.isSelected()) {

                    strBusca = "SELECT * FROM clientes WHERE FONE1='" + txtTermoBusca.getText() + "'" + " AND tipoCLI ='" + tipoPessoa + "'";
                }
            }

            Connection con = DAO.getConexao();

            try {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(strBusca);

                int totalResults = 0;
                //DefaultTableCellRenderer ioRender = new DefaultTableCellRenderer();
                int contador = 0;
                if (!ckbAcumular.isSelected()) {
                    model.limpar();
                    while (rs.next()) {
                        tableBuscaClientes.setRowHeight(35);
                        Color corLinha;
                        if((contador % 2) == 0){
                            corLinha =   Color.yellow;
                        }
                        else{
                            corLinha =   Color.white;
                        }
                        //ioRender.setBackground(corLinha);
                        //tableBuscaClientes.getColumnModel().getColumn(0).setCellRenderer(ioRender);
                       // tableBuscaClientes.getCellRenderer(contador, 0);
                        
                        Cliente cliente = new Cliente();
                        cliente.setCodigo(rs.getInt("codigo"));
                        cliente.setCpf(rs.getString("cpf"));
                        cliente.setNome(rs.getString("nome"));
                        cliente.setNomeFantasia(rs.getString("apelido"));
                        cliente.setLogradouro(rs.getString("ENDERECO"));
                        cliente.setFonePrincipal(rs.getString("FONE1"));
                        model.inserir(cliente);
                        contador++;
                    }
                } else {
                    while (rs.next()) {
                        tableBuscaClientes.setRowHeight(35);
                        Color corLinha;
                        if((contador % 2) == 0){
                           corLinha = Color.yellow;
                        }
                        else{
                            corLinha = Color.white;
                        }  
                       //ioRender.setBackground(corLinha);
                       // tableBuscaClientes.getColumnModel().getColumn(0).setCellRenderer(ioRender);
                        //tableBuscaClientes.setBackground(corLinha);
                        Cliente cliente = new Cliente();
                        cliente.setCodigo(rs.getInt("codigo"));
                        cliente.setCpf(rs.getString("cpf"));
                        cliente.setNome(rs.getString("nome"));
                        cliente.setNomeFantasia(rs.getString("apelido"));

                        cliente.setLogradouro(rs.getString("ENDERECO"));
                        cliente.setFonePrincipal(rs.getString("FONE1"));
                        model.inserir(cliente);
                        contador++;
                    }
                }

            } catch (SQLException ex) {

            }

        


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void rbCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCPFActionPerformed

        txtTermoBusca.setFormatterFactory(null);
        try {
            MaskFormatter format = new MaskFormatter("###.###.###-##");
            format.setPlaceholderCharacter('_');
            txtTermoBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
            txtTermoBusca.setValue(null);
            rbPF.setSelected(true);
            rbPF.setEnabled(true);
            rbPJ.setEnabled(false);
            txtTermoBusca.requestFocus();
        } catch (ParseException ex) {

        }
    }//GEN-LAST:event_rbCPFActionPerformed

    private void rbCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCNPJActionPerformed

        txtTermoBusca.setFormatterFactory(null);
        try {
            MaskFormatter format = new MaskFormatter("##.###.###/####-##");
            format.setPlaceholderCharacter('_');
            txtTermoBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
            txtTermoBusca.setValue(null);
            rbPJ.setSelected(true);
            rbPJ.setEnabled(true);
            rbPF.setEnabled(false);
            txtTermoBusca.requestFocus();
        } catch (ParseException ex) {

        }
    }//GEN-LAST:event_rbCNPJActionPerformed

    private void rbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodigoActionPerformed

        rbPF.setEnabled(true);
        rbPJ.setEnabled(true);
        txtTermoBusca.setFormatterFactory(null);
        txtTermoBusca.setValue("");

        txtTermoBusca.requestFocus();

    }//GEN-LAST:event_rbCodigoActionPerformed

    private void rbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNomeActionPerformed

        rbPF.setEnabled(true);
        rbPJ.setEnabled(true);
        txtTermoBusca.setFormatterFactory(null);
        txtTermoBusca.setValue("");

        txtTermoBusca.requestFocus();
    }//GEN-LAST:event_rbNomeActionPerformed

    private void rbRSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRSocialActionPerformed
        rbPF.setEnabled(true);
        rbPJ.setEnabled(true);
        rbPJ.setSelected(true);
        txtTermoBusca.setFormatterFactory(null);
        txtTermoBusca.setValue("");

        txtTermoBusca.requestFocus();
    }//GEN-LAST:event_rbRSocialActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        tableBuscaClientes.removeAll();
        txtTermoBusca.setText("");
        txtTermoBusca.requestFocus();
        model.limpar();
        carregaValoresPadrao();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void ckbAcumularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbAcumularActionPerformed
        
        if(ckbTodos.isSelected()){
            JOptionPane.showMessageDialog(null, "Não é Possível Acumular Consultas Quando a Opção <<Todos>> Estiver Ativada!");
            ckbAcumular.setSelected(false);
        }
    }//GEN-LAST:event_ckbAcumularActionPerformed

    private void ckbTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbTodosItemStateChanged
        
        if(ckbTodos.isSelected()){
            carregaValoresPadrao();
            ckbAcumular.setSelected(false);
            txtTermoBusca.setText("");
            //txtTermoBusca.setEnabled(false);
            
        }
        
        
    }//GEN-LAST:event_ckbTodosItemStateChanged

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        String cod = tableBuscaClientes.getValueAt(tableBuscaClientes.getSelectedRow(),0).toString();
        Cliente cliente = new Cliente();
        cliente.setCodigo(Integer.parseInt(cod));
        frmCadastrarClientes telaClientes = new frmCadastrarClientes(cliente);
        
        //clientes.cliente.setCodigo(cliente.getCodigo());
        //clientes.setarValoresCliente(cliente, ManipulaComponentes.statusCadastro.Editando);
        telaClientes.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(frmLocalizaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLocalizaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLocalizaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLocalizaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLocalizaPessoas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox ckbAcumular;
    private javax.swing.JCheckBox ckbTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbCNPJ;
    private javax.swing.JRadioButton rbCPF;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbPF;
    private javax.swing.JRadioButton rbPJ;
    private javax.swing.JRadioButton rbRSocial;
    private javax.swing.JRadioButton rbTelefone;
    private javax.swing.ButtonGroup rbgroupOpcoesBusca;
    private javax.swing.ButtonGroup rbgroupTipoPessoa;
    private javax.swing.JTable tableBuscaClientes;
    private javax.swing.JFormattedTextField txtTermoBusca;
    // End of variables declaration//GEN-END:variables

    private void implementaListeners() {
        
    }
}
