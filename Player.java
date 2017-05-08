public class Player
{
    private String name; private Hand hand; private boolean insane;
    private int sanity, points;
    
    public Player(String name)
    {
        this.name = name; hand = new Hand();
        sanity = 5; points = 0; insane = false;
    }
    
    public String getName() {return name;}
    public boolean insanity() {return insane;} 
    public void setInsanity(boolean tf) {insane = tf;}
    public int getSanity() {return sanity;} public void lessSane() {sanity -= 1;}
    public int getPoints() {return points;} public void addPoints(int num) {points += num;}
    public Hand getHand() {return hand;}
}
