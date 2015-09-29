/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

/**
 * The listener interface for receiving addAssignmentButton events.
 * The class that is interested in processing a addAssignmentButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAddAssignmentButtonListener<code> method. When
 * the addAssignmentButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AddAssignmentButtonListener implements ActionListener {

    /** The add frame. */
    MainFrame addFrame;

    /**
     * Instantiates a new adds the assignment button listener.
     *
     * @param addFrame the add frame
     */
    public AddAssignmentButtonListener(MainFrame addFrame) {
        this.addFrame = addFrame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        addFrame.showUserView(MainFrame.ADD_ASSIGNMENT_VIEW, null, null);
    }

}
