/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.AreaConhecimento_CnpqSubAreas;
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
public class AreaConhecimento_CnpqSubAreasDAO {
    private ConexaoBanco conexao;
    
    public AreaConhecimento_CnpqSubAreasDAO (){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(NacionalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public AreaConhecimento_CnpqSubAreas Abrir(int idAreaConhecimentoCnpqSubAreas) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM AreaConhecimento_CNPqSubAreas "
                    + "WHERE idAreaConhecimento_CNPqSubAreas = ?");
            comando.setInt(1, idAreaConhecimentoCnpqSubAreas);
            ResultSet consulta = comando.executeQuery();
            AreaConhecimento_CnpqSubAreas novo = null;
            if(consulta.first()){
                novo = new AreaConhecimento_CnpqSubAreas();
                novo.setIdAreaConhecimento_CnpqSubAreas(idAreaConhecimentoCnpqSubAreas);
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
    
    public List<AreaConhecimento_CnpqSubAreas> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM AreaConhecimento_CNPqSubAreas");
            ResultSet consulta = comando.executeQuery();
            List<AreaConhecimento_CnpqSubAreas> lista = new LinkedList<>();
            while(consulta.next()){
                AreaConhecimento_CnpqSubAreas novo = new AreaConhecimento_CnpqSubAreas();
                novo.setIdAreaConhecimento_CnpqSubAreas(consulta.getInt("idAreaConhecimento_CNPq"));
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