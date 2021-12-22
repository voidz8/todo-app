package nl.novi;

import java.io.Serializable;
import java.util.List;

public class TodoList implements Serializable {
    private String name;
    private int week;
    private List<Todo> todoList;

    public TodoList(String name) {
        this.name = name;
    }

    public TodoList(String name, int week, List<Todo> todoList) {
        this.name = name;
        this.week = week;
        this.todoList = todoList;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
