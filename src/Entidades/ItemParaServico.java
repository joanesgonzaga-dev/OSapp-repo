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
public class ItemParaServico {
    
    private Integer idUnico;
    private String descricao;
    private String fabricante;
    private String modelo;
    private String numeroSerie;
    private String campoLivre;
    private Integer ano1;
    private Integer ano2;

    /**
     * @return the idUnico
     */
    public Integer getIdUnico() {
        return idUnico;
    }

    /**
     * @param idUnico the idUnico to set
     */
    public void setIdUnico(Integer idUnico) {
        this.idUnico = idUnico;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the numeroSerie
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * @param numeroSerie the numeroSerie to set
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * @return the campoLivre
     */
    public String getCampoLivre() {
        return campoLivre;
    }

    /**
     * @param campoLivre the campoLivre to set
     */
    public void setCampoLivre(String campoLivre) {
        this.campoLivre = campoLivre;
    }

    /**
     * @return the ano1
     */
    public Integer getAno1() {
        return ano1;
    }

    /**
     * @param ano1 the ano1 to set
     */
    public void setAno1(Integer ano1) {
        this.ano1 = ano1;
    }

    /**
     * @return the ano2
     */
    public Integer getAno2() {
        return ano2;
    }

    /**
     * @param ano2 the ano2 to set
     */
    public void setAno2(Integer ano2) {
        this.ano2 = ano2;
    }
    
    public enum comparaPropriedadesExclusivas{
        
    }
    
}
