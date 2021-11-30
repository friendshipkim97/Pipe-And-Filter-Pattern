/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package component.filter;

import component.constant.Constants.EStudentNumberFilter;
import component.domain.Student;
import component.utility.LineUtility;
import framework.CommonFilterImpl;

import java.io.IOException;

public class StudentNumberFilter extends CommonFilterImpl{

    LineUtility lineUtility;
    String line;
    Student student;
    private String studentNumber;

    public StudentNumberFilter(String studentNumber) { this.studentNumber = studentNumber; }

    @Override
    public boolean specificComputationForFilter() throws IOException {
        while (true) {
            this.lineUtility = new LineUtility();
            this.line = this.lineUtility.readStudentLine(this.in.get(EStudentNumberFilter.ePortZero.getNumber()));
            if(this.line.startsWith(EStudentNumberFilter.eReadComplete.getContent())) return EStudentNumberFilter.eTrue.isCheck();
            if(!this.line.trim().isEmpty()) {
                this.student = new Student(this.line);
                if(student.studentNumberCheck(this.studentNumber)){
                    this.lineUtility.writeLine(this.line, this.out.get(EStudentNumberFilter.ePortZero.getNumber())); } } } }
}
