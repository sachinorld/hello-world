package com.html2pdf.convert;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import com.itextpdf.text.DocumentException;

public class Convert {

	public static void convert() {
		String str = "<html><head><body><div style=\"width:100%;height:100%;\"><h3 style=\"margin-left:5px;margin-top:40px\">First</h3><div style=\"margin-left:15px;margin-top:15px\"><title></title><p>sdasdasd shshshshdffgdfgd</p></div><h3 style=\"margin-left:5px;margin-top:40px\">The dream</h3><div style=\"margin-left:15px;margin-top:15px\"></div></div></body></head></html>";
	    String fileNameWithPath = "/D:/MySimple.pdf";


	    com.itextpdf.text.Document document =
	            new com.itextpdf.text.Document(com.itextpdf.text.PageSize.A4);
	    
		try(FileOutputStream fos = new FileOutputStream(fileNameWithPath)) {
			com.itextpdf.text.pdf.PdfWriter pdfWriter =
			        com.itextpdf.text.pdf.PdfWriter.getInstance(document, fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	    document.open();

	    document.addAuthor("Myself");
	    document.addSubject("My Subject");
	    document.addCreationDate();
	    document.addTitle("My Title");

	    com.itextpdf.text.html.simpleparser.HTMLWorker htmlWorker =
	            new com.itextpdf.text.html.simpleparser.HTMLWorker(document);
	    try {
			htmlWorker.parse(new StringReader(str.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	    document.close();
	}
	
	public static void main(String[] args) {
		convert();
	}

}
