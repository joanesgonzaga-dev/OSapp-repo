/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Auxiliares.ItemCombo;
import Configuracoes.Conexao;
import Configuracoes.DAO;
import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Joanes Gonzaga
 */
public class Cliente {

    //Dados Pessoa
    private String cpf;
    private String cnpj;
    private String rg;
    private String ie;
    private String orgaoEmissorRG;
    private String tipoPessoa;
    private String genero;
    private String nome;
    private String nomeFantasia;
    private String nacionalidade;
    private Integer codNaturalidade;
    private String naturalidade;
    private Date nascimento_Fundacao;

    //Dados Quanto Cliente
    private Integer iDUnico;
    private Integer codigo;
    private Integer loja;
    private boolean statusCadastro;
    private Date dataCadastro;
    private Date dataEdicao;
    private Image foto_Logo;

    //Dados Tributarios
    private boolean isentoICMS;
    private String inscMunicipal;
    private Integer cnae;
    private String cnaeDescricao;
    private Integer ieSubTributaria;
    private String inscSuframa;
    private String codigoRegimeTributario;
    private String regimeTributario;

    //Endereco
    private String logradouro;
    private String numero;
    private String complemento;
    private Integer codPais;
    private String pais;
    private Integer codUF;
    private String uf;
    private Integer codMunicipio;
    private String municipio;
    private Integer codBairro;
    private String bairro;
    private String cep;
    private String fonePrincipal;
    private String celular;
    private String email;
    private String estadoCivil;
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    
    public void addPropertyChangeListener(PropertyChangeListener listener){
       propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * @return the cpf_CNPJ
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf_CNPJ the cpf_CNPJ to set
     */
    public void setCpf(String cpf) {
        java.lang.String oldCpf = this.cpf;
        this.cpf = cpf;
        propertyChangeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    /**
     * @return the rg_IE
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg_IE to set
     */
    public void setRg(String rg) {
        java.lang.String oldRg = this.rg;
        this.rg = rg;
        propertyChangeSupport.firePropertyChange("rg", oldRg, rg);
    }

    /**
     * @return the orgaoEmissorRG
     */
    public String getOrgaoEmissorRG() {
        return orgaoEmissorRG;
    }

    /**
     * @param orgaoEmissorRG the orgaoEmissorRG to set
     */
    public void setOrgaoEmissorRG(String orgaoEmissorRG) {
        java.lang.String oldOrgaoEmissorRG = this.orgaoEmissorRG;
        this.orgaoEmissorRG = orgaoEmissorRG;
        propertyChangeSupport.firePropertyChange("orgaoEmissorRG", oldOrgaoEmissorRG, orgaoEmissorRG);
    }

    /**
     * @return the tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(String tipoPessoa) {
        String oldTipoPessoa = this.tipoPessoa;
        this.tipoPessoa = tipoPessoa;
        propertyChangeSupport.firePropertyChange("tipoPessoa", oldTipoPessoa, tipoPessoa);
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        java.lang.String oldGenero = this.genero;
        this.genero = genero;
        propertyChangeSupport.firePropertyChange("genero", oldGenero, genero);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        java.lang.String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange("nome", oldNome, nome);
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        java.lang.String oldNomeFantasia = this.nomeFantasia;
        this.nomeFantasia = nomeFantasia;
        propertyChangeSupport.firePropertyChange("nomeFantasia", oldNomeFantasia, nomeFantasia);
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        java.lang.String oldNacionalidade = this.nacionalidade;
        this.nacionalidade = nacionalidade;
        propertyChangeSupport.firePropertyChange("nacionalidade", oldNacionalidade, nacionalidade);
    }

    /**
     * @return the codNaturalidade
     */
    public Integer getCodNaturalidade() {
        return codNaturalidade;
    }

    /**
     * @param codNaturalidade the codNaturalidade to set
     */
    public void setCodNaturalidade(Integer codNaturalidade) {
        Integer oldCodNaturalidade = this.codNaturalidade;
        this.codNaturalidade = codNaturalidade;
        propertyChangeSupport.firePropertyChange("codNaturalidade", oldCodNaturalidade, codNaturalidade);
    }

    /**
     * @return the naturalidade
     */
    public String getNaturalidade() {
        return this.naturalidade;
    }

    /**
     * @param naturalidade the naturalidade to set
     */
    public void setNaturalidade(String naturalidade) {
        java.lang.String oldNaturalidade = this.naturalidade;
        this.naturalidade = naturalidade;
        propertyChangeSupport.firePropertyChange("naturalidade", oldNaturalidade, naturalidade);
    }

    /**
     * @return the nascimento_Fundacao
     */
    public Date getNascimento_Fundacao() {
        
        
        return nascimento_Fundacao;
    }

    /**
     * @param nascimento_Fundacao the nascimento_Fundacao to set
     */
    public void setNascimento_Fundacao(Date nascimento_Fundacao) {

        java.util.Date oldNascimento_Fundacao = this.nascimento_Fundacao;
        this.nascimento_Fundacao = nascimento_Fundacao;
        propertyChangeSupport.firePropertyChange("nascimento_Fundacao", oldNascimento_Fundacao, nascimento_Fundacao);
    }

    /**
     * @return the iDUnico
     */
    public Integer getiDUnico() {
        return iDUnico;
    }

    /**
     * @param iDUnico the iDUnico to set
     */
    
    public void setiDUnico(Integer iDUnico) {
        Integer oldiDUnico = this.iDUnico;
        this.iDUnico = iDUnico;
        propertyChangeSupport.firePropertyChange("iDUnico", oldiDUnico, iDUnico);
    }
    
    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    
    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }
    
    /**
     * @return the loja
     */
    public Integer getLoja() {
        return loja;
    }

    /**
     * @param loja the loja to set
     */
    public void setLoja(Integer loja) {
        Integer oldLoja = this.loja;
        this.loja = loja;
        propertyChangeSupport.firePropertyChange("loja", oldLoja, loja);
    }

    /**
     * @return the statusCadastro
     */
    public boolean isStatusCadastro() {
        return statusCadastro;
    }

    /**
     * @param statusCadastro the statusCadastro to set
     */
    public void setStatusCadastro(boolean statusCadastro) {
        boolean oldStatusCadastro = this.statusCadastro;
        this.statusCadastro = statusCadastro;
        propertyChangeSupport.firePropertyChange("statusCadastro", oldStatusCadastro, statusCadastro);
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        java.util.Date oldDataCadastro = this.dataCadastro;
        this.dataCadastro = dataCadastro;
        propertyChangeSupport.firePropertyChange("dataCadastro", oldDataCadastro, dataCadastro);
    }

    /**
     * @return the dataEdicao
     */
    public Date getDataEdicao() {
        return dataEdicao;
    }

    /**
     * @param dataEdicao the dataEdicao to set
     */
    public void setDataEdicao(Date dataEdicao) {
        java.util.Date oldDataEdicao = this.dataEdicao;
        this.dataEdicao = dataEdicao;
        propertyChangeSupport.firePropertyChange("dataEdicao", oldDataEdicao, dataEdicao);
    }

    /**
     * @return the foto_Logo
     */
    public Image getFoto_Logo() {
        return foto_Logo;
    }

    /**
     * @param foto_Logo the foto_Logo to set
     */
    public void setFoto_Logo(Image foto_Logo) {
        java.awt.Image oldFoto_Logo = this.foto_Logo;
        this.foto_Logo = foto_Logo;
        propertyChangeSupport.firePropertyChange("foto_Logo", oldFoto_Logo, foto_Logo);
    }

    /**
     * @return the isentoICMS
     */
    public boolean isIsentoICMS() {
        return isentoICMS;
    }

    /**
     * @param isentoICMS the isentoICMS to set
     */
    public void setIsentoICMS(boolean isentoICMS) {
        boolean oldIsentoICMS = this.isentoICMS;
        this.isentoICMS = isentoICMS;
        propertyChangeSupport.firePropertyChange("isentoICMS", oldIsentoICMS, isentoICMS);
    }

    /**
     * @return the inscMunicipal
     */
    public String getInscMunicipal() {
        return inscMunicipal;
    }

    /**
     * @param inscMunicipal the inscMunicipal to set
     */
    public void setInscMunicipal(String inscMunicipal) {
        java.lang.String oldInscMunicipal = this.inscMunicipal;
        this.inscMunicipal = inscMunicipal;
        propertyChangeSupport.firePropertyChange("inscMunicipal", oldInscMunicipal, inscMunicipal);
    }

    /**
     * @return the cnae
     */
    public Integer getCnae() {
        return cnae;
    }

    /**
     * @param cnae the cnae to set
     */
    public void setCnae(Integer cnae) {
        Integer oldCnae = this.cnae;
        this.cnae = cnae;
        propertyChangeSupport.firePropertyChange("cnae", oldCnae, cnae);
    }

    /**
     * @return the ieSubTributaria
     */
    public Integer getIeSubTributaria() {
        return ieSubTributaria;
    }

    /**
     * @param ieSubTributaria the ieSubTributaria to set
     */
    public void setIeSubTributaria(Integer ieSubTributaria) {
        Integer oldIeSubTributaria = this.ieSubTributaria;
        this.ieSubTributaria = ieSubTributaria;
        propertyChangeSupport.firePropertyChange("ieSubTributaria", oldIeSubTributaria, ieSubTributaria);
    }

    /**
     * @return the inscSuframa
     */
    public String getInscSuframa() {
        return inscSuframa;
    }

    /**
     * @param inscSuframa the inscSuframa to set
     */
    public void setInscSuframa(String inscSuframa) {
        String oldInscSuframa = this.inscSuframa;
        this.inscSuframa = inscSuframa;
        propertyChangeSupport.firePropertyChange("inscSuframa", oldInscSuframa, inscSuframa);
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        java.lang.String oldLogradouro = this.logradouro;
        this.logradouro = logradouro;
        propertyChangeSupport.firePropertyChange("logradouro", oldLogradouro, logradouro);
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        java.lang.String oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        java.lang.String oldComplemento = this.complemento;
        this.complemento = complemento;
        propertyChangeSupport.firePropertyChange("complemento", oldComplemento, complemento);
    }

    /**
     * @return the codPais
     */
    public Integer getCodPais() {
        return codPais;
    }

    /**
     * @param codPais the codPais to set
     */
    public void setCodPais(Integer codPais) {
        Integer oldCodPais = this.codPais;
        this.codPais = codPais;
        propertyChangeSupport.firePropertyChange("codPais", oldCodPais, codPais);
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        java.lang.String oldPais = this.pais;
        this.pais = pais;
        propertyChangeSupport.firePropertyChange("pais", oldPais, pais);
    }

    /**
     * @return the codUF
     */
    public int getCodUF() {
        return codUF;
    }

    /**
     * @param codUF the codUF to set
     */
    public void setCodUF(Integer codUF) {
        Integer oldCodUF = this.codUF;
        this.codUF = codUF;
        propertyChangeSupport.firePropertyChange("codUF", oldCodUF, codUF);
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        java.lang.String oldUf = this.uf;
        this.uf = uf;
        propertyChangeSupport.firePropertyChange("uf", oldUf, uf);
    }

    /**
     * @return the codMunicipio
     */
    public Integer getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * @param codMunicipio the codMunicipio to set
     */
    public void setCodMunicipio(Integer codMunicipio) {
        Integer oldCodMunicipio = this.codMunicipio;
        this.codMunicipio = codMunicipio;
        propertyChangeSupport.firePropertyChange("codMunicipio", oldCodMunicipio, codMunicipio);
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        java.lang.String oldMunicipio = this.municipio;
        this.municipio = municipio;
        propertyChangeSupport.firePropertyChange("municipio", oldMunicipio, municipio);
    }

    /**
     * @return the codBairro
     */
    public Integer getCodBairro() {
        return codBairro;
    }

    /**
     * @param codBairro the codBairro to set
     */
    public void setCodBairro(Integer codBairro) {
        Integer oldCodBairro = this.codBairro;
        this.codBairro = codBairro;
        propertyChangeSupport.firePropertyChange("codBairro", oldCodBairro, codBairro);
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        java.lang.String oldBairro = this.bairro;
        this.bairro = bairro;
        propertyChangeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        java.lang.String oldCep = this.cep;
        this.cep = cep;
        propertyChangeSupport.firePropertyChange("cep", oldCep, cep);
    }

    /**
     * @return the fonePrincipal
     */
    public String getFonePrincipal() {
        return fonePrincipal;
    }

    /**
     * @param fonePrincipal the fonePrincipal to set
     */
    public void setFonePrincipal(String fonePrincipal) {
        java.lang.String oldFonePrincipal = this.fonePrincipal;
        this.fonePrincipal = fonePrincipal;
        propertyChangeSupport.firePropertyChange("fonePrincipal", oldFonePrincipal, fonePrincipal);
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        java.lang.String oldCelular = this.celular;
        this.celular = celular;
        propertyChangeSupport.firePropertyChange("celular", oldCelular, celular);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        java.lang.String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange("email", oldEmail, email);
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the cnaeDescricao
     */
    public String getCnaeDescricao() {
        return cnaeDescricao;
    }

    /**
     * @param cnaeDescricao the cnaeDescricao to set
     */
    public void setCnaeDescricao(String cnaeDescricao) {
        java.lang.String oldCnaeDescricao = this.cnaeDescricao;
        this.cnaeDescricao = cnaeDescricao;
        propertyChangeSupport.firePropertyChange("cnaeDescricao", oldCnaeDescricao, cnaeDescricao);
    }

    /**
     * @return the codigoRegimeTributario
     */
    public String getCodigoRegimeTributario() {
        return codigoRegimeTributario;
    }

    /**
     * @param codigoRegimeTributario the codigoRegimeTributario to set
     */
    public void setCodigoRegimeTributario(String codigoRegimeTributario) {
        java.lang.String oldCodigoRegimeTributario = this.codigoRegimeTributario;
        this.codigoRegimeTributario = codigoRegimeTributario;
        propertyChangeSupport.firePropertyChange("codigoRegimeTributario", oldCodigoRegimeTributario, codigoRegimeTributario);
    }

    /**
     * @return the regimeTributario
     */
    public String getRegimeTributario() {
        return regimeTributario;
    }

    /**
     * @param regimeTributario the regimeTributario to set
     */
    public void setRegimeTributario(String regimeTributario) {
        java.lang.String oldRegimeTributario = this.regimeTributario;
        this.regimeTributario = regimeTributario;
        propertyChangeSupport.firePropertyChange("regimeTributario", oldRegimeTributario, regimeTributario);
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        java.lang.String oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        propertyChangeSupport.firePropertyChange("cnpj", oldCnpj, cnpj);
    }

    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        java.lang.String oldIe = this.ie;
        this.ie = ie;
        propertyChangeSupport.firePropertyChange("ie", oldIe, ie);
    }

    

    /**
     * @return the estado
     */
    

    
}
