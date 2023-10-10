package com.scaler.lld.design.assignments.adapter;

import com.scaler.lld.design.assignments.adapter.external.ApiUtils;
import com.scaler.lld.design.assignments.adapter.external.GoogleTranslateApi;
import com.scaler.lld.design.assignments.adapter.external.MicrosoftTranslateApi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TranslationAdapterTest {

    @Test
    public void testMethods() {

        Class<?> adapterClass = TranslationProviderAdapter.class;
        Method[] methods = adapterClass.getDeclaredMethods();

        assertTrue(methods.length >= 2,
                "If the adapter class is implemented correctly, there should be at least 2 methods.");

        long getSupportedLanguagesMethod = Arrays.stream(methods)
                .filter(method -> method.getParameterCount() == 0
                        && method.getReturnType() == List.class)
                .count();

        long translateMethod = Arrays.stream(methods)
                .filter(method -> method.getParameterCount() == 1
                        && method.getReturnType() == String.class
                        && method.getParameterTypes()[0] == TranslationRequest.class)
                .count();

        assertEquals(1, getSupportedLanguagesMethod,
                "If the adapter class is implemented correctly, there should be 1 method for getting the list of supported languages which accepts no parameters and has a return type of List<String>.");
        assertEquals(1, translateMethod,
                "If the adapter class is implemented correctly, there should be 1 method for translating text which accepts a TranslationRequest parameter and has a return type of String.");
    }

    @Test
    public void testImplementations() {

        Reflections reflections = new Reflections(TranslationAdapterTest.class.getPackageName(),
                new SubTypesScanner(false));
        Set<Class<? extends TranslationProviderAdapter>> adapterImplClasses = reflections
                .getSubTypesOf(TranslationProviderAdapter.class);

        assertTrue(adapterImplClasses.size() >= 2,
                "If the adapter class is implemented correctly, there should be at least 2 implementations of the adapter interface.");

        for (Class<? extends TranslationProviderAdapter> clazz : adapterImplClasses) {
            assertTrue(TranslationProviderAdapter.class.isAssignableFrom(clazz),
                    "Class " + clazz.getSimpleName() + " should implement TranslationProviderAdapter interface.");

            boolean hasApiReference = false;

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if ((field.getType() == GoogleTranslateApi.class || field.getType() == MicrosoftTranslateApi.class)) {
                    hasApiReference = true;
                    break;
                }
            }

            assertTrue(hasApiReference,
                    "If the adapter class is implemented correctly, it should have a field referring to the external APIs.");
        }
    }

    @Test
    public void testTranslationRequest() {
        Field[] fields = TranslationRequest.class.getDeclaredFields();
        List<Pair<Class<?>, Integer>> expectedFields = List.of(
                Pair.of(String.class, 3),
                Pair.of(Double.class, 1)
        );

        assertEquals(4, fields.length,
                "If the TranslationRequest class is implemented correctly, it should have 4 fields.");
        int stringCount = Stream.of(fields)
                .filter(field -> field.getType() == String.class)
                .mapToInt(field -> 1)
                .sum();
        assertEquals(3, stringCount,
                "If the TranslationRequest class is implemented correctly, it should have 3 fields of type String.");
        
        int doubleCount = Stream.of(fields)
                .filter(field -> field.getType() == Double.class)
                .mapToInt(field -> 1)
                .sum();
        assertEquals(1, doubleCount,
                "If the TranslationRequest class is implemented correctly, it should have 1 field of type Integer.");
    }

    @Test
    public void testGetSupportedLanguages() throws Exception {
        Reflections reflections = new Reflections(TranslationProviderAdapter.class.getPackageName(),
                new SubTypesScanner(false));
        Set<Class<? extends TranslationProviderAdapter>> adapterClasses = reflections
                .getSubTypesOf(TranslationProviderAdapter.class);

        List<Pair<TranslationProviderAdapter, Method>> translateMethods = new ArrayList<>();

        for (Class<? extends TranslationProviderAdapter> adapterClass : adapterClasses) {
            Constructor<? extends TranslationProviderAdapter> constructor = adapterClass.getDeclaredConstructor();
            TranslationProviderAdapter adapter = constructor.newInstance();

            Method[] methods = adapterClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getReturnType() == List.class && method.getParameterTypes().length == 0) {
                    translateMethods.add(new Pair<>(adapter, method));
                }
            }
        }

        try (MockedStatic<ApiUtils> mockApiUtils = Mockito.mockStatic(ApiUtils.class)) {
            for (Pair<TranslationProviderAdapter, Method> method : translateMethods) {
                List<String> languages = (List<String>) method.getRight().invoke(method.getLeft());
                List<String> expectedLanguages = List.of("hindi", "marathi", "kannada");
                assertEquals(expectedLanguages, languages, "If the adapter class is implemented correctly, the method should return the list of supported languages.");
            }

            mockApiUtils.verify(ApiUtils::logMicrosoftGetSupportedLanguages);
            mockApiUtils.verify(ApiUtils::logGoogleGetSupportedLanguages);

        }
    }

    @Test
    public void testTranslate() throws Exception {
        Reflections reflections = new Reflections(TranslationProviderAdapter.class.getPackageName(),
                new SubTypesScanner(false));
        Set<Class<? extends TranslationProviderAdapter>> adapterClasses = reflections
                .getSubTypesOf(TranslationProviderAdapter.class);

        List<Pair<TranslationProviderAdapter, Method>> translateMethods = new ArrayList<>();

        for (Class<? extends TranslationProviderAdapter> adapterClass : adapterClasses) {
            Constructor<? extends TranslationProviderAdapter> constructor = adapterClass.getDeclaredConstructor();
            TranslationProviderAdapter adapter = constructor.newInstance();

            Method[] methods = adapterClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getReturnType() == String.class
                        && method.getParameterTypes().length == 1
                        && method.getParameterTypes()[0] == TranslationRequest.class) {
                    translateMethods.add(new Pair<>(adapter, method));
                }
            }
        }
        try (MockedStatic<ApiUtils> mockApiUtils = Mockito.mockStatic(ApiUtils.class)) {
            for (Pair<TranslationProviderAdapter, Method> method : translateMethods) {
                method.getRight().invoke(method.getLeft(), new TranslationRequest());
            }

            mockApiUtils.verify(ApiUtils::logGoogleTranslate);
            mockApiUtils.verify(ApiUtils::logMicrosoftTranslate);

        }
    }

    @AllArgsConstructor
    @Getter
    private static class Pair<L, R> {
        private L left;
        private R right;

        public static <L, R> Pair<L, R> of(L left, R right) {
            return new Pair<>(left, right);
        }
    }
}