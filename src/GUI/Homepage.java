package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage {
    JFrame frame;
    JPanel heading;
    JPanel login;
    JLabel headertext;
    JButton makeReservations;
    JButton checkBookingStatus;
    JButton userProfile;
    JButton cancelReservation;
    JButton exit;

    Homepage() {
        trainHomepage();
    }

    void trainHomepage() {
        // Transparent Heading
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,400,50);

        // JFrame
        frame =  new JFrame("Train Reservation System");
        frame.setLayout(null);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // Background Image
        ImageIcon bg_image = new ImageIcon("Images/train.jpg");
        Image img = bg_image.getImage();
        Image temp_img = img.getScaledInstance(400,500, Image.SCALE_SMOOTH);
        bg_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", bg_image, JLabel.CENTER);
        background.add(heading);
        background.setBounds(0,0,400,500);
        frame.add(background);

        // Header Text
        headertext = new JLabel("TRAIN RESERVATION HOMEPAGE");
        headertext.setBounds(15,20,400,50);
        headertext.setFont(new Font("Serif", Font.BOLD, 18));
        headertext.setVerticalAlignment(JLabel.TOP);
        headertext.setForeground(Color.WHITE);
        heading.add(headertext);

        // HomePage Panel
        login = new JPanel();
        login.setSize(300, 300);
        login.setBounds(40,100,300,300);
        login.setBackground(new Color(0,0,0,100));
        background.add(login);

        // Make Reservation Button
        makeReservations = new JButton("Make Booking Here");
        makeReservations.setBounds(55, 110, 265, 30);
        makeReservations.setBackground(Color.CYAN);
        makeReservations.setFocusable(false);
        makeReservations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        makeReservations.setFont(new Font("Verdana", Font.BOLD, 15));
        makeReservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        background.add(makeReservations);

        // Check Booking Status Button
        checkBookingStatus = new JButton("Check Booking Status");
        checkBookingStatus.setBounds(55, 170, 265, 30);
        checkBookingStatus.setBackground(Color.GREEN);
        checkBookingStatus.setFocusable(false);
        checkBookingStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkBookingStatus.setFont(new Font("Verdana", Font.BOLD, 15));
        checkBookingStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        background.add(checkBookingStatus);

        // Add Reservation Area Button
        cancelReservation = new JButton("Cancel Booking");
        cancelReservation.setBounds(55,230,265,30);
        cancelReservation.setBackground(Color.RED);
        cancelReservation.setForeground(Color.white);
        cancelReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancelReservation.setFocusable(false);
        cancelReservation.setFont(new Font("Verdana", Font.BOLD, 15));
        cancelReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        background.add(cancelReservation);

        // User Profile Area
        userProfile = new JButton("Edit User Profile");
        userProfile.setBounds(55, 290, 265, 30);
        userProfile.setBackground(Color.darkGray);
        userProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userProfile.setFocusable(false);
        userProfile.setFont(new Font("Verdana", Font.BOLD, 15));
        userProfile.setForeground(Color.white);
        userProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        background.add(userProfile);

        // Exit Area
        exit = new JButton("Exit");
        exit.setBounds(55,350,265,30);
        exit.setBackground(Color.RED);
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exit.setFocusable(false);
        exit.setFont(new Font("Verdana", Font.BOLD, 15));
        exit.setForeground(Color.white);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        background.add(exit);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Homepage();
    }

}
