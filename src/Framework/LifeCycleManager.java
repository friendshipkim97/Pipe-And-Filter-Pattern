/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Framework;

import Components.AddFilter.AddFilter1;
import Components.AddFilter.AddFilter2;
import Components.AddFilter.AddFilter3;
import Components.AddFilter.AddFilter4;
import Components.Middle.MiddleFilter1;
import Components.Middle.MiddleFilter2;
import Components.Middle.MiddleFilter3;
import Components.Middle.MiddleFilter4;
import Components.Sink.SinkFilter;
import Components.Source.SourceFilter;

import java.io.IOException;

public class LifeCycleManager {
    public static void main(String[] args) {
        try {
            LifeCycleManager lifeCycleManager = new LifeCycleManager();
            //lifeCycleManager.hw1();
            //lifeCycleManager.hw2();
            lifeCycleManager.hw3();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void hw1() throws IOException {
        CommonFilter sourceFilter = new SourceFilter("Students.txt");
        CommonFilter sinkFilter = new SinkFilter("Output.txt");
        CommonFilter middleFilter = new MiddleFilter1();
        CommonFilter addFilter = new AddFilter1();

        sourceFilter.connectOutputTo(middleFilter);
        middleFilter.connectOutputTo(addFilter);
        addFilter.connectOutputTo(sinkFilter);

        Thread thread1 = new Thread(sourceFilter);
        Thread thread2 = new Thread(sinkFilter);
        Thread thread3 = new Thread(middleFilter);
        Thread thread4 = new Thread(addFilter);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


    private void hw2() throws IOException {
        CommonFilter sourceFilter = new SourceFilter("Students.txt");
        CommonFilter sinkFilter = new SinkFilter("Output.txt");
        CommonFilter middleFilter2 = new MiddleFilter2();
        CommonFilter addFilter2 = new AddFilter2();

        sourceFilter.connectOutputTo(middleFilter2);
        middleFilter2.connectOutputTo(addFilter2);
        addFilter2.connectOutputTo(sinkFilter);

        Thread thread1 = new Thread(sourceFilter);
        Thread thread2 = new Thread(sinkFilter);
        Thread thread3 = new Thread(middleFilter2);
        Thread thread4 = new Thread(addFilter2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private void hw3() throws IOException {
        CommonFilter sourceFilter = new SourceFilter("Students.txt");
        CommonFilter sinkFilter = new SinkFilter("Output.txt");
        CommonFilter middleFilter3 = new MiddleFilter3();
        CommonFilter middleFilter4 = new MiddleFilter4();
        CommonFilter addFilter3 = new AddFilter3();
        CommonFilter addFilter4 = new AddFilter4();

        sourceFilter.connectOutputTo(middleFilter3);
        middleFilter3.connectOutputTo(middleFilter4);
        middleFilter4.connectOutputTo(addFilter3);
        addFilter3.connectOutputTo(addFilter4);
        addFilter4.connectOutputTo(sinkFilter);

        Thread thread1 = new Thread(sourceFilter);
        Thread thread2 = new Thread(sinkFilter);
        Thread thread3 = new Thread(middleFilter3);
        Thread thread4 = new Thread(middleFilter4);
        Thread thread5 = new Thread(addFilter3);
        Thread thread6 = new Thread(addFilter4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }

}
