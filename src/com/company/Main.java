package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {


        int timeQuantum = 3;
        int count = 0;

        ArrayList<Process> processList = new ArrayList<Process>();

        processList.add(new Process(1,12,0));
        processList.add(new Process(2,12,0));
        processList.add(new Process(3,12,0));
        processList.add(new Process(4,12,0));
        processList.add(new Process(5,12,0));




        while (processList.isEmpty() == false) {



            for (Process p : processList) {

                //minus the timeQuantum from the processTime
                p.setProcessTime(timeQuantum);


                if (p.getProcessTime() <= timeQuantum) {
                    processList.remove(p);
                }



                int waitTime = (p.getprocessId()-1) * timeQuantum;

                System.out.println("list: " + processList.size());
                System.out.println("p" + p.getprocessId() + ": " + p.getProcessTime());
                System.out.println("p" + p.getprocessId() + " wt: " + waitTime);



                p.setProcessWaitTime(waitTime);

                //find out how to add to the list i.e update the wait time of a list item
                //processList.indexOf(p.getprocessId());


                System.out.println("Process " + p.getprocessId() + " Wait time: " + p.getProcessWaitTime());
                System.out.println();

                /*if (count == processList.size()){
                    count = 0;
                }
                */
            }
        }


        //sjfSorter(processList);


    }


    private static void sjfSorter(ArrayList<Process> list)
    {
        Collections.sort(list);


        for(Process str: list){
            System.out.println(str.getProcessTime());
        }


    }

}
