## Classic Singleton:

Classic Singleton creates an instance only if there is no instance created so far; otherwise, it will return the instance that is already created. 

```python
class Singleton:
    def __new__(cls, *args):
        if not hasattr(cls, 'instance'):
            cls.instance = super(Singleton, cls).__new__(cls)
        return cls.instance

s = Singleton() # newly created instance
s1 = Singleton() # returned the previously created instance - s
print(f"{s=}\n{s1}")
```

In the preceding snippet `__new__` magic method was overridden to control objects creation. `s` object got created with the `__new__` method while `s1` returns the previously created object instance. The logic behind the snippet is that `hasattr` builtin function checks if the object class to be created has an instance attribute, if it doesn't, a new object will be created, and if it does have instance attribute, the previously created object will be returned. You'll also notice that the `id` of both objects are the same. The results are shown below:

```
s=<__main__.Singleton object at 0x7fe9df1986d0>
s1=<__main__.Singleton object at 0x7fe9df1986d0>
```

Let’s check what happens when we subclass a singleton class. 

```python
class Singleton:
    def __new__(cls, *args):
        if not hasattr(cls, 'instance'):
            cls.instance = super(Singleton, cls).__new__(cls)
        return cls.instance

class SingletonChild(Singleton):
    pass

child = SingletonChild()
print(child is s)
 
print(f"{s=}\n{child=}")
```

The output is

```
True
s=<__main__.Singleton object at 0x7fdb9b4cfeb0>
child=<__main__.Singleton object at 0x7fdb9b4cfeb0>
```

Here, you can see that SingletonChild has the same instance of Singleton and also shares the same state. But there are scenarios, where we need a different instance, but should share the same state. This state sharing can be achieved using *Borg or Monostate pattern*.

## Borg or Monostate pattern:

Python uses `__dict__` to store the state of every object of a class and that is what we will manipulate to share the state across all objects of a class. Below is the implementation.

```python
class Borg:                                                                   
    __shared_state = {'borg': 'Monostate'}                                    
    def __init__(self):                                                       
        self.x = 'Design Pattern'                                             
        self.__dict__ = self.__shared_state                                   
        pass

b = Borg()
b1 = Borg()
b.x = 2100
print(f"b {b.__dict__}, {b.x=}")
print(f"b1 {b1.__dict__}, {b1.x=}")
```

The output is:

```
b {'borg': 'Monostate', 'x': 2100}, b.x=2100
b1 {'borg': 'Monostate', 'x': 2100}, b1.x=2100
```

## Using Metaclasses:

A metaclass is a class of class. It is through metaclass that programmers are able to create their classes from python predefined classes. As a matter of fact, everything in python is an object.

As metaclass has more control over class creation and object instantiation, it can be used to create Singletons. Metaclasses in python override the `__new__` and `__init__` or `__call__` magic methods. Below is the sample code for Singleton implementation with metaclasses.

```python
class MetaSingleton(type):
    _instances = {}
    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super(MetaSingleton, cls).__call__(*args, **kwargs)
        return cls._instances[cls]

class Logger(metaclass=MetaSingleton):
    pass

log1 = Logger()
log2 = Logger()
print(f"{log1=}\n{log2=}")
```

The output is 

```
log1=<__main__.Logger object at 0x7f5e89a79450>
log2=<__main__.Logger object at 0x7f5e89a79450>
```

## References:
[Singleton Pattern in Python - I](https://www.geeksforgeeks.org/singleton-pattern-in-python-a-complete-guide/) \
[Singleton Pattern in Python - II](https://iq.opengenus.org/singleton-design-in-python/)
