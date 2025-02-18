package com.encadrement.controleur;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encadrement.model.NotifStage;
import com.encadrement.service.NotifStageService;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController 
@RequestMapping("gestStages/notifs") 
public class NotificationController { 

	@Autowired
	private NotifStageService ns; 
 	@GetMapping("/") 
	public List<NotifStage> getAllNotifications(){ 
		List<NotifStage> n = new ArrayList<NotifStage>();
		n=ns.list();
		return n; 

	}
	@GetMapping("/notificationsVue") 
	public int notificationsVue(){ 
		List<NotifStage> n = new ArrayList<NotifStage>();
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			NotifStage not = n.get(i);
			not.setStatut(true);
			ns.updateNotifDemandes(not);
				
		}
		return getAllNbNotifications();

	}
	@GetMapping("/nbNotifs") 
	public int getAllNbNotifications(){ 
		List<NotifStage> n = new ArrayList<NotifStage>();
		int j =0;
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			NotifStage not = n.get(i);
			if(!not.isStatut())
				j++;
		}
		return j; 

	}
	@DeleteMapping("/")
	public void deleteAll() {
		ns.deleteAll();
	}
		 
} 