package component.addFilter;

import component.utility.FileUtility;
import component.utility.Student;
import framework.CommonFilterImpl;

import java.io.IOException;

public class AddFilter2 extends CommonFilterImpl {

    @Override
    public boolean specificComputationForFilter() throws IOException {

        FileUtility fileUtility;
        String line;
        Student student;

        while (true) {
            fileUtility = new FileUtility();
            line = fileUtility.readStudentLine(in.get(0));
            if(line.startsWith("readComplete")) return true;
            if(!line.trim().isEmpty()) {
                student = new Student(line);
                if (!student.courseCheck("23456")) {
                    student.addCourse("23456"); }
                line = fileUtility.makeStudentLine(student);
                fileUtility.writeLine(line, out.get(0));
            }
        }
    }
}
