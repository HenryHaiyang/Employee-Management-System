# Pseudocode

## Main Program

```text
BEGIN

CREATE array of Department with maximum size
SET departmentCount = 0

DO
    DISPLAY menu
    GET user choice

    IF choice == 1 THEN
        CREATE new department
        ADD department to array
        INCREASE departmentCount

    ELSE IF choice is between 2 and 7 THEN
        IF no departments exist
            DISPLAY message asking user to create a department
        ELSE
            DISPLAY list of departments
            SELECT a department

            IF choice == 2 THEN
                ADD employee to selected department

            ELSE IF choice == 3 THEN
                DISPLAY all employees

            ELSE IF choice == 4 THEN
                DISPLAY full-time employees

            ELSE IF choice == 5 THEN
                DISPLAY part-time employees

            ELSE IF choice == 6 THEN
                CALCULATE and DISPLAY average salary

            ELSE IF choice == 7 THEN
                SEARCH for employee
                UPDATE employee information
            ENDIF
        ENDIF

    ELSE IF choice == 8 THEN
        GENERATE business report

    ELSE IF choice == 9 THEN
        GENERATE bonus and benefits report

    ELSE IF choice == 0 THEN
        DISPLAY exit message

    ELSE
        DISPLAY invalid choice message
    ENDIF

WHILE choice != 0

END
```

## Employee Creation

```text
GET employee type
GET whether default information should be used

IF default information is selected
    CREATE default employee of selected type
ELSE
    GET name
    GET employee ID
    VALIDATE employee ID
    CHECK for duplicate ID
    GET salary

    IF employee is part-time
        GET hours worked
        CREATE PartTimeEmployee
    ELSE
        CREATE FullTimeEmployee
    ENDIF
ENDIF

ADD employee to department
```

## Employee Update

```text
GET employee ID
SEARCH selected department for the employee

IF employee is not found
    DISPLAY error
ELSE IF employee uses the protected default ID
    DISPLAY error
ELSE
    DISPLAY update options

    IF name is selected
        UPDATE name
    ENDIF

    IF salary is selected
        UPDATE salary
    ENDIF

    IF both are selected
        UPDATE name
        UPDATE salary
    ENDIF

    IF a part-time employee chooses hours
        UPDATE hours worked
    ENDIF
ENDIF
```
