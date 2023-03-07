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
        } else currentStation++;
    }

    public void prev() {
        if (currentStation == 0) {
            setCurrentStation(9);
        } else currentStation--;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void increaseVolume() {
        if (currentVolume == 100) {
            setCurrentVolume(100);
        } else currentVolume++;
    }

    public void decreaseVolume() {
        if (currentVolume == 0) {
            setCurrentVolume(0);
        } else currentVolume--;
    }
}
