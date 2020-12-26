package tudelft.roman;

import javax.naming.OperationNotSupportedException;

public class MyRomanNumeral {

    // Possible test cases:
    // Using more than one subtractor as in 'IIV'
    // Using invalid subtractor as in 'VX'

    public int convert(String romanNumeral) throws OperationNotSupportedException {
        int value = 0;
        if (romanNumeral == null) return 0;
        if (romanNumeral.isBlank()) return 0;

        int length = romanNumeral.length();
        int currentPos = 0;

        char currentChar = romanNumeral.charAt(currentPos);
        int currentValue = GetValue(currentChar);

        boolean nextCharAvailable = ((currentPos+1) < length);

        if (!nextCharAvailable) return currentValue;
        boolean shallSubtract = false;
        int nextValue = 0;

        while (nextCharAvailable)
        {
            char nextChar = romanNumeral.charAt(currentPos + 1);
            shallSubtract = ShallSubtract(currentChar, nextChar);
            nextValue = GetValue(nextChar);

            if (shallSubtract)
            {
                value += (nextValue-currentValue);
            }
            else
            {
                value += (currentValue);
            }

            currentPos++;
            currentChar = nextChar;
            currentValue = nextValue;
            nextCharAvailable = ((currentPos+1) < length);

        }

        if (!shallSubtract) value += nextValue;
        return value;
    }

    private int GetValue(char romanDigit)
    {
        switch(romanDigit)
        {
            case 'M' : return 1000;
            case 'D' : return 500;
            case 'C' : return 100;
            case 'L' : return 50;
            case 'X' : return 10;
            case 'V' : return 5;
            case 'I' : return 1;
            default: throw new IllegalArgumentException(String.valueOf(romanDigit));
        }
    }

    private boolean ShallSubtract(char currentChar, char nextChar) throws OperationNotSupportedException {
        // TODO: What about IVV
        switch(nextChar) {
            case 'I' :
                return false;

            case 'V' :
            case 'X' :
                if (currentChar == 'I') { return true; }
                else if (currentChar == 'V') { throw new OperationNotSupportedException(); }
                break;

            case 'L' :
            case 'C' :
                if (currentChar == 'I') { throw new OperationNotSupportedException(); }
                else if (currentChar == 'V') { throw new OperationNotSupportedException(); }
                else if (currentChar == 'X') { return true; }
                else if (currentChar == 'L') { throw new OperationNotSupportedException(); }
                break;

            case 'D' :
            case 'M' :
                if (currentChar == 'I') { throw new OperationNotSupportedException(); }
                else if (currentChar == 'V') { throw new OperationNotSupportedException(); }
                else if (currentChar == 'X') { throw new OperationNotSupportedException(); }
                else if (currentChar == 'L') { throw new OperationNotSupportedException(); }
                else if (currentChar == 'C') { return true; }
                else if (currentChar == 'D') { throw new OperationNotSupportedException(); }
                break;

        }

        return false;

    }

}
