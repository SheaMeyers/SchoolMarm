/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import model.Principal;
import model.Student;
import model.Teacher;
import view.LoginView;
import view.MainFrame;
import Database.DBAccessor;

/**
 * The listener interface for receiving login events.
 * The class that is interested in processing a login
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addLoginListener<code> method. When
 * the login event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class LoginListener implements Login {

    /** The parent. */
    private LoginView parent;

    /**
     * Instantiates a new login listener.
     *
     * @param parent the parent
     */
    public LoginListener(LoginView parent) {
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        String idString = parent.getID();
        char[] pwString = parent.getPassword();
        DBAccessor accessor = new DBAccessor();
        String password = "";

        for(int i = 0; i < pwString.length; i++) {
            password += pwString[i];
        }

        String result = accessor.Login(idString, password);

        if(result == null) {
            parent.setErrorMessage("<html><font color=RED>Invalid User ID or Password, Please Try Again</font></html>");
            parent.clearPasswordField();
        } else {
            StringTokenizer info = new StringTokenizer(result, "\t");
            int index = 0;
            String[] data = new String[info.countTokens()];

            while(info.hasMoreTokens()) {
                data[index] = info.nextToken();
                index++;
            }

            char[] passwordString = data[10].toCharArray();

            switch(Integer.parseInt(data[11])) {
                case 0:
                    Student newStudent = null;

                    for(int i = 0; i < SchoolMarm.students.size(); i++) {
                        if(SchoolMarm.students.get(i).getID().equals(data[0]))
                            newStudent = SchoolMarm.students.get(i);
                    }

                    MainFrame.user = newStudent;
                    SchoolMarm.main.showUserView(MainFrame.STUDENT_VIEW, (Student)MainFrame.user, null);
                    break;

                case 1: //student
                    if(SchoolMarm.rows == 0 || SchoolMarm.cols == 0) {
                        Teacher newTeacher = new Teacher(data[1], data[2], data[0], data[5],
                                                         data[6],  data[8], passwordString);
                        MainFrame.user = newTeacher;
                        SchoolMarm.main.showUserView(MainFrame.OPTIONS_VIEW, null, null);
                    } else {
                        Teacher newTeacher = new Teacher(data[1],  data[2], data[0], data[5],
                                                         data[6],  data[8], passwordString);
                        MainFrame.user = newTeacher;
                        SchoolMarm.main.showUserView(MainFrame.TEACHER_VIEW, null, null);
                    }

                    break;

                case 2:  //teacher
                    if(SchoolMarm.rows == 0 || SchoolMarm.cols == 0) {
                        Principal newPrincipal = new Principal(data[1], data[2], data[0], data[5],
                                                               data[6], data[8], passwordString);
                        MainFrame.user = newPrincipal;
                        SchoolMarm.main.showUserView(MainFrame.OPTIONS_VIEW, null, null);
                    } else {
                        Principal newPrincipal = new Principal(data[1], data[2], data[0], data[5],
                                                               data[6], data[8], passwordString);
                        MainFrame.user = newPrincipal;
                        SchoolMarm.main.showUserView(MainFrame.PRINCIPAL_VIEW, null, null);
                    }

                    break;

                default:
                    parent.setErrorMessage("<html><font color=RED>Invalid User ID or Password, Please Try Again</font></html>");
                    parent.clearPasswordField();
            }
        }
    }
}
