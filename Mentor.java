package db;
public class Mentor {
 private int mentorId;
 private String mentorName;
 private String department;
 public Mentor(int mentorId, String mentorName, String department) {
 this.mentorId = mentorId;
 this.mentorName = mentorName;
 this.department = department;
 }
 public int getMentorId() { return mentorId; }
  public String getMentorName() { return mentorName; }
 public String getDepartment() { return department; }
 @Override
 public String toString() {
 return "Mentor [ID=" + mentorId + ", Name=" + mentorName + ", Department=" + 
department + "]";
 }
}
