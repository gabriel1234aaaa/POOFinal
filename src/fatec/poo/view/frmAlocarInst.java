/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

/**
 *
 * @author 0030481711010
 */
public class frmAlocarInst extends javax.swing.JFrame {

    /**
     * Creates new form frmAlocarInst
     */
    public frmAlocarInst() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurso = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        lblTurma = new javax.swing.JLabel();
        cmbTurma = new javax.swing.JComboBox<>();
        lblInstrutor = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        cmbSituacao = new javax.swing.JLabel();
        txtSituacao = new javax.swing.JTextField();
        btnAlocar = new javax.swing.JButton();
        btnLiberar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alocar Instrutor");
        setSize(new java.awt.Dimension(90, 90));

        lblCurso.setText("Curso");

        lblTurma.setText("Turma");

        lblInstrutor.setText("Instrutor");

        cmbSituacao.setText("Situação");

        txtSituacao.setEnabled(false);

        btnAlocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnAlocar.setText("Alocar");

        btnLiberar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Eraser.png"))); // NOI18N
        btnLiberar.setText("Liberar");
        btnLiberar.setEnabled(false);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbSituacao)
                        .addGap(15, 15, 15)
                        .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInstrutor)
                        .addGap(13, 13, 13)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurso)
                            .addComponent(lblTurma))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlocar)
                .addGap(18, 18, 18)
                .addComponent(btnLiberar)
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurma)
                    .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstrutor)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSituacao)
                    .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnLiberar)
                    .addComponent(btnAlocar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lblCurso.getAccessibleContext().setAccessibleName("lblCurso");
        cmbCurso.getAccessibleContext().setAccessibleName("cmbCurso");
        cmbCurso.getAccessibleContext().setAccessibleDescription("");
        lblTurma.getAccessibleContext().setAccessibleName("lblTurma");
        cmbTurma.getAccessibleContext().setAccessibleName("cmbTurma");
        lblInstrutor.getAccessibleContext().setAccessibleName("lblInstrutor");
        cmbSituacao.getAccessibleContext().setAccessibleName("cmbSituacao");
        txtSituacao.getAccessibleContext().setAccessibleName("txtSituacao");
        btnAlocar.getAccessibleContext().setAccessibleName("btnAlocar");
        btnLiberar.getAccessibleContext().setAccessibleName("btnLiberar");
        btnSair.getAccessibleContext().setAccessibleName("btnSair");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(frmAlocarInst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAlocarInst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAlocarInst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAlocarInst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAlocarInst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocar;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JLabel cmbSituacao;
    private javax.swing.JComboBox<String> cmbTurma;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblInstrutor;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JTextField txtSituacao;
    // End of variables declaration//GEN-END:variables
}
