/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AlunoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CampusDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CursoAreaDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.EstadoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.OrientadorDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CursoArea;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Email;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Endereco;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Nacionalidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Orientador;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Responsavel;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Telefone;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ifrmOrientadorCad extends javax.swing.JInternalFrame {
    Orientador orientador = new Orientador();
    
    List<Cidade> cidades;
    List<Estado> estados;
    List<CursoArea> cursos;
    List<Campus> campus;
    List<Nacionalidade> nacionalidades;

    /**
     * Creates new form ifrmCampusCad
     */
    
    OrientadorDAO orientadorDao = new OrientadorDAO();
    
    public Date formatarData(String data) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        
        Date dataFormatada = format.parse(data);
        
        return dataFormatada; 
    }
    
    private void addTelefone(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("DDD");
        model.addColumn("Telefone");
        
        for(Telefone te : orientador.getTelefone()){
            Vector v = new Vector();
            v.add(0, te.getDdd());
            v.add(1, te.getNumero());
            model.addRow(v);
        }
        jtbListaTeleOrientador.setModel(model);
    }
    
     private void addEmail(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Endereço de E-mail");
 
        for(Email em : orientador.getEmail()){
            Vector v = new Vector();
            v.add(em.getEnderecoEmail());
            model.addRow(v);
        }
        jtbListaEmailOrientador.setModel(model);
    }
     
     private void addEndereco(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Rua");
        model.addColumn("Num");
        model.addColumn("Bairro");
        model.addColumn("Cep");
        model.addColumn("Complemento");
        model.addColumn("Cidade");
        model.addColumn("Estado");
 
        for(Endereco en : orientador.getEndereco()){
            Vector v = new Vector();
            v.add(0,en.getRua());
            v.add(1,en.getNumero());
            v.add(2,en.getBairro());
            v.add(3,en.getCep());
            v.add(4,en.getComplemento());
            v.add(5,en.getCidade().getNome());
            v.add(6,en.getCidade().getEstado().getNome());
            model.addRow(v);
        }
        jtbListaEndOrientador.setModel(model);
    }
    public ifrmOrientadorCad() throws SQLException {
        initComponents();
        CidadeDAO cidadeDao = new CidadeDAO();
        EstadoDAO estadoDao = new EstadoDAO();
        CursoAreaDAO cursoAreaDao = new CursoAreaDAO(); 
        CampusDAO campusDao = new CampusDAO();
        NacionalidadeDAO nacionalidadeDao = new NacionalidadeDAO();
      
        //Cidade
        cidades = cidadeDao.ListarTodas();
        jcbCidadeOrientador.removeAllItems();
        for(Cidade ci: cidades){
            jcbCidadeOrientador.addItem(ci);
        }
        
        //Estado
        estados = estadoDao.ListarTodos();
        jcbOrientadorEstado.removeAllItems();
        for(Estado es: estados){
            jcbOrientadorEstado.addItem(es);
        }
        
        //Campus
        campus = campusDao.ListarTodos();
        jcbOrientadorCampus.removeAllItems();
        for(Campus ca: campus){
            jcbOrientadorCampus.addItem(ca);
        }
        
        //Nacionalidade
        nacionalidades = nacionalidadeDao.ListarTodos();
        jcbOrientadorNascionalidade.removeAllItems();
        for(Nacionalidade na: nacionalidades){
            jcbOrientadorNascionalidade.addItem(na);
        }
        
        //Curso
        cursos = cursoAreaDao.ListarTodos();
        jcbOrientadorCurso.removeAllItems();
        for(CursoArea cu: cursos){
            jcbOrientadorCurso.addItem(cu);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOrientadorNome = new javax.swing.JTextField();
        txtOrientadorRg = new javax.swing.JTextField();
        txtOrientadorCpf = new javax.swing.JTextField();
        txtOrientadorDataExp = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txtOrientadorDataExp = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel7 = new javax.swing.JLabel();
        txtOrientadorOrgaoEx = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbOrientadorCampus = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jcbOrientadorNascionalidade = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jcbOrientadorCurso = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jcbOrientadorEstado = new javax.swing.JComboBox();
        lblDataNasc = new javax.swing.JLabel();
        txtOrientadorDataNasc = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txtOrientadorDataNasc = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtOrientadorTituloAcademico = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtOrientadorLocalPermanencia = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtOrientadorFormacao = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtOrientadorSiape = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbListaTeleOrientador = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtOrientadorddd = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtOrientadorTelefone = new javax.swing.JTextField();
        btnaddTelefoneOrientador = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbListaEndOrientador = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtOrientadorRua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtOrientadorBairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtOrientadorCep = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtOrientadorNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtOrientadorComplemento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jcbCidadeOrientador = new javax.swing.JComboBox();
        btnaddEnderecoOrientador = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbListaEmailOrientador = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtOrientadorEmail = new javax.swing.JTextField();
        btnAddEmailAluno = new javax.swing.JButton();
        btnSalvarOrientador = new javax.swing.JButton();
        btnCancelarOrientador = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

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
        jLabel2.setText("Cadastrar Area Conhecimento");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ifl.png"))); // NOI18N

        jLabel1.setText("Nome");

        jLabel4.setText("Rg");

        jLabel5.setText("Cpf");

        jLabel6.setText("Data Exp.");

        txtOrientadorDataExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrientadorDataExpActionPerformed(evt);
            }
        });

        jLabel7.setText("Orgão Exp.");

        jLabel8.setText("Campus");

        jcbOrientadorCampus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Nacionalidade");

        jcbOrientadorNascionalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Curso");

        jcbOrientadorCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Estado");

        jcbOrientadorEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbOrientadorEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOrientadorEstadoActionPerformed(evt);
            }
        });

        lblDataNasc.setText("Data Nasc.");

        txtOrientadorDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrientadorDataNascActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbOrientadorNascionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbOrientadorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbOrientadorCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbOrientadorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtOrientadorCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(8, 8, 8)
                                .addComponent(txtOrientadorOrgaoEx))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOrientadorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtOrientadorRg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(lblDataNasc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrientadorDataExp)
                                    .addComponent(txtOrientadorDataNasc))))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOrientadorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtOrientadorRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtOrientadorOrgaoEx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtOrientadorDataExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrientadorCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblDataNasc)
                    .addComponent(txtOrientadorDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbOrientadorNascionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jcbOrientadorEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbOrientadorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jcbOrientadorCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geral", jPanel2);

        jLabel29.setText("Titulo Acadêmico");

        jLabel32.setText("Formação");

        jLabel33.setText("LocalPermanencia");

        jLabel34.setText("Siape");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrientadorSiape, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOrientadorLocalPermanencia, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(txtOrientadorFormacao)
                    .addComponent(txtOrientadorTituloAcademico))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtOrientadorSiape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrientadorLocalPermanencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrientadorFormacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrientadorTituloAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orientador", jPanel3);

        jtbListaTeleOrientador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtbListaTeleOrientador);

        jLabel19.setText("DDD");

        jLabel20.setText("Telefone");

        btnaddTelefoneOrientador.setText("Adicionar");
        btnaddTelefoneOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddTelefoneOrientadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrientadorddd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrientadorTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnaddTelefoneOrientador)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtOrientadorddd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtOrientadorTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnaddTelefoneOrientador)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Telefone", jPanel4);

        jtbListaEndOrientador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtbListaEndOrientador);

        jLabel13.setText("Rua");

        jLabel14.setText("Bairro");

        jLabel15.setText("Cep");

        jLabel16.setText("Numero");

        jLabel17.setText("Complemento");

        txtOrientadorComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrientadorComplementoActionPerformed(evt);
            }
        });

        jLabel18.setText("Cidade");

        jcbCidadeOrientador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnaddEnderecoOrientador.setText("Adicionar");
        btnaddEnderecoOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddEnderecoOrientadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtOrientadorRua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtOrientadorCep)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtOrientadorBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtOrientadorNumero))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOrientadorComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCidadeOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnaddEnderecoOrientador)
                        .addGap(50, 50, 50))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtOrientadorRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtOrientadorBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtOrientadorCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtOrientadorNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtOrientadorComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jcbCidadeOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddEnderecoOrientador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Endereço", jPanel5);

        jtbListaEmailOrientador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbListaEmailOrientador);

        jLabel12.setText("Email");

        btnAddEmailAluno.setText("Adicionar");
        btnAddEmailAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmailAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOrientadorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddEmailAluno)
                .addGap(50, 50, 50))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtOrientadorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnAddEmailAluno)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Email", jPanel6);

        btnSalvarOrientador.setText("Salvar");
        btnSalvarOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarOrientadorActionPerformed(evt);
            }
        });

        btnCancelarOrientador.setText("Cancelar");
        btnCancelarOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOrientadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2)
                        .addContainerGap(409, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelarOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvarOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnSalvarOrientador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarOrientador)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOrientadorComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrientadorComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrientadorComplementoActionPerformed

    private void txtOrientadorDataExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrientadorDataExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrientadorDataExpActionPerformed

    private void txtOrientadorDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrientadorDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrientadorDataNascActionPerformed

    private void jcbOrientadorEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOrientadorEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbOrientadorEstadoActionPerformed

    private void btnAddEmailAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmailAlunoActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(rootPane,"Deseja realmente adicionar esse email?")==0){
            Email email = new Email();
            email.setEnderecoEmail(txtOrientadorEmail.getText());

            orientador.addEmail(email);
            JOptionPane.showMessageDialog(rootPane, "Email adicionado");
            addEmail();
            
            txtOrientadorEmail.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ação cancelada");
        }
    }//GEN-LAST:event_btnAddEmailAlunoActionPerformed

    private void btnaddTelefoneOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddTelefoneOrientadorActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(rootPane,"Deseja realmente adicionar esse telefone?")==0){
            Telefone telefone = new Telefone();
            telefone.setDdd(Integer.parseInt(txtOrientadorddd.getText()));
            telefone.setNumero(Integer.parseInt(txtOrientadorTelefone.getText()));

            orientador.addTelefone(telefone);
            JOptionPane.showMessageDialog(rootPane, "Telefone adicionado");
            addTelefone();
            
            txtOrientadorddd.setText(null);
            txtOrientadorTelefone.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ação cancelada");
        }
    }//GEN-LAST:event_btnaddTelefoneOrientadorActionPerformed

    private void btnaddEnderecoOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddEnderecoOrientadorActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(rootPane,"Deseja realmente adicionar esse endereco?")==0){
            Endereco endereco = new Endereco();
            
            Cidade c = (Cidade)jcbCidadeOrientador.getSelectedItem();
   
            endereco.setRua(txtOrientadorRua.getText());
            endereco.setNumero(Integer.parseInt(txtOrientadorNumero.getText()));
            endereco.setBairro(txtOrientadorBairro.getText());
            endereco.setCep(Integer.parseInt(txtOrientadorCep.getText()));
            endereco.setComplemento(txtOrientadorComplemento.getText());
            endereco.setCidade(c);
            
            orientador.addEndereco(endereco);
            JOptionPane.showMessageDialog(rootPane, "Endereco adicionado");
            addEndereco();
            
            txtOrientadorRua.setText(null);
            txtOrientadorNumero.setText(null);
            txtOrientadorBairro.setText(null);
            txtOrientadorCep.setText(null);
            txtOrientadorComplemento.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ação cancelada");
        }
    }//GEN-LAST:event_btnaddEnderecoOrientadorActionPerformed

    private void btnCancelarOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOrientadorActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(rootPane, "Deseja cancelar a operação?")==0){
            JOptionPane.showMessageDialog(rootPane, "Operação cancelada");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Continuar de onde parou.");
        }
    }//GEN-LAST:event_btnCancelarOrientadorActionPerformed

    private void btnSalvarOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarOrientadorActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente salvar esses dados?")==0){
            
            CursoArea cu = (CursoArea) jcbOrientadorCurso.getSelectedItem();
            Campus ca = (Campus) jcbOrientadorCampus.getSelectedItem();
            Nacionalidade na = (Nacionalidade) jcbOrientadorNascionalidade.getSelectedItem();
            Estado es = (Estado) jcbOrientadorEstado.getSelectedItem();
            
            orientador.setNome(txtOrientadorNome.getText());
            orientador.setCpf(Integer.parseInt(txtOrientadorCpf.getText()));
            orientador.setRg(txtOrientadorRg.getText());
            orientador.setOrgaoExpeditor(txtOrientadorOrgaoEx.getText());
            
            //Data Nascimento
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                orientador.setDataNascimento(formatarData(txtOrientadorDataNasc.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Data Expedição Rg
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                orientador.setDataExpedicao(formatarData(txtOrientadorDataExp.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
            orientador.setMatriculaSiape(Integer.parseInt(txtOrientadorSiape.getText()));
            orientador.setLocalPermanencia(txtOrientadorLocalPermanencia.getText());
            orientador.setFormacaoAcademica(txtOrientadorFormacao.getText());
            orientador.setTituloAcademico(txtOrientadorTituloAcademico.getText());
             
            orientador.setCampus(ca);
            orientador.setCursoArea(cu);
            orientador.setNacionalidade(na);
            orientador.setEstado(es);
            
            try {
                if(orientadorDao.Salvar(orientador)){
                    JOptionPane.showMessageDialog(rootPane, "Dados foram salvos com sucesso.");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao salvar os dados."); 
                } 
            } catch (SQLException ex) {
                Logger.getLogger(ifrmOrientadorCad.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtOrientadorNome.setText(null);
            txtOrientadorRg.setText(null);
            txtOrientadorOrgaoEx.setText(null);
            txtOrientadorDataExp.setText(null);
            txtOrientadorDataNasc.setText(null);
            txtOrientadorCpf.setText(null);
            txtOrientadorSiape.setText(null);
            txtOrientadorLocalPermanencia.setText(null);
            txtOrientadorFormacao.setText(null);
            txtOrientadorTituloAcademico.setText(null);
           
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao salvar os dados, consulte o administrador do sistema.");
        }
    }//GEN-LAST:event_btnSalvarOrientadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmailAluno;
    private javax.swing.JButton btnCancelarOrientador;
    private javax.swing.JButton btnSalvarOrientador;
    private javax.swing.JButton btnaddEnderecoOrientador;
    private javax.swing.JButton btnaddTelefoneOrientador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox jcbCidadeOrientador;
    private javax.swing.JComboBox jcbOrientadorCampus;
    private javax.swing.JComboBox jcbOrientadorCurso;
    private javax.swing.JComboBox jcbOrientadorEstado;
    private javax.swing.JComboBox jcbOrientadorNascionalidade;
    private javax.swing.JTable jtbListaEmailOrientador;
    private javax.swing.JTable jtbListaEndOrientador;
    private javax.swing.JTable jtbListaTeleOrientador;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JTextField txtOrientadorBairro;
    private javax.swing.JTextField txtOrientadorCep;
    private javax.swing.JTextField txtOrientadorComplemento;
    private javax.swing.JTextField txtOrientadorCpf;
    private javax.swing.JTextField txtOrientadorDataExp;
    private javax.swing.JTextField txtOrientadorDataNasc;
    private javax.swing.JTextField txtOrientadorEmail;
    private javax.swing.JTextField txtOrientadorFormacao;
    private javax.swing.JTextField txtOrientadorLocalPermanencia;
    private javax.swing.JTextField txtOrientadorNome;
    private javax.swing.JTextField txtOrientadorNumero;
    private javax.swing.JTextField txtOrientadorOrgaoEx;
    private javax.swing.JTextField txtOrientadorRg;
    private javax.swing.JTextField txtOrientadorRua;
    private javax.swing.JTextField txtOrientadorSiape;
    private javax.swing.JTextField txtOrientadorTelefone;
    private javax.swing.JTextField txtOrientadorTituloAcademico;
    private javax.swing.JTextField txtOrientadorddd;
    // End of variables declaration//GEN-END:variables
}
