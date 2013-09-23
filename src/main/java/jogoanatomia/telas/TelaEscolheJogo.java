<<<<<<< HEAD:src/main/java/jogoanatomia/telas/TelaEscolheJogo.java
package jogoanatomia.telas;

import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import jogoanatomia.entidades.FasesDicas;

public class TelaEscolheJogo extends javax.swing.JFrame {

    static TelaEscolheJogo singleton;
    
    public static TelaEscolheJogo getInstance(){
        if (singleton==null){
            singleton=new TelaEscolheJogo();
        }
        return singleton;
    }

    public TelaEscolheJogo() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBforca = new javax.swing.JButton();
        jBcacaPalavras = new javax.swing.JButton();
        jBassociacao = new javax.swing.JButton();
        jBperguntas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Escolha o Jogo");
        setBounds(new java.awt.Rectangle(300, 50, 0, 0));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBforca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBforca.setForeground(new java.awt.Color(153, 0, 0));
        jBforca.setText("Forca");
        jBforca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBforcaActionPerformed(evt);
            }
        });
        getContentPane().add(jBforca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 140, -1));

        jBcacaPalavras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBcacaPalavras.setForeground(new java.awt.Color(153, 0, 0));
        jBcacaPalavras.setText("Caça-Palavras");
        jBcacaPalavras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcacaPalavrasActionPerformed(evt);
            }
        });
        getContentPane().add(jBcacaPalavras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, -1));

        jBassociacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBassociacao.setForeground(new java.awt.Color(153, 0, 0));
        jBassociacao.setText("Jogo de Associação");
        jBassociacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBassociacaoActionPerformed(evt);
            }
        });
        getContentPane().add(jBassociacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, -1));

        jBperguntas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBperguntas.setForeground(new java.awt.Color(153, 0, 0));
        jBperguntas.setText("Quiz");
        jBperguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBperguntasActionPerformed(evt);
            }
        });
        getContentPane().add(jBperguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Escolha um jogo!");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 11, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBassociacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBassociacaoActionPerformed

    }//GEN-LAST:event_jBassociacaoActionPerformed

    private void jBforcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBforcaActionPerformed

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
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
=======
package jogoanatomia.telas;

import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import jogoanatomia.entidades.FasesDicas;

public class TelaEscolheJogo extends javax.swing.JFrame {

    static TelaEscolheJogo singleton;
    
    public static TelaEscolheJogo getInstance(){
        if (singleton==null){
            singleton=new TelaEscolheJogo();
        }
        return singleton;
    }

    public TelaEscolheJogo() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBforca = new javax.swing.JButton();
        jBcacaPalavras = new javax.swing.JButton();
        jBassociacao = new javax.swing.JButton();
        jBperguntas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Escolha o Jogo");
        setBounds(new java.awt.Rectangle(300, 50, 0, 0));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBforca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBforca.setForeground(new java.awt.Color(153, 0, 0));
        jBforca.setText("Forca");
        jBforca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBforcaActionPerformed(evt);
            }
        });
        getContentPane().add(jBforca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 140, -1));

        jBcacaPalavras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBcacaPalavras.setForeground(new java.awt.Color(153, 0, 0));
        jBcacaPalavras.setText("Caça-Palavras");
        jBcacaPalavras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcacaPalavrasActionPerformed(evt);
            }
        });
        getContentPane().add(jBcacaPalavras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, -1));

        jBassociacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBassociacao.setForeground(new java.awt.Color(153, 0, 0));
        jBassociacao.setText("Jogo de Associação");
        jBassociacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBassociacaoActionPerformed(evt);
            }
        });
        getContentPane().add(jBassociacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, -1));

        jBperguntas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBperguntas.setForeground(new java.awt.Color(153, 0, 0));
        jBperguntas.setText("Quiz");
        jBperguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBperguntasActionPerformed(evt);
            }
        });
        getContentPane().add(jBperguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Escolha um jogo!");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 11, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBassociacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBassociacaoActionPerformed

    }//GEN-LAST:event_jBassociacaoActionPerformed

    private void jBforcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBforcaActionPerformed

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
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
>>>>>>> 98a7f4c2fb3e78942486d7139b4f74a526e56950:src/main/java/jogoanatomia/telas/TelaEscolheJogo.java
