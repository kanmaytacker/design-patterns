package com.scaler.lld.design.assignments.factory;

import lombok.AllArgsConstructor;

public class AudioPlayerFactory {
    public static AudioPlayer createAudioPlayer(MediaFormat mediaFormat,int volume,double playBackRate){
        if(mediaFormat==MediaFormat.MP3){
            return new MP3Player(volume,playBackRate);
        }
        else if(mediaFormat==MediaFormat.WAV){
            return new WAVPlayer(volume,playBackRate);
        }
        else if(mediaFormat==MediaFormat.FLAC){
            return new FLACPlayer(volume,playBackRate);
        }
        else{
            throw new RuntimeException("Invalid Media player format provided");
        }
    }

}