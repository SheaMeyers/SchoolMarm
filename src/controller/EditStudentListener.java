/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.MainFrame;

/**
 * The listener interface for receiving editStudent events.
 * The class that is interested in processing a editStudent
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEditStudentListener<code> method. When
 * the editStudent event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class EditStudentListener implements ActionListener {

    /** The add frame. */
    private MainFrame addFrame;

    /**
     * Instantiates a new edits the student listener.
     *
     * @param frame the frame
     */
    public EditStudentListener(MainFrame frame) {
        addFrame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        addFrame.showUserView(MainFrame.EDIT_STUDENT_VIEW, null, null);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
