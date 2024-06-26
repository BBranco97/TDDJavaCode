package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.example.Main.AVGWeekTemperature;
import static org.example.Main.DaysAboveAVG;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private void setSystemInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void IsTemperatureReturnEqualsTemperatureSent() {
        int[] temperatures = {1, 2, 3, 4, 5, 6, 7};
        String input = "1 2 3 4 5 6 7";

        setSystemInput(input);
        int[] returnedTemperatures = Main.GetTemperature();

        assertArrayEquals(temperatures, returnedTemperatures);
    }

    @Test
    void TemperatureWithInvalidInputShouldReturnError() {
        String input = "1 2 3 A 5 6 7";

        setSystemInput(input);

        assertThrows(IllegalArgumentException.class, Main::GetTemperature);

    }

    @Test
    void TemperaturesNotInformedShouldReturnError() {
        int[] temp = {};
        assertThrows(IllegalArgumentException.class, () -> {
            AVGWeekTemperature(temp);
        });
    }

    @Test
    void ShouldCalculateAVGTemperatures() {
        int[] temp = {1, 2, 3, 0, -3, -2, -1};
        double avg = AVGWeekTemperature(temp);
        int average = 0;
        assertEquals(AVGWeekTemperature(temp),average);
    }

    @Test
    void NumberOfTemperaturesEnteredLessThan7ShouldReturnError() {
        int[] temp = {1, 1, 1};
        assertThrows(IllegalArgumentException.class, () -> {
            AVGWeekTemperature(temp);
        });
    }

    @Test
    void NumberOfTemperaturesEnteredBiggerThan7ShouldReturnError() {
        int[] temp = {1, 1, 1, 1, 1, 1, 1 ,1};
        assertThrows(IllegalArgumentException.class, () -> {
            AVGWeekTemperature(temp);
        });
    }

    @Test
    void DaysWithSameTemperatureShouldReturnZeroDaysAboveAVG(){
        int[] temp = {0, 0, 0, 0, 0, 0, 0};
        double avg = AVGWeekTemperature(temp);
        int days = 0;
        assertEquals(DaysAboveAVG(temp,avg),days);
    }

    @Test
    void DaysWithDifferentTemperatureShouldReturnDaysAboveAVG(){
        int[] temp = {1, 2, 3, 0, 5, 6, -7};
        double avg = AVGWeekTemperature(temp);
        int days = 4;
        assertEquals(DaysAboveAVG(temp,avg),days);
    }
}