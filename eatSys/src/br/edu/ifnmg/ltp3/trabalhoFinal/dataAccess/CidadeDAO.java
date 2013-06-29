/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author emerson
 */
public class CidadeDAO {
     private ConexaoBanco conexao;
    
    public CidadeDAO() throws SQLException{
        conexao = new ConexaoBanco();
    }
    
    public Cidade Abrir(int idCidade) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELE * FROM Cidade WHERE idCidade = ?");
            comando.setInt(1, idCidade);
            ResultSet consulta = comando.executeQuery();

            Cidade cidadeNovo = null;
            EstadoDAO estado = new EstadoDAO();

            if(consulta.first()){
                cidadeNovo = new Cidade();
                cidadeNovo.setIdCidade(consulta.getInt("idCidade"));
                cidadeNovo.setNomeCidade(consulta.getString("nome"));
                cidadeNovo.setCidadeEstado(estado.Abrir(consulta.getInt("idEstado")));
            } 
            return cidadeNovo;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }   
    }
    
    public List<Cidade> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Cidade");
            ResultSet consulta = comando.executeQuery();
            
            List<Cidade> lista = new LinkedList<>();
            EstadoDAO estado = new EstadoDAO();
            
            while(consulta.next()){
                Cidade cidadeNovo = new Cidade();
                cidadeNovo.setIdCidade(consulta.getInt("idCidade"));
                cidadeNovo.setNomeCidade(consulta.getString("nome"));
                cidadeNovo.setCidadeEstado(estado.Abrir(consulta.getInt("idEstado")));
                
                lista.add(cidadeNovo);
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
