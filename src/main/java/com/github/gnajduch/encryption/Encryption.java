package com.github.gnajduch.encryption;

import java.util.Arrays;
import com.github.gnajduch.encryption.exception.InputSizeExceededException;
import com.github.gnajduch.utils.StringUtils;

public class Encryption {

    /**
     * @param inputText text to be ciphered
     * @return text encoded according to specification
     * @throws InputSizeExceededException if input text contains more than 81 characters
     */
    public static String encrypt(String inputText) throws InputSizeExceededException {
        ConstraintValidator.validate(inputText);
        return cipher(inputText);
    }

    private static String cipher(String inputText) {
        double lengthSquaredRoot = Math.sqrt(Double.valueOf(inputText.length()));
        int rowsNumber = (int) Math.floor(lengthSquaredRoot);
        int colsNumber = (int) Math.ceil(lengthSquaredRoot);

        if (arraySizeIncreaseNeeded(rowsNumber * colsNumber, inputText.length())) {
            rowsNumber++;
        }

        return buildCipher(inputText, rowsNumber, colsNumber);
    }

    private static boolean arraySizeIncreaseNeeded(int arrayCapacity, int numberOfCharacters) {
        return arrayCapacity < numberOfCharacters;
    }

    private static String buildCipher(String inputText, int rowsNumber, int colsNumber) {
        char[][] array = convertToCharArray(inputText, rowsNumber, colsNumber);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < colsNumber; i++) {
            for (int j = 0; j < rowsNumber; j++) {
                sb.append(array[j][i]);
            }
            sb.append(" ");
        }

        return StringUtils.removeRedundantChars(sb.toString());
    }

    private static char[][] convertToCharArray(String input, int rowsNumber, int colsNumber) {
        char[][] inputTextArray = new char[rowsNumber][colsNumber];
        char[] inputArray = input.toCharArray();
        int pointer = 0;

        for (int i = 0; i < rowsNumber; i++) {
            inputTextArray[i] = Arrays.copyOfRange(inputArray, pointer, pointer + colsNumber);
            pointer += colsNumber;
        }

        return inputTextArray;
    }
}