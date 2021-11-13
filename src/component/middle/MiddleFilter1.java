/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package component.middle;

import java.io.IOException;

import component.utility.FileUtility;
import component.domain.Student;
import component.utility.LineUtility;
import framework.CommonFilterImpl;

public class MiddleFilter1 extends CommonFilterImpl {
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
                if(student.majorCheck("CS")){
                    lineUtility.writeLine(line, out.get(0)); } } }

        }
    }





