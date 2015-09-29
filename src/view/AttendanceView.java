/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.Color;
import controller.AttendanceClickListener;
import controller.AttendanceDoneButtonListener;
import controller.SchoolMarm;

/**
 * The Class AttendanceView.
 *
 */
public class AttendanceView extends TeacherView {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new attendance view.
     */
    public AttendanceView() {
        super();
        calendarButton.setEnabled(false);
        gradeButton.setEnabled(false);
        optionsButton.setEnabled(false);
        addStudentButton.setEnabled(false);
        addAssignmentButton.setEnabled(false);
        attendanceButton.setText("Done");
        attendanceButton.removeActionListener(abl);

        /* This needs to be implemented.
         * it should actually be a method which will take the attendance data
         * which is saved in the boolean array with a true corresponding to
         * a student being present, and false corresponding to absent.
         * And then save that data in the database, by getting the value student.getAttendance() and associating it with
         * the date. (Date date = new Date() will provide the current date and time);
         *
         * This means the Student class will require a boolean field called attendance
         * and methods to get and set it.  I am implementing those very basically
         * but set should save to database when called.
         */

        for(int i = 0; i < SchoolMarm.seats.size(); i++) {
            SchoolMarm.seats.get(i).removeActionListener(SchoolMarm.seatListeners.get(i));
        }

        AttendanceDoneButtonListener adbl = new AttendanceDoneButtonListener();
        attendanceButton.addActionListener(adbl);

        for(int i = 0; i < SchoolMarm.students.size(); i++) {
            if(SchoolMarm.students.get(i).getSeat() >= 0) {
                if(SchoolMarm.students.get(i).getAttendance())
                    SchoolMarm.seats.get(SchoolMarm.students.get(i).getSeat()).setBackground(Color.GREEN);
                else
                    SchoolMarm.seats.get(SchoolMarm.students.get(i).getSeat()).setBackground(Color.RED);

                SchoolMarm.seats.get(SchoolMarm.students.get(i).getSeat()).addActionListener(new AttendanceClickListener(SchoolMarm.seats.get(SchoolMarm.students.get(i).getSeat())));
            }
        }
    }
}
