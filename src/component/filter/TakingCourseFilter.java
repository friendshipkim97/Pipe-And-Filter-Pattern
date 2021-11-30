package component.filter;

import component.constant.Constants.ETakingCourseFilter;
import component.domain.Student;
import component.utility.LineUtility;
import framework.CommonFilterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TakingCourseFilter extends CommonFilterImpl {

    LineUtility lineUtility;
    String line;
    Student student;
    private List<String> courseList;
    private boolean haveToTakingCourse;

    public TakingCourseFilter(boolean haveToTakingCourse, String... courses) {
        this.haveToTakingCourse = haveToTakingCourse;
        this.courseList = new ArrayList();
        for (String course : courses) { this.courseList.add(course); } }

    @Override
    public boolean specificComputationForFilter() throws IOException {
        while (true) {
            this.lineUtility = new LineUtility();
            this.line = this.lineUtility.readStudentLine(this.in.get(ETakingCourseFilter.ePortZero.getNumber()));
            if(this.line.startsWith(ETakingCourseFilter.eReadComplete.getContent())) return ETakingCourseFilter.eTrue.isCheck();
            if(!this.line.trim().isEmpty()) {
                this.student = new Student(this.line);
                if(this.haveToTakingCourse) {addCourse();}
                else {deleteCourse();}
                this.line = this.lineUtility.makeStudentLine(this.student);
                this.lineUtility.writeLine(this.line, this.out.get(ETakingCourseFilter.ePortZero.getNumber())); } } }

    public void addCourse(){
        for (String course : courseList) {
            if (!this.student.courseCheck(course)) {
                this.student.addCourse(course); } } }
    public void deleteCourse(){
        for (String course : courseList) {
            if (this.student.courseCheck(course)) {
                this.student.deleteCourse(course); } } }
}
