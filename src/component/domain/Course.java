package component.domain;

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
     * getters
     */

    public String getCourseNumber() { return courseNumber; }
    public List<String> getAdvancedCourseNumbers() { return advancedCourseNumbers; }
}
