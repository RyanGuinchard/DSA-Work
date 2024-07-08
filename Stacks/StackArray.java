package Stacks;

public class StackArray {
    int [] arr;
    int top;

    public StackArray(int size) {
        this.arr = new int[size];
        this.top = -1;
        System.out.println("The stack is created with size: " + size);
    }

    //isEmpty method
    public boolean isEmpty() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    // isFull method
    public boolean isFull() {
        if (top == arr.length - 1) {
            System.out.println("Stack is full");
            return true;
        } else {
            System.out.println("Stack is not full");
            return false;
        }
    }

    //Push method
    public void push(int value) {
        if (!isEmpty()) {
            System.out.println("Stack is full");
        } else {
            arr[top + 1] = value;
            top++;
            System.out.println("Value is successfully inserted");
        }
    }

    // Pop method

    // Peek method

    // delete a stack

    // use stack datastructure to check whether a word is palindrome or not

    // Implement stack datastructure using Linkedlist instead of array
}
