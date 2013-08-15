package jogoanatomia.telas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import jogoanatomia.entidades.Ranking;

public class TelaRanking extends javax.swing.JFrame {
   
    static TelaRanking singleton;
    
    public static TelaRanking getInstance(){
        if (singleton==null){
            singleton=new TelaRanking();
        }
        return singleton;
    }
    
    String[] columnNames={" ","Nome","Pontos"};
    
    public void inicio(){
        int idJogo = jCBjogos.getSelectedIndex();
        ArrayList<Ranking> ranking=Ranking.getRankingOrdenado(idJogo);
        DefaultTableModel dftm = new DefaultTableModel(columnNames, 0);
        for(int i=0;i<ranking.size();i++){
            String[] linha = new String[3];
            linha[0]=(i+1)+"";
            linha[1]=ranking.get(i).getNome();
            linha[2]=ranking.get(i).getPontos()+"";
            dftm.addRow(linha);
        }
        jTBranking.setModel(dftm);
    }
    
    public TelaRanking() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCBjogos = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBranking = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Ranking");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Ranking");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ver pontuação do jogo: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jCBjogos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCBjogos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Forca", "Caça-Palavras", "Jogo de Associação", "Quiz" }));
        jCBjogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBjogosActionPerformed(evt);
            }
        });
        getContentPane().add(jCBjogos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 177, -1));

        jTBranking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nome", "Pontos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTBranking);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, 300, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/fundo_ranking.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBjogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBjogosActionPerformed
        if(jCBjogos.getSelectedIndex()!=0)
            inicio();
        else{
            DefaultTableModel dftm = new DefaultTableModel(columnNames, 0);
            jTBranking.setModel(dftm);
        }
    }//GEN-LAST:event_jCBjogosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox jCBjogos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTBranking;
    // End of variables declaration//GEN-END:variables
}
