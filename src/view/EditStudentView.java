/*
 * The Constructors
 * SchoolMarm
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Student;
import controller.BackButtonListener;
import controller.EditStudentClickedListener;
import controller.SchoolMarm;

/**
 * The Class EditStudentView.
 *
 */
public class EditStudentView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The drop down. */
    protected JComboBox dropDown;

    /**
     * Instantiates a new edits the student view.
     *
     * @param frame the frame
     */
    public EditStudentView(MainFrame frame) {
        String[] studentNames = new String[SchoolMarm.students.size()];

        for(int i = 0; i < studentNames.length; i++) {
            studentNames[i] = SchoolMarm.students.get(i).fullName();
        }

        JButton editButton = new JButton();
        
        if(studentNames.length > 0){
        	dropDown = new JComboBox(studentNames);
        	add(dropDown);
        	editButton.setText("Edit");
        	editButton.addActionListener(new EditStudentClickedListener(frame, this));
        }else{
        	JLabel noAssignLabel = new JLabel("No Students to Edit");
        	add(noAssignLabel);
        	editButton.setText("OK");
        	editButton.addActionListener(new BackButtonListener(frame, MainFrame.STUDENT_AED_VIEW, null, null));
        }
        add(editButton);
    }

    /**
     * Gets the selected student.
     *
     * @return the selected student
     */
    public Student getSelectedStudent() {
        return SchoolMarm.students.get(dropDown.getSelectedIndex());
    }



}
