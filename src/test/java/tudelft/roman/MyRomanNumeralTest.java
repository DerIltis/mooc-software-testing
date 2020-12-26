package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

public class MyRomanNumeralTest {


    @Test
    public void singleNumber1() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void singleNumber2() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("V");
        Assertions.assertEquals(5, result);
    }

    @Test
    public void manyNumber1() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("III");
        Assertions.assertEquals(3, result);
    }

    @Test
    public void manyNumber2() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("XX");
        Assertions.assertEquals(20, result);
    }

    @Test
    public void tooManyNumbers() throws OperationNotSupportedException {
        // TODO: This should be invalid!
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("IIII");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithManyDigits1() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithManyDigits2() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("XVIII");
        Assertions.assertEquals(18, result);
    }

    @Test
    public void numberWithSubtractiveNotation() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithManySubtractiveNotation() throws OperationNotSupportedException {
        MyRomanNumeral roman = new MyRomanNumeral();
        int result = roman.convert("XCIV");
        Assertions.assertEquals(94, result);
    }

    @Test
    public void invalidCharInNumeralArgument(){
        MyRomanNumeral roman = new MyRomanNumeral();

        Assertions.assertThrows(IllegalArgumentException.class, () -> { int result = roman.convert("VBII");});
    }

    @Test
    public void invalidOrderInNumeralArgument1(){
        MyRomanNumeral roman = new MyRomanNumeral();

        Assertions.assertThrows(OperationNotSupportedException.class, () -> { int result = roman.convert("VV");});
    }



    @Test
    public void invalidOrderInNumeralArgument2(){
        MyRomanNumeral roman = new MyRomanNumeral();

        Assertions.assertThrows(OperationNotSupportedException.class, () -> { int result = roman.convert("VX");});
    }



    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }
}
