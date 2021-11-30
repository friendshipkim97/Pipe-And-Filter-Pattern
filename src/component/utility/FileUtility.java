package component.utility;

import component.constant.Constants.EFileUtility;

import java.io.*;

public class FileUtility {

    public boolean readFile(PipedOutputStream out, String sourceFile) throws IOException {
        int byte_read;
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File(sourceFile)));
        while(true) {
            byte_read = br.read();
            if (byte_read == EFileUtility.eMinusOne.getNumber()) return EFileUtility.eTrue.isCheck();
            out.write(byte_read); } }

    public boolean writeFile(PipedInputStream in, String sinkFile) throws IOException {
        int byte_read;
        FileWriter fw = new FileWriter(sinkFile);
        while(true) {
            byte_read = in.read();
            if (byte_read == EFileUtility.eMinusOne.getNumber()) {
                fw.close();
                System.out.print(EFileUtility.eFilteringFinishMessage.getContent());
                return EFileUtility.eTrue.isCheck(); }
            fw.write((char)byte_read); } }

}

