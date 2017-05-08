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
}
