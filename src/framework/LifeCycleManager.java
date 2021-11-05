/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package framework;

import component.addFilter.AddFilter1;
import component.addFilter.AddFilter2;
import component.addFilter.AddFilter3;
import component.middle.MiddleFilter1;
import component.middle.MiddleFilter2;
import component.middle.MiddleFilter3;
import component.middle.MiddleFilter4;
import component.sink.SinkFilter;
import component.source.SourceFilter;

import java.io.IOException;

public class LifeCycleManager {
    public static void main(String[] args) {
        try {

            LifeCycleManager lifeCycleManager = new LifeCycleManager();
            //lifeCycleManager.hw1();
            //lifeCycleManager.hw2();
            //lifeCycleManager.hw3();
            lifeCycleManager.hw4();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void hw1() throws IOException {
        CommonFilter sourceFilter = new SourceFilter("Students.txt", 0);
        CommonFilter sinkFilter = new SinkFilter("Output.txt", 0);
        CommonFilter middleFilter = new MiddleFilter1();
        CommonFilter addFilter = new AddFilter1();

        sourceFilter.connectOutputTo(middleFilter, 0);
        middleFilter.connectOutputTo(addFilter, 0);
        addFilter.connectOutputTo(sinkFilter, 0);

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
        CommonFilter sourceFilter = new SourceFilter("Students.txt", 0);
        CommonFilter sinkFilter = new SinkFilter("Output.txt", 0);
        CommonFilter middleFilter2 = new MiddleFilter2();
        CommonFilter addFilter2 = new AddFilter2();

        sourceFilter.connectOutputTo(middleFilter2, 0);
        middleFilter2.connectOutputTo(addFilter2, 0);
        addFilter2.connectOutputTo(sinkFilter, 0);

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
        CommonFilter sourceFilter = new SourceFilter("Students.txt", 0);
        CommonFilter sinkFilter = new SinkFilter("Output.txt", 0);
        CommonFilter middleFilter3 = new MiddleFilter3();
        CommonFilter addFilter3 = new AddFilter3();

        sourceFilter.connectOutputTo(middleFilter3, 0);
        middleFilter3.connectOutputTo(addFilter3, 0);
        addFilter3.connectOutputTo(sinkFilter, 0);

        Thread thread1 = new Thread(sourceFilter);
        Thread thread2 = new Thread(sinkFilter);
        Thread thread3 = new Thread(middleFilter3);
        Thread thread4 = new Thread(addFilter3);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private void hw4() throws IOException {
        CommonFilter sourceFilter1 = new SourceFilter("Students.txt", 0);
        CommonFilter sourceFilter2 = new SourceFilter("Courses.txt", 1);

        CommonFilter sinkFilter1 = new SinkFilter("Output-1.txt", 0);
        CommonFilter sinkFilter2 = new SinkFilter("Output-2.txt", 1);

        CommonFilter middleFilter4 = new MiddleFilter4();

        sourceFilter1.connectOutputTo(middleFilter4, 0);
        sourceFilter2.connectOutputTo(middleFilter4, 1);
        middleFilter4.connectOutputTo(sinkFilter1, 0);
        middleFilter4.connectOutputTo(sinkFilter2, 1);

        Thread thread1 = new Thread(sourceFilter1);
        Thread thread2 = new Thread(sourceFilter2);
        Thread thread3 = new Thread(sinkFilter1);
        Thread thread4 = new Thread(sinkFilter2);
        Thread thread5 = new Thread(middleFilter4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


}
