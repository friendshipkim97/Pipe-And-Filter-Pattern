/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package component.filter;

import component.constant.Constants.EAdvancedCourseFilter;
import component.domain.Course;
import component.domain.Student;
import component.utility.LineUtility;
import framework.CommonFilterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedCourseFilter extends CommonFilterImpl{

    LineUtility lineUtility;
    String courseLine;
    String studentLine;
    Student student;
    List<Course> courses;
    Course course;
    boolean advancedCourseCheck;
    List<String> advancedCourses;

    public AdvancedCourseFilter() { this.courses = new ArrayList<>(); }

    @Override
    public boolean specificComputationForFilter() throws IOException {

        while (true){
            this.lineUtility = new LineUtility();
            this.courseLine = this.lineUtility.readCourseLine(this.in.get(EAdvancedCourseFilter.ePortOne.getNumber()));
            if(!this.courseLine.trim().isEmpty()) {
                this.course = new Course(this.courseLine);
                this.courses.add(this.course); }
            if(this.lineUtility.getByte_read() == EAdvancedCourseFilter.eMinusOne.getNumber()) { break; } }

        while (true){
            this.lineUtility = new LineUtility();
            this.studentLine = this.lineUtility.readStudentLine(this.in.get(EAdvancedCourseFilter.ePortZero.getNumber()));
            if(this.studentLine.startsWith(EAdvancedCourseFilter.eReadComplete.getContent())) return EAdvancedCourseFilter.eTrue.isCheck();
            if(!this.studentLine.trim().isEmpty()) {
                this.student = new Student(this.studentLine);
                // 해당 라인의 선강좌정보 가져오기
                this.advancedCourses = getAllAdvancedCourses(this.student, this.courses);
                // 선강좌정보 중복제거
                this.advancedCourses = this.advancedCourses.stream().distinct().collect(Collectors.toList());
                // 강좌가 선강좌를 듣고 있는지 체크
                this.advancedCourseCheck = checkAdvancedCourse(this.student, this.advancedCourses);
                if(this.advancedCourseCheck) this.lineUtility.writeLine(this.studentLine, this.out.get(EAdvancedCourseFilter.ePortZero.getNumber()));
                else this.lineUtility.writeLine(this.studentLine, this.out.get(EAdvancedCourseFilter.ePortOne.getNumber())); } } }

    private boolean checkAdvancedCourse(Student student, List<String> advancedCourses) {
        boolean advancedCourseCheck = EAdvancedCourseFilter.eTrue.isCheck();
        for (String advancedCourse : advancedCourses) {
            if(student.getCourses().contains(advancedCourse) == EAdvancedCourseFilter.eFalse.isCheck()) {
                advancedCourseCheck = EAdvancedCourseFilter.eFalse.isCheck(); } }
        return advancedCourseCheck; }
    private List<String> getAllAdvancedCourses(Student student, List<Course> courses) {
        List<String> advancedCourses = new ArrayList<>();
        for (String studentCourse : student.getCourses()) {
            for (Course tempCourse : courses) {
                if(tempCourse.getCourseNumber().equals(studentCourse) &&
                        tempCourse.getAdvancedCourseNumbers().size() != EAdvancedCourseFilter.eSizeZero.getNumber()){
                    advancedCourses.addAll(tempCourse.getAdvancedCourseNumbers()); } } }
        return advancedCourses; }

}

