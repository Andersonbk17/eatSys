/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewandowsky
 */
public class testeA {
    public static void main(String args[]){
        NacionalidadeDAO dao = new NacionalidadeDAO();
        try {
            System.out.print(dao.ListarTodos());
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
