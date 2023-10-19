package com.scaler.lld.design.assignments.abstractfactory;

import com.scaler.lld.design.assignments.abstractfactory.decoder.AudioDecoder;
import com.scaler.lld.design.assignments.abstractfactory.decoder.FLACDecoder;
import com.scaler.lld.design.assignments.abstractfactory.player.AudioPlayer;
import com.scaler.lld.design.assignments.abstractfactory.player.FLACPlayer;
import com.scaler.lld.design.assignments.abstractfactory.processor.AudioProcessor;
import com.scaler.lld.design.assignments.abstractfactory.processor.FLACAudioProcessor;

public class FLACAudioFactory extends AudioFactory {
    @Override
    public MediaFormat supportsType() {
        return MediaFormat.FLAC;
    }

    @Override
    public AudioProcessor createAudioProcessor(byte[] bytes) {
        return new FLACAudioProcessor(bytes);
    }

    @Override
    public AudioDecoder audioDecoder(byte[] bytes) {
        return new FLACDecoder(bytes);
    }

    @Override
    public AudioPlayer createPlayer(int volume, double playbackRate) {
        return new FLACPlayer(volume, playbackRate);
    }
}