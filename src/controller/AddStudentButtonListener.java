/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import Database.DBAccessor;
import model.Student;
import view.AddStudentView;
import view.MainFrame;

/**
 * The listener interface for receiving addStudentButton events.
 * The class that is interested in processing a addStudentButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAddStudentButtonListener<code> method. When
 * the addStudentButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AddStudentButtonListener implements ActionListener {

    /** The parent. */
    private AddStudentView parent;

    /** The frame. */
    private MainFrame frame;

    /**
     * Instantiates a new adds the student button listener.
     *
     * @param parent the parent
     * @param frame the frame
     */
    public AddStudentButtonListener(AddStudentView parent, MainFrame frame) {
        this.parent = parent;
        this.frame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File externImgFile = new File(parent.getURL());
            String sysImgURL = SchoolMarm.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "Resources" + File.separator + parent.getID() + ".jpg";
            File studentImgFile = new File(sysImgURL);

            if(!studentImgFile.exists()) {
                studentImgFile.createNewFile();
            }
            
            FileChannel in = new FileInputStream(externImgFile).getChannel();
            FileChannel out = new FileOutputStream(studentImgFile).getChannel();
            out.transferFrom(in, 0, in.size());
            in.close();
            out.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        DBAccessor accessor = new DBAccessor();
        String pass = "";

        for(int i = 0; i < parent.getPass().length; i++) {
            pass = pass + parent.getPass()[i];
        }

        if(accessor.AddPerson(parent.getID(), parent.getFName(), parent.getLName(),
                              parent.getDad(), parent.getMom(), parent.getAddress(), parent.getEmail(), parent.getAllergies(),
                              parent.getPhone(), -1, pass, 0, parent.getID() + ".jpg")) {
            SchoolMarm.students.add(new Student(parent.getFName(), parent.getLName(), parent.getID(), parent.getAddress(), parent.getEmail(), parent.getPhone(), parent.getPass(), parent.getDad(), parent.getMom(), parent.getAllergies(), parent.getID() + ".jpg"));
            frame.setVisible(false);
        } else {
            parent.setErrorMessage("One of the values is not proper");
        }
    }

}
