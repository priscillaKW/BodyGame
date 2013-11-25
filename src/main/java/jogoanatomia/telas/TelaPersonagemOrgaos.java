/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.telas;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

import jogoanatomia.entidades.Organ;
import jogoanatomia.entidades.User;
import jogoanatomia.services.OrganServiceImpl;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Jessica
 */
public class TelaPersonagemOrgaos extends javax.swing.JFrame {

    public TelaSelecionaPersonagens windowSeleciona;

    public TelaEstudar windowEstudar;

    public OrganServiceImpl organServiceImpl;

    public List<Organ> orgaos;

    public Icon icon;

    public Icon icon2;

    private User usuario;

    /**
     * Creates new form TelaPersonagemOrgaos
     */
    @SuppressWarnings("unchecked")
    public TelaPersonagemOrgaos() {
        this.usuario = SessionStore.getLoggedUser();

        windowSeleciona = new TelaSelecionaPersonagens();

        organServiceImpl = new OrganServiceImpl();

        orgaos = organServiceImpl.all();

        Collections.sort(orgaos, new Comparator<Organ>() {
            public int compare(Organ o1, Organ o2) {
                return o1.getStage().compareTo(o2.getStage());
            }
        });

        initComponents();

        carregaPersonagem();

        atualizaListaOrgaos();
    }

    @SuppressWarnings("unchecked")
    private void atualizaListaOrgaos() {
        jListOrgaos.setCellRenderer(new DefaultListCellRenderer() {

            private static final long serialVersionUID = 1L;

            public Component getListCellRendererComponent(JList list,
                                                          Object value, int index, boolean isSelected,
                                                          boolean cellHasFocus) {

                Component comp = super.getListCellRendererComponent(list, value, index, false, false);

                if (index <= usuario.currentStage() + 1) {
                    if (isSelected && cellHasFocus)
                        comp.setBackground(Color.YELLOW);
                } else {
                    comp.setEnabled(false);
                }

                return comp;
            }
        });
    }

    private void carregaPersonagem() {
        if (this.usuario.getCharacter() == null) {
            return;
        }

        if (this.usuario.getCharacter().getKind().equals("female")) {
            switch (usuario.currentStage()) {
                case 0:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem1-mulher.png")));
                    break;
                case 1:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem2-mulher.png")));
                    break;
                case 2:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem3-mulher.png")));
                    break;
                case 3:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem4-mulher.png")));
                    break;
                case 4:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem5-mulher.png")));
                    break;
                case 5:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem6-mulher.png")));
                    break;
                case 6:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem7-mulher.png")));
                    break;
                case 7:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem8-mulher.png")));
                    break;
                case 8:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem9-mulher.png")));
                    break;
                default:
                    jLabelPersonagens
                            .setIcon(new ImageIcon(
                                    TelaSelecionaPersonagens.class
                                            .getResource("/images/Female_shadow_-_upper.png")));
            }
        } else if (usuario.getCharacter().getKind().equals("male")) {
            switch (usuario.currentStage()) {
                case 0:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem1-homem.png")));
                    break;
                case 1:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem2-homem.png")));
                    break;
                case 2:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem3-homem.png")));
                    break;
                case 3:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem4-homem.png")));
                    break;
                case 4:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem5-homem.png")));
                    break;
                case 5:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem6-homem.png")));
                    break;
                case 6:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem7-homem.png")));
                    break;
                case 7:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem8-homem.png")));
                    break;
                case 8:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/imagem9-homem.png")));
                    break;
                default:
                    jLabelPersonagens.setIcon(new ImageIcon(
                            TelaSelecionaPersonagens.class
                                    .getResource("/images/Man_shadow_-_upper.png")));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelPersonagens = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListOrgaos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BodyGame - Escolha personagem e parte do corpo");
        setMaximizedBounds(new java.awt.Rectangle(650, 520, 520, 520));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jLabelTitulo.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("BodyGame");

        jLabelPersonagens.setPreferredSize(new java.awt.Dimension(260, 450));
        jLabelPersonagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonagensMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 14)); // NOI18N
        jLabel2.setText("Selecione o seu personagem clicando na imagem a esquerda e a parte do corpo à direita!!");

        jButtonStart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonStart.setForeground(new java.awt.Color(153, 0, 0));
        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jListOrgaos.setFont(new java.awt.Font("Segoe Script", 0, 14)); // NOI18N
        jListOrgaos.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return orgaos.size(); }
            public Object getElementAt(int i) { return orgaos.get(i).getName(); }
        });
        jListOrgaos.setPreferredSize(new java.awt.Dimension(260, 300));
        jScrollPane1.setViewportView(jListOrgaos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPersonagens, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPersonagens, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jButtonStart)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPersonagensMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelPersonagensMouseClicked
        this.dispose();
        windowSeleciona.setVisible(true);
    }// GEN-LAST:event_jLabelPersonagensMouseClicked

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonStartActionPerformed
        int index = jListOrgaos.getSelectedIndex();

        if (index != -1 && index <= (usuario.currentStage() + 1)) {
            Organ orgaoSelecionado = orgaos.get(index);
            windowEstudar = new TelaEstudar();
            windowEstudar.setOrgao(orgaoSelecionado);
            this.dispose();
            windowEstudar.setVisible(true);
            windowEstudar.iniciar();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um órgão para iniciar o jogo");
        }
    }// GEN-LAST:event_jButtonStartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed"
        // desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(
                    TelaPersonagemOrgaos.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(
                    TelaPersonagemOrgaos.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(
                    TelaPersonagemOrgaos.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(
                    TelaPersonagemOrgaos.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPersonagemOrgaos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonStart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPersonagens;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList jListOrgaos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
