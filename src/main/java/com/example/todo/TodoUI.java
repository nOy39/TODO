package com.example.todo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.DateTimeResolution;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Created by @author OGI aka nOy39
 *
 * @Date 12.04.2018
 * @Time 13:40
 */
@SpringUI
@Theme("valo")
public class TodoUI extends UI {

    private VerticalLayout layout;

    @Autowired
    TodoList todoList;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        addTodoList();
        addActionButton();
 //       addCalendar();
        
    }

    private void addActionButton() {
        Button deleteButton = new Button("Delete completed");
        deleteButton.setIcon(FontAwesome.RECYCLE);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
        layout.addComponent(deleteButton);
    }

    private void addTodoList() {
        todoList.setWidth("80%");
        layout.addComponent(todoList);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setSpacing(true);
        formLayout.setWidth("80%");

        TextField taskField = new TextField();
        taskField.setWidth("100%");

        DateTimeField sample;
        sample = new DateTimeField();
        sample.setValue(LocalDateTime.now());
        sample.addValueChangeListener(event -> Notification.show("Value changed:",
                String.valueOf(event.getValue()),
                Notification.Type.TRAY_NOTIFICATION));

        Button addButton = new Button("Add");
        addButton.setIcon(FontAwesome.PLUS);
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        addButton.addClickListener(e-> {
            System.out.println(taskField.getValue());
            todoList.setTodo(taskField.getValue());
        });

        formLayout.addComponents(taskField,sample,addButton);
        formLayout.setExpandRatio(taskField,1);
        layout.addComponent(formLayout);
    }

    private void addHeader() {
        Label header = new Label("TODO");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.addStyleName(ValoTheme.LABEL_HUGE);
        header.setSizeUndefined();
        layout.addComponent(header);
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        setContent(layout);
    }
}
