/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Database.DBAccessor;

import model.Seat;
import model.Student;
import view.AssignSeatView;
import view.MainFrame;

/**
 * The listener interface for receiving assignSeat events.
 * The class that is interested in processing a assignSeat
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAssignSeatListener<code> method. When
 * the assignSeat event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AssignSeatListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The seat. */
    private Seat seat;

    /** The parent. */
    private AssignSeatView parent;

    /**
     * Instantiates a new assign seat listener.
     *
     * @param frame the frame
     * @param seat the seat
     * @param parent the parent
     */
    public AssignSeatListener(MainFrame frame, Seat seat, AssignSeatView parent) {
        this.frame = frame;
        this.seat = seat;
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Student student = parent.getSelectedStudent();
        DBAccessor accessor = new DBAccessor();

        if(accessor.updateSeat(student.getID(), seat.getSeatNum()))
            seat.assign(student);

        frame.setVisible(false);
    }

}
