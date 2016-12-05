package com.yaesta.app.pdf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yaesta.app.pdf.bean.GuideDataBean;

public class BuildGuidePDF implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5372397406436416938L;

	public static GuideDataBean generateGuidePDF(GuideDataBean guideData){
		
		String result = "OK";
		
		try{
			
			OutputStream file = new FileOutputStream(new File(guideData.getPdfPath()));
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, file);
			document.open();
			setAtributePDF(document,guideData); // set atribute in pdf
			
			if(guideData.getLogoPath()!=null){
				inputImagePdf(document,guideData.getLogoPath()); // input image in pdf
			}
			
			PdfContentByte cb = writer.getDirectContent();
			 
	        PdfPTable table = new PdfPTable(2);
	        
	        Barcode128 code128 = new Barcode128();
	        table.addCell("# Orden:");
	        code128.setBaseline(-1);
	        code128.setSize(12);
	        code128.setCode(guideData.getOrderId());
	        code128.setCodeType(Barcode128.CODE128);
	        Image code128Image = code128.createImageWithBarcode(cb, null, null);
	        PdfPCell cell = new PdfPCell();
	        cell.addElement(new Phrase("Orden #: " + guideData.getOrderId()));
	        cell.addElement(code128Image);
	        table.addCell(cell);
	 
	        document.add(table);
	        
			if(guideData.getParagraphs()!=null && !guideData.getParagraphs().isEmpty()){
				for(String str:guideData.getParagraphs()){
					inputParagraphPDF(document,str);
				}
			}
			if(guideData.getItemDataList()!=null && !guideData.getItemDataList().isEmpty()){
				document.add(TableBuilder.createTableData(guideData.getItemDataList(),guideData.getDataTitle())); // input table in pdf
			}
			document.close();
			file.close();
			System.out.println("PDF generated!!!");
			
			
			
		}catch(Exception e){
			result = "Error "+e.getMessage();
			e.printStackTrace();
		}
		
		guideData.setResultMessage(result);
		return guideData;
	}
	
	protected static void inputImagePdf(Document document, String imagePath)
			throws BadElementException, MalformedURLException, IOException {
		Image img = Image.getInstance(imagePath);
		try {
			document.add(img);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("image...");
	}
	
	protected static void inputParagraphPDF(Document document, String textParagraph)
			throws DocumentException {
		document.add(new Paragraph(textParagraph));
		
		System.out.println("text...");
	}
	
	private static void setAtributePDF(Document document, GuideDataBean guideData) {
		document.setPageSize(PageSize.A4);
		document.addAuthor(guideData.getAuthor());
		document.addCreationDate();
		document.addCreator(guideData.getCreator());
		document.addTitle(guideData.getTitle());
		System.out.println("atribute...");
	}


}
