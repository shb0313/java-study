package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 1. 기반 스트림(표준입력, stdin, System.in)
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");

			// 2.보조스트림1(byte|byte|byte -> char)
			
			// 3. 보조스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4)
			br = new BufferedReader(isr);
	
			// 4. 처리
			String line = null;
			
				while((line = br.readLine()) != null) {
					if("quit".equals(line)) {
						break;
					}
					System.out.println(line);
				}		
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error:" + e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();				
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}
