package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/stations.csv")

    public void shouldSetStation(int target, int expected) { // номер станции
        Radio radio = new Radio();
        radio.setCurrentStation(target);

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

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/volume.csv")

    public void shouldSetVolume(int target, int expected) { // номер станции
        Radio radio = new Radio();
        radio.setCurrentVolume(target);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentVolume(72);
        radio.increaseVolume();

        int expected = 73;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeOverMax() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolume() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentVolume(38);
        radio.decreaseVolume();

        int expected = 37;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDecreaseVolumeUnderMin() { // номер станции больше допустимого значения
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
