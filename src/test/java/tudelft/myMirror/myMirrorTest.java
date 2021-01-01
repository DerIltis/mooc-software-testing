package tudelft.myMirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class myMirrorTest {

    private myMirror mirror;

    @BeforeEach
    private void init() { mirror = new myMirror(); }


    @Test()
    public void stringIsNull()
    {
        //noinspection ConstantConditions
        Assertions.assertThrows(NullPointerException.class, () -> mirror.mirrorEnds(null));
    }

    @Test
    public void stringIsEmpty()
    {
        String result = mirror.mirrorEnds("");
        Assertions.assertEquals("", result);
    }

    @ParameterizedTest
    @CsvSource("a,a")
    public void singleChar(String input, String expected)
    {
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"ab,''", "abc,''", "abcd,''"})
    public void noMirror(String input, String expected)
    {
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"aBCa,a", "AbcdbA,Ab"})
    public void nonOverlappingMirror(String input, String expected)
    {
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"aa,aa","aba,aba", "ABCCBA,ABCCBA"})
    public void palindrome(String input, String expected)
    {
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"abXYZba, ab", "abca,a","aba,aba"})
    public void examples(String input, String expected)
    {
        String result = mirror.mirrorEnds(input);
        Assertions.assertEquals(expected, result);
    }
}
