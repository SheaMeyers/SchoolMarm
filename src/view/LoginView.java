/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;

import javax.swing.*;

import controller.LoginListener;

/**
 * The Class LoginView.
 *
 */
public class LoginView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id field. */
    private JTextField idField;

    /** The pw field. */
    private JPasswordField pwField;

    /** The error label. */
    private JLabel errorLabel;

    /** The login button. */
    protected JButton loginButton;

    /**
     * Instantiates a new login view.
     *
     * @param main the main
     */
    public LoginView(MainFrame main) {
        JLabel idLabel = new JLabel("User ID:");
        JLabel pwLabel = new JLabel("Password:");
        loginButton = new JButton("Login");
        idField = new JTextField(15);
        pwField = new JPasswordField(15);
        errorLabel = new JLabel("");
        JPanel errorPanel = new JPanel();
        errorPanel.add(errorLabel);
        JPanel labelPanel = new JPanel();
        JPanel fieldPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel pwFieldPanel = new JPanel();
        JPanel idFieldPanel = new JPanel();
        JPanel pwLabelPanel = new JPanel();
        JPanel idLabelPanel = new JPanel();
        idLabelPanel.add(idLabel);
        pwLabelPanel.add(pwLabel);
        idFieldPanel.add(idField);
        pwFieldPanel.add(pwField);
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.PAGE_AXIS));
        fieldPanel.add(Box.createVerticalGlue());
        fieldPanel.add(idFieldPanel);
        fieldPanel.add(Box.createVerticalGlue());
        fieldPanel.add(pwFieldPanel);
        fieldPanel.add(Box.createVerticalGlue());
        labelPanel.add(Box.createVerticalGlue());
        labelPanel.add(idLabelPanel);
        labelPanel.add(Box.createVerticalGlue());
        labelPanel.add(pwLabelPanel);
        labelPanel.add(Box.createVerticalGlue());
        buttonPanel.add(loginButton);
        this.setLayout(new BorderLayout());
        this.add(errorPanel, BorderLayout.NORTH);
        this.add(labelPanel, BorderLayout.WEST);
        this.add(fieldPanel, BorderLayout.EAST);
        this.add(buttonPanel, BorderLayout.SOUTH);
        LoginListener ll = new LoginListener(this);
        loginButton.addActionListener(ll);
        pwField.addActionListener(ll);
        idField.addActionListener(ll);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getID() {
        return idField.getText();
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public char[] getPassword() {
        return pwField.getPassword();
    }

    /**
     * Sets the error message.
     *
     * @param message the new error message
     */
    public void setErrorMessage(String message) {
        errorLabel.setText(message);
    }

    /**
     * Clear password field.
     */
    public void clearPasswordField() {
        pwField.setText("");
    }
}
