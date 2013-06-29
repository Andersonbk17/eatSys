/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author emerson
 */
public class PlanoDeTrabalho {
    private int idPlanoDeTrabalho;
    private String introducao;
    private String justificativa;
    private String objetivos;
    private String metodologia;
    private String resultadoEsperado;
    private String referenciaBibliografica;
    private Date dataInicio;
    private Date dataTermino;
    private boolean status;
    
    private Aluno alunoPlanoTrabalho; 

    public PlanoDeTrabalho(int idPlanoDeTrabalho, String introducao, String justificativa, String objetivos, String metodologia, String resultadoEsperado, String referenciaBibliografica, Date dataInicio, Date dataTermino, boolean status, Aluno alunoPlanoTrabalho) {
        this.idPlanoDeTrabalho = idPlanoDeTrabalho;
        this.introducao = introducao;
        this.justificativa = justificativa;
        this.objetivos = objetivos;
        this.metodologia = metodologia;
        this.resultadoEsperado = resultadoEsperado;
        this.referenciaBibliografica = referenciaBibliografica;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.status = status;
        this.alunoPlanoTrabalho = alunoPlanoTrabalho;
    }
    
    public PlanoDeTrabalho() {
        this.idPlanoDeTrabalho = 0;
        this.introducao = "";
        this.justificativa = "";
        this.objetivos = "";
        this.metodologia = "";
        this.resultadoEsperado = "";
        this.referenciaBibliografica = "";
        this.dataInicio = new Date();
        this.dataTermino = new Date();;
        this.status = true;
        this.alunoPlanoTrabalho = new Aluno();
    }

    public int getIdPlanoDeTrabalho() {
        return idPlanoDeTrabalho;
    }

    public void setIdPlanoDeTrabalho(int idPlanoDeTrabalho) {
        this.idPlanoDeTrabalho = idPlanoDeTrabalho;
    }

    public String getIntroducao() {
        return introducao;
    }

    public void setIntroducao(String introducao) {
        this.introducao = introducao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(String resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public String getReferenciaBibliografica() {
        return referenciaBibliografica;
    }

    public void setReferenciaBibliografica(String referenciaBibliografica) {
        this.referenciaBibliografica = referenciaBibliografica;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Aluno getAlunoPlanoTrabalho() {
        return alunoPlanoTrabalho;
    }

    public void setAlunoPlanoTrabalho(Aluno alunoPlanoTrabalho) {
        this.alunoPlanoTrabalho = alunoPlanoTrabalho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idPlanoDeTrabalho;
        hash = 37 * hash + Objects.hashCode(this.introducao);
        hash = 37 * hash + Objects.hashCode(this.justificativa);
        hash = 37 * hash + Objects.hashCode(this.objetivos);
        hash = 37 * hash + Objects.hashCode(this.metodologia);
        hash = 37 * hash + Objects.hashCode(this.resultadoEsperado);
        hash = 37 * hash + Objects.hashCode(this.referenciaBibliografica);
        hash = 37 * hash + Objects.hashCode(this.dataInicio);
        hash = 37 * hash + Objects.hashCode(this.dataTermino);
        hash = 37 * hash + (this.status ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.alunoPlanoTrabalho);
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
        final PlanoDeTrabalho other = (PlanoDeTrabalho) obj;
        if (this.idPlanoDeTrabalho != other.idPlanoDeTrabalho) {
            return false;
        }
        if (!Objects.equals(this.introducao, other.introducao)) {
            return false;
        }
        if (!Objects.equals(this.justificativa, other.justificativa)) {
            return false;
        }
        if (!Objects.equals(this.objetivos, other.objetivos)) {
            return false;
        }
        if (!Objects.equals(this.metodologia, other.metodologia)) {
            return false;
        }
        if (!Objects.equals(this.resultadoEsperado, other.resultadoEsperado)) {
            return false;
        }
        if (!Objects.equals(this.referenciaBibliografica, other.referenciaBibliografica)) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataTermino, other.dataTermino)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.alunoPlanoTrabalho, other.alunoPlanoTrabalho)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlanoDeTrabalho{" + "idPlanoDeTrabalho=" + idPlanoDeTrabalho + ", "
                + "introducao=" + introducao + ", justificativa=" + justificativa + ", "
                + "objetivos=" + objetivos + ", metodologia=" + metodologia + ", "
                + "resultadoEsperado=" + resultadoEsperado + ", "
                + "referenciaBibliografica=" + referenciaBibliografica + ", dataInicio=" + dataInicio + ", "
                + "dataTermino=" + dataTermino + ", status=" + status + ", "
                + "alunoPlanoTrabalho=" + alunoPlanoTrabalho + '}';
    }
    
    
    
    
    
    
    
}
