/*
 * The Constructors
 * SchoolMarm
 */
package model;

/**
 * The Class Person.
 *
 */
public abstract class Person {

    /** The First name. */
    protected String FirstName;

    /** The Last name. */
    protected String LastName;

    /** The id. */
    protected String id;

    /** The address. */
    protected String address;

    /** The email. */
    protected String email;

    /** The phone number. */
    protected String phoneNumber;

    /** The pass. */
    protected char[] pass;

    /**
     * Instantiates a new person.
     *
     * @param FirstName the first name
     * @param MiddleName the middle name
     * @param LastName the last name
     * @param id the id
     * @param address the address
     * @param email the email
     * @param phoneNumber the phone number
     * @param pass the pass
     */
    public Person(String FirstName, String LastName, String id, String address, String email, String phoneNumber, char[] pass) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.id = id;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getID() {
        return id;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the pass.
     *
     * @return the pass
     */
    public char[] getPass() {
        return pass;
    }

    /**
     * Sets the first name.
     *
     * @param newFirstName the new first name
     */
    public void setFirstName(String newFirstName) {
        FirstName = newFirstName;
    }
    
    /**
     * Sets the last name.
     *
     * @param newLastName the new last name
     */
    public void setLastName(String newLastName) {
        LastName = newLastName;
    }

    /**
     * Sets the id.
     *
     * @param newID the new id
     */
    public void setID(String newID) {
        id = newID;
    }

    /**
     * Sets the address.
     *
     * @param add the new address
     */
    public void setAddress(String add) {
        address = add;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the phone number.
     *
     * @param phNum the new phone number
     */
    public void setPhoneNumber(String phNum) {
        phoneNumber = phNum;
    }

    /**
     * Sets the pass.
     *
     * @param pass the new pass
     */
    public void setPass(char[] pass) {
        this.pass = pass;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "\nFirst Name: " + FirstName
               + "\nLast Name: " + LastName + "\nID: " + id + "\nAddress: " + address
               + "\nEmail: " + email + "\nPhone Number: " + phoneNumber;
    }

    /**
     * Full name.
     *
     * @return the string
     */
    public String fullName() {
        return FirstName+ " " +LastName;
    }

    /**
     * Gets the user level.
     *
     * @return the user level
     */
    public abstract int getUserLevel();

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    }
}