/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Nacionalidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Modric
 */
public class NacionalidadeDAO {
    private ConexaoBanco conexao;
    
    public NacionalidadeDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(NacionalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Nacionalidade Abrir(int idNacionalidade) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Nacionalidade "
                    + "WHERE idNacionalidade = ?");
            comando.setInt(1, idNacionalidade);
            ResultSet consulta = comando.executeQuery();
            Nacionalidade novo = null;
            if(consulta.first()){
                novo = new Nacionalidade();
                novo.setIdNacionalidade(idNacionalidade);
                novo.setNome(consulta.getString("nacionalidadePt"));
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public List<Nacionalidade> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Nacionalidade");
            ResultSet consuta = comando.executeQuery();
            List<Nacionalidade> lista = new LinkedList<>();
            while(consuta.next()){
                Nacionalidade novo = new Nacionalidade();
                novo.setIdNacionalidade(consuta.getInt("idNacionalidade"));
                novo.setNome(consuta.getString("nacionalidadePt"));
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
}