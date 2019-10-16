package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.Pokemon;
import control.Treinador;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

@SuppressWarnings("serial")
public class TPokedex extends JInternalFrame {
	private JPanel panel;
	private JTabbedPane tabPokedex;
	JPanel pnlGen1;
	private JLabel lblNomepokemon;
	private JLabel lblImagempokemon;
	private JComboBox<String> comboBox;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JPanel pnlResistencia;
	private JLabel lblResist1;
	private JLabel lblResist2;
	private JLabel lblResist3;
	private JLabel lblResist4;
	private JLabel lblResist5;
	private JLabel lblResist6;
	private JLabel lblResist7;
	private JLabel lblResist8;
	private JLabel lblClassificacao;
	private JPanel panel_1;
	private JLabel lblFraq1;
	private JLabel lblFraq2;
	private JLabel lblFraq3;
	private JLabel lblFraq4;
	private JLabel lblFraq5;
	private JLabel lblFraq6;
	private JLabel lblFraq7;
	private JLabel lblFraq8;
	private Pokemon pokemon;
	private JLabel lblTipo01;
	private JLabel lblTipo02;
	private JTextPane txtpnDescrioDoPokemon;
	private Treinador treinador;
	private JButton btnTelaInicial;
	private JButton btnProcurar;
	private JLabel lblProcurar;

