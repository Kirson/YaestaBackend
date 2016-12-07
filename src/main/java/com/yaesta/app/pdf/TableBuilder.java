package com.yaesta.app.pdf;

import java.io.Serializable;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.yaesta.app.pdf.bean.ItemData;
import com.yaesta.app.pdf.enums.ItemDataEnum;

public class TableBuilder implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4444416262225998510L;

	public static PdfPTable createTableData(List<ItemData> data, String tableLabel) throws DocumentException {

		PdfPTable table = new PdfPTable(3); //3 column
		table.setWidthPercentage(100); // width of the table to 100% of page
		table.setWidths(new float[] { 1f, 1f, 1f });

		PdfPCell cell = new PdfPCell(new Phrase(tableLabel));

		cell.setColspan(3);
		TableStyle.headerCellStyle(cell);
		table.addCell(cell);
		
		table.addCell(labelCell(ItemDataEnum.CODE.getDescItem()));
		table.addCell(labelCell(ItemDataEnum.NAME.getDescItem()));
		table.addCell(labelCell(ItemDataEnum.QUANTITY.getDescItem()));

		for(ItemData id:data){
			table.addCell(valueCell(id.getCode()));
			table.addCell(valueCell(id.getName()));
			table.addCell(valueCell(id.getQuantity()));
		}

	

		System.out.println("table...");
		return table;
	}

	private static PdfPCell labelCell(String text) {
		PdfPCell cell = new PdfPCell(new Phrase(text));
		TableStyle.labelCellStyle(cell);
		return cell;
	}
	
	private static PdfPCell valueCell(String text) {
		PdfPCell cell = new PdfPCell(new Phrase(text));
		TableStyle.valueCellStyle(cell);
		return cell;
	}
}
