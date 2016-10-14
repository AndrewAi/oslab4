package com.company;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner console = new Scanner(System.in);




        ArrayList<Process> processList = new ArrayList<Process>();

        //processList.add(new Process(1, 20, 0));
        //processList.add(new Process(2, 2, 0));
        //processList.add(new Process(3, 13, 0));
        //processList.add(new Process(4, 12, 0));
        //processList.add(new Process(5, 1, 0));
        //processList.add(new Process(6, 9, 0));

        System.out.println("Enter the process name and burst time for each process");
        System.out.println("Please enter the number of processes");
        int numberOfProcesses = console.nextInt();



        for (int i = 0; i < numberOfProcesses; i++ ){


            System.out.println("Enter process name (integer): ");
            int processId = console.nextInt();

            System.out.println("Enter process burst time for process " + processId + ": ");
            int processBurstTime = console.nextInt();
            System.out.println();

            processList.add(new Process(processId,processBurstTime,0));

        }


        System.out.println("Press 1 for Round Robin");
        System.out.println("Press 2 for FCFS");
        System.out.println("Press 3 for SJF");
        System.out.println("Press 4 to  Exit");
        int option = console.nextInt();

        switch (option){

            case 1:
                roundRobin(processList);
                break;

            case 2:
                fCFS(processList);
                break;

            case 3:
                fCFS(sjfSorter(processList));
                break;

            case 4:
                System.exit(0);
                break;
        }



        //sjfSorter(processList);
        //fCFS(sjfSorter(processList));
        fCFS(processList);
        //roundRobin(processList);

    }


    private static ArrayList<Process> sjfSorter(ArrayList<Process> list) {

        Collections.sort(list);

        return list;

    }


    private static void fCFS(ArrayList<Process> processList) {


        int totalTime = 0;
        int totalWaitTime = 0;


        for (int i = 0; i < processList.size(); i++) {


            System.out.println("p" + processList.get(i).getprocessId() + " Start: " + totalTime);
            System.out.println("p" + processList.get(i).getprocessId() + " Wait: " + totalTime);
            System.out.println("p" + processList.get(i).getprocessId() + " Burst: " + processList.get(i).getProcessTime());
            System.out.println();

            totalWaitTime += totalTime;


            totalTime = totalTime + processList.get(i).getProcessTime();


        }

        System.out.println("Average Wait Time: " + totalWaitTime / processList.size());


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
