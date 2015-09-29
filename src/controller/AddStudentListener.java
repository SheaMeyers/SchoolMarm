/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.MainFrame;

/**
 * The listener interface for receiving addStudent events.
 * The class that is interested in processing a addStudent
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAddStudentListener<code> method. When
 * the addStudent event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AddStudentListener implements ActionListener {

    /** The add frame. */
    private MainFrame addFrame;

    /**
     * Instantiates a new adds the student listener.
     *
     * @param oldFrame the old frame
     */
    public AddStudentListener(MainFrame oldFrame) {
        addFrame = new MainFrame();
        oldFrame.setVisible(false);
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        addFrame.showUserView(MainFrame.ADD_STUDENT_VIEW, null, null);
        addFrame.setLocation(new Point(SchoolMarm.main.getX() + 700, SchoolMarm.main.getY()));
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
