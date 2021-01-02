package tudelft.blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackJackLineCoverageTest {

    @Test
    public void bothPlayersGoTooHigh() {
        int result = new BlackJack().play(30, 30);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void leftPlayerWins() {
        int result = new BlackJack().play(10, 22);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void rightPlayerWins() {
        int result = new BlackJack().play(22, 10);
        Assertions.assertEquals(10, result);
    }
}
