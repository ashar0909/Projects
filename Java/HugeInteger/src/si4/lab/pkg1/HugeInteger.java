/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si4.lab.pkg1;

import java.util.Random;

/**
 *
 * @author imama5
 */
public class HugeInteger {

    char hugeInt[];
    int sign;

    public HugeInteger(String val) throws IllegalArgumentException {
        if ("".equals(val)) {
            throw new IllegalArgumentException("Invalid Input! Please insert an integer");//throws an error if the string is empty
        }
        if (val.charAt(0) == '-') {//Checking if the number is negative
            while (val.charAt(0) == '0'&& val.length() != 1) { // remove leading zeros
                val = val.substring(1);
            }
            hugeInt = new char[val.length() - 1];//create an array of char that's the lenght of the string
            sign = 0;//have the sign be 0, which correlates to a negative number

            for (int i = 1; i < val.length(); i++) {
                if (val.charAt(i) > 59 || val.charAt(i) < 48) {//Checks if the element is a number
                    throw new IllegalArgumentException("Invalid Input! Please insert an integer");//throws an error if the element isn't a number
                } else {
                    hugeInt[i - 1] = val.charAt(i);//puts the number in the corresponding array
                }
            }
        } else {//if the number is positive
            while (val.charAt(0) == '0' && val.length() != 1) {
                val = val.substring(1);
            }
            hugeInt = new char[val.length()];
            sign = 1;//a sign of 1 indicates a positive number
            for (int i = 0; i < val.length(); i++) {
                if (val.charAt(i) > 59 || val.charAt(i) < 48) {
                    throw new IllegalArgumentException("Invalid Input! Please insert an integer");//throws an error if the element isn't a number
                } else {
                    hugeInt[i] = val.charAt(i);//puts the number in the corresponding array
                }

            }
        }
    }

    public HugeInteger(int n) throws IllegalArgumentException {
        if (n <= 0) {//Checks if the input is correct
            throw new IllegalArgumentException("Invalid Input! n has to be greater than 0");
        } else {
            hugeInt = new char[n];
            Random rand = new Random();
            int randomNum;
            randomNum = rand.nextInt(9) + 1;//creates a random number from 1-9
            hugeInt[0] = Character.forDigit(randomNum, 10);//makes it so that the first number isn't a 0
            for (int i = 1; i < n; i++) {
                randomNum = rand.nextInt(10);//creates a random number from 0-9
                hugeInt[i] = Character.forDigit(randomNum, 10);//converts the int into char and puts it into the array
            }
            randomNum = rand.nextInt(2);
            sign = randomNum;//randomly assign 1 or 0 to sign, randomly making it positive or negative
        }
    }

    public HugeInteger(char val) throws IllegalArgumentException {
        if (val > 59 || val < 48) {
            throw new IllegalArgumentException("Invalid Input! Please insert an integer");//throws an error if the element isn't a number
        } else {
            sign = 1;
            hugeInt = new char[1];
            hugeInt[0] = Character.forDigit(val - 48, 10);
        }
    }

    public int compareTo(HugeInteger h) {
        int tell = 0;//defaults to the two numbers being equal
        if (sign > h.sign || hugeInt.length > h.hugeInt.length && sign == 1 || hugeInt.length < h.hugeInt.length && sign == h.sign && sign == 0) {//if this is greater than h
            tell = 1;
        } else if (sign < h.sign || hugeInt.length < h.hugeInt.length && sign == 1 || hugeInt.length > h.hugeInt.length && sign == h.sign && sign == 0) {//if h is greater than this
            tell = -1;
        } else {
            for (int i = 0; i < hugeInt.length; i++) {//individually check all of the numbers and return 1 or -1 if the numbers aren't equal, breaks as soon as the numbers arent equal
                if (Character.getNumericValue(hugeInt[i]) > Character.getNumericValue(h.hugeInt[i]) && sign == 1 || Character.getNumericValue(hugeInt[i]) < Character.getNumericValue(h.hugeInt[i]) && sign == 0) {
                    tell = 1;
                    break;
                } else if (Character.getNumericValue(hugeInt[i]) < Character.getNumericValue(h.hugeInt[i]) && sign == 1 || Character.getNumericValue(hugeInt[i]) > Character.getNumericValue(h.hugeInt[i]) && sign == 0) {
                    tell = -1;
                    break;
                }
            }
        }
        return tell;
    }

