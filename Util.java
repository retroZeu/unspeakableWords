import java.io.IOException;
import java.util.Scanner;
public class Util
{
    public static String getLine()
    {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    
    public static int getInt()
    {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    
    /**
     * Verifies that one of the strings provided as arguments will be
     * returned.
     * 
     * Example usage:
     * String input = User.getValidInput("yes", "no", "y", "n");
     * 
     * Only yes, no, y, and n are valid inputs. If the user types anything
     * else, they will be prompted to re-enter.
     * 
     */
    public static String getValidInput(String... validInputs)
    {
        String input = "";
        boolean valid = false;
        do
        {
            input = getLine();
            for(String str : validInputs)
            {
                if(input.toLowerCase().equals(str.toLowerCase()))
                    valid = true;
            }
            if(!valid)
                System.out.print("Invalid input. Please try again: ");
        }
        while(!valid);
        return input;
    }
    
    public static void main(String... arg) throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
