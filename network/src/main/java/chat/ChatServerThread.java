package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickName;
	private Socket socket;
	
	PrintWriter printWriter = null;
	List<Writer> listWriters;

	@Override
	public void run() {
		//1. Remote Host Information
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remotePort = inetRemoteSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		
		//2. 스트링 얻기
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
		
			//3. 요청 처리
			while(true) {
				String request = bufferedReader.readLine();
				
				if(request == null) {
					ChatServer.log("클리이언트로부터 연결 끊김");
					doQuit(printWriter);
					break;
				}
				
				//4. 프로토콜 분석
				String[] tokens = request.split(":");
				
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					ChatServer.log("에러:알 수 없는 요청(" + tokens[0] + ")");
				}				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickName = nickName;
		
		//입장
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		//writer pool에 저장
		addWriter(writer);
		
		//ack
		printWriter.println("join:ok");
		printWriter.flush();
		
	}

	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);			
		}
	}

	private void broadcast(String data) {
		synchronized(listWriters) {
			
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickName + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		listWriters.remove(writer);
		
	}
	

	private void doMessage(String string) {
		System.out.println(string);
		
	}	
}
