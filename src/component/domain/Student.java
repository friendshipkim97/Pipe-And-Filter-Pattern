package component.domain;

import component.constant.Constants.EStudent;

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
        String[] strAry = line.split(EStudent.eSpace.getContent());

        for (int i = EStudent.eSizeZero.getNumber(); i<strAry.length; i++) {
            if(i == EStudent.eSizeZero.getNumber()) this.studentNumber = strAry[i];
            else if(i == EStudent.eSizeOne.getNumber()) this.lastName = strAry[i];
            else if(i == EStudent.eSizeTwo.getNumber()) this.firstName = strAry[i];
            else if(i == EStudent.eSizeThree.getNumber()) this.major = strAry[i];
            else if(i >= EStudent.eSizeFour.getNumber()) { String tempCourse = strAry[i].trim();
            this.courses.add(tempCourse); } } }

    public boolean majorCheck(String major){
        if(this.major.equals(major)) return EStudent.eTrue.isCheck();
        else return EStudent.eFalse.isCheck(); }
    public boolean courseCheck(String course) {
        if(!this.courses.isEmpty()) {
            for (String tempCourse : courses) {
                if (tempCourse.equals(course)) {
                    return EStudent.eTrue.isCheck(); } } }
        return EStudent.eFalse.isCheck(); }
    public boolean studentNumberCheck(String studentNumber) {
        if(this.studentNumber.startsWith(studentNumber)) return EStudent.eTrue.isCheck();
        else return EStudent.eFalse.isCheck(); }
    public void addCourse(String course) {
        this.courses.add(course);
    }
    public void deleteCourse(String course) {
        this.courses.remove(course);
    }

    /**
     * getters
     */

    public String getStudentNumber() { return studentNumber; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMajor() { return major; }
    public List<String> getCourses() { return courses; }

}
