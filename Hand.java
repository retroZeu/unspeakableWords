import java.util.ArrayList;
public class Hand
{
    private ArrayList<Card> cards;
    
    public Hand() {cards = new ArrayList<Card>();}
    
    public void drawing(Card card) {cards.add(card);}
    
    /**
     * Returns the given Card if found, removing it from the cards.
     */
    public Card move(Card card) 
    {
        if (check(card))
        {
            for (int i = 0; i < cards.size(); i++)
            {
                if (cards.get(i).getLetter().equals(card.getLetter())) 
                { 
                    Card temp = cards.get(i);
                    cards.remove(i);
                    return temp;
                }
            }
        }
        return null;
    }
    
    /**
     * Returns true if the given Card is within the cards
     */
    public boolean check(Card card)
    {
        boolean here = false;
        for (int i = 0; i < cards.size(); i++)
        {
            if (cards.get(i).getLetter().equals(card.getLetter())) 
            { 
                here = true; break;
            }
        }
        return here;
    }
    
    public ArrayList<Card> getCards() {return cards;}
    
    public String toString()
    {
        String toReturn = "";
        for (Card c : cards) {toReturn = toReturn + c.getLetter() + ", ";}
        return toReturn;
    }
}
