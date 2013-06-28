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
public class Usuario {
    private int idUsuario;
    private String Usuario;
    private String senha;
    private int nivel;

    public Usuario(int idUsuario, String Usuario, String senha, int nivel) {
        this.idUsuario = idUsuario;
        this.Usuario = Usuario;
        this.senha = senha;
        this.nivel = nivel;
    }
    
    public Usuario() {
        this.idUsuario = 0;
        this.Usuario = "";
        this.senha = "";
        this.nivel = 0;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idUsuario;
        hash = 89 * hash + Objects.hashCode(this.Usuario);
        hash = 89 * hash + Objects.hashCode(this.senha);
        hash = 89 * hash + this.nivel;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Usuario, other.Usuario)) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Usuario ;
    }
    
    
    
    
}
