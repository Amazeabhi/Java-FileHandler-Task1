import java.io.*;
import java.util.Scanner;

public class FileHandler {

    static String fileName = "sample.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== File Handler Menu =====");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Append to File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume leftover newline

            switch (choice) {
                case 1:
                    writeToFile(scanner);
                    break;
                case 2:
                    readFromFile();
                    break;
                case 3:
                    appendToFile(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void writeToFile(Scanner scanner) {
        try {
            FileWriter writer = new FileWriter(fileName);
            System.out.print("Enter text to write: ");
            String text = scanner.nextLine();
            writer.write(text);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void appendToFile(Scanner scanner) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            System.out.print("Enter text to append: ");
            String text = scanner.nextLine();
            writer.write("\n" + text);
            writer.close();
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}
