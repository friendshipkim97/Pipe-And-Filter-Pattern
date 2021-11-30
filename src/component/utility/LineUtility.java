package component.utility;

import component.constant.Constants.ELineUtility;
import component.domain.Student;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

public class LineUtility {

    byte[] buffer = new byte[ELineUtility.eBytes64.getNumber()];
    int idx = ELineUtility.eSizeZero.getNumber();
    String line;
    byte[] bytes;
    int byte_read = ELineUtility.eSizeZero.getNumber();

    public String readStudentLine(PipedInputStream in) throws IOException {
        while (byte_read != ELineUtility.eEnter.getNumber() && byte_read != ELineUtility.eMinusOne.getNumber()) {
            byte_read = in.read();
            if (byte_read != ELineUtility.eMinusOne.getNumber()) buffer[idx++] = (byte) byte_read; }
        line = new String(buffer);
        if(byte_read == ELineUtility.eMinusOne.getNumber()) { line = ELineUtility.eReadComplete.getContent(); }
        return line; }

    public String readCourseLine(PipedInputStream in) throws IOException {
        while (byte_read != ELineUtility.eEnter.getNumber() && byte_read != ELineUtility.eMinusOne.getNumber()) {
            byte_read = in.read();
            if (byte_read != ELineUtility.eMinusOne.getNumber()) buffer[idx++] = (byte) byte_read; }
        line = new String(buffer);
        return line; }

    public void writeLine(String line, PipedOutputStream out) throws IOException {
        bytes = line.getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            if (aByte != ELineUtility.eSizeZero.getNumber())
                out.write(aByte); } }

    public String makeStudentLine(Student student) {
        String line = student.getStudentNumber() + ELineUtility.eSpace.getContent() + student.getLastName() + ELineUtility.eSpace.getContent()
                + student.getFirstName() + ELineUtility.eSpace.getContent() + student.getMajor();
        String courseLine = ELineUtility.eEmpty.getContent();
        if(!student.getCourses().isEmpty()){
            for (String course : student.getCourses()) {
                String tempCourse = course.trim();
                courseLine += ELineUtility.eSpace.getContent() + tempCourse; } }
        return line + courseLine + ELineUtility.eEnterString.getContent(); }

    public int getByte_read() { return byte_read; }
}
