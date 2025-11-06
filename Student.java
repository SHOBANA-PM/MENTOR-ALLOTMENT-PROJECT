package db;
public class Student {
 private int studentId;
 private String studentName;
 private String department;
 private int mentorId;
 public Student(int studentId, String studentName, String department, int mentorId) {
 this.studentId = studentId;
 this.studentName = studentName;
 this.department = department;
 this.mentorId = mentorId;
 }
 public int getStudentId() { return studentId; }
 public String getStudentName() { return studentName; }
 public String getDepartment() { return department; }
 public int getMentorId() { return mentorId; }
 @Override
 public String toString() {
   return "Student [ID=" + studentId + ", Name=" + studentName + ", Dept=" + 
department + ", MentorID=" + mentorId + "]";
 }
}
