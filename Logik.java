public class Logik
{
    int number;

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
