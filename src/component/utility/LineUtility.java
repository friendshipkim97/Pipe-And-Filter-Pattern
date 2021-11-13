package component.utility;

import component.domain.Student;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

public class LineUtility {

    byte[] buffer = new byte[64];
    int idx = 0;
    String line;
    byte[] bytes;
    int byte_read = 0;

    public String readStudentLine(PipedInputStream in) throws IOException {
        while (byte_read != '\n' && byte_read != -1) {
            byte_read = in.read();
            if (byte_read != -1) buffer[idx++] = (byte) byte_read;
        }
        line = new String(buffer);
        if(byte_read == -1) { line = "readComplete"; }
        return line;
    }

    public String readCourseLine(PipedInputStream in) throws IOException {
        while (byte_read != '\n' && byte_read != -1) {
            byte_read = in.read();
            if (byte_read != -1) buffer[idx++] = (byte) byte_read;
        }
        line = new String(buffer);
        return line;
    }

    public void writeLine(String line, PipedOutputStream out) throws IOException {
        bytes = line.getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            if (aByte != 0)
                out.write(aByte);
        }
    }

    public String makeStudentLine(Student student) {
        String line = student.getStudentNumber() + " " + student.getLastName() + " "
                + student.getFirstName() + " " + student.getMajor();
        String courseLine = "";
        if(!student.getCourses().isEmpty()){
            for (String course : student.getCourses()) {
                String tempCourse = course.trim();
                courseLine += " " + tempCourse;
            }
        }
        return line + courseLine + "\n";
    }

    public int getByte_read() { return byte_read; }
}
