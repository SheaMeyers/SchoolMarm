/*
 * The Constructors
 * SchoolMarm
 */
package model;

/**
 * The Class TimeSlot.
 *
 */
public class TimeSlot {

    /** The hour. */
    private int hour;

    /** The info. */
    private String info;

    /**
     * Instantiates a new time slot.
     *
     * @param hour the hour
     * @param info the info
     */
    public TimeSlot(int hour, String info) {
        this.hour = hour;
        this.info = info;
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
     * Gets the hour.
     *
     * @return the hour
     */
    public int getHour() {
        if(hour > 12) {
            hour -= 12;
        }

        return hour;
    }

}
