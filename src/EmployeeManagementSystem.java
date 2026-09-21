/*
* Employment Management System - Henry & Ray
* Date: May 5, 2026
*
* This program implements a comprehensive employment management system that allows users to:
* - Create departments with specified employee capacities
* - Add full-time and part-time employees to departments
* - Manage employee information (name, ID, salary, hours worked)
* - Generate reports on employees, salaries, bonuses, and benefits
* - Update employee details
*
* The system uses object-oriented principles with an abstract Employee class
* and concrete implementations for FullTimeEmployee and PartTimeEmployee.
* Departments manage collections of employees and provide various query operations.
*/
import java.util.*;
/**
* Abstract base class representing an employee in the system.
* This class provides common attributes and methods for all employee types,
* while requiring subclasses to implement type-specific behavior like bonus
* calculation.
*/
abstract class Employee {
 /** Employee's full name */
 private String name;
 /** Unique employee identification number */
 private long id;
 /** Annual salary in dollars */
 private double salary;
 /** Static counter tracking total number of employees across all instances */
 private static int totalEmployees = 0;
 /**
  * Abstract method to calculate annual bonus.
  * Implementation varies by employee type (full-time vs part-time).
  *
  * @return the calculated annual bonus amount
  */
 abstract double calculateAnnualBonus();
 /**
  * Abstract method to return the type of employee as a string.
  *
  * @return string representation of employee type
  */
 abstract String returnType();
 /**
  * Constructor for creating a custom employee with specified details.
  *
  * @param name   the employee's full name
  * @param id     unique employee ID (typically 5 digits)
  * @param salary annual salary in dollars
  */
 public Employee(String name, long id, double salary) {
   this.name = name;
   this.id = id;
   this.salary = salary;
   totalEmployees++;
 }
 /**
  * Default constructor that creates a randomly named employee with default
  * values.
  * Used for testing or when specific details are not provided.
  * Generates a random name in the format "Kun's fan No. XXXX"
  */
 public Employee() {
   Random rand = new Random();
   this.name = "Kun's fan No." + (rand.nextInt(8999) + 1000); // Set random name id to default name
   this.id = 25025;
   this.salary = 252525.25;
   totalEmployees++;
 }
 // Setter
 /**
  * Sets the employee's name.
  *
  * @param name the new name for the employee
  */
 public void setName(String name) {
   this.name = name;
 }
 /**
  * Sets the employee's ID.
  *
  * @param id the new unique identifier for the employee
  */
 public void setId(long id) {
   this.id = id;
 }
 /**
  * Sets the employee's annual salary.
  *
  * @param salary the new annual salary in dollars
  */
 public void setSalary(double salary) {
   this.salary = salary;
 }
 // Getter
 /**
  * Gets the employee's name.
  *
  * @return the employee's full name
  */
 public String getName() {
   return name;
 }
 /**
  * Gets the employee's ID.
  *
  * @return the employee's unique identifier
  */
 public long getId() {
   return id;
 }
 /**
  * Gets the employee's annual salary.
  *
  * @return the employee's annual salary in dollars
  */
 public double getSalary() {
   return salary;
 }
 /**
  * Gets the total number of employees created across all instances.
  *
  * @return total count of all employees in the system
  */
 public static int getTotalEmployees() {
   return totalEmployees;
 }
 /**
  * Returns a string representation of the employee including name, ID, and
  * salary.
  *
  * @return formatted string with employee details
  */
 public String toString() {
   return "Name: " + name +
       "\nID: " + id +
       "\nSalary: " + salary;
 }
}
// full time
/**
* Represents a full-time employee with benefits and bonus calculation.
* Full-time employees receive a 5% bonus of their salary and are eligible for
* random benefits.
*/
class FullTimeEmployee extends Employee {
 /**
  * Array of available benefits that can be randomly assigned to full-time
  * employees
  */
 private String[] benefits = {
     "Health insurance",
     "Paid vacation",
     "Retirement plan",
     "Meal subsidy"
 };// An array that stores different benefits
 /**
  * Constructor for creating a full-time employee with specified details.
  *
  * @param name   employee's name
  * @param id     employee's ID
  * @param salary employee's annual salary
  */
 public FullTimeEmployee(String name, long id, double salary) {
   super(name, id, salary);
 }
 /**
  * Default constructor for creating a full-time employee with random details.
  */
 public FullTimeEmployee() {
   super();
 }
 /**
  * Returns the type of this employee.
  *
  * @return "FullTimeEmployee"
  */
 @Override
 public String returnType() {
   return "FullTimeEmployee";
 }
 /**
  * Calculates the annual bonus for full-time employees (5% of salary).
  *
  * @return bonus amount (5% of annual salary)
  */
 @Override
 public double calculateAnnualBonus() {
   return 0.05 * super.getSalary(); // bonus is 5% of the base salary
 }
 // Unique feature
 /**
  * Assigns a random benefit to the full-time employee.
  * Uses a random number generator to select from available benefits.
  *
  * @return randomly selected benefit string, or "No benefit (T w T)" if none
  *         selected
  */
 public String BenefitLottery() {
   Random rand = new Random();
   int randNum = rand.nextInt(benefits.length + 1); // Generate random number from 0 to 4
   // return corresponding benefit
   switch (randNum) {
     case 0:
       return benefits[0];
     case 1:
       return benefits[1];
     case 2:
       return benefits[2];
     case 3:
       return benefits[3];
     default:
       return "No benefit (T w T)";
   }
 }
 /**
  * Returns a string representation of the full-time employee including
  * basic info, bonus, and randomly assigned benefit.
  *
  * @return formatted string with employee details
  */
 @Override
 public String toString() {
   return super.toString() +
       "\nBonus: " + String.format("%.2f", calculateAnnualBonus()) +
       "\nBenefit: " + BenefitLottery();
 }
}
// part time
/**
* Represents a part-time employee with hours worked tracking and bonus
* calculation.
* Part-time employees receive $10 per hour worked as bonus and are not eligible
* for benefits.
*/
class PartTimeEmployee extends Employee {
 /** Total number of hours worked by the part-time employee */
 private double hoursWorked;
 /**
  * Constructor for creating a part-time employee with specified details.
  *
  * @param name        employee's name
  * @param id          employee's ID
  * @param salary      employee's hourly or annual rate
  * @param hoursWorked total hours worked
  */
 public PartTimeEmployee(String name, long id, double salary, double hoursWorked) {
   super(name, id, salary);
   this.hoursWorked = hoursWorked;
 }
 /**
  * Default constructor for creating a part-time employee with default hours.
  */
 public PartTimeEmployee() {
   super(); // Call default employee
   this.hoursWorked = 1000;
 }
 /**
  * Sets the total hours worked by the part-time employee.
  *
  * @param hoursWorked new total hours worked
  */
 public void setHour(double hoursWorked) {
   this.hoursWorked = hoursWorked;
 }
 /**
  * Returns the type of this employee.
  *
  * @return "PartTimeEmployee"
  */
 @Override
 public String returnType() {
   return "PartTimeEmployee";
 }
 /**
  * Calculates the annual bonus for part-time employees ($10 per hour worked).
  *
  * @return bonus amount ($10 * hours worked)
  */
 @Override
 public double calculateAnnualBonus() {
   return 10 * hoursWorked; // 10 dollars per hour
 }
 /**
  * Returns a string representation of the part-time employee including
  * basic info, hours worked, and bonus.
  *
  * @return formatted string with employee details
  */
 @Override
 public String toString() {
   return super.toString() +
       "\nHours Worked: " + hoursWorked +
       "\nBonus: " + String.format("%.2f", calculateAnnualBonus());
 }
}
// Department
/**
* Represents a department that manages a collection of employees.
* Provides methods for adding employees, searching, and generating various
* reports.
* Uses an array to store employees with a maximum capacity set at creation.
*/
class Department {
 /**
  * Array storing employee objects (can be FullTimeEmployee or PartTimeEmployee)
  */
 private Employee[] employees;// employees is an array of object Employee that can contain its extended class
                              // such as FullTimeEmployee and PartTimeEmployee
 /** Maximum number of employees this department can hold */
 private int DepartmentSize;// Length of the array
 /** Current number of employees in this department */
 private int numOfEmployee = 0;
 // Constructor
 /**
  * Creates a new department with specified maximum capacity.
  *
  * @param DepartmentSize maximum number of employees the department can hold
  */
 public Department(int DepartmentSize) {
   this.DepartmentSize = DepartmentSize;
   employees = new Employee[DepartmentSize];
 }
 /**
  * Adds an employee to the department if space is available.
  * Finds the first empty slot in the array and places the employee there.
  *
  * @param employee the employee object to add (FullTimeEmployee or
  *                 PartTimeEmployee)
  */
 public void addEmployee(Employee employee) {
   int i = 0; // Start searching from index 0
   // Use do-while loop to find the first empty slot (null position) in the array
   do {
     if (employees[i] == null) { // Found an empty slot
       break; // Exit the loop, i now contains the empty index
     }
     i++; // Move to next index
   } while (i < employees.length); // Continue until end of array
   // Check if we found an empty slot or reached the end
   if (i == employees.length) { // No empty slots found - department is full
     System.out.println("Department is full. Cannot add more employees!");
     return; // Exit method without adding employee
   }
   employees[i] = employee; // Place employee in the empty slot
   numOfEmployee++; // Increment employee count
 }
 // Getter
 public Employee[] getArray() {
   return employees;
 }
 public String getFullTime() {
   String str = "\nFull Time Employees:\n";// String was initialized with the output title
   // Find all the full time employees
   for (int i = 0; i < DepartmentSize; i++) {
     if (employees[i] != null && employees[i].returnType().equals("FullTimeEmployee")) {
       // If the element of the array is not empty and employee is belongs to full time
       str += employees[i].getName() + "\n";// Add the name to the end of the string
     }
   }
   return str;
 }
 public String getPartTime() {
   String str = "\nPart Time Employees:\n";// String was initialized with the output title
   // Find all the full time employees
   for (int i = 0; i < DepartmentSize; i++) {
     if (employees[i] != null && employees[i].returnType().equals("PartTimeEmployee")) {
       // If the element of the array is not empty and employee is belongs to part time
       str += employees[i].getName() + "\n";// Add the name to the end of the string
     }
   }
   return str;
 }
 public Employee searchWithId(long id) {
   // Linear search through the employee array to find matching ID
   for (int i = 0, l = employees.length; i < l; i++) { // Cache array length for efficiency
     if (employees[i] == null)
       continue; // Skip empty slots (null employees)
     if (id == employees[i].getId())
       return employees[i]; // Found matching ID, return employee object
   }
   return null; // Employee with specified ID not found
 }
 public void countEmployeeTypes() {
   int fullTime = 0; // Counter for full-time employees
   int partTime = 0; // Counter for part-time employees
   // Iterate through all employee slots in the department
   for (int i = 0; i < employees.length; i++) {
     if (employees[i] == null)
       continue; // Skip empty slots (no employee at this index)
     // Check employee type using polymorphism and increment appropriate counter
     if (employees[i].returnType().equals("FullTimeEmployee")) {
       fullTime++; // Increment full-time employee counter
     } else if (employees[i].returnType().equals("PartTimeEmployee")) {
       partTime++; // Increment part-time employee counter
     }
   }
   // Display the employee type counts
   System.out.println("\nEmployee:"); // Section header
   System.out.println("Total number of employees: " + numOfEmployee); // Total employee count
   System.out.println("Full-time employees: " + fullTime); // Full-time count
   System.out.println("Part-time employees: " + partTime); // Part-time count
 }
 public double calculateAverageSalary() {
   double totalSalary = 0; // Accumulator for sum of all salaries
   int countEmployees = 0; // Counter for number of employees with salaries
   // Iterate through all employee slots to calculate total salary and count
   for (int i = 0; i < employees.length; i++) {
     if (employees[i] != null) { // Only process non-null employees
       totalSalary += employees[i].getSalary(); // Add employee's salary to total
       countEmployees++; // Increment employee count
     }
   }
   // Avoid division by zero if no employees exist
   if (countEmployees == 0)
     return 0; // Return 0 if department has no employees
   return totalSalary / countEmployees; // Calculate and return average salary
 }
 // toString
 /**
  * Returns a string representation of the department showing all employee names.
  *
  * @return formatted string with "Employees:" header followed by all employee
  *         names
  */
 public String toString() {
   String str = "\nEmployees:\n";
   for (int i = 0; i < DepartmentSize; i++) {
     if (employees[i] != null) {
       str += employees[i].getName() + "\n";
     }
   }
   return str;
 }
}
public class EmployeeManagementSystem {
 /**
  * Main class containing the program's entry point and all user interaction
  * logic.
  * Provides a menu-driven interface for managing departments and employees.
  * Handles user input validation and orchestrates all system operations.
  */
 /**
  * Main entry point of the Employment Management System.
  * Initializes the system and runs the main menu loop for user interaction.
  * Supports up to 5 departments and provides various management operations.
  *
  * @param args command line arguments (not used)
  */
 public static void main(String[] args) {
   Scanner input = new Scanner(System.in); // Create scanner for reading user input
   Department[] departments = new Department[5]; // Array to hold up to 5 departments
   int deptCount = 0; // Counter for number of departments created
   int choice; // Variable to store user's menu choice
   // Main menu loop - continues until user chooses to exit (choice 0)
   while (true) {
     displayMenu(); // Display the menu options to user
     // Input validation loop for menu choice - keeps asking until valid integer
     // entered
     while (true) {
       String str = input.nextLine(); // Read user input as string
       if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) { // Check if input parses successfully
         choice = EmployeeManagementSystem.parseInt(str); // If successful, store the choice
         break; // Exit validation loop
       }
       // If parsing failed, loop continues and asks again
     }
     // Process menu choice based on user's selection
     if (choice == 1) {
       // Option 1: Create a new department (maximum 5 allowed)
       if (deptCount == 5) {
         System.out.println("◆ Number of departments reached."); // Max departments reached
       } else {
         createDepartment(departments, deptCount, input); // Create new department
         deptCount++; // Increment department counter
       }
     }
     else if (choice >= 2 && choice <= 7) {
       // Options 2-7: Operations that require at least one department to exist
       // First validate that departments exist
       if (deptCount == 0) {
         System.out.println("◆ No departments available. Choose option 1 to create a new Department!");
         continue; // Skip to next iteration of menu loop
       }
       // Prompt user to select which department to work with
       System.out.print("◆ Select Department (1 to " + (deptCount) + "): ");
       int dIndex; // Department index (1-based from user, 0-based in array)
       while (true) {
         String str = input.nextLine();
         if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) {
           dIndex = EmployeeManagementSystem.parseInt(str);
           break;
         }
       }
       // Validate department selection is within valid range
       if (dIndex - 1 < 0 || dIndex - 1 >= deptCount) {
         System.out.println("◆ Invalid department.");
         continue; // Skip to next iteration of menu loop
       }
       Department dept = departments[dIndex - 1]; // Get selected department (convert to 0-based index)
       // Execute department-specific operations based on choice
       switch (choice) {
         case 2:
           addNewEmployee(input, dept); // Add new employee to selected department
           break;
         case 3:
           System.out.println(dept); // Display all employees in department
           break;
         case 4:
           System.out.print(dept.getFullTime()); // Display only full-time employees
           break;
         case 5:
           System.out.print(dept.getPartTime()); // Display only part-time employees
           break;
         case 6:
           double avg = dept.calculateAverageSalary(); // Calculate average salary
           System.out.printf("◆ Average Annual Salary($): %.2f%n", avg); // Display with 2 decimal places
           break;
         case 7:
           updateEmployee(dept, input); // Update existing employee information
           break;
       }
     }
     else if (choice == 8) {
       displayBusinessReport(departments, deptCount); // Generate comprehensive business report
     }
     else if (choice == 9) {
       displayBonusAndBenefitsReport(departments, deptCount); // Generate bonus and benefits report
     }
     else if (choice == 0) {
       System.out.println("\n\n◆ You did a great job in managing your business!👍"); // Exit message
       return; // Exit the program
     }
     else {
       System.out.println("◆ Invalid Choice! Please enter a valid option."); // Invalid menu choice
     }
   }
 }
 /**
  * Displays the main menu options to the user.
  * Shows all available operations for managing departments and employees.
  */
 public static void displayMenu() {
   System.out.println("\n﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌\nMenu:");
   System.out.println("1. Create a new department"
       + "\n2. Add a new employee to a specific department"
       + "\n3. Display all employees in one department"
       + "\n4. Display full-time employees in one department"
       + "\n5. Display part-time employees in one department"
       + "\n6. Calculate and display average salary of the employees in one department"
       + "\n7. Update an employee's information"
       + "\n8. Generate a summarizing report for your business"
       + "\n9. Display employee bonus and benefits report for your business"
       + "\n0. Exit\n﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌\n");
   System.out.print("◆ Enter your choice: ");
 }
 /**
  * Creates a new department by prompting user for maximum employee capacity.
  * Validates that the capacity is a positive integer.
  *
  * @param dpts     array of departments to add to
  * @param dptCount current number of departments (used as index)
  * @param scanner  Scanner object for user input
  */
 public static void createDepartment(Department[] dpts, int dptCount, Scanner scanner) {
   System.out.print("◆ Enter the max number of employees: ");
   int size;
   while (true) {
     String str = scanner.nextLine();
     if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) {
       size = EmployeeManagementSystem.parseInt(str);
       if(size > 0){
         break;
       } else {
         System.out.print("◆ Invalid size. Must be positive integer. Re-enter: ");
       }
     }
   }
   dpts[dptCount] = new Department(size);
   System.out.println("◆ New department created successfully.");
 }
 /**
  * Adds a new employee to the specified department.
  * Prompts user for employee type, details, and validates input.
  * Supports both default employee creation and custom employee details.
  *
  * @param scanner Scanner object for user input
  * @param dept    Department to add the employee to
  */
 public static void addNewEmployee(Scanner scanner, Department dept) {
   // Prompt user to choose employee type (full-time or part-time)
   System.out.print("\n◆ Type of Employee:"
       + "\n   Full-time employee(Enter 1)"
       + "\n   Part-time employee(Enter any other integer)"
       + "\n◆ Enter the type: ");
   int type; // Store employee type choice
   // Input validation loop for employee type
   while (true) {
     String str = scanner.nextLine();
     if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) {
       type = EmployeeManagementSystem.parseInt(str);
       break;
     }
   }
   // Ask if user wants to use default employee or enter custom details
   System.out.print("◆ Do you want to use default employee (1 for yes, any other integer for no): ");
   int choice; // Store default/custom choice
   // Input validation loop for default/custom choice
   while (true) {
     String str = scanner.nextLine();
     if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) {
       choice = EmployeeManagementSystem.parseInt(str);
       break;
     }
   }
   if (choice == 1) {
     // User chose default employee - create with random details
     if (type == 1) {
       dept.addEmployee(new FullTimeEmployee()); // Create default full-time employee
     } else {
       dept.addEmployee(new PartTimeEmployee()); // Create default part-time employee
     }
   }
   else {
     // User chose custom employee - prompt for detailed information
     System.out.print("◆ Enter the employee's name: ");
     String name = scanner.nextLine(); // Read employee name
     int id; // Store employee ID
     // Validate ID format (must be exactly 5 digits)
     while (true) {
       System.out.print("◆ Enter the employee's ID (5 digits, non-0 first digit): ");
       String str = scanner.nextLine();
       id = parseInt(str);
       if (id > 10000 && id < 99999) { // Input validation loop for ID
         break;
       }
       System.out.println("◆ Invalid ID. ");
     }
     // Prevent using the default ID (25025) for custom employees
     if (id == 25025) {
       System.out.print("◆ Can't enter a default ID. Re-enter a new ID please: ");
       while (true) {
         String str = scanner.nextLine();
         if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) {
           id = EmployeeManagementSystem.parseInt(str);
           break;
         }
       }
     }
     // Check if ID already exists in the department (no duplicates allowed)
     if (dept.searchWithId(id) != null) {
       System.out.print("◆ ID already existed. Re-enter a new ID please: ");
       while (true) {
         String str = scanner.nextLine();
         if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) {
           id = EmployeeManagementSystem.parseInt(str);
           break;
         }
       }
     }
     // Prompt for annual salary
     System.out.print("◆ Enter the employee's salary (in $ per year): ");
     double salary = scanner.nextDouble(); // Read salary as double
     scanner.nextLine(); // Consume newline character
     // Create appropriate employee type based on user's choice
     if (type == 1) {
       // Create full-time employee with provided details
       dept.addEmployee(new FullTimeEmployee(name, id, salary));
     } else {
       // For part-time employees, also need hours worked
       System.out.print("\n◆ Enter the total number of hours the employee has worked: ");
       double hoursWorked = scanner.nextDouble(); // Read hours worked
       scanner.nextLine(); // Consume newline character
       dept.addEmployee(new PartTimeEmployee(name, id, salary, hoursWorked)); // Create part-time employee
     }
   }
 }
 /**
  * Custom integer parsing method with input validation and error handling.
  * Converts string to integer, handling edge cases and providing user feedback.
  *
  * @param numberString the string to parse
  * @return the parsed integer, or Integer.MIN_VALUE if parsing fails
  */
 public static int parseInt(String numberString) {
   // First, check for invalid input conditions that would cause parsing to fail
   if (numberString == null || numberString.length() >= 10 || numberString.length() == 0) {
     System.out.print("\n◆ Invalid input"
         + "\n◆ Possible problem:"
         + "\n\ta.Input was too long"
         + "\n\tb.Input was not a integer"
         + "\n\tc.Input was null"
         + "\n\td.Input was empty"
         + "\n◆ Please re-enter an integer: ");
     return Integer.MIN_VALUE; // Return error code Integer.MIN_VALUE to indicate parsing failure
   }
   int number = 0; // Initialize result number to 0
   int sign = 1; // Default to positive number
   int startIndex = 0; // Start parsing from beginning of string
   // Check if number is negative (starts with minus sign)
   if (numberString.charAt(startIndex) == '-') {
     sign = -1; // Set sign to negative
     startIndex = 1; // Skip the minus sign for parsing digits
   }
   // Parse each character in the string to build the number
   for (int i = startIndex; i < numberString.length(); i++) {
     // Check if current character is a valid digit (0-9)
     if (numberString.charAt(i) >= '0' && numberString.charAt(i) <= '9') {
       // Convert character digit to integer and add to running total
       // Multiply by 10 to shift digits left, then add the new digit
       number = number * 10 + (numberString.charAt(i) - '0');
     } else {
       // Invalid character found - not a digit
       System.out.print(
           "\n◆ Invalid input\n◆ Possible problem:\n\ta.Input was too long\n\tb.Input was not a integer\n\tc.Input is null\n◆ Please re-enter an integer: ");
       return Integer.MIN_VALUE; // Return error code Integer.MIN_VALUE to indicate parsing failure
     }
   }
   return number * sign; // Apply sign and return final parsed integer
 }
 /**
  * Updates an existing employee's information in the department.
  * Allows updating name, salary, or hours worked based on employee type.
  *
  * @param dept    Department containing the employee
  * @param scanner Scanner object for user input
  */
 public static void updateEmployee(Department dept, Scanner scanner) {
   // Prompt user for employee ID to update
   System.out.print("◆ Enter an employee's ID to update (Cannot enter \"25025\" because it's a default id): ");
   long searchID = scanner.nextLong(); // Read ID as long
   scanner.nextLine(); // Consume newline character
   // Prevent updating default employees (ID 25025)
   if (searchID == 25025) {
     System.out.print("◆ You can't update a default employee.");
     return; // Exit method early
   }
   // Search for employee with the provided ID
   Employee emp = dept.searchWithId(searchID);
   if (emp == null) {
     System.out.println("◆ Employee not found."); // Employee with ID doesn't exist
     return; // Exit method early
   } else {
     System.out.println("◆ Employee found."); // Employee located successfully
     System.out.println(emp); // Display current employee information
     // Display update options menu
     System.out.println("◆ What would you like to update?"
         + "\n   Name (Enter 1)"
         + "\n   Salary (Enter 2)"
         + "\n   Both (Enter 3)"
         + "\n   Hours worked (Enter any other integer)");
     System.out.print("Your choice: ");
     int choice; // Store update choice
     // Input validation loop for update choice
     while (true) {
       String str = scanner.nextLine();
       if (EmployeeManagementSystem.parseInt(str) != Integer.MIN_VALUE) {
         choice = EmployeeManagementSystem.parseInt(str);
         break;
       }
     }
     // Process update choice
     if (choice == 1 || choice == 3) {
       // Update name (choice 1 or 3)
       System.out.print("◆ Enter new name: ");
       emp.setName(scanner.nextLine()); // Read and set new name
     }
     if (choice == 2 || choice == 3) {
       // Update salary (choice 2 or 3)
       System.out.print("◆ Enter new salary: ");
       emp.setSalary(scanner.nextDouble()); // Read and set new salary
       scanner.nextLine(); // Consume newline character
     }
     if (choice != 1 && choice != 2 && choice != 3) {
       // Update hours worked (any other choice)
       // First check if employee is part-time (only part-time employees have hours
       // worked)
       if (emp.returnType().equals("FullTimeEmployee")) {
         System.out.println("◆ Not available due to wrong type of Employee"); // Full-time employees don't have hours
                                                                              // worked
         return; // Exit method early
       } else {
         // Employee is part-time, update hours worked
         System.out.print("Enter the total number of hours worked by this employee: ");
         double hours = scanner.nextDouble(); // Read new hours
         scanner.nextLine(); // Consume newline character
         ((PartTimeEmployee) emp).setHour(hours); // Cast to PartTimeEmployee and update hours
       }
     }
     System.out.println("◆ Employee successfully updated."); // Confirmation message
   }
 }
 /**
  * Generates and displays a comprehensive business report.
  * Shows total employees across all departments and department-specific details
  * including employee lists and average salaries.
  *
  * @param departments array of all departments
  * @param deptCount   number of departments created
  */
 public static void displayBusinessReport(Department[] departments, int deptCount) {
   System.out.println("\n◆ BUSINESS REPORT ◆"); // Report header
   // Check if any departments exist
   if (deptCount == 0) {
     System.out.println("◆ N/A. Choose option 1 to create a new Department!");
     return; // Exit if no departments
   }
   // Display total employee count across all departments
   System.out.println("Total number of employees in your business: " + Employee.getTotalEmployees());
   // Loop through each department and display its details
   for (int i = 0; i < deptCount; i++) {
     System.out.println("\n-----Department " + (i + 1) + "-----"); // Department header
     System.out.println(departments[i]); // Display all employees in department
     // Display average salary for this department, formatted to 2 decimal places
     System.out.printf("Average Annual Salary($): %.2f%n", departments[i].calculateAverageSalary());
   }
 }
 /**
  * Generates and displays a report of employee bonuses and benefits.
  * Shows bonus amounts for all employees and benefits for full-time employees.
  * Part-time employees show "N/A" for benefits.
  *
  * @param departments array of all departments
  * @param deptCount   number of departments created
  */
 public static void displayBonusAndBenefitsReport(Department[] departments, int deptCount) {
   System.out.println("◆ BONUS & BENEFITS REPORT ◆"); // Report header
   // Check if any departments exist
   if (deptCount == 0) {
     System.out.println("◆ N/A. Choose option 1 to create a new Department!");
     return; // Exit if no departments
   }
   // Loop through each department
   for (int i = 0; i < deptCount; i++) {
     System.out.println("\n-----Department " + (i + 1) + "-----"); // Department header
     Employee[] emps = departments[i].getArray(); // Get employee array for this department
     boolean hasEmployees = false; // Flag to track if department has any employees
     // Loop through all possible employee slots in the department
     for (int j = 0; j < emps.length; j++) {
       Employee emp = emps[j];
       if (emp != null) { // Only process non-null employee slots
         hasEmployees = true; // Mark that department has at least one employee
         // Display employee name and ID
         System.out.println("◆ Name: " + emp.getName() + " (ID: " + emp.getId() + ")");
         // Display calculated bonus amount, formatted to 2 decimal places
         System.out.printf("◆ Bonus: $%.2f%n", emp.calculateAnnualBonus());
         // Display benefits based on employee type
         if (emp.returnType().equals("FullTimeEmployee")) {
           // Full-time employees get random benefits
           FullTimeEmployee ftEmp = (FullTimeEmployee) emp;
           System.out.println("◆ Benefit: " + ftEmp.BenefitLottery()); // Random benefit assignment
         } else {
           // Part-time employees don't get benefits
           System.out.println("◆ Benefit: N/A (Part-time)");
         }
         System.out.println(); // Add blank line between employees
       }
     }
     // If no employees were found in this department
     if (!hasEmployees) {
       System.out.println("◆ No employees currently in this department.");
     }
   }
 }
