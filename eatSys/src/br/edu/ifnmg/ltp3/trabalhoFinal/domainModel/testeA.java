/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.EstadoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class testeA {
    public static void main(String args[]) throws SQLException{
       
        NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
        Nacionalidade a = nacionalidade.Abrir(1);
        
        Map parameterMap = new HashMap();
        parameterMap.put("nomeCompleto",a.getNome());
        parameterMap.put("campusOndeTrabalha",a.getIdNacionalidade());
        String caminho = "../reports/Orientador.jasper";
        
       // JasperReport jasperReport = (JasperReport) JRLoader.loadObject(caminho);
        
        
        CidadeDAO dao = new CidadeDAO();
        List<Cidade> lista;
        
        lista = dao.ListarTodos();
        
        System.out.print(lista);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* OrientadorDAO dao= new OrientadorDAO();
        Orientador a = new Orientador();
        List<Orientador> lista;
        CursoAreaDAO curso = new CursoAreaDAO();
        CampusDAO campus = new CampusDAO();
        CidadeDAO cidade = new CidadeDAO();
        NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
        EstadoDAO estado = new EstadoDAO();
       // Pr
        //CursoAreaDAO curso = new CursoAreaDAO();
        
        
        try {
            a.setCursoArea(curso.Abrir(1));
            a.setCpf(111222333);
            a.setEmailEndereco("aaa@aaa");
            a.setEnderecoBairro("fatima");
            a.setEnderecoCep(12356);
            a.setEnderecoComplmento("nenum");
            a.setEnderecoRua("rua 13");
            a.setFormacaoUniversitaria("vagabundo");
            a.setNome("novo");
            a.setPessoaCampus(campus.Abrir(3));
            a.setPessoaCidade(cidade.Abrir(1));
            a.setPessoaNacionalidade(nacionalidade.Abrir(10));
            a.setPessoaEstado(estado.Abrir(12));
            a.setCursoArea(curso.Abrir(3));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
           
            lista = dao.ListarTodos();
            //lista.get(0).setUsuario("Ronaldo");
            //dao.Apagar(3);
            //System.out.print(dao.Salvar(a));
            System.out.print(lista);
        } catch (SQLException ex) {
            Logger.getLogger(testeA.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    * */
    }    
}
