/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.util.Date;

/**
 *
 * @author Joanes Gonzaga
 */
public class Atendimento {
    
    private Integer codigo;
    private Integer codAtendente;
    private String nomeAtendente;
    private Date dataEntrada;
    private Date horaEntrada;
    private Integer codCliente;
    private String nomeCliente;
    private Date previsaoEntrega;
    private Date horaPrevista;
    private Date conclusao;
    private Date retirada;
    private String horaRetirada;
    private String obs;
    private String situacao;
    private double desconto;
    private double totalBruto;
    private double percdesc;
    private Integer loja;
    private String localizacao;
    private Integer filial;
    private Date ultimaModificacao;

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
        this.codigo = codigo;
    }

    /**
     * @return the codAtendente
     */
    public Integer getCodAtendente() {
        return codAtendente;
    }

    /**
     * @param codAtendente the codAtendente to set
     */
    public void setCodAtendente(Integer codAtendente) {
        this.codAtendente = codAtendente;
    }

    /**
     * @return the nomeAtendente
     */
    public String getNomeAtendente() {
        return nomeAtendente;
    }

    /**
     * @param nomeAtendente the nomeAtendente to set
     */
    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the horaEntrada
     */
    public Date getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the codCliente
     */
    public Integer getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the previsaoEntrega
     */
    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    /**
     * @param previsaoEntrega the previsaoEntrega to set
     */
    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    /**
     * @return the horaPrevista
     */
    public Date getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * @param horaPrevista the horaPrevista to set
     */
    public void setHoraPrevista(Date horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    /**
     * @return the conclusao
     */
    public Date getConclusao() {
        return conclusao;
    }

    /**
     * @param conclusao the conclusao to set
     */
    public void setConclusao(Date conclusao) {
        this.conclusao = conclusao;
    }

    /**
     * @return the retirada
     */
    public Date getRetirada() {
        return retirada;
    }

    /**
     * @param retirada the retirada to set
     */
    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    /**
     * @return the horaRetirada
     */
    public String getHoraRetirada() {
        return horaRetirada;
    }

    /**
     * @param horaRetirada the horaRetirada to set
     */
    public void setHoraRetirada(String horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the totalBruto
     */
    public double getTotalBruto() {
        return totalBruto;
    }

    /**
     * @param totalBruto the totalBruto to set
     */
    public void setTotalBruto(double totalBruto) {
        this.totalBruto = totalBruto;
    }

    /**
     * @return the percdesc
     */
    public double getPercdesc() {
        return percdesc;
    }

    /**
     * @param percdesc the percdesc to set
     */
    public void setPercdesc(double percdesc) {
        this.percdesc = percdesc;
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
        this.loja = loja;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the filial
     */
    public Integer getFilial() {
        return filial;
    }

    /**
     * @param filial the filial to set
     */
    public void setFilial(Integer filial) {
        this.filial = filial;
    }

    /**
     * @return the ultimaModificacao
     */
    public Date getUltimaModificacao() {
        return ultimaModificacao;
    }

    /**
     * @param ultimaModificacao the ultimaModificacao to set
     */
    public void setUltimaModificacao(Date ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }
    
    
}
