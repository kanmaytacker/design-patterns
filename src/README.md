# Code Glossary

## Creational Design Patterns

### Singleton
* [Basic Singleton<sup>*</sup>](https://github.com/kanmaytacker/design-patterns/blob/master/src/main/java/com/scaler/lld/design/creational/singleton/ConnectionPool.java)
* [Thread Safe Singleton<sup>*</sup>](https://github.com/kanmaytacker/design-patterns/blob/master/src/main/java/com/scaler/lld/design/creational/singleton/ConnectionPool.java)
* [Singleton with double checked locking](https://github.com/kanmaytacker/design-patterns/blob/master/src/main/java/com/scaler/lld/design/creational/singleton/ConnectionPool.java)
* [Test](https://github.com/kanmaytacker/design-patterns/blob/master/src/test/java/com/scaler/lld/design/creational/singleton/DatabaseConnectionTest.java)

### Builder
* [Constructor with HashMap](https://github.com/kanmaytacker/design-patterns/blob/master/src/main/java/com/scaler/lld/design/creational/builder/student/Student.java)
* [Student builder](https://github.com/kanmaytacker/design-patterns/blob/master/src/main/java/com/scaler/lld/design/creational/builder/student/NewStudent.java)
* [Database builder](https://github.com/kanmaytacker/design-patterns/blob/master/src/main/java/com/scaler/lld/design/creational/builder/database/Database.java)
* [Student builder - Test](https://github.com/kanmaytacker/design-patterns/blob/master/src/test/java/com/scaler/lld/design/creational/builder/student/StudentTest.java)
* [Database builder - Test](https://github.com/kanmaytacker/design-patterns/blob/master/src/test/java/com/scaler/lld/design/creational/builder/database/DatabaseBuilderTest.java)

### Prototype

#### Game - Background and foreground objects
* [Prototype - Game - Clonable Interface](main/java/com/scaler/lld/design/creational/prototype/game/GraphicalObject.java)
* [Prototype - Game - Concrete class](main/java/com/scaler/lld/design/creational/prototype/game/BackgroundObject.java)
* [Prototype - Game - Registry](main/java/com/scaler/lld/design/creational/prototype/game/BackgroundObjectRegistry.java)
* [Test](test/java/com/scaler/lld/design/creational/prototype/game/GameObjectTest.java)


#### Example - ML Model
* [Prototype - ML Model - Clonable Interface](main/java/com/scaler/lld/design/creational/prototype/mlmodel/ObjectClonable.java)
* [Prototype - ML Model - Concrete class](main/java/com/scaler/lld/design/creational/prototype/mlmodel/MLModel.java)
* [Prototype - ML Model - Registry](main/java/com/scaler/lld/design/creational/prototype/mlmodel/ModelRegistry.java)
* [Test](test/java/com/scaler/lld/design/creational/prototype/mlmodel/MLModelTest.java)

### Factory

#### Simple Factory

* [Simple Factory - Button](main/java/com/scaler/lld/design/creational/simplefactory/button/ButtonFactory.java)
* [Simple Factory - Game](main/java/com/scaler/lld/design/creational/simplefactory/game/GameObjectFactory.java)
  * [Test](test/java/com/scaler/lld/design/creational/simplefactory/game/GameObjectTest.java)
* [Simple Factory - Database](main/java/com/scaler/lld/design/creational/simplefactory/database/DatabaseDriverFactory.java)
    * [Test](test/java/com/scaler/lld/design/creational/simplefactory/database/DatabaseDriverTest.java)

#### Factory Method

* [Factory Method - Button](main/java/com/scaler/lld/design/creational/factory/button/)
  * [Test](test/java/com/scaler/lld/design/creational/factory/button/ButtonFactoryTest.java)
* [Factory Method - Game](main/java/com/scaler/lld/design/creational/factory/game/)
  * [Test](test/java/com/scaler/lld/design/creational/factory/game/GameObjectFactoryTest.java)
* [Factory Method - Database](main/java/com/scaler/lld/design/creational/factory/database/)
  * [Test](test/java/com/scaler/lld/design/creational/factory/database/DatabaseFactoryTest.java)

<sup>*</sup> To be updated