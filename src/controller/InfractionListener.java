/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Student;

import view.MainFrame;

/**
 * The listener interface for receiving infraction events.
 * The class that is interested in processing a infraction
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addInfractionListener<code> method. When
 * the infraction event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class InfractionListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The student. */
    private Student student;

    /**
     * Instantiates a new infraction listener.
     *
     * @param student the student
     * @param frame the frame
     */
    public InfractionListener(Student student, MainFrame frame) {
        this.frame = frame;
        this.student = student;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.showUserView(MainFrame.INFRACTION_VIEW, student, null);
    }

}
