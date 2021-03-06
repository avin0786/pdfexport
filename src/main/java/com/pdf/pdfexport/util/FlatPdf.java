package com.pdf.pdfexport.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.forms.xfa.XfaForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.licensekey.LicenseKey;

public class FlatPdf {
	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, InterruptedException {
		PdfReader reader = new PdfReader(
				"D:\\pdfexport\\src\\main\\resources\\pdf\\Form_AOC4.pdf");
		PdfWriter writer = new PdfWriter(
				"D:\\pdfexport\\src\\main\\resources\\pdf\\Form_AOC-4.pdf");
		LicenseKey
				.loadLicenseFile("D:\\pdfexport\\src\\main\\resources\\itextkey.xml");

		/*
		 * XFAFlattenerProperties flattenerProperties = new
		 * XFAFlattenerProperties()
		 * .setPdfVersion(XFAFlattenerProperties.PDF_1_7) .createXmpMetaData()
		 * .setTagged() .setMetaData( new MetaData() .setAuthor("iText Samples")
		 * .setLanguage("EN") .setSubject("Showing off our flattening skills")
		 * .setTitle("Flattened XFA"));
		 * 
		 * XFAFlattener xfaf = new XFAFlattener()
		 * .setFlattenerProperties(flattenerProperties);
		 * 
		 * xfaf.flatten(new
		 * FileInputStream("D:\\pdfexport\\src\\main\\resources\\pdf\\Form_AOC4.pdf"
		 * ), new FileOutputStream(
		 * "D:\\pdfexport\\src\\main\\resources\\pdf\\flat.pdf"));
		 */

		PdfDocument pdfDoc = new PdfDocument(reader, writer);
		 XfaForm xfa = PdfAcroForm.getAcroForm(pdfDoc, false).getXfaForm();
		//Document domDoc =  xfa.getDomDocument();
		
		  // XfaForm xfa = form.getXfaForm();

	        // Method fills this object with XFA data under datasets/data.
	        xfa.fillXfaForm(new FileInputStream("D:\\pdfexport\\src\\main\\resources\\Form_AOC4_data.xml"));
	        xfa.write(pdfDoc);

		/*Map<String, PdfFormField> fields = PdfAcroForm
				.getAcroForm(pdfDoc, true).getFormFields();
		for (Map.Entry<String, PdfFormField> name : fields.entrySet()) {
			System.out
					.println("Element getValue=" + name.getValue().getValue());

		} */
		pdfDoc.close();
	}

}
