package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			//1. 키보드 연결
			scanner = new Scanner(System.in);
						
			//2. Socket 생성
			socket = new Socket();
			
			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");
			
			//4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			//5. join 프로토콜
			System.out.print("닉네임>>");
			String nickName = scanner.nextLine();
			printWriter.println("join: " + nickName);
			printWriter.flush();
			
			//6. ChatClientThread 시작
			new ChatClientThread();
						
			//7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input)) {
					//8. quit 프로토콜 처리
					break;
				}else {
					//메시지 처리				
					printWriter.println(input);
					String data = br.readLine();
					if(data == null) {
						log("closed by server");
						break;
					}
					System.out.println("<<" + data + nickName );					
				}
			}
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}