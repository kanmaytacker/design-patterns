package com.scaler.lld.design.solutions.adapter;

import com.scaler.lld.design.solutions.adapter.external.GoogleTranslateApi;
import com.scaler.lld.design.solutions.adapter.external.GoogleTranslationRequest;

import java.util.List;

public class GoogleTranslationProviderAdapter implements TranslationProviderAdapter{

    private final GoogleTranslateApi api = new GoogleTranslateApi();
    @Override
    public String convert(TranslationRequest request) {
        return api.convert(convertRequest(request));
    }

    private GoogleTranslationRequest convertRequest(TranslationRequest request) {
        return new GoogleTranslationRequest(request.getText(),
                request.getSourceLanguage(), request.getTargetLanguage(), request.getConfidenceThreshold());
    }

    @Override
    public List<String> getSupportedLanguages() {
        return api.getLanguages();
    }
}
