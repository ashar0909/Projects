/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si4.lab.pkg1;

import java.math.BigInteger;

/**
 *
 * @author Ashar
 */


public class SI4Lab1 {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HugeInteger huge1, huge2, huge3, huge4,huge5,huge6;
        int compare;
        for (int i=1;i<2000000000;i++){
            huge1 = new HugeInteger(i);
            huge2 = new HugeInteger(2000000000 - i);
            huge3 = huge1.add(huge2);
            huge4 = huge1.subtract(huge2);
            huge5 = huge1.multiply(huge2);
            huge6 = huge1.divide(huge2);
            compare = huge1.compareTo(huge2); 
            System.out.print(huge1 + "\n" + huge2 + "\n" + huge3 + "\n" + huge4 + "\n" + huge5 + "\n" + huge6 + "\n"+ compare + "\n");

            
        }
        
        
        
//        huge1 = new HugeInteger("1000000");
//        huge2 = new HugeInteger("0");
//        huge3 = huge1.multiply(huge2);
//        huge4 = huge1.divide(huge2);
//       int k = huge1.compareTo(huge2);
//        System.out.print(huge1 + "\n" + huge2 + "\n" + huge3 + "\n" + huge4 + "\n" + k + "\n");
//
// 
//
//        HugeIntTiming time = new HugeIntTiming(10,5);
//        System.out.print(time.toString() + "\n");
//        HugeIntTiming time2 = new HugeIntTiming(25,45);
//        System.out.print(time2.toString() + "\n");
//        HugeIntTiming time3 = new HugeIntTiming(50,5);
//        System.out.print(time3.toString() + "\n");
//        HugeIntTiming time4 = new HugeIntTiming(75, 5);
//        System.out.print(time4.toString() + "\n");
//        HugeIntTiming time5 = new HugeIntTiming(100, 5);
//        System.out.print(time5.toString() + "\n");

      
       
        

    }
    
}
