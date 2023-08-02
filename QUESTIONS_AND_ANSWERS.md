# Design pattern questions and answers

## Questions

1. Joe Bloggs has to create a class to load a huge configuration file. There can be memory issues if the file is loaded multiple times. If there are multiple instances, there can also be inconsistencies. Which design pattern can he use?
    - [ ] Factory
    - [ ] Builder
    - [ ] Singleton
    - [ ] Prototype
---

2. Which implementation of the Singleton pattern is used in the following code snippet?

```java
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
 - [ ] Lazy initialization
 - [ ] Eager initialization
 - [ ] Thread-safe initialization
 - [ ] Double-checked locking
---
3. What is the problem with the implementation of the Singleton pattern in Question 2?

 - [ ] It is not performant
 - [ ] It is not thread-safe
 - [ ] It does not create a single instance
 - [ ] It uses a lot of memory

----
4. Which implementation of the Singleton pattern is used in the following code snippet?
```java
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
```

 - [ ] Lazy initialization
 - [ ] Eager initialization
 - [ ] Thread-safe initialization
 - [ ] Double-checked locking
---
5. What is the problem with the implementation of the Singleton pattern in Question 4?

 - [ ] It is not performant
 - [ ] It is not thread-safe
 - [ ] It does not create a single instance
 - [ ] It does not allow dynamic initialization i.e. pass arguments to the constructor

---
6. What is the problem with using a synchronized method to implement the Singleton pattern as below?


```java
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
 - [ ] It is not performant
 - [ ] It is not thread-safe
 - [ ] It does not create a single instance
 - [ ] It uses a lot of memory

---
7. How do you fix the problem in Question 6?

 - [ ] Use a synchronized block
 - [ ] Use double-checked locking
 - [ ] Use a static block
 - [ ] Use a static variable
---
8.  Joe Bloggs is developing a complex configuration object for a software system. The configuration object has over 60 properties, and creating instances of it using a traditional constructor has become unwieldy and error-prone. Additionally, the configuration objects should be immutable to ensure consistency throughout the application. Which design pattern should Joe use to address these challenges?
 - [ ] Factory
 - [ ] Builder
 - [ ] Singleton
 - [ ] Prototype
---
9. Joe Bloggs has to integrate Uber with different insurance providers. Each provider has a different set of APIs and data formats. He wants to just use one format in the codebase. Adding new providers should also be easy. What design pattern can he use?
- [ ] Factory
- [ ] Builder
- [ ] Adapter
- [ ] Facade
---
10.   Joe Bloggs wants to implement a simulation application. You can add different layers such as brightness, hue, saturation, etc. You can also add different filters such as sepia, black and white, etc. What design pattern can he use to implement this?
- [ ] Factory
- [ ] Decorator
- [ ] Adapter
- [ ] Builder
---

## Answers
1. Singleton (C)
2. Lazy initialization (A)
3. It is not thread-safe (B)
4. Eager initialization (B)
5. It does not allow dynamic initialization i.e. pass arguments to the constructor (D)
6. It is not performant (A)
7. Use double-checked locking (B)
8. Builder (B)
9. Adapter (C)
10. Decorator (B)
---


