package com.scaler.lld.design.assignments.abstractfactory;

import com.scaler.lld.design.assignments.abstractfactory.decoder.AudioDecoder;
import com.scaler.lld.design.assignments.abstractfactory.player.AudioPlayer;
import com.scaler.lld.design.assignments.abstractfactory.processor.AudioProcessor;
import com.scaler.lld.design.assignments.abstractfactory.processor.FLACAudioProcessor;

public abstract class AudioFactory {
    public abstract MediaFormat supportsType();
    public abstract AudioProcessor createAudioProcessor(byte[] bytes);
    public abstract AudioDecoder audioDecoder(byte[] bytes);
    public abstract AudioPlayer createPlayer(int volume, double playbackRate);
}