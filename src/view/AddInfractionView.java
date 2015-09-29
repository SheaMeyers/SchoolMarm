/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.AddInfractionDoneListener;
import controller.BackButtonListener;

import model.Student;

/**
 * The Class AddInfractionView.
 *
 */
public class AddInfractionView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The student. */
    @SuppressWarnings("unused")
    private Student student;

    /** The title field. */
    private JTextField titleField;

    /** The info area. */
    private JTextArea infoArea;

    /**
     * Instantiates a new adds the infraction view.
     *
     * @param student the student
     * @param frame the frame
     */
    public AddInfractionView(Student student, MainFrame frame) {
        this.student = student;
        JLabel titleLabel = new JLabel("Infraction Title: ");
        JLabel infoLabel = new JLabel("Infraction Info: ");
        titleField = new JTextField(25);
        infoArea = new JTextArea();
        JPanel titlePanel = new JPanel();
        JPanel infoPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        infoPanel.setLayout(new BorderLayout());
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        titlePanel.add(titleField, BorderLayout.CENTER);
        infoPanel.add(infoLabel, BorderLayout.NORTH);
        infoPanel.add(infoArea, BorderLayout.CENTER);
        JButton doneButton = new JButton("Done");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(doneButton);
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(new BackButtonListener(frame, MainFrame.INFRACTION_VIEW, student, null));
        /* This listener needs to be implemented.
         * It should take the information from the titleField and infoArea and save it to the database.
         * Referencing "student"
         */
        doneButton.addActionListener(new AddInfractionDoneListener(frame, this, student));
        this.setLayout(new BorderLayout());
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return titleField.getText();
    }

    /**
     * Gets the info.
     *
     * @return the info
     */
    public String getInfo() {
        return infoArea.getText();
    }


}
