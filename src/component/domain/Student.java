package component.domain;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentNumber;
    private String lastName;
    private String firstName;
    private String major;
    private List<String> courses;

    public Student(String line) {

        courses = new ArrayList<>();
        String[] strAry = line.split(" ");

        for (int i=0; i<strAry.length; i++) {
            if(i == 0) this.studentNumber = strAry[i];
            else if(i == 1) this.lastName = strAry[i];
            else if(i == 2) this.firstName = strAry[i];
            else if(i == 3) this.major = strAry[i];
            else if(i >= 4) { String tempCourse = strAry[i].trim();
            this.courses.add(tempCourse); }
        }
    }

    public boolean majorCheck(String major){
        if(this.major.equals(major)) return true;
        else return false;
    }

    public boolean courseCheck(String course) {
        if(!this.courses.isEmpty()) {
            for (String tempCourse : courses) {
                if (tempCourse.equals(course)) {
                    return true; }
            }
        }
        return false;
    }

    public boolean studentNumberCheck(String studentNumber) {
        if(this.studentNumber.startsWith(studentNumber)) return true;
        else return false;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }

    public void deleteCourse(String course) {
        this.courses.remove(course);
    }

    /**
     * getters and Setters
     */
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public List<String> getCourses() { return courses; }
    public void setCourses(List<String> courses) { this.courses = courses; }

}
