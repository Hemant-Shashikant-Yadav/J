import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.net.URI;
import java.net.URISyntaxException;

public class IAMS10 {
    private static JFrame layeredFrame;
    private static JLayeredPane layeredPane;

    public static void login() {
        JFrame loginFrame = new JFrame("Login Form");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and configure the labels
        JLabel loginLabel = new JLabel("Login ID:");
        JLabel passwordLabel = new JLabel("Password:");

        // Create and configure the text fields
        JTextField loginTextField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        // Set the positions of the labels and text fields
        loginLabel.setBounds(50, 50, 100, 30);
        loginTextField.setBounds(160, 50, 150, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(160, 100, 150, 30);

        // Create the login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 150, 80, 30);

        // Add an ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the entered password
                String password = new String(passwordField.getPassword());

                // Check if the password matches
                if (password.equals("@Ganesh")) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    loginFrame.dispose();
                    switchFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                }
            }
        });

        // Create a layered pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 400));

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        // Add the labels, text fields, and login button to the layered pane
        layeredPane.add(loginLabel, Integer.valueOf(1));
        layeredPane.add(loginTextField, Integer.valueOf(1));
        layeredPane.add(passwordLabel, Integer.valueOf(1));
        layeredPane.add(passwordField, Integer.valueOf(1));
        layeredPane.add(loginButton, Integer.valueOf(1));

        // Configure the frame
        loginFrame.setContentPane(layeredPane);
        loginFrame.setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        loginFrame.setSize(500, 500); // Set dimensions to 500x500
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    public static void switchFrame() {
        JFrame f = new JFrame();

        JLabel l = new JLabel("Choose the options from the following:");

        String[] options = { "Admission Student", "Library", "Sports_Complex", "Hostel" };
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(100, 110, 200, 30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 150, 100, 30);

        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 200, 100, 30);

        // Add an ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = comboBox.getSelectedIndex();
                switch (selectedIndex) {
                    case 0:
                        f.dispose();
                        admitStudent();
                        break;
                    case 1:
                        f.dispose();
                        library();
                        break;
                    case 2:
                        f.dispose();
                        sportsComplex();
                        break;
                    case 3:
                        f.dispose();
                        hostel();
                        break;
                }
            }
        });

        l.setBounds(90, 50, 400, 30);

        f.add(l);
        f.add(comboBox);
        f.add(submitButton);
        f.add(backButton);

        f.setSize(600, 600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                login();
            }
        });

        JButton aboutUsButton = new JButton("About Us");
        aboutUsButton.setBounds(150, 250, 100, 30);

        // Add an ActionListener to the aboutUs button
        aboutUsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop()
                            .browse(new URI("https://www.kbpislampur.com/allsubfiles/aboutus/collegeprofile.html"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        f.add(aboutUsButton);

        JButton facultyManagementButton = new JButton("Faculty Management");
        facultyManagementButton.setBounds(320, 100, 150, 30);
        f.add(facultyManagementButton);

        facultyManagementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                faculty_management(); // Call the faculty_management() function when the button is clicked
            }
        });

        JButton complaintButton = new JButton("Complaint Section");
        complaintButton.setBounds(320, 140, 150, 30);
        f.add(complaintButton);

        complaintButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                complaint_Section();
            }
        });

        JButton studentLeaveButton = new JButton("Student Leave");
        studentLeaveButton.setBounds(320, 180, 150, 30);
        f.add(studentLeaveButton);

        studentLeaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentLeave();
            }
        });

        JButton teacherLeaveButton = new JButton("Teacher Leave");
        teacherLeaveButton.setBounds(320, 220, 150, 30);
        f.add(teacherLeaveButton);

        teacherLeaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                teacherLeave();
            }
        });

        JButton updatesButton = new JButton("New Updates");
        updatesButton.setBounds(320, 260, 150, 30);
        f.add(updatesButton);

        updatesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newUpdates();
            }
        });

        JButton examResultButton = new JButton("Exam Result");
        examResultButton.setBounds(320, 300, 150, 30);
        f.add(examResultButton);

        examResultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                examResult();
            }
        });

        JButton feeStructureButton = new JButton("Fee Structure");
        feeStructureButton.setBounds(320, 340, 150, 30);
        f.add(feeStructureButton);

        feeStructureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feeStructure();
            }
        });

        JButton departmentButton = new JButton("Department");
        departmentButton.setBounds(320, 380, 150, 30);
        f.add(departmentButton);

        departmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                department();
            }
        });

        JButton contactButton = new JButton("Contact");
        contactButton.setBounds(320, 420, 150, 30);
        f.add(contactButton);

        contactButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contact();
            }
        });

        JButton feedbackButton = new JButton("Feedback");
        feedbackButton.setBounds(320, 460, 150, 30);
        f.add(feedbackButton);

        feedbackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                feedback();
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
    }

    public static void faculty_management() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Faculty Management System");
        JLabel nameLabel = new JLabel("Enter faculty member's name:");
        JLabel departmentLabel = new JLabel("Enter faculty member's department:");
        JLabel positionLabel = new JLabel("Enter faculty member's position:");
        JLabel qualificationLabel = new JLabel("Enter faculty member's qualification:");
        JLabel experienceLabel = new JLabel("Enter faculty member's experience:");
        JLabel salaryLabel = new JLabel("Enter faculty member's salary:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        nameLabel.setBounds(30, 80, 200, 30);
        departmentLabel.setBounds(30, 120, 200, 30);
        positionLabel.setBounds(30, 160, 200, 30);
        qualificationLabel.setBounds(30, 200, 200, 30);
        experienceLabel.setBounds(30, 240, 200, 30);
        salaryLabel.setBounds(30, 280, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField nameTextField = new JTextField();
        JTextField departmentTextField = new JTextField();
        JTextField positionTextField = new JTextField();
        JTextField qualificationTextField = new JTextField();
        JTextField experienceTextField = new JTextField();
        JTextField salaryTextField = new JTextField();

        nameTextField.setBounds(250, 80, 200, 30);
        departmentTextField.setBounds(250, 120, 200, 30);
        positionTextField.setBounds(250, 160, 200, 30);
        qualificationTextField.setBounds(250, 200, 200, 30);
        experienceTextField.setBounds(250, 240, 200, 30);
        salaryTextField.setBounds(250, 280, 200, 30);

        layeredPane.add(title);
        layeredPane.add(nameLabel);
        layeredPane.add(departmentLabel);
        layeredPane.add(positionLabel);
        layeredPane.add(qualificationLabel);
        layeredPane.add(experienceLabel);
        layeredPane.add(salaryLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(nameTextField);
        layeredPane.add(departmentTextField);
        layeredPane.add(positionTextField);
        layeredPane.add(qualificationTextField);
        layeredPane.add(experienceTextField);
        layeredPane.add(salaryTextField);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 320, 100, 30);
        layeredPane.add(back_button);

        JButton save_button = new JButton("Save & create file");
        save_button.setBounds(150, 320, 150, 30);
        layeredPane.add(save_button);

        JButton read_button = new JButton("Read File");
        read_button.setBounds(320, 320, 100, 30);
        layeredPane.add(read_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Save button action listener
        save_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "faculty_management.txt";
                String data = "Name: " + nameTextField.getText() + "\n" +
                        "Department: " + departmentTextField.getText() + "\n" +
                        "Position: " + positionTextField.getText() + "\n" +
                        "Qualification: " + qualificationTextField.getText() + "\n" +
                        "Experience: " + experienceTextField.getText() + "\n" +
                        "Salary: " + salaryTextField.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // Read button action listener
        read_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "faculty_management.txt";
                displayData(fileName, "Faculty Management Data"); // Assuming displayData() is a method for displaying
                                                                  // data from a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void complaint_Section() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Complaint Section");
        JLabel nameLabel = new JLabel("Enter your name:");
        JLabel emailLabel = new JLabel("Enter your email:");
        JLabel complaintLabel = new JLabel("Enter your complaint:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        nameLabel.setBounds(30, 80, 200, 30);
        emailLabel.setBounds(30, 120, 200, 30);
        complaintLabel.setBounds(30, 160, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField nameTextField = new JTextField();
        JTextField emailTextField = new JTextField();
        JTextArea complaintTextArea = new JTextArea();
        complaintTextArea.setLineWrap(true);
        complaintTextArea.setWrapStyleWord(true);

        nameTextField.setBounds(250, 80, 200, 30);
        emailTextField.setBounds(250, 120, 200, 30);
        complaintTextArea.setBounds(250, 160, 300, 200);

        layeredPane.add(title);
        layeredPane.add(nameLabel);
        layeredPane.add(emailLabel);
        layeredPane.add(complaintLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(nameTextField);
        layeredPane.add(emailTextField);
        layeredPane.add(complaintTextArea);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 380, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 380, 100, 30);
        layeredPane.add(submit_button);

        JButton view_button = new JButton("View Complaints");
        view_button.setBounds(270, 380, 150, 30);
        layeredPane.add(view_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "complaints.txt";
                String data = "Name: " + nameTextField.getText() + "\n" +
                        "Email: " + emailTextField.getText() + "\n" +
                        "Complaint: " + complaintTextArea.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // View button action listener
        view_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "complaints.txt";
                displayData(fileName, "Complaints Data"); // Assuming displayData() is a method for displaying data from
                                                          // a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void studentLeave() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Student Leave Application");
        JLabel nameLabel = new JLabel("Enter your name:");
        JLabel rollNoLabel = new JLabel("Enter your roll number:");
        JLabel departmentLabel = new JLabel("Enter your department:");
        JLabel leaveTypeLabel = new JLabel("Select leave type:");
        JLabel fromDateLabel = new JLabel("From Date:");
        JLabel toDateLabel = new JLabel("To Date:");
        JLabel reasonLabel = new JLabel("Reason for leave:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        nameLabel.setBounds(30, 80, 200, 30);
        rollNoLabel.setBounds(30, 120, 200, 30);
        departmentLabel.setBounds(30, 160, 200, 30);
        leaveTypeLabel.setBounds(30, 200, 200, 30);
        fromDateLabel.setBounds(30, 240, 200, 30);
        toDateLabel.setBounds(30, 280, 200, 30);
        reasonLabel.setBounds(30, 320, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField nameTextField = new JTextField();
        JTextField rollNoTextField = new JTextField();
        JTextField departmentTextField = new JTextField();
        JComboBox<String> leaveTypeComboBox = new JComboBox<>(new String[] { "Casual", "Sick", "Vacation" });
        JTextField fromDateTextField = new JTextField();
        JTextField toDateTextField = new JTextField();
        JTextArea reasonTextArea = new JTextArea();
        reasonTextArea.setLineWrap(true);
        reasonTextArea.setWrapStyleWord(true);

        nameTextField.setBounds(250, 80, 200, 30);
        rollNoTextField.setBounds(250, 120, 200, 30);
        departmentTextField.setBounds(250, 160, 200, 30);
        leaveTypeComboBox.setBounds(250, 200, 200, 30);
        fromDateTextField.setBounds(250, 240, 200, 30);
        toDateTextField.setBounds(250, 280, 200, 30);
        reasonTextArea.setBounds(250, 320, 300, 100);

        layeredPane.add(title);
        layeredPane.add(nameLabel);
        layeredPane.add(rollNoLabel);
        layeredPane.add(departmentLabel);
        layeredPane.add(leaveTypeLabel);
        layeredPane.add(fromDateLabel);
        layeredPane.add(toDateLabel);
        layeredPane.add(reasonLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(nameTextField);
        layeredPane.add(rollNoTextField);
        layeredPane.add(departmentTextField);
        layeredPane.add(leaveTypeComboBox);
        layeredPane.add(fromDateTextField);
        layeredPane.add(toDateTextField);
        layeredPane.add(reasonTextArea);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 440, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 440, 100, 30);
        layeredPane.add(submit_button);

        JButton view_button = new JButton("View Leaves");
        view_button.setBounds(270, 440, 150, 30);
        layeredPane.add(view_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "student_leaves.txt";
                String data = "Name: " + nameTextField.getText() + "\n" +
                        "Roll Number: " + rollNoTextField.getText() + "\n" +
                        "Department: " + departmentTextField.getText() + "\n" +
                        "Leave Type: " + leaveTypeComboBox.getSelectedItem() + "\n" +
                        "From Date: " + fromDateTextField.getText() + "\n" +
                        "To Date: " + toDateTextField.getText() + "\n" +
                        "Reason: " + reasonTextArea.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // View button action listener
        view_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "student_leaves.txt";
                displayData(fileName, "Student Leaves Data"); // Assuming displayData() is a method for displaying data
                                                              // from a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void teacherLeave() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Teacher Leave Application");
        JLabel nameLabel = new JLabel("Enter your name:");
        JLabel employeeIDLabel = new JLabel("Enter your employee ID:");
        JLabel departmentLabel = new JLabel("Enter your department:");
        JLabel leaveTypeLabel = new JLabel("Select leave type:");
        JLabel fromDateLabel = new JLabel("From Date:");
        JLabel toDateLabel = new JLabel("To Date:");
        JLabel reasonLabel = new JLabel("Reason for leave:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        nameLabel.setBounds(30, 80, 200, 30);
        employeeIDLabel.setBounds(30, 120, 200, 30);
        departmentLabel.setBounds(30, 160, 200, 30);
        leaveTypeLabel.setBounds(30, 200, 200, 30);
        fromDateLabel.setBounds(30, 240, 200, 30);
        toDateLabel.setBounds(30, 280, 200, 30);
        reasonLabel.setBounds(30, 320, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField nameTextField = new JTextField();
        JTextField employeeIDTextField = new JTextField();
        JTextField departmentTextField = new JTextField();
        JComboBox<String> leaveTypeComboBox = new JComboBox<>(new String[] { "Casual", "Sick", "Vacation" });
        JTextField fromDateTextField = new JTextField();
        JTextField toDateTextField = new JTextField();
        JTextArea reasonTextArea = new JTextArea();
        reasonTextArea.setLineWrap(true);
        reasonTextArea.setWrapStyleWord(true);

        nameTextField.setBounds(250, 80, 200, 30);
        employeeIDTextField.setBounds(250, 120, 200, 30);
        departmentTextField.setBounds(250, 160, 200, 30);
        leaveTypeComboBox.setBounds(250, 200, 200, 30);
        fromDateTextField.setBounds(250, 240, 200, 30);
        toDateTextField.setBounds(250, 280, 200, 30);
        reasonTextArea.setBounds(250, 320, 300, 100);

        layeredPane.add(title);
        layeredPane.add(nameLabel);
        layeredPane.add(employeeIDLabel);
        layeredPane.add(departmentLabel);
        layeredPane.add(leaveTypeLabel);
        layeredPane.add(fromDateLabel);
        layeredPane.add(toDateLabel);
        layeredPane.add(reasonLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(nameTextField);
        layeredPane.add(employeeIDTextField);
        layeredPane.add(departmentTextField);
        layeredPane.add(leaveTypeComboBox);
        layeredPane.add(fromDateTextField);
        layeredPane.add(toDateTextField);
        layeredPane.add(reasonTextArea);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 440, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 440, 100, 30);
        layeredPane.add(submit_button);

        JButton view_button = new JButton("View Leaves");
        view_button.setBounds(270, 440, 150, 30);
        layeredPane.add(view_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "teacher_leaves.txt";
                String data = "Name: " + nameTextField.getText() + "\n" +
                        "Employee ID: " + employeeIDTextField.getText() + "\n" +
                        "Department: " + departmentTextField.getText() + "\n" +
                        "Leave Type: " + leaveTypeComboBox.getSelectedItem() + "\n" +
                        "From Date: " + fromDateTextField.getText() + "\n" +
                        "To Date: " + toDateTextField.getText() + "\n" +
                        "Reason: " + reasonTextArea.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // View button action listener
        view_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "teacher_leaves.txt";
                displayData(fileName, "Teacher Leaves Data"); // Assuming displayData() is a method for displaying data
                                                              // from a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void newUpdates() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("New Updates");
        JLabel titleLabel = new JLabel("Title:");
        JLabel contentLabel = new JLabel("Content:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        titleLabel.setBounds(30, 80, 200, 30);
        contentLabel.setBounds(30, 120, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField titleTextField = new JTextField();
        JTextArea contentTextArea = new JTextArea();
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);

        titleTextField.setBounds(250, 80, 200, 30);
        contentTextArea.setBounds(250, 120, 300, 200);

        layeredPane.add(title);
        layeredPane.add(titleLabel);
        layeredPane.add(contentLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(titleTextField);
        layeredPane.add(contentTextArea);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 360, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 360, 100, 30);
        layeredPane.add(submit_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "updates.txt";
                String data = "Title: " + titleTextField.getText() + "\n" +
                        "Content: " + contentTextArea.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void examResult() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Exam Results");
        JLabel nameLabel = new JLabel("Enter student's name:");
        JLabel rollNoLabel = new JLabel("Enter student's roll number:");
        JLabel subjectLabel = new JLabel("Enter subject:");
        JLabel marksLabel = new JLabel("Enter marks:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        nameLabel.setBounds(30, 80, 200, 30);
        rollNoLabel.setBounds(30, 120, 200, 30);
        subjectLabel.setBounds(30, 160, 200, 30);
        marksLabel.setBounds(30, 200, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField nameTextField = new JTextField();
        JTextField rollNoTextField = new JTextField();
        JTextField subjectTextField = new JTextField();
        JTextField marksTextField = new JTextField();

        nameTextField.setBounds(250, 80, 200, 30);
        rollNoTextField.setBounds(250, 120, 200, 30);
        subjectTextField.setBounds(250, 160, 200, 30);
        marksTextField.setBounds(250, 200, 200, 30);

        layeredPane.add(title);
        layeredPane.add(nameLabel);
        layeredPane.add(rollNoLabel);
        layeredPane.add(subjectLabel);
        layeredPane.add(marksLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(nameTextField);
        layeredPane.add(rollNoTextField);
        layeredPane.add(subjectTextField);
        layeredPane.add(marksTextField);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 240, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 240, 100, 30);
        layeredPane.add(submit_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "exam_results.txt";
                String data = "Name: " + nameTextField.getText() + "\n" +
                        "Roll Number: " + rollNoTextField.getText() + "\n" +
                        "Subject: " + subjectTextField.getText() + "\n" +
                        "Marks: " + marksTextField.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void feeStructure() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Fee Structure");
        JLabel nameLabel = new JLabel("Enter student's name:");
        JLabel rollNoLabel = new JLabel("Enter student's roll number:");
        JLabel departmentLabel = new JLabel("Select department:");
        JLabel semesterLabel = new JLabel("Select semester:");
        JLabel feeLabel = new JLabel("Enter fee amount:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        nameLabel.setBounds(30, 80, 200, 30);
        rollNoLabel.setBounds(30, 120, 200, 30);
        departmentLabel.setBounds(30, 160, 200, 30);
        semesterLabel.setBounds(30, 200, 200, 30);
        feeLabel.setBounds(30, 240, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField nameTextField = new JTextField();
        JTextField rollNoTextField = new JTextField();
        JComboBox<String> departmentComboBox = new JComboBox<>(new String[] { "BSC CS", "BBA", "Bcom" });
        JComboBox<String> semesterComboBox = new JComboBox<>(new String[] { "Semester 1", "Semester 2", "Semester 3" });
        JTextField feeTextField = new JTextField();

        nameTextField.setBounds(250, 80, 200, 30);
        rollNoTextField.setBounds(250, 120, 200, 30);
        departmentComboBox.setBounds(250, 160, 200, 30);
        semesterComboBox.setBounds(250, 200, 200, 30);
        feeTextField.setBounds(250, 240, 200, 30);

        layeredPane.add(title);
        layeredPane.add(nameLabel);
        layeredPane.add(rollNoLabel);
        layeredPane.add(departmentLabel);
        layeredPane.add(semesterLabel);
        layeredPane.add(feeLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(nameTextField);
        layeredPane.add(rollNoTextField);
        layeredPane.add(departmentComboBox);
        layeredPane.add(semesterComboBox);
        layeredPane.add(feeTextField);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 280, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 280, 100, 30);
        layeredPane.add(submit_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "fee_structure.txt";
                String data = "Name: " + nameTextField.getText() + "\n" +
                        "Roll Number: " + rollNoTextField.getText() + "\n" +
                        "Department: " + departmentComboBox.getSelectedItem() + "\n" +
                        "Semester: " + semesterComboBox.getSelectedItem() + "\n" +
                        "Fee Amount: " + feeTextField.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void department() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Department Information");
        JLabel departmentLabel = new JLabel("Enter department name:");
        JLabel hodLabel = new JLabel("Enter HOD name:");
        JLabel contactLabel = new JLabel("Enter contact number:");
        JLabel descriptionLabel = new JLabel("Enter department description:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        departmentLabel.setBounds(30, 80, 200, 30);
        hodLabel.setBounds(30, 120, 200, 30);
        contactLabel.setBounds(30, 160, 200, 30);
        descriptionLabel.setBounds(30, 200, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField departmentTextField = new JTextField();
        JTextField hodTextField = new JTextField();
        JTextField contactTextField = new JTextField();
        JTextArea descriptionTextArea = new JTextArea();
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);

        departmentTextField.setBounds(250, 80, 200, 30);
        hodTextField.setBounds(250, 120, 200, 30);
        contactTextField.setBounds(250, 160, 200, 30);
        descriptionTextArea.setBounds(250, 200, 300, 100);

        layeredPane.add(title);
        layeredPane.add(departmentLabel);
        layeredPane.add(hodLabel);
        layeredPane.add(contactLabel);
        layeredPane.add(descriptionLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(departmentTextField);
        layeredPane.add(hodTextField);
        layeredPane.add(contactTextField);
        layeredPane.add(descriptionTextArea);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 320, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 320, 100, 30);
        layeredPane.add(submit_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "departments.txt";
                String data = "Department Name: " + departmentTextField.getText() + "\n" +
                        "HOD Name: " + hodTextField.getText() + "\n" +
                        "Contact Number: " + contactTextField.getText() + "\n" +
                        "Description: " + descriptionTextArea.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void contact() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.example.com")); // Replace "https://www.example.com" with
                                                                             // the actual college website URL
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    public static void feedback() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Feedback Form");
        JLabel nameLabel = new JLabel("Enter your name:");
        JLabel emailLabel = new JLabel("Enter your email:");
        JLabel feedbackLabel = new JLabel("Enter your feedback:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        nameLabel.setBounds(30, 80, 200, 30);
        emailLabel.setBounds(30, 120, 200, 30);
        feedbackLabel.setBounds(30, 160, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField nameTextField = new JTextField();
        JTextField emailTextField = new JTextField();
        JTextArea feedbackTextArea = new JTextArea();
        feedbackTextArea.setLineWrap(true);
        feedbackTextArea.setWrapStyleWord(true);

        nameTextField.setBounds(250, 80, 200, 30);
        emailTextField.setBounds(250, 120, 200, 30);
        feedbackTextArea.setBounds(250, 160, 300, 200);

        layeredPane.add(title);
        layeredPane.add(nameLabel);
        layeredPane.add(emailLabel);
        layeredPane.add(feedbackLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(nameTextField);
        layeredPane.add(emailTextField);
        layeredPane.add(feedbackTextArea);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 380, 100, 30);
        layeredPane.add(back_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(150, 380, 100, 30);
        layeredPane.add(submit_button);

        // Back button action listener
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame(); // Assuming switchFrame() is a method for switching frames
            }
        });

        // Submit button action listener
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "feedback.txt";
                String data = "Name: " + nameTextField.getText() + "\n" +
                        "Email: " + emailTextField.getText() + "\n" +
                        "Feedback: " + feedbackTextArea.getText() + "\n";

                saveDataToFile(fileName, data); // Assuming saveDataToFile() is a method for saving data to a file
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void admitStudent() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Welcome to the KBP College , Urun-Islampur");
        JLabel firstname = new JLabel("Enter the student's first name:");
        JLabel middlename = new JLabel("Enter the student's middle name:");
        JLabel lastname = new JLabel("Enter the student's last name:");
        JLabel addressLabel = new JLabel("Enter the student's address:");
        JLabel phoneNumberLabel = new JLabel("Enter the student's phone number:");
        JLabel parentPhoneNumberLabel = new JLabel("Enter the student's parent's phone number:");
        JLabel marksLabel = new JLabel("Enter the student's 12th marks:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        firstname.setBounds(30, 80, 200, 30);
        middlename.setBounds(30, 120, 200, 30);
        lastname.setBounds(30, 160, 200, 30);
        addressLabel.setBounds(30, 200, 200, 30);
        phoneNumberLabel.setBounds(30, 240, 200, 30);
        parentPhoneNumberLabel.setBounds(30, 280, 200, 30);
        marksLabel.setBounds(30, 320, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField firstnameTextField = new JTextField();
        JTextField middlenameTextField = new JTextField();
        JTextField lastnameTextField = new JTextField();
        JTextField addressLabelTextField = new JTextField();
        JTextField phoneNumberLabelTextField = new JTextField();
        JTextField parentPhoneNumberLabelTextField = new JTextField();
        JTextField marksLabelTextField = new JTextField();

        firstnameTextField.setBounds(250, 80, 200, 30);
        middlenameTextField.setBounds(250, 120, 200, 30);
        lastnameTextField.setBounds(250, 160, 200, 30);
        addressLabelTextField.setBounds(250, 200, 200, 30);
        phoneNumberLabelTextField.setBounds(250, 240, 200, 30);
        parentPhoneNumberLabelTextField.setBounds(250, 280, 200, 30);
        marksLabelTextField.setBounds(250, 320, 200, 30);

        layeredPane.add(title);
        layeredPane.add(firstname);
        layeredPane.add(middlename);
        layeredPane.add(lastname);
        layeredPane.add(addressLabel);
        layeredPane.add(phoneNumberLabel);
        layeredPane.add(parentPhoneNumberLabel);
        layeredPane.add(marksLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(firstnameTextField);
        layeredPane.add(middlenameTextField);
        layeredPane.add(lastnameTextField);
        layeredPane.add(addressLabelTextField);
        layeredPane.add(phoneNumberLabelTextField);
        layeredPane.add(parentPhoneNumberLabelTextField);
        layeredPane.add(marksLabelTextField);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 360, 100, 30);
        layeredPane.add(back_button);

        JButton save_button = new JButton("Save & create file");
        save_button.setBounds(150, 360, 150, 30);
        layeredPane.add(save_button);

        JButton read_button = new JButton("Read File");
        read_button.setBounds(320, 360, 100, 30);
        layeredPane.add(read_button);

        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame();
            }
        });

        save_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "admission_student.txt";
                String data = "First Name: " + firstnameTextField.getText() + "\n" +
                        "Middle Name: " + middlenameTextField.getText() + "\n" +
                        "Last Name: " + lastnameTextField.getText() + "\n" +
                        "Address: " + addressLabelTextField.getText() + "\n" +
                        "Phone Number: " + phoneNumberLabelTextField.getText() + "\n" +
                        "Parent's Phone Number: " + parentPhoneNumberLabelTextField.getText() + "\n" +
                        "Marks: " + marksLabelTextField.getText() + "\n";

                saveDataToFile(fileName, data);
            }
        });

        JButton moreInfoButton = new JButton("For more information, click here");
        moreInfoButton.setBounds(30, 400, 400, 30);
        layeredPane.add(moreInfoButton);

        moreInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop()
                            .browse(new URI("https://www.kbpislampur.com/allsubfiles/contact/contact.html"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        read_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "admission_student.txt";
                displayData(fileName, "Admission Student Data");
            }
        });

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void library() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Welcome to the KBP Library, Urun-Islampur");
        JLabel firstname = new JLabel("Enter the student's first name:");
        JLabel middlename = new JLabel("Enter the student's middle name:");
        JLabel lastname = new JLabel("Enter the student's last name:");
        JLabel addressLabel = new JLabel("Enter the student's address:");
        JLabel phoneNumberLabel = new JLabel("Enter the student's phone number:");
        JLabel parentPhoneNumberLabel = new JLabel("Enter the student's parent's phone number:");
        JLabel marksLabel = new JLabel("Enter the student's 12th marks:");
        JLabel dataLabel = new JLabel();

        title.setBounds(40, 50, 460, 30);
        firstname.setBounds(30, 80, 200, 30);
        middlename.setBounds(30, 120, 200, 30);
        lastname.setBounds(30, 160, 200, 30);
        addressLabel.setBounds(30, 200, 200, 30);
        phoneNumberLabel.setBounds(30, 240, 200, 30);
        parentPhoneNumberLabel.setBounds(30, 280, 200, 30);
        marksLabel.setBounds(30, 320, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField firstnameTextField = new JTextField();
        JTextField middlenameTextField = new JTextField();
        JTextField lastnameTextField = new JTextField();
        JTextField addressLabelTextField = new JTextField();
        JTextField phoneNumberLabelTextField = new JTextField();
        JTextField parentPhoneNumberLabelTextField = new JTextField();
        JTextField marksLabelTextField = new JTextField();

        firstnameTextField.setBounds(250, 80, 200, 30);
        middlenameTextField.setBounds(250, 120, 200, 30);
        lastnameTextField.setBounds(250, 160, 200, 30);
        addressLabelTextField.setBounds(250, 200, 200, 30);
        phoneNumberLabelTextField.setBounds(250, 240, 200, 30);
        parentPhoneNumberLabelTextField.setBounds(250, 280, 200, 30);
        marksLabelTextField.setBounds(250, 320, 200, 30);

        layeredPane.add(title);
        layeredPane.add(firstname);
        layeredPane.add(middlename);
        layeredPane.add(lastname);
        layeredPane.add(addressLabel);
        layeredPane.add(phoneNumberLabel);
        layeredPane.add(parentPhoneNumberLabel);
        layeredPane.add(marksLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(firstnameTextField);
        layeredPane.add(middlenameTextField);
        layeredPane.add(lastnameTextField);
        layeredPane.add(addressLabelTextField);
        layeredPane.add(phoneNumberLabelTextField);
        layeredPane.add(parentPhoneNumberLabelTextField);
        layeredPane.add(marksLabelTextField);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 360, 100, 30);
        layeredPane.add(back_button);

        JButton save_button = new JButton("Save & create file");
        save_button.setBounds(150, 360, 150, 30);
        layeredPane.add(save_button);

        JButton read_button = new JButton("Read File");
        read_button.setBounds(320, 360, 100, 30);
        layeredPane.add(read_button);

        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame();
            }
        });

        save_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "library.txt";
                String data = "First Name: " + firstnameTextField.getText() + "\n" +
                        "Middle Name: " + middlenameTextField.getText() + "\n" +
                        "Last Name: " + lastnameTextField.getText() + "\n" +
                        "Address: " + addressLabelTextField.getText() + "\n" +
                        "Phone Number: " + phoneNumberLabelTextField.getText() + "\n" +
                        "Parent's Phone Number: " + parentPhoneNumberLabelTextField.getText() + "\n" +
                        "Marks: " + marksLabelTextField.getText() + "\n";

                saveDataToFile(fileName, data);
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        read_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "library.txt";
                displayData(fileName, "Library Data");
            }
        });

        JButton moreInfoButton = new JButton("For more information, click here");
        moreInfoButton.setBounds(30, 400, 400, 30);
        layeredPane.add(moreInfoButton);

        moreInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop()
                            .browse(new URI("https://www.kbpislampur.com/allsubfiles/contact/contact.html"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void sportsComplex() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Welcome to the KBP Sport Complex, Urun-Islampur");
        JLabel firstname = new JLabel("Enter the student's first name:");
        JLabel middlename = new JLabel("Enter the student's middle name:");
        JLabel lastname = new JLabel("Enter the student's last name:");
        JLabel addressLabel = new JLabel("Enter the student's address:");
        JLabel phoneNumberLabel = new JLabel("Enter the student's phone number:");
        JLabel parentPhoneNumberLabel = new JLabel("Enter the student's parent's phone number:");
        JLabel marksLabel = new JLabel("Enter the student's 12th marks:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        firstname.setBounds(30, 80, 200, 30);
        middlename.setBounds(30, 120, 200, 30);
        lastname.setBounds(30, 160, 200, 30);
        addressLabel.setBounds(30, 200, 200, 30);
        phoneNumberLabel.setBounds(30, 240, 200, 30);
        parentPhoneNumberLabel.setBounds(30, 280, 200, 30);
        marksLabel.setBounds(30, 320, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField firstnameTextField = new JTextField();
        JTextField middlenameTextField = new JTextField();
        JTextField lastnameTextField = new JTextField();
        JTextField addressLabelTextField = new JTextField();
        JTextField phoneNumberLabelTextField = new JTextField();
        JTextField parentPhoneNumberLabelTextField = new JTextField();
        JTextField marksLabelTextField = new JTextField();

        firstnameTextField.setBounds(250, 80, 200, 30);
        middlenameTextField.setBounds(250, 120, 200, 30);
        lastnameTextField.setBounds(250, 160, 200, 30);
        addressLabelTextField.setBounds(250, 200, 200, 30);
        phoneNumberLabelTextField.setBounds(250, 240, 200, 30);
        parentPhoneNumberLabelTextField.setBounds(250, 280, 200, 30);
        marksLabelTextField.setBounds(250, 320, 200, 30);

        layeredPane.add(title);
        layeredPane.add(firstname);
        layeredPane.add(middlename);
        layeredPane.add(lastname);
        layeredPane.add(addressLabel);
        layeredPane.add(phoneNumberLabel);
        layeredPane.add(parentPhoneNumberLabel);
        layeredPane.add(marksLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(firstnameTextField);
        layeredPane.add(middlenameTextField);
        layeredPane.add(lastnameTextField);
        layeredPane.add(addressLabelTextField);
        layeredPane.add(phoneNumberLabelTextField);
        layeredPane.add(parentPhoneNumberLabelTextField);
        layeredPane.add(marksLabelTextField);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 360, 100, 30);
        layeredPane.add(back_button);

        JButton save_button = new JButton("Save & create file");
        save_button.setBounds(150, 360, 150, 30);
        layeredPane.add(save_button);

        JButton read_button = new JButton("Read File");
        read_button.setBounds(320, 360, 100, 30);
        layeredPane.add(read_button);

        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame();
            }
        });

        save_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "sports_complex.txt";
                String data = "First Name: " + firstnameTextField.getText() + "\n" +
                        "Middle Name: " + middlenameTextField.getText() + "\n" +
                        "Last Name: " + lastnameTextField.getText() + "\n" +
                        "Address: " + addressLabelTextField.getText() + "\n" +
                        "Phone Number: " + phoneNumberLabelTextField.getText() + "\n" +
                        "Parent's Phone Number: " + parentPhoneNumberLabelTextField.getText() + "\n" +
                        "Marks: " + marksLabelTextField.getText() + "\n";

                saveDataToFile(fileName, data);
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        read_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "sports_complex.txt";
                displayData(fileName, "Sports Complex Data");
            }
        });

        JButton moreInfoButton = new JButton("For more information, click here");
        moreInfoButton.setBounds(30, 400, 400, 30);
        layeredPane.add(moreInfoButton);

        moreInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop()
                            .browse(new URI("https://www.kbpislampur.com/allsubfiles/contact/contact.html"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void hostel() {
        layeredFrame = new JFrame();
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 600));

        JLabel title = new JLabel("Welcome to the ADCET Hostel, Ashta");
        JLabel firstname = new JLabel("Enter the student's first name:");
        JLabel middlename = new JLabel("Enter the student's middle name:");
        JLabel lastname = new JLabel("Enter the student's last name:");
        JLabel addressLabel = new JLabel("Enter the student's address:");
        JLabel phoneNumberLabel = new JLabel("Enter the student's phone number:");
        JLabel parentPhoneNumberLabel = new JLabel("Enter the student's parent's phone number:");
        JLabel marksLabel = new JLabel("Enter the student's 12th marks:");
        JLabel dataLabel = new JLabel();

        title.setBounds(20, 50, 460, 30);
        firstname.setBounds(30, 80, 200, 30);
        middlename.setBounds(30, 120, 200, 30);
        lastname.setBounds(30, 160, 200, 30);
        addressLabel.setBounds(30, 200, 200, 30);
        phoneNumberLabel.setBounds(30, 240, 200, 30);
        parentPhoneNumberLabel.setBounds(30, 280, 200, 30);
        marksLabel.setBounds(30, 320, 200, 30);
        dataLabel.setBounds(30, 400, 500, 200);

        JTextField firstnameTextField = new JTextField();
        JTextField middlenameTextField = new JTextField();
        JTextField lastnameTextField = new JTextField();
        JTextField addressLabelTextField = new JTextField();
        JTextField phoneNumberLabelTextField = new JTextField();
        JTextField parentPhoneNumberLabelTextField = new JTextField();
        JTextField marksLabelTextField = new JTextField();

        firstnameTextField.setBounds(250, 80, 200, 30);
        middlenameTextField.setBounds(250, 120, 200, 30);
        lastnameTextField.setBounds(250, 160, 200, 30);
        addressLabelTextField.setBounds(250, 200, 200, 30);
        phoneNumberLabelTextField.setBounds(250, 240, 200, 30);
        parentPhoneNumberLabelTextField.setBounds(250, 280, 200, 30);
        marksLabelTextField.setBounds(250, 320, 200, 30);

        layeredPane.add(title);
        layeredPane.add(firstname);
        layeredPane.add(middlename);
        layeredPane.add(lastname);
        layeredPane.add(addressLabel);
        layeredPane.add(phoneNumberLabel);
        layeredPane.add(parentPhoneNumberLabel);
        layeredPane.add(marksLabel);
        layeredPane.add(dataLabel);

        layeredPane.add(firstnameTextField);
        layeredPane.add(middlenameTextField);
        layeredPane.add(lastnameTextField);
        layeredPane.add(addressLabelTextField);
        layeredPane.add(phoneNumberLabelTextField);
        layeredPane.add(parentPhoneNumberLabelTextField);
        layeredPane.add(marksLabelTextField);

        JButton back_button = new JButton("Back");
        back_button.setBounds(30, 360, 100, 30);
        layeredPane.add(back_button);

        JButton save_button = new JButton("Save & create file");
        save_button.setBounds(150, 360, 150, 30);
        layeredPane.add(save_button);

        JButton read_button = new JButton("Read File");
        read_button.setBounds(320, 360, 100, 30);
        layeredPane.add(read_button);

        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredFrame.dispose();
                switchFrame();
            }
        });

        save_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "hostel.txt";
                String data = "First Name: " + firstnameTextField.getText() + "\n" +
                        "Middle Name: " + middlenameTextField.getText() + "\n" +
                        "Last Name: " + lastnameTextField.getText() + "\n" +
                        "Address: " + addressLabelTextField.getText() + "\n" +
                        "Phone Number: " + phoneNumberLabelTextField.getText() + "\n" +
                        "Parent's Phone Number: " + parentPhoneNumberLabelTextField.getText() + "\n" +
                        "Marks: " + marksLabelTextField.getText() + "\n";

                saveDataToFile(fileName, data);
            }
        });

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\paras\\Downloads\\ADCET_PARAS.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        read_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = "hostel.txt";
                displayData(fileName, "Hostel Data");
            }
        });

        JButton moreInfoButton = new JButton("For more information, click here");
        moreInfoButton.setBounds(30, 400, 400, 30);
        layeredPane.add(moreInfoButton);

        moreInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop()
                            .browse(new URI("https://www.kbpislampur.com/allsubfiles/contact/contact.html"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        layeredFrame.setContentPane(layeredPane);
        layeredFrame.pack();
        layeredFrame.setLocationRelativeTo(null);
        layeredFrame.setVisible(true);
    }

    public static void saveDataToFile(String fileName, String data) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.append(data);
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "File Created Successfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error in Creating File");
        }
    }

    public static String readDataFromFile(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error in Reading File");
        }
        return fileContent.toString();
    }

    public static void displayData(String fileName, String frameTitle) {
        JFrame dataFrame = new JFrame(frameTitle);
        JTextArea dataTextArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(dataTextArea);
        dataTextArea.setEditable(false);

        String data = readDataFromFile(fileName);
        dataTextArea.setText(data);

        dataFrame.add(scrollPane);
        dataFrame.pack();
        dataFrame.setLocationRelativeTo(null);
        dataFrame.setVisible(true);
    }

    public static void main(String[] args) {
        login();
    }
}