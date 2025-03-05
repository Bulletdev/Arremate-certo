
package com.bulletinfotech.licitacao.model;

public class Pregao {
    private String descricao;
    private String situacao;
    private double valorProposto;

    public Pregao(String descricao, String situacao, double valorProposto) {
        this.descricao = descricao;
        this.situacao = situacao;
        this.valorProposto = valorProposto;
    }

    public String getDescricao() { return descricao; }
    public String getSituacao() { return situacao; }
    public double getValorProposto() { return valorProposto; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }
    public void setValorProposto(double valorProposto) { this.valorProposto = valorProposto; }
}