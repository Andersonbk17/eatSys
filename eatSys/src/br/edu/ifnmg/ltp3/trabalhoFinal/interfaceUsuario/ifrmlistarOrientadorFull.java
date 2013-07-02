/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CampusDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CursoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.EstadoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.OrientadorDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CursoArea;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Nacionalidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Orientador;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.awt.OrientableFlowLayout;

/**
 *
 * @author emerson
 */
public class ifrmlistarOrientadorFull extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmlistarOrientadorFull
     */
    
    Orientador o;
    OrientadorDAO dao;
    
    public Date formatarData(String data) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        
        Date dataFormatada = format.parse(data);
        
        return dataFormatada; 
    }
    

    public ifrmlistarOrientadorFull(Orientador or, OrientadorDAO ad, int c) {
        initComponents();
        this.o = or;
        this.dao = ad;
        
        if(c == 0){
            carregaCampos(0);
        }else{
            carregaCampos(1);
        }
    }
    
    private void carregaCampos(int c) {
            txtId.setText(Integer.toString(o.getIdOrientador()));
            txtSiape.setText(Integer.toString(o.getMatriculaSiape()));
            txtNome.setText(o.getNome());
            txtCpf.setText(Integer.toString(o.getCpf()));
            txtRg.setText(o.getRg());
            txtRgOrgaoExpedidor.setText(o.getRgOrgaoExpedidor());
     

            SimpleDateFormat banco = new SimpleDateFormat("yyyy-MM-dd");

            String data = banco.format(o.getDataNascimento());
            data = data.substring(7,10) +"/"+ data.substring(5,7) +"/"+ data.substring(0,5);
            txtNascimento.setText(data);
            String data2 = banco.format(o.getRgDataExpedicao());
            data2 = data2.substring(7,10) +"/"+ data2.substring(5,7) +"/"+ data2.substring(0,5);
            txtDataExp.setText(data2);
            //----
            txtRua.setText(o.getEnderecoRua());
            txtNumero.setText(o.getEnderecoNumero());
            txtBairro.setText(o.getEnderecoBairro());
            txtComple.setText(o.getEnderecoComplmento());
            txtCep.setText(Integer.toString(o.getEnderecoCep()));
            //----
            txtEmail.setText(o.getEmailEndereco());
            txtLocal.setText(o.getLocalPermanencia());
            //----
            txtRamal.setText(o.getTelefoneRamal());
            //----
            txtTelefone.setText(o.getTelefoneFixo());
            txtCelular.setText(o.getTelefoneCelular());
            txtFormacao.setText(o.getFormacaoUniversitaria());
            txtTitulacao.setText(o.getTituloAcademico());

            //------
            CamposJCB();
            //------
            
        if(c == 0){
            txtId.setEditable(false);
            txtSiape.setEditable(false);
            txtNome.setEditable(false);
            txtCpf.setEditable(false);
            txtRg.setEditable(false);
            txtRgOrgaoExpedidor.setEditable(false);
            txtFormacao.setEditable(false);
            txtTitulacao.setEditable(false);
            
            txtNascimento.setEditable(false);
            txtDataExp.setEditable(false);

            //----
            txtRua.setEditable(false);
            txtNumero.setEditable(false);
            txtBairro.setEditable(false);
            txtComple.setEditable(false);
            txtCep.setEditable(false);
            //----
            txtEmail.setEditable(false);
            txtLocal.setEditable(false);
            //----
            txtRamal.setEditable(false);
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
            txtSiape.setEditable(true);
            txtNome.setEditable(true);
            txtCpf.setEditable(true);
            txtRg.setEditable(true);
            txtRgOrgaoExpedidor.setEditable(true);
            txtFormacao.setEditable(true);
            txtTitulacao.setEditable(true);
           
            txtNascimento.setEditable(true);
            txtDataExp.setEditable(true);

            //----
            txtRua.setEditable(true);
            txtNumero.setEditable(true);
            txtBairro.setEditable(true);
            txtComple.setEditable(true);
            txtCep.setEditable(true);
            //----
            txtEmail.setEditable(true);
            txtLocal.setEditable(true);
            //----
            txtRamal.setEditable(true);
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
            jcbCidade.setSelectedItem(o.getPessoaCidade());

            //Estado
            estados = estadoDao.ListarTodos();
            jcbEstado.removeAllItems();
            for(Estado es: estados){
                jcbEstado.addItem(es);
            }
            jcbEstado.setSelectedItem(o.getPessoaEstado());

            //Campus
            campus = campusDao.ListarTodos();
            jcbCampus.removeAllItems();
            for(Campus ca: campus){
                jcbCampus.addItem(ca);
            }
            jcbCampus.setSelectedItem(o.getPessoaCampus());

            //Nacionalidade
            nacionalidades = nacionalidadeDao.ListarTodos();
            jcbNacionalidade.removeAllItems();
            for(Nacionalidade na: nacionalidades){
                jcbNacionalidade.addItem(na);
            }
            jcbNacionalidade.setSelectedItem(o.getPessoaNacionalidade());

            //Curso
            cursos = cursoAreaDao.ListarTodos();
            jcbCurso.removeAllItems();
            for(CursoArea cu: cursos){
                jcbCurso.addItem(cu);
            }
            jcbCurso.setSelectedItem(o.getCursoArea());
            
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
            
            o.setMatriculaSiape(Integer.parseInt(txtSiape.getText()));
            o.setNome(txtNome.getText());
            o.setCpf(Integer.parseInt(txtCpf.getText()));
            o.setRg(txtRg.getText());
            o.setRgOrgaoExpedidor(txtRgOrgaoExpedidor.getText());
 
            
            //Data Nascimento
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                o.setDataNascimento(formatarData(txtNascimento.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Data Expedição Rg
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                o.setRgDataExpedicao(formatarData(txtDataExp.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            o.setPessoaCampus(ca);
            o.setCursoArea(cu);
            o.setPessoaNacionalidade(na);
            o.setPessoaEstado(es);
            o.setPessoaCidade(ci);
            
            //----
            o.setEnderecoRua(txtRua.getText());
            o.setEnderecoNumero(txtNumero.getText());
            o.setEnderecoBairro(txtBairro.getText());
            o.setEnderecoComplmento(txtComple.getText());
            o.setEnderecoCep(Integer.parseInt(txtCep.getText()));
            //----
            o.setEmailEndereco(txtEmail.getText());
            o.setLocalPermanencia(txtLocal.getText());
            //----
            o.setTelefoneRamal(txtRamal.getText());
            //----
            o.setTelefoneFixo(txtTelefone.getText());
            o.setTelefoneCelular(txtCelular.getText());
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
        txtSiape = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFormacao = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTitulacao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtRamal = new javax.swing.JTextField();
        jtbListarEndResponsavel = new javax.swing.JTabbedPane();
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

        jLabel13.setText("Siape");

        jLabel17.setText("FORMAÇÃO");

        jLabel18.setText("TITULAÇÃO");

        jLabel21.setText("LOCAL PERMANENCIA");

        jLabel22.setText("RAMAL");

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
                .addContainerGap(59, Short.MAX_VALUE))
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
                                .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtbListarEndResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(160, 160, 160))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel36)
                                                .addGap(5, 5, 5)
                                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSiape, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jcbNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtNome))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRg)))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRamal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtSiape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(40, Short.MAX_VALUE))
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
                          
                ifrmOrientadorListar janela = new ifrmOrientadorListar();
                
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
                
                if (dao.Salvar(o)) {
                    JOptionPane.showMessageDialog(rootPane, "As alterações foram salvas com sucesso!");
                    
                    ifrmOrientadorListar janela = new ifrmOrientadorListar();
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jcbCampus;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JComboBox jcbCurso;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbNacionalidade;
    private javax.swing.JTabbedPane jtbListarEndResponsavel;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtComple;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataExp;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFormacao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRamal;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRgOrgaoExpedidor;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSiape;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTitulacao;
    // End of variables declaration//GEN-END:variables
}
