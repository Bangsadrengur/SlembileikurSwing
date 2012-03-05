import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vidmot
{
    JFrame frame;
    JButton guess;
    JButton newGame;
    JButton closeGame;
    JLabel statusLabel;
    JTextField entryBox;
    Logik logik;
    int tries;

    public Vidmot()
    {
        frame = new JFrame("Slembileikur");
        guess = new JButton("Guess");
        newGame = new JButton("New Game");
        closeGame = new JButton("Exit");
        statusLabel = new JLabel("Guess a number between 1 and 10");
        entryBox = new JTextField();
        logik = new Logik();
        tries = 0;

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        newGame.addActionListener(new newGameAction());
        closeGame.addActionListener(new closeGameAction());
        guess.addActionListener(new guessAction());

        frame.setSize(300,300);

        frame.setLayout(new BorderLayout());

        frame.add(newGame, BorderLayout.WEST);
        frame.add(closeGame, BorderLayout.SOUTH);
        frame.add(guess, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.EAST);
        frame.add(entryBox, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
    }

    private class newGameAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent evt)
        {
            statusLabel.setText("Guess a number between 1 and 10");
            entryBox.setText("");
            logik = new Logik();
            tries = 0;
        }
    }

    private class closeGameAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent evt)
        {
            System.exit(0);
        }
    }
    private class guessAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent evt)
        {
            String number = entryBox.getText();
            int k = logik.checkNumber(Integer.parseInt(number));
            if(k < 0)
            {
                tries++;
                statusLabel.setText("Too low, " + tries + " tries");
            } else if(k > 0)
            {
                tries++;
                statusLabel.setText("Too hight, " + tries + " tries");
            } else {
                tries++;
                statusLabel.setText("That is the correct number!");
            }
        }
    }

    public static void main(String[] args)
    {
        Vidmot vidmot = new Vidmot();
    }
}

