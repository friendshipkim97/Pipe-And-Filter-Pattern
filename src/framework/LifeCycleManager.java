/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package framework;

import component.filter.TakingCourseFilter;
import component.constant.Constants.ELifeCycleManager;
import component.filter.AdvancedCourseFilter;
import component.filter.StudentMajorFilter;
import component.filter.StudentNumberFilter;
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
        CommonFilter sourceFilter = new SourceFilter(ELifeCycleManager.eStudentFileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter sinkFilter = new SinkFilter(ELifeCycleManager.eOutputFileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter studentMajorFilter = new StudentMajorFilter(ELifeCycleManager.eCSMajor.getContent(),
                ELifeCycleManager.eTrue.isCheck());
        CommonFilter takingCourseFilter = new TakingCourseFilter(ELifeCycleManager.eTrue.isCheck()
                , ELifeCycleManager.eCourseNumber12345.getContent()
                , ELifeCycleManager.eCourseNumber23456.getContent());

        sourceFilter.connectOutputTo(studentMajorFilter, ELifeCycleManager.ePortZero.getNumber());
        studentMajorFilter.connectOutputTo(takingCourseFilter, ELifeCycleManager.ePortZero.getNumber());
        takingCourseFilter.connectOutputTo(sinkFilter, ELifeCycleManager.ePortZero.getNumber());

        Thread thread1 = new Thread(sourceFilter);
        Thread thread2 = new Thread(sinkFilter);
        Thread thread3 = new Thread(studentMajorFilter);
        Thread thread4 = new Thread(takingCourseFilter);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


    private void hw2() throws IOException {
        CommonFilter sourceFilter = new SourceFilter(ELifeCycleManager.eStudentFileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter sinkFilter = new SinkFilter(ELifeCycleManager.eOutputFileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter studentMajorFilter = new StudentMajorFilter(ELifeCycleManager.eEEMajor.getContent(),
                ELifeCycleManager.eTrue.isCheck());
        CommonFilter takingCourseFilter = new TakingCourseFilter(ELifeCycleManager.eTrue.isCheck()
                , ELifeCycleManager.eCourseNumber23456.getContent());

        sourceFilter.connectOutputTo(studentMajorFilter, ELifeCycleManager.ePortZero.getNumber());
        studentMajorFilter.connectOutputTo(takingCourseFilter, ELifeCycleManager.ePortZero.getNumber());
        takingCourseFilter.connectOutputTo(sinkFilter, ELifeCycleManager.ePortZero.getNumber());

        Thread thread1 = new Thread(sourceFilter);
        Thread thread2 = new Thread(sinkFilter);
        Thread thread3 = new Thread(studentMajorFilter);
        Thread thread4 = new Thread(takingCourseFilter);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private void hw3() throws IOException {
        CommonFilter sourceFilter = new SourceFilter(ELifeCycleManager.eStudentFileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter sinkFilter = new SinkFilter(ELifeCycleManager.eOutputFileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter studentNumberFilter = new StudentNumberFilter(ELifeCycleManager.eStudentNumber2013.getContent());
        CommonFilter studentMajorFilter = new StudentMajorFilter(ELifeCycleManager.eCSMajor.getContent(), ELifeCycleManager.eFalse.isCheck());
        CommonFilter takingCourseFilter = new TakingCourseFilter(ELifeCycleManager.eFalse.isCheck(),
                ELifeCycleManager.eCourseNumber17651.getContent(),
                ELifeCycleManager.eCourseNumber17652.getContent());

        sourceFilter.connectOutputTo(studentNumberFilter, ELifeCycleManager.ePortZero.getNumber());
        studentNumberFilter.connectOutputTo(studentMajorFilter, ELifeCycleManager.ePortZero.getNumber());
        studentMajorFilter.connectOutputTo(takingCourseFilter, ELifeCycleManager.ePortZero.getNumber());
        takingCourseFilter.connectOutputTo(sinkFilter, ELifeCycleManager.ePortZero.getNumber());

        Thread thread1 = new Thread(sourceFilter);
        Thread thread2 = new Thread(sinkFilter);
        Thread thread3 = new Thread(studentNumberFilter);
        Thread thread4 = new Thread(studentMajorFilter);
        Thread thread5 = new Thread(takingCourseFilter);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    private void hw4() throws IOException {
        CommonFilter sourceFilter1 = new SourceFilter(ELifeCycleManager.eStudentFileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter sourceFilter2 = new SourceFilter(ELifeCycleManager.eCourseFileName.getContent(), ELifeCycleManager.ePortOne.getNumber());

        CommonFilter sinkFilter1 = new SinkFilter(ELifeCycleManager.eOutput1FileName.getContent(), ELifeCycleManager.ePortZero.getNumber());
        CommonFilter sinkFilter2 = new SinkFilter(ELifeCycleManager.eOutput2FileName.getContent(), ELifeCycleManager.ePortOne.getNumber());

        CommonFilter advancedCourseFilter = new AdvancedCourseFilter();

        sourceFilter1.connectOutputTo(advancedCourseFilter, ELifeCycleManager.ePortZero.getNumber());
        sourceFilter2.connectOutputTo(advancedCourseFilter, ELifeCycleManager.ePortOne.getNumber());
        advancedCourseFilter.connectOutputTo(sinkFilter1, ELifeCycleManager.ePortZero.getNumber());
        advancedCourseFilter.connectOutputTo(sinkFilter2, ELifeCycleManager.ePortOne.getNumber());

        Thread thread1 = new Thread(sourceFilter1);
        Thread thread2 = new Thread(sourceFilter2);
        Thread thread3 = new Thread(sinkFilter1);
        Thread thread4 = new Thread(sinkFilter2);
        Thread thread5 = new Thread(advancedCourseFilter);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


}
