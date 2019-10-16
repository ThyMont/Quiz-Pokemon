package view;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.Pokemon;
import control.Quiz;
import control.Treinador;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Font;

@SuppressWarnings("serial")
public class TQuizGenI extends JInternalFrame {
	private JPanel panel;
	private JTextField txtTrainername;
	private JLabel lblPokemonImg;
	private JLabel lblAvatar;
	private JButton btnOpcaoa;
	private JButton btnOpcaob;
	private JButton btnOpcaoc;
	private JButton btnOpcaod;
	private JProgressBar barraExp;
	private JLabel lblTituloquiz;
	private JButton btnTelaInicial;
	private JLabel lblQuemEste;
	private Quiz quiz;
	private Treinador treinador;
	private JLabel lblExperincia;
	private JLabel lblPrximoNvel;
	private JLabel lblTotalPokedex;

	public TQuizGenI(JDesktopPane desktop, Treinador treinador) {
		setBorder(null);
		setBounds(0, 0, 1366, 706);
		this.treinador = treinador;
		
		quiz = new Quiz();

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblTituloquiz = new JLabel("TituloQuiz");
		lblTituloquiz.setForeground(Color.WHITE);
		lblTituloquiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloquiz.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTituloquiz.setBounds(138, 29, 364, 68);
		lblTituloquiz.setText("Primeira Geração");
		panel.add(lblTituloquiz);

		lblTotalPokedex = new JLabel();
		lblTotalPokedex.setText("Status Pokédex: " + treinador.getTotalPokedex() + " Pokémon vistos");
		lblTotalPokedex.setForeground(Color.WHITE);
		lblTotalPokedex.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		lblTotalPokedex.setBounds(527, 44, 429, 53);
		panel.add(lblTotalPokedex);
		
		lblPokemonImg = new JLabel("");
		lblPokemonImg.setBorder(null);
		lblPokemonImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonImg.setBounds(767, 110, 260, 260);
		panel.add(lblPokemonImg);

		lblAvatar = new JLabel("Avatar");
		lblAvatar = new JLabel("");
		lblAvatar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setBorder(null);
		lblAvatar.setBounds(138, 177, 190, 300);
		lblAvatar.setIcon(new ImageIcon(
				(new ImageIcon(TInicial.class.getResource("/images/Treinador/" + treinador.getSpritetreinador())))
						.getImage()
						.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(lblAvatar);

		txtTrainername = new JTextField();
		txtTrainername.setFont(new Font("Dialog", Font.PLAIN, 23));
		txtTrainername.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrainername.setBackground(Color.WHITE);
		txtTrainername.setBorder(null);
		txtTrainername.setEditable(false);
		txtTrainername.setText("TrainerName");
		txtTrainername.setBounds(160, 133, 146, 33);
		panel.add(txtTrainername);
		txtTrainername.setColumns(10);

		btnOpcaoa = new JButton("opcaoA");
		btnOpcaoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (quiz.verificarResposta(btnOpcaoa.getText())) {
					respostaCorreta(treinador.getNomeTreinador());
				} else {
					respostaErrada(treinador.getNomeTreinador());
				}
			}
		});
		btnOpcaoa.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnOpcaoa.setBounds(577, 436, 270, 70);
		panel.add(btnOpcaoa);

