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
public class Estado {
    private int idEstado;
    private String nomeEstado;
    private String uf;
   
    
    public Estado(int idEstado, String nomeEstado, String uf) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
    }
    
     public Estado() {
        this.idEstado = 0;
        this.nomeEstado = "";
        this.uf = "";
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.idEstado;
        hash = 23 * hash + Objects.hashCode(this.nomeEstado);
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
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado) {
            return false;
        }
        if (!Objects.equals(this.nomeEstado, other.nomeEstado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeEstado;
    }
    
    
    
}
