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
public class Campus {
    private int idCampus;
    private String nome;

    public Campus(int idCampus, String nome) {
        this.idCampus = idCampus;
        this.nome = nome;
    }
    
    public Campus() {
        this.idCampus = 0;
        this.nome = "";
    }

    public int getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(int idCampus) {
        this.idCampus = idCampus;
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
        hash = 71 * hash + this.idCampus;
        hash = 71 * hash + Objects.hashCode(this.nome);
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
        final Campus other = (Campus) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nome;
    }
    
    
}
