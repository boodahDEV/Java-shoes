package procesos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Main extends JFrame{

	private JPanel contentPane;
	public JPanel principal;
	public JLabel proceso[] = new JLabel[2];
	public JLabel ejecucion;
	Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 534, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		principal = new JPanel();
		principal.setBackground(new Color(255, 255, 255));
		principal.setBounds(0, 0, 518, 432);
		contentPane.add(principal);
		principal.setLayout(null);
		for(int i=0;i<proceso.length;i++) {
			proceso[i] = new JLabel(" ");
			proceso[i].setIcon(new ImageIcon(Main.class.getResource("/image/hilo.png")));
			if(i==1) {
				proceso[i].setIcon(new ImageIcon(Main.class.getResource("/image/hilo2.png")));
			}
			proceso[i].setFocusable(false);
			proceso[i].setBounds(70, 241, 20, 20);
			proceso[i].setVisible(false);
			principal.add(proceso[i]);
		}
		
		ejecucion = new JLabel("");
		ejecucion.setIcon(new ImageIcon(Main.class.getResource("/image/diag.jpg")));
		ejecucion.setFocusable(false);
		ejecucion.setBounds(58, 11, 398, 260);
		//ejecucion.setVisible(false);
		principal.add(ejecucion);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
	try {
		Main mn = new Main(); 
		Thread procesos = new Thread(new Procesos(mn.proceso[0],mn.ejecucion),"#1");
		Thread procesos2 = new Thread(new Procesos(mn.proceso[1],mn.ejecucion), "#2");
		Thread.sleep(500);
		System.out.println("Iniciando el proceso "+procesos.getName());
		procesos.start();// El proceso esta en listo!
		Thread.sleep(7000);
		System.out.println("Iniciando el proceso "+procesos2.getName());
		procesos2.start();// El proceso esta en listo!

		procesos.join();
		procesos2.join();
		
		//
	}catch(Exception e) {}
	}// fin main
}
