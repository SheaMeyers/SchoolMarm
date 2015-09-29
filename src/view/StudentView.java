/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.InfractionListener;
import controller.SchoolMarm;
import controller.StudentGradesListener;

import model.Student;

/**
 * The Class StudentView.
 *
 */
public class StudentView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new student view.
     *
     * @param student the student
     * @param main the main
     */
    public StudentView(Student student, MainFrame main) {
        JPanel parentPanel = new JPanel();
        JPanel infoPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel northPanel = new JPanel();
        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        BufferedImage pic = null;
        BufferedImage rPic = null;

        try {
            pic = ImageIO.read(new File(SchoolMarm.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "Resources" + File.separator + student.getImgURL()));
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

        ImageIcon icon = new ImageIcon(rPic);
        Image img = icon.getImage();
        pic = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = pic.createGraphics();
        g.drawImage(img, 0, 0, null);
        JLabel picLabel = new JLabel(new ImageIcon(pic));
        parentPanel.add(picLabel);
        northPanel.add(parentPanel);
        northPanel.add(namePanel);
        /* All info from here to the next comment is hard coded
         * and would actually be taken from the "Student" object that
         * was passed in at creation.
         */
        /*JLabel nameLabel = new JLabel("<html><b><font size=10>First Last</b></html>");
        northPanel.add(nameLabel);

        JLabel phoneLabel = new JLabel("<html><font size=5><b>Phone Number:</b> (999) 555-1234</html>");
        JLabel motherLabel = new JLabel("<html><font size=5><b>Mother:</b> Mother Name</html>");
        JLabel fatherLabel = new JLabel("<html><font size=5><b>Father:</b> Father Name</html>");
        JLabel allergyLabel = new JLabel("<html><font size=5><b>Allergies:</b><br>&nbsp;&nbsp;&nbsp;&nbsp; Everything</html>");
        JLabel addressLabel = new JLabel("<html><font size=5><b>Address:</b><br>&nbsp;&nbsp;&nbsp;&nbsp; 123 Fakestreet<br>&nbsp;&nbsp;&nbsp;&nbsp; Falseville, AB<br>&nbsp;&nbsp;&nbsp;&nbsp; A1B 2C4</html>");

        */
        JLabel nameLabel = new JLabel("<html><b><font size=10>" + student.getFirstName() + "<br>" + student.getLastName() + "</b></html>");
        northPanel.add(nameLabel);
        JLabel phoneLabel = new JLabel("<html><font size=5>Phone Number:</font><font size=4>" + student.getPhoneNumber() + "</html>");
        JLabel motherLabel = new JLabel("<html><font size=5>Father:</font><font size=4>" + student.getGuardian1() + "</html>");
        JLabel fatherLabel = new JLabel("<html><font size=5>Mother:</font><font size=4>" + student.getGuardian2() + "</html>");
        JLabel allergyLabel = new JLabel("<html><font size=5>Allergies:<br></font><font size=4>" + student.getAllergy() + "<br></html>");
        JLabel addressLabel = new JLabel("<html><font size=5>Address:<br></font><font size=4>" + student.getAddress() + "<br></html>");
        JLabel emailLabel = new JLabel("<html><font size=5>Email:</font><font size=4>" + student.getEmail() + "</html>");
        infoPanel.setLayout(new GridLayout(6, 0));
        infoPanel.add(motherLabel);
        infoPanel.add(fatherLabel);
        infoPanel.add(phoneLabel);
        infoPanel.add(emailLabel);
        infoPanel.add(addressLabel);
        infoPanel.add(allergyLabel);
        JPanel buttonPanel = new JPanel();
        JButton gradeButton = new JButton("Grades");
        JButton infractionButton = new JButton("Infractions");
        buttonPanel.add(gradeButton);
        buttonPanel.add(infractionButton);
        StudentGradesListener sgl = new StudentGradesListener(student, main);
        gradeButton.addActionListener(sgl);
        InfractionListener il = new InfractionListener(student, main);
        infractionButton.addActionListener(il);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

}
