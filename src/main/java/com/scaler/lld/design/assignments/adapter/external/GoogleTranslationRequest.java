package com.scaler.lld.design.assignments.adapter.external;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GoogleTranslationRequest {
    private String text;
    private String sourceLanguage;
    private String targetLanguage;
    private Double confidenceThreshold;
}