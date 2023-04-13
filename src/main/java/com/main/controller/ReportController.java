package com.main.controller;

import com.main.entity.Citizenplan;
import com.main.request.SearchRequest;
import com.main.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("search" ,  new SearchRequest());
        init(model);
        return "home";
    }
    @PostMapping("/search")
    public String handleSearch(@ModelAttribute("search")  SearchRequest search , Model model) {

        List<Citizenplan> plans = service.search(search);
        model.addAttribute("plans", plans);
        init(model);

        return "home";
    }

    @GetMapping("/excel")
    public void generateExcelFile(HttpServletResponse response)throws Exception{
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition" ,"attachment;filename=plans.xls");
        service.exportToexcel(response);
    }
    @GetMapping("/pdf")
    public void generatePdfFile(HttpServletResponse response)throws Exception{
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition" ,"attachment;filename=plans.pdf");
        service.exportTopdf(response);
    }

    private void init(Model model) {
        model.addAttribute("pname" , service.getPlanNames());
        model.addAttribute("pstatus" , service.getPlanStatus());
    }

}

