package com.scaler.lld.design.assignments.factory;

public class WAVPlayer {
    private int volume;
    private double playBackRate;

    public WAVPlayer(int volume, double playBackRate) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }

    public void play() {
        // Simulate playing audio in WAV format
        // Each media format will have its own implementation
        System.out.println("Playing WAV audio");
    }

    public void pause() {
        // Simulate pausing audio in WAV format
        // Each media format will have its own implementation
        System.out.println("Pausing WAV audio");
    }

    public void stop() {
        // Simulate stopping audio in WAV format
        // Each media format will have its own implementation
        System.out.println("Stopping WAV audio");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to " + volume);
        } else {
            System.out.println("Invalid volume level");
        }
    }

    public double getPlayBackRate() {
        return playBackRate;
    }

    public MediaFormat supportsType() {
        return MediaFormat.WAV;
    }
}