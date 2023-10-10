package com.scaler.lld.design.assignments.abstractfactory;

import com.scaler.lld.design.assignments.abstractfactory.decoder.AudioDecoder;
import com.scaler.lld.design.assignments.abstractfactory.player.AudioPlayer;
import com.scaler.lld.design.assignments.abstractfactory.processor.AudioProcessor;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AudioFactoryTest {

    @Test
    public void testAbstractFactoryClass() {
        // Define the package where your files are located
        String packageName = AudioFactoryTest.class.getPackageName();

        // Get all subtypes of AudioFactory using reflection
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<? extends AudioFactory>> subTypes = reflections.getSubTypesOf(AudioFactory.class);

        assertEquals(2, subTypes.size(),
                "If the abstract factory is implemented correctly, it should have 2 subtypes: MP3Factory and FLACFactory.");

        boolean hasSupportsType = Arrays.stream(AudioFactory.class.getDeclaredMethods())
                .anyMatch(method -> method.getName().equals("supportsType")
                        && method.getParameterCount() == 0
                        && method.getReturnType().equals(MediaFormat.class)
                        && Modifier.isAbstract(method.getModifiers()));
        assertTrue(hasSupportsType,
                "If the abstract factory class is implemented correctly, it should have a method called supportsType with no parameters and returns a MediaFormat.");

        boolean hasCreateProcessorMethod = Arrays.stream(AudioFactory.class.getDeclaredMethods())
                .anyMatch(method -> Modifier.isAbstract(method.getModifiers())
                        && method.getReturnType().equals(AudioProcessor.class)
                        && Arrays.asList(method.getParameterTypes()).contains(byte[].class));
        assertTrue(hasCreateProcessorMethod,
                "If the abstract factory class is implemented correctly, it should have a method to create an audio processor that takes a byte[] parameter and returns an AudioProcessor.");

        boolean hasCreateDecoderMethod = Arrays.stream(AudioFactory.class.getDeclaredMethods())
                .anyMatch(method -> Modifier.isAbstract(method.getModifiers())
                        && method.getReturnType().equals(AudioDecoder.class)
                        && Arrays.asList(method.getParameterTypes()).contains(byte[].class));
        assertTrue(hasCreateDecoderMethod,
                "If the abstract factory class is implemented correctly, it should have a method to create a decoder that takes a byte[] parameter and returns an AudioDecoder.");

        boolean hasCreatePlayerMethod = Arrays.stream(AudioFactory.class.getDeclaredMethods())
                .anyMatch(method -> Modifier.isAbstract(method.getModifiers())
                        && method.getReturnType().equals(AudioPlayer.class)
                        && Arrays.asList(method.getParameterTypes()).contains(int.class)
                        && Arrays.asList(method.getParameterTypes()).contains(double.class));
        assertTrue(hasCreatePlayerMethod,
                "If the abstract factory class is implemented correctly, it should have a method to create a player that takes an int parameter for the volume and a double parameter for the playback rate and returns an AudioPlayer.");

    }

    @Test
    public void testAudioProcessorCreateMethodInvocation() {
        // Get all methods in AudioFactory
        Method[] methods = AudioFactory.class.getDeclaredMethods();

        // Check if any method is returning a AudioProcessor
        Method createMethod = Arrays.stream(methods)
                .filter(method -> method.getReturnType().equals(AudioProcessor.class)
                        && Arrays.asList(method.getParameterTypes()).contains(byte[].class))
                .findFirst()
                .orElse(null);

        assertNotNull(createMethod,
                "If the abstract factory is implemented correctly, it should have a method to create an audio processor that takes a byte[] parameter and returns an AudioProcessor.");

        byte[] audioData = new byte[0];

        // Invoke the create method with parameters in different orders
        AudioProcessor processor = null;

        try {
            processor = (AudioProcessor) createMethod.invoke(new MP3AudioFactory(), (Object) audioData);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            fail("If the abstract factory is implemented correctly, the create method for an audio processor should take a byte[] parameter and return an AudioProcessor.");
        }

        // Verify that the returned processors are not null and match the expected type
        assertNotNull(processor,
                "If the abstract factory is implemented correctly, the create method for an audio processor should return a non-null AudioProcessor.");
        assertEquals(MediaFormat.MP3, processor.supportsFormat(),
                "If the factory is implemented correctly, the create method should return a MP3Processor for an MP3 audio.");

    }

    @Test
    public void testAudioDecoderCreateMethodInvocation() {
        // Get all methods in AudioFactory
        Method[] methods = AudioFactory.class.getDeclaredMethods();

        // Check if any method is returning a DocumentProcessor
        Method createMethod = Arrays.stream(methods)
                .filter(method -> method.getReturnType().equals(AudioDecoder.class)
                        && Arrays.asList(method.getParameterTypes()).contains(byte[].class))
                .findFirst()
                .orElse(null);

        assertNotNull(createMethod,
                "If the abstract factory is implemented correctly, it should have a method to create an audio decoder that takes a byte[] parameter and returns an AudioDecoder.");

        byte[] audioData = new byte[0];

        // Invoke the create method with parameters in different orders
        AudioDecoder decoder = null;

        try {
            decoder = (AudioDecoder) createMethod.invoke(new MP3AudioFactory(), (Object) audioData);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            fail("If the abstract factory is implemented correctly, the create method for an audio decoder should take a byte[] parameter and return an AudioDecoder.");
        }

        // Verify that the returned processors are not null and match the expected type
        assertNotNull(decoder,
                "If the abstract factory is implemented correctly, the create method for an audio decoder should return a non-null AudioDecoder.");
        assertEquals(MediaFormat.MP3, decoder.supportsFormat(),
                "If the factory is implemented correctly, the create method should return a MP3Decoder for an MP3 audio.");

    }

    @Test
    public void testAudioPlayerCreateMethodInvocation() {
        // Get all methods in AudioFactory
        Method[] methods = AudioFactory.class.getDeclaredMethods();

        // Check if any method is returning a AudioPlayer
        Method createMethod = Arrays.stream(methods)
                .filter(method -> method.getReturnType().equals(AudioPlayer.class)
                        && Arrays.asList(method.getParameterTypes()).contains(int.class)
                        && Arrays.asList(method.getParameterTypes()).contains(double.class))
                .findFirst()
                .orElse(null);

        assertNotNull(createMethod,
                "If the abstract factory is implemented correctly, it should have a method to create an audio player that takes an int parameter for the volume and a double parameter for the playback rate and returns an AudioPlayer.");

        // Invoke the create method with parameters in different orders
        AudioPlayer player = null;
        int volume = 0;
        double rate = 0.0;

        try {
            player = (AudioPlayer) createMethod.invoke(new MP3AudioFactory(), volume, rate);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            fail("If the abstract factory is implemented correctly, the create method for an audio player should take an int parameter for the volume and a double parameter for the playback rate and return an AudioPlayer.");
        }

        // Verify that the returned processors are not null and match the expected type
        assertNotNull(player,
                "If the abstract factory is implemented correctly, the create method for a player should return a non-null AudioPlayer.");
        assertEquals(MediaFormat.MP3, player.supportsFormat(),
                "If the factory is implemented correctly, the create method should take an int parameter for the volume and a double parameter for the playback rate and return a MP3Player for an MP3 audio.");

    }

}