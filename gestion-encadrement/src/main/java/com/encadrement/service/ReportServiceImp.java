package com.encadrement.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.encadrement.model.Report;
import com.encadrement.model.StringResult;
import com.encadrement.util.Constant;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@Service(value="reportService")
public class ReportServiceImp implements ReportService{

	@Autowired
	DataSource datasource;
	
	@Autowired
	ResourceLoader resourceloader;
	@Override
	public StringResult createReport(Report report,Long user_id,int duree, String user) throws SQLException {
		// TODO Auto-generated method stub
		StringResult reportName =new StringResult();
		try {
			
			Resource resource=resourceloader.getResource("Classpath:/report/"+report.getName()+".jasper");
			
			InputStream reportStream = resource.getInputStream();
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			OutputStream outputstream = new ByteArrayOutputStream();
			
			parameters.put("Report_Folder", resourceloader.getResource("classpath:/report/").getFile().getAbsolutePath()+java.io.File.separator);
			parameters.put("user_id", user_id);
			parameters.put("duree", duree);
			parameters.put("user", user);
			Connection conn = this.datasource.getConnection();
			
			byte [] reportsBytes = JasperRunManager.runReportToPdf(reportStream, parameters,conn);
			
			reportName.setName(report.getName()+"_"+System.currentTimeMillis()+".pdf");
			
			FileOutputStream fileOutputStream = new FileOutputStream(Constant.REPORT_RESULT_FOLDER + reportName.getName());
			
			fileOutputStream.write(reportsBytes);
			
			fileOutputStream.close();
			
			return reportName;
		}catch (JRException e) {
			// TODO: handle exception
			System.out.print(e.getStackTrace());
		}catch (IOException e) {
			// TODO: handle exception
			System.out.print(e.getStackTrace());

		}
		return null;
		
	}


}
