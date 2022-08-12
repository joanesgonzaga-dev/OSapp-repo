/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Auxiliares.ControlarDigitacao;
import Auxiliares.GerenciaJFrames;
import Auxiliares.GerenciarCombo;
import Auxiliares.ItemCombo;
import Auxiliares.ManipulaComponentes;
import Auxiliares.TratamentoNulos;
import Configuracoes.DAO;
import Entidades.Cliente;
import Facade.ClienteFacade;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.synth.ColorType;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import org.eclipse.persistence.jpa.rs.exceptions.JAXBExceptionMapper;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Joanes Gonzaga
 */
public class frmCadastrarClientes extends javax.swing.JFrame {

    ManipulaComponentes.statusCadastro statusFrame;
    ArrayList<JButton> botoes;
    ResultSet rs = null;
    String genero = null;
    String tipoPessoa = null;
    Cliente cliente;
    Boolean statusCadastro;
    ArrayList<JTextField> camposBloqueados = new ArrayList<JTextField>();
    ArrayList<JTextField> camposObrigatorios = new ArrayList<JTextField>();

    /**
     * Creates new form frmCadastrarClientes
     */
    public frmCadastrarClientes() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GerenciaJFrames gerenciaFrame = new GerenciaJFrames();
        gerenciaFrame.posicionaFrame(this);

        //Cria o ArrayList de botoes presentes no Frame
        botoes = new ArrayList<>();
        botoes.add(btnAdd);
        botoes.add(btnEdit);
        botoes.add(btnRemove);
        botoes.add(btnSearch);
        botoes.add(btnDispose);

        camposBloqueados.add(txtNome);
        camposBloqueados.add(txtNomeFantasia);

        camposObrigatorios.add(txtNome);
        camposObrigatorios.add(txtNomeFantasia);

        //Ao instancia o objeto Frame, define a variável statusFrame com o valor Navegando;
        statusFrame = statusFrame.Navegando;

