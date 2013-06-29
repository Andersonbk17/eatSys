/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.AreaConhecimento_Cnpq;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class AreaConhecimentoCnpqDAO {
    private ConexaoBanco conexao;
    
    public AreaConhecimentoCnpqDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(NacionalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public AreaConhecimento_Cnpq Abrir(int idAreaConhecimentoCnpq) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM AreaConhecimento_CNPq "
                    + "WHERE idAreaConhecimento = ?");
            comando.setInt(1, idAreaConhecimentoCnpq);
            ResultSet consulta = comando.executeQuery();
            AreaConhecimento_Cnpq novo = null;
            if(consulta.first()){
                novo = new AreaConhecimento_Cnpq();
                novo.setIdAreaConhecimento_Cnpq(idAreaConhecimentoCnpq);
                novo.setCodigo(consulta.getString("codigo"));
                novo.setNome(consulta.getString("nome"));
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public List<AreaConhecimento_Cnpq> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM AreaConhecimentoCNPq");
            ResultSet consulta = comando.executeQuery();
            List<AreaConhecimento_Cnpq> lista = new LinkedList<>();
            while(consulta.next()){
                AreaConhecimento_Cnpq novo = new AreaConhecimento_Cnpq();
                novo.setIdAreaConhecimento_Cnpq(consulta.getInt("idAreaConhecimento_CNPq"));
                novo.setCodigo(consulta.getString("codigo"));
                novo.setNome(consulta.getString("nome"));
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