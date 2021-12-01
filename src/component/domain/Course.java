package component.domain;

import component.constant.Constants.ECourse;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseNumber;
    private String professorLastName;
    private String courseName;
    private List<String> advancedCourseNumbers;

    public Course(String line) {

        advancedCourseNumbers = new ArrayList<>();
        String[] strAry = line.split(ECourse.eSpace.getContent());

        for (int i = ECourse.eSizeZero.getNumber(); i<strAry.length; i++) {
            if(i == ECourse.eSizeZero.getNumber()) this.courseNumber = strAry[i];
            else if(i == ECourse.eSizeOne.getNumber()) this.professorLastName = strAry[i];
            else if(i == ECourse.eSizeTwo.getNumber()) this.courseName = strAry[i];
            else if(i >= ECourse.eSizeThree.getNumber()) { String tempCourse = strAry[i].trim();
                this.advancedCourseNumbers.add(tempCourse); } } }

    /**
     * getters
     */

    public String getCourseNumber() { return courseNumber; }
    public List<String> getAdvancedCourseNumbers() { return advancedCourseNumbers; }
}
