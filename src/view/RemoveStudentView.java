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
import controller.RemoveStudentClickedListener;
import controller.SchoolMarm;

/**
 * The Class RemoveStudentView.
 *
 */
public class RemoveStudentView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The drop down. */
    protected JComboBox dropDown;

    /**
     * Instantiates a new removes the student view.
     *
     * @param frame the frame
     */
    public RemoveStudentView(MainFrame frame) {
        String[] studentNames = new String[SchoolMarm.students.size()];

        for(int i = 0; i < studentNames.length; i++) {
            studentNames[i] = SchoolMarm.students.get(i).fullName();
        }

        JButton removeButton = new JButton();
        
        if(studentNames.length > 0){
        	dropDown = new JComboBox(studentNames);
        	add(dropDown);
        	removeButton.setText("Remove");
        	removeButton.addActionListener(new RemoveStudentClickedListener(frame, this));
        }else{
        	JLabel noAssignLabel = new JLabel("No Students to Remove");
        	add(noAssignLabel);
        	removeButton.setText("OK");
        	removeButton.addActionListener(new BackButtonListener(frame, MainFrame.STUDENT_AED_VIEW, null, null));
        }
        add(removeButton);
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
