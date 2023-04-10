package com.main.service;

import com.main.entity.Citizenplan;
import com.main.repo.CitizenPlanRepository;
import com.main.request.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private CitizenPlanRepository planrepo;
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
    public boolean exportToexcel() {
        return false;
    }

    @Override
    public boolean exportTopdf() {
        return false;
    }
}
