/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

/**
 *
 * @author emerson
 */
public class Cidade {
    private int idCidade;
    private String nomeCidade;
    
    private Estado cidadeEstado;

    public Cidade(int idCidade, String nomeCidade, Estado cidadeEstado) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.cidadeEstado = cidadeEstado;
    }
    
    public Cidade() {
        this.idCidade = 0;
        this.nomeCidade = "";
        this.cidadeEstado = new Estado();
    }
    
    
    
}
