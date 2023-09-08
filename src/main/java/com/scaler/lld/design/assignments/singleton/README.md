# File based configuration manager

## Problem Statement

You are tasked with creating a system-wide configuration manager for a complex software suite. The configuration manager is responsible for managing various configuration settings that affect the behavior and appearance of the software. To prevent multiple instances of the configuration manager, which could lead to inconsistencies and potential resource conflicts, you need to implement a design pattern that ensures the configuration manager is a singleton object.


## Assignment

You are required to extend an abstract class `FileBasedConfigurationManager` to implement the Singleton design pattern and create a configuration manager class. The abstract class provides a foundation for managing configuration settings using a file-based approach.

### Part 1: Implementing Singleton and Extending Abstract Class

1. **Extend the `FileBasedConfigurationManager` abstract class**: You already have an abstract class named `FileBasedConfigurationManager`. Your task is to extend this class to create your own configuration manager class.

2. **Implement the Singleton design pattern**: Within your configuration manager class, implement the Singleton design pattern to ensure that only one instance of your class can exist within the program.

3. **Implement the `getInstance()` and `resetInstance()` methods**: Implement the `getInstance()` and `resetInstance()` methods in your configuration manager class. The `getInstance()` method should return the singleton instance of your configuration manager class. The `resetInstance()` method should reset the singleton instance of your configuration manager class to `null`.

### Part 2: Configuration Management

The `FileBasedConfigurationManager` abstract class provides a foundation for managing configuration settings using a file-based approach.

It already has a `load` method that loads configuration settings from a file and stores it in a `Properties` object. The `Properties` object is a collection of key-value pairs, where the key is a string and the value is an object.

Implement the following methods for configuration management in your extended class:

- `String getConfiguration(String key)`: Retrieve a configuration value based on a given key.
- `<T> T getConfiguration(String key, Class<T> type)`: Retrieve a configuration value and perform type conversion.
- `void setConfiguration(String key, String value)`: Set a configuration value.
- `<T> void setConfiguration(String key, T value)`: Set a configuration value with type checking.
- `void removeConfiguration(String key)`: Remove a configuration value based on a given key.
- `void clear()`: Clear all configuration settings.

## Instructions

1. Clone this repository to your local machine.
2. Extend the `FileBasedConfigurationManager` abstract class to create your own configuration manager class.
3. Implement the required methods within your configuration manager class.
4. Run the provided test cases in the `FileBasedConfigurationManagerTest` class to verify the correctness of your implementation.