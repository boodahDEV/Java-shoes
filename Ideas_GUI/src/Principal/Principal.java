package Principal;

import javax.swing.*;
import rojerusan.RSNotifyShadowFade;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.MatteBorder;

import Animacion.Fade;
import rsbuttom.RSButtonMetro;

public class Principal extends JFrame {
	private String nombre, apellido,edad,ano,institucion, acudiente, telefono,correo,licencia,pass;
	private JPanel contentPane;
	JPanel principal;
	private JPanel dashboard;
	private JButton home,opciones;
	private RSButtonMetro Home,opcion;
	protected JLabel MOVE;
	private Principal esto;
	private int xx,yy;
	
	/**													SOLUCIONADO 26/3/2018
	 * 												
	 * EL PROGRAMA (22/3/2018) TIENE UN BUG el cual es al hacer la llamda de este �panel desde el programa principal, que de 
	 * hecho lo hace y hace bien, cuando ya estoy con el panel desplegado y abro el dashboard heste oculta el contenido del panel y 
	 * provoca que el dashboard  se note por ensima del panel y tenga apariencia no agradable.
	 * 
	 * */
	
	/**
	 * 
	 * EL PROGRAMA (26/3/2018) tiene como consecuencia del ajuste del panel del BUGS anterior, es el de que cuando le damos click y se ejecuta
	 * el reajuste del panel, este cambia su tama�o y como consecuencia cambia el tama�o de los componentes dentros del panel en cada opcione, 
	 * por ende CADA COMPONENTE DENTRO DE ESE PANEL TIENE QUE REDIMENCIONARCE AL AJUSTE, que quiere decir que la modesta tarea de evitar el 
	 * GridBagLayout() se esta haciendo complicada al avance del programa.
	 * 
	 * */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					new Paneles.CambiaPanel(frame.principal,new Paneles.PanelHome());
					
				} catch (Exception e) { }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dashboard = new JPanel();
		dashboard.setBackground(new Color(41, 128, 185));
		dashboard.setBounds(/*0*/-138, 0, 177, 531);
		contentPane.add(dashboard);
		dashboard.setLayout(null);
		
		JPanel icon = new JPanel();
		icon.setBackground(new Color(179,229,252));
		icon.setBounds(137, 0, 40, 532);
		dashboard.add(icon);
		icon.setLayout(null);
		
		JButton menu = new JButton(" ");
		menu.setBounds(0, 0, 45, 35);
		icon.add(menu);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
			try {
					int xx = dashboard.getX();
					if(xx < -1) {
						Animacion.Animacion.mover_derecha(-138, 0, 2, 2, dashboard);
						new Paneles.ConfigPanel((JPanel)principal.getComponent(0),true);
					}else {
						Animacion.Animacion.mover_izquierda(0, -138, 2, 2, dashboard);
						new Paneles.ConfigPanel((JPanel)principal.getComponent(0),false);
							}
				}catch(Exception x) {System.out.println("Error");/**El error aqui hay que solucionarlo, y se soluciona al dar como primero el panel home.*/}
			}
			
		});
		menu.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/image/menu2.png")));
		menu.setRolloverIcon(new ImageIcon(this.getClass().getResource("/image/menu2.png")));
		menu.setIcon(new ImageIcon(this.getClass().getResource("/image/menu.png")));
		menu.setBorder(null);
		menu.setBorderPainted(false);
		menu.setContentAreaFilled(false);
		menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menu.setFocusable(false);
		menu.setRequestFocusEnabled(false);
		
		opciones = new JButton("");
		opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(opciones.isSelected() && dashboard.getX()==-138) {
					new Paneles.CambiaPanel(principal,new Paneles.PanelOpciones(esto));
					
				}else {
					Animacion.Animacion.mover_izquierda(0, -138, 2, 2, dashboard);
					new Paneles.CambiaPanel(principal,new Paneles.PanelOpciones(esto));
				}
					
			}
		});
		opciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				opciones.setSelected(true);
				home.setSelected(false);
			}
		});
		opciones.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/image/config2.png")));
		opciones.setRolloverIcon(new ImageIcon(this.getClass().getResource("/image/config2.png")));
		opciones.setIcon(new ImageIcon(this.getClass().getResource("/image/config.png")));
		opciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		opciones.setBorder(null);
		opciones.setContentAreaFilled(false);
		opciones.setBorderPainted(false);
		opciones.setFocusable(false);
		opciones.setRequestFocusEnabled(false);
		opciones.setBounds(0, 490, 40, 30);
		icon.add(opciones);
		
		home = new JButton("");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(home.isSelected() && dashboard.getX()==-138) {
					new Paneles.CambiaPanel(principal,new Paneles.PanelHome());
					
				}else {
					Animacion.Animacion.mover_izquierda(0, -138, 2, 2, dashboard);
					new Paneles.CambiaPanel(principal,new Paneles.PanelHome());
				}
			}
		});
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				opciones.setSelected(false);
				home.setSelected(true);
			}
		});
		home.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/image/home2.png")));
		home.setRolloverIcon(new ImageIcon(this.getClass().getResource("/image/home2.png")));
		home.setIcon(new ImageIcon(this.getClass().getResource("/image/home.png")));
		home.setRequestFocusEnabled(false);
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setFocusable(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setBorder(null);
		home.setBounds(0, 70, 40, 30);
		icon.add(home);
		
		JPanel titulo = new JPanel();
		titulo.setBackground(new Color(64,196,255));
		titulo.setBounds(0, 0, 783, 57);
		contentPane.add(titulo);
		titulo.setLayout(null);
		
		JButton exit = new JButton(" ");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);//solucionar el problema de cerrado de aplicacione
			}
		});
		exit.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/image/exit2.png")));
		exit.setRolloverIcon(new ImageIcon(this.getClass().getResource("/image/exit2.png")));
		exit.setToolTipText("Exit\r\n");
		exit.setIcon(new ImageIcon(this.getClass().getResource("/image/exit.png")));
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setBorder(null);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusable(false);
		exit.setRequestFocusEnabled(false);
		exit.setBounds(751, 5, 30, 20);
		titulo.add(exit);
		
		/***/
			MOVE = new JLabel(" ");
			MOVE.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent b) {
					int x = b.getXOnScreen();
					int y = b.getYOnScreen();
					
					setLocation(x-xx, y-yy);
				}
			});
			MOVE.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent a) {
					xx= a.getX();
					yy = a.getY();
				}
			});
				MOVE.setBounds(0, 0, 781, 57);
				titulo.add(MOVE);
				
				JLabel label = new JLabel(" ");
				label.setBounds(48, 8, 47, 38);
				titulo.add(label);
		/***/
				
		principal = new JPanel();
		principal.setBackground(new Color(255, 255, 255));
		principal.setBounds(39, 57, 743, 475);
		contentPane.add(principal);
		principal.setLayout(null);
		
		Home = new RSButtonMetro();
		Home.setColorHover(new Color(29, 95, 138));
		Home.setFocusable(false);
		Home.setRequestFocusEnabled(false);
		Home.setColorPressed(new Color(29,95,138));
		Home.setColorNormal(new Color(41,128,185));
		Home.setFont(new Font("Century Gothic", Font.BOLD, 17));
		Home.setText("Home");
		Home.setSize(136, 35);
		Home.setLocation(0, 68);
		dashboard.add(Home);
		
		opcion = new RSButtonMetro();
		opcion.setText("Opciones");
		opcion.setRequestFocusEnabled(false);
		opcion.setFont(new Font("Century Gothic", Font.BOLD, 17));
		opcion.setFocusable(false);
		opcion.setColorPressed(new Color(29, 95, 138));
		opcion.setColorNormal(new Color(41, 128, 185));
		opcion.setColorHover(new Color(29, 95, 138));
		opcion.setBounds(0, 485, 136, 35);
		dashboard.add(opcion);
		
		
	}
	private final void RSNotifyError(String Titulo,String texto) {
		RSNotifyShadowFade b = new RSNotifyShadowFade(Titulo,texto,1,RSNotifyShadowFade.PositionNotify.TopRight,RSNotifyShadowFade.TypeNotify.ERROR);
		b.setLocationRelativeTo(null);
		b.setVisible(true);
	}
	private final void RSNotifyAceptar(String Titulo,String texto) {
		RSNotifyShadowFade b = new RSNotifyShadowFade(Titulo,texto,1,RSNotifyShadowFade.PositionNotify.TopRight,RSNotifyShadowFade.TypeNotify.SUCCESS);
		b.setLocationRelativeTo(null);
		b.setVisible(true);
	}
	
	protected void setData(String nombre, String apellido, String edad, String pass) {
		this.nombre= nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.pass=pass;
	}//end
}
