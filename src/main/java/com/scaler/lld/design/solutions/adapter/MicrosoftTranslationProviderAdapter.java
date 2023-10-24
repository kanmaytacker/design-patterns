package com.scaler.lld.design.solutions.adapter;

import com.scaler.lld.design.solutions.adapter.external.MicrosoftTranslateApi;

import java.util.List;

public class MicrosoftTranslationProviderAdapter implements TranslationProviderAdapter{

    private final MicrosoftTranslateApi api = new MicrosoftTranslateApi();
    @Override
    public String convert(TranslationRequest request) {
        return api.translate(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
    }

    @Override
    public List<String> getSupportedLanguages() {
        return api.getSupportedLanguages();
    }
}
