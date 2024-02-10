package com.scaler.lld.design.assignments.adapter;

import com.scaler.lld.design.assignments.adapter.external.MicrosoftTranslateApi;

import java.util.List;

public class MicrosoftTranslateAdapter implements TranslationProviderAdapter{
    private MicrosoftTranslateApi microsoftTranslateApi=new MicrosoftTranslateApi();
    @Override
    public String getTranslatedText(TranslationRequest translationRequest) {
        return microsoftTranslateApi.translate(translationRequest.getText(),translationRequest.getSourceLanguage(),translationRequest.getTargetLanguage());
    }

    @Override
    public List<String> getTranslationSupportedLanguages() {
        return microsoftTranslateApi.getSupportedLanguages();
    }
}
