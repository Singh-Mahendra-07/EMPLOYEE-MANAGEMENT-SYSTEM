import java.util.Scanner;

public class Employee_Management_System {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Initialize employee database
        String Name[] = new String[100];
        int Id[] = new int[100];
        int Salaries[] = new int[100];
        int numEmployees = 0;

        while (true) {

            // Display menu
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Calculate Total Salary");
            System.out.println("5. Sort Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Get user choice
            int choice = input.nextInt();
            System.out.println();

            if (choice == 1) { // Add Employee

                // Get employee information from user
                System.out.print("Enter employee name: ");
                String fullName = input.next();
                input.nextLine();
                System.out.print("Enter employee ID: ");
                int id = input.nextInt();
                System.out.print("Enter employee salary: ");
                int salary = input.nextInt();

                // Add employee to database
                Name[numEmployees] = fullName;
                Id[numEmployees] = id;
                Salaries[numEmployees] = salary;
                numEmployees++;

                System.out.println("Employee added Successfully.");
                System.out.println();

            } else if (choice == 2) { // Remove Employee

                // Get employee ID from user
                System.out.print("Enter employee ID: ");
                int id = input.nextInt();

                // Find employee in database
                int index = -1;
                for (int i = 0; i < numEmployees; i++) {
                    if (Id[i] == id) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    // Employee not found
                    System.out.println("Employee not found.");
                } else {
                    // Remove employee from database
                    for (int i = index; i < numEmployees - 1; i++) {
                        Name[i] = Name[i + 1];
                        Id[i] = Id[i + 1];
                        Salaries[i] = Salaries[i + 1];
                    }
                    numEmployees--;
                    System.out.println("Employee removed.");
                }
                System.out.println();

            } else if (choice == 3) { // Search Employee

                // Get search query from user
                System.out.print("Enter employee name or ID: ");
                String query = input.next();

                // Search for employee in database
                boolean found = false;
                for (int i = 0; i < numEmployees; i++) {
                    if (Name[i].equals(query) || Id[i] == Integer.parseInt(query)) {
                        // Employee found
                        System.out.println("Employee found:");
                        System.out.println("Name: " + Name[i]);
                        System.out.println("ID: " + Id[i]);
                        System.out.println("Salary: " + Salaries[i]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    // Employee not found
                    System.out.println("Employee not found.");
                }
                System.out.println();

            } else if (choice == 4) { // Calculate Total Salary

                // Calculate total salary of all employees
                int totalSalary = 0;
                for (int i = 0; i < numEmployees; i++) {
                    totalSalary += Salaries[i];
                }

                System.out.println("Total salary of all employees: " + totalSalary);
                System.out.println();

            } else if (choice == 5) { // Sort Employees

                // Get sorting criteria from user
                System.out.println("Sort by:");
                System.out.println("1. Name");
                System.out.println("2. ID");
                System.out.print("Enter your choice: ");
                int sortChoice = input.nextInt();
                System.out.println();

                // Sort employees using bubble sort
                for (int i = 0; i < numEmployees - 1; i++) {
                    for (int j = 0; j < numEmployees - i - 1; j++) {
                        if (sortChoice == 1 && Name[j].compareTo(Name[j + 1]) > 0) {
                            // Swap employees
                            String tempName = Name[j];
                            Name[j] = Name[j + 1];
                            Name[j + 1] = tempName;
                            int tempID = Id[j];
                            Id[j] = Id[j + 1];
                            Id[j + 1] = tempID;
                            int tempSalary = Salaries[j];
                            Salaries[j] = Salaries[j + 1];
                            Salaries[j + 1] = tempSalary;
                        } else if (sortChoice == 2 && Id[j] > Id[j + 1]) {
                            // Swap employees
                            String tempName = Name[j];
                            Name[j] = Name[j + 1];
                            Name[j + 1] = tempName;
                            int tempID = Id[j];
                            Id[j] = Id[j + 1];
                            Id[j + 1] = tempID;
                            int tempSalary = Salaries[j];
                            Salaries[j] = Salaries[j + 1];
                            Salaries[j + 1] = tempSalary;
                        }
                    }
                }

                // Display sorted employees
                System.out.println("Sorted employees:");
                for (int i = 0; i < numEmployees; i++) {
                    System.out.println("Name: " + Name[i]);
                    System.out.println("ID: " + Id[i]);
                    System.out.println("Salary: " + Salaries[i]);
                    System.out.println();
                }

            } else if (choice == 6) { // Exit

                System.out.println("Exiting...");
                break;

            } else { // Invalid choice

                System.out.println("Invalid choice. Please try again.");
                System.out.println();

            }

        }

        input.close(); // close Scanner

    }

}
