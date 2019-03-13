package si4.lab.pkg2;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author Ashar
 */

//all asymptotic run time and space complexities are measured using big O 
public class BSTSet {
    private TNode root;
    
    //creates a tree where the root is null
    public BSTSet(){
        root = null;
    }
    
    
    public BSTSet(int[] input) {
        // asymptotic run time is n because the function goes through the tree starting from the root until it reaches the appropriate spot,
        //this gives it a run time of 2*n, giving it an asymptotic run time of n
        //space complexity n, as the program only uses n terms for space
        if (input.length <=0){//make root equal to null and end the program if no input is given
            root = null;
            return;
        }
        root = new TNode (input[0],null,null);//make the root the first value in the array
        TNode temp = root;
        for (int i=1;i<input.length;i++){
            //go to the position on the tree that the next value will go to
            while (temp.left != null &&input[i] <  temp.element || temp.right != null &&input[i] > temp.element ){
                if (temp.element<input[i]){
                    temp = temp.right;
                }else if (temp.element>input[i]){
                    temp = temp.left;
                }
            }
            //create a new node in the corresponding area on the tree
            if (temp.element < input[i]) {
                temp.right = new TNode(input[i],null,null); 
            } else if (temp.element > input[i]) {
                temp.left = new TNode(input[i],null,null);
            }
            //turn temp back into root and repeat the code above
            temp = root;
        }
        
    }
    
    
    public boolean isIn(int v){
        //asymptotic run time is n because the worst cast scenario is that the node is at a leaf, which is at max height, which is at most n times
        //the space complexity is 1 because the function creates only one new node 
        TNode temp = root;
        if (temp == null) {
            return false;
        }
        //goes left or right until it finds or doesnt find the value 
        while (temp.left != null && v< temp.element  || temp.right != null && v> temp.element ){
            if (v> temp.element ){
                temp = temp.right;
            }else if(v< temp.element){
                temp = temp.left;
            }else if( temp.element == v){
                return true;
            }
        }
        if (temp.element == v) {
            return true;
        }else {
            return false;
        }
    }
    
    public void add(int v){
        // asymptotic run time is n because at worst, the value is added after a leaf which has a asymptotic run time of n 
        //the space complexity is 1 because only one node is created 
        TNode temp = root;
        //finds the branch that the value should be added to
        while (temp.left != null && v < temp.element || temp.right != null && v > temp.element) {
            if (v > temp.element) {
                temp = temp.right;
            } else if (v < temp.element) {
                temp = temp.left;
            //ends the function if the value is already in the tree
            } else if (temp.element == v) {
                return;
            }
        }
        //adds the new value in the corresponding branch
        if (v < temp.element ) {
            temp.left = new TNode (v, temp.left,null);
        }else if(v > temp.element) {
            temp.right = new TNode(v, null, temp.right);
        }
    }
    
    
    public boolean remove(int v){
        //asymptotic run time is n because at worst the value is at a leaf, which makes the asymptotic run time n
        //the space used is 2*n, which gives the function a space complexity of n
        TNode temp = root, prev=root;
        while (temp.left != null && v < temp.element || temp.right != null && v > temp.element) {//find the part of the tree that the value would be at
            prev = temp;
            if (v > temp.element) {
                temp = temp.right;
            } else if (v < temp.element) {
                temp = temp.left;
            }else{
                break;
            }
        }
        //if there are two branches or if the value to remove is the root and there is only one branch on the left,
        //find the biggest value in the left branch and replace v with that new value
        if (temp.element == v && temp.left !=null&& temp.right !=null ||temp.element == v && temp.left != null && temp ==root) {
            TNode temp2 = temp.left;
            prev = temp;
            while (temp2.right !=null){
                prev = temp2;
                temp2 = temp2.right;
            }
            //remove the biggest value in the left branch
            if (prev == temp){
                temp.element = temp2.element;
                prev.left = prev.left.left;
            }else{
                temp.element = temp2.element;
                prev.right = prev.right.left;
            }
            return true;   
            //if the value to remove is the root and there is only one branch on the right,
            //find the smallest value in the right branch and replace v with that new value
        }else if(temp.element == v && temp.right != null && temp ==root){
            TNode temp2 = temp.right;
            prev = temp;
            while (temp2.left != null) {
                prev = temp2;
                temp2 = temp2.left;
            }
            //remove the smallest value in the right branch
            if (prev == temp) {
                temp.element = temp2.element;
                prev.right = prev.right.right;
            } 
            return true;
            //if there is only one branch, remove the value by skipping it
        }else if (temp.element == v && temp.right !=null ) {
            if (prev.element > v) {
                prev.left = prev.left.right;
            } else if (prev.element < v) {
                prev.right = prev.right.right;
            }
            return true;
        }else if (temp.element == v && temp.left !=null){
            if (prev.element > v) {
                prev.left = prev.left.left;
            } else if (prev.element < v) {
                prev.right = prev.right.left;
            }
            return true;
        //if there are no branches, make the previous node point to null instead of the value
        }else if (temp.element == v && temp.right ==null&& temp.left ==null){
            if (prev.element>v){
                prev.left = null;
            }else if (prev.element<v){
                prev.right = null;
            }
            return true;
        }
        return false;
    }
    
    
    //create a string of all of the numbers in the tree, seperated by commas
    private String toString(TNode t) {
        String stringList = "";
        if (t == null) {
            return "";
        }
        stringList = t.element + ",";
        return toString(t.left) + stringList + toString(t.right);
    }
  
    
    
