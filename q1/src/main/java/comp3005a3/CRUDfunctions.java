package comp3005a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

// All CRUD-related functions
public class CRUDfunctions {


    // lists all students available in the database
    public static void getAllStudents() {
        // creates variables to utilize database elements
        Connection conn = null;
        ResultSet result = null;
        Statement statement = null;
        
            // establish connection, statement creation and SQL instructions isseed
        try{
            conn = databaseAccess.establishAccess();
            statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM students");


            // List out of all elements in loop
            while(result.next()) {

                int student_id = result.getInt("student_id");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email = result.getString("email");
                Date enrollment_date = result.getDate("enrollment_date");

                System.out.println("ID: " + student_id + ", First name: " + first_name + ", Last Name: " + last_name + ", email: " + email + ", Enrolled: " + enrollment_date);


            }

        }
        catch (SQLException e){
            // problem catcher
            e.printStackTrace();

        }
        finally {

            // close and sign out all components that were active
            try {


                if (statement != null) {
                    statement.close();;
                }
    
                if (result != null) {
                    result.close();
                }

                if (conn != null) {
                    databaseAccess.stopAccess(conn);;
                }

            } catch (SQLException e) {
                // further failure investigation
                e.printStackTrace();
            }

        }

    }

    // addition method
    public static void addStudent(String first_name, String last_name, String email, Date enrollment_date) {
        // creates varaibles to utilize database elements
        Connection conn = databaseAccess.establishAccess();
        PreparedStatement prepar = null;
        
        try{
            // SQL instruction issued and preserved and then sent off
            String Instr = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";

            prepar = conn.prepareStatement(Instr, Statement.RETURN_GENERATED_KEYS);

            prepar.setString(1, first_name);
            prepar.setString(2, last_name);
            prepar.setString(3, email);
            prepar.setDate(4, enrollment_date);
            
            // Data gets added in the required format 
            int specRow = prepar.executeUpdate();
            try (ResultSet tuple = prepar.getGeneratedKeys()) {

                if(tuple.next()) {
                    // information on function that has been issued
                    int ID_request = tuple.getInt(1); 
                    System.out.println("Your student_ID is: " + ID_request);

                    System.out.println("The following row has been created: " + specRow);

                }
                

            }

            
        } catch (SQLException e){

            e.printStackTrace();

        }
        finally {

            try {
                // close down components
    
                if (prepar != null) {
                    prepar.close();
                }

            
            } catch (SQLException e) {
                // problem catcher
                e.printStackTrace();
            }

        }

    }


    // update method 
    public static void updateStudentEmail(int student_id,String email) {

        // creates varaibles to utilize database elements
        Connection conn = databaseAccess.establishAccess();
        PreparedStatement prepar = null;
        
        try{
            // SQL instruction issued and preserved and then sent off
            String Instr = "UPDATE students SET email = ? WHERE student_id = ?";

            prepar = conn.prepareStatement(Instr);

            
            prepar.setString(1, email);
            prepar.setInt(2, student_id);



            // Data gets added in the required format 
            int specRow = prepar.executeUpdate();
            
            System.out.println("The following row has been updated: " + specRow);
        }
        catch (SQLException e){

            e.printStackTrace();

        }
        finally {

            try {
                
                // components are shut down
                if (prepar != null) {
                    prepar.close();
                }

                if (conn != null) {

                    databaseAccess.stopAccess(conn);
                }

            

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

    }

    // delete function
    public static void deleteStudent(int student_id) {

        // establish connections
        Connection conn = databaseAccess.establishAccess();
        PreparedStatement prepar = null;
        
        try{
            // SQL instructions issued, held and then sent off
            String Instr = "DELETE FROM students WHERE student_id = ?";

            prepar = conn.prepareStatement(Instr);

            prepar.setInt(1, student_id);
            
            // there has been a deletion
            int specRow = prepar.executeUpdate();
            
            
            System.out.println("The following row has been updated: " + specRow);
        }
        catch (SQLException e){

            e.printStackTrace();

        }
        finally {

            try {
                // shut down databse compnenets and connections
    
                if (prepar != null) {
                    prepar.close();
                }

                if (conn != null) {

                    databaseAccess.stopAccess(conn);
                }

            

            } catch (SQLException e) {

                e.printStackTrace();
            }

            

        }




    }


}
