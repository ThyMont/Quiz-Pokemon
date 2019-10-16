package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import control.Treinador;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class TInicial extends JInternalFrame {
	private JDesktopPane desktopPane;
	private JLabel lblAvatar; 
	private Treinador treinador;
	private JLabel lblRocha;
	private JLabel lblTrovao;
	private JLabel lblLama;
	private JLabel lblVulcao;
	private JLabel lblCascata;
	private JLabel lblArcoiris;
	private JLabel lblAlma;
	private JLabel lblTerra;
	private JLabel lblNometreinador;
	private TCadastroPokemon tCadastroPokemon;
	private TEditarPokemon tEditarPokemon;
	private TPokedex tpokedex;

	public TInicial(JDesktopPane desktopTZero, String nomeTreinador) {
		setBounds(0, 0, 1366, 706);

		treinador = new Treinador(nomeTreinador);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnPokedex = new JButton("Pok\u00E9dex");
		btnPokedex.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btnPokedex.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					tCadastroPokemon.dispose();
					tEditarPokemon.dispose();
				} catch (Exception e1) {

				}
				tpokedex = new TPokedex(desktopPane, treinador.getNomeTreinador());
				((BasicInternalFrameUI) tpokedex.getUI()).setNorthPane(null);
				desktopTZero.add(tpokedex);
				tpokedex.setVisible(true);
			}
		});
		menuBar.add(btnPokedex);
		btnPokedex.setFocusPainted(false);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btnSair.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		menuBar.add(btnSair);

		JButton btnCadastrarPokmon = new JButton("Cadastrar Pok\u00E9mon");
		btnCadastrarPokmon.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btnCadastrarPokmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tCadastroPokemon.dispose();
					tEditarPokemon.dispose();
				} catch (Exception e) {

				}
				tCadastroPokemon = new TCadastroPokemon();
				((BasicInternalFrameUI) tCadastroPokemon.getUI()).setNorthPane(null);
				desktopPane.add(tCadastroPokemon);
				tCadastroPokemon.setVisible(true);
			}
		});
		menuBar.add(btnCadastrarPokmon);
		if (nomeTreinador.equals("Thyago")) {
			btnCadastrarPokmon.setEnabled(true);
		} else {
			btnCadastrarPokmon.setEnabled(false);
		}
		
		btnCadastrarPokmon.setFocusPainted(false);

		JButton btnEditarPokmon = new JButton("Editar Pokémon");
		btnEditarPokmon.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btnEditarPokmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tCadastroPokemon.dispose();
					tEditarPokemon.dispose();
				} catch (Exception e) {

				}
				tEditarPokemon = new TEditarPokemon();
				((BasicInternalFrameUI) tEditarPokemon.getUI()).setNorthPane(null);
				desktopPane.add(tEditarPokemon);
				tEditarPokemon.setVisible(true);
			}
		});
		menuBar.add(btnEditarPokmon);
		if (nomeTreinador.equals("Thyago")) {
			btnCadastrarPokmon.setEnabled(true);
		} else {
			btnCadastrarPokmon.setEnabled(false);
		}
		
		btnCadastrarPokmon.setFocusPainted(false);

		desktopPane = new JDesktopPane();
		desktopPane.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent arg0) {
				treinador = new Treinador(nomeTreinador);
				refresh();
			}
		});
		desktopPane.setBorder(null);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		lblAvatar = new JLabel();
		lblAvatar.setBorder(null);
		lblAvatar.setBounds(820, 83, 324, 528);
		lblAvatar.setIcon(new ImageIcon(
				(new ImageIcon(TInicial.class.getResource("/images/Treinador/" + treinador.getSpritetreinador())))
						.getImage()
						.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblAvatar);

		JButton btnQuiz = new JButton("   Quiz");
		btnQuiz.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
		btnQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TMenuQuiz tmenuQuiz = new TMenuQuiz(desktopPane, treinador);
				((BasicInternalFrameUI) tmenuQuiz.getUI()).setNorthPane(null);
				desktopPane.add(tmenuQuiz);
				tmenuQuiz.setVisible(true);
				try {
					tmenuQuiz.setMaximum(true);
				} catch (PropertyVetoException e) {
				}
			}
		});
		btnQuiz.setBounds(114, 234, 287, 100);
		btnQuiz.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/QuizPokemon.png"))).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		btnQuiz.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		desktopPane.add(btnQuiz);

		JButton btnTrainerCard = new JButton("  Trainer Card");
		btnTrainerCard.setBounds(114, 109, 287, 100);
		btnTrainerCard.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/pokedex-app-icon.png")))
				.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		btnTrainerCard.setFont(new Font("Malgun Gothic", Font.BOLD, 30));

		btnTrainerCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTrainerCard ttrainer = new TTrainerCard(desktopPane, treinador.getNomeTreinador());
				((BasicInternalFrameUI) ttrainer.getUI()).setNorthPane(null);
				desktopPane.add(ttrainer);
				ttrainer.setVisible(true);
				try {
					ttrainer.setMaximum(true);
				} catch (PropertyVetoException e1) {
				}
			}
		});
		desktopPane.add(btnTrainerCard);

		lblRocha = new JLabel();
		lblRocha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/PEDRA.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo PEDRA para aumentar o nível da Insínia da Rocha",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblRocha.setBorder(null);
		lblRocha.setBounds(663, 131, 100, 100);
		lblRocha.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/ROCHA0.png")))
				.getImage().getScaledInstance(lblRocha.getWidth(), lblRocha.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblRocha.setHorizontalAlignment(SwingConstants.CENTER);
		desktopPane.add(lblRocha);

		lblCascata = new JLabel("");
		lblCascata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/AGUA.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo AGUA para aumentar o nível da Insínia da Cascata",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblCascata.setHorizontalAlignment(SwingConstants.CENTER);
		lblCascata.setBorder(null);
		lblCascata.setBounds(1198, 131, 100, 100);
		lblCascata.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/CASCATA0.png")))
				.getImage().getScaledInstance(lblRocha.getWidth(), lblRocha.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblCascata);

		lblTrovao = new JLabel("");
		lblTrovao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/ELETRICO.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo ELÉTRICO para aumentar o nível da Insínia do Trovão",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblTrovao.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrovao.setBorder(null);
		lblTrovao.setBounds(663, 257, 100, 100);
		lblTrovao.setIcon(
				new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/TROVAO0.png"))).getImage()
						.getScaledInstance(lblTrovao.getWidth(), lblTrovao.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblTrovao);

		lblArcoiris = new JLabel("");
		lblArcoiris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/GRAMA.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo GRAMA para aumentar o nível da Insínia do Arco-Íris",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblArcoiris.setHorizontalAlignment(SwingConstants.CENTER);
		lblArcoiris.setBorder(null);
		lblArcoiris.setBounds(1198, 257, 100, 100);
		lblArcoiris.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/ARCOIRIS0.png")))
				.getImage()
				.getScaledInstance(lblArcoiris.getWidth(), lblArcoiris.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblArcoiris);

		lblLama = new JLabel("");
		lblLama.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/PSIQUICO.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo PSÍQUICO para aumentar o nível da Insínia da Lama",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblLama.setHorizontalAlignment(SwingConstants.CENTER);
		lblLama.setBorder(null);
		lblLama.setBounds(663, 388, 100, 100);
		lblLama.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/LAMA0.png")))
				.getImage().getScaledInstance(lblLama.getWidth(), lblLama.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblLama);

		lblAlma = new JLabel("");
		lblAlma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/VENENO.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo VENENO para aumentar o nível da Insínia da Alma",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblAlma.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlma.setBorder(null);
		lblAlma.setBounds(1198, 388, 100, 100);
		lblAlma.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/ALMA0.png")))
				.getImage().getScaledInstance(lblAlma.getWidth(), lblAlma.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblAlma);

		lblVulcao = new JLabel("");
		lblVulcao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/FOGO.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo FOGO para aumentar o nível da Insínia do Vulcão",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblVulcao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVulcao.setBorder(null);
		lblVulcao.setBounds(663, 511, 100, 100);
		lblVulcao.setIcon(
				new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/VULCAO0.png"))).getImage()
						.getScaledInstance(lblVulcao.getWidth(), lblVulcao.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblVulcao);

		lblTerra = new JLabel("");
		lblTerra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Icon icon = new ImageIcon(TInicial.class.getResource("/images/SimboloTipos/TERRESTRE.png"));
				JOptionPane.showMessageDialog(null,
						"No Quiz, responda corretamente Pokémon do tipo TERRESTRE para aumentar o nível da Insínia da Terra",
						"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
		lblTerra.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerra.setBorder(null);
		lblTerra.setBounds(1198, 511, 100, 100);
		lblTerra.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Insignias/TERRA0.png")))
				.getImage().getScaledInstance(lblTerra.getWidth(), lblTerra.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblTerra);

		lblNometreinador = new JLabel(treinador.getNomeTreinador());
		lblNometreinador.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		lblNometreinador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNometreinador.setBounds(815, 14, 337, 58);

		desktopPane.add(lblNometreinador);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 1366, 670);
		lblBackground.setIcon(
				new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Wallpaper/WallpaperTinicial.png")))
						.getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),
								java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblBackground);
		refresh();

	}

	public void refresh() {

		lblAvatar.setIcon(new ImageIcon(
				(new ImageIcon(TInicial.class.getResource("/images/Treinador/" + treinador.getSpritetreinador())))
						.getImage()
						.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH)));

		lblRocha.setIcon(new ImageIcon((new ImageIcon(TInicial.class
				.getResource("/images/Insignias/ROCHA" + treinador.nivelInsignia(treinador.getInsigRocha()) + ".png")))
						.getImage()
						.getScaledInstance(lblRocha.getWidth(), lblRocha.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblRocha.setToolTipText("Insignia da ROCHA - Nível: " + treinador.nivelInsignia(treinador.getInsigRocha()));
		lblCascata.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource(
				"/images/Insignias/CASCATA" + treinador.nivelInsignia(treinador.getInsigCascata()) + ".png")))
						.getImage()
						.getScaledInstance(lblRocha.getWidth(), lblRocha.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblCascata
				.setToolTipText("Insignia da Cascata - Nível: " + treinador.nivelInsignia(treinador.getInsigCascata()));
		lblTrovao.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource(
				"/images/Insignias/TROVAO" + treinador.nivelInsignia(treinador.getInsigTrovao()) + ".png"))).getImage()
						.getScaledInstance(lblTrovao.getWidth(), lblTrovao.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblTrovao.setToolTipText("Insignia do TROVÃO - Nível: " + treinador.nivelInsignia(treinador.getInsigTrovao()));
		lblArcoiris.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource(
				"/images/Insignias/ARCOIRIS" + treinador.nivelInsignia(treinador.getInsigArcoIris()) + ".png")))
						.getImage().getScaledInstance(lblArcoiris.getWidth(), lblArcoiris.getHeight(),
								java.awt.Image.SCALE_SMOOTH)));
		lblArcoiris.setToolTipText(
				"Insignia do ARCO-ÍRIS - Nível: " + treinador.nivelInsignia(treinador.getInsigArcoIris()));
		lblLama.setIcon(new ImageIcon((new ImageIcon(TInicial.class
				.getResource("/images/Insignias/LAMA" + treinador.nivelInsignia(treinador.getInsigLama()) + ".png")))
						.getImage()
						.getScaledInstance(lblLama.getWidth(), lblLama.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblLama.setToolTipText("Insignia da LAMA - Nível: " + treinador.nivelInsignia(treinador.getInsigLama()));
		lblAlma.setIcon(new ImageIcon((new ImageIcon(TInicial.class
				.getResource("/images/Insignias/ALMA" + treinador.nivelInsignia(treinador.getInsigAlma()) + ".png")))
						.getImage()
						.getScaledInstance(lblAlma.getWidth(), lblAlma.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblAlma.setToolTipText("Insignia da ALMA - Nível:" + treinador.nivelInsignia(treinador.getInsigAlma()));
		lblVulcao.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource(
				"/images/Insignias/VULCAO" + treinador.nivelInsignia(treinador.getInsigVulcao()) + ".png"))).getImage()
						.getScaledInstance(lblVulcao.getWidth(), lblVulcao.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblVulcao.setToolTipText("Insignia do VULCÃO - Nível: " + treinador.nivelInsignia(treinador.getInsigVulcao()));
		lblTerra.setIcon(new ImageIcon((new ImageIcon(TInicial.class
				.getResource("/images/Insignias/TERRA" + treinador.nivelInsignia(treinador.getInsigTerra()) + ".png")))
						.getImage()
						.getScaledInstance(lblTerra.getWidth(), lblTerra.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		lblTerra.setToolTipText("Insignia da TERRA - Nível:" + treinador.nivelInsignia(treinador.getInsigTerra()));

	}
}
