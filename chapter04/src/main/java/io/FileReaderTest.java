package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		
		try {
			in = new FileReader("test.txt");
			
			int count = 0;
			int data = -1;
			while((data = in.read()) != -1) {
				System.out.println((char)data);
			}
			System.out.println("");
			System.out.println("count:" + count);
			
		} catch(FileNotFoundException e) {
			System.out.println("File Not Found:" + e);
		} catch(IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(in != null) {
					in.close();
				} 
			} catch (IOException e) {
	            e.printStackTrace();
			}
		}
	}
}
