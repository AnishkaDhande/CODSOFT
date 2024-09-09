import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfSubjects;

        // to get the number of subjects
        System.out.print("Enter the number of subjects: ");
        numOfSubjects = scanner.nextInt();

        int[] marks = new int[numOfSubjects];
        int totalMarks = 0;

        // input marks for each subject
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i]; // Sum up the marks
        }

        // to calculate the average percentage
        double avgPercentage = (double) totalMarks / numOfSubjects;

        // to determine the grade based on the average percentage
        char grade;
        if (avgPercentage >= 90) {
            grade = 'A';
        } else if (avgPercentage >= 80) {
            grade = 'B';
        } else if (avgPercentage >= 70) {
            grade = 'C';
        } else if (avgPercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // to display the results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", avgPercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
