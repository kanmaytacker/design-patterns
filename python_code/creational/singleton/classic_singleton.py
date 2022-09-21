class Singleton:
    def __new__(cls, *args):
        if not hasattr(cls, 'instance'):
            cls.instance = super(Singleton, cls).__new__(cls)
        return cls.instance

class SingletonChild(Singleton):
    pass

s = Singleton() # newly created instance
s1 = Singleton() # returned the previously created instance - s
print(f"{s=}\n{s1=}")

child = SingletonChild()
print(child is s)
 
print(f"{s=}\n{child=}")