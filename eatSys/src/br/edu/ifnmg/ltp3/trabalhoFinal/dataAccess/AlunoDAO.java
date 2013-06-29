/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Nacionalidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author emerson
 */
public class AlunoDAO {
    ConexaoBanco conexao;
    
    public AlunoDAO() throws SQLException{
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Aluno obj) throws SQLException{
        PessoaDAO pessoaDAO = new PessoaDAO();
        try{
            if(obj.getIdAluno() == 0){
                pessoaDAO.SalvarPessoa(obj);

                PreparedStatement comando = conexao.getConexao().prepareStatement(""
                        + "INSERT INTO Aluno(tituloEleitor,secaoEleitoral,zonaEleitoral,situacaoMilitar,certidaoMilitar,idPessoa, "
                        + "status,matricula,idCurso,nomeResponsavel,rgResponsavel,orgaoExpeditorResponsavel,cpfResponsavel,nomeMae, "
                        + "orgaoExpeditor,rgMae,cpfMae,localTrabalho,telefoneLocalTrabalho) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getTituloEleitoral());
                comando.setString(2, obj.getSecaoEleitoral());
                comando.setString(3, obj.getZonaEleitoral());
                comando.setString(4, obj.getSituacaoMilitar());
                comando.setString(5, obj.getCertidaoMilitar());
                comando.setInt(6, pessoaDAO.ChaveEstrangeira(obj.getCpf()));
                comando.setInt(7, 1);
                comando.setInt(8, obj.getMatricula());
                comando.setInt(9, obj.getAlunoCurso().getIdCursoArea());
                comando.setString(10, obj.getNomePai());
                comando.setString(11,obj.getRgPai());
                comando.setString(12, obj.getOrgaoExpedidorPai());
                comando.setInt(13, obj.getCpfPai());
                comando.setString(14, obj.getNomeMae());
                comando.setString(15,obj.getRgMae());
                comando.setString(16, obj.getOrgaoExpedidorMae());
                comando.setInt(17, obj.getCpfMae());
                comando.setString(18, obj.getLocalTrabalho());
                comando.setString(19, obj.getTelefoneLocalTrabalho());

                comando.execute();
                
            }else{
                pessoaDAO.SalvarPessoa(obj);

                PreparedStatement comando = conexao.getConexao().prepareStatement(""
                        + "UPDATE Aluno SET tituloEleitor = ?,secaoEleitoral = ?,zonaEleitoral = ?,situacaoMilitar = ?,certidaoMilitar = ?,"
                        + "matricula = ?,idCurso = ?,nomeResponsavel = ?,rgResponsavel = ?,orgaoExpeditorResponsavel = ?,cpfResponsavel = ?,"
                        + "nomeMae = ?,orgaoExpeditor = ?,rgMae = ?,cpfMae = ?,localTrabalho = ?,telefoneLocalTrabalho = ? "
                        + "WHERE idAluno = ? ");
                comando.setString(1, obj.getTituloEleitoral());
                comando.setString(2, obj.getSecaoEleitoral());
                comando.setString(3, obj.getZonaEleitoral());
                comando.setString(4, obj.getSituacaoMilitar());
                comando.setString(5, obj.getCertidaoMilitar());
                comando.setInt(6, obj.getMatricula());
                comando.setInt(7, obj.getAlunoCurso().getIdCursoArea());
                comando.setString(8, obj.getNomePai());
                comando.setString(9,obj.getRgPai());
                comando.setString(10, obj.getOrgaoExpedidorPai());
                comando.setInt(11, obj.getCpfPai());
                comando.setString(12, obj.getNomeMae());
                comando.setString(13,obj.getRgMae());
                comando.setString(14, obj.getOrgaoExpedidorMae());
                comando.setInt(15, obj.getCpfMae());
                comando.setString(16, obj.getLocalTrabalho());
                comando.setString(17, obj.getTelefoneLocalTrabalho());
                comando.setInt(18, obj.getIdAluno());

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
    
    public Aluno Abrir(int idAluno) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                     + "SELECT pe.idPessoa,pe.nome,pe.cpf,pe.rg,pe.dataNascimento,pe.orgaoExpedidor,pe.dataExpedicao,pe.status, "
                     + "pe.idCampus,pe.idNacionalidade,pe.idEstado,pe.rua,pe.numero,pe.complemento,pe.bairro,pe.cep, "
                     + "pe.telefoneResidencial,pe.celular,pe.email,pe.idCidade, "
                     + "al.idAluno,al.tituloEleitor,al.secaoEleitoral,al.zonaEleitoral,al.situacaoMilitar,al.certidaoMilitar, "
                     + "al.status,al.matricula,al.idCurso,al.nomeResponsavel,al.rgResponsavel,al.orgaoExpeditorResponsavel,al.cpfResponsavel,al.nomeMae, "
                     + "al.orgaoExpeditor,al.rgMae,al.cpfMae,al.localTrabalho,al.telefoneLocalTrabalho "
                     + "FROM Pessoa pe "
                     + "INNER JOIN Aluno al ON (pe.idPessoa = al.idPessoa)"
                     + "WHERE al.idAluno = ? ");
            comando.setInt(1, idAluno);

            ResultSet resultado = comando.executeQuery();
            Aluno aluno = new Aluno();
            
            if(resultado.first()){
                CampusDAO campus = new CampusDAO();
                NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
                EstadoDAO estado = new EstadoDAO();
                CidadeDAO cidade = new CidadeDAO();
                CursoAreaDAO curso = new CursoAreaDAO();

                aluno.setIdPessoa(resultado.getInt("pe.idPessoa"));
                aluno.setNome(resultado.getString("pe.nome"));
                aluno.setCpf(resultado.getInt("pe.cpf"));
                aluno.setRg(resultado.getString("pe.rg"));
                aluno.setDataNascimento(resultado.getDate("pe.dataNascimento"));
                aluno.setRgOrgaoExpedidor(resultado.getString("pe.orgaoExpeditor"));
                aluno.setRgDataExpedicao(resultado.getDate("pe.dataExpedicao"));
                aluno.setPessoaCampus(campus.Abrir(resultado.getInt("pe.idCampus")));
                aluno.setPessoaNacionalidade(nacionalidade.Abrir(resultado.getInt("pe.idNacionalidade")));
                aluno.setPessoaEstado(estado.Abrir(resultado.getInt("pe.idEstado")));
                aluno.setEnderecoRua(resultado.getString("pe.rua"));
                aluno.setEnderecoNumero(resultado.getString("pe.numero"));
                aluno.setEnderecoComplmento(resultado.getString("pe.complemento"));
                aluno.setEnderecoBairro(resultado.getString("pe.bairro"));
                aluno.setEnderecoCep(resultado.getInt("pe.cep"));
                aluno.setEnderecoRua(resultado.getString("pe.telefoneResidencial"));
                aluno.setEnderecoRua(resultado.getString("pe.celular"));
                aluno.setEnderecoRua(resultado.getString("pe.email"));
                aluno.setPessoaCidade(cidade.Abrir(resultado.getInt("pe.cidade")));
                aluno.setIdAluno(resultado.getInt("al.idAluno"));
                aluno.setTituloEleitoral(resultado.getString("al.tituloEleitoral"));
                aluno.setSecaoEleitoral(resultado.getString("al.secaoEleitoral"));
                aluno.setZonaEleitoral(resultado.getString("al.zonaEleitoral"));
                aluno.setSituacaoMilitar(resultado.getString("al.situacaoMilitar"));
                aluno.setCertidaoMilitar(resultado.getString("al.certidaoMilitar"));
                aluno.setMatricula(resultado.getInt("al.matricula"));
                aluno.setAlunoCurso(curso.Abrir(resultado.getInt("al.idCurso")));
                aluno.setNomePai(resultado.getString("al.nomeResponsavel"));
                aluno.setRgPai(resultado.getString("al.rgResponsavel"));
                aluno.setOrgaoExpedidorPai(resultado.getString("al.orgaoExpeditorResponsavel"));
                aluno.setCpfPai(resultado.getInt("al.cpfResponsavel"));
                aluno.setNomePai(resultado.getString("al.nomeMae"));
                aluno.setRgPai(resultado.getString("al.rgMae"));
                aluno.setOrgaoExpedidorPai(resultado.getString("al.orgaoExpeditor"));
                aluno.setCpfPai(resultado.getInt("al.cpfMae"));
                aluno.setLocalTrabalho(resultado.getString("al.localTrabalho"));
                aluno.setTelefoneLocalTrabalho(resultado.getString("al.telefoneLocalTrabalho"));
            }
            return aluno;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    }
    
     public List<Aluno> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                     + "SELECT pe.idPessoa,pe.nome,pe.cpf,pe.rg,pe.dataNascimento,pe.orgaoExpedidor,pe.dataExpedicao,pe.status, "
                     + "pe.idCampus,pe.idNacionalidade,pe.idEstado,pe.rua,pe.numero,pe.complemento,pe.bairro,pe.cep, "
                     + "pe.telefoneResidencial,pe.celular,pe.email,pe.idCidade, "
                     + "al.idAluno,al.tituloEleitor,al.secaoEleitoral,al.zonaEleitoral,al.situacaoMilitar,al.certidaoMilitar, "
                     + "al.status,al.matricula,al.idCurso,al.nomeResponsavel,al.rgResponsavel,al.orgaoExpeditorResponsavel,al.cpfResponsavel,al.nomeMae, "
                     + "al.orgaoExpeditor,al.rgMae,al.cpfMae,al.localTrabalho,al.telefoneLocalTrabalho "
                     + "FROM Pessoa pe "
                     + "INNER JOIN Aluno al ON (pe.idPessoa = al.idPessoa)"
                     + "WHERE al.status = 1");

            ResultSet resultado = comando.executeQuery();
            List<Aluno> lista = new LinkedList<> ();
            
            while(resultado.next()){
                Aluno aluno = new Aluno();
                CampusDAO campus = new CampusDAO();
                NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
                EstadoDAO estado = new EstadoDAO();
                CidadeDAO cidade = new CidadeDAO();
                CursoAreaDAO curso = new CursoAreaDAO();

                aluno.setIdPessoa(resultado.getInt("pe.idPessoa"));
                aluno.setNome(resultado.getString("pe.nome"));
                aluno.setCpf(resultado.getInt("pe.cpf"));
                aluno.setRg(resultado.getString("pe.rg"));
                aluno.setDataNascimento(resultado.getDate("pe.dataNascimento"));
                aluno.setRgOrgaoExpedidor(resultado.getString("pe.orgaoExpeditor"));
                aluno.setRgDataExpedicao(resultado.getDate("pe.dataExpedicao"));
                aluno.setPessoaCampus(campus.Abrir(resultado.getInt("pe.idCampus")));
                aluno.setPessoaNacionalidade(nacionalidade.Abrir(resultado.getInt("pe.idNacionalidade")));
                aluno.setPessoaEstado(estado.Abrir(resultado.getInt("pe.idEstado")));
                aluno.setEnderecoRua(resultado.getString("pe.rua"));
                aluno.setEnderecoNumero(resultado.getString("pe.numero"));
                aluno.setEnderecoComplmento(resultado.getString("pe.complemento"));
                aluno.setEnderecoBairro(resultado.getString("pe.bairro"));
                aluno.setEnderecoCep(resultado.getInt("pe.cep"));
                aluno.setEnderecoRua(resultado.getString("pe.telefoneResidencial"));
                aluno.setEnderecoRua(resultado.getString("pe.celular"));
                aluno.setEnderecoRua(resultado.getString("pe.email"));
                aluno.setPessoaCidade(cidade.Abrir(resultado.getInt("pe.cidade")));
                aluno.setIdAluno(resultado.getInt("al.idAluno"));
                aluno.setTituloEleitoral(resultado.getString("al.tituloEleitoral"));
                aluno.setSecaoEleitoral(resultado.getString("al.secaoEleitoral"));
                aluno.setZonaEleitoral(resultado.getString("al.zonaEleitoral"));
                aluno.setSituacaoMilitar(resultado.getString("al.situacaoMilitar"));
                aluno.setCertidaoMilitar(resultado.getString("al.certidaoMilitar"));
                aluno.setMatricula(resultado.getInt("al.matricula"));
                aluno.setAlunoCurso(curso.Abrir(resultado.getInt("al.idCurso")));
                aluno.setNomePai(resultado.getString("al.nomeResponsavel"));
                aluno.setRgPai(resultado.getString("al.rgResponsavel"));
                aluno.setOrgaoExpedidorPai(resultado.getString("al.orgaoExpeditorResponsavel"));
                aluno.setCpfPai(resultado.getInt("al.cpfResponsavel"));
                aluno.setNomePai(resultado.getString("al.nomeMae"));
                aluno.setRgPai(resultado.getString("al.rgMae"));
                aluno.setOrgaoExpedidorPai(resultado.getString("al.orgaoExpeditor"));
                aluno.setCpfPai(resultado.getInt("al.cpfMae"));
                aluno.setLocalTrabalho(resultado.getString("al.localTrabalho"));
                aluno.setTelefoneLocalTrabalho(resultado.getString("al.telefoneLocalTrabalho"));
                
                lista.add(aluno);
                
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
