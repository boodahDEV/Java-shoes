package Paneles;
import javax.swing.*;

public class ConfigPanel {
public JPanel panel_activo;
public boolean bandera;	

	public ConfigPanel(JPanel panel_activo,boolean bandera) {
		this.panel_activo=panel_activo;
		this.bandera=bandera;
		consulta();
	/*	new Thread(new Runnable() {

			@Override
			public void run() {
				try {
				while(true) {
					if(consulta()==true) {
					
					System.out.println("ok t");
					Thread.sleep(1000);
					}else {
						System.out.println("ok f");
						
						}
					}//while
				}catch(Exception a) {}
			}
			
		}).start();
		*/
	}//constructor
	
	public void consulta() {
		//System.out.println("Dentro del consulta");
		if(bandera==true) {
			//System.out.println("true");
			panel_activo.setBounds(139, 0, 604, 475);
			bandera=true;
		}else {
		//	System.out.println("false");
			panel_activo.setBounds(0,0, 743, 475);
			bandera=false;
		}
	}
}
