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
    public char bracketCurlOpen() throws Exception {


//        char[] expectedArray = {' ', '{', '\n'};
//
//        char resultArray =  bracketCurlOpen();
//
//        assertArrayEquals(expectedArray, resultArray);
//
//        return expectedArray;
        return 0;

    }
    /**
     * testing method of formatting the closing curly brace
     * @return returns the control's data, if it is true
     * @throws Exception basic parental exception
     */
    @Test
    public char[] bracketCurlClose() throws Exception {

        char[] expectedArray = {'\n', '}', '\n'};

        char[] resultArray =  bracketCurlClose();

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

        char[] expectedArray = {' ', '(', 'i'};

        char[] resultArray =  bracketOpen();

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

        char[] expectedArray = {')', ')', '\n'};

        char[] resultArray =  bracketClose();

        assertArrayEquals(expectedArray, resultArray);

        return expectedArray;
    }

}