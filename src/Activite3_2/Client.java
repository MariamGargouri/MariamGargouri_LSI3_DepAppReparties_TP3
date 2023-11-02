package Activite3_2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) 
	{

		try{
			
			  // Connexion
			  System.out.println("je suis un client");
			  Socket socket=new Socket("10.25.12.63",1234); // Une socket va etre crée : domander une connexion du client au serveur 
			  System.out.println("je suis un client connecté");
			  
			  //partie traitement
			  InputStream is = socket.getInputStream(); // Pour lire le flux qui est dans le port 1234
			  OutputStream os = socket.getOutputStream();
			 
			  InputStreamReader isr= new InputStreamReader(is); // Lire caractère par caractère 
			  BufferedReader br = new BufferedReader(isr); // Lire des chaines de caractères 
			  System.out.println(br.readLine());// reception d'une chaine de caractere qui contient son ordre de communication 
			  
			  ObjectOutputStream oos = new ObjectOutputStream(os);
			  
			  int op1;
			  int op2;
			  String op;

			  System.out.println("donner le premier opérant");
			  Scanner scanner= new Scanner(System.in); // Je donne la main au utilisateur d'ecrire une valeur
			  op1=scanner.nextInt(); // nextInt pour lire un entier
			  
			  System.out.println("donner le deuxième opérant");
			  op2=scanner.nextInt(); // nextInt pour lire un entier
			  
			  do
			  {
			  System.out.println("donner l'opération (+,-,*,/)");
			  op=scanner.nextLine(); // nextLine pour lire un une chaine de caractères ou un caractère
			  } while (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*")  );
			  
			  
			  Operation operation = new Operation (op1,op2,op.charAt(0)); // instanciation de l'objet Operation 
			  oos.writeObject(operation);// envoyer un objet de type Operation au serveur

			  ObjectInputStream ois = new ObjectInputStream(is);
			  Operation operation1 = (Operation) ois.readObject(); //reception d'un objet du type Operation 
			     
			  System.out.println(op1+" "+op+" "+" "+op2+" = "+operation1.getResult());
			  
			  	 
			  //Déconnexion
			  System.out.println("deconnexion client");
			  socket.close();
			}
			catch(Exception e) {e.printStackTrace();}
	}
}


