package com.yaesta.app.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yaesta.app.pdf.bean.GuideDataBean;

public class BuildTagGuidePDF extends BuildGuidePDF implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 5187673033595468041L;

	public static GuideDataBean generateGuidePDF(GuideDataBean guideData) {

		String result = "OK";

		try {

			
			OutputStream file = new FileOutputStream(new File(guideData.getPdfPath()));
			Document document = new Document(PageSize.A5.rotate());
			
			PdfWriter writer = PdfWriter.getInstance(document, file);
			document.open();
			setPageAtributePDF(document, guideData); // set atribute in pdf
			
			

			if (guideData.getLogoPath() != null) {
				inputImagePdf(document, guideData.getLogoPath(),guideData.getGuideLeyend()); // input image
																	// in pdf
			}

			PdfContentByte cb = writer.getDirectContent();

			PdfPTable table = new PdfPTable(1);

			Barcode128 code128 = new Barcode128();
			code128.setBaseline(-1);
			code128.setSize(6);
			//code128.setBarHeight(25f);
			code128.setCode(guideData.getGuideNumber());
			code128.setCodeType(Barcode128.CODE128);
			Image code128Image = code128.createImageWithBarcode(cb, CMYKColor.BLACK, CMYKColor.BLACK);
			PdfPCell cell = new PdfPCell();
			//cell.addElement(new Phrase("Guia #: " + guideData.getGuideNumber()));
			cell.addElement(code128Image);
			table.addCell(cell);

			document.add(table);

			if (guideData.getParagraphs() != null && !guideData.getParagraphs().isEmpty()) {
				for (String str : guideData.getParagraphs()) {
					inputParagraphPDF(document, str);
				}
			}
			if (guideData.getItemDataList() != null && !guideData.getItemDataList().isEmpty()) {
				document.add(TableBuilder.createTableData(guideData.getItemDataList(), guideData.getDataTitle())); // input
																													// pdf
			}
			document.close();
			file.close();
			System.out.println("Tag PDF generated!!!");

		} catch (Exception e) {
			result = "Error " + e.getMessage();
			e.printStackTrace();
		}

		guideData.setResultMessage(result);
		return guideData;
	}

	private static void inputImagePdf(Document document, String imagePath, String text)
			throws BadElementException, MalformedURLException, IOException {
		
		
		
		try {
			Paragraph p = new Paragraph();
			Phrase pp = new Phrase();
			Image img = Image.getInstance(imagePath);
			p.add((Element) new Chunk(img, 0, 0));
			pp.add(text);
			p.add(pp);
			document.add(p);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("image...");
	}

	private static void setPageAtributePDF(Document document, GuideDataBean guideData) {
		document.setPageSize(PageSize.A5.rotate());
		document.addAuthor(guideData.getAuthor());
		document.addCreationDate();
		document.addCreator(guideData.getCreator());
		document.addTitle(guideData.getTitle());
		System.out.println("atribute...");
	}
	
	

}
