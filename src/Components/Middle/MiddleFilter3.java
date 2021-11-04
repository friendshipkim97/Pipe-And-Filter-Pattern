/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Components.Middle;

import Components.utility.FileUtility;
import Components.utility.Student;
import Framework.CommonFilterImpl;

import java.io.IOException;

public class MiddleFilter3 extends CommonFilterImpl{
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
                if(student.studentNumberCheck("2013") && !student.majorCheck("CS")){
                    fileUtility.writeLine(line, out.get(0)); }
            }
        }
    }  
}
