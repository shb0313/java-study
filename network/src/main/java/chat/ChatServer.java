package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	//public static final int PORT = 5000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		List<Writer> listWriters = new ArrayList<Writer>();

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 기다림... ");

			try {
				// 3. 요청대기
				while (true) {
					socket = serverSocket.accept();
					new ChatServerThread(socket, listWriters).start();
				}
			} catch (SocketException e) {
				System.out.println("suddenly closed");
			} catch (IOException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String message) {
		System.out.println(message);
	}
}
