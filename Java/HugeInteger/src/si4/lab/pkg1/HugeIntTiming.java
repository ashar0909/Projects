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
public class HugeIntTiming {
    double runTime1 = 0.0, runTime2 = 0.0, runTime3 = 0.0, runTime4 = 0.0,runTime5 = 0.0;
    
    public HugeIntTiming(int n) {
        HugeInteger huge1, huge2, huge3;

        long startTime, endTime;
        for (int numInts = 0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(n);        //creates a random integer of n digits
            huge2 = new HugeInteger(n);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 2000000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                huge3 = huge1.add(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime1 += (double) (endTime - startTime) / ((double) 2000000);//get the average time it took
        }
        runTime1 = runTime1 / ((double) 100);//this makes it so that runTime is the average time it took to run addition

        for (int numInts = 0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(n);        //creates a random integer of n digits
            huge2 = new HugeInteger(n);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 2000000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                huge3 = huge1.subtract(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime2 += (double) (endTime - startTime) / ((double) 2000000);

        }
        runTime2= runTime2 / ((double) 100);

        for (int numInts = 0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(n);        //creates a random integer of n digits
            huge2 = new HugeInteger(n);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 75000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                huge3 = huge1.multiply(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime3 += (double) (endTime - startTime) / ((double) 75000);
        }
        runTime3 = runTime3 / ((double) 100);
        
        for (int numInts = 0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(n);        //creates a random integer of n digits
            huge2 = new HugeInteger(n);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 1500000; numRun++) {
                huge3 = huge1.divide(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime4 += (double) (endTime - startTime) / ((double) 1500000);
        }
        runTime4 = runTime4 / ((double) 100);
        
        for (int numInts = 0; numInts < 100; numInts++) {
            huge1 = new HugeInteger(n);        //creates a random integer of n digits
            huge2 = new HugeInteger(n);        //creates a random integer of n digits
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 250000000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                int k = huge1.compareTo(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime5 += (double) (endTime - startTime) / ((double) 250000000);
        }
        runTime5 = runTime5 / ((double) 100);
    }
    
    public HugeIntTiming(int n, int j) {//a different constructor for BigInteger, it uses int j to differentiate between the two constructors
        BigInteger huge1, huge2, huge3;
        HugeInteger string1, string2;

        long startTime, endTime;
        for (int numInts = 0; numInts < 100; numInts++) {
            string1 = new HugeInteger(n);        //creates a random integer of n digits
            string2 = new HugeInteger(n);        //creates a random integer of n digits
            huge1 = new BigInteger(string1.toString());
            huge2 = new BigInteger(string2.toString());
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 25000000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                huge3 = huge1.add(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime1 += (double) (endTime - startTime) / ((double) 25000000);

        }
        runTime1 = runTime1 / ((double) 100);

        for (int numInts = 0; numInts < 100; numInts++) {
            string1 = new HugeInteger(n);        //creates a random integer of n digits
            string2 = new HugeInteger(n);        //creates a random integer of n digits
            huge1 = new BigInteger(string1.toString());
            huge2 = new BigInteger(string2.toString());
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 25500000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                huge3 = huge1.subtract(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime2 += (double) (endTime - startTime) / ((double) 25500000);

        }
        runTime2 = runTime2 / ((double) 100);

        for (int numInts = 0; numInts < 100; numInts++) {
            string1 = new HugeInteger(n);        //creates a random integer of n digits
            string2 = new HugeInteger(n);        //creates a random integer of n digits
            huge1 = new BigInteger(string1.toString());
            huge2 = new BigInteger(string2.toString());
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 25000000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                huge3 = huge1.multiply(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime3 += (double) (endTime - startTime) / ((double) 25000000);
        }
        runTime3 = runTime3 / ((double) 100);

        for (int numInts = 0; numInts < 100; numInts++) {
            string1 = new HugeInteger(n);        //creates a random integer of n digits
            string2 = new HugeInteger(n);        //creates a random integer of n digits
            huge1 = new BigInteger(string1.toString());
            huge2 = new BigInteger(string2.toString());
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 28000000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                huge3 = huge1.divide(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime4 += (double) (endTime - startTime) / ((double) 28000000);
        }
        runTime4 = runTime4 / ((double) 100);

        for (int numInts = 0; numInts < 100; numInts++) {
            string1 = new HugeInteger(n);        //creates a random integer of n digits
            string2 = new HugeInteger(n);        //creates a random integer of n digits
            huge1 = new BigInteger(string1.toString());
            huge2 = new BigInteger(string2.toString());
            startTime = System.currentTimeMillis();
            for (int numRun = 0; numRun < 650000000; numRun++) {//the number of times this occurs was tested so that endTime-startTime is greater than 500 
                int k = huge1.compareTo(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime5 += (double) (endTime - startTime) / ((double) 650000000);
        }
        runTime5 = runTime5 / ((double) 100);
    }
    
    @Override
    public String toString(){
        String stringNum;
        stringNum = runTime1 + "\n"+runTime2 + "\n"+runTime3 + "\n"+runTime4 + "\n"+runTime5 + "\n";
        return stringNum;
    }
}
