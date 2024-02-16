import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Interaction with the user using Scanner class
    Scanner sc = new Scanner(System.in);

    boolean exitCode = false;

    System.out.println("Hi, welcome to use the GradeCalculator. Let's calculate your final weighted grade");
    System.out.println("Please input the number of assignments (Please input Integer amount eg. 5)");
    int capacity = sc.nextInt();
    ExtendWeightedGrade gradeCalculator = new ExtendWeightedGrade(capacity);
    int size = 0;

    while (!exitCode) {
      // input grades earned of each assignment in the class and their Point Total and perventage
      while (size < capacity) {
        System.out.print("Please input the assignment " + (size + 1) + "'s Earned Points for the assignment (Please input Integer amount eg. 16):");
        int earnedPoint = sc.nextInt();
        System.out.print("Please input the assignment " + (size + 1) + "'s Point Total (Please input Integer amount eg. 20): ");
        int totalPoint = sc.nextInt();
        System.out.print("Please input the assignment " + (size + 1) + "'s Percentage (Please input Integer amount eg. 10): ");
        int assignmentPercent = sc.nextInt();
        size++;
        gradeCalculator.addAssignment(size, earnedPoint, totalPoint, assignmentPercent);
      }

      System.out.println("Please pick an option: input a to get an assignment's data / input b to edit an assignment");
      String input = sc.next();
      if (input.equals("a")) {
        System.out.println("Which assignment information do you want to view ?(First assignment = 1 etc.)");
        int index = sc.nextInt();
        int[] assignment = gradeCalculator.getAssignment(index);
        System.out.println("The " + index + "assignment's earnedPoint is " + assignment[0]);
        System.out.println("The " + index + "assignment's totalPoint is " + assignment[1]);
        System.out.println("The " + index + "assignment's weight is " + assignment[2]);
        System.out.println("Please pick an option: input c to menu / input e to get letter grade based");
        input = sc.next();
      }
      
      if (input.equals("b")) {
        System.out.println("Which assignment information do you want to edit ?(First assignment = 1 etc.)");
        int index = sc.nextInt();
        System.out.print("Please input the assignment " + (index) + "'s Earned Points for the assignment (Please input Integer amount eg. 16):");
        int earnedPoint = sc.nextInt();
        System.out.print("Please input the assignment " + (index) + "'s Point Total (Please input Integer amount eg. 20): ");
        int totalPoint = sc.nextInt();
        System.out.print("Please input the assignment " + (index) + "'s Percentage (Please input Integer amount eg. 10): ");
        int assignmentPercent = sc.nextInt();
        gradeCalculator.editAssignment(index, earnedPoint, totalPoint, assignmentPercent);
        System.out.println("Please pick an option: input c to menu / input e to get letter grade based");
        input = sc.next();
      }

      if (input.equals("e")) {
        exitCode = true;
      }
    }
    
    // put all calculated grade together
    double finalGrade = gradeCalculator.getFinalWeightedGrade();
    if (finalGrade < 0) {
      System.out.println("the weights does not add up to 100");
    }
    String res = "";
    // output a letter grade based on the total
    if (finalGrade >= 90) {
      res = "A";
    } else if (finalGrade >= 80 && finalGrade < 90) {
      res = "B";
    } else if (finalGrade >= 70 && finalGrade < 80) {
      res = "C";
    } else if (finalGrade >= 60 && finalGrade < 70) {
      res = "D";
    } else {
      res = "F";
    }

    System.out.print("Your final grade is " + res);
    sc.close();
  }
}

