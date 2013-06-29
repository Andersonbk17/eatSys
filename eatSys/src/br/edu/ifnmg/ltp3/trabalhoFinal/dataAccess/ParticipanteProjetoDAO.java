/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ParticipanteProjeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewandowsky
 */
public class ParticipanteProjetoDAO {
    private ConexaoBanco conexao;
    
    public ParticipanteProjetoDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean Salvar(ParticipanteProjeto obj,int idProjetoPesquisa ) throws SQLException{
        try{
            if(obj.getIdParticipante()== 0){
                PreparedStatement comando = conexao.getConexao().prepareCall("INSERT INTO ParticipanteProjeto(nome,titulacao,"
                        + "observacao,idCampus,idProjetoPesquisa,status) VALUES(?,?,?,?,?,1)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getTitulacao());
                comando.setString(3, obj.getObservacao());
                comando.setInt(4,obj.getCampus().getIdCampus());
                comando.setInt(5,idProjetoPesquisa);
                comando.execute();
            }else{
                PreparedStatement comando1 = conexao.getConexao().prepareCall("UPDATE ParticipanteProjeto SET nome = ?,titulacao = ?,"
                        + "observacao = ?,idCampus = ?,idProjetoPesquisa = ? WHERE idParticipanteProjeto = ?");
                comando1.setString(1, obj.getNome());
                comando1.setString(2, obj.getTitulacao());
                comando1.setString(3, obj.getObservacao());
                comando1.setInt(4,obj.getCampus().getIdCampus());
                comando1.setInt(5,idProjetoPesquisa);
                comando1.setInt(5,obj.getIdParticipante());
                comando1.executeUpdate();
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    }
    
    
    public ParticipanteProjeto Abrir(int idParticipante) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM ParticipanteProjeto WHERE "
                    + "idParticipanteProjeto = ? AND status = 1");
            comando.setInt(1, idParticipante);
            ResultSet consulta = comando.executeQuery();
             ParticipanteProjeto novo = null;
            if(consulta.first()){
                novo = new ParticipanteProjeto();
                CampusDAO campusdao = new CampusDAO();
                novo.setIdParticipante(idParticipante);
                novo.setCampus(campusdao.Abrir(consulta.getInt("idCampus")));
                novo.setNome(consulta.getString("nome"));
                novo.setObservacao(consulta.getString("observacao"));
                novo.setTitulacao(consulta.getString("titulacao"));
                
                return novo;
           
            }
            return novo;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
        
            conexao.getConexao().close();
        
        }
   
    }
    
    
    public List<ParticipanteProjeto> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM ParticipanteProjeto WHERE status = 1");
            ResultSet consulta = comando.executeQuery();
            List<ParticipanteProjeto> lista = new LinkedList<>();
            while(consulta.next()){
                ParticipanteProjeto novo = new ParticipanteProjeto();
                CampusDAO campusdao = new CampusDAO();
                novo.setIdParticipante(consulta.getInt("idParticipanteProjeto"));
                novo.setCampus(campusdao.Abrir(consulta.getInt("idCampus")));
                novo.setNome(consulta.getString("nome"));
                novo.setObservacao(consulta.getString("observacao"));
                novo.setTitulacao(consulta.getString("titulacao"));
                lista.add(novo);
            }
            return lista;
         }catch(SQLException ex){
               ex.printStackTrace();
               return null;
        }finally{
            conexao.getConexao().close();
        }
     }
    
    public boolean Apagar(int idParticipante ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE ParticipanteProjeto SET status = 0 WHERE idParticipanteProjeto = ?");
            comando.setInt(1, idParticipante);
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