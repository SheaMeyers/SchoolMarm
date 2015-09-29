/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.io.File;

import controller.EditStudentDoneListener;
import controller.SchoolMarm;

import model.Student;

/**
 * The Class EditStudentInfoView.
 *
 */
public class EditStudentInfoView extends AddStudentView {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new edits the student info view.
     *
     * @param frame the frame
     * @param student the student
     */
    public EditStudentInfoView(MainFrame frame, Student student) {
        super(frame);
        fNameField.setText(student.getFirstName());
        lNameField.setText(student.getLastName());
        String imgPath = SchoolMarm.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "Resources" + File.separator;
        imgPath += student.getImgURL();
        urlField.setText(imgPath);
        momField.setText(student.getGuardian2());
        dadField.setText(student.getGuardian1());
        phoneField.setText(student.getPhoneNumber());
        emailField.setText(student.getEmail());
        addressArea.setText(student.getAddress().replace("<br>", "\n"));
        allergyArea.setText(student.getAllergy().replace("<br>", "\n"));
        String pass = "";

        for(int i = 0; i < student.getPass().length; i++) {
            pass += student.getPass()[i];
        }

        passwordField.setText(pass);
        idField.setText(student.getID());
        fNameField.setEnabled(false);
        lNameField.setEnabled(false);
        idField.setEnabled(false);
        doneButton.setText("Edit");
        doneButton.removeActionListener(doneButton.getActionListeners()[0]);
        doneButton.addActionListener(new EditStudentDoneListener(frame, this, student));
    }

}
