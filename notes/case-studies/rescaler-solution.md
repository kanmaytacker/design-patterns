# ReScaler - A case study

## Version 1
Following are the requirements of the ReScaler application:
* A student should be able to login with their email address and password.
* Students should be able to view their profile which includes their name, email address and phone number.

### Solution

#### Class Diagram

```mermaid
classDiagram
    class Student {
        -String name
        -String email
        -String phone
        -String password
        +getName() String
        +getEmail() String
        +getPhone() String
        }
```

### Database Schema

```mermaid
erDiagram
    STUDENT {
        int id PK
        string email
        string name
        string phone
        string password
    }
```
---

## Version 2

* We will provide multiple courses as a part of the ReScaler application.
* Every student can enroll for a single course.
* Every course has a name.

### Solution 1 - Course Name as an attribute

#### Class Diagram

```mermaid
classDiagram
    class Student {
        -String name
        -String email
        -String phone
        -String password
        -String courseName
        +getName() String
        +getEmail() String
        +getPhone() String
        }
```

#### Database Schema

```mermaid
erDiagram
    STUDENT {
        int id PK
        string email
        string name
        string phone
        string password
        string courseName
    }
```

Disadvantages:
* The student can only enroll for a single course.
* Course name is duplicated for every student in the same course. This is a waste of space.
* Updating the course name for all the students is a tedious task.
* Course cannot exist without a student. Our design is subject to database anomalies.

### Solution 2 - Course as a separate entity

#### Class Diagram

```mermaid
classDiagram
    class Student {
        -String name
        -String email
        -String phone
        -String password
        +getName() String
        +getEmail() String
        +getPhone() String
        }
    class Course {
        -String name
        }
    Student "*" --o "1" Course : Enrolled in
```
#### Database Schema

```mermaid
erDiagram
    STUDENT {
        int id PK
        string email
        string name
        string phone
        string password
        int courseId FK
    }
    COURSE {
        int id PK
        string name
    }

    STUDENT ||--o{ COURSE : "enrolled in"
```

---

## Version 3
* Each student can enroll for **exactly 4** courses

### Solution 1 - Multiple course ID columns

#### Class Diagram

```mermaid
classDiagram
    class Student {
        -String name
        -String email
        -String phone
        -String password
        -Course[] courses
        +getName() String
        +getEmail() String
        +getPhone() String
        }

    class Course {
        -String name
        }
    
    Student "*" --o "*" Course : Enrolled in
```

#### Database Schema

```mermaid
erDiagram
    STUDENT {
        int id PK
        string email
        string name
        string phone
        string password
        int courseId1 FK
        int courseId2 FK
        int courseId3 FK
        int courseId4 FK
    }
    COURSE {
        int id PK
        string name
    }

    STUDENT ||--o{ COURSE : "enrolled in"
```

Disadvantages:
* `Extensibility` - The student can enroll for only 4 courses.
* `Querying` - We need to write a query to get all the course columns for a student to identify the courses they are enrolled in.

### Solution 2 - Separate table for student-course mapping

#### Class Diagram

```mermaid
classDiagram
    class Student {
        -String name
        -String email
        -String phone
        -String password
        -Course[] courses
        +getName() String
        +getEmail() String
        +getPhone() String
        }

    class Course {
        -String name
        }
    
    Student "*" --o "*" Course : Enrolled in
```

#### Database Schema

```mermaid
erDiagram
    STUDENT {
        int id PK
        string email
        string name
        string phone
        string password
    }
    COURSE {
        int id PK
        string name
    }
    STUDENT_COURSE {
        int studentId FK
        int courseId FK
    }

    STUDENT ||--|{ STUDENT_COURSE : "enrolled in"
    COURSE ||--|{ STUDENT_COURSE : "has"
```

