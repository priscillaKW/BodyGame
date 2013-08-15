package jogoanatomia.telas;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import jogoanatomia.entidades.Estudos;
import jogoanatomia.entidades.Orgao;

public class EscolheParteCorpo extends javax.swing.JFrame {

    static EscolheParteCorpo singleton;
    static ArrayList<Orgao> orgaos;
    
    public static EscolheParteCorpo getInstance(){
        if (singleton==null){
            singleton=new EscolheParteCorpo();
        }
        return singleton;
    }

    public void inicio() {
        modelo=new DefaultListModel();
        orgaos = Orgao.getTodos();
        for (int i = 0; i < orgaos.size(); i++) {
            modelo.addElement(orgaos.get(i).getNome());
        }
        jLorgaos.setModel(modelo);
    }
    
    public EscolheParteCorpo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBestudar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        jLorgaos = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BodyGame - Escolha Parte do Corpo");
        setBounds(new java.awt.Rectangle(300, 50, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(530, 400));
        setMinimumSize(new java.awt.Dimension(530, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBestudar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBestudar.setForeground(new java.awt.Color(102, 0, 0));
        jBestudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/1369963189_notebook.png"))); // NOI18N
        jBestudar.setText("Estudar");
        jBestudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBestudarActionPerformed(evt);
            }
        });
        getContentPane().add(jBestudar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Escolha a parte do corpo que quer estudar");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jScrollPane1.setViewportView(jLorgaos);
        jLorgaos.setModel(modelo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 140, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogoanatomia/telas/images/fundo_escolhe_orgao.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBestudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBestudarActionPerformed
        Estudar.getInstance().setVisible(true);
        ArrayList<Estudos> temp = Estudos.getPorOrgao(orgaos.get(jLorgaos.getSelectedIndex()).getIdOrgao());
        Estudar.getInstance().setConteudos(temp);   
        Estudar.getInstance().iniciaEstudos();        
    }//GEN-LAST:event_jBestudarActionPerformed

    private DefaultListModel modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBestudar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jLorgaos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
