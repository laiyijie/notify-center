package cn.bangnongmang.notify.server.channel;

import cn.bangnongmang.notify.server.service.NotifyCommand;

public interface NotifyCommandBrocaster {
	void registerNotifyCommand(String commandName, NotifyCommand notifyCommand);
}
