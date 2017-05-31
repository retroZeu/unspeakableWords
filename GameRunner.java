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
        bot.readFile(); bot.sortFile();
        Deck main = new Deck(); Deck discards = new Deck("empty");
        main.shuffle(); //Shuffles the deck
        System.out.print("How many players are playing?: ");
        int numPlayers = Util.getInt();
        while (numPlayers<=1) {System.out.print("Invalid number of players. Try again: "); numPlayers = Util.getInt();}
        for (int i = 1; i < numPlayers + 1; i++)
        {
            System.out.print("What is player " + i + "'s name?: ");
            String name = Util.getLine();
            Player temp = new Player(name);
            for (int x = 0; x < 7; x++) {Game.draw(main, temp, discards);} //The player draws 7 cards from the Deck;
            playing.add(temp);
        }
        Util.clear();
        
        
        
        //THE GAME --------------
        int numOfPlayers = playing.size();
        boolean endGame = false;
        while (numOfPlayers > 1)
        {
            Player person = playing.get(0); //ALWAYS THE FIRST PLAYER
            //Display name, sanity points, total points, and hand
            System.out.println(person.getName() + "\nSanity Points: " + person.getSanity() + "\nTotal Points: " + 
            person.getPoints() + "\nCards: " + person.getHand().getCards().toString());
            
            
            System.out.print("What would you like to do, " + person.getName() + "? [PLAY/PASS]:");
            String opt = Util.getValidInput("play", "pass");
            if (opt.equals("play"))
            {
                System.out.print("What word would you like to play? [PASS]: ");
                String word = Util.getLine();
                if (word.equals("pass")||word.equals("PASS")) 
                {
                    Util.clear();
                    Game.pass(person, main, discards);
                } else { Game.play(person, word, bot, main, discards); }  
            }
            else if (opt.equals("pass"))
            {
                Util.clear();
                Game.pass(person, main, discards);
            }
            
            boolean pointOut = Game.playerOutPoints(person);
            boolean sanityOut = Game.playerOutSanity(person);
            if (pointOut || sanityOut || endGame)
            {
                if (pointOut) {endGame = true;}
                Player temp = playing.get(0); playing.remove(0); out.add(temp);
            }
            else {Player temp = playing.get(0); playing.remove(0); playing.add(temp);}
            System.out.println("======"+ person.getName() + " NOW HAS "+ person.getPoints() + " POINTS!======");
            numOfPlayers = playing.size(); //UPDATE THE VARIABLE
        }
        
        
        
        Util.clear();
        //END GAME ---------------
        System.err.print("hi1");
        for (int i = 0; i < numOfPlayers; i++) //Move all players from playing to out.
        {
            Player temp = playing.get(i); playing.remove(i); out.add(temp);
            System.err.print("hi2");
        }
        //Collections.sort(out); The last person in list wins.
        
        
        ArrayList<Integer> point = new ArrayList<Integer>(); 
        //what is the size of point right now? Prior to adding anything to it?
        
        for (int i = 0; i < out.size(); i++) { point.add(out.get(i).getPoints()); }
        Collections.sort(point);
        Player[] order= new Player[out.size()];
        for(int i = 0; i<point.size(); i++)
        {
            for(int j = 0; j<point.size(); j++)
            {
                if(out.get(j).getPoints()==point.get(i))
                {
                    //System.err.println("I'm an i: " + i + "  LOOK AT ME");
                    order[i] = out.get(j);
                }
            }
        }
    
        
        //Declare winner and stuff.
        System.out.println("RANKING");
        int placing = 1;
        for (int i = out.size()-1; i >= 0; i--)
        { System.out.println(placing +" >> " + order[i].getName() + " POINTS: " + order[i].getPoints());
            placing++; 
        }
    }
}