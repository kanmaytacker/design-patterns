package com.scaler.lld.design.assignments.adapter;

import java.util.List;

public interface TranslationProviderAdapter {
    public String getTranslatedText(TranslationRequest translationRequest);
    public List<String> getTranslationSupportedLanguages();
}