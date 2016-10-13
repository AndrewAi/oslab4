package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {



        //int count = 0;
        //boolean firstLoop = true;


        ArrayList<Process> processList = new ArrayList<Process>();

        processList.add(new Process(1,12,0));
        processList.add(new Process(2,20,0));
        processList.add(new Process(3,12,0));
        processList.add(new Process(4,24,0));
        processList.add(new Process(5,27,0));













        //sjfSorter(processList);
        fCFS(processList);
        //roundRobin(processList);



    }


    private static void sjfSorter(ArrayList<Process> list) {

        Collections.sort(list);


        for(Process str: list){
            System.out.println(str.getProcessTime());
        }


    }





    private static void fCFS(ArrayList<Process> processList){


        int totalTime = 0;

        for (int i = 0; i < processList.size(); i++) {

            //System.out.println("START TIME = " + totalTime);
            System.out.println("p" + processList.get(i).getprocessId() + " Start: " + totalTime);
            System.out.println("p" + processList.get(i).getprocessId() + " Wait: " + totalTime);


            if (processList.get(i).getprocessId() == 1) {

                processList.get(i).setProcessWaitTime(0);
                totalTime += processList.get(i).getProcessTime();
                processList.get(i).setProcessWaitTime(0);

            }

            else{

                totalTime += processList.get(i).getProcessTime();

                 processList.get(i).setProcessWaitTime(totalTime);

        }






            System.out.println("p" + processList.get(i).getprocessId() + " Burst: " + processList.get(i).getProcessTime());
            System.out.println();
        }


    }






    private static void roundRobin(ArrayList<Process> processList) {

        int waitTime = 0;
        int timeQuantum = 3;

        while (processList.isEmpty() == false) {


            for (int i = 0; i < processList.size(); i++) {

                //minus the timeQuantum from the processTime
                processList.get(i).setProcessTime(timeQuantum);


                //int waitTime = (p.getprocessId()-1) * timeQuantum;
                //System.out.println(firstLoop);


                waitTime = (processList.get(i).getprocessId() - 1) * timeQuantum;


                int totaWaitTime = +waitTime;
                int averageWaitTime = totaWaitTime / processList.size();
                //System.out.println(firstLoop);


                System.out.println("list: " + processList.size());
                System.out.println("p" + processList.get(i).getprocessId() + ": " + processList.get(i).getProcessTime());
                System.out.println("p" + processList.get(i).getprocessId() + " wt: " + waitTime);


                processList.get(i).setProcessWaitTime(waitTime);

                //find out how to add to the list i.e update the wait time of a list item
                //processList.indexOf(p.getprocessId());


                System.out.println("P" + processList.get(i).getprocessId() + " Wait time: " + processList.get(i).getProcessWaitTime());
                System.out.println();



                if (processList.get(i).getProcessTime() < timeQuantum) {
                    processList.remove(i);
                    //continue;
                }

            }
        }
    }

}
