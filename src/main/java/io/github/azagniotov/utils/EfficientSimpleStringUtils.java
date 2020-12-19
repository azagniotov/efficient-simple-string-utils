package io.github.azagniotov.utils;

import java.util.Arrays;

public final class EfficientSimpleStringUtils {

    private EfficientSimpleStringUtils() {
        // No instance methods
    }

    public static char[] trim(final String target) {
        final char[] originalChars = target.toCharArray();

        int start = 0;
        while (Character.isWhitespace(originalChars[start])) {
            ++start;
        }

        int end = originalChars.length - 1;
        while (Character.isWhitespace(originalChars[end])) {
            --end;
        }

        return Arrays.copyOfRange(originalChars, start, end + 1);
    }

    public static String trimAsString(final String target) {
        return new String(trim(target)).intern();
    }

    public static char[] firstToken(final String target) {
        final char[] originalChars = target.toCharArray();

        int start = 0;
        while (Character.isWhitespace(originalChars[start])) {
            ++start;
        }

        int end = start;
        while (!Character.isWhitespace(originalChars[end])) {
            end++;
        }

        return Arrays.copyOfRange(originalChars, start, end);
    }

    public static char[] lastToken(final String target) {
        final char[] originalChars = target.toCharArray();

        int end = originalChars.length - 1;
        while (Character.isWhitespace(originalChars[end])) {
            end--;
        }

        int start = end;
        while (!Character.isWhitespace(originalChars[start])) {
            start--;
        }

        return Arrays.copyOfRange(originalChars, start + 1, end + 1);
    }

    public static String firstTokenAsString(final String target) {
        return new String(firstToken(target)).intern();
    }

    public static long firstTokenAsLong(final String target) {
        return parseLong(firstToken(target));
    }

    public static String lastTokenAsString(final String target) {
        return new String(lastToken(target)).intern();
    }

    public static long lastTokenAsLong(final String target) {
        return parseLong(lastToken(target));
    }

    public static String inject(final String source, final int startIndex, final String injectable) {
        final char[] sourceChars = source.toCharArray();
        final char[] injectableChars = injectable.toCharArray();

        final int sourceCharsLength = sourceChars.length;
        final int injectableCharsLength = injectableChars.length;
        final char[] mergedFinalChars = new char[sourceCharsLength + injectableCharsLength];

        if (startIndex >= (sourceCharsLength + injectableCharsLength)) {
            throw new ArrayIndexOutOfBoundsException(startIndex);
        }

        System.arraycopy(sourceChars, 0, mergedFinalChars, 0, startIndex);
        System.arraycopy(injectableChars, 0, mergedFinalChars, startIndex, injectableCharsLength);
        System.arraycopy(sourceChars, startIndex, mergedFinalChars, startIndex + injectableCharsLength, sourceCharsLength - startIndex);

        return new String(mergedFinalChars).intern();
    }

    /**
     * A super simplified implementation of java.lang.Long.parseLong that accepts a char array instead of a String
     */
    private static long parseLong(final char[] originalChars) throws NumberFormatException {
        long result = 0;
        int i = 0, len = originalChars.length;
        long limit = -Long.MAX_VALUE;
        int digit;
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            digit = Character.digit(originalChars[i++], 10);
            result *= 10;
            if (result < limit + digit) {
                throw new NumberFormatException();
            }
            result -= digit;
        }

        return -result;
    }
}
