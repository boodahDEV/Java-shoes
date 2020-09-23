package Paneles;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.*;

import rsbuttom.RSButtonMetro;

public class PanelOpciones extends JPanel {
	private JButton exit,privacidad,perfil;
	private JSeparator separator1,separator2,separator3;
	private JLabel addF;
	private JTextField txtTestoPrueba;

	/**
	 * Create the panel.
	 */
	public PanelOpciones(JFrame parents) {
		setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(64,196,255)));
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		this.setBounds(0,0, 743, 475);
		

		
		JPanel info = new JPanel();
		info.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(64,196,255)));
		info.setBackground(new Color(255, 255, 255));
		info.setVisible(false);
		info.setBounds(159, 11, 574, 453);
		add(info);
		info.setLayout(null);
		
		addF = new JLabel("");
		addF.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(169,169,169)));
		addF.setIcon(new ImageIcon(PanelOpciones.class.getResource("/image/newImage.png")));
		addF.setHorizontalAlignment(SwingConstants.CENTER);
		addF.setBounds(67, 11, 145, 164);
		info.add(addF);
		
		txtTestoPrueba = new JTextField();
		txtTestoPrueba.setBorder(null);
		txtTestoPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		txtTestoPrueba.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		txtTestoPrueba.setText("TESTO PRUEBA");
		txtTestoPrueba.setBackground(new Color(255, 255, 255));
		txtTestoPrueba.setDisabledTextColor(new Color(128, 128, 128));
		txtTestoPrueba.setEditable(false);
		txtTestoPrueba.setEnabled(false);
		txtTestoPrueba.setBounds(271, 11, 207, 37);
		info.add(txtTestoPrueba);
		txtTestoPrueba.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(169, 169, 169));
		separator.setBounds(271, 59, 207, 2);
		info.add(separator);
		
		JLabel asa = new JLabel("Arrastra y suelta la imagen aquí");
		asa.setHorizontalAlignment(SwingConstants.CENTER);
		asa.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		asa.setBounds(56, 178, 167, 14);
		info.add(asa);
		
		RSButtonMetro jbcargar = new RSButtonMetro();
		jbcargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JFileChooser jfc = new JFileChooser();
				jfc.setMultiSelectionEnabled(false);
				
				if(jfc.showOpenDialog(parents)==JFileChooser.APPROVE_OPTION) {
					rsdragdropfiles.RSDragDropFiles.setCopiar(jfc.getSelectedFile().toString(),"src/image/FileNUI/newImage.png");
					addF.setIcon(new ImageIcon(jfc.getSelectedFile().toString()));
				}else {
					System.out.println("Error 871 cancelado en el cargado de imagen");
				}
			}
		});
		jbcargar.setToolTipText("");
		jbcargar.setText("Buscar imagen");
		jbcargar.setRequestFocusEnabled(false);
		jbcargar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		jbcargar.setFocusable(false);
		jbcargar.setColorTextPressed(new Color(41, 128, 185));
		jbcargar.setColorTextNormal(new Color(41, 128, 185));
		jbcargar.setColorTextHover(new Color(29, 95, 138));
		jbcargar.setColorPressed(new Color(179, 229, 252));
		jbcargar.setColorNormal(Color.WHITE);
		jbcargar.setColorHover(new Color(179, 229, 252));
		jbcargar.setBackground(Color.WHITE);
		jbcargar.setBounds(95, 190, 95, 15);
		info.add(jbcargar);
		
		JPanel opciones = new JPanel();
		opciones.setBackground(new Color(255, 255, 255));
		opciones.setBounds(10, 11, 139, 453);
		add(opciones);
		opciones.setLayout(null);
		
		privacidad = new JButton("Privacidad");
		privacidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Animacion.Animacion.mover_derecha(-98, 20, 2, 2, privacidad);
		
			privacidad.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					privacidad.setForeground(new Color(41,128,185));
				}
			});
			privacidad.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseMoved(MouseEvent e) {
					privacidad.setForeground(new Color (29,95,138));
				}
			});
			privacidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
/*->*/				//accion de esuchar
				}
			});
		
		perfil = new JButton("Perfil");
		Animacion.Animacion.mover_derecha(-98, 20, 2, 2, perfil);
		perfil.setBounds(28, 11, 80, 20);
		opciones.add(perfil);
			perfil.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseMoved(MouseEvent a) {
					perfil.setForeground(new Color (29,95,138));
				}
			});
			perfil.addMouseListener(new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					perfil.setForeground(new Color(41,128,185));
				}
			});
			perfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
/*->*/					//accion de esuchar boton perfil
					info.setVisible(true);
						int y= privacidad.getY();
					/*	if(y < 100) {
							Animacion.Animacion.bajar(50, 190, 4, 2, privacidad);
							separator2.setBounds(10, 215, 120,2); // LO SIMULA BASTANTE BIEN LA BAJADA, PERO REAJUSTAR.
						}else {
						Animacion.Animacion.subir(190, 50, 4, 2, privacidad);
						separator2.setBounds(10, 75, 120,2);// HAY QUE CONTROLAR EL RETORNO DE EL SEPARADOR  
					}*/
				}
			});
		perfil.setBorderPainted(false);
		perfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		perfil.setBorder(null);
		perfil.setContentAreaFilled(false);
		perfil.setFocusable(false);
		perfil.setRequestFocusEnabled(false);
		perfil.setForeground(new Color(41,128,185));
		perfil.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		privacidad.setBounds(28, 50, 80, 20);
		opciones.add(privacidad);
		privacidad.setRequestFocusEnabled(false);
		privacidad.setForeground(new Color(41,128,185));
		privacidad.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		privacidad.setFocusable(false);
		privacidad.setContentAreaFilled(false);
		privacidad.setBorderPainted(false);
		privacidad.setBorder(null);
		
		exit = new JButton("Cerrar Secion");
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Animacion.Animacion.mover_derecha(-98, 20, 2, 2, exit);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(new Color(41,128,185));
			}
		});
		exit.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				exit.setForeground(new Color (29,95,138));
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/*->*/				//accion de esuchar el boton de salir
			}
		});
		exit.setBounds(20, 405, 98, 20);
		opciones.add(exit);
		exit.setRequestFocusEnabled(false);
		exit.setForeground(new Color(41,128,185));
		exit.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		exit.setFocusable(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setBorder(null);
		
		separator1 = new JSeparator();
		separator1.setForeground(new Color(169, 169, 169));
		separator1.setBounds(10, 34, 120, 2);
		opciones.add(separator1);
		
		separator2 = new JSeparator();
		separator2.setForeground(new Color(169, 169, 169));
		separator2.setBounds(10, 75, 120, 2);
		opciones.add(separator2);
		
		separator3 = new JSeparator();
		separator3.setForeground(new Color(169, 169, 169));
		separator3.setBounds(10, 429, 120, 2);
		opciones.add(separator3);
	}
}
