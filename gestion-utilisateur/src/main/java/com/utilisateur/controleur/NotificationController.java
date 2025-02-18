package com.utilisateur.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utilisateur.model.NotifDemandes;
import com.utilisateur.service.NotifDemandesService;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController 
@RequestMapping("utilisateur/notifs") 
public class NotificationController { 

	@Autowired
	private NotifDemandesService ns; 

	@GetMapping("/") 
	public List<NotifDemandes> getAllNotifications(){ 
		List<NotifDemandes> n = new ArrayList<NotifDemandes>();
		n=ns.list();
		return n; 
	}
	@GetMapping("/notificationsVue") 
	public int notificationsVue(){ 
		List<NotifDemandes> n = new ArrayList<NotifDemandes>();
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			NotifDemandes not = n.get(i);
			not.setStatut(true);
			ns.updateNotifDemandes(not);				
		}
		return getAllNbNotifications();
	}
	@GetMapping("/nbNotifs") 
	public int getAllNbNotifications(){ 
		List<NotifDemandes> n = new ArrayList<NotifDemandes>();
		int j =0;
		n=ns.list();
		for(int i=0;i<n.size();i++) {
			NotifDemandes not = n.get(i);
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