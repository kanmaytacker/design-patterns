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