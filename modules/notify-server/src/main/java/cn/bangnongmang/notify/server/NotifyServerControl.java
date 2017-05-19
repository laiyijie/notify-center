package cn.bangnongmang.notify.server;

public interface NotifyServerControl {

	boolean createType(String name, String description, String patterConstraint);

	boolean deleteType(String name);

	boolean addHookTypeModel(String hookName, String typeName, String model);

	boolean modifyHookTypeModel(String hookName, String typeName, String model);

	boolean deleteHookTypeModel(String hookName, String typeName);
}
