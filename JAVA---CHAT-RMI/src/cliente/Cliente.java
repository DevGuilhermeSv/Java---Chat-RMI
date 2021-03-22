package cliente;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import model.ChatGUI;
import servidor.ServerIF;

public class Cliente extends UnicastRemoteObject implements ClienteIF, Runnable {

	private ServerIF serverIF;
	private String name = "Cliente";
	private static final long serialVersionUID = 1L;
	private Scanner scanner;
	private ChatGUI chat; 
	protected Cliente(String name, ServerIF serverIF) throws IOException {

		this.name = name;
		this.serverIF = serverIF;
		serverIF.conectClienteChat(this, name);
		chat = new ChatGUI();
		

	}

	public synchronized void recuperaMessage(String message) throws RemoteException {
		chat.chatbox(message);
	
		//System.out.println(message);

	}
	

	public synchronized String getNameCliente() throws RemoteException {
		return this.name;
	}

	public void run() {

		scanner = new Scanner(System.in);
		String message;

		while (true) {

			message = scanner.nextLine();

			try {

				if (!message.equals("/exit")) {
					serverIF.sendMenssage("[" + name + "] : " + message);
				} else {
					serverIF.sendMenssage("[" + name + "] : desconectou-se");
					serverIF.disconnectClienteChat(this);
					
					System.exit(0);
					break;
				}

			} catch (RemoteException e) {
				e.printStackTrace();

			}

		}

	}

}
