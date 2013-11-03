package jogoanatomia.telas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.media.j3d.Canvas3D;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.QuizGame;
import jogoanatomia.entidades.actor.QuizActor;
import jogoanatomia.loader.CarregaObj;
import jogoanatomia.loader.CarregaStereo;
import jogoanatomia.services.GameServiceImpl;


public class Quiz extends javax.swing.JFrame {

    public CarregaObj carregaObj;
    
    public CarregaStereo carregaStereo;
    
    public Organ orgao;
    
    public QuizActor quizActor;
    
    public QuizGame fase;
    
    Timer timer;  
    
    int current = 120;  

    
    public Quiz(Organ orgao) {
        quizActor = new QuizActor(new GameServiceImpl(), SessionStore.getLoggedUser(), orgao);
        fase = quizActor.nextStage();
        this.orgao = orgao;
        initComponents();
        carregaObj = new CarregaObj();
        String file = orgao.getImageFileName();
        carregaObj.setFile(file);
        Canvas3D c = carregaObj.carregaOrgao();
        atualizaPanel(c);   
    }
    
    public void reinicializaCampos(){
        jLPergunta.setText(fase.getAnswer());
        if (fase.getOptionA().length() > 70) {
            jRBresposta1.setText(quizActor.naoCabeLable(fase.getOptionA()));
        } else {
            jRBresposta1.setText(fase.getOptionA());
        }
        
        if (fase.getOptionB().length() > 70) {
            jRBresposta2.setText(quizActor.naoCabeLable(fase.getOptionB()));
        } else {
            jRBresposta2.setText(fase.getOptionB());
        }
        
        if (fase.getOptionC().length() > 70) {
            jRBresposta3.setText(quizActor.naoCabeLable(fase.getOptionC()));
        } else {
            jRBresposta3.setText(fase.getOptionC());
        }
        
        if (fase.getOptionD().length() > 70) {
            jRBresposta4.setText(quizActor.naoCabeLable(fase.getOptionD()));
        } else {
            jRBresposta4.setText(fase.getOptionD());
        }
        
        jRBresposta1.setSelected(false);
        jRBresposta2.setSelected(false);
        jRBresposta3.setSelected(false);
        jRBresposta4.setSelected(false);
        jLquestao.setText(fase.getQuestion()+"");
        if (timer!=null) {
            timer.stop();
        }                

    }
    
    public void atualizaPanel(Canvas3D c){
        jPanelOrgao.removeAll();
        jPanelOrgao.setLayout(new BorderLayout(10, 0));
        jPanelOrgao.add(c);
        jPanelOrgao.updateUI();    
    }
    
    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
    
