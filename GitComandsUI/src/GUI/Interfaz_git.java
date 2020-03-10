package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;

import javax.swing.JButton;
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
		//contentPane.setBorder(new MatteBorder(2,2,2,2, new Color(213,0,249)));
		contentPane.setLayout(null);
		
		/*	CONFIGURACION INICIAL */
		
		setContentPane(contentPane);
		setResizable(false);
	}
	
	public void loadPanelsInContentPane() {
		JPanel [] allPane = new JPanel[3]; // instancia de paneles
		
		/* 0 -> Panel "panel de botones"  */
		allPane[0] = new JPanel(null);
		allPane[0].setBounds(1, 1, 150, 559);
		allPane[0].setBackground(new Color(255,255,255));
		allPane[0].setBorder(new MatteBorder(1,1,1,1, new Color(0,0,0)));
		addButtonInPane(allPane[0]);
		/* 0 -> Panel "panel de botones"  */
		
		/* 1 -> Panel "panel de interaccion"  */
		allPane[1] = new JPanel(null);
		allPane[1].setBounds(152, 1, 281, 280);
		allPane[1].setBackground(new Color(255,255,255));
		allPane[1].setBorder(new MatteBorder(1,1,1,1, new Color(0,0,0)));
		/* 1 -> Panel "panel de interaccion"  */

		/* 2 -> Panel "panel de log de salida"  */
		allPane[2] = new JPanel(null);
		allPane[2].setBounds(152, 282, 281, 278);
		allPane[2].setBackground(new Color(255,255,255));
		allPane[2].setBorder(new MatteBorder(1,1,1,1, new Color(0,0,0)));
		/* 2 -> Panel "panel de log de salida"  */
		
		for (JPanel jPanel : allPane) {
			contentPane.add(jPanel);			
		}
	}//
	
	public void addButtonInPane(JPanel panel) {
		JButton add = new JButton("ADD");
			add.setCursor(new Cursor(Cursor.HAND_CURSOR));
			add.setFocusable(false);
			add.setBounds(20, 10, 80, 30);
		panel.add(add);	
		
		JButton commit = new JButton("COMMIT");
			commit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			commit.setFocusable(false);
			commit.setBounds(10, 55, 100, 30);
		panel.add(commit);		
		
	    Desktop desktop = null;
	    // on Windows, retrieve the path of the "Program Files" folder
	    File file = new File(System.getenv("programfiles"));

	    try {
	      if (Desktop.isDesktopSupported()) {
	         desktop = Desktop.getDesktop();
	         desktop.open(file);
	      }
	      else {
	         System.out.println("desktop is not supported");
	      }
	    }catch (Exception e){  }
	  
	}//
	
	public void createInteractionArea() {
		
	}

}
