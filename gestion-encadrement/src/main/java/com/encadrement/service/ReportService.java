package com.encadrement.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.encadrement.model.Report;
import com.encadrement.model.StringResult;

@Service(value="reportService")
public interface ReportService {
	
	public StringResult createReport(Report report,Long user_id,int duree,String user) throws SQLException;

}
