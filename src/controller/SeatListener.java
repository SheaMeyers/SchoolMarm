/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.AssignSeatView;
import view.MainFrame;
import model.Seat;

/**
 * The listener interface for receiving seat events.
 * The class that is interested in processing a seat
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addSeatListener<code> method. When
 * the seat event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class SeatListener implements ActionListener {

    /** The student frame. */
    private MainFrame studentFrame;

    /** The seat. */
    private Seat seat;

    /**
     * Instantiates a new seat listener.
     *
     * @param seat the seat
     */
    public SeatListener(Seat seat) {
        this.seat = seat;
        this.studentFrame = new MainFrame();
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(seat.getStudent() == null) {
            studentFrame.setVisible(false);
            studentFrame.removeCurrentPanel();
            studentFrame.validate();
            AssignSeatView assignSeatView = new AssignSeatView(studentFrame, seat);
            studentFrame.add(assignSeatView);
            studentFrame.setCurrentPanel(assignSeatView);
            studentFrame.validate();
            studentFrame.setVisible(true);
        } else {
            studentFrame.showUserView(MainFrame.STUDENT_VIEW, seat.getStudent(), null);
            studentFrame.setLocation(new Point(SchoolMarm.main.getX() + 700, SchoolMarm.main.getY()));
        }

        studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
