package com.pdf.pdfexport.util;

import java.io.FileNotFoundException;

public class MainTest {
	
	public static void main(String[] args){
		 System.out.println("I am a test");
		 try {
			 PdfDocument pdf = new PdfDocument(new PdfReader(SRC));
			    PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
			    XfaForm xfa = form.getXfaForm();
			    Document doc = xfa.getDomDocument();
			    DOMSource domSource = new DOMSource(doc);
			    StringWriter writer = new StringWriter();
			    StreamResult result = new StreamResult(writer);
			    TransformerFactory tf = TransformerFactory.newInstance();
			    Transformer transformer = tf.newTransformer();
			    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			    transformer.transform(domSource, result);
			    writer.flush();
			    System.out.println(writer.toString());
			ExportPdfFile.getPdfFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
