import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zeucudatcapua2 on 5/31/17.
 */
public class GameRunnerGUI extends JFrame {

    public static void main(String[] args)
    {
        new GameRunnerGUI();
    }

    public GameRunnerGUI()
    {

        this.setSize(750,500);  this.setResizable(false); this.setTitle("Unspeakable Words JAVA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        JLabel name = new JLabel("temp"); top.add(name);



        JPanel left = new JPanel();
        JLabel points = new JLabel("points"); left.add(points);
        JLabel sanity = new JLabel("sanity"); left.add(sanity);



        JPanel main = new JPanel();
        JLabel text = new JLabel("some text"); main.add(text);

        JPanel bottom = new JPanel();
        JTextField textField = new JTextField("TYPE HERE", 30); bottom.add(textField);


        JPanel right = new JPanel();
        JButton play = new JButton("Send"); play.setText("PLAY");
        play.setBorderPainted(false); play.setContentAreaFilled(false); right.add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //advance to the next turn having played
                //have a separate method to call to update the values on the screen
                text.setText("What word would you like to play?");
                String word = textField.getText();
                Game.play();

                //AFTER PLAY
                update();
            }
        });


        JButton pass = new JButton("Send"); play.setText("PASS");
        pass.setBorderPainted(false); pass.setContentAreaFilled(false); right.add(pass);
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //advance to the next turn having passed
                Game.pass();

                //AFTER PASS
                update();
            }
        });


        //SETUP
        ArrayList<Player> playing = new ArrayList<Player>();
        ArrayList<Player> out = new ArrayList<Player>();
        FileManager bot = new FileManager("words.txt");
        bot.readFile(); bot.sortFile();
        Deck main = new Deck(); Deck discards = new Deck("empty");
        main.shuffle(); //Shuffles the deck

        String num = (String)JOptionPane.showInputDialog(
                null,
                "How many players are playing?",
                "SETUP",
                JOptionPane.PLAIN_MESSAGE);
        int numPlayers = 2;
        try {
            numPlayers = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }



        for (int i = 1; i < numPlayers + 1; i++)
        {
            System.out.print("What is player " + i + "'s name?: ");
            String name = (String)JOptionPane.showInputDialog(
                    null,
                    "What is player " + i + "'s name?",
                    "SETUP",
                    JOptionPane.PLAIN_MESSAGE);
            Player temp = new Player(name);
            for (int x = 0; x < 7; x++) {Game.draw(main, temp, discards);} //The player draws 7 cards from the Deck;
            playing.add(temp);
        }


        //SHOW GAME
        this.add(top, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(bottom, BorderLayout.SOUTH);
        this.setVisible(true);





        //THE GAME
        int numOfPlayers = playing.size();
        boolean endGame = false;
        Player person = playing.get(0); update(person, name, points, sanity, text);











        //END GAME --------------
        for (int i = 0; i < numOfPlayers; i++) //Move all players from playing to out.
        {
            Player temp = playing.get(i); playing.remove(i); out.add(temp);
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
                    order[i] = out.get(j);
                }
            }
        }


        //Declare winner and stuff.
        String end = "";
        end += "RANKING\n";
        int placing = 1;
        for (int i = out.size()-1; i >= 0; i--)
        {
            end += placing +" >> " + order[i].getName() + " POINTS: " + order[i].getPoints() + "\n";
            placing++;
        }

        text.setText(end);
    }

    public static void update(Player person, JLabel name, JLabel points, JLabel sanity, JLabel text
                              boolean endGame, ArrayList<Player> playing, ArrayList<Player> out, int numOfPlayers)
    {
        boolean pointOut = Game.playerOutPoints(person);
        boolean sanityOut = Game.playerOutSanity(person);
        if (pointOut || sanityOut || endGame)
        {
            if (pointOut) {endGame = true;}
            Player temp = playing.get(0); playing.remove(0); out.add(temp);
        }
        else {Player temp = playing.get(0); playing.remove(0); playing.add(temp);}

        System.out.println("======"+ person.getName() + " NOW HAS "+ person.getPoints() + " POINTS!======");
        numOfPlayers = playing.size();
        name.setText(person.getName()); points.setText(person.getPoints()); sanity.setText(person.getSanity());
        String theMain = person.getHand().getCards().toString() + "\nWhat would you like to do? -->>";
        text.setText(theMain);
    }


}
