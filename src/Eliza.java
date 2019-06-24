/*
 * You will be creating an interactive chat-bot type program. Eliza is a therapist program
 * that interacts with the user. Your program will need to evaluate what the user asks and
 * turn the user's input into a question that sounds like the therapist really cares.
 *
 * Your first task is to develop a program with a running loop. If the user types in
 * "I am feeling great" or enter "Q", the program will stop running. Your program should
 * print out the last input (as an output) every time before accepting new input.
 * Make sure you are accommodating for NO case-sensitivity. (Q is the same as q)
 *
 * Use HashMaps or String arrays to loop through user's input and implement the following:
 * Replacements:
 * replace i with you
 * replace me with you
 * replace my with your
 * replace am with are
 *
 */


import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
    private static final String NULL = "";
    private static HashMap<String, String> ReplaceMap;
    private static String[] HedgesArray = {"Please tell me more",
                                           "Many of my patients tell me the same thing",
                                           "It is getting late, maybe we had better quit"};
    private static String[] QualifiersArray = {"Why do you say that",
                                               "You seem to think that",
                                               "So, you are concerned that"};


    public static void main(String[] args) {
        Random random = new Random();

        Scanner keyboard = new Scanner(System.in);

        /*
         * initialize replaceMap
         */
        ReplaceMap = new HashMap<String, String>();
        ReplaceMap.put("i", "you");
        ReplaceMap.put("me", "you");
        ReplaceMap.put("my", "your");
        ReplaceMap.put("am", "are");

        String msg = "", reply = "";

        System.out.println("Good day. What is your problem?");
        boolean flag = true;
        int idx;

        while (flag) {
            System.out.println("Enter your response here or Q to quit:");
            msg = keyboard.nextLine();

            if ((msg.equalsIgnoreCase("I am feeling great")) ||
                (msg.equalsIgnoreCase("Q"))) {
                flag = false;
            }
            else {
                if (random.nextBoolean()) {
                    // use QualifiersArray
                    idx = random.nextInt(QualifiersArray.length);
                    reply = convert2Reply(msg);
                    System.out.println(QualifiersArray[idx] + " " + reply);
                }
                else {
                    // use HedgesArray
                    idx = random.nextInt (HedgesArray.length);
                    System.out.println(HedgesArray[idx]);
                }
            }

        }

        System.out.println("Good bye.");
    }

    public static String convert2Reply(String userMsg) {
        String msg = "";

        for (String token : userMsg.split(" ")) {
            if (ReplaceMap.containsKey(token)) {
                // should replace
                msg = msg + ReplaceMap.get(token) + " ";
            }
            else {
                // should not replace
                msg = msg + token + " ";
            }

        }


        return (msg);
    }
}