    public BSTSet union(BSTSet s){
        //asymptotic run time is n as the function goes through the tree n times individually
        //this makes the runtime 2*n, making the asymptotic run time n
        //the space complexity is n as a new BSTSet is created
        String[] thisString = toString(root).split(",");
        String[] sString = s.toString(s.root).split(",");
        int[] unionArray = new int [thisString.length+ sString.length];
        //create an array with values from both trees
        for (int i=0;i<thisString.length;i++){
            unionArray[i] = Integer.parseInt(thisString[i]);
        }
        for (int i = 0; i < sString.length; i++) {
            unionArray[i+thisString.length] = Integer.parseInt(sString[i]);
        }
        //BSTSet will remove doubles, so we can use unionArray to make the new tree
        BSTSet union = new BSTSet(unionArray);
        return union;
        
    }
    
    
    public BSTSet intersection(BSTSet s){
        //asymptotic run time is n^2 as the function compares each value in one tree with each value in the other tree
        //the space complexity is n as a new BSTSet is created
        String[] thisString = toString(root).split(",");
        String[] sString = s.toString(s.root).split(",");
        int[] tempArray = new int[thisString.length + sString.length];
        int counter =0;
        //when the two trees have the same value, copy the value into a new array
        for (int i = 0; i < thisString.length; i++) {
            for (int j = 0; j < sString.length; j++) {
                if (thisString[i].equals(sString[j])){
                    tempArray[counter] = Integer.parseInt(thisString[i]);
                    counter++;
                }
            }
        }
        //copy the array into a new array that is the size of the intersection
        int[] interArray = new int[counter];
        System.arraycopy(tempArray, 0, interArray, 0, counter);
        BSTSet intersection = new BSTSet(interArray);
        return intersection;
    }
    
    
    public BSTSet difference(BSTSet s){
        //asymptotic run time is n^2 as the function compares each value in one tree with each value in the other tree
        //the space complexity is n as a new BSTSet is created
        String[] thisString = toString(root).split(",");
        String[] sString = s.toString(s.root).split(",");
        int[] tempArray = new int[thisString.length + sString.length];
        int counter = 0,tell =0;
        //if the arrays don't have the same value, then add the value into the new array
        for (int i = 0; i < thisString.length; i++) {
            for (int j = 0; j < sString.length; j++) {
                if (thisString[i].equals(sString[j])) {
                   tell = 1;
                }
            }
            if (tell==0){
                tempArray[counter] = Integer.parseInt(thisString[i]);
                counter++;
            }
            tell =0;
        }
        //copy the array into a new array that is the size of the difference
        int[] diffArray = new int[counter];
        System.arraycopy(tempArray, 0, diffArray, 0, counter);
        BSTSet difference = new BSTSet(diffArray);
        return difference;
    }
    
    private int size(TNode t){
        //go through every node and at each node increase the length
        int length = 0;
        if (t != null) {
            length = length +size(t.left);
            length = length+ size(t.right);
            length++;
        }
        return length;
    }
    
    public int size(){
        //the asymptotic run time is n because the function calls size(TNode t), which calls itself n times
        //the space complexity is n because for each node two integers are created when size(TNode t) is called
        int length =0;
        if (root == null) {
            System.out.println("The set is empty");
        } else {
            length = size(root);
        }
        return length;
    }
    
    
    
    
    
    
    private int height(TNode t) {
        //height will go left and right until it reaches a null value, then it will go back
        if (t == null) {
            return -1;
        }
        int rightNode = height(t.right);
        int leftNode = height(t.left);
        
        int height = rightNode > leftNode ? rightNode + 1 : leftNode + 1;
        return height;
    }
    
    public int height(){
        //the asymptotic run time is n, because the function calls height(TNode t), which calls itself n times
        //the space complexity is n because for each node two integers are created when height(TNode t) is called
        if (root == null) {
            return -1;
        }
        return height(root);
        
    }
    
    
    //code was given by the lab 3 assignment
    public void printBSTSet(TNode t){
        //the asymptotic run time is n, because the function calles left and right on each node, making it go through the whole tree
        //the space complexity is 0 because no new values are stored
        if (t != null) {
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }
    
    //code was given by the lab 3 assignment
    public void printBSTSet() {
        //the asymptotic run time is n, because the function calles left and right on each node, making it go through the whole tree
        //the space complexity is 0 because no new values are stored
        if (root == null) {
            System.out.println("The set is empty");
        }else{
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }
    
    
    public void printNonRec(){
        //the time complexity is n^2; the function adds to the stack one at a time,
        //and during the addition, remove is used which has a time complexity of n
        //making the time complexity n*n or n^2
        //the function creates a new BSTSet as well as making a stack with n values, 
        //taking up 2*n amount of space and giving it a space complexity of n
        BSTSet copy = union(this); //create a copy of this tree using union
        TNode max = copy.root;
        MyStack stack = new MyStack();//create a new stack
        int temp;
        for (int i=0;i<size();i++){
            while(max.right!=null){//find the max value in the tree
                max = max.right;
            }
            //add the max value to the stack and remove it form the tree
            temp = max.element;
            max = copy.root;
            stack.push(temp);
            copy.remove(temp);
        }
        //print the elements in the stack from the top to the bottom
        System.out.print("The set elements are: ");
        for (int i = 0; i < size(); i++) {
            System.out.print(stack.pop() + ", ");
        }
    }
}
