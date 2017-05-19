package cn.bangnongmang.notify.bo;

import java.io.Serializable;

public class NotifyCommand implements Serializable{
	/** 
	 * @Fields serialVersionUID TODO(用一句话描述这个变量表示什么)
	 */ 
	private static final long serialVersionUID = 5590747778573905675L;
	public static final String REGISTER_HOOK = "register";
	public static final String UNREGISTER_HOOK = "unregister";
	
	protected String command;
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}
