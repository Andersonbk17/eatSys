/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AreaConhecimento_CnpqDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CampusDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CursoAreaDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewandowsky
 */
public class testeA {
    public static void main(String args[]){
        AreaConhecimento_CnpqDAO dao = new AreaConhecimento_CnpqDAO();
        Usuario a = new Usuario();
        List<AreaConhecimento_Cnpq> lista;
        //a.setUsuario("Ronaldo");
        //a.setSenha("123456");
        //a.setNivel(1);
        
        
        
        try {
           
            lista = dao.ListarTodos();
            //lista.get(0).setUsuario("Ronaldo");
            //dao.Apagar(3);
            //System.out.print(dao.Salvar(lista.get(0)));
            System.out.print(dao.Abrir(1));
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
