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

