/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si4.lab.pkg2;
import java.util.EmptyStackException;

/**
 *
 * @author Ashar
 */

//the code below was partially taken from Lecture 2 - Stacks & Queues
//but was edited to suit my code


public class MyStack {
    private Node head;
//starts with an empty stack
    public MyStack() {
        head = null;
    }
    //checks if the stack is empty
    public boolean isEmpty() {
        return (head == null);
    }
    //adds an element to the top of the stack
    public void push(int element) {
        head = new Node(element, head);
    }
    //removes an element from the top of the stack
    //throws an error if the stack is empty
    public int pop() throws EmptyStackException{
        if (isEmpty()) {
            throw new EmptyStackException();
        }else{
            int e = head.element;
            head = head. next ;
            return e;
        }
    }
}
