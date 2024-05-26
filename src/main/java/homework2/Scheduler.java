package homework2;

import java.util.ArrayList;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        // your code here
        ProcessQueue pq = new ProcessQueue();
        int t = 0;
        int itemsLeft = processes.size();
        float totalWaitTime = 0;
        while(true){

            String name = "No process";
            for(Process p : processes){
                if(p.getArrival()==t){
                    pq.addProcess(p);
                    itemsLeft--;
                }
            }
            if(!pq.isEmpty()){

                Process p = pq.peekNextProcess();
                int burst = p.getBurst();

                if(burst==1){
                    p = pq.runNextProcess();
                    p.setWaitTime(t+1);
                    totalWaitTime += p.getWaitTime();
                }

                p.setBurst(--burst);
                name = p.getName();
            }

            System.out.println("t: " + t + "   |   " + name);
            t++;

            if(pq.isEmpty() && itemsLeft==0){
                System.out.println("Total time: " + t);
                System.out.println("Average waiting time:" + (totalWaitTime/processes.size()));
                break;
            }
        }
    }

    public static void main(String[] args) {
        // you can use the main method for testing
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 5, 4, 0));
        processes.add(new Process("P2", 4, 3, 1));
        processes.add(new Process("P3", 3, 1, 2));
        processes.add(new Process("P4", 2, 5, 3));
        processes.add(new Process("P5", 2, 2, 4));

        scheduleAndRun(processes);
    }
}
