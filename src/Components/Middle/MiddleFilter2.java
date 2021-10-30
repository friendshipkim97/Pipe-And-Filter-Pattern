/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Components.Middle;

import Framework.CommonFilterImpl;

import java.io.IOException;

public class MiddleFilter2 extends CommonFilterImpl{
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
                if(numOfBlank == checkBlank && buffer[idx-3] == 'E' && buffer[idx-2] == 'E')
                    isCS = true;
            }      
            if(isCS == true) {
                for(int i = 0; i<idx; i++) 
                    out.write((char)buffer[i]);
                    out.write(13);
                    out.write(10);
                isCS = false;
            }
            if (byte_read == -1) return true;
            idx = 0;
            numOfBlank = 0;
            byte_read = '\0';
        }
    }  
}
