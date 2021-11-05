/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package component.sink;

import java.io.IOException;

import component.utility.FileUtility;
import framework.CommonFilterImpl;

public class SinkFilter extends CommonFilterImpl{
    private String sinkFile;
    private FileUtility fileUtility;
    private int portNo;
    
    public SinkFilter(String outputFile, int portNo) {
        this.sinkFile = outputFile;
        this.fileUtility = new FileUtility();
        this.portNo = portNo;
    }
    @Override
    public boolean specificComputationForFilter() throws IOException {
        return this.fileUtility.writeFile(in.get(portNo), sinkFile);
    }
}
