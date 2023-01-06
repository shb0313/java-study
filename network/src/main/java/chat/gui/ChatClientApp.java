package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (!name.isEmpty()) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		// 1. create socket
		Socket socket = new Socket();

		// 2. connect to server
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			System.out.println("connected");

			// 3. get iostream
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 4. join protocol 진행
			printWriter.println("join:" + name);

			String line = bufferedReader.readLine();

			if ("join:ok".equals(line)) {
				new ChatWindow(name, socket).show();
			}
		} catch (IOException e) {
			System.out.println("채팅종료");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
