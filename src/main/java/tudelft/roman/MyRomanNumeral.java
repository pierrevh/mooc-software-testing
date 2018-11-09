package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class MyRomanNumeral {
    private static Map<Character, Integer> NUMERAL_VALUES = new HashMap<>();

    static {
        NUMERAL_VALUES.put('I', 1);
        NUMERAL_VALUES.put('V', 5);
        NUMERAL_VALUES.put('X', 10);
        NUMERAL_VALUES.put('L', 50);
        NUMERAL_VALUES.put('C', 100);
        NUMERAL_VALUES.put('D', 500);
        NUMERAL_VALUES.put('M', 1000);
    }

    public static int convert(String roman) {
        if (roman == null || roman.length() < 1) {
            return 0;
        }

        int result = 0;
        int valueOfPrevious = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int valueOfCurrent = getOrThrow(roman.charAt(i));
            if (valueOfCurrent < valueOfPrevious) {
                result -= valueOfCurrent;
            } else {
                result += valueOfCurrent;
            }
            valueOfPrevious = valueOfCurrent;
        }

        return result;
    }

    private static int getOrThrow(char romanNumeral) {
        Integer value = NUMERAL_VALUES.get(romanNumeral);
        if (value == null)
            throw new IllegalArgumentException("The character " + romanNumeral + " is not a roman numeral");
        return value;
    }

    private static int success = 0;
    private static int fail = 0;

    public static void main(String[] args) {
        test("", 0);
        test(null, 0);
        test("I", 1);
        test("VI", 6);
        test("IV", 4);
        test("MMCMXLIV", 2944);

        testWithException("BLABLA", IllegalArgumentException.class);

        System.out.println("Ran " + (success + fail) + " testcases. " + success + " successful, " + fail + " failures");
    }

    private static void testWithException(String testcase, Class<? extends Exception> exception) {
        try {
            test(testcase, Integer.MIN_VALUE);
            System.out.println("Fail. Expected exception " + exception);
            fail++;
        } catch (Exception e) {
            boolean expectedExceptionThrown = exception.getName().equals(e.getClass().getName());
            if (expectedExceptionThrown) {
                success++;
            } else {
                fail++;
                System.out.println("Fail. Expected exception " + exception);
            }
        }
    }

    private static void test(String testcase, int expected) {
        int actual = convert(testcase);
        if (actual != expected) {
            System.out.println("Fail " + testcase);
            fail++;
        } else {
            success++;
        }

    }
}
