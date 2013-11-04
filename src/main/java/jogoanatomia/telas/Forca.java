package jogoanatomia.telas;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.media.j3d.Canvas3D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jogoanatomia.entidades.HangmanGame;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.actor.ForcaActor;
import jogoanatomia.loader.CarregaObj;
import jogoanatomia.loader.CarregaStereo;
import jogoanatomia.services.GameServiceImpl;


public class Forca extends javax.swing.JFrame {

    public Organ orgao;
    
    public ForcaActor forcaActor;
    
    private HangmanGame fase;
    
    public CarregaObj carregaObj;
    
    public CarregaStereo carregaStereo;
    

    public void setOrgao(Organ orgao) {
        this.orgao = orgao;
    }
      
    public Forca(Organ orgao) {
        initComponents();
        forcaActor = new ForcaActor(new GameServiceImpl(), SessionStore.getLoggedUser(), orgao);
        setOrgao(orgao);

        fase = forcaActor.nextStage();
        jTforca.setText(forcaActor.gerarMascara());
        jLdica.setText(fase.getTip());
        jLletras.setText(forcaActor.quantLetras());
        jLletrasErradas.setText("");
        jLforca.setIcon(new ImageIcon(getClass().getResource("images/forca0.png")));
        carregaObj = new CarregaObj();
        String file = orgao.getImageFileName();
        carregaObj.setFile(file);
        Canvas3D c = carregaObj.carregaOrgao();
        atualizaPanel(c);
    }
    
    public void atualizaPanel(Canvas3D c){
        jPanelOrgao.removeAll();
        jPanelOrgao.setLayout(new BorderLayout(10, 0));
        jPanelOrgao.add(c);
        jPanelOrgao.updateUI();    
    }

