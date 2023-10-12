package sjpapi.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CurlReaderTest {

    private final CurlReader reader = new CurlReader();

    // If this test fails, it means sjp.pl changed something
    // in the structure of the page; it is possible that
    // SjpAPI has stopped working.
    // If it still works, you can ignore this test.
    @Test
    void testIsSJPHaveSameSite() throws IOException {
        final String curlOutput = reader.getCurlOutput("https://www.sjp.pl");

        assertTrue(curlOutput.startsWith("200"));
        assertTrue(curlOutput.contains("<!DOCTYPE html>"));
        assertTrue(curlOutput.contains("meta name=\"Description\" content=\"Słownik języka polskiego, ortograficzny, wyrazów obcych i słownik do gier słownych w jednym (słownik literaki, skrable)\""));
        assertTrue(curlOutput.contains("słownik języka polskiego sjp"));
        assertTrue(curlOutput.contains("Słownik jest rozwijany z myślą o zastosowaniu do sprawdzania pisowni w programach open-source, do gier słownych (np. <a href=\"https://www.kurnik.pl/literaki/\">literaki</a>) i do użytku online jako kilka rodzajów słowników w jednym.</p>  <p>Redakcją słownika zajmują się hobbyści"));
        assertTrue(curlOutput.contains("Pierwsza wersja (słownik alternatywny) powstała na bazie dawnego słownika do ispella"));
        assertTrue(curlOutput.contains("Kontakt w sprawach technicznych: sjpslownik@gmail.com"));
    }
}