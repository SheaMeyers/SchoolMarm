/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Seat;

/**
 * The listener interface for receiving attendanceClick events.
 * The class that is interested in processing a attendanceClick
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAttendanceClickListener<code> method. When
 * the attendanceClick event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AttendanceClickListener implements ActionListener {

    /** The seat. */
    private Seat seat;

    /**
     * Instantiates a new attendance click listener.
     *
     * @param seat the seat
     */
    public AttendanceClickListener(Seat seat) {
        this.seat = seat;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(seat.getStudent().getAttendance()) {
            seat.setBackground(Color.RED);
            seat.getStudent().setAttendance(false);
        } else {
            seat.setBackground(Color.GREEN);
            seat.getStudent().setAttendance(true);
        }
    }

}
