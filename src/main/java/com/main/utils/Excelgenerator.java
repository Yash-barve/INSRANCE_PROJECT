package com.main.utils;

import com.main.entity.Citizenplan;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Component
public class Excelgenerator {

    public void generate(HttpServletResponse response , List<Citizenplan> records , File file)throws Exception{
        Workbook workbook = new HSSFWorkbook() ;
        Sheet sheet = workbook.createSheet("plans-data");
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("CITIZEN NAME");
        headerRow.createCell(2).setCellValue("GENDER");
        headerRow.createCell(3).setCellValue("PLAN NAME");
        headerRow.createCell(4).setCellValue("PLAN STATUS");
        headerRow.createCell(5).setCellValue("PLAN START DATE");
        headerRow.createCell(6).setCellValue("PLAN END DATE");
        headerRow.createCell(7).setCellValue("BENEFIT AMOUNT");

        int dataRowIndex = 1;
        for (Citizenplan plan:records) {
            Row dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(plan.getCitizenId());
            dataRow.createCell(1).setCellValue(plan.getCitizenName());
            dataRow.createCell(2).setCellValue(plan.getGender());
            dataRow.createCell(3).setCellValue(plan.getPlanName());
            dataRow.createCell(4).setCellValue(plan.getPlanStatus());
            if (null != plan.getPlanStartDate()) {
                dataRow.createCell(5).setCellValue(plan.getPlanStartDate());
            } else {
                dataRow.createCell(5).setCellValue("N/A");
            }
            if (null != plan.getPlanStartDate()) {
                dataRow.createCell(6).setCellValue(plan.getPlanEndDate());
            } else {
                dataRow.createCell(6).setCellValue("N/A");
            }
            if (null != plan.getPlanStartDate()) {
                dataRow.createCell(7).setCellValue(plan.getBenefitAmt()+"");
            } else {
                dataRow.createCell(7).setCellValue("N/A");
            }

            dataRowIndex++;
        }

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }
}
