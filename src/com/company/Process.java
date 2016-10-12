package com.company;

/**
 * Created by AndrewIrwin on 12/10/2016.
 */
public class Process implements Comparable {



    private int processId;
    private int processTime;
    private int processWaitTime;



    public Process(int processId, int processTime, int processWaitTime) {

        this.processId = processId;
        this.processTime = processTime;
        this.processWaitTime = processWaitTime;

    }




    public int getprocessId() {
        return processId;
    }

    public void setprocessId(int processId) {
        this.processId = processId;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime -= processTime;
    }


    public int getProcessWaitTime() {
        return processWaitTime;
    }

    public void setProcessWaitTime(int processWaitTime) {
        this.processWaitTime += processWaitTime;
    }





    @Override
    public int compareTo(Object  pTime) {

        int compareProcessTime = ((Process)pTime).getProcessTime();

        return this.processTime-compareProcessTime;

    }
}
