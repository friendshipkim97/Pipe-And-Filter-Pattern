package component.utility;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtility {

    byte[] buffer = new byte[64];
    int byte_read = 0;
    int idx = 0;
    String line;
    byte[] bytes;

    public boolean readFile(PipedOutputStream out, String sourceFile) throws IOException {
        int byte_read;
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File(sourceFile)));
        while(true) {
            byte_read = br.read();
            if (byte_read == -1) return true;
            out.write(byte_read);
        }
    }

    public boolean writeFile(PipedInputStream in, String sinkFile) throws IOException {
        int byte_read;
        FileWriter fw = new FileWriter(sinkFile);
        while(true) {
            byte_read = in.read();
            if (byte_read == -1) {
                fw.close();
                System.out.print( "::Filtering is finished; Output file is created." );
                return true;
            }
            fw.write((char)byte_read);
        }
    }

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

