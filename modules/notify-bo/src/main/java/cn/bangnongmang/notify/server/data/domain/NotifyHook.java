package cn.bangnongmang.notify.server.data.domain;

public class NotifyHook {
    private String hook_name;

    private String description;

    private String parameters;

    public String getHook_name() {
        return hook_name;
    }

    public void setHook_name(String hook_name) {
        this.hook_name = hook_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}