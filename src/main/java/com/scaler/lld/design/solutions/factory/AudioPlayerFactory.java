package com.scaler.lld.design.solutions.factory;

public abstract class AudioPlayerFactory {

    public abstract AudioPlayer create(int volume, double playBackRate);

    public static  AudioPlayer create(MediaFormat format, double playBackRate, int volume){
        return switch (format) {
            case FLAC -> new FLACPlayer(volume, playBackRate);
            case WAV -> new WAVPlayer(volume, playBackRate);
            case MP3 -> new MP3Player(volume, playBackRate);
        };
    }
}