    public HugeInteger add(HugeInteger h) {
        String output = "";
        int sum;
        if (sign == 1 && h.sign == 0) {//If the signs are opposite, then subtract the two numbers
            if ((hugeInt.length < h.hugeInt.length)) {
                return h.add(this);// makes this the number with more digits
            } else {
                //copy these values into a new variable so we can modify the variables freely
                char thisArray[] = new char[hugeInt.length];
                char hArray[] = new char[h.hugeInt.length];
                System.arraycopy(hugeInt, 0, thisArray, 0, hugeInt.length);
                System.arraycopy(h.hugeInt, 0, hArray, 0, h.hugeInt.length);
                int thisLength = thisArray.length - 1;
                int hLength = hArray.length - 1;
                int addend1, addend2;// these are the two numbers to be subtracted
                while (thisLength >= 0 || hLength >= 0) {
                    if (thisLength < 0) {//if the length is outside the length of the array, make the addend 0
                        addend1 = 0;
                    } else {
                        addend1 = Character.getNumericValue(thisArray[thisLength]);//if the length is within the length of the array, make the addend the corresponding digit
                    }
                    if (hLength < 0) {
                        addend2 = 0;
                    } else {
                        addend2 = Character.getNumericValue(hArray[hLength]);
                    }
                    if (addend1 < addend2 && thisLength > 0) {// if this number is less than h number 
                        addend1 = addend1 + 10;//increase this number by 10
                        thisArray[thisLength - 1] = Character.forDigit((Character.getNumericValue(thisArray[thisLength - 1]) - 1), 10);//decrease the next number by 1                      
                    }
                    sum = addend1 - addend2;
                    output = sum + output;
                    thisLength--;
                    hLength--;
                }
            }
        }

        if (sign == 0 && h.sign == 1) {//If the signs are opposite, then subtract the two numbers
            if ((hugeInt.length < h.hugeInt.length)) {
                return h.add(this);// makes this the number with more digits
            } else {
                char thisArray[] = new char[hugeInt.length];
                char hArray[] = new char[h.hugeInt.length];
                System.arraycopy(hugeInt, 0, thisArray, 0, hugeInt.length);
                System.arraycopy(h.hugeInt, 0, hArray, 0, h.hugeInt.length);
                int thisLength = thisArray.length - 1;
                int hLength = hArray.length - 1;
                int addend1, addend2;

                while (thisLength >= 0 || hLength >= 0) {
                    if (thisLength < 0) {
                        addend1 = 0;
                    } else {
                        addend1 = Character.getNumericValue(thisArray[thisLength]);
                    }
                    if (hLength < 0) {
                        addend2 = 0;
                    } else {
                        addend2 = Character.getNumericValue(hArray[hLength]);
                    }
                    if (addend1 < addend2 && thisLength > 0) {
                        addend1 = addend1 + 10;
                        thisArray[thisLength - 1] = Character.forDigit((Character.getNumericValue(thisArray[thisLength - 1]) - 1), 10);

                    }
                    sum = addend1 - addend2;
                    output = sum + output;
                    thisLength--;
                    hLength--;
                }
            }
        }
        if (sign == 1 && h.sign == 1 || sign == 0 && h.sign == 0) {//If the sings are positive or negative, add them
            char thisArray[] = new char[hugeInt.length];
            char hArray[] = new char[h.hugeInt.length];
            System.arraycopy(hugeInt, 0, thisArray, 0, hugeInt.length);
            System.arraycopy(h.hugeInt, 0, hArray, 0, h.hugeInt.length);
            int thisLength = thisArray.length - 1;
            int hLength = hArray.length - 1;
            int extra = 0;//create a variable to extra over if the sum is greater than 10
            while (thisLength >= 0 || hLength >= 0) {
                int addend1, addend2;
                if (thisLength < 0) {
                    addend1 = 0;
                } else {
                    addend1 = Character.getNumericValue(thisArray[thisLength]);
                }
                if (hLength < 0) {
                    addend2 = 0;
                } else {
                    addend2 = Character.getNumericValue(hArray[hLength]);
                }
                sum = addend1 + addend2 + extra;
                extra = 0;
                if (sum > 9) {//if the sum is greater than 9, extra over the number
                    extra = 1;
                    sum = sum - 10;
                }
                output = sum + output;
                thisLength--;
                hLength--;
            }
            if (extra == 1) {
                output = 1 + output;
            }
        }
        HugeInteger total = new HugeInteger(output);//create a new hugeInteger with the new string
        //change the sign on the new HugeInteger depending on the sign of the two numbers that got added
        if (sign == 0 && h.sign == 0) {
            total.sign = 0;
        } else if (sign == 1 && h.sign == 1) {
            total.sign = 1;
        } else if ((sign == 0 && h.sign == 1) && (compareTo(h) == -1)) {
            total.sign = 0;
        } else if ((sign == 1 && h.sign == 0) && (compareTo(h) == 1)) {
            total.sign = 1;
        }
        return total;

    }

