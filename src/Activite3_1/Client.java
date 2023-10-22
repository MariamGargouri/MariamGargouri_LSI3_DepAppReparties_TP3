package Activite3_1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) 
	{

		try{
			
			  // Connexion
			  System.out.println("je suis un client");
			  Socket socket=new Socket("localhost",1234); // Une socket va etre crée : domander une connexion du client au serveur 
			  System.out.println("je suis un client connecté");
			  
			  //partie traitement
			  InputStream is = socket.getInputStream(); // Pour lire le flux qui est dans le port 1234
			  InputStreamReader isr= new InputStreamReader(is); // Lire caractère par caractère 
			  BufferedReader br = new BufferedReader(isr); // Lire des chaines de caractères 
			  System.out.println(br.readLine());
			  
			  //Déconnexion
			  System.out.println("deconnexion client");
			  socket.close();
			}
			catch(Exception e) {e.printStackTrace();
}
		
	}
}
	


