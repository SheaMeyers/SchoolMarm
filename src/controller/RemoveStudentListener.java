/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

/**
 * The listener interface for receiving removeStudent events.
 * The class that is interested in processing a removeStudent
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addRemoveStudentListener<code> method. When
 * the removeStudent event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class RemoveStudentListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /**
     * Instantiates a new removes the student listener.
     *
     * @param frame the frame
     */
    public RemoveStudentListener(MainFrame frame) {
        this.frame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.showUserView(MainFrame.REMOVE_STUDENT_VIEW, null, null);
    }

}
