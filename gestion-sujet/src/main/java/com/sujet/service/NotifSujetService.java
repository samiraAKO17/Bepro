package com.sujet.service;

import java.util.List;

import com.sujet.model.NotifSujet;

public interface NotifSujetService {

	List<NotifSujet> list();
	void addNotifDemandes (NotifSujet n);
	void updateNotifDemandes(NotifSujet n);
	void deleteNotifDemandes(Long id);
	void deleteAll();
}
