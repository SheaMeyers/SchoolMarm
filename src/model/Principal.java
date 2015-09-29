/*
 * The Constructors
 * SchoolMarm
 */
package model;

import controller.Login;

/**
 * The Class Principal.
 *
 */
public class Principal extends Person {

    /* (non-Javadoc)
     * @see model.Person#getUserLevel()
     */
    @Override
    public int getUserLevel() {
        return Login.PRINCIPAL;
    }

    /**
     * Instantiates a new principal.
     *
     * @param FirstName the first name
     * @param MiddleName the middle name
     * @param LastName the last name
     * @param id the id
     * @param PrincipalAddress the principal address
     * @param PrincipalEmail the principal email
     * @param PrincipalPhoneNumber the principal phone number
     * @param PrincipalPass the principal pass
     */
    public Principal(String FirstName, String LastName, String id, String PrincipalAddress,
                     String PrincipalEmail, String PrincipalPhoneNumber, char[] PrincipalPass) {
        super(LastName, FirstName, id, PrincipalAddress, PrincipalEmail, PrincipalPhoneNumber, PrincipalPass);
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    }

}