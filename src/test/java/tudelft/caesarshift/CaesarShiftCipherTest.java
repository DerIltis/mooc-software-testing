package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher caesar;
    @BeforeEach
    public void init()
    {
        caesar = new CaesarShiftCipher();
    }

    @Test
    public void messageIsNull()
    {
        //noinspection ConstantConditions
        Assertions.assertThrows(NullPointerException.class, () -> caesar.CaesarShiftCipher(null,0));

    }

    @Test
    public void messageIsEmpty()
    {

        String result = caesar.CaesarShiftCipher("", 13);
        Assertions.assertEquals("", result);
    }

    @Test
    public void shiftIsZero()
    {
        String input = "caesar";
        String result = caesar.CaesarShiftCipher(input, 0);
        Assertions.assertEquals(input, result);

    }

    @Test
    public void shiftTwice()
    {
        String input = "caesar";
        String result = caesar.CaesarShiftCipher(input, 13);
        result = caesar.CaesarShiftCipher(result, 13);
        Assertions.assertEquals(input, result);

    }


    @Test
    public void shiftBackAndForth()
    {
        String input = "caesar";
        int shift = 5;
        String result = caesar.CaesarShiftCipher(input, shift);
        result = caesar.CaesarShiftCipher(result, -shift);
        Assertions.assertEquals(input, result);

    }

}
