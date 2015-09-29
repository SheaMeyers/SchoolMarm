/*
 * The Constructors
 * SchoolMarm
 */
package view;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Assignment;

import controller.BackButtonListener;
import controller.EditAssignClickedListener;
import controller.SchoolMarm;

/**
 * The Class EditAssignmentView.
 *
 */
public class EditAssignmentView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The drop down. */
    protected JComboBox dropDown;

    /**
     * Instantiates a new edits the assignment view.
     *
     * @param frame the frame
     */
    public EditAssignmentView(MainFrame frame) {
        String[] assignmentNames = new String[SchoolMarm.assignments.size()];

        for(int i = 0; i < assignmentNames.length; i++) {
            assignmentNames[i] = SchoolMarm.assignments.get(i).getName();
        }
        
        JButton editButton = new JButton();
        
        if(assignmentNames.length > 0){
        	dropDown = new JComboBox(assignmentNames);
        	add(dropDown);
        	editButton.setText("Edit");
        	editButton.addActionListener(new EditAssignClickedListener(frame, this));
        }else{
        	JLabel noAssignLabel = new JLabel("No Assignments to Edit");
        	add(noAssignLabel);
        	editButton.setText("OK");
        	editButton.addActionListener(new BackButtonListener(frame, MainFrame.ASSIGNMENT_VIEW, null, null));
        }
        add(editButton);
    }

    /**
     * Gets the selected assign.
     *
     * @return the selected assign
     */
    public Assignment getSelectedAssign() {
        return SchoolMarm.assignments.get(dropDown.getSelectedIndex());
    }

}
