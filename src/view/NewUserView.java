/*
 * The Constructors
 * SchoolMarm
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.NewUserListener;

/**
 * The Class NewUserView.
 *
 */
public class NewUserView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The name field. */
    private JTextField fNameField;

    /** The l name field. */
    private JTextField lNameField;

    /** The id field. */
    private JTextField idField;

    /** The add field. */
    private JTextField addField;

    /** The email field. */
    private JTextField emailField;

    /** The phone field. */
    private JTextField phoneField;

    /** The password field. */
    private JTextField passwordField;

    /**
     * Instantiates a new new user view.
     *
     * @param frame the frame
     */
    public NewUserView(MainFrame frame) {
        JLabel idLabel = new JLabel("User ID: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel spaceLabel = new JLabel("<html><br></html>");
        JLabel fNameLabel = new JLabel("First Name: ");
        JLabel lNameLabel = new JLabel("Last Name: ");
        JLabel addLabel = new JLabel("Address: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel phoneLabel = new JLabel("Phone Number: ");
        idField = new JTextField(20);
        passwordField = new JTextField(20);
        fNameField = new JTextField(20);
        lNameField = new JTextField(20);
        addField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        JPanel idPanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel spacePanel = new JPanel();
        JPanel fNamePanel = new JPanel();
        JPanel lNamePanel = new JPanel();
        JPanel addPanel = new JPanel();
        JPanel emailPanel = new JPanel();
        JPanel phonePanel = new JPanel();
        idPanel.add(idLabel);
        idPanel.add(idField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        spacePanel.add(spaceLabel);
        fNamePanel.add(fNameLabel);
        fNamePanel.add(fNameField);
        lNamePanel.add(lNameLabel);
        lNamePanel.add(lNameField);
        addPanel.add(addLabel);
        addPanel.add(addField);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);
        add(idPanel);
        add(passwordPanel);
        add(spacePanel);
        add(fNamePanel);
        add(lNamePanel);
        add(addPanel);
        add(emailPanel);
        add(phonePanel);
        JButton doneButton = new JButton("Done");
        JPanel donePanel = new JPanel();
        donePanel.add(doneButton);
        add(donePanel);
        doneButton.addActionListener(new NewUserListener(frame, this));
    }

    /**
     * Gets the f name.
     *
     * @return the f name
     */
    public String getFName() {
    	if(!fNameField.getText().equals(""))
    		return fNameField.getText();
    	return "Unknown";
    }

    /**
     * Gets the l name.
     *
     * @return the l name
     */
    public String getLName() {
    	if(!lNameField.getText().equals(""))
    		return lNameField.getText();
    	return "Unknown";
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return idField.getText();
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
    	if(!addField.getText().equals(""))
    		return addField.getText();
    	return "Unknown";
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
    	if(!emailField.getText().equals(""))
    		return emailField.getText();
    	return "Unknown";
    }

    /**
     * Gets the phone num.
     *
     * @return the phone num
     */
    public String getPhoneNum() {
    	if(!phoneField.getText().equals(""))
    		return phoneField.getText();
    	return "Unknown";
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
