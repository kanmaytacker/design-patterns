# Facade pattern for a travel booking platform

## Problem Statement
You are working on an online booking platform for travel accommodations. The platform needs to handle bookings, payments, and notifications through different external services. The goal is to provide a simplified interface for customers and internal modules to perform booking-related tasks without directly dealing with the intricacies of each external service.

## Assignment
Your task is to implement the Facade pattern to refactor the existing `BookingManager` class. The `BookingManager` class has multiple dependencies and methods that handle bookings, payments, and notifications. Your goal is to create a facade class that provides a unified and simplified interface for these complex operations.

## Implementing the Facade Pattern

1. **Review the original class**: Take a closer look at the `BookingManager` class and its methods. Understand the dependencies it uses and the interactions with external services.

2. **Create the facade class**: Create a new class called `BookingFacade` that implements the Facade pattern. This class will encapsulate the complex interactions with the external services and provide a simplified interface for clients.

3. **Remember to call the constructor of your facade using the same arguments from the BookingManager class**: The constructor of your `BookingFacade` class should take the same arguments that the `BookingManager` class constructor does. This allows you to pass the necessary dependencies to the facade.

4. **Test your implementation**: Test cases have been provided for you to test your implementation. Run the test cases to ensure that your facade class works correctly and provides the expected functionality.

## Instructions
1. Clone this repository to your local machine.
2. Create a new class named `BookingFacade`.
3. Implement the Facade pattern within your `BookingFacade` class to encapsulate interactions with external services.
4. Ensure that your `BookingFacade` constructor takes the same arguments as the `BookingManager` constructor.
5. Run the provided test cases in the `BookingManagerTest` class to verify the correctness of your implementation.