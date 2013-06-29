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
public class CronogramaDeAtividade {
    private int idCronogramaAtividade;
    private String descricao;
    private int numeroAtividade;
    private Date dataInicio;
    private Date dataFim;
    private boolean status;
    
    private PlanoDeTrabalho atividadePlanoTrabalho;

    public CronogramaDeAtividade(int idCronogramaAtividade, String descricao, int numeroAtividade, Date dataInicio, Date dataFim, boolean status, PlanoDeTrabalho atividadePlanoTrabalho) {
        this.idCronogramaAtividade = idCronogramaAtividade;
        this.descricao = descricao;
        this.numeroAtividade = numeroAtividade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.atividadePlanoTrabalho = atividadePlanoTrabalho;
    }

    public int getIdCronogramaAtividade() {
        return idCronogramaAtividade;
    }

    public void setIdCronogramaAtividade(int idCronogramaAtividade) {
        this.idCronogramaAtividade = idCronogramaAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroAtividade() {
        return numeroAtividade;
    }

    public void setNumeroAtividade(int numeroAtividade) {
        this.numeroAtividade = numeroAtividade;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PlanoDeTrabalho getAtividadePlanoTrabalho() {
        return atividadePlanoTrabalho;
    }

    public void setAtividadePlanoTrabalho(PlanoDeTrabalho atividadePlanoTrabalho) {
        this.atividadePlanoTrabalho = atividadePlanoTrabalho;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idCronogramaAtividade;
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + this.numeroAtividade;
        hash = 37 * hash + Objects.hashCode(this.dataInicio);
        hash = 37 * hash + Objects.hashCode(this.dataFim);
        hash = 37 * hash + (this.status ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.atividadePlanoTrabalho);
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
        final CronogramaDeAtividade other = (CronogramaDeAtividade) obj;
        if (this.idCronogramaAtividade != other.idCronogramaAtividade) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.numeroAtividade != other.numeroAtividade) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataFim, other.dataFim)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.atividadePlanoTrabalho, other.atividadePlanoTrabalho)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CronogramaDeAtividade{" + "idCronogramaAtividade=" + idCronogramaAtividade + ", "
                + "descricao=" + descricao + ", numeroAtividade=" + numeroAtividade + ", "
                + "dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", status=" + status + ", "
                + "atividadePlanoTrabalho=" + atividadePlanoTrabalho + '}';
    }
    
    
}
