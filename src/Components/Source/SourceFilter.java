/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Components.Source;

import java.io.IOException;

import Components.utility.FileUtility;
import Framework.CommonFilterImpl;

public class SourceFilter extends CommonFilterImpl{
    private String sourceFile;
    private FileUtility fileUtility;
    private int portNo;
    
    public SourceFilter(String inputFile, int portNo){
        this.sourceFile = inputFile;
        this.fileUtility = new FileUtility();
        this.portNo = portNo;
    }    
    @Override
    public boolean specificComputationForFilter() throws IOException {
        return this.fileUtility.readFile(out.get(portNo), sourceFile);
    }
}
