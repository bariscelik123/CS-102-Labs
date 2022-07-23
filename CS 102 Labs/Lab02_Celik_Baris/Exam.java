import java.util.ArrayList;
import java.util.Scanner;

public class Exam {

    private ArrayList<Question> exam = new ArrayList<Question>();
    private boolean completed;
    private Question q1,q2,q3,q4,q5,q6,q7,q8,q9;

    public Exam() {
        this.completed = false;

        q1 = new Question("An array the same as an ArrayList (true/false)", "false");
        q2 = new Question("Strings are immutable? (true/false)","true");
        q3 = new Question("You must use the new keyword to create a String object (true/false)","false");
        q4 = new Question( "What kind of inheritance is not allowed in java (one word)","multiple");
        q5 = new Question("Does a subclass inherit both member variables and methods?(Yes/No)","multiple");
        q6 = new MultipleChoice("A class Animal has a subclass Mammal. Which of the following is true: ","b","a.Because of single inheritance, Mammal can have no subclasses.\nb.Because of single inheritance, Mammal can have no other parent than Animal.\nc.Because of single inheritance, Animal can have only one subclass.");
        q7 = new MultipleChoice("What does immutable mean?","b","a)A String is an instance of an object.\nb)Once created the object's data cannot be changed\nc)String class objects can be used in any application");
        String arr[] = {"variable","class","object"};
        q8 = new ShortAnswer("What is a static data member?","A variable that belong to the class and not the object",arr);
        String arr2[] = {"create","initialize","object"};
        q9 = new ShortAnswer("What is the purpose of a constructor?","To create objects and initialize their data",arr2);
    
    
    exam.add(q1);
    exam.add(q2);
    exam.add(q3);
    exam.add(q4);
    exam.add(q5);
    exam.add(q6);
    exam.add(q7);
    exam.add(q8);
    exam.add(q9);
    }

    public void takeExam() {
        Scanner in = new Scanner (System.in);

        for(int k = 0; k < exam.size(); k++) {
            System.out.println(exam.get(k).displayQuestion());
            System.out.println("Answer is: ");
            exam.get(k).setStudentAnswer(in.nextLine());
            exam.get(k).setScore();
            System.out.println("Answer: " + exam.get(k).isAnswerCorrect());
        }

        this.completed = true;
          
    }
    
    public void gradeExam() {

        int score = 0;

        if (this.completed) {

            for ( Question cur : exam) {
                score = score + cur.getScore();
            }

            System.out.println("Your score is " + score);
        }
        
        else  {
            System.out.println("Can't show. The exam is not completed.");
        }



    }

    public void displayMistakes() {

        if (this.completed) {
            for ( int i = 0; i < exam.size(); i++) {
                if (exam.get(i).isAnswerCorrect()) {
                    System.out.println(exam.get(i).toString());
                }
            }
        }
        else {
            System.out.println("Can't show. The exam is not completed.");
        }

   

    }
}
