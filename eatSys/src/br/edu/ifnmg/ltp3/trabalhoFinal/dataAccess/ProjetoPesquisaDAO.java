/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ParticipanteProjeto;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ProjetoPesquisa;
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
public class ProjetoPesquisaDAO {
    private ConexaoBanco conexao;
    
    public ProjetoPesquisaDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean Salvar(ProjetoPesquisa obj ) throws SQLException{
        try{
            if(obj.getIdProjetoPesquisa()== 0){
                PreparedStatement comando = conexao.getConexao().prepareCall("INSERT INTO ProjetoPesquisa(titulo,dataInicio,"
                        + "dataTermino,grupoPesquisa,idCampus,resumo,idOrientador,financiamentoAprovado,valorFinanciamento,dataFinanciamento,"
                        + "bolsaIniciacao,numeroBolsas,agenciaFinanciadora,convenio,nomeConvenio,status,fundacao,fundacaoNome,projetoMulticampi,"
                        + "idAluno,idAreaConhecimento_CnpqSubAreas) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getTitulo());
                //comando.setString(2, obj.getTitulacao());
                //comando.setString(3, obj.getObservacao());
                comando.setString(4,obj.getGrupoPesquisa());
                comando.setInt(5,obj.getCampus().getIdCampus());
                comando.setString(6, obj.getResumo());
                comando.setInt(7,obj.getOrientador().getIdOrientador());
                comando.setInt(8, obj.getFinanciamentoAprovado());
                comando.setFloat(9, obj.getValorFinanciamento());
                //comando.setDate(10, null);
                comando.setInt(11, obj.getBolsasIniciacao());
                comando.setInt(12, obj.getNumeroBolsas());
                comando.setString(13, obj.getAgenciaFinanciadora());
                comando.setInt(14, obj.getConvenio());
                comando.setString(15, obj.getNomeConvenio());
                comando.setInt(16, 1);
                comando.setInt(17, obj.getFuncadao());
                comando.setString(18, obj.getFundacaoNome());
                comando.setBoolean(19, obj.isProjetoMulticampi());
                comando.setInt(20, obj.getAluno().getIdAluno());
                comando.setInt(21, obj.getAreaConhecimento().getIdAreaConhecimento_CnpqSubAreas());
                
                comando.execute();
            }else{
                PreparedStatement comando1 = conexao.getConexao().prepareCall("UPDATE  ProjetoPesquisa SET titulo = ?,dataInicio = ?,"
                        + "dataTermino = ?,grupoPesquisa = ?,idCampus = ?,resumo = ?,idOrientador = ?,financiamentoAprovado = ?,valorFinanciamento = ?,"
                        + "dataFinanciamento = ?,bolsaIniciacao = ?,numeroBolsas = ?,agenciaFinanciadora = ?,convenio = ?,nomeConvenio = ?,"
                        + "status = ?,fundacao = ?,fundacaoNome = ?,projetoMulticampi = ?,idAluno = ?,idAreaConhecimento_CnpqSubAreas = ? "
                        + "WHERE idProjetoPesquisa = ?");
                comando1.setString(1, obj.getTitulo());
                //comando1.setString(2, obj.getTitulacao());
                //comando1.setString(3, obj.getObservacao());
                comando1.setString(4,obj.getGrupoPesquisa());
                comando1.setInt(5,obj.getCampus().getIdCampus());
                comando1.setString(6, obj.getResumo());
                comando1.setInt(7,obj.getOrientador().getIdOrientador());
                comando1.setInt(8, obj.getFinanciamentoAprovado());
                comando1.setFloat(9, obj.getValorFinanciamento());
                //comando1.setDate(10, null);
                comando1.setInt(11, obj.getBolsasIniciacao());
                comando1.setInt(12, obj.getNumeroBolsas());
                comando1.setString(13, obj.getAgenciaFinanciadora());
                comando1.setInt(14, obj.getConvenio());
                comando1.setString(15, obj.getNomeConvenio());
                comando1.setInt(16, 1);
                comando1.setInt(17, obj.getFuncadao());
                comando1.setString(18, obj.getFundacaoNome());
                comando1.setBoolean(19, obj.isProjetoMulticampi());
                comando1.setInt(20, obj.getAluno().getIdAluno());
                comando1.setInt(21, obj.getAreaConhecimento().getIdAreaConhecimento_CnpqSubAreas());
                comando1.setInt(22, obj.getIdProjetoPesquisa());
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    }
    
    
    public ProjetoPesquisa Abrir(int idProjetoPesquisa) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM ProjetoPesquisa WHERE "
                    + "idProjetoPesquisa = ? ");
            comando.setInt(1, idProjetoPesquisa);
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