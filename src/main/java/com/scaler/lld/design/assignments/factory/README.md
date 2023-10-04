# Simple Factory Pattern for Audio Player

## Problem Statement

You are developing an audio player application that supports different audio formats, such as MP3, WAV, and FLAC. Each audio format requires a specific decoder and player implementation. To keep your audio player extensible and maintainable, you decide to implement the Simple Factory pattern to create audio player objects based on the audio format.

## Assignment

Your task is to implement the Simple Factory pattern to create audio players for different audio formats in the audio player application. The Simple Factory pattern allows you to encapsulate the creation logic of audio player objects, making it easy to add support for new audio formats in the future.

### Task 1 - Creating Audio Player Classes (Product Hierarchy)

Start by creating individual audio player classes for each supported audio format. Each audio player class should implement the same set of methods for playing, pausing, and stopping audio playback. Additionally, each class should have attributes that store information about the audio file, such as the volume and playback rate.

### Task 2 - Implementing the Simple Factory

Next, implement a `AudioPlayerFactory` class that follows the Simple Factory pattern. This class should provide a method to create audio player objects based on the audio format. The factory class should take care of instantiating the appropriate audio player class based on the format provided and the relevant arguments.

### Instructions

1. Implement the `AudioPlayer` class as a common parent class for all audio players. Include attributes and methods that are common to all audio players.

2. Implement the `AudioPlayerFactory` class that implements the Simple Factory pattern. Add a method to create audio player objects based on the audio format and relevant arguments.

3. Run the provided test cases in the `AudioPlayerTest` class to verify the correctness of your implementation. The tests will check if all audio player classes are implemented correctly and if the factory class is able to create audio player objects for different audio formats.