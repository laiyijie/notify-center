package cn.bangnongmang.notify.bo.pattern;

import java.io.Serializable;
import java.util.Map;

public class NotifyAppPushPattern {
	private String title;
	private String description;
	private NotifyAction payload;
	private Integer notifyType;
	private int passThrough;
	private int timeToLive;
	private int timeToSend;
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NotifyAction getPayload() {
		return payload;
	}

	public void setPayload(NotifyAction payload) {
		this.payload = payload;
	}

	public Integer getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(Integer notifyType) {
		this.notifyType = notifyType;
	}

	public int getPassThrough() {
		return passThrough;
	}

	public void setPassThrough(int passThrough) {
		this.passThrough = passThrough;
	}

	public int getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	public int getTimeToSend() {
		return timeToSend;
	}

	public void setTimeToSend(int timeToSend) {
		this.timeToSend = timeToSend;
	}

	public static class NotifyAction implements Serializable{

		public enum ActionType {
			FRAGMENT,WEBPAGE
		}
		private ActionType actionType;
		private String messageType;
		private String messageIconUrl;
		private String target;
		private Map<String, Object> parameters;
		public ActionType getActionType() {
			return actionType;
		}
		public void setActionType(ActionType actionType) {
			this.actionType = actionType;
		}
		public String getTarget() {
			return target;
		}
		public void setTarget(String target) {
			this.target = target;
		}
		public Map<String, Object> getParameters() {
			return parameters;
		}
		public void setParameters(Map<String, Object> parameters) {
			this.parameters = parameters;
		}
		public String getMessageIconUrl() {
			return messageIconUrl;
		}
		public void setMessageIconUrl(String messageIconUrl) {
			this.messageIconUrl = messageIconUrl;
		}
		public String getMessageType() {
			return messageType;
		}
		public void setMessageType(String messageType) {
			this.messageType = messageType;
		}
		
		
		

	}

}
