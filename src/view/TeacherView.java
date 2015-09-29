/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import controller.AssignmentButtonListener;
import controller.AttendanceButtonListener;
import controller.CalendarListener;
import controller.GradeButtonListener;
import controller.OptionsListener;
import controller.SchoolMarm;
import controller.StudentButtonListener;

/**
 * The Class TeacherView.
 *
 */
public class TeacherView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The calendar button. */
    protected JButton calendarButton;

    /** The attendance button. */
    protected JButton attendanceButton;

    /** The grade button. */
    protected JButton gradeButton;

    /** The options button. */
    protected JButton optionsButton;

    /** The add student button. */
    protected JButton addStudentButton;

    /** The add assignment button. */
    protected JButton addAssignmentButton;

    /** The abl. */
    protected AttendanceButtonListener abl;

    /**
     * Instantiates a new teacher view.
     */
    public TeacherView() {
        JPanel buttonPanel = new JPanel();
        JPanel roomPanel = new JPanel();
        calendarButton = new JButton("Calendar");
        attendanceButton = new JButton("Attendance");
        gradeButton = new JButton("Grades");
        optionsButton = new JButton("Options");
        addStudentButton = new JButton("Students");
        addAssignmentButton = new JButton("Assignments");
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(roomPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(0, 6));
        /* These will be the row and column field in the options table
         * in the database, not 5 and 4 as it is hard coded.
         */
        roomPanel.setLayout(new GridLayout(SchoolMarm.rows, SchoolMarm.cols));
        buttonPanel.add(attendanceButton);
        buttonPanel.add(addStudentButton);
        buttonPanel.add(calendarButton);
        buttonPanel.add(gradeButton);
        buttonPanel.add(addAssignmentButton);
        buttonPanel.add(optionsButton);

        for(int i = 0; i < SchoolMarm.seats.size(); i++) {
            roomPanel.add(SchoolMarm.seats.get(i));
        }

        abl = new AttendanceButtonListener();
        attendanceButton.addActionListener(abl);
        CalendarListener cl = new CalendarListener();
        calendarButton.addActionListener(cl);
        GradeButtonListener gbl = new GradeButtonListener();
        gradeButton.addActionListener(gbl);
        OptionsListener ol = new OptionsListener();
        optionsButton.addActionListener(ol);
        StudentButtonListener sbl = new StudentButtonListener();
        addStudentButton.addActionListener(sbl);
        AssignmentButtonListener aal = new AssignmentButtonListener();
        addAssignmentButton.addActionListener(aal);
    }

}
