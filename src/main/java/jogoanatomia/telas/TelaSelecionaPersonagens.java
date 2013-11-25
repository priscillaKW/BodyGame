/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanatomia.telas;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jogoanatomia.entidades.User;
import jogoanatomia.services.UserService;
import jogoanatomia.services.UserServiceImpl;

/**
 * @author Jessica
 */
public class TelaSelecionaPersonagens extends javax.swing.JFrame {
    private UserService userService;

    /**
     * Creates new form TelaSelecionaPersonagens
     */
    public TelaSelecionaPersonagens() {
        userService = new UserServiceImpl();

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(TelaSelecionaPersonagens.class.getResource("/images/256px-Female_with_organs.png")));

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(TelaSelecionaPersonagens.class.getResource("/images/256px-Male_with_organs.png")));

        final JRadioButton rdbtnMulher = new JRadioButton("Mulher");

        final JRadioButton rdbtnHomem = new JRadioButton("Homem");

        JLabel lblSelecioneOPersonagem = new JLabel("Selecione o personagem");

        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User usuario = SessionStore.getLoggedUser();
                String personagem = null;
                if (rdbtnMulher.isSelected()) {
                    personagem = "female";
                } else {
                    personagem = "male";
                }

                User reloadedUser = userService.setCharacter(usuario.getId(), personagem);

                if(reloadedUser != null)
                    SessionStore.setLoggedUser(reloadedUser);

                TelaPersonagemOrgaos tPersonagemOrgaos = new TelaPersonagemOrgaos();
                tPersonagemOrgaos.setVisible(true);
                dispose();

            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98)
                                                .addComponent(rdbtnMulher)
                                                .addGap(309)
                                                .addComponent(rdbtnHomem))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(226)
                                                .addComponent(lblSelecioneOPersonagem))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44)
                                                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(btnOk)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(label)
                                                                .addGap(74)
                                                                .addComponent(label_1)))))
                                .addContainerGap(734, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(8)
                                .addComponent(lblSelecioneOPersonagem)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_1)
                                        .addComponent(label))
                                .addGap(18)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(rdbtnMulher)
                                        .addComponent(rdbtnHomem))
                                .addGap(27)
                                .addComponent(btnOk)
                                .addContainerGap(214, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionaPersonagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionaPersonagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionaPersonagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSelecionaPersonagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSelecionaPersonagens().setVisible(true);
            }
        });
    }
}
