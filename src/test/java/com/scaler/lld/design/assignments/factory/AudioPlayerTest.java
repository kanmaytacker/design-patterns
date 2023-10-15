package com.scaler.lld.design.assignments.factory;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AudioPlayerTest {

    @Test
    public void testParentClass() {
        // Define the package where your processors are located
        String packageName = AudioPlayerTest.class.getPackageName();

        // Get all subtypes of AudioPlayer using reflection
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<? extends AudioPlayer>> subTypes = reflections.getSubTypesOf(AudioPlayer.class);

        // Ensure there is at least one subclass
        assertEquals(3, subTypes.size(),
                "If the factory is implemented correctly, there should be 3 concrete product classes of AudioPlayer.");

        // Check if AudioPlayer has the required methods and fields
        boolean hasVolume = Arrays.stream(AudioPlayer.class.getDeclaredFields())
                .anyMatch(field -> field.getType().equals(int.class) || field.getType().equals(Integer.class));
        assertTrue(hasVolume,
                "If the parent class is implemented correctly, it should have a field of type int or Integer to store the volume.");

        boolean hasPlaybackRate = Arrays.stream(AudioPlayer.class.getDeclaredFields())
                .anyMatch(field -> field.getType().equals(double.class) || field.getType().equals(Double.class));

        assertTrue(hasPlaybackRate,
                "If the parent class is implemented correctly, it should have a field of type double or Double to store the playback rate.");

        boolean hasSupportsType = Arrays.stream(AudioPlayer.class.getDeclaredMethods())
                .anyMatch(method -> method.getName().equals("supportsType")
                        && method.getParameterCount() == 0
                        && method.getReturnType().equals(MediaFormat.class)
                        && Modifier.isAbstract(method.getModifiers()));
        assertTrue(hasSupportsType,
                "If the parent class is implemented correctly, it should have a method called supportsType with no parameters and MediaFormat return type.");


        boolean hasPlay = Arrays.stream(AudioPlayer.class.getDeclaredMethods())
                .anyMatch(method -> method.getName().equals("play")
                        && method.getParameterCount() == 0
                        && method.getReturnType().equals(void.class)
                        && Modifier.isAbstract(method.getModifiers()));
        assertTrue(hasPlay,
                "If the parent class is implemented correctly, it should have a method called play with no parameters and void return type.");

        boolean hasPause = Arrays.stream(AudioPlayer.class.getDeclaredMethods())
                .anyMatch(method -> method.getName().equals("pause")
                        && method.getParameterCount() == 0
                        && method.getReturnType().equals(void.class)
                        && Modifier.isAbstract(method.getModifiers()));
        assertTrue(hasPause,
                "If the parent class is implemented correctly, it should have a method called pause with no parameters and void return type.");

        boolean hasStop = Arrays.stream(AudioPlayer.class.getDeclaredMethods())
                .anyMatch(method -> method.getName().equals("stop")
                        && method.getParameterCount() == 0
                        && method.getReturnType().equals(void.class)
                        && Modifier.isAbstract(method.getModifiers()));
        assertTrue(hasStop,
                "If the parent class is implemented correctly, it should have a method called stop with no parameters and void return type.");

    }

    @Test
    public void testAudioPlayerFactory() {

        // Check if the AudioPlayerFactory class has a static method to create the
        // audio player
        boolean hasCreateMethod = Arrays.stream(AudioPlayerFactory.class.getDeclaredMethods())
                .anyMatch(method -> Modifier.isStatic(method.getModifiers())
                        && method.getReturnType().equals(AudioPlayer.class)
                        && Arrays.asList(method.getParameterTypes()).contains(MediaFormat.class)
                        && (Arrays.asList(method.getParameterTypes()).contains(int.class) || Arrays.asList(method.getParameterTypes()).contains(Integer.class))
                        && (Arrays.asList(method.getParameterTypes()).contains(double.class) || Arrays.asList(method.getParameterTypes()).contains(Double.class)));

        assertTrue(hasCreateMethod,
                "If the factory is implemented correctly, it should have a static method to create an audio player that takes three parameters: MediaFormat, int volume, and double playbackRate.");
    }

    @Test
    public void testAudioPlayerFactoryCreateMethodInvocation() {
        // Get all methods in AudioPlayerFactory
        Method[] methods = AudioPlayerFactory.class.getDeclaredMethods();

        // Check if any method is a static method that returns AudioPlayer
        Method createMethod = Arrays.stream(methods)
                .filter(method -> Modifier.isStatic(method.getModifiers())
                        && method.getReturnType().equals(AudioPlayer.class)
                        && Arrays.asList(method.getParameterTypes()).contains(MediaFormat.class)
                        && (Arrays.asList(method.getParameterTypes()).contains(int.class) || Arrays.asList(method.getParameterTypes()).contains(Integer.class))
                        && (Arrays.asList(method.getParameterTypes()).contains(double.class) || Arrays.asList(method.getParameterTypes()).contains(Double.class)))
                .findFirst()
                .orElse(null);

        assertNotNull(createMethod, "If the factory is implemented correctly, it should have a static method to create an audio player that takes three parameters: MediaFormat, int volume, and double playbackRate.");

        MediaFormat format = MediaFormat.FLAC;
        int volume = 50;
        double playbackRate = 1.0;

        // Invoke the create method with parameters in different orders
        AudioPlayer player = null;

        try {
            player = (AudioPlayer) createMethod.invoke(null, format, volume, playbackRate);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
            // Swallow the exception and try again with parameters in the reversed order
        }

        if (player == null) {
            try {
                player = (AudioPlayer) createMethod.invoke(null, format, playbackRate, volume);
            } catch (IllegalAccessException | InvocationTargetException ignored) {

            }
        }

        // Verify that the returned players are not null and match the expected type
        assertNotNull(player, "If the factory is implemented correctly, the create method should return a non-null AudioPlayer.");
        assertEquals(MediaFormat.FLAC, player.supportsType(), "If the factory is implemented correctly, the create method should return an AudioPlayer that supports the given MediaFormat.");

    }

}