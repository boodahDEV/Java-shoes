package Principal;

import java.awt.EventQueue;
import rsbuttom.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Animacion.Fade;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Inicio extends JFrame {
	private ArrayList <Filtrar> lista = new ArrayList<Filtrar>();
	private JPanel contentPane,jplogin;
	private JTextField jtfnom,jtfedad;
	private JPasswordField jpfpass;
	private boolean edad,contrasena;
	private JSeparator separator,separator2,separator3;
	private JLabel aprobado,errorPass,aprobado2,errorEdad,jlEdad;
	private int xx,yy;
	private JButton github;
	private Inicio esto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 330, 452);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel(" ");
		titulo.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent a) {
				int x = a.getXOnScreen();
				int y = a.getYOnScreen();
				setLocation(x-xx, y-yy);
			}
		});
		titulo.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent a) {
				xx= a.getX();
				yy = a.getY();
			}
		});
		titulo.setBorder(null);
		titulo.setIcon(new ImageIcon(this.getClass().getResource("/image/logo.png")));
		titulo.setBounds(0, 0, 330, 452);
		panel.add(titulo);
		
		jplogin = new JPanel();
		jplogin.setForeground(new Color(105, 105, 105));
		jplogin.setBorder(new LineBorder(new Color(165, 42, 42)));
		jplogin.setBackground(new Color(255, 255, 255));
		jplogin.setBounds(330, 0, 370, 452);
		contentPane.add(jplogin);
		jplogin.setLayout(null);
		
		jtfnom = new JTextField();
		jtfnom.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		jtfnom.setBorder(null);
		jtfnom.setForeground(new Color(205, 92, 92));
		jtfnom.setBounds(78, 91, 210, 25);
		jplogin.add(jtfnom);
		jtfnom.setColumns(10);
		
		jpfpass = new JPasswordField();
		jpfpass.setEchoChar('*');
		jpfpass.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		jpfpass.setForeground(new Color(205, 92, 92));
		jpfpass.setBorder(null);
		jpfpass.setText("boodah");
		jpfpass.setBounds(78, 241, 205, 25);
		jpfpass.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				jpfpass.setText("");
			}
			public void focusLost(FocusEvent arg0) { 
				try {
				if(jpfpass.getPassword().length<8) {
					 errorPass.setVisible(true);aprobado2.setVisible(false);contrasena = false;
				}else {errorPass.setVisible(false);aprobado2.setVisible(true);contrasena = true;}
				}catch(Exception a) {}
			}
		});
		jplogin.add(jpfpass);
		
		RSButtonMetro jbregistrar = new RSButtonMetro();
		jbregistrar.setRequestFocusEnabled(false);
		jbregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//aqui va lo que ara el boton de registrar, lo cual debe guardar
				String texto = a.getActionCommand();
				if(texto.equals("Registrar") && contrasena == true && edad == true) {
					char p[] = jpfpass.getPassword();
					String newPass = new String(p);
					String[] nomApell = jtfnom.getText().split(" ");
					/**/
					try {
						System.out.println("dentro");
						registro(nomApell[0],nomApell[1],jtfedad.getText(),newPass);
						Principal b = new Principal();
						Animacion.Fade.JFrameFadeIn(0f, 1f, 0.2f, 50, b);
						javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						new Paneles.CambiaPanel(b.principal,new Paneles.PanelHome());
						b.setData(nomApell[0],nomApell[1],jtfedad.getText(),newPass);
						b.setLocationRelativeTo(null);
						b.setVisible(true);
						
					}catch(Exception e) {}
					/**/
					
				}else {
					//aqui debo de hacer un nuevo if y tomar en cuenta los cambios
					
					}//else #1
			}//end action
		});
		jbregistrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		jbregistrar.setText("Registrar");
		jbregistrar.setColorPressed(new Color(210, 80, 80));
		jbregistrar.setColorHover(new Color(210, 80, 80));
		jbregistrar.setColorNormal(new Color(200, 73, 73));
		jbregistrar.setBackground(new Color(200, 73, 73));
		jbregistrar.setBounds(87, 313, 218, 58);
		jplogin.add(jbregistrar);
		
		jtfedad = new JTextField("");
		
		jtfedad.setHorizontalAlignment(SwingConstants.CENTER);
		jtfedad.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		jtfedad.setBorder(null);
		jtfedad.setForeground(new Color(205, 92, 92));
		jtfedad.setColumns(10);
		jtfedad.setBounds(78, 169, 25, 25);
		jtfedad.addFocusListener (new FocusListener(){
		   public void focusLost (FocusEvent e){
			   if(Integer.parseInt(jtfedad.getText())>=5 && Integer.parseInt(jtfedad.getText())<=18 ) {
				   	aprobado.setVisible(true);
				   	errorEdad.setVisible(false);
				   	jtfedad.setForeground(new Color(205, 92, 92));
				   	edad = true;
			   }else{aprobado.setVisible(false);errorEdad.setVisible(true);jtfedad.setForeground(new Color(255,0,0)); edad = false;}
		   }//
		   public void focusGained(FocusEvent arg0) { }
		});
		jplogin.add(jtfedad);
		
		separator = new JSeparator();
		separator.setForeground(new Color(105, 105, 105));
		separator.setBackground(new Color(165, 42, 42));
		separator.setBounds(68, 116, 240, 1);
		jplogin.add(separator);
		
		separator2 = new JSeparator();
		separator2.setForeground(new Color(105, 105, 105));
		separator2.setBackground(new Color(165, 42, 42));
		separator2.setBounds(68, 194, 50, 1);
		jplogin.add(separator2);
		
		separator3 = new JSeparator();
		separator3.setForeground(new Color(105, 105, 105));
		separator3.setBackground(new Color(165, 42, 42));
		separator3.setBounds(68, 266, 240, 1);
		jplogin.add(separator3);
		
		JLabel jlnom = new JLabel("Nombre completo");
		jlnom.setForeground(new Color(105, 105, 105));
		jlnom.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jlnom.setBounds(25, 69, 159, 25);
		jplogin.add(jlnom);
		
		jlEdad = new JLabel("Edad");
		jlEdad.setForeground(new Color(105, 105, 105));
		jlEdad.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jlEdad.setBounds(25, 139, 48, 25);
		jplogin.add(jlEdad);
		
		JLabel jlpass = new JLabel("Contrase�a");
		jlpass.setForeground(new Color(105, 105, 105));
		jlpass.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jlpass.setBounds(25, 210, 86, 25);
		jplogin.add(jlpass);
		
		JLabel iniciar = new JLabel("Ya tienes una cuenta? Inicia Secion aqui");
		iniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iniciar.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent arg0) {
			iniciar.setForeground(new Color(105, 105, 105)); }
			public void mouseClicked(MouseEvent e) {
			if(iniciar.getText().equals("Ya tienes una cuenta? Inicia Secion aqui")) {
				/**/
				jlEdad.setVisible(false);
				aprobado.setVisible(false);
				jtfedad.setVisible(false);
				errorEdad.setVisible(false);
				separator2.setVisible(false);
				jplogin.repaint();
				/**/
				jlnom.setText("Nombre de usuario");
				Animacion.Animacion.bajar(69, 99, 4, 2, jlnom);
				Animacion.Animacion.bajar(91, 121, 4, 2, jtfnom);
				//Animacion.Animacion.bajar(117, 147, 4, 2, aviso); Eliminado y rea�adido en el fram de registro...
				separator.setBounds(68, 146, 240, 1);
				Animacion.Animacion.subir(210, 180, 4, 2, jlpass);
				Animacion.Animacion.subir(241, 211, 4, 2, jpfpass);
				Animacion.Animacion.subir(242, 212, 4, 2, aprobado2);
				Animacion.Animacion.subir(267, 237,4,2, errorPass);
				separator3.setBounds(68, 236, 240, 1);
				jbregistrar.setText("Iniciar secion");
				iniciar.setText("No tienes una cuenta? Registrate aqui");
				iniciar.setBounds(63, 375, 289, 25);
				jplogin.repaint();
			}else {
				/**/
				jlEdad.setVisible(true);
				aprobado.setVisible(false);
				jtfedad.setVisible(true);
				errorEdad.setVisible(false);
				separator2.setVisible(true);
				jplogin.repaint();
				/**/
				jlnom.setText("Nombre completo");
				Animacion.Animacion.subir(99, 69, 4, 2, jlnom);
				Animacion.Animacion.subir(121, 91, 4, 2, jtfnom);
				//Animacion.Animacion.subir(147, 117, 4, 2, aviso);
				separator.setBounds(68, 116, 240, 1);
				Animacion.Animacion.bajar(180, 210, 4, 2, jlpass);
				Animacion.Animacion.bajar(211, 241, 4, 2, jpfpass);
				Animacion.Animacion.bajar(212, 242, 4, 2, aprobado2);
				Animacion.Animacion.bajar(237, 267, 4, 2, errorPass);
				separator3.setBounds(68, 266, 240, 1);
				jbregistrar.setText("Registrar");
				iniciar.setText("Ya tienes una cuenta? Inicia Secion aqui");
				iniciar.setBounds(55, 375, 289, 25);
				jplogin.repaint();
				}
			}//fin clicked
		});
		iniciar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent arg0) {
			iniciar.setForeground(new Color(169, 169, 169)); }
		});
	
		iniciar.setForeground(new Color(105, 105, 105));
		iniciar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		iniciar.setBounds(55, 375, 289, 25);
		
		jplogin.add(iniciar);

		aprobado = new JLabel(" ");
		aprobado.setIcon(new ImageIcon(this.getClass().getResource("/image/aprobado.png")));
		aprobado.setBounds(120, 170, 25, 25);
		aprobado.setVisible(false);
		jplogin.add(aprobado);
		/*Boton de cerrar*/	
		JButton exit = new JButton("");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		aprobado2 = new JLabel(" ");
		aprobado2.setIcon(new ImageIcon(this.getClass().getResource("/image/aprobado.png")));
		aprobado2.setBounds(305, 242, 25, 25);
		aprobado2.setVisible(false);
		jplogin.add(aprobado2);
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/image/exit2.png")));
		exit.setRolloverIcon(new ImageIcon(this.getClass().getResource("/image/exit2.png")));
		exit.setIcon(new ImageIcon(this.getClass().getResource("/image/exit.png")));
		exit.setRequestFocusEnabled(false);
		exit.setFocusable(false);
		exit.setBorder(null);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setBounds(343, 4, 27, 20);
		jplogin.add(exit);
		/*---------------*/
		
		errorPass = new JLabel("La contrase�a debe tener al menos  8 dijitos.");
		errorPass.setForeground(new Color(255, 0, 0));
		errorPass.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		errorPass.setBounds(68, 267, 248, 14);
		errorPass.setVisible(false);
		jplogin.add(errorPass);
		
		errorEdad = new JLabel("Edad fuera de rango.");
		errorEdad.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		errorEdad.setForeground(new Color(255, 0, 0));
		errorEdad.setBounds(68, 195, 116, 14);
		errorEdad.setVisible(false);
		jplogin.add(errorEdad);
		
		github = new JButton(" ");
		github.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		github.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/image/github2.png")));
		github.setRolloverIcon(new ImageIcon(this.getClass().getResource("/image/github2.png")));
		github.setIcon(new ImageIcon(this.getClass().getResource("/image/github.png")));
		github.setToolTipText("Sigueme en Github");
		github.setRequestFocusEnabled(false);
		github.setFocusable(false);
		github.setContentAreaFilled(false);
		github.setBorderPainted(false);
		github.setBorder(null);
		github.setBounds(5, 410, 37, 37);
		jplogin.add(github);

	}
	
	
	@SuppressWarnings("unused")
	private void registro(String nombre, String apellido, String edad, String pass){
		try{
			ObjectInputStream leer_fichero = new ObjectInputStream(new FileInputStream("Data.odd"));
			ArrayList<Filtrar[]> personal_Recuperado = (ArrayList<Filtrar[]>) leer_fichero.readObject();
			leer_fichero.close();
			Filtrar []listaNueva = new Filtrar[personal_Recuperado.size()];
			personal_Recuperado.toArray(listaNueva);
			for(Filtrar e: listaNueva){
				lista.add(e);
				}
		}catch (Exception e1) { }
		
		
		lista.add(new Filtrar(nombre,apellido,edad,pass));
		
		try{	
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("Data.odd"));
			escribiendo_fichero.writeObject(lista);
			escribiendo_fichero.close();
		}catch(Exception e){ }	
	}//fin metodo	
}
