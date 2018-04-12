package com.example.todo;

import com.vaadin.ui.VerticalLayout;
import org.springframework.stereotype.Component;

/**
 * Created by @author OGI aka nOy39
 *
 * @Date 12.04.2018
 * @Time 13:48
 */

@Component
public class TodoList extends VerticalLayout {

    private boolean isReady;
    private String todo;

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
