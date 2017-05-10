import java.util.ArrayList;
import java.util.Collections;
public class Deck
{
    private ArrayList<Card> deckPile;
    
    public Deck()
    {
        deckPile = new ArrayList<Card>();
        for (int i = 0; i < 10; i++) {Card x = new Card("A"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("B"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("C"); deckPile.add(x); }
        for (int i = 0; i < 3; i++) {Card x = new Card("D"); deckPile.add(x); }
        for (int i = 0; i < 10; i++) {Card x = new Card("E"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("F"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("G"); deckPile.add(x); }
        for (int i = 0; i < 3; i++) {Card x = new Card("H"); deckPile.add(x); }
        for (int i = 0; i < 9; i++) {Card x = new Card("I"); deckPile.add(x); }
        for (int i = 0; i < 1; i++) {Card x = new Card("J"); deckPile.add(x); }
        for (int i = 0; i < 1; i++) {Card x = new Card("K"); deckPile.add(x); }
        for (int i = 0; i < 5; i++) {Card x = new Card("L"); deckPile.add(x); }
        for (int i = 0; i < 3; i++) {Card x = new Card("M"); deckPile.add(x); }
        for (int i = 0; i < 5; i++) {Card x = new Card("N"); deckPile.add(x); }
        for (int i = 0; i < 8; i++) {Card x = new Card("O"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("P"); deckPile.add(x); }
        for (int i = 0; i < 1; i++) {Card x = new Card("Q"); deckPile.add(x); }
        for (int i = 0; i < 5; i++) {Card x = new Card("R"); deckPile.add(x); }
        for (int i = 0; i < 5; i++) {Card x = new Card("S"); deckPile.add(x); }
        for (int i = 0; i < 5; i++) {Card x = new Card("T"); deckPile.add(x); }
        for (int i = 0; i < 4; i++) {Card x = new Card("U"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("V"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("W"); deckPile.add(x); }
        for (int i = 0; i < 1; i++) {Card x = new Card("X"); deckPile.add(x); }
        for (int i = 0; i < 2; i++) {Card x = new Card("Y"); deckPile.add(x); }
        for (int i = 0; i < 1; i++) {Card x = new Card("Z"); deckPile.add(x); }
    }
    
    public Deck(String empty)
    {if (empty.length() > 1) {deckPile = new ArrayList<Card>();}}
    
    /**
     * Returns the first Card from the deckPile, removing it from said pile.
     */
    public Card deal()
    {
        Card toDeal = deckPile.get(0);
        deckPile.remove(0);
        return toDeal;
    }
    
    /**
     * Adds the given Card to the deckPile.
     */
    public void addCard(Card toAdd) {deckPile.add(toAdd);}
    
    /**
     * Randomizes the order of the deckPile.
     */
    public void shuffle(){Collections.shuffle(deckPile);}
}
