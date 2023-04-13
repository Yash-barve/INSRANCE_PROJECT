package com.main.utils;

import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.main.entity.Citizenplan;
import com.main.repo.CitizenPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


@Component
public class Pdfgenerate {

    public void pdfGenerate(HttpServletResponse response, List<Citizenplan> plans , File f) throws Exception{

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());
        PdfWriter.getInstance(document,new FileOutputStream(f));

        document.open();
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);

        Paragraph paragraph1 = new Paragraph("Citizen Plan Report", fontTiltle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph1);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);

        table.addCell("Id");
        table.addCell("CName");
        table.addCell("Gender");
        table.addCell("PName");
        table.addCell("PStatus");
        table.addCell("StatDte");
        table.addCell("Benefit");

        for (Citizenplan plan : plans){
            table.addCell(String.valueOf(plan.getCitizenId()));
            table.addCell(plan.getCitizenName());
            table.addCell(plan.getGender());
            table.addCell(plan.getPlanName());
            table.addCell(plan.getPlanStatus());
            table.addCell(plan.getPlanStartDate()+"");
            table.addCell(plan.getBenefitAmt()+"");
        }
        document.add(table);
        document.close();

    }

}
