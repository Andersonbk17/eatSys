/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.PlanoDeTrabalho;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author emerson
 */
public class PlanoTrabalhoDAO {
    ConexaoBanco conexao;
    
    public PlanoTrabalhoDAO() throws SQLException{
        conexao = new ConexaoBanco();
    }
    
    public boolean Salvar(PlanoDeTrabalho obj) throws SQLException{
        try{
            if(obj.getIdPlanoDeTrabalho() == 0){
                PreparedStatement comando = conexao.getConexao().prepareStatement(""
                        + "INSERT INTO PlanoDeTrabaho(idaluno,introducao,justificativa,objetivos,metodologia,resultadosEsperados, "
                        + "referenciasBibliograficas,status,dataInicial,dataFinal) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?) ");
                comando.setInt(1, obj.getAlunoPlanoTrabalho().getIdAluno());
                comando.setString(2, obj.getIntroducao());
                comando.setString(3, obj.getJustificativa());
                comando.setString(4, obj.getObjetivos());
                comando.setString(5, obj.getMetodologia());
                comando.setString(6, obj.getResultadoEsperado());
                comando.setString(7, obj.getReferenciaBibliografica());
                comando.setInt(8, 1);

                java.sql.Date dataInicio = new java.sql.Date(obj.getDataInicio().getTime());
                comando.setDate(9,dataInicio);

                java.sql.Date dataFinal = new java.sql.Date(obj.getDataTermino().getTime());
                comando.setDate(10,dataFinal);

                comando.execute();

            }else{
                     PreparedStatement comando = conexao.getConexao().prepareStatement(""
                        + "UPDATE PlanoDeTrabaho SET idaluno = ?,introducao = ?,justificativa = ?,objetivos = ?,metodologia = ?, "
                        + "resultadosEsperados = ?,referenciasBibliograficas = ?,dataInicial = ?,dataFinal = ? "
                        + "WHERE idPlanoDeTrabalho = ? AND status = 1 ");
                comando.setInt(1, obj.getAlunoPlanoTrabalho().getIdAluno());
                comando.setString(2, obj.getIntroducao());
                comando.setString(3, obj.getJustificativa());
                comando.setString(4, obj.getObjetivos());
                comando.setString(5, obj.getMetodologia());
                comando.setString(6, obj.getResultadoEsperado());
                comando.setString(7, obj.getReferenciaBibliografica());

                java.sql.Date dataInicio = new java.sql.Date(obj.getDataInicio().getTime());
                comando.setDate(8,dataInicio);

                java.sql.Date dataFinal = new java.sql.Date(obj.getDataTermino().getTime());
                comando.setDate(9,dataFinal);

                comando.setInt(10, obj.getIdPlanoDeTrabalho());

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
    
    public PlanoDeTrabalho Abrir(int idPlanoDeTrabalho) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM PlanoDeTrabaho WHERE idPlanoDeTrabalho = ?  AND status = 1");
            comando.setInt(1, idPlanoDeTrabalho);

            ResultSet resultado = comando.executeQuery();

            PlanoDeTrabalho planoNovo = null;

            if(resultado.first()){
                planoNovo = new PlanoDeTrabalho();
                AlunoDAO aluno = new AlunoDAO(); 


                planoNovo.setIdPlanoDeTrabalho(idPlanoDeTrabalho);
                planoNovo.setAlunoPlanoTrabalho(aluno.Abrir(resultado.getInt("idAluno")));
                planoNovo.setIntroducao(resultado.getString("introducao"));
                planoNovo.setJustificativa(resultado.getString("justificativa"));
                planoNovo.setObjetivos(resultado.getString("objetivos"));
                planoNovo.setMetodologia(resultado.getString("metodologia"));
                planoNovo.setResultadoEsperado(resultado.getString("resultadosEsperados"));
                planoNovo.setReferenciaBibliografica(resultado.getString("referenciasBibliograficas"));
                planoNovo.setDataInicio(resultado.getDate("dataInicial"));
                planoNovo.setDataTermino(resultado.getDate("dataFinal"));

            }
            return planoNovo;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;      
        }finally{
            conexao.getConexao().close();
        }
    }   
    
     public List<PlanoDeTrabalho> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM PlanoDeTrabaho WHERE idPlanoDeTrabaho = ?  AND status = 1");

            ResultSet resultado = comando.executeQuery();

            List<PlanoDeTrabalho> lista = new LinkedList<>();

            while(resultado.first()){
                PlanoDeTrabalho planoNovo;
                planoNovo = new PlanoDeTrabalho();
                AlunoDAO aluno = new AlunoDAO(); 


                planoNovo.setIdPlanoDeTrabalho(resultado.getInt("idPlanoDeTrabalho"));
                planoNovo.setAlunoPlanoTrabalho(aluno.Abrir(resultado.getInt("idAluno")));
                planoNovo.setIntroducao(resultado.getString("introducao"));
                planoNovo.setJustificativa(resultado.getString("justificativa"));
                planoNovo.setObjetivos(resultado.getString("objetivos"));
                planoNovo.setMetodologia(resultado.getString("metodologia"));
                planoNovo.setResultadoEsperado(resultado.getString("resultadosEsperados"));
                planoNovo.setReferenciaBibliografica(resultado.getString("referenciasBibliograficas"));
                planoNovo.setDataInicio(resultado.getDate("dataInicial"));
                planoNovo.setDataTermino(resultado.getDate("dataFinal"));

                lista.add(planoNovo);

            }
            return lista;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;      
        }finally{
            conexao.getConexao().close();
        }
    }   
     
    public boolean Apagar(int idPlanoDeTrabalho) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE PlanoDeTrabalho "
                    + "SET status = 0 "
                    + "WHERE idPlanoDeTrabalho = ? ");
            comando.setInt(1, idPlanoDeTrabalho);
            
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
