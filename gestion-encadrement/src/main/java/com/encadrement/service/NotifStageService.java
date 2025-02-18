package com.encadrement.service;

import java.util.List;

import com.encadrement.model.NotifStage;

public interface NotifStageService {

	List<NotifStage> list();
	void addNotifDemandes (NotifStage n);
	void updateNotifDemandes(NotifStage n);
	void deleteNotifDemandes(Long id);
	void deleteAll();
}
