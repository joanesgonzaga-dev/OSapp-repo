/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Facade;

import Configuracoes.DAO;
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.eclipse.persistence.internal.helper.Helper;

/**
 *
 * @author Joanes Gonzaga
 */
public class ClienteFacade {
    
    public static boolean adicionarCliente(Cliente cliente) {
        boolean retorno = false;
        int retornoInsert = -1;
        
        String mensagemErro = null;
        try {
            Connection conn = Configuracoes.DAO.getConexao();
            String sqlInsert = "INSERT INTO clientes(idunico,codigo,nome,apelido,FONE1,nacionalidade,naturalidade,isentoICMS, tipoCLI,ativo,dataad,emailCliente,estadocivil,genero,celular,cpf,rg,orgaoEmissorRG,inscricaoMunicipal,inscricaoSuframa,cnaeCodigo,cnaeDescricao,NASC,endereco,complemento,numero,uf,cidade,bairro,cep,codigoRegimeTributario,regimeTributario,cnpj,ie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sqlInsert);
            stm.setInt(1, cliente.getiDUnico());
            stm.setInt(2, cliente.getCodigo());
            stm.setString(3, cliente.getNome());
            stm.setString(4, cliente.getNomeFantasia());
           //stm.setInt(5, cliente.getCodPais());
            //stm.setString(6, cliente.getPais());
            stm.setString(5, cliente.getFonePrincipal());      
            //stm.setString(6, cliente.getUf());
            //stm.setInt(7, cliente.getCodNaturalidade());
            stm.setString(6, cliente.getNacionalidade());
            stm.setString(7, cliente.getNaturalidade());
           //stm.setInt(8, cliente.getCodMunicipio());
           //stm.setString(9, cliente.getMunicipio());
            stm.setBoolean(8, cliente.isIsentoICMS());
            stm.setString(9, cliente.getTipoPessoa());
            stm.setBoolean(10, cliente.isStatusCadastro());
            
            java.util.Date utilData = cliente.getDataCadastro();
            java.sql.Date sqlData = new java.sql.Date(utilData.getTime());
            stm.setDate(11, sqlData);
            
            stm.setString(12, cliente.getEmail());
            stm.setString(13, cliente.getEstadoCivil());
            stm.setString(14, cliente.getGenero());
            stm.setString(15, cliente.getCelular());
            stm.setString(16, cliente.getCpf());
            stm.setString(17, cliente.getRg());
            stm.setString(18,cliente.getOrgaoEmissorRG());
            stm.setString(19, cliente.getInscMunicipal());
            stm.setString(20, cliente.getInscSuframa());
            stm.setInt(21, cliente.getCnae());
            stm.setString(22,cliente.getCnaeDescricao());
            //java.util.Date utilDataNASC;
            java.util.Date utilDataNASC = cliente.getNascimento_Fundacao();
            java.sql.Date sqlDataNASC = new java.sql.Date(utilDataNASC.getTime());
            stm.setDate(23, sqlDataNASC);
            
            //Endereço
            stm.setString(24, cliente.getLogradouro());
            stm.setString(25, cliente.getComplemento());
            stm.setString(26, cliente.getNumero());
            stm.setString(27, cliente.getUf());
            stm.setString(28, cliente.getMunicipio());
            stm.setString(29,cliente.getBairro());
            stm.setString(30, cliente.getCep());
            stm.setString(31, cliente.getCodigoRegimeTributario());
            stm.setString(32, cliente.getRegimeTributario());
            stm.setString(33, cliente.getCnpj());
            stm.setString(34, cliente.getIe());
            
            
            //JOptionPane.showConfirmDialog(null, sqlInsert);
            retornoInsert = stm.executeUpdate();
            if (retornoInsert < 0) {
                mensagemErro = "O código não executou!";
                retorno = false;
                
            } else if (retornoInsert == 0) {
                mensagemErro = "Nada foi inserido! Consulte o log da aplicação";
                retorno = false;
            } else if (retornoInsert > 0) {
                JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!", "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                retorno = true;
                }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Adicionar o Novo cliente! - Erro: " + mensagemErro + ex.getMessage());
            retorno = false;
        }

        return retorno;
    }
    
