package Components.AddFilter;

import Framework.CommonFilterImpl;

import java.io.IOException;

public class AddFilter4 extends CommonFilterImpl {

    @Override
    public boolean specificComputationForFilter() throws IOException {
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];

        boolean is17652 = false;
        int index17652 = 0;
        int byte_read = 0;

        while(true) {
            while(byte_read != '\n' && byte_read != -1) {
                byte_read = in.read();
                if(byte_read == ' ') numOfBlank++;
                if(byte_read != -1) buffer[idx++] = (byte)byte_read;
                if(numOfBlank >= 4 && buffer[idx-6] == '1' && buffer[idx-5] == '7' &&
                        buffer[idx-4] == '6' && buffer[idx-3] == '5' && buffer[idx-2] == '2'){
                    index17652 = idx-6;
                    is17652 = true;
                }
            }

            if(is17652 == true){
                for(int i = 0; i<index17652; i++){
                    out.write((char)buffer[i]);
                }
                for(int j = index17652+6; j<idx-2; j++){
                    out.write((char)buffer[j]);
                }
            } else{
                for(int i = 0; i<idx-2; i++){
                    out.write((char)buffer[i]);
                }
            }
            if (byte_read == -1) return true;
            out.write((char)buffer[idx-2]);
            out.write((char)buffer[idx-1]);
            is17652 = false;
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }
}
