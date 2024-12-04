import java.util.Scanner;


public class Main {




    public static void main(String[] args) {

        String[] student_id = new String[100];
        String[] student_name = new String[100];
        int []programing_marks = new int[100];
        int []database_marks = new int[100];
        int student_count = 0;
        int []total_marks = new int[100];
        double[]total_avg = new double[100];


        String []sorted_name = new String[100];
        String []sorted_id = new String[100];
        int []sorted_programing_marks = new int[100];
        int []sorted_database_marks = new int[100];

        int []all_total_marks = new int[100];
        double []all_total_avg = new double[100];
        int []rank = new int[100];

        while(true){
            home();

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter an option to continue > ");
            int option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                student_count = add_new_student( student_id,student_name,student_count);

            } else if (option == 2) {
                student_count = new_student_withMark(student_id,student_name,student_count
                        ,programing_marks,database_marks);

            } else if (option == 3) {
                add_mark(student_id,student_name,programing_marks,database_marks,student_count);
            }else if (option == 4) {
                update_student_details(student_id,student_name,student_count);
            }else if (option == 5) {
                update_marks(student_id,student_name,student_count,programing_marks,database_marks);
            }else if (option == 6) {
                delete_student(student_id,student_name,student_count,programing_marks,database_marks);
            }else if (option == 7) {
                print_student_details(student_id,student_name,student_count,programing_marks,
                        database_marks,total_marks,total_avg,rank);
            }else if (option == 8) {
                print_student_ranks(student_id,student_name,student_count,total_marks,total_avg,
                        sorted_name,sorted_id,programing_marks,database_marks,all_total_marks,all_total_avg,rank);
                System.out.print("Do you want go back to main menu? (y/n)");
                String answer1 = scan.nextLine();
                if (answer1.equalsIgnoreCase("n")) {
                    break;
                }
            }else if (option == 9) {
                programing(student_id,student_name,student_count,sorted_database_marks,
                        sorted_programing_marks,sorted_name,sorted_id,programing_marks,database_marks);
                System.out.print("Do you want go back to main menu? (y/n)");
                String answer1 = scan.nextLine();
                if (answer1.equalsIgnoreCase("n")) {
                    break;
                }
            } else if (option == 10) {
                database(student_id,student_name,student_count,sorted_database_marks,
                        sorted_programing_marks,sorted_name,sorted_id,programing_marks,database_marks);
                System.out.print("Do you want go back to main menu? (y/n)");
                String answer1 = scan.nextLine();
                if (answer1.equalsIgnoreCase("n")) {
                    break;
                }
            }


        }

    }
    public static void home(){

        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t WELCOME TO MARKS MANAGEMENT SYSTEM                    ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.print("[1] Add New Student                        ");
        System.out.println("[2] Add Student With Marks");
        System.out.print("[3] Add Marks                              ");
        System.out.println("[4] Update Student Details");
        System.out.print("[5] Update Marks                           ");
        System.out.println("[6] Delete Student ");
        System.out.print("[7] Print Student Details                  ");
        System.out.println("[8] Print Student Ranks");
        System.out.print("[9] Best in Programing Fundamentals        ");
        System.out.println("[10] Best in Database Management System   ");
    }

    public static int add_new_student(String[] id,String[] name,int student_count) {

        Scanner scan = new Scanner(System.in);


        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t\t ADD NEW STUDENT                           ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        while(true){

            while (true) {
                System.out.print("Enter student id: ");
                String student_id = scan.nextLine();

                boolean exists = false;
                for (int i = 0; i < student_count; i++) {
                    if (student_id.equals(id[i])) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("The student already exists.");
                    System.out.println();
                } else {
                    id[student_count] = student_id;
                    break;
                }
            }

            System.out.print("Enter student name: ");
            String student_name = scan.nextLine();
            name[student_count] = student_name;
            System.out.println();
            student_count++;
            System.out.print("Student has been added to the successfully.Do you want to add a new student (y/n) ");
            String answer = scan.nextLine();
            System.out.println();

            if (answer.equals("N") || answer.equals("n")) {
                break;


            }
        }
        return student_count;

    }

    public static int new_student_withMark(String[] id,String[] name,int student_count,
                                           int[] programing_marks,int[] database_marks) {
        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t ADD NEW STUDENT WITH MARKS                    ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        while(true){

            while (true) {
                System.out.print("Enter student id: ");
                String student_id = scan.nextLine();

                boolean exists = false;
                for (int i = 0; i < student_count; i++) {
                    if (student_id.equals(id[i])) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("The student already exists. Please enter a different ID.");
                } else {
                    id[student_count] = student_id;
                    break;
                }
            }

            System.out.print("Enter student name: ");
            String student_name = scan.nextLine();
            name[student_count] = student_name;
            System.out.println();

            while(true){
                System.out.print("Programing Fundamentals marks  : ");
                int programing_mark = scan.nextInt();
                if (programing_mark < 0 || programing_mark > 100) {
                    System.out.println("invalid marks.please enter correct marks.");
                    System.out.println();
                }else{
                    programing_marks[student_count] = programing_mark;
                    break;
                }
            }

            while(true){
                System.out.print("Database management system marks  : ");
                int database_mark = scan.nextInt();
                if (database_mark < 0 || database_mark > 100) {
                    System.out.println("invalid marks.please enter correct marks.");
                    System.out.println();
                }else{
                    database_marks[student_count] = database_mark;
                    break;
                }
            }

            scan.nextLine();
            student_count++;
            System.out.println();

            System.out.print("Student has been added to the successfully.Do you want to add a new student (y/n) ");
            String answer1 = scan.nextLine();
            System.out.println();
            if (answer1.equals("N") || answer1.equals("n")) {
                break;
            }


        }
         return student_count;

    }

    public  static void add_mark(String[] id,String[] name,int[] programing_marks,
                                 int[] database_marks,int student_count) {
        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t\t\t ADD MARKS                             ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        while(true){
            System.out.print("Enter student id: ");
            String student_id = scan.nextLine();

            boolean exists = false;
            for(int i=0;i<student_count;i++){
                if (student_id.equals(id[i])) {
                    exists = true;
                }
            }

            if (!exists) {
                System.out.print("invalid student id.Do you want to search again (y/n)");
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("n")){
                    break;
                }
            }else {
                for (int i = 0; i < student_count; i++) {
                    if (student_id.equals(id[i])) {
                        System.out.println("Student name :"+ name[i]);
                        if (programing_marks[i] != 0){
                            System.out.println("This student's marks have been  already  added.");
                            System.out.println("If you want to update the mark, please use [4] update marks option.");
                            System.out.println();
                            break;


                        }else{
                            System.out.println();
                            while(true){
                                System.out.print("Programing Fundamentals marks  : ");
                                int programing_mark = scan.nextInt();
                                if (programing_mark < 0 || programing_mark > 100) {
                                    System.out.println("invalid marks.please enter correct marks.");

                                }else{
                                    programing_marks[i] = programing_mark;
                                    break;
                                }
                            }
                            while(true){
                                System.out.print("Database management system marks  : ");
                                int database_mark = scan.nextInt();
                                if (database_mark < 0 || database_mark > 100) {
                                    System.out.println("invalid marks.please enter correct marks.");
                                }else{
                                    database_marks[i] = database_mark;
                                    break;
                                }
                            }
                            scan.nextLine();
                        }
                    }
                }

                System.out.print("Do you want tho add marks for another student (y/n)");
                String answer1 = scan.nextLine();
                System.out.println();

                if (answer1.equals("N") || answer1.equals("n")) {
                    break;
                }
            }
        }
    }

    public  static  void update_student_details(String[] id,String[] name,int student_count) {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t UPDATE STUDENT DETAILS                        ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        while(true){
            System.out.print("Enter student id: ");
            String student_id = scan.nextLine();

            boolean exists = false;
            for(int i=0;i<student_count;i++){
                if (student_id.equals(id[i])) {
                    exists = true;
                }
            }

            if (!exists) {
                System.out.print("invalid student id.Do you want to search again (y/n)");
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("n")){
                    break;
                }
            }else {
                for (int i = 0; i < student_count; i++) {
                    if (student_id.equals(id[i])) {
                        System.out.println("Student name :"+ name[i]);
                        String temp;
                        System.out.println();
                        System.out.print("Enter the new student name :");
                        temp = scan.nextLine();
                        name[i] = temp;
                        System.out.println();
                        System.out.println("student successfully updated.");
                        break;
                        }else{
                            System.out.println();
                        }
                    }

                System.out.print("Do you want to update another student details? (y/n)");
                String answer1 = scan.nextLine();
                System.out.println();

                if (answer1.equals("N") || answer1.equals("n")) {
                    break;
                }
                }

        }

    }

    public  static  void update_marks(String[] id,String[] name,int student_count,
                                      int[] programing_marks,int[] database_marks) {
        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t\t\t UPDATE MARKS                          ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        while(true){
            System.out.print("Enter student id: ");
            String student_id = scan.nextLine();

            boolean exists = false;
            for(int i=0;i<student_count;i++){
                if (student_id.equals(id[i])) {
                    exists = true;
                }
            }

            if (!exists) {
                System.out.print("invalid student id.Do you want to search again (y/n)");
                String choice = scan.nextLine();
                System.out.println();
                if(choice.equalsIgnoreCase("n")){
                    break;
                } else if (!choice.equalsIgnoreCase("y" ) ) {
                    break;
                }
            }else {
                for (int i = 0; i < student_count; i++) {
                    if (student_id.equals(id[i])) {
                        System.out.println("Student name :"+ name[i]);
                        System.out.println();

                        if (programing_marks[i] != 0 || database_marks[i] != 0) {
                            System.out.print("Programing Fundamentals marks : "+programing_marks[i]);
                            System.out.println();
                            System.out.print("database Fundamentals marks : "+database_marks[i]);

                            System.out.println();
                            System.out.println();
                            while(true){
                                System.out.print("Enter new Programing Fundamentals marks :");
                                int pMark = scan.nextInt();
                                scan.nextLine();
                                if (pMark < 0 || pMark > 100) {
                                    System.out.println("invalid marks.please enter correct marks.");

                                }else{
                                    programing_marks[i] = pMark;
                                    break;
                                }

                            }
                            while(true){
                                System.out.print("Enter new database Fundamentals marks :");
                                int dMark = scan.nextInt();
                                scan.nextLine();
                                if (dMark < 0 || dMark > 100) {
                                    System.out.println("invalid marks.please enter correct marks.");
                                    System.out.println();

                                }else{
                                    database_marks[i] = dMark;
                                    break;
                                }

                            }
                            System.out.println();
                            System.out.println("marks successfully updated.");


                        }else {
                            System.out.println("This student 's marks yet to be added.");
                        }
                    }
                }

                System.out.print("Do you want tho update marks for another student (y/n)");
                String answer1 = scan.nextLine();
                System.out.println();

                if (answer1.equals("N") || answer1.equals("n")) {
                    break;
                }
                
            }
        }
    }

    public static  int delete_student(String[] id,String[] name,int student_count,
                                      int[] programing_marks,int[] database_marks) {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t\t\t DELETE STUDENT                        ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        while(true){
            System.out.print("Enter student id: ");
            String student_id = scan.nextLine();

            boolean exists = false;
            for(int i=0;i<student_count;i++){
                if (student_id.equals(id[i])) {
                    exists = true;
                }
            }

            if (!exists) {
                System.out.print("invalid student id.Do you want to search again (y/n)");
                String choice = scan.nextLine();
                System.out.println();
                if(choice.equalsIgnoreCase("n")){
                    break;
                }
            }else {
                for (int i = 0; i < student_count; i++) {
                    if (student_id.equals(id[i])) {
                        id[i]= null;
                        name[i] = null;
                        database_marks[i]= 0;
                        programing_marks[i] = 0;
                        student_count--;
                        System.out.println("Student has been deleted successfully.");
                    }
                    
                }
                System.out.print("Do you want to delete another student? (y/n)");
                String answer1 = scan.nextLine();
                System.out.println();

                if (answer1.equals("N") || answer1.equals("n")) {
                    break;
                }
            }
        }
        return student_count;
    }

    public static  void print_student_details(String[] id,String[] name,int student_count,
                                              int[] programing_marks,
                                              int[] database_marks,
                                              int []total_marks,double []total_avg,int []rank) {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t\t\t PRINT STUDENT DETAILS                     ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");


        while(true){
            System.out.print("Enter student id: ");
            String student_id = scan.nextLine();

            boolean exists = false;
            for(int i=0;i<student_count;i++){
                if (student_id.equals(id[i])) {
                    exists = true;
                }
            }

            if (!exists) {
                System.out.print("invalid student id.Do you want to search again (y/n)");
                String choice = scan.nextLine();
                System.out.println();
                if(choice.equalsIgnoreCase("n")){
                    break;
                }
            }else {
                for (int i = 0; i < student_count; i++) {
                    if (student_id.equals(id[i])) {
                        System.out.println("Student name :"+ name[i]);

                        if(programing_marks[i] != 0 || database_marks[i] != 0) {

                            int total = programing_marks[i] + database_marks[i];
                            double average_marks = total / 2.0;
                            total_marks[i] = total;
                            total_avg[i] = average_marks;

                            for (int l = 0; l < student_count; l++) {
                                rank[l] = 1;
                                for (int j = 0; j < student_count; j++) {
                                    if (total_marks[j] > total_marks[i]) {
                                        rank[l]++;
                                    }
                                }
                            }


                            String position = "";
                            if (rank[i] == 1) {
                                position = "(First)";
                            } else if (rank[i] == 2) {
                                position = "(Second)";
                            } else if (rank[i] == 3) {
                                position = "(Third)";
                            } else if (rank[i] == student_count) {
                                position = "(Last)";
                            }
                            System.out.println("+-------------------------------------+----------------------------+");
                            System.out.println("| Programing Fundamentals marks       |   \t\t\t\t\t\t"+programing_marks[i]  +" |");
                            System.out.println("| database Management System marks    |   \t\t\t\t\t\t"+database_marks[i]  +" |");
                            System.out.println("| Total Marks                         |   \t\t\t\t\t    "+total        +" |");
                            System.out.println("| Avg. Marks                          |  \t\t\t\t\t  "+average_marks      +" |");
                            System.out.println("| Rank                                |   \t\t\t\t  "+rank[i] +position+" |");
                            System.out.println("+-------------------------------------+----------------------------+");
                            
                        }else {
                            System.out.println("This student 's marks yet to be added.");
                        }
                    }
                }

                System.out.print("Do you want to search another student? (y/n)");
                String answer1 = scan.nextLine();
                System.out.println();

                if (answer1.equals("N") || answer1.equals("n")) {
                    break;
                }

            }

        }
    }

    public static  void print_student_ranks(String[] id,String[] name,int student_count
            ,int []sorted_total,double []sorted_average,String []sorted_name,String []sorted_id,
                                            int[] programing_marks,int[] database_marks,int []all_total_marks,
                                            double []all_total_avg,int []rank) {

        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\t\t\tPRINT STUDENT'S RANKS                      ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        int total = 0;
        double avg = 0;

        for (int i = 0; i < student_count; i++) {
            total= programing_marks[i] + database_marks[i];
            avg = total/ 2.0;
            all_total_marks[i] = total;
            all_total_avg[i] = avg;
        }


        for(int i=0;i<student_count;i++){
            sorted_total[i] = all_total_marks[i];
            sorted_average[i] = all_total_avg[i];
            sorted_name[i] = name[i];
            sorted_id[i] = id[i];

        }
        for(int i=0; i< student_count-1; i++){
            for(int j=i+1; j< student_count; j++){
                if (sorted_total[i] < sorted_total[j]){

                    int temp = sorted_total[j];
                    sorted_total[j] = sorted_total[i];
                    sorted_total[i] = temp;

                    double temp1 = sorted_average[j];
                    sorted_average[j] = sorted_average[i];
                    sorted_average[i] = temp1;

                    String temp2 = sorted_name[j];
                    sorted_name[j] = sorted_name[i];
                    sorted_name[i] = temp2;

                    String temp3 = sorted_id[j];
                    sorted_id[j] = sorted_id[i];
                    sorted_id[i] = temp3;

                }
            }
        }
        int x=1;
        for(int i=0;i<student_count;i++){
            if (true){
                rank[i]= x;
                x++;
            }
        }

        System.out.println("+-------+------+---------------+--------------+------------+");
        System.out.println("| Rank  | ID   | Name          | Total Marks  | Avg. Marks |");
        System.out.println("+-------+------+---------------+--------------+------------+");

        for (int i = 0; i < student_count; i++) {
            if (sorted_total[i] != 0) {
                System.out.printf("| %-5d | %-4s | %-13s | %-12d | %-10.2f |\n",
                        rank[i], sorted_id[i], sorted_name[i],
                        sorted_total[i], sorted_average[i]);
            }
        }

        System.out.println("+-------+------+---------------+--------------+------------+");



    }

    public static  void programing(String[] id,String[] name,int student_count
            ,int []sorted_d,int []sorted_p,String []sorted_name,String []sorted_id,
                                   int[] programing_marks,int[] database_marks) {
        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\tBEST IN PROGRAMING FUNDAMENTALS                      ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        for(int i=0;i<student_count;i++){
            sorted_p[i] = programing_marks[i];
            sorted_d[i] = database_marks[i];
            sorted_name[i] = name[i];
            sorted_id[i] = id[i];

        }
        for(int i=0; i< student_count-1; i++){
            for(int j=i+1; j< student_count; j++){
                if (sorted_p[i] < sorted_p[j]){

                    int temp = sorted_p[j];
                    sorted_p[j] = sorted_p[i];
                    sorted_p[i] = temp;

                    int temp1 = sorted_d[j];
                    sorted_d[j] = sorted_d[i];
                    sorted_d[i] = temp1;


                    String temp2 = sorted_name[j];
                    sorted_name[j] = sorted_name[i];
                    sorted_name[i] = temp2;

                    String temp3 = sorted_id[j];
                    sorted_id[j] = sorted_id[i];
                    sorted_id[i] = temp3;

                }
            }
        }

        System.out.println("+------+---------------+--------------+------------+");
        System.out.println("| ID   | Name          | PF Marks     | DBMS Marks |");
        System.out.println("+------+---------------+--------------+------------+");

        for (int i = 0; i < student_count; i++) {
            if (sorted_p[i] != 0) {
                System.out.printf("| %-4s | %-14s | %-12d | %-10d |\n",
                        sorted_id[i], sorted_name[i], sorted_p[i], sorted_d[i]);
            }
        }
        System.out.println("+------+----------------+--------------+------------+");

    }

    public static  void database(String[] id,String[] name,int student_count
            ,int []sorted_d,int []sorted_p,String []sorted_name,
                                 String []sorted_id,int[] programing_marks,int[] database_marks) {
        System.out.println("------------------------------------------------------------------------");
        System.out.print("|");
        System.out.print("      \t\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM                      ");
        System.out.print("|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        for(int i=0;i<student_count;i++){
            sorted_p[i] = programing_marks[i];
            sorted_d[i] = database_marks[i];
            sorted_name[i] = name[i];
            sorted_id[i] = id[i];

        }
        for(int i=0; i< student_count-1; i++){
            for(int j=i+1; j< student_count; j++){
                if (sorted_p[i] < sorted_p[j]){

                    int temp = sorted_p[j];
                    sorted_p[j] = sorted_p[i];
                    sorted_p[i] = temp;

                    int temp1 = sorted_d[j];
                    sorted_d[j] = sorted_d[i];
                    sorted_d[i] = temp1;


                    String temp2 = sorted_name[j];
                    sorted_name[j] = sorted_name[i];
                    sorted_name[i] = temp2;

                    String temp3 = sorted_id[j];
                    sorted_id[j] = sorted_id[i];
                    sorted_id[i] = temp3;

                }
            }
        }

        System.out.println("+------+----------------+--------------+------------+");
        System.out.println("| ID   | Name           | DBMS Marks   | PF Marks   |");
        System.out.println("+------+----------------+--------------+------------+");

        for (int i = 0; i < student_count; i++) {
            if (sorted_p[i] != 0) {
                System.out.printf("| %-4s | %-14s | %-12d | %-10d |\n",
                        sorted_id[i], sorted_name[i], sorted_d[i], sorted_p[i]);
            }
        }
        System.out.println("+------+----------------+--------------+------------+");


    }
}





