package com.scaler.lld.design.assignments.factory;

public abstract class AudioPlayer {
    private int volume;
    private double playBackRate;
    public abstract void play() ;

    public abstract void pause() ;

    public abstract void stop();

    public abstract void setVolume(int volume);

    public abstract int getVolume();

    public abstract double getPlayBackRate();
    public abstract MediaFormat supportsType();
}