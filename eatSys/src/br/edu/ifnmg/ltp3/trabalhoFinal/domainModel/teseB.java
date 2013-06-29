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
        Estado e = new Estado();
        List<Aluno> lista;
     
        al.setNome("Emerson");
        al.setCpf(123);
        al.setRg("111");
        al.setRgOrgaoExpedidor("SSP");
        n.setIdNacionalidade(25);
        al.setPessoaNacionalidade(n);
        c.setIdCampus(1);
        e.setIdEstado(5);
        
       
        
        try {
           
            
            lista = dao.ListarTodos();
            //lista.get(0).setUsuario("Ronaldo");
            dao.Salvar(al);
            //dao.Apagar(3);
            System.out.print(dao.Salvar(lista.get(0)));
            System.out.print(dao.Abrir(1));
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
}
