package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Interfaz_git extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		Interfaz_git frame = new Interfaz_git();	
		frame.loadPanelsInContentPane();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}

	public Interfaz_git() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new MatteBorder(2,2,2,2, new Color(213,0,249)));
		contentPane.setLayout(null);
		
		/*	CONFIGURACION INICIAL */
		
		setContentPane(contentPane);
		this.setUndecorated(true);
		setResizable(false);
	}
	
	public void loadPanelsInContentPane() {
		JPanel [] allPane = new JPanel[1]; // instancia de paneles
		
		/* 0 -> Panel norte "barra de titulo"  */
		allPane[0] = new JPanel(null);
		allPane[0].setBounds(1, 1, 448, 30);
		allPane[0].setBackground(new Color(170,0,255));
		/* 0 -> Panel norte "barra de titulo"  */

		
		
		for (JPanel jPanel : allPane) {
			contentPane.add(jPanel);			
		}
	}

}
