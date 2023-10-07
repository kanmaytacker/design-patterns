# Design patterns - Questions and answers

1. Joe Bloggs is designing a pricing calculator for a ride-sharing app. The pricing structure involves different algorithms, such as distance-based pricing, time-based pricing, and surge pricing during peak hours. Joe wants to create a pricing calculation system that can seamlessly switch between different pricing strategies and accommodate future adjustments. What design pattern aligns with Joe's pricing calculation requirements?

- [ ] A. Decorator
- [ ] B. Strategy
- [ ] C. Observer
- [ ] D. Factory

2. Joe Bloggs is working on a graphical editing software. The application must support rendering text with different fonts, sizes, and colors. The application must also support rendering images with different dimensions and formats. Joe is concerned about the memory overhead of creating multiple text and image objects with the same state. Which design pattern should Joe use to achieve efficient memory usage?

- [ ] A. Prototype
- [ ] B. Facade
- [ ] C. Flyweight
- [ ] D. Adapter

3. Joe Bloggs is developing a RESTful API for an e-commerce platform. He wants to add logging functionality to track incoming requests, their payloads, and response statuses. Joe aims to implement this logging without cluttering the main API code with repetitive logging statements. Which design pattern can Joe use to wrap the API endpoints with logging behavior?

- [ ] A. Decorator
- [ ] B. Facade
- [ ] C. Adapter
- [ ] D. Strategy

4. Joe Bloggs is building a game development framework. Different game levels have distinct challenges and environments, requiring unique objects like enemies and power-ups. Joe needs a way to create these level-specific objects without directly instantiating them in the game code. Which design pattern is suitable for solving this problem and avoiding tight coupling?

- [ ] A. Singleton
- [ ] B. Factory
- [ ] C. Prototype
- [ ] D. Builder

5. Joe Bloggs is building a weather app that gathers data from different weather data providers. Each provider offers data in a different format and exposes distinct APIs. Joe aims to normalize the data format and ensure seamless integration with new weather data sources in the future. Which design pattern should Joe use to achieve these goals?

- [ ] A. Adapter
- [ ] B. Facade
- [ ] C. Decorator
- [ ] D. Observer

6. Joe Bloggs is developing a software application for data analysis. The application involves data collection, preprocessing, analysis algorithms, and visualization. The interactions between these components can become complex. Joe wants to provide a simplified interface for data analysts to perform end-to-end analysis tasks without dealing with the inner workings of each component. Which design pattern is suitable for this scenario?

- [ ] A. Strategy
- [ ] B. Adapter
- [ ] C. Facade
- [ ] D. Observer

7. Joe Bloggs is building a task management application. Users can create tasks and assign them to different team members. Joe wants to implement a feature where team members receive notifications whenever they are assigned a new task or when the due date of a task is approaching. The notifications should be sent through various communication channels, such as in-app alerts, emails, and Slack messages. Which design pattern can Joe use to implement this real-time task notification system?

- [ ] A. Observer
- [ ] B. Adapter
- [ ] C. Facade
- [ ] D. Strategy

8. Joe Bloggs is developing a logging module for a large application. The logging module needs to maintain a single log file throughout the application's execution to avoid file access conflicts and ensure consistency. Which design pattern is suitable for this scenario?

- [ ] A. Singleton
- [ ] B. Factory
- [ ] C. Prototype
- [ ] D. Builder

9. Joe Bloggs is working on testing a user API for a social media platform. Each test case requires generating multiple mock users with different attributes to simulate various scenarios. However, calling the API to create each mock user is time-consuming and inefficient. To optimize the user creation process during testing, which design pattern can Joe use?

- [ ] A. Singleton
- [ ] B. Factory
- [ ] C. Prototype
- [ ] D. Builder

10. Joe Bloggs is developing a messaging application with support for various message types, including text, images, audio, and video. Each message type can have additional attributes and settings, such as delivery status and timestamps. The current approach of creating message objects using multiple overloaded constructors has become error-prone and challenging to maintain. What design pattern can Joe use to streamline the creation of message objects with different configurations?

---

## Answers

1. B (Strategy)
2. C (Flyweight)
3. A (Decorator)
4. B (Factory)
5. A (Adapter)
6. C (Facade)
7. A (Observer)
8. A (Singleton)
9. C (Prototype)
10. D (Builder)
   