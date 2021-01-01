package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MakeChocolateTest {
    private MakeChocolate choc;

    @BeforeEach
    public void initialize()
    {
        choc = new MakeChocolate();
    }

    @ParameterizedTest(name = "small={0}, big={1}, goal={2}, result={3}")
    @CsvSource({"3,4,22,2", "3,4,23,3", "3,4,24,-1"})
    public void goalIsTooBig(int small, int big, int goal, int result)
    {
        int calc = choc.makeChocolate(small, big, goal);
        Assertions.assertEquals(result, calc);
    }

    @ParameterizedTest(name = "small={0}, big={1}, goal={2}, result={3}")
    @CsvSource({"3,3,20,-1", "3,4,20,0", "3,5,20,0"})
    public void onlyBig(int small, int big, int goal, int result)
    {
        int calc = choc.makeChocolate(small, big, goal);
        Assertions.assertEquals(result, calc);
    }

    @ParameterizedTest(name = "small={0}, big={1}, goal={2}, result={3}")
    @CsvSource({"2,3,3,-1", "3,3,3,3", "4,3,3,3"})
    public void onlySmall(int small, int big, int goal, int result)
    {
        int calc = choc.makeChocolate(small, big, goal);
        Assertions.assertEquals(result, calc);
    }

    @ParameterizedTest(name = "small={0}, big={1}, goal={2}, result={3}")
    @CsvSource({"0,3,17,-1", "1,3,17,-1", "2,3,17,2", "3,3,17,2",
            "0,3,12,-1", "1,3,12,-1", "2,3,12,2", "3,3,12,2"})
    public void bigAndSmall(int small, int big, int goal, int result)
    {
        int calc = choc.makeChocolate(small, big, goal);
        Assertions.assertEquals(result, calc);
    }

    @ParameterizedTest(name = "small={0}, big={1}, goal={2}, result={3}")
    @CsvSource({"1,3,12,-1", "2,3,12,2", "3,3,12,2"})
    public void insufficientSmall(int small, int big, int goal, int result)
    {
        int calc = choc.makeChocolate(small, big, goal);
        Assertions.assertEquals(result, calc);
    }

}
