package com.yaesta.app.pdf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.yaesta.app.pdf.bean.GuideDataBean;

public class BuildGuidePDF {
	
	
	@SuppressWarnings("unused")
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
		}
		
		guideData.setResultMessage(result);
		return guideData;
	}
	
	private static void inputImagePdf(Document document, String imagePath)
			throws BadElementException, MalformedURLException, IOException {
		Image img = Image.getInstance(imagePath);
		try {
			document.add(img);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("image...");
	}
	
	private static void inputParagraphPDF(Document document, String textParagraph)
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
