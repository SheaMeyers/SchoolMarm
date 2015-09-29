/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AddAssignmentDoneButtonListener;

/**
 * The Class AddAssignmentView.
 *
 */
public class AddAssignmentView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The name field. */
    protected JTextField nameField;

    /** The start date field. */
    protected JTextField startDateField;

    /** The due date field. */
    protected JTextField dueDateField;

    /** The done button. */
    protected JButton doneButton;


    /**
     * Instantiates a new adds the assignment view.
     *
     * @param frame the frame
     */
    public AddAssignmentView(MainFrame frame) {
        nameField = new JTextField(15);
        startDateField = new JTextField(15);
        dueDateField = new JTextField(15);
        JLabel nameLabel = new JLabel("Assignment Name: ");
        JLabel startDateLabel = new JLabel("Assigned: ");
        JLabel dueDateLabel = new JLabel("Due Date: ");
        doneButton = new JButton("Done");
        JPanel namePanel = new JPanel();
        JPanel startPanel = new JPanel();
        JPanel duePanel = new JPanel();
        setLayout(new GridLayout(4, 1));
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        startPanel.add(startDateLabel);
        startPanel.add(startDateField);
        duePanel.add(dueDateLabel);
        duePanel.add(dueDateField);
        add(namePanel);
        add(startPanel);
        add(duePanel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(doneButton);
        doneButton.addActionListener(new AddAssignmentDoneButtonListener(frame, this));
        add(buttonPanel);
    }

    /* (non-Javadoc)
     * @see java.awt.Component#getName()
     */
    public String getName() {
        return nameField.getText();
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public String getStartDate() {
        return startDateField.getText();
    }

    /**
     * Gets the due date.
     *
     * @return the due date
     */
    public String getDueDate() {
    	if(!dueDateField.getText().equals(""))
    		return dueDateField.getText();
    	return startDateField.getText();
    }

}
