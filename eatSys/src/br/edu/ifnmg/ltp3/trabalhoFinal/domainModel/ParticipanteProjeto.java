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
public class ParticipanteProjeto {
    private int idParticipante;
    private String nome;
    private String titulacao;
    private String observacao;
    
    private Campus campus;

    public ParticipanteProjeto(int idParticipante, String nome, String titulacao, 
            String observacao, Campus campus) {
        this.idParticipante = idParticipante;
        this.nome = nome;
        this.titulacao = titulacao;
        this.observacao = observacao;
        this.campus = campus;
    }
    
    public ParticipanteProjeto() {
        this.idParticipante = 0;
        this.nome = "";
        this.titulacao = "";
        this.observacao = "";
        this.campus = new Campus();
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idParticipante;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.titulacao);
        hash = 17 * hash + Objects.hashCode(this.observacao);
        hash = 17 * hash + Objects.hashCode(this.campus);
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
        final ParticipanteProjeto other = (ParticipanteProjeto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        if (!Objects.equals(this.campus, other.campus)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome ;
    }
    
    
    
    
}
