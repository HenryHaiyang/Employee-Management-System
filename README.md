# Employment Management System

**Authors:** Henry Guo & Ray  
**Date:** May 5, 2026  
**Language:** Java

A high-school Java project implementing a console-based employment management system. The program demonstrates object-oriented programming through an abstract `Employee` class, concrete full-time and part-time employee classes, and a `Department` class that manages employee collections.

## Features

- Create departments with configurable employee capacities
- Add full-time and part-time employees
- Use default employee profiles or custom employee information
- Display all employees in a department
- Filter employees by employment type
- Search for employees by ID
- Calculate average salary
- Update employee information
- Generate a business summary report
- Generate an employee bonus and benefits report
- Validate integer input with a custom parser
- Randomly assign a benefit to full-time employees in the benefits report

## Object-Oriented Concepts

- **Abstraction:** `Employee` is an abstract superclass.
- **Inheritance:** `FullTimeEmployee` and `PartTimeEmployee` extend `Employee`.
- **Polymorphism:** Employee objects are stored through the `Employee` superclass, while `returnType()` identifies the concrete type.
- **Encapsulation:** Fields are private where appropriate and accessed through getters and setters.
- **Method overriding:** Employee subclasses override abstract methods and `toString()`.
- **Downcasting:** Type-specific functionality uses downcasting where necessary.
- **Arrays and object management:** Departments use employee arrays and the main program uses a department array.
- **Input validation:** A custom `parseInt()` method handles invalid integer input.

## Project Structure

```text
Employee-Management-System/
├── README.md
├── .gitignore
├── src/
│   └── EmployeeManagementSystem.java
└── docs/
    ├── class-design.md
    ├── project-log.md
    ├── project-plan.md
    └── pseudocode.md
```

## Menu

1. Create a new department
2. Add a new employee to a specific department
3. Display all employees in one department
4. Display full-time employees in one department
5. Display part-time employees in one department
6. Calculate/display average salary
7. Update employee information
8. Generate a summarizing business report
9. Display employee bonus and benefits report
0. Exit

## Class Overview

### Employee

Abstract superclass containing common employee information such as name, ID, and salary. It also defines the abstract methods used to calculate annual bonuses and identify employee types.

### FullTimeEmployee

Represents full-time employees. Its annual bonus is calculated as 5% of salary. It also contains a list of possible benefits and a benefit lottery feature.

### PartTimeEmployee

Represents part-time employees. Its annual bonus is calculated from the number of hours worked.

### Department

Stores employees in an array and provides operations such as adding employees, finding employees by ID, filtering by employee type, counting employee types, and calculating average salary.

### EmployeeManagementSystem

Contains the main program, menu system, input handling, department creation, employee creation, updating, and report generation.

## Collaboration

The project was completed by two partners:

- **Ray:** Employee hierarchy and Department class development
- **Haiyang:** Main program, menu system, integration, input validation, testing, and final revisions

Both partners contributed to planning, testing, revisions, documentation, and finalization.

## Development Timeline

The project was developed from April 30 to May 5, 2026.

- **Day 1:** Planning, pseudocode, class structure, employee hierarchy, Department class, and initial menu
- **Day 2:** Default employees, department operations, reporting, null handling, and average salary
- **Day 3:** Employee searching and updating
- **Day 4:** Input validation and custom integer parsing
- **Day 5:** Documentation and bonus/benefits reporting
- **Day 6:** Final testing, bug fixes, formatting, and project presentation

See [`docs/project-log.md`](docs/project-log.md) for the detailed development log.

## Running the Program

The project uses standard Java and does not require external libraries.

From the project root:

```bash
javac -d out src/EmployeeManagementSystem.java
java -cp out EmployeeManagementSystem
```

Alternatively, open `src/EmployeeManagementSystem.java` in a Java IDE such as Eclipse and run the `EmployeeManagementSystem` class.

## Notes

This repository preserves the project as a high-school programming project. The implementation intentionally uses arrays and a single Java source file because these were part of the original project requirements and learning objectives.
