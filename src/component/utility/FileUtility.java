package component.utility;

import component.domain.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtility {

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

}

