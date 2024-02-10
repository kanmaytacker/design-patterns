package com.scaler.lld.design.assignments.adapter;

import com.scaler.lld.design.assignments.adapter.external.GoogleTranslateApi;
import com.scaler.lld.design.assignments.adapter.external.GoogleTranslationRequest;

import java.util.List;

public class GoogleTranslateAdapter implements TranslationProviderAdapter{
    private GoogleTranslateApi googleTranslateApi=new GoogleTranslateApi();
    @Override
    public String getTranslatedText(TranslationRequest translationRequest) {
        GoogleTranslationRequest googleTranslationRequest=new GoogleTranslationRequest(translationRequest.getText(),translationRequest.getSourceLanguage(),translationRequest.getTargetLanguage(),translationRequest.getConfidenceThreshold());
        return googleTranslateApi.convert(googleTranslationRequest);
    }

    @Override
    public List<String> getTranslationSupportedLanguages() {
        return googleTranslateApi.getLanguages();
    }
}
