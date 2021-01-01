package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    private GHappy happy;

    @BeforeEach
    public void init()
    {
        happy = new GHappy();
    }


    @Test
    public void stringIsNull()
    {
        //noinspection ConstantConditions
        Assertions.assertThrows(AssertionError.class,() -> happy.gHappy(null));
    }


    @Test
    public void stringIsEmpty()
    {
        Boolean isHappy = happy.gHappy("");
        Assertions.assertEquals(true, isHappy);
    }

    @Test
    public void stringWithoutGs()
    {
        Boolean isHappy = happy.gHappy("abc");
        Assertions.assertEquals(true, isHappy);

    }

    @ParameterizedTest
    @CsvSource({"gg",
            "gga",
            "agg",
            "agga"})
    public void onlyDoubleG(String input)
    {
        Boolean isHappy = happy.gHappy(input);
        Assertions.assertEquals(true, isHappy);
    }

    @ParameterizedTest
    @CsvSource({"g", "ga", "ag", "gag", "agaga"})
    public void onlySingleGs(String input)
    {
        Boolean isHappy = happy.gHappy(input);
        Assertions.assertEquals(false, isHappy);
    }

    @ParameterizedTest
    @CsvSource({"ggg","gggg","agggggaa"})
    public void moreThanTwoConsecutiveGs(String input)
    {
        Boolean isHappy = happy.gHappy(input);
        Assertions.assertEquals(true, isHappy);
    }

    @ParameterizedTest
    @CsvSource({"ggagg","aaggaggga"})
    public void multipleHappyGs(String input)
    {
        Boolean isHappy = happy.gHappy(input);
        Assertions.assertEquals(true, isHappy);
    }

    @ParameterizedTest
    @CsvSource({"gagg,false"})
    public void bothHappyAndUnhappyGs(String input)
    {
        Boolean isHappy = happy.gHappy(input);
        Assertions.assertEquals(false, isHappy);
    }


}
