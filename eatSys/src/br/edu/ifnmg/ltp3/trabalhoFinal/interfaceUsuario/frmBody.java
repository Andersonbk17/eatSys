/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class frmBody extends javax.swing.JFrame {

    /**
     * Creates new form frmBody
     */
    public frmBody(Usuario usuarioLogado) {
        this.UsuarioLogado = usuarioLogado;
        initComponents();
        if(usuarioLogado.getNivel() > 1){
            jMenuItemUsuarios.setVisible(false);
            jSeparator1.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmSistema = new javax.swing.JMenu();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuitemSair = new javax.swing.JMenuItem();
        jMenuItemFechar = new javax.swing.JMenuItem();
        jmBodyCadastrar = new javax.swing.JMenu();
        jmiAluno = new javax.swing.JMenuItem();
        jmiOrientador = new javax.swing.JMenuItem();
        jmiPPesquisa = new javax.swing.JMenuItem();
        jmiCampus = new javax.swing.JMenuItem();
        jmiCursoArea = new javax.swing.JMenuItem();
        jmiCurso = new javax.swing.JMenuItem();
        jmiAreaConhecimento = new javax.swing.JMenuItem();
        jmBodyListar = new javax.swing.JMenu();
        jmiListarOrientador = new javax.swing.JMenuItem();
        jmiListarAluno = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmBodyProjetos = new javax.swing.JMenu();
        jmBodyRelarotio = new javax.swing.JMenu();
        jmBodySobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("eatSys Menu Principal");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1224, 760));

        jMenuBar1.setBackground(new java.awt.Color(102, 204, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jmSistema.setText("Sistema");

        jMenuItemUsuarios.setText("Usuários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jmSistema.add(jMenuItemUsuarios);
        jmSistema.add(jSeparator1);

        jMenuitemSair.setText("Sair");
        jMenuitemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuitemSairActionPerformed(evt);
            }
        });
        jmSistema.add(jMenuitemSair);

        jMenuItemFechar.setText("Fechar");
        jMenuItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharActionPerformed(evt);
            }
        });
        jmSistema.add(jMenuItemFechar);

        jMenuBar1.add(jmSistema);

        jmBodyCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        jmBodyCadastrar.setText("Cadastrar");

        jmiAluno.setText("Aluno");
        jmiAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlunoActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiAluno);

        jmiOrientador.setText("Orientador");
        jmiOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOrientadorActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiOrientador);

        jmiPPesquisa.setText("Projeto Pesquisa");
        jmiPPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPPesquisaActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiPPesquisa);

        jmiCampus.setText("Campus");
        jmiCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCampusActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiCampus);

        jmiCursoArea.setText("Curso/Area");
        jmiCursoArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCursoAreaActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiCursoArea);

        jmiCurso.setText("Curso");
        jmiCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCursoActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiCurso);

        jmiAreaConhecimento.setText("Area Conhecimento");
        jmiAreaConhecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAreaConhecimentoActionPerformed(evt);
            }
        });
        jmBodyCadastrar.add(jmiAreaConhecimento);

        jMenuBar1.add(jmBodyCadastrar);

        jmBodyListar.setForeground(new java.awt.Color(0, 0, 0));
        jmBodyListar.setText("Listar");

        jmiListarOrientador.setText("Orientador");
        jmiListarOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarOrientadorActionPerformed(evt);
            }
        });
        jmBodyListar.add(jmiListarOrientador);

        jmiListarAluno.setText("Aluno");
        jmiListarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarAlunoActionPerformed(evt);
            }
        });
        jmBodyListar.add(jmiListarAluno);

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmBodyListar.add(jMenuItem1);

        jMenuBar1.add(jmBodyListar);

        jmBodyProjetos.setForeground(new java.awt.Color(0, 0, 0));
        jmBodyProjetos.setText("Projetos");
        jMenuBar1.add(jmBodyProjetos);

        jmBodyRelarotio.setForeground(new java.awt.Color(0, 0, 0));
        jmBodyRelarotio.setText("Relatorios");
        jMenuBar1.add(jmBodyRelarotio);

        jmBodySobre.setForeground(new java.awt.Color(0, 0, 0));
        jmBodySobre.setText("Sobre");
        jMenuBar1.add(jmBodySobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlunoActionPerformed
       
            ifrmAlunoCad janela = new ifrmAlunoCad();
            add(janela);
            janela.setVisible(true);
       

    }//GEN-LAST:event_jmiAlunoActionPerformed

    private void jmiPPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPPesquisaActionPerformed
        try {
            // TODO add your handling code here:
            ifrmProjetoPesquisaCad janela = new ifrmProjetoPesquisaCad();
            add(janela);
            janela.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmBody.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmiPPesquisaActionPerformed

    private void jmiOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOrientadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiOrientadorActionPerformed

    private void jmiCursoAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCursoAreaActionPerformed
        try {
            // TODO add your handling code here:
            ifrmCursoAreaCad janela = new ifrmCursoAreaCad();
            add(janela);
            janela.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmBody.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jmiCursoAreaActionPerformed

    private void jmiCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCampusActionPerformed
        try {
            // TODO add your handling code here:
            ifrmCampusCad janela = new ifrmCampusCad();
            add(janela);
            janela.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmBody.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jmiCampusActionPerformed

    private void jmiAreaConhecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAreaConhecimentoActionPerformed
        // TODO add your handling code here:
        ifrmAreaConhecimentoCad janela = new ifrmAreaConhecimentoCad();
        add(janela);
        janela.setVisible(true);
        
        
    }//GEN-LAST:event_jmiAreaConhecimentoActionPerformed

    private void jmiListarOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarOrientadorActionPerformed
     
    }//GEN-LAST:event_jmiListarOrientadorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuitemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuitemSairActionPerformed
        this.dispose();
        frmLogin janela = new frmLogin();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuitemSairActionPerformed

    private void jMenuItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemFecharActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        frmCadastroUsuario janela = new frmCadastroUsuario();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jmiCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCursoActionPerformed
        try {
            // TODO add your handling code here:
            ifrmCursoCad janela = new ifrmCursoCad();
            add(janela);
            janela.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmBody.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmiCursoActionPerformed

    private void jmiListarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarAlunoActionPerformed
        try {
            // TODO add your handling code here:
            ifrmAlunoListar janela = new ifrmAlunoListar();
            add(janela);
            janela.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmBody.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmiListarAlunoActionPerformed
    private Usuario UsuarioLogado; 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemFechar;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenuItem jMenuitemSair;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jmBodyCadastrar;
    private javax.swing.JMenu jmBodyListar;
    private javax.swing.JMenu jmBodyProjetos;
    private javax.swing.JMenu jmBodyRelarotio;
    private javax.swing.JMenu jmBodySobre;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JMenuItem jmiAluno;
    private javax.swing.JMenuItem jmiAreaConhecimento;
    private javax.swing.JMenuItem jmiCampus;
    private javax.swing.JMenuItem jmiCurso;
    private javax.swing.JMenuItem jmiCursoArea;
    private javax.swing.JMenuItem jmiListarAluno;
    private javax.swing.JMenuItem jmiListarOrientador;
    private javax.swing.JMenuItem jmiOrientador;
    private javax.swing.JMenuItem jmiPPesquisa;
    // End of variables declaration//GEN-END:variables
}
