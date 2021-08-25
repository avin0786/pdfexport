package com.pdf.pdfexport.controller;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pdf.pdfexport.util.ExportPdfFile;

@Controller
public class PdfExportController {

	@RequestMapping(value = { "/export" }, method = { RequestMethod.GET })
	public ResponseEntity<InputStreamResource> exportToPdf(
			HttpServletResponse response) throws FileNotFoundException {

		response.setContentType("application/pdf");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET,POST,PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "filename=form_updated.pdf");
		headers.add("Cache-Control", "nocache , no-store,must-revalidate");
		headers.add("Pregma", "no-cache");
		headers.add("Expires", "0");

		InputStream ioStream = ExportPdfFile.getPdfFile();

		return ((ResponseEntity.BodyBuilder) ResponseEntity.ok().headers(
				headers)).contentType(MediaType.APPLICATION_PDF).body(
				new InputStreamResource(ioStream));

	}
}
