package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		
		//기반 스트림
		try {
			FileOutputStream fos = new FileOutputStream("hello.txt");
			
			//보조 스트림
			bos = new BufferedOutputStream(fos);
			
			//for(int = 'a'; i <= 'z'; i++)
			for(int i = 97; i <= 122; i++) {
				bos.write(i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Foound:" + e);
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}finally {
			try {
				if(bos != null) {
					bos.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
