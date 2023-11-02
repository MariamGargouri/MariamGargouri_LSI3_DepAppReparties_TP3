package Activite3_2;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Thread {
	
	private int nombreClient; // Permet de suivre son ordre de communication (numéro du client connecté)
	
	public static void main(String[] args) 
	{
		// Appel du serveur 
		(new Serveur()).start();
	}
	public void run()
	{
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("démarrage du serveur");
			while(true)
			{
				Socket s = ss.accept();// Attend qu'un client se connecte et accepte la connexion
				new ClientProcess(s,++nombreClient).start();// Crée un nouveau thread pour gérer le client
			}
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
// Création du thread
public class ClientProcess extends Thread{
	
	private int numClient;// Le numéro unique du client
	private Socket s;// Le socket pour communiquer avec le client
	
	// Constructeur
	public ClientProcess (Socket s,int numClient)
	{
		this.s=s;
		this.numClient=numClient;
	}
	public void run()
	{
		System.out.println("le client num:" + numClient+"de l'adresse IP:"+s.getRemoteSocketAddress());
		// Affiche un message au serveur, indiquant le numéro du client et son adresse IP
		
		try {
			new PrintWriter(s.getOutputStream(),true).println("bienvenue, vous etes le client num"+numClient);
			// Envoie un message de bienvenue au client connecté
			
			InputStream is = s.getInputStream();    // elle prend le contenue de os du client
		    OutputStream os = s.getOutputStream(); // Pour envoyer la resultat au client
		     									  //is et os : pour la communication entre le client et le serveur (thread)

		     ObjectInputStream ois = new ObjectInputStream(is);
		     Operation operation = (Operation) ois.readObject(); //reception d'un objet du type Operation 
		     
		     int op1= operation.getOp1();
		     int op2= operation.getOp2();
		     char op= operation.getOp();
		       
		     int result=0;
		     
		     switch(op) {
		     case '+': 
		    	 	result=op1+op2;
		    	 	break;
		     case '-':
		    	 	result=op1-op2;		       
		    	 	break;
		     case '*':
		    	 	result=op1*op2;			       
		    	 	break;
			 case '/':
			    	 result=op1/op2;			       
			    	 break;}
		     
			  ObjectOutputStream oos = new ObjectOutputStream(os);
			  Operation operation1 = new Operation (operation.getOp1(),operation.getOp2(), operation.getOp());
			  operation1.setResult(result);
			  
			  oos.writeObject(operation1); //envoie au client un objet de type Operation

		    } catch (IOException e) {e.printStackTrace();} catch (ClassNotFoundException e) {e.printStackTrace();}
	}
}// Fin du classe ClientProcess
}// Fin de la classe Serveur
