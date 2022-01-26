package com.github.gnajduch;

import com.github.gnajduch.encryption.Encryption;
import com.github.gnajduch.encryption.exception.InputSizeExceededException;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws InputSizeExceededException {
        while (true) {
            System.out.println("Please enter text to be encoded: ");
            Scanner keyboard = new Scanner(System.in);
            String inputString = keyboard.nextLine();
            System.out.println("Cipher: " + Encryption.encrypt(inputString));
        }
    }
}
