import java.util.Scanner;

public class adil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks for 5 subjects:");

        int totalMarks = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double avg = (double) totalMarks / 5;
        String grade = Grade(avg);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static String Grade(double avg) {
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

