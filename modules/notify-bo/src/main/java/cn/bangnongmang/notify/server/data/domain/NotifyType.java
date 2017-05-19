package cn.bangnongmang.notify.server.data.domain;

public class NotifyType {
    private String type_name;

    private String description;

    private String patternConstraint;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPatternConstraint() {
        return patternConstraint;
    }

    public void setPatternConstraint(String patternConstraint) {
        this.patternConstraint = patternConstraint;
    }
}