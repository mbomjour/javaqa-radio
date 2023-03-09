package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest // количество станций не задано (по умолчанию)
    @CsvFileSource(files = "src/test/resources/stations-default-qty.csv")

    public void shouldSetStationIfQtyDefault(int target, int expected) {
        radio.setCurrentStation(target);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNextStation() {
        radio.setCurrentStation(8);
        radio.next();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationNextToLast() {
        radio.setCurrentStation(9);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevStation() {
        radio.setCurrentStation(8);
        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationPreFirst() {
        radio.setCurrentStation(0);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // количество станций задано выше стандартного
    @CsvFileSource(files = "src/test/resources/stations-over-default.csv")

    public void shouldSetStationIfQty12(int target, int expected) {
        Radio radio = new Radio(12);
        radio.setCurrentStation(target);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNextStationQty12() {
        Radio radio = new Radio(12);
        radio.setCurrentStation(10);
        radio.next();

        int expected = 11;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationNextToLastQty12() {
        Radio radio = new Radio(12);
        radio.setCurrentStation(11);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevStationQty12() {
        Radio radio = new Radio(12);
        radio.setCurrentStation(10);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationPreFirstQty12() {
        Radio radio = new Radio(12);
        radio.setCurrentStation(0);
        radio.prev();

        int expected = 11;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // количество станций задано ниже стандартного
    @CsvFileSource(files = "src/test/resources/stations-under-default.csv")

    public void shouldSetStationIfQty8(int target, int expected) {
        Radio radio = new Radio(8);
        radio.setCurrentStation(target);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNextStationQty8() {
        Radio radio = new Radio(8);
        radio.setCurrentStation(6);
        radio.next();

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationNextToLastQty8() {
        Radio radio = new Radio(8);
        radio.setCurrentStation(7);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevStationQty8() {
        Radio radio = new Radio(8);
        radio.setCurrentStation(6);
        radio.prev();

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetStationPreFirst8() {
        Radio radio = new Radio(8);
        radio.setCurrentStation(0);
        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/volume.csv")

    public void shouldSetVolume(int target, int expected) {
        radio.setCurrentVolume(target);

        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.setCurrentVolume(72);
        radio.increaseVolume();

        int expected = 73;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeOverMax() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolume() {
        radio.setCurrentVolume(38);
        radio.decreaseVolume();

        int expected = 37;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDecreaseVolumeUnderMin() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
