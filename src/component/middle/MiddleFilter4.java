/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package component.middle;

import component.utility.Course;
import component.utility.FileUtility;
import component.utility.Student;
import framework.CommonFilterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MiddleFilter4 extends CommonFilterImpl{
    @Override
    public boolean specificComputationForFilter() throws IOException {
        FileUtility fileUtility;
        String courseLine;
        String studentLine;
        Student student;
        List<Course> courses = new ArrayList<>();
        Course course;
        boolean advancedCourseCheck;
        List<String> advancedCourses;

        while (true){
            fileUtility = new FileUtility();
            courseLine = fileUtility.readCourseLine(in.get(1));
            if(!courseLine.trim().isEmpty()) {
                course = new Course(courseLine);
                courses.add(course);
            }
            if(fileUtility.getByte_read() == -1) { break; }
        }

        while (true){
            fileUtility = new FileUtility();
            studentLine = fileUtility.readStudentLine(in.get(0));
            if(studentLine.startsWith("readComplete")) return true;
            if(!studentLine.trim().isEmpty()) {
                student = new Student(studentLine);
                // 해당 라인의 선강좌정보 가져오기
                advancedCourses = getAllAdvancedCourses(student, courses);
                // 선강좌정보 중복제거
                advancedCourses = advancedCourses.stream().distinct().collect(Collectors.toList());
                // 강좌가 선강좌를 듣고 있는지 체크
                advancedCourseCheck = checkAdvancedCourse(student, advancedCourses);
                if(advancedCourseCheck) fileUtility.writeLine(studentLine, out.get(0));
                else  fileUtility.writeLine(studentLine, out.get(1));
                }
            }
        }

    private boolean checkAdvancedCourse(Student student, List<String> advancedCourses) {
        boolean advancedCourseCheck = true;
        for (String advancedCourse : advancedCourses) {
            if(student.getCourses().contains(advancedCourse) == false) {
                advancedCourseCheck = false; } }
        return advancedCourseCheck;
    }

    private List<String> getAllAdvancedCourses(Student student, List<Course> courses) {
        List<String> advancedCourses = new ArrayList<>();
        for (String studentCourse : student.getCourses()) {
            for (Course tempCourse : courses) {
                if(tempCourse.getCourseNumber().equals(studentCourse) && tempCourse.getAdvancedCourseNumbers().size() != 0){
                    advancedCourses.addAll(tempCourse.getAdvancedCourseNumbers()); } } }
        return advancedCourses;
    }

}

