import java.util.ArrayList;

public class Game
{
    public static void draw(Deck main, Player person)
    {
        person.getHand().drawing(main.deal());
    }
    
    public static void discard(Deck discards, Player person, Card card)
    {
        discards.addCard(person.getHand().move(card));
    }
    
    public static void play(Player person, String aWord, FileManager bot, Deck main, Deck discards)
    {
        //1.Check if word is in player's hand. If true, then check if legal(word) or player is insane. 
        //2.If false, end method and try again,
        //3.If true, then add card value to a sum, discard the cards from hand, add sum to player's points
        //4.Sanity check: if d20 roll < word sum, then player loses a sanity
        //5.Draw back to 7.
        
    }
    
    public static void pass(Player person, Deck main, Deck discards)
    {
        //1.Disard hand, draw back up to 7.
        ArrayList<Card> temp = person.getHand().getCards();
        for (Card x : temp) {discard(discards,person,x);}
        for (int i = 0; i < 7; i++) {draw(main, person);}
    }
    
    public static boolean endGame(Player person) //checks if sanity = 0 or points >= 100
    {
        if (person.getPoints() >= 100 || person.getSanity() <= 0) {return true;}
        else {return false;}
    }
}
