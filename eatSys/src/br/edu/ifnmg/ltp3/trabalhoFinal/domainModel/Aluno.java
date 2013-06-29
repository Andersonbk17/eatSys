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
public class Aluno extends Pessoa{
    private int idAluno;
    private int matricula;
    private String tituloEleitoral;
    private String zonaEleitoral;
    private String secaoEleitoral;
    private String situacaoMilitar;
    private String certidaoMilitar;
    
    private String nomePai;
    private String rgPai;
    private String orgaoExpedidorPai;
    private int cpfPai;
    private String nomeMae;
    private String rgMae;
    private String orgaoExpedidorMae;
    private int cpfMae;
    
    private String localTrabalho;
    private String telefoneLocalTrabalho;
    
    private CursoArea alunoCurso;

    public Aluno(int idAluno, int matricula, String tituloEleitoral, String zonaEleitoral, String secaoEleitoral, String situacaoMilitar, String certidaoMilitar, String nomePai, String rgPai, String orgaoExpedidorPai, int cpfPai, String nomeMae, String rgMae, String orgaoExpedidorMae, int cpfMae, String localTrabalho, String telefoneLocalTrabalho, CursoArea alunoCurso) {
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.tituloEleitoral = tituloEleitoral;
        this.zonaEleitoral = zonaEleitoral;
        this.secaoEleitoral = secaoEleitoral;
        this.situacaoMilitar = situacaoMilitar;
        this.certidaoMilitar = certidaoMilitar;
        this.nomePai = nomePai;
        this.rgPai = rgPai;
        this.orgaoExpedidorPai = orgaoExpedidorPai;
        this.cpfPai = cpfPai;
        this.nomeMae = nomeMae;
        this.rgMae = rgMae;
        this.orgaoExpedidorMae = orgaoExpedidorMae;
        this.cpfMae = cpfMae;
        this.localTrabalho = localTrabalho;
        this.telefoneLocalTrabalho = telefoneLocalTrabalho;
        this.alunoCurso = alunoCurso;
    }
    