    public HugeInteger subtract(HugeInteger h) {
        String output = "";
        int diff;
        if ((sign == 1 && h.sign == 0)) {//if the two numbers have oppsite signs, add the two numbers
            int extra = 0;//create a number to extra a number if the sum is greater than 10
            char thisArray[] = new char[hugeInt.length];
            char hArray[] = new char[h.hugeInt.length];
            System.arraycopy(hugeInt, 0, thisArray, 0, hugeInt.length);
            System.arraycopy(h.hugeInt, 0, hArray, 0, h.hugeInt.length);
            int thisLength = thisArray.length - 1;
            int hLength = hArray.length - 1;
            int minuend, subtrahend;//variables for the digits of the numbers being subtracted
            while (thisLength >= 0 || hLength >= 0) {//Start from the most significant digit to least
                if (thisLength < 0) {//if the length is outside the length of the array, make the addend 0
                    minuend = 0;
                } else {
                    minuend = Character.getNumericValue(thisArray[thisLength]);//if the length is within the length of the array, make the addend the corresponding digit
                }
                if (hLength < 0) {
                    subtrahend = 0;
                } else {
                    subtrahend = Character.getNumericValue(hArray[hLength]);
                }
                diff = minuend + subtrahend + extra;
                extra = 0;
                if (diff > 9) {
                    diff = diff - 10;
                    extra = 1;

                }
                output = diff + output;
                thisLength--;
                hLength--;
            }
            if (extra == 1) {
                output = 1 + output;
            }
        }

        if (sign == 0 && h.sign == 1) {//add the two numbers again because the signs are opposite
            int extra = 0;
            char thisArray[] = new char[hugeInt.length];
            char hArray[] = new char[h.hugeInt.length];
            System.arraycopy(hugeInt, 0, thisArray, 0, hugeInt.length);
            System.arraycopy(h.hugeInt, 0, hArray, 0, h.hugeInt.length);
            int thisLength = thisArray.length - 1;
            int hLength = hArray.length - 1;
            int minuend, subtrahend;
            while (thisLength >= 0 || hLength >= 0) {
                if (thisLength < 0) {
                    minuend = 0;
                } else {
                    minuend = Character.getNumericValue(thisArray[thisLength]);
                }
                if (hLength < 0) {
                    subtrahend = 0;
                } else {
                    subtrahend = Character.getNumericValue(hArray[hLength]);
                }
                diff = minuend + subtrahend + extra;
                extra = 0;
                if (diff > 9) {
                    diff = diff - 10;
                    extra = 1;
                }
                output = diff + output;
                thisLength--;
                hLength--;
            }
            if (extra == 1) {
                output = 1 + output;
            }
        }
        //if both signs are positive or negative and this has fewer digits
        if (sign == 1 && h.sign == 1 && compareTo(h) == -1 || sign == 0 && h.sign == 0 && compareTo(h) != -1) {
            char thisArray[] = new char[hugeInt.length];
            char hArray[] = new char[h.hugeInt.length];
            System.arraycopy(hugeInt, 0, thisArray, 0, hugeInt.length);
            System.arraycopy(h.hugeInt, 0, hArray, 0, h.hugeInt.length);
            int thisLength = thisArray.length - 1;
            int hLength = hArray.length - 1;
            while (thisLength >= 0 || hLength >= 0) {
                //if this has fewer digits, then make h subtract this
                int minuend, subtrahend;
                if (thisLength < 0) {
                    subtrahend = 0;
                } else {
                    subtrahend = Character.getNumericValue(thisArray[thisLength]);
                }
                if (hLength < 0) {
                    minuend = 0;
                } else {
                    minuend = Character.getNumericValue(hArray[hLength]);
                }
                if (minuend < subtrahend) {
                    minuend += 10;
                    hArray[hLength - 1] = Character.forDigit((Character.getNumericValue(hArray[hLength - 1]) - 1), 10);
                }
                diff = minuend - subtrahend;
                output = diff + output;
                thisLength--;
                hLength--;
            }
            //if both signs are positive or negative and this has more digits
        } else if (sign == 1 && h.sign == 1 && compareTo(h) != -1 || sign == 0 && h.sign == 0 && compareTo(h) == -1) {//if this is the bigger number
            char thisArray[] = new char[hugeInt.length];
            char hArray[] = new char[h.hugeInt.length];
            System.arraycopy(hugeInt, 0, thisArray, 0, hugeInt.length);
            System.arraycopy(h.hugeInt, 0, hArray, 0, h.hugeInt.length);
            int thisLength = thisArray.length - 1;
            int hLength = hArray.length - 1;
            while (thisLength >= 0 || hLength >= 0) {
                //if this has more digits, make this subtract h
                int minuend, subtrahend;
                if (thisLength < 0) {
                    minuend = 0;
                } else {
                    minuend = Character.getNumericValue(thisArray[thisLength]);
                }
                if (hLength < 0) {
                    subtrahend = 0;
                } else {
                    subtrahend = Character.getNumericValue(hArray[hLength]);
                }
                if (minuend < subtrahend) {
                    minuend += 10;
                    thisArray[thisLength - 1] = Character.forDigit((Character.getNumericValue(thisArray[thisLength - 1]) - 1), 10);
                }
                diff = minuend - subtrahend;
                output = diff + output;
                thisLength--;
                hLength--;
            }
        }
        HugeInteger total = new HugeInteger(output);
        //change the sign in total depending on the numbers inputted
        if (sign == 0 && h.sign == 0 && compareTo(h) == -1) {
            total.sign = 0;
        } else if (sign == 1 && h.sign == 1 && compareTo(h) == -1) {
            total.sign = 0;
        } else if ((sign == 0 && h.sign == 1)) {
            total.sign = 0;
        } else if ((sign == 0 && h.sign == 0) && (compareTo(h) == 1)) {
            total.sign = 1;
        } else if (sign == 1 && h.sign == 1 && compareTo(h) == 1) {
            total.sign = 1;
        }
        return total;
    }

