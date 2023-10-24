package com.scaler.lld.design.solutions.abstractfactory;

import com.scaler.lld.design.solutions.abstractfactory.player.AudioPlayer;
import com.scaler.lld.design.solutions.abstractfactory.player.MP3Player;
import com.scaler.lld.design.solutions.abstractfactory.decoder.AudioDecoder;
import com.scaler.lld.design.solutions.abstractfactory.decoder.MP3Decoder;
import com.scaler.lld.design.solutions.abstractfactory.processor.AudioProcessor;
import com.scaler.lld.design.solutions.abstractfactory.processor.MP3AudioProcessor;

public class MP3AudioFactory extends AudioFactory {
    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.MP3;
    }

    @Override
    public AudioDecoder createDecoder(byte[] audioData) {
        return new MP3Decoder(audioData);
    }

    @Override
    public AudioPlayer createPlayer(int volume, double playbackRate) {
        return new MP3Player(volume, playbackRate);
    }

    @Override
    public AudioProcessor createProcessor(byte[] audioData) {
        return new MP3AudioProcessor(audioData);
    }
}