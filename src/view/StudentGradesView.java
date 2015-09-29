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

import controller.BackButtonListener;
import controller.SchoolMarm;
import model.Student;

/**
 * The Class StudentGradesView.
 *
 */
public class StudentGradesView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The assignment labels. */
    JLabel[] assignmentLabels;

    /** The grade labels. */
    JLabel[] gradeLabels;

    /* I will need a method to get an array of assignment names,
     * and an array of grades for a given student id from the
     * database.
     */
    /**
     * Instantiates a new student grades view.
     *
     * @param student the student
     */
    public StudentGradesView(Student student) {
        assignmentLabels = new JLabel[student.getNumGrades()];
        gradeLabels = new JLabel[student.getNumGrades()];
        JPanel assignmentsPanel = new JPanel();
        JPanel gradesPanel = new JPanel();
        JPanel gradePanels[] = new JPanel[gradeLabels.length];
        JPanel labelPanels[] = new JPanel[assignmentLabels.length];
        JPanel backPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backPanel.add(backButton);
        assignmentsPanel.setLayout(new BoxLayout(assignmentsPanel, BoxLayout.PAGE_AXIS));
        gradesPanel.setLayout(new BoxLayout(gradesPanel, BoxLayout.PAGE_AXIS));

        for(int i = 0; i < student.getNumGrades(); i++) {
            assignmentLabels[i] = new JLabel(student.getGrade(i).getAssignment().getName());
            labelPanels[i] = new JPanel();
            labelPanels[i].add(assignmentLabels[i]);
            assignmentsPanel.add(labelPanels[i]);
            gradeLabels[i] = new JLabel(student.getGrade(i).getGrade());
            gradePanels[i] = new JPanel();
            gradePanels[i].add(gradeLabels[i]);
            gradesPanel.add(gradePanels[i]);
        }

        BackButtonListener bbl = new BackButtonListener(SchoolMarm.main, MainFrame.STUDENT_VIEW, student, null);
        backButton.addActionListener(bbl);
        this.setLayout(new BorderLayout());
        this.add(assignmentsPanel, BorderLayout.WEST);
        this.add(gradesPanel, BorderLayout.EAST);
        this.add(backPanel, BorderLayout.SOUTH);
    }
}
