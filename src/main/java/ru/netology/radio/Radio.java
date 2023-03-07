package ru.netology.radio;

public class Radio {
    int currentStation;
    int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > 9) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public void next() {
        if (currentStation == 9) {
            setCurrentStation(0);
        } else setCurrentStation(currentStation + 1);
    }

    public void prev() {
        if (currentStation == 0) {
            setCurrentStation(9);
        } else setCurrentStation(currentStation - 1);
    }
}
