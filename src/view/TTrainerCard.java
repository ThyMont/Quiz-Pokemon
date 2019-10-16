package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import control.Treinador;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class TTrainerCard extends JInternalFrame {
	private JPanel panel;
	private Treinador treinador;
	private JComboBox<String> cmbRegiao;
	private JComboBox<String> cmbCidade;
	private JPasswordField txtSenha;
	private JComboBox<String> cmbMes;
	private JComboBox<String> cmbDia;
	private JButton btnCancelar;
	private JLabel lblAvatar;

	public TTrainerCard(JDesktopPane desktopPane, String nomeTreinador) {
		treinador = new Treinador(nomeTreinador);
		setBorder(null);
		setBounds(0, 0, 1366, 698);

		panel = new JPanel();
		panel.setBorder(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblAvatar = new JLabel("");
		lblAvatar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatar.setBorder(null);
		lblAvatar.setBounds(0, 29, 336, 496);
		lblAvatar.setIcon(new ImageIcon((new ImageIcon(
				TCadastroTreinador.class.getResource("/images/Treinador/" + treinador.getSpritetreinador()))).getImage()
						.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(lblAvatar);

		JTextField txtTrainerName = new JTextField();
		txtTrainerName.setEditable(false);
		txtTrainerName.setFont(new Font("Dialog", Font.PLAIN, 25));
		txtTrainerName.setText(treinador.getNomeTreinador());
		txtTrainerName.setBounds(672, 22, 256, 39);
		panel.add(txtTrainerName);
		txtTrainerName.setColumns(10);

		JLabel lblNomeDeTreinador = new JLabel("Nome de Treinador:");
		lblNomeDeTreinador.setForeground(Color.WHITE);
		lblNomeDeTreinador.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNomeDeTreinador.setBounds(412, 24, 242, 34);
		panel.add(lblNomeDeTreinador);

		JLabel lblExperincia = new JLabel();
		lblExperincia.setText("Experiência total: " + treinador.getExperiencia() + " pontos");
		lblExperincia.setForeground(Color.WHITE);
		lblExperincia.setFont(new Font("Dialog", Font.BOLD, 25));
		lblExperincia.setBounds(412, 126, 429, 34);
		panel.add(lblExperincia);

		JProgressBar barXP = new JProgressBar();
		barXP.setForeground(Color.BLUE);
		barXP.setBounds(714, 188, 214, 26);
		barXP.setMaximum(treinador.determinarExpMaximo());
		barXP.setValue(barXP.getMaximum() - treinador.getProximoNivel());
		panel.add(barXP);

		JLabel lblPrximoNvel = new JLabel();
		lblPrximoNvel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblPrximoNvel.setForeground(Color.WHITE);
		lblPrximoNvel.setText("Próximo Nível: " + treinador.getProximoNivel() + " pontos");
		lblPrximoNvel.setBounds(412, 188, 284, 26);
		panel.add(lblPrximoNvel);

		JLabel lblNivel = new JLabel();
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNivel.setBounds(412, 77, 236, 26);
		lblNivel.setText("Nível: " + treinador.getNivel());
		panel.add(lblNivel);

		JComboBox<String> cmbAvatar = new JComboBox<String>();
		cmbAvatar.setFont(new Font("Dialog", Font.BOLD, 22));
		cmbAvatar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblAvatar.setIcon(new ImageIcon((new ImageIcon(
						TInicial.class.getResource("/images/Treinador/" + cmbAvatar.getSelectedItem() + ".png")))
								.getImage().getScaledInstance((int) (lblAvatar.getWidth() * 0.75),
										(int) (lblAvatar.getHeight() * 0.75), java.awt.Image.SCALE_SMOOTH)));
			}
		});
		cmbAvatar.setBounds(1089, 128, 256, 32);
		switch (treinador.getNivel()) {
		case 1:
			cmbAvatar.addItem("RED");
			cmbAvatar.addItem("LEAF");
			break;
		case 2:
			cmbAvatar.addItem("RED");
			cmbAvatar.addItem("LEAF");
			cmbAvatar.addItem("ETHAN");
			cmbAvatar.addItem("KRIS");
			break;
		case 3:
			cmbAvatar.addItem("RED");
			cmbAvatar.addItem("LEAF");
			cmbAvatar.addItem("ETHAN");
			cmbAvatar.addItem("KRIS");
			cmbAvatar.addItem("BRENDAN");
			cmbAvatar.addItem("MAY");
			break;
		case 4:
		default:
			cmbAvatar.addItem("RED");
			cmbAvatar.addItem("LEAF");
			cmbAvatar.addItem("ETHAN");
			cmbAvatar.addItem("KRIS");
			cmbAvatar.addItem("BRENDAN");
			cmbAvatar.addItem("MAY");
			cmbAvatar.addItem("LUCAS");
			cmbAvatar.addItem("DAWN");
			break;

		}
		for (int i = 0; i < cmbAvatar.getItemCount(); i++) {
			if (cmbAvatar.getItemAt(i)
					.equals(treinador.getSpritetreinador().substring(0, treinador.getSpritetreinador().indexOf('.'))))
				cmbAvatar.setSelectedIndex(i);

		}

		JLabel lblAvatar_1 = new JLabel("Avatar:");
		lblAvatar_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAvatar_1.setForeground(Color.WHITE);
		lblAvatar_1.setFont(new Font("Dialog", Font.BOLD, 25));
		lblAvatar_1.setBounds(819, 105, 256, 71);
		panel.add(lblAvatar_1);
		panel.add(cmbAvatar);

		JButton btnSalvarAlterações = new JButton("Salvar Cadastro");
		btnSalvarAlterações.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(
						(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
								.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
				if (cmbMes.getSelectedIndex() == 0 || cmbRegiao.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Há algum erro, verifique os dados novamente", "ATENÇÃO!!",
							JOptionPane.INFORMATION_MESSAGE, icon);

				} else if (txtSenha.getPassword().length <= 3) {
					JOptionPane.showMessageDialog(null,
							"Senha muito curta. Insira uma senha com no mínimo 4 caracteres", "ATENÇÃO!!",
							JOptionPane.INFORMATION_MESSAGE, icon);
				} else {

					String sprite = (String) cmbAvatar.getSelectedItem();
					String mes = (String) cmbMes.getSelectedItem();
					String dia = (String) cmbDia.getSelectedItem();
					String regiao = (String) cmbRegiao.getSelectedItem();
					String cidade = (String) cmbCidade.getSelectedItem();
					char[] senha = txtSenha.getPassword();
					treinador.salvarTreinador(sprite, mes, dia, regiao, cidade, senha);
					JOptionPane.showMessageDialog(null, "Treinador salvo com sucesso!", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);

					dispose();
				}
			}
		});
		btnSalvarAlterações.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		btnSalvarAlterações.setBounds(1016, 533, 329, 108);
		panel.add(btnSalvarAlterações);

		JLabel lblIdade = new JLabel("Data de Nascimento:");
		lblIdade.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setFont(new Font("Dialog", Font.BOLD, 25));
		lblIdade.setBounds(412, 235, 256, 71);
		panel.add(lblIdade);

		cmbCidade = new JComboBox<String>();
		cmbCidade.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cmbCidade.setBounds(1089, 254, 256, 39);
		panel.add(cmbCidade);

		cmbRegiao = new JComboBox<String>();
		cmbRegiao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String regiao = (String) cmbRegiao.getSelectedItem();
				switch (regiao) {
				case "KANTO":
					cmbCidade.setModel(new DefaultComboBoxModel<String>(new String[] { "PALLET TOWN", "VIRIDIAN CITY",
							"PEWTER CITY", "CERULEAN CITY", "VERMILION CITY", "LAVENDER TOWN", "CELADON CITY",
							"FUCHSIA CITY", "SAFFRON CITY", "CINNABAR ISLAND" }));
					break;
				case "JOHTO":
					cmbCidade.setModel(new DefaultComboBoxModel<String>(new String[] { "NEW BARK TOWN",
							"CHERRYGROVE CITY", "VIOLET CITY", "AZALEA TOWN", "GOLDENROD CITY", "ECRUTEAK CITY",
							"OLIVINE CITY", "CIANWOOD CITY", "MAHOGANY TOWN", "BLACKTHORN CITY" }));
					break;
				case "HOENN":
					cmbCidade.setModel(new DefaultComboBoxModel<String>(new String[] { "LITTLEROOT TOWN", "ODALE TOWN",
							"PETALBURG CITY", "RUSTBORO CITY", "DEWFORD TOWN", "SLATEPORT CITY", "MAUVILLE CITY",
							"VERDANTURF TOWN", "FALLARBOR TOWN", "LAVARIDGE TOWN", "FORTREE CITY", "LILYCOVE CITY",
							"MOSSDEEP CITY", "SOOTOPOLIS CITY", "PACIFIDLOG TOWN", "EVER GRANDE CITY" }));
					break;
				default:
					cmbCidade.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
				}
			}
		});
		cmbRegiao
				.setModel(new DefaultComboBoxModel<String>(new String[] { "(SELECIONAR)", "KANTO", "JOHTO", "HOENN" }));

		cmbRegiao.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cmbRegiao.setBounds(1089, 184, 256, 39);
		panel.add(cmbRegiao);

		cmbRegiao.setSelectedItem((String) treinador.getRegiao());
		cmbCidade.setSelectedItem((String) treinador.getCidade());

		JLabel lblRegiao = new JLabel("Regi\u00E3o:");
		lblRegiao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegiao.setForeground(Color.WHITE);
		lblRegiao.setFont(new Font("Dialog", Font.BOLD, 25));
		lblRegiao.setBounds(819, 165, 256, 71);
		panel.add(lblRegiao);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCidade.setBounds(819, 235, 256, 71);
		panel.add(lblCidade);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSenha.setBounds(819, 318, 256, 71);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Sua senha deve ter no m\u00EDnimo 4 caracteres.");
		txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		txtSenha.setColumns(10);
		txtSenha.setBounds(1089, 336, 256, 39);
		txtSenha.setText(treinador.getSenha());
		panel.add(txtSenha);

		cmbMes = new JComboBox<String>();
		cmbMes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch ((String) cmbMes.getSelectedItem()) {

				case "FEVEREIRO":
					cmbDia.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06",
							"07", "08", "09", "10", "11", "112", "13", "14", "15", "16", "17", "18", "19", "20", "21",
							"22", "23", "24", "25", "26", "27", "28", "29" }));
					break;
				case "JANEIRO":
				case "MARÇO":
				case "MAIO":
				case "JULHO":
				case "AGOSTO":
				case "OUTUBRO":
				case "DEZEMBRO":
					cmbDia.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06",
							"07", "08", "09", "10", "11", "112", "13", "14", "15", "16", "17", "18", "19", "20", "21",
							"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
					break;
				case "ABRIL":
				case "JUNHO":
				case "SETEMBRO":
				case "NOVEMBRO":
					cmbDia.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06",
							"07", "08", "09", "10", "11", "112", "13", "14", "15", "16", "17", "18", "19", "20", "21",
							"22", "23", "24", "25", "26", "27", "28", "29", "30", "0" }));
					break;
				default:
					cmbDia.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));

				}
			}
		});
		cmbMes.setModel(new DefaultComboBoxModel<String>(new String[] { "", "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL",
				"MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));
		cmbMes.setFont(new Font("Dialog", Font.PLAIN, 18));
		cmbMes.setBounds(682, 257, 154, 28);
		panel.add(cmbMes);

		cmbDia = new JComboBox<String>();
		cmbDia.setBounds(848, 257, 90, 28);
		panel.add(cmbDia);

		cmbMes.setSelectedItem((String) treinador.getMesNasc());
		cmbDia.setSelectedItem((String) treinador.getDiaNasc());

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		btnCancelar.setBounds(653, 533, 329, 108);
		panel.add(btnCancelar);

		JLabel lblBackground = new JLabel("");
		lblBackground
				.setToolTipText("Faltam " + treinador.getProximoNivel() + " pontos para o pr\u00F3ximo n\u00EDvel");
		lblBackground.setBounds(0, 0, 1366, 698);
		lblBackground.setIcon(
				new ImageIcon((new ImageIcon(TInicial.class.getResource("/images/Wallpaper/WallpaperPokeball.png")))
						.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(lblBackground);

	}
}
