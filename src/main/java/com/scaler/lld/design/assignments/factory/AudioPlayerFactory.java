package com.scaler.lld.design.assignments.factory;

public class AudioPlayerFactory {
    static AudioPlayer createAudioPlayer(MediaFormat format, int volume, double playBackRate) {
        if (format == MediaFormat.FLAC) {
            FLACPlayer FlacObj = new FLACPlayer(volume, playBackRate);
            return FlacObj;
        } else if (format == MediaFormat.MP3) {
            MP3Player Mp3Obj = new MP3Player(volume, playBackRate);
            return Mp3Obj;
        } else {
            WAVPlayer WavObj = new WAVPlayer(volume, playBackRate);
            return WavObj;
        }
    }
}