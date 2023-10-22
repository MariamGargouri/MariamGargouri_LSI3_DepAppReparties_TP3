package Activite3_1;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
public class Client1 {
	
		public static void main(String[] args) 
		{

			try{
				
				//connexion
				  InetAddress inetAddress = InetAddress.getByName("localhost");
				  InetSocketAddress inetSocketAdd = new InetSocketAddress (inetAddress,1234); //inetSocketAdd c'est un lien virtuel entre les deux machines  
				  Socket socket=new Socket(); // une socket va etre crée qui signifie un transporteur de donnée
				  socket.connect(inetSocketAdd);// socket va connecter sur le chemin entre les deux machines 
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
		


