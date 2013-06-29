/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author emerson
 */
public class EstadoDAO {
    private ConexaoBanco conexao;
    
    public EstadoDAO() throws SQLException{
        conexao = new ConexaoBanco();
    }
    
    public Estado Abrir(int idEstado) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM Estado WHERE idEstado = ?");
            comando.setInt(1, idEstado);
            ResultSet consulta = comando.executeQuery();

            Estado estadoNovo = null;

            if(consulta.first()){
                estadoNovo = new Estado();
                estadoNovo.setIdEstado(idEstado);
                estadoNovo.setNomeEstado(consulta.getString("nome"));
                estadoNovo.setUf(consulta.getString("uf"));
            } 
            return estadoNovo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }   
    }
    
    public List<Estado> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Estado");
            ResultSet consulta = comando.executeQuery();
            
            List<Estado> lista = new LinkedList<>();
            
            while(consulta.next()){
                Estado estadoNovo = new Estado();
                estadoNovo.setIdEstado(consulta.getInt("idEstado"));
                estadoNovo.setNomeEstado(consulta.getString("nome"));
                estadoNovo.setUf(consulta.getString("uf"));
                
                lista.add(estadoNovo);
            }
            return lista;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
   
    }
    
}
