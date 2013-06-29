/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import java.sql.CallableStatement;
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
public class CampusDAO {
    private ConexaoBanco conexao;
    
    public CampusDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean Salvar(Campus obj ) throws SQLException{
        try{
            if(obj.getIdCampus()== 0){
                CallableStatement comando = conexao.getConexao().prepareCall("INSERT INTO Campus(nome,status) VALUES(?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, 1);
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall("UPDATE Campus SET nome = ? WHERE idCampus = ?");
                comando1.setString(1, obj.getNome());
                comando1.setInt(2, obj.getIdCampus());
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
    
    
    public Campus Abrir(int idCampus) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Campus WHERE idCampus = ? AND STATUS = 1");
            comando.setInt(1, idCampus);
            ResultSet consulta = comando.executeQuery();
            
            if(consulta.first()){
                Campus novo = new Campus();
                
                novo.setIdCampus(idCampus);
                novo.setNome(consulta.getString("nome"));
                
                return novo;
           
            }else return null;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
        
            conexao.getConexao().close();
        
        }
   
    }
    
    
    public List<Campus> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Campus WHERE STATUS = 1");
            ResultSet consulta = comando.executeQuery();
            List<Campus> lista = new LinkedList<>();
            while(consulta.next()){
                Campus novo = new Campus();
                novo.setNome(consulta.getString("nome"));
                novo.setIdCampus(consulta.getInt("idCampus"));
                
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
    
    public boolean Apagar(int idCampus ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE Campus SET status = 0 WHERE idCampus = ?");
            comando.setInt(1, idCampus);
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