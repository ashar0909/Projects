#include <string.h>
#include <stdio.h>
#include <stdlib.h>


char **read_words(const char *input_filename, int *nPtr);

int main(void){
    return 0;
}

char **read_words(const char *input_filename, int *nPtr){
    int n,i;
    char ** list = malloc((*nPtr)*sizeof(char*));


}


/*
//Qustion 1
char *my_strcat( const char * const str1, const char * const str2);

int main(void){
    printf( "%s\n", my_strcat( "Hello", "world!" ));
    return 0;
  }


char *my_strcat( const char * const str1, const char * const str2){
    int n,i;
    char *str3;
    n = strlen(str1)+strlen(str2);
    str3 = (char*) malloc(n);
    for (i=0;i<strlen(str1);i++){
        str3[i]=str1[i];
    }
    for (i=0;i<strlen(str2);i++){
        str3[i+strlen(str1)]=str2[i];
    }
    return str3;
}
















//Question 2
typedef struct {
   int  studentNumber;
   char  firstName[15];
   char  lastName[15];
   int   project1Grade;
   int   project2Grade;
   float grade;
} student;

student **create_class_list(char *filename, int *sizePtr );
int find(int idNo,  student **list, int size);
void input_grades(char *filename, student **list, int size);
void compute_final_course_grades(student **list, int size);
void output_final_course_grades(student **list, int size);
void print_list(student **list, int size);
void withdraw(int idNo, student **list, int *sizePtr);
void destroy_list(student **list, int *sizePtr);


int main(void){
    char *file = "lab3.txt",*file2 = "grade.txt";
    int n =0;
    int*p =&n;
    student ** studentArr;
    studentArr = create_class_list(file, p );
    input_grades(file2, studentArr, n);
    compute_final_course_grades(studentArr, n);
    output_final_course_grades(studentArr, n);
    withdraw(999, studentArr, p);
    withdraw(4580, studentArr, p);
    print_list(studentArr, n);
    withdraw(9000, studentArr, p);
    destroy_list(studentArr, p);
    print_list(studentArr, n);

    return 0;
}

 student **create_class_list(char *filename, int *sizePtr ){
    FILE * fp;
    fp = fopen(filename,"r");
    int i;
    fscanf (fp, "%d", sizePtr);
    student ** stu;
    int * temp;
    stu = malloc(*sizePtr*sizeof(student*));
    for (i=0;i<*sizePtr;i++){
        stu[i]=malloc(sizeof(student));
        temp = &(*stu[i]).studentNumber;
        fscanf (fp, "%d", temp);
        fscanf (fp, "%s", (*stu[i]).firstName);
        fscanf (fp, "%s", (*stu[i]).lastName);
        (*stu[i]).project1Grade =0;
        (*stu[i]).project2Grade =0;
        (*stu[i]).grade = 0.0;
    }
    fclose(fp);
    return stu;
}



int find(int idNo, student **list, int size){
    int i;
    for (i=0;i<size;i++){
        if ((*list[i]).studentNumber==idNo){
            return i;
        }
    }
    return -1;
}



void input_grades(char *filename, student **list, int size){
    int i,n;
    FILE * fp;
    fp = fopen(filename,"r");
    int temp =0;
    for (i=0;i<size;i++){
        fscanf (fp, "%d", &temp);
        n = find(temp,list,size);
        fscanf (fp, "%d", &(*list[n]).project1Grade);
        fscanf (fp, "%d", &(*list[n]).project2Grade);
    }
    fclose(fp);
}

void compute_final_course_grades(student **list, int size){
    int i;
    for(i=0;i<size;i++){
        (*list[i]).grade = ((*list[i]).project1Grade + (*list[i]).project2Grade)/2;
    }
}


void output_final_course_grades(student **list, int size){
    int i;
    FILE * fp;
    fp = fopen("finalGrades.txt", "w");
    fprintf(fp, "%d\n",size);
    for(i=0;i<size;i++){
        fprintf(fp, "%d ",(*list[i]).studentNumber);
        fprintf(fp, "%f\n",(*list[i]).grade);
    }
    fclose(fp);
}

void print_list(student **list, int size){
    int i;
    for(i=0;i<size;i++){
        printf( "ID: %d, name: %s %s, project1grade: %d, project 2 grade: %d, finalgrade: %f\n",(*list[i]).studentNumber,(*list[i]).firstName,(*list[i]).lastName,(*list[i]).project1Grade,(*list[i]).project2Grade,(*list[i]).grade);
    }
}


void withdraw(int idNo, student **list, int *sizePtr){
    int i,j,check;
    check = *sizePtr;
    for (i=0;i<*sizePtr;i++){
        if(idNo==(*list[i]).studentNumber){
            free(list[i]);
            for(j=i+1;j<*sizePtr;j++){
                list[j-1]=list[j];
            }
            *sizePtr = *sizePtr-1;
        }
    }
    if (check == *sizePtr){
        printf("The student was not in the list\n");
    }
}


void destroy_list(student **list, int *sizePtr){
    int i,j;
    j = *sizePtr;
    for (i=0;i<j;i++){
        free(list[i]);
        *sizePtr = *sizePtr-1;
    }
}





*/
