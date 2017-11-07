package ru.kuzzzik;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * class testing methods for fixing the placement of brackets
 */
public class InnerTest {
    /**
     * testing method of formatting the opening curly brace
     * @return returns the control's data, if it is true
     * @throws Exception basic parental exception
     */
    @Test
    public void bracketCurlOpen() throws Exception {

        InnerTest myUnit1 = new InnerTest();

        char[] expectedArray = {' ', '{', '\n'};

        char[] resultArray =  myUnit1.bracketCurlOpen();

        assertArrayEquals(expectedArray, resultArray);

    }
    /**
     * testing method of formatting the closing curly brace
     * @return returns the control's data, if it is true
     * @throws Exception basic parental exception
     */
    @Test
    public char[] bracketCurlClose() throws Exception {
        InnerTest myUnit2 = new InnerTest();

        char[] expectedArray = {'\n', '}', '\n'};

        char[] resultArray =  myUnit2.bracketCurlClose();

        assertArrayEquals(expectedArray, resultArray);

        return expectedArray;
    }
    /**
     * testing method of formatting the opening brace
     * @return returns the control's data, if it is true
     * @throws Exception basic parental exception
     */
    @Test
    public char[] bracketOpen() throws Exception {
        InnerTest myUnit3 = new InnerTest();

        char[] expectedArray = {' ', '(', 'i'};

        char[] resultArray =  myUnit3.bracketOpen();

        assertArrayEquals(expectedArray, resultArray);

        return expectedArray;
    }
    /**
     * testing method of formatting the closing brace
     * @return returns the control's data, if it is true
     * @throws Exception basic parental exception
     */
    @Test
    public char[] bracketClose() throws Exception {
        InnerTest myUnit4 = new InnerTest();

        char[] expectedArray = {')', ')', '\n'};

        char[] resultArray =  myUnit4.bracketClose();

        assertArrayEquals(expectedArray, resultArray);

        return expectedArray;
    }

}