import java.util.ArrayList;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Donatas Vasauskas
 * @version 2019.12.11-01
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] language = { "english", "lietuviu"};
    private static final String[] validCommands = {
        "go", "quit", "help", "grab", "drop", "look", "back", "eat", "save", "load", "open", "english", "lietuviu"};
    private static final String[] validCommandsLt = {
        "english", "lietuviu", "keliauti", "baigti", "pagalba", "paimti", "padeti", "ziureti", "atgal", "valgyti", "ikrauti", "iskrauti", "atidaryti"
    };
    private GUI english;
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
           for(int i = 0; i < validCommands.length; i++) {
                if(validCommands[i].equals(aString))
                    return true;
            }
                // if we get here, the string was not found in the commands
                
           if(english.english())
           {
               for(int i = 0; i < validCommands.length; i++) {
                   if(validCommands[i].equals(aString))
                        return true;
                    }
                // if we get here, the string was not found in the commands
                return false;
        
           }
           else
           {
               for(int i = 0; i < validCommandsLt.length; i++) {
                if(validCommandsLt[i].equals(aString))
                    return true;
            }
                // if we get here, the string was not found in the commands
                return false;
        
           }
           
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
       if(english.english())
       {
           for(String command: validCommands) {
                english.appendText(command + "  ");
           }
            english.appendText("\n");
       }
       else
       {
           for(String command: validCommandsLt) {
                english.appendText(command + "  ");
           }
            english.appendText("\n");
       }
    }
    
    
    
    public String getCommandList()
    {
        if(english.english())
        {
            ArrayList list = new ArrayList();
            for(String command: validCommands) {
                list.add(command);
            }
            return String.join(" ", list);
        }
        else
        {
            ArrayList list = new ArrayList();
            for(String command: validCommandsLt) {
                list.add(command);
            }
            return String.join(" ", list);
        }
    }
    
  
}
