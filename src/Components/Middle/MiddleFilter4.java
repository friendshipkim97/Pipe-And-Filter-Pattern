/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Components.Middle;

import Framework.CommonFilterImpl;

import java.io.IOException;

public class MiddleFilter4 extends CommonFilterImpl{
    @Override
    public boolean specificComputationForFilter() throws IOException {
    	int checkBlank = 4;
        int numOfBlank = 0;
        int idx = 0;
        byte[] buffer = new byte[64];
        boolean isCS = false;
        int byte_read = 0;
        
        while(true) {
            while(byte_read != '\n' && byte_read != -1) {
            	byte_read = in.read();
                if(byte_read == ' ') numOfBlank++;
                if(byte_read != -1) buffer[idx++] = (byte) byte_read;
                // 전공이CS인지 체크
                if(numOfBlank == checkBlank && buffer[idx-3] == 'C' && buffer[idx-2] == 'S'){
                    isCS = true;
                }
            }
            // 전공이CS이면 기록
            if(isCS == false) {
                if(idx>3) {
                    for(int i = 0; i<idx; i++)
                        out.write((char)buffer[i]);
                    out.write(13);
                    out.write(10);
                }
            }
            if (byte_read == -1) return true;
            idx = 0;
            numOfBlank = 0;
            isCS = false;
            byte_read = '\0';

        }
    }  
}
