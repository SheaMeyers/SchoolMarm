/*
 * The Constructors
 * SchoolMarm
 */
package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import controller.SchoolMarm;

/**
 * The Class DefaultIcon.
 *
 */
public class StudentIcon extends ImageIcon {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new default icon.
     *
     * @param url the url
     */
    public StudentIcon(String url) {
        BufferedImage pic = null;
        BufferedImage rPic = null;

        try {
            pic = ImageIO.read(new File(SchoolMarm.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "Resources" + File.separator + url));
            rPic = new BufferedImage(100, 100, pic.getType());
            Graphics2D g = rPic.createGraphics();
            g.drawImage(pic, 0, 0, 100, 100, null);
            g.dispose();
        } catch(Exception e) {
            try {
                rPic = ImageIO.read(this.getClass().getResource("/images/generic-face.png"));
            } catch(Exception ee) {
                ee.printStackTrace();
                e.printStackTrace();
            }
        }

        this.setImage(rPic);
    }

    /**
     * The Class SysTime.
     *
     * @author wangzhichai
     * now function will return a system current time
     */
    public static class SysTime {

        /** The Constant INSTANCE. */
        public static final SysTime INSTANCE = new SysTime();

        /**
         * Now.
         *
         * @return the long
         */
        public long now() {
            return System.currentTimeMillis();
        }
    }
}