package com.scaler.lld.design.solutions.factory;

public class FLACPlayerFactory extends AudioPlayerFactory{

    @Override
    public AudioPlayer create(int volume, double playBackRate) {
        return new FLACPlayer(volume, playBackRate);
    }
}
