package cn.bangnongmang.notify.server;

import cn.bangnongmang.notify.server.channel.NotifyBaseChannel;

public interface NotifyServer {

	void start();
	void registerChannel(NotifyBaseChannel notifyBaseChannel);

}
