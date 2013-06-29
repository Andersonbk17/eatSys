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
public class Pessoa {
    private int idPessoa;
    private String nome;
    private int cpf;
    private String rg;
    private String rgOrgaoExpedidor;
    private Date rgDataExpedicao;
    private Date dataNascimento;
    private boolean status;
    
    private String enderecoRua;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoComplmento;
    private int enderecoCep;
    
    private String telefoneFixo;
    private String telefoneCelular;
    
    private String emailEndereco;
    
    private Campus pessoaCampus;
    private Nacionalidade pessoaNacionalidade;
    private Cidade pessoaCidade; 
    private Estado pessoaEstado;

    public Pessoa(int idPessoa, String nome, int cpf, String rg, String rgOrgaoExpedidor, Date rgDataExpedicao, Date dataNascimento, boolean status, String enderecoRua, String enderecoNumero, String enderecoBairro, String enderecoComplmento, int enderecoCep, String telefoneFixo, String telefoneCelular, String emailEndereco, Campus pessoaCampus, Nacionalidade pessoaNacionalidade, Cidade pessoaCidade, Estado pessoaEstado) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.rgOrgaoExpedidor = rgOrgaoExpedidor;
        this.rgDataExpedicao = rgDataExpedicao;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.enderecoRua = enderecoRua;
        this.enderecoNumero = enderecoNumero;
        this.enderecoBairro = enderecoBairro;
        this.enderecoComplmento = enderecoComplmento;
        this.enderecoCep = enderecoCep;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.emailEndereco = emailEndereco;
        this.pessoaCampus = pessoaCampus;
        this.pessoaNacionalidade = pessoaNacionalidade;
        this.pessoaCidade = pessoaCidade;
        this.pessoaEstado = pessoaEstado;
    }
    
    public Pessoa() {
        this.idPessoa = 0;
        this.nome = "";
        this.cpf = 0;
        this.rg = "";
        this.rgOrgaoExpedidor = "";
        this.rgDataExpedicao = new Date();
        this.dataNascimento = new Date();
        this.status = true;
        this.enderecoRua = "";
        this.enderecoNumero = "";
        this.enderecoBairro = "";
        this.enderecoComplmento = "";
        this.enderecoCep = 0;
        this.telefoneFixo = "";
        this.telefoneCelular = "";
        this.emailEndereco = "";
        this.pessoaCampus = new Campus();
        this.pessoaNacionalidade = new Nacionalidade();
        this.pessoaCidade = new Cidade();
        this.pessoaEstado = new Estado();
    }

    
    
    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRgOrgaoExpedidor() {
        return rgOrgaoExpedidor;
    }

    public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
        this.rgOrgaoExpedidor = rgOrgaoExpedidor;
    }

    public Date getRgDataExpedicao() {
        return rgDataExpedicao;
    }

    public void setRgDataExpedicao(Date rgDataExpedicao) {
        this.rgDataExpedicao = rgDataExpedicao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoComplmento() {
        return enderecoComplmento;
    }

    public void setEnderecoComplmento(String enderecoComplmento) {
        this.enderecoComplmento = enderecoComplmento;
    }

    public int getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(int enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmailEndereco() {
        return emailEndereco;
    }

    public void setEmailEndereco(String emailEndereco) {
        this.emailEndereco = emailEndereco;
    }

    public Campus getPessoaCampus() {
        return pessoaCampus;
    }

    public void setPessoaCampus(Campus pessoaCampus) {
        this.pessoaCampus = pessoaCampus;
    }

    public Nacionalidade getPessoaNacionalidade() {
        return pessoaNacionalidade;
    }

    public void setPessoaNacionalidade(Nacionalidade pessoaNacionalidade) {
        this.pessoaNacionalidade = pessoaNacionalidade;
    }

    public Cidade getPessoaCidade() {
        return pessoaCidade;
    }

    public void setPessoaCidade(Cidade pessoaCidade) {
        this.pessoaCidade = pessoaCidade;
    }

    public Estado getPessoaEstado() {
        return pessoaEstado;
    }

    public void setPessoaEstado(Estado pessoaEstado) {
        this.pessoaEstado = pessoaEstado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPessoa;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.cpf;
        hash = 97 * hash + Objects.hashCode(this.rg);
        hash = 97 * hash + Objects.hashCode(this.rgOrgaoExpedidor);
        hash = 97 * hash + Objects.hashCode(this.rgDataExpedicao);
        hash = 97 * hash + Objects.hashCode(this.dataNascimento);
        hash = 97 * hash + (this.status ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.enderecoRua);
        hash = 97 * hash + Objects.hashCode(this.enderecoNumero);
        hash = 97 * hash + Objects.hashCode(this.enderecoBairro);
        hash = 97 * hash + Objects.hashCode(this.enderecoComplmento);
        hash = 97 * hash + this.enderecoCep;
        hash = 97 * hash + Objects.hashCode(this.telefoneFixo);
        hash = 97 * hash + Objects.hashCode(this.telefoneCelular);
        hash = 97 * hash + Objects.hashCode(this.emailEndereco);
        hash = 97 * hash + Objects.hashCode(this.pessoaCampus);
        hash = 97 * hash + Objects.hashCode(this.pessoaNacionalidade);
        hash = 97 * hash + Objects.hashCode(this.pessoaCidade);
        hash = 97 * hash + Objects.hashCode(this.pessoaEstado);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.rgOrgaoExpedidor, other.rgOrgaoExpedidor)) {
            return false;
        }
        if (!Objects.equals(this.rgDataExpedicao, other.rgDataExpedicao)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.enderecoRua, other.enderecoRua)) {
            return false;
        }
        if (!Objects.equals(this.enderecoNumero, other.enderecoNumero)) {
            return false;
        }
        if (!Objects.equals(this.enderecoBairro, other.enderecoBairro)) {
            return false;
        }
        if (!Objects.equals(this.enderecoComplmento, other.enderecoComplmento)) {
            return false;
        }
        if (this.enderecoCep != other.enderecoCep) {
            return false;
        }
        if (!Objects.equals(this.telefoneFixo, other.telefoneFixo)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCelular, other.telefoneCelular)) {
            return false;
        }
        if (!Objects.equals(this.emailEndereco, other.emailEndereco)) {
            return false;
        }
        if (!Objects.equals(this.pessoaCampus, other.pessoaCampus)) {
            return false;
        }
        if (!Objects.equals(this.pessoaNacionalidade, other.pessoaNacionalidade)) {
            return false;
        }
        if (!Objects.equals(this.pessoaCidade, other.pessoaCidade)) {
            return false;
        }
        if (!Objects.equals(this.pessoaEstado, other.pessoaEstado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", "
                + "rgOrgaoExpedidor=" + rgOrgaoExpedidor + ", rgDataExpedicao=" + rgDataExpedicao + ", "
                + "dataNascimento=" + dataNascimento + ", status=" + status + ", "
                + "enderecoRua=" + enderecoRua + ", enderecoNumero=" + enderecoNumero + ", "
                + "enderecoBairro=" + enderecoBairro + ", enderecoComplmento=" + enderecoComplmento + ", "
                + "enderecoCep=" + enderecoCep + ", telefoneFixo=" + telefoneFixo + ", "
                + "telefoneCelular=" + telefoneCelular + ", emailEndereco=" + emailEndereco + ", "
                + "pessoaCampus=" + pessoaCampus + ", pessoaNacionalidade=" + pessoaNacionalidade + ", "
                + "pessoaCidade=" + pessoaCidade + ", pessoaEstado=" + pessoaEstado + '}';
    }
    
    
    
    
}
