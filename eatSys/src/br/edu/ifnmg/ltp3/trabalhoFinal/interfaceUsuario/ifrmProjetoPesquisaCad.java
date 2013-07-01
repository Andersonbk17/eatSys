/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AlunoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AreaConhecimento_CnpqDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AreaConhecimento_CnpqSubAreasDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CampusDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.OrientadorDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.ParticipanteProjetoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.ProjetoPesquisaDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.AreaConhecimento_Cnpq;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.AreaConhecimento_CnpqSubAreas;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Orientador;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ParticipanteProjeto;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ProjetoPesquisa;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emerson
 */
public class ifrmProjetoPesquisaCad extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmCampusCad
     */
    
    /*########################## Funcoes #########################################3#*/
    private void carregacbxCampus(){
        CampusDAO daoCampus = new CampusDAO();
        try {
            
            
            for(Campus c : daoCampus.ListarTodos()) {
                jcbProjetoPesquisaCampus.addItem(c);
                jcbProjetoPesquisaCampusPartici.addItem(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ifrmProjetoPesquisaCad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os Campus");
            
        }
    }
    
    private void carregacbxOrientador() {
        OrientadorDAO daoOrientador = new OrientadorDAO();
        try {
            for(Orientador o : daoOrientador.ListarTodos()){
                jcbProjetoPesquisaOrientador.addItem(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ifrmProjetoPesquisaCad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os Orientadores");
        }
    
    }
    
    private void carregaCbxAluno(){
       AlunoDAO daoAluno = new AlunoDAO();
        try {
            for(Aluno a : daoAluno.ListarTodos()){
               jcbProjetoPesquisaAluno.addItem(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ifrmProjetoPesquisaCad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void carregaCbxAreasConhecimento(){
        AreaConhecimento_CnpqDAO daoAreasConhecimentoCnpq = new AreaConhecimento_CnpqDAO();
        AreaConhecimento_CnpqSubAreasDAO daoAreasConhecimentoSub= new AreaConhecimento_CnpqSubAreasDAO();
        try {
            for(AreaConhecimento_CnpqSubAreas a : daoAreasConhecimentoSub.ListarTodos()){
                jcbProjetoPesquisaAreaConhecimento.addItem(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ifrmProjetoPesquisaCad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ifrmProjetoPesquisaCad() throws SQLException {
        initComponents();
        
        ocultarFinan(0);
        ocultarConv(0);
        ocultarBolsa(0);
        ocultarGerenciadoFundacao(0);
        
        carregacbxOrientador();
        carregacbxCampus();
        carregaCbxAluno();
        carregaCbxAreasConhecimento();
      
      
    }
    
    private void ocultarFinan(int confirmacao){
        
         if(confirmacao == 1){
         //Reabrir campus
         txtProjetoPesquisaAgenciaFinan.setVisible(true);
         txtValorFinanciamento.setVisible(true);
         txtProjetoPesquisaDataFinan.setVisible(true);
         lblAgenciaFinan.setVisible(true);
         lblValorFinan.setVisible(true);
         lblDataFinan.setVisible(true);
         //setar Null
         txtProjetoPesquisaAgenciaFinan.setText(null);
         txtValorFinanciamento.setText(null);
         txtProjetoPesquisaDataFinan.setText(null);
         }else{
             //esconder campus
         txtProjetoPesquisaAgenciaFinan.setVisible(false);
         txtValorFinanciamento.setVisible(false);
         txtProjetoPesquisaDataFinan.setVisible(false);
         lblAgenciaFinan.setVisible(false);
         lblValorFinan.setVisible(false);
         lblDataFinan.setVisible(false);      
         //setar Null
         txtProjetoPesquisaAgenciaFinan.setText(null);
         txtValorFinanciamento.setText(null);
         txtProjetoPesquisaDataFinan.setText(null);
         }
    }

    private void ocultarConv(int confirmacao){
        if(confirmacao == 1){
            txtQualConvenio.setVisible(true);
            lblConvenioQual.setVisible(true);
            txtQualConvenio.setText(null);
        }else{
            txtQualConvenio.setVisible(false);
            lblConvenioQual.setVisible(false);
            txtQualConvenio.setText(null);
        }
    }
    
    private void ocultarBolsa(int confirmacao){
        if(confirmacao == 1){
            txtNumeroBolsas.setVisible(true);
            lblNumeroBolsas.setVisible(true);
            txtNumeroBolsas.setText(null);
        }else{
            txtNumeroBolsas.setVisible(false);
            lblNumeroBolsas.setVisible(false);
            txtNumeroBolsas.setText(null);
        }
    }
    
    private void ocultarGerenciadoFundacao(int confirmacao){
        if(confirmacao == 1){
            txtQualFundacao.setVisible(true);
            txtQualFundacao.setText(null);
            lblQualFundacao.setVisible(true);
        }else{
            txtQualFundacao.setVisible(false);
            lblQualFundacao.setVisible(false);
            
        }
    }
    
    
    private boolean verificarCampusVazios(){
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        financiomento = new javax.swing.ButtonGroup();
        convenio = new javax.swing.ButtonGroup();
        bolsa = new javax.swing.ButtonGroup();
        grupogerenciadoFundacao = new javax.swing.ButtonGroup();
        multicampi = new javax.swing.ButtonGroup();
        bolsas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbtProjetoPesquisa = new javax.swing.JTabbedPane();
        jPanelGeral = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblGrupoPesquisa = new javax.swing.JLabel();
        txtProjetoPesquisaTitulo = new javax.swing.JTextField();
        lblDataTermino = new javax.swing.JLabel();
        lblDataInicio = new javax.swing.JLabel();
        lblOrientador = new javax.swing.JLabel();
        lblCampus = new javax.swing.JLabel();
        jcbProjetoPesquisaOrientador = new javax.swing.JComboBox();
        jcbProjetoPesquisaCampus = new javax.swing.JComboBox();
        jcbProjetoPesquisaAreaConhecimento = new javax.swing.JComboBox();
        lblAluno = new javax.swing.JLabel();
        jcbProjetoPesquisaAluno = new javax.swing.JComboBox();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataTermino = new javax.swing.JFormattedTextField();
        txtGrupoPesquisa = new javax.swing.JTextField();
        lblAreaPesquisa = new javax.swing.JLabel();
        lblResumo = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtProjetoPesquisaResumo = new javax.swing.JTextArea();
        jPanelConvenio = new javax.swing.JPanel();
        lblConvenioQual = new javax.swing.JLabel();
        txtQualConvenio = new javax.swing.JTextField();
        jrbConvenioSim = new javax.swing.JRadioButton();
        jrbConvenioNao = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        lblGerenciadoFundacao = new javax.swing.JLabel();
        jrbFundacaoSim = new javax.swing.JRadioButton();
        jrbFundacaoNao = new javax.swing.JRadioButton();
        lblQualFundacao = new javax.swing.JLabel();
        txtQualFundacao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jrbMultiCampiSim = new javax.swing.JRadioButton();
        jrbMultiCampiNao = new javax.swing.JRadioButton();
        jPanelFinanciamento = new javax.swing.JPanel();
        lblValorFinan = new javax.swing.JLabel();
        lblDataFinan = new javax.swing.JLabel();
        lblAgenciaFinan = new javax.swing.JLabel();
        txtProjetoPesquisaAgenciaFinan = new javax.swing.JTextField();
        txtProjetoPesquisaDataFinan = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txtProjetoPesquisaDataFinan = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        txtValorFinanciamento = new javax.swing.JTextField();
        jrFinanCon = new javax.swing.JRadioButton();
        jrFinanSub = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jrFinanSim = new javax.swing.JRadioButton();
        jrFinanNao = new javax.swing.JRadioButton();
        lblPossuiBolsas = new javax.swing.JLabel();
        jrbBolsasSim = new javax.swing.JRadioButton();
        jrbBolsasNao = new javax.swing.JRadioButton();
        lblNumeroBolsas = new javax.swing.JLabel();
        txtNumeroBolsas = new javax.swing.JTextField();
        jPanelParticipante = new javax.swing.JPanel();
        txtTitulacao = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtNomeParticipante = new javax.swing.JTextField();
        jcbProjetoPesquisaCampusPartici = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtParticipanteObservacao = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbListaParcicipantesProjetoPesquisa = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnParticipanteAdicionar = new javax.swing.JButton();
        btnParticipanteRemover = new javax.swing.JButton();
        jPanelResumo = new javax.swing.JPanel();
        lblLocalRealizacao = new javax.swing.JLabel();
        txtLocalRealizacao = new javax.swing.JTextField();
        lblprogramaPlano = new javax.swing.JLabel();
        txtProgramaPlanoEnvolvido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIntroducao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtJustificativa = new javax.swing.JTextArea();
        lblJustificativa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblObjetivos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObjetivos = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        lblResultadosEsperados = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtResultadosEsperados = new javax.swing.JTextArea();
        lblReferenciasBibliograficas = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtReferenciasBibliograficas = new javax.swing.JTextArea();
        btnSalvarProjetoPesquisa = new javax.swing.JButton();
        btnCancelarProjetoPesquisa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setPreferredSize(new java.awt.Dimension(1024, 700));

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cadastrar Projeto Pesquisa");

        jPanelGeral.setPreferredSize(new java.awt.Dimension(1000, 670));

        lblTitulo.setText("Titulo");

        lblGrupoPesquisa.setText("Grupo Pesquisa");

        lblDataTermino.setText("Data Término");

        lblDataInicio.setText("Data Inicio");

        lblOrientador.setText("Coordenador");

        lblCampus.setText("Campus");

        jcbProjetoPesquisaOrientador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        jcbProjetoPesquisaCampus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        jcbProjetoPesquisaAreaConhecimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        lblAluno.setText("Aluno");

        jcbProjetoPesquisaAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblAreaPesquisa.setText("Area Conhecimento (CNPq)");

        lblResumo.setText("Resumo");

        txtProjetoPesquisaResumo.setColumns(20);
        txtProjetoPesquisaResumo.setLineWrap(true);
        txtProjetoPesquisaResumo.setRows(5);
        jScrollPane4.setViewportView(txtProjetoPesquisaResumo);

        javax.swing.GroupLayout jPanelGeralLayout = new javax.swing.GroupLayout(jPanelGeral);
        jPanelGeral.setLayout(jPanelGeralLayout);
        jPanelGeralLayout.setHorizontalGroup(
            jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelGeralLayout.createSequentialGroup()
                            .addComponent(lblTitulo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtProjetoPesquisaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelGeralLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelGeralLayout.createSequentialGroup()
                            .addComponent(lblGrupoPesquisa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGrupoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelGeralLayout.createSequentialGroup()
                            .addComponent(lblDataInicio)
                            .addGap(32, 32, 32)
                            .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(lblDataTermino)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeralLayout.createSequentialGroup()
                            .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelGeralLayout.createSequentialGroup()
                                    .addComponent(lblAreaPesquisa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbProjetoPesquisaAreaConhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelGeralLayout.createSequentialGroup()
                                    .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblOrientador)
                                        .addComponent(lblCampus))
                                    .addGap(108, 108, 108)
                                    .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcbProjetoPesquisaCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelGeralLayout.createSequentialGroup()
                                            .addComponent(jcbProjetoPesquisaOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblAluno)))))
                            .addGap(27, 27, 27)
                            .addComponent(jcbProjetoPesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(98, 98, 98)))
                    .addComponent(lblResumo))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanelGeralLayout.setVerticalGroup(
            jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtProjetoPesquisaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicio)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataTermino)
                    .addComponent(txtDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrupoPesquisa)
                    .addComponent(txtGrupoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAreaPesquisa)
                    .addComponent(jcbProjetoPesquisaAreaConhecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrientador)
                    .addComponent(jcbProjetoPesquisaOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbProjetoPesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAluno))
                .addGap(18, 18, 18)
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCampus)
                    .addComponent(jcbProjetoPesquisaCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(lblResumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jbtProjetoPesquisa.addTab("Geral", jPanelGeral);

        lblConvenioQual.setText("Qual?");

        convenio.add(jrbConvenioSim);
        jrbConvenioSim.setText("Sim");
        jrbConvenioSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbConvenioSimActionPerformed(evt);
            }
        });

        convenio.add(jrbConvenioNao);
        jrbConvenioNao.setSelected(true);
        jrbConvenioNao.setText("Não");
        jrbConvenioNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbConvenioNaoActionPerformed(evt);
            }
        });

        jLabel9.setText("O Projeto possui convênio?");

        lblGerenciadoFundacao.setText("O Projeto é gerenciado por alguma fundação ?");

        grupogerenciadoFundacao.add(jrbFundacaoSim);
        jrbFundacaoSim.setText("Sim");
        jrbFundacaoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFundacaoSimActionPerformed(evt);
            }
        });

        grupogerenciadoFundacao.add(jrbFundacaoNao);
        jrbFundacaoNao.setSelected(true);
        jrbFundacaoNao.setText("Não");
        jrbFundacaoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFundacaoNaoActionPerformed(evt);
            }
        });

        lblQualFundacao.setText("Qual?");

        jLabel4.setText("O Projeto é Multicampi?");

        multicampi.add(jrbMultiCampiSim);
        jrbMultiCampiSim.setText("Sim");

        multicampi.add(jrbMultiCampiNao);
        jrbMultiCampiNao.setSelected(true);
        jrbMultiCampiNao.setText("Não");

        javax.swing.GroupLayout jPanelConvenioLayout = new javax.swing.GroupLayout(jPanelConvenio);
        jPanelConvenio.setLayout(jPanelConvenioLayout);
        jPanelConvenioLayout.setHorizontalGroup(
            jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConvenioLayout.createSequentialGroup()
                .addGroup(jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConvenioLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbConvenioSim)
                            .addComponent(jrbConvenioNao)))
                    .addGroup(jPanelConvenioLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelConvenioLayout.createSequentialGroup()
                                .addComponent(lblConvenioQual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQualConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(lblGerenciadoFundacao)
                            .addGroup(jPanelConvenioLayout.createSequentialGroup()
                                .addComponent(lblQualFundacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQualFundacao, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(jPanelConvenioLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbFundacaoNao)
                            .addComponent(jrbFundacaoSim)))
                    .addGroup(jPanelConvenioLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jrbMultiCampiNao)
                            .addComponent(jrbMultiCampiSim))))
                .addContainerGap(539, Short.MAX_VALUE))
        );
        jPanelConvenioLayout.setVerticalGroup(
            jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConvenioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbConvenioSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbConvenioNao)
                .addGap(27, 27, 27)
                .addGroup(jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQualConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConvenioQual))
                .addGap(46, 46, 46)
                .addComponent(lblGerenciadoFundacao)
                .addGap(18, 18, 18)
                .addComponent(jrbFundacaoSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbFundacaoNao)
                .addGap(32, 32, 32)
                .addGroup(jPanelConvenioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQualFundacao)
                    .addComponent(txtQualFundacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jrbMultiCampiSim)
                .addGap(18, 18, 18)
                .addComponent(jrbMultiCampiNao)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jbtProjetoPesquisa.addTab("Convenio/Gestão", jPanelConvenio);

        lblValorFinan.setText("Valor");

        lblDataFinan.setText("Data");

        lblAgenciaFinan.setText("Agência");

        financiomento.add(jrFinanCon);
        jrFinanCon.setText("Conduzido com recursos de outras fontes");
        jrFinanCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrFinanConActionPerformed(evt);
            }
        });

        financiomento.add(jrFinanSub);
        jrFinanSub.setText("Submetido e Arguandando Aprovação");
        jrFinanSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrFinanSubActionPerformed(evt);
            }
        });

        jLabel24.setText("O Projeto é financiado?");

        financiomento.add(jrFinanSim);
        jrFinanSim.setText("Sim");
        jrFinanSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrFinanSimActionPerformed(evt);
            }
        });

        financiomento.add(jrFinanNao);
        jrFinanNao.setSelected(true);
        jrFinanNao.setText("Não");
        jrFinanNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrFinanNaoActionPerformed(evt);
            }
        });

        lblPossuiBolsas.setText("O projeto possui bolsas?");

        bolsas.add(jrbBolsasSim);
        jrbBolsasSim.setText("Sim");
        jrbBolsasSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBolsasSimActionPerformed(evt);
            }
        });

        bolsas.add(jrbBolsasNao);
        jrbBolsasNao.setSelected(true);
        jrbBolsasNao.setText("Não");
        jrbBolsasNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBolsasNaoActionPerformed(evt);
            }
        });

        lblNumeroBolsas.setText("Numero de Bolsas");

        javax.swing.GroupLayout jPanelFinanciamentoLayout = new javax.swing.GroupLayout(jPanelFinanciamento);
        jPanelFinanciamento.setLayout(jPanelFinanciamentoLayout);
        jPanelFinanciamentoLayout.setHorizontalGroup(
            jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFinanciamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbBolsasSim)
                    .addComponent(jLabel24)
                    .addGroup(jPanelFinanciamentoLayout.createSequentialGroup()
                        .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrFinanSim, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrFinanNao)
                            .addComponent(lblAgenciaFinan)
                            .addComponent(lblDataFinan)
                            .addComponent(lblValorFinan))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorFinanciamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProjetoPesquisaDataFinan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProjetoPesquisaAgenciaFinan, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrFinanCon)
                            .addComponent(jrFinanSub)))
                    .addComponent(lblPossuiBolsas)
                    .addComponent(jrbBolsasNao)
                    .addGroup(jPanelFinanciamentoLayout.createSequentialGroup()
                        .addComponent(lblNumeroBolsas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumeroBolsas, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanelFinanciamentoLayout.setVerticalGroup(
            jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFinanciamentoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel24)
                .addGap(26, 26, 26)
                .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrFinanSim)
                    .addComponent(jrFinanSub))
                .addGap(18, 18, 18)
                .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrFinanNao)
                    .addComponent(jrFinanCon))
                .addGap(33, 33, 33)
                .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgenciaFinan)
                    .addComponent(txtProjetoPesquisaAgenciaFinan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataFinan)
                    .addComponent(txtProjetoPesquisaDataFinan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorFinan)
                    .addComponent(txtValorFinanciamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(lblPossuiBolsas)
                .addGap(31, 31, 31)
                .addComponent(jrbBolsasSim)
                .addGap(18, 18, 18)
                .addComponent(jrbBolsasNao)
                .addGap(18, 18, 18)
                .addGroup(jPanelFinanciamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroBolsas)
                    .addComponent(txtNumeroBolsas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jbtProjetoPesquisa.addTab("Financiamento/Iniciação", jPanelFinanciamento);

        jLabel22.setText("Titulação");

        txtNomeParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeParticipanteActionPerformed(evt);
            }
        });

        jcbProjetoPesquisaCampusPartici.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));

        txtParticipanteObservacao.setColumns(20);
        txtParticipanteObservacao.setLineWrap(true);
        txtParticipanteObservacao.setRows(5);
        jScrollPane5.setViewportView(txtParticipanteObservacao);

        jtbListaParcicipantesProjetoPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbListaParcicipantesProjetoPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbListaParcicipantesProjetoPesquisaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtbListaParcicipantesProjetoPesquisa);

        jLabel19.setText("Nome");

        jLabel21.setText("Campus");

        jLabel23.setText("Observação");

        btnParticipanteAdicionar.setText("Adicionar");
        btnParticipanteAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipanteAdicionarActionPerformed(evt);
            }
        });

        btnParticipanteRemover.setText("Remover");
        btnParticipanteRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipanteRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelParticipanteLayout = new javax.swing.GroupLayout(jPanelParticipante);
        jPanelParticipante.setLayout(jPanelParticipanteLayout);
        jPanelParticipanteLayout.setHorizontalGroup(
            jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                                .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbProjetoPesquisaCampusPartici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnParticipanteAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnParticipanteRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelParticipanteLayout.setVerticalGroup(
            jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtNomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jcbProjetoPesquisaCampusPartici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                        .addGroup(jPanelParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelParticipanteLayout.createSequentialGroup()
                        .addComponent(btnParticipanteAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnParticipanteRemover)))
                .addGap(41, 41, 41))
        );

        jbtProjetoPesquisa.addTab("Participantes", jPanelParticipante);

        lblLocalRealizacao.setText("Local Realização");

        lblprogramaPlano.setText("Programa do Plano Envolvido");

        jLabel1.setText("Introdução");

        txtIntroducao.setColumns(20);
        txtIntroducao.setLineWrap(true);
        txtIntroducao.setRows(5);
        jScrollPane1.setViewportView(txtIntroducao);

        txtJustificativa.setColumns(20);
        txtJustificativa.setRows(5);
        jScrollPane2.setViewportView(txtJustificativa);

        lblJustificativa.setText("Justificativa");

        javax.swing.GroupLayout jPanelResumoLayout = new javax.swing.GroupLayout(jPanelResumo);
        jPanelResumo.setLayout(jPanelResumoLayout);
        jPanelResumoLayout.setHorizontalGroup(
            jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResumoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResumoLayout.createSequentialGroup()
                        .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelResumoLayout.createSequentialGroup()
                                .addComponent(lblprogramaPlano)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProgramaPlanoEnvolvido))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelResumoLayout.createSequentialGroup()
                                .addComponent(lblLocalRealizacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLocalRealizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 352, Short.MAX_VALUE))
                    .addGroup(jPanelResumoLayout.createSequentialGroup()
                        .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJustificativa)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanelResumoLayout.setVerticalGroup(
            jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResumoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocalRealizacao)
                    .addComponent(txtLocalRealizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprogramaPlano)
                    .addComponent(txtProgramaPlanoEnvolvido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJustificativa)
                    .addGroup(jPanelResumoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );

        jbtProjetoPesquisa.addTab("Plano de Trabalho do Aluno", jPanelResumo);

        lblObjetivos.setText("Objetivos");

        txtObjetivos.setColumns(20);
        txtObjetivos.setLineWrap(true);
        txtObjetivos.setRows(5);
        jScrollPane3.setViewportView(txtObjetivos);

        jLabel3.setText("Metodologia");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblObjetivos)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                            .addComponent(jScrollPane7)))
                    .addComponent(jLabel3))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObjetivos)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jbtProjetoPesquisa.addTab("cont", jPanel2);

        lblResultadosEsperados.setText("Resultados Esperados");

        txtResultadosEsperados.setColumns(20);
        txtResultadosEsperados.setRows(5);
        jScrollPane8.setViewportView(txtResultadosEsperados);

        lblReferenciasBibliograficas.setText("Referências Bibliográficas");

        txtReferenciasBibliograficas.setColumns(20);
        txtReferenciasBibliograficas.setRows(5);
        jScrollPane9.setViewportView(txtReferenciasBibliograficas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultadosEsperados)
                            .addComponent(lblReferenciasBibliograficas)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblResultadosEsperados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblReferenciasBibliograficas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jbtProjetoPesquisa.addTab("conti", jPanel3);

        btnSalvarProjetoPesquisa.setText("Salvar");
        btnSalvarProjetoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProjetoPesquisaActionPerformed(evt);
            }
        });

        btnCancelarProjetoPesquisa.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jbtProjetoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvarProjetoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarProjetoPesquisa, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btnSalvarProjetoPesquisa)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarProjetoPesquisa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbtProjetoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarProjetoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProjetoPesquisaActionPerformed
        
        
        projetoPesquisa.setAluno((Aluno)jcbProjetoPesquisaAluno.getSelectedItem());
        projetoPesquisa.setAreaConhecimento((AreaConhecimento_CnpqSubAreas)jcbProjetoPesquisaAreaConhecimento.getSelectedItem());//verificaaar
        //projetoPesquisa.setBolsasIniciacao(WIDTH);
        projetoPesquisa.setCampus((Campus)jcbProjetoPesquisaCampus.getSelectedItem());
        projetoPesquisa.setNomeConvenio(txtQualConvenio.getText());
        projetoPesquisa.setFundacaoNome(txtQualFundacao.getText());
        projetoPesquisa.setValorFinanciamento(Float.parseFloat(txtValorFinanciamento.getText()));
        //projetoPesquisa.setDataFinanciamento(null);
        
        projetoPesquisa.setNumeroBolsas(Integer.parseInt(txtNumeroBolsas.getText()));
        projetoPesquisa.setAgenciaFinanciadora(txtProjetoPesquisaAgenciaFinan.getText());
        //projetoPesquisa.setDataInicio(null);
        //projetoPesquisa.setDataTermino(null);
        projetoPesquisa.setGrupoPesquisa(txtGrupoPesquisa.getText());
        projetoPesquisa.setListaParticipantes(listaParticipantes);
        projetoPesquisa.setOrientador((Orientador)jcbProjetoPesquisaOrientador.getSelectedItem());
        projetoPesquisa.setResumo(txtProjetoPesquisaResumo.getText());
        
        ProjetoPesquisaDAO dao = new ProjetoPesquisaDAO();
        try {
            if(dao.Salvar(projetoPesquisa)){
                JOptionPane.showMessageDialog(rootPane, "Projeto Salvo com sucesso !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ifrmProjetoPesquisaCad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar os dados");
        }
        
    }//GEN-LAST:event_btnSalvarProjetoPesquisaActionPerformed

    private void jrFinanNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrFinanNaoActionPerformed

        projetoPesquisa.setFinanciamentoAprovado(2);
        ocultarFinan(0);
    }//GEN-LAST:event_jrFinanNaoActionPerformed

    private void jrFinanSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrFinanSimActionPerformed

        projetoPesquisa.setFinanciamentoAprovado(1);
        ocultarFinan(1);
    }//GEN-LAST:event_jrFinanSimActionPerformed

    private void jrFinanSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrFinanSubActionPerformed

        projetoPesquisa.setFinanciamentoAprovado(3);
        ocultarFinan(1);
    }//GEN-LAST:event_jrFinanSubActionPerformed

    private void jrFinanConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrFinanConActionPerformed
        projetoPesquisa.setFinanciamentoAprovado(4);
        ocultarFinan(1);
    }//GEN-LAST:event_jrFinanConActionPerformed

    private void jrbFundacaoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFundacaoNaoActionPerformed
        ocultarGerenciadoFundacao(0);
        projetoPesquisa.setFuncadao(2);
    }//GEN-LAST:event_jrbFundacaoNaoActionPerformed

    private void jrbFundacaoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFundacaoSimActionPerformed
        projetoPesquisa.setFuncadao(1);
        ocultarGerenciadoFundacao(1);
    }//GEN-LAST:event_jrbFundacaoSimActionPerformed

    private void jrbConvenioNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbConvenioNaoActionPerformed
        projetoPesquisa.setConvenio(2);
        ocultarConv(0);
    }//GEN-LAST:event_jrbConvenioNaoActionPerformed

    private void jrbConvenioSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbConvenioSimActionPerformed
        projetoPesquisa.setConvenio(1);
        ocultarConv(1);
    }//GEN-LAST:event_jrbConvenioSimActionPerformed

    private void jrbBolsasSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBolsasSimActionPerformed
       projetoPesquisa.setBolsasIniciacao(1);
       ocultarBolsa(1);
    }//GEN-LAST:event_jrbBolsasSimActionPerformed

    private void jrbBolsasNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBolsasNaoActionPerformed
       projetoPesquisa.setBolsasIniciacao(2);
       ocultarBolsa(0);
    }//GEN-LAST:event_jrbBolsasNaoActionPerformed

    private void txtNomeParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeParticipanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeParticipanteActionPerformed

    private void btnParticipanteAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipanteAdicionarActionPerformed
        if(!txtNomeParticipante.getText().isEmpty() && jcbProjetoPesquisaCampusPartici.getSelectedIndex() != 0){
            ParticipanteProjeto participanteProjeto = new ParticipanteProjeto();
            
            participanteProjeto.setCampus((Campus)jcbProjetoPesquisaCampusPartici.getSelectedItem());
            participanteProjeto.setNome(txtNomeParticipante.getText());
            participanteProjeto.setObservacao(txtParticipanteObservacao.getText());
            participanteProjeto.setTitulacao(txtTitulacao.getText());
            
            //projetoPesquisa.addParticipante(participanteProjeto);
            
            txtNomeParticipante.setText("");
            txtParticipanteObservacao.setText("");
            txtTitulacao.setText("");
            jcbProjetoPesquisaCampusPartici.setSelectedIndex(0);
            listaParticipantes.add(participanteProjeto);
            carregaListaParticipantes();
            
        }
        
    
        
        
        
    }//GEN-LAST:event_btnParticipanteAdicionarActionPerformed

    private void btnParticipanteRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipanteRemoverActionPerformed
       if(JOptionPane.showConfirmDialog(rootPane,"Você tem certeza que deseja remover o item ?") == 0){
          listaParticipantes.remove(tmpParticipante);
          carregaListaParticipantes();
       }
    }//GEN-LAST:event_btnParticipanteRemoverActionPerformed

    private void jtbListaParcicipantesProjetoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbListaParcicipantesProjetoPesquisaMouseClicked
       tmpParticipante = jtbListaParcicipantesProjetoPesquisa.getSelectedRow();
        
    }//GEN-LAST:event_jtbListaParcicipantesProjetoPesquisaMouseClicked
    private void carregaListaParticipantes(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Titulação");
        model.addColumn("Instituição/Campus");
        model.addColumn("Observação");
        
     
        for (ParticipanteProjeto c : listaParticipantes) {
            Vector valores = new Vector();
            valores.add(0,c.getNome());
            valores.add(1,c.getTitulacao());
            valores.add(2,c.getCampus().getNome());
            valores.add(3,c.getObservacao());
     
            model.addRow(valores);
        }
        jtbListaParcicipantesProjetoPesquisa.setModel(model);
        jtbListaParcicipantesProjetoPesquisa.repaint();
    }
    
    private void remover(ParticipanteProjeto p){
        listaParticipantes.remove(p);
        carregaListaParticipantes();
    }
    int tmpParticipante;
    ProjetoPesquisa projetoPesquisa = new ProjetoPesquisa();
    List<ParticipanteProjeto> listaParticipantes = new LinkedList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bolsa;
    private javax.swing.ButtonGroup bolsas;
    private javax.swing.JButton btnCancelarProjetoPesquisa;
    private javax.swing.JButton btnParticipanteAdicionar;
    private javax.swing.JButton btnParticipanteRemover;
    private javax.swing.JButton btnSalvarProjetoPesquisa;
    private javax.swing.ButtonGroup convenio;
    private javax.swing.ButtonGroup financiomento;
    private javax.swing.ButtonGroup grupogerenciadoFundacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelConvenio;
    private javax.swing.JPanel jPanelFinanciamento;
    private javax.swing.JPanel jPanelGeral;
    private javax.swing.JPanel jPanelParticipante;
    private javax.swing.JPanel jPanelResumo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTabbedPane jbtProjetoPesquisa;
    private javax.swing.JComboBox jcbProjetoPesquisaAluno;
    private javax.swing.JComboBox jcbProjetoPesquisaAreaConhecimento;
    private javax.swing.JComboBox jcbProjetoPesquisaCampus;
    private javax.swing.JComboBox jcbProjetoPesquisaCampusPartici;
    private javax.swing.JComboBox jcbProjetoPesquisaOrientador;
    private javax.swing.JRadioButton jrFinanCon;
    private javax.swing.JRadioButton jrFinanNao;
    private javax.swing.JRadioButton jrFinanSim;
    private javax.swing.JRadioButton jrFinanSub;
    private javax.swing.JRadioButton jrbBolsasNao;
    private javax.swing.JRadioButton jrbBolsasSim;
    private javax.swing.JRadioButton jrbConvenioNao;
    private javax.swing.JRadioButton jrbConvenioSim;
    private javax.swing.JRadioButton jrbFundacaoNao;
    private javax.swing.JRadioButton jrbFundacaoSim;
    private javax.swing.JRadioButton jrbMultiCampiNao;
    private javax.swing.JRadioButton jrbMultiCampiSim;
    private javax.swing.JTable jtbListaParcicipantesProjetoPesquisa;
    private javax.swing.JLabel lblAgenciaFinan;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblAreaPesquisa;
    private javax.swing.JLabel lblCampus;
    private javax.swing.JLabel lblConvenioQual;
    private javax.swing.JLabel lblDataFinan;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDataTermino;
    private javax.swing.JLabel lblGerenciadoFundacao;
    private javax.swing.JLabel lblGrupoPesquisa;
    private javax.swing.JLabel lblJustificativa;
    private javax.swing.JLabel lblLocalRealizacao;
    private javax.swing.JLabel lblNumeroBolsas;
    private javax.swing.JLabel lblObjetivos;
    private javax.swing.JLabel lblOrientador;
    private javax.swing.JLabel lblPossuiBolsas;
    private javax.swing.JLabel lblQualFundacao;
    private javax.swing.JLabel lblReferenciasBibliograficas;
    private javax.swing.JLabel lblResultadosEsperados;
    private javax.swing.JLabel lblResumo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorFinan;
    private javax.swing.JLabel lblprogramaPlano;
    private javax.swing.ButtonGroup multicampi;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JFormattedTextField txtDataTermino;
    private javax.swing.JTextField txtGrupoPesquisa;
    private javax.swing.JTextArea txtIntroducao;
    private javax.swing.JTextArea txtJustificativa;
    private javax.swing.JTextField txtLocalRealizacao;
    private javax.swing.JTextField txtNomeParticipante;
    private javax.swing.JTextField txtNumeroBolsas;
    private javax.swing.JTextArea txtObjetivos;
    private javax.swing.JTextArea txtParticipanteObservacao;
    private javax.swing.JTextField txtProgramaPlanoEnvolvido;
    private javax.swing.JTextField txtProjetoPesquisaAgenciaFinan;
    private javax.swing.JTextField txtProjetoPesquisaDataFinan;
    private javax.swing.JTextArea txtProjetoPesquisaResumo;
    private javax.swing.JTextField txtProjetoPesquisaTitulo;
    private javax.swing.JTextField txtQualConvenio;
    private javax.swing.JTextField txtQualFundacao;
    private javax.swing.JTextArea txtReferenciasBibliograficas;
    private javax.swing.JTextArea txtResultadosEsperados;
    private javax.swing.JTextField txtTitulacao;
    private javax.swing.JTextField txtValorFinanciamento;
    // End of variables declaration//GEN-END:variables
}
