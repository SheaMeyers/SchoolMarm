/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainFrame;

/**
 * The listener interface for receiving attendanceButton events.
 * The class that is interested in processing a attendanceButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAttendanceButtonListener<code> method. When
 * the attendanceButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AttendanceButtonListener implements ActionListener {

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SchoolMarm.main.showUserView(MainFrame.ATTENDANCE_VIEW, null, null);
    }

}
