package week2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;

    private Node<Data> top = null;
    private int size;




    public QueueBasedStack() {
        size=0;
        // your code here
        q1=new Queue<>();
        q2=new Queue<>();
    }

    public void push(Data data) {

        // your code here
        while(!q1.isEmpty()){
            Data temp= q1.dequeue();
            q2.enqueue(temp);
        }
        q1.enqueue(data);
        while (!q2.isEmpty()){
            Data temp=q2.dequeue();
            q1.enqueue(temp);
        }

        size++;
    }

    public Data pop() {
        if (isEmpty()) {													// 1
            throw new NoSuchElementException("The stack is empty.");		// 1
        }
        Data item = q1.dequeue();

        size--;															    // 4
        return item;

    }

    public Data peek() {
        // your code here (remove next line)
        return q1.peek();
    }

    public int size() {
        // your code here (remove next line)
        return size;
    }

    public boolean isEmpty() {
        // your code here (remove next line)
        return size==0;
    }
}
