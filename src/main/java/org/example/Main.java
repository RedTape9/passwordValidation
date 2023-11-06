package org.example;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String pwd = "superSafePW";

        System.out.println(randomPasswordWhichPassesTheTests());
    }


    public static boolean isPWLengthGreaterOrEqualThan8(String pwd) {
        return pwd.length() >= 8;
    }

    public static boolean isPWContainsAtLeastOneDigit(String pwd) {
        // return pwd.matches(".*\\d.*");

        /*String numbers = "0123456789";
        for (int i = 0; i < pwd.length(); i++) {
            if (numbers.contains(pwd.substring(i, i + 1))) {
                return true;
            }
        } return false;*/


        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isDigit(pwd.charAt(i))) {
                return true;
            }
        }
        return false;

    }

    public static boolean isPWContainsAtLeastOneUpperAndOneLowerCaseLetter(String pwd) {
        boolean isUpper = false;
        boolean isLower = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isLetter(pwd.charAt(i))) {
                if (Character.isUpperCase(pwd.charAt(i))) {
                    isUpper = true;
                } else {
                    isLower = true;
                }
            }
        }
        return isUpper && isLower;

        /*
        String regExp = "^(?=.*[a-z])(?=.*[A-Z]).*$";
        return pwd.matches(regExp);
        */
    }

    public static boolean isPWAWellKnownPW(String pwd) {
        String[] wellKnownPWs = {
                "PW1",
                "Admin1234",
                "Welcome1",
                "Secret12",
                "ChangeMe1",
                "Superman1",
                "Letmein12",
                "Qwerty123",
                "Trustno12",
                "Access123"
        };
        for (int i = 0; i < wellKnownPWs.length; i++) {
            if (pwd.equals(wellKnownPWs[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPWContainsASpecialChar(String pwd) {
        String numbers = "0123456789";
        String letters = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < pwd.length(); i++) {
            char currentChar = pwd.charAt(i);
            if (!(numbers.indexOf(currentChar) >= 0 ||
                    letters.indexOf(currentChar) >= 0 ||
                    letters.toUpperCase().indexOf(currentChar) >= 0)) {
                return true;  // Ein Sonderzeichen wurde gefunden
            }
        }
        return false;  // Kein Sonderzeichen gefunden

        // return pwd.matches(".*[^a-zA-Z0-9].*");
    }


    public static String randomPasswordWhichPassesTheTests() {
        SecureRandom random = new SecureRandom();
        String numbers = "0123456789";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = "!§$%&/()=?";

        // Ein Array für das Passwort erstellen
        char[] pwdArray = new char[8];

        // Ein Zeichen aus jeder der vier Kategorien hinzufügen
        pwdArray[0] = numbers.charAt(random.nextInt(numbers.length()));
        pwdArray[1] = letters.charAt(random.nextInt(letters.length()));
        pwdArray[2] = letters.toUpperCase().charAt(random.nextInt(letters.length()));
        pwdArray[3] = specialChars.charAt(random.nextInt(specialChars.length()));

        // Die restlichen Zeichen zufällig generieren
        for (int i = 4; i < 8; i++) {
            int choice = random.nextInt(4);
            switch (choice) {
                case 0:
                    pwdArray[i] = numbers.charAt(random.nextInt(numbers.length()));
                    break;
                case 1:
                    pwdArray[i] = letters.charAt(random.nextInt(letters.length()));
                    break;
                case 2:
                    pwdArray[i] = letters.toUpperCase().charAt(random.nextInt(letters.length()));
                    break;
                case 3:
                    pwdArray[i] = specialChars.charAt(random.nextInt(specialChars.length()));
                    break;
            }
        }

        // Die Zeichen des Passworts mischen mit der Fisher-Yates-Methode
        for (int i = 0; i < pwdArray.length; i++) {
            int randomIndex = random.nextInt(pwdArray.length);
            char temp = pwdArray[i];
            pwdArray[i] = pwdArray[randomIndex];
            pwdArray[randomIndex] = temp;
        }

        // Char-Array in String konvertieren
        String pwd = new String(pwdArray);

        return pwd;
    }

}