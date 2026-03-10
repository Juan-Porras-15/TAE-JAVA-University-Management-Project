# University Tracking System - Java TAE Final Project
# Project Overview:
This system manages university operations, including tracking classes, teachers, and students. It is built with a focus on SOLID principles and Clean Code architecture.

# ASCII Final Class Diagram:
```
       +-----------------------------------------------------------+
       |                        University                         |
       +-----------------------------------------------------------+
       | - List<Teacher> teachers                                  |
       | - List<Student> students                                  |
       | - List<UniversityClass> classes                           |
       +-----------------------------------------------------------+
       | + getClassesByStudentId(int): List<UniversityClass>       |
       +-------------------------+---------------------------------+
                                 |
         +-----------------------+-----------------------+
         |                       |                       |
+--------v-------+      +--------v-------+      +--------v--------+
|    Teacher     |      |    Student     |      | UniversityClass |
|   (Abstract)   |      +----------------+      +-----------------+
+----------------+      | - static idCnt |      | - String name   |
| - String name  |      | - int id       |      | - String room   |
| - double base  |      | - String name  |      | - Teacher prof  |
+----------------+      | - int age      |      | - List<Student> |
| + calcSalary()*|      +----------------+      +-----------------+
+--------^-------+
         |
    +----+-------+
    |            |
+---+----+   +---+----+
|FullTime|   |PartTime|
+--------+   +--------+
```

# Key Technical Implementation:
- **Inheritance & Polymorphism:** Used an abstract Teacher class with specialized salary calculations for Full-Time (experience-based) and Part-Time (hours-based) staff.
- **Static Management:** Implemented a static counter in the Student class for automatic, unique ID generation.
- **Encapsulation:** All data model attributes are private, accessed only via public methods.
- **Robust I/O:** A dedicated InputValidator handles all console exceptions (letters in numeric fields, negatives, etc.).

# Branching Strategy
This project follows a variant of **Trunk-Based Development**
- **Short-lived Feature Branches:** All changes made where done in an independent short-living branch.
- **Disclaimer:** I'm aware that the main objective of this branching strategy approach is the continues delivery, nonetheless since its sucha simple project I did not follow this principal fully. Instead, I used branch to safely integrate new code in an organiced way but not neccesarilly did full continous delivery.
- **Persistence:** Contrary to standard practice, feature branches were not deleted after merging to main. This was done specifically to provide evidence of multi-branch usage as requested in the project guidelines.

