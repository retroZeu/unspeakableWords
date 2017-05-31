import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
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

            }
        });


        JButton pass = new JButton("Send"); play.setText("pas");
        pass.setBorderPainted(false); pass.setContentAreaFilled(false); right.add(pass);
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });




        this.add(top, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(bottom, BorderLayout.SOUTH);
        this.setVisible(true);
    }

}
