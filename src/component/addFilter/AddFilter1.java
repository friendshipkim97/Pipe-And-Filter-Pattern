package component.addFilter;

import component.utility.FileUtility;
import component.domain.Student;
import component.utility.LineUtility;
import framework.CommonFilterImpl;

import java.io.IOException;

public class AddFilter1 extends CommonFilterImpl {

    @Override
    public boolean specificComputationForFilter() throws IOException {

        LineUtility lineUtility;
        String line;
        Student student;

        while (true) {
            lineUtility = new LineUtility();
            line = lineUtility.readStudentLine(in.get(0));
            if(line.startsWith("readComplete")) return true;
            if(!line.trim().isEmpty()) {
                student = new Student(line);
                if (!student.courseCheck("12345")) {
                    student.addCourse("12345"); }
                if (!student.courseCheck("23456")) {
                    student.addCourse("23456"); }
                line = lineUtility.makeStudentLine(student);
                lineUtility.writeLine(line, out.get(0));
            }
        }
    }
}
