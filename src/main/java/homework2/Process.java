package homework2;

public class Process implements Comparable<Process> {
    // Implement the required attributes and constructor
    private final String name;
    private final int priority, arrival;
    private int burst;
    private int waitTime;

    public Process(String name, int priority, int burst, int arrival) {
        this.name = name;
        this.priority = priority;
        this.burst = burst;
        this.arrival = arrival;
        this.waitTime = - burst - arrival;
    }

    public String getName(){
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurst() {
        return burst;
    }

    public int getArrival() {
        return arrival;
    }
    public int getWaitTime(){
        return waitTime;
    }

    public void setBurst(int burst){
        this.burst = burst;
    }
    public void setWaitTime(int finishTime){
        this.waitTime = finishTime + this.waitTime;
    }
    @Override
    public int compareTo(Process other) {
        // implement the correct logic
        if(this.priority < other.priority){
            return -1;
        }
        else if(this.priority > other.priority){
            return 1;
        }
        else{
            return 0;
        }
    }


    }

