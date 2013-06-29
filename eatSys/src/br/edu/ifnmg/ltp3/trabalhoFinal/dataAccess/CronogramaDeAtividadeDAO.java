/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CronogramaDeAtividade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author emerson
 */
public class CronogramaDeAtividadeDAO {
    ConexaoBanco conexao;
    
    public CronogramaDeAtividadeDAO() throws SQLException{
        conexao = new ConexaoBanco();
    }
    
    public boolean Salvar(CronogramaDeAtividade obj) throws SQLException{
        try{
            if(obj.getIdCronogramaAtividade() == 0){
                PreparedStatement comando = conexao.getConexao().prepareStatement(""
                        + "INSERT INTO CronogramaDeAtividade(descricao,numeroAtividade,status,idPlanoDeTrabalho,dataInicio,dataFim) "
                        + "VALUES(?,?,?,?,?,?) ");
                comando.setString(1, obj.getDescricao());
                comando.setInt(2, obj.getNumeroAtividade());
                comando.setInt(3, 1);
                comando.setInt(4, obj.getAtividadePlanoTrabalho().getIdPlanoDeTrabalho());

                java.sql.Date dataInicio = new java.sql.Date(obj.getDataInicio().getTime());
                comando.setDate(5,dataInicio);

                java.sql.Date dataFim = new java.sql.Date(obj.getDataFim().getTime());
                comando.setDate(6,dataFim);

                comando.execute();
                
            }else{
                PreparedStatement comando = conexao.getConexao().prepareStatement(""
                        + "UPDATE CronogramaDeAtividade SET descricao = ?,numeroAtividade = ?,idPlanoDeTrabalho = ?,dataInicio = ?,dataFim = ? "
                        + "WHERE idCronogramaDeAtividades = ? AND status = 1");
                comando.setString(1, obj.getDescricao());
                comando.setInt(2, obj.getNumeroAtividade());
                comando.setInt(3, obj.getAtividadePlanoTrabalho().getIdPlanoDeTrabalho());

                java.sql.Date dataInicio = new java.sql.Date(obj.getDataInicio().getTime());
                comando.setDate(4,dataInicio);

                java.sql.Date dataFim = new java.sql.Date(obj.getDataFim().getTime());
                comando.setDate(5,dataFim);

                comando.setInt(6, obj.getIdCronogramaAtividade());

                comando.executeUpdate(); 
        
            }
            return true;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;    
        }finally{
            conexao.getConexao().close();
        }
    }
    
    public CronogramaDeAtividade Abrir(int idCronogramaDeAtividade) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM CronogramaDeAtividade WHERE idCronogramaDeAtividades = ?  AND status = 1");
            comando.setInt(1, idCronogramaDeAtividade);

            ResultSet resultado = comando.executeQuery();

            CronogramaDeAtividade atividadeNovo = null;

            if(resultado.first()){
                atividadeNovo = new CronogramaDeAtividade();
                PlanoTrabalhoDAO planoTrabalho = new PlanoTrabalhoDAO(); 

                atividadeNovo.setIdCronogramaAtividade(idCronogramaDeAtividade);
                atividadeNovo.setDescricao(resultado.getString("descricao"));
                atividadeNovo.setNumeroAtividade(resultado.getInt("numeroAtividade"));
                atividadeNovo.setAtividadePlanoTrabalho(planoTrabalho.Abrir(resultado.getInt("idPlanoDeTrabalho")));
                atividadeNovo.setDataInicio(resultado.getDate("dataInicio"));
                atividadeNovo.setDataFim(resultado.getDate("dataFim"));

            }
            return atividadeNovo;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;      
        }finally{
            conexao.getConexao().close();
        }
    }   
    
    public List<CronogramaDeAtividade> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM CronogramaDeAtividade WHERE status = 1");

            ResultSet resultado = comando.executeQuery();

            List<CronogramaDeAtividade> lista = new LinkedList<>();

            if(resultado.first()){
                CronogramaDeAtividade atividadeNovo;
                atividadeNovo = new CronogramaDeAtividade();
                PlanoTrabalhoDAO planoTrabalho = new PlanoTrabalhoDAO(); 

                atividadeNovo.setIdCronogramaAtividade(resultado.getInt("idCronogramaDeAtividades"));
                atividadeNovo.setDescricao(resultado.getString("descricao"));
                atividadeNovo.setNumeroAtividade(resultado.getInt("numeroAtividade"));
                atividadeNovo.setAtividadePlanoTrabalho(planoTrabalho.Abrir(resultado.getInt("idPlanoDeTrabalho")));
                atividadeNovo.setDataInicio(resultado.getDate("dataInicio"));
                atividadeNovo.setDataFim(resultado.getDate("dataFim"));
                
                lista.add(atividadeNovo);

            }
            return lista;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;      
        }finally{
            conexao.getConexao().close();
        }
    }   
     
    public boolean Apagar(int idCronogramaDeAtividade) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE CronogramaDeAtividade "
                    + "SET status = 0 "
                    + "WHERE idCronogramaDeAtividades = ? ");
            comando.setInt(1, idCronogramaDeAtividade);
            
            comando.executeUpdate();
            
            return true;
            
        }catch(SQLException ex){
           ex.printStackTrace();
           return false;
        }finally{
            conexao.getConexao().close();
        }
    }
    
}
