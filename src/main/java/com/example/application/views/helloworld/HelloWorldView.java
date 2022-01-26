package com.example.application.views.helloworld;

import com.example.application.views.MainLayout;
import com.vaadin.componentfactory.Popup;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public HelloWorldView() {
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);

        Button button = new Button("Push Me");
        button.setId("push-me");

        Popup popup = new Popup();
        popup.setFor(button.getId().orElse(null));
        Div text = new Div();
        text.setText("element 1");
        Div text2 = new Div();
        text2.setText("element 2");
        popup.add(text, text2);

        Div closeOnClickStatus = new Div();
        closeOnClickStatus.setText("Close on click: " + popup.isCloseOnClick());

        Div eventStatus = new Div();
        popup.addPopupOpenChangedEventListener(event -> {
            if (event.isOpened())
                eventStatus.setText("Popup opened");
            else
                eventStatus.setText("Popup closed");
        });


        add(button, popup, closeOnClickStatus, eventStatus);
    }

}
