/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.AddInfractionListener;
import controller.BackButtonListener;
import controller.Login;
import model.Student;

/**
 * The Class InfractionView.
 *
 */
public class InfractionView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The infraction labels. */
    private JLabel infractionLabels[];

    /* Will need a way to get infractions from student... i.e:
     * student.getInfractions()
     */
    /**
     * Instantiates a new infraction view.
     *
     * @param student the student
     * @param frame the frame
     */
    public InfractionView(Student student, MainFrame frame) {
        infractionLabels = new JLabel[student.getNumInfractions()];
        JPanel infractionsPanel = new JPanel();
        infractionsPanel.setLayout(new BoxLayout(infractionsPanel, BoxLayout.PAGE_AXIS));

        for(int i = 0; i < student.getNumInfractions(); i++) {
            infractionLabels[i] = new JLabel("<html>" + student.getInfraction(i).getDate().toString() + "<br>" + student.getInfraction(i).getTitle() + "<br>" + student.getInfraction(i).getInfo() + "</html>");
            infractionsPanel.add(add(infractionLabels[i]));
            infractionsPanel.add(new JLabel(" "));
            infractionsPanel.add(Box.createVerticalGlue());
        }

        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener(frame, MainFrame.STUDENT_VIEW, student, null));
        buttonPanel.add(backButton);

        if(MainFrame.user.getUserLevel() == Login.TEACHER || MainFrame.user.getUserLevel() == Login.PRINCIPAL) {
            JButton addInfraction = new JButton("New Infraction");
            AddInfractionListener ail = new AddInfractionListener(student, frame);
            addInfraction.addActionListener(ail);
            buttonPanel.add(addInfraction);
        }

        this.setLayout(new BorderLayout());
        this.add(infractionsPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

}
