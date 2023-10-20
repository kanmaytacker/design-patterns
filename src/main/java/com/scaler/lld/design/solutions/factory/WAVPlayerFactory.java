package com.scaler.lld.design.solutions.factory;

public class WAVPlayerFactory extends AudioPlayerFactory {

    @Override
    public AudioPlayer create(int volume, double playBackRate) {
        return new WAVPlayer(volume, playBackRate);
    }
}
