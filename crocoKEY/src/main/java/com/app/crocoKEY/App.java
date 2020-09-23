package com.app.crocoKEY;

import java.awt.EventQueue;
import java.io.*;
import java.net.*;

import com.app.crocoKEY.db.DB_access;
import com.app.crocoKEY.gui.crocoKEY;
import com.mongodb.client.MongoCursor;

//import com.app.crocoKEY.db.DB_access;
//import com.app.crocoKEY.gui.crocoKEY;

public class App {
	 private Socket clientSocket;
	    private PrintWriter out;
	    private BufferedReader in;
	 
	    public static void startConnection(String ip, int port){
//	        clientSocket = new Socket(ip, port);
//	        out = new PrintWriter(clientSocket.getOutputStream(), true);
//	        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//	        

	        String hostname = ip;
	 
	        try (Socket socket = new Socket(hostname, port)) {
	 
	            InputStream input = socket.getInputStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	 
	            String time = reader.readLine();
	 
	            System.out.println(time);
	 
	 
	        } catch (UnknownHostException ex) {
	 
	            System.out.println("Server not found: " + ex.getMessage());
	 
	        } catch (IOException ex) {
	 
	            System.out.println("I/O error: " + ex.getMessage());
	        }
	        
	    }
	 
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						if (args[0].equalsIgnoreCase("console")) {
							System.out.println("Welcome! to crocoKEY v0.20.0.1   \t\t-console mode-");
								try {
									App.startConnection("127.0.0.1", 6969);
									
									
//									DB_access a = new DB_access();
//									MongoCursor<String> dbsCursor = a.getMongoClient().listDatabaseNames().iterator();
//									
//									while(dbsCursor.hasNext()) {
//										if (dbsCursor.next().equalsIgnoreCase("T800")) {
//											System.out.println("* -- T800 " );											
//										}else {
//											System.out.println("* -- *");
//										}
//									}
									
								}catch(Exception e) {
									System.out.println("Error -- "+e);
								}
															
						}else{
							System.out.println("Welcome!");
							crocoKEY frame = new crocoKEY("crocoKEY","v0.20.4.0");
		//					frame.setLocationRelativeTo(null);
		//					frame.setVisible(true);	
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
