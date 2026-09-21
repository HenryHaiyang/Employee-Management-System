# Class Design

## Employee

**Type:** Abstract class

### Fields

| Field | Type | Access | Purpose |
|---|---|---|---|
| `name` | String | private | Employee name |
| `id` | long | private | Employee ID |
| `salary` | double | private | Employee salary |
| `totalEmployees` | int | private static | Tracks employee objects created |

### Important Methods

- `Employee(...)`
- `Employee()`
- `setName(...)`
- `setId(...)`
- `setSalary(...)`
- `getName()`
- `getId()`
- `getSalary()`
- `getTotalEmployees()`
- `calculateAnnualBonus()`
- `returnType()`
- `toString()`

The class demonstrates abstraction and encapsulation.

## FullTimeEmployee

**Extends:** `Employee`

### Additional Data

A string array stores possible employee benefits:

- Health insurance
- Paid vacation
- Retirement plan
- Meal subsidy

### Important Methods

- `returnType()`
- `calculateAnnualBonus()`
- `BenefitLottery()`
- `toString()`

The annual bonus is calculated as 5% of salary.

## PartTimeEmployee

**Extends:** `Employee`

### Additional Data

- `hoursWorked`

### Important Methods

- `setHour(...)`
- `getHoursWorked()`
- `returnType()`
- `calculateAnnualBonus()`
- `toString()`

The annual bonus is calculated as 10 times the number of hours worked.

## Department

### Fields

| Field | Type | Purpose |
|---|---|---|
| `employees` | Employee[] | Stores employees |
| `DepartmentSize` | int | Maximum department capacity |
| `numOfEmployee` | int | Number of employees currently added |

### Important Methods

- `addEmployee(Employee)`
- `getArray()`
- `getFullTime()`
- `getPartTime()`
- `searchWithId(long)`
- `countEmployeeTypes()`
- `calculateAverageSalary()`
- `toString()`

The Department class demonstrates object aggregation because it manages an array of Employee objects.

## EmployeeManagementSystem

**Type:** Main program class

### Main Responsibilities

- Maintain the department array
- Display the menu
- Create departments
- Add employees
- Display employees
- Update employee information
- Generate reports
- Validate user input

The main program interacts with the object-oriented classes rather than storing employee data directly in the menu logic.
