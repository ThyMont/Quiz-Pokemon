package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import control.Treinador;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class TLogin extends JInternalFrame {
	private JComboBox<String> cmbNomeTreinador;
	private JPasswordField pwdSenha;
	private JDesktopPane desktop;
	private Treinador treinador;
	private TInicial tinicial;

	public TLogin(JDesktopPane desktopPane) {

		desktop = desktopPane;
		desktop.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent arg0) {
				refresh();
			}
		});
		setBorder(null);
		setBounds(59, 248, 412, 283);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNomeDeTreinador = new JLabel("Nome de Treinador:");
		lblNomeDeTreinador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomeDeTreinador.setBounds(12, 52, 179, 38);
		panel.add(lblNomeDeTreinador);

		cmbNomeTreinador = new JComboBox<String>();
		cmbNomeTreinador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbNomeTreinador.setBounds(202, 55, 198, 33);
		refresh();
		panel.add(cmbNomeTreinador);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(129, 102, 62, 31);
		panel.add(lblSenha);

		pwdSenha = new JPasswordField();
		pwdSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pwdSenha.setText("");
			}
		});
		pwdSenha.setText("150236");
		pwdSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdSenha.setBounds(202, 100, 198, 33);
		panel.add(pwdSenha);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					treinador = new Treinador((String) cmbNomeTreinador.getSelectedItem());
					String senhaDigitada = String.valueOf(pwdSenha.getPassword());
					if (treinador.verificarSenha(senhaDigitada)) {
						tinicial = new TInicial(desktop, (String) cmbNomeTreinador.getSelectedItem());
						((BasicInternalFrameUI) tinicial.getUI()).setNorthPane(null);
						desktop.add(tinicial);
						tinicial.setVisible(true);

					} else if (senhaDigitada.isEmpty()) {
						ImageIcon icon = new ImageIcon(
								(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png")))
										.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
						JOptionPane.showMessageDialog(null, "Por favor, informe a sua senha", "Gotcha!",
								JOptionPane.INFORMATION_MESSAGE, icon);
					} else {
						ImageIcon icon = new ImageIcon(
								(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png")))
										.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
						JOptionPane.showMessageDialog(null, "Senha Inválida", "Gotcha!",
								JOptionPane.INFORMATION_MESSAGE, icon);
					}
					
					;
				} catch (Exception e) {
					ImageIcon icon = new ImageIcon(
							(new ImageIcon(TCadastroTreinador.class.getResource("/images/pokeballIcon.png"))).getImage()
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
					JOptionPane.showMessageDialog(null, "Nenhum treinador cadastrado.\nFaça um novo cadastro",
							"Gotcha!", JOptionPane.INFORMATION_MESSAGE, icon);
				}
			}
		});
		btnLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnLogin.setBounds(129, 162, 153, 33);
		panel.add(btnLogin);

		JButton btnCadastro = new JButton("Novo Treinador");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TCadastroTreinador tCadastroTreinador = new TCadastroTreinador();
				((BasicInternalFrameUI) tCadastroTreinador.getUI()).setNorthPane(null);
				desktopPane.add(tCadastroTreinador);
				tCadastroTreinador.setVisible(true);
			}
		});
		btnCadastro.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCadastro.setBounds(129, 217, 153, 33);
		panel.add(btnCadastro);

	}

	public TLogin() {
		// TODO Auto-generated constructor stub
	}

	public void refresh() {
		Treinador treinador = new Treinador();
		String[] listaTreinadores = treinador.listaTreinadores();
		cmbNomeTreinador.setModel(new DefaultComboBoxModel<String>(listaTreinadores));
	}
}
