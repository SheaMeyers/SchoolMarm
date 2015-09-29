/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Student;
import controller.BackButtonListener;
import controller.StudentGradesDoneButtonListener;

/**
 * The Class TeacherGradesView.
 *
 */
public class TeacherGradesView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The assignment labels. */
    JLabel[] assignmentLabels;

    /** The grade fields. */
    JTextField[] gradeFields;

    /* I will need a method to get an array of assignment names,
     * and an array of grades for a given student id from the
     * database.
     */
    /**
     * Instantiates a new teacher grades view.
     *
     * @param student the student
     * @param frame the frame
     */
    public TeacherGradesView(Student student, MainFrame frame) {
        assignmentLabels = new JLabel[student.getNumGrades()];
        gradeFields = new JTextField[student.getNumGrades()];
        JPanel assignmentsPanel = new JPanel();
        JPanel gradesPanel = new JPanel();
        JPanel fieldPanels[] = new JPanel[gradeFields.length];
        JPanel labelPanels[] = new JPanel[assignmentLabels.length];
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");
        JButton doneButton = new JButton("Done");
        backPanel.add(doneButton);
        backPanel.add(backButton);
        assignmentsPanel.setLayout(new BoxLayout(assignmentsPanel, BoxLayout.PAGE_AXIS));
        gradesPanel.setLayout(new BoxLayout(gradesPanel, BoxLayout.PAGE_AXIS));

        for(int i = 0; i < student.getNumGrades(); i++) {
            assignmentLabels[i] = new JLabel(student.getGrade(i).getAssignment().getName());
            labelPanels[i] = new JPanel();
            labelPanels[i].add(assignmentLabels[i]);
            assignmentsPanel.add(labelPanels[i]);
            gradeFields[i] = new JTextField(5);
            gradeFields[i].setText(student.getGrade(i).getGrade());
            fieldPanels[i] = new JPanel();
            fieldPanels[i].add(gradeFields[i]);
            gradesPanel.add(fieldPanels[i]);
        }

        BackButtonListener bbl = new BackButtonListener(frame, MainFrame.STUDENT_VIEW, student, null);
        backButton.addActionListener(bbl);
        doneButton.addActionListener(new StudentGradesDoneButtonListener(frame, this, student));
        this.setLayout(new BorderLayout());
        this.add(assignmentsPanel, BorderLayout.WEST);
        this.add(gradesPanel, BorderLayout.EAST);
        this.add(backPanel, BorderLayout.SOUTH);
    }

    /**
     * Gets the assignment.
     *
     * @param i the i
     * @return the assignment
     */
    public String getAssignment(int i) {
        return assignmentLabels[i].getText();
    }

    /**
     * Gets the grade.
     *
     * @param i the i
     * @return the grade
     */
    public String getGrade(int i) {
    	if(!gradeFields[i].getText().equals(""))
    		return gradeFields[i].getText();
    	return "0";
    }
}
