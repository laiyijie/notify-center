package cn.bangnongmang.notify.client;

import cn.bangnongmang.notify.bo.NotifyBusinessMessage;
import cn.bangnongmang.notify.server.data.domain.NotifyHook;

public interface NotifyClient {

	void registerHook(NotifyHook notifyHook);

	void deleteHook(String notifyHookName);

	void sendBusinessMessage(NotifyBusinessMessage notifyBusinessMessage);

}
