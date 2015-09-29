/*
 * The Constructors
 * SchoolMarm
 */
package model;

import java.util.Date;

/**
 * The Class Infraction.
 *
 */
public class Infraction {

    /** The info. */
    private String info;

    /** The title. */
    private String title;

    /** The date. */
    private String date;

    /**
     * Instantiates a new infraction.
     *
     * @param title the title
     * @param info the info
     * @param date the date
     */
    public Infraction(String title, String info, Date date) {
        this.info = info;
        this.title = title;
        this.date = date.toString();
    }

    /**
     * Instantiates a new infraction.
     *
     * @param title the title
     * @param info the info
     * @param date the date
     */
    public Infraction(String title, String info, String date) {
        this.info = info;
        this.title = title;
        this.date = date;
    }

    /**
     * Gets the info.
     *
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

}
