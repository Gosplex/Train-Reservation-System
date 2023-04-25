package GUI;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp {

    public SignUp() {
        userSignUp();
    }

    JTextField name;
    JTextField email;
    JTextField phone;
    JTextField gender;
    JLabel applicationNo;
    JLabel fname;
    JLabel mobile;
    JLabel genderText;
    JLabel emailText;
    JLabel passwordText;
    JCheckBox male;
    JCheckBox female;
    JPasswordField password;
    JButton register;
    JButton reset;
    JTextArea details;

    private void userSignUp() {
        // Generate Random Application Number
        int formNo = (int)Math.floor((Math.random() * 9000) + 1000);

        // JFrame
        JFrame frame = new JFrame("Online Reservation Form");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // JLabel
        applicationNo = new JLabel("Application Number: "+formNo);
        applicationNo.setBounds(20, 20, 400, 50);
        applicationNo.setFont(new Font("Verdana", Font.BOLD, 23));
        applicationNo.setVerticalAlignment(JLabel.TOP);
        frame.add(applicationNo);

        // Name Field
        fname = new JLabel("Name");
        fname.setFont(new Font("Arial", Font.PLAIN, 12));
        fname.setBounds(20, 80, 80, 30);
        frame.add(fname);
        name = new JTextField();
        name.setBounds(85, 80, 265, 30);
        name.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        frame.add(name);

        // Gender Field
        genderText = new JLabel("Gender");
        genderText.setFont(new Font("Arial", Font.PLAIN, 12));
        genderText.setBounds(20, 125, 80, 30);
        frame.add(genderText);
        male = new JCheckBox("Male");
        male.setBounds(105, 125, 80, 30);
        male.setSelected(false);
        frame.add(male);
        female = new JCheckBox("Female");
        female.setBounds(200, 125, 80, 30);
        female.setSelected(true);
        frame.add(female);

        // Mobile Field
        mobile = new JLabel("Mobile");
        mobile.setFont(new Font("Arial", Font.PLAIN, 12));
        mobile.setBounds(20, 170, 80, 30);
        frame.add(mobile);
        phone = new JTextField();
        phone.setBounds(85, 170, 265, 30);
        phone.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        frame.add(phone);

        // Email Field
        emailText = new JLabel("Email");
        emailText.setFont(new Font("Arial", Font.PLAIN, 12));
        emailText.setBounds(20, 215, 80, 30);
        frame.add(emailText);
        email = new JTextField();
        email.setBounds(85, 215, 265, 30);
        email.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        frame.add(email);

        // Password Field
        passwordText = new JLabel("Password");
        passwordText.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordText.setBounds(20, 260, 80, 30);
        frame.add(passwordText);
        password = new JPasswordField();
        password.setBounds(85, 260, 265, 30);
        frame.add(password);

        // Register Button
        register = new JButton("REGISTER");
        register.setBounds(85, 305, 95, 30);
        register.setBackground(Color.GREEN);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate Inputs
                if (name.getText().equals("") || email.getText().equals("") || phone.getText().equals("") || password.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "All Input Fields are needed", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
                else  {
                    frame.setSize(800, 400);

                    // Detailed Area
                    details = new JTextArea();
                    details.setBounds(382, 20, 380, 305);
                    details.setEditable(false);
                    String top = "=============================================\n";
                    String topText = "\tUser Details\n";
                    String data = "Name: \t "+name.getText()+"\n"+"Mobile: \t "+phone.getText()+"\n"+"Email: \t"+email.getText()+"\n";
                    String data3 = "User Login Details"+"\n\n"+"User ID: \t"+formNo+"\n"+"Password \t"+new String(password.getPassword());
                    String data1;
                    if (male.isSelected()) {
                        data1 = "Gender: \t Male"+"\n\n";
                    } else {
                        data1 = "Gender: \t Female" + "\n\n";
                    }
                    details.setText(top + topText + top+ data + data1 + data3);
                    details.setFont(new Font("Arial", Font.BOLD, 15));
                    frame.add(details);

                    // Clear Input Fields
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    password.setText("");
                    male.setSelected(false);
                    female.setSelected(false);

                    // DataBase Connection
                    String url = "jdbc:mysql://localhost:3306/train_reservation";
                    String sqlUsername = "root";
                    String sqlPassword = "";
                    try {
                        Class.forName("con.mysql.cj.jdbc.Driver");

                        Connection connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);

                        Statement statement = connection.createStatement();

                        // ResultSet resultSet = statement.executeQuery(sql);

                        connection.close();

                    }
                    catch (Exception error) {
                        System.out.println(error);
                    }

                }
            }
        });
        frame.add(register);

        // Reset Button
        reset = new JButton("RESET");
        reset.setBounds(200, 305, 95, 30);
        reset.setBackground(Color.RED);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear Input Fields
                name.setText("");
                email.setText("");
                phone.setText("");
                password.setText("");
                male.setSelected(false);
                female.setSelected(false);
            }
        });
        frame.add(reset);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}

