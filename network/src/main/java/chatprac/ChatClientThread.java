package chatprac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	
	Socket socket = null;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			
			String message = bufferedReader.readLine();
			
			if(message == null) {
				System.out.println("");
			}
			
			System.out.println(message);
		
		} catch (IOException e) {
			System.out.println("채팅종료");
		}
	}

}
