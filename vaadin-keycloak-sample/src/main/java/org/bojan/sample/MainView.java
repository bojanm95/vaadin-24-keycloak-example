package org.bojan.sample;

import com.vaadin.flow.component.html.Div;
import org.bojan.sample.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public MainView(@Autowired GreetService service) {

        // Use custom CSS classes to apply styling. This is defined in
        // styles.css.
        addClassName("centered-content");

        Div label = new Div();
        label.setText("User info");

        TextField username = new TextField("username");
        username.setValue(SecurityUtils.getLoggedInUser().getPreferredUsername());
        username.setReadOnly(true);

        TextField id = new TextField("id");
        id.setValue(SecurityUtils.getLoggedInUser().getUserId());
        id.setReadOnly(true);

        TextField email = new TextField("email");
        email.setValue(SecurityUtils.getLoggedInUser().getEmail());
        email.setReadOnly(true);

        TextField firstName = new TextField("first name");
        firstName.setValue(SecurityUtils.getLoggedInUser().getName());
        firstName.setReadOnly(true);

        TextField sessionId = new TextField("session id");
        sessionId.setValue(SecurityUtils.getLoggedInUser().getSessionId());
        sessionId.setReadOnly(true);

        add(label, username, id, email, firstName, sessionId);
    }

}
