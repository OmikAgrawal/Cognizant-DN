import java.util.Scanner;;

public class HelloWorld {

    // METHOD OVERLOADING

    // Version 1: Accepts two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Version 2: Accepts two doubles (Overloaded by changing parameter types)
    public static double add(double a, double b) {
        return a + b;
    }

    // Version 3: Accepts three integers (Overloaded by changing the number of
    // parameters)
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static int fibonacci(int n) {
        // Base Case 1: If n is 0, the 0th Fibonacci number is 0
        if (n == 0) {
            return 0;
        }
        // Base Case 2: If n is 1, the 1st Fibonacci number is 1
        if (n == 1) {
            return 1;
        }

        // Recursive Step: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Type num1 :");
        // int num1 = sc.nextInt();
        // System.out.print("Type num2 :");
        // int num2 = sc.nextInt();
        // System.out.print("Select [+,-,*,/] :");
        // String operator = sc.next();
        // int result = 0;

        // switch (operator) {
        //     case "/":
        //         result = num1 / num2;
        //         break;
        //     case "*":
        //         result = num1 * num2;
        //         break;
        //     case "+":
        //         result = num1 + num2;
        //         break;
        //     case "-":
        //         result = num1 - num2;
        //         break;

        //     default:
        //         System.out.println("Invalid Opeator");
        //         break;
        // }
        
        // System.out.println("Result :" + result);
        // sc.close();


        // System.out.print("Enter an integer: ");
        // int number = sc.nextInt();
        
        // // 2 & 3. Use the modulus operator to check divisibility and display the result
        // if (number % 2 == 0) {
        //     System.out.println(number + " is an Even number.");
        // } else {
        //     System.out.println(number + " is an Odd number.");
        // }
        
        // sc.close();

        // Scanner sc = new Scanner(System.in);

        // // 1. Prompt the user to enter a year
        // System.out.print("Enter a year: ");
        // int year = sc.nextInt();

        // // 2. Check the leap year rules using logical operators
        // // Rule: Divisible by 4 AND (NOT divisible by 100 OR divisible by 400)
        // if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        //     System.out.println(year + " is a leap year.");
        // } else {
        //     System.out.println(year + " is NOT a leap year.");
        // }

        // sc.close();

        Scanner sc = new Scanner(System.in);

        // 1. Prompt the user for a number [cite: 34, 36]
        System.out.print("Enter a number to print its multiplication table: ");
        int num = sc.nextInt();

        System.out.println("Multiplication Table for " + num + ":");

        // 2. Use a for loop to iterate from 1 to 10 [cite: 37]
        for (int i = 1; i <= 10; i++) {
            // 3. Multiply the input number by the loop counter and display the result
            // [cite: 38]
            System.out.printf("%d x %d = %d\n", num, i, (num * i));
        }

        sc.close();


        //PRIMITIVE DATA TYPE
    
        // 1 & 2. Declare variables with appropriate primitive types and assign values
        int integerVar = 105; // Whole number 
        float floatVar = 5.75f; // Single-precision decimal (requires 'f') 
        double doubleVar = 19.99; // Double-precision decimal 
        char charVar = 'A'; // Single character enclosed in single quotes 
        boolean booleanVar = true; // Conditional boolean flag 

        // 3. Display each variable using System.out.println() 
        System.out.println("Integer Value: " + integerVar);
        System.out.println("Float Value: " + floatVar);
        System.out.println("Double Value: " + doubleVar);
        System.out.println("Character Value: " + charVar);
        System.out.println("Boolean Value: " + booleanVar);


        //TYPE CASTING 

        // 1. Declare a double variable with a decimal value
        double originalDouble = 9.78;
        System.out.println("Original double value: " + originalDouble);

        // 2. Cast it to an int (Narrowing / Explicit Casting) and display the result
        // This will truncate the fractional part (.78) completely
        int castedInt = (int) originalDouble;
        System.out.println("Casted int value (after truncation): " + castedInt);

        System.out.println("------------------------------------");

        // 3. Declare an int variable
        int originalInt = 25;
        System.out.println("Original int value: " + originalInt);

        // Cast it to a double (Widening / Implicit Casting) and display it
        // Java does this automatically behind the scenes
        double castedDouble = originalInt;
        System.out.println("Casted double value (automatic): " + castedDouble);



        //OPERATION 
       
        // 1. Write expressions combining multiple operators [cite: 56, 58]
        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 100 / 5 * 2;

        // 2. Display the result and explain the order of operations [cite: 59]
        System.out.println("Expression 1: 10 + 5 * 2");
        System.out.println("Result: " + result1);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+). "
                         + "Therefore, 5 * 2 is evaluated first (10), then 10 + 10 is evaluated.\n");

        System.out.println("Expression 2: (10 + 5) * 2");
        System.out.println("Result: " + result2);
        System.out.println("Explanation: Parentheses () have the highest precedence. "
                         + "Therefore, 10 + 5 is evaluated first (15), then 15 * 2 is evaluated.\n");

        System.out.println("Expression 3: 100 / 5 * 2");
        System.out.println("Result: " + result3);
        System.out.println("Explanation: Division (/) and Multiplication (*) have the same precedence. "
                + "They evaluate from Left-to-Right (associativity). Therefore, 100 / 5 is done first (20), then 20 * 2.");
                         



        Scanner sc = new Scanner(System.in);

        // 1. Prompt the user for marks out of 100
        System.out.print("Enter your marks (0-100): ");
        int marks = sc.nextInt();

        String grade;

        // Validation to ensure input falls into a realistic range
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid entry! Marks must be between 0 and 100.");
            sc.close();
            return;
        }

        // 2. Use an efficient if-else-if ladder to check overlapping ranges
        if (marks >= 90) {
            grade = "A"; // Range: 90-100
        } else if (marks >= 80) {
            grade = "B"; // Range: 80-89 (implicitly less than 90)
        } else if (marks >= 70) {
            grade = "C"; // Range: 70-79 (implicitly less than 80)
        } else if (marks >= 60) {
            grade = "D"; // Range: 60-69 (implicitly less than 70)
        } else {
            grade = "F"; // Range: Below 60
        }

        // 3. Display the assigned grade
        System.out.println("Assigned Grade: " + grade);

        sc.close();



        //RANDOM FUNCTION

        Scanner sc = new Scanner(System.in);

        // 1. Generate a random number between 1 and 100
        int randomNumber = (int) (Math.random() * 100) + 1;
        int userGuess;
        int attempts = 0;

        System.out.println("--- Welcome to the Number Guessing Game! ---");
        System.out.println("I have selected a random number between 1 and 100. Try to guess it!");

        // 4. Continue looping using a do-while loop until the user guesses correctly
        do {
            // 2. Prompt the user to guess the number
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            attempts++;

            // 3. Provide feedback if the guess is too high, too low, or correct
            if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("\nCongratulations! You've guessed the correct number.");
                System.out.println("Total attempts: " + attempts);
            }

        } while (userGuess != randomNumber);

        sc.close();

        

        //FACTORIAL 

        Scanner sc = new Scanner(System.in);

        // 1. Prompt the user for a non-negative integer
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();

        // Validation for negative inputs
        if (n < 0) {
            System.out.println("Invalid input! Factorial is not defined for negative numbers.");
            sc.close();
            return;
        }

        // 2. Use a long accumulator variable initialized to 1
        long factorial = 1;

        // Use a for loop to calculate the factorial
        for (int i = 1; i <= n; i++) {
            factorial *= i; // Multiplies accumulator by the current loop counter
        }

        // 3. Display the final result
        System.out.println("The factorial of " + n + " (" + n + "!) is: " + factorial);

        sc.close();



        // 3. Call each method and display the results
        int sumOfTwoInts = add(10, 20);
        double sumOfTwoDoubles = add(5.5, 4.5);
        int sumOfThreeInts = add(5, 10, 15);

        System.out.println("Result of add(int, int): " + sumOfTwoInts);
        System.out.println("Result of add(double, double): " + sumOfTwoDoubles);
        System.out.println("Result of add(int, int, int): " + sumOfThreeInts);



        //RECURSION - FIBONACCI 

       
        Scanner sc = new Scanner(System.in);

        // 1. Prompt the user for a positive integer n
        System.out.print("Enter a positive integer position (n): ");
        int n = sc.nextInt();

        // Validation for negative inputs
        if (n < 0) {
            System.out.println("Invalid input! Position must be a non-negative integer.");
            sc.close();
            return;
        }

        // 3. Display the result
        int result = fibonacci(n);
        System.out.println("The Fibonacci number at position " + n + " is: " + result);

        sc.close();

        

    }

  }
