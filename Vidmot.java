import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vidmot
{
    // Fastayrðing gagna:
    // frame er rammi. guess er ágiskunarhnappur,
    // newGame er frumstillingarhnappur og 
    // closeGame er hnappur til að hætta keyrslu.
    // statusLabel heldur utan um stöðu leiks
    // og tjáir notanda hana. entryBox er 
    // innsláttarsvæði fyrir ágiskanir.
    // tries heldur utan um fjölda tilrauna.
    // logik heldur utan um slembna tölu til
    // ágiskunar.
    JFrame frame;
    JButton guess;
    JButton newGame;
    JButton closeGame;
    JLabel statusLabel;
    JTextField entryBox;
    Logik logik;
    int tries;

    // Gluggi smíðaður og virkni forstillt. Engin tilraun til spurningar 
    // hefur verið gerð.
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

    // Ýtt hefur verið á New Game hnapp og gluggaumhverfi
    // og slembitala eru öll endurstillt.
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

    // Ýtt hefur verið á Close hnapp, forriti verður lokað.
    private class closeGameAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent evt)
        {
            System.exit(0);
        }
    }

    // Ýtt hefur verið á Guess hnappinn. statusLabel er uppfærður
    // í samræmi við útkomu ágiskunar. Öll inntök í inntaksbox
    // sem ekki eru af sniði int skila villum en trufla annars
    // ekki virkni eða stöðu leiks.
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
        private class Logik
        {
            // Fastayrðing gagna:
            // number er slembitala til ágiskunar.
            int number;

            // Number er stillt, hún liggur á bilinu 1..10.
            public Logik()
            {
                number = new java.util.Random().nextInt(9) + 1;
            }

            // Compares x to number. Negative value if lower, zero
            // if equal and positive number if higher.
            public int checkNumber(int x)
            {
                return new Integer(x).compareTo(this.number);
            }
        }
    }

    // Forrit gangsett.
    public static void main(String[] args)
    {
        Vidmot vidmot = new Vidmot();
    }
}