    public void goTimer() {  
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                jLtempo.setText(--current + "");
                if(current==0){
                    JOptionPane.showMessageDialog(rootPane, "Ops!! Você perdeu!", "AVISO", 1, null);    
                }
            }  
        };  
        this.timer = new Timer(1000, action);  
        this.timer.start();  
    }
    
    public String getResposta(){
        if(jRBresposta1.isSelected()) {
            return "a";
        }
        else if(jRBresposta2.isSelected()) {
            return "b";
        }
        else if(jRBresposta3.isSelected()) {
            return "c";
        }
        else if(jRBresposta4.isSelected()) {
            return "d";
        }
        else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGrespostas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLPergunta = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLquestao = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLtempo = new javax.swing.JLabel();
        jBresponder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRBresposta1 = new javax.swing.JRadioButton();
        jRBresposta2 = new javax.swing.JRadioButton();
        jRBresposta3 = new javax.swing.JRadioButton();
        jRBresposta4 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jPanelOrgao = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLpontuacaoTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonStereo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Quiz");
        setBounds(new java.awt.Rectangle(300, 0, 580, 720));
        setMinimumSize(new java.awt.Dimension(1131, 579));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLPergunta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPergunta.setText("-");

        jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel5.setText("Questão:");

        jLquestao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLquestao.setText("-");

        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel9.setText("Tempo:");

        jLtempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLtempo.setForeground(new java.awt.Color(153, 0, 0));
        jLtempo.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLquestao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLtempo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLquestao))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLtempo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLPergunta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 550, 70));

        jBresponder.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jBresponder.setForeground(new java.awt.Color(153, 0, 0));
        jBresponder.setText("Responder");
        jBresponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBresponderActionPerformed(evt);
            }
        });
        getContentPane().add(jBresponder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jRBresposta1.setBackground(new java.awt.Color(255, 255, 255));
        BGrespostas.add(jRBresposta1);
        jRBresposta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresposta1.setText("-");
        jRBresposta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBresposta1ActionPerformed(evt);
            }
        });
        jRBresposta1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRBresposta1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRBresposta1KeyReleased(evt);
            }
        });

        jRBresposta2.setBackground(new java.awt.Color(255, 255, 255));
        BGrespostas.add(jRBresposta2);
        jRBresposta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresposta2.setText("-");
        jRBresposta2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRBresposta2KeyPressed(evt);
            }
        });

        jRBresposta3.setBackground(new java.awt.Color(255, 255, 255));
        BGrespostas.add(jRBresposta3);
        jRBresposta3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresposta3.setText("-");
        jRBresposta3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRBresposta3KeyPressed(evt);
            }
        });

        jRBresposta4.setBackground(new java.awt.Color(255, 255, 255));
        BGrespostas.add(jRBresposta4);
        jRBresposta4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresposta4.setText("-");
        jRBresposta4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRBresposta4KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBresposta1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jRBresposta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRBresposta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRBresposta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBresposta1)
                .addGap(55, 55, 55)
                .addComponent(jRBresposta2)
                .addGap(59, 59, 59)
                .addComponent(jRBresposta3)
                .addGap(56, 56, 56)
                .addComponent(jRBresposta4)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 550, 340));

        jLabel11.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Quiz");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        jPanelOrgao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelOrgaoLayout = new javax.swing.GroupLayout(jPanelOrgao);
        jPanelOrgao.setLayout(jPanelOrgaoLayout);
        jPanelOrgaoLayout.setHorizontalGroup(
            jPanelOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        jPanelOrgaoLayout.setVerticalGroup(
            jPanelOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelOrgao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 550, 420));

        jLabel12.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel12.setText("Pontuação Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        jLpontuacaoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpontuacaoTotal.setText("-");
        getContentPane().add(jLpontuacaoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/fundo_perguntas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 580));

        jRadioButtonStereo.setText("Stereoscopia");
        jRadioButtonStereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStereoActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonStereo, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 480, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBresponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresponderActionPerformed
        String resp=getResposta();
        if (resp==null){
            JOptionPane.showMessageDialog(rootPane, "Ops!! Você esqueceu de escolher a alternativa!", "AVISO", 1, null);
            return;
        }
        if (resp.equals(fase.getAnswer())) {
            JOptionPane.showMessageDialog(rootPane, "Parabéns! Resposta Correta ;)", "AVISO", 1, null);
            fase = quizActor.nextStage();
            if(fase == null){
                JOptionPane.showMessageDialog(rootPane, "Parabéns! Você completou o jogo!!", "AVISO", 1, null);
            }
            reinicializaCampos();
        } else {
                JOptionPane.showMessageDialog(rootPane, "Ops!! Você perdeu!", "AVISO", 1, null);
                return;
        }        
        
    }//GEN-LAST:event_jBresponderActionPerformed

    private void jRBresposta1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRBresposta1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBresposta1KeyReleased

    private void jRBresposta1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRBresposta1KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jBresponderActionPerformed(null);
        }
    }//GEN-LAST:event_jRBresposta1KeyPressed

    private void jRBresposta2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRBresposta2KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jBresponderActionPerformed(null);
        }
    }//GEN-LAST:event_jRBresposta2KeyPressed

    private void jRBresposta3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRBresposta3KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jBresponderActionPerformed(null);
        }
    }//GEN-LAST:event_jRBresposta3KeyPressed

    private void jRBresposta4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRBresposta4KeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jBresponderActionPerformed(null);
        }
    }//GEN-LAST:event_jRBresposta4KeyPressed

    private void jRBresposta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBresposta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBresposta1ActionPerformed

    private void jRadioButtonStereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStereoActionPerformed
        carregaStereo = new CarregaStereo();
        String file = orgao.getImageFileName();
        carregaStereo.setFileName(file);
        atualizaPanel(carregaStereo.carregaObjeto());
    }//GEN-LAST:event_jRadioButtonStereoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGrespostas;
    private javax.swing.JButton jBresponder;
    private javax.swing.JLabel jLPergunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLpontuacaoTotal;
    private javax.swing.JLabel jLquestao;
    private javax.swing.JLabel jLtempo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelOrgao;
    private javax.swing.JRadioButton jRBresposta1;
    private javax.swing.JRadioButton jRBresposta2;
    private javax.swing.JRadioButton jRBresposta3;
    private javax.swing.JRadioButton jRBresposta4;
    private javax.swing.JRadioButton jRadioButtonStereo;
    // End of variables declaration//GEN-END:variables
}
