/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import model.Student;
import view.MainFrame;

/**
 * The listener interface for receiving backButton events.
 * The class that is interested in processing a backButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addBackButtonListener<code> method. When
 * the backButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class BackButtonListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The student. */
    private Student student;

    /** The view to display. */
    private int viewToDisplay;

    /** The date. */
    private Calendar date;

    /**
     * Instantiates a new back button listener.
     *
     * @param frame the frame
     * @param viewToDisplay the view to display
     * @param student the student
     * @param date the date
     */
    public BackButtonListener(MainFrame frame, int viewToDisplay, Student student, Calendar date) {
        this.frame = frame;
        this.viewToDisplay = viewToDisplay;
        this.student = student;
        this.date = date;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.showUserView(viewToDisplay, student, date);
    }

}
