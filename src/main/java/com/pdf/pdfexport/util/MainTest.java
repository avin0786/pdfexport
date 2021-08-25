package com.pdf.pdfexport.util;

import java.io.FileNotFoundException;

public class MainTest {
	
	public static void main(String[] args){
		 System.out.println("I am a test");
		 try {
			ExportPdfFile.getPdfFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
