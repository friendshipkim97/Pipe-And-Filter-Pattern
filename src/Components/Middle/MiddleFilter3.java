/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Components.Middle;

import Framework.CommonFilterImpl;

import java.io.IOException;

public class MiddleFilter3 extends CommonFilterImpl{
    @Override
    public boolean specificComputationForFilter() throws IOException {
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];
        boolean is2013 = false;
        int byte_read = 0;
        
        while(true) {
            while(byte_read != '\n' && byte_read != -1) {
            	byte_read = in.read();
                if(byte_read == ' ') numOfBlank++;
                if(byte_read != -1) buffer[idx++] = (byte) byte_read;
                // 2013학번인지 체크
                if(numOfBlank == 1 && buffer[idx-9] == '2' && buffer[idx-8] == '0' && buffer[idx-7] == '1' && buffer[idx-6] == '3')
                    is2013 = true;
            }
            // 2013학번이면 기록
            if(is2013 == true) {
                for(int i = 0; i<idx; i++) 
                    out.write((char)buffer[i]);
                    out.write(13);
                    out.write(10);
                is2013 = false;
            }
            if (byte_read == -1) return true;
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }  
}
