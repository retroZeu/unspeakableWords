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
        int j = 0;
        for(int i = 0; i<out.size()-j; i++)//how many times loop is run thru
        {
            int max = out.get(0).getPoints();
            System.err.print("hi3");
            for(int x = 0; x<out.size()-j; x++)//number of items needed to check
            {
                int check = out.get(x).getPoints();
                Player temp = out.get(out.size()-j-1);
                if(check > max)
                {
                    max = check;                    
                    out.set(out.size()-j-1,out.get(x));  
                    System.err.print("hi4");
                }
                else
                {
                    out.set(out.size()-j-1,out.get(0));
                }
                out.add(0, temp);
                System.err.print("hi5");
            }
            j++;
        }        
        
        //Declare winner and stuff.
        System.out.println("RANKING");
        int placing = 1;
        for (int i = out.size()-1; i > 0; i--)
        { System.out.println(placing +" >> " + out.get(i).getName()); placing++; }
    }
}