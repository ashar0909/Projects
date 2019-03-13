/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si4.lab.pkg2;

/**
 *
 * @author Ashar
 */

//the code below was partially taken from Lecture 2 - Stacks & Queues
//but was edited to suit my code

public class Node {
    int element;
    Node next;
//the node contains an element and points to another node
    Node(int e, Node n) {
        element = e;
        next = n;
    }
}
