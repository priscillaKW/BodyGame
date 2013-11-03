package jogoanatomia.telas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import jogoanatomia.entidades.Organ;

public class TelaEscolheJogo extends javax.swing.JFrame {

    public Icon icon;

    static Organ orgao;

    public Forca forca;
    
    public void setOrgao(Organ orgao) {
        this.orgao = orgao;
    }
    
    public TelaEscolheJogo() {
        initComponents();
        icon = new ImageIcon(getClass().getResource("/images/trophy.png"), "Troféu");
        orgao = new Organ();
  /*      //Forca completa?
        if(jogosActor.jogoCompletoPorOrgao(1, Integer.parseInt(orgao.getId()))) jBforca.setIcon(icon);
        //Associação completa?
        if(jogosActor.jogoCompletoPorOrgao(2,Integer.parseInt(orgao.getId()))) jBassociacao.setIcon(icon);
        //Caça-Palavras completa?
        if(jogosActor.jogoCompletoPorOrgao(3,Integer.parseInt(orgao.getId()))) jBcacaPalavras.setIcon(icon);
        //Quiz completo?
        if(jogosActor.jogoCompletoPorOrgao(4,Integer.parseInt(orgao.getId()))) jBperguntas.setIcon(icon); */
    }

    public static void main(String[] args) {
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
                new TelaEscolheJogo().setVisible(true);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBforca = new javax.swing.JButton();
        jBcacaPalavras = new javax.swing.JButton();
        jBassociacao = new javax.swing.JButton();
        jBperguntas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Escolha o Jogo");
        setBounds(new java.awt.Rectangle(300, 50, 0, 0));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setResizable(false);

        jBforca.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jBforca.setForeground(new java.awt.Color(153, 0, 0));
        jBforca.setText("Forca");
        jBforca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBforcaActionPerformed(evt);
            }
        });

        jBcacaPalavras.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jBcacaPalavras.setForeground(new java.awt.Color(153, 0, 0));
        jBcacaPalavras.setText("Caça-Palavras");
        jBcacaPalavras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcacaPalavrasActionPerformed(evt);
            }
        });

        jBassociacao.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jBassociacao.setForeground(new java.awt.Color(153, 0, 0));
        jBassociacao.setText("Associação");
        jBassociacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBassociacaoActionPerformed(evt);
            }
        });

        jBperguntas.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jBperguntas.setForeground(new java.awt.Color(153, 0, 0));
        jBperguntas.setText("Quiz");
        jBperguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBperguntasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Escolha um jogo!");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Complete os 4 jogos para ganhar a parte do corpo correspondente!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBperguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBforca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBcacaPalavras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBassociacao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addComponent(jBforca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBassociacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBcacaPalavras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBperguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBassociacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBassociacaoActionPerformed

    }//GEN-LAST:event_jBassociacaoActionPerformed

    private void jBforcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBforcaActionPerformed
       forca = new Forca(orgao);       
    }//GEN-LAST:event_jBforcaActionPerformed

    private void jBperguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBperguntasActionPerformed

    }//GEN-LAST:event_jBperguntasActionPerformed

    private void jBcacaPalavrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcacaPalavrasActionPerformed

    }//GEN-LAST:event_jBcacaPalavrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBassociacao;
    private javax.swing.JButton jBcacaPalavras;
    private javax.swing.JButton jBforca;
    private javax.swing.JButton jBperguntas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
