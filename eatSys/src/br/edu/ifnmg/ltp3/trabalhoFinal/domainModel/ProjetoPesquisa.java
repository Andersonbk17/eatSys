/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lewandowsky
 */
public class ProjetoPesquisa {
     private int idProjetoPesquisa;
     private String titulo;
     private Date dataInicio;
     private Date dataTermino;
     private String grupoPesquisa;
     private String resumo;
     private int financiamentoAprovado;
     private float valorFinanciamento;
     private Date dataFinanciamento;
     private int bolsasIniciacao;
     private int numeroBolsas;
     private String agenciaFinanciadora;
     private int convenio;
     private String nomeConvenio;
     private int status;
     private int funcadao;
     private String fundacaoNome;
     private boolean projetoMulticampi;
     
     
     private Campus campus;
     private Orientador orientador;
     private AreaConhecimento_CnpqSubAreas areaConhecimento;
     private Aluno aluno;
     private List<ParticipanteProjeto> listaParticipantes;

    public ProjetoPesquisa(int idProjetoPesquisa, String titulo, Date dataInicio, 
            Date dataTermino, String grupoPesquisa, String resumo, int financiamentoAprovado, 
            float valorFinanciamento, Date dataFinanciamento, int bolsasIniciacao, 
            int numeroBolsas, String agenciaFinanciadora, int convenio, String nomeConvenio, 
            int status, int funcadao, String fundacaoNome, boolean projetoMulticampi, 
            Campus campus, Orientador orientador, AreaConhecimento_CnpqSubAreas areaConhecimento, Aluno aluno,List<ParticipanteProjeto> listaParticipantes) {
        this.idProjetoPesquisa = idProjetoPesquisa;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.grupoPesquisa = grupoPesquisa;
        this.resumo = resumo;
        this.financiamentoAprovado = financiamentoAprovado;
        this.valorFinanciamento = valorFinanciamento;
        this.dataFinanciamento = dataFinanciamento;
        this.bolsasIniciacao = bolsasIniciacao;
        this.numeroBolsas = numeroBolsas;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.convenio = convenio;
        this.nomeConvenio = nomeConvenio;
        this.status = status;
        this.funcadao = funcadao;
        this.fundacaoNome = fundacaoNome;
        this.projetoMulticampi = projetoMulticampi;
        this.campus = campus;
        this.orientador = orientador;
        this.areaConhecimento = areaConhecimento;
        this.aluno = aluno;
        this.listaParticipantes = listaParticipantes;
    }
     
    public ProjetoPesquisa() {
        this.idProjetoPesquisa = 0;
        this.titulo = "";
        this.dataInicio = new Date();
        this.dataTermino = new Date();
        this.grupoPesquisa = "";
        this.resumo = "";
        this.financiamentoAprovado = 0;
        this.valorFinanciamento = 0;
        this.dataFinanciamento = new Date();
        this.bolsasIniciacao = 0;
        this.numeroBolsas = 0;
        this.agenciaFinanciadora = "";
        this.convenio = 0;
        this.nomeConvenio = "";
        this.status = 0;
        this.funcadao = 0;
        this.fundacaoNome = "";
        this.projetoMulticampi = false;
        this.campus = new Campus();
        this.orientador = new Orientador();
        this.areaConhecimento = new AreaConhecimento_CnpqSubAreas();
        this.aluno = new Aluno();
        this.listaParticipantes = new LinkedList<>();
    }

    public int getIdProjetoPesquisa() {
        return idProjetoPesquisa;
    }

