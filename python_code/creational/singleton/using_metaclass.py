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
