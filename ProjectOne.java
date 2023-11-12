import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
public class ProjectOne {

    public static int count=0;

    public ProjectOne() {
        count++;
    }

    public static void CreateTable() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingryd", "root", "igaogboni1.");
             Statement statement = connection.createStatement(); Scanner scanner = new Scanner(System.in)) {


            statement.execute("CREATE TABLE IF NOT EXISTS p1table(name Text NOT NULL, email Text, age Int, location text, designation text)");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int PopulateTable(){
        Scanner scanner = new Scanner(System.in);
        do {
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingryd", "root", "igaogboni1.");
                Statement statement = connection.createStatement() ) {
                statement.execute("CREATE TABLE IF NOT EXISTS p1table(name Text NOT NULL, email Text, age Int, location text, designation text)");

                PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO p1table(name, email, age, location, designation) VALUES(?, ?, ?, ?,?)");
                System.out.println("Please enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Please enter your email: ");
                String email = scanner.nextLine();
                System.out.println("Please enter your age: ");
                int age = scanner.nextInt();
                System.out.println("Please enter your location: ");
                String location = scanner.nextLine();
                System.out.println("Please enter your designation: ");
                String designation = scanner.nextLine();

                insertStatement.setString(1, name);
                insertStatement.setString(2, email);
                insertStatement.setInt(3, age);
                insertStatement.setString(4, location);
                insertStatement.setString(5, designation);
                insertStatement.execute();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            }
                count++;
        } while (count<10);
        scanner.close();
        System.out.println(count);
        return count;


    }

    public static void main(String[] args) {
        CreateTable();
        PopulateTable();
    }



}