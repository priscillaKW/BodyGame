package jogoanatomia.telas;

import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import jogoanatomia.entidades.FasesDicas;

public class EscolheJogo extends javax.swing.JFrame {

    static EscolheJogo singleton;
    
    public static EscolheJogo getInstance(){
        if (singleton==null){
            singleton=new EscolheJogo();
        }
        return singleton;
    }

    public EscolheJogo() {
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
        Associacao.getInstance().setVisible(true);
        Associacao.getInstance().limpa();
        Associacao.getInstance().inicio();
        Associacao.getInstance().setPontuacaoTotal(0);
    }//GEN-LAST:event_jBassociacaoActionPerformed

    private void jBforcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBforcaActionPerformed
        Forca.getInstance().setVisible(true);
        Forca.getInstance().inicio();
        Forca.getInstance().setPontuacao(600);
        Forca.getInstance().setPontuacaoTotal(0);
    }//GEN-LAST:event_jBforcaActionPerformed

    private void jBperguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBperguntasActionPerformed
        Perguntas.getInstance().setVisible(true);
        Perguntas.getInstance().inicio();
        Perguntas.getInstance().setVidas(3);
        Perguntas.getInstance().setPontuacaoTotal(0);
        Perguntas.getInstance().setQuestao(1);
    }//GEN-LAST:event_jBperguntasActionPerformed

    private void jBcacaPalavrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcacaPalavrasActionPerformed
        CacaPalavras.getInstance().setVisible(true);
        CacaPalavras.getInstance().inicio();
        CacaPalavras.getInstance().setPontuacaoTotal(0);
        CacaPalavras.getInstance().setFaltaEncontrar(10);
    }//GEN-LAST:event_jBcacaPalavrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBassociacao;
    private javax.swing.JButton jBcacaPalavras;
    private javax.swing.JButton jBforca;
    private javax.swing.JButton jBperguntas;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
