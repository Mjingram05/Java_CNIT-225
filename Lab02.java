/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab02;

/**
 *
 * @author MjING
 */
import java.util.Scanner;
public class Lab02
{
    public static final String START_STRING = "abc def";


    public static void printHelp(String errorMessage)
    {
        System.err.println(errorMessage);
        System.err.println("Usage - enter one of the following Commands:");
        System.err.println();
        System.err.println("SearchText [text]: prints the idex of the text in"
                            + "The String, leaves it unchanged");
        System.err.println("removeText [text] - deletes all occurences of"
                            + "[text] in the String");
        System.err.println("addText [text] - first arguement is an integer"
                            + "Between 0 and the length of the string; "
                            + "adds [text] at the location of the string.");
        System.err.println("reverseText [noaruguement] - Make the String into "
                            + "A mirror image");
        System.err.println("ReverseEachWord [noarguement] - like reverseText"
                            + "but applies to each command word induvidually.");
        System.err.println("printString [noarguements] - prints current string");
        System.err.println("enterNewString [text] - overwrites whatever the "
                            + "string was with the [text] instead");
        System.err.println("quit [no arguement] - exits the program.");

        System.err.println("");
    }




    public static String printString(String oldString, String[] commandwords)
    {
        System.out.println(oldString);
        return oldString;
    }

    private static String combineWordsFrom(String [] words, int index)
    {
        String newString = "";
        for(int i = index; i < words.length; i+=1)
        {
            if(i>index)
            {
                newString += " ";
            }
            newString += words[i];
        }
        return newString;
    }

    public static String searchText (String oldString, String[] commandWords)
    {
        if (commandWords.length < 2)
        {
            printHelp("error search Text");
            return null;
        }
        String findString = combineWordsFrom(commandWords,1);
        System.out.println(oldString.indexOf(findString));
        return null;
    }
    public static String removeText(String oldString, String[] commandWords)
    {
    // TODO: You should remove from "oldString" all instances of the text found in "commandWords" starting from index 1 to the end of the string array
    // 1. First check if the length of commandWords is less than 2. If it is, then print an error using printHelp and return null.
    // 2. Get the text you need to remove from oldString. Use combineWordsFrom(commandWords,1) to get the appropriate text.
    // 3. Remove the text from oldString using the String function replaceAll.
    // 4. Return the String that is returned from the replaceAll function.
        if (commandWords.length < 2)
        {
            printHelp("removeText - Require arguement");
            return null;
        }
        String delString = combineWordsFrom(commandWords,1);
        return oldString.replaceAll(delString, "");
    }
    
    public static String addText(String oldString, String[] commandWords)
    {
    // TODO: You should add text to "oldString" at a specific index
    // 1. First check if the length of commandWords is less than 3. If it is, then print an error using printHelp and return null.
    // 2. Get the text you need to add to oldString. Use combineWordsFrom(commandWords,2) to get the appropriate text.
    // 3. Get the index using "Integer.parseInt(commandWords[1])".
    // 4. Check if the index is in the correct range (greater than 0, and less than or equal to oldString’s length). If not, print an error usingprintHelp and return null.
    // 5. Return oldString.substring(parameters) + text + oldString.substring(parameters) using the correct parameters for substring.
        if (commandWords.length < 3)
        {
            printHelp("error addText");
            return null;
        }
        String addString = combineWordsFrom(commandWords,2);
        int index = Integer.parseInt(commandWords[1]);
        if (index < 0 || index > oldString.length())
        {
            printHelp("addText - Invalid index (must be int between 0 and string length): " + index);
            return null;
        }
        return oldString.substring(0, index) + addString + oldString.substring(index);
    }

    private static String reverseString(String s)
    {
        // TODO: Make the utility function reverseString which reverses a single string
        // 1. Create a new StringBuilder object, and initialize it with "s"
        // 2. Call reverse() on the StringBuilder object, then toString()
        // 3. Return the resulting String from step 2
        // Note: An alternative way of doing this is to traverse the string in reverse using a for loop and the function charAt, and to build the string in reverse character by character 
        //Reverse = new s;
        //this.oldString = oldString.reverse();
        //return reverseString();
        return new StringBuilder (s).reverse().toString();
        
    }
    public static String reverseText(String oldString, String[] commandWords)
    {
        // This function is already completed, as long as reverseString is correctly implemented.
        // Note: It was a design choice to not error out if arguments were erroneouslyincluded.
        return reverseString(oldString);   
    }
    public static String reverseEachWord(String oldString, String[] commandWords)
    {
    // TODO: Reverse each individual word in oldString using the reverseString function which you filled in
    // 1. Call split(" ") on oldString (split up the string on space), and store the result in a String array
    // 2. Create a new empty string called result (i.e., String result = "")
    // 3. Create a for loop and iterate over each element of the String array from step 1
    // 4. Within the loop, if the index is greater than 0, add a blank space to result (i.e., result += " ")
    // 5. Within the loop, add the reversed version of the array String to result (i.e., result += reverseString(array[i]))
    // 6. Return result
    // Note: It was a design choice to not error out if arguments were erroneously included.
    String[] splitString = oldString.split(" ");
    String results = "";
    for (int i = 0; i < splitString.length; i++){
         if (i > 0){
        results += " ";
        }
   
        results += reverseString(splitString[i]);
        }
        return results;
        }


    public static String enterNewString(String oldString, String[] commandWords)
    {
        // This command needs an argument after the command; if it’s missing
        // that’s an error.
        if (commandWords.length < 2)
        {
            printHelp("enterNewString - requires an argument");
            return null;
        }
        else
        return combineWordsFrom(commandWords, 1);
    }
    public static String handleStringCommand(String oldString, String[] commandWords)
    {
        if ("searchText".equals(commandWords[0]))
        {
        return searchText(oldString, commandWords);
        }
        else if ("removeText".equals(commandWords[0]))
        {
        return removeText(oldString, commandWords);
        }
        else if ("addText".equals(commandWords[0]))
        {
        return addText(oldString, commandWords);
        }
        else if ("reverseText".equals(commandWords[0]))
        {
        return reverseText(oldString, commandWords);
        }
        else if ("reverseEachWord".equals(commandWords[0]))
        {
        return reverseEachWord(oldString, commandWords);
        }
        else if ("printString".equals(commandWords[0]))
        {
        return printString(oldString, commandWords);
        }
        else if ("enterNewString".equals(commandWords[0]))
        {
        return enterNewString(oldString, commandWords);
        }
        else
        {
        printHelp("Unknown command: "+commandWords[0]);
        return null;
        }
}

    public static void main(String args[])
    { 
        String theString = START_STRING;
        
        Scanner s = new Scanner(System.in);
        boolean run = true;

        do
        {
            System.out.print("Enter Comand: ");
            String line = s.nextLine();
            String[] commandWords = line.split(" ");
            
            if ("quit".equals(commandWords[0]))
            {
             run = false;
            }
            else
            {
                String newString = handleStringCommand(theString, commandWords);
                if (newString != null)
                {
                    theString = newString;
                }
            }
        }while (run==true);
    }
}
    /**
     * @param args the command line arguments
     */


