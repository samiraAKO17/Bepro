package com.sujet.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujet.model.NotifSujet;
import com.sujet.service.NotifSujetService;


@CrossOrigin(origins = "http://localhost:4200") 
@RestController 
@RequestMapping("gestSujets/notifs") 
public class NotificationController { 

	@Autowired
	private NotifSujetService ns; 

	@GetMapping("/") 
	public List<NotifSujet> getAllNotifications(){ 
		List<NotifSujet> n = new ArrayList<NotifSujet>();
		n=ns.list();
		return n; 

	}
	@GetMapping("/notificationsVue") 
	public int notificationsVue(){ 
		List<NotifSujet> n = new ArrayList<NotifSujet>();
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			NotifSujet not = n.get(i);
			not.setStatut(true);
			ns.updateNotifDemandes(not);
				
		}
		return getAllNbNotifications();

	}
	@GetMapping("/nbNotifs") 
	public int getAllNbNotifications(){ 
		List<NotifSujet> n = new ArrayList<NotifSujet>();
		int j =0;
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			NotifSujet not = n.get(i);
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