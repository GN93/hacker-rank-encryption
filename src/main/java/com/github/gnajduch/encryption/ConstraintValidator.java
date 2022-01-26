package com.github.gnajduch.encryption;

import com.github.gnajduch.encryption.exception.InputSizeExceededException;

class ConstraintValidator {
    private static final int INPUT_MAX_SIZE = 81;

    static void validate(String inputText) throws InputSizeExceededException {
        if (inputText.length() > INPUT_MAX_SIZE) {
            throw new InputSizeExceededException(String.format("Maximum text length exceeded. " +
                    "Expected up to %d characters but has %d.", INPUT_MAX_SIZE, inputText.length()));
        }
    }
}
