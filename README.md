# comp3005_A3_Q1

COMP 3005 Assignment-3 Q1

Video link:  
GitHub link: 

Preequisties:

- PostgreSQL database software: https://www.postgresql.org/download/
- Java Development kit (JDK) version: https://www.oracle.com/java/technologies/downloads/#java17
- PostgreSQL JDBC driver software: https://jdbc.postgresql.org/download/
- Visual Studio Code (Or any IDE should work): https://code.visualstudio.com/download

SQL setup:
- Find the ddl_comp3005_A3_Q1.sql and the dml_comp3005_A3_Q1.sql file in src->resources folder.
- Launch pgAdmin.
- In the browser panel on the left, right-click on Databases and select Create > Database.
- Name the new database "Comp3005_A3_Q1" and click Save.
- In pgAdmin, select the newly created database by clicking on it.
- Open the Query Tool by right-clicking on "Comp3005_A3_Q1" and selecting Query Tool.
- Click on the Open File icon (looks like a folder) in the toolbar.
- Navigate to the location where you saved "ddl_comp3005_A3_Q1.sql" and open it.
- The content of "ddl_comp3005_A3_Q1.sql" should now be displayed in the query editor.
- Click on the Run button (a green triangle) to execute the SQL commands.
- Repeat the same with the "dml_comp3005_A3_Q1.sql" file

- Credential Specifications: (Note: Your user and password may be 
				different those must be replaced)
  Credentials for signing in:
        String url = "jdbc:postgresql://localhost:5432/Comp3005_A3_Q1";
        String user = "postgres";
        String password = "postgres";

IDE setup:
- Running the application: Open the IDE and set it at the 'q1' folder
  if you set it an further it will not be able to locate the JDBC Maven

Application run:
- Run the main.java file using the run button in VS code IDE the terminal should launch
 with the menu options, you can start interacting with the program.




 
