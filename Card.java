public class Card
{
    private final String LETTER;
    private int VALUE; //pseudo-final
    
    public Card(String letter)
    {
        LETTER = letter;
        if (letter.equals("A")) {VALUE = 5;}
        if (letter.equals("B")) {VALUE = 5;}
        if (letter.equals("C")) {VALUE = 0;}
        if (letter.equals("D")) {VALUE = 2;}
        if (letter.equals("E")) {VALUE = 4;}
        if (letter.equals("F")) {VALUE = 3;}
        if (letter.equals("G")) {VALUE = 2;}
        if (letter.equals("H")) {VALUE = 4;}
        if (letter.equals("I")) {VALUE = 4;}
        if (letter.equals("J")) {VALUE = 2;}
        if (letter.equals("K")) {VALUE = 3;}
        if (letter.equals("L")) {VALUE = 1;}
        if (letter.equals("M")) {VALUE = 3;}
        if (letter.equals("N")) {VALUE = 2;}
        if (letter.equals("O")) {VALUE = 0;}
        if (letter.equals("P")) {VALUE = 3;}
        if (letter.equals("Q")) {VALUE = 2;}
        if (letter.equals("R")) {VALUE = 4;}
        if (letter.equals("S")) {VALUE = 0;}
        if (letter.equals("T")) {VALUE = 2;}
        if (letter.equals("U")) {VALUE = 0;}
        if (letter.equals("V")) {VALUE = 1;}
        if (letter.equals("W")) {VALUE = 3;}
        if (letter.equals("X")) {VALUE = 4;}
        if (letter.equals("Y")) {VALUE = 3;}
        if (letter.equals("Z")) {VALUE = 2;}
    }
    
    public String getLetter() { return LETTER;}
    public int getValue() { return VALUE;}
    
    public String toString() {return LETTER;}
}

