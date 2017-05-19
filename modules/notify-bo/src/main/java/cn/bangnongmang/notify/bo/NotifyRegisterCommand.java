package cn.bangnongmang.notify.bo;

import cn.bangnongmang.notify.server.data.domain.NotifyHook;

public class NotifyRegisterCommand extends NotifyCommand{

	/** 
	 * @Fields serialVersionUID TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = -5017991470290280895L;



	private NotifyHook notifyHook;

	public NotifyHook getNotifyHook() {
		return notifyHook;
	}

	public void setNotifyHook(NotifyHook notifyHook) {
		this.notifyHook = notifyHook;
	}


	
}
