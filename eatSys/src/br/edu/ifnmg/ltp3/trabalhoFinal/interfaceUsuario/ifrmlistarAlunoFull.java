/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AlunoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CampusDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CursoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.EstadoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CursoArea;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Nacionalidade;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author emerson
 */
public class ifrmlistarAlunoFull extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmlistarOrientadorFull
     */
    
    Aluno aluno;
    AlunoDAO dao;
    
    public Date formatarData(String data) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        
        Date dataFormatada = format.parse(data);
        
        return dataFormatada; 
    }
    

    public ifrmlistarAlunoFull(Aluno a, AlunoDAO ad, int c) {
        initComponents();
        this.aluno = a;
        this.dao = ad;
        
        if(c == 0){
            carregaCampos(0);
        }else{
            carregaCampos(1);
        }
    }
    
    private void carregaCampos(int c) {
            txtId.setText(Integer.toString(aluno.getIdAluno()));
            txtMatricula.setText(Integer.toString(aluno.getMatricula()));
            txtNome.setText(aluno.getNome());
            txtCpf.setText(Integer.toString(aluno.getCpf()));
            txtRg.setText(aluno.getRg());
            txtRgOrgaoExpedidor.setText(aluno.getRgOrgaoExpedidor());
            txtCMilitar.setText(aluno.getCertidaoMilitar());
            txtSMilitar.setText(aluno.getSituacaoMilitar());
            txtTitulo.setText(aluno.getTituloEleitoral());
            txtZona.setText(aluno.getZonaEleitoral());
            txtSecao.setText(aluno.getSecaoEleitoral());

            SimpleDateFormat banco = new SimpleDateFormat("yyyy-MM-dd");

            String data = banco.format(aluno.getDataNascimento());
            data = data.substring(7,10) +"/"+ data.substring(5,7) +"/"+ data.substring(0,5);
            txtNascimento.setText(data);
            String data2 = banco.format(aluno.getRgDataExpedicao());
            data2 = data2.substring(7,10) +"/"+ data2.substring(5,7) +"/"+ data2.substring(0,5);
            txtDataExp.setText(data2);

            //Dados dos responsaveis legais pelo aluno
            txtPai.setText(aluno.getNomePai());
            txtCpfPai.setText(Integer.toString(aluno.getCpfPai()));
            txtRgPai.setText(aluno.getRgPai());
            txtExpRgPai.setText(aluno.getOrgaoExpedidorPai());
            //----
            txtMae.setText(aluno.getNomeMae());
            txtCpfMae.setText(Integer.toString(aluno.getCpfMae()));
            txtRgMae.setText(aluno.getRgMae());
            txtExpRgMae.setText(aluno.getOrgaoExpedidorMae());
            //----
            txtRua.setText(aluno.getEnderecoRua());
            txtNumero.setText(aluno.getEnderecoNumero());
            txtBairro.setText(aluno.getEnderecoBairro());
            txtComple.setText(aluno.getEnderecoComplmento());
            txtCep.setText(Integer.toString(aluno.getEnderecoCep()));
            //----
            txtEmail.setText(aluno.getEmailEndereco());
            txtTrabalho.setText(aluno.getLocalTrabalho());
            //----
            txtFoneTrabalho.setText(aluno.getTelefoneLocalTrabalho());
            //----
            txtTelefone.setText(aluno.getTelefoneFixo());
            txtCelular.setText(aluno.getTelefoneCelular());

            //------
            CamposJCB();
            //------
            
        if(c == 0){
            txtId.setEditable(false);
            txtMatricula.setEditable(false);
            txtNome.setEditable(false);
            txtCpf.setEditable(false);
            txtRg.setEditable(false);
            txtRgOrgaoExpedidor.setEditable(false);
            txtCMilitar.setEditable(false);
            txtSMilitar.setEditable(false);
            txtTitulo.setEditable(false);
            txtZona.setEditable(false);
            txtSecao.setEditable(false);
            txtNascimento.setEditable(false);
            txtDataExp.setEditable(false);

            //Dados dos responsaveis legais pelo aluno
            txtPai.setEditable(false);
            txtCpfPai.setEditable(false);
            txtRgPai.setEditable(false);
            txtExpRgPai.setEditable(false);
            //----
            txtMae.setEditable(false);
            txtCpfMae.setEditable(false);
            txtRgMae.setEditable(false);
            txtExpRgMae.setEditable(false);
            //----
            txtRua.setEditable(false);
            txtNumero.setEditable(false);
            txtBairro.setEditable(false);
            txtComple.setEditable(false);
            txtCep.setEditable(false);
            //----
            txtEmail.setEditable(false);
            txtTrabalho.setEditable(false);
            //----
            txtFoneTrabalho.setEditable(false);
            //----
            txtTelefone.setEditable(false);
            txtCelular.setEditable(false);
            
            jcbCampus.setEnabled(false);
            jcbCidade.setEnabled(false);
            jcbNacionalidade.setEnabled(false);
            jcbEstado.setEnabled(false);
            jcbCurso.setEnabled(false);
            
            btnSalvar.setVisible(false);
  
            
        }else{
            txtId.setEditable(false);
            txtMatricula.setEditable(true);
            txtNome.setEditable(true);
            txtCpf.setEditable(true);
            txtRg.setEditable(true);
            txtRgOrgaoExpedidor.setEditable(true);
            txtCMilitar.setEditable(true);
            txtSMilitar.setEditable(true);
            txtTitulo.setEditable(true);
            txtZona.setEditable(true);
            txtSecao.setEditable(true);
            txtNascimento.setEditable(true);
            txtDataExp.setEditable(true);

            //Dados dos responsaveis legais pelo aluno
            txtPai.setEditable(true);
            txtCpfPai.setEditable(true);
            txtRgPai.setEditable(true);
            txtExpRgPai.setEditable(true);
            //----
            txtMae.setEditable(true);
            txtCpfMae.setEditable(true);
            txtRgMae.setEditable(true);
            txtExpRgMae.setEditable(true);
            //----
            txtRua.setEditable(true);
            txtNumero.setEditable(true);
            txtBairro.setEditable(true);
            txtComple.setEditable(true);
            txtCep.setEditable(true);
            //----
            txtEmail.setEditable(true);
            txtTrabalho.setEditable(true);
            //----
            txtFoneTrabalho.setEditable(true);
            //----
            txtTelefone.setEditable(true);
            txtCelular.setEditable(true);
            
            jcbCampus.setEnabled(true);
            jcbCidade.setEnabled(true);
            jcbNacionalidade.setEnabled(true);
            jcbEstado.setEnabled(true);  
            jcbCurso.setEnabled(true);
            
            btnSalvar.setVisible(true);
    
        }
    }
    
    public void CamposJCB(){
        List<Cidade> cidades;
        List<Estado> estados;
        List<CursoArea> cursos;
        List<Campus> campus;
        List<Nacionalidade> nacionalidades;

       try{   
            CidadeDAO cidadeDao = new CidadeDAO();
            EstadoDAO estadoDao = new EstadoDAO();
            CursoDAO cursoAreaDao = new CursoDAO(); 
            CampusDAO campusDao = new CampusDAO();
            NacionalidadeDAO nacionalidadeDao = new NacionalidadeDAO();


            //Cidade
            cidades = cidadeDao.ListarTodos();
            jcbCidade.removeAllItems();
            for(Cidade ci: cidades){
                jcbCidade.addItem(ci);
            }
            jcbCidade.setSelectedItem(aluno.getPessoaCidade());

            //Estado
            estados = estadoDao.ListarTodos();
            jcbEstado.removeAllItems();
            for(Estado es: estados){
                jcbEstado.addItem(es);
            }
            jcbEstado.setSelectedItem(aluno.getPessoaEstado());

            //Campus
            campus = campusDao.ListarTodos();
            jcbCampus.removeAllItems();
            for(Campus ca: campus){
                jcbCampus.addItem(ca);
            }
            jcbCampus.setSelectedItem(aluno.getPessoaCampus());

            //Nacionalidade
            nacionalidades = nacionalidadeDao.ListarTodos();
            jcbNacionalidade.removeAllItems();
            for(Nacionalidade na: nacionalidades){
                jcbNacionalidade.addItem(na);
            }
            jcbNacionalidade.setSelectedItem(aluno.getPessoaNacionalidade());

            //Curso
            cursos = cursoAreaDao.ListarTodos();
            jcbCurso.removeAllItems();
            for(CursoArea cu: cursos){
                jcbCurso.addItem(cu);
            }
            jcbCurso.setSelectedItem(aluno.getAlunoCurso());
            
       }catch(SQLException ex){
           ex.printStackTrace();
       }
    }
    
    private void carregaObjeto() {  
        
            CursoArea cu = (CursoArea) jcbCurso.getSelectedItem();
            Campus ca = (Campus) jcbCampus.getSelectedItem();
            Nacionalidade na = (Nacionalidade) jcbNacionalidade.getSelectedItem();
            Estado es = (Estado) jcbEstado.getSelectedItem();
            Cidade ci = (Cidade) jcbCidade.getSelectedItem();
            
            aluno.setMatricula(Integer.parseInt(txtMatricula.getText()));
            aluno.setNome(txtNome.getText());
            aluno.setCpf(Integer.parseInt(txtCpf.getText()));
            aluno.setRg(txtRg.getText());
            aluno.setRgOrgaoExpedidor(txtRgOrgaoExpedidor.getText());
            aluno.setCertidaoMilitar(txtCMilitar.getText());
            aluno.setSituacaoMilitar(txtSMilitar.getText());
            
            //Data Nascimento
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                aluno.setDataNascimento(formatarData(txtNascimento.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Data Expedição Rg
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                aluno.setRgDataExpedicao(formatarData(txtDataExp.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            aluno.setTituloEleitoral(txtTitulo.getText());
            aluno.setZonaEleitoral(txtZona.getText());
            aluno.setSecaoEleitoral(txtSecao.getText());
            aluno.setPessoaCampus(ca);
            aluno.setAlunoCurso(cu);
            aluno.setPessoaNacionalidade(na);
            aluno.setPessoaEstado(es);
            aluno.setPessoaCidade(ci);
            
            //Dados dos responsaveis legais pelo aluno
            aluno.setNomePai(txtPai.getText());
            aluno.setCpfPai(Integer.parseInt(txtCpfPai.getText()));
            aluno.setRgPai(txtRgPai.getText());
            aluno.setOrgaoExpedidorPai(txtExpRgPai.getText());
            aluno.setNomeMae(txtMae.getText());
            aluno.setCpfMae(Integer.parseInt(txtCpfMae.getText()));
            aluno.setRgMae(txtRgMae.getText());
            aluno.setOrgaoExpedidorMae(txtExpRgMae.getText());
            //----
            aluno.setEnderecoRua(txtRua.getText());
            aluno.setEnderecoNumero(txtNumero.getText());
            aluno.setEnderecoBairro(txtBairro.getText());
            aluno.setEnderecoComplmento(txtComple.getText());
            aluno.setEnderecoCep(Integer.parseInt(txtCep.getText()));
            //----
            aluno.setEmailEndereco(txtEmail.getText());
            aluno.setLocalTrabalho(txtTrabalho.getText());
            //----
            aluno.setTelefoneLocalTrabalho(txtFoneTrabalho.getText());
            //----
            aluno.setTelefoneFixo(txtTelefone.getText());
            aluno.setTelefoneCelular(txtCelular.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtRgOrgaoExpedidor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDataExp = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txtDataExp = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        txtCpf = new javax.swing.JTextField();
        txtNascimento = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txtNascimento = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCMilitar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtSMilitar = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSecao = new javax.swing.JTextField();
        txtZona = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTrabalho = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtFoneTrabalho = new javax.swing.JTextField();
        jtbListarEndResponsavel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtPai = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtRgPai = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtExpRgPai = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtCpfPai = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtMae = new javax.swing.JTextField();
        txtCpfMae = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtRgMae = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtExpRgMae = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtComple = new javax.swing.JTextField();
        jcbCidade = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbNacionalidade = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jcbCampus = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jcbCurso = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setPreferredSize(new java.awt.Dimension(1024, 700));

        lblNome.setText("Nome");

        jLabel2.setText("RG");

        jLabel3.setText("CPF");

        jLabel4.setText("NASCIMENTO");

        jLabel15.setText("ORGÃO EXP.");

        jLabel16.setText("DATA EXP.");

        txtDataExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataExpActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel13.setText("MATRICULA");

        jLabel14.setText("TITULO");

        jLabel17.setText("CERTIDÃO MILITAR");

        jLabel18.setText("SITUAÇÃO MILITAR");

        jLabel19.setText("SEÇÃO");

        jLabel20.setText("ZONA");

        jLabel21.setText("LOCAL TRABALHO");

        jLabel22.setText("TELEFONE TRABALHO");

        jLabel30.setText("PAI");

        jLabel31.setText("RG");

        jLabel32.setText("ORG EXPEDIDOR");

        jLabel33.setText("CPF");

        jLabel37.setText("MÃE");

        jLabel38.setText("CPF");

        jLabel39.setText("RG");

        jLabel40.setText("ORG EXPEDIDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel30))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPai, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExpRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMae, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExpRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtCpfMae, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtExpRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(txtExpRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtCpfMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jtbListarEndResponsavel.addTab("RESPONAVEL", jPanel1);

        jLabel23.setText("RUA");

        jLabel24.setText("NUMERO");

        jLabel25.setText("BAIRRO");

        jLabel26.setText("CEP");

        jLabel27.setText("CIDADE");

        jLabel29.setText("COMPLEMENTO");

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtComple, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txtComple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jtbListarEndResponsavel.addTab("ENDERECO", jPanel2);

        jLabel34.setText("EMAIL");

        jLabel35.setText("TELEFONE FIXO");

        jLabel36.setText("TELEFONE CELULAR");

        jLabel6.setText("NACIONALIDADE");

        jcbNacionalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("CAMPUS");

        jcbCampus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCampusActionPerformed(evt);
            }
        });

        jLabel5.setText("ESTADO");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbEstado.setFocusable(false);

        jLabel8.setText("CURSO");

        jcbCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCursoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtbListarEndResponsavel))
                        .addGap(160, 160, 160))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSMilitar))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel14)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSecao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel35)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtTelefone))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jcbNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtNome))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFoneTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jcbCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(211, 211, 211)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jcbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRgOrgaoExpedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataExp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jcbNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtRgOrgaoExpedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtDataExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(txtSecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtSMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtCMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtFoneTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jcbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jtbListarEndResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataExpActionPerformed

    private void jcbCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCampusActionPerformed

    private void jcbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCursoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
         if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente Cancelar?") == 0) {
            try {
                JOptionPane.showMessageDialog(rootPane, "Cancelado!");
                          
                ifrmAlunoListar janela = new ifrmAlunoListar();
                
                this.getParent().add(janela);
                janela.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(ifrmlistarAlunoFull.class.getName()).log(Level.SEVERE, null, ex);
            }

          } else {                
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada!");
          }
         
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja salvar as Alterações?") == 0) {

                carregaObjeto();
                
                if (dao.Salvar(aluno)) {
                    JOptionPane.showMessageDialog(rootPane, "As alterações foram salvas com sucesso!");
                    
                    ifrmAlunoListar janela = new ifrmAlunoListar();
                    this.getParent().add(janela);
                    janela.setVisible(true);
                    this.setVisible(false);
                   
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Falha ao salvar! Consulte o administrador do sistema!");
                }

            } else {                
                JOptionPane.showMessageDialog(rootPane, "Operação cancelada!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar! Consulte o administrador do sistema!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jcbCampus;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JComboBox jcbCurso;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbNacionalidade;
    private javax.swing.JTabbedPane jtbListarEndResponsavel;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCMilitar;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtComple;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtCpfMae;
    private javax.swing.JTextField txtCpfPai;
    private javax.swing.JTextField txtDataExp;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtExpRgMae;
    private javax.swing.JTextField txtExpRgPai;
    private javax.swing.JTextField txtFoneTrabalho;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMae;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPai;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRgMae;
    private javax.swing.JTextField txtRgOrgaoExpedidor;
    private javax.swing.JTextField txtRgPai;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSMilitar;
    private javax.swing.JTextField txtSecao;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTrabalho;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
