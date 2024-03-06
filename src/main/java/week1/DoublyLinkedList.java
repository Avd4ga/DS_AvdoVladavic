package week1;

import java.util.Iterator;

public class DoublyLinkedList<Data> implements Iterable<Data> {
    private DoubleNode<Data> head;
    private DoubleNode<Data> tail;
    private int size = 0;

    /* Add a new node to the front of the doubly linked list */
    public void addToFront(Data data) {
        // your code
        DoubleNode<Data> newNode = new DoubleNode<>();      // 1
        newNode.data = data;

        if(head==null){
            newNode.next=head;
            head=newNode;

        }
        else{
            newNode.next = head;
            head = newNode;
            newNode.next.prev = newNode;

        }

        size++;
    }

    /* Remove a node from the front of the doubly linked list */
    public void removeFromFront() {
        // your code
        if (head == null) {                                                     // 1
            throw new IndexOutOfBoundsException("The linked list is empty.");   // 1
        }                                                                       // 1
        head = head.next;
        head.prev = null;
        size--;
    }

    /* Add a new node to the end of the doubly linked list */
    public void addToRear(Data data) {
        // your code
        DoubleNode<Data> newNode = new DoubleNode<>();      // 1
        newNode.data = data;                    // 1


        if (head == null) {                         // 2
            head = newNode;

        } else {
            DoubleNode<Data> current = head;
            while (current.next != null) {          // 4
                current = current.next;             // 4
            }
            newNode.prev=current;
            tail=newNode;// 4
            current.next = newNode;                 // 5
        }
        size++;
    }

    /* Remove a node at the end of the doubly linked list */
    public void removeFromRear() {
        // your code
        if (head == null) {                                                     // 1
            throw new IndexOutOfBoundsException("The linked list is empty.");   // 1
        } else if (size == 1) {                                                 // 2
            head = null;                                                        // 2
        } else {                                                                // 3
            DoubleNode<Data> current = head;                                          // 3
            while (current.next.next != null) {                                 // 4
                current = current.next;                                         // 4
            }                                                                   // 4
            current.next = null;                                                // 5
        }
        size--;
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {
        // your code
        if (index < 0 || index >= size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }
        DoubleNode<Data> current = head;												// 2
        int i = 0;																// 3
        while (i < index) {														// 4
            current = current.next;												// 4
            i++;																// 4
        }

        return current.data;
    }

    /* Add an element to a doubly linked list by index (0-index) */
    public void add(int index, Data data) {
        // your code
        if (index < 0 || index >= size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }

        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;

        DoubleNode<Data> current = head;
        DoubleNode<Data> temp = new DoubleNode<>();
        int i = 0;																// 3
        while (i < index) {                                                     // 4
            temp = current;
            current = current.next;												// 4
            i++;																// 4
        }

        newNode.next = current;
        newNode.prev = current.prev;
        temp.next = newNode;
        size++;
    }

    /* Delete an element from a doubly linked list by index (0-index) */
    public void remove(int index) {
        // your code
        if (index < 0 || index >= size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }

        DoubleNode<Data> current = head;
        DoubleNode<Data> previous = new DoubleNode<>();
        int i = 0;																// 3
        while (i < index) {                                                     // 4
            previous = current;
            current = current.next;												// 4
            i++;																// 4
        }

        previous.next = current.next;
        current.next.prev = previous;
        size++;
    }

    /* Return the current size of the doubly linked list */
    public int count() {
        //your code
        return size;
    }

    /* Return an Iterator Object */
    @Override
    public Iterator<Data> iterator() { return new DoublyLinkedListIterator();}
    /* Define the Iterator class, and hasNext() and next() methods */
    private class DoublyLinkedListIterator implements Iterator<Data> {
        //your code
        DoubleNode<Data> current = head;

        @Override
        public boolean hasNext() {
            //your code
            return current != null;
        }

        @Override
        public Data next() {
            //your code
            Data data = current.data;                                   // 4
            current = current.next;                                     // 4
            return data;
        }
    }

    /* Get head node (for test purposes) */
    public DoubleNode<Data> getHead() {
        return head;
    }

    /* Get tail node (for test purposes) */
    public DoubleNode<Data> getTail() {
        return tail;
    }
}