/*
 * You will be creating an interactive chat-bot type program. Eliza is a therapist program
 * that interacts with the user. Your program will need to evaluate what the user asks and
 * turn the user's input into a question that sounds like the therapist really cares.
 *
 * Your first task is to develop a program with a running loop. If the user types in
 * "I am feeling great" or enter "Q", the program will stop running. Your program should
 * print out the last input (as an output) every time before accepting new input.
 * Make sure you are accommodating for NO case-sensitivity. (Q is the same as q)
 */


import java.util.Scanner;

public class Eliza {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);


        String msg = "";

        System.out.println("Good day. What is your problem?");
        boolean flag = true;

        while (flag) {
            System.out.println("Enter your response here or Q to quit:");
            msg = keyboard.nextLine();

            if ((msg.equalsIgnoreCase("I am feeling great")) ||
                (msg.equalsIgnoreCase("Q"))) {
                flag = false;
            }
            else
                System.out.println(msg);
        }

        System.out.println("Good bye.");
    }
}
