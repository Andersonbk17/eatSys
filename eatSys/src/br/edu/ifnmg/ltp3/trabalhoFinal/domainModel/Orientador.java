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
public class Orientador extends Pessoa{
    private int matriculaSiape;
    private String localPermanencia;
    private String formacaoUniversitaria;
    private String tituloAcademico;
    private String telefoneRamal;
    
    CursoArea cursoArea;

    public Orientador(int matriculaSiape, String localPermanencia, String formacaoUniversitaria, 
            String tituloAcademico, String telefoneRamal, CursoArea cursoArea) {
        this.matriculaSiape = matriculaSiape;
        this.localPermanencia = localPermanencia;
        this.formacaoUniversitaria = formacaoUniversitaria;
        this.tituloAcademico = tituloAcademico;
        this.telefoneRamal = telefoneRamal;
        this.cursoArea = cursoArea;
    }
    
     public Orientador() {
        this.matriculaSiape = 0;
        this.localPermanencia = "";
        this.formacaoUniversitaria = "";
        this.tituloAcademico = "";
        this.telefoneRamal = "";
        this.cursoArea = new CursoArea();
    }

    public int getMatriculaSiape() {
        return matriculaSiape;
    }

    public void setMatriculaSiape(int matriculaSiape) {
        this.matriculaSiape = matriculaSiape;
    }

    public String getLocalPermanencia() {
        return localPermanencia;
    }

    public void setLocalPermanencia(String localPermanencia) {
        this.localPermanencia = localPermanencia;
    }

    public String getFormacaoUniversitaria() {
        return formacaoUniversitaria;
    }

    public void setFormacaoUniversitaria(String formacaoUniversitaria) {
        this.formacaoUniversitaria = formacaoUniversitaria;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public String getTelefoneRamal() {
        return telefoneRamal;
    }

    public void setTelefoneRamal(String telefoneRamal) {
        this.telefoneRamal = telefoneRamal;
    }

    public CursoArea getCursoArea() {
        return cursoArea;
    }

    public void setCursoArea(CursoArea cursoArea) {
        this.cursoArea = cursoArea;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.matriculaSiape;
        hash = 59 * hash + Objects.hashCode(this.localPermanencia);
        hash = 59 * hash + Objects.hashCode(this.formacaoUniversitaria);
        hash = 59 * hash + Objects.hashCode(this.tituloAcademico);
        hash = 59 * hash + Objects.hashCode(this.telefoneRamal);
        hash = 59 * hash + Objects.hashCode(this.cursoArea);
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
        final Orientador other = (Orientador) obj;
        if (this.matriculaSiape != other.matriculaSiape) {
            return false;
        }
        if (!Objects.equals(this.formacaoUniversitaria, other.formacaoUniversitaria)) {
            return false;
        }
        if (!Objects.equals(this.tituloAcademico, other.tituloAcademico)) {
            return false;
        }
        if (!Objects.equals(this.cursoArea, other.cursoArea)) {
            return false;
        }
        return true;
    }

   
    
    
    
}