       public Aluno() {
        this.idAluno = 0;
        this.matricula = 0;
        this.tituloEleitoral = "";
        this.zonaEleitoral = "";
        this.secaoEleitoral = "";
        this.situacaoMilitar = "";
        this.certidaoMilitar = "";
        this.nomePai = "";
        this.rgPai = "";
        this.orgaoExpedidorPai = "";
        this.cpfPai = 0;
        this.nomeMae = "";
        this.rgMae = "";
        this.orgaoExpedidorMae = "";
        this.cpfMae = 0;
        this.localTrabalho = "";
        this.telefoneLocalTrabalho = "";
        this.alunoCurso = new CursoArea();
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(String tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public String getZonaEleitoral() {
        return zonaEleitoral;
    }

    public void setZonaEleitoral(String zonaEleitoral) {
        this.zonaEleitoral = zonaEleitoral;
    }

    public String getSecaoEleitoral() {
        return secaoEleitoral;
    }

    public void setSecaoEleitoral(String secaoEleitoral) {
        this.secaoEleitoral = secaoEleitoral;
    }

    public String getSituacaoMilitar() {
        return situacaoMilitar;
    }

    public void setSituacaoMilitar(String situacaoMilitar) {
        this.situacaoMilitar = situacaoMilitar;
    }

    public String getCertidaoMilitar() {
        return certidaoMilitar;
    }

    public void setCertidaoMilitar(String certidaoMilitar) {
        this.certidaoMilitar = certidaoMilitar;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getRgPai() {
        return rgPai;
    }

    public void setRgPai(String rgPai) {
        this.rgPai = rgPai;
    }

    public String getOrgaoExpedidorPai() {
        return orgaoExpedidorPai;
    }

    public void setOrgaoExpedidorPai(String orgaoExpedidorPai) {
        this.orgaoExpedidorPai = orgaoExpedidorPai;
    }

    public int getCpfPai() {
        return cpfPai;
    }

    public void setCpfPai(int cpfPai) {
        this.cpfPai = cpfPai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getRgMae() {
        return rgMae;
    }

    public void setRgMae(String rgMae) {
        this.rgMae = rgMae;
    }

    public String getOrgaoExpedidorMae() {
        return orgaoExpedidorMae;
    }

    public void setOrgaoExpedidorMae(String orgaoExpedidorMae) {
        this.orgaoExpedidorMae = orgaoExpedidorMae;
    }

    public int getCpfMae() {
        return cpfMae;
    }

    public void setCpfMae(int cpfMae) {
        this.cpfMae = cpfMae;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneLocalTrabalho() {
        return telefoneLocalTrabalho;
    }

    public void setTelefoneLocalTrabalho(String telefoneLocalTrabalho) {
        this.telefoneLocalTrabalho = telefoneLocalTrabalho;
    }

    public CursoArea getAlunoCurso() {
        return alunoCurso;
    }

    public void setAlunoCurso(CursoArea alunoCurso) {
        this.alunoCurso = alunoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idAluno;
        hash = 67 * hash + this.matricula;
        hash = 67 * hash + Objects.hashCode(this.tituloEleitoral);
        hash = 67 * hash + Objects.hashCode(this.zonaEleitoral);
        hash = 67 * hash + Objects.hashCode(this.secaoEleitoral);
        hash = 67 * hash + Objects.hashCode(this.situacaoMilitar);
        hash = 67 * hash + Objects.hashCode(this.certidaoMilitar);
        hash = 67 * hash + Objects.hashCode(this.nomePai);
        hash = 67 * hash + Objects.hashCode(this.rgPai);
        hash = 67 * hash + Objects.hashCode(this.orgaoExpedidorPai);
        hash = 67 * hash + this.cpfPai;
        hash = 67 * hash + Objects.hashCode(this.nomeMae);
        hash = 67 * hash + Objects.hashCode(this.rgMae);
        hash = 67 * hash + Objects.hashCode(this.orgaoExpedidorMae);
        hash = 67 * hash + this.cpfMae;
        hash = 67 * hash + Objects.hashCode(this.localTrabalho);
        hash = 67 * hash + Objects.hashCode(this.telefoneLocalTrabalho);
        hash = 67 * hash + Objects.hashCode(this.alunoCurso);
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
        final Aluno other = (Aluno) obj;
        if (this.idAluno != other.idAluno) {
            return false;
        }
        if (this.matricula != other.matricula) {
            return false;
        }
        if (!Objects.equals(this.tituloEleitoral, other.tituloEleitoral)) {
            return false;
        }
        if (!Objects.equals(this.zonaEleitoral, other.zonaEleitoral)) {
            return false;
        }
        if (!Objects.equals(this.secaoEleitoral, other.secaoEleitoral)) {
            return false;
        }
        if (!Objects.equals(this.situacaoMilitar, other.situacaoMilitar)) {
            return false;
        }
        if (!Objects.equals(this.certidaoMilitar, other.certidaoMilitar)) {
            return false;
        }
        if (!Objects.equals(this.nomePai, other.nomePai)) {
            return false;
        }
        if (!Objects.equals(this.rgPai, other.rgPai)) {
            return false;
        }
        if (!Objects.equals(this.orgaoExpedidorPai, other.orgaoExpedidorPai)) {
            return false;
        }
        if (this.cpfPai != other.cpfPai) {
            return false;
        }
        if (!Objects.equals(this.nomeMae, other.nomeMae)) {
            return false;
        }
        if (!Objects.equals(this.rgMae, other.rgMae)) {
            return false;
        }
        if (!Objects.equals(this.orgaoExpedidorMae, other.orgaoExpedidorMae)) {
            return false;
        }
        if (this.cpfMae != other.cpfMae) {
            return false;
        }
        if (!Objects.equals(this.localTrabalho, other.localTrabalho)) {
            return false;
        }
        if (!Objects.equals(this.telefoneLocalTrabalho, other.telefoneLocalTrabalho)) {
            return false;
        }
        if (!Objects.equals(this.alunoCurso, other.alunoCurso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", matricula=" + matricula + ", "
                + "tituloEleitoral=" + tituloEleitoral + ", zonaEleitoral=" + zonaEleitoral + ", "
                + "secaoEleitoral=" + secaoEleitoral + ", situacaoMilitar=" + situacaoMilitar + ", "
                + "certidaoMilitar=" + certidaoMilitar + ", nomePai=" + nomePai + ", rgPai=" + rgPai + ", "
                + "orgaoExpedidorPai=" + orgaoExpedidorPai + ", cpfPai=" + cpfPai + ", "
                + "nomeMae=" + nomeMae + ", rgMae=" + rgMae + ", orgaoExpedidorMae=" + orgaoExpedidorMae + ", "
                + "cpfMae=" + cpfMae + ", localTrabalho=" + localTrabalho + ", "
                + "telefoneLocalTrabalho=" + telefoneLocalTrabalho + ", alunoCurso=" + alunoCurso + '}';
    }
       
    

    
    
    
    
    
    
    
}
