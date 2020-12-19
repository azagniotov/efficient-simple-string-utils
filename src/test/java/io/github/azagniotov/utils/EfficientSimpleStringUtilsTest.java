package io.github.azagniotov.utils;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class EfficientSimpleStringUtilsTest {

    @Test
    public void shouldTrim() throws Exception {
        assertArrayEquals("monkeys".toCharArray(), EfficientSimpleStringUtils.trim("   monkeys   "));
        assertArrayEquals("monkeys".toCharArray(), EfficientSimpleStringUtils.trim("   monkeys"));
        assertArrayEquals("monkeys".toCharArray(), EfficientSimpleStringUtils.trim("monkeys       "));
        assertArrayEquals("monkeys".toCharArray(), EfficientSimpleStringUtils.trim("monkeys"));
    }

    @Test
    public void shouldTrimAsString() throws Exception {
        assertEquals("monkeys", EfficientSimpleStringUtils.trimAsString("   monkeys   "));
        assertEquals("monkeys", EfficientSimpleStringUtils.trimAsString("   monkeys"));
        assertEquals("monkeys", EfficientSimpleStringUtils.trimAsString("monkeys       "));
        assertEquals("monkeys", EfficientSimpleStringUtils.trimAsString("monkeys"));
    }

    @Test
    public void shouldExtractFirstToken() throws Exception {
        assertArrayEquals("123486534".toCharArray(), EfficientSimpleStringUtils.firstToken("123486534 800"));
        assertArrayEquals("123486534".toCharArray(), EfficientSimpleStringUtils.firstToken("123486534       800"));
        assertArrayEquals("123486534".toCharArray(), EfficientSimpleStringUtils.firstToken("     123486534       800"));
    }

    @Test
    public void shouldExtractLastToken() throws Exception {
        assertArrayEquals("800".toCharArray(), EfficientSimpleStringUtils.lastToken("123486534 800"));
        assertArrayEquals("800".toCharArray(), EfficientSimpleStringUtils.lastToken("123486534       800"));
        assertArrayEquals("800".toCharArray(), EfficientSimpleStringUtils.lastToken("     123486534       800   "));
    }

    @Test
    public void shouldExtractFirstTokenSucceededByWhitespaceAsString() throws Exception {
        assertEquals("123486534", EfficientSimpleStringUtils.firstTokenAsString("123486534 800"));
        assertEquals("123486534", EfficientSimpleStringUtils.firstTokenAsString("123486534       800"));
        assertEquals("123486534", EfficientSimpleStringUtils.firstTokenAsString("     123486534       800"));
    }

    @Test
    public void shouldExtractFirstTokenSucceededByWhitespaceAsLong() throws Exception {
        assertEquals(123486534L, EfficientSimpleStringUtils.firstTokenAsLong("123486534 800"));
        assertEquals(123486534L, EfficientSimpleStringUtils.firstTokenAsLong("123486534       800"));
        assertEquals(123486534L, EfficientSimpleStringUtils.firstTokenAsLong("     123486534       800"));
    }

    @Test
    public void shouldExtractLastTokenPrecededByWhitespaceAsString() throws Exception {
        assertEquals("800", EfficientSimpleStringUtils.lastTokenAsString("123486534 800"));
        assertEquals("800", EfficientSimpleStringUtils.lastTokenAsString("123486534       800"));
        assertEquals("800", EfficientSimpleStringUtils.lastTokenAsString("123486534       800       "));
    }

    @Test
    public void shouldExtractLastTokenPrecededByWhitespaceAsLong() throws Exception {
        assertEquals(800L, EfficientSimpleStringUtils.lastTokenAsLong("123486534 800"));
        assertEquals(800L, EfficientSimpleStringUtils.lastTokenAsLong("123486534       800"));
        assertEquals(800L, EfficientSimpleStringUtils.lastTokenAsLong("123486534       800         "));
    }

    @Test
    public void shouldInjectString() throws Exception {
        assertEquals("zaggy@gmail.com", EfficientSimpleStringUtils.inject("zaggygmail.com", 5, "@"));
        assertEquals("Hello, World. This monkey Alex is fun!!!", EfficientSimpleStringUtils.inject("Hello, World. This monkey is fun!!!", 25, " Alex"));
        assertEquals("Well, this is a start", EfficientSimpleStringUtils.inject("this is a start", 0, "Well, "));
        assertEquals("This is a happy ending!", EfficientSimpleStringUtils.inject("This is a happy", 15, " ending!"));
        assertEquals("@", EfficientSimpleStringUtils.inject("", 0, "@"));
        assertEquals(" @ ", EfficientSimpleStringUtils.inject("  ", 1, "@"));
        assertEquals("zaggy@", EfficientSimpleStringUtils.inject("zaggy", 5, "@"));

        assertThrows("Array index out of range: 6", ArrayIndexOutOfBoundsException.class, () -> {
            EfficientSimpleStringUtils.inject("zaggy", 6, "@");
        });

        assertThrows("Array index out of range: 0", ArrayIndexOutOfBoundsException.class, () -> {
            EfficientSimpleStringUtils.inject("", 0, "");
        });
    }
}
