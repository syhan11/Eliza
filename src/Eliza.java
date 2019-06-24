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


import java.util.ArrayList;
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
    private static String[] Vowels = {"a", "e", "i", "o", "u"};

    private static ArrayList<String> Messages = new ArrayList<String>();



    public static void main(String[] args) {
         Scanner keyboard = new Scanner(System.in);
         boolean usingLatin = false;

        /*
         * initialize replaceMap
         */
        ReplaceMap = new HashMap<String, String>();
        ReplaceMap.put("i", "you");
        ReplaceMap.put("me", "you");
        ReplaceMap.put("my", "your");
        ReplaceMap.put("am", "are");

        Random random = new Random();
        String msg = "", reply = "", tmp = "";

        logMessage("Good day. What is your problem?", true, true);

        boolean flag = true;
        int idx;

        while (flag) {
            logMessage("Enter your response here or Q to quit:", true, true);

            msg = keyboard.nextLine();
            logMessage(msg, false, false);

            if ((msg.contains("pig")) && (!usingLatin) {

                pigLatin();
                usingLatin = !usingLatin;
            }
            else {

                if ((msg.equalsIgnoreCase("I am feeling great")) ||
                        (msg.equalsIgnoreCase("Q"))) {
                    flag = false;
                } else {
                    if (random.nextBoolean()) {
                        // use QualifiersArray
                        idx = random.nextInt(QualifiersArray.length);
                        reply = convert2Reply(msg);
                        tmp = QualifiersArray[idx] + " " + reply;
                    } else {
                        // use HedgesArray
                        idx = random.nextInt(HedgesArray.length);
                        tmp = HedgesArray[idx];
                    }

                    logMessage(tmp, true, true);
                }
            }

        }

        logMessage("Good bye.", true, true);

        printMessage();
    }

    /*
     * If you type "pig" Eliza should begin speaking in pig latin
     * Pig Latin Rules:
     * If the first letter is a consonant, add "ay" to the end
     * If the first letter is a vowel, add "way" or "tay" to the end
     * Don't worry about the "multiple-letters-that-sounds-like one" rule
     * (eg. str-, ch-, th-, etc.)
     */

    public static void pigLatin(Scanner keyboard) {
        System.out.println("PigLatin");



    }

    public static void pigLatin() {
        System.out.println("PigLatin without parm");



    }

    public static void logMessage(String varMsg, boolean varPrint, boolean varSystem) {

        if (varPrint)
            System.out.println(varMsg);

        if (varSystem)
            Messages.add("System:\t" + varMsg);
        else
            Messages.add("User:\t" + varMsg);
    }

    public static void printMessage() {
        System.out.println("\n***** Log:");
        for (String item : Messages)
            System.out.println(item);
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
