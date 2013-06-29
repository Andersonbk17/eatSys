/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        Aluno aluno = new Aluno();
        
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
        resultado.first();
        
        aluno.setIdPessoa(resultado.getInt("pe.idPessoa"));
        aluno.setNome(resultado.getString(""));
        aluno.setCpf(resultado.getInt(""));
        aluno.setRg(resultado.getString(""));
        //aluno.setDataNascimento(resultado.getString(""));
        aluno.setRgOrgaoExpedidor(resultado.getString(""));
        //aluno.setRgDataExpedicao(resultado.getString(""));
        
        
        
        return aluno;
    
    }
    
}
