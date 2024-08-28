package com.akademicu.mytattooapp;

public class Validation {
    public static boolean textFieldValidator(String input){
        return input.isEmpty() || input.isBlank();
    }
}
