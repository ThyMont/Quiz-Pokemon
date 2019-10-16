package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import control.Pokemon;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class TCadastroPokemon extends JInternalFrame {
	private JPanel panel;
	private JTextField txtNomepokemon;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JComboBox<String> cmbTipo1;
	private JComboBox<String> cmbTipo2;
	private JTextField txtClassificacao;
	private JTextArea textField;
	private JLabel lblTipo2Img;
	private JLabel lblTipo1Img;
	private JList<String> listFraq;
	private JList<String> listResist;

	public TCadastroPokemon() {
		setBorder(null);
		setBounds(0, 0, 1366, 706);

		panel = new JPanel();

		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblTelaDeCadastro = new JLabel("Cadastro de novos Pok\u00E9mon");
		lblTelaDeCadastro.setForeground(Color.WHITE);
		lblTelaDeCadastro.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		lblTelaDeCadastro.setBounds(191, 27, 462, 59);
		panel.add(lblTelaDeCadastro);

		JButton btnTelaInicial = new JButton("");
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
		lblTelaInicial.setForeground(Color.WHITE);
		lblTelaInicial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelaInicial.setBounds(47, 103, 88, 20);
		panel.add(lblTelaInicial);

		JLabel lblNumero = new JLabel("N\u00FAmero: #");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNumero.setBounds(50, 183, 137, 33);
		panel.add(lblNumero);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNome.setBounds(47, 239, 119, 33);
		panel.add(lblNome);

		JLabel lblTipo_1 = new JLabel("Tipo 1:");
		lblTipo_1.setForeground(Color.WHITE);
		lblTipo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo_1.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTipo_1.setBounds(378, 307, 182, 33);
		panel.add(lblTipo_1);

		JLabel lblTipo_2 = new JLabel("Tipo 2:");
		lblTipo_2.setForeground(Color.WHITE);
		lblTipo_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo_2.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTipo_2.setVisible(false);
		lblTipo_2.setBounds(378, 355, 182, 33);
		panel.add(lblTipo_2);

		JLabel lblClassificacao = new JLabel("Classifica\u00E7\u00E3o:");
		lblClassificacao.setForeground(Color.WHITE);
		lblClassificacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClassificacao.setFont(new Font("Dialog", Font.BOLD, 25));
		lblClassificacao.setBounds(378, 239, 182, 33);
		panel.add(lblClassificacao);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("Dialog", Font.BOLD, 25));
		lblAltura.setBounds(47, 307, 119, 33);
		panel.add(lblAltura);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPeso.setBounds(47, 355, 119, 33);
		panel.add(lblPeso);

		JPanel pnlResistencias = new JPanel();
		pnlResistencias.setBorder(
				new TitledBorder(null, "Resist\u00EAncias", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlResistencias.setBounds(915, 183, 417, 226);
		panel.add(pnlResistencias);
		pnlResistencias.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 393, 165);
		pnlResistencias.add(scrollPane);

		listResist = new JList<String>();
		listResist.setSelectionBackground(new Color(144, 238, 144));
		listResist.setFont(new Font("Dialog", Font.PLAIN, 18));
		listResist.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "AGUA", "DRAGAO", "ELETRICO", "FADA", "FANTASMA", "FOGO", "GELO", "GRAMA",
					"INSETO", "LUTADOR", "METAL", "NORMAL", "NOTURNO", "PEDRA", "PSIQUICO", "TERRESTRE", "VENENO",
					"VOADOR" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listResist);

		JLabel lblPressioneATecla = new JLabel("Pressione a tecla \"ctrl\" para selecionar mais de um tipo.");
		lblPressioneATecla.setBounds(12, 200, 393, 16);
		pnlResistencias.add(lblPressioneATecla);

		JPanel pnlFraquezas = new JPanel();
		pnlFraquezas.setBorder(new TitledBorder(new LineBorder(new Color(140, 140, 140)), "Fraquezas",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlFraquezas.setBounds(915, 421, 417, 226);
		panel.add(pnlFraquezas);
		pnlFraquezas.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 23, 393, 165);
		pnlFraquezas.add(scrollPane_1);

		listFraq = new JList<String>();
		listFraq.setSelectionBackground(new Color(255, 153, 153));
		listFraq.setFont(new Font("Dialog", Font.PLAIN, 18));
		listFraq.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "AGUA", "DRAGAO", "ELETRICO", "FADA", "FANTASMA", "FOGO", "GELO", "GRAMA",
					"INSETO", "LUTADOR", "METAL", "NORMAL", "NOTURNO", "PEDRA", "PSIQUICO", "TERRESTRE", "VENENO",
					"VOADOR" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(listFraq);

		JLabel label = new JLabel("Pressione a tecla \"ctrl\" para selecionar mais de um tipo.");
		label.setBounds(12, 200, 393, 16);
		pnlFraquezas.add(label);

		MaskFormatter mskNumero = null;
		try {
			mskNumero = new MaskFormatter("###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField frmtdtxtfldNumero = new JFormattedTextField(mskNumero);
		frmtdtxtfldNumero.setToolTipText("3 D\u00EDgitos");
		frmtdtxtfldNumero.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmtdtxtfldNumero.setText("#" + mskNumero);
		frmtdtxtfldNumero.setBounds(191, 185, 55, 33);
		panel.add(frmtdtxtfldNumero);

		txtNomepokemon = new JTextField();
		txtNomepokemon.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtNomepokemon.setBounds(191, 241, 114, 33);
		panel.add(txtNomepokemon);
		txtNomepokemon.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtAltura.setBounds(191, 309, 114, 33);
		panel.add(txtAltura);
		txtAltura.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtPeso.setBounds(191, 357, 114, 33);
		panel.add(txtPeso);
		txtPeso.setColumns(10);

		lblTipo1Img = new JLabel();
		lblTipo1Img.setBorder(null);
		lblTipo1Img.setBackground(Color.WHITE);
		lblTipo1Img.setAlignmentX(0.5f);
		lblTipo1Img.setBounds(743, 313, 71, 27);
		panel.add(lblTipo1Img);

		lblTipo2Img = new JLabel();
		lblTipo2Img.setBorder(null);
		lblTipo2Img.setBackground(Color.WHITE);
		lblTipo2Img.setAlignmentX(0.5f);
		lblTipo2Img.setBounds(743, 361, 71, 27);
		panel.add(lblTipo2Img);

		cmbTipo1 = new JComboBox<String>();
		cmbTipo1.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmbTipo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cmbTipo1.getSelectedIndex() == 0) {
					cmbTipo2.setEnabled(false);
					cmbTipo2.setVisible(false);
					lblTipo_2.setVisible(false);
					lblTipo1Img.setVisible(false);
					lblTipo2Img.setVisible(false);

				} else {
					lblTipo1Img.setVisible(true);
					lblTipo1Img.setIcon(new ImageIcon(new ImageIcon(TCadastroPokemon.class
							.getResource("/images/TagTipos/" + cmbTipo1.getSelectedItem() + ".png")).getImage()
									.getScaledInstance(lblTipo1Img.getWidth(), lblTipo1Img.getHeight(),
											java.awt.Image.SCALE_SMOOTH)));
					cmbTipo2.setEnabled(true);
					cmbTipo2.setVisible(true);
					lblTipo_2.setVisible(true);
				}
			}
		});
		cmbTipo1.setModel(new DefaultComboBoxModel<String>(new String[] { "", "AGUA", "DRAGAO", "ELETRICO", "FADA",
				"FANTASMA", "FOGO", "GELO", "GRAMA", "INSETO", "LUTADOR", "METAL", "NORMAL", "NOTURNO", "PEDRA",
				"PSIQUICO", "TERRESTRE", "VENENO", "VOADOR" }));
		cmbTipo1.setBounds(576, 309, 149, 33);
		panel.add(cmbTipo1);

		cmbTipo2 = new JComboBox<String>();
		cmbTipo2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cmbTipo2.getSelectedIndex() == 0) {
					lblTipo2Img.setVisible(false);

				} else {
					lblTipo2Img.setVisible(true);
					lblTipo2Img.setIcon(new ImageIcon(new ImageIcon(TCadastroPokemon.class
							.getResource("/images/TagTipos/" + cmbTipo2.getSelectedItem() + ".png")).getImage()
									.getScaledInstance(lblTipo1Img.getWidth(), lblTipo1Img.getHeight(),
											java.awt.Image.SCALE_SMOOTH)));
				}
			}
		});
		cmbTipo2.setFont(new Font("Dialog", Font.PLAIN, 20));
		cmbTipo2.setVisible(false);
		cmbTipo2.setEnabled(false);
		cmbTipo2.setModel(new DefaultComboBoxModel<String>(new String[] { "", "AGUA", "DRAGAO", "ELETRICO", "FADA",
				"FANTASMA", "FOGO", "GELO", "GRAMA", "INSETO", "LUTADOR", "METAL", "NORMAL", "NOTURNO", "PEDRA",
				"PSIQUICO", "TERRESTRE", "VENENO", "VOADOR" }));
		cmbTipo2.setBounds(576, 357, 149, 33);
		panel.add(cmbTipo2);

		txtClassificacao = new JTextField();
		txtClassificacao.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtClassificacao.setBounds(578, 241, 236, 33);
		panel.add(txtClassificacao);
		txtClassificacao.setColumns(10);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDescricao.setBounds(12, 414, 155, 33);
		panel.add(lblDescricao);

		textField = new JTextArea();
		textField.setLineWrap(true);
		textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(191, 416, 313, 234);
		panel.add(textField);

		JButton btnSalvarNovoPokmon = new JButton("Salvar Novo Pok\u00E9mon");
		btnSalvarNovoPokmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (frmtdtxtfldNumero.getValue().toString().isEmpty()) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Informe um número válido", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (txtNomepokemon.getText().isEmpty() || txtNomepokemon.getText().contains(":")) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Informe um nome pokémon válido", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (txtAltura.getText().isEmpty() || txtAltura.getText().contains(":")) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Informe uma altura válida", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (txtPeso.getText().isEmpty() || txtPeso.getText().contains(":")) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Informe um peso válido", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (txtClassificacao.getText().isEmpty() || txtClassificacao.getText().contains(":")) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Informe uma Classificação válida", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (textField.getText().isEmpty() || textField.getText().contains(":")) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Verifique a Descrição", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (cmbTipo1.getSelectedIndex() == 0) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Selecione pelo menos 1 tipo para o novo Pokémon", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (cmbTipo1.getSelectedIndex() == 0) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Selecione pelo menos 1 tipo para o novo Pokémon", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (listResist.getSelectedValuesList().isEmpty() || listFraq.getSelectedValuesList().isEmpty()) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Verifique as Fraquezas e resistências", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (listResist.getSelectedValuesList().size() > 8
						|| listFraq.getSelectedValuesList().size() > 8) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Verifique as Fraquezas e resistências.\nMáximo de 8 para cada",
							"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);

				} else {
					String numero = "#" + frmtdtxtfldNumero.getValue();
					String nome = txtNomepokemon.getText();
					String classificacao = txtClassificacao.getText();
					String altura = txtAltura.getText();
					String peso = txtPeso.getText();
					String tipo;
					if (cmbTipo2.getSelectedIndex() == 0) {
						tipo = "" + cmbTipo1.getSelectedItem();
					} else {
						tipo = cmbTipo1.getSelectedItem() + "&" + cmbTipo2.getSelectedItem();
					}
					String fraquezas = null;
					List<String> listaFraquezas = listFraq.getSelectedValuesList();
					switch (listaFraquezas.size()) {
					case 1: {
						fraquezas = listaFraquezas.get(0);
						break;
					}
					case 2: {
						fraquezas = listaFraquezas.get(0) + "@" + listaFraquezas.get(1);
						break;
					}
					case 3: {
						fraquezas = listaFraquezas.get(0) + "@" + listaFraquezas.get(1) + "@" + listaFraquezas.get(2);
						break;
					}
					case 4: {
						fraquezas = listaFraquezas.get(0) + "@" + listaFraquezas.get(1) + "@" + listaFraquezas.get(2) + "@"
								+ listaFraquezas.get(3);
						break;
					}
					case 5: {
						fraquezas = listaFraquezas.get(0) + "@" + listaFraquezas.get(1) + "@" + listaFraquezas.get(2) + "@"
								+ listaFraquezas.get(3) + "@" + listaFraquezas.get(4);
						break;
					}
					case 6: {
						fraquezas = listaFraquezas.get(0) + "@" + listaFraquezas.get(1) + "@" + listaFraquezas.get(2) + "@"
								+ listaFraquezas.get(3) + "@" + listaFraquezas.get(4) + "@" + listaFraquezas.get(5);
						break;
					}
					case 7: {
						fraquezas = listaFraquezas.get(0) + "@" + listaFraquezas.get(1) + "@" + listaFraquezas.get(2) + "@"
								+ listaFraquezas.get(3) + "@" + listaFraquezas.get(4) + "@" + listaFraquezas.get(5)
								+ "@" + listaFraquezas.get(6);
						break;
					}
					case 8: {
						fraquezas = listaFraquezas.get(0) + "@" + listaFraquezas.get(1) + "@" + listaFraquezas.get(2) + "@"
								+ listaFraquezas.get(3) + "@" + listaFraquezas.get(4) + "@" + listaFraquezas.get(5)
								+ "@" + listaFraquezas.get(6) + "@" + listaFraquezas.get(7);
						break;
					}

					}

					String resistencias = null;
					List<String> listaResistencias = listResist.getSelectedValuesList();
					switch (listaResistencias.size()) {
					case 1: {
						resistencias = listaResistencias.get(0);
						break;
					}
					case 2: {
						resistencias = listaResistencias.get(0) + "%" + listaResistencias.get(1);
						break;
					}
					case 3: {
						resistencias = listaResistencias.get(0) + "%" + listaResistencias.get(1) + "%"
								+ listaResistencias.get(2);
						break;
					}
					case 4: {
						resistencias = listaResistencias.get(0) + "%" + listaResistencias.get(1) + "%"
								+ listaResistencias.get(2) + "%" + listaResistencias.get(3);
						break;
					}
					case 5: {
						resistencias = listaResistencias.get(0) + "%" + listaResistencias.get(1) + "%"
								+ listaResistencias.get(2) + "%" + listaResistencias.get(3) + "%"
								+ listaResistencias.get(4);
						break;
					}
					case 6: {
						resistencias = listaResistencias.get(0) + "%" + listaResistencias.get(1) + "%"
								+ listaResistencias.get(2) + "%" + listaResistencias.get(3) + "%"
								+ listaResistencias.get(4) + "%" + listaResistencias.get(5);
						break;
					}
					case 7: {
						resistencias = listaResistencias.get(0) + "%" + listaResistencias.get(1) + "%"
								+ listaResistencias.get(2) + "%" + listaResistencias.get(3) + "%"
								+ listaResistencias.get(4) + "%" + listaResistencias.get(5) + "%"
								+ listaResistencias.get(6);
						break;
					}
					case 8: {
						resistencias = listaResistencias.get(0) + "%" + listaResistencias.get(1) + "%"
								+ listaResistencias.get(2) + "%" + listaResistencias.get(3) + "%"
								+ listaResistencias.get(4) + "%" + listaResistencias.get(5) + "%"
								+ listaResistencias.get(6) + "%" + listaResistencias.get(7);
						break;
					}


					}

					String descricao = textField.getText();
					
					new Pokemon(numero, nome,classificacao, altura, peso, tipo, fraquezas, resistencias, descricao);
				}

			}
		});
		btnSalvarNovoPokmon.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btnSalvarNovoPokmon.setBounds(576, 469, 262, 46);
		panel.add(btnSalvarNovoPokmon);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btnCancelar.setBounds(576, 536, 262, 46);
		panel.add(btnCancelar);
		
				JLabel lblBackground = new JLabel("");
				lblBackground.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				lblBackground.setBounds(0, 0, 1366, 706);
				lblBackground.setIcon(new ImageIcon(
						(new ImageIcon(TCadastroTreinador.class.getResource("/images/Wallpaper/WallpaperPKBL.png"))).getImage()
								.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),
										java.awt.Image.SCALE_SMOOTH)));
				panel.add(lblBackground);

	}
}
