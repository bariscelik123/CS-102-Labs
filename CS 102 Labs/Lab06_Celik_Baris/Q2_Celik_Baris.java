import java.util.ArrayList;
import java.util.Scanner;

public class Q2_Celik_Baris {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Month number:");
        int numberOfMonths = in.nextInt();

        ArrayList<Integer> salary = new ArrayList<Integer>();

        for(int i = 0; i < numberOfMonths; i++) {
            System.out.print("\nSalary of the month " + (i + 1) + ": ");
            salary.add(in.nextInt());
        }

        System.out.print("months later: ");
        int monthsLater = in.nextInt();

        System.out.println("Salary: " + SalaryofLastMonth(salary, monthsLater));


    }
        public static int SalaryofLastMonth(ArrayList<Integer> salary, int monthsLater) {

            int salaryy = 0;

            if(monthsLater == 0) {
                return salary.get(salary.size()-1);
            }

            else if (monthsLater == 1) {
                for (int x: salary) {
                    salaryy += x;
                }
                return salaryy;
            }

            for(int x: salary) {
                salaryy += x;
            }

            salary.add(salaryy);

            return SalaryofLastMonth(salary, monthsLater - 1);
        }
    
}
