
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Orientador;
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
public class OrientadorDAO {
    private ConexaoBanco conexao;
    
    public OrientadorDAO(){
        try {
            conexao = new ConexaoBanco();
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean Salvar(Orientador obj ) throws SQLException{
        try{
            if(obj.getIdOrientador()== 0){
                
                
                
                int idPessoa = 0;//mudar o valor inicial
                
                PreparedStatement comando = conexao.getConexao().prepareCall("INSERT INTO Orientador(matriculaSiape,localPermanencia,"
                        + "formacaoUniversitaria,tituloAcademico,idPessoa,status,idCurso,telefoneRamal) VALUES(?,?,?,?,?,?,?,?)");
                comando.setInt(1, obj.getMatriculaSiape());
                comando.setString(2, obj.getLocalPermanencia());
                comando.setString(3, obj.getFormacaoUniversitaria());
                comando.setString(4, obj.getTituloAcademico());
                comando.setInt(5, idPessoa);
                comando.setInt(6, 1);
                comando.setInt(7, obj.getCursoArea().getIdCursoArea());
                comando.setString(8,obj.getTelefoneRamal());
                comando.execute();
            }else{
                
                /*Colocar o Update PEssoaDAO*/
                
                PreparedStatement comando1 = conexao.getConexao().prepareCall("UPDATE Orientador SET matriculaSiape = ?,localPermanencia = ?,"
                        + "formacaoUniversitaria = ?,tituloAcademico = ?,idPessoa = ?,status = ?,idCurso = ?,telefoneRamal = ? WHERE idOrientador = ?");
                comando1.setInt(1, obj.getMatriculaSiape());
                comando1.setString(2, obj.getLocalPermanencia());
                comando1.setString(3, obj.getFormacaoUniversitaria());
                comando1.setString(4, obj.getTituloAcademico());
                comando1.setInt(5, obj.getIdPessoa());
                comando1.setInt(6, 1);
                comando1.setInt(7, obj.getCursoArea().getIdCursoArea());
                comando1.setString(8,obj.getTelefoneRamal());
                comando1.setInt(9, obj.getIdOrientador());
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
    
    
    public Orientador Abrir(int idOrientador) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Orientador WHERE idOrientador = ? AND STATUS = 1");
            comando.setInt(1, idOrientador);
            ResultSet consulta = comando.executeQuery();
            Orientador novo = null;
            if(consulta.first()){
                novo = new Orientador();
                CursoAreaDAO novoCursoArea = new CursoAreaDAO();
                CampusDAO novoCampus = new CampusDAO();
                CidadeDAO  novoCidade = new CidadeDAO();
                EstadoDAO novoEstado = new EstadoDAO();
                NacionalidadeDAO novoNacionaldiade = new NacionalidadeDAO();
                novo.setCpf(consulta.getInt("cpf"));
                novo.setCursoArea(novoCursoArea.Abrir(consulta.getInt("idCurso")));
                //novo.setDataNascimento(null);
                novo.setEmailEndereco(consulta.getString("email"));
                novo.setEnderecNumero(consulta.getString("numero"));
                novo.setEnderecoBairro(consulta.getString("bairro"));
                novo.setEnderecoCep(consulta.getInt("cep"));
                novo.setEnderecoComplmento(consulta.getString("complemento"));
                novo.setEnderecoRua(consulta.getString("rua"));
                novo.setFormacaoUniversitaria(consulta.getString("formacaoUniversitaria"));
                novo.setIdOrientador(idOrientador);
                novo.setIdPessoa(consulta.getInt("idPessoa"));
                novo.setLocalPermanencia(consulta.getString("localPermanencia"));
                novo.setMatriculaSiape(consulta.getInt("matriculaSiape"));
                novo.setNome(consulta.getString("nome"));
                novo.setPessoaCampus(novoCampus.Abrir(consulta.getInt("idCampus")));
                novo.setPessoaCidade(novoCidade.Abrir(consulta.getInt("idCidade")));
                novo.setPessoaEstado(novoEstado.Abrir(consulta.getInt("idEstado")));
                novo.setPessoaNacionalidade(novoNacionaldiade.Abrir(consulta.getInt("idNacionalidade")));
                novo.setRg(consulta.getString("rg"));
                //novo.setRgDataExpedicao(novoEstado);
                novo.setRgOrgaoExpedidor(consulta.getString("orgaoExpeditor"));
                novo.setTelefoneCelular(consulta.getString("celular"));
                novo.setTelefoneFixo(consulta.getString("telefoneResidencial"));
                novo.setTelefoneRamal(consulta.getString("telefoneRamal"));
                novo.setTituloAcademico(consulta.getString("tituloAcademico"));
                /*conferir a cidade*/
                
            
           
            }
            
            return novo;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
        
            conexao.getConexao().close();
        
        }
   
    }
    
    
    public List<Orientador> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Orientador WHERE STATUS = 1");
            ResultSet consulta = comando.executeQuery();
            List<Orientador> lista = new LinkedList<>();
            while(consulta.next()){
                Orientador novo = new Orientador();
                CursoAreaDAO novoCursoArea = new CursoAreaDAO();
                CampusDAO novoCampus = new CampusDAO();
                CidadeDAO  novoCidade = new CidadeDAO();
                EstadoDAO novoEstado = new EstadoDAO();
                NacionalidadeDAO novoNacionaldiade = new NacionalidadeDAO();
    
                novo.setCpf(consulta.getInt("cpf"));
                novo.setCursoArea(novoCursoArea.Abrir(consulta.getInt("idCurso")));
                //novo.setDataNascimento(null);
                novo.setEmailEndereco(consulta.getString("email"));
                novo.setEnderecNumero(consulta.getString("numero"));
                novo.setEnderecoBairro(consulta.getString("bairro"));
                novo.setEnderecoCep(consulta.getInt("cep"));
                novo.setEnderecoComplmento(consulta.getString("complemento"));
                novo.setEnderecoRua(consulta.getString("rua"));
                novo.setFormacaoUniversitaria(consulta.getString("formacaoUniversitaria"));
                novo.setIdOrientador(consulta.getInt("idOrientador"));
                novo.setIdPessoa(consulta.getInt("idPessoa"));
                novo.setLocalPermanencia(consulta.getString("localPermanencia"));
                novo.setMatriculaSiape(consulta.getInt("matriculaSiape"));
                novo.setNome(consulta.getString("nome"));
                novo.setPessoaCampus(novoCampus.Abrir(consulta.getInt("idCampus")));
                novo.setPessoaCidade(novoCidade.Abrir(consulta.getInt("idCidade")));
                novo.setPessoaEstado(novoEstado.Abrir(consulta.getInt("idEstado")));
                novo.setPessoaNacionalidade(novoNacionaldiade.Abrir(consulta.getInt("idNacionalidade")));
                novo.setRg(consulta.getString("rg"));
                //novo.setRgDataExpedicao(novoEstado);
                novo.setRgOrgaoExpedidor(consulta.getString("orgaoExpeditor"));
                novo.setTelefoneCelular(consulta.getString("celular"));
                novo.setTelefoneFixo(consulta.getString("telefoneResidencial"));
                novo.setTelefoneRamal(consulta.getString("telefoneRamal"));
                novo.setTituloAcademico(consulta.getString("tituloAcademico"));
                
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
    
    public boolean Apagar(int idOrientador,int idPessoa ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE Orientador SET status = 0 WHERE idOrientador = ?");
            comando.setInt(1, idOrientador);
            comando.executeUpdate();
            
            /*Chamar a dao Pessoa Para Excluir tbm*/
            return true;
        }catch(SQLException ex){
           ex.printStackTrace();
           return false;
        }finally{
            conexao.getConexao().close();
        }
   
    }
}