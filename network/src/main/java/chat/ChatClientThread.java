package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;


public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;

	
	@Override
	public void run() {
		try {			
			while(true) {
				String message = bufferedReader.readLine();
				if(message == null) {
					ChatClient.log("closed by client");
					break;
				}	
				
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
