/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package component.filter;

import component.constant.Constants.EStudentMajorFilter;
import component.domain.Student;
import component.utility.LineUtility;
import framework.CommonFilterImpl;

import java.io.IOException;

public class StudentMajorFilter extends CommonFilterImpl {

    LineUtility lineUtility;
    String line;
    Student student;
    private String major;
    private boolean haveToBeMajor;

    public StudentMajorFilter(String major, boolean haveToBeMajor) {
        this.major = major;
        this.haveToBeMajor = haveToBeMajor; }

    @Override
    public boolean specificComputationForFilter() throws IOException {
        while (true) {
            this.lineUtility = new LineUtility();
            this.line = this.lineUtility.readStudentLine(this.in.get(EStudentMajorFilter.ePortZero.getNumber()));
            if (this.line.startsWith(EStudentMajorFilter.eReadComplete.getContent())) return EStudentMajorFilter.eTrue.isCheck();
            if (!this.line.trim().isEmpty()) {
                this.student = new Student(this.line);
                if (this.haveToBeMajor) { writeLineByMajor(); }
                else { writeLineByNotMajor(); } } } }

    private void writeLineByMajor() throws IOException {
        if (this.student.majorCheck(this.major)) {
            this.lineUtility.writeLine(this.line, this.out.get(EStudentMajorFilter.ePortZero.getNumber())); } }
    private void writeLineByNotMajor() throws IOException {
        if (!student.majorCheck(this.major)) {
            this.lineUtility.writeLine(this.line, this.out.get(EStudentMajorFilter.ePortZero.getNumber())); } }
}





