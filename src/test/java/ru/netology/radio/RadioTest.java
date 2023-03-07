package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/stations.csv")

    public void shouldSetStation(int setStation, int expected) { // номер станции
        Radio radio = new Radio();
        radio.setCurrentStation(setStation);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNextStation() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.next();

        int expected = 4;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationNextToLast() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevStation() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        radio.prev();

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationPreFirst() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }
}
