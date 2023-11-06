package org.example;

public class Main {
    public static void main(String[] args) {

        String pwd = "superSafePW";
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
        } return false;

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
}