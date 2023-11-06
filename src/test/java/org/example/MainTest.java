package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void isPWLengthGreaterOrEqualThan8() {
        assertEquals(true, Main.isPWLengthGreaterOrEqualThan8("12345678"));
        assertEquals(true, Main.isPWLengthGreaterOrEqualThan8("123SafePW"));
        assertEquals(true, Main.isPWLengthGreaterOrEqualThan8("Albion123"));
    }

    @Test
    void isPWContainsAtLeastOneDigit() {
        assertEquals(true, Main.isPWContainsAtLeastOneDigit("12345678"));
        assertEquals(true, Main.isPWContainsAtLeastOneDigit("123SafePW"));
        assertEquals(true, Main.isPWContainsAtLeastOneDigit("Albion123"));
    }

    @Test
    void isPWContainsAtLeastOneUpperAndOneLowerCaseLetter() {
        assertEquals(false, Main.isPWContainsAtLeastOneUpperAndOneLowerCaseLetter("12345678"));
        assertEquals(true, Main.isPWContainsAtLeastOneUpperAndOneLowerCaseLetter("123SafePW"));
        assertEquals(true, Main.isPWContainsAtLeastOneUpperAndOneLowerCaseLetter("Albion123"));
    }

    @Test
    void isPWAWellKnownPW() {
        assertEquals(true, Main.isPWAWellKnownPW("Admin1234"));
        assertEquals(true, Main.isPWAWellKnownPW("Welcome1"));
        assertEquals(true, Main.isPWAWellKnownPW("Secret12"));
        assertEquals(true, Main.isPWAWellKnownPW("ChangeMe1"));
        assertEquals(true, Main.isPWAWellKnownPW("Superman1"));
        assertEquals(true, Main.isPWAWellKnownPW("Letmein12"));
        assertEquals(true, Main.isPWAWellKnownPW("Qwerty123"));
        assertEquals(true, Main.isPWAWellKnownPW("Trustno12"));
        assertEquals(true, Main.isPWAWellKnownPW("Access123"));
    }
}