package com.main.service;

import com.main.entity.Citizenplan;
import com.main.request.SearchRequest;

import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ReportService {

    public List<String> getPlanNames();

    public List<String> getPlanStatus();

    public List<Citizenplan> search(SearchRequest request);

    public boolean exportToexcel(HttpServletResponse response) throws Exception;

    public boolean exportTopdf(HttpServletResponse response)throws Exception;
}
