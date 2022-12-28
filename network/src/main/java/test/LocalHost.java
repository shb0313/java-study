package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			String hostName = inetAddress.getHostName();
			String hostIpAdress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostIpAdress);
			
			byte[] ipAdresses = inetAddress.getAddress();
			for(byte ipAdress : ipAdresses) {
				//System.out.println((int)ipAdress);
				System.out.print(ipAdress & 0x000000ff);
				System.out.print(".");
			}
						
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
