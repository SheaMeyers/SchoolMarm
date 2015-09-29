/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.util.Calendar;
import javax.swing.*;
import controller.Login;
import model.Person;
import model.Student;

/**
 * The Class MainFrame.
 *
 */
public class MainFrame extends JFrame {

    /** The Constant STUDENT_VIEW. */
    public static final int STUDENT_VIEW = 0;

    /** The Constant TEACHER_VIEW. */
    public static final int TEACHER_VIEW = 1;

    /** The Constant PRINCIPAL_VIEW. */
    public static final int PRINCIPAL_VIEW = 2;

    /** The Constant CALENDAR_VIEW. */
    public static final int CALENDAR_VIEW = 3;

    /** The Constant DAY_VIEW. */
    public static final int DAY_VIEW = 4;

    /** The Constant ATTENDANCE_VIEW. */
    public static final int ATTENDANCE_VIEW = 5;

    /** The Constant GRADES_VIEW. */
    public static final int GRADES_VIEW = 6;

    /** The Constant OPTIONS_VIEW. */
    public static final int OPTIONS_VIEW = 7;

    /** The Constant STUDENT_GRADES_VIEW. */
    public static final int STUDENT_GRADES_VIEW = 8;

    /** The Constant TEACHER_GRADES_VIEW. */
    public static final int TEACHER_GRADES_VIEW = 9;

    /** The Constant INFRACTION_VIEW. */
    public static final int INFRACTION_VIEW = 10;

    /** The Constant ADD_INFRACTION_VIEW. */
    public static final int ADD_INFRACTION_VIEW = 11;

    /** The Constant CALENDAR_DAY_VIEW. */
    public static final int CALENDAR_DAY_VIEW = 12;

    /** The Constant ADD_STUDENT_VIEW. */
    public static final int ADD_STUDENT_VIEW = 13;

    /** The Constant ADD_ASSIGNMENT_VIEW. */
    public static final int ADD_ASSIGNMENT_VIEW = 14;

    /** The Constant EDIT_ASSIGN_VIEW. */
    public static final int EDIT_ASSIGN_VIEW = 15;

    /** The Constant ASSIGNMENT_VIEW. */
    public static final int ASSIGNMENT_VIEW = 16;

    /** The Constant STUDENT_AED_VIEW. */
    public static final int STUDENT_AED_VIEW = 17;

    /** The Constant EDIT_STUDENT_VIEW. */
    public static final int EDIT_STUDENT_VIEW = 18;

    /** The Constant REMOVE_STUDENT_VIEW. */
    public static final int REMOVE_STUDENT_VIEW = 19;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The user. */
    public static Person user;

    /** The current panel. */
    private JPanel currentPanel;

