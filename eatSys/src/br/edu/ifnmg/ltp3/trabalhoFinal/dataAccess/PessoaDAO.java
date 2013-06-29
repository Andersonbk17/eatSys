/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emerson
 */
public class PessoaDAO {
    ConexaoBanco conexao;
    
    public PessoaDAO() throws SQLException{
        conexao = new ConexaoBanco();
    }
    
    //Função para pegar chave estrangeira
    public int ChaveEstrangeira(int Cpf) throws SQLException{
         
         //Aqui estou fazendo uma consulta de Pessoa(idPessoa) atravez do cpf, se e somente se cpf for igual a obj.getCpf
         PreparedStatement comandoConsulta = conexao.getConexao().prepareStatement(""
                 + "SELECT pe.idPessoa FROM Pessoa pe "
                 + "INNER JOIN Aluno al ON (pe.idPessoa = al.idPessoa) "
                 + "WHERE pe.cpf = ? ");
         comandoConsulta.setInt(1,Cpf); 
         ResultSet resultado = comandoConsulta.executeQuery();
         resultado.first();
                
         //Aqui criei uma variavel do tipo inteiro para armazenar o valor da consulta Pessoa(idPessoa)
         int aux;
         aux = resultado.getInt("pe.idPessoa");
                  
         return aux;
    }
    
    public boolean SalvarPessoa(Pessoa obj) throws SQLException{
        try{
            if(obj.getIdPessoa() == 0){
                PreparedStatement comando = conexao.getConexao().prepareStatement(""
                        + "INSERT INTO Pessoa(nome,cpf,rg,dataNascimento,orgaoExpedidor,dataExpedicao,status, "
                        + "idCampus,idNacionalidade,idEstado,rua,numero,complemento,bairro,cep, "
                        + "telefoneResidencial,celular,email,idCidade) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getCpf());
                comando.setString(3, obj.getRg());

                java.sql.Date dataNascimento = new java.sql.Date(obj.getDataNascimento().getTime());
                comando.setDate(4,dataNascimento);

                comando.setString(5, obj.getRgOrgaoExpedidor());

                java.sql.Date dataExpedicao = new java.sql.Date(obj.getRgDataExpedicao().getTime());
                comando.setDate(6,dataExpedicao);

                comando.setInt(7, 1);
                comando.setInt(8, obj.getPessoaCampus().getIdCampus());
                comando.setInt(9, obj.getPessoaNacionalidade().getIdNacionalidade());
                comando.setInt(10, obj.getPessoaEstado().getIdEstado());
                comando.setString(11, obj.getEnderecoRua());
                comando.setString(12, obj.getEnderecoNumero());
                comando.setString(13, obj.getEnderecoComplmento());
                comando.setString(14, obj.getEnderecoBairro());
                comando.setInt(15, obj.getEnderecoCep());
                comando.setString(16, obj.getTelefoneFixo());
                comando.setString(17, obj.getTelefoneCelular());
                comando.setString(18, obj.getEmailEndereco());
                comando.setInt(19, obj.getPessoaCidade().getIdCidade());

                comando.execute();

            }else{
                 PreparedStatement comando = conexao.getConexao().prepareStatement(""
                         + "UPDATE Pessoa SET nome = ?,cpf = ?,rg = ?,dataNascimento = ?,orgaoExpedidor = ?, "
                         + "dataExpedicao = ?,status = ?,idCampus = ?,idNacionalidade = ?,idEstado = ?,rua = ?, "
                         + "numero = ?,complemento = ?,bairro = ?,cep = ?,telefoneResidencial = ?,celular = ?, "
                         + "email = ?,idCidade = ? "
                         + "WHERE idPessoa = ?");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getCpf());
                comando.setString(3, obj.getRg());

                java.sql.Date dataNascimento = new java.sql.Date(obj.getDataNascimento().getTime());
                comando.setDate(4,dataNascimento);

                comando.setString(5, obj.getRgOrgaoExpedidor());

                java.sql.Date dataExpedicao = new java.sql.Date(obj.getRgDataExpedicao().getTime());
                comando.setDate(6,dataExpedicao);

                comando.setInt(7, 1);
                comando.setInt(8, obj.getPessoaCampus().getIdCampus());
                comando.setInt(9, obj.getPessoaNacionalidade().getIdNacionalidade());
                comando.setInt(10, obj.getPessoaEstado().getIdEstado());
                comando.setString(11, obj.getEnderecoRua());
                comando.setString(12, obj.getEnderecoNumero());
                comando.setString(13, obj.getEnderecoComplmento());
                comando.setString(14, obj.getEnderecoBairro());
                comando.setInt(15, obj.getEnderecoCep());
                comando.setString(16, obj.getTelefoneFixo());
                comando.setString(17, obj.getTelefoneCelular());
                comando.setString(18, obj.getEmailEndereco());
                comando.setInt(19, obj.getPessoaCidade().getIdCidade());
                comando.setInt(20, obj.getIdPessoa());

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
    
     public boolean Apagar(int idPessoa) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("UPDATE Pessoa SET status = 0 "
                    + "WHERE idPessoa = ?");
            comando.setInt(1, idPessoa);
            
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