	public TPokedex(JDesktopPane desktopPane, String nomeTreinador) {
		setBorder(null);
		setBounds(0, 0, 1366, 706);
		treinador = new Treinador(nomeTreinador);
		pokemon = new Pokemon();
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tabPokedex = new JTabbedPane(JTabbedPane.TOP);
		tabPokedex.setBackground(Color.WHITE);
		tabPokedex.setBounds(153, 55, 1111, 609);
		tabPokedex.setFont(new Font("Dialog", Font.BOLD, 22));
		panel.add(tabPokedex);

		pnlGen1 = new JPanel();
		pnlGen1.setAutoscrolls(true);
		pnlGen1.setFont(new Font("Dialog", Font.PLAIN, 30));
		pnlGen1.setBackground(new Color(255, 255, 255));
		ImageIcon icon = new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Pokemon/#001.png")))
				.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		tabPokedex.addTab("1ª Geração", icon, pnlGen1, null);
		pnlGen1.setLayout(null);

		lblImagempokemon = new JLabel("");
		lblImagempokemon.setBorder(null);
		lblImagempokemon.setBackground(Color.YELLOW);
		lblImagempokemon.setBounds(105, 63, 350, 350);
		pnlGen1.add(lblImagempokemon);

		lblTipo01 = new JLabel("");
		lblTipo01.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTipo01.setBackground(Color.WHITE);
		lblTipo01.setBorder(null);
		lblTipo01.setBounds(105, 468, 142, 54);
		pnlGen1.add(lblTipo01);

		lblTipo02 = new JLabel("");
		lblTipo02.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTipo02.setBorder(null);
		lblTipo02.setBackground(Color.WHITE);
		lblTipo02.setBounds(292, 468, 142, 54);
		pnlGen1.add(lblTipo02);

		lblNomepokemon = new JLabel("NomePokemon");
		lblNomepokemon.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNomepokemon.setBounds(276, 10, 231, 25);
		pnlGen1.add(lblNomepokemon);

		txtpnDescrioDoPokemon = new JTextPane();
		txtpnDescrioDoPokemon.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtpnDescrioDoPokemon.setBackground(new Color(255, 255, 255));
		txtpnDescrioDoPokemon.setEditable(false);
		txtpnDescrioDoPokemon.setBorder(
				new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtpnDescrioDoPokemon.setBounds(604, 50, 458, 120);
		pnlGen1.add(txtpnDescrioDoPokemon);

		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAltura.setBounds(599, 413, 79, 36);
		pnlGen1.add(lblAltura);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPeso.setBounds(873, 413, 61, 36);
		pnlGen1.add(lblPeso);

		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtAltura.setBackground(new Color(255, 255, 255));
		txtAltura.setEditable(false);
		txtAltura.setColumns(10);
		txtAltura.setBounds(668, 411, 126, 40);
		pnlGen1.add(txtAltura);

		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtPeso.setBackground(new Color(255, 255, 255));
		txtPeso.setEditable(false);
		txtPeso.setColumns(10);
		txtPeso.setBounds(936, 411, 126, 40);
		pnlGen1.add(txtPeso);

		pnlResistencia = new JPanel();
		pnlResistencia.setLayout(null);
		pnlResistencia.setName("Resist\u00EAncias");
		pnlResistencia.setBorder(
				new TitledBorder(null, "Resist\u00EAncias", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlResistencia.setBackground(new Color(224, 255, 255));
		pnlResistencia.setBounds(604, 182, 458, 94);
		pnlGen1.add(pnlResistencia);

		lblResist1 = new JLabel("");
		lblResist1.setBorder(null);
		lblResist1.setBounds(12, 23, 71, 27);
		pnlResistencia.add(lblResist1);

		lblResist2 = new JLabel("");
		lblResist2.setBorder(null);
		lblResist2.setBounds(130, 23, 71, 27);
		pnlResistencia.add(lblResist2);

		lblResist3 = new JLabel("");
		lblResist3.setBorder(null);
		lblResist3.setBounds(250, 23, 71, 27);
		pnlResistencia.add(lblResist3);

		lblResist4 = new JLabel("");
		lblResist4.setBorder(null);
		lblResist4.setBounds(370, 23, 71, 27);
		pnlResistencia.add(lblResist4);

		lblResist5 = new JLabel("");
		lblResist5.setBorder(null);
		lblResist5.setBounds(12, 60, 71, 27);
		pnlResistencia.add(lblResist5);

		lblResist6 = new JLabel("");
		lblResist6.setBorder(null);
		lblResist6.setBounds(130, 60, 71, 25);
		pnlResistencia.add(lblResist6);

		lblResist7 = new JLabel("");
		lblResist7.setBorder(null);
		lblResist7.setBounds(250, 60, 71, 27);
		pnlResistencia.add(lblResist7);

		lblResist8 = new JLabel("");
		lblResist8.setBorder(null);
		lblResist8.setBounds(370, 60, 71, 27);
		pnlResistencia.add(lblResist8);

		lblClassificacao = new JLabel();
		lblClassificacao.setBorder(null);

		lblClassificacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassificacao.setFont(new Font("Malgun Gothic", Font.BOLD, 28));
		lblClassificacao.setBounds(604, 10, 458, 34);
		pnlGen1.add(lblClassificacao);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setName("Fraquezas");
		panel_1.setBorder(new TitledBorder(null, "Fraquezas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setBounds(604, 288, 458, 94);
		pnlGen1.add(panel_1);

		lblFraq1 = new JLabel("");
		lblFraq1.setBorder(null);
		lblFraq1.setBounds(12, 20, 71, 27);
		panel_1.add(lblFraq1);

		lblFraq2 = new JLabel("");
		lblFraq2.setBorder(null);
		lblFraq2.setBounds(130, 20, 71, 27);
		panel_1.add(lblFraq2);

		lblFraq3 = new JLabel("");
		lblFraq3.setBorder(null);
		lblFraq3.setBounds(250, 20, 71, 27);
		panel_1.add(lblFraq3);

		lblFraq4 = new JLabel("");
		lblFraq4.setBorder(null);
		lblFraq4.setBounds(370, 20, 71, 27);
		panel_1.add(lblFraq4);

		lblFraq5 = new JLabel("");
		lblFraq5.setBorder(null);
		lblFraq5.setBounds(12, 57, 71, 27);
		panel_1.add(lblFraq5);

		lblFraq6 = new JLabel("");
		lblFraq6.setBorder(null);
		lblFraq6.setBounds(130, 57, 71, 27);
		panel_1.add(lblFraq6);

		lblFraq7 = new JLabel("");
		lblFraq7.setBorder(null);
		lblFraq7.setBounds(250, 57, 71, 27);
		panel_1.add(lblFraq7);

		lblFraq8 = new JLabel("");
		lblFraq8.setBorder(null);
		lblFraq8.setBounds(370, 57, 71, 27);
		panel_1.add(lblFraq8);

		JPanel pnlGen2 = new JPanel();
		pnlGen2.setEnabled(false);
		ImageIcon icon2 = new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/pokeballIcon.png")))
				.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		tabPokedex.addTab("2ª Geração", icon2, pnlGen2, null);
		tabPokedex.setEnabledAt(1, false);

		btnTelaInicial = new JButton("");
		btnTelaInicial.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Home.png"))).getImage()
				.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		btnTelaInicial.setBackground(Color.DARK_GRAY);
		btnTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnTelaInicial.setBounds(47, 27, 88, 68);
		panel.add(btnTelaInicial);
		
		JLabel lblTelaInicial = new JLabel("Tela Inicial");
		lblTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaInicial.setForeground(Color.BLACK);
		lblTelaInicial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelaInicial.setBounds(47, 103, 88, 20);
		panel.add(lblTelaInicial);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pokemon.setPokedex(treinador.getPokedexVisto());
				String pokemonSelecionado = (String) comboBox.getSelectedItem();
				String numeroPokemon = pokemonSelecionado.substring(0, 4);
				pokemon.preencherDescricao(numeroPokemon,treinador.getPokedexVisto());
				lblNomepokemon.setName(pokemon.getNome());
				lblImagempokemon.setIcon(new ImageIcon(
						(new ImageIcon(TInicial.class.getResource("/images/Pokemon/" + pokemon.getNumero() + ".png")))
								.getImage().getScaledInstance(lblImagempokemon.getWidth(), lblImagempokemon.getHeight(),
										java.awt.Image.SCALE_SMOOTH)));
				lblNomepokemon.setText(pokemonSelecionado);
				lblClassificacao.setText(pokemon.getClassificacao());
				txtAltura.setText(pokemon.getAltura());
				txtPeso.setText(pokemon.getPeso());
				txtpnDescrioDoPokemon.setText(pokemon.getDescricao());
				// Adicionar o Tipo do Pokémon
				try{
					lblTipo01.setIcon(new ImageIcon(new ImageIcon(pokemon.exibirTipo(pokemon.getTipo()[0])).getImage()
				
						.getScaledInstance(lblTipo01.getWidth(), lblTipo01.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblTipo01.setVisible(true);
				} catch (Exception e) {
					lblTipo01.setVisible(true);
				}
					try {
					// if (pokemon.getTipo().length == 2) {
					lblTipo02.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(pokemon.getTipo()[1])).getImage().getScaledInstance(
									lblTipo02.getWidth(), lblTipo02.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblTipo02.setVisible(true);
					// } else

				} catch (Exception e) {
					lblTipo02.setVisible(false);
				}
				// Adicionar as Resistências
				String[] resistencia = pokemon.getResistencias();

				try{
					lblResist1.setIcon(
			
						new ImageIcon(new ImageIcon(pokemon.exibirTipo(resistencia[0])).getImage().getScaledInstance(
								lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist1.setVisible(true);
				} catch (Exception e) {
					lblResist1.setVisible(false);
				}
					try {
					lblResist2.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(resistencia[1])).getImage().getScaledInstance(
									lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist2.setVisible(true);
				} catch (Exception e1) {
					lblResist2.setVisible(false);
				}
				try {
					lblResist3.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(resistencia[2])).getImage().getScaledInstance(
									lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist3.setVisible(true);
				} catch (Exception e2) {
					lblResist3.setVisible(false);
				}
				try {
					lblResist4.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(resistencia[3])).getImage().getScaledInstance(
									lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist4.setVisible(true);
				} catch (Exception e2) {
					lblResist4.setVisible(false);
				}
				try {
					lblResist5.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(resistencia[4])).getImage().getScaledInstance(
									lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist5.setVisible(true);
				} catch (Exception e2) {
					lblResist5.setVisible(false);
				}
				try {
					lblResist6.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(resistencia[5])).getImage().getScaledInstance(
									lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist6.setVisible(true);
				} catch (Exception e2) {
					lblResist6.setVisible(false);
				}
				try {
					lblResist7.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(resistencia[6])).getImage().getScaledInstance(
									lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist7.setVisible(true);
				} catch (Exception e2) {
					lblResist7.setVisible(false);
				}
				try {
					lblResist8.setIcon(new ImageIcon(
							new ImageIcon(pokemon.exibirTipo(resistencia[7])).getImage().getScaledInstance(
									lblResist1.getWidth(), lblResist1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblResist8.setVisible(true);
				} catch (Exception e2) {
					lblResist8.setVisible(false);
				}

				// Adicionar as Fraquezas
				String[] fraqueza = pokemon.getFraquezas();

				try{
					lblFraq1.setIcon(new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[0])).getImage()
				
						.getScaledInstance(lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq1.setVisible(true);
				}catch (Exception e) {
					lblFraq1.setVisible(false);
				}
					try {
					lblFraq2.setIcon(
							new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[1])).getImage().getScaledInstance(
									lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq2.setVisible(true);
				} catch (Exception e1) {
					lblFraq2.setVisible(false);
				}
				try {
					lblFraq3.setIcon(
							new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[2])).getImage().getScaledInstance(
									lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq3.setVisible(true);
				} catch (Exception e2) {
					lblFraq3.setVisible(false);
				}
				try {
					lblFraq4.setIcon(
							new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[3])).getImage().getScaledInstance(
									lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq4.setVisible(true);
				} catch (Exception e2) {
					lblFraq4.setVisible(false);
				}
				try {
					lblFraq5.setIcon(
							new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[4])).getImage().getScaledInstance(
									lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq5.setVisible(true);
				} catch (Exception e2) {
					lblFraq5.setVisible(false);
				}
				try {
					lblFraq6.setIcon(
							new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[5])).getImage().getScaledInstance(
									lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq6.setVisible(true);
				} catch (Exception e2) {
					lblFraq6.setVisible(false);
				}
				try {
					lblFraq7.setIcon(
							new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[6])).getImage().getScaledInstance(
									lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq7.setVisible(true);
				} catch (Exception e2) {
					lblFraq7.setVisible(false);
				}
				try {
					lblFraq8.setIcon(
							new ImageIcon(new ImageIcon(pokemon.exibirTipo(fraqueza[7])).getImage().getScaledInstance(
									lblFraq1.getWidth(), lblFraq1.getHeight(), java.awt.Image.SCALE_SMOOTH)));
					lblFraq8.setVisible(true);
				} catch (Exception e2) {
					lblFraq8.setVisible(false);
				}

			}
		});
		String[] lista = pokemon.listarNomesENumeros();
		comboBox.setModel(new DefaultComboBoxModel<String>(lista));
		comboBox.setSelectedIndex(0);

		comboBox.setBounds(33, 12, 200, 25);
		pnlGen1.add(comboBox);
		
		btnProcurar = new JButton("");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JComboBox<String> jcb = new JComboBox<String>();
				
				new JOptionPane();
				String nomePokemon = pokemon.pesquisar(JOptionPane.showInputDialog("Pesquisa Pokémon por nome, descrição ou tipo. \n\n Digite o Pokémon desejado:"));
				if (nomePokemon.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum Pokémon encontrado =(");
				}else {
				jcb.setModel(new DefaultComboBoxModel<String>(nomePokemon.split(":")));
				JOptionPane.showConfirmDialog(null, jcb, "Selecione o Pokémon", JOptionPane.OK_CANCEL_OPTION);
				comboBox.setSelectedItem(jcb.getSelectedItem());
				}
			}
		});
		btnProcurar.setIcon(new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/lupa.png"))).getImage()
				.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
		btnProcurar.setBounds(47, 143, 88, 68);
		panel.add(btnProcurar);
		
		lblProcurar = new JLabel("Procurar");
		lblProcurar.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcurar.setFont(new Font("Dialog", Font.BOLD, 15));
		lblProcurar.setBounds(47, 220, 88, 16);
		panel.add(lblProcurar);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 1366, 720);
		lblBackground.setIcon(
				new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Wallpaper/WallpaperPKBL.png")))
						.getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),
								java.awt.Image.SCALE_SMOOTH)));
		panel.add(lblBackground);
	}
}
