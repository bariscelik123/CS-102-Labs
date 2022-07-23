import java.util.*;

import java.util.Scanner;

public class ExamApplication {

    public static void main(String[] args) {
        Exam exam = new Exam();
        run(exam);
         
    }

    public static void run(Exam e) {
        String choice ="";
        Scanner in = new Scanner (System.in);

        while(!choice.equals("4")) {
            System.out.println("1-Take the exam.");
            System.out.println("2-Grade the exam.");
            System.out.println("3-Display mistakes.");
            System.out.println("4-Quit");
            
            System.out.print("Enter your selection: ");
            choice = in.nextLine();

            if (choice.equals("1")) {
                e.takeExam();
            }

            else if (choice.equals("2")) {
                e.gradeExam();
            }

            else if (choice.equals("3")) {
            e.displayMistakes();

             }
             else if (choice.equals("4")) {
              System.out.println("Quitting...");
          }
    }
}
}

    
    
