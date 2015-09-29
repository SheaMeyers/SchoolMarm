/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Assignment;
import model.Student;
import controller.GradeDoneButtonListener;
import controller.GradeKeyListener;
import controller.SchoolMarm;

/**
 * The Class GradesView.
 *
 */
public class GradesView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The grade fields. */
    private JTextField[][] gradeFields;

    /**
     * Instantiates a new grades view.
     */
    public GradesView() {
        /* Here I need to be able to access the database
         * and get an array of Seat objects, or student
         * Objects.
         *
         * For the time being, it will be hard coded.
         */
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(SchoolMarm.students.size() + 1, SchoolMarm.assignments.size() + 1, 5, 5));
        gradeFields = new JTextField[SchoolMarm.students.size() + 1][SchoolMarm.assignments.size() + 1];
        JPanel[][] fieldPanels = new JPanel[SchoolMarm.students.size() + 1][SchoolMarm.assignments.size() + 1];
        JLabel[] studentLabels = new JLabel[SchoolMarm.students.size() + 1];
        JLabel[] assignmentLabels = new JLabel[SchoolMarm.assignments.size() + 1];

        for(int i = 0; i < SchoolMarm.students.size() + 1; i++) {
            for(int j = 0; j < SchoolMarm.assignments.size() + 1; j++) {
                gradeFields[i][j] = new JTextField(5);
                fieldPanels[i][j] = new JPanel();
                fieldPanels[i][j].add(gradeFields[i][j]);

                if(i == 0) {
                    if(j == 0) {
                        studentLabels[i] = new JLabel("Students: ");
                        mainPanel.add(studentLabels[i]);
                    } else {
                        assignmentLabels[j] = new JLabel(SchoolMarm.assignments.get(j - 1).getName());
                        assignmentLabels[j].setHorizontalAlignment(JLabel.CENTER);
                        mainPanel.add(assignmentLabels[j]);
                    }
                } else if(j == 0) {
                    studentLabels[i] = new JLabel(SchoolMarm.students.get(i - 1).fullName());
                    mainPanel.add(studentLabels[i]);
                } else {
                    gradeFields[i][j].setText(SchoolMarm.students.get(i - 1).getGradeForAssignment(SchoolMarm.assignments.get(j - 1)).getGrade());
                    gradeFields[i][j].addKeyListener(new GradeKeyListener(gradeFields));
                    mainPanel.add(fieldPanels[i][j]);
                }
            }
        }

        JButton doneButton = new JButton("Done");
        JPanel donePanel = new JPanel();
        donePanel.add(doneButton);
        doneButton.addActionListener(new GradeDoneButtonListener(this));
        this.setLayout(new BorderLayout());
        this.add(donePanel, BorderLayout.SOUTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Gets the grade.
     *
     * @param student the student
     * @param assignment the assignment
     * @return A string representation of whatever is in the textfield for a given student and assignment.
     */

    /*
     * This function should be called when the window is closed
     * It should be in a loop which will take this information and store it in the database
     * for each student.
     */
    public String getGrade(Student student, Assignment assignment) {
        int sint = SchoolMarm.students.indexOf(student);
        int aint = SchoolMarm.assignments.indexOf(assignment);
        return gradeFields[sint + 1][aint + 1].getText();
    }
}
