package cn.bangnongmang.notify.server.channel;

import cn.bangnongmang.notify.server.service.NotifySender;

public interface NotifyBusinessBrocaster {
	void registerNotifySender(String senderName,NotifySender notifyBaseSender);
}
