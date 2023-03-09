package ru.netology.radio;

public class Radio {
    private int qtyStation = 10;
    private int minStation = 0;
    private int maxStation = qtyStation - 1;
    private int currentStation;

    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public Radio(int qtyStation) {
        this.qtyStation = qtyStation;
        this.maxStation = qtyStation - 1;
    }

    public Radio() {
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation) {
            return;
        }
        if (currentStation > maxStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void next() {
        if (currentStation == maxStation) {
            setCurrentStation(minStation);
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == minStation) {
            setCurrentStation(maxStation);
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minVolume) {
            return;
        }
        if (currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume == maxVolume) {
            return;
        }
        currentVolume++;
    }

    public void decreaseVolume() {
        if (currentVolume == minVolume) {
            return;
        }
        currentVolume--;
    }
}
