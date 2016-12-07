package com.yaesta.app.pdf;

import java.io.Serializable;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Base on https://github.com/KRostyslav/generatePDF/blob/master/generatePDF/
 * @author cristhian
 *
 */
public class TableStyle implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4274238326652981465L;

	public static void headerCellStyle(PdfPCell cell) {
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setPaddingTop(0f);
		cell.setPaddingBottom(1f);
		cell.setBackgroundColor(new BaseColor(0, 121, 182));
		cell.setBorder(0);
		cell.setBorderWidthBottom(2f);
	}

	public static void labelCellStyle(PdfPCell cell) {
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPaddingLeft(1f);
		cell.setPaddingTop(0f);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setBorder(0);
		cell.setBorderWidthBottom(1);
		cell.setBorderColorBottom(BaseColor.GRAY);
		cell.setMinimumHeight(15f);
	}

	public static void valueCellStyle(PdfPCell cell) {
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPaddingTop(0f);
		cell.setPaddingBottom(1f);
		cell.setBorder(0);
		cell.setBorderWidthBottom(0.5f);
		cell.setMinimumHeight(15f);
	}
}
