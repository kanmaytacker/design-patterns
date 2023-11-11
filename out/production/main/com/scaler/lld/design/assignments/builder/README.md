# Builder Pattern Implementation for a database configuration class

## Problem Statement

You are tasked with creating a system-wide database configuration for a complex software suite. The configuration is responsible for managing various configuration settings that affect the data layer. To ensure a flexible and readable way to create configuration instances that are immutable, you decide to implement the Builder pattern.

## Assignment

Your task is to implement the Builder pattern to create instances of a configuration manager class. The Builder pattern allows for step-by-step construction of complex objects while keeping the creation process separate from the main object.

## Implementing the Builder Pattern

1. `Review the original class` - You have been provided with a class that represents the database configuration `DatabaseConfiguration`. The class has a number of properties that are used to configure the database connection. Your task is to implement the Builder pattern to create instances of a class with the same properties.

2. `Create the builder class` - Create a new class called `DatabaseConfigurationBuilder` that will implement the builder patter. A dummy class has been provided for you to start with. Remember to annotate the class with the `@WithBuilder` annotation. The name does not matter as long as it is annotated.

3. `Test your implementation` - A test case has been provided for you to test your implementation. Run the test case to ensure that your implementation is correct. This will pick the correct implementation of the builder class based on the `@WithBuilder` annotation.

## Instructions
1. Clone this repository to your local machine.
2. Create a new class annotated with the `@WithBuilder` annotation.
3. Implement the builder pattern within your class.
4. Run the provided test cases in the `DatabaseConfigurationBuilderTest` class to verify the correctness of your implementation.