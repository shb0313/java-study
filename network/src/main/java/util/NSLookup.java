package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {

		try {

			while (true) {
				System.out.print(">");
				Scanner sc = new Scanner(System.in);
				String domainName = sc.nextLine();

				InetAddress[] inetAddresses = InetAddress.getAllByName(domainName);

				for (int i = 0; i < inetAddresses.length; i++) {
					System.out.println(inetAddresses[i].getHostName() + " : " + inetAddresses[i].getHostAddress());
				}

				if (domainName == "exit") {
					break;
				}

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
