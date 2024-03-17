package comp3005a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;

// Main function
public class Main {

    // Scanner initialization
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        // while loop to repeat the menu options
        while(true) {

            // interface intructions
            System.out.println("Welcome to Student Database select your option: ");
            System.out.println("1. View all student records.");
            System.out.println("2. Update student email.");
            System.out.println("3. Add a student record.");
            System.out.println("4. Delete a student record.");
            System.out.println("5. Quit the program.");

            int selection = scan.nextInt();
            scan.nextLine();

            // options
            switch(selection) {

                case 1:

                    CRUDfunctions.getAllStudents();
                    break;

                case 2:


                    System.out.println("Email Address: ");

                    String upd_email = scan.nextLine();

                    System.out.println("Student ID: ");
                    int upd_ID = scan.nextInt();



                    CRUDfunctions.updateStudentEmail(upd_ID, upd_email);
                    break;
                case 3:

                // Example input: Starlight, Theta, starlight.theta@example.com, 2024-01-01 
                    System.out.println("First name: ");
                    String add_first_name = scan.nextLine();

                    System.out.println("Last name: ");
                    String add_last_name = scan.nextLine();

                    System.out.println("Email Address: ");
                    String add_email = scan.nextLine();

                    System.out.println("Enrollment(YYYY-MM-DD)");
                    String add_enroll = scan.nextLine();

                    Date enrollAgain = Date.valueOf(add_enroll);


                    CRUDfunctions.addStudent(add_first_name, add_last_name, add_email, enrollAgain);
                    break;
                case 4:

                    System.out.println("Student ID: ");
                    int del_ID = scan.nextInt();

                    CRUDfunctions.deleteStudent(del_ID);
                    break;
                case 5:
                    
                    System.out.println("Program exiting");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Recognized orders from 1 through 5, try again!");

            }
            
        }   





        

    }
}