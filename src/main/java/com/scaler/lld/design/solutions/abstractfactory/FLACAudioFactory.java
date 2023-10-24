package com.scaler.lld.design.solutions.abstractfactory;

import com.scaler.lld.design.solutions.abstractfactory.player.AudioPlayer;
import com.scaler.lld.design.solutions.abstractfactory.player.FLACPlayer;
import com.scaler.lld.design.solutions.abstractfactory.decoder.AudioDecoder;
import com.scaler.lld.design.solutions.abstractfactory.decoder.FLACDecoder;
import com.scaler.lld.design.solutions.abstractfactory.processor.AudioProcessor;
import com.scaler.lld.design.solutions.abstractfactory.processor.FLACAudioProcessor;

public class FLACAudioFactory extends AudioFactory {
    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.FLAC;
    }

    @Override
    public AudioDecoder createDecoder(byte[] audioData) {
        return new FLACDecoder(audioData);
    }

    @Override
    public AudioPlayer createPlayer(int volume, double playbackRate) {
        return new FLACPlayer(volume, playbackRate);
    }

    @Override
    public AudioProcessor createProcessor(byte[] audioData) {
        return new FLACAudioProcessor(audioData);
    }
}