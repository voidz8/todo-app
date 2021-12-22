package nl.novi;

import java.io.Serializable;

public class Todo implements Serializable {
    private String name;
    private Integer estimatedTime;
    //monday 1 - 7 sunday
    private int day;
    private boolean finished;
    private Integer timeSpent;

    public Todo() {
    }

    public Todo(String name, Integer estimatedTime, int day) {
        this.name = name;
        this.estimatedTime = estimatedTime;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }
}
