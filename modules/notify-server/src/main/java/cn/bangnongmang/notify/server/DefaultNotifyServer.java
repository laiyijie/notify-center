package cn.bangnongmang.notify.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.bangnongmang.notify.server.channel.NotifyBaseChannel;

public class DefaultNotifyServer implements NotifyServer {

	private List<NotifyBaseChannel> channels = new ArrayList<>();
	private boolean isStart = false;
	private ExecutorService executorService = Executors.newCachedThreadPool();

	private boolean available = false;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public void start() {

		if (!isAvailable()) {
			return;
		}
		if (!isStart) {
			for (NotifyBaseChannel notifyBaseChannel : channels) {
				executorService.execute(notifyBaseChannel);
			}
		}
		isStart = true;
	}

	@Override
	public void registerChannel(NotifyBaseChannel notifyBaseChannel) {
		this.channels.add(notifyBaseChannel);
	}

}
