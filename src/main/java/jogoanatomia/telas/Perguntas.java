package jogoanatomia.telas;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.media.j3d.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import jogoanatomia.entidades.FasesPerguntas;
import jogoanatomia.entidades.Organ;
import jogoanatomia.loader.CarregaObj;
import jogoanatomia.loader.CarregaStereo;

public class Perguntas extends javax.swing.JFrame {

    static Perguntas singleton;
    private String letraCerta;
    private int vidas=3;
    private int pontuacaoTotal=0;
    private int questao=1;
    private Canvas3D c;
    public static VirtualUniverse u;
    public Locale myLocale;
    FasesPerguntas fase;

    public int getQuestao() {
        return questao;
    }

    public void setQuestao(int questao) {
        this.questao = questao;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getLetraCerta() {
        return letraCerta;
    }

    public void setLetraCerta(String letraCerta) {
        this.letraCerta = letraCerta;
    }
    
    public static Perguntas getInstance(){
        if (singleton==null){
            singleton=new Perguntas();
        }
        return singleton;
    }

    Timer timer;  
    int current = 120;  

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
    
    public String naoCabeLable(String original) {
        String nova = "<html>";
        int i = 70;
        int j = 0;
        while (i < original.length()) {
            if (original.charAt(i) != ' ') {
                i++;
            } else {
                nova = nova + original.substring(j, i) + "<br>";
                j = i + 1;
                i = i + 70;
            }
        }
        nova = nova + original.substring(j, original.length()) + "</html>";
        return nova;
    }
    
    public FasesPerguntas sorteiaFase(){
        ArrayList<FasesPerguntas> todas = null;
        int i=(int) (Math.random()*todas.size());
        return todas.get(i);
    }
    
    public void inicio(){
        fase = sorteiaFase();
        setLetraCerta(fase.getLetraCerta());
        jLPergunta.setText(fase.getPergunta());
        if (fase.getRespA().length() > 70) {
            jRBresposta1.setText(naoCabeLable(fase.getRespA()));
        } else {
            jRBresposta1.setText(fase.getRespA());
        }
        
        if (fase.getRespB().length() > 70) {
            jRBresposta2.setText(naoCabeLable(fase.getRespB()));
        } else {
            jRBresposta2.setText(fase.getRespB());
        }
        
        if (fase.getRespC().length() > 70) {
            jRBresposta3.setText(naoCabeLable(fase.getRespC()));
        } else {
            jRBresposta3.setText(fase.getRespC());
        }
        
        if (fase.getRespD().length() > 70) {
            jRBresposta4.setText(naoCabeLable(fase.getRespD()));
        } else {
            jRBresposta4.setText(fase.getRespD());
        }
        
        jLnivel.setText(fase.getNivel()+"");
        jRBresposta1.setSelected(false);
        jRBresposta2.setSelected(false);
        jRBresposta3.setSelected(false);
        jRBresposta4.setSelected(false);
        jLvidas.setText(getVidas()+"");
        jLpontuacaoTotal.setText(getPontuacaoTotal()+"");
        jLquestao.setText(getQuestao()+"");
        if (timer!=null) {
            timer.stop();
        }                

	// GraphicsConfiguration[] configurations =
	// defaultScreen.getConfigurations();
	GraphicsConfigTemplate3D g3d = new GraphicsConfigTemplate3D();
	GraphicsEnvironment ge = GraphicsEnvironment
			.getLocalGraphicsEnvironment();
	GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	GraphicsConfiguration gcn = defaultScreen.getBestConfiguration(g3d);
	c = new Canvas3D(gcn);
        // construcao do universo
        u = new VirtualUniverse();
        Organ orgao = null;
        myLocale = new Locale(u);
            CarregaObj CarregaObj = new CarregaObj();
        CarregaObj.setFile("./"+orgao.getName().toLowerCase());
        myLocale.addBranchGraph(CarregaObj.createSceneGraph());
        myLocale.addBranchGraph(CarregaObj.branchGroupLeft(c));
        jPanel3.removeAll();
        jPanel3.setLayout(new BorderLayout(10, 0));
        jPanel3.add(c);
        jPanel3.updateUI();
        // Background
        BranchGroup brbg = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
                100);
        Color3f bgColor = new Color3f(0.0f, 0.7f, 1.0f);
        Background backg = new Background(bgColor);
        backg.setApplicationBounds(bounds);
        brbg.addChild(backg);
        myLocale.addBranchGraph(brbg);
                setCurrent(120);
        jLtempo.setText(getCurrent()+"");
        goTimer();

    }
    
