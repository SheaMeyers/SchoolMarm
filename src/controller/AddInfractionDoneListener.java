/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Database.DBAccessor;
import model.Infraction;
import model.Student;
import view.AddInfractionView;
import view.MainFrame;

/**
 * The listener interface for receiving addInfractionDone events.
 * The class that is interested in processing a addInfractionDone
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAddInfractionDoneListener<code> method. When
 * the addInfractionDone event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AddInfractionDoneListener implements ActionListener {

    /** The parent. */
    private AddInfractionView parent;

    /** The student. */
    private Student student;

    /** The frame. */
    private MainFrame frame;

    /**
     * Instantiates a new adds the infraction done listener.
     *
     * @param frame the frame
     * @param parent the parent
     * @param student the student
     */
    public AddInfractionDoneListener(MainFrame frame, AddInfractionView parent, Student student) {
        this.frame = frame;
        this.parent = parent;
        this.student = student;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DBAccessor accessor = new DBAccessor();

        if(accessor.AddInfraction(student.getID(), new Date().toString(), parent.getTitle(), parent.getInfo()))
            student.addInfraction(new Infraction(parent.getTitle(), parent.getInfo(), new Date()));

        frame.showUserView(MainFrame.INFRACTION_VIEW, student, null);
    }

}
