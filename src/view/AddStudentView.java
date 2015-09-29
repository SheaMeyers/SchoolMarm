/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.AddStudentButtonListener;

/**
 * The Class AddStudentView.
 *
 */
public class AddStudentView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The name field. */
    protected JTextField fNameField;

    /** The l name field. */
    protected JTextField lNameField;

    /** The mom field. */
    protected JTextField momField;

    /** The dad field. */
    protected JTextField dadField;

    /** The phone field. */
    protected JTextField phoneField;

    /** The email field. */
    protected JTextField emailField;

    /** The address area. */
    protected JTextArea addressArea;

    /** The allergy area. */
    protected JTextArea allergyArea;

    /** The password field. */
    protected JTextField passwordField;

    /** The id field. */
    protected JTextField idField;

    /** The url field. */
    protected JTextField urlField;

    /** The done button. */
    protected JButton doneButton;

    /** The error label. */
    private JLabel errorLabel;

    /**
     * Instantiates a new adds the student view.
     *
     * @param frame the frame
     */
    public AddStudentView(MainFrame frame) {
        JLabel urlLabel = new JLabel("Image URL: ");
        JLabel fNameLabel = new JLabel("First Name: ");
        JLabel lNameLabel = new JLabel("Last Name: ");
        JLabel momLabel = new JLabel("Mother: ");
        JLabel dadLabel = new JLabel("Father: ");
        JLabel addressLabel = new JLabel("Address: ");
        JLabel phoneLabel = new JLabel("Phone Number: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel allergyLabel = new JLabel("Allergies: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel idLabel = new JLabel("Student ID: ");
        urlField = new JTextField(20);
        fNameField = new JTextField(20);
        lNameField = new JTextField(20);
        momField = new JTextField(20);
        dadField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        addressArea = new JTextArea(2, 20);
        allergyArea = new JTextArea(2, 20);
        passwordField = new JTextField(20);
        idField = new JTextField(20);
        JPanel urlFieldPanel = new JPanel();
        JPanel fNameFieldPanel = new JPanel();
        JPanel lNameFieldPanel = new JPanel();
        JPanel momFieldPanel = new JPanel();
        JPanel dadFieldPanel = new JPanel();
        JPanel phoneFieldPanel = new JPanel();
        JPanel emailFieldPanel = new JPanel();
        JPanel addressAreaPanel = new JPanel();
        JPanel allergyAreaPanel = new JPanel();
        JPanel passwordFieldPanel = new JPanel();
        JPanel idFieldPanel = new JPanel();
        JPanel urlLabelPanel = new JPanel();
        JPanel fNameLabelPanel = new JPanel();
        JPanel lNameLabelPanel = new JPanel();
        JPanel momLabelPanel = new JPanel();
        JPanel dadLabelPanel = new JPanel();
        JPanel phoneLabelPanel = new JPanel();
        JPanel emailLabelPanel = new JPanel();
        JPanel addressLabelPanel = new JPanel();
        JPanel allergyLabelPanel = new JPanel();
        JPanel passwordLabelPanel = new JPanel();
        JPanel idLabelPanel = new JPanel();
        urlFieldPanel.add(urlField);
        fNameFieldPanel.add(fNameField);
        lNameFieldPanel.add(lNameField);
        dadFieldPanel.add(dadField);
        momFieldPanel.add(momField);
        phoneFieldPanel.add(phoneField);
        emailFieldPanel.add(emailField);
        passwordFieldPanel.add(passwordField);
        idFieldPanel.add(idField);
        JScrollPane addressPane = new JScrollPane(addressArea);
        addressPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        addressAreaPanel.add(addressPane);
        JScrollPane allergyPane = new JScrollPane(allergyArea);
        allergyPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        allergyAreaPanel.add(allergyPane);
        urlLabelPanel.add(urlLabel);
        fNameLabelPanel.add(fNameLabel);
        lNameLabelPanel.add(lNameLabel);
        dadLabelPanel.add(dadLabel);
        momLabelPanel.add(momLabel);
        phoneLabelPanel.add(phoneLabel);
        emailLabelPanel.add(emailLabel);
        addressLabelPanel.add(addressLabel);
        allergyLabelPanel.add(allergyLabel);
        passwordLabelPanel.add(passwordLabel);
        idLabelPanel.add(idLabel);
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        westPanel.setLayout(new GridLayout(11, 0));
        eastPanel.setLayout(new GridLayout(11, 0));
        eastPanel.add(urlFieldPanel);
        eastPanel.add(fNameFieldPanel);
        eastPanel.add(lNameFieldPanel);
        eastPanel.add(idFieldPanel);
        eastPanel.add(passwordFieldPanel);
        eastPanel.add(dadFieldPanel);
        eastPanel.add(momFieldPanel);
        eastPanel.add(phoneFieldPanel);
        eastPanel.add(emailFieldPanel);
        eastPanel.add(addressAreaPanel);
        eastPanel.add(allergyAreaPanel);
        westPanel.add(urlLabelPanel);
        westPanel.add(fNameLabelPanel);
        westPanel.add(lNameLabelPanel);
        westPanel.add(idLabelPanel);
        westPanel.add(passwordLabelPanel);
        westPanel.add(dadLabelPanel);
        westPanel.add(momLabelPanel);
        westPanel.add(phoneLabelPanel);
        westPanel.add(emailLabelPanel);
        westPanel.add(addressLabelPanel);
        westPanel.add(allergyLabelPanel);
        JPanel buttonPanel = new JPanel();
        doneButton = new JButton("Add Student");
        doneButton.addActionListener(new AddStudentButtonListener(this, frame));
        buttonPanel.add(doneButton);
        errorLabel = new JLabel();
        this.setLayout(new BorderLayout());
        this.add(errorLabel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(buttonPanel, BorderLayout.SOUTH);
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
     * Gets the dad.
     *
     * @return the dad
     */
    public String getDad() {
    	if(!dadField.getText().equals(""))
    		return dadField.getText();
    	return "Unknown";
    }

    /**
     * Gets the mom.
     *
     * @return the mom
     */
    public String getMom() {
    	if(!momField.getText().equals(""))
    		return momField.getText();
    	return "Unknown";
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
    	if(!phoneField.getText().equals(""))
    		return phoneField.getText();
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
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
    	String retval = addressArea.getText().replace("\t", "    ");
    	retval = retval.replace("\n", "<br>");
        if(retval.equals(""))
        	return "Unknown";
        return retval;
    }

    /**
     * Gets the allergies.
     *
     * @return the allergies
     */
    public String getAllergies() {
        String retval = allergyArea.getText().replace("\t", "    ");
        retval = retval.replace("\n", "<br>");
        if(retval.equals(""))
        	return "Unknown";
        return retval;
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
     * Gets the pass.
     *
     * @return the pass
     */
    public char[] getPass() {
        char[] password = new char[passwordField.getText().length()];

        for(int i = 0; i < password.length; i++) {
            password[i] = passwordField.getText().charAt(i);
        }
        return password;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getURL() {
    	if(!urlField.getText().equals(""))
    		return urlField.getText();
    	return this.getClass().getResource("/images/generic-face.png").getPath();
    }

    /**
     * Sets the error message.
     *
     * @param message the new error message
     */
    public void setErrorMessage(String message) {
        errorLabel.setText("<html><font color=RED>" + message + "</html>");
    }
}
