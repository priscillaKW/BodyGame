package jogoanatomia.telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.WordSearchesGame;
import jogoanatomia.entidades.actor.CacaPalavraActor;

public class CacaPalavras extends javax.swing.JFrame {

    public Organ orgao;
    public CacaPalavraActor cacaPalavrasActor;
    private WordSearchesGame fase;
    public int rodada;

    private int[] primeiraLetra = {-1, -1};
    Timer timer;
    int current = 120;

    public void setOrgao(Organ orgao) {
        this.orgao = orgao;
    }

    public CacaPalavras(Organ orgao) {
        initComponents();
        setVisible(true);
        cacaPalavrasActor = new CacaPalavraActor();
        setOrgao(orgao);
        cacaPalavrasActor.sorteiaFases(orgao.getId());
        rodada = 0;

        fase = cacaPalavrasActor.getProxFase(rodada);
        String[] colunas = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 20);
        jTcacaPalavras.setModel(modelo);
        Component[] a = jPanel1.getComponents();
        int i = 0;
        while (i < a.length && i < fase.getWords().size()) {
            JLabel teste = (JLabel) a[i];
            teste.setText(fase.getWords().get(i));
        }
        preencheTable();
        if (timer != null) {
            timer.stop();
        }
        setCurrent(240);
        jLtempo.setText(getCurrent() + "");
        goTimer();
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
                if (current == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Ops, você perdeu!", "AVISO", 1, null);
                    //TODO - salva quanto ele completou
                }
            }
        };
        this.timer = new Timer(1000, action);
        this.timer.start();
    }

    public void limpa() {
        String[] colunas = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 20);
        jTcacaPalavras.setModel(modelo);
        if (timer != null) {
            timer.stop();
        }
        setCurrent(240);
        jLtempo.setText(getCurrent() + "");

    }

    public void preencheTable() {
        for (int i = 0; i < fase.getWords().size(); i++) {
            String palavra = fase.getWords().get(i).replace(" ", "");
            boolean naoCabe;
            boolean taVazio;
            do {
                naoCabe = true;
                taVazio = true;
                //coordenadas X, Y e direção
                int[] xyD = cacaPalavrasActor.sorteiaPosicao();
                //HORIZONTAL
                if (xyD[2] == 0) {
                    //verifica se cabe na linha
                    if ((20 - xyD[1]) >= palavra.length()) {
                        //verifica se as células necessárias para a palavra estão vazias
                        for (int j = 0; j < palavra.length(); j++) {
                            Object celula = jTcacaPalavras.getModel().getValueAt(xyD[0], (xyD[1] + j));
                            if (celula != null) {
                                taVazio = false;
                                break;
                            }
                        }
                        //se estiver vazio, preenche
                        if (taVazio) {
                            for (int j = 0; j < palavra.length(); j++) {
                                jTcacaPalavras.getModel().setValueAt(palavra.toUpperCase().charAt(j), xyD[0], (xyD[1] + j));
                            }
                        }
                        naoCabe = false;
                    } else {
                        naoCabe = true;
                    }
                    //VERTICAL
                } else {
                    //verifica se cabe na linha
                    if ((20 - xyD[0]) >= palavra.length()) {
                        //verifica se as células necessárias para a palavra estão vazias
                        for (int j = 0; j < palavra.length(); j++) {
                            Object celula = jTcacaPalavras.getModel().getValueAt((xyD[0] + j), xyD[1]);
                            if (celula != null) {
                                taVazio = false;
                            }
                        }
                        //se estiver vazio, preenche
                        if (taVazio) {
                            for (int j = 0; j < palavra.length(); j++) {
                                jTcacaPalavras.getModel().setValueAt(palavra.toUpperCase().charAt(j), (xyD[0] + j), xyD[1]);
                            }
                        }
                        naoCabe = false;
                    } else {
                        naoCabe = true;
                    }
                }
                if (!taVazio) {
                    naoCabe = true;
                }
            } while (naoCabe);
        }
        for (int i = 0; i < jTcacaPalavras.getModel().getRowCount(); i++) {
            for (int j = 0; j < jTcacaPalavras.getModel().getColumnCount(); j++) {
                if (jTcacaPalavras.getModel().getValueAt(i, j) == null) {
                    int letra = (int) (Math.random() * 26);
                    jTcacaPalavras.getModel().setValueAt((char) (letra + 65), i, j);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTcacaPalavras = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLpalavra1 = new javax.swing.JLabel();
        jLpalavra2 = new javax.swing.JLabel();
        jLpalavra3 = new javax.swing.JLabel();
        jLpalavra4 = new javax.swing.JLabel();
        jLpalavra5 = new javax.swing.JLabel();
        jLpalavra6 = new javax.swing.JLabel();
        jLpalavra7 = new javax.swing.JLabel();
        jLpalavra8 = new javax.swing.JLabel();
        jLpalavra9 = new javax.swing.JLabel();
        jLpalavra10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLpontuacaoTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLtempo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTBestereoscopia = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Caça-Palavras");
        setBounds(new java.awt.Rectangle(0, 50, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTcacaPalavras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4", "Título 5", "Título 6", "Título 7", "Título 8", "Título 9", "Título 10", "Título 11", "Título 12", "Título 13", "Título 14", "Título 15", "Título 16", "Título 17", "Título 18", "Título 19", "Título 20"
            }
        ));
        jTcacaPalavras.setTableHeader(null
        );
        jTcacaPalavras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTcacaPalavrasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTcacaPalavras);
        jTcacaPalavras.getSelectionModel().setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
        jTcacaPalavras.getColumnModel().getSelectionModel().setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);
        jTcacaPalavras.setCellSelectionEnabled(true);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 93, 641, 341));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setText("Caça-Palavras");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLpalavra1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra1.setText("-");
        jLpalavra1.setName("palavra1"); // NOI18N

        jLpalavra2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra2.setText("-");
        jLpalavra2.setName("palavra2"); // NOI18N

        jLpalavra3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra3.setText("-");
        jLpalavra3.setName("palavra3"); // NOI18N

        jLpalavra4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra4.setText("-");
        jLpalavra4.setName("palavra4"); // NOI18N

        jLpalavra5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra5.setText("-");
        jLpalavra5.setName("palavra5"); // NOI18N

        jLpalavra6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra6.setText("-");
        jLpalavra6.setName("palavra6"); // NOI18N

        jLpalavra7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra7.setText("-");
        jLpalavra7.setName("palavra7"); // NOI18N

        jLpalavra8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra8.setText("-");
        jLpalavra8.setName("palavra8"); // NOI18N

        jLpalavra9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra9.setText("-");
        jLpalavra9.setName("palavra9"); // NOI18N

        jLpalavra10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpalavra10.setText("-");
        jLpalavra10.setName("palavra10"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLpalavra1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jLpalavra2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLpalavra10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLpalavra1)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra2)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra3)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra4)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra5)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra6)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra7)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra8)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra9)
                .addGap(18, 18, 18)
                .addComponent(jLpalavra10)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 93, 240, 341));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Pontuação Total:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 23, -1, -1));

        jLpontuacaoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpontuacaoTotal.setText("-");
        getContentPane().add(jLpontuacaoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 23, 100, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tempo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 23, -1, -1));

        jLtempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLtempo.setForeground(new java.awt.Color(153, 0, 0));
        jLtempo.setText("-");
        getContentPane().add(jLtempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 23, 38, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(906, 7, 410, 390));

        jTBestereoscopia.setText("ON");
        jTBestereoscopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBestereoscopiaActionPerformed(evt);
            }
        });
        getContentPane().add(jTBestereoscopia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, -1, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Estereoscopia:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Clique na primeira e última letra de cada palavra para marcá-la!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 58, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/fundo_cacapalavras.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTBestereoscopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBestereoscopiaActionPerformed


    }//GEN-LAST:event_jTBestereoscopiaActionPerformed


    private void jTcacaPalavrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTcacaPalavrasMouseClicked
        int y = jTcacaPalavras.getSelectedColumn();
        final int x = jTcacaPalavras.getSelectedRow();
        Object celula = jTcacaPalavras.getModel().getValueAt(x, y);
        if (primeiraLetra[0] == -1) {
            primeiraLetra[0] = x;
            primeiraLetra[1] = y;
        } else {
            String palavra = "";
            boolean horizontal = false;
            //palavra está na horizontal
            if (primeiraLetra[0] == x) {
                horizontal = true;
                for (int i = primeiraLetra[1]; i <= y; i++) {
                    palavra = palavra + jTcacaPalavras.getModel().getValueAt(x, i).toString();
                }
            }
            //palavra está na vertical
            if (primeiraLetra[1] == y) {
                horizontal = false;
                for (int i = primeiraLetra[0]; i <= x; i++) {
                    palavra = palavra + jTcacaPalavras.getModel().getValueAt(i, y).toString();
                }
            }
            //encontrou palavra
            boolean encontrou = false;
            for (int i = 0; i < fase.getWords().size(); i++) {
                if (fase.getWords().get(i).replace(" ", "").toUpperCase().equals(palavra)) {
                    Component[] a = jPanel1.getComponents();
                    JLabel teste = (JLabel) a[i];
                    teste.setFont(new Font("Tahoma", Font.ITALIC, 11));
                    teste.setEnabled(false);
                    cacaPalavrasActor.setPontuacaoTotal(cacaPalavrasActor.getPontuacaoTotal() + 100);
                    jLpontuacaoTotal.setText(cacaPalavrasActor.getPontuacaoTotal() + "");
                    cacaPalavrasActor.setFaltaEncontrar(cacaPalavrasActor.getFaltaEncontrar() - 1);
                    encontrou = true;
                }
            }
            if (!encontrou) {
                JOptionPane.showMessageDialog(rootPane, "Ops!! Você não selecionou nenhuma palavra válida!", "AVISO", 1, null);
            } else {
                if (horizontal) {
                    for (int j = primeiraLetra[1]; j <= y; j++) {
                        Object valor = "<html><strike><font color=\"red\">" + jTcacaPalavras.getModel().getValueAt(x, j) + "</font></strike></html>";
                        jTcacaPalavras.getModel().setValueAt(valor, x, j);
                        jTcacaPalavras.updateUI();
                    }
                } else {
                    for (int k = primeiraLetra[0]; k <= x; k++) {
                        Object valor = "<html><strike><font color=\"red\">" + jTcacaPalavras.getModel().getValueAt(k, y) + "</font></strike></html>";
                        jTcacaPalavras.getModel().setValueAt(valor, k, y);
                        jTcacaPalavras.updateUI();
                    }
                }
            }
            primeiraLetra[0] = -1;
            primeiraLetra[1] = -1;
        }
        if (cacaPalavrasActor.getFaltaEncontrar() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Parabéns! Você completou essa rodada! Vamos para a próxima!", "AVISO", 1, null);

            cacaPalavrasActor.setPontuacaoTotal(10);

            rodada += 1;
            fase = cacaPalavrasActor.getProxFase(rodada);

            if (fase == null) {
                JOptionPane.showMessageDialog(rootPane, "Não há mais fases para este jogo!", "AVISO", 1, null);
                setVisible(false);
            } else {
                limpa();
                Component[] a = jPanel1.getComponents();
                int i = 0;
                while (i < a.length && i < fase.getWords().size()) {
                    JLabel teste = (JLabel) a[i];
                    teste.setText(fase.getWords().get(i));
                }
                preencheTable();
                goTimer();
            }
        }
    }//GEN-LAST:event_jTcacaPalavrasMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLpalavra1;
    private javax.swing.JLabel jLpalavra10;
    private javax.swing.JLabel jLpalavra2;
    private javax.swing.JLabel jLpalavra3;
    private javax.swing.JLabel jLpalavra4;
    private javax.swing.JLabel jLpalavra5;
    private javax.swing.JLabel jLpalavra6;
    private javax.swing.JLabel jLpalavra7;
    private javax.swing.JLabel jLpalavra8;
    private javax.swing.JLabel jLpalavra9;
    private javax.swing.JLabel jLpontuacaoTotal;
    private javax.swing.JLabel jLtempo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jTBestereoscopia;
    private javax.swing.JTable jTcacaPalavras;
    // End of variables declaration//GEN-END:variables
}
