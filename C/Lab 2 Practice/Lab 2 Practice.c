#include <stdio.h>
#include <math.h>

//Question 14

voidaddEff( int val1[], int val2[], int val3[],int pos1[], int pos2[],int pos3[],int k1, int k2);
void reconstruct( int source[], int m, const int val[], const int pos[], int n) {

int main (void){

}

voidaddEff( int val1[], int val2[], int val3[],int pos1[], int pos2[],int pos3[],int k1, int k2){
    int i,j,count=0;

        for (i=0;i<k1;i++){
            for (j=0;j<k2;j++){
            if(pos1[i]<pos2[j]){
                val3[i] = va11[i];
            }else if(pos1[i]>pos2[j]){
                val3[i] = va12[i];
            }else if(pos1[i]== pos2[j]){
                val3[[pos1[i]] = val2[i]+ va11[i];
            }
        }



}
















/*
//Question 1
void print_vector(double array[], int size);
void add_vectors( double vector1[], double vector2[], double vector3[], int n);
double scalar_prod(double vector1[],double vector2[],int n);
double norm2(double vector[],int n);

int main (void){
    double ray[3] = {2,4,6},ray2[3] = {0,1,2},ray3[3],prod = 0.0,nor;
    add_vectors(ray,ray2,ray3,3);
    print_vector(ray3,3);
    prod = scalar_prod(ray,ray2,3);
    nor = norm2(ray2,3);
    printf("\n%lf",nor);

    return 0;
}
void print_vector(double array[], int size){
    int i;
    for (i=0;i<size;i++){
        printf("%lf, ",array[i]);
    }
}
void add_vectors( double vector1[], double vector2[], double vector3[], int n){
    int i;
    for (i=0;i<n;i++){
        vector3[i]=vector1[i]+vector2[i];
    }
}
double scalar_prod(double vector1[],double vector2[],int n){
    int i;
    double scalarprod = 0.0;
    for (i=0;i<n;i++){
        scalarprod += vector1[i]*vector2[i];
    }
    return scalarprod;
}
double norm2(double vector[],int n){
    double square;
    square = scalar_prod(vector,vector,n);
    return sqrt(square);
}


//Question 2
void sorted (int array[],int size);

int main (void){
    int test[6]={1,2,3,4,5,6};
    sorted(test,6);

    return 0;
}


void sorted (int array[],int size){
    int temp=0,i,pos=0,neg=0,eq=0;
    for (i=0;i<size;i++){
        temp = array[i];
        if (temp!=array[i+1]&&temp<array[i+1]){
            neg++;
        }else if(temp!=array[i+1]&&temp>array[i+1]){
            pos++;
        }else if(temp==array[i+1]){
            eq++;
        }
    }
    if ((pos+eq)==size||(neg+eq)==size){
        printf("The array is sorted");
    }else{
        printf("The array is not sorted");
    }
}



//Question 3
void counter (int array[],int size,int num);

int main (void){
    int test[6]={1,1,1,4,5,6};
    counter(test,6,1);

    return 0;
}


void counter (int array[],int size,int num){
    int count=0,i;
    for (i=0;i<size;i++){
        if (array[i]==num){
            count++;
        }
    }
    printf("%d was in the array %d times", num, count);
}

//Question 4
void change (int x[],int n);

int main (void){
    int i;
    int test[10]={0,-1,2,0,7,6,-8,0,9,0};
    change(test,10);
    for (i=0;i<10;i++){
        printf("%d ",test[i]);
    }
    return 0;
}


void change (int x[],int n){
    int i,count=0,j;
    for (i=0;i<n;i++){
        if (x[i]==0){
            count++;
        }
    }
    for (i=0;i<n;i++){
        if (x[i]==0){
            for (j=i;j<n;j++){
                x[j]=x[j+1];
            }
        }
    }
    for (i=(n-count);i<n;i++){
        x[i]=0;
    }

}




//Question 5
#define N 5
int is_diag_dom( int mat[ ][N]);

int main (void){
    int i,j,tell, arr[5][5];
    for (i=0;i<5;i++){
        for(j=0;j<5;j++){
            arr[i][j]=j+1;
        }
        arr[i][i]=50;
    }
    tell = is_diag_dom(arr);
    printf("%d",tell);
    return 0;
}


int is_diag_dom( int mat[ ][N]){
    int i,j,count=0,add=0;
    for (i=0;i<N;i++){
        add=0;
        for (j=0;j<N;j++){
            add += mat[i][j];
        }
        add -= mat[i][i];
        if (mat[i][i]>add){
            count++;
        }
    }
    if (count ==N){
        return 1;
    }else{
        return 0;
    }
}



//Question 6

int main (void){
    int i,j, arr[5][5];
    for (i=0;i<5;i++){
        for(j=0;j<5;j++){
            arr[i][j]=j+1;
        }
    }
     for (i=0;i<5;i++){
        for(j=0;j<5;j++){
            printf("%d  ",arr[i][j]);
        }
    }

}



//Question 7
#define  N  5
int is_toeplitz(int a[][N], int m);

int main (void){


}

int is_toeplitz(int a[][N], int m){
    int i,j=0,k=0,temp;
    for (i=0;i<N;i++){
        temp = a[0][i];
        j=0;
        k=i;
        while(++j < N && ++k < m){
            if(a[j][k]!= temp){
                return 0;
            }
        }
    }
    for (i=0;i<m;i++){
        temp = a[i][0];
        j=i;
        k=0;
        while(++j < N && ++k < m){
            if(a[j][k]!= temp){
                return 0;
            }
        }
    }

    return 1;

}


//Question 8
void letter_freq(const char word[], int freq []);

int main (void){
    int a[26] = {0};
    const char w[] = "qwertyuioplkjhgfdsazxcvbn";
    letter_freq(w, a);
    return 0;
}


void letter_freq(const char word[], int freq []){
    char i=0,temp, low= 'a',high = 'A',j;
    while (temp != '\0'){
        temp = word[i];
        if('a'<=temp&& temp<='z'){
            freq[temp-97]++;
            printf("hello\n");
        }
        if('A'<=temp && temp<='Z'){
            freq[temp-65]++;
        }
    i++;
    }
    for (j=0;j<26;j++){
        printf("The count of %c and %c is %d\n",high,low,freq[j]);
        high++;
        low++;
    }

}

//Question 9
void string_copy(const char source[], char destination[], int n);

int main (void){
    const char x[] = "hello";
    char y[3];
    string_copy(x, y, 3);
    printf("%s",y);
    return 0;
}

void string_copy(const char source[], char destination[], int n){
    int i;
    for(i=0;i<n;i++){
        destination[i] = source[i];
    }
    destination[n]='\0';
}


//Question 10
void my_strcat( const char str1[], const char str2[], char str3[], int n);

int main (void){
    const char x[] = "hello",y[] = "bye";
    char z[5];
    my_strcat(x, y, z,5);
    printf("%s",z);
    return 0;
}

void my_strcat( const char str1[], const char str2[], char str3[], int n){
    int i=0,j=0;
    while (str1[i]!='\0'){
        i++;
    }
    while (str2[j]!='\0'){
        j++;
    }
    if(i+j>n){
        printf("The two arrays are too big, please try again with smaller arrays \n");
    }else{
        i=0,j=0;
        while (str1[i]!='\0'){
            str3[i] = str1[i];
            i++;
        }
        while (str2[j]!='\0'){
            str3[j+i] = str2[j];
            j++;
        }
        str3[j+i]='\0';
    }
}



//Question 12
int ispre(const char s[], const char p[]);

int main (void){
    int i;
    const char pre[] = "bac",word[] = "base";
    i = ispre(pre,word);
    printf("%d",i);
    return 0;
}

int ispre(const char s[], const char p[]){
     int i=0,j=0,count =0;
     while (s[i]!='\0'){
        i++;
     }
     for (j=0;j<i;j++){
        if (s[j]==p[j]){
            count++;
        }
     }
    if (count == i){
        return 1;
    }else{
        return 0;
    }

}



//Question 13
void efficient( const int source[], int val[], int pos[], int size);
void reconstruct( int source[], int m, const int val[], const int pos[], int n) ;

int main (void){
    int a[10] = {1,0,0,0,2,0,3,0,0,0},b[3],c[3],a2[10],b2[3] = {1,2,3},c2[3] = {0,4,6},i;
    efficient(a,b,c,10);
    reconstruct(a2,10,b2,c2,3);
    for (i=0;i<3;i++){
        printf("%d",b[i]);
    }
    printf("\n");
    for (i=0;i<3;i++){
        printf("%d",c[i]);
    }
    printf("\n");
    for (i=0;i<10;i++){
        printf("%d",a2[i]);
    }
    return 0;
}
void efficient( const int source[], int val[], int pos[], int size){
    int i,j=0;
    for (i=0;i<size;i++){
        if (source[i]!=0){
            val[j]=source[i];
            pos[j] = i;
            j++;
        }
    }
}



void reconstruct( int source[], int m, const int val[], const int pos[], int n) {
    int i,j;
    for (i=0;i<m;i++){
        source[i] = 0;
    }
    for (j=0;j<n;j++){
        source[pos[j]]=val[j];
    }
}

*/
