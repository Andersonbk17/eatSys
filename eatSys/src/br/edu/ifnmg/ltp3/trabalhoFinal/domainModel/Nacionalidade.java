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
public class Nacionalidade {
    private int idNacionalidade;
    private String nome;

    public Nacionalidade(int idNacionalidade, String nome) {
        this.idNacionalidade = idNacionalidade;
        this.nome = nome;
    }
    
    public Nacionalidade() {
        this.idNacionalidade = 0;
        this.nome = "";
    }

    public int getIdNacionalidade() {
        return idNacionalidade;
    }

    public void setIdNacionalidade(int idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idNacionalidade;
        hash = 59 * hash + Objects.hashCode(this.nome);
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
        final Nacionalidade other = (Nacionalidade) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nome ;
    }
    
    
    
}
