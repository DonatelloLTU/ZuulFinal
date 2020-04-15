
/**
 * Starts Zuul game
 *
 * @author Donatas Vasauskas
 * @version 2019.12.11-01
 */
public class GameMain
{
   /**
    * Starts Zuul game
    * @param args program arguments
    */
    public static void main(String[] args) 
   {
       Game game = new Game();
       System.out.print('\u000C');
       game.play();
   }
}
