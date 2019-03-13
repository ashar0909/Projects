#include <stdio.h>
#include <stdlib.h>

/*
//Question 1
int main(void)
{
    int sum1=0,sum2=0,sum3=0,i,j=30,k=30;
    for (i=30; i<1000; i+=4)
    {
        sum1+=i;
    }
    printf("The sum is %d\n", sum1);
      while(j<1000)
    {
        sum2+=j;
        j+=4;
    }
    printf("The sum is %d\n", sum2);
    do{
        sum3+=k;
        k+=4;
    } while(k<1000);
    printf("The sum is %d\n", sum3);
    return 0;
}



//Question 2
int main(void)
{
    int x,i=1;
    printf("Please input a positive integer: ");
    scanf("%d", &x);
    while (i){
        if (x>0){
            printf("%d", x);
            break;
        }else{
        printf("That is not a positive integer, please input a positive integer: ");
        scanf("%d", &x);
        continue;
        }
    }

    return 0;
}



//Question 3
int main(void)
{
    int counter,i=1,number,smallest;
    printf("Please input a positive integer: ");
    scanf("%d", &counter);
    while (i){
        if (counter>0){
            break;
        }else{
        printf("That is not a positive integer, please input a positive integer: ");
        scanf("%d", &counter);
        continue;
        }
    }
    for(i=0;i<counter;i++ ){
        printf("Please input an integer: ");
        scanf("%d", &number);
        if (number<smallest)
            smallest = number;
    }
    printf("The smallest number is %d", smallest);
    return 0;
}


//Question 4
int main(void)
{
    int x,i=1;
    while (i){
        printf("Please input an integer (0 to end): ");
        scanf("%d", &x);
        if (x>=10000&&x<=99999||x<=-10000&&x>=-99999){
            printf("Your input is a five-digit number: %d\n", x);
            continue;
        }else if (x==0)
        break;
    }
    return 0;
}




//Question 5
int main(void)
{
    float x;
    int average;
    printf("Please input a student's average: ");
    scanf("%f", &x);
    average = (int)x;
    switch (average){
        case 90 ... 100: printf("4\n");
        break;
        case 80 ... 89: printf("3\n");
        break;
        case 70 ... 79: printf("2\n");
        break;
        case 60 ... 69: printf("1\n");
        break;
        case 0 ... 59: printf("0\n");
        break;
        default: printf("That was not a valid input\n");
    }
    return 0;
}


//Question 6
int main(void)
{
    int n, counter = 1;
    float i=1.0, approximate ;
    printf("Please input a positive integer: ");
    scanf("%d", &n);
    while (i){
        if (n>0){
            break;
        }else{
        printf("That is not a positive integer, please input a positive integer: ");
        scanf("%d", &n);
        continue;
        }
    }
    for (counter=1;counter<=n;counter++){
        if (counter%2==0)
            approximate = approximate - 4/i;
        else
            approximate = approximate + 4/i;
        i+=2;
    }
    printf("The approximation is %f: ", approximate);
    return 0;
}


//Question 7
int main(void)
{
    int side1, side2, hypotenuse, counter;
    for (hypotenuse = 1;hypotenuse<=400;hypotenuse++){
            for (side2 = 1;side2<=400;side2++){
                    for (side1 = 1;side1<=400;side1++){
                        if (side1*side1+side2*side2==hypotenuse*hypotenuse){
                            printf("%d, %d, and %d\n", side1, side2, hypotenuse);
                            counter +=1;
                        }
                    }
            }
    }
    printf("The total number of combinations are %d\n", counter);
    return 0;
}



//Question 8
int main(void)
{
    int x,i=1,j,sum;
    printf("Please input a positive integer: ");
    scanf("%d", &x);
    while (i){
        if (x>0){
            break;
        }else{
        printf("That is not a positive integer, please input a positive integer: ");
        scanf("%d", &x);
        continue;
        }
    }
    for (i=1; i<x;i++){
            sum = 0;
            for (j=1;j<i;j++){
                if(i%j==0){
                    sum+=j;
                }
            }
            if (sum == i){
                printf("%d\n",i);
            }
    }
    return 0;
}


//Question 9
int main(void)
{
    int n,i,j,k,increment,num=1;
    printf("Please input a positive integer from 1 to 25: ");
    scanf("%d",&n);
    for (i=0;i<n;i++){
        for (j=0;j<n;j++){
            printf("*");
        }
        printf("\n");
    }
    increment = (n-1);
    for(i=0;i<n;i++){
        for(j=0;j<increment;j++){
            printf(" ");
        }
        for (k=0;k<num;k++){
            printf("*");
        }
        increment-=1;
        num+=2;
        printf("\n");
    }
    increment = n*2-1;
    for (i=0;i<n;i++){
        for (j=0;j<increment;j++){
            printf("*");
        }
        printf("\n");
        increment = increment-2;
    }
    increment = 0;
    num = n;
    for(i=0;i<(n-1)/2+1;i++){
        for(j=0;j<increment;j++){
            printf(" ");
        }
        for (k=0;k<num;k++){
            printf("*");
        }
        increment+=1;
        num-=2;
        printf("\n");
    }
    num=3;
    increment = (n-1)/2-1;
    for(i=0;i<(n-1)/2;i++){
        for(j=0;j<increment;j++){
            printf(" ");
        }
        for (k=0;k<num;k++){
            printf("*");
        }
        increment-=1;
        num+=2;
        printf("\n");
    }
    return 0;
}


//Question 10
int main(void){
    int x,counter=0;
    printf("Enter a positive integer: ");
    scanf("%d", &x);
    while(x>0){
        x=x/10;
        counter+=1;
    }
    printf("\n Your number has %d digits", counter);
    return 0;
}


//Question 11
int main(void){
    int x,newx=0,temp=0,i,divider=1,multiplier = 1,counter=0,x2=0;
    printf("Enter a positive integer ");
    scanf("%d",&x);
    x2=x;
    while(x2>0){
        x2=x2/10;
        counter+=1;
    }
    for(i=0;i<counter-1;i++){
        divider=divider*10;
    }
    for (i=counter;i>0;i--){
        temp = x/divider;
        newx = temp*multiplier+newx;
        x = x%divider;
        divider = divider/10;
        multiplier = multiplier*10;
    }
    printf("%d",newx);
    return 0;
}

//Question 12
int main(void){
    int x,temp=0,i,divider=1,counter=0,x2=0,sum=0,j;
    printf("Enter a positive integer with only 1 and 0 ");
    scanf("%d",&x);
    x2=x;
    while(x2>0){
        x2=x2/10;
        counter+=1;
    }
    for(i=0;i<counter-1;i++){
        divider=divider*10;
    }
    for(i=0;i<counter;i++){
        temp = x/divider;
        x = x%divider;
        divider = divider/10;
        for (j=0;j<counter-i-1;j++){
            temp = temp*2;
        }
        sum = sum+temp;
    }
    printf("Your number is %d",sum);
    return 0;
}



//Question 13

int main(void)
{
    int x,i,j,fact=1,e=1,fact2=1;
    printf("Enter a non-negative integer: ");
    scanf("%d",&x);
    for (i=1;i<=x;i++){
        fact = fact*i;
    }
    for (i=0;i<x;i++){
        for (j=1;j<=i;j++){
            fact2 = fact2*i;
        }
        e = e+1/fact2;
        fact2=1;
    }
    printf("Your factorial is %d\n", fact);
    printf("The estimate is %d\n", e);
    return 0;
}



//Question 14
int main(void){
    int x,i,temp;
    printf("Enter a positive integer: ");
    scanf("%d",&x);
    for (i=2;i<x;i++){
        temp = x%i;
        if (temp==0){
            break;
        }
    }
    if (temp==0){
        printf("Your number is not a prime number");
    }else{
        printf("Your number is a prime number");
    }
    return 0;
}


*/