    public static int atualizarCliente(Cliente cliente){
        
        int retorno = -1;
        Connection con = DAO.getConexao();
        
        try{
            PreparedStatement pStm = con.prepareStatement("UPDATE clientes SET nome=?,apelido=?,BAIRRO=?"
                    + ",CIDADE=?,UF=?,cep=?,FONE1=?,CELULAR=?,NASC=?"
                    + ",ESTADOCIVIL=?,CPF=?,RG=?,TIPOCLI=?,ENDERECO=?,NATURALIDADE=? "
                    + ",numero=?,complemento=?,pais=?,genero=?,isentoICMS=?,ativo=?"
                    + ",nacionalidade=?,emailCliente=?,orgaoEmissorRG=?,inscricaoMunicipal=?"
                    + ",inscricaoSuframa=?,cnaeDescricao=?,cnaeCodigo=?,codigoRegimeTributario=?"
                    + ",regimeTributario=? WHERE codigo=" + cliente.getCodigo());
            pStm.setString(1, cliente.getNome());
            pStm.setString(2,cliente.getNomeFantasia());
            pStm.setString(3, cliente.getBairro());
            pStm.setString(4,cliente.getMunicipio());
            pStm.setString(5, cliente.getUf());
            pStm.setString(6, cliente.getCep());
            pStm.setString(7, cliente.getFonePrincipal());
            pStm.setString(8, cliente.getCelular());
            
            java.util.Date utilDataNASC = cliente.getNascimento_Fundacao();
            java.sql.Date sqlDataNASC = new java.sql.Date(utilDataNASC.getTime());
            pStm.setDate(9, sqlDataNASC);
            
            pStm.setString(10, cliente.getEstadoCivil());
            pStm.setString(11, cliente.getCpf());
            pStm.setString(12, cliente.getRg());
            pStm.setString(13, cliente.getTipoPessoa());
            pStm.setString(14, cliente.getLogradouro());
            pStm.setString(15, cliente.getNaturalidade());
            
            pStm.setString(16, cliente.getNumero());
            pStm.setString(17, cliente.getComplemento());
            pStm.setString(18, cliente.getPais());
            pStm.setString(19, cliente.getGenero());
            pStm.setBoolean(20, cliente.isIsentoICMS());
            pStm.setBoolean(21, cliente.isStatusCadastro());
            
            pStm.setString(22, cliente.getNacionalidade());
            pStm.setString(23, cliente.getEmail());
            pStm.setString(24, cliente.getOrgaoEmissorRG());
            pStm.setString(25, cliente.getInscMunicipal());
            
            pStm.setString(26, cliente.getInscSuframa());
            pStm.setString(27, cliente.getCnaeDescricao());
            pStm.setInt(28, cliente.getCnae());
            pStm.setString(29, cliente.getCodigoRegimeTributario());
            pStm.setString(30, cliente.getRegimeTributario());
            
            
            retorno = pStm.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return retorno;
    }
    
    public static ResultSet retornaDadosCliente(int codCliente){
        
        Connection con = DAO.getConexao();
        ResultSet rs = null;
        try{
        PreparedStatement pStm = con.prepareStatement("SELECT * FROM clientes WHERE codigo=?");
        pStm.setInt(1, codCliente);
        rs = pStm.executeQuery();
        
         }
        catch(SQLException ex){
            
        }
        return rs;
    }

    public static int capturarUltimoSequencialCliente() {
        int codigoAtual = 0;
        try {
            Connection con = DAO.getConexao();
            PreparedStatement stm = con.prepareStatement("SELECT valor FROM sequencialTabelas WHERE nomeTabela= 'CLIENTES' ");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                codigoAtual = rs.getInt("valor");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível capturar o último código sequencial de cliente!");
        }

        return codigoAtual;
    }

    public static int consultaCodigoLoja() {

        int codigoLoja = 0;

        Connection con = DAO.getConexao();
        try {
            PreparedStatement stm = con.prepareStatement("SELECT codigo FROM Lojas WHERE atual = 'S' ");

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                codigoLoja = rs.getInt("codigo");
            }

            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro ao tentar obter o código da loja atual \n" + ex.getMessage());
        }

        return codigoLoja;
    }

    public static int gerarNovoSequencialCliente(int codigoLoja, int ultimoCodigoSequencial) {

        ultimoCodigoSequencial = ultimoCodigoSequencial + 1;
        //Gerar o código UPDATE na coluna valor, da tabela SequencialTabelas
        Connection con = DAO.getConexao();
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE SequencialTabelas SET valor=" + ultimoCodigoSequencial + " WHERE NomeTabela = 'CLIENTES' ");
            int result = stm.executeUpdate();
        } catch (SQLException ex) {

        }

        String loja = "" + codigoLoja;
        String cliente = "" + ultimoCodigoSequencial;
        String novoCodigo = loja + "0" + cliente;
        int novoSequencial = Integer.parseInt(novoCodigo);

        return novoSequencial;
    }
    
}
