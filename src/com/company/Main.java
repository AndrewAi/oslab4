package com.company;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ArrayList<Process> processList = new ArrayList<Process>();
                                 //ProcessName  //BurstTime   //Wait Time
        processList.add(new Process(1,            12,          0));
        processList.add(new Process(2, 12, 0));
        processList.add(new Process(3, 12, 0));
        //processList.add(new Process(4, 12, 0));
        //processList.add(new Process(5, 1, 0));
        //processList.add(new Process(6, 9, 0));


        //showMenu();


        //sjfSorter(processList);
        //fCFS(sjfSorter(processList));
        //fCFS(processList);
        roundRobin(processList);
        //roundRobin2(processList);

    }

    private static void showMenu() {

        ArrayList<Process> processList = new ArrayList<Process>();

        Scanner console = new Scanner(System.in);

        System.out.println("Enter the process name and burst time for each process");
        System.out.println("Please enter the number of processes");
        int numberOfProcesses = console.nextInt();


        for (int i = 0; i < numberOfProcesses; i++) {


            System.out.println("Enter process name (integer): ");
            int processId = console.nextInt();

            System.out.println("Enter process burst time for process " + processId + ": ");
            int processBurstTime = console.nextInt();
            System.out.println();

            processList.add(new Process(processId, processBurstTime, 0));

        }


        System.out.println("Press 1 for Round Robin");
        System.out.println("Press 2 for FCFS");
        System.out.println("Press 3 for SJF");
        System.out.println("Press 4 to  Exit");
        int option = console.nextInt();

        switch (option) {

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
        int timeQuantumCumulative = 0;
        int counter = 0;
        int totalWaitTime = 0;



        while (processList.isEmpty() == false) {


            for (int i = 0; i < processList.size(); i++) {



                processList.get(i).setProcessTime(timeQuantum);







                if (processList.get(i).getProcessTime() < 3) {
                    timeQuantumCumulative = timeQuantumCumulative - processList.get(i).getProcessTime();
                    processList.remove(i);
                    continue;
                }




                // print out process name
                //print out Start Time basically the time Cumalative;
                //print out burst remaining time basically the .getProcessTime
                // print out the Wait time which is .getProcessWaitTime


                System.out.println("P" + processList.get(i).getprocessId() + " Start Time : " + timeQuantumCumulative);
                System.out.println("P" + processList.get(i).getprocessId() + " Remaining Time : " + processList.get(i).getProcessTime());
                System.out.println("P" + processList.get(i).getprocessId() + " Wait Time : " + processList.get(i).getProcessWaitTime());
                System.out.println();





                timeQuantumCumulative += timeQuantum;
                totalWaitTime += timeQuantum;
                processList.get(i).setProcessWaitTime(timeQuantum);


            }

        }

    }


    private static void roundRobin2(ArrayList<Process> processList) {

        int waitTime = 0;
        int timeQuantum = 3;
        int counter = 0;

        while (processList.isEmpty() == false) {


            for (int i = 0; i < processList.size(); i++) {

                //each loop
                // minus time quantum from the process time
                // multiply the time quatum by the list item counter and reset the list item counter each time it gets to the end of the list

                //minus the timeQuantum from the processTime
                processList.get(i).setProcessTime(timeQuantum);


                //int waitTime = (p.getprocessId()-1) * timeQuantum;
                //System.out.println(firstLoop);


                waitTime = (processList.get(i).getprocessId() - 1) * timeQuantum;


                int totaWaitTime =+ waitTime;
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

                /*
                if (i > 0 & i < processList.size()){

                    //loop * (list size - p.get(i)) * Q

                     wTime = (i * (processList.size() - processList.get(i).getprocessId())) * timeQuantum;

                     processList.get(i).setProcessWaitTime(wTime);



                }

                else if (i == processList.size()){

                    // (loop * processList.get(i).getprocessId() - 1) * timeQuantum;

                   wTime = (i * processList.get(i).getprocessId() - 1) * timeQuantum;

                    processList.get(i).setProcessWaitTime(wTime);



                }



                else if (i == 0 && processList.get(i).getprocessId() == 1){

                    // ((loop * 1) * Q) + Q


                    wTime = ((i * 1) * timeQuantum) + timeQuantum;

                    processList.get(i).setProcessWaitTime(wTime);

                }
                */

