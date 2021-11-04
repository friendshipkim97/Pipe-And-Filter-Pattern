/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Components.Middle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import Components.utility.FileUtility;
import Components.utility.Student;
import Framework.CommonFilterImpl;

public class MiddleFilter1 extends CommonFilterImpl {
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
                if(student.majorCheck("CS")){
                    fileUtility.writeLine(line, out.get(0)); }
                }
            }

        }
    }





