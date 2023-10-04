### Abstract Factory Pattern for Audio Players

## Problem Statement

You are designing an audio player application. The application should support different audio formats such as MP3, WAV, and FLAC. Each format requires specific decoding, processing, and rendering steps. You want to create instances of these processing steps without explicitly specifying their classes and ensure that the steps within the same format family are compatible.

## Assignment

Your task is to extend the Abstract Factory pattern to create audio processing components in the audio player application. The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes, allowing for easy addition of new audio format processor types and ensuring compatibility within families.

### Task 1 - Adding the factory methods to the abstract factory

The abstract factory class `AudioFactory` has been created for you. You will need to add the factory methods to create audio decoders, processors, and renderers to the abstract factory class. The method `supportsFormat` has already been abstracted out for you as an example. You will need to implement the `AudioFactory` class as a common parent class for all the audio format factories.

### Task 2 - Implementing the Abstract Factory

Now that you have the abstract factory class, you will need to implement the abstract factory for different audio formats such as MP3, WAV, and FLAC. Three classes have been created for you: `Mp3AudioFactory`, `WavAudioFactory`, and `FlacAudioFactory`. You will need to implement the methods to create compatible audio decoders, processors, and renderers. Ensure that the created components are compatible within the same format family.

### Instructions

1. Implement the `AudioFactory` interface with methods to create audio decoders, processors, and renderers.

2. Create concrete implementations of the `AudioFactory` interface for MP3, WAV, and FLAC audio formats. Implement the methods to create compatible audio decoders, processors, and renderers.

3. Run the provided test cases in the `AudioFactoryTest` class to verify the correctness of your implementation. The tests will check if all audio components have a common parent class, and if the factory classes can correctly create audio decoders, processors, and renderers based on the audio format.