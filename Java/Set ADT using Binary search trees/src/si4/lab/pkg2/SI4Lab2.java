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
public class SI4Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create two int arrays of length 20
        int[] temp = new int [20];
        int[] temp2 = new int[20];

        for (int i=1;i<21;i++){
            temp [i-1] =i;
        }
        for (int i = 11; i < 31; i++) {
            temp2[i - 11] = i;
        }
        temp[0] = 10;
        temp[2] = 5;
        //create a BSTSet from 2-20(missing 3) and another one from 11-30
        BSTSet test = new BSTSet(temp);
        BSTSet test2 =new BSTSet(temp2);
        
        //add 3 and remove 17 from the first BSTSet
        test.add(3);
        test.remove(17);
        
        //test each function and add it to a new BSTSet
        BSTSet test3 = test.union(test2);
        BSTSet test4 = test.intersection(test2);
        BSTSet test5 = test.difference(test2);

        //test out size() and height()
        System.out.print(test.size() +"\n"+ test.height()+"\n");
       
        
        test.printBSTSet();
        test2.printBSTSet();
        test3.printBSTSet();
        test4.printBSTSet();
        test5.printBSTSet();
        
        //test the non-recursive print statement
        test.printNonRec();

    }
    
}
