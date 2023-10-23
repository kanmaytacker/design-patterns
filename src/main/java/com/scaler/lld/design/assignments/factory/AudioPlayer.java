package com.scaler.lld.design.assignments.factory;

public abstract class AudioPlayer {

    private int volume;
    private double playBackRate;

    AudioPlayer(int volume, double playBackRate) {
        this.playBackRate = playBackRate;
        this.volume = volume;
    }

    public abstract MediaFormat supportsType();

    public abstract void play();

    public abstract void pause();

    public abstract void stop();


}