package Components.AddFilter;

import Framework.CommonFilterImpl;

import java.io.IOException;

public class AddFilter1 extends CommonFilterImpl {

    @Override
    public boolean specificComputationForFilter() throws IOException {
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];
        boolean is12345 = false;
        boolean is23456 = false;
        int byte_read = 0;

        while(true) {
            while(byte_read != '\n' && byte_read != -1) {
                byte_read = in.read();
                if(byte_read == ' ') numOfBlank++;
                if(byte_read != -1) buffer[idx++] = (byte)byte_read;
                if(numOfBlank >= 4 && buffer[idx-6] == '1' && buffer[idx-5] == '2' &&
                        buffer[idx-4] == '3' && buffer[idx-3] == '4' && buffer[idx-2] == '5')
                    is12345 = true;
                if(numOfBlank >= 4 && buffer[idx-6] == '2' && buffer[idx-5] == '3' &&
                        buffer[idx-4] == '4' && buffer[idx-3] == '5' && buffer[idx-2] == '6')
                    is23456 = true;
            }
            for(int i = 0; i<idx-2; i++)
                out.write((char)buffer[i]);

            // 12345 없으면 넣기
            if(idx >= 3 && is12345 == false){
                if(numOfBlank != 4){
                    out.write(' ');
                }
                out.write('1');
                out.write('2');
                out.write('3');
                out.write('4');
                out.write('5');
            }
            // 23456 없으면 넣기
            if(idx >= 3 && is23456 == false){
                out.write(' ');
                out.write('2');
                out.write('3');
                out.write('4');
                out.write('5');
                out.write('6');
            }
            if (byte_read == -1) return true;
            out.write((char)buffer[idx-2]);
            out.write((char)buffer[idx-1]);
            is12345 = false;
            is23456 = false;
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }
}
