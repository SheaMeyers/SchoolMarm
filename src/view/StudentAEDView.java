/*
 * The Constructors
 * SchoolMarm
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AddStudentListener;
import controller.EditStudentListener;
import controller.RemoveStudentListener;

/**
 * The Class StudentAEDView.
 *
 */
public class StudentAEDView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new student aed view.
     *
     * @param frame the frame
     */
    public StudentAEDView(MainFrame frame) {
        JButton addButton = new JButton("Add Student");
        JButton editButton = new JButton("Edit Student");
        JButton removeButton = new JButton("Remove Student");
        addButton.addActionListener(new AddStudentListener(frame));
        editButton.addActionListener(new EditStudentListener(frame));
        removeButton.addActionListener(new RemoveStudentListener(frame));
        add(addButton);
        add(editButton);
        add(removeButton);
    }

}
