import java.util.Collections;
import java.util.ArrayList;
public class GameRunner
{
    public static void main(String[] args)
    {
        //SETUP ---------------
        ArrayList<Player> playing = new ArrayList<Player>();
        ArrayList<Player> out = new ArrayList<Player>();
        FileManager bot = new FileManager("words.txt");
        Deck main = new Deck(); Deck discards = new Deck("empty");
        main.shuffle(); //Shuffles the deck
        System.out.print("How many players are playing?: ");
        int numPlayers = Util.getInt();
        for (int i = 1; i < numPlayers + 1; i++)
        {
            System.out.print("What is player " + i + "'s name?: ");
            String name = Util.getLine();
            Player temp = new Player(name);
            for (int x = 0; x < 7; x++) {Game.draw(main, temp);} //The player draws 7 cards from the Deck;
            playing.add(temp);
        }
        
        
        
        
        //THE GAME --------------
        int numOfPlayers = playing.size();
        while (numOfPlayers > 1)
        {
            Player person = playing.get(0); //ALWAYS THE FIRST PLAYER
            //Display name, sanity points, total points, and hand
            System.out.println(person.getName() + "\nSanity Points: " + person.getSanity() + "\nTotal Points: " + 
            person.getPoints() + "\nCards: " + person.getHand().getCards().toString());
            System.out.print("What would you like to do, " + person.getName() + "? [PLAY/PASS]:");
            String opt = Util.getValidInput("PLAY", "PASS");
            if (opt.equals("PASS"))
            {
                System.out.print("What word would you like to play?: ");
                String word = Util.getLine();
                Game.play(person, word, bot, main, discards);  
            }
            else if (opt.equals("PASS"))
            {
                Game.pass(person, main, discards);
            }
            
            //STUFF
            
            numOfPlayers = playing.size(); //UPDATE THE VARIABLE
        }
        
        
        
        
        //END GAME ---------------
        for (int i = 0; i < numOfPlayers; i++) //Move all players from playing to out.
        {
            Player temp = playing.get(i); playing.remove(i); out.add(temp);
        }
        Collections.sort(out); //FIX: The last person in list wins.
        //Declare winner and stuff.
        System.out.println("RANKING");
        int placing = 1;
        for (int i = out.size()-1; i > 0; i--)
        { System.out.println(placing +" >> " + out.get(i).getName()); placing++; }
    }
}