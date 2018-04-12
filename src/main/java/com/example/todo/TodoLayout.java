package com.example.todo;

import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by @author OGI aka nOy39
 *
 * @Date 12.04.2018
 * @Time 15:33
 */
public class TodoLayout extends HorizontalLayout {

    private final CheckBox done;
    private final TextField text;

    public TodoLayout(Todo todo, TodoChangeListener changeListener) {
        setWidth("100%");
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        done = new CheckBox();
        text = new TextField();

        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setValueChangeMode(ValueChangeMode.BLUR);

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);

        binder.setBean(todo);

        addComponent(done);
        addComponentsAndExpand(text);

        binder.addValueChangeListener(event -> changeListener.todoChanged(todo));
    }
}
