/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainFrame;
import model.*;

/**
 * The listener interface for receiving addInfraction events.
 * The class that is interested in processing a addInfraction
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAddInfractionListener<code> method. When
 * the addInfraction event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AddInfractionListener implements ActionListener {

    /** The student. */
    private Student student;

    /** The frame. */
    private MainFrame frame;

    /**
     * Instantiates a new adds the infraction listener.
     *
     * @param student the student
     * @param frame the frame
     */
    public AddInfractionListener(Student student, MainFrame frame) {
        this.student = student;
        this.frame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.showUserView(MainFrame.ADD_INFRACTION_VIEW, student, null);
    }


}
