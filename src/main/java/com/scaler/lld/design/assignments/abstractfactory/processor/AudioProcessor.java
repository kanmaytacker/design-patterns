package com.scaler.lld.design.assignments.abstractfactory.processor;


import com.scaler.lld.design.assignments.abstractfactory.MediaFormat;
import lombok.Getter;

@Getter
public abstract class AudioProcessor {

    private final byte[] audioData;

    public AudioProcessor(byte[] audioData) {
        this.audioData = audioData;
    }

    public abstract MediaFormat supportsFormat();

    public abstract byte[] process();
}