package cn.bangnongmang.notify.server.data.domain;

public class NotifySendPattern extends NotifySendPatternKey {
    private String pattern;

    private String state;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}