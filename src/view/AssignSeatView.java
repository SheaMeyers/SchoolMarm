/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.AssignSeatListener;
import controller.SchoolMarm;

import model.Seat;
import model.Student;

/**
 * The Class AssignSeatView.
 *
 */
public class AssignSeatView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The student drop down. */
    private JComboBox studentDropDown;

    /**
     * Instantiates a new assign seat view.
     *
     * @param frame the frame
     * @param seat the seat
     */
    public AssignSeatView(MainFrame frame, Seat seat) {
    	
    	final MainFrame thisFrame = frame;
    	
        String[] nameList = new String[SchoolMarm.students.size()];

        for(int i = 0; i < nameList.length; i++) {
            nameList[i] = SchoolMarm.students.get(i).fullName();
        }
        
        JButton addButton = new JButton();
        
        if(nameList.length > 0){
        	studentDropDown = new JComboBox(nameList);
        	add(studentDropDown);
        	addButton.setText("Assign");
        	addButton.addActionListener(new AssignSeatListener(frame, seat, this));
        }else{
        	JLabel noAssignLabel = new JLabel("No Students to Seat");
        	add(noAssignLabel);
        	addButton.setText("OK");
        	addButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					thisFrame.setVisible(false);
				}
        	});
        }
        add(addButton);
        frame.setSize(300, 75);
    }

    /**
     * Gets the selected student.
     *
     * @return the selected student
     */
    public Student getSelectedStudent() {
        return SchoolMarm.students.get(studentDropDown.getSelectedIndex());
    }
}
