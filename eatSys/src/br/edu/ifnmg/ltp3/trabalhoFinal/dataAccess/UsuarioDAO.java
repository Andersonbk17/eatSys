/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Usuario;
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
public class UsuarioDAO {
    private ConexaoBanco conexao;
    
    public UsuarioDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean Salvar(Usuario obj ) throws SQLException{
        try{
            if(obj.getIdUsuario()== 0){
                PreparedStatement comando = conexao.getConexao().prepareCall("INSERT INTO Usuario(usuario,senha,nivel,status) VALUES(?,?,?,?)");
                comando.setString(1, obj.getUsuario());
                comando.setString(2, obj.getSenha());
                comando.setInt(3, obj.getNivel());
                comando.setInt(4,1);
                comando.execute();
            }else{
                PreparedStatement comando1 = conexao.getConexao().prepareCall("UPDATE Usuario SET usuario = ?,senha = ?,"
                        + "nivel = ? WHERE idUsuario = ?");
                comando1.setString(1, obj.getUsuario());
                comando1.setString(2, obj.getSenha());
                comando1.setInt(3, obj.getNivel());
                comando1.setInt(4, obj.getIdUsuario());
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
    
    
    public Usuario Autenticar(String usuario, String senha) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Usuario WHERE usuario = ? AND STATUS = 1 AND senha = ?");
            comando.setString(1, usuario);
            comando.setString(2, senha);
            
            ResultSet consulta = comando.executeQuery();
                Usuario novo = null;
            
                if(consulta.first()){
                novo = new Usuario();
                
                novo.setUsuario(consulta.getString("usuario"));
                novo.setNivel(consulta.getInt("nivel"));
                
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
    
    public Usuario Abrir(int idUsuario) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Usuario WHERE idUsuario = ? AND STATUS = 1");
            comando.setInt(1, idUsuario);
            ResultSet consulta = comando.executeQuery();
            
            if(consulta.first()){
                Usuario novo = new Usuario();
                
                novo.setIdUsuario(idUsuario);
                novo.setUsuario(consulta.getString("usuario"));
                novo.setNivel(consulta.getInt("nivel"));
                
                return novo;
           
            }else return null;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
        
            conexao.getConexao().close();
        
        }
   
    }
    
    
    public List<Usuario> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Usuario WHERE status = 1");
            ResultSet consulta = comando.executeQuery();
            List<Usuario> lista = new LinkedList<>();
            while(consulta.next()){
                Usuario novo = new Usuario();
                novo.setIdUsuario(consulta.getInt("idUsuario"));
                novo.setUsuario(consulta.getString("usuario"));
                novo.setNivel(consulta.getInt("nivel"));
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
    
    public boolean Apagar(int idUsuario ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE Usuario SET status = 0 WHERE idUsuario = ?");
            comando.setInt(1, idUsuario);
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