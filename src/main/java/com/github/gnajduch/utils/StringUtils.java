package com.github.gnajduch.utils;

public class StringUtils {

    public static String removeRedundantChars(String s) {
        return s.replaceAll("\\u0000", "").trim();
    }
}
