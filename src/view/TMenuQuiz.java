package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import control.Treinador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TMenuQuiz extends JInternalFrame {
	private JPanel panel;
	private JDesktopPane desktop;

	public TMenuQuiz(JDesktopPane desktopPane, Treinador treinador) {
		desktop = desktopPane;
		setBorder(null);
		setBounds(0, 0, 1366, 706);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
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
		
		

		JLabel lblQuizes = new JLabel("Escolha seu Quiz abaixo:");
		lblQuizes.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuizes.setForeground(Color.WHITE);
		lblQuizes.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblQuizes.setBounds(407, 38, 646, 119);
		panel.add(lblQuizes);

		JButton btnGenI = new JButton("PRIMEIRA GERA\u00C7\u00C3O");
		btnGenI.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		btnGenI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TQuizGenI tQuiz = new TQuizGenI(desktop, treinador);
				((BasicInternalFrameUI) tQuiz.getUI()).setNorthPane(null);
				desktop.add(tQuiz);
				try {
					tQuiz.setMaximum(true);
				} catch (PropertyVetoException e) {
				}
				tQuiz.setVisible(true);
				dispose();

			}
		});
		btnGenI.setBounds(56, 317, 412, 91);
		panel.add(btnGenI);

		JButton btnSombras = new JButton("Sombras");
		btnSombras.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		btnSombras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TQuizSombras tQuiz = new TQuizSombras(desktop, treinador);
				((BasicInternalFrameUI) tQuiz.getUI()).setNorthPane(null);
				desktop.add(tQuiz);
				try {
					tQuiz.setMaximum(true);
				} catch (PropertyVetoException e1) {
				}
				tQuiz.setVisible(true);
				dispose();
			}
		});
		
		JButton btnSegundaGerao = new JButton("SEGUNDA GERA\u00C7\u00C3O");
		btnSegundaGerao.setToolTipText("Desbloqueio no n\u00EDvel 3");
		btnSegundaGerao.setEnabled(false);
		btnSegundaGerao.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		btnSegundaGerao.setBounds(497, 317, 412, 91);
		panel.add(btnSegundaGerao);
		
		JButton btnTerceiraGerao = new JButton("TERCEIRA GERA\u00C7\u00C3O");
		btnTerceiraGerao.setToolTipText("Desbloqueio no n\u00EDvel 5");
		btnTerceiraGerao.setEnabled(false);
		btnTerceiraGerao.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		btnTerceiraGerao.setBounds(943, 317, 412, 91);
		panel.add(btnTerceiraGerao);
		btnSombras.setBounds(497, 453, 412, 91);
		panel.add(btnSombras);
		
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
