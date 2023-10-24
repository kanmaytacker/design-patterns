package com.scaler.lld.design.solutions.factory;

public class MP3PlayerFactory extends AudioPlayerFactory {
    @Override
    public AudioPlayer create(int volume, double playBackRate) {
        return new MP3Player(volume, playBackRate);
    }
}
