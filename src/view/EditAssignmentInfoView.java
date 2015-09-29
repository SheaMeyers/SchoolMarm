/*
 * The Constructors
 * SchoolMarm
 */
package view;

import controller.EditAssignDoneListener;
import model.Assignment;

/**
 * The Class EditAssignmentInfoView.
 *
 */
public class EditAssignmentInfoView extends AddAssignmentView {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new edits the assignment info view.
     *
     * @param frame the frame
     * @param assignment the assignment
     */
    public EditAssignmentInfoView(MainFrame frame, Assignment assignment) {
        super(frame);
        nameField.setText(assignment.getName());
        nameField.setEnabled(false);
        startDateField.setText(assignment.getAssignedDate());
        startDateField.setEnabled(false);
        dueDateField.setText(assignment.getDueDate());
        doneButton.removeActionListener(doneButton.getActionListeners()[0]);
        doneButton.addActionListener(new EditAssignDoneListener(frame, this, assignment));
    }

}
