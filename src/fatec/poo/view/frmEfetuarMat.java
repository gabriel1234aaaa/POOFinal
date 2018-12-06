/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

import fatec.poo.control.Conexao;
import fatec.poo.control.DaoAPrazo;
import fatec.poo.control.DaoAVista;
import fatec.poo.control.DaoAluno;
import fatec.poo.control.DaoCurso;
import fatec.poo.control.DaoInstrutor;
import fatec.poo.control.DaoMatricula;
import fatec.poo.control.DaoTurma;
import fatec.poo.model.APrazo;
import fatec.poo.model.AVista;
import fatec.poo.model.Aluno;
import fatec.poo.model.Curso;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Matricula;
import fatec.poo.model.Turma;
import java.awt.Component;
import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author 0030481711010
 */
public class frmEfetuarMat extends javax.swing.JFrame {

    /**
     * Creates new form frmEfetuarMat
     */
    public frmEfetuarMat() {
        initComponents();
    }

    private void limparCampos() {
        for (Component component : jPanel1.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
                ((JTextField) component).setEnabled(false);
            }
             if (component instanceof JRadioButton) {
                ((JRadioButton) component).setEnabled(false);
            }
            btgPagamento.clearSelection();
        }
        for (Component component : getContentPane().getComponents()) {
            if (!(component instanceof JLabel)) {
                component.setEnabled(false);
            }
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JFormattedTextField) {
                ((JFormattedTextField) component).setValue("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }

        btnConsultar.setEnabled(true);
        txtCPFAluno.setEnabled(true);
        btnSair.setEnabled(true);
        cmbCurso.setEnabled(true);
        cmbTurma.setEnabled(true);
        txtDtMatricula.setEnabled(true);

        if (rbtnAVista.isSelected()) {
            rbtnAVista.setSelected(false);
        } else {
            rbtnParcelado.setSelected(false);
        }
        
        cmbCurso.setSelectedIndex(0);
    }

    private Matricula formToObject() {

        Matricula matricula = new Matricula(txtDtMatricula.getText().replaceAll("[^0-9]", ""));
        Aluno aluno = daoAluno.consultar(txtCPFAluno.getText().replaceAll("[^0-9]", ""));
        Turma turma = daoTurma.consultar(cmbTurma.getSelectedItem().toString());
        AVista aVista = new AVista();
        APrazo aPrazo = new APrazo();

        matricula.setAluno(aluno);
        matricula.setTurma(turma);

        if (rbtnAVista.isSelected()) {
            aVista.setAgencia(Integer.parseInt(txtAgencia.getText()));
            aVista.setNCheque(Integer.parseInt(txtNCheque.getText()));
            aVista.setValor(Double.parseDouble(txtValor.getText().replace("R$ ", "").replace(".", "").replace(",", ".")));
            aVista.setPreData(txtDtPagto.getText().replaceAll("[^0-9]", ""));
            aPrazo = null;
        } else {
            aPrazo.setDtVencimento(txtDtVencto.getText().replaceAll("[^0-9]", ""));
            aPrazo.setQtdeMensalidade(Integer.parseInt(txtQtdeMensal.getText()));
            aPrazo.setTaxaJuros(Double.parseDouble(txtTxJuros.getText().replace(".", "").replace(",", ".")));
            aPrazo.setValor(Double.parseDouble(txtValor.getText().replace("R$ ", "").replace(".", "").replace(",", ".")));
            aVista = null;
        }
        matricula.setAprazo(aPrazo);
        matricula.setAvista(aVista);

        return matricula;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgPagamento = new javax.swing.ButtonGroup();
        lblDtMatricula = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        lblTurma = new javax.swing.JLabel();
        lblCPFAluno = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        cmbTurma = new javax.swing.JComboBox<>();
        txtCPFAluno = new javax.swing.JFormattedTextField();
        txtDtMatricula = new javax.swing.JFormattedTextField();
        lblValor = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbtnAVista = new javax.swing.JRadioButton();
        rbtnParcelado = new javax.swing.JRadioButton();
        lblAgencia = new javax.swing.JLabel();
        lblQtdeMensal = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        txtQtdeMensal = new javax.swing.JTextField();
        lblNCheque = new javax.swing.JLabel();
        lblTxJuros = new javax.swing.JLabel();
        txtNCheque = new javax.swing.JTextField();
        txtTxJuros = new javax.swing.JTextField();
        lblDtPagto = new javax.swing.JLabel();
        txtDtPagto = new javax.swing.JFormattedTextField();
        lxlDtVencto = new javax.swing.JLabel();
        txtDtVencto = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Efetuar Matrícula");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblDtMatricula.setText("Data da Matrícula");

        lblCurso.setText("Curso");

        lblTurma.setText("Turma");

        lblCPFAluno.setText("CPF Aluno");

        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        cmbTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTurmaActionPerformed(evt);
            }
        });

        try {
            txtCPFAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFAluno.setEnabled(false);

        try {
            txtDtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblValor.setText("Valor");

        lblNome.setText("Nome");

        txtNome.setEnabled(false);

        txtValor.setEnabled(false);

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.setEnabled(false);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Eraser.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        btgPagamento.add(rbtnAVista);
        rbtnAVista.setText("À Vista");
        rbtnAVista.setEnabled(false);
        rbtnAVista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnAVistaItemStateChanged(evt);
            }
        });

        btgPagamento.add(rbtnParcelado);
        rbtnParcelado.setText("Parcelado");
        rbtnParcelado.setEnabled(false);
        rbtnParcelado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnParceladoItemStateChanged(evt);
            }
        });

        lblAgencia.setText("Agência");

        lblQtdeMensal.setText("Qtde. Mensalidades");

        txtAgencia.setEnabled(false);

        txtQtdeMensal.setEnabled(false);

        lblNCheque.setText("No. Cheque");

        lblTxJuros.setText("Tx. Juros(%)");

        txtNCheque.setEnabled(false);

        txtTxJuros.setEnabled(false);

        lblDtPagto.setText("Data Pagto.");

        try {
            txtDtPagto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDtPagto.setEnabled(false);

        lxlDtVencto.setText("Data 1o. Vencto.");

        try {
            txtDtVencto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDtVencto.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnAVista)
                    .addComponent(rbtnParcelado))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAgencia)
                        .addGap(10, 10, 10)
                        .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblNCheque)
                        .addGap(10, 10, 10)
                        .addComponent(txtNCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblDtPagto)
                        .addGap(10, 10, 10)
                        .addComponent(txtDtPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblQtdeMensal)
                        .addGap(10, 10, 10)
                        .addComponent(txtQtdeMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblTxJuros)
                        .addGap(10, 10, 10)
                        .addComponent(txtTxJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lxlDtVencto)
                        .addGap(10, 10, 10)
                        .addComponent(txtDtVencto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAVista)
                    .addComponent(lblAgencia)
                    .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNCheque)
                    .addComponent(txtNCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDtPagto)
                    .addComponent(txtDtPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnParcelado)
                    .addComponent(lblQtdeMensal)
                    .addComponent(txtQtdeMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTxJuros)
                    .addComponent(txtTxJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lxlDtVencto)
                    .addComponent(txtDtVencto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        rbtnAVista.getAccessibleContext().setAccessibleName("rbtnAVista");
        rbtnParcelado.getAccessibleContext().setAccessibleName("rbtnParcelado");
        lblAgencia.getAccessibleContext().setAccessibleName("lblAgencia");
        lblQtdeMensal.getAccessibleContext().setAccessibleName("lblQtdeMensal");
        txtAgencia.getAccessibleContext().setAccessibleName("txtAgencia");
        txtAgencia.getAccessibleContext().setAccessibleDescription("");
        txtQtdeMensal.getAccessibleContext().setAccessibleName("txtQtdeMensal");
        lblNCheque.getAccessibleContext().setAccessibleName("lblNCheque");
        lblTxJuros.getAccessibleContext().setAccessibleName("lblTxJuros");
        txtNCheque.getAccessibleContext().setAccessibleName("txtNCheque");
        txtTxJuros.getAccessibleContext().setAccessibleName("txtTxJuros");
        lblDtPagto.getAccessibleContext().setAccessibleName("lblDtPagto");
        txtDtPagto.getAccessibleContext().setAccessibleName("txtDtPagto");
        lxlDtVencto.getAccessibleContext().setAccessibleName("lxlDtVencto");
        txtDtVencto.getAccessibleContext().setAccessibleName("txtDtVencto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnConsultar)
                        .addGap(30, 30, 30)
                        .addComponent(btnInserir)
                        .addGap(30, 30, 30)
                        .addComponent(btnAlterar)
                        .addGap(30, 30, 30)
                        .addComponent(btnExcluir)
                        .addGap(30, 30, 30)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDtMatricula)
                                .addGap(25, 25, 25)
                                .addComponent(txtDtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCurso)
                                            .addComponent(lblTurma))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCPFAluno)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCPFAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome)
                                        .addGap(15, 15, 15)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblValor)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtMatricula)
                    .addComponent(txtDtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTurma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCPFAluno)
                            .addComponent(txtCPFAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValor)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(20, 20, 20))
        );

        lblDtMatricula.getAccessibleContext().setAccessibleName("lblDtMatricula");
        lblCurso.getAccessibleContext().setAccessibleName("lblCurso");
        lblTurma.getAccessibleContext().setAccessibleName("lblTurma");
        lblCPFAluno.getAccessibleContext().setAccessibleName("lblCPFAluno");
        cmbCurso.getAccessibleContext().setAccessibleName("cmbCurso");
        cmbTurma.getAccessibleContext().setAccessibleName("cmbTurma");
        txtCPFAluno.getAccessibleContext().setAccessibleName("txtCPFAluno");
        txtDtMatricula.getAccessibleContext().setAccessibleName("txtDtMatricula");
        lblValor.getAccessibleContext().setAccessibleName("lblValor");
        lblValor.getAccessibleContext().setAccessibleDescription("");
        lblNome.getAccessibleContext().setAccessibleName("lblNome");
        txtNome.getAccessibleContext().setAccessibleName("txtNome");
        txtValor.getAccessibleContext().setAccessibleName("txtValor");
        btnConsultar.getAccessibleContext().setAccessibleName("btnConsultar");
        btnInserir.getAccessibleContext().setAccessibleName("btnInserir");
        btnAlterar.getAccessibleContext().setAccessibleName("btnAlterar");
        btnExcluir.getAccessibleContext().setAccessibleName("btnExcluir");
        btnSair.getAccessibleContext().setAccessibleName("btnSair");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed

       DecimalFormat dFormat = new DecimalFormat("#,##0.00");
        ArrayList<Turma> turmas;
        turmas = daoTurma.consultarTurmas(cmbCurso.getSelectedItem().toString());
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Turma turma : turmas) {
            modelo.addElement(turma.getSiglaTurma());
        }
        Curso curso = daoCurso.consultar(cmbCurso.getSelectedItem().toString());
        txtValor.setText("R$ " + dFormat.format(curso.getValor()));

        cmbTurma.setModel(modelo);
        cmbTurma.setSelectedIndex(0);
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Conexao con = new Conexao("BD1711046", "BD1711046");
        con.setDriver("oracle.jdbc.driver.OracleDriver");
        con.setConnectionString("jdbc:oracle:thin:@apolo:1521:xe");

        daoTurma = new DaoTurma(con.conectar());
        daoCurso = new DaoCurso(con.conectar());
        daoAluno = new DaoAluno(con.conectar());
        daoAVista = new DaoAVista(con.conectar());
        daoAPrazo = new DaoAPrazo(con.conectar());
        daoInst = new DaoInstrutor(con.conectar());
        daoMatricula = new DaoMatricula(con.conectar());

        ArrayList<Curso> cursos = daoCurso.consultarCursos();
        for (Curso curso : cursos) {
            cmbCurso.addItem(curso.getSigla());
        }
    }//GEN-LAST:event_formWindowOpened

    private void cmbTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTurmaActionPerformed
        txtCPFAluno.setEnabled(true);

    }//GEN-LAST:event_cmbTurmaActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            String cpf = txtCPFAluno.getText().replaceAll("[^0-9]", "");
            if (Aluno.validarCPF(cpf)) {
                Aluno aluno = daoAluno.consultar(cpf);
                if (aluno != null) {

                    txtNome.setText(aluno.getNome());
                    txtCPFAluno.setEnabled(false);
                    btnConsultar.setEnabled(false);
                    rbtnAVista.setEnabled(true);
                    rbtnParcelado.setEnabled(true);
                    rbtnParcelado.setSelected(true);
                    rbtnAVista.setSelected(true);
                    cmbCurso.setEnabled(false);
                    cmbTurma.setEnabled(false);
                    Matricula mat = daoMatricula.consultar(cpf, cmbTurma.getSelectedItem().toString());

                    if (mat != null) {
                        btnInserir.setEnabled(false);
                        btnAlterar.setEnabled(true);
                        btnExcluir.setEnabled(true);
                        txtDtMatricula.setText(mat.getData());
                        if (mat.getAprazo() != null) {

                            rbtnParcelado.setSelected(true);

                        } else {
                            rbtnAVista.setSelected(true);

                        }

                    } else {
                        btnInserir.setEnabled(true);
                        btnAlterar.setEnabled(false);
                        btnExcluir.setEnabled(false);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "CPF não cadastrado para um aluno!", "CPF Inválido", JOptionPane.ERROR_MESSAGE);
                    txtCPFAluno.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Informe um CPF válido!", "CPF Inválido", JOptionPane.ERROR_MESSAGE);
                txtCPFAluno.requestFocus();
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "ERRO: " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            Matricula matricula = formToObject();

            daoMatricula.inserir(matricula);
            JOptionPane.showMessageDialog(this, "A Matrícula foi inserida com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "ERRO: " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            Matricula matricula = formToObject();

            daoMatricula.alterar(matricula);
            JOptionPane.showMessageDialog(this, "A Matrícula foi alterada com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "ERRO: " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void rbtnAVistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnAVistaItemStateChanged
        String cpf = txtCPFAluno.getText().replaceAll("[^0-9]", "");
        Matricula mat = daoMatricula.consultar(cpf, cmbTurma.getSelectedItem().toString());

        txtAgencia.setEnabled(true);
        txtNCheque.setEnabled(true);
        txtDtPagto.setEnabled(true);

        txtQtdeMensal.setEnabled(false);
        txtTxJuros.setEnabled(false);
        txtDtVencto.setEnabled(false);

        if (mat.getAvista() != null) {
            txtAgencia.setText(String.valueOf(mat.getAvista().getAgencia()));
            txtNCheque.setText(String.valueOf(mat.getAvista().getNCheque()));
            txtDtPagto.setText(String.valueOf(mat.getAvista().getPreData()));
        }

        txtQtdeMensal.setText("");
        txtTxJuros.setText("");
        txtDtVencto.setText("");
    }//GEN-LAST:event_rbtnAVistaItemStateChanged

    private void rbtnParceladoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnParceladoItemStateChanged
        String cpf = txtCPFAluno.getText().replaceAll("[^0-9]", "");
        Matricula mat = daoMatricula.consultar(cpf, cmbTurma.getSelectedItem().toString());

        txtQtdeMensal.setEnabled(true);
        txtTxJuros.setEnabled(true);
        txtDtVencto.setEnabled(true);

        txtAgencia.setEnabled(false);
        txtNCheque.setEnabled(false);
        txtDtPagto.setEnabled(false);
        if (mat.getAprazo() != null) {
            txtQtdeMensal.setText(String.valueOf(mat.getAprazo().getQtdeMensalidade()));
            txtTxJuros.setText(String.valueOf(mat.getAprazo().getTaxaJuros()));
            txtDtVencto.setText(String.valueOf(mat.getAprazo().getDtVencimento()));
        }

        txtAgencia.setText("");
        txtNCheque.setText("");
        txtDtPagto.setText("");
    }//GEN-LAST:event_rbtnParceladoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmEfetuarMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEfetuarMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEfetuarMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEfetuarMat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEfetuarMat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgPagamento;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JComboBox<String> cmbTurma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblCPFAluno;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDtMatricula;
    private javax.swing.JLabel lblDtPagto;
    private javax.swing.JLabel lblNCheque;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQtdeMensal;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JLabel lblTxJuros;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lxlDtVencto;
    private javax.swing.JRadioButton rbtnAVista;
    private javax.swing.JRadioButton rbtnParcelado;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JFormattedTextField txtCPFAluno;
    private javax.swing.JFormattedTextField txtDtMatricula;
    private javax.swing.JFormattedTextField txtDtPagto;
    private javax.swing.JFormattedTextField txtDtVencto;
    private javax.swing.JTextField txtNCheque;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQtdeMensal;
    private javax.swing.JTextField txtTxJuros;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
    DaoCurso daoCurso;
    DaoTurma daoTurma;
    DaoAluno daoAluno;
    DaoAVista daoAVista;
    DaoAPrazo daoAPrazo;
    DaoInstrutor daoInst;
    DaoMatricula daoMatricula;
}