    /**
     * Instantiates a new main frame.
     */
    public MainFrame() {
        LoginView loginView = new LoginView(this);
        currentPanel = loginView;
        this.add(loginView);
        this.setResizable(false);
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Show user view.
     *
     * @param viewToShow the view to show
     * @param student the student
     * @param date the date
     */
    public void showUserView(int viewToShow, Student student, Calendar date) {
        switch(viewToShow) {
            case STUDENT_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                StudentView studentView = new StudentView(student, this);
                this.add(studentView);
                currentPanel = studentView;
                this.setSize(400, 650);

                if(user.getUserLevel() == Login.STUDENT) {
                    this.setLocationRelativeTo(null);
                }

                this.validate();
                this.setVisible(true);
                break;

            case TEACHER_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                TeacherView teacherView = new TeacherView();
                this.add(teacherView);
                currentPanel = teacherView;
                this.setSize(700, 650);
                setLocationRelativeTo(null);
                this.validate();
                this.setVisible(true);
                break;

            case PRINCIPAL_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                //For the time being, the teacherView and principalView are the same
                //so I am simply using teacherView Here
                TeacherView principalView = new TeacherView();
                this.add(principalView);
                currentPanel = principalView;
                this.setSize(700, 650);
                setLocationRelativeTo(null);
                this.validate();
                this.setVisible(true);
                break;

            case STUDENT_GRADES_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                StudentGradesView studentGradesView = new StudentGradesView(student);
                this.add(studentGradesView);
                currentPanel = studentGradesView;
                this.validate();
                this.setVisible(true);
                break;

            case TEACHER_GRADES_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                TeacherGradesView teacherGradesView = new TeacherGradesView(student, this);
                this.add(teacherGradesView);
                currentPanel = teacherGradesView;
                this.validate();
                this.setVisible(true);
                break;

            case INFRACTION_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                InfractionView teacherInfractionView = new InfractionView(student, this);
                this.add(teacherInfractionView);
                currentPanel = teacherInfractionView;
                this.validate();
                this.setVisible(true);
                break;

            case ADD_INFRACTION_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                AddInfractionView addInfractionView = new AddInfractionView(student, this);
                this.add(addInfractionView);
                currentPanel = addInfractionView;
                this.validate();
                this.setVisible(true);
                break;

            case ATTENDANCE_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                AttendanceView attendanceView = new AttendanceView();
                this.add(attendanceView);
                currentPanel = attendanceView;
                this.validate();
                this.setVisible(true);
                break;

            case CALENDAR_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                CalendarView calendarView = new CalendarView(date);
                this.add(calendarView);
                currentPanel = calendarView;
                this.validate();
                this.setVisible(true);
                break;

            case CALENDAR_DAY_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                CalendarDayView calendarDayView = new CalendarDayView(date);
                this.add(calendarDayView);
                currentPanel = calendarDayView;
                this.validate();
                this.setVisible(true);
                break;

            case GRADES_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                GradesView gradesView = new GradesView();
                this.add(gradesView);
                currentPanel = gradesView;
                this.validate();
                this.setVisible(true);
                break;

            case OPTIONS_VIEW:
                MainFrame optionsFrame = new MainFrame();
                optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                OptionsView optionsView = new OptionsView(this, optionsFrame);
                optionsFrame.add(optionsView);
                optionsFrame.setSize(300, 150);
                optionsFrame.setVisible(true);
                break;

            case ADD_STUDENT_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                AddStudentView addStudentView = new AddStudentView(this);
                this.add(addStudentView);
                currentPanel = addStudentView;
                this.setSize(400, 650);
                this.validate();
                this.setVisible(true);
                break;

            case ADD_ASSIGNMENT_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                AddAssignmentView addAssignmentView = new AddAssignmentView(this);
                this.add(addAssignmentView);
                currentPanel = addAssignmentView;
                this.setSize(300, 175);
                this.validate();
                this.setVisible(true);
                break;

            case EDIT_ASSIGN_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                EditAssignmentView editAssignmentView = new EditAssignmentView(this);
                this.add(editAssignmentView);
                currentPanel = editAssignmentView;
                this.setSize(300, 75);
                this.validate();
                this.setVisible(true);
                break;

            case ASSIGNMENT_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                AssignmentView assignmentView = new AssignmentView(this);
                this.add(assignmentView);
                currentPanel = assignmentView;
                this.setSize(300, 75);
                this.validate();
                this.setVisible(true);
                break;

            case STUDENT_AED_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                StudentAEDView studentAEDView = new StudentAEDView(this);
                this.add(studentAEDView);
                currentPanel = studentAEDView;
                this.setSize(150, 150);
                this.validate();
                this.setVisible(true);
                break;

            case EDIT_STUDENT_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                EditStudentView editStudentView = new EditStudentView(this);
                this.add(editStudentView);
                currentPanel = editStudentView;
                this.setSize(300, 75);
                this.validate();
                this.setVisible(true);
                break;

            case REMOVE_STUDENT_VIEW:
                this.setVisible(false);
                this.remove(currentPanel);
                this.validate();
                RemoveStudentView removeStudentView = new RemoveStudentView(this);
                this.add(removeStudentView);
                currentPanel = removeStudentView;
                this.setSize(300, 75);
                this.validate();
                this.setVisible(true);
                break;
        }
    }

    /**
     * Removes the current panel.
     */
    public void removeCurrentPanel() {
        this.remove(currentPanel);
    }

    /**
     * Sets the current panel.
     *
     * @param panel the new current panel
     */
    public void setCurrentPanel(JPanel panel) {
        currentPanel = panel;
    }

}