    public void setIdProjetoPesquisa(int idProjetoPesquisa) {
        this.idProjetoPesquisa = idProjetoPesquisa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getGrupoPesquisa() {
        return grupoPesquisa;
    }

    public void setGrupoPesquisa(String grupoPesquisa) {
        this.grupoPesquisa = grupoPesquisa;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getFinanciamentoAprovado() {
        return financiamentoAprovado;
    }

    public void setFinanciamentoAprovado(int financiamentoAprovado) {
        this.financiamentoAprovado = financiamentoAprovado;
    }

    public float getValorFinanciamento() {
        return valorFinanciamento;
    }

    public void setValorFinanciamento(float valorFinanciamento) {
        this.valorFinanciamento = valorFinanciamento;
    }

    public Date getDataFinanciamento() {
        return dataFinanciamento;
    }

    public void setDataFinanciamento(Date dataFinanciamento) {
        this.dataFinanciamento = dataFinanciamento;
    }

    public int getBolsasIniciacao() {
        return bolsasIniciacao;
    }

    public void setBolsasIniciacao(int bolsasIniciacao) {
        this.bolsasIniciacao = bolsasIniciacao;
    }

    public int getNumeroBolsas() {
        return numeroBolsas;
    }

    public void setNumeroBolsas(int numeroBolsas) {
        this.numeroBolsas = numeroBolsas;
    }

    public String getAgenciaFinanciadora() {
        return agenciaFinanciadora;
    }

    public void setAgenciaFinanciadora(String agenciaFinanciadora) {
        this.agenciaFinanciadora = agenciaFinanciadora;
    }

    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        this.convenio = convenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFuncadao() {
        return funcadao;
    }

    public void setFuncadao(int funcadao) {
        this.funcadao = funcadao;
    }

    public String getFundacaoNome() {
        return fundacaoNome;
    }

    public void setFundacaoNome(String fundacaoNome) {
        this.fundacaoNome = fundacaoNome;
    }

    public boolean isProjetoMulticampi() {
        return projetoMulticampi;
    }

    public void setProjetoMulticampi(boolean projetoMulticampi) {
        this.projetoMulticampi = projetoMulticampi;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public AreaConhecimento_CnpqSubAreas getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento_CnpqSubAreas areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<ParticipanteProjeto> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<ParticipanteProjeto> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }
    
    public void addParticipante(ParticipanteProjeto p){
        if(!this.listaParticipantes.contains(p)){
            this.listaParticipantes.add(p);
        }
    }
    
    public void removeParticipante(ParticipanteProjeto p){
        if(this.listaParticipantes.contains(p)){
            this.listaParticipantes.remove(p);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idProjetoPesquisa;
        hash = 17 * hash + Objects.hashCode(this.titulo);
        hash = 17 * hash + Objects.hashCode(this.dataInicio);
        hash = 17 * hash + Objects.hashCode(this.dataTermino);
        hash = 17 * hash + Objects.hashCode(this.grupoPesquisa);
        hash = 17 * hash + Objects.hashCode(this.resumo);
        hash = 17 * hash + this.financiamentoAprovado;
        hash = 17 * hash + Float.floatToIntBits(this.valorFinanciamento);
        hash = 17 * hash + Objects.hashCode(this.dataFinanciamento);
        hash = 17 * hash + this.bolsasIniciacao;
        hash = 17 * hash + this.numeroBolsas;
        hash = 17 * hash + Objects.hashCode(this.agenciaFinanciadora);
        hash = 17 * hash + this.convenio;
        hash = 17 * hash + Objects.hashCode(this.nomeConvenio);
        hash = 17 * hash + this.status;
        hash = 17 * hash + this.funcadao;
        hash = 17 * hash + Objects.hashCode(this.fundacaoNome);
        hash = 17 * hash + (this.projetoMulticampi ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.campus);
        hash = 17 * hash + Objects.hashCode(this.orientador);
        hash = 17 * hash + Objects.hashCode(this.areaConhecimento);
        hash = 17 * hash + Objects.hashCode(this.aluno);
        hash = 17 * hash + Objects.hashCode(this.listaParticipantes);
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
        final ProjetoPesquisa other = (ProjetoPesquisa) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
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
        return true;
    }

    @Override
    public String toString() {
        return titulo ;
    }
    
   
     
}
