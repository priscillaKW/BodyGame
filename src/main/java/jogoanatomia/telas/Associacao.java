package jogoanatomia.telas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.media.j3d.Canvas3D;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import jogoanatomia.entidades.AssociationGame;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.actor.AssociacaoActor;
import jogoanatomia.loader.CarregaObj;
import jogoanatomia.loader.CarregaStereo;
import jogoanatomia.services.GameServiceImpl;

public class Associacao extends javax.swing.JFrame {

    Organ orgao;
    
    AssociacaoActor associacaoActor;
    
    AssociationGame fase;
    
     public CarregaObj carregaObj;
    
    public CarregaStereo carregaStereo;

    public Timer timer;
    public int current;

    public void setOrgao(Organ orgao) {
        this.orgao = orgao;
    }

    public Associacao(Organ orgao) {
        initComponents();
        associacaoActor = new AssociacaoActor(new GameServiceImpl(), SessionStore.getLoggedUser(), orgao);
        setOrgao(orgao);
        limpa();

        fase = associacaoActor.nextStage();
        jLdica1.setText(associacaoActor.fasesOriginal.get(0).getTip());
        jLdica2.setText(associacaoActor.fasesOriginal.get(1).getTip());
        jLdica3.setText(associacaoActor.fasesOriginal.get(2).getTip());
        jLdica4.setText(associacaoActor.fasesOriginal.get(3).getTip());
        jLdica5.setText(associacaoActor.fasesOriginal.get(4).getTip());
        jRBresp1.setText(associacaoActor.fasesEmbaralhadas.get(0).getAnswer());
        jRBresp2.setText(associacaoActor.fasesEmbaralhadas.get(1).getAnswer());
        jRBresp3.setText(associacaoActor.fasesEmbaralhadas.get(2).getAnswer());
        jRBresp4.setText(associacaoActor.fasesEmbaralhadas.get(3).getAnswer());
        jRBresp5.setText(associacaoActor.fasesEmbaralhadas.get(4).getAnswer());
        setCurrent(40);
        jLtempo.setText(getCurrent() + "");
        goTimer();
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
        associacaoActor.finish();
        TelaEscolheJogo escolheJogo = new TelaEscolheJogo(orgao);
        this.dispose();
        escolheJogo.setVisible(true);
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void limpa() {
        jLdica1.setText("");
        jLdica2.setText("");
        jLdica3.setText("");
        jLdica4.setText("");
        jLdica5.setText("");
        jRBresp1.setText("");
        jRBresp2.setText("");
        jRBresp3.setText("");
        jRBresp4.setText("");
        jRBresp5.setText("");
        jTF1.setText("");
        jTF2.setText("");
        jTF3.setText("");
        jTF4.setText("");
        jTF5.setText("");
        if (timer != null) {
            timer.stop();
        }
    }

    public void goTimer() {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jLtempo.setText(--current + "");
                if (current == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Ops, você perdeu!", "AVISO", 1, null);
                    disposeAndBackToGameSelection();
                }
            }
        };
        this.timer = new Timer(1000, action);
        this.timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGdicas = new javax.swing.ButtonGroup();
        BGrespostas = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLpontuacaoTotal = new javax.swing.JLabel();
        jPanelOrgao = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLdica1 = new javax.swing.JLabel();
        jLdica2 = new javax.swing.JLabel();
        jLdica3 = new javax.swing.JLabel();
        jLdica4 = new javax.swing.JLabel();
        jLdica5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTF1 = new javax.swing.JTextField();
        jTF2 = new javax.swing.JTextField();
        jTF3 = new javax.swing.JTextField();
        jTF4 = new javax.swing.JTextField();
        jTF5 = new javax.swing.JTextField();
        jRBresp1 = new javax.swing.JLabel();
        jRBresp2 = new javax.swing.JLabel();
        jRBresp3 = new javax.swing.JLabel();
        jRBresp4 = new javax.swing.JLabel();
        jRBresp5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLtempo = new javax.swing.JLabel();
        jRadioButtonStereo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Jogo de Associação");
        setMaximumSize(new java.awt.Dimension(1142, 600));
        setMinimumSize(new java.awt.Dimension(1142, 600));
        setPreferredSize(new java.awt.Dimension(1142, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel12.setText("Pontuação Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, 20));

        jLabel11.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Jogo de Associação");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLpontuacaoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpontuacaoTotal.setText("0");
        getContentPane().add(jLpontuacaoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 50, -1));

        jPanelOrgao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelOrgaoLayout = new javax.swing.GroupLayout(jPanelOrgao);
        jPanelOrgao.setLayout(jPanelOrgaoLayout);
        jPanelOrgaoLayout.setHorizontalGroup(
            jPanelOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        jPanelOrgaoLayout.setVerticalGroup(
            jPanelOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelOrgao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 550, 410));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("1 -");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("2 -");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("3 -");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("4 -");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("5 -");

        jLdica1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLdica1.setText("-");
        jLdica1.setName("dica1"); // NOI18N

        jLdica2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLdica2.setText("-");
        jLdica2.setName("dica2"); // NOI18N

        jLdica3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLdica3.setText("-");
        jLdica3.setName("dica3"); // NOI18N

        jLdica4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLdica4.setText("-");
        jLdica4.setName("dica4"); // NOI18N

        jLdica5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLdica5.setText("-");
        jLdica5.setName("dica5"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLdica1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLdica2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLdica3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLdica5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLdica4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLdica1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLdica2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLdica3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLdica4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLdica5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 560, 170));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTF1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF1.setForeground(new java.awt.Color(153, 0, 0));

        jTF2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF2.setForeground(new java.awt.Color(153, 0, 0));

        jTF3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF3.setForeground(new java.awt.Color(153, 0, 0));

        jTF4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF4.setForeground(new java.awt.Color(153, 0, 0));

        jTF5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF5.setForeground(new java.awt.Color(153, 0, 0));

        jRBresp1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresp1.setText("-");
        jRBresp1.setName("resp1"); // NOI18N

        jRBresp2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresp2.setText("-");
        jRBresp2.setName("resp2"); // NOI18N

        jRBresp3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresp3.setText("-");
        jRBresp3.setName("resp3"); // NOI18N

        jRBresp4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresp4.setText("-");
        jRBresp4.setName("resp4"); // NOI18N

        jRBresp5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBresp5.setText("-");
        jRBresp5.setName("resp5"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBresp1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRBresp5, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                            .addComponent(jRBresp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRBresp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRBresp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBresp1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBresp2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBresp3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBresp4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBresp5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 560, -1));

        jButton1.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setText("Associar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel9.setText("Tempo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, -1, -1));

        jLtempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLtempo.setForeground(new java.awt.Color(153, 0, 0));
        jLtempo.setText("-");
        getContentPane().add(jLtempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 38, -1));

        jRadioButtonStereo.setText("Stereoscopia");
        jRadioButtonStereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStereoActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonStereo, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 460, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTF1.getText().equals("") || jTF2.getText().equals("") || jTF3.getText().equals("") || jTF4.getText().equals("") || jTF5.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ops, você esqueceu de associar alguma coisa!", "AVISO", 1, null);
        } else {
            ArrayList<Integer> resp = new ArrayList();
            resp.add(Integer.parseInt(jTF1.getText()));
            resp.add(Integer.parseInt(jTF2.getText()));
            resp.add(Integer.parseInt(jTF3.getText()));
            resp.add(Integer.parseInt(jTF4.getText()));
            resp.add(Integer.parseInt(jTF5.getText()));
            boolean certo = true;

            for (int i = 0; i < resp.size(); i++) {
                if (!(resp.get(i) == (associacaoActor.ordemRespostas.get(i) + 1))) {
                    certo = false;
                }
            }

            if (certo) {
                JOptionPane.showMessageDialog(rootPane, "Parabéns! Você completou essa rodada! Vamos para a próxima!", "AVISO", 1, null);
                jLpontuacaoTotal.setText(associacaoActor.getActualStage() + "/" + associacaoActor.getTotalStages());

                fase = associacaoActor.nextStage();

                if (fase == null) {
                    JOptionPane.showMessageDialog(rootPane, "Não há mais fases para este jogo!", "AVISO", 1, null);
                    disposeAndBackToGameSelection();
                } else {
                    limpa();
                    jLdica1.setText(associacaoActor.fasesOriginal.get(0).getTip());
                    jLdica2.setText(associacaoActor.fasesOriginal.get(1).getTip());
                    jLdica3.setText(associacaoActor.fasesOriginal.get(2).getTip());
                    jLdica4.setText(associacaoActor.fasesOriginal.get(3).getTip());
                    jLdica5.setText(associacaoActor.fasesOriginal.get(4).getTip());
                    jRBresp1.setText(associacaoActor.fasesEmbaralhadas.get(0).getAnswer());
                    jRBresp2.setText(associacaoActor.fasesEmbaralhadas.get(1).getAnswer());
                    jRBresp3.setText(associacaoActor.fasesEmbaralhadas.get(2).getAnswer());
                    jRBresp4.setText(associacaoActor.fasesEmbaralhadas.get(3).getAnswer());
                    jRBresp5.setText(associacaoActor.fasesEmbaralhadas.get(4).getAnswer());
                    setCurrent(40);
                    jLtempo.setText(getCurrent() + "");
                    goTimer();
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Ops, você perdeu!", "AVISO", 1, null);
                disposeAndBackToGameSelection();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.ButtonGroup BGdicas;
    private javax.swing.ButtonGroup BGrespostas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLdica1;
    private javax.swing.JLabel jLdica2;
    private javax.swing.JLabel jLdica3;
    private javax.swing.JLabel jLdica4;
    private javax.swing.JLabel jLdica5;
    private javax.swing.JLabel jLpontuacaoTotal;
    private javax.swing.JLabel jLtempo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelOrgao;
    private javax.swing.JLabel jRBresp1;
    private javax.swing.JLabel jRBresp2;
    private javax.swing.JLabel jRBresp3;
    private javax.swing.JLabel jRBresp4;
    private javax.swing.JLabel jRBresp5;
    private javax.swing.JRadioButton jRadioButtonStereo;
    private javax.swing.JTextField jTF1;
    private javax.swing.JTextField jTF2;
    private javax.swing.JTextField jTF3;
    private javax.swing.JTextField jTF4;
    private javax.swing.JTextField jTF5;
    // End of variables declaration//GEN-END:variables
}
