package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class TelaZero extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	public static void main(String[] args) {
		 try {
	            // select Look and Feel
	            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
	            // start application
	        }
	        catch (Exception ex) {
	            //ex.printStackTrace();
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaZero frame = new TelaZero();
					frame.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}

	public TelaZero() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaZero.class.getResource("/images/pokeballIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, -8, 1382, 744);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		
		JLabel lblSejaBemvindoaAo = new JLabel("Seja Bem-vindo(a) ao");
		lblSejaBemvindoaAo.setFont(new Font("Ink Free", Font.BOLD, 48));
		lblSejaBemvindoaAo.setBounds(101, 86, 509, 60);
		desktopPane.add(lblSejaBemvindoaAo);
		
		JLabel lblPokemonQuiz = new JLabel("");
		lblPokemonQuiz.setIcon(new ImageIcon(TelaZero.class.getResource("/images/Titulo Pok\u00E9monQuizz.png")));
		lblPokemonQuiz.setBounds(638, 52, 605, 132);
		desktopPane.add(lblPokemonQuiz);
		
		TLogin tLogin = new TLogin(desktopPane);
		((BasicInternalFrameUI)tLogin.getUI()).setNorthPane(null);
		tLogin.setVisible(true);
		desktopPane.add(tLogin);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 1366, 722);
		lblBackground.setBorder(null);
		lblBackground
				.setIcon(new ImageIcon((new ImageIcon(TelaZero.class.getResource("/images/Wallpaper/Wallpaper Tela Inicial.png")))
						.getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(),
								java.awt.Image.SCALE_SMOOTH)));
		desktopPane.add(lblBackground);
	}
}
