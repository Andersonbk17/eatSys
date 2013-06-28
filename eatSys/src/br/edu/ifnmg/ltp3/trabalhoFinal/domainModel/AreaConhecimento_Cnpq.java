/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lewandowsky
 */
public class AreaConhecimento_Cnpq {
    private int idAreaConhecimento_Cnpq;
    private String codigo;
    private String nome;
    private List<AreaConhecimento_CnpqSubAreas> listaAreasConhecimento;

    public AreaConhecimento_Cnpq(int idAreaConhecimento_Cnpq, String codigo, String nome
            ,List<AreaConhecimento_CnpqSubAreas> listaAreasConhecimento) {
        this.idAreaConhecimento_Cnpq = idAreaConhecimento_Cnpq;
        this.codigo = codigo;
        this.nome = nome;
        this.listaAreasConhecimento = listaAreasConhecimento;
    }
    
    public AreaConhecimento_Cnpq() {
        this.idAreaConhecimento_Cnpq = 0;
        this.codigo = "";
        this.nome = "";
        this.listaAreasConhecimento = new LinkedList<>();
    }

    public int getIdAreaConhecimento_Cnpq() {
        return idAreaConhecimento_Cnpq;
    }

    public void setIdAreaConhecimento_Cnpq(int idAreaConhecimento_Cnpq) {
        this.idAreaConhecimento_Cnpq = idAreaConhecimento_Cnpq;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AreaConhecimento_CnpqSubAreas> getListaAreasConhecimento() {
        return listaAreasConhecimento;
    }

    public void setListaAreasConhecimento(List<AreaConhecimento_CnpqSubAreas> listaAreasConhecimento) {
        this.listaAreasConhecimento = listaAreasConhecimento;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idAreaConhecimento_Cnpq;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final AreaConhecimento_Cnpq other = (AreaConhecimento_Cnpq) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   codigo + "-" + nome ;
    }
      
    
}
