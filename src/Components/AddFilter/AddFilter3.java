package Components.AddFilter;

import Framework.CommonFilterImpl;

import java.io.IOException;

public class AddFilter3 extends CommonFilterImpl {

    @Override
    public boolean specificComputationForFilter() throws IOException {
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];

        boolean is17651 = false;
        int index17651 = 0;
        int byte_read = 0;

        while(true) {
            while(byte_read != '\n' && byte_read != -1) {
                byte_read = in.read();
                if(byte_read == ' ') numOfBlank++;
                if(byte_read != -1) buffer[idx++] = (byte)byte_read;
                if(numOfBlank >= 4 && buffer[idx-6] == '1' && buffer[idx-5] == '7' &&
                        buffer[idx-4] == '6' && buffer[idx-3] == '5' && buffer[idx-2] == '1'){
                    index17651 = idx-6;
                    is17651 = true;
                }
            }

            // 17651 있으면 제거
            if(is17651 == true){
                for(int i = 0; i<index17651; i++){
                    out.write((char)buffer[i]);
                }
                for(int j = index17651+6; j<idx-2; j++){
                    out.write((char)buffer[j]);
                }
            } else{
                for(int i = 0; i<idx-2; i++)
                    out.write((char)buffer[i]);
            }

            if (byte_read == -1) return true;
            out.write((char)buffer[idx-2]);
            out.write((char)buffer[idx-1]);
            is17651 = false;
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }
}
