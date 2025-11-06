package db;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MentorAllotmentUI extends JFrame {
 private JTextField mentorNameField, mentorDeptField;
 private JTextField studentNameField, studentDeptField, mentorIdField;
 private JTextArea outputArea;
 public MentorAllotmentUI() {
 setTitle("Mentor Allotment System");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setSize(600, 500);
 setLayout(new BorderLayout());
 // ======= TOP PANEL =======
 JPanel topPanel = new JPanel(new GridLayout(2, 1));
   // Mentor input section
 JPanel mentorPanel = new JPanel();
 mentorPanel.setBorder(BorderFactory.createTitledBorder("Add Mentor"));
 mentorPanel.add(new JLabel("Name:"));
 mentorNameField = new JTextField(10);
 mentorPanel.add(mentorNameField);
 mentorPanel.add(new JLabel("Dept:"));
 mentorDeptField = new JTextField(10);
 mentorPanel.add(mentorDeptField);
 JButton addMentorBtn = new JButton("Add Mentor");
 mentorPanel.add(addMentorBtn);
 // Student input section
 JPanel studentPanel = new JPanel();
 studentPanel.setBorder(BorderFactory.createTitledBorder("Add Student"));
 studentPanel.add(new JLabel("Name:"));
 studentNameField = new JTextField(10);
 studentPanel.add(studentNameField);
 studentPanel.add(new JLabel("Dept:"));
 studentDeptField = new JTextField(10);
 studentPanel.add(studentDeptField);
 studentPanel.add(new JLabel("Mentor ID:"));
 mentorIdField = new JTextField(5);
 studentPanel.add(mentorIdField);
 JButton addStudentBtn = new JButton("Add Student");
 studentPanel.add(addStudentBtn);
 topPanel.add(mentorPanel);
 topPanel.add(studentPanel);
   // ======= CENTER OUTPUT AREA =======
 outputArea = new JTextArea();
 outputArea.setEditable(false);
 JScrollPane scroll = new JScrollPane(outputArea);
 // ======= BOTTOM BUTTONS =======
 JPanel bottomPanel = new JPanel();
 JButton showAllotmentsBtn = new JButton("Show Allotments");
 bottomPanel.add(showAllotmentsBtn);
 add(topPanel, BorderLayout.NORTH);
 add(scroll, BorderLayout.CENTER);
 add(bottomPanel, BorderLayout.SOUTH);
 // ======= BUTTON ACTIONS =======
 addMentorBtn.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 String name = mentorNameField.getText();
 String dept = mentorDeptField.getText();
 if (!name.isEmpty() && !dept.isEmpty()) {
 DBOperations.addMentor(name, dept);
 outputArea.append("Added Mentor: " + name + " (" + dept + ")\n");
 mentorNameField.setText("");
 mentorDeptField.setText("");
 } else {
 JOptionPane.showMessageDialog(null, "Please fill all mentor fields!");
 }
 }
 });
   addStudentBtn.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 String name = studentNameField.getText();
 String dept = studentDeptField.getText();
 String mentorId = mentorIdField.getText();
 if (!name.isEmpty() && !dept.isEmpty() && !mentorId.isEmpty()) {
 try {
 DBOperations.addStudent(name, dept, Integer.parseInt(mentorId));
 outputArea.append("Added Student: " + name + " (" + dept + ")\n");
 studentNameField.setText("");
 studentDeptField.setText("");
 mentorIdField.setText("");
 } catch (NumberFormatException ex) {
 JOptionPane.showMessageDialog(null, "Mentor ID must be a number!");
 }
 } else {
 JOptionPane.showMessageDialog(null, "Please fill all student fields!");
 }
 }
 });
 showAllotmentsBtn.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 outputArea.append("\n--- Student-Mentor Allotments ---\n");
 DBOperations.showAllotments();
 }
 });
 setVisible(true);
   }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(() -> new MentorAllotmentUI());
 }
}
