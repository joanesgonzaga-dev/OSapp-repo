/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Auxiliares.GerenciaJFrames;
import Auxiliares.GerenciarCombo;
import Auxiliares.ItemCombo;
import Auxiliares.ManipulaComponentes;
import Configuracoes.DAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Joanes Gonzaga
 */
public class frmCadastroCEP extends javax.swing.JFrame {

    ManipulaComponentes.statusCadastro statusFrame;
    ArrayList<JButton> botoes;
    ArrayList<JTextField> campos;
    ResultSet rsCEPs;
    /**
     * Creates new form frmCadastroCEP
     */
    public frmCadastroCEP() {
        initComponents();
        
        botoes = new ArrayList<>();
        botoes.add(btnAdd);
        botoes.add(btnEdit);
        botoes.add(btnRemove);
        //botoes.add(btnSearch);
        botoes.add(btnDispose);
        
        campos = new ArrayList<JTextField>();
        campos.add(txtLogradouro);
        campos.add(jffCEP);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GerenciaJFrames gerenciaFrame = new GerenciaJFrames();
        
        Dimension tamanhoForm = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - (Toolkit.getDefaultToolkit().getScreenSize().width - 650), Toolkit.getDefaultToolkit().getScreenSize().height - (Toolkit.getDefaultToolkit().getScreenSize().height - 325));
        setSize(tamanhoForm);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - tamanhoForm.width)/3, ((Toolkit.getDefaultToolkit().getScreenSize().height - tamanhoForm.height)/3));
        setResizable(false);
        setTitle(getTitle());
        
        carregaComboUFs();
        carregaComboMunicipios();
        carregaComboBairros();
        //carregaValoresPadrao();
        
        statusFrame = statusFrame.Navegando;
    }
    
    
    private void carregaComboMunicipios() {

        Connection con = DAO.getConexao();
        ItemCombo itemUF = (ItemCombo)cbUFs.getSelectedItem();
        String codUF = itemUF.getIndice().toString();
        codUF = codUF.substring(0, 2);
        
        String str = "SELECT CODIGO, MUNICIPIO FROM CEP_MUNICIPIO WHERE CODIGO LIKE '" + codUF + "%'";
        try {
            Statement stm = con.createStatement();
            ResultSet rsMunicipio = stm.executeQuery(str);
            GerenciarCombo.preencherCombo(rsMunicipio, "CODIGO", "MUNICIPIO", cbMunicipio);
            SetaMunicipioPadrao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Carregar a Lista de Municípios! " + '\n' + ex.getMessage());
        }
    }
    
    private void carregaComboUFs() {
        Connection con = DAO.getConexao();
        String str = "SELECT codigo,nome FROM CEP_UF ORDER BY nome";

        try {
            Statement stm = con.createStatement();
            ResultSet rsUFs = stm.executeQuery(str);
            GerenciarCombo.preencherCombo(rsUFs, "codigo", "nome", cbUFs);
            SetaUFPadrao();
            
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void carregaComboBairros(){
        Connection con = DAO.getConexao();
        ItemCombo itemMunicipio = (ItemCombo)cbMunicipio.getSelectedItem();
        String str = "SELECT DISTINCT bairro,codmunicipio FROM CEP WHERE codmunicipio="+ itemMunicipio.getIndice().toString();

        try {
            Statement stm = con.createStatement();
            ResultSet rsBairros = stm.executeQuery(str);
            GerenciarCombo.preencherCombo(rsBairros, "codmunicipio", "bairro", cbBairros);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void SetaUFPadrao(){
        Connection conDefault = DAO.getConexao();
        
        String sqlDefault = "SELECT ufPadraoCliente FROM lojas WHERE atual='S'";
        try {
            Statement stmDefault = conDefault.createStatement();
            ResultSet rsDefault = stmDefault.executeQuery(sqlDefault);
            
            if(rsDefault.next()){
                GerenciarCombo.setarOpcaocombo(cbUFs, rsDefault.getString("ufPadraoCliente"));
            }
        } catch (SQLException ex) {
            
        }
        
    }
    
    private void SetaMunicipioPadrao(){
        Connection conDefault = DAO.getConexao();
        
        String sqlDefault = "SELECT municipioPadraoCliente FROM lojas WHERE atual='S'";
        try {
            Statement stmDefault = conDefault.createStatement();
            ResultSet rsDefault1 = stmDefault.executeQuery(sqlDefault);
            
            if(rsDefault1.next()){
                GerenciarCombo.setarOpcaocombo(cbMunicipio, rsDefault1.getString("municipioPadraoCliente".trim()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deu Erro! - " + ex.getMessage());
        }
        
    }
    
    private void SetaBairroPadrao(){
        Connection conDefault = DAO.getConexao();
        
        String sqlDefault = "SELECT municipioPadraoCliente FROM lojas WHERE atual='S'";
        try {
            Statement stmDefault = conDefault.createStatement();
            ResultSet rsDefault1 = stmDefault.executeQuery(sqlDefault);
            
            if(rsDefault1.next()){
                GerenciarCombo.setarOpcaocombo(cbMunicipio, rsDefault1.getString("municipioPadraoCliente".trim()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deu Erro! - " + ex.getMessage());
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

        panelCEP = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        jffCEP = new javax.swing.JFormattedTextField();
        panelDetalhes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbUFs = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbMunicipio = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbBairros = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelBotoes = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnDispose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manutenção de CEP's");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelCEP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CEP A Consultar:"));
        panelCEP.setLayout(new java.awt.GridBagLayout());

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCEP.add(btnConsultar, gridBagConstraints);

        try {
            jffCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCEP.add(jffCEP, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(panelCEP, gridBagConstraints);

        panelDetalhes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detalhes:"));
        panelDetalhes.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("UF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(jLabel1, gridBagConstraints);

        cbUFs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUFsItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(cbUFs, gridBagConstraints);

        jLabel2.setText("Municipio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(jLabel2, gridBagConstraints);

        cbMunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMunicipioItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(cbMunicipio, gridBagConstraints);

        jLabel3.setText("Logradouro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(txtLogradouro, gridBagConstraints);

        jLabel4.setText("Bairro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(cbBairros, gridBagConstraints);

        jButton1.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(jButton1, gridBagConstraints);

        jButton2.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDetalhes.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(panelDetalhes, gridBagConstraints);

        panelBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Comandos:"));
        panelBotoes.setLayout(new java.awt.GridBagLayout());

        btnAdd.setText("Adicionar");
        btnAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(btnAdd, gridBagConstraints);

        btnEdit.setText("Editar");
        btnEdit.setPreferredSize(new java.awt.Dimension(75, 23));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(btnEdit, gridBagConstraints);

        btnRemove.setText("Excluir");
        btnRemove.setPreferredSize(new java.awt.Dimension(75, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(btnRemove, gridBagConstraints);

        btnDispose.setText("Sair");
        btnDispose.setPreferredSize(new java.awt.Dimension(75, 23));
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelBotoes.add(btnDispose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(panelBotoes, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
       
        String cepDigitado = jffCEP.getText();
        String[] cepDigitado2 = cepDigitado.split("-");
        String novaString = "";
        for (String c : cepDigitado2) {
            novaString += c;
        }
        
        String strCEP = "SELECT * FROM cep WHERE cep=" + novaString;
        Connection conCEP = DAO.getConexao();
        try {
            Statement stmCEP = conCEP.createStatement();
            rsCEPs = stmCEP.executeQuery(strCEP);
            
            if(rsCEPs.next()){
                GerenciarCombo.setarOpcaocombo(cbUFs, rsCEPs.getString("UF"));
                carregaComboMunicipios();
                GerenciarCombo.setarOpcaocomboIndice(cbMunicipio, rsCEPs.getString("CODMUNICIPIO"));
                txtLogradouro.setText(rsCEPs.getString("LOGRADOURO"));
                carregaComboBairros();
                GerenciarCombo.setarOpcaocombo(cbBairros, rsCEPs.getString("BAIRRO"));
                
            }
            
        } catch (SQLException ex) {
            
        }
        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cbMunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMunicipioItemStateChanged
       carregaComboBairros();
    }//GEN-LAST:event_cbMunicipioItemStateChanged

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       if(statusFrame == statusFrame.Navegando){
          // ManipulaComponentes.bloqueiaBarraDeEspaco(campos);
           statusFrame = ManipulaComponentes.statusCadastro.Adicionando;
            ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
            setTitle("Manutenção de CEP's - " + statusFrame);
            txtLogradouro.setText(null);
            txtLogradouro.requestFocus();
       }
       else if(statusFrame == statusFrame.Adicionando){
           
        String cepDigitado = jffCEP.getText();
        String[] cepDigitado2 = cepDigitado.split("-");
        String novaString = "";
        for (String c : cepDigitado2) {
            novaString += c;
            }
        Connection conCEPInsert = DAO.getConexao();
           try {
               String strSQLCepInsert = "INSERT INTO cep(cep,UF,CODMUNICIPIO,LOGRADOURO,BAIRRO) VALUES(?,?,?,?,?)";
               PreparedStatement pstmCEPInsert = conCEPInsert.prepareStatement(strSQLCepInsert);
               pstmCEPInsert.setString(1, novaString);
               ItemCombo itemUF = (ItemCombo)cbUFs.getSelectedItem();
               pstmCEPInsert.setString(2, itemUF.getDescricao());
               
               ItemCombo itemMunicipio = (ItemCombo)cbMunicipio.getSelectedItem();
               pstmCEPInsert.setString(3, itemMunicipio.getIndice().toString());
               
               pstmCEPInsert.setString(4, txtLogradouro.getText());
               
               ItemCombo itemBairro = (ItemCombo)cbBairros.getSelectedItem();
               pstmCEPInsert.setString(5, itemBairro.getDescricao());
               
               if(pstmCEPInsert.executeUpdate() <= 0){
                   JOptionPane.showMessageDialog(null, "Não Foi Possível Cadastrar o CEP!");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Novo CEP Cadastrado com Sucesso!");
                   statusFrame = ManipulaComponentes.statusCadastro.Navegando;
                    ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
                    setTitle("Manutenção de CEP's - " + statusFrame);
               }
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro de SQL - Não Foi Possível Cadastrar o CEP! " + ex.getMessage());
               return;
           }
        
            
            
           
       }
       
       else if(statusFrame == statusFrame.Editando){
           String cepDigitado = jffCEP.getText();
        String[] cepDigitado2 = cepDigitado.split("-");
        String novaString = "";
        for (String c : cepDigitado2) {
            novaString += c;
            }
        Connection conCEPUpdate = DAO.getConexao();
           try {
               String strSQLCepUpdate = "UPDATE cep SET cep=?,UF=?,CODMUNICIPIO=?,LOGRADOURO=?,BAIRRO=? WHERE ";
               PreparedStatement pstmCEPUpdate = conCEPUpdate.prepareStatement(strSQLCepUpdate);
               pstmCEPUpdate.setString(1, novaString);
               ItemCombo itemUF = (ItemCombo)cbUFs.getSelectedItem();
               pstmCEPUpdate.setString(2, itemUF.getDescricao());
               
               ItemCombo itemMunicipio = (ItemCombo)cbMunicipio.getSelectedItem();
               pstmCEPUpdate.setString(3, itemMunicipio.getIndice().toString());
               
               pstmCEPUpdate.setString(4, txtLogradouro.getText());
               
               ItemCombo itemBairro = (ItemCombo)cbBairros.getSelectedItem();
               pstmCEPUpdate.setString(5, itemBairro.getDescricao());
               
               if(pstmCEPUpdate.executeUpdate() <= 0){
                   JOptionPane.showMessageDialog(null, "Não Foi Possível Cadastrar o CEP!");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Novo CEP Cadastrado com Sucesso!");
                   statusFrame = ManipulaComponentes.statusCadastro.Navegando;
                    ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
                    setTitle("Manutenção de CEP's - " + statusFrame);
               }
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Erro de SQL - Não Foi Possível Atualizar o CEP! " + ex.getMessage());
               return;
           }
       }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(statusFrame == statusFrame.Navegando){
            
            if(rsCEPs == null){
                JOptionPane.showMessageDialog(null, "Não Há Registro Selecionado Para Edição!");
            }
            else{
            statusFrame = statusFrame.Editando;
            ManipulaComponentes.gerenciaBotoes(botoes, statusFrame); 
            setTitle("Manutenção de CEP's - " + statusFrame);
            }
            
           
       }
       else if(statusFrame == statusFrame.Adicionando || statusFrame == statusFrame.Editando){
           if(JOptionPane.showConfirmDialog(null, "Você está "+ statusFrame + " um registro. Deseja Abandona a operação?", "Edição de Registro", JOptionPane.YES_NO_OPTION) == 0){
                statusFrame = statusFrame.Navegando;
                setTitle("Cadastro de CNAE - " + statusFrame);
                ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
                
            }
           else{
               return;
           }
       }
    }//GEN-LAST:event_btnEditActionPerformed

    private void cbUFsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUFsItemStateChanged
       
        carregaComboMunicipios();
    }//GEN-LAST:event_cbUFsItemStateChanged

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
            java.util.logging.Logger.getLogger(frmCadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadastroCEP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnDispose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox cbBairros;
    private javax.swing.JComboBox cbMunicipio;
    private javax.swing.JComboBox cbUFs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField jffCEP;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCEP;
    private javax.swing.JPanel panelDetalhes;
    private javax.swing.JTextField txtLogradouro;
    // End of variables declaration//GEN-END:variables
}
