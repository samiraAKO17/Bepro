package com.encadrement.controleur;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.encadrement.Feign.EncadrementContacts;
import com.encadrement.model.Report;
import com.encadrement.model.StringResult;
import com.encadrement.service.ReportService;
import com.utilisateur.model.Utilisateur;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/attestation")
public class ReportController {
	@Autowired
	@Qualifier("reportService")
	ReportService reportService;
	@Autowired
	EncadrementContacts c;
	@RequestMapping(value="/{user_id}/{duree}",method = RequestMethod.POST)
	public StringResult printUsers(@PathVariable Long user_id,@PathVariable int duree,@RequestBody Report report){
		Utilisateur u =c.getUser(user_id);
		String user =u.getNom()+" "+u.getPrenom();
		StringResult reportName = null;
		try {  
			
			reportName = this.reportService.createReport(report,user_id,duree,user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reportName;		
	}

}
