package com.main.service;

import com.main.entity.Citizenplan;
import com.main.repo.CitizenPlanRepository;
import com.main.request.SearchRequest;
import com.main.utils.EmailSender;
import com.main.utils.Excelgenerator;
import com.main.utils.Pdfgenerate;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private CitizenPlanRepository planrepo;
    @Autowired
    private Excelgenerator excelgenerator;
    @Autowired
    private Pdfgenerate pdfgenerate;

    @Autowired
    private EmailSender emailSender;

    @Override
    public List<String> getPlanNames() {
        return planrepo.getPlanNames();
    }

    @Override
    public List<String> getPlanStatus() {
        return planrepo.getPlanStatus();
    }

    @Override
    public List<Citizenplan> search(SearchRequest request) {

        Citizenplan entity = new Citizenplan();

        if (null!=request.getPlanName() && !"".equals(request.getPlanName())){
            entity.setPlanName(request.getPlanName());
        }
        if (null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())){
            entity.setPlanStatus(request.getPlanStatus());
        }
        if (null!=request.getGender() && !"".equals(request.getGender())){
            entity.setGender(request.getGender());
        }
        if (null!=request.getPlanStartDate() && !"".equals(request.getPlanStartDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = request.getPlanStartDate();

            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formatter);
            entity.setPlanStartDate(localDate);
        }
        if (null!=request.getPlanEndDate() && !"".equals(request.getPlanEndDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = request.getPlanEndDate();

            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formatter);
            entity.setPlanEndDate(localDate);
        }
        return planrepo.findAll(Example.of(entity));

    }

    @Override
    public boolean exportToexcel(HttpServletResponse response) throws Exception  {

          File f = new File("plans.xls");
          List<Citizenplan> plans = planrepo.findAll();
          excelgenerator.generate(response,plans ,f);

          String subject="Insurance Report";
          String body= "<h3 color=lightgrey>hello " +
                "this Report show All the Citizen Name with status With Benefit Amount" +
                "<br>" +
                "<br></h3>" +
                "<h4 color=blue>yash Barve</h4>";
          String to= "aryanbarve2017@gmail.com";

          emailSender.sendEmail(subject ,body ,to,f);
          f.delete();

          return true;
    }

    @Override
    public boolean exportTopdf(HttpServletResponse response) throws Exception {

        File f = new File("plans.pdf");
        List<Citizenplan> plans = planrepo.findAll();
        pdfgenerate.pdfGenerate(response,plans,f);

        String subject= "Insurance Report";
        String body= "<h4>hello " +
                "this Report show All the Citizen Name with status With Benefit Amount" +
                "<br>" +
                "<br>" +
                "Regards" +
                "<br>"+
                "yash Barve</h4>";
        String to="ybarve99@gmail.com";

        emailSender.sendEmail(subject ,body ,to,f);
        f.delete();

        return true;
    }
}

