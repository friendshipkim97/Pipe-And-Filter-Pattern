/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package component.middle;

import component.utility.FileUtility;
import component.domain.Student;
import component.utility.LineUtility;
import framework.CommonFilterImpl;

import java.io.IOException;

public class MiddleFilter2 extends CommonFilterImpl{
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
                if(student.majorCheck("EE")){
                    lineUtility.writeLine(line, out.get(0)); } } }
    }  
}
