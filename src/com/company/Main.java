package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {


        int timeQuantum = 3;

        ArrayList<Process> processList = new ArrayList<Process>();

        processList.add(new Process(1,12,0));
        processList.add(new Process(2,12,0));
        processList.add(new Process(3,12,0));
        processList.add(new Process(4,12,0));
        processList.add(new Process(5,12,0));




        while (processList.isEmpty() == false) {

            for (Process p : processList) {

                p.setProcessTime(timeQuantum);

                if (p.getProcessTime() <= timeQuantum) {
                    processList.remove(p);
                }

                int waitTime = (processList.size() - 1) * timeQuantum;

                System.out.println("list: " + processList.size());
                System.out.println("wt: " + waitTime);


                p.setProcessWaitTime(waitTime);


                System.out.println("Process " + p.getprocessId() + " Wait time: " + p.getProcessWaitTime());
            }
        }


        sjfSorter(processList);


    }


    private static void sjfSorter(ArrayList<Process> list)
    {
        Collections.sort(list);


        for(Process str: list){
            System.out.println(str.getProcessTime());
        }


    }

}
