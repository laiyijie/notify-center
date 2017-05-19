package cn.bangnongmang.notify.server.service;

import cn.bangnongmang.notify.bo.NotifyBusinessMessage;

public interface NotifySender {
	void send(NotifyBusinessMessage notifyBusinessMessage, String pattern,String constraint);
}
