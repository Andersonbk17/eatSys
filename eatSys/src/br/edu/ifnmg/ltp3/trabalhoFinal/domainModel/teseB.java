/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AlunoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AreaConhecimento_CnpqDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emerson
 */
public class teseB {
    public static void main(String args[]) throws SQLException{
        Aluno al = new Aluno();
        AlunoDAO dao = new AlunoDAO();
        Nacionalidade n = new Nacionalidade();
        Campus c = new Campus();
        Cidade ci = new Cidade();
        CursoArea ca= new CursoArea();
        Estado e = new Estado();
        List<Aluno> lista;
     
        al.setNome("Emerson");
        al.setCpf(123);
        al.setRg("111");
        al.setRgOrgaoExpedidor("SSP");
        n.setIdNacionalidade(25);
        al.setPessoaNacionalidade(n);
        c.setIdCampus(3);
        al.setPessoaCampus(c);
        e.setIdEstado(5);
        al.setPessoaEstado(e);
        ci.setIdCidade(25);
        al.setPessoaCidade(ci);
       
        ca.setIdCursoArea(1);
        al.setAlunoCurso(ca);
        
        
       
        
        try {
           
            
            lista = dao.ListarTodos();
            //lista.get(0).setUsuario("Ronaldo");
            dao.Salvar(al);
            lista = dao.ListarTodos();
            //dao.Apagar(3);
            System.out.print(lista);
            System.out.print(dao.Abrir(4));
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
}
