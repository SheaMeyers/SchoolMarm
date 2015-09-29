/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Database.DBAccessor;

import view.MainFrame;

/**
 * The listener interface for receiving attendanceDoneButton events.
 * The class that is interested in processing a attendanceDoneButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAttendanceDoneButtonListener<code> method. When
 * the attendanceDoneButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AttendanceDoneButtonListener implements ActionListener {

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DBAccessor accessor = new DBAccessor();

        for(int index = 0; index < SchoolMarm.students.size(); index++) {
            accessor.RecordAttendance(SchoolMarm.students.get(index).getID(), SchoolMarm.students.get(index).getAttendance());
        }

        for(int i = 0; i < SchoolMarm.seats.size(); i++) {
            ActionListener[] listeners = SchoolMarm.seats.get(i).getActionListeners();

            for(int j = 0; j < listeners.length; j++) {
                SchoolMarm.seats.get(i).removeActionListener(listeners[j]);
            }

            SchoolMarm.seats.get(i).addActionListener(SchoolMarm.seatListeners.get(i));
            SchoolMarm.seats.get(i).setBackground(null);
        }

        SchoolMarm.main.showUserView(MainFrame.TEACHER_VIEW, null, null);
    }
}
