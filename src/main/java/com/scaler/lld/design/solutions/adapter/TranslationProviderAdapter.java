package com.scaler.lld.design.solutions.adapter;

import java.util.List;

public interface TranslationProviderAdapter {

    String convert(TranslationRequest request);
    List<String> getSupportedLanguages();
}