    public HugeInteger multiply(HugeInteger h) {
        int extra = 0;
        int mult;
        int remainder;
        HugeInteger product = new HugeInteger("0");
        String temp = "";
        if (this.hugeInt.length < h.hugeInt.length) {
            return (h.multiply(this));// if this is shorter, reverse the two numbers
        } else {
            //multiply the shorter HugeInt by every number in the longer HugeInt and add the results
            for (int i =  h.hugeInt.length - 1; i >=0; i--) {
                int num =Character.getNumericValue(h.hugeInt[i]) ;
                for (int j =  this.hugeInt.length-1; j >=0; j--) {
                    mult = num * Character.getNumericValue(this.hugeInt[j])  + extra;
                    extra = mult / 10;//leaves the number to add to the next digit
                    remainder = mult % 10;//stores the number corresponding to this digit
                    if (j == 0) {
                        remainder = mult;//since there is no number after j=0, make remainder multi
                    }
                    temp = remainder + temp;//add remainder to the beggining of temp as we start from the lowest digit
                }
                HugeInteger temp_Huge = new HugeInteger(temp);
                product = product.add(temp_Huge);// add temp to product
                temp = "0";
                for (int k = 1; k <=  h.hugeInt.length - 1-i; k++) {
                    temp = temp + "0";//add zeros to temp to get it to the right place value 
                }
                extra = 0;
            }
            if (this.sign == 1 && h.sign == 0 || this.sign == 0 && h.sign == 1) {//change the sign of the product dependsing on the factors
                product.sign = 0;
            }
            return product;

        }

    }
    
    
    public HugeInteger divide(HugeInteger h) throws IllegalArgumentException{
        if (Character.getNumericValue(h.hugeInt[0])==0){
            throw new IllegalArgumentException("Invalid Input! Cannot divide by zero");//throws an error if the string is zero
        }
        HugeInteger thisCopy = new HugeInteger(toString());//copy the HugeIntegers into new HugeIntegers
        HugeInteger hCopy = new HugeInteger(h.toString());
        HugeInteger quotient = new HugeInteger("0");
        HugeInteger one = new HugeInteger("1");
        thisCopy.sign = 1;//make both the HugeInt positive to make it easier to divide
        hCopy.sign =1;
        if (thisCopy.compareTo(hCopy) ==-1) {
            return quotient;
        }else{
            while(thisCopy.compareTo(hCopy) >=0){//subtract the bigger one by the smaller one untill the bigger one is smaller than the smaller one
                thisCopy = thisCopy.subtract(hCopy);
                quotient = quotient.add(one);//increment the quotient every time a subtraction occurs
            }
        }
        if(sign ==1 && h.sign == 0 || sign ==0 && h.sign ==1){//change the sign depending on the dividend and divisor
            quotient.sign = 0;
        }
          return quotient;
    }
    
    @Override
    public String toString() {//send the HugeInterger into a string
        String stringNum = "";
        if (sign == 1) {
            for (int i = 0; i < hugeInt.length; i++) {
                stringNum = stringNum + hugeInt[i];
            }
        } else {
            stringNum = "-";
            for (int i = 0; i < hugeInt.length; i++) {
                stringNum = stringNum + hugeInt[i];
            }
        }
        return stringNum;
    }

}

