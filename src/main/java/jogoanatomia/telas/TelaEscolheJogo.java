package jogoanatomia.telas;

import static java.lang.String.format;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.sun.media.sound.Toolkit;

import jogoanatomia.entidades.*;
import jogoanatomia.services.GameService;
import jogoanatomia.services.GameServiceImpl;
import jogoanatomia.services.UserService;
import jogoanatomia.services.UserServiceImpl;

public class TelaEscolheJogo extends javax.swing.JFrame {
	private UserService userService;

	public Icon icon = new ImageIcon(getClass().getResource(
			"/images/trophy.png"), "Troféu");

	static Organ orgao;

	public Forca forca;

	public Associacao associacao;

	public Quiz quiz;

	public CacaPalavras cacaPalavras;

	private User usuario;

	public void setOrgao(Organ orgao) {
		this.orgao = orgao;
	}

	private GameService service;

	private Float quizPercentage;
	private Float hangmanPercentage;
	private Float associationPercentage;
	private Float wordSearchesPercentage;

	public TelaEscolheJogo(Organ organ) {
		orgao = organ;
		userService = new UserServiceImpl();
		service = new GameServiceImpl();

		usuario = SessionStore.getLoggedUser();

		String userId = usuario.getId();

		quizPercentage = service.getCompletedPercentage(userId, organ.getId(),
				QuizGame.class);
		hangmanPercentage = service.getCompletedPercentage(userId,
				organ.getId(), HangmanGame.class);
		associationPercentage = service.getCompletedPercentage(userId,
				organ.getId(), AssociationGame.class);
		wordSearchesPercentage = service.getCompletedPercentage(userId,
				organ.getId(), WordSearchesGame.class);

		initComponents();
		int jogosCompletos = 0;

		if (hangmanPercentage.equals(100f)) {
			jBforca.setIcon(icon);
			jogosCompletos++;
		} else if (hangmanPercentage > 0f) {
			jBforca.setText(jBforca.getText() + " (" + hangmanPercentage + "%)");
		}

		if (associationPercentage.equals(100f)) {
			jBassociacao.setIcon(icon);
			jogosCompletos++;
		} else if (associationPercentage > 0f) {
			jBassociacao.setText(jBassociacao.getText() + " ("
					+ associationPercentage + "%)");
		}

		if (quizPercentage.equals(100f)) {
			jBperguntas.setIcon(icon);
			jogosCompletos++;
		} else if (quizPercentage > 0f) {
			jBperguntas.setText(jBperguntas.getText() + " (" + quizPercentage
					+ "%)");
		}

		if (wordSearchesPercentage.equals(100f)) {
			jBcacaPalavras.setIcon(icon);
			jogosCompletos++;
		} else if (wordSearchesPercentage > 0f) {
			jBcacaPalavras.setText(jBcacaPalavras.getText() + " ("
					+ wordSearchesPercentage + "%)");
		}

		if (jogosCompletos == 4) {
			if (orgao.getStage() > usuario.currentStage()) {

				User reloadedUser = userService.updateCurrentStage(
						usuario.getId(), organ.getStage());

				if (reloadedUser != null){
					SessionStore.setLoggedUser(reloadedUser);
				}
				
				if (orgao.getStage() == 8) {
					
					JOptionPane
							.showMessageDialog(null,
									"Parabéns!! Você completou o jogo. Veja como ficou o seu personagem o/");
					TelaPersonagemOrgaos tPersonagemOrgaos = new TelaPersonagemOrgaos();
					tPersonagemOrgaos.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null,
							"Parabéns!! Você completou os jogos para o órgão "
									+ organ.getName()
									+ ". Veja como está o seu personagem ;)");
					TelaPersonagemOrgaos tPersonagemOrgaos = new TelaPersonagemOrgaos();
					tPersonagemOrgaos.setVisible(true);
					dispose();
				}
			}
		}
	}

	private void disposeAndBackToOrganSelection() {
		TelaPersonagemOrgaos personagemOrgaos = new TelaPersonagemOrgaos();
		this.dispose();
		personagemOrgaos.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jBforca = new javax.swing.JButton();
		jBcacaPalavras = new javax.swing.JButton();
		jBassociacao = new javax.swing.JButton();
		jBperguntas = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("BodyGame - Escolha o Jogo");
		setBounds(new java.awt.Rectangle(300, 50, 0, 0));
		setMinimumSize(new java.awt.Dimension(450, 350));
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		jBforca.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
		jBforca.setForeground(new java.awt.Color(153, 0, 0));
		jBforca.setText("Forca");
		jBforca.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBforcaActionPerformed(evt);
			}
		});

		jBcacaPalavras.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
		jBcacaPalavras.setForeground(new java.awt.Color(153, 0, 0));
		jBcacaPalavras.setText("Caça-Palavras");
		jBcacaPalavras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBcacaPalavrasActionPerformed(evt);
			}
		});

		jBassociacao.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
		jBassociacao.setForeground(new java.awt.Color(153, 0, 0));
		jBassociacao.setText("Associação");
		jBassociacao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBassociacaoActionPerformed(evt);
			}
		});

		jBperguntas.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
		jBperguntas.setForeground(new java.awt.Color(153, 0, 0));
		jBperguntas.setText("Quiz");
		jBperguntas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBperguntasActionPerformed(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(153, 0, 0));
		jLabel5.setText("Escolha um jogo!");

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(153, 0, 0));
		jLabel1.setText("Complete os 4 jogos para ganhar a parte do corpo correspondente!");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(71, 71, 71)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addComponent(
														jBforca,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jBassociacao,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jBcacaPalavras,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														280, Short.MAX_VALUE)
												.addComponent(
														jBperguntas,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap(99, Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(46, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel5)
																.addGap(126,
																		126,
																		126))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addGap(33, 33,
																		33)))));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(11, 11, 11)
						.addComponent(jLabel5)
						.addGap(35, 35, 35)
						.addComponent(jBforca,
								javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jBassociacao,
								javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jBcacaPalavras,
								javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jBperguntas,
								javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32).addComponent(jLabel1)
						.addContainerGap(23, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jBassociacaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBassociacaoActionPerformed
		associacao = new Associacao(orgao);
		this.dispose();
		associacao.setVisible(true);
	}// GEN-LAST:event_jBassociacaoActionPerformed

	private void jBforcaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBforcaActionPerformed
		forca = new Forca(orgao);
		this.dispose();
		forca.setVisible(true);
	}// GEN-LAST:event_jBforcaActionPerformed

	private void jBperguntasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBperguntasActionPerformed
		quiz = new Quiz(orgao);
		this.dispose();
		quiz.setVisible(true);
	}// GEN-LAST:event_jBperguntasActionPerformed

	private void jBcacaPalavrasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBcacaPalavrasActionPerformed
		cacaPalavras = new CacaPalavras(orgao);
		this.dispose();
		cacaPalavras.setVisible(true);

	}// GEN-LAST:event_jBcacaPalavrasActionPerformed

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		disposeAndBackToOrganSelection();
	}// GEN-LAST:event_formWindowClosing

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jBassociacao;
	private javax.swing.JButton jBcacaPalavras;
	private javax.swing.JButton jBforca;
	private javax.swing.JButton jBperguntas;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel5;
	// End of variables declaration//GEN-END:variables
}
