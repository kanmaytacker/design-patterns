package com.scaler.lld.design.solutions.abstractfactory;

import com.scaler.lld.design.solutions.abstractfactory.player.AudioPlayer;
import com.scaler.lld.design.solutions.abstractfactory.decoder.AudioDecoder;
import com.scaler.lld.design.solutions.abstractfactory.processor.AudioProcessor;

public abstract class AudioFactory {
    public abstract MediaFormat supportsFormat();
    public abstract AudioDecoder createDecoder(byte[] audioData);
    public abstract AudioPlayer createPlayer(int volume, double playbackRate);
    public abstract AudioProcessor createProcessor(byte[] audioData);
}