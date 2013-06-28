/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Objects;

/**
 *
 * @author lewandowsky
 */
public class AreaConhecimento_CnpqSubAreas {
    private int idAreaConhecimento_CnpqSubAreas;
    private String nome;
    private String codigo;

    public AreaConhecimento_CnpqSubAreas(int idAreaConhecimento_CnpqSubAreas, String nome, String codigo) {
        this.idAreaConhecimento_CnpqSubAreas = idAreaConhecimento_CnpqSubAreas;
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public AreaConhecimento_CnpqSubAreas() {
        this.idAreaConhecimento_CnpqSubAreas = 0;
        this.nome = "";
        this.codigo = "";
    }

    public int getIdAreaConhecimento_CnpqSubAreas() {
        return idAreaConhecimento_CnpqSubAreas;
    }

    public void setIdAreaConhecimento_CnpqSubAreas(int idAreaConhecimento_CnpqSubAreas) {
        this.idAreaConhecimento_CnpqSubAreas = idAreaConhecimento_CnpqSubAreas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idAreaConhecimento_CnpqSubAreas;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final AreaConhecimento_CnpqSubAreas other = (AreaConhecimento_CnpqSubAreas) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo +"-" + nome   ;
    }
    
    
    
    
}
