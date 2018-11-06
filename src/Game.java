import java.util.Timer;
import java.util.TimerTask;

public class Game  {
    private Timer timer;
    private Board board;
    private int gameTime;
    private Card cardA;
    private Card cardB;
    private int pairsLeftToOpen;
    private TimerTask timerTask;



    public Game(Board board, int pairsLeftToOpen) {

        timer = new Timer();
        gameTime = 0;
        this.board = board;
        this.pairsLeftToOpen = pairsLeftToOpen;

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                board.setTimeValue(gameTime++);
            }
        }, 0, 1000);

    }


    public Boolean openCard(Card card){


        if (cardA == null) {
            cardA = card;
            return true;
        }
        else if (cardB == null) {
            cardB = card;
            if (cardA.getColor() == cardB.getColor() && cardA != cardB) {
                cardA.lock();
                cardB.lock();
                resetOpenedCards();
                pairsLeftToOpen--;
                if (pairsLeftToOpen == 0) {
                    GameOver gameOver = new GameOver(board.getOwner(), gameTime, (int) (((double)board.getBoardSize()/gameTime)*10000), board.getBoardSize());

                    timer.cancel();

                }
            } else {
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        cardA.close();
                        cardB.close();
                        resetOpenedCards();
                    }
                };
                timer.schedule(timerTask,2000);
            }
            return true;
        }

        else {
            timerTask.cancel();
            cardA.close();
            cardB.close();
            resetOpenedCards();
            return false;
        }

    }

    private void resetOpenedCards() {
        cardA = null;
        cardB = null;
    }
}