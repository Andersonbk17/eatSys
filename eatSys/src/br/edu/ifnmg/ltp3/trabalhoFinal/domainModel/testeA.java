/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AreaConhecimento_CnpqDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CampusDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CursoAreaDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.OrientadorDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.java2d.loops.CustomComponent;

/**
 *
 * @author lewandowsky
 */
public class testeA {
    public static void main(String args[]) throws SQLException{
        OrientadorDAO dao= new OrientadorDAO();
        Orientador a = new Orientador();
        List<Orientador> lista;
        CursoAreaDAO curso = new CursoAreaDAO();
        CampusDAO campus = new CampusDAO();
        CidadeDAO cidade = new CidadeDAO();
        a.setCpf(111222333);
        
        try {
            a.setCursoArea(curso.Abrir(1));
            a.setEmailEndereco("aaa@aaa");
            a.setEnderecoBairro("fatima");
            a.setEnderecoCep(12356);
            a.setEnderecoComplmento("nenum");
            a.setEnderecoRua("rua 13");
            a.setFormacaoUniversitaria("vagabundo");
            a.setNome("Ronaldo");
            a.setPessoaCampus(campus.Abrir(1));
            a.setPessoaCidade(cidade.Abrir(1));
            
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
           
            lista = dao.ListarTodos();
            //lista.get(0).setUsuario("Ronaldo");
            //dao.Apagar(3);
            System.out.print(dao.Salvar(a));
            System.out.print(dao.Abrir(1));
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
