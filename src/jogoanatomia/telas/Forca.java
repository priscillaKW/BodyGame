package jogoanatomia.telas;

import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.media.j3d.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import jogoanatomia.entidades.FasesDicas;
import jogoanatomia.entidades.Orgao;
import jogoanatomia.entidades.Ranking;
import jogoanatomia.loader.CarregaObj;
import jogoanatomia.loader.CarregaStereo;

public class Forca extends javax.swing.JFrame {

    static Forca singleton;
    private Canvas3D c;
    public static VirtualUniverse u;
    public Locale myLocale;
    FasesDicas fase;
    
    public static Forca getInstance(){
        if (singleton==null){
            singleton=new Forca();
        }
        return singleton;
    }
    
    private String palavraForca;
    private int letrasErradas=0;
    private ArrayList<String> listaLetrasErradas=new ArrayList<String>();
    private int pontuacao=6;
    private int pontuacaoTotal=0;

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
        jLpontuacaoTotal.setText(pontuacaoTotal+"");
    }
    
    public int getLetrasErradas() {
        return letrasErradas;
    }

    public void setLetrasErradas(int letrasErradas) {
        this.letrasErradas = letrasErradas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
        jLpontuacaoRodada.setText(pontuacao+"");
    }

    public String getPalavraForca() {
        return palavraForca;
    }

    public void setPalavraForca(String palavraForca) {
        this.palavraForca = palavraForca.toUpperCase();
        gerarMascara();
    }
    
    public String gerarMascara(){
        String retorno="";        
        for(int i=0; i<getPalavraForca().length();i++){
            if(getPalavraForca().charAt(i)==' ') {
                retorno=retorno+"-";
            }
            else {
                retorno=retorno+"_";
            }
        }
        jTforca.setText(retorno);
        return retorno;
    }

    public void quantLetras(){
        String temp=palavraForca.replaceAll(" ", "");
        jLletras.setText("Essa palavra tem " + temp.length() + " letras.");
    }
    
    public FasesDicas sorteiaFase(){
        ArrayList<FasesDicas> todas = FasesDicas.getTodas();
        int i=(int) (Math.random()*todas.size());
        return todas.get(i);
    }

    public void inicio(){
                fase = sorteiaFase();

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
        Orgao orgao = Orgao.getOrgaoPorId(fase.getIdOrgao()).get(0);
        myLocale = new Locale(u);
            CarregaObj CarregaObj = new CarregaObj();
        CarregaObj.setFile("./"+orgao.getNome().toLowerCase());
        myLocale.addBranchGraph(CarregaObj.createSceneGraph());
        myLocale.addBranchGraph(CarregaObj.branchGroupLeft(c));
        jPanel2.removeAll();
        jPanel2.setLayout(new BorderLayout(10, 0));
        jPanel2.add(c);
        jPanel2.updateUI();
        // Background
        BranchGroup brbg = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
                100);
        Color3f bgColor = new Color3f(0.0f, 0.7f, 1.0f);
        Background backg = new Background(bgColor);
        backg.setApplicationBounds(bounds);
        brbg.addChild(backg);
        myLocale.addBranchGraph(brbg);
        setPalavraForca(fase.getResposta());
        jLdica.setText(fase.getDica());
        jLnivel.setText(fase.getNivel()+"");
        quantLetras();
        jLletrasErradas.setText("");
        listaLetrasErradas=new ArrayList<String>();
        letrasErradas=0;
        jLforca.setIcon(new ImageIcon("images/forca0.png"));
        jLpontuacaoTotal.setText(getPontuacaoTotal()+"");
        jLpontuacaoRodada.setText(getPontuacao()+"");
    }
    
    public Forca() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLdica = new javax.swing.JLabel();
        jLletras = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLnivel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTletra = new javax.swing.JTextField();
        jBtentaLetra = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTBestereoscopia = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jLletrasErradas = new javax.swing.JLabel();
        jTforca = new javax.swing.JTextField();
        jLforca = new javax.swing.JLabel();
        jLpontuacaoTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLpontuacaoRodada = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Jogo de Forca");
        setBackground(new java.awt.Color(153, 102, 255));
        setBounds(new java.awt.Rectangle(300, 50, 820, 500));
        setMaximumSize(new java.awt.Dimension(820, 500));
        setMinimumSize(new java.awt.Dimension(820, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Jogo de Forca");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Letras erradas:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLdica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLdica.setText("-");
        getContentPane().add(jLdica, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 380, 20));

        jLletras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLletras.setText("-");
        getContentPane().add(jLletras, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 240, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nível:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLnivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLnivel.setText("-");
        getContentPane().add(jLnivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Dica:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 10));

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Estereoscopia:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        jTBestereoscopia.setText("ON");
        jTBestereoscopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBestereoscopiaActionPerformed(evt);
            }
        });
        getContentPane().add(jTBestereoscopia, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, -1, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Escolha uma letra:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Pontuação Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jLpontuacaoRodada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpontuacaoRodada.setText("6");
        getContentPane().add(jLpontuacaoRodada, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 100, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Pontuação da Rodada:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 440, 310));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/fundo_forca.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTBestereoscopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBestereoscopiaActionPerformed
        Orgao orgao = Orgao.getOrgaoPorId(fase.getIdOrgao()).get(0);
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
        CarregaObj.setFileName("./"+orgao.getNome().toLowerCase());
        myLocale.addBranchGraph(CarregaObj.createSceneGraph());
        myLocale.addBranchGraph(CarregaObj.branchGroupLeft(c));
        jPanel2.removeAll();
        jPanel2.setLayout(new BorderLayout(10, 0));
        jPanel2.add(c);
        jPanel2.updateUI();
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

    private void jBtentaLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtentaLetraActionPerformed
        if(jTletra.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ops!! Você esqueceu de informar uma letra!", "AVISO", 1, null);
            return;
        }
        char letra = jTletra.getText().toUpperCase().charAt(0);
        jTletra.setText("");
        String resultado = "";
        if (getPalavraForca().indexOf(letra) >= 0) {
            for (int i = 0; i < getPalavraForca().length(); i++) {
                String temp = jTforca.getText();
                if (getPalavraForca().charAt(i) == letra) {
                    resultado = resultado + getPalavraForca().charAt(i);
                } else {
                    resultado = resultado + temp.charAt(i);
                }
            }
            jTforca.setText(resultado);
        } else {
            if (listaLetrasErradas.contains(letra + "")) {
                JOptionPane.showMessageDialog(rootPane, "Ops!! Você já tentou essa letra!", "AVISO", 1, null);
            } else {
                jLletrasErradas.setText(jLletrasErradas.getText() + letra + "-");
                setLetrasErradas(getLetrasErradas() + 1);
                listaLetrasErradas.add(letra+"");
                jLforca.setIcon(new ImageIcon("images/forca" + getLetrasErradas() + ".png"));
                setPontuacao(getPontuacao()-100);
                jLpontuacaoRodada.setText(getPontuacao()+"");
            }
        }
        if(getLetrasErradas()==6){
            JOptionPane.showMessageDialog(rootPane, "Ops!! Você perdeu!", "AVISO", 1, null);
            String nomeRanking = JOptionPane.showInputDialog(rootPane, "Insira seu nome:", "AVISO", 1);
            Ranking.insereRegistro(nomeRanking,getPontuacaoTotal(),1);
            this.setVisible(false);
            TelaRanking.getInstance().setVisible(true);
            TelaRanking.getInstance().jCBjogos.setSelectedIndex(1);
            TelaRanking.getInstance().inicio();
            setPontuacao(600);
            setPontuacaoTotal(0);
        }
        if(getPalavraForca().equals(jTforca.getText().replace("-", " "))){
            JOptionPane.showMessageDialog(rootPane, "Parabéns!! Você completou o jogo!", "AVISO", 1, null);
            setPontuacaoTotal(getPontuacaoTotal()+getPontuacao());
            setPontuacao(600);
            inicio();
        }
    }//GEN-LAST:event_jBtentaLetraActionPerformed

    private void jTletraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTletraKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jBtentaLetraActionPerformed(null);
        }
    }//GEN-LAST:event_jTletraKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtentaLetra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLdica;
    private javax.swing.JLabel jLforca;
    private javax.swing.JLabel jLletras;
    private javax.swing.JLabel jLletrasErradas;
    private javax.swing.JLabel jLnivel;
    private javax.swing.JLabel jLpontuacaoRodada;
    private javax.swing.JLabel jLpontuacaoTotal;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jTBestereoscopia;
    private javax.swing.JTextField jTforca;
    private javax.swing.JTextField jTletra;
    // End of variables declaration//GEN-END:variables
}
