/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AlunoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.OrientadorDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Orientador;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author emerson
 */
public class ifrmAlunoListar extends javax.swing.JInternalFrame {
    
    AlunoDAO dao;
    
    
   
    /**
     * Creates new form frmListarProduto
     */
    public ifrmAlunoListar() throws SQLException {
        initComponents();
        
        List<Aluno> aluno = null;
        dao = new AlunoDAO();
        
        aluno = dao.ListarTodos();

        preencheTabela(aluno);
        

    }
    
    //Metodo para listar Produtos na Tabela tblListagemProd
    private void preencheTabela(List<Aluno> lista) {
       
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("MATRICULA");
        model.addColumn("NOME");
        model.addColumn("RG");
        model.addColumn("CFP");
        model.addColumn("TITULO");
        model.addColumn("CAM");
        model.addColumn("NASCIMENTO");
       

        for (Aluno a : lista) {
            Vector valores = new Vector();
            valores.add(0,a.getIdAluno());
            valores.add(1,a.getMatricula());
            valores.add(2,a.getNome());
            valores.add(3,a.getRg());
            valores.add(4,a.getCpf());
            valores.add(5,a.getTituloEleitoral());
            valores.add(6,a.getCertidaoMilitar());
            valores.add(7,a.getDataNascimento());
           
            model.addRow(valores);
        }
        tblListagemAluno.setModel(model);
        tblListagemAluno.repaint();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeOrientador = new javax.swing.JLabel();
        txtFiltrarA = new javax.swing.JTextField();
        btnFiltrarAluno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemAluno = new javax.swing.JTable();
        jpTituloProdutoListar = new javax.swing.JPanel();
        lblTituloOrientadorListar = new javax.swing.JLabel();
        jpRemoverItemtbEndereco = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1000, 420));

        lblNomeOrientador.setText("Nome");

        btnFiltrarAluno.setText("Filtrar");
        btnFiltrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarAlunoActionPerformed(evt);
            }
        });

        tblListagemAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListagemAluno.setEnabled(false);
        tblListagemAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagemAluno);

        jpTituloProdutoListar.setBackground(new java.awt.Color(102, 204, 0));

        lblTituloOrientadorListar.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        lblTituloOrientadorListar.setText("Aluno");

        javax.swing.GroupLayout jpTituloProdutoListarLayout = new javax.swing.GroupLayout(jpTituloProdutoListar);
        jpTituloProdutoListar.setLayout(jpTituloProdutoListarLayout);
        jpTituloProdutoListarLayout.setHorizontalGroup(
            jpTituloProdutoListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloProdutoListarLayout.createSequentialGroup()
                .addGap(439, 439, 439)
                .addComponent(lblTituloOrientadorListar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTituloProdutoListarLayout.setVerticalGroup(
            jpTituloProdutoListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloProdutoListarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloOrientadorListar)
                .addGap(19, 19, 19))
        );

        jpRemoverItemtbEndereco.setBackground(new java.awt.Color(102, 204, 0));

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel3.setText("Clique sobre algum campo para ver versão FULL ");

        javax.swing.GroupLayout jpRemoverItemtbEnderecoLayout = new javax.swing.GroupLayout(jpRemoverItemtbEndereco);
        jpRemoverItemtbEndereco.setLayout(jpRemoverItemtbEnderecoLayout);
        jpRemoverItemtbEnderecoLayout.setHorizontalGroup(
            jpRemoverItemtbEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRemoverItemtbEnderecoLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel3)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        jpRemoverItemtbEnderecoLayout.setVerticalGroup(
            jpRemoverItemtbEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRemoverItemtbEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTituloProdutoListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNomeOrientador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrarAluno)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpRemoverItemtbEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTituloProdutoListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltrarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeOrientador)
                    .addComponent(btnFiltrarAluno))
                .addGap(18, 18, 18)
                .addComponent(jpRemoverItemtbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarAlunoActionPerformed
        Aluno al = new Aluno();
        try {
            al.setNome(txtFiltrarA.getText());
        }catch (Exception ex) {
            System.out.printf("Erro");
        }
        
        List<Aluno> lista = null;
        try {
            lista = dao.buscar(al);
        } catch (Exception ex) {
            System.out.printf("Erro");
        }
        
        preencheTabela(lista);
        
    }//GEN-LAST:event_btnFiltrarAlunoActionPerformed

    private void tblListagemAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemAlunoMouseClicked

        ifrmlistarOrientadorFull janela = new ifrmlistarOrientadorFull();
        add(janela);
        janela.setVisible(true);
        
        this.dispose();
        
        
    }//GEN-LAST:event_tblListagemAlunoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrarAluno;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpRemoverItemtbEndereco;
    private javax.swing.JPanel jpTituloProdutoListar;
    private javax.swing.JLabel lblNomeOrientador;
    private javax.swing.JLabel lblTituloOrientadorListar;
    private javax.swing.JTable tblListagemAluno;
    private javax.swing.JTextField txtFiltrarA;
    // End of variables declaration//GEN-END:variables
}
