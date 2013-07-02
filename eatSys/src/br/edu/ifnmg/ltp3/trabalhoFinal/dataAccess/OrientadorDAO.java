
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Orientador;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                
                Pessoa tmp = new Pessoa();
                PessoaDAO daoPessoa = new PessoaDAO();
                
                tmp.setCpf(obj.getCpf());
                tmp.setDataNascimento(obj.getDataNascimento());
                tmp.setEmailEndereco(obj.getEmailEndereco());
                tmp.setEnderecoNumero(obj.getEnderecoNumero());
                tmp.setEnderecoBairro(obj.getEnderecoBairro());
                tmp.setEnderecoCep(obj.getEnderecoCep());
                tmp.setEnderecoComplmento(obj.getEnderecoComplmento());
                tmp.setEnderecoRua(obj.getEnderecoRua());
                tmp.setIdPessoa(obj.getIdPessoa());
                tmp.setNome(obj.getNome());
                tmp.setPessoaCampus(obj.getPessoaCampus());
                tmp.setPessoaCidade(obj.getPessoaCidade());
                tmp.setPessoaEstado(obj.getPessoaEstado());
                tmp.setPessoaNacionalidade(obj.getPessoaNacionalidade());
                tmp.setRg(obj.getRg());
                tmp.setRgDataExpedicao(obj.getRgDataExpedicao());
                tmp.setRgOrgaoExpedidor(obj.getRgOrgaoExpedidor());
                tmp.setTelefoneCelular(obj.getTelefoneCelular());
                tmp.setTelefoneFixo(obj.getTelefoneFixo());
                
                daoPessoa.SalvarPessoa(tmp);
                
                PreparedStatement consulta = conexao.getConexao().prepareStatement("SELECT max(idPessoa) FROM Pessoa WHERE cpf = ?");
                consulta.setInt(1, obj.getCpf());
                ResultSet rs = consulta.executeQuery();//verificar
                
                if(rs.first()){
                    int idPessoa = rs.getInt("max(idPessoa)");//mudar o valor inicial

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
                    return false;
                }
            }else{
                
                Pessoa tmp = new Pessoa();
                PessoaDAO daoPessoa = new PessoaDAO();
                
                tmp.setCpf(obj.getCpf());
                tmp.setDataNascimento(obj.getDataNascimento());
                tmp.setEmailEndereco(obj.getEmailEndereco());
                tmp.setEnderecoNumero(obj.getEnderecoNumero());
                tmp.setEnderecoBairro(obj.getEnderecoBairro());
                tmp.setEnderecoCep(obj.getEnderecoCep());
                tmp.setEnderecoComplmento(obj.getEnderecoComplmento());
                tmp.setEnderecoRua(obj.getEnderecoRua());
                tmp.setIdPessoa(obj.getIdPessoa());
                tmp.setNome(obj.getNome());
                tmp.setPessoaCampus(obj.getPessoaCampus());
                tmp.setPessoaCidade(obj.getPessoaCidade());
                tmp.setPessoaEstado(obj.getPessoaEstado());
                tmp.setPessoaNacionalidade(obj.getPessoaNacionalidade());
                tmp.setRg(obj.getRg());
                tmp.setRgDataExpedicao(obj.getRgDataExpedicao());
                tmp.setRgOrgaoExpedidor(obj.getRgOrgaoExpedidor());
                tmp.setTelefoneCelular(obj.getTelefoneCelular());
                tmp.setTelefoneFixo(obj.getTelefoneFixo());
                
                daoPessoa.SalvarPessoa(tmp);
                
                
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

            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT pe.idPessoa,pe.nome,pe.cpf,pe.rg,pe.dataNascimento,pe.orgaoExpedidor,pe.dataExpedicao,pe.status, "
                    + "pe.idCampus,pe.idNacionalidade,pe.idEstado,pe.rua,pe.numero,pe.complemento,pe.bairro,pe.cep, "
                    + "pe.telefoneResidencial,pe.celular,pe.email,pe.idCidade, "
                    + "o.tituloAcademico,o.telefoneRamal,o.localPermanencia,o.matriculaSiape,o.formacaoUniversitaria, "
                    + "o.idOrientador,o.idCurso "
                    + "FROM Orientador o "
                    + "INNER JOIN Pessoa pe ON (pe.idPessoa=o.idPessoa) "
                    + "WHERE o.idOrientador = ? AND pe.status = 1 ");

            comando.setInt(1, idOrientador);
            ResultSet consulta = comando.executeQuery();
            Orientador novo = null;
            if(consulta.first()){
                novo = new Orientador();
                CursoDAO novoCursoArea = new CursoDAO();
                CampusDAO novoCampus = new CampusDAO();
                CidadeDAO  novoCidade = new CidadeDAO();
                EstadoDAO novoEstado = new EstadoDAO();
                NacionalidadeDAO novoNacionaldiade = new NacionalidadeDAO();
                novo.setCpf(consulta.getInt("pe.cpf"));
                novo.setCursoArea(novoCursoArea.Abrir(consulta.getInt("o.idCurso")));
                novo.setDataNascimento(consulta.getDate("pe.dataNascimento"));
                novo.setEmailEndereco(consulta.getString("pe.email"));
                novo.setEnderecoNumero(consulta.getString("pe.numero"));
                novo.setEnderecoBairro(consulta.getString("pe.bairro"));
                novo.setEnderecoCep(consulta.getInt("pe.cep"));
                novo.setEnderecoComplmento(consulta.getString("pe.complemento"));
                novo.setEnderecoRua(consulta.getString("pe.rua"));
                novo.setFormacaoUniversitaria(consulta.getString("o.formacaoUniversitaria"));
                novo.setIdOrientador(idOrientador);

                novo.setIdPessoa(consulta.getInt("pe.idPessoa"));
                novo.setLocalPermanencia(consulta.getString("o.localPermanencia"));
                novo.setMatriculaSiape(consulta.getInt("o.matriculaSiape"));
                novo.setNome(consulta.getString("pe.nome"));
                novo.setPessoaCampus(novoCampus.Abrir(consulta.getInt("pe.idCampus")));
                novo.setPessoaCidade(novoCidade.Abrir(consulta.getInt("pe.idCidade")));
                novo.setPessoaEstado(novoEstado.Abrir(consulta.getInt("pe.idEstado")));
                novo.setPessoaNacionalidade(novoNacionaldiade.Abrir(consulta.getInt("pe.idNacionalidade")));
                novo.setRg(consulta.getString("pe.rg"));
                novo.setRgDataExpedicao(consulta.getDate("pe.dataExpedicao"));
                novo.setRgOrgaoExpedidor(consulta.getString("pe.orgaoExpedidor"));
                novo.setTelefoneCelular(consulta.getString("pe.celular"));
                novo.setTelefoneFixo(consulta.getString("pe.telefoneResidencial"));
                novo.setTelefoneRamal(consulta.getString("o.telefoneRamal"));
                novo.setTituloAcademico(consulta.getString("o.tituloAcademico"));
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
                novo.setRgOrgaoExpedidor(consulta.getString("orgaoExpedidor"));
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
            Statement comando = conexao.getConexao().createStatement();
                    
                    
            /*
 p.idPessoa,p.nome,p.cpf,p.rg,p.dataNascimento         
             
             */
            
            ResultSet consulta = comando.executeQuery("SELECT * FROM Pessoa p "
                    + "INNER JOIN Orientador o ON p.idPessoa = o.idPessoa WHERE p.status = 1 AND o.status = 1");
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
                novo.setDataNascimento(consulta.getDate("dataNascimento"));
                novo.setEmailEndereco(consulta.getString("email"));
                novo.setEnderecoNumero(consulta.getString("numero"));
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
                novo.setRgDataExpedicao(consulta.getDate("dataExpedicao"));
                novo.setRgOrgaoExpedidor(consulta.getString("orgaoExpedidor"));
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
    
     public List<Orientador> buscar(Orientador filtro) throws ErroValidacaoException {
        try {
            
            String sql = ""
                    + "SELECT pe.idPessoa,pe.nome,pe.cpf,pe.rg,pe.dataNascimento,pe.orgaoExpedidor,pe.dataExpedicao,pe.status, "
                    + "pe.idCampus,pe.idNacionalidade,pe.idEstado,pe.rua,pe.numero,pe.complemento,pe.bairro,pe.cep, "
                    + "pe.telefoneResidencial,pe.celular,pe.email,pe.idCidade, "
                    + "o.tituloAcademico,o.telefoneRamal,o.localPermanencia,o.matriculaSiape,o.formacaoUniversitaria, "
                    + "o.idOrientador,o.idCurso "
                    + "FROM Orientador o "
                    + "INNER JOIN Pessoa pe ON (pe.idPessoa=o.idPessoa) ";
            String where = "";
            
            if(filtro.getNome().length() > 0){
                where = "pe.nome like '%"+filtro.getNome()+"%' ";
                where = where + " and pe.status=1 order by o.idOrientador ";
            }   

            if(where.length() > 0){
                sql = sql + " where " + where;
            }
            
            if(where.length() == 0){
                where = where + " pe.status=1 order by o.idOrientador ";
                sql = sql + " where " + where;
            }
            
            Statement comando = conexao.getConexao().createStatement();
            
            ResultSet consulta = comando.executeQuery(sql);
     
            List<Orientador> lista = new LinkedList<>();
            while (consulta.next()) {
            
                Orientador novo = new Orientador();
                CursoDAO novoCursoArea = new CursoDAO();
                CampusDAO novoCampus = new CampusDAO();
                CidadeDAO  novoCidade = new CidadeDAO();
                EstadoDAO novoEstado = new EstadoDAO();
                NacionalidadeDAO novoNacionaldiade = new NacionalidadeDAO();
    
                novo.setCpf(consulta.getInt("pe.cpf"));
                novo.setCursoArea(novoCursoArea.Abrir(consulta.getInt("o.idCurso")));
                novo.setDataNascimento(consulta.getDate("pe.dataNascimento"));
                novo.setEmailEndereco(consulta.getString("pe.email"));
                novo.setEnderecoNumero(consulta.getString("pe.numero"));
                novo.setEnderecoBairro(consulta.getString("pe.bairro"));
                novo.setEnderecoCep(consulta.getInt("pe.cep"));
                novo.setEnderecoComplmento(consulta.getString("pe.complemento"));
                novo.setEnderecoRua(consulta.getString("pe.rua"));
                novo.setFormacaoUniversitaria(consulta.getString("o.formacaoUniversitaria"));
                novo.setIdOrientador(Integer.parseInt(consulta.getString("idOrientador")));
                novo.setIdPessoa(consulta.getInt("pe.idPessoa"));
                novo.setLocalPermanencia(consulta.getString("o.localPermanencia"));
                novo.setMatriculaSiape(consulta.getInt("o.matriculaSiape"));
                novo.setNome(consulta.getString("pe.nome"));
                novo.setPessoaCampus(novoCampus.Abrir(consulta.getInt("pe.idCampus")));
                novo.setPessoaCidade(novoCidade.Abrir(consulta.getInt("pe.idCidade")));
                novo.setPessoaEstado(novoEstado.Abrir(consulta.getInt("pe.idEstado")));
                novo.setPessoaNacionalidade(novoNacionaldiade.Abrir(consulta.getInt("pe.idNacionalidade")));
                novo.setRg(consulta.getString("pe.rg"));
                novo.setRgDataExpedicao(consulta.getDate("pe.dataExpedicao"));
                novo.setRgOrgaoExpedidor(consulta.getString("pe.orgaoExpedidor"));
                novo.setTelefoneCelular(consulta.getString("pe.celular"));
                novo.setTelefoneFixo(consulta.getString("pe.telefoneResidencial"));
                novo.setTelefoneRamal(consulta.getString("o.telefoneRamal"));
                novo.setTituloAcademico(consulta.getString("o.tituloAcademico"));
                
                lista.add(novo);
            }
            return lista;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
     }
}
