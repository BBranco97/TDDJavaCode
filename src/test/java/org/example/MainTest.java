package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void IsTemperatureReturnEqualsTemperatureSent() {
        int[] temperatures = {1, 2, 3, 4, 5, 6, 7};
        String input = "1 2 3 4 5 6 7";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] returnedTemperatures = Main.GetTemperature();

        assertArrayEquals(temperatures, returnedTemperatures);
    }

}