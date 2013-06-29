/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CursoArea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emerson
 */
public class CursoDAO {
    private ConexaoBanco conexao;
    
    public CursoDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(CursoAreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean Salvar(CursoArea obj) throws SQLException{
        try{
            if(obj.getIdCursoArea() == 0){
                PreparedStatement comando = conexao.getConexao().prepareStatement("INSERT INTO Curso(nome,sigla,status) VALUES(?,?,1)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getSigla());
                comando.executeUpdate();
            }else{
                PreparedStatement comando1 = conexao.getConexao().prepareStatement("UPDATE Curso SET nome = ?,sigla = ? WHERE idCurso =?");
                comando1.setString(1, obj.getNome());
                comando1.setString(2, obj.getSigla());
                comando1.setInt(3, obj.getIdCursoArea());
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
    
    
    public CursoArea Abrir(int idCursoArea) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Curso WHERE idCurso = ? AND status = 1");
            comando.setInt(1, idCursoArea);
            ResultSet consulta = comando.executeQuery();
            CursoArea novo = null;
            if(consulta.first()){
                novo = new CursoArea();
                novo.setIdCursoArea(idCursoArea);
                novo.setNome(consulta.getString("nome"));
                novo.setSigla(consulta.getString("sigla"));
                
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public List<CursoArea> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Curso WHERE status = 1");
            ResultSet consuta = comando.executeQuery();
            List<CursoArea> lista = new LinkedList<>();
            while(consuta.next()){
                CursoArea novo = new CursoArea();
                novo.setIdCursoArea(consuta.getInt("idCurso"));
                novo.setNome(consuta.getString("nome"));
                novo.setSigla(consuta.getString("sigla"));
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
    
    public boolean Apagar(int idCursoArea) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("UPDATE CursoArea SET status = 0 "
                    + "WHERE idCurso = ?");
            comando.setInt(1, idCursoArea);
            
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
