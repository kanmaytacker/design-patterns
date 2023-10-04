package com.scaler.lld.design.assignments.abstractfactory.player;
import com.scaler.lld.design.assignments.abstractfactory.MediaFormat;

public abstract class AudioPlayer {

    private int volume;
    private double playbackRate;

    public AudioPlayer(int volume, double playbackRate) {
        this.volume = volume;
        this.playbackRate = playbackRate;
    }

    public abstract MediaFormat supportsFormat();

    public abstract void play();

    public abstract void pause();

    public abstract void stop();

    public int getVolume() {
        return volume;
    }

    public double getPlaybackRate() {
        return playbackRate;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to " + volume);
        } else {
            System.out.println("Invalid volume level");
        }
    }
}