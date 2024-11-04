import java.util.ArrayList;
import java.util.Scanner;

public class Java_Lab2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //1.Write a program to find all of the longest word in a given dictionary
        String[] dictionary = {"cat", "dog", "red", "is", "am"};
        String longestWord = dictionary[0];
        for (String word : dictionary) {
            if (word.length() >= longestWord.length()) {
                longestWord = word;
                System.out.print(longestWord + " ");
            }
        }
        System.out.println();

        System.out.println("************************");

        //2. Write a program that displays the number of occurrences
        // of an element in the array.
        int[] repeatedArray = {1, 1, 1, 3, 3, 5};
        int counter; // to check how many times a number got repeated
        for (int i = 0; i < repeatedArray.length; i++) {
            // flag to check if a number in the array has been checked before or not
            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++)
                if (repeatedArray[i] == repeatedArray[k]) {
                    alreadyCounted = true;
                    break; // to not check the rest
                }
            if (!alreadyCounted) {
                counter = 0; // to reset the counter
                for (int j = 0; j < repeatedArray.length; j++)
                    if (repeatedArray[i] == repeatedArray[j])
                        counter++;
                System.out.println("number " + repeatedArray[i] + " occurred " + counter + " times ");
            }
        }

        System.out.println("************************");

        //3.Write a program to find the k largest elements in a given array.
        // Elements in the array can be in any order.
        int[] theFullArray = {1, 4, 17, 7, 25, 3, 100};
        // sort the array first:
        //int temp;
        for (int i = 0; i < theFullArray.length; i++) {
            for (int j = i + 1; j < theFullArray.length; j++) {
                if (theFullArray[i] < theFullArray[j]) {
                    int temp = theFullArray[i];
                    theFullArray[i] = theFullArray[j];
                    theFullArray[j] = temp;
                }
            }
        }
        int k = 3;
        System.out.println("The 3 largest Elements In The Array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(theFullArray[i] + " ");
        }
        System.out.println();

        System.out.println("************************");

        //4. Create a method to reverse an array of integers.
        // Implement the method without creating a new array.
        int[] originalArray = {5, 4, 3, 2, 1};
        System.out.println("Original Array: ");
        for (int i = 0; i < originalArray.length; i++) {
            System.out.print(originalArray[i] + " ");
        }
        System.out.println();
        System.out.println("Reversed Array: ");
        reverseArray(originalArray);
        System.out.println();

        System.out.println("************************");

        // 5. Write a menu driven Java program with following option:
        System.out.println("Please, Enter the size of the array: ");
        int arraySize = input.nextInt(); // the size of the array
        int[] menuArray = new int[arraySize]; // the array itself
        int menuOption; // the choice of the user in menu
        do {
            System.out.println("Select your option from the menu: \n" +
                    "1. Accept elements of an array\n" +
                    "2. Display elements of an array\n" +
                    "3. Search the element within array\n" +
                    "4. Sort the array \n" +
                    "5. To Quit the menu \n");
            menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.println("Enter Array Elements: ");
                    for (int i = 0; i < menuArray.length; i++) {
                        menuArray[i] = input.nextInt(); // add the entered element to the array
                    }
                    break;
                case 2:
                    System.out.println("The Array: ");
                    for (int number : menuArray) {
                        System.out.print(number + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter a number to find if its in the array: ");
                    int searchElement = input.nextInt();
                    boolean elementExist = false;
                    for (int element : menuArray) {
                        if (element == searchElement) {
                            elementExist = true;
                            break;
                        }
                    }
                    if (elementExist)
                        System.out.println("Number " + searchElement + " is inside the array ");
                    else
                        System.out.println("Number " + searchElement + " is not inside the array ");
                    break;
                case 4:
                    System.out.println("The sorted array: ");
                    for (int i = 0; i < menuArray.length; i++) {
                        for (int j = i; j < menuArray.length; j++) {
                            int temp = 0;
                            if (menuArray[i] > menuArray[j]) {
                                temp = menuArray[i];
                                menuArray[i] = menuArray[j];
                                menuArray[j] = temp;
                            }
                        }
                        System.out.print(menuArray[i] + " ");
                    }
                    System.out.println();
                    break;
            }
        } while (menuOption != 5);

        System.out.println("************************");

        //6. Create a method that generates a random number within a given range. Allow the user to
        //specify the range and call the method to display random numbers.
        System.out.println("Enter the minimum value of the range: ");
        int minimumValue = input.nextInt();
        System.out.println("Enter the maximum value of the range: ");
        int maximumValue = input.nextInt();
        System.out.println("Enter the number of random numbers to generate: ");
        int numberOfRandomNumbers = input.nextInt();
        randomNumber(minimumValue, maximumValue, numberOfRandomNumbers);
        System.out.println();
        input.nextLine();

        System.out.println("************************");

        //7. Write a program that checks the strength of a password. Create a method that evaluates a
        //password based on criteria like length, inclusion of special characters, and
        //uppercase/lowercase letters.
        System.out.println("Enter a password: ");
        String password = input.nextLine();
        //Classify the password as strong (8 or more), moderately strong (5 or more), or weak
        //based on the totalScore.
        int totalScore = checkLength(password) + checkSpecialCharacters(password) + checkUpperCaseLowerCase(password);
        if (totalScore >= 8)
            System.out.println("Password is strong");
        else if (totalScore >= 5)
            System.out.println("Password is moderately strong");
        else
            System.out.println("Password is weak");

        System.out.println("************************");

        //8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
        System.out.println("Enter a number to generate fibonacci sequence: ");
        int number = input.nextInt();
        System.out.println("The Fibonacci sequence: ");
        fibonacci(number);

    } // end main

    public static void reverseArray(int[] array1) {
        for (int i = array1.length - 1; i >= 0; i--) {
            System.out.print(array1[i] + " ");
        }
    }

    public static void randomNumber(int minValue, int maxValue, int numberOfValues) {
        int randomNumber = 0;
        for (int i = 0; i < numberOfValues; i++) {
            randomNumber = (int) ((Math.random() * (maxValue - minValue)) + minValue);
            if (i > 0) // condition just to NOT print - after the last number
                System.out.print(" - "); // to print - BEFORE the numbers, therefore skips the first index
            System.out.print(randomNumber);
        }
    }

    public static int checkLength(String password) {
        //Length: 0-5 characters (0 points), 6-7 characters (2 points),
        // 8 or more characters (3 points).
        int score = 0;
        if (password.length() >= 8)
            score += 3;
        else if ((password.length() == 7) || (password.length() == 6))
            score += 2;
        else
            return score;
        return score;
    }

    public static int checkSpecialCharacters(String password) {
        //Special characters: Absence (0 points), Presence (2 points).
        int score = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                score += 2;
                break;
            }
        }
        return score;
    }

    public static int checkUpperCaseLowerCase(String password) {
        //Uppercase and lowercase letters: Absence of both (0 points),
        // presence of both (3 points).
        int score = 0;
        boolean upperCaseFlag = false;
        boolean loweCaseFlag = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                upperCaseFlag = true;
            if (Character.isLowerCase(password.charAt(i)))
                loweCaseFlag = true;
        }
        if (upperCaseFlag && loweCaseFlag)
            score += 3;
        return score;
    }

    public static void fibonacci(int number) {
        int[] fibonacciList = new int[number];
        fibonacciList[0] = 0;
        fibonacciList[1] = 1;
        System.out.print(fibonacciList[0] + " " + fibonacciList[1] + " ");
        // i = 2 because I had logic error when i = 0 because the before indices will be minus
        for (int i = 2; i < fibonacciList.length; i++) {
            fibonacciList[i] = fibonacciList[i - 2] + fibonacciList[i - 1];
            System.out.print(fibonacciList[i] + " ");
        }
    }

}
