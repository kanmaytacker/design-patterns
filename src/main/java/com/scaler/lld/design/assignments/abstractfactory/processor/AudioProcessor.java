package com.scaler.lld.design.assignments.abstractfactory.processor;


import com.scaler.lld.design.assignments.abstractfactory.MediaFormat;

public abstract class AudioProcessor {

    private final byte[] audioData;

    public AudioProcessor(byte[] audioData) {
        this.audioData = audioData;
    }

    public byte[] getAudioData() {
        return audioData;
    }

    public abstract MediaFormat supportsFormat();

    public abstract byte[] process();
}