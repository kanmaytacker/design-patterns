package com.scaler.lld.design.assignments.abstractfactory.player;

import com.scaler.lld.design.assignments.abstractfactory.MediaFormat;

public class MP3Player extends AudioPlayer {

    public MP3Player(int volume, double playBackRate) {
        super(volume, playBackRate);
    }

    @Override
    public void play() {
        // Simulate playing audio in MP3 format
        // Each media format will have its own implementation
        System.out.println("Playing MP3 audio");
    }

    @Override
    public void pause() {
        // Simulate pausing audio in MP3 format
        // Each media format will have its own implementation
        System.out.println("Pausing MP3 audio");
    }

    @Override
    public void stop() {
        // Simulate stopping audio in MP3 format
        // Each media format will have its own implementation
        System.out.println("Stopping MP3 audio");
    }

    public MediaFormat supportsFormat() {
        return MediaFormat.MP3;
    }
}