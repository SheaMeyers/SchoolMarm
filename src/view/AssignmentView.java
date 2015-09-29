/*
 * The Constructors
 * SchoolMarm
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AddAssignmentButtonListener;
import controller.EditAssignmentButtonListener;

/**
 * The Class AssignmentView.
 *
 */
public class AssignmentView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new assignment view.
     *
     * @param frame the frame
     */
    public AssignmentView(MainFrame frame) {
        JButton addButton = new JButton("Add Assignment");
        JButton editButton = new JButton("Edit Assignment");
        addButton.addActionListener(new AddAssignmentButtonListener(frame));
        editButton.addActionListener(new EditAssignmentButtonListener(frame));
        add(addButton);
        add(editButton);
    }

}