		btnOpcaob = new JButton("OpcaoB");
		btnOpcaob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (quiz.verificarResposta(btnOpcaob.getText())) {
					respostaCorreta(treinador.getNomeTreinador());
				} else {
					respostaErrada(treinador.getNomeTreinador());
				}
			}
		});
		btnOpcaob.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnOpcaob.setBounds(577, 530, 270, 70);
		panel.add(btnOpcaob);

		btnOpcaoc = new JButton("OpcaoC");
		btnOpcaoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (quiz.verificarResposta(btnOpcaoc.getText())) {
					respostaCorreta(treinador.getNomeTreinador());
				} else {
					respostaErrada(treinador.getNomeTreinador());
				}
			}
		});
		btnOpcaoc.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnOpcaoc.setBounds(954, 436, 270, 70);
		panel.add(btnOpcaoc);

		btnOpcaod = new JButton("opcaoD");
		btnOpcaod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (quiz.verificarResposta(btnOpcaod.getText())) {
					respostaCorreta(treinador.getNomeTreinador());
				} else {
					respostaErrada(treinador.getNomeTreinador());
				}
			}
		});
		btnOpcaod.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnOpcaod.setBounds(954, 530, 270, 70);
		panel.add(btnOpcaod);

		barraExp = new JProgressBar();
		barraExp.setBounds(1013, 62, 303, 20);
		barraExp.setMaximum(treinador.determinarExpMaximo());
		barraExp.setValue(barraExp.getMaximum() - treinador.getProximoNivel());
		panel.add(barraExp);
		
		lblExperincia = new JLabel();
		lblExperincia.setText("Experiência total: " + treinador.getExperiencia() + " pontos");
		lblExperincia.setForeground(Color.WHITE);
		lblExperincia.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		lblExperincia.setBounds(527, 8, 429, 53);
		panel.add(lblExperincia);
		
		lblPrximoNvel = new JLabel();
		lblPrximoNvel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPrximoNvel.setForeground(Color.WHITE);
		lblPrximoNvel.setText("Próximo Nível: " + treinador.getProximoNivel() + " pontos");
		lblPrximoNvel.setBounds(1013, 24, 303, 26);
		panel.add(lblPrximoNvel);

		btnTelaInicial = new JButton("");
		btnTelaInicial.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Home.png")))
				.getImage()
				.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		btnTelaInicial.setBackground(Color.DARK_GRAY);
		btnTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnTelaInicial.setBounds(23, 29, 88, 68);
		panel.add(btnTelaInicial);

		lblQuemEste = new JLabel("Quem \u00E9 este Pok\u00E9mon?");
		lblQuemEste.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblQuemEste.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuemEste.setBounds(701, 373, 394, 52);
		panel.add(lblQuemEste);

		JLabel lblTelaInicial = new JLabel("Tela Inicial");
		lblTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaInicial.setForeground(Color.WHITE);
		lblTelaInicial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelaInicial.setBounds(23, 105, 88, 20);
		panel.add(lblTelaInicial);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 1366, 706);
		lblBackground.setIcon(
				new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Wallpaper/WallpaperQuiz" + ".png")))
						.getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),
								java.awt.Image.SCALE_SMOOTH)));
		panel.add(lblBackground);

		preencherQuiz();
		

	}
	public void refresh() {
		barraExp.setMaximum(treinador.determinarExpMaximo());
		barraExp.setValue(barraExp.getMaximum() - treinador.getProximoNivel());
		lblExperincia.setText("Experiência total: " + treinador.getExperiencia() + " pontos");
		lblPrximoNvel.setText("Próximo Nível: " + treinador.getProximoNivel() + " pontos");
		lblTotalPokedex.setText("Status Pokédex: " + treinador.getTotalPokedex() + " Pokémon vistos");
		btnOpcaoa.setFocusPainted(false);
		btnOpcaob.setFocusPainted(false);
		btnOpcaoc.setFocusPainted(false);
		btnOpcaod.setFocusPainted(false);
		
	}

	public void preencherQuiz() {
		String [] teste = new Pokemon().listarNumerosPokemon();
		String[] quizGenI = teste;
		int pokeSorteado = quiz.sortearPokemonGenI();

		quiz = new Quiz(quizGenI[pokeSorteado]);
		String sorteio = quizGenI[pokeSorteado];

		quiz.dadosPergunta(sorteio);
		txtTrainername.setText(treinador.getNomeTreinador());
		btnOpcaoa.setText(quiz.getOpcaoA());
		btnOpcaob.setText(quiz.getOpcaoB());
		btnOpcaoc.setText(quiz.getOpcaoC());
		btnOpcaod.setText(quiz.getOpcaoD());
		lblPokemonImg.setIcon(new ImageIcon(
				(new ImageIcon(TInicial.class.getResource("/images/Pokemon/" + quiz.getPokePergunta() + ".png")))
						.getImage().getScaledInstance(lblPokemonImg.getWidth(), lblPokemonImg.getHeight(),
								java.awt.Image.SCALE_SMOOTH)));
	}
	public void respostaCorreta(String nomeTreinador) {
		treinador.upExperiencia();
		treinador.verPokemon(quiz.getPokePergunta());
		Pokemon pokemon = new Pokemon(quiz.getPokePergunta());
		String[] tipo = pokemon.getTipo();
		String tipo1, tipo2; 
		tipo1 = tipo[0];
		treinador.upInsignia(tipo1);
		try {	
			tipo2 = tipo[1];
			treinador.upInsignia(tipo2);
		} catch (Exception e) {
		}
		refresh();
		preencherQuiz();
		
	}
	public void respostaErrada(String nomeTreinador) {
		ImageIcon icon = new ImageIcon(
				(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
						.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		JOptionPane.showMessageDialog(null, "Você perdeu", "=(",
				JOptionPane.INFORMATION_MESSAGE, icon);
		dispose();
	}
	
	
}