        //Em seguida, chama o método que controla os botoes do Frame a partir do valor da variável statusFrame
        ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
        carregaComboPaises();
        carregaComboUFs();
        carregaComboRegimeTributario();
        carregaComboCNAEDescricao();
        carregaComboNaturalidade();
        carregaComboMunicipios();
        this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);
        //carregaValoresPadrao();
    }

    public frmCadastrarClientes(Cliente clienteConsulta) {

        cliente = clienteConsulta;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GerenciaJFrames gerenciaFrame = new GerenciaJFrames();
        gerenciaFrame.posicionaFrame(this);

        //Cria o ArrayList de botoes presentes no Frame
        botoes = new ArrayList<>();
        botoes.add(btnAdd);
        botoes.add(btnEdit);
        botoes.add(btnRemove);
        botoes.add(btnSearch);
        botoes.add(btnDispose);

        camposBloqueados.add(txtNome);
        camposBloqueados.add(txtNomeFantasia);

        camposObrigatorios.add(txtNome);
        camposObrigatorios.add(txtNomeFantasia);

        //Ao instancia o objeto Frame, define a variável statusFrame com o valor Navegando;
        statusFrame = statusFrame.Editando;

        //Em seguida, chama o método que controla os botoes do Frame a partir do valor da variável statusFrame
        ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
        carregaComboPaises();
        carregaComboUFs();
        carregaComboRegimeTributario();
        carregaComboCNAEDescricao();
        carregaComboNaturalidade();
        carregaComboMunicipios();
        this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);

        populaCamposDadosCliente(cliente.getCodigo());
        setarValoresCliente(cliente, statusFrame);
        //
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

        btngroupTipoPessoa = new javax.swing.ButtonGroup();
        btngroupStatus = new javax.swing.ButtonGroup();
        btngroupGenero = new javax.swing.ButtonGroup();
        painelDadosGerais = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rbPF = new javax.swing.JRadioButton();
        rbPJ = new javax.swing.JRadioButton();
        rbE = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rbAtivo = new javax.swing.JRadioButton();
        rbInativo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        dateCadastro = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dateEdicao = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jffTelFixo = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        jffCelular = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        ckbIsentoICMS = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jffEmail = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        dateNascimento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbPaises = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbNaturalidade = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtRG = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtOEmissor = new javax.swing.JTextField();
        jffCPF = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jffCNPJ = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIM = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtCNAECodigo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbCNAEDesc = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        cbRegimeTributario = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        txtSubstituicaoTributaria = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtSuframa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAddCNAE = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnAddFoto = new javax.swing.JButton();
        btnDeleteFoto = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDispose = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        painelEndereco = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cbUFs = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        cbMunicipio = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jffCEP = new javax.swing.JFormattedTextField();
        btnLocalizarCEP = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Clientes - Softaway Sistemas");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        painelDadosGerais.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tipo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btngroupTipoPessoa.add(rbPF);
        rbPF.setText("Pessoa Física");
        rbPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(rbPF, gridBagConstraints);

        btngroupTipoPessoa.add(rbPJ);
        rbPJ.setText("Pessoa Jurídica");
        rbPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPJActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(rbPJ, gridBagConstraints);

        btngroupTipoPessoa.add(rbE);
        rbE.setText("Estrangeiro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(rbE, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.25;
        painelDadosGerais.add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btngroupStatus.add(rbAtivo);
        rbAtivo.setText("Ativo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(rbAtivo, gridBagConstraints);

        btngroupStatus.add(rbInativo);
        rbInativo.setText("Inativo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel2.add(rbInativo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.25;
        painelDadosGerais.add(jPanel2, gridBagConstraints);

        jLabel1.setText("Data do Cadastro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelDadosGerais.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelDadosGerais.add(dateCadastro, gridBagConstraints);

        jLabel2.setText("Editado em:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelDadosGerais.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelDadosGerais.add(dateEdicao, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(painelDadosGerais, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        txtId.setEditable(false);
        txtId.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtId, gridBagConstraints);

        jLabel4.setText("Nome/Razão Social:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtNome, gridBagConstraints);

        jLabel7.setText("Nome Fantasia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtNomeFantasia, gridBagConstraints);

        jLabel27.setText("Tel. Fixo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel27, gridBagConstraints);

        try {
            jffTelFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(0##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jffTelFixo, gridBagConstraints);

        jLabel28.setText("Celular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel28, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jffCelular, gridBagConstraints);

        jLabel29.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel29, gridBagConstraints);

        ckbIsentoICMS.setText("Isento ICMS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(ckbIsentoICMS, gridBagConstraints);

        jLabel32.setText("Código:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel32, gridBagConstraints);

        txtCodigo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtCodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jffEmail, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gênero:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel8.setLayout(new java.awt.GridBagLayout());

        btngroupGenero.add(rbMasculino);
        rbMasculino.setText("Masculino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(rbMasculino, gridBagConstraints);

        btngroupGenero.add(rbFeminino);
        rbFeminino.setText("Feminino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(rbFeminino, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        jPanel5.add(jPanel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(dateNascimento, gridBagConstraints);

        jLabel8.setText("Data Nascimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Nacionalidade: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(cbPaises, gridBagConstraints);

        jLabel10.setText("Naturalidade: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel10, gridBagConstraints);

        cbNaturalidade.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(cbNaturalidade, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jPanel10, gridBagConstraints);

        jLabel11.setText("Estado Civil:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel11, gridBagConstraints);

        jLabel33.setText("Estado Civil:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel33, gridBagConstraints);

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado", "Divorciado", "Solteiro", "Viúvo", "Outros", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(cbEstadoCivil, gridBagConstraints);

        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel34.setText("C.P.F:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel34, gridBagConstraints);

        jLabel35.setText("R.G:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel35, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtRG, gridBagConstraints);

        jLabel36.setText("O. Emissor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jLabel36, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(txtOEmissor, gridBagConstraints);

        try {
            jffCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jffCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jffCPFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jffCPFFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.weightx = 0.33;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel12.add(jffCPF, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel5.add(jPanel12, gridBagConstraints);

        jTabbedPane1.addTab("Dados Pessoa Física", jPanel5);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("CNPJ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(jLabel5, gridBagConstraints);

        try {
            jffCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jffCNPJ.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jffCNPJ.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jffCNPJ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jffCNPJFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(jffCNPJ, gridBagConstraints);

        jLabel6.setText("Ins. Estadual:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(txtIE, gridBagConstraints);

        jLabel15.setText("Ins. Municipal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(jLabel15, gridBagConstraints);

        txtIM.setPreferredSize(new java.awt.Dimension(103, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(txtIM, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        jPanel7.add(jPanel9, gridBagConstraints);

        jLabel16.setText("Cód. CNAE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel16, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(txtCNAECodigo, gridBagConstraints);

        jLabel17.setText("Desc. CNAE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel17, gridBagConstraints);

        cbCNAEDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCNAEDescItemStateChanged(evt);
            }
        });
        cbCNAEDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCNAEDescActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(cbCNAEDesc, gridBagConstraints);

        jLabel18.setText("Regime Tributário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel18, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(cbRegimeTributario, gridBagConstraints);

        jLabel26.setText("I.E: (Subst. Tributária):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jLabel26, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(txtSubstituicaoTributaria, gridBagConstraints);

        jLabel30.setText("Ins. SUFRAMA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(jLabel30, gridBagConstraints);

        txtSuframa.setPreferredSize(new java.awt.Dimension(103, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(20, 5, 5, 5);
        jPanel7.add(txtSuframa, gridBagConstraints);

        jButton1.setText("Localizar CNAE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(jButton1, gridBagConstraints);

        btnAddCNAE.setText("+");
        btnAddCNAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCNAEActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel7.add(btnAddCNAE, gridBagConstraints);

        jTabbedPane1.addTab("Dados Pessoa Jurídica", jPanel7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jTabbedPane1, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Foto/Logo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel6.setLayout(new java.awt.GridBagLayout());

        btnAddFoto.setText("Adicionar");
        btnAddFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFotoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(btnAddFoto, gridBagConstraints);

        btnDeleteFoto.setText("Remover");
        btnDeleteFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFotoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(btnDeleteFoto, gridBagConstraints);

        jLabel31.setBackground(new java.awt.Color(255, 255, 204));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        jPanel6.add(jLabel31, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(jPanel4, gridBagConstraints);

        painelBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Comandos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        painelBotoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelBotoes.setLayout(new java.awt.GridBagLayout());

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.setPreferredSize(new java.awt.Dimension(77, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelBotoes.add(btnAdd, gridBagConstraints);

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setPreferredSize(new java.awt.Dimension(77, 23));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelBotoes.add(btnEdit, gridBagConstraints);

        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemove.setText("Excluir");
        btnRemove.setPreferredSize(new java.awt.Dimension(77, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelBotoes.add(btnRemove, gridBagConstraints);

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Pesquisar");
        btnSearch.setPreferredSize(new java.awt.Dimension(77, 23));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelBotoes.add(btnSearch, gridBagConstraints);

        btnDispose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDispose.setText("Sair");
        btnDispose.setPreferredSize(new java.awt.Dimension(77, 23));
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelBotoes.add(btnDispose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(painelBotoes, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jSeparator1, gridBagConstraints);

        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Endereço:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        painelEndereco.setLayout(new java.awt.GridBagLayout());

        jLabel19.setText("Logradouro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jLabel19, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(txtLogradouro, gridBagConstraints);

        jLabel20.setText("Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jLabel20, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(txtNumero, gridBagConstraints);

        jLabel21.setText("Complemento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jLabel21, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(txtComplemento, gridBagConstraints);

        jLabel22.setText("UF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jLabel22, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(cbUFs, gridBagConstraints);

        jLabel23.setText("Municipio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jLabel23, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(cbMunicipio, gridBagConstraints);

        jLabel24.setText("Bairro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jLabel24, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(txtBairro, gridBagConstraints);

        jLabel25.setText("CEP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jLabel25, gridBagConstraints);

        try {
            jffCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(jffCEP, gridBagConstraints);

        btnLocalizarCEP.setText("Localizar pelo CEP");
        btnLocalizarCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarCEPActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        painelEndereco.add(btnLocalizarCEP, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        painelEndereco.add(jPanel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(painelEndereco, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String retorno = null;

        //JOptionPane.showMessageDialog(null, Integer.parseInt());
        if ((retorno = JOptionPane.showInputDialog("Código")) == null) {
            return;
        }
        //Integer.parseInt(retorno) ;
        //JOptionPane.showMessageDialog(null, retorno);
        Connection cn = DAO.getConexao();
        try {
            PreparedStatement stm = cn.prepareStatement("SELECT * FROM clientes WHERE idUnico=?");
            stm.setInt(1, Integer.parseInt(retorno));

            ResultSet rs100 = stm.executeQuery();
            int contador = 0;
            while (rs100.next()) {
                //JOptionPane.showMessageDialog(null, rs100.getInt("idUnico"));
                ManipulaComponentes.liberaDocument(camposBloqueados);

                populaCamposDadosCliente(rs100.getInt("idUnico"));
                //JOptionPane.showMessageDialog(null, rs100.getInt("idUnico"));

                cliente = new Cliente();
                cliente.setiDUnico(rs100.getInt("idUnico"));
                cliente.setCodigo(rs100.getInt("codigo"));
                setarValoresCliente(cliente, statusFrame);
                contador += 1;
            }

            if (contador == 0) {
                JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro de SQL - " + ex.getMessage());
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        //incluir um IF pra controlar a inserçao e chamar metodo gerenciaBotoes()
        //Se o formulário estiver em modo de Navegação, ele será passado para o modo de inserção, limpa os componentes, chama o método de controle
        //dos botões e carrega os valores padrão.
        if (statusFrame == ManipulaComponentes.statusCadastro.Navegando) {
            //cliente = new Cliente();
            cliente = null;
            cliente = new Cliente();
            rs = null;
            txtNome.requestFocus();
            //Limpa os componentes para iniciar a inserção
            //Entra no Modo de Inserção
            statusFrame = ManipulaComponentes.statusCadastro.Adicionando;
            //Limpa os Componentes
            ManipulaComponentes.limpaCampos(this.getComponents());
            //Chama o método de controle dos botões
            ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
            this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);
            //Carrega os valores padrão dos campos
            carregaValoresPadrao();
            //Chama método para bloquear caracteres inválidos nos campos aplicáveis
            ManipulaComponentes.bloqueiaBarraDeEspaco(camposBloqueados);
            //ImplementsBeansBinding();
        } //Se já estiver em modo de Inserção
        else if (statusFrame == ManipulaComponentes.statusCadastro.Adicionando) {

            cliente = new Cliente();
            //txtNome.requestFocus();
            //Monda a lista dos campos de texto (somente JTextField) que devem ser validados quanto a estarem vazios

            //Este IF sem Else, chama o método de validação do campo Email (JFormattedTextField), mas somente se houve algum connteúdo a ser validado
            //Caso o campo esteja em branco, a validação não acontece por se entender que o usuário não deseja utilizá-lo
            if (!jffEmail.getText().trim().equals("")) {
                if (!ManipulaComponentes.validEmail(jffEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "O email inserido não parece ter um formato válido!");
                    return;
                }
            }

            //Este IF/ELSE Chama o método de validação dos campos obrigatórios, passando a list dos componentes a serem validados
            //não deixando a inserção prosseguir, caso haja algum campo obrigatório que esteja vazio.
            //
            if (!ManipulaComponentes.validarCamposObrigatorios(camposObrigatorios)) {
                JOptionPane.showMessageDialog(null, "O campo não pode estar vazio!");
                return;
            }
                //Caso o método de validação de campos obrigatórios não retorne false, então procede com a inserção
            //Instancia um objeto da classe Servico
            //cliente = new Cliente();

            setarValoresCliente(cliente, statusFrame);

                //Se a Inserção for bem sucedida, retorna um ResultSet com os dados do cliente
            //e preenche a tela
            if (ClienteFacade.adicionarCliente(cliente)) {
                statusFrame = ManipulaComponentes.statusCadastro.Navegando;
                ManipulaComponentes.limpaCampos(this.getComponents());
                ManipulaComponentes.liberaDocument(camposBloqueados);
                //Chama o método de controle de botoões
                ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);

                this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);

                populaCamposDadosCliente(cliente.getCodigo());
            } else {
                JOptionPane.showMessageDialog(null, "Não Foi Possível Cadastrar o Cliente!");
            }
        } else if (statusFrame == ManipulaComponentes.statusCadastro.Editando) {
            //Neste ponto, a aplicação só entrará se estiver em modo de edição. Portanto, já estará em modo de edição, o ResultSet preenchido e os valores do objeto Cliente "setados".
            setarValoresCliente(cliente, statusFrame);
            int retorno = ClienteFacade.atualizarCliente(cliente);
            if (retorno <= 0) {
                JOptionPane.showMessageDialog(null, "Não Atualizou!");
            } else if (retorno > 0) {
                populaCamposDadosCliente(cliente.getCodigo());
                statusFrame = ManipulaComponentes.statusCadastro.Navegando;
                ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
                this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);
                JOptionPane.showMessageDialog(null, "Registro Atualizado com Sucesso!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        //ManipulaComponentes.habilitaDesabilitaCampos(this.getComponents(), false);       
        //Caso o ResultSet esteja esteja vazio, não entra em Edição
        //ResultSet rs = null;
        if (statusFrame == ManipulaComponentes.statusCadastro.Navegando) {
            if (rs == null) {
                JOptionPane.showMessageDialog(null, "Não Existe um Registro Selecionado para Edição!");

            } else {
                try {
                    while (rs.next()) {
                        cliente = new Cliente();
                        cliente.setiDUnico(rs.getInt("idUnico"));
                        cliente.setCodigo(rs.getInt("codigo"));

                    }
                    populaCamposDadosCliente(cliente.getCodigo());
                    setarValoresCliente(cliente, statusFrame);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                //cliente1.setiDUnico(rs.getInt("idUnico"));
                statusFrame = ManipulaComponentes.statusCadastro.Editando;

                ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
                this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);
            }
        } else if (statusFrame == ManipulaComponentes.statusCadastro.Editando) {

            //Não precisa verificar o ResultSet, pois não tem como estar no modo Editando com o Resultset vazio.
            //Por estar em modo de Edição, interage com o usuário quanto ao abandono da operação!
            if (JOptionPane.showConfirmDialog(null, "Você está " + statusFrame + " um registro. Confirma o Abandono da operação?", "Cadastro de Funcionário", JOptionPane.YES_NO_OPTION) == 0) {
                //ManipulaComponentes.liberaDocument(camposBloqueados);
                //Chamar código de cancelamento da açao editar!
                statusFrame = ManipulaComponentes.statusCadastro.Navegando;
                ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
                this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);

                //Na verdade tem que ser um código que carregue no Frame o registro que estava sendo editado. 
                //Atenção Para não chamar o método de limpeza dos campos, pois isso impossibilitaria o método retornaDadosCliente(int) de obter
                //o código do cliente atualmente carregado no Form!
                //cliente = new Cliente();
                //rs = ClienteFacade.retornaDadosCliente(cliente.getCodigo());
                populaCamposDadosCliente(cliente.getCodigo());

            } else {
                return;
            }

            //ManipulaComponentes.gerenciaBotoes(botoes, statusFrame = ManipulaComponentes.statusCadastro.Navegando);
            //ManipulaComponentes.limpaCampos(this.getComponents());
        } else if (statusFrame == ManipulaComponentes.statusCadastro.Adicionando) {
            //Por estar em modo de Inserção, interage com o usuário quanto ao abandono da operação!
            if (JOptionPane.showConfirmDialog(null, "Você está " + statusFrame + " um registro. Confirma o Abandono da operação?", "Cadastro de Funcionário", JOptionPane.YES_NO_OPTION) == 0) {

                statusFrame = ManipulaComponentes.statusCadastro.Navegando;
                ManipulaComponentes.gerenciaBotoes(botoes, statusFrame);
                this.setTitle("Cadastro de Clientes - Softaway Sistemas - " + statusFrame);
                ManipulaComponentes.limpaCampos(this.getComponents());
                carregaValoresPadrao();
            } else {
                return;
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFotoActionPerformed

        JOptionPane.showMessageDialog(null, dateNascimento.getDate());
    }//GEN-LAST:event_btnAddFotoActionPerformed

    private void cbCNAEDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCNAEDescActionPerformed


    }//GEN-LAST:event_cbCNAEDescActionPerformed

    private void rbPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPFActionPerformed

        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_rbPFActionPerformed

    private void rbPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPJActionPerformed

        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_rbPJActionPerformed

    private void jffCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jffCPFFocusGained
        jffCPF.setCaretPosition(0);
    }//GEN-LAST:event_jffCPFFocusGained

    private void btnDeleteFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFotoActionPerformed

        JOptionPane.showMessageDialog(null, cliente.getiDUnico() + " - " + cliente.getCodigo() + " - " + cliente.getNome() + "\n"
                + "Nascimento Objeto : " + cliente.getNascimento_Fundacao() + " / Nascimento Componente: " + dateNascimento.getDate());

    }//GEN-LAST:event_btnDeleteFotoActionPerformed

    private void jffCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jffCPFFocusLost

        String strCPF = jffCPF.getText();
        String cpfValidado = "";

        if (statusFrame == statusFrame.Adicionando || statusFrame == statusFrame.Editando) {
            if (jffCPF.getText().equals("   .   .   -  ")) {
                return;
            } else {
                for (int i = 0; i < strCPF.length(); i++) {

                    if ((strCPF.charAt(i) - 48) >= 0) {
                        cpfValidado += strCPF.charAt(i);
                    }
                }
                if (Auxiliares.ValidaCPF.isCPF(cpfValidado)) {

                } else {
                    JOptionPane.showMessageDialog(null, "O CPF digitado não é válido!");
                    //jffCPF.requestFocus();
                }
            }
        } else {
            return;
        }


    }//GEN-LAST:event_jffCPFFocusLost

    private void jffCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jffCNPJFocusLost
        String strCNPJ = jffCNPJ.getText();
        String cnpjValidado = "";

        if (statusFrame == statusFrame.Adicionando || statusFrame == statusFrame.Editando) {
            if (jffCNPJ.getText().equals("  .   .   /    -  ")) {
                return;
            } else {
                for (int i = 0; i < strCNPJ.length(); i++) {

                    if ((strCNPJ.charAt(i) - 48) >= 0) {
                        cnpjValidado += strCNPJ.charAt(i);
                    }
                }

                if (Auxiliares.ValidaCNPJ.isCNPJ(cnpjValidado)) {

                } else {
                    //JOptionPane.showMessageDialog(null, cnpjValidado.length());
                    JOptionPane.showMessageDialog(null, "O CNPJ digitado não é válido!");
                    //jffCNPJ.requestFocus();
                }
            }
        } else {
            return;
        }


    }//GEN-LAST:event_jffCNPJFocusLost

    private void btnAddCNAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCNAEActionPerformed

        frmCadastrarCNAE cnaeForm = new frmCadastrarCNAE(null, true);
        cnaeForm.setVisible(true);
        carregaComboCNAEDescricao();
    }//GEN-LAST:event_btnAddCNAEActionPerformed

    private void cbCNAEDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCNAEDescItemStateChanged

       // ItemCombo itemCNAE = (ItemCombo) cbCNAEDesc.getSelectedItem();
        // txtCNAECodigo.setText(itemCNAE.getIndice().toString());
    }//GEN-LAST:event_cbCNAEDescItemStateChanged

    private void btnLocalizarCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarCEPActionPerformed

        String cepDigitado = jffCEP.getText();
        String[] cepDigitado2 = cepDigitado.split("-");
        String novaString = "";
        for (String c : cepDigitado2) {
            novaString += c;
        }

        Connection conCEP = DAO.getConexao();

        try {
            PreparedStatement pstmCEP = conCEP.prepareStatement("SELECT * FROM cep WHERE cep=?");
            pstmCEP.setString(1, novaString);
            ResultSet rsCep = pstmCEP.executeQuery();

            int contador = 0;
            while (rsCep.next()) {
                contador++;
            }

            if (contador <= 0) {
                JOptionPane.showMessageDialog(null, "O CEP " + jffCEP.getText() + " não Foi Localizado!");
            } else {
                if (JOptionPane.showConfirmDialog(null, "CEP Localizado! Deseja Atualizar o Endereço do Cliente com os Dados do CEP Digitado?", "Localizar CEP", JOptionPane.YES_NO_OPTION) == 0) {
                    Connection con = DAO.getConexao();
                    String strSQLCep = "SELECT CEP.CEP, CEP.CODMUNICIPIO, CEP.UF, CEP.LOGRADOURO, CEP.BAIRRO, CEP_MUNICIPIO.CODIGO, CEP_MUNICIPIO.MUNICIPIO\n"
                            + "FROM CEP_MUNICIPIO INNER JOIN\n"
                            + " CEP ON CEP_MUNICIPIO.CODIGO = CEP.CODMUNICIPIO\n"
                            + "WHERE CEP.CEP = ?";

                    PreparedStatement pstm100 = con.prepareStatement(strSQLCep);
                    pstm100.setString(1, novaString);
                    ResultSet rsDadosCep = pstm100.executeQuery();

                    while (rsDadosCep.next()) {
                        GerenciarCombo.setarOpcaocombo(cbMunicipio, rsDadosCep.getString("MUNICIPIO"));
                        txtLogradouro.setText(rsDadosCep.getString("logradouro"));
                        txtBairro.setText(rsDadosCep.getString("bairro"));
                        jffCEP.setText(rsDadosCep.getString("cep"));
                        GerenciarCombo.setarOpcaocombo(cbUFs, rsDadosCep.getString("UF"));
                    }
                } else {
                    return;
                }
            }

        } catch (SQLException ex) {

        }


    }//GEN-LAST:event_btnLocalizarCEPActionPerformed

    private void carregaComboNaturalidade() {
        Connection con = DAO.getConexao();
        String str = "SELECT codigo, ESTADO FROM CEP_UF ORDER BY ESTADO";
        try {
            Statement stm = con.createStatement();
            ResultSet rsNaturalidade = stm.executeQuery(str);
            GerenciarCombo.preencherCombo(rsNaturalidade, "codigo", "ESTADO", cbNaturalidade);

        } catch (SQLException ex) {

        }
    }

    private void carregaComboMunicipios() {

        Connection con = DAO.getConexao();
        String str = "SELECT CODIGO, MUNICIPIO FROM CEP_MUNICIPIO ORDER BY MUNICIPIO";
        try {
            Statement stm = con.createStatement();
            ResultSet rsMunicipio = stm.executeQuery(str);
            GerenciarCombo.preencherCombo(rsMunicipio, "CODIGO", "MUNICIPIO", cbMunicipio);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Carregar a Lista de Municípios! " + '\n' + ex.getMessage());
        }
    }

    private void carregaComboPaises() {

        Connection con = DAO.getConexao();
        String str = "SELECT codigo, nome FROM NFE_Pais ORDER BY nome";
        try {
            Statement stm = con.createStatement();
            ResultSet rsPAISES = stm.executeQuery(str);

            GerenciarCombo.preencherCombo(rsPAISES, "codigo", "nome", cbPaises);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void carregaComboUFs() {
        Connection con = DAO.getConexao();
        String str = "SELECT codigo,nome FROM CEP_UF ORDER BY nome";

        try {
            Statement stm = con.createStatement();
            ResultSet rsUFs = stm.executeQuery(str);
            GerenciarCombo.preencherCombo(rsUFs, "codigo", "nome", cbUFs);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void carregaComboRegimeTributario() {
        Connection con = DAO.getConexao();
        String str = "SELECT codigo, nome FROM NFE_RegimeTributario ORDER BY nome";
        try {
            Statement stm = con.createStatement();
            ResultSet rsRT = stm.executeQuery(str);

            GerenciarCombo.preencherCombo(rsRT, "codigo", "nome", cbRegimeTributario);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void carregaComboCNAEDescricao() {
        Connection con = DAO.getConexao();
        String str = "SELECT codigo, descCNAE FROM CNAE ORDER BY descCNAE";
        try {
            Statement stm = con.createStatement();
            ResultSet rsCNAE = stm.executeQuery(str);
            GerenciarCombo.preencherCombo(rsCNAE, "codigo", "descCNAE", cbCNAEDesc);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void carregaValoresPadrao() {

        String str = "SELECT * FROM lojas WHERE atual = 'S' ";
        Connection con = DAO.getConexao();
        try {
            Statement stm = con.createStatement();
            ResultSet rsPadrao = stm.executeQuery(str);

            while (rsPadrao.next()) {
                //Seleciona Tipo de Pessoa
                switch (rsPadrao.getString("tipoPessoaPadraoCliente")) {
                    case "PF":
                        rbPF.setSelected(true);
                        jTabbedPane1.setSelectedIndex(0);
                        break;
                    case "PJ":
                        rbPJ.setSelected(true);
                        jTabbedPane1.setSelectedIndex(1);
                        break;
                    case "E":
                        rbE.setSelected(true);
                        break;
                    default:
                        rbPF.setSelected(false);
                        rbPJ.setSelected(false);
                        rbE.setSelected(false);
                        break;
                }

                //Seleciona Status
                if (rsPadrao.getBoolean("statusPadraoCliente")) {
                    rbAtivo.setSelected(true);
                } else {
                    rbInativo.setSelected(true);
                }

                ckbIsentoICMS.setSelected(rsPadrao.getBoolean("isentoICMSPadraoCliente"));

                //Seleciona Genero
                if (rsPadrao.getString("generoPadraoCliente").equals("M")) {
                    rbMasculino.setSelected(true);
                } else if (rsPadrao.getString("generoPadraoCliente").equals("F")) {
                    rbFeminino.setSelected(true);
                }

                cbEstadoCivil.setSelectedItem(rsPadrao.getString("estadoCivilPadraoCliente"));

                GerenciarCombo.setarOpcaocombo(cbCNAEDesc, rsPadrao.getString("cnaePadraoDescCliente"));
                GerenciarCombo.setarOpcaocombo(cbPaises, rsPadrao.getString("nacionalidadePadraoCliente"));
                GerenciarCombo.setarOpcaocombo(cbNaturalidade, rsPadrao.getString("naturalidadePadraoCliente"));
                GerenciarCombo.setarOpcaocombo(cbRegimeTributario, rsPadrao.getString("regimeTributarioPadraoCliente"));
                GerenciarCombo.setarOpcaocombo(cbUFs, rsPadrao.getString("ufPadraoCliente"));
                GerenciarCombo.setarOpcaocombo(cbMunicipio, rsPadrao.getString("municipioPadraoCliente"));

                ItemCombo codCNAEItem = (ItemCombo) cbCNAEDesc.getSelectedItem();

                txtCNAECodigo.setText(codCNAEItem.getIndice().toString());
            }

        } catch (SQLException ex) {

        }
    }

    public void filtraCbMunicipios() {

        cbMunicipio.removeAllItems();
        ItemCombo itemUF = (ItemCombo) cbUFs.getSelectedItem();
        String codigoUF = itemUF.getIndice().toString();
        //codigoUF.substring(0, 2);

        String strSQL = "SELECT codigo,municipio from CEP_MUNICIPIO WHERE codigo LIKE '" + codigoUF.substring(0, 2) + "%'";

        Connection con = DAO.getConexao();
        try {
            Statement stm = con.createStatement();
            ResultSet rsMunicipios = stm.executeQuery(strSQL);
            GerenciarCombo.preencherCombo(rsMunicipios, "codigo", "municipio", cbMunicipio);
        } catch (SQLException ex) {

        }

    }

    public void ImplementsBeansBinding() {
        BindingGroup grupoBinding = new BindingGroup();
        Binding binding;
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("iDUnico"), txtId, BeanProperty.create("text"));
        grupoBinding.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("codigo"), txtCodigo, BeanProperty.create("text"));
        grupoBinding.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("nome"), txtNome, BeanProperty.create("text"));
        grupoBinding.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("nomeFantasia"), txtNomeFantasia, BeanProperty.create("text"));
        grupoBinding.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("fonePrincipal"), jffTelFixo, BeanProperty.create("text"));
        grupoBinding.addBinding(binding);

        JComboBoxBinding comboBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, null, cbNaturalidade);
        grupoBinding.addBinding(comboBinding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("naturalidade"), cbNaturalidade, ELProperty.create("${selectedItem.ESTADO}"));
        grupoBinding.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("isentoICMS"), ckbIsentoICMS, BeanProperty.create("selected"));
        grupoBinding.addBinding(binding);

        //binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, cliente, BeanProperty.create("isentoICMS"),ckbIsentoICMS ,BeanProperty.create("selected"));
        //grupoBinding.addBinding(binding);
        grupoBinding.bind();
    }

    public void setarValoresCliente(Cliente cliente1, ManipulaComponentes.statusCadastro statusAcao) {
        Cliente clientePadrao = cliente1;
        //Criar método para controlar a inserção correta nos componentes do frame!!! Faltando Fazer!!
        //Gera o novo código sequencial através da chamadas de função abaixo
        if (statusAcao == ManipulaComponentes.statusCadastro.Adicionando) {
            clientePadrao.setCodigo(ClienteFacade.gerarNovoSequencialCliente(ClienteFacade.consultaCodigoLoja(), ClienteFacade.capturarUltimoSequencialCliente()));
            clientePadrao.setiDUnico(clientePadrao.getCodigo());
        } else {
            clientePadrao.setCodigo(clientePadrao.getCodigo());
            clientePadrao.setiDUnico(clientePadrao.getiDUnico());
        }
        clientePadrao.setDataCadastro(new Date());
        clientePadrao.setNome(txtNome.getText());
        clientePadrao.setNomeFantasia(txtNomeFantasia.getText());
        clientePadrao.setIsentoICMS(ckbIsentoICMS.isSelected());
        clientePadrao.setFonePrincipal(jffTelFixo.getText());
        clientePadrao.setCelular(jffCelular.getText());
        clientePadrao.setEmail(jffEmail.getText());

        if (rbPF.isSelected()) {
            tipoPessoa = "PF";
        } else if (rbPJ.isSelected()) {
            tipoPessoa = "PJ";
        } else if (rbE.isSelected()) {
            tipoPessoa = "ES";
        }
        clientePadrao.setTipoPessoa(tipoPessoa);

        if (rbAtivo.isSelected()) {
            statusCadastro = true;
        } else if (rbInativo.isSelected()) {
            statusCadastro = false;
        }

        clientePadrao.setStatusCadastro(statusCadastro);

        if (rbMasculino.isSelected()) {
            genero = "M";
        } else if (rbFeminino.isSelected()) {
            genero = "F";
        }
        clientePadrao.setGenero(genero);

        clientePadrao.setCpf(jffCPF.getText());
        clientePadrao.setCnpj(jffCNPJ.getText());
        clientePadrao.setRg(txtRG.getText());
        clientePadrao.setIe(txtIE.getText());

        clientePadrao.setOrgaoEmissorRG(txtOEmissor.getText().trim());
        clientePadrao.setEstadoCivil(cbEstadoCivil.getSelectedItem().toString());
        clientePadrao.setInscMunicipal(txtIM.getText());
        clientePadrao.setInscSuframa(txtSuframa.getText());

        ItemCombo itemNacionalidade = (ItemCombo) cbPaises.getSelectedItem();
        clientePadrao.setNacionalidade(itemNacionalidade.getDescricao());

        ItemCombo itemNaturalidade = (ItemCombo) cbNaturalidade.getSelectedItem();
        clientePadrao.setNaturalidade(itemNaturalidade.getDescricao());

        ItemCombo itemCNAEDesc = (ItemCombo) cbCNAEDesc.getSelectedItem();
        clientePadrao.setCnaeDescricao(itemCNAEDesc.getDescricao());
        Integer codCNAE = (Integer) itemCNAEDesc.getIndice();
        clientePadrao.setCnae(codCNAE);

        ItemCombo itemRegimeTributario = (ItemCombo) cbRegimeTributario.getSelectedItem();
        clientePadrao.setCodigoRegimeTributario(itemRegimeTributario.getIndice().toString());
        clientePadrao.setRegimeTributario(itemRegimeTributario.getDescricao());
        clientePadrao.setNascimento_Fundacao(dateNascimento.getDate());
        //Endereço:
        clientePadrao.setLogradouro(txtLogradouro.getText());
        clientePadrao.setComplemento(txtComplemento.getText());
        clientePadrao.setNumero(txtNumero.getText());

        ItemCombo itemUF = (ItemCombo) cbUFs.getSelectedItem();
        clientePadrao.setUf(itemUF.getDescricao());

        ItemCombo itemMuninipio = (ItemCombo) cbMunicipio.getSelectedItem();
        clientePadrao.setMunicipio(itemMuninipio.getDescricao());

        clientePadrao.setBairro(txtBairro.getText());

        clientePadrao.setCep(jffCEP.getText());

        Date dataNAsc = dateNascimento.getDate();
        if(dataNAsc == null){
            cliente.setNascimento_Fundacao(new Date("01/01/1900"));
        }
        else{
            cliente.setNascimento_Fundacao(dateNascimento.getDate());
        }
        

    }

    //Alterar o método para que o mesmo retorne um booleano, afim de verificar se o mesmo obteve algum resultado
    public void populaCamposDadosCliente(int codCliente) {

        try {

            //Inserir código que captura o tamanho do ResultSet para saber se a consulta obteve resultados
            rs = ClienteFacade.retornaDadosCliente(codCliente);

            while (rs.next()) {

                txtId.setText("" + rs.getInt("idunico"));
                txtCodigo.setText("" + rs.getInt("codigo"));
                dateCadastro.setDate(rs.getDate("dataad"));
                dateEdicao.setDate(rs.getDate("ultimamodificacao"));

                Boolean statusAtivo = rs.getBoolean("ativo");

                if (statusAtivo) {
                    rbAtivo.setSelected(true);
                } else {
                    rbInativo.setSelected(true);
                }

                txtNome.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("nome"), ""));
                txtNomeFantasia.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("apelido"), ""));
                ckbIsentoICMS.setSelected(TratamentoNulos.getTratarBoolean().Tratar(rs.getBoolean("isentoICMS"), false));
                jffCelular.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("CELULAR"), ""));
                jffTelFixo.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("FONE1"), ""));
                jffEmail.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("emailCliente"), ""));
                //Endereço
                txtLogradouro.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("endereco"), ""));
                txtComplemento.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("complemento"), ""));
                txtNumero.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("numero"), ""));

                //cbUFs.setSelectedItem();
                Auxiliares.GerenciarCombo.setarOpcaocombo(cbUFs, rs.getString("uf"));
                GerenciarCombo.setarOpcaocombo(cbPaises, rs.getString("nacionalidade"));
                GerenciarCombo.setarOpcaocombo(cbNaturalidade, rs.getString("naturalidade"));
                Auxiliares.GerenciarCombo.setarOpcaocombo(cbMunicipio, rs.getString("cidade"));
                //cbMunicipio.setSelectedItem(rs.getString("cidade"));
                txtBairro.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("bairro"), ""));
                jffCEP.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("cep"), ""));

                String regimeTributario = TratamentoNulos.getTratarString().Tratar(rs.getString("regimeTributario"), "");

                GerenciarCombo.setarOpcaocombo(cbRegimeTributario, regimeTributario); //<<===================

                GerenciarCombo.setarOpcaocombo(cbCNAEDesc, rs.getString("cnaeDescricao"));

                String tipoCLI = TratamentoNulos.getTratarString().Tratar(rs.getString("TIPOCLI"), "");

                switch (tipoCLI) {
                    case "PF":
                        rbPF.setSelected(true);
                        jTabbedPane1.setSelectedIndex(0);
                        break;
                    case "PJ":
                        rbPJ.setSelected(true);
                        jTabbedPane1.setSelectedIndex(1);
                        break;
                }

                jffCPF.setText(null);
                jffCPF.setText(rs.getString("cpf"));
                jffCNPJ.setText(null);
                jffCNPJ.setText(rs.getString("cnpj"));
                txtRG.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("rg"), ""));
                txtIE.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("ie"), ""));
                txtIM.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("inscricaoMunicipal"), ""));
                txtSuframa.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("inscricaoSuframa"), ""));

                String generoCliente = TratamentoNulos.getTratarString().Tratar(rs.getString("genero"), "");
                switch (generoCliente) {
                    case "M":
                        rbMasculino.setSelected(true);
                        break;
                    case "F":
                        rbFeminino.setSelected(true);
                        break;
                    default:
                        rbMasculino.setSelected(false);
                        rbFeminino.setSelected(false);
                        break;
                }
                txtOEmissor.setText(TratamentoNulos.getTratarString().Tratar(rs.getString("orgaoEmissorRG"), ""));
                cbEstadoCivil.setSelectedItem(rs.getString("ESTADOCIVIL"));

                java.sql.Date dataBanco = rs.getDate("NASC");
                    //DateFormat df1 = DateFormat.getDateInstance();
                //df1.format(dataBanco);                   
                dateNascimento.setDate(dataBanco);

                    //JOptionPane.showMessageDialog(null, dataNascBanco);
                //java.util.Date dataNascimento = new java.util.Date(dataBanco.toString());
                //dateNascimento.setDate(dataNascimento);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Popular Campos!: " + '\n' + ex.getMessage());

        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Popular Campos!: " + '\n' + ex.getMessage());
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Popular Campos!: " + '\n' + ex.getMessage());
        }

    }

    //private void carrega
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
            java.util.logging.Logger.getLogger(frmCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmCadastrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCNAE;
    private javax.swing.JButton btnAddFoto;
    private javax.swing.JButton btnDeleteFoto;
    private javax.swing.JButton btnDispose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLocalizarCEP;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup btngroupGenero;
    private javax.swing.ButtonGroup btngroupStatus;
    private javax.swing.ButtonGroup btngroupTipoPessoa;
    private javax.swing.JComboBox cbCNAEDesc;
    private javax.swing.JComboBox cbEstadoCivil;
    private javax.swing.JComboBox cbMunicipio;
    private javax.swing.JComboBox cbNaturalidade;
    private javax.swing.JComboBox cbPaises;
    private javax.swing.JComboBox cbRegimeTributario;
    private javax.swing.JComboBox cbUFs;
    private javax.swing.JCheckBox ckbIsentoICMS;
    private com.toedter.calendar.JDateChooser dateCadastro;
    private com.toedter.calendar.JDateChooser dateEdicao;
    private com.toedter.calendar.JDateChooser dateNascimento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JFormattedTextField jffCEP;
    private javax.swing.JFormattedTextField jffCNPJ;
    private javax.swing.JFormattedTextField jffCPF;
    private javax.swing.JFormattedTextField jffCelular;
    private javax.swing.JFormattedTextField jffEmail;
    private javax.swing.JFormattedTextField jffTelFixo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelDadosGerais;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JRadioButton rbAtivo;
    private javax.swing.JRadioButton rbE;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbInativo;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JRadioButton rbPF;
    private javax.swing.JRadioButton rbPJ;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCNAECodigo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtIE;
    private javax.swing.JTextField txtIM;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtOEmissor;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtSubstituicaoTributaria;
    private javax.swing.JTextField txtSuframa;
    // End of variables declaration//GEN-END:variables

}
