package com.company;

/**
 * Created by AndrewIrwin on 12/10/2016.
 */
public class Process implements Comparable {

    //Member Variables
    private int processId;
    private int processTime;
    private int processWaitTime;


    //Constructor which constructs objects from class member variables
    public Process(int processId, int processTime) {

        this.processId = processId;
        this.processTime = processTime;
        this.processWaitTime = 0;
        this.quantumCounter = 0;


    }

    // Getters return class member variables
    // Setters allow the value of class member variables to be modified


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

        if (processTime == 0) {
            this.processTime = 0;
        } else {
            this.processTime -= processTime;
        }


    }


    public int getProcessWaitTime() {
        return processWaitTime;
    }

    public void setProcessWaitTime(int processWaitTime) {
        this.processWaitTime = processWaitTime;
    }


    public int getQuantumCounter() {
        return quantumCounter;
    }

    public void setQuantumCounter(int quantumCounter) {
        this.quantumCounter += quantumCounter;
    }

    private int quantumCounter;


    //Below method Overrides the default compareTo Method compate the processTime variables

    @Override
    public int compareTo(Object pTime) {

        int compareProcessTime = ((Process) pTime).getProcessTime();

        return this.processTime - compareProcessTime;

    }
}
