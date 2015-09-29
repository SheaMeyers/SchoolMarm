/*
 * The Constructors
 * SchoolMarm
 */
package model;

import controller.Login;

/**
 * The Class Teacher.
 *
 */
public class Teacher extends Person {

    /**
     * Instantiates a new teacher.
     *
     * @param FirstName the first name
     * @param MiddleName the middle name
     * @param LastName the last name
     * @param id the id
     * @param TeacherAddress the teacher address
     * @param TeacherEmail the teacher email
     * @param TeacherPhoneNumber the teacher phone number
     * @param TeacherPass the teacher pass
     */
    public Teacher(String FirstName, String LastName, String id, String TeacherAddress,
                   String TeacherEmail,  String TeacherPhoneNumber, char[] TeacherPass) {
        super(LastName, FirstName, id, TeacherAddress, TeacherEmail, TeacherPhoneNumber, TeacherPass);
    }

    /* (non-Javadoc)
     * @see model.Person#getUserLevel()
     */
    @Override
    public int getUserLevel() {
        return Login.TEACHER;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    }

}
