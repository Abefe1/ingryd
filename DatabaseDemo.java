import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseDemo {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ingryd", "root", "igaogboni1.");
            Statement statement = connection.createStatement(); Scanner scanner = new Scanner(System.in)){


            statement.execute("CREATE TABLE IF NOT EXISTS cohort(name Text NOT NULL, email Text, location Text, age Int )");

            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO cohort(name, email, location, age) VALUES(?, ?, ?, ?)");

            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Please enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Please enter your location: ");
            String location = scanner.nextLine();
            System.out.println("Please enter your age: ");
            int age = scanner.nextInt();

            insertStatement.setString(1, name);
            insertStatement.setString(2, email);
            insertStatement.setString(3, location);
            insertStatement.setInt(4, age);

            insertStatement.execute();

            PreparedStatement updateStatement = connection.prepareStatement("UPDATE cohort SET name='Java Student' WHERE age=? ");
            System.out.println("Please enter the age to update the name column: ");
            String name1 = scanner.nextLine();
            updateStatement.setString(1, name1);
            updateStatement.execute();

            PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM cohort WHERE age=? AND location=?");
            System.out.println("Please enter the age to delete record: ");
            int age1 = scanner.nextInt();
            scanner.nextLine();
            deleteStatement.setInt(1, age1);
            System.out.println("Please enter the location to delete record: ");
            String location1 = scanner.nextLine();
            deleteStatement.setString(2, location1);
            deleteStatement.execute();
            deleteStatement.close();


        } catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}