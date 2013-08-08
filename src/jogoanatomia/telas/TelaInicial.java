package jogoanatomia.telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaInicial extends javax.swing.JFrame {

    static TelaInicial singleton;
    
    public static TelaInicial getInstance(){
        if (singleton==null){
            singleton=new TelaInicial();
        }
        return singleton;
    }
    
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBestudar = new javax.swing.JButton();
        jBjogar = new javax.swing.JButton();
        jBranking = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BodyGame");
        setBounds(new java.awt.Rectangle(300, 50, 0, 0));
        setMaximumSize(new java.awt.Dimension(590, 520));
        setMinimumSize(new java.awt.Dimension(590, 520));
        setPreferredSize(new java.awt.Dimension(590, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBestudar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBestudar.setForeground(new java.awt.Color(153, 0, 0));
        jBestudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/1369963189_notebook.png"))); // NOI18N
        jBestudar.setText("Estudar");
        jBestudar.setMaximumSize(new java.awt.Dimension(690, 230));
        jBestudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBestudarActionPerformed(evt);
            }
        });
        getContentPane().add(jBestudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 130, -1));

        jBjogar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBjogar.setForeground(new java.awt.Color(153, 0, 0));
        jBjogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/1369963184_game.png"))); // NOI18N
        jBjogar.setText("Jogar");
        jBjogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBjogarActionPerformed(evt);
            }
        });
        getContentPane().add(jBjogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 130, -1));

        jBranking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBranking.setForeground(new java.awt.Color(153, 0, 0));
        jBranking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/winners.png"))); // NOI18N
        jBranking.setText("Ranking");
        jBranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrankingActionPerformed(evt);
            }
        });
        getContentPane().add(jBranking, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 130, 50));

        jBsair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBsair.setForeground(new java.awt.Color(153, 0, 0));
        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 83, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/fundo_Inicial.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBjogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBjogarActionPerformed
        EscolheJogo.getInstance().setVisible(true);
    }//GEN-LAST:event_jBjogarActionPerformed

    private void jBestudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBestudarActionPerformed
        EscolheParteCorpo.getInstance().setVisible(true);
        EscolheParteCorpo.getInstance().inicio();
    }//GEN-LAST:event_jBestudarActionPerformed

    private void jBrankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrankingActionPerformed
        TelaRanking.getInstance().setVisible(true);
    }//GEN-LAST:event_jBrankingActionPerformed

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        JOptionPane.showMessageDialog(this, "Volte sempre!");
        this.dispose();
    }//GEN-LAST:event_jBsairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBestudar;
    private javax.swing.JButton jBjogar;
    private javax.swing.JButton jBranking;
    private javax.swing.JButton jBsair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
