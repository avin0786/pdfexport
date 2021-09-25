package com.pdf.pdfexport.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class MainTest {
	
	public static void main(String[] args) throws IOException{
		 System.out.println("I am a test");                                                                                                                                                     
		 try {
			 
			 
			 
			// PdfReader reader = new PdfReader("pdf/Form_AOC4.pdf");
			// reader.ge
			// PdfDocument pdfDoc = new PdfDocument(new PdfReader("pdf/Form_AOC4.pdf"));
		     //   PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);

		        // Being set as true, this parameter is responsible to generate an appearance Stream
		        // while flattening for all form fields that don't have one. Generating appearances will
		        // slow down form flattening, but otherwise Acrobat might render the pdf on its own rules.
		      //  form.setGenerateAppearance(true);
			 
			  FileInputStream fileInputStream = new FileInputStream("pdf/Form_AOC4.pdf");     
		
			    
			 
			ExportPdfFile.getPdfFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
