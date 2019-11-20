
/**
 * Runs a game of hangman
 * @author (Isy Herman)
 * @version (11-18-2019)
 */
public class HangmanGame
{
    // instance variables - replace the example below with your own
    private int x;
    private String secretWord;
    private String gameStatus;
    private String guessedLetters;

    /**
     * Constructor for objects of class HangmanGame
     */
    public HangmanGame(String sw)
    {
        // initialise instance variables
        this.secretWord = sw;
        this.gameStatus = "";
        this.guessedLetters = "";
        
        for (int k = 0; k < sw.length(); k++)
         {
            if(Character.isLetter(secretWord.charAt(k)))
            {
                gameStatus += "-";
            }
            else
            {
                gameStatus += sw.charAt(k);
            }
        }
        this.guessedLetters = "";
    }
    
    /**
     * returns letters guessed
     * @return letters guessed
     */
    public String getTried()
    {
        return guessedLetters;
    }
    
    /**
     * returns game status
     * @return status of the game
     */
    public String getGuessed()
    {
        return gameStatus;
    }
    
    /**
     * checks to see if the letter guessed is in the secret word and if it is, the guessed letter replaces the dash at the letter's correct location in the secret word
     */
    public int tryLetter(char a)
    {
        a = Character.toLowerCase(a);
        int b = guessedLetters.indexOf(a);
        int c = secretWord.indexOf(a);
        if(b == 1)
        {
            return 0;
        }
        else if(c == -1)
        {
            guessedLetters += a;
            return -1;
        }
        else
        {
            guessedLetters += a;
            for(int i = 0; i < secretWord.length(); i++)
            {
                if(a == secretWord.charAt(i))
                {
                    gameStatus = gameStatus.substring(0,i) + a + gameStatus.substring(i + 1);
                }
            }
        }
        return 1;
    }
}
