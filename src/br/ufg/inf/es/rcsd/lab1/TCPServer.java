package br.ufg.inf.es.rcsd.lab1;

import java.io.*;
import java.net.*;

class TCPServer {

	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;

		int porta = 6789;
		ServerSocket welcomeSocket = new ServerSocket(porta);

		System.out.println("Esperando conexoes na porta " + porta);

		int numConn = 1;
		
		while (true) {

			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("Conexao [" + numConn++ + "] aceita....");

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();

			capitalizedSentence = clientSentence.toUpperCase() + '\n';

			outToClient.writeBytes(capitalizedSentence);

			connectionSocket.close();

		}
	}
}
