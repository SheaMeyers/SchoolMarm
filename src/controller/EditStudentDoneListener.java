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
import model.Student;
import view.AddStudentView;
import view.MainFrame;
import Database.DBAccessor;

/**
 * The listener interface for receiving editStudentDone events.
 * The class that is interested in processing a editStudentDone
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEditStudentDoneListener<code> method. When
 * the editStudentDone event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class EditStudentDoneListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private AddStudentView parent;

    /** The old student. */
    private Student oldStudent;

    /**
     * Instantiates a new edits the student done listener.
     *
     * @param frame the frame
     * @param parent the parent
     * @param oldStudent the old student
     */
    public EditStudentDoneListener(MainFrame frame, AddStudentView parent, Student oldStudent) {
        this.frame = frame;
        this.parent = parent;
        this.oldStudent = oldStudent;
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

        int index = SchoolMarm.students.indexOf(oldStudent);

        if(accessor.updatePerson(parent.getID(), parent.getFName(), parent.getLName(),
                                 parent.getDad(), parent.getMom(), parent.getAddress(), parent.getEmail(), parent.getAllergies(),
                                 parent.getPhone(), pass, parent.getID() + ".jpg")) {
            SchoolMarm.students.get(index).updateStudent(parent.getAddress(), parent.getEmail(), parent.getPhone(), parent.getPass(), parent.getDad(), parent.getMom(), parent.getAllergies(), parent.getID() + ".jpg");
            SchoolMarm.seats.get(SchoolMarm.students.get(index).getSeat()).assign(SchoolMarm.students.get(index));
            frame.setVisible(false);
        }
    }

}
