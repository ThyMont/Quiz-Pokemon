package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import control.Treinador;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class TCadastroTreinador extends JInternalFrame {
	private JLabel lblAvatar;
	private JPanel panel;
	private Treinador treinador;
	private JComboBox<String> cmbRegiao;
	private JComboBox<String> cmbCidade;
	private JPasswordField txtSenha;
	private JComboBox<String> cmbMes;
	private JComboBox<String> cmbAvatar;
	private JComboBox<String> cmbDia;
	private JTextField txtTrainerName;
	private JLabel lblTreinadorN;
	private JButton btnCancelar;

	public TCadastroTreinador() {
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
		lblAvatar.setIcon(new ImageIcon(
				(new ImageIcon(TCadastroTreinador.class.getResource("/images/Treinador/RED.png"))).getImage()
						.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		panel.add(lblAvatar);

		txtTrainerName = new JTextField();
		txtTrainerName.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		txtTrainerName.setText("RED");
		txtTrainerName.setBounds(756, 113, 256, 39);
		panel.add(txtTrainerName);
		txtTrainerName.setColumns(10);

		JLabel lblNomeDeTreinador = new JLabel("Nome de Treinador:");
		lblNomeDeTreinador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDeTreinador.setForeground(Color.WHITE);
		lblNomeDeTreinador.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNomeDeTreinador.setBounds(486, 96, 256, 71);
		panel.add(lblNomeDeTreinador);

		cmbAvatar = new JComboBox<String>();
		cmbAvatar.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cmbAvatar.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblAvatar.setIcon(new ImageIcon((new ImageIcon(TCadastroTreinador.class
						.getResource("/images/Treinador/" + cmbAvatar.getSelectedItem() + ".png"))).getImage()
								.getScaledInstance((int) (lblAvatar.getWidth() * 0.75),
										(int) (lblAvatar.getHeight() * 0.75), java.awt.Image.SCALE_SMOOTH)));
			}
		});
		cmbAvatar.setBounds(756, 249, 256, 39);

		cmbAvatar.addItem("RED");
		cmbAvatar.addItem("LEAF");

		JLabel lblAvatar_1 = new JLabel("Avatar:");
		lblAvatar_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAvatar_1.setForeground(Color.WHITE);
		lblAvatar_1.setFont(new Font("Dialog", Font.BOLD, 25));
		lblAvatar_1.setBounds(486, 232, 256, 71);
		panel.add(lblAvatar_1);
		panel.add(cmbAvatar);

		JButton btnSalvarCadastro = new JButton("Salvar Cadastro");
		btnSalvarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon(
						(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
								.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
				if (txtTrainerName.getText().contains("##") || cmbMes.getSelectedIndex() == 0
						|| cmbRegiao.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Há algum erro, verifique os dados novamente", "ATENÇÃO!!",
							JOptionPane.INFORMATION_MESSAGE, icon);

				} else if (txtSenha.getPassword().length <= 3) {

				} else {
					String nomeTreinador = txtTrainerName.getText();
					String avatar = (String) cmbAvatar.getSelectedItem();
					String mes = (String) cmbMes.getSelectedItem();
					String dia = (String) cmbDia.getSelectedItem();
					String regiao = (String) cmbRegiao.getSelectedItem();
					String cidade = (String) cmbCidade.getSelectedItem();
					char[] senha = txtSenha.getPassword();
					new Treinador(nomeTreinador, avatar, mes, dia, regiao, cidade, senha);
					JOptionPane.showMessageDialog(null, "Treinador salvo com sucesso!", "Gotcha!",
							JOptionPane.INFORMATION_MESSAGE, icon);

					dispose();
				}
			}
		});
		btnSalvarCadastro.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		btnSalvarCadastro.setBounds(1016, 533, 329, 108);
		panel.add(btnSalvarCadastro);

		JLabel lblIdade = new JLabel("Data de Nascimento:");
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setFont(new Font("Dialog", Font.BOLD, 25));
		lblIdade.setBounds(486, 164, 256, 71);
		panel.add(lblIdade);

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
				case "Hoenn":
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
		cmbRegiao.setModel(new DefaultComboBoxModel<String>(
				new String[] { "(SELECIONAR)", "KANTO", "JOHTO", "HOENN" }));
		cmbRegiao.setSelectedIndex(0);
		cmbRegiao.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cmbRegiao.setBounds(756, 318, 256, 39);
		panel.add(cmbRegiao);

		JLabel lblRegiao = new JLabel("Regi\u00E3o:");
		lblRegiao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegiao.setForeground(Color.WHITE);
		lblRegiao.setFont(new Font("Dialog", Font.BOLD, 25));
		lblRegiao.setBounds(486, 299, 256, 71);
		panel.add(lblRegiao);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 25));
		lblCidade.setBounds(486, 369, 256, 71);
		panel.add(lblCidade);

		cmbCidade = new JComboBox<String>();
		cmbCidade.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cmbCidade.setBounds(756, 388, 256, 39);
		panel.add(cmbCidade);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSenha.setBounds(486, 454, 256, 71);
		panel.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Sua senha deve ter no m\u00EDnimo 4 caracteres.");
		txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		txtSenha.setColumns(10);
		txtSenha.setBounds(756, 472, 256, 39);
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
		cmbMes.setBounds(756, 186, 154, 28);
		panel.add(cmbMes);

		cmbDia = new JComboBox<String>();
		cmbDia.setBounds(922, 186, 90, 28);
		panel.add(cmbDia);

		lblTreinadorN = new JLabel();
		lblTreinadorN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreinadorN.setForeground(Color.WHITE);
		lblTreinadorN.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTreinadorN.setBounds(486, 13, 526, 71);
		{
			treinador = new Treinador();
			lblTreinadorN.setText("Treinador nº:" + (treinador.contaTreinador() + 1));
		}
		panel.add(lblTreinadorN);

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
		lblBackground.setBounds(0, 0, 1366, 720);
		lblBackground.setIcon(new ImageIcon(
				(new ImageIcon(TCadastroTreinador.class.getResource("/images/Wallpaper/WallpaperPokeball.png")))
						.getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),
								java.awt.Image.SCALE_SMOOTH)));
		panel.add(lblBackground);

	}
}
