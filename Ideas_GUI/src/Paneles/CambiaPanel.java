package Paneles;
import javax.swing.*;
public class CambiaPanel {
	
	private JPanel contenedor;
	private JPanel contenido;
	
	public CambiaPanel(JPanel contenedor, JPanel contenido) {
		this.contenedor= contenedor;
		this.contenido = contenido;
		//contenido.setBounds(39, 57, 743, 475);
		contenedor.removeAll();
		contenedor.revalidate();
		contenedor.repaint();
		
		contenedor.add(contenido);
		contenedor.revalidate();
		contenedor.repaint();
	}
}