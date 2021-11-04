package Components.utility;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseNumber;
    private String professorLastName;
    private String courseName;
    private List<String> advancedCourseNumbers;

    public Course(String line) {

        advancedCourseNumbers = new ArrayList<>();
        String[] strAry = line.split(" ");

        for (int i=0; i<strAry.length; i++) {
            if(i == 0) this.courseNumber = strAry[i];
            else if(i == 1) this.professorLastName = strAry[i];
            else if(i == 2) this.courseName = strAry[i];
            else if(i >= 3) { String tempCourse = strAry[i].trim();
                this.advancedCourseNumbers.add(tempCourse); }
        }
    }

    /**
     * getters and setters
     */
    public String getCourseNumber() { return courseNumber; }
    public void setCourseNumber(String courseNumber) { this.courseNumber = courseNumber; }
    public String getProfessorLastName() { return professorLastName; }
    public void setProfessorLastName(String professorLastName) { this.professorLastName = professorLastName; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public List<String> getAdvancedCourseNumbers() { return advancedCourseNumbers; }
    public void setAdvancedCourseNumbers(List<String> advancedCourseNumbers) { this.advancedCourseNumbers = advancedCourseNumbers; }
}
