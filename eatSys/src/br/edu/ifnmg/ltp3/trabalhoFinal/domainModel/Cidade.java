/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Objects;

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

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Estado getCidadeEstado() {
        return cidadeEstado;
    }

    public void setCidadeEstado(Estado cidadeEstado) {
        this.cidadeEstado = cidadeEstado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCidade;
        hash = 97 * hash + Objects.hashCode(this.nomeCidade);
        hash = 97 * hash + Objects.hashCode(this.cidadeEstado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade) {
            return false;
        }
        if (!Objects.equals(this.nomeCidade, other.nomeCidade)) {
            return false;
        }
        if (!Objects.equals(this.cidadeEstado, other.cidadeEstado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nomeCidade ;
    }
    
    
    
    
}
