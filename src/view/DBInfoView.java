/*
 * The Constructors
 * SchoolMarm
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DBInfoDoneListener;

/**
 * The Class DBInfoView.
 *
 */
public class DBInfoView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The host field. */
    private JTextField hostField;

    /** The database field. */
    private JTextField databaseField;

    /** The username field. */
    private JTextField usernameField;

    /** The password field. */
    private JTextField passwordField;

    /**
     * Instantiates a new dB info view.
     *
     * @param frame the frame
     */
    public DBInfoView(MainFrame frame) {
        JLabel hostLabel = new JLabel("Host: ");
        JLabel databaseLabel = new JLabel("Database: ");
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        hostField = new JTextField(20);
        databaseField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JTextField(20);
        JPanel hostPanel = new JPanel();
        JPanel databasePanel = new JPanel();
        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        hostPanel.add(hostLabel);
        hostPanel.add(hostField);
        databasePanel.add(databaseLabel);
        databasePanel.add(databaseField);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        add(hostPanel);
        add(databasePanel);
        add(usernamePanel);
        add(passwordPanel);
        JButton doneButton = new JButton("Done");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(doneButton);
        add(buttonPanel);
        doneButton.addActionListener(new DBInfoDoneListener(frame, this));
    }

    /**
     * Gets the host.
     *
     * @return the host
     */
    public String getHost() {
        return hostField.getText();
    }

    /**
     * Gets the database.
     *
     * @return the database
     */
    public String getDatabase() {
        return databaseField.getText();
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return usernameField.getText();
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return passwordField.getText();
    }



}