    private void disposeAndBackToGameSelection() {
        forcaActor.finish();
        TelaEscolheJogo escolheJogo = new TelaEscolheJogo(orgao);
        this.dispose();
        escolheJogo.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLdica = new javax.swing.JLabel();
        jLletras = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTletra = new javax.swing.JTextField();
        jBtentaLetra = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLletrasErradas = new javax.swing.JLabel();
        jTforca = new javax.swing.JTextField();
        jLforca = new javax.swing.JLabel();
        jLpontuacaoTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButtonStereo = new javax.swing.JRadioButton();
        jPanelOrgao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Jogo de Forca");
        setBackground(new java.awt.Color(153, 102, 255));
        setBounds(new java.awt.Rectangle(300, 50, 820, 500));
        setMaximumSize(new java.awt.Dimension(820, 500));
        setMinimumSize(new java.awt.Dimension(820, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Jogo de Forca");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel6.setText("Letras erradas:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLdica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLdica.setText("-");
        getContentPane().add(jLdica, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 380, 20));

        jLletras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLletras.setText("-");
        getContentPane().add(jLletras, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 240, -1));

        jLabel8.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel8.setText("Dica:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 10));

        jTletra.setColumns(1);
        jTletra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTletra.setForeground(new java.awt.Color(102, 0, 0));
        jTletra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTletraKeyPressed(evt);
            }
        });
        getContentPane().add(jTletra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 120, 40));

        jBtentaLetra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/vai.png"))); // NOI18N
        jBtentaLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtentaLetraActionPerformed(evt);
            }
        });
        getContentPane().add(jBtentaLetra, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 40, 40));

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel10.setText("Escolha uma letra:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLletrasErradas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jLletrasErradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 240, 20));

        jTforca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTforca.setForeground(new java.awt.Color(153, 0, 0));
        jTforca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTforca.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        jTforca.setEnabled(false);
        getContentPane().add(jTforca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 310, 20));

        jLforca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/forca0.png"))); // NOI18N
        getContentPane().add(jLforca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 190, 200));

        jLpontuacaoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpontuacaoTotal.setText("-");
        getContentPane().add(jLpontuacaoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 100, -1));

        jLabel12.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel12.setText("Pontuação:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jRadioButtonStereo.setText("Stereoscopia");
        jRadioButtonStereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStereoActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonStereo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        javax.swing.GroupLayout jPanelOrgaoLayout = new javax.swing.GroupLayout(jPanelOrgao);
        jPanelOrgao.setLayout(jPanelOrgaoLayout);
        jPanelOrgaoLayout.setHorizontalGroup(
            jPanelOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanelOrgaoLayout.setVerticalGroup(
            jPanelOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelOrgao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 440, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtentaLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtentaLetraActionPerformed
        if(jTletra.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ops!! Você esqueceu de informar uma letra!", "AVISO", 1, null);
            return;
        }
        char letra = jTletra.getText().toUpperCase().charAt(0);
        jTletra.setText("");
        String resultado = "";
        String palavra = forcaActor.getPalavraForca();
        if (palavra.indexOf(letra) >= 0) {
            for (int i = 0; i < palavra.length(); i++) {
                String temp = jTforca.getText();
                if (palavra.charAt(i) == letra) {
                    resultado = resultado + palavra.charAt(i);
                } else {
                    resultado = resultado + temp.charAt(i);
                }
            }
            jTforca.setText(resultado);
        } else {
            if (forcaActor.listaLetrasErradas.contains(letra + "")) {
                JOptionPane.showMessageDialog(rootPane, "Ops!! Você já tentou essa letra!", "AVISO", 1, null);
            } else {
                jLletrasErradas.setText(jLletrasErradas.getText() + letra + "-");
                forcaActor.setLetrasErradas(forcaActor.getLetrasErradas() + 1);
                forcaActor.listaLetrasErradas.add(letra+"");
                jLforca.setIcon(new ImageIcon(getClass().getResource("images/forca" + forcaActor.getLetrasErradas() + ".png")));
            }
        }
        if(forcaActor.getLetrasErradas()==6){
            JOptionPane.showMessageDialog(rootPane, "Ops!! Você perdeu!", "AVISO", 1, null);
            disposeAndBackToGameSelection();
        }
        if(palavra.equals(jTforca.getText().replace("-", " "))){
            JOptionPane.showMessageDialog(rootPane, "Parabéns!! Você completou o jogo!", "AVISO", 1, null);
            jLpontuacaoTotal.setText((100 * (forcaActor.completedStageCount+1)) / forcaActor.getTotalStages()+"");
            jLletrasErradas.setText("");
            fase = forcaActor.nextStage();
            
            if(fase==null) {
                JOptionPane.showMessageDialog(rootPane, "Não há mais fases para este jogo!", "AVISO", 1, null);
                disposeAndBackToGameSelection();
            } else {
                jTforca.setText(forcaActor.gerarMascara());
                jLdica.setText(fase.getTip());
                jLletras.setText(forcaActor.quantLetras());
                jLletrasErradas.setText("");
                jLforca.setIcon(new ImageIcon(getClass().getResource("images/forca0.png")));
            }
        }
    }//GEN-LAST:event_jBtentaLetraActionPerformed

    private void jTletraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTletraKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jBtentaLetraActionPerformed(null);
        }
    }//GEN-LAST:event_jTletraKeyPressed

    private void jRadioButtonStereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStereoActionPerformed
        carregaStereo = new CarregaStereo();
        String file = orgao.getImageFileName();
        carregaStereo.setFileName(file);
        atualizaPanel(carregaStereo.carregaObjeto());
    }//GEN-LAST:event_jRadioButtonStereoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        disposeAndBackToGameSelection();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtentaLetra;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLdica;
    private javax.swing.JLabel jLforca;
    private javax.swing.JLabel jLletras;
    private javax.swing.JLabel jLletrasErradas;
    private javax.swing.JLabel jLpontuacaoTotal;
    private javax.swing.JPanel jPanelOrgao;
    private javax.swing.JRadioButton jRadioButtonStereo;
    private javax.swing.JTextField jTforca;
    private javax.swing.JTextField jTletra;
    // End of variables declaration//GEN-END:variables
}
