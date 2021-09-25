package com.pdf.pdfexport.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFAResource;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;

public class ExportPdfFile {

	private ExportPdfFile() {

	}

	public static InputStream getPdfFile()
			throws FileNotFoundException {
		try {
			ClassPathResource pdfFile = new ClassPathResource(
					"pdf/Form_AOC-4.pdf");
			
			

			Map<String,String> dataMap = getPdfFileData();
			/*for (Map.Entry<String, String> entry : dataMap.entrySet()) {
				if (pdAcroForm.getField((String) entry.getKey()) != null) {
					pdAcroForm.getField((String) entry.getKey()).setValue(
							(String) entry.getValue());
				}
			} */
			;
			return pdfFile.getInputStream();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static Map<String, String> getPdfFileData()
			throws FileNotFoundException {
		Map<String, String> dataMap = new HashMap<>();
		try {
			ClassPathResource pdfFile = new ClassPathResource(
					"pdf/Form_AOC5.pdf");
			PDDocument pdDocumnet = PDDocument.load(pdfFile.getFile());
			PDDocumentCatalog docCatalog = pdDocumnet.getDocumentCatalog();
		    PDAcroForm form = docCatalog.getAcroForm();
		    PDXFAResource xfa = form.getXFA();
		    System.out.println("XFA"+xfa.getDocument().toString());
		    
		    String s = new String(xfa.getBytes());
		    Iterator<PDField> iterate  = form.getFieldIterator();
		    while(iterate.hasNext())
		    	
		    {
		    	PDField item =iterate.next();
		    	//System.out.println("Item="+item.getFieldType());
		    	//System.out.println("Item="+item.getWidgets());
		    }
		  for(PDField filed :form.getFields()){
		    	//System.out.println("filed=" +filed.getAlternateFieldName());
				//System.out.println("filed=" +filed.getFullyQualifiedName());
				//dataMap.put(filed.getPartialName(), filed.getValueAsString());
		    }
		   
		    //String replacementString = IOUtils.toString(data.getDataStream());
			PDAcroForm pdAcroForm = pdDocumnet.getDocumentCatalog()
					.getAcroForm();
			List<PDField> fileds = pdAcroForm.getFields();
			for (PDField filed :fileds) {
				//System.out.println("filed=" +filed.getAlternateFieldName());
				//System.out.println("filed=" +filed.getFullyQualifiedName());
				//System.out.println("PDFTextStripper=" +new PDFTextStripper().getText(pdDocumnet));
				dataMap.put(filed.getPartialName(), filed.getValueAsString());
			}
			//System.out.println("Data map=" +dataMap.toString());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMap;

	}

}
