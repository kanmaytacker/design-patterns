package com.scaler.lld.design.assignments.factory;

public class MP3Player {
    private int volume;
    private double playBackRate;

    public MP3Player(int volume, double playBackRate) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }

    public void play() {
        // Simulate playing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Playing MP3 audio");
    }

    public void pause() {
        // Simulate pausing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Pausing MP3 audio");
    }

    public void stop() {
        // Simulate stopping audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Stopping MP3 audio");
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to " + volume);
        } else {
            System.out.println("Invalid volume level");
        }
    }

    public int getVolume() {
        return volume;
    }

    public double getPlayBackRate() {
        return playBackRate;
    }

    public MediaFormat supportsType() {
        return MediaFormat.MP3;
    }
}