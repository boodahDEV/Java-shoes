package Paneles;

import java.awt.*;
import javax.swing.border.*;

import rsbuttom.RSButtonMetro;

import javax.swing.*;
import rsbuttom.*;

public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
			setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(64,196,255)));
			setBackground(new Color(255, 255, 255));
			this.setBounds(0,0, 743, 475);
			setLayout(null);
			
			JPanel lamina = new JPanel();
			lamina.setBackground(new Color(255, 255, 255));
			lamina.setBounds(10, 11, 565, 355);
			add(lamina);
			lamina.setLayout(null);
			
			JPanel lamina1 = new JPanel();
			lamina1.setLayout(null);
			lamina1.setBackground(new Color(51, 204, 204));
			lamina1.setBounds(-566, 0, 565, 355);
			lamina.add(lamina1);
			
			JPanel lamina2 = new JPanel();
			lamina2.setLayout(null);
			lamina2.setBackground(new Color(51, 204, 255));
			lamina2.setBounds(0, 0, 565, 355);
			lamina.add(lamina2);
			
			new Thread(new Runnable() {
				public void run() {	
					try {
						while(true) {
							if(lamina1.getX()<0 && lamina2.getX()==0) {
								Animacion.Animacion.mover_izquierda(0, -566, 2, 2, lamina2);
								lamina1.setBounds(566, 0, 565, 355);
								Animacion.Animacion.mover_izquierda(566, 0, 2, 2, lamina1);
								Thread.sleep(5000);
							}else{
								Animacion.Animacion.mover_izquierda(0, -566, 2, 2, lamina1);
								lamina2.setBounds(566,0,565,355);
								Animacion.Animacion.mover_izquierda(566, 0, 2, 2, lamina2);
								Thread.sleep(5000);
							}
							
							}//while
						}catch(Exception a) {}
				}
			}).start();
			
			
			JPanel entradas = new JPanel();
			entradas.setBackground(new Color(255, 255, 255));
			entradas.setBounds(585, 11, 148, 355);
			add(entradas);
			entradas.setLayout(null);
			
			JButton none1 = new JButton("None");
			none1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
			none1.setBorder(null);
			none1.setContentAreaFilled(false);
			none1.setBorderPainted(false);
			none1.setFocusable(false);
			none1.setRequestFocusEnabled(false);
			none1.setBounds(50, 11, 50, 20);
			entradas.add(none1);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(41,128,185));
			separator.setBounds(14, 30, 120, 2);
			entradas.add(separator);
			
			JPanel acceso = new JPanel();
			acceso.setBackground(new Color(255, 255, 255));
			acceso.setBounds(10, 371, 723, 93);
			acceso.setLayout(null);
			add(acceso);
			
			
			RSButtonMetro aula = new RSButtonMetro();
			aula.setToolTipText("");
			aula.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			aula.setColorTextPressed(new Color(41,128,185));
			aula.setColorTextHover(new Color(29,95,138));
			aula.setRolloverSelectedIcon(new ImageIcon(PanelHome.class.getResource("/image/aula2.png")));
			aula.setRolloverIcon(new ImageIcon(PanelHome.class.getResource("/image/aula2.png")));
			aula.setFocusable(false);
			aula.setRequestFocusEnabled(false);
			aula.setColorPressed(new Color(179,229,252));
			aula.setColorHover(new Color(179,229,252));
			aula.setColorTextNormal(new Color(41,128,185));
			aula.setColorNormal(new Color(255, 255, 255));
			aula.setBackground(new Color(255, 255, 255));
			aula.setIcon(new ImageIcon(PanelHome.class.getResource("/image/aula.png")));
			aula.setText("Aula");
			aula.setBounds(0, 0,104, 93);
			acceso.add(aula);
			
			RSButtonMetro plan = new RSButtonMetro();
			plan.setToolTipText("ver el plan de estudio");
			plan.setRolloverSelectedIcon(new ImageIcon(PanelHome.class.getResource("/image/plan2.png")));
			plan.setRolloverIcon(new ImageIcon(PanelHome.class.getResource("/image/plan2.png")));
			plan.setIcon(new ImageIcon(PanelHome.class.getResource("/image/plan.png")));
			plan.setText("Plan");
			plan.setRequestFocusEnabled(false);
			plan.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			plan.setFocusable(false);
			plan.setColorTextPressed(new Color(41, 128, 185));
			plan.setColorTextNormal(new Color(41, 128, 185));
			plan.setColorTextHover(new Color(29, 95, 138));
			plan.setColorPressed(new Color(179, 229, 252));
			plan.setColorNormal(Color.WHITE);
			plan.setColorHover(new Color(179, 229, 252));
			plan.setBackground(Color.WHITE);
			plan.setBounds(113, 0, 104, 93);
			acceso.add(plan);
			
			RSButtonMetro btnmtrLibros = new RSButtonMetro();
			btnmtrLibros.setToolTipText("ver la biblioteca");
			btnmtrLibros.setRolloverSelectedIcon(new ImageIcon(PanelHome.class.getResource("/image/lectura2.png")));
			btnmtrLibros.setRolloverIcon(new ImageIcon(PanelHome.class.getResource("/image/lectura2.png")));
			btnmtrLibros.setIcon(new ImageIcon(PanelHome.class.getResource("/image/lectura.png")));
			btnmtrLibros.setText("Libros");
			btnmtrLibros.setRequestFocusEnabled(false);
			btnmtrLibros.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			btnmtrLibros.setFocusable(false);
			btnmtrLibros.setColorTextPressed(new Color(41, 128, 185));
			btnmtrLibros.setColorTextNormal(new Color(41, 128, 185));
			btnmtrLibros.setColorTextHover(new Color(29, 95, 138));
			btnmtrLibros.setColorPressed(new Color(179, 229, 252));
			btnmtrLibros.setColorNormal(Color.WHITE);
			btnmtrLibros.setColorHover(new Color(179, 229, 252));
			btnmtrLibros.setBackground(Color.WHITE);
			btnmtrLibros.setBounds(227, 0, 104, 93);
			acceso.add(btnmtrLibros);
			
			RSButtonMetro buttonMetro_2 = new RSButtonMetro();
			buttonMetro_2.setText("Aula");
			buttonMetro_2.setRequestFocusEnabled(false);
			buttonMetro_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			buttonMetro_2.setFocusable(false);
			buttonMetro_2.setColorTextPressed(new Color(41, 128, 185));
			buttonMetro_2.setColorTextNormal(new Color(41, 128, 185));
			buttonMetro_2.setColorTextHover(new Color(29, 95, 138));
			buttonMetro_2.setColorPressed(new Color(179, 229, 252));
			buttonMetro_2.setColorNormal(Color.WHITE);
			buttonMetro_2.setColorHover(new Color(179, 229, 252));
			buttonMetro_2.setBackground(Color.WHITE);
			buttonMetro_2.setBounds(341, 0, 104, 93);
			acceso.add(buttonMetro_2);
			
			RSButtonMetro buttonMetro_3 = new RSButtonMetro();
			buttonMetro_3.setText("Aula");
			buttonMetro_3.setRequestFocusEnabled(false);
			buttonMetro_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			buttonMetro_3.setFocusable(false);
			buttonMetro_3.setColorTextPressed(new Color(41, 128, 185));
			buttonMetro_3.setColorTextNormal(new Color(41, 128, 185));
			buttonMetro_3.setColorTextHover(new Color(29, 95, 138));
			buttonMetro_3.setColorPressed(new Color(179, 229, 252));
			buttonMetro_3.setColorNormal(Color.WHITE);
			buttonMetro_3.setColorHover(new Color(179, 229, 252));
			buttonMetro_3.setBackground(Color.WHITE);
			buttonMetro_3.setBounds(455, 0, 104, 93);
			acceso.add(buttonMetro_3);
			
	}
}
