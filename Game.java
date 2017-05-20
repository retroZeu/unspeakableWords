import java.util.ArrayList;
import java.io.IOException;
public class Game
{
    public static void draw(Deck main, Player person, Deck discards)
    {
        if (main.getDeck().size() == 0)
        {
            for (int i = 0; i < discards.getDeck().size(); i++) {main.addCard(discards.deal());}
        }
        person.getHand().drawing(main.deal());
    }
    
    public static void discard(Deck discards, Player person, String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            Card temp = new Card(word.substring(i, i+1).toUpperCase());
            discards.addCard(person.getHand().move(temp));
        }
        
    }
    
    public static void play(Player person, String word, FileManager bot, Deck main, Deck discards)
    {
        //1.Check if word is in player's hand. If true, then check if legal(word) or player is insane. 
        //2.If false, end method and try again,
        //3.If true, then add card value to a sum, discard the cards from hand, add sum to player's points
        //4.Sanity check: if d20 roll < word sum, then player loses a sanity
        //5.Draw back to 7.
        int points = inHand(person, word);
        word = word.toUpperCase();
        if (points != -1)
        {
            if(person.insanity()|| bot.legal(word))
            {
                person.addPoints(points);
                discard(discards, person, word);
            } else {System.out.println("Word not valid. Try another word: "); word = Util.getLine(); play(person, word, bot, main, discards);}
            //Util.main("cmd"); FIX
            System.out.println(person.getName() + " scored " + points +"!");
            sanityCheck(person, points);
        } 
        int handSize = person.getHand().getCards().size();
        while(handSize<7)
        {
            draw(main, person, discards);
            handSize ++;
        }
    }
    
    public static void sanityCheck(Player person, int value)
    {
        int d20 = (int)(Math.random()*20 + 1);
        if(value>d20)
        {
            person.lessSane();            
            System.out.println("Oh no, "+person.getName()+" rolled a "+d20+" and lost a sanity point!"+person.getName()+" have "+person.getSanity()+" sanity points left!");
        } else {System.out.println(person.getName()+" rolled a "+d20+" and passed the sanity check!");}
    }
    
    public static int inHand(Player person, String word)
    {
        int pointsEarned = -1;
        boolean wordInHand = true;
        ArrayList<String> letters = new ArrayList<String>();
        for (int i = 0; i < word.length()-1; i++)
        {
            letters.add(word.substring(i, i+1).toUpperCase());
        }
        int i = 0;
        while(wordInHand&&i<letters.size())
        {
            for(String check: letters)
            { 
                boolean valid = false;
                while(!valid)
                {   
                    ArrayList<Card> temp =  person.getHand().getCards();
                    for(Card x:temp)
                    {
                        if(x.getLetter().equals(check.toUpperCase()))
                        {
                            valid = true;
                        }
                    }
                }
                wordInHand = valid;
                i++;
            }
        }
        if(wordInHand)
        {
            pointsEarned = 0;
            for(String letter: letters)
            {
                Card temp = new Card(letter);
                pointsEarned += temp.getValue();
            }
        }
        return pointsEarned;
    }
    
    public static void pass(Player person, Deck main, Deck discards)
    {
        //1.Disard hand, draw back up to 7.
        String temp = "";
        for (Card x : person.getHand().getCards())
        {temp += x.getLetter();}
        discard(discards, person, temp);
        for (int i = 0; i < 7; i++) {draw(main, person, discards);}
    }
    
    public static boolean playerOutSanity(Player person) //checks if sanity = 0 or points >= 100
    {
        if (person.getSanity() <= 0) {return true;}
        else {return false;}
    }
    
    public static boolean playerOutPoints(Player person) //checks if sanity = 0 or points >= 100
    {
        if (person.getPoints() >= 100) {return true;}
        else {return false;}
    }
}