    public void goTimer() {  
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                jLtempo.setText(--current + "");
                if(current==0){
                    JOptionPane.showMessageDialog(rootPane, "Ops!! Você perdeu!", "AVISO", 1, null);
                    setPontuacaoTotal(0);       
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
    
    public Perguntas() {
        initComponents();
        
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
        jLabel7 = new javax.swing.JLabel();
        jLnivel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLvidas = new javax.swing.JLabel();
        jBresponder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRBresposta1 = new javax.swing.JRadioButton();
        jRBresposta2 = new javax.swing.JRadioButton();
        jRBresposta3 = new javax.swing.JRadioButton();
        jRBresposta4 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLpontuacaoTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTBestereoscopia = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Questão:");

        jLquestao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLquestao.setText("-");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tempo:");

        jLtempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLtempo.setForeground(new java.awt.Color(153, 0, 0));
        jLtempo.setText("-");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nível:");

        jLnivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLnivel.setText("-");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Vidas:");

        jLvidas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLvidas.setForeground(new java.awt.Color(153, 0, 0));
        jLvidas.setText("-");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(jLnivel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLvidas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
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
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLvidas))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLtempo))
                    .addComponent(jLnivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLPergunta)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 550, 70));

        jBresponder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                    .addComponent(jRBresposta1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
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
                .addContainerGap(66, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 550, 340));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Quiz");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 550, 420));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Pontuação Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        jLpontuacaoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpontuacaoTotal.setText("-");
        getContentPane().add(jLpontuacaoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 100, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Estereoscopia:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, -1, -1));

        jTBestereoscopia.setText("ON");
        jTBestereoscopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBestereoscopiaActionPerformed(evt);
            }
        });
        getContentPane().add(jTBestereoscopia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/fundo_perguntas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBresponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresponderActionPerformed
        String resp=getResposta();
        if (resp==null){
            JOptionPane.showMessageDialog(rootPane, "Ops!! Você esqueceu de escolher a alternativa!", "AVISO", 1, null);
            return;
        }
        if (resp.equals(letraCerta)) {
            setPontuacaoTotal(getPontuacaoTotal()+getCurrent());
            jLpontuacaoTotal.setText(getPontuacaoTotal()+"");
        } else {
            setVidas(getVidas() - 1);
            if (getVidas() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Ops!! Você perdeu!", "AVISO", 1, null);
                setVidas(3);
                setPontuacaoTotal(0);
                setQuestao(1);
                return;
            }
        }
        setQuestao(getQuestao()+1);
        inicio();
    }//GEN-LAST:event_jBresponderActionPerformed

    private void jTBestereoscopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBestereoscopiaActionPerformed
        Organ orgao = null;
        GraphicsConfigTemplate3D g3d = new GraphicsConfigTemplate3D();
	GraphicsEnvironment ge = GraphicsEnvironment
			.getLocalGraphicsEnvironment();
	GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	GraphicsConfiguration gcn = defaultScreen.getBestConfiguration(g3d);
	c = new Canvas3D(gcn);
        // construcao do universo
        u = new VirtualUniverse();
        myLocale = new Locale(u);
            CarregaStereo CarregaObj = new CarregaStereo();
        CarregaObj.setFileName("./"+orgao.getName().toLowerCase());
        myLocale.addBranchGraph(CarregaObj.createSceneGraph());
        myLocale.addBranchGraph(CarregaObj.branchGroupLeft(c));
        jPanel3.removeAll();
        jPanel3.setLayout(new BorderLayout(10, 0));
        jPanel3.add(c);
        jPanel3.updateUI();
        // Background
        BranchGroup brbg = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
                400);
        Color3f bgColor = new Color3f(0f, 0f, 0f);
        Background backg = new Background(bgColor);
        backg.setApplicationBounds(bounds);
        brbg.addChild(backg);
        myLocale.addBranchGraph(brbg);
    }//GEN-LAST:event_jTBestereoscopiaActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGrespostas;
    private javax.swing.JButton jBresponder;
    private javax.swing.JLabel jLPergunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLnivel;
    private javax.swing.JLabel jLpontuacaoTotal;
    private javax.swing.JLabel jLquestao;
    private javax.swing.JLabel jLtempo;
    private javax.swing.JLabel jLvidas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRBresposta1;
    private javax.swing.JRadioButton jRBresposta2;
    private javax.swing.JRadioButton jRBresposta3;
    private javax.swing.JRadioButton jRBresposta4;
    private javax.swing.JToggleButton jTBestereoscopia;
    // End of variables declaration//GEN-END:variables
}
