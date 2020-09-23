package procesos;

import javax.swing.JLabel;

public class Procesos implements Runnable{
    boolean suspender; //Suspende un hilo cuando es true
    boolean pausar;    //Detiene un hilo cuando es true
    JLabel proceso, ejecucion;
    Procesos(JLabel proceso,JLabel ejecucion){
    	this.proceso=proceso;
    	this.ejecucion=ejecucion;
    }
    
    
	// ejecucion //
    public void run() {
    	ejecucion.repaint();
        try {
        	System.out.println("Estado de ejecucion del proceso: "+Thread.currentThread().getName());
        	proceso.setVisible(true);
            mueveDiagonalArriba();
            for (int i=1;i<=15;i++){
                System.out.print("Ejecutando proceso: "+Thread.currentThread().getName()+"\n");                
                //bloquea
                if ((i%10)==0){
                    System.out.println();
                    Thread.sleep(250);
                    mueveDiagonalAbajo();
                    suspender = true;
                }
                //manda a listo
                if((i%15)==0) {
                    System.out.println();
                    Thread.sleep(250);
                    mueveDiagonalRegresa();
                    pausar = true;
                }
                synchronized (this) {
                    while (suspender) {
                    	System.out.println("El proceso "+Thread.currentThread().getName()+" esta bloqueado");
                        wait(1500);
                        suspender = false;
                        notify();
                        mueveCentro();
                        System.out.println("EL proceso "+Thread.currentThread().getName()+" esta en Listo!");
                        mueveDiagonalArriba();
                        Thread.sleep(1000);
                        System.out.println("EL proceso "+Thread.currentThread().getName()+" esta por ejecutarse!");
                    } 
                }
                synchronized (this) {
                	while (pausar) {
                		System.out.println("El proceso "+Thread.currentThread().getName()+" Retorno!!!! a listo.");
                        wait(1500);
                        pausar = false;
                        notify();
                        System.out.println("EL proceso "+Thread.currentThread().getName()+" reanudando ejecucion!");
                        mueveDiagonalArriba();
                        Thread.sleep(1000);
                	}
                }
            }
        }catch (Exception exc){}
        System.out.println("El proceso "+Thread.currentThread().getName()+" ha finalizado.");
        mueveExit(); Thread.currentThread().stop();
    }//run 
    
    
    
    protected void mueveDiagonalArriba() {
    	try {
    	for(int i=70;i<241;i++) {
    			proceso.setBounds(i, (241-i)+15, 20, 20);
    			Thread.sleep(10);
    		}
      }catch(Exception a) {}
    }
    protected void mueveDiagonalAbajo() {
    	try {
    	for(int i=241;i<390;i++) {
    			proceso.setBounds(i, (15+i)-230, 20, 20);
    			Thread.sleep(12);
    		}
      }catch(Exception a) {}
    }
    protected void mueveCentro() {
    	try {
    	for(int i=390;i>=70;i--) {
    			proceso.setBounds(i, 175, 20, 20);
    			Thread.sleep(8);
    		}
      }catch(Exception a) {}
    }
    protected void mueveDiagonalRegresa() {
    	try {
    	for(int i=241;i>=135;--i) {
    			proceso.setBounds(i, (75-(i-241)), 20, 20);
    			Thread.sleep(8);
    		}
      }catch(Exception a) {}
    }
    protected void mueveExit() {
    	try {
    	for(int i=241;i<700;i++) {
    			proceso.setBounds(i, 50, 20, 20);
    			Thread.sleep(8);
    		}
      }catch(Exception a) {}
    }
}
