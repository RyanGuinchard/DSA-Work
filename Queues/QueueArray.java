package Queues;

public class QueueArray {
    private int[] arr;
    private int back;
    private int numItems;
    int beginning;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.back = -1;
        this.beginning = -1;
        this.numItems = 0;
        System.out.println("The queue is created with size: " + size);
    }

    // isFull
    public boolean isFull() {
        if (back == arr.length - 1) {
            System.out.println("Queue is full");
            return true;
        } else {
            System.out.println("Queue is not full");
            return false;
        }
    }

    // isEmpty
    public boolean isEmpty() {
        return (numItems == 0); // If there are no items
    }

    // Enqueue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            beginning = 0;
            back++;
            arr[back] = value;
            numItems++;
            System.out.println("Value is successfully inserted");
        } else {
            back++;
            arr[back] = value;
            numItems++;
            System.out.println("Value is successfully inserted");
        }
    }

    // Dequeue
    public int deQueue (int value) {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int result = arr[beginning];
            beginning++;

            if (beginning > back) {
                beginning = back = -1;
            }

            numItems--;
            return result;
        }
    }

    // Peek - see next element about to come out of queue
    public int peek() {
        if (!isEmpty()) {
            return arr[beginning];
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    // delete
    public void delete() {
        arr = null;
        System.out.println("Queue is deleted");
    }
}
