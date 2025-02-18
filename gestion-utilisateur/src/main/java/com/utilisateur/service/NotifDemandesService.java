package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.NotifDemandes;

public interface NotifDemandesService {

	List<NotifDemandes> list();
	void addNotifDemandes (NotifDemandes n);
	void updateNotifDemandes(NotifDemandes n);
	void deleteNotifDemandes(Long id);
	void deleteAll();
}
