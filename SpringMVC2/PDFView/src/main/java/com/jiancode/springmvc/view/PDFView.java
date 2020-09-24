package com.jiancode.springmvc.view;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Description：TODO
 * author：yj
 * email：yj@allong.net
 * date：2019-06-26 10:32
 * version：1.0
 */
public class PDFView extends AbstractPdfView {

    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> userData = (Map<String, String>) model.get("userData");
        Table table = new Table(2);
        table.addCell("No.");
        table.addCell("User Name");

        for (Map.Entry<String, String> entry : userData.entrySet()) {
            table.addCell(entry.getKey());
            table.addCell(entry.getValue());
        }
        document.add(table);
    }
}
