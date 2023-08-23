/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.modelo.MensajeDTO;
import co.edu.unbosque.modelo.NumeroDTO;
import co.edu.unbosque.modelo.persistence.FileHandler;

/**
 *
 * @author englinx
 */
public class Servidor implements Runnable{
    //initialize socket and input stream 
    private Socket socket; //This socket is for read client message
    private Socket socketR;//This socket is for send a message to client
    private ServerSocket server; 
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int	port;
    private String addressClient;
    
  
    // constructor with port 
    public Servidor(int port){ 
    	//initialize socket and input stream 
    	this.socket=null;
    	this.socketR=null;
    	this.server=null; 
    	this.in=null;
    	this.out=null;
    	this.port=port;
    	this.addressClient=addressClient;
    	
       
    }
    @Override
    public void run(){
    	MensajeDTO mss;

            try
            { 
//            	this.server = new ServerSocket(this.port);
            	while (true) {
            		this.server = new ServerSocket(this.port);
            		System.out.println("Server started"); 
        	        System.out.println("Waiting for a client ..."); 
        	        this.socket = server.accept(); 
        	        System.out.println("Client accepted");
        	        String[]lineas= loadFromFile();
        	        MensajeDTO menu1=new MensajeDTO(lineas[0]);
        	        
        	        this.socketR=new Socket(this.socket.getInetAddress(), this.port+1);
        	        this.out = new ObjectOutputStream(socketR.getOutputStream()); 
        	        this.out.writeObject(menu1);
        	        this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); 
        	        MensajeDTO numerorecibido=(MensajeDTO)in.readObject();
        	        System.out.println("Mensaje Recibido"+ numerorecibido.getMensaje());
        	        // takes input from the client socket 
        	        String numeromenu="";
                	int opcionseleccionada=Integer.parseInt(numerorecibido.getMensaje());
                	System.out.println(opcionseleccionada);
                	if(opcionseleccionada ==1) {
                		
                	}
        	        mss = (MensajeDTO)in.readObject();
        	        
                    //Print in server the client message
                    System.out.println(mss);
                    
                   //Send message to the client
                  // Create a socket to send message to client
                	
                	//sends output to the socket to client
                    
                    this.out.writeUTF("You send this: "+mss+" :D");
                    this.out.close();
//                    this.socketR.close();
                    this.in.close();
                    this.server.close();
				}
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            }  catch(ClassNotFoundException e) 
            { 
                System.out.println(e); 
            } 
//        } 
        System.out.println("Closing connection"); 

//        // close connection 
        try {
			socket.close();
			in.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
    } 
    public String[] loadFromFile() {
    	String contenido= FileHandler.abrirArchivoDeTexto("preguntasrespuestas.txt");
    	String [] lineas= contenido.split("\n");
    	for(String linea : lineas) {
    		String[]menu= linea.split(";");
    	}
    	return lineas;
    }
    
    public static void main(String args[]) 
    { 
    	
    	Servidor server = new Servidor(5000);
    	Thread one= new Thread(server);
    	one.start();
    } 
    
    }
    	
    
    

    

