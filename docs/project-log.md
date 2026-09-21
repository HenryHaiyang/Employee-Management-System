# Project Development Log

## April 30, 2026 — Day 1

### Work Completed

- Created the general project plan and timeline.
- Developed pseudocode for the main program and class structure.
- Built the Employee class hierarchy.
- Built the Department class.
- Added fields, constructors, methods, access modifiers, getters, setters, and `toString()`.
- Added annual bonus calculations.
- Added a random benefit lottery for full-time employees.
- Built the first main-program menu options.
- Created an array capable of storing five departments.
- Implemented department creation and employee creation.
- Added full-time and part-time employee selection.

### Issues and Solutions

- The Employee array needed to distinguish employee types without relying on `instanceof`. This was handled through polymorphic `returnType()`.
- The Department `toString()` method was completed.
- Access modifiers were reviewed to support encapsulation.
- Employee IDs were changed from `int` to `long`.
- The use of `@Override` for implementations of abstract methods was confirmed during development.

## May 1, 2026 — Day 2

### Work Completed

- Added default employees for both employee types.
- Default employees use a shared reference ID and salary and receive randomly generated names.
- Completed menu options for displaying employees, filtering by type, calculating average salary, and generating reports.
- Added a business report showing employee totals, employee types, and average salary.
- Added null checks for unused positions in employee arrays.
- Moved average salary calculation into the Department class.

### Design Notes

The program initially did not use static state for employee counting. The employee count was later incorporated into the Employee class.

## May 2, 2026 — Day 3

### Work Completed

- Added employee searching by ID.
- Added employee information updates.
- Prevented updates to the default employee.
- Added the ability to update names, salaries, and part-time hours.
- Added setters and getters for encapsulation.
- Improved handling of null positions during ID searches.
- Changed hours worked to a double value to support non-integer hours.
- Added downcasting when part-time-specific functionality is required.
- Added sample output.
- Continued commenting and improved console formatting.

## May 3, 2026 — Day 4

### Work Completed

- Added custom integer input validation through `parseInt()`.
- Added repeated input prompts for invalid integer values.
- Created detailed error messages for invalid input.
- Improved the robustness of menu and numeric input handling.

## May 4, 2026 — Day 5

### Work Completed

- Completed detailed comments throughout the project.
- Added class and method documentation.
- Documented parameters, return values, and functionality.
- Added the bonus and benefits report as a new menu feature.
- Used polymorphism and downcasting to provide full-time-specific benefit information.

## May 5, 2026 — Day 6

### Work Completed

- Completed the final version.
- Prepared detailed output and project presentation material.
- Fixed a bug in the update option where choosing both name and salary could result in only one update because of an incorrect `if/if/else` structure.
- Changed the update logic to use independent conditions.
- Formatted bonus values to two decimal places.
- Changed the invalid-input sentinel from `-1` to `Integer.MIN_VALUE`, because negative integers such as `-1` are valid input values.
- Revised comments to match the final implementation.

## Final Result

The completed project demonstrates a full object-oriented employee management system with department management, employee searching and updating, input validation, salary calculations, bonus calculations, and reporting features.
