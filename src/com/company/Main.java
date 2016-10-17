package com.company;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        // calling the showMenu Method to inisiate the program menu
        // where the user can input the number of processes, process name and process burst time
        showMenu();


    }






    private static void showMenu() {

        /*Create a new ArrayList of type Process
        Process is another class which contains ...
        Private Fields (Process name, Process Time, Process Wait Time)
        A Constructor to construct an object of type process when called.
        Getter and Setter methods so that the private fields of the objects can be accessed and modified
        */
        ArrayList<Process> processList = new ArrayList<Process>();


        //Create a new instance of the scanner, to be able to take input from the keyboard
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

            // add a new process object as an element to the ArrayList "processList"
            processList.add(new Process(processId, processBurstTime, 0));


        }


        System.out.println("Press 1 for Round Robin");
        System.out.println("Press 2 for FCFS");
        System.out.println("Press 3 for SJF");
        System.out.println("Press 4 to  Exit");
        int option = console.nextInt();


        //switch used to call the method selected by the user in the above dialog.
        // each method is given the processList Arraylist as its arguement

        switch (option) {


            case 1:
                roundRobin(processList);
                break;

            case 2:
                fCFS(processList);
                break;

            case 3:
                // to do shortest job first algorithm, I simply call sjfSorter to sort then list then
                // call fcfs (first come first serve) method which has the same effect as the shortest job first algorithm
                // as all elements in the processlist are all now sorted, smallest to greatest.
                fCFS(sjfSorter(processList));
                break;

            case 4:
                //terminates the program
                System.exit(0);
                break;
        }


    }







    // Below method takes in an ArrayList as its arguement,
    // Sorts the list so that the smallest values are put the front of the list
    // and then returns the now sorted list
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


            // TODO: 18/10/2016  add totaltime = totalTime + processlist if problem occurs
            totalTime += processList.get(i).getProcessTime();

        }

        System.out.println("Average Wait Time: " + totalWaitTime / processList.size());

    }






    private static void roundRobin(ArrayList<Process> processList) {

        int waitTime = 0;
        int timeQuantum = 0;
        int timeQuantumCumulative = 0;
        int counter = 0;
        int totalWaitTime = 0;


        Scanner console = new Scanner(System.in);
        System.out.println("Please Enter Time Quantum");
        timeQuantum = console.nextInt();
        System.out.println();


        while (processList.isEmpty() == false) {


            for (int i = 0; i < processList.size(); i++) {


                // each iteration of the loop i minus the time Quantum from the processTime / remaing process burst time
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


}

