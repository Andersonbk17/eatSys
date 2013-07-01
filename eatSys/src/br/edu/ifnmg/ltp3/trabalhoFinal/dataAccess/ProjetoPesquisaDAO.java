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
                java.sql.Date dataInicio = new java.sql.Date(obj.getDataInicio().getTime());
                comando.setDate(2,dataInicio);
                java.sql.Date dataTermino = new java.sql.Date(obj.getDataTermino().getTime());
                comando.setDate(3, dataTermino);
                comando.setString(4,obj.getGrupoPesquisa());
                comando.setInt(5,obj.getCampus().getIdCampus());
                comando.setString(6, obj.getResumo());
                comando.setInt(7,obj.getOrientador().getIdOrientador());
                comando.setInt(8, obj.getFinanciamentoAprovado());
                comando.setFloat(9, obj.getValorFinanciamento());
                java.sql.Date dataFinanciamento = new java.sql.Date(obj.getDataFinanciamento().getTime());
                comando.setDate(10, dataFinanciamento);
                comando.setInt(11, obj.getBolsasIniciacao());
                comando.setInt(12, obj.getNumeroBolsas());
                comando.setString(13, obj.getAgenciaFinanciadora());
                comando.setInt(14, obj.getConvenio());
                comando.setString(15, obj.getNomeConvenio());
                comando.setInt(16, 1);
                comando.setInt(17, obj.getFuncadao());
                comando.setString(18, obj.getFundacaoNome());
                comando.setInt(19, obj.getProjetoMulticampi());
                comando.setInt(20, obj.getAluno().getIdAluno());
                comando.setInt(21, obj.getAreaConhecimento().getIdAreaConhecimento_CnpqSubAreas());
                
                comando.execute();
                
                PreparedStatement comando1 = conexao.getConexao().prepareStatement("SELECT max(idProjetoPesquisa) FROM "
                        + " ProjetoPesquisa WHERE status =1");
                ResultSet consulta = comando1.executeQuery();
                consulta.first();
                for(ParticipanteProjeto p : obj.getListaParticipantes()){
                    ParticipanteProjetoDAO dao = new ParticipanteProjetoDAO();
                    dao.Salvar(p, consulta.getInt("max(idProjetoPesquisa)"));
                }
            }else{
                PreparedStatement comando1 = conexao.getConexao().prepareCall("UPDATE  ProjetoPesquisa SET titulo = ?,dataInicio = ?,"
                        + "dataTermino = ?,grupoPesquisa = ?,idCampus = ?,resumo = ?,idOrientador = ?,financiamentoAprovado = ?,valorFinanciamento = ?,"
                        + "dataFinanciamento = ?,bolsaIniciacao = ?,numeroBolsas = ?,agenciaFinanciadora = ?,convenio = ?,nomeConvenio = ?,"
                        + "status = ?,fundacao = ?,fundacaoNome = ?,projetoMulticampi = ?,idAluno = ?,idAreaConhecimento_CnpqSubAreas = ? "
                        + "WHERE idProjetoPesquisa = ?");
                comando1.setString(1, obj.getTitulo());java.sql.Date dataInicio = new java.sql.Date(obj.getDataInicio().getTime());
                comando1.setDate(2,dataInicio);
                java.sql.Date dataTermino = new java.sql.Date(obj.getDataTermino().getTime());
                comando1.setDate(3, dataTermino);
                comando1.setString(4,obj.getGrupoPesquisa());
                comando1.setInt(5,obj.getCampus().getIdCampus());
                comando1.setString(6, obj.getResumo());
                comando1.setInt(7,obj.getOrientador().getIdOrientador());
                comando1.setInt(8, obj.getFinanciamentoAprovado());
                comando1.setFloat(9, obj.getValorFinanciamento());
                java.sql.Date dataFinanciamento = new java.sql.Date(obj.getDataFinanciamento().getTime());
                comando1.setDate(10, dataFinanciamento);
                comando1.setInt(11, obj.getBolsasIniciacao());
                comando1.setInt(12, obj.getNumeroBolsas());
                comando1.setString(13, obj.getAgenciaFinanciadora());
                comando1.setInt(14, obj.getConvenio());
                comando1.setString(15, obj.getNomeConvenio());
                comando1.setInt(16, 1);
                comando1.setInt(17, obj.getFuncadao());
                comando1.setString(18, obj.getFundacaoNome());
                comando1.setInt(19, obj.getProjetoMulticampi());
                comando1.setInt(20, obj.getAluno().getIdAluno());
                comando1.setInt(21, obj.getAreaConhecimento().getIdAreaConhecimento_CnpqSubAreas());
                comando1.setInt(22, obj.getIdProjetoPesquisa());
                comando1.executeUpdate();
                for(ParticipanteProjeto p : obj.getListaParticipantes()){
                    ParticipanteProjetoDAO dao = new ParticipanteProjetoDAO();
                    dao.Salvar(p, obj.getIdProjetoPesquisa());
                }
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
             ProjetoPesquisa novo = null;
            if(consulta.first()){
                novo = new ProjetoPesquisa();
                CampusDAO campusdao = new CampusDAO();
                AlunoDAO aluno = new AlunoDAO();
                ParticipanteProjetoDAO participantes = new ParticipanteProjetoDAO();
                OrientadorDAO orientador = new OrientadorDAO();
                AreaConhecimento_CnpqSubAreasDAO areaConhecimento = new AreaConhecimento_CnpqSubAreasDAO();
                novo.setAgenciaFinanciadora(consulta.getString("agenciaFinanciadora"));
                novo.setAluno(aluno.Abrir(consulta.getInt("idAluno")));
                novo.setAreaConhecimento(areaConhecimento.Abrir(consulta.getInt("idAreaConhecimento_CnpqSubAreas")));
                novo.setBolsasIniciacao(consulta.getInt("bolsaIniciacao"));
                novo.setCampus(campusdao.Abrir(consulta.getInt("idCampus")));
                novo.setConvenio(consulta.getInt("convenio"));
                //novo.setDataFinanciamento(null);
                //novo.setDataInicio(null);
                //novo.setDataTermino(null);
                novo.setFinanciamentoAprovado(consulta.getInt("financiamentoAprovado"));
                novo.setFuncadao(consulta.getInt("fundacao"));
                novo.setFundacaoNome(consulta.getString("fundacaoNome"));
                novo.setGrupoPesquisa(consulta.getString("grupoPesquisa"));
                novo.setIdProjetoPesquisa(consulta.getInt("idProjetoPesquisa"));
                novo.setListaParticipantes(participantes.ListarTodos(consulta.getInt("idProjetoPesquisa")));
                novo.setNomeConvenio(consulta.getString("nomeConvenio"));
                novo.setNumeroBolsas(consulta.getInt("numeroBolsas"));
                novo.setOrientador(orientador.Abrir(consulta.getInt("idOrientador")));
                novo.setProjetoMulticampi(consulta.getInt("projetoMulticampi"));
                novo.setResumo(consulta.getString("resumo"));
                novo.setTitulo(consulta.getString("titulo"));
                novo.setValorFinanciamento(consulta.getFloat("valorFinanciamento"));
                
                
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
    
    
    public List<ProjetoPesquisa> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM ProjetoPesquisa WHERE status = 1");
            ResultSet consulta = comando.executeQuery();
            List<ProjetoPesquisa> lista = new LinkedList<>();
            while(consulta.next()){
                ProjetoPesquisa novo = new ProjetoPesquisa();
                CampusDAO campusdao = new CampusDAO();
                AlunoDAO aluno = new AlunoDAO();
                ParticipanteProjetoDAO participantes = new ParticipanteProjetoDAO();
                OrientadorDAO orientador = new OrientadorDAO();
                AreaConhecimento_CnpqSubAreasDAO areaConhecimento = new AreaConhecimento_CnpqSubAreasDAO();
                novo.setAgenciaFinanciadora(consulta.getString("agenciaFinanciadora"));
                novo.setAluno(aluno.Abrir(consulta.getInt("idAluno")));
                novo.setAreaConhecimento(areaConhecimento.Abrir(consulta.getInt("idAreaConhecimento_CnpqSubAreas")));
                novo.setBolsasIniciacao(consulta.getInt("bolsaIniciacao"));
                novo.setCampus(campusdao.Abrir(consulta.getInt("idCampus")));
                novo.setConvenio(consulta.getInt("convenio"));
                //novo.setDataFinanciamento(null);
                //novo.setDataInicio(null);
                //novo.setDataTermino(null);
                novo.setFinanciamentoAprovado(consulta.getInt("financiamentoAprovado"));
                novo.setFuncadao(consulta.getInt("fundacao"));
                novo.setFundacaoNome(consulta.getString("fundacaoNome"));
                novo.setGrupoPesquisa(consulta.getString("grupoPesquisa"));
                novo.setIdProjetoPesquisa(consulta.getInt("idProjetoPesquisa"));
                novo.setListaParticipantes(participantes.ListarTodos(consulta.getInt("idProjetoPesquisa")));
                novo.setNomeConvenio(consulta.getString("nomeConvenio"));
                novo.setNumeroBolsas(consulta.getInt("numeroBolsas"));
                novo.setOrientador(orientador.Abrir(consulta.getInt("idOrientador")));
                novo.setProjetoMulticampi(consulta.getInt("projetoMulticampi"));
                novo.setResumo(consulta.getString("resumo"));
                novo.setTitulo(consulta.getString("titulo"));
                novo.setValorFinanciamento(consulta.getFloat("valorFinanciamento"));
              
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
    
    public boolean Apagar(int idProjetoPesquisa ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE ProjetoPesquisa SET status = 0 WHERE idProjetoPesquisa = ?");
            comando.setInt(1, idProjetoPesquisa);
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