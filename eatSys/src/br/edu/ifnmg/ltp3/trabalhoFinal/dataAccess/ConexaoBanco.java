/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emerson
 */
public class ConexaoBanco {
    private Connection conexao;
    
    public ConexaoBanco() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager
            //.getConnection("jdbc:mysql://localhost:3306/trabalhoFinal","root","");
            //.getConnection("jdbc:mysql://localhost:3306/trabalhoFinal","root","epo123");
            .getConnection("jdbc:mysql://localhost:3306/trabalhoFinal","root","170737");
            //conexao.setAutoCommit(false);
        
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
      }

    public Connection getConexao() {
        try {
            if(conexao.isClosed()){
                conectar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void conectar(){
        try {
            conexao = DriverManager
                 // .getConnection("jdbc:mysql://localhost:3306/trabalhoFinal","root","epo123");
                  .getConnection("jdbc:mysql://localhost:3306/trabalhoFinal","root","170737");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fechar(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
