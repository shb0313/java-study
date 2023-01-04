package chatprac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		BufferedReader bufferedReader;
		PrintWriter printWriter;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");

			// 4. reader/writer 생성
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickName = scanner.nextLine();
			printWriter.println("join:" + nickName);
			printWriter.flush();

			// 6. ChatClientThread 시작
			new ChatClientThread(socket).start();
			
			// 7. 키보드 입력처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					break;
				} else {
					// 9. 메시지 처리
					System.out.println(nickName + ":" + input);
				}
			}
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			// 10. 자원관리
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				log("error:" + e);
			}
		}
	}

	private static void log(String message) {
		System.out.println("Client : " + message);
	}

}
