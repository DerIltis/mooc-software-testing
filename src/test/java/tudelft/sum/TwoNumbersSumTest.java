package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

public class TwoNumbersSumTest {

    private TwoNumbersSum sum;
    @BeforeEach
    public void init()
    {
        sum = new TwoNumbersSum();
    }


    @Test
    public void TwoEmptyNumbers()
    {
        ArrayList<Integer> result = sum.addTwoNumbers(new ArrayList<>(), new ArrayList<>());
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void OneEmptyNumber()
    {
        var a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        ArrayList<Integer> result = sum.addTwoNumbers(a, new ArrayList<>());
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals((int) 1, (int) result.get(0));
        Assertions.assertEquals((int) 2, (int) result.get(1));
    }

    @Test
    public void TwoNonEmptyNumbersWithoutCarryOver()
    {
        ArrayList<Integer> a = new ArrayList<Integer>();

        a.add(1);
        a.add(2);

        ArrayList<Integer> b = new ArrayList<Integer>();

        b.add(1);
        b.add(2);

        ArrayList<Integer> result = sum.addTwoNumbers(a, b);

        Assertions.assertEquals(a.size(), result.size());
        Assertions.assertEquals(2, (int) result.get(0));
        Assertions.assertEquals(4, (int) result.get(1));
    }

    @Test
    public void TwoNonEmptyNumbersWithCarryOver()
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(6);
        a.add(5);

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(6);
        b.add(5);

        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(1);
        r.add(3);
        r.add(0);


        ArrayList<Integer> result = sum.addTwoNumbers(a, b);

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals((int) r.get(0), (int) result.get(0));
        Assertions.assertEquals((int) r.get(1), (int) result.get(1));
        Assertions.assertEquals((int) r.get(2), (int) result.get(2));
    }

    @Test
    public void TwoDifferentNonEmptyNumbersWithCarryOver()
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(6);
        a.add(5);

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(6);
        b.add(5);

        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(2);
        r.add(3);
        r.add(0);


        ArrayList<Integer> result = sum.addTwoNumbers(a, b);

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals((int) r.get(0), (int) result.get(0));
        Assertions.assertEquals((int) r.get(1), (int) result.get(1));
        Assertions.assertEquals((int) r.get(2), (int) result.get(2));
    }


}
