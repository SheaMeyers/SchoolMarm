/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

/**
 * The listener interface for receiving editAssignmentButton events.
 * The class that is interested in processing a editAssignmentButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEditAssignmentButtonListener<code> method. When
 * the editAssignmentButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class EditAssignmentButtonListener implements ActionListener {

    /** The frame. */
    MainFrame frame;

    /**
     * Instantiates a new edits the assignment button listener.
     *
     * @param frame the frame
     */
    public EditAssignmentButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.showUserView(MainFrame.EDIT_ASSIGN_VIEW, null, null);
    }

}
